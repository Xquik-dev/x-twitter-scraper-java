// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Accountless prepaid access for paid read endpoints */
interface GuestWalletServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuestWalletServiceAsync

    /**
     * Create a one-use hosted checkout after the user confirms $10-$250 USD. The request creates no
     * charge. It returns a paid-read API key without an Xquik account. Idempotent replays return
     * the same key.
     */
    fun create(params: GuestWalletCreateParams): CompletableFuture<GuestWalletCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GuestWalletCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuestWalletCreateResponse>

    /**
     * Poll after payment. Use usable to decide whether paid reads can run. An active wallet can
     * remain usable while a top-up is pending. A new wallet becomes usable only after payment is
     * verified. Send the guest key as Authorization: Bearer.
     */
    fun retrieveStatus(): CompletableFuture<GuestWalletRetrieveStatusResponse> =
        retrieveStatus(GuestWalletRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuestWalletRetrieveStatusResponse>

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none()
    ): CompletableFuture<GuestWalletRetrieveStatusResponse> =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestOptions: RequestOptions
    ): CompletableFuture<GuestWalletRetrieveStatusResponse> =
        retrieveStatus(GuestWalletRetrieveStatusParams.none(), requestOptions)

    /**
     * Create a one-use hosted checkout after the user confirms a $10-$250 USD amount for an
     * existing paid-read guest key. The key remains the same. This request creates no charge and
     * never redirects through Xquik.
     */
    fun topup(params: GuestWalletTopupParams): CompletableFuture<GuestWalletTopupResponse> =
        topup(params, RequestOptions.none())

    /** @see topup */
    fun topup(
        params: GuestWalletTopupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuestWalletTopupResponse>

    /**
     * A view of [GuestWalletServiceAsync] that provides access to raw HTTP responses for each
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
        ): GuestWalletServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /guest-wallets`, but is otherwise the same as
         * [GuestWalletServiceAsync.create].
         */
        fun create(
            params: GuestWalletCreateParams
        ): CompletableFuture<HttpResponseFor<GuestWalletCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: GuestWalletCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuestWalletCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /guest-wallets/status`, but is otherwise the same as
         * [GuestWalletServiceAsync.retrieveStatus].
         */
        fun retrieveStatus():
            CompletableFuture<HttpResponseFor<GuestWalletRetrieveStatusResponse>> =
            retrieveStatus(GuestWalletRetrieveStatusParams.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuestWalletRetrieveStatusResponse>>

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: GuestWalletRetrieveStatusParams = GuestWalletRetrieveStatusParams.none()
        ): CompletableFuture<HttpResponseFor<GuestWalletRetrieveStatusResponse>> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<GuestWalletRetrieveStatusResponse>> =
            retrieveStatus(GuestWalletRetrieveStatusParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /guest-wallets/topups`, but is otherwise the same
         * as [GuestWalletServiceAsync.topup].
         */
        fun topup(
            params: GuestWalletTopupParams
        ): CompletableFuture<HttpResponseFor<GuestWalletTopupResponse>> =
            topup(params, RequestOptions.none())

        /** @see topup */
        fun topup(
            params: GuestWalletTopupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuestWalletTopupResponse>>
    }
}
