// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.client

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.services.async.AccountServiceAsync
import com.x_twitter_scraper.api.services.async.ApiKeyServiceAsync
import com.x_twitter_scraper.api.services.async.BotServiceAsync
import com.x_twitter_scraper.api.services.async.ComposeServiceAsync
import com.x_twitter_scraper.api.services.async.CreditServiceAsync
import com.x_twitter_scraper.api.services.async.DraftServiceAsync
import com.x_twitter_scraper.api.services.async.DrawServiceAsync
import com.x_twitter_scraper.api.services.async.EventServiceAsync
import com.x_twitter_scraper.api.services.async.ExtractionServiceAsync
import com.x_twitter_scraper.api.services.async.IntegrationServiceAsync
import com.x_twitter_scraper.api.services.async.MonitorServiceAsync
import com.x_twitter_scraper.api.services.async.RadarServiceAsync
import com.x_twitter_scraper.api.services.async.StyleServiceAsync
import com.x_twitter_scraper.api.services.async.SubscribeServiceAsync
import com.x_twitter_scraper.api.services.async.SupportServiceAsync
import com.x_twitter_scraper.api.services.async.TrendServiceAsync
import com.x_twitter_scraper.api.services.async.WebhookServiceAsync
import com.x_twitter_scraper.api.services.async.XServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the X Twitter Scraper REST API asynchronously. You can also switch
 * to synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface XTwitterScraperClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): XTwitterScraperClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): XTwitterScraperClientAsync

    /** Account info and settings */
    fun account(): AccountServiceAsync

    /** API key management (session auth only) */
    fun apiKeys(): ApiKeyServiceAsync

    /** Subscription, billing, and credits */
    fun subscribe(): SubscribeServiceAsync

    /** AI tweet composition, drafts, writing styles, and radar */
    fun compose(): ComposeServiceAsync

    /** AI tweet composition, drafts, writing styles, and radar */
    fun drafts(): DraftServiceAsync

    /** AI tweet composition, drafts, writing styles, and radar */
    fun styles(): StyleServiceAsync

    /** AI tweet composition, drafts, writing styles, and radar */
    fun radar(): RadarServiceAsync

    /** Real-time X account monitoring */
    fun monitors(): MonitorServiceAsync

    /** Activity events from monitored accounts */
    fun events(): EventServiceAsync

    /** Bulk data extraction (20 tool types) */
    fun extractions(): ExtractionServiceAsync

    /** Giveaway draws from tweet replies */
    fun draws(): DrawServiceAsync

    /** Webhook endpoint management and delivery */
    fun webhooks(): WebhookServiceAsync

    /** Push notification integrations (Telegram) */
    fun integrations(): IntegrationServiceAsync

    fun x(): XServiceAsync

    /** Trending topics and hashtags by region */
    fun trends(): TrendServiceAsync

    fun bot(): BotServiceAsync

    fun support(): SupportServiceAsync

    /** Subscription, billing, and credits */
    fun credits(): CreditServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [XTwitterScraperClientAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XTwitterScraperClientAsync.WithRawResponse

        /** Account info and settings */
        fun account(): AccountServiceAsync.WithRawResponse

        /** API key management (session auth only) */
        fun apiKeys(): ApiKeyServiceAsync.WithRawResponse

        /** Subscription, billing, and credits */
        fun subscribe(): SubscribeServiceAsync.WithRawResponse

        /** AI tweet composition, drafts, writing styles, and radar */
        fun compose(): ComposeServiceAsync.WithRawResponse

        /** AI tweet composition, drafts, writing styles, and radar */
        fun drafts(): DraftServiceAsync.WithRawResponse

        /** AI tweet composition, drafts, writing styles, and radar */
        fun styles(): StyleServiceAsync.WithRawResponse

        /** AI tweet composition, drafts, writing styles, and radar */
        fun radar(): RadarServiceAsync.WithRawResponse

        /** Real-time X account monitoring */
        fun monitors(): MonitorServiceAsync.WithRawResponse

        /** Activity events from monitored accounts */
        fun events(): EventServiceAsync.WithRawResponse

        /** Bulk data extraction (20 tool types) */
        fun extractions(): ExtractionServiceAsync.WithRawResponse

        /** Giveaway draws from tweet replies */
        fun draws(): DrawServiceAsync.WithRawResponse

        /** Webhook endpoint management and delivery */
        fun webhooks(): WebhookServiceAsync.WithRawResponse

        /** Push notification integrations (Telegram) */
        fun integrations(): IntegrationServiceAsync.WithRawResponse

        fun x(): XServiceAsync.WithRawResponse

        /** Trending topics and hashtags by region */
        fun trends(): TrendServiceAsync.WithRawResponse

        fun bot(): BotServiceAsync.WithRawResponse

        fun support(): SupportServiceAsync.WithRawResponse

        /** Subscription, billing, and credits */
        fun credits(): CreditServiceAsync.WithRawResponse
    }
}
