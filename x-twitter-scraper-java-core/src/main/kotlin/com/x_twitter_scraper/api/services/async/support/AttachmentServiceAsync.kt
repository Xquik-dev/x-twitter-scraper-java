// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.support

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.models.support.attachments.AttachmentDownloadParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Support ticket management */
interface AttachmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AttachmentServiceAsync

    /**
     * Streams an authenticated user's support image or video. Video requests support one standard
     * byte range for seeking and resumable playback.
     */
    fun download(id: String): CompletableFuture<HttpResponse> =
        download(id, AttachmentDownloadParams.none())

    /** @see download */
    fun download(
        id: String,
        params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> = download(params.toBuilder().id(id).build(), requestOptions)

    /** @see download */
    fun download(
        id: String,
        params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
    ): CompletableFuture<HttpResponse> = download(id, params, RequestOptions.none())

    /** @see download */
    fun download(
        params: AttachmentDownloadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see download */
    fun download(params: AttachmentDownloadParams): CompletableFuture<HttpResponse> =
        download(params, RequestOptions.none())

    /** @see download */
    fun download(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
        download(id, AttachmentDownloadParams.none(), requestOptions)

    /**
     * A view of [AttachmentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AttachmentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /support/attachments/{id}`, but is otherwise the
         * same as [AttachmentServiceAsync.download].
         */
        fun download(id: String): CompletableFuture<HttpResponse> =
            download(id, AttachmentDownloadParams.none())

        /** @see download */
        fun download(
            id: String,
            params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            download(params.toBuilder().id(id).build(), requestOptions)

        /** @see download */
        fun download(
            id: String,
            params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
        ): CompletableFuture<HttpResponse> = download(id, params, RequestOptions.none())

        /** @see download */
        fun download(
            params: AttachmentDownloadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see download */
        fun download(params: AttachmentDownloadParams): CompletableFuture<HttpResponse> =
            download(params, RequestOptions.none())

        /** @see download */
        fun download(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            download(id, AttachmentDownloadParams.none(), requestOptions)
    }
}
