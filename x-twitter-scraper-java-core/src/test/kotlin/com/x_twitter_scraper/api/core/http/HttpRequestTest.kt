// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import java.io.OutputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class HttpRequestTest {

    enum class UrlTestCase(val request: HttpRequest, val expectedUrl: String) {
        BASE_URL_ONLY(
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://api.example.com").build(),
            expectedUrl = "https://api.example.com",
        ),
        BASE_URL_WITH_TRAILING_SLASH(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com/")
                .build(),
            expectedUrl = "https://api.example.com/",
        ),
        SINGLE_PATH_SEGMENT(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .build(),
            expectedUrl = "https://api.example.com/users",
        ),
        MULTIPLE_PATH_SEGMENTS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegments("users", "123", "profile")
                .build(),
            expectedUrl = "https://api.example.com/users/123/profile",
        ),
        PATH_SEGMENT_WITH_SPECIAL_CHARS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("user name")
                .build(),
            expectedUrl = "https://api.example.com/user+name",
        ),
        SINGLE_QUERY_PARAM(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParam("limit", "10")
                .build(),
            expectedUrl = "https://api.example.com/users?limit=10",
        ),
        MULTIPLE_QUERY_PARAMS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParam("limit", "10")
                .putQueryParam("offset", "20")
                .build(),
            expectedUrl = "https://api.example.com/users?limit=10&offset=20",
        ),
        QUERY_PARAM_WITH_SPECIAL_CHARS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("search")
                .putQueryParam("q", "hello world")
                .build(),
            expectedUrl = "https://api.example.com/search?q=hello+world",
        ),
        MULTIPLE_VALUES_SAME_PARAM(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParams("tags", listOf("admin", "user"))
                .build(),
            expectedUrl = "https://api.example.com/users?tags=admin&tags=user",
        ),
        BASE_URL_WITH_TRAILING_SLASH_AND_PATH(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com/")
                .addPathSegment("users")
                .build(),
            expectedUrl = "https://api.example.com/users",
        ),
        COMPLEX_URL(
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://api.example.com")
                .addPathSegments("v1", "users", "123")
                .putQueryParams("include", listOf("profile", "settings"))
                .putQueryParam("format", "json")
                .build(),
            expectedUrl =
                "https://api.example.com/v1/users/123?include=profile&include=settings&format=json",
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun url(testCase: UrlTestCase) {
        val actualUrl = testCase.request.url()

        assertThat(actualUrl).isEqualTo(testCase.expectedUrl)
    }

    @Test
    fun builderOperationsAndCopy() {
        val body =
            object : HttpRequestBody {
                override fun contentType(): String = "text/plain"

                override fun contentLength(): Long = 4

                override fun repeatable(): Boolean = true

                override fun writeTo(outputStream: OutputStream) {
                    outputStream.write("body".toByteArray())
                }

                override fun close() {}
            }
        val initialHeaders = Headers.builder().put("initial", "1").build()
        val finalHeaders = Headers.builder().put("final", "2").build()
        val initialQuery = QueryParams.builder().put("initial", "1").build()
        val finalQuery = QueryParams.builder().put("final", "2").build()

        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://api.example.com")
                .headers(initialHeaders)
                .headers(mapOf("mapped" to listOf("1")))
                .putHeader("single", "1")
                .putHeaders("many", listOf("1", "2"))
                .putAllHeaders(initialHeaders)
                .putAllHeaders(mapOf("more" to listOf("1")))
                .replaceHeaders("single", "2")
                .replaceHeaders("many", listOf("3", "4"))
                .replaceAllHeaders(initialHeaders)
                .replaceAllHeaders(mapOf("temporary" to listOf("1")))
                .removeHeaders("temporary")
                .putAllHeaders(finalHeaders)
                .removeAllHeaders(setOf("absent"))
                .queryParams(initialQuery)
                .queryParams(mapOf("mapped" to listOf("1")))
                .putQueryParam("single", "1")
                .putQueryParams("many", listOf("1", "2"))
                .putAllQueryParams(initialQuery)
                .putAllQueryParams(mapOf("more" to listOf("1")))
                .replaceQueryParams("single", "2")
                .replaceQueryParams("many", listOf("3", "4"))
                .replaceAllQueryParams(initialQuery)
                .replaceAllQueryParams(mapOf("temporary" to listOf("1")))
                .removeQueryParams("temporary")
                .putAllQueryParams(finalQuery)
                .removeAllQueryParams(setOf("absent"))
                .body(body)
                .build()
        val copied = request.toBuilder().build()

        assertThat(copied.method).isEqualTo(HttpMethod.POST)
        assertThat(copied.baseUrl).isEqualTo("https://api.example.com")
        assertThat(copied.pathSegments).isEmpty()
        assertThat(copied.headers.values("final")).containsExactly("2")
        assertThat(copied.queryParams.values("final")).containsExactly("2")
        assertThat(copied.body).isSameAs(body)
        assertThat(copied.toString()).contains("method=POST", "baseUrl=https://api.example.com")
    }

    @Test
    fun buildRequiresMethodAndBaseUrl() {
        assertThatThrownBy { HttpRequest.builder().baseUrl("https://api.example.com").build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`method` is required, but was not set")
        assertThatThrownBy { HttpRequest.builder().method(HttpMethod.GET).build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`baseUrl` is required, but was not set")
    }
}
