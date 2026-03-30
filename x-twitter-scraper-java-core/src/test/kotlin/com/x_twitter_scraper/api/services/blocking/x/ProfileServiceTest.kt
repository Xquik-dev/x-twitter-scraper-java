// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProfileServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val profile =
            profileService.update(
                ProfileUpdateParams.builder()
                    .account("account")
                    .description("description")
                    .location("location")
                    .name("name")
                    .url("url")
                    .build()
            )

        profile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateAvatar() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val response =
            profileService.updateAvatar(
                ProfileUpdateAvatarParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateBanner() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val response =
            profileService.updateBanner(
                ProfileUpdateBannerParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .build()
            )

        response.validate()
    }
}
