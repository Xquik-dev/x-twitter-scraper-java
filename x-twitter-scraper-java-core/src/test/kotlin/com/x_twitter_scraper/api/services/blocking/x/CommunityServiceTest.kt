// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CommunityServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val community =
            communityService.create(
                CommunityCreateParams.builder()
                    .account("@elonmusk")
                    .name("Example Name")
                    .description("A community for Tesla enthusiasts")
                    .build()
            )

        community.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val community =
            communityService.delete(
                CommunityDeleteParams.builder()
                    .id("id")
                    .account("@elonmusk")
                    .communityName("Tesla Fans")
                    .build()
            )

        community.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveInfo() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response = communityService.retrieveInfo("id")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response =
            communityService.retrieveMembers(
                CommunityRetrieveMembersParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveModerators() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response =
            communityService.retrieveModerators(
                CommunityRetrieveModeratorsParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response =
            communityService.retrieveSearch(
                CommunityRetrieveSearchParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .queryType("queryType")
                    .build()
            )

        response.validate()
    }
}
