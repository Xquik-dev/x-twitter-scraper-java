// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsResponse
import java.util.function.Consumer

/** X data lookups (subscription required) */
interface ListService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListService

    /** Get list followers */
    fun retrieveFollowers(id: String): ListRetrieveFollowersResponse =
        retrieveFollowers(id, ListRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveFollowersResponse =
        retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
    ): ListRetrieveFollowersResponse = retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveFollowersResponse

    /** @see retrieveFollowers */
    fun retrieveFollowers(params: ListRetrieveFollowersParams): ListRetrieveFollowersResponse =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): ListRetrieveFollowersResponse =
        retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

    /** Get list members */
    fun retrieveMembers(id: String): ListRetrieveMembersResponse =
        retrieveMembers(id, ListRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveMembersResponse =
        retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
    ): ListRetrieveMembersResponse = retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveMembersResponse

    /** @see retrieveMembers */
    fun retrieveMembers(params: ListRetrieveMembersParams): ListRetrieveMembersResponse =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(id: String, requestOptions: RequestOptions): ListRetrieveMembersResponse =
        retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

    /** Get list tweets */
    fun retrieveTweets(id: String): ListRetrieveTweetsResponse =
        retrieveTweets(id, ListRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveTweetsResponse =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
    ): ListRetrieveTweetsResponse = retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveTweetsResponse

    /** @see retrieveTweets */
    fun retrieveTweets(params: ListRetrieveTweetsParams): ListRetrieveTweetsResponse =
        retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(id: String, requestOptions: RequestOptions): ListRetrieveTweetsResponse =
        retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)

    /** A view of [ListService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/followers`, but is otherwise the same
         * as [ListService.retrieveFollowers].
         */
        @MustBeClosed
        fun retrieveFollowers(id: String): HttpResponseFor<ListRetrieveFollowersResponse> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveFollowersResponse> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        ): HttpResponseFor<ListRetrieveFollowersResponse> =
            retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveFollowersResponse>

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams
        ): HttpResponseFor<ListRetrieveFollowersResponse> =
            retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveFollowersResponse> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/members`, but is otherwise the same as
         * [ListService.retrieveMembers].
         */
        @MustBeClosed
        fun retrieveMembers(id: String): HttpResponseFor<ListRetrieveMembersResponse> =
            retrieveMembers(id, ListRetrieveMembersParams.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveMembersResponse> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        ): HttpResponseFor<ListRetrieveMembersResponse> =
            retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveMembersResponse>

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            params: ListRetrieveMembersParams
        ): HttpResponseFor<ListRetrieveMembersResponse> =
            retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveMembersResponse> =
            retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/tweets`, but is otherwise the same as
         * [ListService.retrieveTweets].
         */
        @MustBeClosed
        fun retrieveTweets(id: String): HttpResponseFor<ListRetrieveTweetsResponse> =
            retrieveTweets(id, ListRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveTweetsResponse> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        ): HttpResponseFor<ListRetrieveTweetsResponse> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveTweetsResponse>

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            params: ListRetrieveTweetsParams
        ): HttpResponseFor<ListRetrieveTweetsResponse> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveTweetsResponse> =
            retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)
    }
}
