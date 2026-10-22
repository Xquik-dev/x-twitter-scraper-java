// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.CommunityAnalytics
import com.x_twitter_scraper.api.models.CommunityPage
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityFindParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListPopularParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveAnalyticsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.communities.CommunitySearchMembersParams
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinService
import com.x_twitter_scraper.api.services.blocking.x.communities.MediaService
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

    /** Find X Communities & read their info, members, posts & media */
    fun media(): MediaService

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

    /**
     * Returns the communities X finds for a keyword, in X's order. Each community costs 1 credit.
     * To search the tweets in Communities, use /x/communities/search.
     */
    fun find(params: CommunityFindParams): CommunityPage = find(params, RequestOptions.none())

    /** @see find */
    fun find(
        params: CommunityFindParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityPage

    /**
     * Returns the communities X ranks highest under a topic or subtopic. Name it by topicId or by
     * topic name from /x/communities/topics. Each community costs 1 credit. A missing or unknown
     * topic returns invalid_community_topic & lists the topic names.
     */
    fun listPopular(): CommunityPage = listPopular(CommunityListPopularParams.none())

    /** @see listPopular */
    fun listPopular(
        params: CommunityListPopularParams = CommunityListPopularParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityPage

    /** @see listPopular */
    fun listPopular(
        params: CommunityListPopularParams = CommunityListPopularParams.none()
    ): CommunityPage = listPopular(params, RequestOptions.none())

    /** @see listPopular */
    fun listPopular(requestOptions: RequestOptions): CommunityPage =
        listPopular(CommunityListPopularParams.none(), requestOptions)

    /**
     * Returns the communities X suggests, with their full public fields. X picks them per request,
     * so 2 calls can differ. If X suggests none, Xquik asks up to 2 more times. An empty list is
     * free. Each community costs 1 credit.
     */
    fun listSuggested(): CommunityListSuggestedResponse =
        listSuggested(CommunityListSuggestedParams.none())

    /** @see listSuggested */
    fun listSuggested(
        params: CommunityListSuggestedParams = CommunityListSuggestedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityListSuggestedResponse

    /** @see listSuggested */
    fun listSuggested(
        params: CommunityListSuggestedParams = CommunityListSuggestedParams.none()
    ): CommunityListSuggestedResponse = listSuggested(params, RequestOptions.none())

    /** @see listSuggested */
    fun listSuggested(requestOptions: RequestOptions): CommunityListSuggestedResponse =
        listSuggested(CommunityListSuggestedParams.none(), requestOptions)

    /**
     * Returns the community topics with their subtopics. Pass an ID as topicId, or a name as topic,
     * to /x/communities/popular. Each top-level topic costs 1 credit, its subtopics included.
     */
    fun listTopics(): CommunityListTopicsResponse = listTopics(CommunityListTopicsParams.none())

    /** @see listTopics */
    fun listTopics(
        params: CommunityListTopicsParams = CommunityListTopicsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityListTopicsResponse

    /** @see listTopics */
    fun listTopics(
        params: CommunityListTopicsParams = CommunityListTopicsParams.none()
    ): CommunityListTopicsResponse = listTopics(params, RequestOptions.none())

    /** @see listTopics */
    fun listTopics(requestOptions: RequestOptions): CommunityListTopicsResponse =
        listTopics(CommunityListTopicsParams.none(), requestOptions)

    /**
     * Returns community activity for X's latest period. Includes likes, new members, posts, replies
     * & unique posters. Each metric has a count and a changePercent. Each request costs 1 credit.
     */
    fun retrieveAnalytics(id: String): CommunityAnalytics =
        retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        id: String,
        params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityAnalytics = retrieveAnalytics(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        id: String,
        params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
    ): CommunityAnalytics = retrieveAnalytics(id, params, RequestOptions.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        params: CommunityRetrieveAnalyticsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityAnalytics

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(params: CommunityRetrieveAnalyticsParams): CommunityAnalytics =
        retrieveAnalytics(params, RequestOptions.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(id: String, requestOptions: RequestOptions): CommunityAnalytics =
        retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none(), requestOptions)

    /** Get community name, description and member count */
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

    /** Returns tweets, not community records. Requires a Community ID. */
    fun retrieveSearch(params: CommunityRetrieveSearchParams): PaginatedTweets =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /**
     * Finds a community's members by name or username, as the search box on X's members page does.
     * X checks up to 10 accounts that match, & the answer holds the members among them, each with
     * its role. Each member costs 1 credit. An answer without members is free.
     */
    fun searchMembers(id: String, params: CommunitySearchMembersParams): PaginatedUsers =
        searchMembers(id, params, RequestOptions.none())

    /** @see searchMembers */
    fun searchMembers(
        id: String,
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = searchMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see searchMembers */
    fun searchMembers(params: CommunitySearchMembersParams): PaginatedUsers =
        searchMembers(params, RequestOptions.none())

    /** @see searchMembers */
    fun searchMembers(
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

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

        /** Find X Communities & read their info, members, posts & media */
        fun media(): MediaService.WithRawResponse

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
         * Returns a raw HTTP response for `get /x/communities/find`, but is otherwise the same as
         * [CommunityService.find].
         */
        @MustBeClosed
        fun find(params: CommunityFindParams): HttpResponseFor<CommunityPage> =
            find(params, RequestOptions.none())

        /** @see find */
        @MustBeClosed
        fun find(
            params: CommunityFindParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityPage>

        /**
         * Returns a raw HTTP response for `get /x/communities/popular`, but is otherwise the same
         * as [CommunityService.listPopular].
         */
        @MustBeClosed
        fun listPopular(): HttpResponseFor<CommunityPage> =
            listPopular(CommunityListPopularParams.none())

        /** @see listPopular */
        @MustBeClosed
        fun listPopular(
            params: CommunityListPopularParams = CommunityListPopularParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityPage>

        /** @see listPopular */
        @MustBeClosed
        fun listPopular(
            params: CommunityListPopularParams = CommunityListPopularParams.none()
        ): HttpResponseFor<CommunityPage> = listPopular(params, RequestOptions.none())

        /** @see listPopular */
        @MustBeClosed
        fun listPopular(requestOptions: RequestOptions): HttpResponseFor<CommunityPage> =
            listPopular(CommunityListPopularParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/suggested`, but is otherwise the same
         * as [CommunityService.listSuggested].
         */
        @MustBeClosed
        fun listSuggested(): HttpResponseFor<CommunityListSuggestedResponse> =
            listSuggested(CommunityListSuggestedParams.none())

        /** @see listSuggested */
        @MustBeClosed
        fun listSuggested(
            params: CommunityListSuggestedParams = CommunityListSuggestedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityListSuggestedResponse>

        /** @see listSuggested */
        @MustBeClosed
        fun listSuggested(
            params: CommunityListSuggestedParams = CommunityListSuggestedParams.none()
        ): HttpResponseFor<CommunityListSuggestedResponse> =
            listSuggested(params, RequestOptions.none())

        /** @see listSuggested */
        @MustBeClosed
        fun listSuggested(
            requestOptions: RequestOptions
        ): HttpResponseFor<CommunityListSuggestedResponse> =
            listSuggested(CommunityListSuggestedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/topics`, but is otherwise the same as
         * [CommunityService.listTopics].
         */
        @MustBeClosed
        fun listTopics(): HttpResponseFor<CommunityListTopicsResponse> =
            listTopics(CommunityListTopicsParams.none())

        /** @see listTopics */
        @MustBeClosed
        fun listTopics(
            params: CommunityListTopicsParams = CommunityListTopicsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityListTopicsResponse>

        /** @see listTopics */
        @MustBeClosed
        fun listTopics(
            params: CommunityListTopicsParams = CommunityListTopicsParams.none()
        ): HttpResponseFor<CommunityListTopicsResponse> = listTopics(params, RequestOptions.none())

        /** @see listTopics */
        @MustBeClosed
        fun listTopics(
            requestOptions: RequestOptions
        ): HttpResponseFor<CommunityListTopicsResponse> =
            listTopics(CommunityListTopicsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/analytics`, but is otherwise the
         * same as [CommunityService.retrieveAnalytics].
         */
        @MustBeClosed
        fun retrieveAnalytics(id: String): HttpResponseFor<CommunityAnalytics> =
            retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none())

        /** @see retrieveAnalytics */
        @MustBeClosed
        fun retrieveAnalytics(
            id: String,
            params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityAnalytics> =
            retrieveAnalytics(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveAnalytics */
        @MustBeClosed
        fun retrieveAnalytics(
            id: String,
            params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
        ): HttpResponseFor<CommunityAnalytics> =
            retrieveAnalytics(id, params, RequestOptions.none())

        /** @see retrieveAnalytics */
        @MustBeClosed
        fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityAnalytics>

        /** @see retrieveAnalytics */
        @MustBeClosed
        fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams
        ): HttpResponseFor<CommunityAnalytics> = retrieveAnalytics(params, RequestOptions.none())

        /** @see retrieveAnalytics */
        @MustBeClosed
        fun retrieveAnalytics(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityAnalytics> =
            retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/members/search`, but is
         * otherwise the same as [CommunityService.searchMembers].
         */
        @MustBeClosed
        fun searchMembers(
            id: String,
            params: CommunitySearchMembersParams,
        ): HttpResponseFor<PaginatedUsers> = searchMembers(id, params, RequestOptions.none())

        /** @see searchMembers */
        @MustBeClosed
        fun searchMembers(
            id: String,
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            searchMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see searchMembers */
        @MustBeClosed
        fun searchMembers(params: CommunitySearchMembersParams): HttpResponseFor<PaginatedUsers> =
            searchMembers(params, RequestOptions.none())

        /** @see searchMembers */
        @MustBeClosed
        fun searchMembers(
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>
    }
}
