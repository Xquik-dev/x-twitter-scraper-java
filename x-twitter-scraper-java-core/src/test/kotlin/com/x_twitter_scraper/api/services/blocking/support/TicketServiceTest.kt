// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.support

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateParams
import com.x_twitter_scraper.api.models.support.tickets.TicketReplyParams
import com.x_twitter_scraper.api.models.support.tickets.TicketUpdateParams
import org.junit.jupiter.api.Test

internal class TicketServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.create(
                TicketCreateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .body("I am unable to connect my X account. Please help.")
                    .subject("Cannot connect X account")
                    .build()
            )

        kotlin.test.assertNotNull(ticket)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket = ticketService.retrieve("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")

        kotlin.test.assertNotNull(ticket)
    }

    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.update(
                TicketUpdateParams.builder()
                    .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                    .status(TicketUpdateParams.Status.RESOLVED)
                    .build()
            )

        kotlin.test.assertNotNull(ticket)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val tickets = ticketService.list()

        kotlin.test.assertNotNull(tickets)
    }

    @Test
    fun reply() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val response =
            ticketService.reply(
                TicketReplyParams.builder()
                    .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                    .idempotencyKey("Idempotency-Key")
                    .body("Thank you for the update.")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
