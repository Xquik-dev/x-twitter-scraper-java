// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.support

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.models.support.attachments.AttachmentDownloadParams
import java.util.function.Consumer

/** Support ticket management */
interface AttachmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AttachmentService

    /**
     * Streams an authenticated user's support image or video. Video requests support one standard
     * byte range for seeking and resumable playback.
     */
    @MustBeClosed
    fun download(id: String): HttpResponse = download(id, AttachmentDownloadParams.none())

    /** @see download */
    @MustBeClosed
    fun download(
        id: String,
        params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = download(params.toBuilder().id(id).build(), requestOptions)

    /** @see download */
    @MustBeClosed
    fun download(
        id: String,
        params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
    ): HttpResponse = download(id, params, RequestOptions.none())

    /** @see download */
    @MustBeClosed
    fun download(
        params: AttachmentDownloadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see download */
    @MustBeClosed
    fun download(params: AttachmentDownloadParams): HttpResponse =
        download(params, RequestOptions.none())

    /** @see download */
    @MustBeClosed
    fun download(id: String, requestOptions: RequestOptions): HttpResponse =
        download(id, AttachmentDownloadParams.none(), requestOptions)

    /** A view of [AttachmentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AttachmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /support/attachments/{id}`, but is otherwise the
         * same as [AttachmentService.download].
         */
        @MustBeClosed
        fun download(id: String): HttpResponse = download(id, AttachmentDownloadParams.none())

        /** @see download */
        @MustBeClosed
        fun download(
            id: String,
            params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = download(params.toBuilder().id(id).build(), requestOptions)

        /** @see download */
        @MustBeClosed
        fun download(
            id: String,
            params: AttachmentDownloadParams = AttachmentDownloadParams.none(),
        ): HttpResponse = download(id, params, RequestOptions.none())

        /** @see download */
        @MustBeClosed
        fun download(
            params: AttachmentDownloadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see download */
        @MustBeClosed
        fun download(params: AttachmentDownloadParams): HttpResponse =
            download(params, RequestOptions.none())

        /** @see download */
        @MustBeClosed
        fun download(id: String, requestOptions: RequestOptions): HttpResponse =
            download(id, AttachmentDownloadParams.none(), requestOptions)
    }
}
