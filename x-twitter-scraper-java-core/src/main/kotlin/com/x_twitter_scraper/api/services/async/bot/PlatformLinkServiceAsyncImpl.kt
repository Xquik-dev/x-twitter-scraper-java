// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.bot

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class PlatformLinkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PlatformLinkServiceAsync {

    private val withRawResponse: PlatformLinkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PlatformLinkServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlatformLinkServiceAsync =
        PlatformLinkServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PlatformLinkServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlatformLinkServiceAsync.WithRawResponse =
            PlatformLinkServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
