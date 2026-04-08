// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface RetweetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RetweetService

    /** Retweet */
    fun create(id: String, params: RetweetCreateParams): RetweetCreateResponse =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: RetweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RetweetCreateResponse = create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: RetweetCreateParams): RetweetCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RetweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RetweetCreateResponse

    /** Unretweet */
    fun delete(id: String, params: RetweetDeleteParams): RetweetDeleteResponse =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: RetweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RetweetDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: RetweetDeleteParams): RetweetDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RetweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RetweetDeleteResponse

    /** A view of [RetweetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RetweetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets/{id}/retweet`, but is otherwise the same
         * as [RetweetService.create].
         */
        @MustBeClosed
        fun create(
            id: String,
            params: RetweetCreateParams,
        ): HttpResponseFor<RetweetCreateResponse> = create(id, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            id: String,
            params: RetweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RetweetCreateResponse> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: RetweetCreateParams): HttpResponseFor<RetweetCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: RetweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RetweetCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}/retweet`, but is otherwise the
         * same as [RetweetService.delete].
         */
        @MustBeClosed
        fun delete(
            id: String,
            params: RetweetDeleteParams,
        ): HttpResponseFor<RetweetDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: RetweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RetweetDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: RetweetDeleteParams): HttpResponseFor<RetweetDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: RetweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RetweetDeleteResponse>
    }
}
