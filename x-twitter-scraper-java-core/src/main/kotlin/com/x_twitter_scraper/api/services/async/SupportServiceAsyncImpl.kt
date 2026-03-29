// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.services.async.support.TicketServiceAsync
import com.x_twitter_scraper.api.services.async.support.TicketServiceAsyncImpl
import java.util.function.Consumer

class SupportServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SupportServiceAsync {

    private val withRawResponse: SupportServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val tickets: TicketServiceAsync by lazy { TicketServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): SupportServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SupportServiceAsync =
        SupportServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Support ticket management */
    override fun tickets(): TicketServiceAsync = tickets

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SupportServiceAsync.WithRawResponse {

        private val tickets: TicketServiceAsync.WithRawResponse by lazy {
            TicketServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SupportServiceAsync.WithRawResponse =
            SupportServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Support ticket management */
        override fun tickets(): TicketServiceAsync.WithRawResponse = tickets
    }
}
