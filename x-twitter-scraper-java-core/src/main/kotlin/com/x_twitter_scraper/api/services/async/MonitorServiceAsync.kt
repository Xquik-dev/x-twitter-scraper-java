// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.monitors.MonitorCreateParams
import com.x_twitter_scraper.api.models.monitors.MonitorCreateResponse
import com.x_twitter_scraper.api.models.monitors.MonitorDeactivateParams
import com.x_twitter_scraper.api.models.monitors.MonitorDeactivateResponse
import com.x_twitter_scraper.api.models.monitors.MonitorListParams
import com.x_twitter_scraper.api.models.monitors.MonitorListResponse
import com.x_twitter_scraper.api.models.monitors.MonitorRetrieveParams
import com.x_twitter_scraper.api.models.monitors.MonitorRetrieveResponse
import com.x_twitter_scraper.api.models.monitors.MonitorUpdateParams
import com.x_twitter_scraper.api.models.monitors.MonitorUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Real-time X account monitoring */
interface MonitorServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MonitorServiceAsync

    /** Create monitor */
    fun create(params: MonitorCreateParams): CompletableFuture<MonitorCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: MonitorCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorCreateResponse>

    /** Get monitor */
    fun retrieve(id: String): CompletableFuture<MonitorRetrieveResponse> =
        retrieve(id, MonitorRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
    ): CompletableFuture<MonitorRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MonitorRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: MonitorRetrieveParams): CompletableFuture<MonitorRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MonitorRetrieveResponse> =
        retrieve(id, MonitorRetrieveParams.none(), requestOptions)

    /** Update monitor */
    fun update(id: String): CompletableFuture<MonitorUpdateResponse> =
        update(id, MonitorUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: MonitorUpdateParams = MonitorUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: MonitorUpdateParams = MonitorUpdateParams.none(),
    ): CompletableFuture<MonitorUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: MonitorUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorUpdateResponse>

    /** @see update */
    fun update(params: MonitorUpdateParams): CompletableFuture<MonitorUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MonitorUpdateResponse> =
        update(id, MonitorUpdateParams.none(), requestOptions)

    /** List monitors */
    fun list(): CompletableFuture<MonitorListResponse> = list(MonitorListParams.none())

    /** @see list */
    fun list(
        params: MonitorListParams = MonitorListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorListResponse>

    /** @see list */
    fun list(
        params: MonitorListParams = MonitorListParams.none()
    ): CompletableFuture<MonitorListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<MonitorListResponse> =
        list(MonitorListParams.none(), requestOptions)

    /** Deactivate monitor */
    fun deactivate(id: String): CompletableFuture<MonitorDeactivateResponse> =
        deactivate(id, MonitorDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorDeactivateResponse> =
        deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
    ): CompletableFuture<MonitorDeactivateResponse> = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: MonitorDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MonitorDeactivateResponse>

    /** @see deactivate */
    fun deactivate(params: MonitorDeactivateParams): CompletableFuture<MonitorDeactivateResponse> =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MonitorDeactivateResponse> =
        deactivate(id, MonitorDeactivateParams.none(), requestOptions)

    /**
     * A view of [MonitorServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MonitorServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors`, but is otherwise the same as
         * [MonitorServiceAsync.create].
         */
        fun create(
            params: MonitorCreateParams
        ): CompletableFuture<HttpResponseFor<MonitorCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: MonitorCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /monitors/{id}`, but is otherwise the same as
         * [MonitorServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>> =
            retrieve(id, MonitorRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: MonitorRetrieveParams = MonitorRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: MonitorRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: MonitorRetrieveParams
        ): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MonitorRetrieveResponse>> =
            retrieve(id, MonitorRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/{id}`, but is otherwise the same as
         * [MonitorServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>> =
            update(id, MonitorUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: MonitorUpdateParams = MonitorUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: MonitorUpdateParams = MonitorUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: MonitorUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>>

        /** @see update */
        fun update(
            params: MonitorUpdateParams
        ): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MonitorUpdateResponse>> =
            update(id, MonitorUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors`, but is otherwise the same as
         * [MonitorServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<MonitorListResponse>> =
            list(MonitorListParams.none())

        /** @see list */
        fun list(
            params: MonitorListParams = MonitorListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorListResponse>>

        /** @see list */
        fun list(
            params: MonitorListParams = MonitorListParams.none()
        ): CompletableFuture<HttpResponseFor<MonitorListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MonitorListResponse>> =
            list(MonitorListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/{id}`, but is otherwise the same as
         * [MonitorServiceAsync.deactivate].
         */
        fun deactivate(id: String): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>> =
            deactivate(id, MonitorDeactivateParams.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: MonitorDeactivateParams = MonitorDeactivateParams.none(),
        ): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            params: MonitorDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>>

        /** @see deactivate */
        fun deactivate(
            params: MonitorDeactivateParams
        ): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>> =
            deactivate(params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MonitorDeactivateResponse>> =
            deactivate(id, MonitorDeactivateParams.none(), requestOptions)
    }
}
