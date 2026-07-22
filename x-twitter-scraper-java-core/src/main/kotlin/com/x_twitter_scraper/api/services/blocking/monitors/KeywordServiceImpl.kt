// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.monitors

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
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X account monitoring with 1-second checks */
class KeywordServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    KeywordService {

    private val withRawResponse: KeywordService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KeywordService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): KeywordService =
        KeywordServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: KeywordCreateParams,
        requestOptions: RequestOptions,
    ): KeywordCreateResponse =
        // post /monitors/keywords
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: KeywordRetrieveParams,
        requestOptions: RequestOptions,
    ): KeywordRetrieveResponse =
        // get /monitors/keywords/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: KeywordUpdateParams,
        requestOptions: RequestOptions,
    ): KeywordUpdateResponse =
        // patch /monitors/keywords/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: KeywordListParams,
        requestOptions: RequestOptions,
    ): KeywordListResponse =
        // get /monitors/keywords
        withRawResponse().list(params, requestOptions).parse()

    override fun deactivate(
        params: KeywordDeactivateParams,
        requestOptions: RequestOptions,
    ): KeywordDeactivateResponse =
        // delete /monitors/keywords/{id}
        withRawResponse().deactivate(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KeywordService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): KeywordService.WithRawResponse =
            KeywordServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<KeywordCreateResponse> =
            jsonHandler<KeywordCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: KeywordCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<KeywordRetrieveResponse> =
            jsonHandler<KeywordRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: KeywordRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<KeywordUpdateResponse> =
            jsonHandler<KeywordUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: KeywordUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<KeywordListResponse> =
            jsonHandler<KeywordListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: KeywordListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords")
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
            }
        }

        private val deactivateHandler: Handler<KeywordDeactivateResponse> =
            jsonHandler<KeywordDeactivateResponse>(clientOptions.jsonMapper)

        override fun deactivate(
            params: KeywordDeactivateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordDeactivateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deactivateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
