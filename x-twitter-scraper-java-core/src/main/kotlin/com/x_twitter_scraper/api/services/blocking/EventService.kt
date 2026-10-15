// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.StreamResponse
import com.x_twitter_scraper.api.models.events.Event
import com.x_twitter_scraper.api.models.events.EventDetail
import com.x_twitter_scraper.api.models.events.EventListParams
import com.x_twitter_scraper.api.models.events.EventListResponse
import com.x_twitter_scraper.api.models.events.EventRetrieveParams
import com.x_twitter_scraper.api.models.events.EventStreamParams
import java.util.function.Consumer

/** Activity events from monitored accounts */
interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService

    /** Get event */
    fun retrieve(id: String): EventDetail = retrieve(id, EventRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EventRetrieveParams = EventRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventDetail = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EventRetrieveParams = EventRetrieveParams.none(),
    ): EventDetail = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventDetail

    /** @see retrieve */
    fun retrieve(params: EventRetrieveParams): EventDetail = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): EventDetail =
        retrieve(id, EventRetrieveParams.none(), requestOptions)

    /** List events */
    fun list(): EventListResponse = list(EventListParams.none())

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventListResponse

    /** @see list */
    fun list(params: EventListParams = EventListParams.none()): EventListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EventListResponse =
        list(EventListParams.none(), requestOptions)

    /**
     * Streams the account's monitor events as server-sent events, each named by its event type and
     * numbered by its event ID. A reconnect that sends Last-Event-ID first gets every event after
     * that one from the last 30 days, then each new event. A connection lasts up to 30 minutes and
     * sends a comment every 15 seconds while idle. Keep up to 5 streams open per account. Events
     * and streams cost no credits.
     */
    @MustBeClosed fun stream(): StreamResponse<Event> = stream(EventStreamParams.none())

    /** @see stream */
    @MustBeClosed
    fun stream(
        params: EventStreamParams = EventStreamParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<Event>

    /** @see stream */
    @MustBeClosed
    fun stream(params: EventStreamParams = EventStreamParams.none()): StreamResponse<Event> =
        stream(params, RequestOptions.none())

    /** @see stream */
    @MustBeClosed
    fun stream(requestOptions: RequestOptions): StreamResponse<Event> =
        stream(EventStreamParams.none(), requestOptions)

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /events/{id}`, but is otherwise the same as
         * [EventService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<EventDetail> =
            retrieve(id, EventRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventDetail> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
        ): HttpResponseFor<EventDetail> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: EventRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventDetail>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: EventRetrieveParams): HttpResponseFor<EventDetail> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<EventDetail> =
            retrieve(id, EventRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /events`, but is otherwise the same as
         * [EventService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<EventListResponse> = list(EventListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventListParams = EventListParams.none()
        ): HttpResponseFor<EventListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EventListResponse> =
            list(EventListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /events/stream`, but is otherwise the same as
         * [EventService.stream].
         */
        @MustBeClosed
        fun stream(): HttpResponseFor<StreamResponse<Event>> = stream(EventStreamParams.none())

        /** @see stream */
        @MustBeClosed
        fun stream(
            params: EventStreamParams = EventStreamParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<Event>>

        /** @see stream */
        @MustBeClosed
        fun stream(
            params: EventStreamParams = EventStreamParams.none()
        ): HttpResponseFor<StreamResponse<Event>> = stream(params, RequestOptions.none())

        /** @see stream */
        @MustBeClosed
        fun stream(requestOptions: RequestOptions): HttpResponseFor<StreamResponse<Event>> =
            stream(EventStreamParams.none(), requestOptions)
    }
}
