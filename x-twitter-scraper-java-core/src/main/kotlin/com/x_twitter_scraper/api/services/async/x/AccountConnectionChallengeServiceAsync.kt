// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitParams
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Connected X account management */
interface AccountConnectionChallengeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): AccountConnectionChallengeServiceAsync

    /** Submit X account email verification code */
    fun submit(
        id: String,
        params: AccountConnectionChallengeSubmitParams,
    ): CompletableFuture<AccountConnectionChallengeSubmitResponse> =
        submit(id, params, RequestOptions.none())

    /** @see submit */
    fun submit(
        id: String,
        params: AccountConnectionChallengeSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionChallengeSubmitResponse> =
        submit(params.toBuilder().id(id).build(), requestOptions)

    /** @see submit */
    fun submit(
        params: AccountConnectionChallengeSubmitParams
    ): CompletableFuture<AccountConnectionChallengeSubmitResponse> =
        submit(params, RequestOptions.none())

    /** @see submit */
    fun submit(
        params: AccountConnectionChallengeSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountConnectionChallengeSubmitResponse>

    /**
     * A view of [AccountConnectionChallengeServiceAsync] that provides access to raw HTTP responses
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
        ): AccountConnectionChallengeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/account-connection-challenges/{id}/submit`, but
         * is otherwise the same as [AccountConnectionChallengeServiceAsync.submit].
         */
        fun submit(
            id: String,
            params: AccountConnectionChallengeSubmitParams,
        ): CompletableFuture<HttpResponseFor<AccountConnectionChallengeSubmitResponse>> =
            submit(id, params, RequestOptions.none())

        /** @see submit */
        fun submit(
            id: String,
            params: AccountConnectionChallengeSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionChallengeSubmitResponse>> =
            submit(params.toBuilder().id(id).build(), requestOptions)

        /** @see submit */
        fun submit(
            params: AccountConnectionChallengeSubmitParams
        ): CompletableFuture<HttpResponseFor<AccountConnectionChallengeSubmitResponse>> =
            submit(params, RequestOptions.none())

        /** @see submit */
        fun submit(
            params: AccountConnectionChallengeSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountConnectionChallengeSubmitResponse>>
    }
}
