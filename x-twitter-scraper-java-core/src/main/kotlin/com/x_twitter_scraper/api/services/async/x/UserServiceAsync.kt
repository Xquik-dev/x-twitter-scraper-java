// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsResponse
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersResponse
import com.x_twitter_scraper.api.services.async.x.users.FollowServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    fun follow(): FollowServiceAsync

    /** Get multiple users by IDs */
    fun retrieveBatch(
        params: UserRetrieveBatchParams
    ): CompletableFuture<UserRetrieveBatchResponse> = retrieveBatch(params, RequestOptions.none())

    /** @see retrieveBatch */
    fun retrieveBatch(
        params: UserRetrieveBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveBatchResponse>

    /** Get user followers */
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

    /** Get followers you know for a user */
    fun retrieveFollowersYouKnow(
        id: String
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse> =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse> =
        retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse> =
        retrieveFollowersYouKnow(id, params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse>

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse> =
        retrieveFollowersYouKnow(params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveFollowersYouKnowResponse> =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none(), requestOptions)

    /** Get users this user follows */
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

    /** Get tweets liked by a user */
    fun retrieveLikes(id: String): CompletableFuture<UserRetrieveLikesResponse> =
        retrieveLikes(id, UserRetrieveLikesParams.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveLikesResponse> =
        retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
    ): CompletableFuture<UserRetrieveLikesResponse> =
        retrieveLikes(id, params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        params: UserRetrieveLikesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveLikesResponse>

    /** @see retrieveLikes */
    fun retrieveLikes(
        params: UserRetrieveLikesParams
    ): CompletableFuture<UserRetrieveLikesResponse> = retrieveLikes(params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveLikesResponse> =
        retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

    /** Get media tweets by a user */
    fun retrieveMedia(id: String): CompletableFuture<UserRetrieveMediaResponse> =
        retrieveMedia(id, UserRetrieveMediaParams.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveMediaResponse> =
        retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
    ): CompletableFuture<UserRetrieveMediaResponse> =
        retrieveMedia(id, params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        params: UserRetrieveMediaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveMediaResponse>

    /** @see retrieveMedia */
    fun retrieveMedia(
        params: UserRetrieveMediaParams
    ): CompletableFuture<UserRetrieveMediaResponse> = retrieveMedia(params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveMediaResponse> =
        retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

    /** Get tweets mentioning a user */
    fun retrieveMentions(id: String): CompletableFuture<UserRetrieveMentionsResponse> =
        retrieveMentions(id, UserRetrieveMentionsParams.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveMentionsResponse> =
        retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
    ): CompletableFuture<UserRetrieveMentionsResponse> =
        retrieveMentions(id, params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        params: UserRetrieveMentionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveMentionsResponse>

    /** @see retrieveMentions */
    fun retrieveMentions(
        params: UserRetrieveMentionsParams
    ): CompletableFuture<UserRetrieveMentionsResponse> =
        retrieveMentions(params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveMentionsResponse> =
        retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

    /** Search users by name or username */
    fun retrieveSearch(
        params: UserRetrieveSearchParams
    ): CompletableFuture<UserRetrieveSearchResponse> = retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: UserRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveSearchResponse>

    /** Get recent tweets by a user */
    fun retrieveTweets(id: String): CompletableFuture<UserRetrieveTweetsResponse> =
        retrieveTweets(id, UserRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveTweetsResponse> =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
    ): CompletableFuture<UserRetrieveTweetsResponse> =
        retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: UserRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserRetrieveTweetsResponse>

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: UserRetrieveTweetsParams
    ): CompletableFuture<UserRetrieveTweetsResponse> = retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserRetrieveTweetsResponse> =
        retrieveTweets(id, UserRetrieveTweetsParams.none(), requestOptions)

    /** Get verified followers */
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

        fun follow(): FollowServiceAsync.WithRawResponse

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
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>> =
            retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>> =
            retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>> =
            retrieveFollowersYouKnow(id, params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>>

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>> =
            retrieveFollowersYouKnow(params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        fun retrieveFollowersYouKnow(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveFollowersYouKnowResponse>> =
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
        fun retrieveLikes(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>> =
            retrieveLikes(id, UserRetrieveLikesParams.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>> =
            retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>> =
            retrieveLikes(id, params, RequestOptions.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            params: UserRetrieveLikesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>>

        /** @see retrieveLikes */
        fun retrieveLikes(
            params: UserRetrieveLikesParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>> =
            retrieveLikes(params, RequestOptions.none())

        /** @see retrieveLikes */
        fun retrieveLikes(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveLikesResponse>> =
            retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/media`, but is otherwise the same as
         * [UserServiceAsync.retrieveMedia].
         */
        fun retrieveMedia(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>> =
            retrieveMedia(id, UserRetrieveMediaParams.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>> =
            retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>> =
            retrieveMedia(id, params, RequestOptions.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            params: UserRetrieveMediaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>>

        /** @see retrieveMedia */
        fun retrieveMedia(
            params: UserRetrieveMediaParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>> =
            retrieveMedia(params, RequestOptions.none())

        /** @see retrieveMedia */
        fun retrieveMedia(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveMediaResponse>> =
            retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/mentions`, but is otherwise the same
         * as [UserServiceAsync.retrieveMentions].
         */
        fun retrieveMentions(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>> =
            retrieveMentions(id, UserRetrieveMentionsParams.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>> =
            retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>> =
            retrieveMentions(id, params, RequestOptions.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            params: UserRetrieveMentionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>>

        /** @see retrieveMentions */
        fun retrieveMentions(
            params: UserRetrieveMentionsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>> =
            retrieveMentions(params, RequestOptions.none())

        /** @see retrieveMentions */
        fun retrieveMentions(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveMentionsResponse>> =
            retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/search`, but is otherwise the same as
         * [UserServiceAsync.retrieveSearch].
         */
        fun retrieveSearch(
            params: UserRetrieveSearchParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveSearchResponse>> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        fun retrieveSearch(
            params: UserRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveSearchResponse>>

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/tweets`, but is otherwise the same as
         * [UserServiceAsync.retrieveTweets].
         */
        fun retrieveTweets(
            id: String
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>> =
            retrieveTweets(id, UserRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: UserRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>>

        /** @see retrieveTweets */
        fun retrieveTweets(
            params: UserRetrieveTweetsParams
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserRetrieveTweetsResponse>> =
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
