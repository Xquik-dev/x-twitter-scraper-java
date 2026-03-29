// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.account.AccountRetrieveParams
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameParams
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameResponse
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleParams
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Account info & settings */
interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync

    /** Get account info */
    fun retrieve(): CompletableFuture<AccountRetrieveResponse> =
        retrieve(AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none()
    ): CompletableFuture<AccountRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<AccountRetrieveResponse> =
        retrieve(AccountRetrieveParams.none(), requestOptions)

    /** Set linked X username */
    fun setXUsername(
        params: AccountSetXUsernameParams
    ): CompletableFuture<AccountSetXUsernameResponse> = setXUsername(params, RequestOptions.none())

    /** @see setXUsername */
    fun setXUsername(
        params: AccountSetXUsernameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountSetXUsernameResponse>

    /** Update account locale */
    fun updateLocale(
        params: AccountUpdateLocaleParams
    ): CompletableFuture<AccountUpdateLocaleResponse> = updateLocale(params, RequestOptions.none())

    /** @see updateLocale */
    fun updateLocale(
        params: AccountUpdateLocaleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountUpdateLocaleResponse>

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /account`, but is otherwise the same as
         * [AccountServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(AccountRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /account/x-identity`, but is otherwise the same as
         * [AccountServiceAsync.setXUsername].
         */
        fun setXUsername(
            params: AccountSetXUsernameParams
        ): CompletableFuture<HttpResponseFor<AccountSetXUsernameResponse>> =
            setXUsername(params, RequestOptions.none())

        /** @see setXUsername */
        fun setXUsername(
            params: AccountSetXUsernameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountSetXUsernameResponse>>

        /**
         * Returns a raw HTTP response for `patch /account`, but is otherwise the same as
         * [AccountServiceAsync.updateLocale].
         */
        fun updateLocale(
            params: AccountUpdateLocaleParams
        ): CompletableFuture<HttpResponseFor<AccountUpdateLocaleResponse>> =
            updateLocale(params, RequestOptions.none())

        /** @see updateLocale */
        fun updateLocale(
            params: AccountUpdateLocaleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountUpdateLocaleResponse>>
    }
}
