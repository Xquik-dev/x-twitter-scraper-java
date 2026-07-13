// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.writeactions.WriteActionRetrieveParams
import com.x_twitter_scraper.api.models.x.writeactions.WriteActionRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface WriteActionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WriteActionServiceAsync

    /** Get write action status */
    fun retrieve(id: String): CompletableFuture<WriteActionRetrieveResponse> =
        retrieve(id, WriteActionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WriteActionRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
    ): CompletableFuture<WriteActionRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WriteActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WriteActionRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: WriteActionRetrieveParams
    ): CompletableFuture<WriteActionRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WriteActionRetrieveResponse> =
        retrieve(id, WriteActionRetrieveParams.none(), requestOptions)

    /**
     * A view of [WriteActionServiceAsync] that provides access to raw HTTP responses for each
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
        ): WriteActionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/write-actions/{id}`, but is otherwise the same as
         * [WriteActionServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>> =
            retrieve(id, WriteActionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WriteActionRetrieveParams = WriteActionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WriteActionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: WriteActionRetrieveParams
        ): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WriteActionRetrieveResponse>> =
            retrieve(id, WriteActionRetrieveParams.none(), requestOptions)
    }
}
