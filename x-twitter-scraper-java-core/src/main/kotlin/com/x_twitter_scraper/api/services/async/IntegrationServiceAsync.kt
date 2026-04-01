// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.integrations.IntegrationCreateParams
import com.x_twitter_scraper.api.models.integrations.IntegrationCreateResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationDeleteParams
import com.x_twitter_scraper.api.models.integrations.IntegrationDeleteResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationListParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationRetrieveParams
import com.x_twitter_scraper.api.models.integrations.IntegrationRetrieveResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationSendTestParams
import com.x_twitter_scraper.api.models.integrations.IntegrationSendTestResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationUpdateParams
import com.x_twitter_scraper.api.models.integrations.IntegrationUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Push notification integrations (Telegram) */
interface IntegrationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): IntegrationServiceAsync

    /** Create integration */
    fun create(params: IntegrationCreateParams): CompletableFuture<IntegrationCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: IntegrationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationCreateResponse>

    /** Get integration details */
    fun retrieve(id: String): CompletableFuture<IntegrationRetrieveResponse> =
        retrieve(id, IntegrationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
    ): CompletableFuture<IntegrationRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: IntegrationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: IntegrationRetrieveParams
    ): CompletableFuture<IntegrationRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationRetrieveResponse> =
        retrieve(id, IntegrationRetrieveParams.none(), requestOptions)

    /** Update integration */
    fun update(id: String): CompletableFuture<IntegrationUpdateResponse> =
        update(id, IntegrationUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
    ): CompletableFuture<IntegrationUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: IntegrationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationUpdateResponse>

    /** @see update */
    fun update(params: IntegrationUpdateParams): CompletableFuture<IntegrationUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationUpdateResponse> =
        update(id, IntegrationUpdateParams.none(), requestOptions)

    /** List integrations */
    fun list(): CompletableFuture<IntegrationListResponse> = list(IntegrationListParams.none())

    /** @see list */
    fun list(
        params: IntegrationListParams = IntegrationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationListResponse>

    /** @see list */
    fun list(
        params: IntegrationListParams = IntegrationListParams.none()
    ): CompletableFuture<IntegrationListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<IntegrationListResponse> =
        list(IntegrationListParams.none(), requestOptions)

    /** Delete integration */
    fun delete(id: String): CompletableFuture<IntegrationDeleteResponse> =
        delete(id, IntegrationDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
    ): CompletableFuture<IntegrationDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: IntegrationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationDeleteResponse>

    /** @see delete */
    fun delete(params: IntegrationDeleteParams): CompletableFuture<IntegrationDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationDeleteResponse> =
        delete(id, IntegrationDeleteParams.none(), requestOptions)

    /** List integration delivery history */
    fun listDeliveries(id: String): CompletableFuture<IntegrationListDeliveriesResponse> =
        listDeliveries(id, IntegrationListDeliveriesParams.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationListDeliveriesResponse> =
        listDeliveries(params.toBuilder().id(id).build(), requestOptions)

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
    ): CompletableFuture<IntegrationListDeliveriesResponse> =
        listDeliveries(id, params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        params: IntegrationListDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationListDeliveriesResponse>

    /** @see listDeliveries */
    fun listDeliveries(
        params: IntegrationListDeliveriesParams
    ): CompletableFuture<IntegrationListDeliveriesResponse> =
        listDeliveries(params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationListDeliveriesResponse> =
        listDeliveries(id, IntegrationListDeliveriesParams.none(), requestOptions)

    /** Send test delivery */
    fun sendTest(id: String): CompletableFuture<IntegrationSendTestResponse> =
        sendTest(id, IntegrationSendTestParams.none())

    /** @see sendTest */
    fun sendTest(
        id: String,
        params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationSendTestResponse> =
        sendTest(params.toBuilder().id(id).build(), requestOptions)

    /** @see sendTest */
    fun sendTest(
        id: String,
        params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
    ): CompletableFuture<IntegrationSendTestResponse> = sendTest(id, params, RequestOptions.none())

    /** @see sendTest */
    fun sendTest(
        params: IntegrationSendTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<IntegrationSendTestResponse>

    /** @see sendTest */
    fun sendTest(
        params: IntegrationSendTestParams
    ): CompletableFuture<IntegrationSendTestResponse> = sendTest(params, RequestOptions.none())

    /** @see sendTest */
    fun sendTest(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationSendTestResponse> =
        sendTest(id, IntegrationSendTestParams.none(), requestOptions)

    /**
     * A view of [IntegrationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): IntegrationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /integrations`, but is otherwise the same as
         * [IntegrationServiceAsync.create].
         */
        fun create(
            params: IntegrationCreateParams
        ): CompletableFuture<HttpResponseFor<IntegrationCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: IntegrationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /integrations/{id}`, but is otherwise the same as
         * [IntegrationServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>> =
            retrieve(id, IntegrationRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: IntegrationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: IntegrationRetrieveParams
        ): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationRetrieveResponse>> =
            retrieve(id, IntegrationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /integrations/{id}`, but is otherwise the same as
         * [IntegrationServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>> =
            update(id, IntegrationUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: IntegrationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>>

        /** @see update */
        fun update(
            params: IntegrationUpdateParams
        ): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationUpdateResponse>> =
            update(id, IntegrationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /integrations`, but is otherwise the same as
         * [IntegrationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<IntegrationListResponse>> =
            list(IntegrationListParams.none())

        /** @see list */
        fun list(
            params: IntegrationListParams = IntegrationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationListResponse>>

        /** @see list */
        fun list(
            params: IntegrationListParams = IntegrationListParams.none()
        ): CompletableFuture<HttpResponseFor<IntegrationListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<IntegrationListResponse>> =
            list(IntegrationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /integrations/{id}`, but is otherwise the same as
         * [IntegrationServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> =
            delete(id, IntegrationDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: IntegrationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>>

        /** @see delete */
        fun delete(
            params: IntegrationDeleteParams
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> =
            delete(id, IntegrationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /integrations/{id}/deliveries`, but is otherwise the
         * same as [IntegrationServiceAsync.listDeliveries].
         */
        fun listDeliveries(
            id: String
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> =
            listDeliveries(id, IntegrationListDeliveriesParams.none())

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> =
            listDeliveries(params.toBuilder().id(id).build(), requestOptions)

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> =
            listDeliveries(id, params, RequestOptions.none())

        /** @see listDeliveries */
        fun listDeliveries(
            params: IntegrationListDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>>

        /** @see listDeliveries */
        fun listDeliveries(
            params: IntegrationListDeliveriesParams
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> =
            listDeliveries(params, RequestOptions.none())

        /** @see listDeliveries */
        fun listDeliveries(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> =
            listDeliveries(id, IntegrationListDeliveriesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /integrations/{id}/test`, but is otherwise the same
         * as [IntegrationServiceAsync.sendTest].
         */
        fun sendTest(id: String): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> =
            sendTest(id, IntegrationSendTestParams.none())

        /** @see sendTest */
        fun sendTest(
            id: String,
            params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> =
            sendTest(params.toBuilder().id(id).build(), requestOptions)

        /** @see sendTest */
        fun sendTest(
            id: String,
            params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> =
            sendTest(id, params, RequestOptions.none())

        /** @see sendTest */
        fun sendTest(
            params: IntegrationSendTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>>

        /** @see sendTest */
        fun sendTest(
            params: IntegrationSendTestParams
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> =
            sendTest(params, RequestOptions.none())

        /** @see sendTest */
        fun sendTest(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> =
            sendTest(id, IntegrationSendTestParams.none(), requestOptions)
    }
}
