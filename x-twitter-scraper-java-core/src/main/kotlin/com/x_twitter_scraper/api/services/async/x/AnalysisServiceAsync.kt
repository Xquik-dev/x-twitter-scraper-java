// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** AI analysis of posts, at 2 credits per analyzed post */
interface AnalysisServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AnalysisServiceAsync

    /**
     * Answers whether each post is about your brand, the author's attitude toward it & the author's
     * relationship with it. Name the brand in analysis.targets. Each analyzed post costs 2 credits.
     */
    fun brand(): CompletableFuture<AnalysisBrandResponse> = brand(AnalysisBrandParams.none())

    /** @see brand */
    fun brand(
        params: AnalysisBrandParams = AnalysisBrandParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisBrandResponse>

    /** @see brand */
    fun brand(
        params: AnalysisBrandParams = AnalysisBrandParams.none()
    ): CompletableFuture<AnalysisBrandResponse> = brand(params, RequestOptions.none())

    /** @see brand */
    fun brand(requestOptions: RequestOptions): CompletableFuture<AnalysisBrandResponse> =
        brand(AnalysisBrandParams.none(), requestOptions)

    /**
     * Answers 1 to 8 questions you write in analysis.questions. A choice picks a category, such as
     * a topic. A score picks a level. A probability answers yes or no. Without questions it answers
     * the sentiment questions. Each analyzed post costs 2 credits.
     */
    fun classify(): CompletableFuture<AnalysisClassifyResponse> =
        classify(AnalysisClassifyParams.none())

    /** @see classify */
    fun classify(
        params: AnalysisClassifyParams = AnalysisClassifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisClassifyResponse>

    /** @see classify */
    fun classify(
        params: AnalysisClassifyParams = AnalysisClassifyParams.none()
    ): CompletableFuture<AnalysisClassifyResponse> = classify(params, RequestOptions.none())

    /** @see classify */
    fun classify(requestOptions: RequestOptions): CompletableFuture<AnalysisClassifyResponse> =
        classify(AnalysisClassifyParams.none(), requestOptions)

    /**
     * Answers each post's stance on an asset, its content type, its conviction & its relevance. The
     * summary counts bullish & bearish posts per cashtag. Name the asset in analysis.targets. Each
     * analyzed post costs 2 credits.
     */
    fun marketSignals(): CompletableFuture<AnalysisMarketSignalsResponse> =
        marketSignals(AnalysisMarketSignalsParams.none())

    /** @see marketSignals */
    fun marketSignals(
        params: AnalysisMarketSignalsParams = AnalysisMarketSignalsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisMarketSignalsResponse>

    /** @see marketSignals */
    fun marketSignals(
        params: AnalysisMarketSignalsParams = AnalysisMarketSignalsParams.none()
    ): CompletableFuture<AnalysisMarketSignalsResponse> =
        marketSignals(params, RequestOptions.none())

    /** @see marketSignals */
    fun marketSignals(
        requestOptions: RequestOptions
    ): CompletableFuture<AnalysisMarketSignalsResponse> =
        marketSignals(AnalysisMarketSignalsParams.none(), requestOptions)

    /**
     * Answers each post's format, such as reporting, commentary or speculation, its source
     * attribution & its relevance to your topic. Name the topic in analysis.targets. Each analyzed
     * post costs 2 credits.
     */
    fun news(): CompletableFuture<AnalysisNewsResponse> = news(AnalysisNewsParams.none())

    /** @see news */
    fun news(
        params: AnalysisNewsParams = AnalysisNewsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisNewsResponse>

    /** @see news */
    fun news(
        params: AnalysisNewsParams = AnalysisNewsParams.none()
    ): CompletableFuture<AnalysisNewsResponse> = news(params, RequestOptions.none())

    /** @see news */
    fun news(requestOptions: RequestOptions): CompletableFuture<AnalysisNewsResponse> =
        news(AnalysisNewsParams.none(), requestOptions)

    /**
     * Answers each post's attitude, its intensity & its sarcasm probability. Send post IDs, an X
     * search, an account, a List, a post's replies or quotes, or your own texts. Each analyzed post
     * costs 2 credits. A post without an analysis costs nothing.
     */
    fun sentiment(): CompletableFuture<AnalysisSentimentResponse> =
        sentiment(AnalysisSentimentParams.none())

    /** @see sentiment */
    fun sentiment(
        params: AnalysisSentimentParams = AnalysisSentimentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisSentimentResponse>

    /** @see sentiment */
    fun sentiment(
        params: AnalysisSentimentParams = AnalysisSentimentParams.none()
    ): CompletableFuture<AnalysisSentimentResponse> = sentiment(params, RequestOptions.none())

    /** @see sentiment */
    fun sentiment(requestOptions: RequestOptions): CompletableFuture<AnalysisSentimentResponse> =
        sentiment(AnalysisSentimentParams.none(), requestOptions)

    /**
     * Answers each post's hook, clarity, payoff, humor, spam risk & likely reaction, & adds a Viral
     * Score from 0 to 100 with a verdict. The score rates the wording. It does not predict likes or
     * views. Send drafts in texts to score them before posting. Each analyzed post costs 2 credits.
     */
    fun viralScore(): CompletableFuture<AnalysisViralScoreResponse> =
        viralScore(AnalysisViralScoreParams.none())

    /** @see viralScore */
    fun viralScore(
        params: AnalysisViralScoreParams = AnalysisViralScoreParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AnalysisViralScoreResponse>

    /** @see viralScore */
    fun viralScore(
        params: AnalysisViralScoreParams = AnalysisViralScoreParams.none()
    ): CompletableFuture<AnalysisViralScoreResponse> = viralScore(params, RequestOptions.none())

    /** @see viralScore */
    fun viralScore(requestOptions: RequestOptions): CompletableFuture<AnalysisViralScoreResponse> =
        viralScore(AnalysisViralScoreParams.none(), requestOptions)

    /**
     * A view of [AnalysisServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AnalysisServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/analysis/brand`, but is otherwise the same as
         * [AnalysisServiceAsync.brand].
         */
        fun brand(): CompletableFuture<HttpResponseFor<AnalysisBrandResponse>> =
            brand(AnalysisBrandParams.none())

        /** @see brand */
        fun brand(
            params: AnalysisBrandParams = AnalysisBrandParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisBrandResponse>>

        /** @see brand */
        fun brand(
            params: AnalysisBrandParams = AnalysisBrandParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisBrandResponse>> =
            brand(params, RequestOptions.none())

        /** @see brand */
        fun brand(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisBrandResponse>> =
            brand(AnalysisBrandParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/analysis/classify`, but is otherwise the same as
         * [AnalysisServiceAsync.classify].
         */
        fun classify(): CompletableFuture<HttpResponseFor<AnalysisClassifyResponse>> =
            classify(AnalysisClassifyParams.none())

        /** @see classify */
        fun classify(
            params: AnalysisClassifyParams = AnalysisClassifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisClassifyResponse>>

        /** @see classify */
        fun classify(
            params: AnalysisClassifyParams = AnalysisClassifyParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisClassifyResponse>> =
            classify(params, RequestOptions.none())

        /** @see classify */
        fun classify(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisClassifyResponse>> =
            classify(AnalysisClassifyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/analysis/market-signals`, but is otherwise the
         * same as [AnalysisServiceAsync.marketSignals].
         */
        fun marketSignals(): CompletableFuture<HttpResponseFor<AnalysisMarketSignalsResponse>> =
            marketSignals(AnalysisMarketSignalsParams.none())

        /** @see marketSignals */
        fun marketSignals(
            params: AnalysisMarketSignalsParams = AnalysisMarketSignalsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisMarketSignalsResponse>>

        /** @see marketSignals */
        fun marketSignals(
            params: AnalysisMarketSignalsParams = AnalysisMarketSignalsParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisMarketSignalsResponse>> =
            marketSignals(params, RequestOptions.none())

        /** @see marketSignals */
        fun marketSignals(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisMarketSignalsResponse>> =
            marketSignals(AnalysisMarketSignalsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/analysis/news`, but is otherwise the same as
         * [AnalysisServiceAsync.news].
         */
        fun news(): CompletableFuture<HttpResponseFor<AnalysisNewsResponse>> =
            news(AnalysisNewsParams.none())

        /** @see news */
        fun news(
            params: AnalysisNewsParams = AnalysisNewsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisNewsResponse>>

        /** @see news */
        fun news(
            params: AnalysisNewsParams = AnalysisNewsParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisNewsResponse>> =
            news(params, RequestOptions.none())

        /** @see news */
        fun news(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisNewsResponse>> =
            news(AnalysisNewsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/analysis/sentiment`, but is otherwise the same
         * as [AnalysisServiceAsync.sentiment].
         */
        fun sentiment(): CompletableFuture<HttpResponseFor<AnalysisSentimentResponse>> =
            sentiment(AnalysisSentimentParams.none())

        /** @see sentiment */
        fun sentiment(
            params: AnalysisSentimentParams = AnalysisSentimentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisSentimentResponse>>

        /** @see sentiment */
        fun sentiment(
            params: AnalysisSentimentParams = AnalysisSentimentParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisSentimentResponse>> =
            sentiment(params, RequestOptions.none())

        /** @see sentiment */
        fun sentiment(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisSentimentResponse>> =
            sentiment(AnalysisSentimentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/analysis/viral-score`, but is otherwise the same
         * as [AnalysisServiceAsync.viralScore].
         */
        fun viralScore(): CompletableFuture<HttpResponseFor<AnalysisViralScoreResponse>> =
            viralScore(AnalysisViralScoreParams.none())

        /** @see viralScore */
        fun viralScore(
            params: AnalysisViralScoreParams = AnalysisViralScoreParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AnalysisViralScoreResponse>>

        /** @see viralScore */
        fun viralScore(
            params: AnalysisViralScoreParams = AnalysisViralScoreParams.none()
        ): CompletableFuture<HttpResponseFor<AnalysisViralScoreResponse>> =
            viralScore(params, RequestOptions.none())

        /** @see viralScore */
        fun viralScore(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AnalysisViralScoreResponse>> =
            viralScore(AnalysisViralScoreParams.none(), requestOptions)
    }
}
