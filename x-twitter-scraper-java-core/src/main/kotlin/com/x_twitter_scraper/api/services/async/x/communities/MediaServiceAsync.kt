// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.communities.media.MediaListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Find X Communities & read their info, members, posts & media */
interface MediaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MediaServiceAsync

    /**
     * Returns the tweets with photos or videos on 1 community's Media tab, newest first. Each tweet
     * costs 1 credit.
     */
    fun list(id: String): CompletableFuture<PaginatedTweets> = list(id, MediaListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: MediaListParams = MediaListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: MediaListParams = MediaListParams.none(),
    ): CompletableFuture<PaginatedTweets> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MediaListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see list */
    fun list(params: MediaListParams): CompletableFuture<PaginatedTweets> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        list(id, MediaListParams.none(), requestOptions)

    /** A view of [MediaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MediaServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/media`, but is otherwise the
         * same as [MediaServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(id, MediaListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: MediaListParams = MediaListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: MediaListParams = MediaListParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: MediaListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see list */
        fun list(params: MediaListParams): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(id, MediaListParams.none(), requestOptions)
    }
}
