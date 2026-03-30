// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaDownloadResponse
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadResponse
import java.util.function.Consumer

/** Media upload & download */
interface MediaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MediaService

    /** Download tweet media */
    fun download(): MediaDownloadResponse = download(MediaDownloadParams.none())

    /** @see download */
    fun download(
        params: MediaDownloadParams = MediaDownloadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MediaDownloadResponse

    /** @see download */
    fun download(params: MediaDownloadParams = MediaDownloadParams.none()): MediaDownloadResponse =
        download(params, RequestOptions.none())

    /** @see download */
    fun download(requestOptions: RequestOptions): MediaDownloadResponse =
        download(MediaDownloadParams.none(), requestOptions)

    /** Upload media */
    fun upload(params: MediaUploadParams): MediaUploadResponse =
        upload(params, RequestOptions.none())

    /** @see upload */
    fun upload(
        params: MediaUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MediaUploadResponse

    /** A view of [MediaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MediaService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/media/download`, but is otherwise the same as
         * [MediaService.download].
         */
        @MustBeClosed
        fun download(): HttpResponseFor<MediaDownloadResponse> =
            download(MediaDownloadParams.none())

        /** @see download */
        @MustBeClosed
        fun download(
            params: MediaDownloadParams = MediaDownloadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MediaDownloadResponse>

        /** @see download */
        @MustBeClosed
        fun download(
            params: MediaDownloadParams = MediaDownloadParams.none()
        ): HttpResponseFor<MediaDownloadResponse> = download(params, RequestOptions.none())

        /** @see download */
        @MustBeClosed
        fun download(requestOptions: RequestOptions): HttpResponseFor<MediaDownloadResponse> =
            download(MediaDownloadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/media`, but is otherwise the same as
         * [MediaService.upload].
         */
        @MustBeClosed
        fun upload(params: MediaUploadParams): HttpResponseFor<MediaUploadResponse> =
            upload(params, RequestOptions.none())

        /** @see upload */
        @MustBeClosed
        fun upload(
            params: MediaUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MediaUploadResponse>
    }
}
