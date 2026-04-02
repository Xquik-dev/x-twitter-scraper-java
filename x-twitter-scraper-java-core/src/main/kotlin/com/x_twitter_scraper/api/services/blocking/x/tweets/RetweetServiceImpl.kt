// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class RetweetServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RetweetService {

    private val withRawResponse: RetweetService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RetweetService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RetweetService =
        RetweetServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RetweetService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RetweetService.WithRawResponse =
            RetweetServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
