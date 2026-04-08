// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateResponse
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface FollowServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowServiceAsync

    /** Follow user */
    fun create(id: String, params: FollowCreateParams): CompletableFuture<FollowCreateResponse> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: FollowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: FollowCreateParams): CompletableFuture<FollowCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FollowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowCreateResponse>

    /** Unfollow user */
    fun deleteAll(
        id: String,
        params: FollowDeleteAllParams,
    ): CompletableFuture<FollowDeleteAllResponse> = deleteAll(id, params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        id: String,
        params: FollowDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowDeleteAllResponse> =
        deleteAll(params.toBuilder().id(id).build(), requestOptions)

    /** @see deleteAll */
    fun deleteAll(params: FollowDeleteAllParams): CompletableFuture<FollowDeleteAllResponse> =
        deleteAll(params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        params: FollowDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowDeleteAllResponse>

    /**
     * A view of [FollowServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FollowServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/users/{id}/follow`, but is otherwise the same as
         * [FollowServiceAsync.create].
         */
        fun create(
            id: String,
            params: FollowCreateParams,
        ): CompletableFuture<HttpResponseFor<FollowCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: FollowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: FollowCreateParams
        ): CompletableFuture<HttpResponseFor<FollowCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: FollowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/users/{id}/follow`, but is otherwise the same
         * as [FollowServiceAsync.deleteAll].
         */
        fun deleteAll(
            id: String,
            params: FollowDeleteAllParams,
        ): CompletableFuture<HttpResponseFor<FollowDeleteAllResponse>> =
            deleteAll(id, params, RequestOptions.none())

        /** @see deleteAll */
        fun deleteAll(
            id: String,
            params: FollowDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowDeleteAllResponse>> =
            deleteAll(params.toBuilder().id(id).build(), requestOptions)

        /** @see deleteAll */
        fun deleteAll(
            params: FollowDeleteAllParams
        ): CompletableFuture<HttpResponseFor<FollowDeleteAllResponse>> =
            deleteAll(params, RequestOptions.none())

        /** @see deleteAll */
        fun deleteAll(
            params: FollowDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowDeleteAllResponse>>
    }
}
