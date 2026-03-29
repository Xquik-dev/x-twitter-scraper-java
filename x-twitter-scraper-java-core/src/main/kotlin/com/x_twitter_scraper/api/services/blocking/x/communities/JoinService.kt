// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateResponse
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface JoinService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JoinService

    /** Join community */
    fun create(id: String, params: JoinCreateParams): JoinCreateResponse =
        create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: JoinCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JoinCreateResponse = create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: JoinCreateParams): JoinCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: JoinCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JoinCreateResponse

    /** Leave community */
    fun deleteAll(id: String, params: JoinDeleteAllParams): JoinDeleteAllResponse =
        deleteAll(id, params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        id: String,
        params: JoinDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JoinDeleteAllResponse = deleteAll(params.toBuilder().id(id).build(), requestOptions)

    /** @see deleteAll */
    fun deleteAll(params: JoinDeleteAllParams): JoinDeleteAllResponse =
        deleteAll(params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        params: JoinDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JoinDeleteAllResponse

    /** A view of [JoinService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JoinService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/communities/{id}/join`, but is otherwise the
         * same as [JoinService.create].
         */
        @MustBeClosed
        fun create(id: String, params: JoinCreateParams): HttpResponseFor<JoinCreateResponse> =
            create(id, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            id: String,
            params: JoinCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JoinCreateResponse> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: JoinCreateParams): HttpResponseFor<JoinCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: JoinCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JoinCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/communities/{id}/join`, but is otherwise the
         * same as [JoinService.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(
            id: String,
            params: JoinDeleteAllParams,
        ): HttpResponseFor<JoinDeleteAllResponse> = deleteAll(id, params, RequestOptions.none())

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(
            id: String,
            params: JoinDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JoinDeleteAllResponse> =
            deleteAll(params.toBuilder().id(id).build(), requestOptions)

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(params: JoinDeleteAllParams): HttpResponseFor<JoinDeleteAllResponse> =
            deleteAll(params, RequestOptions.none())

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(
            params: JoinDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JoinDeleteAllResponse>
    }
}
