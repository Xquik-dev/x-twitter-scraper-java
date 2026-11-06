// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x.users

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.mute.MuteCreateParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteCreateResponse
import com.x_twitter_scraper.api.models.x.users.mute.MuteDeleteParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteDeleteResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface MuteService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MuteService

    /**
     * Mutes a user through a connected X account. The user's posts leave that account's timelines,
     * and X doesn't tell the user.
     */
    fun create(id: String, params: MuteCreateParams): MuteCreateResponse =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: MuteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MuteCreateResponse = create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: MuteCreateParams): MuteCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: MuteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MuteCreateResponse

    /** Unmutes a user through a connected X account. */
    fun delete(id: String, params: MuteDeleteParams): MuteDeleteResponse =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: MuteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MuteDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: MuteDeleteParams): MuteDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: MuteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MuteDeleteResponse

    /** A view of [MuteService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MuteService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/users/{id}/mute`, but is otherwise the same as
         * [MuteService.create].
         */
        @MustBeClosed
        fun create(id: String, params: MuteCreateParams): HttpResponseFor<MuteCreateResponse> =
            create(id, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            id: String,
            params: MuteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MuteCreateResponse> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: MuteCreateParams): HttpResponseFor<MuteCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: MuteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MuteCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/users/{id}/mute`, but is otherwise the same as
         * [MuteService.delete].
         */
        @MustBeClosed
        fun delete(id: String, params: MuteDeleteParams): HttpResponseFor<MuteDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: MuteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MuteDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: MuteDeleteParams): HttpResponseFor<MuteDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: MuteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MuteDeleteResponse>
    }
}
