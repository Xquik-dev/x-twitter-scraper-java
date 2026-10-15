// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.LoopbackTestServer
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import java.lang.reflect.Modifier
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

internal class ResponseGenericTypesTest {

    @Test
    fun rawResponseHasReadableGenericTypes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(LoopbackTestServer.baseUrl())
                .apiKey("test-only")
                .build()
        try {
            client.credits().withRawResponse().retrieveBalance().use { response ->
                assertGenericTypesReadable(response)
            }
        } finally {
            client.close()
        }
    }

    @Test
    fun mappedStreamResponseHasReadableGenericTypes() {
        val mapped = ListStreamResponse(listOf("a", "bc")).map { it.length }

        assertGenericTypesReadable(mapped)
    }

    @Test
    fun asyncStreamResponseHasReadableGenericTypes() {
        val asyncResponse =
            CompletableFuture<StreamResponse<String>>().toAsync(Executor { it.run() })
        try {
            assertGenericTypesReadable(asyncResponse)
        } finally {
            asyncResponse.close()
        }
    }

    private class ListStreamResponse(private val values: List<String>) : StreamResponse<String> {

        override fun stream(): Stream<String> = values.stream()

        override fun close() = Unit
    }

    private fun assertGenericTypesReadable(value: Any) {
        val fieldValues =
            value.javaClass.declaredFields
                .filterNot { Modifier.isStatic(it.modifiers) }
                .mapNotNull { field -> field.takeIf { it.trySetAccessible() }?.get(value) }
        (listOf(value) + fieldValues).forEach { inspected ->
            val type = inspected.javaClass
            assertThatCode {
                    type.genericInterfaces.forEach { it.typeName }
                    type.genericSuperclass?.typeName
                    type.declaredConstructors.forEach { constructor ->
                        constructor.genericParameterTypes.forEach { it.typeName }
                    }
                }
                .describedAs(type.name)
                .doesNotThrowAnyException()
        }
    }
}
