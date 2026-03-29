// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

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
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateResponse
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X write actions (tweets, likes, follows, DMs) */
class JoinServiceImpl internal constructor(private val clientOptions: ClientOptions) : JoinService {

    private val withRawResponse: JoinService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): JoinService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): JoinService =
        JoinServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: JoinCreateParams,
        requestOptions: RequestOptions,
    ): JoinCreateResponse =
        // post /x/communities/{id}/join
        withRawResponse().create(params, requestOptions).parse()

    override fun deleteAll(
        params: JoinDeleteAllParams,
        requestOptions: RequestOptions,
    ): JoinDeleteAllResponse =
        // delete /x/communities/{id}/join
        withRawResponse().deleteAll(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        JoinService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): JoinService.WithRawResponse =
            JoinServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<JoinCreateResponse> =
            jsonHandler<JoinCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: JoinCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JoinCreateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "join")
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

        private val deleteAllHandler: Handler<JoinDeleteAllResponse> =
            jsonHandler<JoinDeleteAllResponse>(clientOptions.jsonMapper)

        override fun deleteAll(
            params: JoinDeleteAllParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JoinDeleteAllResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "join")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteAllHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
