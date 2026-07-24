// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import org.junit.jupiter.api.Test

internal class MediaServiceAsyncTest {
    @Test
    fun download() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaServiceAsync = client.x().media()

        val responseFuture =
            mediaServiceAsync.download(
                MediaDownloadParams.builder()
                    .tweetId("1234567890")
                    .addTweetId("1234567890")
                    .addTweetId("1234567891")
                    .tweetInput("https://x.com/elonmusk/status/1234567890")
                    .tweetUrl("https://x.com/elonmusk/status/1234567890")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun upload() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaServiceAsync = client.x().media()

        val responseFuture =
            mediaServiceAsync.upload(
                MediaUploadParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/image.png")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
