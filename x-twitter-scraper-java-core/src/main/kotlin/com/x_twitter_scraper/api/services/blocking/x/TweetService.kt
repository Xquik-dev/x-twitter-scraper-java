// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.services.blocking.x.tweets.LikeService
import com.x_twitter_scraper.api.services.blocking.x.tweets.RetweetService
import java.util.function.Consumer

interface TweetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService

    /** X write actions (tweets, likes, follows, DMs) */
    fun like(): LikeService

    /** X write actions (tweets, likes, follows, DMs) */
    fun retweet(): RetweetService

    /** Create tweet */
    fun create(params: TweetCreateParams): TweetCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetCreateResponse

    /** Get tweet with full text, author, metrics & media */
    fun retrieve(id: String): TweetRetrieveResponse = retrieve(id, TweetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
    ): TweetRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TweetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: TweetRetrieveParams): TweetRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): TweetRetrieveResponse =
        retrieve(id, TweetRetrieveParams.none(), requestOptions)

    /** Get multiple tweets by IDs */
    fun list(params: TweetListParams): PaginatedTweets = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** Delete tweet */
    fun delete(id: String, params: TweetDeleteParams): TweetDeleteResponse =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: TweetDeleteParams): TweetDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetDeleteResponse

    /** List users who liked a tweet */
    fun getFavoriters(id: String): PaginatedUsers =
        getFavoriters(id, TweetGetFavoritersParams.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = getFavoriters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
    ): PaginatedUsers = getFavoriters(id, params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see getFavoriters */
    fun getFavoriters(params: TweetGetFavoritersParams): PaginatedUsers =
        getFavoriters(params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(id: String, requestOptions: RequestOptions): PaginatedUsers =
        getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

    /** List quote tweets of a tweet */
    fun getQuotes(id: String): PaginatedTweets = getQuotes(id, TweetGetQuotesParams.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getQuotes(params.toBuilder().id(id).build(), requestOptions)

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
    ): PaginatedTweets = getQuotes(id, params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getQuotes */
    fun getQuotes(params: TweetGetQuotesParams): PaginatedTweets =
        getQuotes(params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

    /** List replies to a tweet */
    fun getReplies(id: String): PaginatedTweets = getReplies(id, TweetGetRepliesParams.none())

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
    ): PaginatedTweets = getReplies(id, params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(
        params: TweetGetRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getReplies */
    fun getReplies(params: TweetGetRepliesParams): PaginatedTweets =
        getReplies(params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getReplies(id, TweetGetRepliesParams.none(), requestOptions)

    /** List users who retweeted a tweet */
    fun getRetweeters(id: String): PaginatedUsers =
        getRetweeters(id, TweetGetRetweetersParams.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = getRetweeters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
    ): PaginatedUsers = getRetweeters(id, params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see getRetweeters */
    fun getRetweeters(params: TweetGetRetweetersParams): PaginatedUsers =
        getRetweeters(params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(id: String, requestOptions: RequestOptions): PaginatedUsers =
        getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

    /** Get full conversation thread for a tweet */
    fun getThread(id: String): PaginatedTweets = getThread(id, TweetGetThreadParams.none())

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getThread(params.toBuilder().id(id).build(), requestOptions)

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
    ): PaginatedTweets = getThread(id, params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getThread */
    fun getThread(params: TweetGetThreadParams): PaginatedTweets =
        getThread(params, RequestOptions.none())

    /** @see getThread */
    fun getThread(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getThread(id, TweetGetThreadParams.none(), requestOptions)

    /** Search tweets with X query operators & pagination */
    fun search(params: TweetSearchParams): PaginatedTweets = search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** A view of [TweetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun like(): LikeService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun retweet(): RetweetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets`, but is otherwise the same as
         * [TweetService.create].
         */
        @MustBeClosed
        fun create(params: TweetCreateParams): HttpResponseFor<TweetCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetCreateResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}`, but is otherwise the same as
         * [TweetService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(id, TweetRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
        ): HttpResponseFor<TweetRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TweetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TweetRetrieveParams): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(id, TweetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets`, but is otherwise the same as
         * [TweetService.list].
         */
        @MustBeClosed
        fun list(params: TweetListParams): HttpResponseFor<PaginatedTweets> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}`, but is otherwise the same as
         * [TweetService.delete].
         */
        @MustBeClosed
        fun delete(id: String, params: TweetDeleteParams): HttpResponseFor<TweetDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: TweetDeleteParams): HttpResponseFor<TweetDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetDeleteResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/favoriters`, but is otherwise the
         * same as [TweetService.getFavoriters].
         */
        @MustBeClosed
        fun getFavoriters(id: String): HttpResponseFor<PaginatedUsers> =
            getFavoriters(id, TweetGetFavoritersParams.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            getFavoriters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = getFavoriters(id, params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(params: TweetGetFavoritersParams): HttpResponseFor<PaginatedUsers> =
            getFavoriters(params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/quotes`, but is otherwise the same as
         * [TweetService.getQuotes].
         */
        @MustBeClosed
        fun getQuotes(id: String): HttpResponseFor<PaginatedTweets> =
            getQuotes(id, TweetGetQuotesParams.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getQuotes(params.toBuilder().id(id).build(), requestOptions)

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getQuotes(id, params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(params: TweetGetQuotesParams): HttpResponseFor<PaginatedTweets> =
            getQuotes(params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/replies`, but is otherwise the same
         * as [TweetService.getReplies].
         */
        @MustBeClosed
        fun getReplies(id: String): HttpResponseFor<PaginatedTweets> =
            getReplies(id, TweetGetRepliesParams.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getReplies(id, params, RequestOptions.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            params: TweetGetRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(params: TweetGetRepliesParams): HttpResponseFor<PaginatedTweets> =
            getReplies(params, RequestOptions.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getReplies(id, TweetGetRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters`, but is otherwise the
         * same as [TweetService.getRetweeters].
         */
        @MustBeClosed
        fun getRetweeters(id: String): HttpResponseFor<PaginatedUsers> =
            getRetweeters(id, TweetGetRetweetersParams.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            getRetweeters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = getRetweeters(id, params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(params: TweetGetRetweetersParams): HttpResponseFor<PaginatedUsers> =
            getRetweeters(params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/thread`, but is otherwise the same as
         * [TweetService.getThread].
         */
        @MustBeClosed
        fun getThread(id: String): HttpResponseFor<PaginatedTweets> =
            getThread(id, TweetGetThreadParams.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getThread(params.toBuilder().id(id).build(), requestOptions)

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getThread(id, params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getThread */
        @MustBeClosed
        fun getThread(params: TweetGetThreadParams): HttpResponseFor<PaginatedTweets> =
            getThread(params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getThread(id, TweetGetThreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/search`, but is otherwise the same as
         * [TweetService.search].
         */
        @MustBeClosed
        fun search(params: TweetSearchParams): HttpResponseFor<PaginatedTweets> =
            search(params, RequestOptions.none())

        /** @see search */
        @MustBeClosed
        fun search(
            params: TweetSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>
    }
}
