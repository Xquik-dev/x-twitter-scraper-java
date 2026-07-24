// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.monitors

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateParams
import org.junit.jupiter.api.Test

internal class KeywordServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordServiceAsync = client.monitors().keywords()

        val keywordFuture =
            keywordServiceAsync.create(
                KeywordCreateParams.builder()
                    .addEventType(EventType.TWEET_NEW)
                    .query("xquik OR \"x api\"")
                    .build()
            )

        val keyword = keywordFuture.get()
        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordServiceAsync = client.monitors().keywords()

        val keywordFuture = keywordServiceAsync.retrieve("id")

        val keyword = keywordFuture.get()
        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordServiceAsync = client.monitors().keywords()

        val keywordFuture =
            keywordServiceAsync.update(
                KeywordUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .build()
            )

        val keyword = keywordFuture.get()
        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordServiceAsync = client.monitors().keywords()

        val keywordsFuture = keywordServiceAsync.list()

        val keywords = keywordsFuture.get()
        kotlin.test.assertNotNull(keywords)
    }

    @Test
    fun deactivate() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordServiceAsync = client.monitors().keywords()

        val responseFuture = keywordServiceAsync.deactivate("id")

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
