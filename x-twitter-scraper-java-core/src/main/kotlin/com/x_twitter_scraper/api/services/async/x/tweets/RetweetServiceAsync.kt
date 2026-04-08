// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface RetweetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RetweetServiceAsync

    /** Retweet */
    fun create(id: String, params: RetweetCreateParams): CompletableFuture<RetweetCreateResponse> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: RetweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RetweetCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: RetweetCreateParams): CompletableFuture<RetweetCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RetweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RetweetCreateResponse>

    /** Unretweet */
    fun delete(id: String, params: RetweetDeleteParams): CompletableFuture<RetweetDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: RetweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RetweetDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: RetweetDeleteParams): CompletableFuture<RetweetDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RetweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RetweetDeleteResponse>

    /**
     * A view of [RetweetServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RetweetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets/{id}/retweet`, but is otherwise the same
         * as [RetweetServiceAsync.create].
         */
        fun create(
            id: String,
            params: RetweetCreateParams,
        ): CompletableFuture<HttpResponseFor<RetweetCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: RetweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RetweetCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: RetweetCreateParams
        ): CompletableFuture<HttpResponseFor<RetweetCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: RetweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RetweetCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}/retweet`, but is otherwise the
         * same as [RetweetServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: RetweetDeleteParams,
        ): CompletableFuture<HttpResponseFor<RetweetDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: RetweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RetweetDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: RetweetDeleteParams
        ): CompletableFuture<HttpResponseFor<RetweetDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: RetweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RetweetDeleteResponse>>
    }
}
