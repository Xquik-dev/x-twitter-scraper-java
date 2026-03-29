// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.media.MediaCreateParams
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MediaServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaService = client.x().media()

        val media =
            mediaService.create(
                MediaCreateParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .isLongVideo(true)
                    .build()
            )

        media.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun download() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaService = client.x().media()

        val response =
            mediaService.download(
                MediaDownloadParams.builder().addTweetId("string").tweetInput("tweetInput").build()
            )

        response.validate()
    }
}
