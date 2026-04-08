// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accounts.AccountBulkRetryParams
import com.x_twitter_scraper.api.models.x.accounts.AccountBulkRetryResponse
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateParams
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateResponse
import com.x_twitter_scraper.api.models.x.accounts.AccountDeleteParams
import com.x_twitter_scraper.api.models.x.accounts.AccountDeleteResponse
import com.x_twitter_scraper.api.models.x.accounts.AccountListParams
import com.x_twitter_scraper.api.models.x.accounts.AccountListResponse
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthParams
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthResponse
import com.x_twitter_scraper.api.models.x.accounts.AccountRetrieveParams
import com.x_twitter_scraper.api.models.x.accounts.XAccountDetail
import java.util.function.Consumer

/** Connected X account management */
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

    /** Connect X account */
    fun create(params: AccountCreateParams): AccountCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountCreateResponse

    /** Get X account details */
    fun retrieve(id: String): XAccountDetail = retrieve(id, AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XAccountDetail = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): XAccountDetail = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XAccountDetail

    /** @see retrieve */
    fun retrieve(params: AccountRetrieveParams): XAccountDetail =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): XAccountDetail =
        retrieve(id, AccountRetrieveParams.none(), requestOptions)

    /** List connected X accounts */
    fun list(): AccountListResponse = list(AccountListParams.none())

    /** @see list */
    fun list(
        params: AccountListParams = AccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountListResponse

    /** @see list */
    fun list(params: AccountListParams = AccountListParams.none()): AccountListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AccountListResponse =
        list(AccountListParams.none(), requestOptions)

    /** Disconnect X account */
    fun delete(id: String): AccountDeleteResponse = delete(id, AccountDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: AccountDeleteParams = AccountDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: AccountDeleteParams = AccountDeleteParams.none(),
    ): AccountDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountDeleteResponse

    /** @see delete */
    fun delete(params: AccountDeleteParams): AccountDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): AccountDeleteResponse =
        delete(id, AccountDeleteParams.none(), requestOptions)

    /**
     * Clears loginFailedAt and loginFailureReason for all accounts with transient or automated
     * failure reasons, making them eligible for retry on next use.
     */
    fun bulkRetry(): AccountBulkRetryResponse = bulkRetry(AccountBulkRetryParams.none())

    /** @see bulkRetry */
    fun bulkRetry(
        params: AccountBulkRetryParams = AccountBulkRetryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountBulkRetryResponse

    /** @see bulkRetry */
    fun bulkRetry(
        params: AccountBulkRetryParams = AccountBulkRetryParams.none()
    ): AccountBulkRetryResponse = bulkRetry(params, RequestOptions.none())

    /** @see bulkRetry */
    fun bulkRetry(requestOptions: RequestOptions): AccountBulkRetryResponse =
        bulkRetry(AccountBulkRetryParams.none(), requestOptions)

    /** Re-authenticate X account */
    fun reauth(id: String, params: AccountReauthParams): AccountReauthResponse =
        reauth(id, params, RequestOptions.none())

    /** @see reauth */
    fun reauth(
        id: String,
        params: AccountReauthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountReauthResponse = reauth(params.toBuilder().id(id).build(), requestOptions)

    /** @see reauth */
    fun reauth(params: AccountReauthParams): AccountReauthResponse =
        reauth(params, RequestOptions.none())

    /** @see reauth */
    fun reauth(
        params: AccountReauthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountReauthResponse

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/accounts`, but is otherwise the same as
         * [AccountService.create].
         */
        @MustBeClosed
        fun create(params: AccountCreateParams): HttpResponseFor<AccountCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountCreateResponse>

        /**
         * Returns a raw HTTP response for `get /x/accounts/{id}`, but is otherwise the same as
         * [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<XAccountDetail> =
            retrieve(id, AccountRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XAccountDetail> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): HttpResponseFor<XAccountDetail> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XAccountDetail>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AccountRetrieveParams): HttpResponseFor<XAccountDetail> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<XAccountDetail> =
            retrieve(id, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/accounts`, but is otherwise the same as
         * [AccountService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<AccountListResponse> = list(AccountListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AccountListParams = AccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AccountListParams = AccountListParams.none()
        ): HttpResponseFor<AccountListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AccountListResponse> =
            list(AccountListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /x/accounts/{id}`, but is otherwise the same as
         * [AccountService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<AccountDeleteResponse> =
            delete(id, AccountDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: AccountDeleteParams = AccountDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: AccountDeleteParams = AccountDeleteParams.none(),
        ): HttpResponseFor<AccountDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: AccountDeleteParams): HttpResponseFor<AccountDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountDeleteResponse> =
            delete(id, AccountDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/accounts/bulk-retry`, but is otherwise the same
         * as [AccountService.bulkRetry].
         */
        @MustBeClosed
        fun bulkRetry(): HttpResponseFor<AccountBulkRetryResponse> =
            bulkRetry(AccountBulkRetryParams.none())

        /** @see bulkRetry */
        @MustBeClosed
        fun bulkRetry(
            params: AccountBulkRetryParams = AccountBulkRetryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountBulkRetryResponse>

        /** @see bulkRetry */
        @MustBeClosed
        fun bulkRetry(
            params: AccountBulkRetryParams = AccountBulkRetryParams.none()
        ): HttpResponseFor<AccountBulkRetryResponse> = bulkRetry(params, RequestOptions.none())

        /** @see bulkRetry */
        @MustBeClosed
        fun bulkRetry(requestOptions: RequestOptions): HttpResponseFor<AccountBulkRetryResponse> =
            bulkRetry(AccountBulkRetryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/accounts/{id}/reauth`, but is otherwise the same
         * as [AccountService.reauth].
         */
        @MustBeClosed
        fun reauth(
            id: String,
            params: AccountReauthParams,
        ): HttpResponseFor<AccountReauthResponse> = reauth(id, params, RequestOptions.none())

        /** @see reauth */
        @MustBeClosed
        fun reauth(
            id: String,
            params: AccountReauthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountReauthResponse> =
            reauth(params.toBuilder().id(id).build(), requestOptions)

        /** @see reauth */
        @MustBeClosed
        fun reauth(params: AccountReauthParams): HttpResponseFor<AccountReauthResponse> =
            reauth(params, RequestOptions.none())

        /** @see reauth */
        @MustBeClosed
        fun reauth(
            params: AccountReauthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountReauthResponse>
    }
}
