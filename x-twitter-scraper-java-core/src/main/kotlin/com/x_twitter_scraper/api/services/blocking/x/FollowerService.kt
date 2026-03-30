// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckParams
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckResponse
import java.util.function.Consumer

/** X data lookups (subscription required) */
interface FollowerService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowerService

    /** Check follow relationship */
    fun check(params: FollowerCheckParams): FollowerCheckResponse =
        check(params, RequestOptions.none())

    /** @see check */
    fun check(
        params: FollowerCheckParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FollowerCheckResponse

    /** A view of [FollowerService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowerService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/followers/check`, but is otherwise the same as
         * [FollowerService.check].
         */
        @MustBeClosed
        fun check(params: FollowerCheckParams): HttpResponseFor<FollowerCheckResponse> =
            check(params, RequestOptions.none())

        /** @see check */
        @MustBeClosed
        fun check(
            params: FollowerCheckParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FollowerCheckResponse>
    }
}
