// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitParams
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitResponse
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionChallengeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountConnectionChallengeService

    /** Submit X account email verification code */
    fun submit(
        id: String,
        params: AccountConnectionChallengeSubmitParams,
    ): AccountConnectionChallengeSubmitResponse = submit(id, params, RequestOptions.none())

    /** @see submit */
    fun submit(
        id: String,
        params: AccountConnectionChallengeSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionChallengeSubmitResponse =
        submit(params.toBuilder().id(id).build(), requestOptions)

    /** @see submit */
    fun submit(
        params: AccountConnectionChallengeSubmitParams
    ): AccountConnectionChallengeSubmitResponse = submit(params, RequestOptions.none())

    /** @see submit */
    fun submit(
        params: AccountConnectionChallengeSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountConnectionChallengeSubmitResponse

    /**
     * A view of [AccountConnectionChallengeService] that provides access to raw HTTP responses for
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
        ): AccountConnectionChallengeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/account-connection-challenges/{id}/submit`, but
         * is otherwise the same as [AccountConnectionChallengeService.submit].
         */
        @MustBeClosed
        fun submit(
            id: String,
            params: AccountConnectionChallengeSubmitParams,
        ): HttpResponseFor<AccountConnectionChallengeSubmitResponse> =
            submit(id, params, RequestOptions.none())

        /** @see submit */
        @MustBeClosed
        fun submit(
            id: String,
            params: AccountConnectionChallengeSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionChallengeSubmitResponse> =
            submit(params.toBuilder().id(id).build(), requestOptions)

        /** @see submit */
        @MustBeClosed
        fun submit(
            params: AccountConnectionChallengeSubmitParams
        ): HttpResponseFor<AccountConnectionChallengeSubmitResponse> =
            submit(params, RequestOptions.none())

        /** @see submit */
        @MustBeClosed
        fun submit(
            params: AccountConnectionChallengeSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountConnectionChallengeSubmitResponse>
    }
}
