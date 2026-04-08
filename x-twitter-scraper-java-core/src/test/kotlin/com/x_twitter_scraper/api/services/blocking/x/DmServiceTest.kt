// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DmServiceTest {

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

    @Disabled("Mock server tests are disabled")
    @Test
    fun send() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val response =
            dmService.send(
                DmSendParams.builder()
                    .userId("userId")
                    .account("@elonmusk")
                    .text("Example text content")
                    .addMediaId("1234567890123456789")
                    .replyToMessageId("1234567890123456789")
                    .build()
            )

        response.validate()
    }
}
