// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import org.junit.jupiter.api.Test

internal class MediaServiceTest {
    @Test
    fun download() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaService = client.x().media()

        val response =
            mediaService.download(
                MediaDownloadParams.builder()
                    .tweetId("1234567890")
                    .addTweetId("1234567890")
                    .addTweetId("1234567891")
                    .tweetInput("https://x.com/elonmusk/status/1234567890")
                    .tweetUrl("https://x.com/elonmusk/status/1234567890")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun upload() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaService = client.x().media()

        val response =
            mediaService.upload(
                MediaUploadParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/image.png")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
