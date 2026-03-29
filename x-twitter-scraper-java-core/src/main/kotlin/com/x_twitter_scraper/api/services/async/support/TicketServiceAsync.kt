// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.support

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Support ticket management */
interface TicketServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TicketServiceAsync

    /** Create a support ticket */
    fun create(params: TicketCreateParams): CompletableFuture<TicketCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TicketCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketCreateResponse>

    /** Get ticket with all messages */
    fun retrieve(id: String): CompletableFuture<TicketRetrieveResponse> =
        retrieve(id, TicketRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TicketRetrieveParams = TicketRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TicketRetrieveParams = TicketRetrieveParams.none(),
    ): CompletableFuture<TicketRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TicketRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: TicketRetrieveParams): CompletableFuture<TicketRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TicketRetrieveResponse> =
        retrieve(id, TicketRetrieveParams.none(), requestOptions)

    /** Update ticket status */
    fun update(id: String, params: TicketUpdateParams): CompletableFuture<TicketUpdateResponse> =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: TicketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: TicketUpdateParams): CompletableFuture<TicketUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TicketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketUpdateResponse>

    /** List user's support tickets */
    fun list(): CompletableFuture<TicketListResponse> = list(TicketListParams.none())

    /** @see list */
    fun list(
        params: TicketListParams = TicketListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketListResponse>

    /** @see list */
    fun list(
        params: TicketListParams = TicketListParams.none()
    ): CompletableFuture<TicketListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<TicketListResponse> =
        list(TicketListParams.none(), requestOptions)

    /** Reply to a support ticket */
    fun reply(id: String, params: TicketReplyParams): CompletableFuture<TicketReplyResponse> =
        reply(id, params, RequestOptions.none())

    /** @see reply */
    fun reply(
        id: String,
        params: TicketReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketReplyResponse> =
        reply(params.toBuilder().id(id).build(), requestOptions)

    /** @see reply */
    fun reply(params: TicketReplyParams): CompletableFuture<TicketReplyResponse> =
        reply(params, RequestOptions.none())

    /** @see reply */
    fun reply(
        params: TicketReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TicketReplyResponse>

    /**
     * A view of [TicketServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TicketServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /support/tickets`, but is otherwise the same as
         * [TicketServiceAsync.create].
         */
        fun create(
            params: TicketCreateParams
        ): CompletableFuture<HttpResponseFor<TicketCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TicketCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /support/tickets/{id}`, but is otherwise the same as
         * [TicketServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>> =
            retrieve(id, TicketRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TicketRetrieveParams = TicketRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TicketRetrieveParams = TicketRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TicketRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: TicketRetrieveParams
        ): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TicketRetrieveResponse>> =
            retrieve(id, TicketRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /support/tickets/{id}`, but is otherwise the same
         * as [TicketServiceAsync.update].
         */
        fun update(
            id: String,
            params: TicketUpdateParams,
        ): CompletableFuture<HttpResponseFor<TicketUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            params: TicketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            params: TicketUpdateParams
        ): CompletableFuture<HttpResponseFor<TicketUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: TicketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketUpdateResponse>>

        /**
         * Returns a raw HTTP response for `get /support/tickets`, but is otherwise the same as
         * [TicketServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TicketListResponse>> =
            list(TicketListParams.none())

        /** @see list */
        fun list(
            params: TicketListParams = TicketListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketListResponse>>

        /** @see list */
        fun list(
            params: TicketListParams = TicketListParams.none()
        ): CompletableFuture<HttpResponseFor<TicketListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TicketListResponse>> =
            list(TicketListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /support/tickets/{id}/messages`, but is otherwise
         * the same as [TicketServiceAsync.reply].
         */
        fun reply(
            id: String,
            params: TicketReplyParams,
        ): CompletableFuture<HttpResponseFor<TicketReplyResponse>> =
            reply(id, params, RequestOptions.none())

        /** @see reply */
        fun reply(
            id: String,
            params: TicketReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketReplyResponse>> =
            reply(params.toBuilder().id(id).build(), requestOptions)

        /** @see reply */
        fun reply(
            params: TicketReplyParams
        ): CompletableFuture<HttpResponseFor<TicketReplyResponse>> =
            reply(params, RequestOptions.none())

        /** @see reply */
        fun reply(
            params: TicketReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TicketReplyResponse>>
    }
}
