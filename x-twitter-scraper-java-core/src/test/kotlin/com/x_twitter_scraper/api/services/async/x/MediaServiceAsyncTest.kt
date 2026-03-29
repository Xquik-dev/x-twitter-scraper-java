// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.media.MediaCreateParams
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MediaServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaServiceAsync = client.x().media()

        val mediaFuture =
            mediaServiceAsync.create(
                MediaCreateParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .isLongVideo(true)
                    .build()
            )

        val media = mediaFuture.get()
        media.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun download() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaServiceAsync = client.x().media()

        val responseFuture =
            mediaServiceAsync.download(
                MediaDownloadParams.builder().addTweetId("string").tweetInput("tweetInput").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
