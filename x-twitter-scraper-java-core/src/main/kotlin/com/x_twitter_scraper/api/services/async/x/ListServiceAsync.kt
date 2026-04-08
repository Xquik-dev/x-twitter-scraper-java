// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    /** Get list followers */
    fun retrieveFollowers(id: String): CompletableFuture<ListRetrieveFollowersResponse> =
        retrieveFollowers(id, ListRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveFollowersResponse> =
        retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
    ): CompletableFuture<ListRetrieveFollowersResponse> =
        retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveFollowersResponse>

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: ListRetrieveFollowersParams
    ): CompletableFuture<ListRetrieveFollowersResponse> =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ListRetrieveFollowersResponse> =
        retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

    /** Get list members */
    fun retrieveMembers(id: String): CompletableFuture<ListRetrieveMembersResponse> =
        retrieveMembers(id, ListRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveMembersResponse> =
        retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
    ): CompletableFuture<ListRetrieveMembersResponse> =
        retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveMembersResponse>

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: ListRetrieveMembersParams
    ): CompletableFuture<ListRetrieveMembersResponse> =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ListRetrieveMembersResponse> =
        retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

    /** Get list tweets */
    fun retrieveTweets(id: String): CompletableFuture<ListRetrieveTweetsResponse> =
        retrieveTweets(id, ListRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveTweetsResponse> =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
    ): CompletableFuture<ListRetrieveTweetsResponse> =
        retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListRetrieveTweetsResponse>

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: ListRetrieveTweetsParams
    ): CompletableFuture<ListRetrieveTweetsResponse> = retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ListRetrieveTweetsResponse> =
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
         * Returns a raw HTTP response for `get /x/lists/{id}/followers`, but is otherwise the same
         * as [ListServiceAsync.retrieveFollowers].
         */
        fun retrieveFollowers(
            id: String
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: ListRetrieveFollowersParams = ListRetrieveFollowersParams.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>> =
            retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>>

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: ListRetrieveFollowersParams
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>> =
            retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ListRetrieveFollowersResponse>> =
            retrieveFollowers(id, ListRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/members`, but is otherwise the same as
         * [ListServiceAsync.retrieveMembers].
         */
        fun retrieveMembers(
            id: String
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>> =
            retrieveMembers(id, ListRetrieveMembersParams.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: ListRetrieveMembersParams = ListRetrieveMembersParams.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>> =
            retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>>

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: ListRetrieveMembersParams
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>> =
            retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ListRetrieveMembersResponse>> =
            retrieveMembers(id, ListRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/lists/{id}/tweets`, but is otherwise the same as
         * [ListServiceAsync.retrieveTweets].
         */
        fun retrieveTweets(
            id: String
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>> =
            retrieveTweets(id, ListRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: ListRetrieveTweetsParams = ListRetrieveTweetsParams.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>>

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: ListRetrieveTweetsParams
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ListRetrieveTweetsResponse>> =
            retrieveTweets(id, ListRetrieveTweetsParams.none(), requestOptions)
    }
}
