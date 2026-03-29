// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllParams
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface ProfileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileServiceAsync

    /** Update X profile */
    fun patchAll(params: ProfilePatchAllParams): CompletableFuture<ProfilePatchAllResponse> =
        patchAll(params, RequestOptions.none())

    /** @see patchAll */
    fun patchAll(
        params: ProfilePatchAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfilePatchAllResponse>

    /** Update profile avatar */
    fun updateAvatar(
        params: ProfileUpdateAvatarParams
    ): CompletableFuture<ProfileUpdateAvatarResponse> = updateAvatar(params, RequestOptions.none())

    /** @see updateAvatar */
    fun updateAvatar(
        params: ProfileUpdateAvatarParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfileUpdateAvatarResponse>

    /** Update profile banner */
    fun updateBanner(
        params: ProfileUpdateBannerParams
    ): CompletableFuture<ProfileUpdateBannerResponse> = updateBanner(params, RequestOptions.none())

    /** @see updateBanner */
    fun updateBanner(
        params: ProfileUpdateBannerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfileUpdateBannerResponse>

    /**
     * A view of [ProfileServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProfileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /x/profile`, but is otherwise the same as
         * [ProfileServiceAsync.patchAll].
         */
        fun patchAll(
            params: ProfilePatchAllParams
        ): CompletableFuture<HttpResponseFor<ProfilePatchAllResponse>> =
            patchAll(params, RequestOptions.none())

        /** @see patchAll */
        fun patchAll(
            params: ProfilePatchAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfilePatchAllResponse>>

        /**
         * Returns a raw HTTP response for `patch /x/profile/avatar`, but is otherwise the same as
         * [ProfileServiceAsync.updateAvatar].
         */
        fun updateAvatar(
            params: ProfileUpdateAvatarParams
        ): CompletableFuture<HttpResponseFor<ProfileUpdateAvatarResponse>> =
            updateAvatar(params, RequestOptions.none())

        /** @see updateAvatar */
        fun updateAvatar(
            params: ProfileUpdateAvatarParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfileUpdateAvatarResponse>>

        /**
         * Returns a raw HTTP response for `patch /x/profile/banner`, but is otherwise the same as
         * [ProfileServiceAsync.updateBanner].
         */
        fun updateBanner(
            params: ProfileUpdateBannerParams
        ): CompletableFuture<HttpResponseFor<ProfileUpdateBannerResponse>> =
            updateBanner(params, RequestOptions.none())

        /** @see updateBanner */
        fun updateBanner(
            params: ProfileUpdateBannerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfileUpdateBannerResponse>>
    }
}
