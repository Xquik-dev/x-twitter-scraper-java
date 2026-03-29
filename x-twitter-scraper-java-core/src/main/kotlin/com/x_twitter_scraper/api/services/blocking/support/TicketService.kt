// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.support

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateParams
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateResponse
import com.x_twitter_scraper.api.models.support.tickets.TicketListParams
import com.x_twitter_scraper.api.models.support.tickets.TicketListResponse
import com.x_twitter_scraper.api.models.support.tickets.TicketReplyParams
import com.x_twitter_scraper.api.models.support.tickets.TicketReplyResponse
import com.x_twitter_scraper.api.models.support.tickets.TicketRetrieveParams
import com.x_twitter_scraper.api.models.support.tickets.TicketRetrieveResponse
import com.x_twitter_scraper.api.models.support.tickets.TicketUpdateParams
import com.x_twitter_scraper.api.models.support.tickets.TicketUpdateResponse
import java.util.function.Consumer

/** Support ticket management */
interface TicketService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TicketService

    /** Create a support ticket */
    fun create(params: TicketCreateParams): TicketCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TicketCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketCreateResponse

    /** Get ticket with all messages */
    fun retrieve(id: String): TicketRetrieveResponse = retrieve(id, TicketRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TicketRetrieveParams = TicketRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TicketRetrieveParams = TicketRetrieveParams.none(),
    ): TicketRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TicketRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: TicketRetrieveParams): TicketRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): TicketRetrieveResponse =
        retrieve(id, TicketRetrieveParams.none(), requestOptions)

    /** Update ticket status */
    fun update(id: String, params: TicketUpdateParams): TicketUpdateResponse =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: TicketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: TicketUpdateParams): TicketUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TicketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketUpdateResponse

    /** List user's support tickets */
    fun list(): TicketListResponse = list(TicketListParams.none())

    /** @see list */
    fun list(
        params: TicketListParams = TicketListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketListResponse

    /** @see list */
    fun list(params: TicketListParams = TicketListParams.none()): TicketListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): TicketListResponse =
        list(TicketListParams.none(), requestOptions)

    /** Reply to a support ticket */
    fun reply(id: String, params: TicketReplyParams): TicketReplyResponse =
        reply(id, params, RequestOptions.none())

    /** @see reply */
    fun reply(
        id: String,
        params: TicketReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketReplyResponse = reply(params.toBuilder().id(id).build(), requestOptions)

    /** @see reply */
    fun reply(params: TicketReplyParams): TicketReplyResponse = reply(params, RequestOptions.none())

    /** @see reply */
    fun reply(
        params: TicketReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TicketReplyResponse

    /** A view of [TicketService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TicketService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /support/tickets`, but is otherwise the same as
         * [TicketService.create].
         */
        @MustBeClosed
        fun create(params: TicketCreateParams): HttpResponseFor<TicketCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TicketCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketCreateResponse>

        /**
         * Returns a raw HTTP response for `get /support/tickets/{id}`, but is otherwise the same as
         * [TicketService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<TicketRetrieveResponse> =
            retrieve(id, TicketRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TicketRetrieveParams = TicketRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TicketRetrieveParams = TicketRetrieveParams.none(),
        ): HttpResponseFor<TicketRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TicketRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TicketRetrieveParams): HttpResponseFor<TicketRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TicketRetrieveResponse> =
            retrieve(id, TicketRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /support/tickets/{id}`, but is otherwise the same
         * as [TicketService.update].
         */
        @MustBeClosed
        fun update(id: String, params: TicketUpdateParams): HttpResponseFor<TicketUpdateResponse> =
            update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: TicketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: TicketUpdateParams): HttpResponseFor<TicketUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: TicketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /support/tickets`, but is otherwise the same as
         * [TicketService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<TicketListResponse> = list(TicketListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TicketListParams = TicketListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: TicketListParams = TicketListParams.none()
        ): HttpResponseFor<TicketListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TicketListResponse> =
            list(TicketListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /support/tickets/{id}/messages`, but is otherwise
         * the same as [TicketService.reply].
         */
        @MustBeClosed
        fun reply(id: String, params: TicketReplyParams): HttpResponseFor<TicketReplyResponse> =
            reply(id, params, RequestOptions.none())

        /** @see reply */
        @MustBeClosed
        fun reply(
            id: String,
            params: TicketReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketReplyResponse> =
            reply(params.toBuilder().id(id).build(), requestOptions)

        /** @see reply */
        @MustBeClosed
        fun reply(params: TicketReplyParams): HttpResponseFor<TicketReplyResponse> =
            reply(params, RequestOptions.none())

        /** @see reply */
        @MustBeClosed
        fun reply(
            params: TicketReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TicketReplyResponse>
    }
}
