// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

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
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeResponse
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
class StyleServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StyleService {

    private val withRawResponse: StyleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StyleService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService =
        StyleServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: StyleListParams, requestOptions: RequestOptions): StyleListResponse =
        // get /styles
        withRawResponse().list(params, requestOptions).parse()

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
    }
}
