// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.webhooks.Webhook
import com.x_twitter_scraper.api.models.webhooks.WebhookCreateParams
import com.x_twitter_scraper.api.models.webhooks.WebhookCreateResponse
import com.x_twitter_scraper.api.models.webhooks.WebhookDeactivateParams
import com.x_twitter_scraper.api.models.webhooks.WebhookDeactivateResponse
import com.x_twitter_scraper.api.models.webhooks.WebhookListDeliveriesParams
import com.x_twitter_scraper.api.models.webhooks.WebhookListDeliveriesResponse
import com.x_twitter_scraper.api.models.webhooks.WebhookListParams
import com.x_twitter_scraper.api.models.webhooks.WebhookListResponse
import com.x_twitter_scraper.api.models.webhooks.WebhookTestParams
import com.x_twitter_scraper.api.models.webhooks.WebhookTestResponse
import com.x_twitter_scraper.api.models.webhooks.WebhookUpdateParams
import java.util.function.Consumer

/** Webhook endpoint management & delivery */
interface WebhookService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService

    /** Create webhook */
    fun create(params: WebhookCreateParams): WebhookCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookCreateResponse

    /** Update webhook */
    fun update(id: String): Webhook = update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(id: String, params: WebhookUpdateParams = WebhookUpdateParams.none()): Webhook =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook

    /** @see update */
    fun update(params: WebhookUpdateParams): Webhook = update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): Webhook =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** List webhooks */
    fun list(): WebhookListResponse = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListResponse

    /** @see list */
    fun list(params: WebhookListParams = WebhookListParams.none()): WebhookListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): WebhookListResponse =
        list(WebhookListParams.none(), requestOptions)

    /** Deactivate webhook */
    fun deactivate(id: String): WebhookDeactivateResponse =
        deactivate(id, WebhookDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookDeactivateResponse = deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
    ): WebhookDeactivateResponse = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: WebhookDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookDeactivateResponse

    /** @see deactivate */
    fun deactivate(params: WebhookDeactivateParams): WebhookDeactivateResponse =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(id: String, requestOptions: RequestOptions): WebhookDeactivateResponse =
        deactivate(id, WebhookDeactivateParams.none(), requestOptions)

    /** List webhook deliveries */
    fun listDeliveries(id: String): WebhookListDeliveriesResponse =
        listDeliveries(id, WebhookListDeliveriesParams.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListDeliveriesResponse =
        listDeliveries(params.toBuilder().id(id).build(), requestOptions)

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
    ): WebhookListDeliveriesResponse = listDeliveries(id, params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        params: WebhookListDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListDeliveriesResponse

    /** @see listDeliveries */
    fun listDeliveries(params: WebhookListDeliveriesParams): WebhookListDeliveriesResponse =
        listDeliveries(params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(id: String, requestOptions: RequestOptions): WebhookListDeliveriesResponse =
        listDeliveries(id, WebhookListDeliveriesParams.none(), requestOptions)

    /** Test webhook endpoint */
    fun test(id: String): WebhookTestResponse = test(id, WebhookTestParams.none())

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookTestResponse = test(params.toBuilder().id(id).build(), requestOptions)

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
    ): WebhookTestResponse = test(id, params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookTestResponse

    /** @see test */
    fun test(params: WebhookTestParams): WebhookTestResponse = test(params, RequestOptions.none())

    /** @see test */
    fun test(id: String, requestOptions: RequestOptions): WebhookTestResponse =
        test(id, WebhookTestParams.none(), requestOptions)

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /webhooks`, but is otherwise the same as
         * [WebhookService.create].
         */
        @MustBeClosed
        fun create(params: WebhookCreateParams): HttpResponseFor<WebhookCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookCreateResponse>

        /**
         * Returns a raw HTTP response for `patch /webhooks/{id}`, but is otherwise the same as
         * [WebhookService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<Webhook> = update(id, WebhookUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook> = update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): HttpResponseFor<Webhook> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook>

        /** @see update */
        @MustBeClosed
        fun update(params: WebhookUpdateParams): HttpResponseFor<Webhook> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(id: String, requestOptions: RequestOptions): HttpResponseFor<Webhook> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks`, but is otherwise the same as
         * [WebhookService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<WebhookListResponse> = list(WebhookListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): HttpResponseFor<WebhookListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<WebhookListResponse> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /webhooks/{id}`, but is otherwise the same as
         * [WebhookService.deactivate].
         */
        @MustBeClosed
        fun deactivate(id: String): HttpResponseFor<WebhookDeactivateResponse> =
            deactivate(id, WebhookDeactivateParams.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookDeactivateResponse> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
        ): HttpResponseFor<WebhookDeactivateResponse> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: WebhookDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookDeactivateResponse>

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: WebhookDeactivateParams
        ): HttpResponseFor<WebhookDeactivateResponse> = deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookDeactivateResponse> =
            deactivate(id, WebhookDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks/{id}/deliveries`, but is otherwise the
         * same as [WebhookService.listDeliveries].
         */
        @MustBeClosed
        fun listDeliveries(id: String): HttpResponseFor<WebhookListDeliveriesResponse> =
            listDeliveries(id, WebhookListDeliveriesParams.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListDeliveriesResponse> =
            listDeliveries(params.toBuilder().id(id).build(), requestOptions)

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
        ): HttpResponseFor<WebhookListDeliveriesResponse> =
            listDeliveries(id, params, RequestOptions.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            params: WebhookListDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListDeliveriesResponse>

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            params: WebhookListDeliveriesParams
        ): HttpResponseFor<WebhookListDeliveriesResponse> =
            listDeliveries(params, RequestOptions.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookListDeliveriesResponse> =
            listDeliveries(id, WebhookListDeliveriesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhooks/{id}/test`, but is otherwise the same as
         * [WebhookService.test].
         */
        @MustBeClosed
        fun test(id: String): HttpResponseFor<WebhookTestResponse> =
            test(id, WebhookTestParams.none())

        /** @see test */
        @MustBeClosed
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookTestResponse> =
            test(params.toBuilder().id(id).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
        ): HttpResponseFor<WebhookTestResponse> = test(id, params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookTestResponse>

        /** @see test */
        @MustBeClosed
        fun test(params: WebhookTestParams): HttpResponseFor<WebhookTestResponse> =
            test(params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(id: String, requestOptions: RequestOptions): HttpResponseFor<WebhookTestResponse> =
            test(id, WebhookTestParams.none(), requestOptions)
    }
}
