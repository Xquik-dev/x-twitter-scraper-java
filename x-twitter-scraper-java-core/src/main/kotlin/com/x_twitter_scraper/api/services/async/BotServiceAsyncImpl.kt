// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.services.async.bot.PlatformLinkServiceAsync
import com.x_twitter_scraper.api.services.async.bot.PlatformLinkServiceAsyncImpl
import java.util.function.Consumer

class BotServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BotServiceAsync {

    private val withRawResponse: BotServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val platformLinks: PlatformLinkServiceAsync by lazy {
        PlatformLinkServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): BotServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotServiceAsync =
        BotServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun platformLinks(): PlatformLinkServiceAsync = platformLinks

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BotServiceAsync.WithRawResponse {

        private val platformLinks: PlatformLinkServiceAsync.WithRawResponse by lazy {
            PlatformLinkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BotServiceAsync.WithRawResponse =
            BotServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun platformLinks(): PlatformLinkServiceAsync.WithRawResponse = platformLinks
    }
}
