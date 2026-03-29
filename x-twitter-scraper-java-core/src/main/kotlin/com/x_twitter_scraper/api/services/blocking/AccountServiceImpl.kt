// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.SecurityOptions
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
import com.x_twitter_scraper.api.models.account.AccountRetrieveParams
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameParams
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameResponse
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleParams
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleResponse
import java.util.function.Consumer

/** Account info & settings */
class AccountServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountService {

    private val withRawResponse: AccountService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AccountService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService =
        AccountServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions,
    ): AccountRetrieveResponse =
        // get /account
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun setXUsername(
        params: AccountSetXUsernameParams,
        requestOptions: RequestOptions,
    ): AccountSetXUsernameResponse =
        // put /account/x-identity
        withRawResponse().setXUsername(params, requestOptions).parse()

    override fun updateLocale(
        params: AccountUpdateLocaleParams,
        requestOptions: RequestOptions,
    ): AccountUpdateLocaleResponse =
        // patch /account
        withRawResponse().updateLocale(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountService.WithRawResponse =
            AccountServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<AccountRetrieveResponse> =
            jsonHandler<AccountRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("account")
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.builder().apiKey(true).build())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val setXUsernameHandler: Handler<AccountSetXUsernameResponse> =
            jsonHandler<AccountSetXUsernameResponse>(clientOptions.jsonMapper)

        override fun setXUsername(
            params: AccountSetXUsernameParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountSetXUsernameResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("account", "x-identity")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { setXUsernameHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateLocaleHandler: Handler<AccountUpdateLocaleResponse> =
            jsonHandler<AccountUpdateLocaleResponse>(clientOptions.jsonMapper)

        override fun updateLocale(
            params: AccountUpdateLocaleParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountUpdateLocaleResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("account")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateLocaleHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
