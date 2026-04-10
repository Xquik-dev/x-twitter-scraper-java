// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
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
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinService
import com.x_twitter_scraper.api.services.blocking.x.communities.TweetService
import java.util.function.Consumer

interface CommunityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityService

    /** X write actions (tweets, likes, follows, DMs) */
    fun join(): JoinService

    /** X Community info, members, and tweets */
    fun tweets(): TweetService

    /** Create community */
    fun create(params: CommunityCreateParams): CommunityCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityCreateResponse

    /** Delete community */
    fun delete(id: String, params: CommunityDeleteParams): CommunityDeleteResponse =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: CommunityDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: CommunityDeleteParams): CommunityDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityDeleteResponse

    /** Get community name, description & member count */
    fun retrieveInfo(id: String): CommunityRetrieveInfoResponse =
        retrieveInfo(id, CommunityRetrieveInfoParams.none())

    /** @see retrieveInfo */
    fun retrieveInfo(
        id: String,
        params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityRetrieveInfoResponse =
        retrieveInfo(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveInfo */
    fun retrieveInfo(
        id: String,
        params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
    ): CommunityRetrieveInfoResponse = retrieveInfo(id, params, RequestOptions.none())

    /** @see retrieveInfo */
    fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityRetrieveInfoResponse

    /** @see retrieveInfo */
    fun retrieveInfo(params: CommunityRetrieveInfoParams): CommunityRetrieveInfoResponse =
        retrieveInfo(params, RequestOptions.none())

    /** @see retrieveInfo */
    fun retrieveInfo(id: String, requestOptions: RequestOptions): CommunityRetrieveInfoResponse =
        retrieveInfo(id, CommunityRetrieveInfoParams.none(), requestOptions)

    /** List members of a community */
    fun retrieveMembers(id: String): PaginatedUsers =
        retrieveMembers(id, CommunityRetrieveMembersParams.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMembers */
    fun retrieveMembers(
        id: String,
        params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
    ): PaginatedUsers = retrieveMembers(id, params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see retrieveMembers */
    fun retrieveMembers(params: CommunityRetrieveMembersParams): PaginatedUsers =
        retrieveMembers(params, RequestOptions.none())

    /** @see retrieveMembers */
    fun retrieveMembers(id: String, requestOptions: RequestOptions): PaginatedUsers =
        retrieveMembers(id, CommunityRetrieveMembersParams.none(), requestOptions)

    /** List moderators of a community */
    fun retrieveModerators(id: String): PaginatedUsers =
        retrieveModerators(id, CommunityRetrieveModeratorsParams.none())

    /** @see retrieveModerators */
    fun retrieveModerators(
        id: String,
        params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = retrieveModerators(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveModerators */
    fun retrieveModerators(
        id: String,
        params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
    ): PaginatedUsers = retrieveModerators(id, params, RequestOptions.none())

    /** @see retrieveModerators */
    fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see retrieveModerators */
    fun retrieveModerators(params: CommunityRetrieveModeratorsParams): PaginatedUsers =
        retrieveModerators(params, RequestOptions.none())

    /** @see retrieveModerators */
    fun retrieveModerators(id: String, requestOptions: RequestOptions): PaginatedUsers =
        retrieveModerators(id, CommunityRetrieveModeratorsParams.none(), requestOptions)

    /** Search for communities by keyword */
    fun retrieveSearch(params: CommunityRetrieveSearchParams): PaginatedTweets =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** A view of [CommunityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun join(): JoinService.WithRawResponse

        /** X Community info, members, and tweets */
        fun tweets(): TweetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/communities`, but is otherwise the same as
         * [CommunityService.create].
         */
        @MustBeClosed
        fun create(params: CommunityCreateParams): HttpResponseFor<CommunityCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CommunityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /x/communities/{id}`, but is otherwise the same
         * as [CommunityService.delete].
         */
        @MustBeClosed
        fun delete(
            id: String,
            params: CommunityDeleteParams,
        ): HttpResponseFor<CommunityDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: CommunityDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: CommunityDeleteParams): HttpResponseFor<CommunityDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CommunityDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityDeleteResponse>

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/info`, but is otherwise the same
         * as [CommunityService.retrieveInfo].
         */
        @MustBeClosed
        fun retrieveInfo(id: String): HttpResponseFor<CommunityRetrieveInfoResponse> =
            retrieveInfo(id, CommunityRetrieveInfoParams.none())

        /** @see retrieveInfo */
        @MustBeClosed
        fun retrieveInfo(
            id: String,
            params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityRetrieveInfoResponse> =
            retrieveInfo(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveInfo */
        @MustBeClosed
        fun retrieveInfo(
            id: String,
            params: CommunityRetrieveInfoParams = CommunityRetrieveInfoParams.none(),
        ): HttpResponseFor<CommunityRetrieveInfoResponse> =
            retrieveInfo(id, params, RequestOptions.none())

        /** @see retrieveInfo */
        @MustBeClosed
        fun retrieveInfo(
            params: CommunityRetrieveInfoParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityRetrieveInfoResponse>

        /** @see retrieveInfo */
        @MustBeClosed
        fun retrieveInfo(
            params: CommunityRetrieveInfoParams
        ): HttpResponseFor<CommunityRetrieveInfoResponse> =
            retrieveInfo(params, RequestOptions.none())

        /** @see retrieveInfo */
        @MustBeClosed
        fun retrieveInfo(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityRetrieveInfoResponse> =
            retrieveInfo(id, CommunityRetrieveInfoParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/members`, but is otherwise the
         * same as [CommunityService.retrieveMembers].
         */
        @MustBeClosed
        fun retrieveMembers(id: String): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(id, CommunityRetrieveMembersParams.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            params: CommunityRetrieveMembersParams = CommunityRetrieveMembersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = retrieveMembers(id, params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            params: CommunityRetrieveMembersParams
        ): HttpResponseFor<PaginatedUsers> = retrieveMembers(params, RequestOptions.none())

        /** @see retrieveMembers */
        @MustBeClosed
        fun retrieveMembers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            retrieveMembers(id, CommunityRetrieveMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/moderators`, but is otherwise
         * the same as [CommunityService.retrieveModerators].
         */
        @MustBeClosed
        fun retrieveModerators(id: String): HttpResponseFor<PaginatedUsers> =
            retrieveModerators(id, CommunityRetrieveModeratorsParams.none())

        /** @see retrieveModerators */
        @MustBeClosed
        fun retrieveModerators(
            id: String,
            params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            retrieveModerators(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveModerators */
        @MustBeClosed
        fun retrieveModerators(
            id: String,
            params: CommunityRetrieveModeratorsParams = CommunityRetrieveModeratorsParams.none(),
        ): HttpResponseFor<PaginatedUsers> = retrieveModerators(id, params, RequestOptions.none())

        /** @see retrieveModerators */
        @MustBeClosed
        fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see retrieveModerators */
        @MustBeClosed
        fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams
        ): HttpResponseFor<PaginatedUsers> = retrieveModerators(params, RequestOptions.none())

        /** @see retrieveModerators */
        @MustBeClosed
        fun retrieveModerators(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            retrieveModerators(id, CommunityRetrieveModeratorsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/search`, but is otherwise the same as
         * [CommunityService.retrieveSearch].
         */
        @MustBeClosed
        fun retrieveSearch(
            params: CommunityRetrieveSearchParams
        ): HttpResponseFor<PaginatedTweets> = retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        @MustBeClosed
        fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>
    }
}
