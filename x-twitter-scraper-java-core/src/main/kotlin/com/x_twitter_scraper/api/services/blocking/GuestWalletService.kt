// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupResponse
import java.util.function.Consumer

/** Accountless prepaid access for paid read endpoints */
interface GuestWalletService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuestWalletService

    /**
     * Create a one-use Stripe-hosted checkout after the user explicitly confirms a $10-$250 USD
     * amount. This request creates no charge by itself. The user opens checkout_url on Stripe. This
     * endpoint returns the paid-read API key without requiring an Xquik account, email, dashboard,
     * or Xquik web page. An idempotent replay returns the same key.
     */
    fun create(params: GuestWalletCreateParams): GuestWalletCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GuestWalletCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuestWalletCreateResponse

    /**
     * Poll after Stripe payment. Use usable to decide whether paid reads can run. An active wallet
     * can remain usable while a top-up is pending. A new wallet becomes usable only after verified
     * webhook fulfillment. Send the guest key as Authorization: Bearer.
     */
    fun retrieveStatus(): GuestWalletRetrieveStatusResponse =
        retrieveStatus(GuestWalletRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuestWalletRetrieveStatusResponse

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none()
    ): GuestWalletRetrieveStatusResponse = retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(requestOptions: RequestOptions): GuestWalletRetrieveStatusResponse =
        retrieveStatus(GuestWalletRetrieveStatusParams.none(), requestOptions)

    /**
     * Create a one-use Stripe-hosted checkout for an existing paid-read guest key after the user
     * explicitly confirms a $10-$250 USD amount. The key remains the same. This request creates no
     * charge by itself and never redirects through an Xquik web page.
     */
    fun topup(params: GuestWalletTopupParams): GuestWalletTopupResponse =
        topup(params, RequestOptions.none())

    /** @see topup */
    fun topup(
        params: GuestWalletTopupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuestWalletTopupResponse

    /**
     * A view of [GuestWalletService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GuestWalletService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /guest-wallets`, but is otherwise the same as
         * [GuestWalletService.create].
         */
        @MustBeClosed
        fun create(params: GuestWalletCreateParams): HttpResponseFor<GuestWalletCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: GuestWalletCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuestWalletCreateResponse>

        /**
         * Returns a raw HTTP response for `get /guest-wallets/status`, but is otherwise the same as
         * [GuestWalletService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(): HttpResponseFor<GuestWalletRetrieveStatusResponse> =
            retrieveStatus(GuestWalletRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuestWalletRetrieveStatusResponse>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none()
        ): HttpResponseFor<GuestWalletRetrieveStatusResponse> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestOptions: RequestOptions
        ): HttpResponseFor<GuestWalletRetrieveStatusResponse> =
            retrieveStatus(GuestWalletRetrieveStatusParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /guest-wallets/topups`, but is otherwise the same
         * as [GuestWalletService.topup].
         */
        @MustBeClosed
        fun topup(params: GuestWalletTopupParams): HttpResponseFor<GuestWalletTopupResponse> =
            topup(params, RequestOptions.none())

        /** @see topup */
        @MustBeClosed
        fun topup(
            params: GuestWalletTopupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuestWalletTopupResponse>
    }
}
