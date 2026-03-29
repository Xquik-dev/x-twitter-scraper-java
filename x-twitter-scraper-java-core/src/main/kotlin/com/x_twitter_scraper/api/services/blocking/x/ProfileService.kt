// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllParams
import com.x_twitter_scraper.api.models.x.profile.ProfilePatchAllResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarResponse
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerResponse
import java.util.function.Consumer

/** X write actions (tweets, likes, follows, DMs) */
interface ProfileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService

    /** Update X profile */
    fun patchAll(params: ProfilePatchAllParams): ProfilePatchAllResponse =
        patchAll(params, RequestOptions.none())

    /** @see patchAll */
    fun patchAll(
        params: ProfilePatchAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfilePatchAllResponse

    /** Update profile avatar */
    fun updateAvatar(params: ProfileUpdateAvatarParams): ProfileUpdateAvatarResponse =
        updateAvatar(params, RequestOptions.none())

    /** @see updateAvatar */
    fun updateAvatar(
        params: ProfileUpdateAvatarParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileUpdateAvatarResponse

    /** Update profile banner */
    fun updateBanner(params: ProfileUpdateBannerParams): ProfileUpdateBannerResponse =
        updateBanner(params, RequestOptions.none())

    /** @see updateBanner */
    fun updateBanner(
        params: ProfileUpdateBannerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileUpdateBannerResponse

    /** A view of [ProfileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /x/profile`, but is otherwise the same as
         * [ProfileService.patchAll].
         */
        @MustBeClosed
        fun patchAll(params: ProfilePatchAllParams): HttpResponseFor<ProfilePatchAllResponse> =
            patchAll(params, RequestOptions.none())

        /** @see patchAll */
        @MustBeClosed
        fun patchAll(
            params: ProfilePatchAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfilePatchAllResponse>

        /**
         * Returns a raw HTTP response for `patch /x/profile/avatar`, but is otherwise the same as
         * [ProfileService.updateAvatar].
         */
        @MustBeClosed
        fun updateAvatar(
            params: ProfileUpdateAvatarParams
        ): HttpResponseFor<ProfileUpdateAvatarResponse> =
            updateAvatar(params, RequestOptions.none())

        /** @see updateAvatar */
        @MustBeClosed
        fun updateAvatar(
            params: ProfileUpdateAvatarParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileUpdateAvatarResponse>

        /**
         * Returns a raw HTTP response for `patch /x/profile/banner`, but is otherwise the same as
         * [ProfileService.updateBanner].
         */
        @MustBeClosed
        fun updateBanner(
            params: ProfileUpdateBannerParams
        ): HttpResponseFor<ProfileUpdateBannerResponse> =
            updateBanner(params, RequestOptions.none())

        /** @see updateBanner */
        @MustBeClosed
        fun updateBanner(
            params: ProfileUpdateBannerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileUpdateBannerResponse>
    }
}
