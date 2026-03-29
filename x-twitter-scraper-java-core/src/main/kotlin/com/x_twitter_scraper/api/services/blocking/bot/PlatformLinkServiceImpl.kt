// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.bot

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
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateResponse
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteResponse
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupResponse
import java.util.function.Consumer

/** Telegram bot service endpoints */
class PlatformLinkServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    PlatformLinkService {

    private val withRawResponse: PlatformLinkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PlatformLinkService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlatformLinkService =
        PlatformLinkServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: PlatformLinkCreateParams,
        requestOptions: RequestOptions,
    ): PlatformLinkCreateResponse =
        // post /bot/platform-links
        withRawResponse().create(params, requestOptions).parse()

    override fun delete(
        params: PlatformLinkDeleteParams,
        requestOptions: RequestOptions,
    ): PlatformLinkDeleteResponse =
        // delete /bot/platform-links
        withRawResponse().delete(params, requestOptions).parse()

    override fun lookup(
        params: PlatformLinkLookupParams,
        requestOptions: RequestOptions,
    ): PlatformLinkLookupResponse =
        // get /bot/platform-links/lookup
        withRawResponse().lookup(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PlatformLinkService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlatformLinkService.WithRawResponse =
            PlatformLinkServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<PlatformLinkCreateResponse> =
            jsonHandler<PlatformLinkCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: PlatformLinkCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PlatformLinkCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("bot", "platform-links")
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

        private val deleteHandler: Handler<PlatformLinkDeleteResponse> =
            jsonHandler<PlatformLinkDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: PlatformLinkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PlatformLinkDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("bot", "platform-links")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val lookupHandler: Handler<PlatformLinkLookupResponse> =
            jsonHandler<PlatformLinkLookupResponse>(clientOptions.jsonMapper)

        override fun lookup(
            params: PlatformLinkLookupParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PlatformLinkLookupResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("bot", "platform-links", "lookup")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { lookupHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
