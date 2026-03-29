// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

/** Giveaway draws from tweet replies */
interface DrawService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DrawService

    /** Get draw details */
    fun retrieve(id: String): DrawRetrieveResponse = retrieve(id, DrawRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DrawRetrieveParams = DrawRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DrawRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DrawRetrieveParams = DrawRetrieveParams.none(),
    ): DrawRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DrawRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DrawRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: DrawRetrieveParams): DrawRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): DrawRetrieveResponse =
        retrieve(id, DrawRetrieveParams.none(), requestOptions)

    /** List draws */
    fun list(): DrawListResponse = list(DrawListParams.none())

    /** @see list */
    fun list(
        params: DrawListParams = DrawListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DrawListResponse

    /** @see list */
    fun list(params: DrawListParams = DrawListParams.none()): DrawListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): DrawListResponse =
        list(DrawListParams.none(), requestOptions)

    /** Export draw data */
    @MustBeClosed fun export(id: String): HttpResponse = export(id, DrawExportParams.none())

    /** @see export */
    @MustBeClosed
    fun export(
        id: String,
        params: DrawExportParams = DrawExportParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = export(params.toBuilder().id(id).build(), requestOptions)

    /** @see export */
    @MustBeClosed
    fun export(id: String, params: DrawExportParams = DrawExportParams.none()): HttpResponse =
        export(id, params, RequestOptions.none())

    /** @see export */
    @MustBeClosed
    fun export(
        params: DrawExportParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see export */
    @MustBeClosed
    fun export(params: DrawExportParams): HttpResponse = export(params, RequestOptions.none())

    /** @see export */
    @MustBeClosed
    fun export(id: String, requestOptions: RequestOptions): HttpResponse =
        export(id, DrawExportParams.none(), requestOptions)

    /** Run giveaway draw */
    fun run(params: DrawRunParams): DrawRunResponse = run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: DrawRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DrawRunResponse

    /** A view of [DrawService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DrawService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /draws/{id}`, but is otherwise the same as
         * [DrawService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<DrawRetrieveResponse> =
            retrieve(id, DrawRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DrawRetrieveParams = DrawRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DrawRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DrawRetrieveParams = DrawRetrieveParams.none(),
        ): HttpResponseFor<DrawRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DrawRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DrawRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: DrawRetrieveParams): HttpResponseFor<DrawRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DrawRetrieveResponse> =
            retrieve(id, DrawRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /draws`, but is otherwise the same as
         * [DrawService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<DrawListResponse> = list(DrawListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: DrawListParams = DrawListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DrawListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: DrawListParams = DrawListParams.none()
        ): HttpResponseFor<DrawListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<DrawListResponse> =
            list(DrawListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /draws/{id}/export`, but is otherwise the same as
         * [DrawService.export].
         */
        @MustBeClosed fun export(id: String): HttpResponse = export(id, DrawExportParams.none())

        /** @see export */
        @MustBeClosed
        fun export(
            id: String,
            params: DrawExportParams = DrawExportParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = export(params.toBuilder().id(id).build(), requestOptions)

        /** @see export */
        @MustBeClosed
        fun export(id: String, params: DrawExportParams = DrawExportParams.none()): HttpResponse =
            export(id, params, RequestOptions.none())

        /** @see export */
        @MustBeClosed
        fun export(
            params: DrawExportParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see export */
        @MustBeClosed
        fun export(params: DrawExportParams): HttpResponse = export(params, RequestOptions.none())

        /** @see export */
        @MustBeClosed
        fun export(id: String, requestOptions: RequestOptions): HttpResponse =
            export(id, DrawExportParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /draws`, but is otherwise the same as
         * [DrawService.run].
         */
        @MustBeClosed
        fun run(params: DrawRunParams): HttpResponseFor<DrawRunResponse> =
            run(params, RequestOptions.none())

        /** @see run */
        @MustBeClosed
        fun run(
            params: DrawRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DrawRunResponse>
    }
}
