// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.media.MediaDownloadResponse
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Media upload and download */
interface MediaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MediaServiceAsync

    /** Download images & videos from tweets */
    fun download(): CompletableFuture<MediaDownloadResponse> = download(MediaDownloadParams.none())

    /** @see download */
    fun download(
        params: MediaDownloadParams = MediaDownloadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MediaDownloadResponse>

    /** @see download */
    fun download(
        params: MediaDownloadParams = MediaDownloadParams.none()
    ): CompletableFuture<MediaDownloadResponse> = download(params, RequestOptions.none())

    /** @see download */
    fun download(requestOptions: RequestOptions): CompletableFuture<MediaDownloadResponse> =
        download(MediaDownloadParams.none(), requestOptions)

    /** Upload media */
    fun upload(params: MediaUploadParams): CompletableFuture<MediaUploadResponse> =
        upload(params, RequestOptions.none())

    /** @see upload */
    fun upload(
        params: MediaUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MediaUploadResponse>

    /** A view of [MediaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MediaServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/media/download`, but is otherwise the same as
         * [MediaServiceAsync.download].
         */
        fun download(): CompletableFuture<HttpResponseFor<MediaDownloadResponse>> =
            download(MediaDownloadParams.none())

        /** @see download */
        fun download(
            params: MediaDownloadParams = MediaDownloadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MediaDownloadResponse>>

        /** @see download */
        fun download(
            params: MediaDownloadParams = MediaDownloadParams.none()
        ): CompletableFuture<HttpResponseFor<MediaDownloadResponse>> =
            download(params, RequestOptions.none())

        /** @see download */
        fun download(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MediaDownloadResponse>> =
            download(MediaDownloadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /x/media`, but is otherwise the same as
         * [MediaServiceAsync.upload].
         */
        fun upload(
            params: MediaUploadParams
        ): CompletableFuture<HttpResponseFor<MediaUploadResponse>> =
            upload(params, RequestOptions.none())

        /** @see upload */
        fun upload(
            params: MediaUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MediaUploadResponse>>
    }
}
