// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

/** Push notification integrations (Telegram) */
interface IntegrationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): IntegrationService

    /** Create integration */
    fun create(params: IntegrationCreateParams): IntegrationCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: IntegrationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationCreateResponse

    /** Get integration details */
    fun retrieve(id: String): IntegrationRetrieveResponse =
        retrieve(id, IntegrationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
    ): IntegrationRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: IntegrationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: IntegrationRetrieveParams): IntegrationRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): IntegrationRetrieveResponse =
        retrieve(id, IntegrationRetrieveParams.none(), requestOptions)

    /** Update integration */
    fun update(id: String): IntegrationUpdateResponse = update(id, IntegrationUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
    ): IntegrationUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: IntegrationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationUpdateResponse

    /** @see update */
    fun update(params: IntegrationUpdateParams): IntegrationUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): IntegrationUpdateResponse =
        update(id, IntegrationUpdateParams.none(), requestOptions)

    /** List integrations */
    fun list(): IntegrationListResponse = list(IntegrationListParams.none())

    /** @see list */
    fun list(
        params: IntegrationListParams = IntegrationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationListResponse

    /** @see list */
    fun list(
        params: IntegrationListParams = IntegrationListParams.none()
    ): IntegrationListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): IntegrationListResponse =
        list(IntegrationListParams.none(), requestOptions)

    /** Delete integration */
    fun delete(id: String): IntegrationDeleteResponse = delete(id, IntegrationDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
    ): IntegrationDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: IntegrationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationDeleteResponse

    /** @see delete */
    fun delete(params: IntegrationDeleteParams): IntegrationDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): IntegrationDeleteResponse =
        delete(id, IntegrationDeleteParams.none(), requestOptions)

    /** List integration delivery history */
    fun listDeliveries(id: String): IntegrationListDeliveriesResponse =
        listDeliveries(id, IntegrationListDeliveriesParams.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationListDeliveriesResponse =
        listDeliveries(params.toBuilder().id(id).build(), requestOptions)

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
    ): IntegrationListDeliveriesResponse = listDeliveries(id, params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        params: IntegrationListDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationListDeliveriesResponse

    /** @see listDeliveries */
    fun listDeliveries(params: IntegrationListDeliveriesParams): IntegrationListDeliveriesResponse =
        listDeliveries(params, RequestOptions.none())

    /** @see listDeliveries */
    fun listDeliveries(
        id: String,
        requestOptions: RequestOptions,
    ): IntegrationListDeliveriesResponse =
        listDeliveries(id, IntegrationListDeliveriesParams.none(), requestOptions)

    /** Send test delivery */
    fun sendTest(id: String): IntegrationSendTestResponse =
        sendTest(id, IntegrationSendTestParams.none())

    /** @see sendTest */
    fun sendTest(
        id: String,
        params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationSendTestResponse = sendTest(params.toBuilder().id(id).build(), requestOptions)

    /** @see sendTest */
    fun sendTest(
        id: String,
        params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
    ): IntegrationSendTestResponse = sendTest(id, params, RequestOptions.none())

    /** @see sendTest */
    fun sendTest(
        params: IntegrationSendTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IntegrationSendTestResponse

    /** @see sendTest */
    fun sendTest(params: IntegrationSendTestParams): IntegrationSendTestResponse =
        sendTest(params, RequestOptions.none())

    /** @see sendTest */
    fun sendTest(id: String, requestOptions: RequestOptions): IntegrationSendTestResponse =
        sendTest(id, IntegrationSendTestParams.none(), requestOptions)

    /**
     * A view of [IntegrationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): IntegrationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /integrations`, but is otherwise the same as
         * [IntegrationService.create].
         */
        @MustBeClosed
        fun create(params: IntegrationCreateParams): HttpResponseFor<IntegrationCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: IntegrationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationCreateResponse>

        /**
         * Returns a raw HTTP response for `get /integrations/{id}`, but is otherwise the same as
         * [IntegrationService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<IntegrationRetrieveResponse> =
            retrieve(id, IntegrationRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: IntegrationRetrieveParams = IntegrationRetrieveParams.none(),
        ): HttpResponseFor<IntegrationRetrieveResponse> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: IntegrationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: IntegrationRetrieveParams
        ): HttpResponseFor<IntegrationRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationRetrieveResponse> =
            retrieve(id, IntegrationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /integrations/{id}`, but is otherwise the same as
         * [IntegrationService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<IntegrationUpdateResponse> =
            update(id, IntegrationUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: IntegrationUpdateParams = IntegrationUpdateParams.none(),
        ): HttpResponseFor<IntegrationUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: IntegrationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: IntegrationUpdateParams): HttpResponseFor<IntegrationUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationUpdateResponse> =
            update(id, IntegrationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /integrations`, but is otherwise the same as
         * [IntegrationService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<IntegrationListResponse> = list(IntegrationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: IntegrationListParams = IntegrationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: IntegrationListParams = IntegrationListParams.none()
        ): HttpResponseFor<IntegrationListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<IntegrationListResponse> =
            list(IntegrationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /integrations/{id}`, but is otherwise the same as
         * [IntegrationService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<IntegrationDeleteResponse> =
            delete(id, IntegrationDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: IntegrationDeleteParams = IntegrationDeleteParams.none(),
        ): HttpResponseFor<IntegrationDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: IntegrationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: IntegrationDeleteParams): HttpResponseFor<IntegrationDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationDeleteResponse> =
            delete(id, IntegrationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /integrations/{id}/deliveries`, but is otherwise the
         * same as [IntegrationService.listDeliveries].
         */
        @MustBeClosed
        fun listDeliveries(id: String): HttpResponseFor<IntegrationListDeliveriesResponse> =
            listDeliveries(id, IntegrationListDeliveriesParams.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationListDeliveriesResponse> =
            listDeliveries(params.toBuilder().id(id).build(), requestOptions)

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            params: IntegrationListDeliveriesParams = IntegrationListDeliveriesParams.none(),
        ): HttpResponseFor<IntegrationListDeliveriesResponse> =
            listDeliveries(id, params, RequestOptions.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            params: IntegrationListDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationListDeliveriesResponse>

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            params: IntegrationListDeliveriesParams
        ): HttpResponseFor<IntegrationListDeliveriesResponse> =
            listDeliveries(params, RequestOptions.none())

        /** @see listDeliveries */
        @MustBeClosed
        fun listDeliveries(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationListDeliveriesResponse> =
            listDeliveries(id, IntegrationListDeliveriesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /integrations/{id}/test`, but is otherwise the same
         * as [IntegrationService.sendTest].
         */
        @MustBeClosed
        fun sendTest(id: String): HttpResponseFor<IntegrationSendTestResponse> =
            sendTest(id, IntegrationSendTestParams.none())

        /** @see sendTest */
        @MustBeClosed
        fun sendTest(
            id: String,
            params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationSendTestResponse> =
            sendTest(params.toBuilder().id(id).build(), requestOptions)

        /** @see sendTest */
        @MustBeClosed
        fun sendTest(
            id: String,
            params: IntegrationSendTestParams = IntegrationSendTestParams.none(),
        ): HttpResponseFor<IntegrationSendTestResponse> =
            sendTest(id, params, RequestOptions.none())

        /** @see sendTest */
        @MustBeClosed
        fun sendTest(
            params: IntegrationSendTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IntegrationSendTestResponse>

        /** @see sendTest */
        @MustBeClosed
        fun sendTest(
            params: IntegrationSendTestParams
        ): HttpResponseFor<IntegrationSendTestResponse> = sendTest(params, RequestOptions.none())

        /** @see sendTest */
        @MustBeClosed
        fun sendTest(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationSendTestResponse> =
            sendTest(id, IntegrationSendTestParams.none(), requestOptions)
    }
}
