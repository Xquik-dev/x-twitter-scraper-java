// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.handlers.errorBodyHandler
import com.x_twitter_scraper.api.core.handlers.errorHandler
import com.x_twitter_scraper.api.core.handlers.jsonHandler
import com.x_twitter_scraper.api.core.http.HttpMethod
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.multipartFormData
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllParams
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
class ProfileServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ProfileService {

    private val withRawResponse: ProfileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ProfileService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService =
        ProfileServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun patchAll(
        params: ProfilePatchAllParams,
        requestOptions: RequestOptions,
    ): ProfilePatchAllResponse =
        // patch /x/profile
        withRawResponse().patchAll(params, requestOptions).parse()

    override fun updateAvatar(
        params: ProfileUpdateAvatarParams,
        requestOptions: RequestOptions,
    ): ProfileUpdateAvatarResponse =
        // patch /x/profile/avatar
        withRawResponse().updateAvatar(params, requestOptions).parse()

    override fun updateBanner(
        params: ProfileUpdateBannerParams,
        requestOptions: RequestOptions,
    ): ProfileUpdateBannerResponse =
        // patch /x/profile/banner
        withRawResponse().updateBanner(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProfileService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProfileService.WithRawResponse =
            ProfileServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val patchAllHandler: Handler<ProfilePatchAllResponse> =
            jsonHandler<ProfilePatchAllResponse>(clientOptions.jsonMapper)

        override fun patchAll(
            params: ProfilePatchAllParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfilePatchAllResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "profile")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { patchAllHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateAvatarHandler: Handler<ProfileUpdateAvatarResponse> =
            jsonHandler<ProfileUpdateAvatarResponse>(clientOptions.jsonMapper)

        override fun updateAvatar(
            params: ProfileUpdateAvatarParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileUpdateAvatarResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "profile", "avatar")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateAvatarHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateBannerHandler: Handler<ProfileUpdateBannerResponse> =
            jsonHandler<ProfileUpdateBannerResponse>(clientOptions.jsonMapper)

        override fun updateBanner(
            params: ProfileUpdateBannerParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileUpdateBannerResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "profile", "banner")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateBannerHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
