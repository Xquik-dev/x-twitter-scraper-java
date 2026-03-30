// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.bot

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class PlatformLinkServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    PlatformLinkService {

    private val withRawResponse: PlatformLinkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PlatformLinkService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlatformLinkService =
        PlatformLinkServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PlatformLinkService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlatformLinkService.WithRawResponse =
            PlatformLinkServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
