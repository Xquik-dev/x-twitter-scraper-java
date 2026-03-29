// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryResponse
import com.x_twitter_scraper.api.models.x.dm.DmUpdateParams
import com.x_twitter_scraper.api.models.x.dm.DmUpdateResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DmServiceImpl internal constructor(private val clientOptions: ClientOptions) : DmService {

    private val withRawResponse: DmService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DmService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmService =
        DmServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun update(params: DmUpdateParams, requestOptions: RequestOptions): DmUpdateResponse =
        // post /x/dm/{userId}
        withRawResponse().update(params, requestOptions).parse()

    override fun retrieveHistory(
        params: DmRetrieveHistoryParams,
        requestOptions: RequestOptions,
    ): DmRetrieveHistoryResponse =
        // get /x/dm/{userId}/history
        withRawResponse().retrieveHistory(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DmService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DmService.WithRawResponse =
            DmServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val updateHandler: Handler<DmUpdateResponse> =
            jsonHandler<DmUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: DmUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0))
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

        private val retrieveHistoryHandler: Handler<DmRetrieveHistoryResponse> =
            jsonHandler<DmRetrieveHistoryResponse>(clientOptions.jsonMapper)

        override fun retrieveHistory(
            params: DmRetrieveHistoryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmRetrieveHistoryResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0), "history")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHistoryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
