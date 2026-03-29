// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.handlers.emptyHandler
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
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeResponse
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleDeleteParams
import com.x_twitter_scraper.api.models.styles.StyleGetPerformanceParams
import com.x_twitter_scraper.api.models.styles.StyleGetPerformanceResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import com.x_twitter_scraper.api.models.styles.StyleRetrieveParams
import com.x_twitter_scraper.api.models.styles.StyleRetrieveResponse
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Tweet composition, drafts, writing styles & radar */
class StyleServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StyleService {

    private val withRawResponse: StyleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StyleService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService =
        StyleServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: StyleRetrieveParams,
        requestOptions: RequestOptions,
    ): StyleRetrieveResponse =
        // get /styles/{username}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: StyleUpdateParams,
        requestOptions: RequestOptions,
    ): StyleUpdateResponse =
        // put /styles/{username}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: StyleListParams, requestOptions: RequestOptions): StyleListResponse =
        // get /styles
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: StyleDeleteParams, requestOptions: RequestOptions) {
        // delete /styles/{username}
        withRawResponse().delete(params, requestOptions)
    }

    override fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions,
    ): StyleAnalyzeResponse =
        // post /styles
        withRawResponse().analyze(params, requestOptions).parse()

    override fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions,
    ): StyleCompareResponse =
        // get /styles/compare
        withRawResponse().compare(params, requestOptions).parse()

    override fun getPerformance(
        params: StyleGetPerformanceParams,
        requestOptions: RequestOptions,
    ): StyleGetPerformanceResponse =
        // get /styles/{username}/performance
        withRawResponse().getPerformance(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StyleService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StyleService.WithRawResponse =
            StyleServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<StyleRetrieveResponse> =
            jsonHandler<StyleRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: StyleRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("username", params.username().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", params._pathParam(0))
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

        private val updateHandler: Handler<StyleUpdateResponse> =
            jsonHandler<StyleUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: StyleUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("username", params.username().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", params._pathParam(0))
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

        private val listHandler: Handler<StyleListResponse> =
            jsonHandler<StyleListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: StyleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: StyleDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("username", params.username().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val analyzeHandler: Handler<StyleAnalyzeResponse> =
            jsonHandler<StyleAnalyzeResponse>(clientOptions.jsonMapper)

        override fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleAnalyzeResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { analyzeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val compareHandler: Handler<StyleCompareResponse> =
            jsonHandler<StyleCompareResponse>(clientOptions.jsonMapper)

        override fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleCompareResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", "compare")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { compareHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getPerformanceHandler: Handler<StyleGetPerformanceResponse> =
            jsonHandler<StyleGetPerformanceResponse>(clientOptions.jsonMapper)

        override fun getPerformance(
            params: StyleGetPerformanceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleGetPerformanceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("username", params.username().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", params._pathParam(0), "performance")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getPerformanceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
