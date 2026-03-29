// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.users

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateResponse
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface FollowService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowService

    /** Follow user */
    fun create(userId: String, params: FollowCreateParams): FollowCreateResponse =
        create(userId, params, RequestOptions.none())

    /** @see create */
    fun create(
        userId: String,
        params: FollowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FollowCreateResponse = create(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see create */
    fun create(params: FollowCreateParams): FollowCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FollowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FollowCreateResponse

    /** Unfollow user */
    fun deleteAll(userId: String, params: FollowDeleteAllParams): FollowDeleteAllResponse =
        deleteAll(userId, params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        userId: String,
        params: FollowDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FollowDeleteAllResponse =
        deleteAll(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see deleteAll */
    fun deleteAll(params: FollowDeleteAllParams): FollowDeleteAllResponse =
        deleteAll(params, RequestOptions.none())

    /** @see deleteAll */
    fun deleteAll(
        params: FollowDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FollowDeleteAllResponse

    /** A view of [FollowService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/users/{userId}/follow`, but is otherwise the
         * same as [FollowService.create].
         */
        @MustBeClosed
        fun create(
            userId: String,
            params: FollowCreateParams,
        ): HttpResponseFor<FollowCreateResponse> = create(userId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            userId: String,
            params: FollowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FollowCreateResponse> =
            create(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: FollowCreateParams): HttpResponseFor<FollowCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: FollowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FollowCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/users/{userId}/follow`, but is otherwise the
         * same as [FollowService.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(
            userId: String,
            params: FollowDeleteAllParams,
        ): HttpResponseFor<FollowDeleteAllResponse> =
            deleteAll(userId, params, RequestOptions.none())

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(
            userId: String,
            params: FollowDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FollowDeleteAllResponse> =
            deleteAll(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(params: FollowDeleteAllParams): HttpResponseFor<FollowDeleteAllResponse> =
            deleteAll(params, RequestOptions.none())

        /** @see deleteAll */
        @MustBeClosed
        fun deleteAll(
            params: FollowDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FollowDeleteAllResponse>
    }
}
