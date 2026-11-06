// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkCreateParams
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkDeleteResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface BookmarkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BookmarkServiceAsync

    /**
     * Bookmarks a post through a connected X account. Only that account sees its bookmarks, and GET
     * /x/bookmarks lists them.
     */
    fun create(
        id: String,
        params: BookmarkCreateParams,
    ): CompletableFuture<BookmarkCreateResponse> = create(id, params, RequestOptions.none())

    /** @see create */
    fun create(
        id: String,
        params: BookmarkCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BookmarkCreateResponse> =
        create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    fun create(params: BookmarkCreateParams): CompletableFuture<BookmarkCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: BookmarkCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BookmarkCreateResponse>

    /** Removes a bookmark through a connected X account. */
    fun delete(
        id: String,
        params: BookmarkDeleteParams,
    ): CompletableFuture<BookmarkDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: BookmarkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BookmarkDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: BookmarkDeleteParams): CompletableFuture<BookmarkDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: BookmarkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BookmarkDeleteResponse>

    /**
     * A view of [BookmarkServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BookmarkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets/{id}/bookmark`, but is otherwise the same
         * as [BookmarkServiceAsync.create].
         */
        fun create(
            id: String,
            params: BookmarkCreateParams,
        ): CompletableFuture<HttpResponseFor<BookmarkCreateResponse>> =
            create(id, params, RequestOptions.none())

        /** @see create */
        fun create(
            id: String,
            params: BookmarkCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BookmarkCreateResponse>> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        fun create(
            params: BookmarkCreateParams
        ): CompletableFuture<HttpResponseFor<BookmarkCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: BookmarkCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BookmarkCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}/bookmark`, but is otherwise the
         * same as [BookmarkServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: BookmarkDeleteParams,
        ): CompletableFuture<HttpResponseFor<BookmarkDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: BookmarkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BookmarkDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: BookmarkDeleteParams
        ): CompletableFuture<HttpResponseFor<BookmarkDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: BookmarkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BookmarkDeleteResponse>>
    }
}
