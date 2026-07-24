// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateParams
import org.junit.jupiter.api.Test

internal class ProfileServiceTest {
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val profile =
            profileService.update(
                ProfileUpdateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .description("description_value")
                    .location("location_value")
                    .name("Example Name")
                    .url("https://xquik.com/example")
                    .build()
            )

        kotlin.test.assertNotNull(profile)
    }

    @Test
    fun updateAvatar() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val response =
            profileService.updateAvatar(
                ProfileUpdateAvatarParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/avatar.png")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun updateBanner() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val profileService = client.x().profile()

        val response =
            profileService.updateBanner(
                ProfileUpdateBannerParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .url("https://example.com/banner.png")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
