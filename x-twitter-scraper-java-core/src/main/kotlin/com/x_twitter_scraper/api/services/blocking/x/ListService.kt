// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import java.util.function.Consumer

/** X List followers, members, and tweets */
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

    /**
     * Returns 1 public X List as its page on X shows it. Accepts the List ID or the URL-encoded
     * List URL, such as x.com/i/lists/4143408. A private List answers 404 list_not_found.
     */
    fun retrieve(id: String): ListRetrieveResponse = retrieve(id, ListRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ListRetrieveParams = ListRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ListRetrieveParams = ListRetrieveParams.none(),
    ): ListRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ListRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ListRetrieveParams): ListRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ListRetrieveResponse =
        retrieve(id, ListRetrieveParams.none(), requestOptions)

    /** List followers of an X List */
    fun retrieveFollowers(id: String): PaginatedUsers =
        retrieveFollowers(id, ListRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
    ): PaginatedUsers = retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see retrieveFollowers */
    fun retrieveFollowers(params: ListRetrieveFollowersParams): PaginatedUsers =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(id: String, requestOptions: RequestOptions): PaginatedUsers =
        retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

    /** List members of an X List */
    fun retrieveMembers(id: String): PaginatedUsers =
        retrieveMembers(id, ListRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
    ): PaginatedUsers = retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see retrieveMembers */
    fun retrieveMembers(params: ListRetrieveMembersParams): PaginatedUsers =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(id: String, requestOptions: RequestOptions): PaginatedUsers =
        retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

    /**
     * Returns 1 page of public Lists with member counts, banners & owner profiles. X may rank the
     * Lists differently per request. Pass next_cursor as cursor for the next page.
     */
    fun retrieveSearch(params: ListRetrieveSearchParams): ListRetrieveSearchResponse =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: ListRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ListRetrieveSearchResponse

    /** List tweets from an X List */
    fun retrieveTweets(id: String): PaginatedTweets =
        retrieveTweets(id, ListRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
    ): PaginatedTweets = retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see retrieveTweets */
    fun retrieveTweets(params: ListRetrieveTweetsParams): PaginatedTweets =
        retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(id: String, requestOptions: RequestOptions): PaginatedTweets =
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
         * Returns a raw HTTP response for `get /x/lists/{id}`, but is otherwise the same as
         * [ListService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ListRetrieveResponse> =
            retrieve(id, ListRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ListRetrieveParams = ListRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ListRetrieveParams = ListRetrieveParams.none(),
        ): HttpResponseFor<ListRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ListRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ListRetrieveParams): HttpResponseFor<ListRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveResponse> =
            retrieve(id, ListRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/followers`, but is otherwise the same
         * as [ListService.retrieveFollowers].
         */
        @MustBeClosed
        fun retrieveFollowers(id: String): HttpResponseFor<PaginatedUsers> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams
        ): HttpResponseFor<PaginatedUsers> = retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/members`, but is otherwise the same as
         * [ListService.retrieveMembers].
         */
        @MustBeClosed
        fun retrieveMembers(id: String): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(id, ListRetrieveMembersParams.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(params: ListRetrieveMembersParams): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/search`, but is otherwise the same as
         * [ListService.retrieveSearch].
         */
        @MustBeClosed
        fun retrieveSearch(
            params: ListRetrieveSearchParams
        ): HttpResponseFor<ListRetrieveSearchResponse> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        @MustBeClosed
        fun retrieveSearch(
            params: ListRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ListRetrieveSearchResponse>

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/tweets`, but is otherwise the same as
         * [ListService.retrieveTweets].
         */
        @MustBeClosed
        fun retrieveTweets(id: String): HttpResponseFor<PaginatedTweets> =
            retrieveTweets(id, ListRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        ): HttpResponseFor<PaginatedTweets> = retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(params: ListRetrieveTweetsParams): HttpResponseFor<PaginatedTweets> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)
    }
}
