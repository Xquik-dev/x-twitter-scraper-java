// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

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
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.MediaServiceAsync
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

    /** X Community info, members, and tweets */
    fun tweets(): TweetServiceAsync

    /** Find X Communities & read their info, members, posts & media */
    fun media(): MediaServiceAsync

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

    /**
     * Returns the communities X finds for a keyword, in X's order. Each community costs 1 credit.
     * To search the tweets in Communities, use /x/communities/search.
     */
    fun find(params: CommunityFindParams): CompletableFuture<CommunityPage> =
        find(params, RequestOptions.none())

    /** @see find */
    fun find(
        params: CommunityFindParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityPage>

    /**
     * Returns the communities X ranks highest under a topic or subtopic. Name it by topicId or by
     * topic name from /x/communities/topics. Each community costs 1 credit. A missing or unknown
     * topic returns invalid_community_topic & lists the topic names.
     */
    fun listPopular(): CompletableFuture<CommunityPage> =
        listPopular(CommunityListPopularParams.none())

    /** @see listPopular */
    fun listPopular(
        params: CommunityListPopularParams = CommunityListPopularParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityPage>

    /** @see listPopular */
    fun listPopular(
        params: CommunityListPopularParams = CommunityListPopularParams.none()
    ): CompletableFuture<CommunityPage> = listPopular(params, RequestOptions.none())

    /** @see listPopular */
    fun listPopular(requestOptions: RequestOptions): CompletableFuture<CommunityPage> =
        listPopular(CommunityListPopularParams.none(), requestOptions)

    /**
     * Returns the communities X suggests, with their full public fields. X picks them per request,
     * so 2 calls can differ. If X suggests none, Xquik asks up to 2 more times. An empty list is
     * free. Each community costs 1 credit.
     */
    fun listSuggested(): CompletableFuture<CommunityListSuggestedResponse> =
        listSuggested(CommunityListSuggestedParams.none())

    /** @see listSuggested */
    fun listSuggested(
        params: CommunityListSuggestedParams = CommunityListSuggestedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityListSuggestedResponse>

    /** @see listSuggested */
    fun listSuggested(
        params: CommunityListSuggestedParams = CommunityListSuggestedParams.none()
    ): CompletableFuture<CommunityListSuggestedResponse> =
        listSuggested(params, RequestOptions.none())

    /** @see listSuggested */
    fun listSuggested(
        requestOptions: RequestOptions
    ): CompletableFuture<CommunityListSuggestedResponse> =
        listSuggested(CommunityListSuggestedParams.none(), requestOptions)

    /**
     * Returns the community topics with their subtopics. Pass an ID as topicId, or a name as topic,
     * to /x/communities/popular. Each top-level topic costs 1 credit, its subtopics included.
     */
    fun listTopics(): CompletableFuture<CommunityListTopicsResponse> =
        listTopics(CommunityListTopicsParams.none())

    /** @see listTopics */
    fun listTopics(
        params: CommunityListTopicsParams = CommunityListTopicsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityListTopicsResponse>

    /** @see listTopics */
    fun listTopics(
        params: CommunityListTopicsParams = CommunityListTopicsParams.none()
    ): CompletableFuture<CommunityListTopicsResponse> = listTopics(params, RequestOptions.none())

    /** @see listTopics */
    fun listTopics(requestOptions: RequestOptions): CompletableFuture<CommunityListTopicsResponse> =
        listTopics(CommunityListTopicsParams.none(), requestOptions)

    /** Read community activity for X's latest period. Each request costs 1 credit. */
    fun retrieveAnalytics(id: String): CompletableFuture<CommunityAnalytics> =
        retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        id: String,
        params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityAnalytics> =
        retrieveAnalytics(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        id: String,
        params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
    ): CompletableFuture<CommunityAnalytics> = retrieveAnalytics(id, params, RequestOptions.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        params: CommunityRetrieveAnalyticsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityAnalytics>

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        params: CommunityRetrieveAnalyticsParams
    ): CompletableFuture<CommunityAnalytics> = retrieveAnalytics(params, RequestOptions.none())

    /** @see retrieveAnalytics */
    fun retrieveAnalytics(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityAnalytics> =
        retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none(), requestOptions)

    /** Get community name, description and member count */
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

    /** List members of a community */
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

    /** List moderators of a community */
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

    /** Returns tweets, not community records. Requires a Community ID. */
    fun retrieveSearch(params: CommunityRetrieveSearchParams): CompletableFuture<PaginatedTweets> =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /**
     * Finds a community's members by name or username, as the search box on X's members page does.
     * X checks up to 10 accounts that match, & the answer holds the members among them, each with
     * its role. Each member costs 1 credit. An answer without members is free.
     */
    fun searchMembers(
        id: String,
        params: CommunitySearchMembersParams,
    ): CompletableFuture<PaginatedUsers> = searchMembers(id, params, RequestOptions.none())

    /** @see searchMembers */
    fun searchMembers(
        id: String,
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        searchMembers(params.toBuilder().id(id).build(), requestOptions)

    /** @see searchMembers */
    fun searchMembers(params: CommunitySearchMembersParams): CompletableFuture<PaginatedUsers> =
        searchMembers(params, RequestOptions.none())

    /** @see searchMembers */
    fun searchMembers(
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

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

        /** X Community info, members, and tweets */
        fun tweets(): TweetServiceAsync.WithRawResponse

        /** Find X Communities & read their info, members, posts & media */
        fun media(): MediaServiceAsync.WithRawResponse

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
         * Returns a raw HTTP response for `get /x/communities/find`, but is otherwise the same as
         * [CommunityServiceAsync.find].
         */
        fun find(params: CommunityFindParams): CompletableFuture<HttpResponseFor<CommunityPage>> =
            find(params, RequestOptions.none())

        /** @see find */
        fun find(
            params: CommunityFindParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityPage>>

        /**
         * Returns a raw HTTP response for `get /x/communities/popular`, but is otherwise the same
         * as [CommunityServiceAsync.listPopular].
         */
        fun listPopular(): CompletableFuture<HttpResponseFor<CommunityPage>> =
            listPopular(CommunityListPopularParams.none())

        /** @see listPopular */
        fun listPopular(
            params: CommunityListPopularParams = CommunityListPopularParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityPage>>

        /** @see listPopular */
        fun listPopular(
            params: CommunityListPopularParams = CommunityListPopularParams.none()
        ): CompletableFuture<HttpResponseFor<CommunityPage>> =
            listPopular(params, RequestOptions.none())

        /** @see listPopular */
        fun listPopular(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CommunityPage>> =
            listPopular(CommunityListPopularParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/suggested`, but is otherwise the same
         * as [CommunityServiceAsync.listSuggested].
         */
        fun listSuggested(): CompletableFuture<HttpResponseFor<CommunityListSuggestedResponse>> =
            listSuggested(CommunityListSuggestedParams.none())

        /** @see listSuggested */
        fun listSuggested(
            params: CommunityListSuggestedParams = CommunityListSuggestedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityListSuggestedResponse>>

        /** @see listSuggested */
        fun listSuggested(
            params: CommunityListSuggestedParams = CommunityListSuggestedParams.none()
        ): CompletableFuture<HttpResponseFor<CommunityListSuggestedResponse>> =
            listSuggested(params, RequestOptions.none())

        /** @see listSuggested */
        fun listSuggested(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CommunityListSuggestedResponse>> =
            listSuggested(CommunityListSuggestedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/communities/topics`, but is otherwise the same as
         * [CommunityServiceAsync.listTopics].
         */
        fun listTopics(): CompletableFuture<HttpResponseFor<CommunityListTopicsResponse>> =
            listTopics(CommunityListTopicsParams.none())

        /** @see listTopics */
        fun listTopics(
            params: CommunityListTopicsParams = CommunityListTopicsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityListTopicsResponse>>

        /** @see listTopics */
        fun listTopics(
            params: CommunityListTopicsParams = CommunityListTopicsParams.none()
        ): CompletableFuture<HttpResponseFor<CommunityListTopicsResponse>> =
            listTopics(params, RequestOptions.none())

        /** @see listTopics */
        fun listTopics(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CommunityListTopicsResponse>> =
            listTopics(CommunityListTopicsParams.none(), requestOptions)

        /** Read community analytics with its raw HTTP response. */
        fun retrieveAnalytics(id: String): CompletableFuture<HttpResponseFor<CommunityAnalytics>> =
            retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none())

        /** @see retrieveAnalytics */
        fun retrieveAnalytics(
            id: String,
            params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>> =
            retrieveAnalytics(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveAnalytics */
        fun retrieveAnalytics(
            id: String,
            params: CommunityRetrieveAnalyticsParams = CommunityRetrieveAnalyticsParams.none(),
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>> =
            retrieveAnalytics(id, params, RequestOptions.none())

        /** @see retrieveAnalytics */
        fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>>

        /** @see retrieveAnalytics */
        fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>> =
            retrieveAnalytics(params, RequestOptions.none())

        /** @see retrieveAnalytics */
        fun retrieveAnalytics(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>> =
            retrieveAnalytics(id, CommunityRetrieveAnalyticsParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/members/search`, but is
         * otherwise the same as [CommunityServiceAsync.searchMembers].
         */
        fun searchMembers(
            id: String,
            params: CommunitySearchMembersParams,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            searchMembers(id, params, RequestOptions.none())

        /** @see searchMembers */
        fun searchMembers(
            id: String,
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            searchMembers(params.toBuilder().id(id).build(), requestOptions)

        /** @see searchMembers */
        fun searchMembers(
            params: CommunitySearchMembersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            searchMembers(params, RequestOptions.none())

        /** @see searchMembers */
        fun searchMembers(
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>
    }
}
