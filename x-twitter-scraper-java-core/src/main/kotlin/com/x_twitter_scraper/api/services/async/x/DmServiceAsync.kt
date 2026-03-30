// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryResponse
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import com.x_twitter_scraper.api.models.x.dm.DmSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface DmServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmServiceAsync

    /** Get DM conversation history */
    fun retrieveHistory(userId: String): CompletableFuture<DmRetrieveHistoryResponse> =
        retrieveHistory(userId, DmRetrieveHistoryParams.none())

    /** @see retrieveHistory */
    fun retrieveHistory(
        userId: String,
        params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DmRetrieveHistoryResponse> =
        retrieveHistory(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieveHistory */
    fun retrieveHistory(
        userId: String,
        params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
    ): CompletableFuture<DmRetrieveHistoryResponse> =
        retrieveHistory(userId, params, RequestOptions.none())

    /** @see retrieveHistory */
    fun retrieveHistory(
        params: DmRetrieveHistoryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DmRetrieveHistoryResponse>

    /** @see retrieveHistory */
    fun retrieveHistory(
        params: DmRetrieveHistoryParams
    ): CompletableFuture<DmRetrieveHistoryResponse> = retrieveHistory(params, RequestOptions.none())

    /** @see retrieveHistory */
    fun retrieveHistory(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DmRetrieveHistoryResponse> =
        retrieveHistory(userId, DmRetrieveHistoryParams.none(), requestOptions)

    /** Send direct message */
    fun send(userId: String, params: DmSendParams): CompletableFuture<DmSendResponse> =
        send(userId, params, RequestOptions.none())

    /** @see send */
    fun send(
        userId: String,
        params: DmSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DmSendResponse> =
        send(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see send */
    fun send(params: DmSendParams): CompletableFuture<DmSendResponse> =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: DmSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DmSendResponse>

    /** A view of [DmServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/dm/{userId}/history`, but is otherwise the same
         * as [DmServiceAsync.retrieveHistory].
         */
        fun retrieveHistory(
            userId: String
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> =
            retrieveHistory(userId, DmRetrieveHistoryParams.none())

        /** @see retrieveHistory */
        fun retrieveHistory(
            userId: String,
            params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> =
            retrieveHistory(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieveHistory */
        fun retrieveHistory(
            userId: String,
            params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> =
            retrieveHistory(userId, params, RequestOptions.none())

        /** @see retrieveHistory */
        fun retrieveHistory(
            params: DmRetrieveHistoryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>>

        /** @see retrieveHistory */
        fun retrieveHistory(
            params: DmRetrieveHistoryParams
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> =
            retrieveHistory(params, RequestOptions.none())

        /** @see retrieveHistory */
        fun retrieveHistory(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> =
            retrieveHistory(userId, DmRetrieveHistoryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/dm/{userId}`, but is otherwise the same as
         * [DmServiceAsync.send].
         */
        fun send(
            userId: String,
            params: DmSendParams,
        ): CompletableFuture<HttpResponseFor<DmSendResponse>> =
            send(userId, params, RequestOptions.none())

        /** @see send */
        fun send(
            userId: String,
            params: DmSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DmSendResponse>> =
            send(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see send */
        fun send(params: DmSendParams): CompletableFuture<HttpResponseFor<DmSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            params: DmSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DmSendResponse>>
    }
}
