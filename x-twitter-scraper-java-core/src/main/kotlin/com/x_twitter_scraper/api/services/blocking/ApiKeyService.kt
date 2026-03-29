// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeResponse
import java.util.function.Consumer

/** API key management (session auth only) */
interface ApiKeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService

    /** Create API key */
    fun create(): ApiKeyCreateResponse = create(ApiKeyCreateParams.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse

    /** @see create */
    fun create(params: ApiKeyCreateParams = ApiKeyCreateParams.none()): ApiKeyCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiKeyCreateResponse =
        create(ApiKeyCreateParams.none(), requestOptions)

    /** List API keys */
    fun list(): ApiKeyListResponse = list(ApiKeyListParams.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListResponse

    /** @see list */
    fun list(params: ApiKeyListParams = ApiKeyListParams.none()): ApiKeyListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ApiKeyListResponse =
        list(ApiKeyListParams.none(), requestOptions)

    /** Revoke API key */
    fun revoke(id: String): ApiKeyRevokeResponse = revoke(id, ApiKeyRevokeParams.none())

    /** @see revoke */
    fun revoke(
        id: String,
        params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyRevokeResponse = revoke(params.toBuilder().id(id).build(), requestOptions)

    /** @see revoke */
    fun revoke(
        id: String,
        params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
    ): ApiKeyRevokeResponse = revoke(id, params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        params: ApiKeyRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyRevokeResponse

    /** @see revoke */
    fun revoke(params: ApiKeyRevokeParams): ApiKeyRevokeResponse =
        revoke(params, RequestOptions.none())

    /** @see revoke */
    fun revoke(id: String, requestOptions: RequestOptions): ApiKeyRevokeResponse =
        revoke(id, ApiKeyRevokeParams.none(), requestOptions)

    /** A view of [ApiKeyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api-keys`, but is otherwise the same as
         * [ApiKeyService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiKeyCreateResponse> = create(ApiKeyCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none()
        ): HttpResponseFor<ApiKeyCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiKeyCreateResponse> =
            create(ApiKeyCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys`, but is otherwise the same as
         * [ApiKeyService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ApiKeyListResponse> = list(ApiKeyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none()
        ): HttpResponseFor<ApiKeyListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ApiKeyListResponse> =
            list(ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyService.revoke].
         */
        @MustBeClosed
        fun revoke(id: String): HttpResponseFor<ApiKeyRevokeResponse> =
            revoke(id, ApiKeyRevokeParams.none())

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            id: String,
            params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyRevokeResponse> =
            revoke(params.toBuilder().id(id).build(), requestOptions)

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            id: String,
            params: ApiKeyRevokeParams = ApiKeyRevokeParams.none(),
        ): HttpResponseFor<ApiKeyRevokeResponse> = revoke(id, params, RequestOptions.none())

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            params: ApiKeyRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyRevokeResponse>

        /** @see revoke */
        @MustBeClosed
        fun revoke(params: ApiKeyRevokeParams): HttpResponseFor<ApiKeyRevokeResponse> =
            revoke(params, RequestOptions.none())

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyRevokeResponse> =
            revoke(id, ApiKeyRevokeParams.none(), requestOptions)
    }
}
