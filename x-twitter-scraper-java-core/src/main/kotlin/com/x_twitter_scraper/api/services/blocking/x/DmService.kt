// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryResponse
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import com.x_twitter_scraper.api.models.x.dm.DmSendResponse
import java.util.function.Consumer

interface DmService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmService

    /** Get DM conversation history */
    fun retrieveHistory(userId: String): DmRetrieveHistoryResponse =
        retrieveHistory(userId, DmRetrieveHistoryParams.none())

    /** @see retrieveHistory */
    fun retrieveHistory(
        userId: String,
        params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DmRetrieveHistoryResponse =
        retrieveHistory(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieveHistory */
    fun retrieveHistory(
        userId: String,
        params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
    ): DmRetrieveHistoryResponse = retrieveHistory(userId, params, RequestOptions.none())

    /** @see retrieveHistory */
    fun retrieveHistory(
        params: DmRetrieveHistoryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DmRetrieveHistoryResponse

    /** @see retrieveHistory */
    fun retrieveHistory(params: DmRetrieveHistoryParams): DmRetrieveHistoryResponse =
        retrieveHistory(params, RequestOptions.none())

    /** @see retrieveHistory */
    fun retrieveHistory(userId: String, requestOptions: RequestOptions): DmRetrieveHistoryResponse =
        retrieveHistory(userId, DmRetrieveHistoryParams.none(), requestOptions)

    /** Send direct message */
    fun send(userId: String, params: DmSendParams): DmSendResponse =
        send(userId, params, RequestOptions.none())

    /** @see send */
    fun send(
        userId: String,
        params: DmSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DmSendResponse = send(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see send */
    fun send(params: DmSendParams): DmSendResponse = send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: DmSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DmSendResponse

    /** A view of [DmService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/dm/{userId}/history`, but is otherwise the same
         * as [DmService.retrieveHistory].
         */
        @MustBeClosed
        fun retrieveHistory(userId: String): HttpResponseFor<DmRetrieveHistoryResponse> =
            retrieveHistory(userId, DmRetrieveHistoryParams.none())

        /** @see retrieveHistory */
        @MustBeClosed
        fun retrieveHistory(
            userId: String,
            params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DmRetrieveHistoryResponse> =
            retrieveHistory(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieveHistory */
        @MustBeClosed
        fun retrieveHistory(
            userId: String,
            params: DmRetrieveHistoryParams = DmRetrieveHistoryParams.none(),
        ): HttpResponseFor<DmRetrieveHistoryResponse> =
            retrieveHistory(userId, params, RequestOptions.none())

        /** @see retrieveHistory */
        @MustBeClosed
        fun retrieveHistory(
            params: DmRetrieveHistoryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DmRetrieveHistoryResponse>

        /** @see retrieveHistory */
        @MustBeClosed
        fun retrieveHistory(
            params: DmRetrieveHistoryParams
        ): HttpResponseFor<DmRetrieveHistoryResponse> =
            retrieveHistory(params, RequestOptions.none())

        /** @see retrieveHistory */
        @MustBeClosed
        fun retrieveHistory(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmRetrieveHistoryResponse> =
            retrieveHistory(userId, DmRetrieveHistoryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/dm/{userId}`, but is otherwise the same as
         * [DmService.send].
         */
        @MustBeClosed
        fun send(userId: String, params: DmSendParams): HttpResponseFor<DmSendResponse> =
            send(userId, params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            userId: String,
            params: DmSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DmSendResponse> =
            send(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see send */
        @MustBeClosed
        fun send(params: DmSendParams): HttpResponseFor<DmSendResponse> =
            send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: DmSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DmSendResponse>
    }
}
