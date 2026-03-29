// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.SecurityOptions
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.handlers.errorBodyHandler
import com.x_twitter_scraper.api.core.handlers.errorHandler
import com.x_twitter_scraper.api.core.handlers.jsonHandler
import com.x_twitter_scraper.api.core.http.HttpMethod
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyListResponse
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeParams
import com.x_twitter_scraper.api.models.apikeys.ApiKeyRevokeResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** API key management (session auth only) */
class ApiKeyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ApiKeyService {

    private val withRawResponse: ApiKeyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiKeyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService =
        ApiKeyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions,
    ): ApiKeyCreateResponse =
        // post /api-keys
        withRawResponse().create(params, requestOptions).parse()

    override fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions,
    ): ApiKeyListResponse =
        // get /api-keys
        withRawResponse().list(params, requestOptions).parse()

    override fun revoke(
        params: ApiKeyRevokeParams,
        requestOptions: RequestOptions,
    ): ApiKeyRevokeResponse =
        // delete /api-keys/{id}
        withRawResponse().revoke(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiKeyService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiKeyService.WithRawResponse =
            ApiKeyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ApiKeyCreateResponse> =
            jsonHandler<ApiKeyCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ApiKeyListResponse> =
            jsonHandler<ApiKeyListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys")
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val revokeHandler: Handler<ApiKeyRevokeResponse> =
            jsonHandler<ApiKeyRevokeResponse>(clientOptions.jsonMapper)

        override fun revoke(
            params: ApiKeyRevokeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyRevokeResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { revokeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
