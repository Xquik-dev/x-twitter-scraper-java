// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProfileServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun patchAll() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val responseFuture =
            profileServiceAsync.patchAll(
                ProfilePatchAllParams.builder()
                    .account("account")
                    .description("description")
                    .location("location")
                    .name("name")
                    .url("url")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateAvatar() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val responseFuture =
            profileServiceAsync.updateAvatar(
                ProfileUpdateAvatarParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateBanner() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val responseFuture =
            profileServiceAsync.updateBanner(
                ProfileUpdateBannerParams.builder()
                    .account("account")
                    .file("Example data".byteInputStream())
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
