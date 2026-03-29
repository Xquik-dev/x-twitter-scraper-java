// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.support

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateParams
import com.x_twitter_scraper.api.models.support.tickets.TicketReplyParams
import com.x_twitter_scraper.api.models.support.tickets.TicketUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TicketServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketServiceAsync = client.support().tickets()

        val ticketFuture =
            ticketServiceAsync.create(
                TicketCreateParams.builder().body("body").subject("subject").build()
            )

        val ticket = ticketFuture.get()
        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketServiceAsync = client.support().tickets()

        val ticketFuture = ticketServiceAsync.retrieve("id")

        val ticket = ticketFuture.get()
        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketServiceAsync = client.support().tickets()

        val ticketFuture =
            ticketServiceAsync.update(
                TicketUpdateParams.builder().id("id").status(TicketUpdateParams.Status.OPEN).build()
            )

        val ticket = ticketFuture.get()
        ticket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketServiceAsync = client.support().tickets()

        val ticketsFuture = ticketServiceAsync.list()

        val tickets = ticketsFuture.get()
        tickets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun reply() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val ticketServiceAsync = client.support().tickets()

        val responseFuture =
            ticketServiceAsync.reply(TicketReplyParams.builder().id("id").body("body").build())

        val response = responseFuture.get()
        response.validate()
    }
}
