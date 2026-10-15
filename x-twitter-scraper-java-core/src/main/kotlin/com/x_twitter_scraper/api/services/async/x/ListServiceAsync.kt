// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X List followers, members, and tweets */
interface ListServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListServiceAsync

    /**
     * Returns 1 public X List as its page on X shows it. Accepts the List ID or the URL-encoded
     * List URL, such as x.com/i/lists/4143408. A private List answers 404 list_not_found.
     */
    fun retrieve(id: String): CompletableFuture<ListRetrieveResponse> =
        retrieve(id, ListRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ListRetrieveParams = ListRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ListRetrieveParams = ListRetrieveParams.none(),
    ): CompletableFuture<ListRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ListRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: ListRetrieveParams): CompletableFuture<ListRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ListRetrieveResponse> =
        retrieve(id, ListRetrieveParams.none(), requestOptions)

    /** List followers of an X List */
    fun retrieveFollowers(id: String): CompletableFuture<PaginatedUsers> =
        retrieveFollowers(id, ListRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveFollowers */
    fun retrieveFollowers(params: ListRetrieveFollowersParams): CompletableFuture<PaginatedUsers> =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

    /** List members of an X List */
    fun retrieveMembers(id: String): CompletableFuture<PaginatedUsers> =
        retrieveMembers(id, ListRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveMembers */
    fun retrieveMembers(params: ListRetrieveMembersParams): CompletableFuture<PaginatedUsers> =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

    /**
     * Returns 1 page of public Lists with member counts, banners & owner profiles. X may rank the
     * Lists differently per request. Pass next_cursor as cursor for the next page.
     */
    fun retrieveSearch(
        params: ListRetrieveSearchParams
    ): CompletableFuture<ListRetrieveSearchResponse> = retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: ListRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveSearchResponse>

    /** List tweets from an X List */
    fun retrieveTweets(id: String): CompletableFuture<PaginatedTweets> =
        retrieveTweets(id, ListRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveTweets */
    fun retrieveTweets(params: ListRetrieveTweetsParams): CompletableFuture<PaginatedTweets> =
        retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)

    /** A view of [ListServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}`, but is otherwise the same as
         * [ListServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ListRetrieveResponse>> =
            retrieve(id, ListRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ListRetrieveParams = ListRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ListRetrieveParams = ListRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ListRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ListRetrieveParams
        ): CompletableFuture<HttpResponseFor<ListRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ListRetrieveResponse>> =
            retrieve(id, ListRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/followers`, but is otherwise the same
         * as [ListServiceAsync.retrieveFollowers].
         */
        fun retrieveFollowers(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/members`, but is otherwise the same as
         * [ListServiceAsync.retrieveMembers].
         */
        fun retrieveMembers(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, ListRetrieveMembersParams.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: ListRetrieveMembersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/search`, but is otherwise the same as
         * [ListServiceAsync.retrieveSearch].
         */
        fun retrieveSearch(
            params: ListRetrieveSearchParams
        ): CompletableFuture<HttpResponseFor<ListRetrieveSearchResponse>> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        fun retrieveSearch(
            params: ListRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveSearchResponse>>

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/tweets`, but is otherwise the same as
         * [ListServiceAsync.retrieveTweets].
         */
        fun retrieveTweets(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, ListRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: ListRetrieveTweetsParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)
    }
}
