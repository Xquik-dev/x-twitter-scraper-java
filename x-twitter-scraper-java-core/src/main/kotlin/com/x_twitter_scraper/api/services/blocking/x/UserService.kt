// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
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
import com.x_twitter_scraper.api.services.blocking.x.users.FollowService
import java.util.function.Consumer

/** X data lookups (subscription required) */
interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService

    fun follow(): FollowService

    /** Get multiple users by IDs */
    fun retrieveBatch(params: UserRetrieveBatchParams): UserRetrieveBatchResponse =
        retrieveBatch(params, RequestOptions.none())

    /** @see retrieveBatch */
    fun retrieveBatch(
        params: UserRetrieveBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveBatchResponse

    /** Get user followers */
    fun retrieveFollowers(id: String): UserRetrieveFollowersResponse =
        retrieveFollowers(id, UserRetrieveFollowersParams.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowersResponse =
        retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
    ): UserRetrieveFollowersResponse = retrieveFollowers(id, params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        params: UserRetrieveFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowersResponse

    /** @see retrieveFollowers */
    fun retrieveFollowers(params: UserRetrieveFollowersParams): UserRetrieveFollowersResponse =
        retrieveFollowers(params, RequestOptions.none())

    /** @see retrieveFollowers */
    fun retrieveFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): UserRetrieveFollowersResponse =
        retrieveFollowers(id, UserRetrieveFollowersParams.none(), requestOptions)

    /** Get followers you know for a user */
    fun retrieveFollowersYouKnow(id: String): UserRetrieveFollowersYouKnowResponse =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowersYouKnowResponse =
        retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
    ): UserRetrieveFollowersYouKnowResponse =
        retrieveFollowersYouKnow(id, params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowersYouKnowResponse

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams
    ): UserRetrieveFollowersYouKnowResponse =
        retrieveFollowersYouKnow(params, RequestOptions.none())

    /** @see retrieveFollowersYouKnow */
    fun retrieveFollowersYouKnow(
        id: String,
        requestOptions: RequestOptions,
    ): UserRetrieveFollowersYouKnowResponse =
        retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none(), requestOptions)

    /** Get users this user follows */
    fun retrieveFollowing(id: String): UserRetrieveFollowingResponse =
        retrieveFollowing(id, UserRetrieveFollowingParams.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowingResponse =
        retrieveFollowing(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
    ): UserRetrieveFollowingResponse = retrieveFollowing(id, params, RequestOptions.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        params: UserRetrieveFollowingParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveFollowingResponse

    /** @see retrieveFollowing */
    fun retrieveFollowing(params: UserRetrieveFollowingParams): UserRetrieveFollowingResponse =
        retrieveFollowing(params, RequestOptions.none())

    /** @see retrieveFollowing */
    fun retrieveFollowing(
        id: String,
        requestOptions: RequestOptions,
    ): UserRetrieveFollowingResponse =
        retrieveFollowing(id, UserRetrieveFollowingParams.none(), requestOptions)

    /** Get tweets liked by a user */
    fun retrieveLikes(id: String): UserRetrieveLikesResponse =
        retrieveLikes(id, UserRetrieveLikesParams.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveLikesResponse = retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveLikes */
    fun retrieveLikes(
        id: String,
        params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
    ): UserRetrieveLikesResponse = retrieveLikes(id, params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(
        params: UserRetrieveLikesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveLikesResponse

    /** @see retrieveLikes */
    fun retrieveLikes(params: UserRetrieveLikesParams): UserRetrieveLikesResponse =
        retrieveLikes(params, RequestOptions.none())

    /** @see retrieveLikes */
    fun retrieveLikes(id: String, requestOptions: RequestOptions): UserRetrieveLikesResponse =
        retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

    /** Get media tweets by a user */
    fun retrieveMedia(id: String): UserRetrieveMediaResponse =
        retrieveMedia(id, UserRetrieveMediaParams.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveMediaResponse = retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMedia */
    fun retrieveMedia(
        id: String,
        params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
    ): UserRetrieveMediaResponse = retrieveMedia(id, params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(
        params: UserRetrieveMediaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveMediaResponse

    /** @see retrieveMedia */
    fun retrieveMedia(params: UserRetrieveMediaParams): UserRetrieveMediaResponse =
        retrieveMedia(params, RequestOptions.none())

    /** @see retrieveMedia */
    fun retrieveMedia(id: String, requestOptions: RequestOptions): UserRetrieveMediaResponse =
        retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

    /** Get tweets mentioning a user */
    fun retrieveMentions(id: String): UserRetrieveMentionsResponse =
        retrieveMentions(id, UserRetrieveMentionsParams.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveMentionsResponse =
        retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMentions */
    fun retrieveMentions(
        id: String,
        params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
    ): UserRetrieveMentionsResponse = retrieveMentions(id, params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(
        params: UserRetrieveMentionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveMentionsResponse

    /** @see retrieveMentions */
    fun retrieveMentions(params: UserRetrieveMentionsParams): UserRetrieveMentionsResponse =
        retrieveMentions(params, RequestOptions.none())

    /** @see retrieveMentions */
    fun retrieveMentions(id: String, requestOptions: RequestOptions): UserRetrieveMentionsResponse =
        retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

    /** Search users by name or username */
    fun retrieveSearch(params: UserRetrieveSearchParams): UserRetrieveSearchResponse =
        retrieveSearch(params, RequestOptions.none())

    /** @see retrieveSearch */
    fun retrieveSearch(
        params: UserRetrieveSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveSearchResponse

    /** Get recent tweets by a user */
    fun retrieveTweets(id: String): UserRetrieveTweetsResponse =
        retrieveTweets(id, UserRetrieveTweetsParams.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveTweetsResponse =
        retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveTweets */
    fun retrieveTweets(
        id: String,
        params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
    ): UserRetrieveTweetsResponse = retrieveTweets(id, params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(
        params: UserRetrieveTweetsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveTweetsResponse

    /** @see retrieveTweets */
    fun retrieveTweets(params: UserRetrieveTweetsParams): UserRetrieveTweetsResponse =
        retrieveTweets(params, RequestOptions.none())

    /** @see retrieveTweets */
    fun retrieveTweets(id: String, requestOptions: RequestOptions): UserRetrieveTweetsResponse =
        retrieveTweets(id, UserRetrieveTweetsParams.none(), requestOptions)

    /** Get verified followers */
    fun retrieveVerifiedFollowers(id: String): UserRetrieveVerifiedFollowersResponse =
        retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveVerifiedFollowersResponse =
        retrieveVerifiedFollowers(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
    ): UserRetrieveVerifiedFollowersResponse =
        retrieveVerifiedFollowers(id, params, RequestOptions.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        params: UserRetrieveVerifiedFollowersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserRetrieveVerifiedFollowersResponse

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        params: UserRetrieveVerifiedFollowersParams
    ): UserRetrieveVerifiedFollowersResponse =
        retrieveVerifiedFollowers(params, RequestOptions.none())

    /** @see retrieveVerifiedFollowers */
    fun retrieveVerifiedFollowers(
        id: String,
        requestOptions: RequestOptions,
    ): UserRetrieveVerifiedFollowersResponse =
        retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none(), requestOptions)

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService.WithRawResponse

        fun follow(): FollowService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/users/batch`, but is otherwise the same as
         * [UserService.retrieveBatch].
         */
        @MustBeClosed
        fun retrieveBatch(
            params: UserRetrieveBatchParams
        ): HttpResponseFor<UserRetrieveBatchResponse> = retrieveBatch(params, RequestOptions.none())

        /** @see retrieveBatch */
        @MustBeClosed
        fun retrieveBatch(
            params: UserRetrieveBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveBatchResponse>

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/followers`, but is otherwise the same
         * as [UserService.retrieveFollowers].
         */
        @MustBeClosed
        fun retrieveFollowers(id: String): HttpResponseFor<UserRetrieveFollowersResponse> =
            retrieveFollowers(id, UserRetrieveFollowersParams.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowersResponse> =
            retrieveFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            params: UserRetrieveFollowersParams = UserRetrieveFollowersParams.none(),
        ): HttpResponseFor<UserRetrieveFollowersResponse> =
            retrieveFollowers(id, params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: UserRetrieveFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowersResponse>

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            params: UserRetrieveFollowersParams
        ): HttpResponseFor<UserRetrieveFollowersResponse> =
            retrieveFollowers(params, RequestOptions.none())

        /** @see retrieveFollowers */
        @MustBeClosed
        fun retrieveFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveFollowersResponse> =
            retrieveFollowers(id, UserRetrieveFollowersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/followers-you-know`, but is otherwise
         * the same as [UserService.retrieveFollowersYouKnow].
         */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            id: String
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse> =
            retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none())

        /** @see retrieveFollowersYouKnow */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse> =
            retrieveFollowersYouKnow(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowersYouKnow */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            id: String,
            params: UserRetrieveFollowersYouKnowParams = UserRetrieveFollowersYouKnowParams.none(),
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse> =
            retrieveFollowersYouKnow(id, params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse>

        /** @see retrieveFollowersYouKnow */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse> =
            retrieveFollowersYouKnow(params, RequestOptions.none())

        /** @see retrieveFollowersYouKnow */
        @MustBeClosed
        fun retrieveFollowersYouKnow(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveFollowersYouKnowResponse> =
            retrieveFollowersYouKnow(id, UserRetrieveFollowersYouKnowParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/following`, but is otherwise the same
         * as [UserService.retrieveFollowing].
         */
        @MustBeClosed
        fun retrieveFollowing(id: String): HttpResponseFor<UserRetrieveFollowingResponse> =
            retrieveFollowing(id, UserRetrieveFollowingParams.none())

        /** @see retrieveFollowing */
        @MustBeClosed
        fun retrieveFollowing(
            id: String,
            params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowingResponse> =
            retrieveFollowing(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveFollowing */
        @MustBeClosed
        fun retrieveFollowing(
            id: String,
            params: UserRetrieveFollowingParams = UserRetrieveFollowingParams.none(),
        ): HttpResponseFor<UserRetrieveFollowingResponse> =
            retrieveFollowing(id, params, RequestOptions.none())

        /** @see retrieveFollowing */
        @MustBeClosed
        fun retrieveFollowing(
            params: UserRetrieveFollowingParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveFollowingResponse>

        /** @see retrieveFollowing */
        @MustBeClosed
        fun retrieveFollowing(
            params: UserRetrieveFollowingParams
        ): HttpResponseFor<UserRetrieveFollowingResponse> =
            retrieveFollowing(params, RequestOptions.none())

        /** @see retrieveFollowing */
        @MustBeClosed
        fun retrieveFollowing(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveFollowingResponse> =
            retrieveFollowing(id, UserRetrieveFollowingParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/likes`, but is otherwise the same as
         * [UserService.retrieveLikes].
         */
        @MustBeClosed
        fun retrieveLikes(id: String): HttpResponseFor<UserRetrieveLikesResponse> =
            retrieveLikes(id, UserRetrieveLikesParams.none())

        /** @see retrieveLikes */
        @MustBeClosed
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveLikesResponse> =
            retrieveLikes(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveLikes */
        @MustBeClosed
        fun retrieveLikes(
            id: String,
            params: UserRetrieveLikesParams = UserRetrieveLikesParams.none(),
        ): HttpResponseFor<UserRetrieveLikesResponse> =
            retrieveLikes(id, params, RequestOptions.none())

        /** @see retrieveLikes */
        @MustBeClosed
        fun retrieveLikes(
            params: UserRetrieveLikesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveLikesResponse>

        /** @see retrieveLikes */
        @MustBeClosed
        fun retrieveLikes(
            params: UserRetrieveLikesParams
        ): HttpResponseFor<UserRetrieveLikesResponse> = retrieveLikes(params, RequestOptions.none())

        /** @see retrieveLikes */
        @MustBeClosed
        fun retrieveLikes(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveLikesResponse> =
            retrieveLikes(id, UserRetrieveLikesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/media`, but is otherwise the same as
         * [UserService.retrieveMedia].
         */
        @MustBeClosed
        fun retrieveMedia(id: String): HttpResponseFor<UserRetrieveMediaResponse> =
            retrieveMedia(id, UserRetrieveMediaParams.none())

        /** @see retrieveMedia */
        @MustBeClosed
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveMediaResponse> =
            retrieveMedia(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMedia */
        @MustBeClosed
        fun retrieveMedia(
            id: String,
            params: UserRetrieveMediaParams = UserRetrieveMediaParams.none(),
        ): HttpResponseFor<UserRetrieveMediaResponse> =
            retrieveMedia(id, params, RequestOptions.none())

        /** @see retrieveMedia */
        @MustBeClosed
        fun retrieveMedia(
            params: UserRetrieveMediaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveMediaResponse>

        /** @see retrieveMedia */
        @MustBeClosed
        fun retrieveMedia(
            params: UserRetrieveMediaParams
        ): HttpResponseFor<UserRetrieveMediaResponse> = retrieveMedia(params, RequestOptions.none())

        /** @see retrieveMedia */
        @MustBeClosed
        fun retrieveMedia(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveMediaResponse> =
            retrieveMedia(id, UserRetrieveMediaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/mentions`, but is otherwise the same
         * as [UserService.retrieveMentions].
         */
        @MustBeClosed
        fun retrieveMentions(id: String): HttpResponseFor<UserRetrieveMentionsResponse> =
            retrieveMentions(id, UserRetrieveMentionsParams.none())

        /** @see retrieveMentions */
        @MustBeClosed
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveMentionsResponse> =
            retrieveMentions(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMentions */
        @MustBeClosed
        fun retrieveMentions(
            id: String,
            params: UserRetrieveMentionsParams = UserRetrieveMentionsParams.none(),
        ): HttpResponseFor<UserRetrieveMentionsResponse> =
            retrieveMentions(id, params, RequestOptions.none())

        /** @see retrieveMentions */
        @MustBeClosed
        fun retrieveMentions(
            params: UserRetrieveMentionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveMentionsResponse>

        /** @see retrieveMentions */
        @MustBeClosed
        fun retrieveMentions(
            params: UserRetrieveMentionsParams
        ): HttpResponseFor<UserRetrieveMentionsResponse> =
            retrieveMentions(params, RequestOptions.none())

        /** @see retrieveMentions */
        @MustBeClosed
        fun retrieveMentions(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveMentionsResponse> =
            retrieveMentions(id, UserRetrieveMentionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/search`, but is otherwise the same as
         * [UserService.retrieveSearch].
         */
        @MustBeClosed
        fun retrieveSearch(
            params: UserRetrieveSearchParams
        ): HttpResponseFor<UserRetrieveSearchResponse> =
            retrieveSearch(params, RequestOptions.none())

        /** @see retrieveSearch */
        @MustBeClosed
        fun retrieveSearch(
            params: UserRetrieveSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveSearchResponse>

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/tweets`, but is otherwise the same as
         * [UserService.retrieveTweets].
         */
        @MustBeClosed
        fun retrieveTweets(id: String): HttpResponseFor<UserRetrieveTweetsResponse> =
            retrieveTweets(id, UserRetrieveTweetsParams.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveTweetsResponse> =
            retrieveTweets(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            params: UserRetrieveTweetsParams = UserRetrieveTweetsParams.none(),
        ): HttpResponseFor<UserRetrieveTweetsResponse> =
            retrieveTweets(id, params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            params: UserRetrieveTweetsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveTweetsResponse>

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            params: UserRetrieveTweetsParams
        ): HttpResponseFor<UserRetrieveTweetsResponse> =
            retrieveTweets(params, RequestOptions.none())

        /** @see retrieveTweets */
        @MustBeClosed
        fun retrieveTweets(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveTweetsResponse> =
            retrieveTweets(id, UserRetrieveTweetsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/users/{id}/verified-followers`, but is otherwise
         * the same as [UserService.retrieveVerifiedFollowers].
         */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            id: String
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse> =
            retrieveVerifiedFollowers(id, UserRetrieveVerifiedFollowersParams.none())

        /** @see retrieveVerifiedFollowers */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            id: String,
            params: UserRetrieveVerifiedFollowersParams =
                UserRetrieveVerifiedFollowersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse> =
            retrieveVerifiedFollowers(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveVerifiedFollowers */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            id: String,
            params: UserRetrieveVerifiedFollowersParams = UserRetrieveVerifiedFollowersParams.none(),
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse> =
            retrieveVerifiedFollowers(id, params, RequestOptions.none())

        /** @see retrieveVerifiedFollowers */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            params: UserRetrieveVerifiedFollowersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse>

        /** @see retrieveVerifiedFollowers */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            params: UserRetrieveVerifiedFollowersParams
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse> =
            retrieveVerifiedFollowers(params, RequestOptions.none())

        /** @see retrieveVerifiedFollowers */
        @MustBeClosed
        fun retrieveVerifiedFollowers(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserRetrieveVerifiedFollowersResponse> =
            retrieveVerifiedFollowers(
                id,
                UserRetrieveVerifiedFollowersParams.none(),
                requestOptions,
            )
    }
}
