// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.compose.ComposeCreateParams
import com.x_twitter_scraper.api.models.compose.ComposeCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** AI tweet composition, drafts, writing styles, and radar */
interface ComposeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ComposeServiceAsync

    /**
     * Run one step of Xquik's three-step writing workflow. Compose returns questions and editorial
     * rules. Refine returns goal-specific guidance. Score applies deterministic text checks. It
     * does not predict reach or expose X ranking weights.
     */
    fun create(params: ComposeCreateParams): CompletableFuture<ComposeCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ComposeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ComposeCreateResponse>

    /** @see create */
    fun create(
        body: ComposeCreateParams.Body,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ComposeCreateResponse> =
        create(ComposeCreateParams.builder().body(body).build(), requestOptions)

    /** @see create */
    fun create(body: ComposeCreateParams.Body): CompletableFuture<ComposeCreateResponse> =
        create(body, RequestOptions.none())

    /** @see create */
    fun create(
        composePrepareRequest: ComposeCreateParams.Body.ComposePrepareRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ComposeCreateResponse> =
        create(
            ComposeCreateParams.Body.ofComposePrepareRequest(composePrepareRequest),
            requestOptions,
        )

    /** @see create */
    fun create(
        composePrepareRequest: ComposeCreateParams.Body.ComposePrepareRequest
    ): CompletableFuture<ComposeCreateResponse> =
        create(composePrepareRequest, RequestOptions.none())

    /** @see create */
    fun create(
        composeRefineRequest: ComposeCreateParams.Body.ComposeRefineRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ComposeCreateResponse> =
        create(
            ComposeCreateParams.Body.ofComposeRefineRequest(composeRefineRequest),
            requestOptions,
        )

    /** @see create */
    fun create(
        composeRefineRequest: ComposeCreateParams.Body.ComposeRefineRequest
    ): CompletableFuture<ComposeCreateResponse> =
        create(composeRefineRequest, RequestOptions.none())

    /** @see create */
    fun create(
        composeScoreRequest: ComposeCreateParams.Body.ComposeScoreRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ComposeCreateResponse> =
        create(ComposeCreateParams.Body.ofComposeScoreRequest(composeScoreRequest), requestOptions)

    /** @see create */
    fun create(
        composeScoreRequest: ComposeCreateParams.Body.ComposeScoreRequest
    ): CompletableFuture<ComposeCreateResponse> = create(composeScoreRequest, RequestOptions.none())

    /**
     * A view of [ComposeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ComposeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /compose`, but is otherwise the same as
         * [ComposeServiceAsync.create].
         */
        fun create(
            params: ComposeCreateParams
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ComposeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>>

        /** @see create */
        fun create(
            body: ComposeCreateParams.Body,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(ComposeCreateParams.builder().body(body).build(), requestOptions)

        /** @see create */
        fun create(
            body: ComposeCreateParams.Body
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(body, RequestOptions.none())

        /** @see create */
        fun create(
            composePrepareRequest: ComposeCreateParams.Body.ComposePrepareRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(
                ComposeCreateParams.Body.ofComposePrepareRequest(composePrepareRequest),
                requestOptions,
            )

        /** @see create */
        fun create(
            composePrepareRequest: ComposeCreateParams.Body.ComposePrepareRequest
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(composePrepareRequest, RequestOptions.none())

        /** @see create */
        fun create(
            composeRefineRequest: ComposeCreateParams.Body.ComposeRefineRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(
                ComposeCreateParams.Body.ofComposeRefineRequest(composeRefineRequest),
                requestOptions,
            )

        /** @see create */
        fun create(
            composeRefineRequest: ComposeCreateParams.Body.ComposeRefineRequest
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(composeRefineRequest, RequestOptions.none())

        /** @see create */
        fun create(
            composeScoreRequest: ComposeCreateParams.Body.ComposeScoreRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(
                ComposeCreateParams.Body.ofComposeScoreRequest(composeScoreRequest),
                requestOptions,
            )

        /** @see create */
        fun create(
            composeScoreRequest: ComposeCreateParams.Body.ComposeScoreRequest
        ): CompletableFuture<HttpResponseFor<ComposeCreateResponse>> =
            create(composeScoreRequest, RequestOptions.none())
    }
}
