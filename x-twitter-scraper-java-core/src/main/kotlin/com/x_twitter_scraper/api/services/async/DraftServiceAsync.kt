// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.drafts.DraftCreateParams
import com.x_twitter_scraper.api.models.drafts.DraftCreateResponse
import com.x_twitter_scraper.api.models.drafts.DraftDeleteParams
import com.x_twitter_scraper.api.models.drafts.DraftListParams
import com.x_twitter_scraper.api.models.drafts.DraftListResponse
import com.x_twitter_scraper.api.models.drafts.DraftRetrieveParams
import com.x_twitter_scraper.api.models.drafts.DraftRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
interface DraftServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DraftServiceAsync

    /** Save a tweet draft */
    fun create(params: DraftCreateParams): CompletableFuture<DraftCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DraftCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DraftCreateResponse>

    /** Get draft by ID */
    fun retrieve(id: String): CompletableFuture<DraftRetrieveResponse> =
        retrieve(id, DraftRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DraftRetrieveParams = DraftRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DraftRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DraftRetrieveParams = DraftRetrieveParams.none(),
    ): CompletableFuture<DraftRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DraftRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DraftRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: DraftRetrieveParams): CompletableFuture<DraftRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DraftRetrieveResponse> =
        retrieve(id, DraftRetrieveParams.none(), requestOptions)

    /** List saved drafts */
    fun list(): CompletableFuture<DraftListResponse> = list(DraftListParams.none())

    /** @see list */
    fun list(
        params: DraftListParams = DraftListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DraftListResponse>

    /** @see list */
    fun list(
        params: DraftListParams = DraftListParams.none()
    ): CompletableFuture<DraftListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<DraftListResponse> =
        list(DraftListParams.none(), requestOptions)

    /** Delete a draft */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, DraftDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: DraftDeleteParams = DraftDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: DraftDeleteParams = DraftDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: DraftDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: DraftDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, DraftDeleteParams.none(), requestOptions)

    /** A view of [DraftServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DraftServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /drafts`, but is otherwise the same as
         * [DraftServiceAsync.create].
         */
        fun create(
            params: DraftCreateParams
        ): CompletableFuture<HttpResponseFor<DraftCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: DraftCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DraftCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /drafts/{id}`, but is otherwise the same as
         * [DraftServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>> =
            retrieve(id, DraftRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DraftRetrieveParams = DraftRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DraftRetrieveParams = DraftRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DraftRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: DraftRetrieveParams
        ): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DraftRetrieveResponse>> =
            retrieve(id, DraftRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /drafts`, but is otherwise the same as
         * [DraftServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<DraftListResponse>> =
            list(DraftListParams.none())

        /** @see list */
        fun list(
            params: DraftListParams = DraftListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DraftListResponse>>

        /** @see list */
        fun list(
            params: DraftListParams = DraftListParams.none()
        ): CompletableFuture<HttpResponseFor<DraftListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<DraftListResponse>> =
            list(DraftListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /drafts/{id}`, but is otherwise the same as
         * [DraftServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, DraftDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: DraftDeleteParams = DraftDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: DraftDeleteParams = DraftDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: DraftDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: DraftDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, DraftDeleteParams.none(), requestOptions)
    }
}
