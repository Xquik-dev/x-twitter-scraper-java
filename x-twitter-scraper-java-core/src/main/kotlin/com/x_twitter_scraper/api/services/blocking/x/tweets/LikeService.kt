// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface LikeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LikeService

    /** Like tweet */
    fun create(tweetId: String, params: LikeCreateParams): LikeCreateResponse =
        create(tweetId, params, RequestOptions.none())

    /** @see create */
    fun create(
        tweetId: String,
        params: LikeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LikeCreateResponse = create(params.toBuilder().tweetId(tweetId).build(), requestOptions)

    /** @see create */
    fun create(params: LikeCreateParams): LikeCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: LikeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LikeCreateResponse

    /** Unlike tweet */
    fun delete(tweetId: String, params: LikeDeleteParams): LikeDeleteResponse =
        delete(tweetId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        tweetId: String,
        params: LikeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LikeDeleteResponse = delete(params.toBuilder().tweetId(tweetId).build(), requestOptions)

    /** @see delete */
    fun delete(params: LikeDeleteParams): LikeDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: LikeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LikeDeleteResponse

    /** A view of [LikeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LikeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets/{tweetId}/like`, but is otherwise the
         * same as [LikeService.create].
         */
        @MustBeClosed
        fun create(tweetId: String, params: LikeCreateParams): HttpResponseFor<LikeCreateResponse> =
            create(tweetId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            tweetId: String,
            params: LikeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LikeCreateResponse> =
            create(params.toBuilder().tweetId(tweetId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: LikeCreateParams): HttpResponseFor<LikeCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: LikeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LikeCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{tweetId}/like`, but is otherwise the
         * same as [LikeService.delete].
         */
        @MustBeClosed
        fun delete(tweetId: String, params: LikeDeleteParams): HttpResponseFor<LikeDeleteResponse> =
            delete(tweetId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            tweetId: String,
            params: LikeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LikeDeleteResponse> =
            delete(params.toBuilder().tweetId(tweetId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: LikeDeleteParams): HttpResponseFor<LikeDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: LikeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LikeDeleteResponse>
    }
}
