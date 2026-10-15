// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core

import com.x_twitter_scraper.api.core.http.HttpClient
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class ClientOptionsTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun putHeader_canOverwriteDefaultHeader() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .putHeader("User-Agent", "My User Agent")
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()

        assertThat(clientOptions.headers.values("User-Agent")).containsExactly("My User Agent")
    }

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseOriginalClient() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        verify(httpClient, never()).close()

        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(httpClient, never()).close()
        assertThat(clientOptions).isEqualTo(clientOptions)
    }

    @Test
    fun streamHandlerExecutor_defaultsToANamedThreadPoolThatCloseShutsDown() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()
        val threadName =
            CompletableFuture.supplyAsync(
                    { Thread.currentThread().name },
                    clientOptions.streamHandlerExecutor,
                )
                .get(10, TimeUnit.SECONDS)

        clientOptions.close()

        assertThat(threadName).startsWith("xquik-stream-handler-thread-")
        assertThat((clientOptions.streamHandlerExecutor as ExecutorService).isShutdown).isTrue()
    }

    @Test
    fun streamHandlerExecutor_usesTheGivenExecutorAndKeepsItOnCopies() {
        val executor = Executor { it.run() }
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .streamHandlerExecutor(executor)
                .build()

        clientOptions.close()

        assertThat(clientOptions.streamHandlerExecutor).isSameAs(executor)
        assertThat(clientOptions.toBuilder().build().streamHandlerExecutor).isSameAs(executor)
    }

    @Test
    fun streamHandlerExecutor_shutsDownAGivenExecutorServiceOnClose() {
        val executorService = Executors.newSingleThreadExecutor()
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .streamHandlerExecutor(executorService)
                .build()

        clientOptions.close()

        assertThat(executorService.isShutdown).isTrue()
    }
}
