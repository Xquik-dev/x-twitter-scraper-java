// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListPage
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersParams
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkRetrieveFoldersResponse
import java.util.function.Consumer

/** X data lookups (subscription required) */
class BookmarkServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BookmarkService {

    private val withRawResponse: BookmarkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BookmarkService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BookmarkService =
        BookmarkServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: BookmarkListParams,
        requestOptions: RequestOptions,
    ): BookmarkListPage =
        // get /x/bookmarks
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveFolders(
        params: BookmarkRetrieveFoldersParams,
        requestOptions: RequestOptions,
    ): BookmarkRetrieveFoldersResponse =
        // get /x/bookmarks/folders
        withRawResponse().retrieveFolders(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BookmarkService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BookmarkService.WithRawResponse =
            BookmarkServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun list(
            params: BookmarkListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BookmarkListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "bookmarks")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        BookmarkListPage.builder()
                            .service(BookmarkServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val retrieveFoldersHandler: Handler<BookmarkRetrieveFoldersResponse> =
            jsonHandler<BookmarkRetrieveFoldersResponse>(clientOptions.jsonMapper)

        override fun retrieveFolders(
            params: BookmarkRetrieveFoldersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BookmarkRetrieveFoldersResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "bookmarks", "folders")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
