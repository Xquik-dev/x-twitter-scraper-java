// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    /** Get bookmarked tweets */
    fun list(): CompletableFuture<PaginatedTweets> = list(BookmarkListParams.none())

    /** @see list */
    fun list(
        params: BookmarkListParams = BookmarkListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see list */
    fun list(
        params: BookmarkListParams = BookmarkListParams.none()
    ): CompletableFuture<PaginatedTweets> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        list(BookmarkListParams.none(), requestOptions)

    /** Get bookmark folders */
    fun retrieveFolders(): CompletableFuture<BookmarkRetrieveFoldersResponse> =
        retrieveFolders(BookmarkRetrieveFoldersParams.none())

    /** @see retrieveFolders */
    fun retrieveFolders(
        params: BookmarkRetrieveFoldersParams = BookmarkRetrieveFoldersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BookmarkRetrieveFoldersResponse>

    /** @see retrieveFolders */
    fun retrieveFolders(
        params: BookmarkRetrieveFoldersParams = BookmarkRetrieveFoldersParams.none()
    ): CompletableFuture<BookmarkRetrieveFoldersResponse> =
        retrieveFolders(params, RequestOptions.none())

    /** @see retrieveFolders */
    fun retrieveFolders(
        requestOptions: RequestOptions
    ): CompletableFuture<BookmarkRetrieveFoldersResponse> =
        retrieveFolders(BookmarkRetrieveFoldersParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /x/bookmarks`, but is otherwise the same as
         * [BookmarkServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(BookmarkListParams.none())

        /** @see list */
        fun list(
            params: BookmarkListParams = BookmarkListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see list */
        fun list(
            params: BookmarkListParams = BookmarkListParams.none()
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(BookmarkListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/bookmarks/folders`, but is otherwise the same as
         * [BookmarkServiceAsync.retrieveFolders].
         */
        fun retrieveFolders(): CompletableFuture<HttpResponseFor<BookmarkRetrieveFoldersResponse>> =
            retrieveFolders(BookmarkRetrieveFoldersParams.none())

        /** @see retrieveFolders */
        fun retrieveFolders(
            params: BookmarkRetrieveFoldersParams = BookmarkRetrieveFoldersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BookmarkRetrieveFoldersResponse>>

        /** @see retrieveFolders */
        fun retrieveFolders(
            params: BookmarkRetrieveFoldersParams = BookmarkRetrieveFoldersParams.none()
        ): CompletableFuture<HttpResponseFor<BookmarkRetrieveFoldersResponse>> =
            retrieveFolders(params, RequestOptions.none())

        /** @see retrieveFolders */
        fun retrieveFolders(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BookmarkRetrieveFoldersResponse>> =
            retrieveFolders(BookmarkRetrieveFoldersParams.none(), requestOptions)
    }
}
