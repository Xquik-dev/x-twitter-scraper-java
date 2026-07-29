// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionattempts.AccountConnectionAttemptRetrieveParams
import com.x_twitter_scraper.api.models.x.accountconnectionattempts.AccountConnectionAttemptRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionAttemptServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountConnectionAttemptServiceAsync

    /** Get X account connection status */
    fun retrieve(id: String): CompletableFuture<AccountConnectionAttemptRetrieveResponse> =
        retrieve(id, AccountConnectionAttemptRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionAttemptRetrieveParams =
            AccountConnectionAttemptRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionAttemptRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionAttemptRetrieveParams =
            AccountConnectionAttemptRetrieveParams.none(),
    ): CompletableFuture<AccountConnectionAttemptRetrieveResponse> =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionAttemptRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionAttemptRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionAttemptRetrieveParams
    ): CompletableFuture<AccountConnectionAttemptRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountConnectionAttemptRetrieveResponse> =
        retrieve(id, AccountConnectionAttemptRetrieveParams.none(), requestOptions)

    /**
     * A view of [AccountConnectionAttemptServiceAsync] that provides access to raw HTTP responses
     * for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountConnectionAttemptServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/account-connection-attempts/{id}`, but is
         * otherwise the same as [AccountConnectionAttemptServiceAsync.retrieve].
         */
        fun retrieve(
            id: String
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>> =
            retrieve(id, AccountConnectionAttemptRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountConnectionAttemptRetrieveParams =
                AccountConnectionAttemptRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountConnectionAttemptRetrieveParams =
                AccountConnectionAttemptRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AccountConnectionAttemptRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: AccountConnectionAttemptRetrieveParams
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountConnectionAttemptRetrieveResponse>> =
            retrieve(id, AccountConnectionAttemptRetrieveParams.none(), requestOptions)
    }
}
