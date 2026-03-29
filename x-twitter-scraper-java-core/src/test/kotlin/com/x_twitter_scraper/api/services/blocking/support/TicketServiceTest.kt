// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.support

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateParams
import com.x_twitter_scraper.api.models.support.tickets.TicketReplyParams
import com.x_twitter_scraper.api.models.support.tickets.TicketUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TicketServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.create(
                TicketCreateParams.builder().body("body").subject("subject").build()
            )

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket = ticketService.retrieve("id")

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.update(
                TicketUpdateParams.builder().id("id").status(TicketUpdateParams.Status.OPEN).build()
            )

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val tickets = ticketService.list()

        tickets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun reply() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketService = client.support().tickets()

        val response =
            ticketService.reply(TicketReplyParams.builder().id("id").body("body").build())

        response.validate()
    }
}
