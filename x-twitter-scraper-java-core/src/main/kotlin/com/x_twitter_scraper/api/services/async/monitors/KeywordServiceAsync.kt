// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.monitors

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X account monitoring with 1-second checks */
interface KeywordServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KeywordServiceAsync

    /**
     * Creates a keyword monitor. Keyword monitors are unlimited. Active monitors check every 1
     * second and cost 21 credits per hour. Events and webhook deliveries are included. Creation
     * requires available credits for the first hourly charge.
     */
    fun create(params: KeywordCreateParams): CompletableFuture<KeywordCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: KeywordCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordCreateResponse>

    /** Get keyword monitor */
    fun retrieve(id: String): CompletableFuture<KeywordRetrieveResponse> =
        retrieve(id, KeywordRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
    ): CompletableFuture<KeywordRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: KeywordRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: KeywordRetrieveParams): CompletableFuture<KeywordRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordRetrieveResponse> =
        retrieve(id, KeywordRetrieveParams.none(), requestOptions)

    /** Update keyword monitor */
    fun update(id: String): CompletableFuture<KeywordUpdateResponse> =
        update(id, KeywordUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: KeywordUpdateParams = KeywordUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: KeywordUpdateParams = KeywordUpdateParams.none(),
    ): CompletableFuture<KeywordUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: KeywordUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordUpdateResponse>

    /** @see update */
    fun update(params: KeywordUpdateParams): CompletableFuture<KeywordUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordUpdateResponse> =
        update(id, KeywordUpdateParams.none(), requestOptions)

    /** List keyword monitors */
    fun list(): CompletableFuture<KeywordListResponse> = list(KeywordListParams.none())

    /** @see list */
    fun list(
        params: KeywordListParams = KeywordListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordListResponse>

    /** @see list */
    fun list(
        params: KeywordListParams = KeywordListParams.none()
    ): CompletableFuture<KeywordListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<KeywordListResponse> =
        list(KeywordListParams.none(), requestOptions)

    /** Delete keyword monitor */
    fun deactivate(id: String): CompletableFuture<KeywordDeactivateResponse> =
        deactivate(id, KeywordDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordDeactivateResponse> =
        deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
    ): CompletableFuture<KeywordDeactivateResponse> = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: KeywordDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeywordDeactivateResponse>

    /** @see deactivate */
    fun deactivate(params: KeywordDeactivateParams): CompletableFuture<KeywordDeactivateResponse> =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordDeactivateResponse> =
        deactivate(id, KeywordDeactivateParams.none(), requestOptions)

    /**
     * A view of [KeywordServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): KeywordServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors/keywords`, but is otherwise the same as
         * [KeywordServiceAsync.create].
         */
        fun create(
            params: KeywordCreateParams
        ): CompletableFuture<HttpResponseFor<KeywordCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: KeywordCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /monitors/keywords/{id}`, but is otherwise the same
         * as [KeywordServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> =
            retrieve(id, KeywordRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: KeywordRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: KeywordRetrieveParams
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> =
            retrieve(id, KeywordRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/keywords/{id}`, but is otherwise the
         * same as [KeywordServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> =
            update(id, KeywordUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: KeywordUpdateParams = KeywordUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: KeywordUpdateParams = KeywordUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: KeywordUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>>

        /** @see update */
        fun update(
            params: KeywordUpdateParams
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> =
            update(id, KeywordUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/keywords`, but is otherwise the same as
         * [KeywordServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<KeywordListResponse>> =
            list(KeywordListParams.none())

        /** @see list */
        fun list(
            params: KeywordListParams = KeywordListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordListResponse>>

        /** @see list */
        fun list(
            params: KeywordListParams = KeywordListParams.none()
        ): CompletableFuture<HttpResponseFor<KeywordListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<KeywordListResponse>> =
            list(KeywordListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/keywords/{id}`, but is otherwise the
         * same as [KeywordServiceAsync.deactivate].
         */
        fun deactivate(id: String): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> =
            deactivate(id, KeywordDeactivateParams.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        fun deactivate(
            id: String,
            params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            params: KeywordDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>>

        /** @see deactivate */
        fun deactivate(
            params: KeywordDeactivateParams
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> =
            deactivate(params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> =
            deactivate(id, KeywordDeactivateParams.none(), requestOptions)
    }
}
