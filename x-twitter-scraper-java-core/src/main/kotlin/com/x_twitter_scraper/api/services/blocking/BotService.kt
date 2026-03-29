// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import com.x_twitter_scraper.api.models.bot.BotTrackUsageResponse
import com.x_twitter_scraper.api.services.blocking.bot.PlatformLinkService
import java.util.function.Consumer

/** Telegram bot service endpoints */
interface BotService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotService

    /** Telegram bot service endpoints */
    fun platformLinks(): PlatformLinkService

    /** Track bot token usage */
    fun trackUsage(params: BotTrackUsageParams): BotTrackUsageResponse =
        trackUsage(params, RequestOptions.none())

    /** @see trackUsage */
    fun trackUsage(
        params: BotTrackUsageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BotTrackUsageResponse

    /** A view of [BotService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BotService.WithRawResponse

        /** Telegram bot service endpoints */
        fun platformLinks(): PlatformLinkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /bot/usage`, but is otherwise the same as
         * [BotService.trackUsage].
         */
        @MustBeClosed
        fun trackUsage(params: BotTrackUsageParams): HttpResponseFor<BotTrackUsageResponse> =
            trackUsage(params, RequestOptions.none())

        /** @see trackUsage */
        @MustBeClosed
        fun trackUsage(
            params: BotTrackUsageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BotTrackUsageResponse>
    }
}
