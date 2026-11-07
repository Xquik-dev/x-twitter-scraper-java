// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.mute.MuteCreateParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteCreateResponse
import com.x_twitter_scraper.api.models.x.users.mute.MuteDeleteParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteDeleteResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface MuteServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MuteServiceAsync

    /**
     * Mutes a user through a connected X account. The user's posts leave that account's timelines,
     * and X doesn't tell the user.
     */
    fun create(id: String, params: MuteCreateParams): CompletableFuture<MuteCreateResponse> =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: MuteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MuteCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: MuteCreateParams): CompletableFuture<MuteCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: MuteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MuteCreateResponse>

    /** Unmutes a user through a connected X account. */
    fun delete(id: String, params: MuteDeleteParams): CompletableFuture<MuteDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: MuteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MuteDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: MuteDeleteParams): CompletableFuture<MuteDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: MuteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MuteDeleteResponse>

    /** A view of [MuteServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MuteServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/users/{id}/mute`, but is otherwise the same as
         * [MuteServiceAsync.create].
         */
        fun create(
            id: String,
            params: MuteCreateParams,
        ): CompletableFuture<HttpResponseFor<MuteCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: MuteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MuteCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: MuteCreateParams
        ): CompletableFuture<HttpResponseFor<MuteCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: MuteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MuteCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/users/{id}/mute`, but is otherwise the same as
         * [MuteServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: MuteDeleteParams,
        ): CompletableFuture<HttpResponseFor<MuteDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: MuteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MuteDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: MuteDeleteParams
        ): CompletableFuture<HttpResponseFor<MuteDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: MuteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MuteDeleteResponse>>
    }
}
