// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MediaServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun download() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val mediaService = client.x().media()

        val response =
            mediaService.download(
                MediaDownloadParams.builder()
                    .addTweetId("1234567890")
                    .addTweetId("1234567891")
                    .tweetInput("https://x.com/elonmusk/status/1234567890")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val mediaService = client.x().media()

        val response =
            mediaService.upload(
                MediaUploadParams.builder()
                    .account("@elonmusk")
                    .file("Example data".byteInputStream())
                    .isLongVideo(true)
                    .build()
            )

        response.validate()
    }
}
