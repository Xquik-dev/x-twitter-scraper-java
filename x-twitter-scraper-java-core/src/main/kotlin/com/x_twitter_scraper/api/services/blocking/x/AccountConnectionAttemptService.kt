// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionattempts.AccountConnectionAttemptRetrieveParams
import com.x_twitter_scraper.api.models.x.accountconnectionattempts.AccountConnectionAttemptRetrieveResponse
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionAttemptService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountConnectionAttemptService

    /** Get X account connection status */
    fun retrieve(id: String): AccountConnectionAttemptRetrieveResponse =
        retrieve(id, AccountConnectionAttemptRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionAttemptRetrieveParams =
            AccountConnectionAttemptRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionAttemptRetrieveResponse =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionAttemptRetrieveParams =
            AccountConnectionAttemptRetrieveParams.none(),
    ): AccountConnectionAttemptRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionAttemptRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionAttemptRetrieveResponse

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionAttemptRetrieveParams
    ): AccountConnectionAttemptRetrieveResponse = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): AccountConnectionAttemptRetrieveResponse =
        retrieve(id, AccountConnectionAttemptRetrieveParams.none(), requestOptions)

    /**
     * A view of [AccountConnectionAttemptService] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountConnectionAttemptService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/account-connection-attempts/{id}`, but is
         * otherwise the same as [AccountConnectionAttemptService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<AccountConnectionAttemptRetrieveResponse> =
            retrieve(id, AccountConnectionAttemptRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountConnectionAttemptRetrieveParams =
                AccountConnectionAttemptRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionAttemptRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountConnectionAttemptRetrieveParams =
                AccountConnectionAttemptRetrieveParams.none(),
        ): HttpResponseFor<AccountConnectionAttemptRetrieveResponse> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountConnectionAttemptRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionAttemptRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountConnectionAttemptRetrieveParams
        ): HttpResponseFor<AccountConnectionAttemptRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountConnectionAttemptRetrieveResponse> =
            retrieve(id, AccountConnectionAttemptRetrieveParams.none(), requestOptions)
    }
}
