// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.handlers.errorBodyHandler
import com.x_twitter_scraper.api.core.handlers.errorHandler
import com.x_twitter_scraper.api.core.handlers.jsonHandler
import com.x_twitter_scraper.api.core.http.HttpMethod
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepareAsync
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListResponse
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
class BookmarkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BookmarkServiceAsync {

    private val withRawResponse: BookmarkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BookmarkServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BookmarkServiceAsync =
        BookmarkServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: BookmarkListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BookmarkListResponse> =
        // get /x/bookmarks
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun retrieveFolders(
        params: BookmarkRetrieveFoldersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BookmarkRetrieveFoldersResponse> =
        // get /x/bookmarks/folders
        withRawResponse().retrieveFolders(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BookmarkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BookmarkServiceAsync.WithRawResponse =
            BookmarkServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<BookmarkListResponse> =
            jsonHandler<BookmarkListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: BookmarkListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BookmarkListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "bookmarks")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveFoldersHandler: Handler<BookmarkRetrieveFoldersResponse> =
            jsonHandler<BookmarkRetrieveFoldersResponse>(clientOptions.jsonMapper)

        override fun retrieveFolders(
            params: BookmarkRetrieveFoldersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BookmarkRetrieveFoldersResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "bookmarks", "folders")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveFoldersHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
