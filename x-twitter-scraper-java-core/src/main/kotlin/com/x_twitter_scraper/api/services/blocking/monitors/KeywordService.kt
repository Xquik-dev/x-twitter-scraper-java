// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.monitors

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

/** Real-time X account monitoring */
interface KeywordService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KeywordService

    /**
     * Creates an instant keyword monitor. Keyword monitors are unlimited. Active monitors check
     * every 1 second and cost 21 credits per hour. Events and webhook deliveries are included.
     * Creation requires available credits for the first hourly charge.
     */
    fun create(params: KeywordCreateParams): KeywordCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: KeywordCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordCreateResponse

    /** Get keyword monitor */
    fun retrieve(id: String): KeywordRetrieveResponse = retrieve(id, KeywordRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
    ): KeywordRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: KeywordRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: KeywordRetrieveParams): KeywordRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): KeywordRetrieveResponse =
        retrieve(id, KeywordRetrieveParams.none(), requestOptions)

    /** Update keyword monitor */
    fun update(id: String): KeywordUpdateResponse = update(id, KeywordUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: KeywordUpdateParams = KeywordUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: KeywordUpdateParams = KeywordUpdateParams.none(),
    ): KeywordUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: KeywordUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordUpdateResponse

    /** @see update */
    fun update(params: KeywordUpdateParams): KeywordUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): KeywordUpdateResponse =
        update(id, KeywordUpdateParams.none(), requestOptions)

    /** List keyword monitors */
    fun list(): KeywordListResponse = list(KeywordListParams.none())

    /** @see list */
    fun list(
        params: KeywordListParams = KeywordListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordListResponse

    /** @see list */
    fun list(params: KeywordListParams = KeywordListParams.none()): KeywordListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): KeywordListResponse =
        list(KeywordListParams.none(), requestOptions)

    /** Delete keyword monitor */
    fun deactivate(id: String): KeywordDeactivateResponse =
        deactivate(id, KeywordDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordDeactivateResponse = deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        id: String,
        params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
    ): KeywordDeactivateResponse = deactivate(id, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: KeywordDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeywordDeactivateResponse

    /** @see deactivate */
    fun deactivate(params: KeywordDeactivateParams): KeywordDeactivateResponse =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(id: String, requestOptions: RequestOptions): KeywordDeactivateResponse =
        deactivate(id, KeywordDeactivateParams.none(), requestOptions)

    /** A view of [KeywordService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): KeywordService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors/keywords`, but is otherwise the same as
         * [KeywordService.create].
         */
        @MustBeClosed
        fun create(params: KeywordCreateParams): HttpResponseFor<KeywordCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: KeywordCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordCreateResponse>

        /**
         * Returns a raw HTTP response for `get /monitors/keywords/{id}`, but is otherwise the same
         * as [KeywordService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<KeywordRetrieveResponse> =
            retrieve(id, KeywordRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: KeywordRetrieveParams = KeywordRetrieveParams.none(),
        ): HttpResponseFor<KeywordRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: KeywordRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: KeywordRetrieveParams): HttpResponseFor<KeywordRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordRetrieveResponse> =
            retrieve(id, KeywordRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/keywords/{id}`, but is otherwise the
         * same as [KeywordService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<KeywordUpdateResponse> =
            update(id, KeywordUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: KeywordUpdateParams = KeywordUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: KeywordUpdateParams = KeywordUpdateParams.none(),
        ): HttpResponseFor<KeywordUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: KeywordUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: KeywordUpdateParams): HttpResponseFor<KeywordUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordUpdateResponse> =
            update(id, KeywordUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/keywords`, but is otherwise the same as
         * [KeywordService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<KeywordListResponse> = list(KeywordListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: KeywordListParams = KeywordListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: KeywordListParams = KeywordListParams.none()
        ): HttpResponseFor<KeywordListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<KeywordListResponse> =
            list(KeywordListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/keywords/{id}`, but is otherwise the
         * same as [KeywordService.deactivate].
         */
        @MustBeClosed
        fun deactivate(id: String): HttpResponseFor<KeywordDeactivateResponse> =
            deactivate(id, KeywordDeactivateParams.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordDeactivateResponse> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            params: KeywordDeactivateParams = KeywordDeactivateParams.none(),
        ): HttpResponseFor<KeywordDeactivateResponse> =
            deactivate(id, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: KeywordDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeywordDeactivateResponse>

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: KeywordDeactivateParams
        ): HttpResponseFor<KeywordDeactivateResponse> = deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeywordDeactivateResponse> =
            deactivate(id, KeywordDeactivateParams.none(), requestOptions)
    }
}
