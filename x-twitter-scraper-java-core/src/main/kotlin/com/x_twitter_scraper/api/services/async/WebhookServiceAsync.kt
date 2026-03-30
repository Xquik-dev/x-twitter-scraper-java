// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Webhook endpoint management & delivery */
interface WebhookServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync

    /** Create webhook */
    fun create(params: WebhookCreateParams): CompletableFuture<WebhookCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookCreateResponse>

    /** Update webhook */
    fun update(id: String): CompletableFuture<Webhook> = update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): CompletableFuture<Webhook> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook>

    /** @see update */
    fun update(params: WebhookUpdateParams): CompletableFuture<Webhook> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<Webhook> =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** List webhooks */
    fun list(): CompletableFuture<WebhookListResponse> = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListResponse>

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none()
    ): CompletableFuture<WebhookListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<WebhookListResponse> =
        list(WebhookListParams.none(), requestOptions)

    /** Deactivate webhook */
    fun deactivate(id: String): CompletableFuture<WebhookDeactivateResponse> =
        deactivate(id, WebhookDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookDeactivateResponse> =
        deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
    ): CompletableFuture<WebhookDeactivateResponse> = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: WebhookDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookDeactivateResponse>

    /** @see deactivate */
    fun deactivate(params: WebhookDeactivateParams): CompletableFuture<WebhookDeactivateResponse> =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookDeactivateResponse> =
        deactivate(id, WebhookDeactivateParams.none(), requestOptions)

    /** List webhook deliveries */
    fun listDeliveries(id: String): CompletableFuture<WebhookListDeliveriesResponse> =
        listDeliveries(id, WebhookListDeliveriesParams.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListDeliveriesResponse> =
        listDeliveries(params.toBuilder().id(id).build(), requestOptions)

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
    ): CompletableFuture<WebhookListDeliveriesResponse> =
        listDeliveries(id, params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        params: WebhookListDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListDeliveriesResponse>

    /** @see listDeliveries */
    fun listDeliveries(
        params: WebhookListDeliveriesParams
    ): CompletableFuture<WebhookListDeliveriesResponse> =
        listDeliveries(params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookListDeliveriesResponse> =
        listDeliveries(id, WebhookListDeliveriesParams.none(), requestOptions)

    /** Test webhook endpoint */
    fun test(id: String): CompletableFuture<WebhookTestResponse> =
        test(id, WebhookTestParams.none())

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookTestResponse> =
        test(params.toBuilder().id(id).build(), requestOptions)

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
    ): CompletableFuture<WebhookTestResponse> = test(id, params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookTestResponse>

    /** @see test */
    fun test(params: WebhookTestParams): CompletableFuture<WebhookTestResponse> =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(id: String, requestOptions: RequestOptions): CompletableFuture<WebhookTestResponse> =
        test(id, WebhookTestParams.none(), requestOptions)

    /**
     * A view of [WebhookServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.create].
         */
        fun create(
            params: WebhookCreateParams
        ): CompletableFuture<HttpResponseFor<WebhookCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookCreateResponse>>

        /**
         * Returns a raw HTTP response for `patch /webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<Webhook>> =
            update(id, WebhookUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> = update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>>

        /** @see update */
        fun update(params: WebhookUpdateParams): CompletableFuture<HttpResponseFor<Webhook>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<WebhookListResponse>> =
            list(WebhookListParams.none())

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListResponse>>

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookListResponse>> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.deactivate].
         */
        fun deactivate(id: String): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>> =
            deactivate(id, WebhookDeactivateParams.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: WebhookDeactivateParams = WebhookDeactivateParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            params: WebhookDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>>

        /** @see deactivate */
        fun deactivate(
            params: WebhookDeactivateParams
        ): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>> =
            deactivate(params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookDeactivateResponse>> =
            deactivate(id, WebhookDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks/{id}/deliveries`, but is otherwise the
         * same as [WebhookServiceAsync.listDeliveries].
         */
        fun listDeliveries(
            id: String
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>> =
            listDeliveries(id, WebhookListDeliveriesParams.none())

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>> =
            listDeliveries(params.toBuilder().id(id).build(), requestOptions)

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            params: WebhookListDeliveriesParams = WebhookListDeliveriesParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>> =
            listDeliveries(id, params, RequestOptions.none())

        /** @see listDeliveries */
        fun listDeliveries(
            params: WebhookListDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>>

        /** @see listDeliveries */
        fun listDeliveries(
            params: WebhookListDeliveriesParams
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>> =
            listDeliveries(params, RequestOptions.none())

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookListDeliveriesResponse>> =
            listDeliveries(id, WebhookListDeliveriesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhooks/{id}/test`, but is otherwise the same as
         * [WebhookServiceAsync.test].
         */
        fun test(id: String): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, WebhookTestParams.none())

        /** @see test */
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(params.toBuilder().id(id).build(), requestOptions)

        /** @see test */
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, params, RequestOptions.none())

        /** @see test */
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>>

        /** @see test */
        fun test(
            params: WebhookTestParams
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(params, RequestOptions.none())

        /** @see test */
        fun test(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, WebhookTestParams.none(), requestOptions)
    }
}
