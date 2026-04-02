// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

class LikeServiceImpl internal constructor(private val clientOptions: ClientOptions) : LikeService {

    private val withRawResponse: LikeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LikeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LikeService =
        LikeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LikeService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LikeService.WithRawResponse =
            LikeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
