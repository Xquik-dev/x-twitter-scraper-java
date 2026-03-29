// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import com.x_twitter_scraper.api.core.prepareAsync
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import com.x_twitter_scraper.api.models.bot.BotTrackUsageResponse
import com.x_twitter_scraper.api.services.async.bot.PlatformLinkServiceAsync
import com.x_twitter_scraper.api.services.async.bot.PlatformLinkServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Telegram bot service endpoints */
class BotServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BotServiceAsync {

    private val withRawResponse: BotServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val platformLinks: PlatformLinkServiceAsync by lazy {
        PlatformLinkServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): BotServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotServiceAsync =
        BotServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Telegram bot service endpoints */
    override fun platformLinks(): PlatformLinkServiceAsync = platformLinks

    override fun trackUsage(
        params: BotTrackUsageParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BotTrackUsageResponse> =
        // post /bot/usage
        withRawResponse().trackUsage(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BotServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val platformLinks: PlatformLinkServiceAsync.WithRawResponse by lazy {
            PlatformLinkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BotServiceAsync.WithRawResponse =
            BotServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Telegram bot service endpoints */
        override fun platformLinks(): PlatformLinkServiceAsync.WithRawResponse = platformLinks

        private val trackUsageHandler: Handler<BotTrackUsageResponse> =
            jsonHandler<BotTrackUsageResponse>(clientOptions.jsonMapper)

        override fun trackUsage(
            params: BotTrackUsageParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BotTrackUsageResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("bot", "usage")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { trackUsageHandler.handle(it) }
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
