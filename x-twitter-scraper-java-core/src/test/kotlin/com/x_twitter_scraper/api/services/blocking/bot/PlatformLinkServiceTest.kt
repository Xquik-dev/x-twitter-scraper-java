// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.bot

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PlatformLinkServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkService = client.bot().platformLinks()

        val platformLink =
            platformLinkService.create(
                PlatformLinkCreateParams.builder()
                    .platform(PlatformLinkCreateParams.Platform.TELEGRAM)
                    .platformUserId("platformUserId")
                    .build()
            )

        platformLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkService = client.bot().platformLinks()

        val platformLink =
            platformLinkService.delete(
                PlatformLinkDeleteParams.builder()
                    .platform(PlatformLinkDeleteParams.Platform.TELEGRAM)
                    .platformUserId("platformUserId")
                    .build()
            )

        platformLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val platformLinkService = client.bot().platformLinks()

        val response =
            platformLinkService.lookup(
                PlatformLinkLookupParams.builder()
                    .platform("platform")
                    .platformUserId("platformUserId")
                    .build()
            )

        response.validate()
    }
}
