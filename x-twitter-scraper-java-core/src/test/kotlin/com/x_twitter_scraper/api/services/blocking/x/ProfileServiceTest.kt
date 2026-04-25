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
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.x().profile()

        val profile =
            profileService.update(
                ProfileUpdateParams.builder()
                    .account("@elonmusk")
                    .description("description_value")
                    .location("location_value")
                    .name("Example Name")
                    .url("https://xquik.com/example")
                    .build()
            )

        profile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateAvatar() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.x().profile()

        val response =
            profileService.updateAvatar(
                ProfileUpdateAvatarParams.builder()
                    .account("@elonmusk")
                    .file("Example data".byteInputStream())
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateBanner() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.x().profile()

        val response =
            profileService.updateBanner(
                ProfileUpdateBannerParams.builder()
                    .account("@elonmusk")
                    .file("Example data".byteInputStream())
                    .build()
            )

        response.validate()
    }
}
