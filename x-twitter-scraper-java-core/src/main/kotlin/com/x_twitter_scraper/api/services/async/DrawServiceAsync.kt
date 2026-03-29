// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.draws.DrawExportParams
import com.x_twitter_scraper.api.models.draws.DrawListParams
import com.x_twitter_scraper.api.models.draws.DrawListResponse
import com.x_twitter_scraper.api.models.draws.DrawRetrieveParams
import com.x_twitter_scraper.api.models.draws.DrawRetrieveResponse
import com.x_twitter_scraper.api.models.draws.DrawRunParams
import com.x_twitter_scraper.api.models.draws.DrawRunResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Giveaway draws from tweet replies */
interface DrawServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DrawServiceAsync

    /** Get draw details */
    fun retrieve(id: String): CompletableFuture<DrawRetrieveResponse> =
        retrieve(id, DrawRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DrawRetrieveParams = DrawRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DrawRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DrawRetrieveParams = DrawRetrieveParams.none(),
    ): CompletableFuture<DrawRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DrawRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DrawRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: DrawRetrieveParams): CompletableFuture<DrawRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DrawRetrieveResponse> =
        retrieve(id, DrawRetrieveParams.none(), requestOptions)

    /** List draws */
    fun list(): CompletableFuture<DrawListResponse> = list(DrawListParams.none())

    /** @see list */
    fun list(
        params: DrawListParams = DrawListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DrawListResponse>

    /** @see list */
    fun list(params: DrawListParams = DrawListParams.none()): CompletableFuture<DrawListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<DrawListResponse> =
        list(DrawListParams.none(), requestOptions)

    /** Export draw data */
    fun export(id: String): CompletableFuture<HttpResponse> = export(id, DrawExportParams.none())

    /** @see export */
    fun export(
        id: String,
        params: DrawExportParams = DrawExportParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> = export(params.toBuilder().id(id).build(), requestOptions)

    /** @see export */
    fun export(
        id: String,
        params: DrawExportParams = DrawExportParams.none(),
    ): CompletableFuture<HttpResponse> = export(id, params, RequestOptions.none())

    /** @see export */
    fun export(
        params: DrawExportParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see export */
    fun export(params: DrawExportParams): CompletableFuture<HttpResponse> =
        export(params, RequestOptions.none())

    /** @see export */
    fun export(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
        export(id, DrawExportParams.none(), requestOptions)

    /** Run giveaway draw */
    fun run(params: DrawRunParams): CompletableFuture<DrawRunResponse> =
        run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: DrawRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DrawRunResponse>

    /** A view of [DrawServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DrawServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /draws/{id}`, but is otherwise the same as
         * [DrawServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>> =
            retrieve(id, DrawRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DrawRetrieveParams = DrawRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DrawRetrieveParams = DrawRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DrawRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: DrawRetrieveParams
        ): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DrawRetrieveResponse>> =
            retrieve(id, DrawRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /draws`, but is otherwise the same as
         * [DrawServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<DrawListResponse>> =
            list(DrawListParams.none())

        /** @see list */
        fun list(
            params: DrawListParams = DrawListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DrawListResponse>>

        /** @see list */
        fun list(
            params: DrawListParams = DrawListParams.none()
        ): CompletableFuture<HttpResponseFor<DrawListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<DrawListResponse>> =
            list(DrawListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /draws/{id}/export`, but is otherwise the same as
         * [DrawServiceAsync.export].
         */
        fun export(id: String): CompletableFuture<HttpResponse> =
            export(id, DrawExportParams.none())

        /** @see export */
        fun export(
            id: String,
            params: DrawExportParams = DrawExportParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            export(params.toBuilder().id(id).build(), requestOptions)

        /** @see export */
        fun export(
            id: String,
            params: DrawExportParams = DrawExportParams.none(),
        ): CompletableFuture<HttpResponse> = export(id, params, RequestOptions.none())

        /** @see export */
        fun export(
            params: DrawExportParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see export */
        fun export(params: DrawExportParams): CompletableFuture<HttpResponse> =
            export(params, RequestOptions.none())

        /** @see export */
        fun export(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            export(id, DrawExportParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /draws`, but is otherwise the same as
         * [DrawServiceAsync.run].
         */
        fun run(params: DrawRunParams): CompletableFuture<HttpResponseFor<DrawRunResponse>> =
            run(params, RequestOptions.none())

        /** @see run */
        fun run(
            params: DrawRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DrawRunResponse>>
    }
}
