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
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.create(
                TicketCreateParams.builder()
                    .body("I am unable to connect my X account. Please help.")
                    .subject("Cannot connect X account")
                    .build()
            )

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val ticketService = client.support().tickets()

        val ticket = ticketService.retrieve("messages_value")

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val ticketService = client.support().tickets()

        val ticket =
            ticketService.update(
                TicketUpdateParams.builder()
                    .id("id")
                    .status(TicketUpdateParams.Status.RESOLVED)
                    .build()
            )

        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val ticketService = client.support().tickets()

        val tickets = ticketService.list()

        tickets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun reply() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val ticketService = client.support().tickets()

        val response =
            ticketService.reply(
                TicketReplyParams.builder().id("id").body("Thank you for the update.").build()
            )

        response.validate()
    }
}
