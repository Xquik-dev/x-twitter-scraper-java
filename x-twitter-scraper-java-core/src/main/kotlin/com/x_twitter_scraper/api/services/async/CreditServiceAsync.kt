// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceResponse
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Subscription, billing, and credits */
interface CreditServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditServiceAsync

    /** Get credits balance */
    fun retrieveBalance(): CompletableFuture<CreditRetrieveBalanceResponse> =
        retrieveBalance(CreditRetrieveBalanceParams.none())

    /** @see retrieveBalance */
    fun retrieveBalance(
        params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreditRetrieveBalanceResponse>

    /** @see retrieveBalance */
    fun retrieveBalance(
        params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none()
    ): CompletableFuture<CreditRetrieveBalanceResponse> =
        retrieveBalance(params, RequestOptions.none())

    /** @see retrieveBalance */
    fun retrieveBalance(
        requestOptions: RequestOptions
    ): CompletableFuture<CreditRetrieveBalanceResponse> =
        retrieveBalance(CreditRetrieveBalanceParams.none(), requestOptions)

    /** Top up credits balance */
    fun topupBalance(
        params: CreditTopupBalanceParams
    ): CompletableFuture<CreditTopupBalanceResponse> = topupBalance(params, RequestOptions.none())

    /** @see topupBalance */
    fun topupBalance(
        params: CreditTopupBalanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreditTopupBalanceResponse>

    /**
     * A view of [CreditServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /credits`, but is otherwise the same as
         * [CreditServiceAsync.retrieveBalance].
         */
        fun retrieveBalance(): CompletableFuture<HttpResponseFor<CreditRetrieveBalanceResponse>> =
            retrieveBalance(CreditRetrieveBalanceParams.none())

        /** @see retrieveBalance */
        fun retrieveBalance(
            params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreditRetrieveBalanceResponse>>

        /** @see retrieveBalance */
        fun retrieveBalance(
            params: CreditRetrieveBalanceParams = CreditRetrieveBalanceParams.none()
        ): CompletableFuture<HttpResponseFor<CreditRetrieveBalanceResponse>> =
            retrieveBalance(params, RequestOptions.none())

        /** @see retrieveBalance */
        fun retrieveBalance(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CreditRetrieveBalanceResponse>> =
            retrieveBalance(CreditRetrieveBalanceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /credits/topup`, but is otherwise the same as
         * [CreditServiceAsync.topupBalance].
         */
        fun topupBalance(
            params: CreditTopupBalanceParams
        ): CompletableFuture<HttpResponseFor<CreditTopupBalanceResponse>> =
            topupBalance(params, RequestOptions.none())

        /** @see topupBalance */
        fun topupBalance(
            params: CreditTopupBalanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreditTopupBalanceResponse>>
    }
}
