// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import com.x_twitter_scraper.api.models.bot.BotTrackUsageResponse
import com.x_twitter_scraper.api.services.async.bot.PlatformLinkServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Telegram bot service endpoints */
interface BotServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotServiceAsync

    /** Telegram bot service endpoints */
    fun platformLinks(): PlatformLinkServiceAsync

    /** Track bot token usage */
    fun trackUsage(params: BotTrackUsageParams): CompletableFuture<BotTrackUsageResponse> =
        trackUsage(params, RequestOptions.none())

    /** @see trackUsage */
    fun trackUsage(
        params: BotTrackUsageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BotTrackUsageResponse>

    /** A view of [BotServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotServiceAsync.WithRawResponse

        /** Telegram bot service endpoints */
        fun platformLinks(): PlatformLinkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /bot/usage`, but is otherwise the same as
         * [BotServiceAsync.trackUsage].
         */
        fun trackUsage(
            params: BotTrackUsageParams
        ): CompletableFuture<HttpResponseFor<BotTrackUsageResponse>> =
            trackUsage(params, RequestOptions.none())

        /** @see trackUsage */
        fun trackUsage(
            params: BotTrackUsageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BotTrackUsageResponse>>
    }
}
