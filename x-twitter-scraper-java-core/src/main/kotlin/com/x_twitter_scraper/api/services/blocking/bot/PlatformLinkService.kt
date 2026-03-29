// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.bot

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkCreateResponse
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkDeleteResponse
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupParams
import com.x_twitter_scraper.api.models.bot.platformlinks.PlatformLinkLookupResponse
import java.util.function.Consumer

/** Telegram bot service endpoints */
interface PlatformLinkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlatformLinkService

    /** Link a platform user to an Xquik account */
    fun create(params: PlatformLinkCreateParams): PlatformLinkCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: PlatformLinkCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PlatformLinkCreateResponse

    /** Unlink a platform user from an Xquik account */
    fun delete(params: PlatformLinkDeleteParams): PlatformLinkDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: PlatformLinkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PlatformLinkDeleteResponse

    /** Look up an Xquik user by platform identity */
    fun lookup(params: PlatformLinkLookupParams): PlatformLinkLookupResponse =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: PlatformLinkLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PlatformLinkLookupResponse

    /**
     * A view of [PlatformLinkService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlatformLinkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /bot/platform-links`, but is otherwise the same as
         * [PlatformLinkService.create].
         */
        @MustBeClosed
        fun create(params: PlatformLinkCreateParams): HttpResponseFor<PlatformLinkCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: PlatformLinkCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PlatformLinkCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /bot/platform-links`, but is otherwise the same
         * as [PlatformLinkService.delete].
         */
        @MustBeClosed
        fun delete(params: PlatformLinkDeleteParams): HttpResponseFor<PlatformLinkDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PlatformLinkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PlatformLinkDeleteResponse>

        /**
         * Returns a raw HTTP response for `get /bot/platform-links/lookup`, but is otherwise the
         * same as [PlatformLinkService.lookup].
         */
        @MustBeClosed
        fun lookup(params: PlatformLinkLookupParams): HttpResponseFor<PlatformLinkLookupResponse> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: PlatformLinkLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PlatformLinkLookupResponse>
    }
}
