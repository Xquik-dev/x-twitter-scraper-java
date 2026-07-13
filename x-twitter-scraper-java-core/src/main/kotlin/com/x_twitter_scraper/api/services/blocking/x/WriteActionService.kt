// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.writeactions.WriteActionRetrieveParams
import com.x_twitter_scraper.api.models.x.writeactions.WriteActionRetrieveResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface WriteActionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WriteActionService

    /** Get write action status */
    fun retrieve(id: String): WriteActionRetrieveResponse =
        retrieve(id, WriteActionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WriteActionRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
    ): WriteActionRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WriteActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WriteActionRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: WriteActionRetrieveParams): WriteActionRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): WriteActionRetrieveResponse =
        retrieve(id, WriteActionRetrieveParams.none(), requestOptions)

    /**
     * A view of [WriteActionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WriteActionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/write-actions/{id}`, but is otherwise the same as
         * [WriteActionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<WriteActionRetrieveResponse> =
            retrieve(id, WriteActionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WriteActionRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
        ): HttpResponseFor<WriteActionRetrieveResponse> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WriteActionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WriteActionRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WriteActionRetrieveParams
        ): HttpResponseFor<WriteActionRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WriteActionRetrieveResponse> =
            retrieve(id, WriteActionRetrieveParams.none(), requestOptions)
    }
}
