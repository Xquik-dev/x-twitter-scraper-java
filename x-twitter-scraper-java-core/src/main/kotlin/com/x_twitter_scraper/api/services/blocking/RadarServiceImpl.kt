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
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsResponse
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
class RadarServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RadarService {

    private val withRawResponse: RadarService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RadarService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RadarService =
        RadarServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveTrendingTopics(
        params: RadarRetrieveTrendingTopicsParams,
        requestOptions: RequestOptions,
    ): RadarRetrieveTrendingTopicsResponse =
        // get /radar
        withRawResponse().retrieveTrendingTopics(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RadarService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RadarService.WithRawResponse =
            RadarServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveTrendingTopicsHandler: Handler<RadarRetrieveTrendingTopicsResponse> =
            jsonHandler<RadarRetrieveTrendingTopicsResponse>(clientOptions.jsonMapper)

        override fun retrieveTrendingTopics(
            params: RadarRetrieveTrendingTopicsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RadarRetrieveTrendingTopicsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("radar")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveTrendingTopicsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
