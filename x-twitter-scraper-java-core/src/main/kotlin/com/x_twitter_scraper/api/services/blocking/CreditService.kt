// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.credits.CreditRedirectTopupCheckoutParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceResponse
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusResponse
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceResponse
import java.util.function.Consumer

/** Subscription, billing, and credits */
interface CreditService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService

    /** Redirect to an active top-up payment page */
    fun redirectTopupCheckout(params: CreditRedirectTopupCheckoutParams) =
        redirectTopupCheckout(params, RequestOptions.none())

    /** @see redirectTopupCheckout */
    fun redirectTopupCheckout(
        params: CreditRedirectTopupCheckoutParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Get credits balance */
    fun retrieveBalance(): CreditRetrieveBalanceResponse =
        retrieveBalance(CreditRetrieveBalanceParams.none())

    /** @see retrieveBalance */
    fun retrieveBalance(
        params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreditRetrieveBalanceResponse

    /** @see retrieveBalance */
    fun retrieveBalance(
        params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none()
    ): CreditRetrieveBalanceResponse = retrieveBalance(params, RequestOptions.none())

    /** @see retrieveBalance */
    fun retrieveBalance(requestOptions: RequestOptions): CreditRetrieveBalanceResponse =
        retrieveBalance(CreditRetrieveBalanceParams.none(), requestOptions)

    /** Get top-up billing status */
    fun retrieveTopupStatus(
        params: CreditRetrieveTopupStatusParams
    ): CreditRetrieveTopupStatusResponse = retrieveTopupStatus(params, RequestOptions.none())

    /** @see retrieveTopupStatus */
    fun retrieveTopupStatus(
        params: CreditRetrieveTopupStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreditRetrieveTopupStatusResponse

    /**
     * Create a Stripe Checkout session only after the user confirms. The request never completes
     * payment or adds credits by itself.
     */
    fun topupBalance(params: CreditTopupBalanceParams): CreditTopupBalanceResponse =
        topupBalance(params, RequestOptions.none())

    /** @see topupBalance */
    fun topupBalance(
        params: CreditTopupBalanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreditTopupBalanceResponse

    /** A view of [CreditService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /credits/topup/redirect`, but is otherwise the same
         * as [CreditService.redirectTopupCheckout].
         */
        @MustBeClosed
        fun redirectTopupCheckout(params: CreditRedirectTopupCheckoutParams): HttpResponse =
            redirectTopupCheckout(params, RequestOptions.none())

        /** @see redirectTopupCheckout */
        @MustBeClosed
        fun redirectTopupCheckout(
            params: CreditRedirectTopupCheckoutParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get /credits`, but is otherwise the same as
         * [CreditService.retrieveBalance].
         */
        @MustBeClosed
        fun retrieveBalance(): HttpResponseFor<CreditRetrieveBalanceResponse> =
            retrieveBalance(CreditRetrieveBalanceParams.none())

        /** @see retrieveBalance */
        @MustBeClosed
        fun retrieveBalance(
            params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreditRetrieveBalanceResponse>

        /** @see retrieveBalance */
        @MustBeClosed
        fun retrieveBalance(
            params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none()
        ): HttpResponseFor<CreditRetrieveBalanceResponse> =
            retrieveBalance(params, RequestOptions.none())

        /** @see retrieveBalance */
        @MustBeClosed
        fun retrieveBalance(
            requestOptions: RequestOptions
        ): HttpResponseFor<CreditRetrieveBalanceResponse> =
            retrieveBalance(CreditRetrieveBalanceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /credits/topup/status`, but is otherwise the same as
         * [CreditService.retrieveTopupStatus].
         */
        @MustBeClosed
        fun retrieveTopupStatus(
            params: CreditRetrieveTopupStatusParams
        ): HttpResponseFor<CreditRetrieveTopupStatusResponse> =
            retrieveTopupStatus(params, RequestOptions.none())

        /** @see retrieveTopupStatus */
        @MustBeClosed
        fun retrieveTopupStatus(
            params: CreditRetrieveTopupStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreditRetrieveTopupStatusResponse>

        /**
         * Returns a raw HTTP response for `post /credits/topup`, but is otherwise the same as
         * [CreditService.topupBalance].
         */
        @MustBeClosed
        fun topupBalance(
            params: CreditTopupBalanceParams
        ): HttpResponseFor<CreditTopupBalanceResponse> = topupBalance(params, RequestOptions.none())

        /** @see topupBalance */
        @MustBeClosed
        fun topupBalance(
            params: CreditTopupBalanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreditTopupBalanceResponse>
    }
}
