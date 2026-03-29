// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.bot

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PlatformLinkServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkServiceAsync = client.bot().platformLinks()

        val platformLinkFuture =
            platformLinkServiceAsync.create(
                PlatformLinkCreateParams.builder()
                    .platform(PlatformLinkCreateParams.Platform.TELEGRAM)
                    .platformUserId("platformUserId")
                    .build()
            )

        val platformLink = platformLinkFuture.get()
        platformLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkServiceAsync = client.bot().platformLinks()

        val platformLinkFuture =
            platformLinkServiceAsync.delete(
                PlatformLinkDeleteParams.builder()
                    .platform(PlatformLinkDeleteParams.Platform.TELEGRAM)
                    .platformUserId("platformUserId")
                    .build()
            )

        val platformLink = platformLinkFuture.get()
        platformLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkServiceAsync = client.bot().platformLinks()

        val responseFuture =
            platformLinkServiceAsync.lookup(
                PlatformLinkLookupParams.builder()
                    .platform("platform")
                    .platformUserId("platformUserId")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
