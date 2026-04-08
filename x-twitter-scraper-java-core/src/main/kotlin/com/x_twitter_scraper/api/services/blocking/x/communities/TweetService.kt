// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityPage
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListPage
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    /** Search tweets across all communities */
    fun list(params: TweetListParams): TweetListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetListPage

    /** Get community tweets */
    fun listByCommunity(id: String): TweetListByCommunityPage =
        listByCommunity(id, TweetListByCommunityParams.none())

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetListByCommunityPage = listByCommunity(params.toBuilder().id(id).build(), requestOptions)

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
    ): TweetListByCommunityPage = listByCommunity(id, params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(
        params: TweetListByCommunityParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetListByCommunityPage

    /** @see listByCommunity */
    fun listByCommunity(params: TweetListByCommunityParams): TweetListByCommunityPage =
        listByCommunity(params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(id: String, requestOptions: RequestOptions): TweetListByCommunityPage =
        listByCommunity(id, TweetListByCommunityParams.none(), requestOptions)

    /** A view of [TweetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/communities/tweets`, but is otherwise the same as
         * [TweetService.list].
         */
        @MustBeClosed
        fun list(params: TweetListParams): HttpResponseFor<TweetListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetListPage>

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/tweets`, but is otherwise the
         * same as [TweetService.listByCommunity].
         */
        @MustBeClosed
        fun listByCommunity(id: String): HttpResponseFor<TweetListByCommunityPage> =
            listByCommunity(id, TweetListByCommunityParams.none())

        /** @see listByCommunity */
        @MustBeClosed
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetListByCommunityPage> =
            listByCommunity(params.toBuilder().id(id).build(), requestOptions)

        /** @see listByCommunity */
        @MustBeClosed
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        ): HttpResponseFor<TweetListByCommunityPage> =
            listByCommunity(id, params, RequestOptions.none())

        /** @see listByCommunity */
        @MustBeClosed
        fun listByCommunity(
            params: TweetListByCommunityParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetListByCommunityPage>

        /** @see listByCommunity */
        @MustBeClosed
        fun listByCommunity(
            params: TweetListByCommunityParams
        ): HttpResponseFor<TweetListByCommunityPage> =
            listByCommunity(params, RequestOptions.none())

        /** @see listByCommunity */
        @MustBeClosed
        fun listByCommunity(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetListByCommunityPage> =
            listByCommunity(id, TweetListByCommunityParams.none(), requestOptions)
    }
}
