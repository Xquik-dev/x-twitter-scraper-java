// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communities.CommunityActionResult
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface JoinServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JoinServiceAsync

    /** Join community */
    fun create(id: String, params: JoinCreateParams): CompletableFuture<CommunityActionResult> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: JoinCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityActionResult> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: JoinCreateParams): CompletableFuture<CommunityActionResult> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: JoinCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityActionResult>

    /** Leave community */
    fun deleteAll(
        id: String,
        params: JoinDeleteAllParams,
    ): CompletableFuture<CommunityActionResult> = deleteAll(id, params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        id: String,
        params: JoinDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityActionResult> =
        deleteAll(params.toBuilder().id(id).build(), requestOptions)

    /** @see deleteAll */
    fun deleteAll(params: JoinDeleteAllParams): CompletableFuture<CommunityActionResult> =
        deleteAll(params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        params: JoinDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityActionResult>

    /** A view of [JoinServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JoinServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/communities/{id}/join`, but is otherwise the
         * same as [JoinServiceAsync.create].
         */
        fun create(
            id: String,
            params: JoinCreateParams,
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: JoinCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: JoinCreateParams
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: JoinCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>>

        /**
         * Returns a raw HTTP response for `delete /x/communities/{id}/join`, but is otherwise the
         * same as [JoinServiceAsync.deleteAll].
         */
        fun deleteAll(
            id: String,
            params: JoinDeleteAllParams,
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            deleteAll(id, params, RequestOptions.none())

        /** @see deleteAll */
        fun deleteAll(
            id: String,
            params: JoinDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            deleteAll(params.toBuilder().id(id).build(), requestOptions)

        /** @see deleteAll */
        fun deleteAll(
            params: JoinDeleteAllParams
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>> =
            deleteAll(params, RequestOptions.none())

        /** @see deleteAll */
        fun deleteAll(
            params: JoinDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityActionResult>>
    }
}
