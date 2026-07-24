// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpMethod
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpRequestBody
import com.x_twitter_scraper.api.core.http.ProxyAuthenticator
import com.x_twitter_scraper.api.errors.XTwitterScraperIoException
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.net.Proxy
import java.net.ServerSocket
import java.security.KeyStore
import java.time.Duration
import java.util.Optional
import java.util.concurrent.Executors
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class OkHttpClientTest {

    private lateinit var baseUrl: String
    private lateinit var httpClient: OkHttpClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        httpClient = OkHttpClient.builder().build()
    }

    @AfterEach
    fun afterEach() {
        httpClient.close()
    }

    @Test
    fun executeAsync_whenFutureCancelled_cancelsUnderlyingCall() {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val responseFuture =
            httpClient.executeAsync(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build()
            )
        val call = httpClient.okHttpClient.dispatcher.runningCalls().single()

        responseFuture.cancel(false)

        // Should have cancelled the underlying call
        assertThat(call.isCanceled()).isTrue()
    }

    @Test
    fun execute_doesNotFollowRedirects() {
        stubFor(
            get(urlPathEqualTo("/start"))
                .willReturn(
                    aResponse().withStatus(302).withHeader("Location", "$baseUrl/destination")
                )
        )
        stubFor(get(urlPathEqualTo("/destination")).willReturn(ok()))

        val response =
            httpClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(baseUrl)
                    .addPathSegment("start")
                    .putHeader("x-api-key", "test-only")
                    .build()
            )

        response.use { assertThat(it.statusCode()).isEqualTo(302) }
        verify(1, getRequestedFor(urlPathEqualTo("/start")))
        verify(0, getRequestedFor(urlPathEqualTo("/destination")))
        assertThat(httpClient.okHttpClient.followRedirects).isFalse()
        assertThat(httpClient.okHttpClient.followSslRedirects).isFalse()
    }

    @Test
    fun executeBoundsOnlyOversizedNumericRetryAfter() {
        val cases =
            mapOf(
                "oversized" to ("999999999999999999999999999999" to "60"),
                "bounded" to ("42" to "42"),
                "date" to ("Wed, 21 Oct 2037 07:28:00 GMT" to "Wed, 21 Oct 2037 07:28:00 GMT"),
            )

        cases.forEach { (path, values) ->
            val (retryAfter, expected) = values
            stubFor(
                get(urlPathEqualTo("/$path"))
                    .willReturn(serviceUnavailable().withHeader("Retry-After", retryAfter))
            )

            httpClient
                .execute(
                    HttpRequest.builder()
                        .method(HttpMethod.GET)
                        .baseUrl(baseUrl)
                        .addPathSegment(path)
                        .build()
                )
                .use { response ->
                    assertThat(response.headers().values("Retry-After")).containsExactly(expected)
                }
        }
    }

    @Test
    fun builderConfiguresPairedTransportOptions() {
        val executor = Executors.newSingleThreadExecutor()
        val trustManager = defaultTrustManager()
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(trustManager), null)
        val hostnameVerifier = javax.net.ssl.HostnameVerifier { _, _ -> true }

        val configured =
            OkHttpClient.builder()
                .timeout(Duration.ofSeconds(2))
                .proxy(Proxy.NO_PROXY)
                .maxIdleConnections(2)
                .keepAliveDuration(Duration.ofSeconds(30))
                .dispatcherExecutorService(executor)
                .sslSocketFactory(sslContext.socketFactory)
                .trustManager(trustManager)
                .hostnameVerifier(hostnameVerifier)
                .build()

        try {
            assertThat(configured.okHttpClient.connectTimeoutMillis).isEqualTo(60000)
            assertThat(configured.okHttpClient.readTimeoutMillis).isEqualTo(2000)
            assertThat(configured.okHttpClient.writeTimeoutMillis).isEqualTo(2000)
            assertThat(configured.okHttpClient.callTimeoutMillis).isEqualTo(2000)
            assertThat(configured.okHttpClient.proxy).isEqualTo(Proxy.NO_PROXY)
            assertThat(configured.okHttpClient.hostnameVerifier).isSameAs(hostnameVerifier)
            assertThat(configured.okHttpClient.dispatcher.executorService).isSameAs(executor)
        } finally {
            configured.close()
        }
        assertThat(executor.isShutdown).isTrue()
    }

    @Test
    fun builderRejectsUnpairedTransportOptions() {
        val trustManager = defaultTrustManager()
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(trustManager), null)

        assertThatThrownBy { OkHttpClient.builder().maxIdleConnections(1).build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Both or none of `maxIdleConnections`")
        assertThatThrownBy {
                OkHttpClient.builder().keepAliveDuration(Duration.ofSeconds(1)).build()
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Both or none of `maxIdleConnections`")
        assertThatThrownBy {
                OkHttpClient.builder().sslSocketFactory(sslContext.socketFactory).build()
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Both or none of `sslSocketFactory`")
        assertThatThrownBy { OkHttpClient.builder().trustManager(trustManager).build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Both or none of `sslSocketFactory`")
    }

    @Test
    fun proxyAuthenticatorReceivesCompleteChallenge() {
        var observedProxy: Proxy? = null
        var observedRequestBody: String? = null
        var observedResponseBody: String? = null
        val authenticator = ProxyAuthenticator { proxy, request, response ->
            observedProxy = proxy
            val bodyOutput = ByteArrayOutputStream()
            request.body?.writeTo(bodyOutput)
            observedRequestBody = bodyOutput.toByteArray().toString(Charsets.UTF_8)
            observedResponseBody = response.body().readBytes().toString(Charsets.UTF_8)
            Optional.of(request.toBuilder().putHeader("Proxy-Authorization", "test-only").build())
        }
        val configured = OkHttpClient.builder().proxyAuthenticator(authenticator).build()
        val request =
            Request.Builder()
                .url("http://example.com:8080/path?query=value")
                .post("request-body".toRequestBody())
                .addHeader("X-Test", "value")
                .build()
        val challenge =
            Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(407)
                .message("Proxy Authentication Required")
                .body("challenge-body".toResponseBody())
                .build()

        try {
            val retry = challenge.use {
                configured.okHttpClient.proxyAuthenticator.authenticate(null, challenge)
            }

            assertThat(observedProxy).isEqualTo(Proxy.NO_PROXY)
            assertThat(observedRequestBody).isEqualTo("request-body")
            assertThat(observedResponseBody).isEqualTo("challenge-body")
            assertThat(retry).isNotNull()
            assertThat(retry!!.header("Proxy-Authorization")).isEqualTo("test-only")
            assertThat(retry.url.toString()).isEqualTo("http://example.com:8080/path?query=value")
        } finally {
            configured.close()
        }
    }

    @Test
    fun executeFailuresCloseRequestBodies() {
        val unusedPort = ServerSocket(0).use { it.localPort }
        var syncCloses = 0
        val syncBody = requestBody { syncCloses++ }
        val syncRequest =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("http://127.0.0.1:$unusedPort")
                .body(syncBody)
                .build()

        assertThatThrownBy { httpClient.execute(syncRequest, RequestOptions.none()) }
            .isInstanceOf(XTwitterScraperIoException::class.java)
            .hasMessage("Request failed")
        assertThat(syncCloses).isEqualTo(1)

        var asyncCloses = 0
        val asyncBody = requestBody { asyncCloses++ }
        val asyncRequest =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("http://127.0.0.1:$unusedPort")
                .body(asyncBody)
                .build()

        assertThatThrownBy { httpClient.executeAsync(asyncRequest).join() }
            .hasCauseInstanceOf(XTwitterScraperIoException::class.java)
        assertThat(asyncCloses).isEqualTo(1)
    }

    @Test
    fun requestConstructionFailuresCloseRequestBodies() {
        var syncCloses = 0
        val syncRequest =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("not-a-url")
                .body(requestBody { syncCloses++ })
                .build()

        assertThatThrownBy { httpClient.execute(syncRequest, RequestOptions.none()) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(syncCloses).isEqualTo(1)

        var asyncCloses = 0
        val asyncRequest =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("not-a-url")
                .body(requestBody { asyncCloses++ })
                .build()

        assertThatThrownBy { httpClient.executeAsync(asyncRequest) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(asyncCloses).isEqualTo(1)
    }

    private fun requestBody(onClose: () -> Unit): HttpRequestBody =
        object : HttpRequestBody {
            override fun contentType(): String = "text/plain"

            override fun contentLength(): Long = 4

            override fun repeatable(): Boolean = false

            override fun writeTo(outputStream: OutputStream) {
                outputStream.write("body".toByteArray())
            }

            override fun close() = onClose()
        }

    private fun defaultTrustManager(): X509TrustManager {
        val factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        factory.init(null as KeyStore?)
        return factory.trustManagers.filterIsInstance<X509TrustManager>().single()
    }
}
