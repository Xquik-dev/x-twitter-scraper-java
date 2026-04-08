// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface LikeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LikeServiceAsync

    /** Like tweet */
    fun create(id: String, params: LikeCreateParams): CompletableFuture<LikeCreateResponse> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: LikeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LikeCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: LikeCreateParams): CompletableFuture<LikeCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: LikeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LikeCreateResponse>

    /** Unlike tweet */
    fun delete(id: String, params: LikeDeleteParams): CompletableFuture<LikeDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: LikeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LikeDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: LikeDeleteParams): CompletableFuture<LikeDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: LikeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LikeDeleteResponse>

    /** A view of [LikeServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LikeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets/{id}/like`, but is otherwise the same as
         * [LikeServiceAsync.create].
         */
        fun create(
            id: String,
            params: LikeCreateParams,
        ): CompletableFuture<HttpResponseFor<LikeCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: LikeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LikeCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: LikeCreateParams
        ): CompletableFuture<HttpResponseFor<LikeCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: LikeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LikeCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}/like`, but is otherwise the same
         * as [LikeServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: LikeDeleteParams,
        ): CompletableFuture<HttpResponseFor<LikeDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: LikeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LikeDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: LikeDeleteParams
        ): CompletableFuture<HttpResponseFor<LikeDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: LikeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LikeDeleteResponse>>
    }
}
