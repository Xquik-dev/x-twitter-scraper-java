// File generated from our OpenAPI spec by Stainless.

package com.xquik.consumer.proguard

import com.fasterxml.jackson.core.type.TypeReference
import com.x_twitter_scraper.api.client.XTwitterScraperClientImpl
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.HttpClient
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.x.tweets.TweetAuthor
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            val test = ProGuardCompatibilityTest()
            test.proguardRules()
            test.client()
            test.productionDeserialization()
            test.tweetAuthorRoundtrip()
            test.eventTypeRoundtrip()
        }
    }

    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/x-twitter-scraper-java-core.pro"
            )

        checkNotNull(rulesFile).close()
    }

    fun client() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()

        client.account()
        client.apiKeys()
        client.subscribe()
        client.compose()
        client.drafts()
        client.styles()
        client.radar()
        client.monitors()
        client.events()
        client.extractions()
        client.draws()
        client.webhooks()
        client.x()
        client.trends()
        client.support()
        client.credits()
        client.close()
    }

    fun productionDeserialization() {
        val client =
            XTwitterScraperClientImpl(
                ClientOptions.builder()
                    .httpClient(FixedResponseHttpClient(CREDIT_BALANCE_JSON))
                    .apiKey("My API Key")
                    .maxRetries(0)
                    .build()
            )

        val balance = client.credits().retrieveBalance()
        check(balance.autoTopupEnabled())
        check(balance.balance() == 42L)
        check(balance.lifetimePurchased() == 100L)
        check(balance.lifetimeUsed() == 58L)
        client.close()
    }

    fun tweetAuthorRoundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
                .id("9876543210")
                .followers(150000000L)
                .username("elonmusk")
                .verified(true)
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .build()

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                object : TypeReference<TweetAuthor>() {},
            )

        check(roundtrippedTweetAuthor == tweetAuthor)
    }

    fun eventTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val eventType = EventType.TWEET_NEW

        val roundtrippedEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventType),
                object : TypeReference<EventType>() {},
            )

        check(roundtrippedEventType == eventType)
    }
}

private const val CREDIT_BALANCE_JSON =
    """{"auto_topup_enabled":true,"balance":42,"lifetime_purchased":100,"lifetime_used":58}"""

private class FixedResponseHttpClient(responseBody: String) : HttpClient {

    private val responseBody = responseBody.toByteArray()

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response()

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response())

    override fun close() {}

    private fun response(): HttpResponse =
        object : HttpResponse {

            override fun statusCode(): Int = 200

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(responseBody)

            override fun close() {}
        }
}
