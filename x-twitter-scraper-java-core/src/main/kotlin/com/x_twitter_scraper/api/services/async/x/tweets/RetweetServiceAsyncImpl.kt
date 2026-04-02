// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class RetweetServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RetweetServiceAsync {

    private val withRawResponse: RetweetServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RetweetServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RetweetServiceAsync =
        RetweetServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RetweetServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RetweetServiceAsync.WithRawResponse =
            RetweetServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
