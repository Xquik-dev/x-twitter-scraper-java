// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.client

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.services.blocking.AccountService
import com.x_twitter_scraper.api.services.blocking.ApiKeyService
import com.x_twitter_scraper.api.services.blocking.BotService
import com.x_twitter_scraper.api.services.blocking.ComposeService
import com.x_twitter_scraper.api.services.blocking.CreditService
import com.x_twitter_scraper.api.services.blocking.DraftService
import com.x_twitter_scraper.api.services.blocking.DrawService
import com.x_twitter_scraper.api.services.blocking.EventService
import com.x_twitter_scraper.api.services.blocking.ExtractionService
import com.x_twitter_scraper.api.services.blocking.IntegrationService
import com.x_twitter_scraper.api.services.blocking.MonitorService
import com.x_twitter_scraper.api.services.blocking.RadarService
import com.x_twitter_scraper.api.services.blocking.StyleService
import com.x_twitter_scraper.api.services.blocking.SubscribeService
import com.x_twitter_scraper.api.services.blocking.SupportService
import com.x_twitter_scraper.api.services.blocking.TrendService
import com.x_twitter_scraper.api.services.blocking.WebhookService
import com.x_twitter_scraper.api.services.blocking.XService
import java.util.function.Consumer

/**
 * A client for interacting with the X Twitter Scraper REST API synchronously. You can also switch
 * to asynchronous execution via the [async] method.
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
interface XTwitterScraperClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): XTwitterScraperClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): XTwitterScraperClient

    /** Account info & settings */
    fun account(): AccountService

    /** API key management (session auth only) */
    fun apiKeys(): ApiKeyService

    /** Subscription & billing */
    fun subscribe(): SubscribeService

    /** Tweet composition, drafts, writing styles & radar */
    fun compose(): ComposeService

    /** Tweet composition, drafts, writing styles & radar */
    fun drafts(): DraftService

    /** Tweet composition, drafts, writing styles & radar */
    fun styles(): StyleService

    /** Tweet composition, drafts, writing styles & radar */
    fun radar(): RadarService

    /** Real-time X account monitoring */
    fun monitors(): MonitorService

    /** Activity events from monitored accounts */
    fun events(): EventService

    /** Bulk data extraction (20 tool types) */
    fun extractions(): ExtractionService

    /** Giveaway draws from tweet replies */
    fun draws(): DrawService

    /** Webhook endpoint management & delivery */
    fun webhooks(): WebhookService

    /** Push notification integrations (Telegram) */
    fun integrations(): IntegrationService

    /** X data lookups (subscription required) */
    fun x(): XService

    /** Trending topics by region */
    fun trends(): TrendService

    fun bot(): BotService

    fun support(): SupportService

    /** Subscription & billing */
    fun credits(): CreditService

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
     * A view of [XTwitterScraperClient] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XTwitterScraperClient.WithRawResponse

        /** Account info & settings */
        fun account(): AccountService.WithRawResponse

        /** API key management (session auth only) */
        fun apiKeys(): ApiKeyService.WithRawResponse

        /** Subscription & billing */
        fun subscribe(): SubscribeService.WithRawResponse

        /** Tweet composition, drafts, writing styles & radar */
        fun compose(): ComposeService.WithRawResponse

        /** Tweet composition, drafts, writing styles & radar */
        fun drafts(): DraftService.WithRawResponse

        /** Tweet composition, drafts, writing styles & radar */
        fun styles(): StyleService.WithRawResponse

        /** Tweet composition, drafts, writing styles & radar */
        fun radar(): RadarService.WithRawResponse

        /** Real-time X account monitoring */
        fun monitors(): MonitorService.WithRawResponse

        /** Activity events from monitored accounts */
        fun events(): EventService.WithRawResponse

        /** Bulk data extraction (20 tool types) */
        fun extractions(): ExtractionService.WithRawResponse

        /** Giveaway draws from tweet replies */
        fun draws(): DrawService.WithRawResponse

        /** Webhook endpoint management & delivery */
        fun webhooks(): WebhookService.WithRawResponse

        /** Push notification integrations (Telegram) */
        fun integrations(): IntegrationService.WithRawResponse

        /** X data lookups (subscription required) */
        fun x(): XService.WithRawResponse

        /** Trending topics by region */
        fun trends(): TrendService.WithRawResponse

        fun bot(): BotService.WithRawResponse

        fun support(): SupportService.WithRawResponse

        /** Subscription & billing */
        fun credits(): CreditService.WithRawResponse
    }
}
