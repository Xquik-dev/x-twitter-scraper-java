// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.account.AccountRetrieveParams
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameParams
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameResponse
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleParams
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleResponse
import java.util.function.Consumer

/** Account info & settings */
interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    /** Get account info */
    fun retrieve(): AccountRetrieveResponse = retrieve(AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveResponse

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none()
    ): AccountRetrieveResponse = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): AccountRetrieveResponse =
        retrieve(AccountRetrieveParams.none(), requestOptions)

    /** Set linked X username */
    fun setXUsername(params: AccountSetXUsernameParams): AccountSetXUsernameResponse =
        setXUsername(params, RequestOptions.none())

    /** @see setXUsername */
    fun setXUsername(
        params: AccountSetXUsernameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountSetXUsernameResponse

    /** Update account locale */
    fun updateLocale(params: AccountUpdateLocaleParams): AccountUpdateLocaleResponse =
        updateLocale(params, RequestOptions.none())

    /** @see updateLocale */
    fun updateLocale(
        params: AccountUpdateLocaleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountUpdateLocaleResponse

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /account`, but is otherwise the same as
         * [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(AccountRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none()
        ): HttpResponseFor<AccountRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /account/x-identity`, but is otherwise the same as
         * [AccountService.setXUsername].
         */
        @MustBeClosed
        fun setXUsername(
            params: AccountSetXUsernameParams
        ): HttpResponseFor<AccountSetXUsernameResponse> =
            setXUsername(params, RequestOptions.none())

        /** @see setXUsername */
        @MustBeClosed
        fun setXUsername(
            params: AccountSetXUsernameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountSetXUsernameResponse>

        /**
         * Returns a raw HTTP response for `patch /account`, but is otherwise the same as
         * [AccountService.updateLocale].
         */
        @MustBeClosed
        fun updateLocale(
            params: AccountUpdateLocaleParams
        ): HttpResponseFor<AccountUpdateLocaleResponse> =
            updateLocale(params, RequestOptions.none())

        /** @see updateLocale */
        @MustBeClosed
        fun updateLocale(
            params: AccountUpdateLocaleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountUpdateLocaleResponse>
    }
}
