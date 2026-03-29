// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.followers.FollowerRetrieveCheckParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FollowerServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCheck() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val followerService = client.x().followers()

        val response =
            followerService.retrieveCheck(
                FollowerRetrieveCheckParams.builder().source("source").target("target").build()
            )

        response.validate()
    }
}
