// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateParams
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateResponse
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteParams
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface BlockServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BlockServiceAsync

    /**
     * Blocks a user through a connected X account. X removes follows both ways, and unblocking
     * doesn't restore them.
     */
    fun create(id: String, params: BlockCreateParams): CompletableFuture<BlockCreateResponse> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: BlockCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BlockCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: BlockCreateParams): CompletableFuture<BlockCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: BlockCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BlockCreateResponse>

    /** Unblocks a user through a connected X account. */
    fun delete(id: String, params: BlockDeleteParams): CompletableFuture<BlockDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: BlockDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BlockDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: BlockDeleteParams): CompletableFuture<BlockDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: BlockDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BlockDeleteResponse>

    /** A view of [BlockServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BlockServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/users/{id}/block`, but is otherwise the same as
         * [BlockServiceAsync.create].
         */
        fun create(
            id: String,
            params: BlockCreateParams,
        ): CompletableFuture<HttpResponseFor<BlockCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: BlockCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BlockCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: BlockCreateParams
        ): CompletableFuture<HttpResponseFor<BlockCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: BlockCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BlockCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/users/{id}/block`, but is otherwise the same
         * as [BlockServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: BlockDeleteParams,
        ): CompletableFuture<HttpResponseFor<BlockDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: BlockDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BlockDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: BlockDeleteParams
        ): CompletableFuture<HttpResponseFor<BlockDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: BlockDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BlockDeleteResponse>>
    }
}
