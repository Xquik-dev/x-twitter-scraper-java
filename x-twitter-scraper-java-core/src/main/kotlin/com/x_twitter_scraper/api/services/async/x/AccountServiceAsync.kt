// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Connected X account management */
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

    /** Connect X account */
    fun create(params: AccountCreateParams): CompletableFuture<AccountCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountCreateResponse>

    /** Get X account details */
    fun retrieve(id: String): CompletableFuture<XAccountDetail> =
        retrieve(id, AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XAccountDetail> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): CompletableFuture<XAccountDetail> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XAccountDetail>

    /** @see retrieve */
    fun retrieve(params: AccountRetrieveParams): CompletableFuture<XAccountDetail> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<XAccountDetail> =
        retrieve(id, AccountRetrieveParams.none(), requestOptions)

    /** List connected X accounts */
    fun list(): CompletableFuture<AccountListResponse> = list(AccountListParams.none())

    /** @see list */
    fun list(
        params: AccountListParams = AccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountListResponse>

    /** @see list */
    fun list(
        params: AccountListParams = AccountListParams.none()
    ): CompletableFuture<AccountListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AccountListResponse> =
        list(AccountListParams.none(), requestOptions)

    /** Disconnect X account */
    fun delete(id: String): CompletableFuture<AccountDeleteResponse> =
        delete(id, AccountDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: AccountDeleteParams = AccountDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: AccountDeleteParams = AccountDeleteParams.none(),
    ): CompletableFuture<AccountDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountDeleteResponse>

    /** @see delete */
    fun delete(params: AccountDeleteParams): CompletableFuture<AccountDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountDeleteResponse> =
        delete(id, AccountDeleteParams.none(), requestOptions)

    /**
     * Clears loginFailedAt and loginFailureReason for all accounts with transient or automated
     * failure reasons, making them eligible for retry on next use.
     */
    fun bulkRetry(): CompletableFuture<AccountBulkRetryResponse> =
        bulkRetry(AccountBulkRetryParams.none())

    /** @see bulkRetry */
    fun bulkRetry(
        params: AccountBulkRetryParams = AccountBulkRetryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountBulkRetryResponse>

    /** @see bulkRetry */
    fun bulkRetry(
        params: AccountBulkRetryParams = AccountBulkRetryParams.none()
    ): CompletableFuture<AccountBulkRetryResponse> = bulkRetry(params, RequestOptions.none())

    /** @see bulkRetry */
    fun bulkRetry(requestOptions: RequestOptions): CompletableFuture<AccountBulkRetryResponse> =
        bulkRetry(AccountBulkRetryParams.none(), requestOptions)

    /** Re-authenticate X account */
    fun reauth(id: String, params: AccountReauthParams): CompletableFuture<AccountReauthResponse> =
        reauth(id, params, RequestOptions.none())

    /** @see reauth */
    fun reauth(
        id: String,
        params: AccountReauthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountReauthResponse> =
        reauth(params.toBuilder().id(id).build(), requestOptions)

    /** @see reauth */
    fun reauth(params: AccountReauthParams): CompletableFuture<AccountReauthResponse> =
        reauth(params, RequestOptions.none())

    /** @see reauth */
    fun reauth(
        params: AccountReauthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountReauthResponse>

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
         * Returns a raw HTTP response for `post /x/accounts`, but is otherwise the same as
         * [AccountServiceAsync.create].
         */
        fun create(
            params: AccountCreateParams
        ): CompletableFuture<HttpResponseFor<AccountCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /x/accounts/{id}`, but is otherwise the same as
         * [AccountServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<XAccountDetail>> =
            retrieve(id, AccountRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XAccountDetail>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<XAccountDetail>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XAccountDetail>>

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams
        ): CompletableFuture<HttpResponseFor<XAccountDetail>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XAccountDetail>> =
            retrieve(id, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/accounts`, but is otherwise the same as
         * [AccountServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AccountListResponse>> =
            list(AccountListParams.none())

        /** @see list */
        fun list(
            params: AccountListParams = AccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountListResponse>>

        /** @see list */
        fun list(
            params: AccountListParams = AccountListParams.none()
        ): CompletableFuture<HttpResponseFor<AccountListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccountListResponse>> =
            list(AccountListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /x/accounts/{id}`, but is otherwise the same as
         * [AccountServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<AccountDeleteResponse>> =
            delete(id, AccountDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: AccountDeleteParams = AccountDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: AccountDeleteParams = AccountDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountDeleteResponse>>

        /** @see delete */
        fun delete(
            params: AccountDeleteParams
        ): CompletableFuture<HttpResponseFor<AccountDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountDeleteResponse>> =
            delete(id, AccountDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/accounts/bulk-retry`, but is otherwise the same
         * as [AccountServiceAsync.bulkRetry].
         */
        fun bulkRetry(): CompletableFuture<HttpResponseFor<AccountBulkRetryResponse>> =
            bulkRetry(AccountBulkRetryParams.none())

        /** @see bulkRetry */
        fun bulkRetry(
            params: AccountBulkRetryParams = AccountBulkRetryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountBulkRetryResponse>>

        /** @see bulkRetry */
        fun bulkRetry(
            params: AccountBulkRetryParams = AccountBulkRetryParams.none()
        ): CompletableFuture<HttpResponseFor<AccountBulkRetryResponse>> =
            bulkRetry(params, RequestOptions.none())

        /** @see bulkRetry */
        fun bulkRetry(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccountBulkRetryResponse>> =
            bulkRetry(AccountBulkRetryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/accounts/{id}/reauth`, but is otherwise the same
         * as [AccountServiceAsync.reauth].
         */
        fun reauth(
            id: String,
            params: AccountReauthParams,
        ): CompletableFuture<HttpResponseFor<AccountReauthResponse>> =
            reauth(id, params, RequestOptions.none())

        /** @see reauth */
        fun reauth(
            id: String,
            params: AccountReauthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountReauthResponse>> =
            reauth(params.toBuilder().id(id).build(), requestOptions)

        /** @see reauth */
        fun reauth(
            params: AccountReauthParams
        ): CompletableFuture<HttpResponseFor<AccountReauthResponse>> =
            reauth(params, RequestOptions.none())

        /** @see reauth */
        fun reauth(
            params: AccountReauthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountReauthResponse>>
    }
}
