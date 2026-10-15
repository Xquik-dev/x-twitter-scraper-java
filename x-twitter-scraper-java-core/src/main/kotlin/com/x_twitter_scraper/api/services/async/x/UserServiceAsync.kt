// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerParams
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveAffiliatesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveArticlesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchTweetsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerIdsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingIdsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveHighlightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveInsightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveInsightsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListMembershipsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListMembershipsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLiveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLiveResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSimilarParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSubscriptionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersResponse
import com.x_twitter_scraper.api.models.x.users.UserTranslateBioParams
import com.x_twitter_scraper.api.models.x.users.UserTranslateBioResponse
import com.x_twitter_scraper.api.services.async.x.users.FollowServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun follow(): FollowServiceAsync

    /** Get user profile with follower counts and verification */
    fun retrieve(id: String): CompletableFuture<UserProfile> =
        retrieve(id, UserRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserProfile> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
    ): CompletableFuture<UserProfile> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserProfile>

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CompletableFuture<UserProfile> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<UserProfile> =
        retrieve(id, UserRetrieveParams.none(), requestOptions)

    /** Remove follower */
    fun removeFollower(
        id: String,
        params: UserRemoveFollowerParams,
    ): CompletableFuture<UserRemoveFollowerResponse> =
        removeFollower(id, params, RequestOptions.none())

    /** @see removeFollower */
    fun removeFollower(
        id: String,
        params: UserRemoveFollowerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRemoveFollowerResponse> =
        removeFollower(params.toBuilder().id(id).build(), requestOptions)

    /** @see removeFollower */
    fun removeFollower(
        params: UserRemoveFollowerParams
    ): CompletableFuture<UserRemoveFollowerResponse> = removeFollower(params, RequestOptions.none())

    /** @see removeFollower */
    fun removeFollower(
        params: UserRemoveFollowerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRemoveFollowerResponse>

    /**
     * Returns the accounts an organization lists as its affiliates, in X's order. An account
     * without affiliates returns an empty list.
     */
    fun retrieveAffiliates(id: String): CompletableFuture<PaginatedUsers> =
        retrieveAffiliates(id, UserRetrieveAffiliatesParams.none())

    /** @see retrieveAffiliates */
    fun retrieveAffiliates(
        id: String,
        params: UserRetrieveAffiliatesParams = UserRetrieveAffiliatesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveAffiliates(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveAffiliates */
    fun retrieveAffiliates(
        id: String,
        params: UserRetrieveAffiliatesParams = UserRetrieveAffiliatesParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveAffiliates(id, params, RequestOptions.none())

    /** @see retrieveAffiliates */
    fun retrieveAffiliates(
        params: UserRetrieveAffiliatesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveAffiliates */
    fun retrieveAffiliates(
        params: UserRetrieveAffiliatesParams
    ): CompletableFuture<PaginatedUsers> = retrieveAffiliates(params, RequestOptions.none())

    /** @see retrieveAffiliates */
    fun retrieveAffiliates(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveAffiliates(id, UserRetrieveAffiliatesParams.none(), requestOptions)

    /**
     * Returns the posts on the user's Articles tab, newest first. Each post's `article` holds the
     * Article's ID, title, preview, cover & dates. Read the full text with GET
     * /x/articles/{tweetId}.
     */
    fun retrieveArticles(id: String): CompletableFuture<PaginatedTweets> =
        retrieveArticles(id, UserRetrieveArticlesParams.none())

    /** @see retrieveArticles */
    fun retrieveArticles(
        id: String,
        params: UserRetrieveArticlesParams = UserRetrieveArticlesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveArticles(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveArticles */
    fun retrieveArticles(
        id: String,
        params: UserRetrieveArticlesParams = UserRetrieveArticlesParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveArticles(id, params, RequestOptions.none())

    /** @see retrieveArticles */
    fun retrieveArticles(
        params: UserRetrieveArticlesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveArticles */
    fun retrieveArticles(params: UserRetrieveArticlesParams): CompletableFuture<PaginatedTweets> =
        retrieveArticles(params, RequestOptions.none())

    /** @see retrieveArticles */
    fun retrieveArticles(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveArticles(id, UserRetrieveArticlesParams.none(), requestOptions)

    /** Look up multiple users by IDs in one call */
    fun retrieveBatch(
        params: UserRetrieveBatchParams
    ): CompletableFuture<UserRetrieveBatchResponse> = retrieveBatch(params, RequestOptions.none())

    /** @see retrieveBatch */
    fun retrieveBatch(
        params: UserRetrieveBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveBatchResponse>

    /**
     * Returns the newest posts of up to 20 users, named by user ID, username or profile link, in
     * the order named. Send ids or usernames, not both. Each post costs 1 credit. A user in
     * unavailable_ids or unprocessed_ids costs nothing.
     */
    fun retrieveBatchTweets(): CompletableFuture<UserRetrieveBatchTweetsResponse> =
        retrieveBatchTweets(UserRetrieveBatchTweetsParams.none())

    /** @see retrieveBatchTweets */
    fun retrieveBatchTweets(
        params: UserRetrieveBatchTweetsParams = UserRetrieveBatchTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveBatchTweetsResponse>

    /** @see retrieveBatchTweets */
    fun retrieveBatchTweets(
        params: UserRetrieveBatchTweetsParams = UserRetrieveBatchTweetsParams.none()
    ): CompletableFuture<UserRetrieveBatchTweetsResponse> =
        retrieveBatchTweets(params, RequestOptions.none())

    /** @see retrieveBatchTweets */
    fun retrieveBatchTweets(
        requestOptions: RequestOptions
    ): CompletableFuture<UserRetrieveBatchTweetsResponse> =
        retrieveBatchTweets(UserRetrieveBatchTweetsParams.none(), requestOptions)

    /**
     * Returns the user IDs of the selected user's followers, newest first, up to 5,000 a page. Use
     * it when you need IDs only. Each ID costs 1 credit.
     */
    fun retrieveFollowerIds(id: String): CompletableFuture<UserRetrieveFollowerIdsResponse> =
        retrieveFollowerIds(id, UserRetrieveFollowerIdsParams.none())

    /** @see retrieveFollowerIds */
    fun retrieveFollowerIds(
        id: String,
        params: UserRetrieveFollowerIdsParams = UserRetrieveFollowerIdsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowerIdsResponse> =
        retrieveFollowerIds(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowerIds */
    fun retrieveFollowerIds(
        id: String,
        params: UserRetrieveFollowerIdsParams = UserRetrieveFollowerIdsParams.none(),
    ): CompletableFuture<UserRetrieveFollowerIdsResponse> =
        retrieveFollowerIds(id, params, RequestOptions.none())

    /** @see retrieveFollowerIds */
    fun retrieveFollowerIds(
        params: UserRetrieveFollowerIdsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowerIdsResponse>

    /** @see retrieveFollowerIds */
    fun retrieveFollowerIds(
        params: UserRetrieveFollowerIdsParams
    ): CompletableFuture<UserRetrieveFollowerIdsResponse> =
        retrieveFollowerIds(params, RequestOptions.none())

    /** @see retrieveFollowerIds */
    fun retrieveFollowerIds(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveFollowerIdsResponse> =
        retrieveFollowerIds(id, UserRetrieveFollowerIdsParams.none(), requestOptions)

    /** List followers of a user */
    fun retrieveFollowers(id: String): CompletableFuture<UserRetrieveFollowersResponse> =
        retrieveFollowers(id, UserRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowersResponse> =
        retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
    ): CompletableFuture<UserRetrieveFollowersResponse> =
        retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: UserRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowersResponse>

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: UserRetrieveFollowersParams
    ): CompletableFuture<UserRetrieveFollowersResponse> =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveFollowersResponse> =
        retrieveFollowers(id, UserRetrieveFollowersParams.none(), requestOptions)

    /** List mutual followers between you and a user */
    fun retrieveFollowersYouKnow(id: String): CompletableFuture<PaginatedUsers> =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveFollowersYouKnow(id, params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams
    ): CompletableFuture<PaginatedUsers> = retrieveFollowersYouKnow(params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none(), requestOptions)

    /** List accounts a user follows */
    fun retrieveFollowing(id: String): CompletableFuture<UserRetrieveFollowingResponse> =
        retrieveFollowing(id, UserRetrieveFollowingParams.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowingResponse> =
        retrieveFollowing(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
    ): CompletableFuture<UserRetrieveFollowingResponse> =
        retrieveFollowing(id, params, RequestOptions.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        params: UserRetrieveFollowingParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowingResponse>

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        params: UserRetrieveFollowingParams
    ): CompletableFuture<UserRetrieveFollowingResponse> =
        retrieveFollowing(params, RequestOptions.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveFollowingResponse> =
        retrieveFollowing(id, UserRetrieveFollowingParams.none(), requestOptions)

    /**
     * Returns the user IDs of the accounts the selected user follows, newest first, up to 5,000 a
     * page. Use it when you need IDs only. Each ID costs 1 credit.
     */
    fun retrieveFollowingIds(id: String): CompletableFuture<UserRetrieveFollowingIdsResponse> =
        retrieveFollowingIds(id, UserRetrieveFollowingIdsParams.none())

    /** @see retrieveFollowingIds */
    fun retrieveFollowingIds(
        id: String,
        params: UserRetrieveFollowingIdsParams = UserRetrieveFollowingIdsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowingIdsResponse> =
        retrieveFollowingIds(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowingIds */
    fun retrieveFollowingIds(
        id: String,
        params: UserRetrieveFollowingIdsParams = UserRetrieveFollowingIdsParams.none(),
    ): CompletableFuture<UserRetrieveFollowingIdsResponse> =
        retrieveFollowingIds(id, params, RequestOptions.none())

    /** @see retrieveFollowingIds */
    fun retrieveFollowingIds(
        params: UserRetrieveFollowingIdsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowingIdsResponse>

    /** @see retrieveFollowingIds */
    fun retrieveFollowingIds(
        params: UserRetrieveFollowingIdsParams
    ): CompletableFuture<UserRetrieveFollowingIdsResponse> =
        retrieveFollowingIds(params, RequestOptions.none())

    /** @see retrieveFollowingIds */
    fun retrieveFollowingIds(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveFollowingIdsResponse> =
        retrieveFollowingIds(id, UserRetrieveFollowingIdsParams.none(), requestOptions)

    /**
     * Returns the posts on the user's Highlights tab, in X's order. An account without highlights
     * returns an empty list.
     */
    fun retrieveHighlights(id: String): CompletableFuture<PaginatedTweets> =
        retrieveHighlights(id, UserRetrieveHighlightsParams.none())

    /** @see retrieveHighlights */
    fun retrieveHighlights(
        id: String,
        params: UserRetrieveHighlightsParams = UserRetrieveHighlightsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveHighlights(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveHighlights */
    fun retrieveHighlights(
        id: String,
        params: UserRetrieveHighlightsParams = UserRetrieveHighlightsParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveHighlights(id, params, RequestOptions.none())

    /** @see retrieveHighlights */
    fun retrieveHighlights(
        params: UserRetrieveHighlightsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveHighlights */
    fun retrieveHighlights(
        params: UserRetrieveHighlightsParams
    ): CompletableFuture<PaginatedTweets> = retrieveHighlights(params, RequestOptions.none())

    /** @see retrieveHighlights */
    fun retrieveHighlights(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveHighlights(id, UserRetrieveHighlightsParams.none(), requestOptions)

    /**
     * Returns engagement insights for 1 profile. They are engagement rate, averages per post and
     * posting rate, from its counts and its last 20 posts. Reposts and the pinned post stay out of
     * the averages. Each report costs 1 credit, whatever it reads.
     */
    fun retrieveInsights(id: String): CompletableFuture<UserRetrieveInsightsResponse> =
        retrieveInsights(id, UserRetrieveInsightsParams.none())

    /** @see retrieveInsights */
    fun retrieveInsights(
        id: String,
        params: UserRetrieveInsightsParams = UserRetrieveInsightsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveInsightsResponse> =
        retrieveInsights(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveInsights */
    fun retrieveInsights(
        id: String,
        params: UserRetrieveInsightsParams = UserRetrieveInsightsParams.none(),
    ): CompletableFuture<UserRetrieveInsightsResponse> =
        retrieveInsights(id, params, RequestOptions.none())

    /** @see retrieveInsights */
    fun retrieveInsights(
        params: UserRetrieveInsightsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveInsightsResponse>

    /** @see retrieveInsights */
    fun retrieveInsights(
        params: UserRetrieveInsightsParams
    ): CompletableFuture<UserRetrieveInsightsResponse> =
        retrieveInsights(params, RequestOptions.none())

    /** @see retrieveInsights */
    fun retrieveInsights(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveInsightsResponse> =
        retrieveInsights(id, UserRetrieveInsightsParams.none(), requestOptions)

    /** List tweets liked by a user */
    fun retrieveLikes(id: String): CompletableFuture<PaginatedTweets> =
        retrieveLikes(id, UserRetrieveLikesParams.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveLikes(id, params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        params: UserRetrieveLikesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveLikes */
    fun retrieveLikes(params: UserRetrieveLikesParams): CompletableFuture<PaginatedTweets> =
        retrieveLikes(params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

    /**
     * Returns the public X Lists that include the selected user, as the profile's List memberships
     * page shows them. Each List costs 1 credit. A protected account answers 403.
     */
    fun retrieveListMemberships(
        id: String
    ): CompletableFuture<UserRetrieveListMembershipsResponse> =
        retrieveListMemberships(id, UserRetrieveListMembershipsParams.none())

    /** @see retrieveListMemberships */
    fun retrieveListMemberships(
        id: String,
        params: UserRetrieveListMembershipsParams = UserRetrieveListMembershipsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveListMembershipsResponse> =
        retrieveListMemberships(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveListMemberships */
    fun retrieveListMemberships(
        id: String,
        params: UserRetrieveListMembershipsParams = UserRetrieveListMembershipsParams.none(),
    ): CompletableFuture<UserRetrieveListMembershipsResponse> =
        retrieveListMemberships(id, params, RequestOptions.none())

    /** @see retrieveListMemberships */
    fun retrieveListMemberships(
        params: UserRetrieveListMembershipsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveListMembershipsResponse>

    /** @see retrieveListMemberships */
    fun retrieveListMemberships(
        params: UserRetrieveListMembershipsParams
    ): CompletableFuture<UserRetrieveListMembershipsResponse> =
        retrieveListMemberships(params, RequestOptions.none())

    /** @see retrieveListMemberships */
    fun retrieveListMemberships(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveListMembershipsResponse> =
        retrieveListMemberships(id, UserRetrieveListMembershipsParams.none(), requestOptions)

    /**
     * Returns the public X Lists the selected user created, in X's order, as the profile's Lists
     * tab shows them. Each List costs 1 credit. A protected account answers 403.
     */
    fun retrieveLists(id: String): CompletableFuture<UserRetrieveListsResponse> =
        retrieveLists(id, UserRetrieveListsParams.none())

    /** @see retrieveLists */
    fun retrieveLists(
        id: String,
        params: UserRetrieveListsParams = UserRetrieveListsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveListsResponse> =
        retrieveLists(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveLists */
    fun retrieveLists(
        id: String,
        params: UserRetrieveListsParams = UserRetrieveListsParams.none(),
    ): CompletableFuture<UserRetrieveListsResponse> =
        retrieveLists(id, params, RequestOptions.none())

    /** @see retrieveLists */
    fun retrieveLists(
        params: UserRetrieveListsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveListsResponse>

    /** @see retrieveLists */
    fun retrieveLists(
        params: UserRetrieveListsParams
    ): CompletableFuture<UserRetrieveListsResponse> = retrieveLists(params, RequestOptions.none())

    /** @see retrieveLists */
    fun retrieveLists(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveListsResponse> =
        retrieveLists(id, UserRetrieveListsParams.none(), requestOptions)

    /**
     * Says whether 1 user is broadcasting live video on X right now, with their latest broadcast,
     * live or ended. Each check costs 1 credit.
     */
    fun retrieveLive(id: String): CompletableFuture<UserRetrieveLiveResponse> =
        retrieveLive(id, UserRetrieveLiveParams.none())

    /** @see retrieveLive */
    fun retrieveLive(
        id: String,
        params: UserRetrieveLiveParams = UserRetrieveLiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveLiveResponse> =
        retrieveLive(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveLive */
    fun retrieveLive(
        id: String,
        params: UserRetrieveLiveParams = UserRetrieveLiveParams.none(),
    ): CompletableFuture<UserRetrieveLiveResponse> = retrieveLive(id, params, RequestOptions.none())

    /** @see retrieveLive */
    fun retrieveLive(
        params: UserRetrieveLiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveLiveResponse>

    /** @see retrieveLive */
    fun retrieveLive(params: UserRetrieveLiveParams): CompletableFuture<UserRetrieveLiveResponse> =
        retrieveLive(params, RequestOptions.none())

    /** @see retrieveLive */
    fun retrieveLive(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveLiveResponse> =
        retrieveLive(id, UserRetrieveLiveParams.none(), requestOptions)

    /** List media tweets posted by a user */
    fun retrieveMedia(id: String): CompletableFuture<PaginatedTweets> =
        retrieveMedia(id, UserRetrieveMediaParams.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveMedia(id, params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        params: UserRetrieveMediaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveMedia */
    fun retrieveMedia(params: UserRetrieveMediaParams): CompletableFuture<PaginatedTweets> =
        retrieveMedia(params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

    /** List tweets mentioning a user */
    fun retrieveMentions(id: String): CompletableFuture<PaginatedTweets> =
        retrieveMentions(id, UserRetrieveMentionsParams.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveMentions(id, params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        params: UserRetrieveMentionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveMentions */
    fun retrieveMentions(params: UserRetrieveMentionsParams): CompletableFuture<PaginatedTweets> =
        retrieveMentions(params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

    /**
     * Returns target-authored posts and replies. Omit mode for automatic maximum coverage. Pass
     * next_cursor unchanged. Unprefixed cursors stay legacy. Excludes other-author context.
     */
    fun retrieveReplies(id: String): CompletableFuture<PaginatedTweets> =
        retrieveReplies(id, UserRetrieveRepliesParams.none())

    /** @see retrieveReplies */
    fun retrieveReplies(
        id: String,
        params: UserRetrieveRepliesParams = UserRetrieveRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveReplies */
    fun retrieveReplies(
        id: String,
        params: UserRetrieveRepliesParams = UserRetrieveRepliesParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveReplies(id, params, RequestOptions.none())

    /** @see retrieveReplies */
    fun retrieveReplies(
        params: UserRetrieveRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveReplies */
    fun retrieveReplies(params: UserRetrieveRepliesParams): CompletableFuture<PaginatedTweets> =
        retrieveReplies(params, RequestOptions.none())

    /** @see retrieveReplies */
    fun retrieveReplies(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveReplies(id, UserRetrieveRepliesParams.none(), requestOptions)

    /** Search users by name or username */
    fun retrieveSearch(params: UserRetrieveSearchParams): CompletableFuture<PaginatedUsers> =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: UserRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /**
     * Returns the public accounts X lists as similar to the selected user, in X's order. X can list
     * slightly different accounts on each call. Each account costs 1 credit.
     */
    fun retrieveSimilar(id: String): CompletableFuture<PaginatedUsers> =
        retrieveSimilar(id, UserRetrieveSimilarParams.none())

    /** @see retrieveSimilar */
    fun retrieveSimilar(
        id: String,
        params: UserRetrieveSimilarParams = UserRetrieveSimilarParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveSimilar(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveSimilar */
    fun retrieveSimilar(
        id: String,
        params: UserRetrieveSimilarParams = UserRetrieveSimilarParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveSimilar(id, params, RequestOptions.none())

    /** @see retrieveSimilar */
    fun retrieveSimilar(
        params: UserRetrieveSimilarParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveSimilar */
    fun retrieveSimilar(params: UserRetrieveSimilarParams): CompletableFuture<PaginatedUsers> =
        retrieveSimilar(params, RequestOptions.none())

    /** @see retrieveSimilar */
    fun retrieveSimilar(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveSimilar(id, UserRetrieveSimilarParams.none(), requestOptions)

    /**
     * Returns the creators the selected user subscribes to, in X's order. An account that hides its
     * subscriptions returns an empty list.
     */
    fun retrieveSubscriptions(id: String): CompletableFuture<PaginatedUsers> =
        retrieveSubscriptions(id, UserRetrieveSubscriptionsParams.none())

    /** @see retrieveSubscriptions */
    fun retrieveSubscriptions(
        id: String,
        params: UserRetrieveSubscriptionsParams = UserRetrieveSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        retrieveSubscriptions(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveSubscriptions */
    fun retrieveSubscriptions(
        id: String,
        params: UserRetrieveSubscriptionsParams = UserRetrieveSubscriptionsParams.none(),
    ): CompletableFuture<PaginatedUsers> = retrieveSubscriptions(id, params, RequestOptions.none())

    /** @see retrieveSubscriptions */
    fun retrieveSubscriptions(
        params: UserRetrieveSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see retrieveSubscriptions */
    fun retrieveSubscriptions(
        params: UserRetrieveSubscriptionsParams
    ): CompletableFuture<PaginatedUsers> = retrieveSubscriptions(params, RequestOptions.none())

    /** @see retrieveSubscriptions */
    fun retrieveSubscriptions(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        retrieveSubscriptions(id, UserRetrieveSubscriptionsParams.none(), requestOptions)

    /**
     * Omit mode for automatic maximum coverage. Pass next_cursor unchanged. Unprefixed cursors use
     * legacy pagination. Shape and billing stay the same.
     */
    fun retrieveTweets(id: String): CompletableFuture<PaginatedTweets> =
        retrieveTweets(id, UserRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
    ): CompletableFuture<PaginatedTweets> = retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: UserRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see retrieveTweets */
    fun retrieveTweets(params: UserRetrieveTweetsParams): CompletableFuture<PaginatedTweets> =
        retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        retrieveTweets(id, UserRetrieveTweetsParams.none(), requestOptions)

    /** List verified followers of a user */
    fun retrieveVerifiedFollowers(
        id: String
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse> =
        retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse> =
        retrieveVerifiedFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse> =
        retrieveVerifiedFollowers(id, params, RequestOptions.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        params: UserRetrieveVerifiedFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse>

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        params: UserRetrieveVerifiedFollowersParams
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse> =
        retrieveVerifiedFollowers(params, RequestOptions.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveVerifiedFollowersResponse> =
        retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none(), requestOptions)

    /**
     * Returns X's own translation of 1 profile's bio into the language you pick, with the links,
     * mentions, and tags X places in the translated text. A profile without a bio returns
     * translation null & a message, free of charge.
     */
    fun translateBio(
        id: String,
        params: UserTranslateBioParams,
    ): CompletableFuture<UserTranslateBioResponse> = translateBio(id, params, RequestOptions.none())

    /** @see translateBio */
    fun translateBio(
        id: String,
        params: UserTranslateBioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserTranslateBioResponse> =
        translateBio(params.toBuilder().id(id).build(), requestOptions)

    /** @see translateBio */
    fun translateBio(params: UserTranslateBioParams): CompletableFuture<UserTranslateBioResponse> =
        translateBio(params, RequestOptions.none())

    /** @see translateBio */
    fun translateBio(
        params: UserTranslateBioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserTranslateBioResponse>

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun follow(): FollowServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/users/{id}`, but is otherwise the same as
         * [UserServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<UserProfile>> =
            retrieve(id, UserRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserProfile>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<UserProfile>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserProfile>>

        /** @see retrieve */
        fun retrieve(params: UserRetrieveParams): CompletableFuture<HttpResponseFor<UserProfile>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserProfile>> =
            retrieve(id, UserRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/users/{id}/remove-follower`, but is otherwise
         * the same as [UserServiceAsync.removeFollower].
         */
        fun removeFollower(
            id: String,
            params: UserRemoveFollowerParams,
        ): CompletableFuture<HttpResponseFor<UserRemoveFollowerResponse>> =
            removeFollower(id, params, RequestOptions.none())

        /** @see removeFollower */
        fun removeFollower(
            id: String,
            params: UserRemoveFollowerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRemoveFollowerResponse>> =
            removeFollower(params.toBuilder().id(id).build(), requestOptions)

        /** @see removeFollower */
        fun removeFollower(
            params: UserRemoveFollowerParams
        ): CompletableFuture<HttpResponseFor<UserRemoveFollowerResponse>> =
            removeFollower(params, RequestOptions.none())

        /** @see removeFollower */
        fun removeFollower(
            params: UserRemoveFollowerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRemoveFollowerResponse>>

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/affiliates`, but is otherwise the same
         * as [UserServiceAsync.retrieveAffiliates].
         */
        fun retrieveAffiliates(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveAffiliates(id, UserRetrieveAffiliatesParams.none())

        /** @see retrieveAffiliates */
        fun retrieveAffiliates(
            id: String,
            params: UserRetrieveAffiliatesParams = UserRetrieveAffiliatesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveAffiliates(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveAffiliates */
        fun retrieveAffiliates(
            id: String,
            params: UserRetrieveAffiliatesParams = UserRetrieveAffiliatesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveAffiliates(id, params, RequestOptions.none())

        /** @see retrieveAffiliates */
        fun retrieveAffiliates(
            params: UserRetrieveAffiliatesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveAffiliates */
        fun retrieveAffiliates(
            params: UserRetrieveAffiliatesParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveAffiliates(params, RequestOptions.none())

        /** @see retrieveAffiliates */
        fun retrieveAffiliates(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveAffiliates(id, UserRetrieveAffiliatesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/articles`, but is otherwise the same
         * as [UserServiceAsync.retrieveArticles].
         */
        fun retrieveArticles(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveArticles(id, UserRetrieveArticlesParams.none())

        /** @see retrieveArticles */
        fun retrieveArticles(
            id: String,
            params: UserRetrieveArticlesParams = UserRetrieveArticlesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveArticles(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveArticles */
        fun retrieveArticles(
            id: String,
            params: UserRetrieveArticlesParams = UserRetrieveArticlesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveArticles(id, params, RequestOptions.none())

        /** @see retrieveArticles */
        fun retrieveArticles(
            params: UserRetrieveArticlesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveArticles */
        fun retrieveArticles(
            params: UserRetrieveArticlesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveArticles(params, RequestOptions.none())

        /** @see retrieveArticles */
        fun retrieveArticles(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveArticles(id, UserRetrieveArticlesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/batch`, but is otherwise the same as
         * [UserServiceAsync.retrieveBatch].
         */
        fun retrieveBatch(
            params: UserRetrieveBatchParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveBatchResponse>> =
            retrieveBatch(params, RequestOptions.none())

        /** @see retrieveBatch */
        fun retrieveBatch(
            params: UserRetrieveBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveBatchResponse>>

        /**
         * Returns a raw HTTP response for `get /x/users/batch/tweets`, but is otherwise the same as
         * [UserServiceAsync.retrieveBatchTweets].
         */
        fun retrieveBatchTweets():
            CompletableFuture<HttpResponseFor<UserRetrieveBatchTweetsResponse>> =
            retrieveBatchTweets(UserRetrieveBatchTweetsParams.none())

        /** @see retrieveBatchTweets */
        fun retrieveBatchTweets(
            params: UserRetrieveBatchTweetsParams = UserRetrieveBatchTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveBatchTweetsResponse>>

        /** @see retrieveBatchTweets */
        fun retrieveBatchTweets(
            params: UserRetrieveBatchTweetsParams = UserRetrieveBatchTweetsParams.none()
        ): CompletableFuture<HttpResponseFor<UserRetrieveBatchTweetsResponse>> =
            retrieveBatchTweets(params, RequestOptions.none())

        /** @see retrieveBatchTweets */
        fun retrieveBatchTweets(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UserRetrieveBatchTweetsResponse>> =
            retrieveBatchTweets(UserRetrieveBatchTweetsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/follower-ids`, but is otherwise the
         * same as [UserServiceAsync.retrieveFollowerIds].
         */
        fun retrieveFollowerIds(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>> =
            retrieveFollowerIds(id, UserRetrieveFollowerIdsParams.none())

        /** @see retrieveFollowerIds */
        fun retrieveFollowerIds(
            id: String,
            params: UserRetrieveFollowerIdsParams = UserRetrieveFollowerIdsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>> =
            retrieveFollowerIds(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowerIds */
        fun retrieveFollowerIds(
            id: String,
            params: UserRetrieveFollowerIdsParams = UserRetrieveFollowerIdsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>> =
            retrieveFollowerIds(id, params, RequestOptions.none())

        /** @see retrieveFollowerIds */
        fun retrieveFollowerIds(
            params: UserRetrieveFollowerIdsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>>

        /** @see retrieveFollowerIds */
        fun retrieveFollowerIds(
            params: UserRetrieveFollowerIdsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>> =
            retrieveFollowerIds(params, RequestOptions.none())

        /** @see retrieveFollowerIds */
        fun retrieveFollowerIds(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowerIdsResponse>> =
            retrieveFollowerIds(id, UserRetrieveFollowerIdsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/followers`, but is otherwise the same
         * as [UserServiceAsync.retrieveFollowers].
         */
        fun retrieveFollowers(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>> =
            retrieveFollowers(id, UserRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>> =
            retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: UserRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>>

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            params: UserRetrieveFollowersParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>> =
            retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersResponse>> =
            retrieveFollowers(id, UserRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/followers-you-know`, but is otherwise
         * the same as [UserServiceAsync.retrieveFollowersYouKnow].
         */
        fun retrieveFollowersYouKnow(
            id: String
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowersYouKnow(id, params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowersYouKnow(params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/following`, but is otherwise the same
         * as [UserServiceAsync.retrieveFollowing].
         */
        fun retrieveFollowing(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>> =
            retrieveFollowing(id, UserRetrieveFollowingParams.none())

        /** @see retrieveFollowing */
        fun retrieveFollowing(
            id: String,
            params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>> =
            retrieveFollowing(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowing */
        fun retrieveFollowing(
            id: String,
            params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>> =
            retrieveFollowing(id, params, RequestOptions.none())

        /** @see retrieveFollowing */
        fun retrieveFollowing(
            params: UserRetrieveFollowingParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>>

        /** @see retrieveFollowing */
        fun retrieveFollowing(
            params: UserRetrieveFollowingParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>> =
            retrieveFollowing(params, RequestOptions.none())

        /** @see retrieveFollowing */
        fun retrieveFollowing(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingResponse>> =
            retrieveFollowing(id, UserRetrieveFollowingParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/following-ids`, but is otherwise the
         * same as [UserServiceAsync.retrieveFollowingIds].
         */
        fun retrieveFollowingIds(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>> =
            retrieveFollowingIds(id, UserRetrieveFollowingIdsParams.none())

        /** @see retrieveFollowingIds */
        fun retrieveFollowingIds(
            id: String,
            params: UserRetrieveFollowingIdsParams = UserRetrieveFollowingIdsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>> =
            retrieveFollowingIds(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowingIds */
        fun retrieveFollowingIds(
            id: String,
            params: UserRetrieveFollowingIdsParams = UserRetrieveFollowingIdsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>> =
            retrieveFollowingIds(id, params, RequestOptions.none())

        /** @see retrieveFollowingIds */
        fun retrieveFollowingIds(
            params: UserRetrieveFollowingIdsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>>

        /** @see retrieveFollowingIds */
        fun retrieveFollowingIds(
            params: UserRetrieveFollowingIdsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>> =
            retrieveFollowingIds(params, RequestOptions.none())

        /** @see retrieveFollowingIds */
        fun retrieveFollowingIds(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowingIdsResponse>> =
            retrieveFollowingIds(id, UserRetrieveFollowingIdsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/highlights`, but is otherwise the same
         * as [UserServiceAsync.retrieveHighlights].
         */
        fun retrieveHighlights(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveHighlights(id, UserRetrieveHighlightsParams.none())

        /** @see retrieveHighlights */
        fun retrieveHighlights(
            id: String,
            params: UserRetrieveHighlightsParams = UserRetrieveHighlightsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveHighlights(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveHighlights */
        fun retrieveHighlights(
            id: String,
            params: UserRetrieveHighlightsParams = UserRetrieveHighlightsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveHighlights(id, params, RequestOptions.none())

        /** @see retrieveHighlights */
        fun retrieveHighlights(
            params: UserRetrieveHighlightsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveHighlights */
        fun retrieveHighlights(
            params: UserRetrieveHighlightsParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveHighlights(params, RequestOptions.none())

        /** @see retrieveHighlights */
        fun retrieveHighlights(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveHighlights(id, UserRetrieveHighlightsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/insights`, but is otherwise the same
         * as [UserServiceAsync.retrieveInsights].
         */
        fun retrieveInsights(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>> =
            retrieveInsights(id, UserRetrieveInsightsParams.none())

        /** @see retrieveInsights */
        fun retrieveInsights(
            id: String,
            params: UserRetrieveInsightsParams = UserRetrieveInsightsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>> =
            retrieveInsights(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveInsights */
        fun retrieveInsights(
            id: String,
            params: UserRetrieveInsightsParams = UserRetrieveInsightsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>> =
            retrieveInsights(id, params, RequestOptions.none())

        /** @see retrieveInsights */
        fun retrieveInsights(
            params: UserRetrieveInsightsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>>

        /** @see retrieveInsights */
        fun retrieveInsights(
            params: UserRetrieveInsightsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>> =
            retrieveInsights(params, RequestOptions.none())

        /** @see retrieveInsights */
        fun retrieveInsights(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveInsightsResponse>> =
            retrieveInsights(id, UserRetrieveInsightsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/likes`, but is otherwise the same as
         * [UserServiceAsync.retrieveLikes].
         */
        fun retrieveLikes(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveLikes(id, UserRetrieveLikesParams.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveLikes(id, params, RequestOptions.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            params: UserRetrieveLikesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveLikes */
        fun retrieveLikes(
            params: UserRetrieveLikesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveLikes(params, RequestOptions.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/list-memberships`, but is otherwise
         * the same as [UserServiceAsync.retrieveListMemberships].
         */
        fun retrieveListMemberships(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>> =
            retrieveListMemberships(id, UserRetrieveListMembershipsParams.none())

        /** @see retrieveListMemberships */
        fun retrieveListMemberships(
            id: String,
            params: UserRetrieveListMembershipsParams = UserRetrieveListMembershipsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>> =
            retrieveListMemberships(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveListMemberships */
        fun retrieveListMemberships(
            id: String,
            params: UserRetrieveListMembershipsParams = UserRetrieveListMembershipsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>> =
            retrieveListMemberships(id, params, RequestOptions.none())

        /** @see retrieveListMemberships */
        fun retrieveListMemberships(
            params: UserRetrieveListMembershipsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>>

        /** @see retrieveListMemberships */
        fun retrieveListMemberships(
            params: UserRetrieveListMembershipsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>> =
            retrieveListMemberships(params, RequestOptions.none())

        /** @see retrieveListMemberships */
        fun retrieveListMemberships(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveListMembershipsResponse>> =
            retrieveListMemberships(id, UserRetrieveListMembershipsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/lists`, but is otherwise the same as
         * [UserServiceAsync.retrieveLists].
         */
        fun retrieveLists(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>> =
            retrieveLists(id, UserRetrieveListsParams.none())

        /** @see retrieveLists */
        fun retrieveLists(
            id: String,
            params: UserRetrieveListsParams = UserRetrieveListsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>> =
            retrieveLists(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveLists */
        fun retrieveLists(
            id: String,
            params: UserRetrieveListsParams = UserRetrieveListsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>> =
            retrieveLists(id, params, RequestOptions.none())

        /** @see retrieveLists */
        fun retrieveLists(
            params: UserRetrieveListsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>>

        /** @see retrieveLists */
        fun retrieveLists(
            params: UserRetrieveListsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>> =
            retrieveLists(params, RequestOptions.none())

        /** @see retrieveLists */
        fun retrieveLists(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveListsResponse>> =
            retrieveLists(id, UserRetrieveListsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/live`, but is otherwise the same as
         * [UserServiceAsync.retrieveLive].
         */
        fun retrieveLive(id: String): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>> =
            retrieveLive(id, UserRetrieveLiveParams.none())

        /** @see retrieveLive */
        fun retrieveLive(
            id: String,
            params: UserRetrieveLiveParams = UserRetrieveLiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>> =
            retrieveLive(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveLive */
        fun retrieveLive(
            id: String,
            params: UserRetrieveLiveParams = UserRetrieveLiveParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>> =
            retrieveLive(id, params, RequestOptions.none())

        /** @see retrieveLive */
        fun retrieveLive(
            params: UserRetrieveLiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>>

        /** @see retrieveLive */
        fun retrieveLive(
            params: UserRetrieveLiveParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>> =
            retrieveLive(params, RequestOptions.none())

        /** @see retrieveLive */
        fun retrieveLive(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveLiveResponse>> =
            retrieveLive(id, UserRetrieveLiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/media`, but is otherwise the same as
         * [UserServiceAsync.retrieveMedia].
         */
        fun retrieveMedia(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMedia(id, UserRetrieveMediaParams.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMedia(id, params, RequestOptions.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            params: UserRetrieveMediaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveMedia */
        fun retrieveMedia(
            params: UserRetrieveMediaParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMedia(params, RequestOptions.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/mentions`, but is otherwise the same
         * as [UserServiceAsync.retrieveMentions].
         */
        fun retrieveMentions(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMentions(id, UserRetrieveMentionsParams.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMentions(id, params, RequestOptions.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            params: UserRetrieveMentionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveMentions */
        fun retrieveMentions(
            params: UserRetrieveMentionsParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMentions(params, RequestOptions.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/replies`, but is otherwise the same as
         * [UserServiceAsync.retrieveReplies].
         */
        fun retrieveReplies(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveReplies(id, UserRetrieveRepliesParams.none())

        /** @see retrieveReplies */
        fun retrieveReplies(
            id: String,
            params: UserRetrieveRepliesParams = UserRetrieveRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveReplies */
        fun retrieveReplies(
            id: String,
            params: UserRetrieveRepliesParams = UserRetrieveRepliesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveReplies(id, params, RequestOptions.none())

        /** @see retrieveReplies */
        fun retrieveReplies(
            params: UserRetrieveRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveReplies */
        fun retrieveReplies(
            params: UserRetrieveRepliesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveReplies(params, RequestOptions.none())

        /** @see retrieveReplies */
        fun retrieveReplies(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveReplies(id, UserRetrieveRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/search`, but is otherwise the same as
         * [UserServiceAsync.retrieveSearch].
         */
        fun retrieveSearch(
            params: UserRetrieveSearchParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        fun retrieveSearch(
            params: UserRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/similar`, but is otherwise the same as
         * [UserServiceAsync.retrieveSimilar].
         */
        fun retrieveSimilar(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSimilar(id, UserRetrieveSimilarParams.none())

        /** @see retrieveSimilar */
        fun retrieveSimilar(
            id: String,
            params: UserRetrieveSimilarParams = UserRetrieveSimilarParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSimilar(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveSimilar */
        fun retrieveSimilar(
            id: String,
            params: UserRetrieveSimilarParams = UserRetrieveSimilarParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSimilar(id, params, RequestOptions.none())

        /** @see retrieveSimilar */
        fun retrieveSimilar(
            params: UserRetrieveSimilarParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveSimilar */
        fun retrieveSimilar(
            params: UserRetrieveSimilarParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSimilar(params, RequestOptions.none())

        /** @see retrieveSimilar */
        fun retrieveSimilar(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSimilar(id, UserRetrieveSimilarParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/subscriptions`, but is otherwise the
         * same as [UserServiceAsync.retrieveSubscriptions].
         */
        fun retrieveSubscriptions(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSubscriptions(id, UserRetrieveSubscriptionsParams.none())

        /** @see retrieveSubscriptions */
        fun retrieveSubscriptions(
            id: String,
            params: UserRetrieveSubscriptionsParams = UserRetrieveSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSubscriptions(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveSubscriptions */
        fun retrieveSubscriptions(
            id: String,
            params: UserRetrieveSubscriptionsParams = UserRetrieveSubscriptionsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSubscriptions(id, params, RequestOptions.none())

        /** @see retrieveSubscriptions */
        fun retrieveSubscriptions(
            params: UserRetrieveSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see retrieveSubscriptions */
        fun retrieveSubscriptions(
            params: UserRetrieveSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSubscriptions(params, RequestOptions.none())

        /** @see retrieveSubscriptions */
        fun retrieveSubscriptions(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            retrieveSubscriptions(id, UserRetrieveSubscriptionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/tweets`, but is otherwise the same as
         * [UserServiceAsync.retrieveTweets].
         */
        fun retrieveTweets(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, UserRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: UserRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: UserRetrieveTweetsParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            retrieveTweets(id, UserRetrieveTweetsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/verified-followers`, but is otherwise
         * the same as [UserServiceAsync.retrieveVerifiedFollowers].
         */
        fun retrieveVerifiedFollowers(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>> =
            retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none())

        /** @see retrieveVerifiedFollowers */
        fun retrieveVerifiedFollowers(
            id: String,
            params: UserRetrieveVerifiedFollowersParams =
                UserRetrieveVerifiedFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>> =
            retrieveVerifiedFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveVerifiedFollowers */
        fun retrieveVerifiedFollowers(
            id: String,
            params: UserRetrieveVerifiedFollowersParams =
                UserRetrieveVerifiedFollowersParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>> =
            retrieveVerifiedFollowers(id, params, RequestOptions.none())

        /** @see retrieveVerifiedFollowers */
        fun retrieveVerifiedFollowers(
            params: UserRetrieveVerifiedFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>>

        /** @see retrieveVerifiedFollowers */
        fun retrieveVerifiedFollowers(
            params: UserRetrieveVerifiedFollowersParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>> =
            retrieveVerifiedFollowers(params, RequestOptions.none())

        /** @see retrieveVerifiedFollowers */
        fun retrieveVerifiedFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveVerifiedFollowersResponse>> =
            retrieveVerifiedFollowers(
                id,
                UserRetrieveVerifiedFollowersParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/translation`, but is otherwise the
         * same as [UserServiceAsync.translateBio].
         */
        fun translateBio(
            id: String,
            params: UserTranslateBioParams,
        ): CompletableFuture<HttpResponseFor<UserTranslateBioResponse>> =
            translateBio(id, params, RequestOptions.none())

        /** @see translateBio */
        fun translateBio(
            id: String,
            params: UserTranslateBioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserTranslateBioResponse>> =
            translateBio(params.toBuilder().id(id).build(), requestOptions)

        /** @see translateBio */
        fun translateBio(
            params: UserTranslateBioParams
        ): CompletableFuture<HttpResponseFor<UserTranslateBioResponse>> =
            translateBio(params, RequestOptions.none())

        /** @see translateBio */
        fun translateBio(
            params: UserTranslateBioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserTranslateBioResponse>>
    }
}
