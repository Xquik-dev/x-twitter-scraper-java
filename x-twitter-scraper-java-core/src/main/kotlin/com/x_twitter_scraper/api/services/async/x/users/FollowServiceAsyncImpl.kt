// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class FollowServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FollowServiceAsync {

    private val withRawResponse: FollowServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FollowServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowServiceAsync =
        FollowServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FollowServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FollowServiceAsync.WithRawResponse =
            FollowServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
