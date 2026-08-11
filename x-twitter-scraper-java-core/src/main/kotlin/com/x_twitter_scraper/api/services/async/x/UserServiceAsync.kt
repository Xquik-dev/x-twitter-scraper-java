// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerParams
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersResponse
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

    /** Look up multiple users by IDs in one call */
    fun retrieveBatch(
        params: UserRetrieveBatchParams
    ): CompletableFuture<UserRetrieveBatchResponse> = retrieveBatch(params, RequestOptions.none())

    /** @see retrieveBatch */
    fun retrieveBatch(
        params: UserRetrieveBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveBatchResponse>

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
            params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
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
    }
}
