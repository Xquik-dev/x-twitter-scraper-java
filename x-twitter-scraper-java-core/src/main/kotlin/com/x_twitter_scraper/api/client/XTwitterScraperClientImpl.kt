// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.client

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.getPackageVersion
import com.x_twitter_scraper.api.services.blocking.AccountService
import com.x_twitter_scraper.api.services.blocking.AccountServiceImpl
import com.x_twitter_scraper.api.services.blocking.ApiKeyService
import com.x_twitter_scraper.api.services.blocking.ApiKeyServiceImpl
import com.x_twitter_scraper.api.services.blocking.ComposeService
import com.x_twitter_scraper.api.services.blocking.ComposeServiceImpl
import com.x_twitter_scraper.api.services.blocking.CreditService
import com.x_twitter_scraper.api.services.blocking.CreditServiceImpl
import com.x_twitter_scraper.api.services.blocking.DraftService
import com.x_twitter_scraper.api.services.blocking.DraftServiceImpl
import com.x_twitter_scraper.api.services.blocking.DrawService
import com.x_twitter_scraper.api.services.blocking.DrawServiceImpl
import com.x_twitter_scraper.api.services.blocking.EventService
import com.x_twitter_scraper.api.services.blocking.EventServiceImpl
import com.x_twitter_scraper.api.services.blocking.ExtractionService
import com.x_twitter_scraper.api.services.blocking.ExtractionServiceImpl
import com.x_twitter_scraper.api.services.blocking.MonitorService
import com.x_twitter_scraper.api.services.blocking.MonitorServiceImpl
import com.x_twitter_scraper.api.services.blocking.RadarService
import com.x_twitter_scraper.api.services.blocking.RadarServiceImpl
import com.x_twitter_scraper.api.services.blocking.StyleService
import com.x_twitter_scraper.api.services.blocking.StyleServiceImpl
import com.x_twitter_scraper.api.services.blocking.SubscribeService
import com.x_twitter_scraper.api.services.blocking.SubscribeServiceImpl
import com.x_twitter_scraper.api.services.blocking.SupportService
import com.x_twitter_scraper.api.services.blocking.SupportServiceImpl
import com.x_twitter_scraper.api.services.blocking.TrendService
import com.x_twitter_scraper.api.services.blocking.TrendServiceImpl
import com.x_twitter_scraper.api.services.blocking.WebhookService
import com.x_twitter_scraper.api.services.blocking.WebhookServiceImpl
import com.x_twitter_scraper.api.services.blocking.XService
import com.x_twitter_scraper.api.services.blocking.XServiceImpl
import java.util.function.Consumer

class XTwitterScraperClientImpl(private val clientOptions: ClientOptions) : XTwitterScraperClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: XTwitterScraperClientAsync by lazy {
        XTwitterScraperClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: XTwitterScraperClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val account: AccountService by lazy { AccountServiceImpl(clientOptionsWithUserAgent) }

    private val apiKeys: ApiKeyService by lazy { ApiKeyServiceImpl(clientOptionsWithUserAgent) }

    private val subscribe: SubscribeService by lazy {
        SubscribeServiceImpl(clientOptionsWithUserAgent)
    }

    private val compose: ComposeService by lazy { ComposeServiceImpl(clientOptionsWithUserAgent) }

    private val drafts: DraftService by lazy { DraftServiceImpl(clientOptionsWithUserAgent) }

    private val styles: StyleService by lazy { StyleServiceImpl(clientOptionsWithUserAgent) }

    private val radar: RadarService by lazy { RadarServiceImpl(clientOptionsWithUserAgent) }

    private val monitors: MonitorService by lazy { MonitorServiceImpl(clientOptionsWithUserAgent) }

    private val events: EventService by lazy { EventServiceImpl(clientOptionsWithUserAgent) }

    private val extractions: ExtractionService by lazy {
        ExtractionServiceImpl(clientOptionsWithUserAgent)
    }

