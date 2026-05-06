// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MediaServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun download() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val mediaServiceAsync = client.x().media()

        val responseFuture =
            mediaServiceAsync.download(
                MediaDownloadParams.builder()
                    .addTweetId("1234567890")
                    .addTweetId("1234567891")
                    .tweetInput("https://x.com/elonmusk/status/1234567890")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val mediaServiceAsync = client.x().media()

        val responseFuture =
            mediaServiceAsync.upload(
                MediaUploadParams.builder()
                    .account("@elonmusk")
                    .file("Example data".byteInputStream())
                    .isLongVideo(true)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
