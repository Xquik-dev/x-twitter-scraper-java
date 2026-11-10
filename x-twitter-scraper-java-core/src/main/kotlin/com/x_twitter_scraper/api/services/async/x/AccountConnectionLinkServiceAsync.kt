// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLink
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateParams
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateResponse
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkDeleteParams
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkDeleteResponse
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionLinkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountConnectionLinkServiceAsync

    /**
     * Creates a link to a page Xquik hosts, where a person connects an X account with no Xquik
     * signup. Your backend never receives their password or 2FA secret, and the account belongs to
     * you. Send accountId to reconnect 1 of your accounts instead. Connecting is free. Takes a Full
     * access API key or a dashboard session.
     *
     * The link works for 30 minutes, and the response is the only place its token appears.
     */
    fun create(): CompletableFuture<AccountConnectionLinkCreateResponse> =
        create(AccountConnectionLinkCreateParams.none())

    /** @see create */
    fun create(
        params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionLinkCreateResponse>

    /** @see create */
    fun create(
        params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none()
    ): CompletableFuture<AccountConnectionLinkCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        requestOptions: RequestOptions
    ): CompletableFuture<AccountConnectionLinkCreateResponse> =
        create(AccountConnectionLinkCreateParams.none(), requestOptions)

    /** Get an X account connection link */
    fun retrieve(id: String): CompletableFuture<AccountConnectionLink> =
        retrieve(id, AccountConnectionLinkRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionLinkRetrieveParams = AccountConnectionLinkRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionLink> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionLinkRetrieveParams = AccountConnectionLinkRetrieveParams.none(),
    ): CompletableFuture<AccountConnectionLink> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionLinkRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionLink>

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionLinkRetrieveParams
    ): CompletableFuture<AccountConnectionLink> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountConnectionLink> =
        retrieve(id, AccountConnectionLinkRetrieveParams.none(), requestOptions)

    /** Revoke an X account connection link */
    fun delete(id: String): CompletableFuture<AccountConnectionLinkDeleteResponse> =
        delete(id, AccountConnectionLinkDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionLinkDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
    ): CompletableFuture<AccountConnectionLinkDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AccountConnectionLinkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionLinkDeleteResponse>

    /** @see delete */
    fun delete(
        params: AccountConnectionLinkDeleteParams
    ): CompletableFuture<AccountConnectionLinkDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountConnectionLinkDeleteResponse> =
        delete(id, AccountConnectionLinkDeleteParams.none(), requestOptions)

    /**
     * A view of [AccountConnectionLinkServiceAsync] that provides access to raw HTTP responses for
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
        ): AccountConnectionLinkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/account-connection-links`, but is otherwise the
         * same as [AccountConnectionLinkServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<AccountConnectionLinkCreateResponse>> =
            create(AccountConnectionLinkCreateParams.none())

        /** @see create */
        fun create(
            params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkCreateResponse>>

        /** @see create */
        fun create(
            params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none()
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkCreateResponse>> =
            create(AccountConnectionLinkCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/account-connection-links/{id}`, but is otherwise
         * the same as [AccountConnectionLinkServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<AccountConnectionLink>> =
            retrieve(id, AccountConnectionLinkRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountConnectionLinkRetrieveParams =
                AccountConnectionLinkRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLink>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AccountConnectionLinkRetrieveParams =
                AccountConnectionLinkRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLink>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AccountConnectionLinkRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLink>>

        /** @see retrieve */
        fun retrieve(
            params: AccountConnectionLinkRetrieveParams
        ): CompletableFuture<HttpResponseFor<AccountConnectionLink>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountConnectionLink>> =
            retrieve(id, AccountConnectionLinkRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /x/account-connection-links/{id}`, but is
         * otherwise the same as [AccountConnectionLinkServiceAsync.delete].
         */
        fun delete(
            id: String
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>> =
            delete(id, AccountConnectionLinkDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AccountConnectionLinkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>>

        /** @see delete */
        fun delete(
            params: AccountConnectionLinkDeleteParams
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountConnectionLinkDeleteResponse>> =
            delete(id, AccountConnectionLinkDeleteParams.none(), requestOptions)
    }
}
