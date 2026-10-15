// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.checkRequired
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
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Community Notes contributors, their notes, ratings & deleted notes */
class CommunityNoteServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CommunityNoteServiceAsync {

    private val withRawResponse: CommunityNoteServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CommunityNoteServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityNoteServiceAsync =
        CommunityNoteServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listContributorDeletedNotes(
        params: CommunityNoteListContributorDeletedNotesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
        withRawResponse().listContributorDeletedNotes(params, requestOptions).thenApply {
            it.parse()
        }

    override fun listContributorNotes(
        params: CommunityNoteListContributorNotesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        withRawResponse().listContributorNotes(params, requestOptions).thenApply { it.parse() }

    override fun retrieveContributor(
        params: CommunityNoteRetrieveContributorParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        withRawResponse().retrieveContributor(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CommunityNoteServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityNoteServiceAsync.WithRawResponse =
            CommunityNoteServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listContributorDeletedNotesHandler:
            Handler<CommunityNoteListContributorDeletedNotesResponse> =
            jsonHandler<CommunityNoteListContributorDeletedNotesResponse>(clientOptions.jsonMapper)

        override fun listContributorDeletedNotes(
            params: CommunityNoteListContributorDeletedNotesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> {
            checkRequired("alias", params.alias().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "community-notes",
                        "contributors",
                        params._pathParam(0),
                        "deleted-notes",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listContributorDeletedNotesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listContributorNotesHandler:
            Handler<CommunityNoteListContributorNotesResponse> =
            jsonHandler<CommunityNoteListContributorNotesResponse>(clientOptions.jsonMapper)

        override fun listContributorNotes(
            params: CommunityNoteListContributorNotesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> {
            checkRequired("alias", params.alias().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "community-notes",
                        "contributors",
                        params._pathParam(0),
                        "notes",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listContributorNotesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveContributorHandler: Handler<CommunityNoteRetrieveContributorResponse> =
            jsonHandler<CommunityNoteRetrieveContributorResponse>(clientOptions.jsonMapper)

        override fun retrieveContributor(
            params: CommunityNoteRetrieveContributorParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> {
            checkRequired("alias", params.alias().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "community-notes", "contributors", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveContributorHandler.handle(it) }
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
