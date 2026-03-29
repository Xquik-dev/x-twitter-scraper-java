// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** API key management (session auth only) */
interface ApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyServiceAsync

    /** Create API key */
    fun create(): CompletableFuture<ApiKeyCreateResponse> = create(ApiKeyCreateParams.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyCreateResponse>

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none()
    ): CompletableFuture<ApiKeyCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiKeyCreateResponse> =
        create(ApiKeyCreateParams.none(), requestOptions)

    /** List API keys */
    fun list(): CompletableFuture<ApiKeyListResponse> = list(ApiKeyListParams.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyListResponse>

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none()
    ): CompletableFuture<ApiKeyListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ApiKeyListResponse> =
        list(ApiKeyListParams.none(), requestOptions)

    /** Revoke API key */
    fun revoke(id: String): CompletableFuture<ApiKeyRevokeResponse> =
        revoke(id, ApiKeyRevokeParams.none())

    /** @see revoke */
    fun revoke(
        id: String,
        params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyRevokeResponse> =
        revoke(params.toBuilder().id(id).build(), requestOptions)

    /** @see revoke */
    fun revoke(
        id: String,
        params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
    ): CompletableFuture<ApiKeyRevokeResponse> = revoke(id, params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        params: ApiKeyRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyRevokeResponse>

    /** @see revoke */
    fun revoke(params: ApiKeyRevokeParams): CompletableFuture<ApiKeyRevokeResponse> =
        revoke(params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiKeyRevokeResponse> =
        revoke(id, ApiKeyRevokeParams.none(), requestOptions)

    /**
     * A view of [ApiKeyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api-keys`, but is otherwise the same as
         * [ApiKeyServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(ApiKeyCreateParams.none())

        /** @see create */
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>>

        /** @see create */
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(ApiKeyCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys`, but is otherwise the same as
         * [ApiKeyServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ApiKeyListResponse>> =
            list(ApiKeyListParams.none())

        /** @see list */
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyListResponse>>

        /** @see list */
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none()
        ): CompletableFuture<HttpResponseFor<ApiKeyListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiKeyListResponse>> =
            list(ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.revoke].
         */
        fun revoke(id: String): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>> =
            revoke(id, ApiKeyRevokeParams.none())

        /** @see revoke */
        fun revoke(
            id: String,
            params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>> =
            revoke(params.toBuilder().id(id).build(), requestOptions)

        /** @see revoke */
        fun revoke(
            id: String,
            params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>> =
            revoke(id, params, RequestOptions.none())

        /** @see revoke */
        fun revoke(
            params: ApiKeyRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>>

        /** @see revoke */
        fun revoke(
            params: ApiKeyRevokeParams
        ): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>> =
            revoke(params, RequestOptions.none())

        /** @see revoke */
        fun revoke(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiKeyRevokeResponse>> =
            revoke(id, ApiKeyRevokeParams.none(), requestOptions)
    }
}
