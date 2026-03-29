// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DmServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val dm =
            dmService.update(
                DmUpdateParams.builder()
                    .userId("userId")
                    .account("account")
                    .text("text")
                    .addMediaId("string")
                    .replyToMessageId("reply_to_message_id")
                    .build()
            )

        dm.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveHistory() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val response =
            dmService.retrieveHistory(
                DmRetrieveHistoryParams.builder()
                    .userId("userId")
                    .cursor("cursor")
                    .maxId("maxId")
                    .build()
            )

        response.validate()
    }
}
