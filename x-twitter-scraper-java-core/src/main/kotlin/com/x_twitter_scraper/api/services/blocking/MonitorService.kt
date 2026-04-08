// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.monitors.Monitor
import com.x_twitter_scraper.api.models.monitors.MonitorCreateParams
import com.x_twitter_scraper.api.models.monitors.MonitorCreateResponse
import com.x_twitter_scraper.api.models.monitors.MonitorDeactivateParams
import com.x_twitter_scraper.api.models.monitors.MonitorDeactivateResponse
import com.x_twitter_scraper.api.models.monitors.MonitorListParams
import com.x_twitter_scraper.api.models.monitors.MonitorListResponse
import com.x_twitter_scraper.api.models.monitors.MonitorRetrieveParams
import com.x_twitter_scraper.api.models.monitors.MonitorUpdateParams
import java.util.function.Consumer

/** Real-time X account monitoring */
interface MonitorService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MonitorService

    /** Create monitor */
    fun create(params: MonitorCreateParams): MonitorCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: MonitorCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MonitorCreateResponse

    /** Get monitor */
    fun retrieve(id: String): Monitor = retrieve(id, MonitorRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Monitor = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
    ): Monitor = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MonitorRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Monitor

    /** @see retrieve */
    fun retrieve(params: MonitorRetrieveParams): Monitor = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): Monitor =
        retrieve(id, MonitorRetrieveParams.none(), requestOptions)

    /** Update monitor */
    fun update(id: String): Monitor = update(id, MonitorUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: MonitorUpdateParams = MonitorUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Monitor = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(id: String, params: MonitorUpdateParams = MonitorUpdateParams.none()): Monitor =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: MonitorUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Monitor

    /** @see update */
    fun update(params: MonitorUpdateParams): Monitor = update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): Monitor =
        update(id, MonitorUpdateParams.none(), requestOptions)

    /** List monitors */
    fun list(): MonitorListResponse = list(MonitorListParams.none())

    /** @see list */
    fun list(
        params: MonitorListParams = MonitorListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MonitorListResponse

    /** @see list */
    fun list(params: MonitorListParams = MonitorListParams.none()): MonitorListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): MonitorListResponse =
        list(MonitorListParams.none(), requestOptions)

    /** Deactivate monitor */
    fun deactivate(id: String): MonitorDeactivateResponse =
        deactivate(id, MonitorDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MonitorDeactivateResponse = deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
    ): MonitorDeactivateResponse = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: MonitorDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MonitorDeactivateResponse

    /** @see deactivate */
    fun deactivate(params: MonitorDeactivateParams): MonitorDeactivateResponse =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(id: String, requestOptions: RequestOptions): MonitorDeactivateResponse =
        deactivate(id, MonitorDeactivateParams.none(), requestOptions)

    /** A view of [MonitorService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MonitorService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors`, but is otherwise the same as
         * [MonitorService.create].
         */
        @MustBeClosed
        fun create(params: MonitorCreateParams): HttpResponseFor<MonitorCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: MonitorCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MonitorCreateResponse>

        /**
         * Returns a raw HTTP response for `get /monitors/{id}`, but is otherwise the same as
         * [MonitorService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<Monitor> =
            retrieve(id, MonitorRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Monitor> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
        ): HttpResponseFor<Monitor> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MonitorRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Monitor>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MonitorRetrieveParams): HttpResponseFor<Monitor> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Monitor> =
            retrieve(id, MonitorRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/{id}`, but is otherwise the same as
         * [MonitorService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<Monitor> = update(id, MonitorUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: MonitorUpdateParams = MonitorUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Monitor> = update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: MonitorUpdateParams = MonitorUpdateParams.none(),
        ): HttpResponseFor<Monitor> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: MonitorUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Monitor>

        /** @see update */
        @MustBeClosed
        fun update(params: MonitorUpdateParams): HttpResponseFor<Monitor> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(id: String, requestOptions: RequestOptions): HttpResponseFor<Monitor> =
            update(id, MonitorUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors`, but is otherwise the same as
         * [MonitorService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<MonitorListResponse> = list(MonitorListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: MonitorListParams = MonitorListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MonitorListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: MonitorListParams = MonitorListParams.none()
        ): HttpResponseFor<MonitorListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<MonitorListResponse> =
            list(MonitorListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/{id}`, but is otherwise the same as
         * [MonitorService.deactivate].
         */
        @MustBeClosed
        fun deactivate(id: String): HttpResponseFor<MonitorDeactivateResponse> =
            deactivate(id, MonitorDeactivateParams.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MonitorDeactivateResponse> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
        ): HttpResponseFor<MonitorDeactivateResponse> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: MonitorDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MonitorDeactivateResponse>

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: MonitorDeactivateParams
        ): HttpResponseFor<MonitorDeactivateResponse> = deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MonitorDeactivateResponse> =
            deactivate(id, MonitorDeactivateParams.none(), requestOptions)
    }
}
