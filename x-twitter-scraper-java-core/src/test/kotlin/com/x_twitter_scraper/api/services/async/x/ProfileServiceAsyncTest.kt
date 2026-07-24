// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateParams
import org.junit.jupiter.api.Test

internal class ProfileServiceAsyncTest {
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val profileFuture =
            profileServiceAsync.update(
                ProfileUpdateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .description("description_value")
                    .location("location_value")
                    .name("Example Name")
                    .url("https://xquik.com/example")
                    .build()
            )

        val profile = profileFuture.get()
        kotlin.test.assertNotNull(profile)
    }

    @Test
    fun updateAvatar() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val responseFuture =
            profileServiceAsync.updateAvatar(
                ProfileUpdateAvatarParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/avatar.png")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun updateBanner() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileServiceAsync = client.x().profile()

        val responseFuture =
            profileServiceAsync.updateBanner(
                ProfileUpdateBannerParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/banner.png")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
