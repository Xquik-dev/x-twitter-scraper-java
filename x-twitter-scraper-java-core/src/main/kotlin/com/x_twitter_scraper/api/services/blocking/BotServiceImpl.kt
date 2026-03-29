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
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import com.x_twitter_scraper.api.models.bot.BotTrackUsageResponse
import com.x_twitter_scraper.api.services.blocking.bot.PlatformLinkService
import com.x_twitter_scraper.api.services.blocking.bot.PlatformLinkServiceImpl
import java.util.function.Consumer

/** Telegram bot service endpoints */
class BotServiceImpl internal constructor(private val clientOptions: ClientOptions) : BotService {

    private val withRawResponse: BotService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val platformLinks: PlatformLinkService by lazy {
        PlatformLinkServiceImpl(clientOptions)
    }

    override fun withRawResponse(): BotService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotService =
        BotServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Telegram bot service endpoints */
    override fun platformLinks(): PlatformLinkService = platformLinks

    override fun trackUsage(
        params: BotTrackUsageParams,
        requestOptions: RequestOptions,
    ): BotTrackUsageResponse =
        // post /bot/usage
        withRawResponse().trackUsage(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BotService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val platformLinks: PlatformLinkService.WithRawResponse by lazy {
            PlatformLinkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BotService.WithRawResponse =
            BotServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Telegram bot service endpoints */
        override fun platformLinks(): PlatformLinkService.WithRawResponse = platformLinks

        private val trackUsageHandler: Handler<BotTrackUsageResponse> =
            jsonHandler<BotTrackUsageResponse>(clientOptions.jsonMapper)

        override fun trackUsage(
            params: BotTrackUsageParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BotTrackUsageResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("bot", "usage")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
