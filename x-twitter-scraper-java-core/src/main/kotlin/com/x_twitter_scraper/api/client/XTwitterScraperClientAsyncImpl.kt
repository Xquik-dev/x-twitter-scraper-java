// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.client

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.getPackageVersion
import com.x_twitter_scraper.api.services.async.AccountServiceAsync
import com.x_twitter_scraper.api.services.async.AccountServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.ApiKeyServiceAsync
import com.x_twitter_scraper.api.services.async.ApiKeyServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.ComposeServiceAsync
import com.x_twitter_scraper.api.services.async.ComposeServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.CreditServiceAsync
import com.x_twitter_scraper.api.services.async.CreditServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.DraftServiceAsync
import com.x_twitter_scraper.api.services.async.DraftServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.DrawServiceAsync
import com.x_twitter_scraper.api.services.async.DrawServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.EventServiceAsync
import com.x_twitter_scraper.api.services.async.EventServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.ExtractionServiceAsync
import com.x_twitter_scraper.api.services.async.ExtractionServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.MonitorServiceAsync
import com.x_twitter_scraper.api.services.async.MonitorServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.RadarServiceAsync
import com.x_twitter_scraper.api.services.async.RadarServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.StyleServiceAsync
import com.x_twitter_scraper.api.services.async.StyleServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.SubscribeServiceAsync
import com.x_twitter_scraper.api.services.async.SubscribeServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.SupportServiceAsync
import com.x_twitter_scraper.api.services.async.SupportServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.TrendServiceAsync
import com.x_twitter_scraper.api.services.async.TrendServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.WebhookServiceAsync
import com.x_twitter_scraper.api.services.async.WebhookServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.XServiceAsync
import com.x_twitter_scraper.api.services.async.XServiceAsyncImpl
import java.util.function.Consumer

class XTwitterScraperClientAsyncImpl(private val clientOptions: ClientOptions) :
    XTwitterScraperClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: XTwitterScraperClient by lazy { XTwitterScraperClientImpl(clientOptions) }

    private val withRawResponse: XTwitterScraperClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val account: AccountServiceAsync by lazy {
        AccountServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val apiKeys: ApiKeyServiceAsync by lazy {
        ApiKeyServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val subscribe: SubscribeServiceAsync by lazy {
        SubscribeServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val compose: ComposeServiceAsync by lazy {
        ComposeServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val drafts: DraftServiceAsync by lazy {
        DraftServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val styles: StyleServiceAsync by lazy {
        StyleServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val radar: RadarServiceAsync by lazy {
        RadarServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val monitors: MonitorServiceAsync by lazy {
        MonitorServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val events: EventServiceAsync by lazy {
        EventServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val extractions: ExtractionServiceAsync by lazy {
        ExtractionServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val draws: DrawServiceAsync by lazy { DrawServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val x: XServiceAsync by lazy { XServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val trends: TrendServiceAsync by lazy {
        TrendServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val support: SupportServiceAsync by lazy {
        SupportServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val credits: CreditServiceAsync by lazy {
        CreditServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): XTwitterScraperClient = sync

    override fun withRawResponse(): XTwitterScraperClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): XTwitterScraperClientAsync =
        XTwitterScraperClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Account info and settings */
    override fun account(): AccountServiceAsync = account

    /** API key management (session auth only) */
    override fun apiKeys(): ApiKeyServiceAsync = apiKeys

    /** Subscription, billing, and credits */
    override fun subscribe(): SubscribeServiceAsync = subscribe

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun compose(): ComposeServiceAsync = compose

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun drafts(): DraftServiceAsync = drafts

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun styles(): StyleServiceAsync = styles

    /** AI tweet composition, drafts, writing styles, and radar */
    override fun radar(): RadarServiceAsync = radar

    /** Real-time X account monitoring */
    override fun monitors(): MonitorServiceAsync = monitors

    /** Activity events from monitored accounts */
    override fun events(): EventServiceAsync = events

    /** Bulk data extraction (20 tool types) */
    override fun extractions(): ExtractionServiceAsync = extractions

    /** Giveaway draws from tweet replies */
    override fun draws(): DrawServiceAsync = draws

    /** Webhook endpoint management and delivery */
    override fun webhooks(): WebhookServiceAsync = webhooks

    override fun x(): XServiceAsync = x

    /** Trending topics and hashtags by region */
    override fun trends(): TrendServiceAsync = trends

    override fun support(): SupportServiceAsync = support

    /** Subscription, billing, and credits */
    override fun credits(): CreditServiceAsync = credits

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        XTwitterScraperClientAsync.WithRawResponse {

        private val account: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyServiceAsync.WithRawResponse by lazy {
            ApiKeyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val subscribe: SubscribeServiceAsync.WithRawResponse by lazy {
            SubscribeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val compose: ComposeServiceAsync.WithRawResponse by lazy {
            ComposeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val drafts: DraftServiceAsync.WithRawResponse by lazy {
            DraftServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val styles: StyleServiceAsync.WithRawResponse by lazy {
            StyleServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val radar: RadarServiceAsync.WithRawResponse by lazy {
            RadarServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val monitors: MonitorServiceAsync.WithRawResponse by lazy {
            MonitorServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventServiceAsync.WithRawResponse by lazy {
            EventServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val extractions: ExtractionServiceAsync.WithRawResponse by lazy {
            ExtractionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val draws: DrawServiceAsync.WithRawResponse by lazy {
            DrawServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val x: XServiceAsync.WithRawResponse by lazy {
            XServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val trends: TrendServiceAsync.WithRawResponse by lazy {
            TrendServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val support: SupportServiceAsync.WithRawResponse by lazy {
            SupportServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val credits: CreditServiceAsync.WithRawResponse by lazy {
            CreditServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XTwitterScraperClientAsync.WithRawResponse =
            XTwitterScraperClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Account info and settings */
        override fun account(): AccountServiceAsync.WithRawResponse = account

        /** API key management (session auth only) */
        override fun apiKeys(): ApiKeyServiceAsync.WithRawResponse = apiKeys

        /** Subscription, billing, and credits */
        override fun subscribe(): SubscribeServiceAsync.WithRawResponse = subscribe

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun compose(): ComposeServiceAsync.WithRawResponse = compose

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun drafts(): DraftServiceAsync.WithRawResponse = drafts

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun styles(): StyleServiceAsync.WithRawResponse = styles

        /** AI tweet composition, drafts, writing styles, and radar */
        override fun radar(): RadarServiceAsync.WithRawResponse = radar

        /** Real-time X account monitoring */
        override fun monitors(): MonitorServiceAsync.WithRawResponse = monitors

        /** Activity events from monitored accounts */
        override fun events(): EventServiceAsync.WithRawResponse = events

        /** Bulk data extraction (20 tool types) */
        override fun extractions(): ExtractionServiceAsync.WithRawResponse = extractions

        /** Giveaway draws from tweet replies */
        override fun draws(): DrawServiceAsync.WithRawResponse = draws

        /** Webhook endpoint management and delivery */
        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        override fun x(): XServiceAsync.WithRawResponse = x

        /** Trending topics and hashtags by region */
        override fun trends(): TrendServiceAsync.WithRawResponse = trends

        override fun support(): SupportServiceAsync.WithRawResponse = support

        /** Subscription, billing, and credits */
        override fun credits(): CreditServiceAsync.WithRawResponse = credits
    }
}
