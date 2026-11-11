// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLink
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateParams
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateResponse
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkDeleteParams
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkDeleteResponse
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkRetrieveParams
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionLinkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountConnectionLinkService

    /**
     * Creates a link to a page Xquik hosts, where a person connects an X account with no Xquik
     * signup. Your backend never receives their password or 2FA secret, and the account belongs to
     * you. Send accountId to reconnect 1 of your accounts instead. Connecting is free. Takes a Full
     * access API key or a dashboard session.
     *
     * The link works for 30 minutes, and the response is the only place its token appears.
     */
    fun create(): AccountConnectionLinkCreateResponse =
        create(AccountConnectionLinkCreateParams.none())

    /** @see create */
    fun create(
        params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionLinkCreateResponse

    /** @see create */
    fun create(
        params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none()
    ): AccountConnectionLinkCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): AccountConnectionLinkCreateResponse =
        create(AccountConnectionLinkCreateParams.none(), requestOptions)

    /** Get an X account connection link */
    fun retrieve(id: String): AccountConnectionLink =
        retrieve(id, AccountConnectionLinkRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionLinkRetrieveParams = AccountConnectionLinkRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionLink = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AccountConnectionLinkRetrieveParams = AccountConnectionLinkRetrieveParams.none(),
    ): AccountConnectionLink = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountConnectionLinkRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionLink

    /** @see retrieve */
    fun retrieve(params: AccountConnectionLinkRetrieveParams): AccountConnectionLink =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): AccountConnectionLink =
        retrieve(id, AccountConnectionLinkRetrieveParams.none(), requestOptions)

    /** Revoke an X account connection link */
    fun delete(id: String): AccountConnectionLinkDeleteResponse =
        delete(id, AccountConnectionLinkDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionLinkDeleteResponse =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
    ): AccountConnectionLinkDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AccountConnectionLinkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionLinkDeleteResponse

    /** @see delete */
    fun delete(params: AccountConnectionLinkDeleteParams): AccountConnectionLinkDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): AccountConnectionLinkDeleteResponse =
        delete(id, AccountConnectionLinkDeleteParams.none(), requestOptions)

    /**
     * A view of [AccountConnectionLinkService] that provides access to raw HTTP responses for each
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
        ): AccountConnectionLinkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/account-connection-links`, but is otherwise the
         * same as [AccountConnectionLinkService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<AccountConnectionLinkCreateResponse> =
            create(AccountConnectionLinkCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionLinkCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: AccountConnectionLinkCreateParams = AccountConnectionLinkCreateParams.none()
        ): HttpResponseFor<AccountConnectionLinkCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            requestOptions: RequestOptions
        ): HttpResponseFor<AccountConnectionLinkCreateResponse> =
            create(AccountConnectionLinkCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/account-connection-links/{id}`, but is otherwise
         * the same as [AccountConnectionLinkService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<AccountConnectionLink> =
            retrieve(id, AccountConnectionLinkRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountConnectionLinkRetrieveParams =
                AccountConnectionLinkRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionLink> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AccountConnectionLinkRetrieveParams =
                AccountConnectionLinkRetrieveParams.none(),
        ): HttpResponseFor<AccountConnectionLink> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountConnectionLinkRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionLink>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountConnectionLinkRetrieveParams
        ): HttpResponseFor<AccountConnectionLink> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountConnectionLink> =
            retrieve(id, AccountConnectionLinkRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /x/account-connection-links/{id}`, but is
         * otherwise the same as [AccountConnectionLinkService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<AccountConnectionLinkDeleteResponse> =
            delete(id, AccountConnectionLinkDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionLinkDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: AccountConnectionLinkDeleteParams = AccountConnectionLinkDeleteParams.none(),
        ): HttpResponseFor<AccountConnectionLinkDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AccountConnectionLinkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionLinkDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AccountConnectionLinkDeleteParams
        ): HttpResponseFor<AccountConnectionLinkDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountConnectionLinkDeleteResponse> =
            delete(id, AccountConnectionLinkDeleteParams.none(), requestOptions)
    }
}
