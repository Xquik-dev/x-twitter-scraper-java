// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.users

import com.x_twitter_scraper.api.core.ClientOptions
import java.util.function.Consumer

interface FollowService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowService

    /** A view of [FollowService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowService.WithRawResponse
    }
}
