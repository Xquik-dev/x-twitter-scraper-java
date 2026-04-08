// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.TweetServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CommunityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun join(): JoinServiceAsync

    /** X data lookups (subscription required) */
    fun tweets(): TweetServiceAsync

    /** Create community */
    fun create(params: CommunityCreateParams): CompletableFuture<CommunityCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityCreateResponse>

    /** Delete community */
    fun delete(
        id: String,
        params: CommunityDeleteParams,
    ): CompletableFuture<CommunityDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: CommunityDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: CommunityDeleteParams): CompletableFuture<CommunityDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityDeleteResponse>

    /** Get community details */
    fun retrieveInfo(id: String): CompletableFuture<CommunityRetrieveInfoResponse> =
        retrieveInfo(id, CommunityRetrieveInfoParams.none())

    /** @see retrieveInfo */
    fun retrieveInfo(
        id: String,
        params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        retrieveInfo(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveInfo */
    fun retrieveInfo(
        id: String,
        params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        retrieveInfo(id, params, RequestOptions.none())

    /** @see retrieveInfo */
    fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityRetrieveInfoResponse>

    /** @see retrieveInfo */
    fun retrieveInfo(
        params: CommunityRetrieveInfoParams
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        retrieveInfo(params, RequestOptions.none())

    /** @see retrieveInfo */
    fun retrieveInfo(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        retrieveInfo(id, CommunityRetrieveInfoParams.none(), requestOptions)

    /** Get community members */
    fun retrieveMembers(id: String): CompletableFuture<PaginatedUsers> =
        retrieveMembers(id, CommunityRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveMembers */
    fun retrieveMembers(params: CommunityRetrieveMembersParams): CompletableFuture<PaginatedUsers> =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveMembers(id, CommunityRetrieveMembersParams.none(), requestOptions)

    /** Get community moderators */
    fun retrieveModerators(id: String): CompletableFuture<PaginatedUsers> =
        retrieveModerators(id, CommunityRetrieveModeratorsParams.none())

    /** @see retrieveModerators */
    fun retrieveModerators(
        id: String,
        params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveModerators(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveModerators */
    fun retrieveModerators(
        id: String,
        params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveModerators(id, params, RequestOptions.none())

    /** @see retrieveModerators */
    fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveModerators */
    fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams
    ): CompletableFuture<PaginatedUsers> = retrieveModerators(params, RequestOptions.none())

    /** @see retrieveModerators */
    fun retrieveModerators(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveModerators(id, CommunityRetrieveModeratorsParams.none(), requestOptions)

    /** Search tweets across communities */
    fun retrieveSearch(params: CommunityRetrieveSearchParams): CompletableFuture<PaginatedTweets> =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /**
     * A view of [CommunityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun join(): JoinServiceAsync.WithRawResponse

        /** X data lookups (subscription required) */
        fun tweets(): TweetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/communities`, but is otherwise the same as
         * [CommunityServiceAsync.create].
         */
        fun create(
            params: CommunityCreateParams
        ): CompletableFuture<HttpResponseFor<CommunityCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CommunityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/communities/{id}`, but is otherwise the same
         * as [CommunityServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: CommunityDeleteParams,
        ): CompletableFuture<HttpResponseFor<CommunityDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: CommunityDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: CommunityDeleteParams
        ): CompletableFuture<HttpResponseFor<CommunityDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: CommunityDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityDeleteResponse>>

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/info`, but is otherwise the same
         * as [CommunityServiceAsync.retrieveInfo].
         */
        fun retrieveInfo(
            id: String
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> =
            retrieveInfo(id, CommunityRetrieveInfoParams.none())

        /** @see retrieveInfo */
        fun retrieveInfo(
            id: String,
            params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> =
            retrieveInfo(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveInfo */
        fun retrieveInfo(
            id: String,
            params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> =
            retrieveInfo(id, params, RequestOptions.none())

        /** @see retrieveInfo */
        fun retrieveInfo(
            params: CommunityRetrieveInfoParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>>

        /** @see retrieveInfo */
        fun retrieveInfo(
            params: CommunityRetrieveInfoParams
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> =
            retrieveInfo(params, RequestOptions.none())

        /** @see retrieveInfo */
        fun retrieveInfo(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> =
            retrieveInfo(id, CommunityRetrieveInfoParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/members`, but is otherwise the
         * same as [CommunityServiceAsync.retrieveMembers].
         */
        fun retrieveMembers(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, CommunityRetrieveMembersParams.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveMembers */
        fun retrieveMembers(
            params: CommunityRetrieveMembersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveMembers(id, CommunityRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/moderators`, but is otherwise
         * the same as [CommunityServiceAsync.retrieveModerators].
         */
        fun retrieveModerators(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveModerators(id, CommunityRetrieveModeratorsParams.none())

        /** @see retrieveModerators */
        fun retrieveModerators(
            id: String,
            params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveModerators(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveModerators */
        fun retrieveModerators(
            id: String,
            params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveModerators(id, params, RequestOptions.none())

        /** @see retrieveModerators */
        fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveModerators */
        fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveModerators(params, RequestOptions.none())

        /** @see retrieveModerators */
        fun retrieveModerators(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveModerators(id, CommunityRetrieveModeratorsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/search`, but is otherwise the same as
         * [CommunityServiceAsync.retrieveSearch].
         */
        fun retrieveSearch(
            params: CommunityRetrieveSearchParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>
    }
}
