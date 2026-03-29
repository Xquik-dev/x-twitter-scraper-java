// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.events.EventListParams
import com.x_twitter_scraper.api.models.events.EventListResponse
import com.x_twitter_scraper.api.models.events.EventRetrieveParams
import com.x_twitter_scraper.api.models.events.EventRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Activity events from monitored accounts */
interface EventServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventServiceAsync

    /** Get event */
    fun retrieve(id: String): CompletableFuture<EventRetrieveResponse> =
        retrieve(id, EventRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EventRetrieveParams = EventRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EventRetrieveParams = EventRetrieveParams.none(),
    ): CompletableFuture<EventRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: EventRetrieveParams): CompletableFuture<EventRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EventRetrieveResponse> =
        retrieve(id, EventRetrieveParams.none(), requestOptions)

    /** List events */
    fun list(): CompletableFuture<EventListResponse> = list(EventListParams.none())

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventListResponse>

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none()
    ): CompletableFuture<EventListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<EventListResponse> =
        list(EventListParams.none(), requestOptions)

    /** A view of [EventServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /events/{id}`, but is otherwise the same as
         * [EventServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<EventRetrieveResponse>> =
            retrieve(id, EventRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<EventRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: EventRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: EventRetrieveParams
        ): CompletableFuture<HttpResponseFor<EventRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EventRetrieveResponse>> =
            retrieve(id, EventRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /events`, but is otherwise the same as
         * [EventServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<EventListResponse>> =
            list(EventListParams.none())

        /** @see list */
        fun list(
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventListResponse>>

        /** @see list */
        fun list(
            params: EventListParams = EventListParams.none()
        ): CompletableFuture<HttpResponseFor<EventListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<EventListResponse>> =
            list(EventListParams.none(), requestOptions)
    }
}