    private val draws: DrawService by lazy { DrawServiceImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val x: XService by lazy { XServiceImpl(clientOptionsWithUserAgent) }

    private val trends: TrendService by lazy { TrendServiceImpl(clientOptionsWithUserAgent) }

    private val support: SupportService by lazy { SupportServiceImpl(clientOptionsWithUserAgent) }

    private val credits: CreditService by lazy { CreditServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): XTwitterScraperClientAsync = async

    override fun withRawResponse(): XTwitterScraperClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): XTwitterScraperClient =
        XTwitterScraperClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Account info and settings */
    override fun account(): AccountService = account

    /** API key management (session auth only) */
    override fun apiKeys(): ApiKeyService = apiKeys

    /** Subscription, billing, and credits */
    override fun subscribe(): SubscribeService = subscribe

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun compose(): ComposeService = compose

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun drafts(): DraftService = drafts

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun styles(): StyleService = styles

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun radar(): RadarService = radar

    /** Real-time X account monitoring */
    override fun monitors(): MonitorService = monitors

    /** Activity events from monitored accounts */
    override fun events(): EventService = events

    /** Bulk data extraction (20 tool types) */
    override fun extractions(): ExtractionService = extractions

    /** Giveaway draws from tweet replies */
    override fun draws(): DrawService = draws

    /** Webhook endpoint management and delivery */
    override fun webhooks(): WebhookService = webhooks

    override fun x(): XService = x

    /** Trending topics and hashtags by region */
    override fun trends(): TrendService = trends

    override fun support(): SupportService = support

    /** Subscription, billing, and credits */
    override fun credits(): CreditService = credits

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        XTwitterScraperClient.WithRawResponse {

        private val account: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyService.WithRawResponse by lazy {
            ApiKeyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val subscribe: SubscribeService.WithRawResponse by lazy {
            SubscribeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val compose: ComposeService.WithRawResponse by lazy {
            ComposeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val drafts: DraftService.WithRawResponse by lazy {
            DraftServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val styles: StyleService.WithRawResponse by lazy {
            StyleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val radar: RadarService.WithRawResponse by lazy {
            RadarServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val monitors: MonitorService.WithRawResponse by lazy {
            MonitorServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventService.WithRawResponse by lazy {
            EventServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val extractions: ExtractionService.WithRawResponse by lazy {
            ExtractionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val draws: DrawService.WithRawResponse by lazy {
            DrawServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val x: XService.WithRawResponse by lazy {
            XServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val trends: TrendService.WithRawResponse by lazy {
            TrendServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val support: SupportService.WithRawResponse by lazy {
            SupportServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val credits: CreditService.WithRawResponse by lazy {
            CreditServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XTwitterScraperClient.WithRawResponse =
            XTwitterScraperClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Account info and settings */
        override fun account(): AccountService.WithRawResponse = account

        /** API key management (session auth only) */
        override fun apiKeys(): ApiKeyService.WithRawResponse = apiKeys

        /** Subscription, billing, and credits */
        override fun subscribe(): SubscribeService.WithRawResponse = subscribe

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun compose(): ComposeService.WithRawResponse = compose

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun drafts(): DraftService.WithRawResponse = drafts

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun styles(): StyleService.WithRawResponse = styles

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun radar(): RadarService.WithRawResponse = radar

        /** Real-time X account monitoring */
        override fun monitors(): MonitorService.WithRawResponse = monitors

        /** Activity events from monitored accounts */
        override fun events(): EventService.WithRawResponse = events

        /** Bulk data extraction (20 tool types) */
        override fun extractions(): ExtractionService.WithRawResponse = extractions

        /** Giveaway draws from tweet replies */
        override fun draws(): DrawService.WithRawResponse = draws

        /** Webhook endpoint management and delivery */
        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        override fun x(): XService.WithRawResponse = x

        /** Trending topics and hashtags by region */
        override fun trends(): TrendService.WithRawResponse = trends

        override fun support(): SupportService.WithRawResponse = support

        /** Subscription, billing, and credits */
        override fun credits(): CreditService.WithRawResponse = credits
    }
}
