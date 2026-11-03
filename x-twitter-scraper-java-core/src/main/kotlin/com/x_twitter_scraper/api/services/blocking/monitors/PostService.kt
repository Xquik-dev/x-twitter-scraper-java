// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.monitors

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.monitors.posts.PostCreateParams
import com.x_twitter_scraper.api.models.monitors.posts.PostDeleteParams
import com.x_twitter_scraper.api.models.monitors.posts.PostDeleteResponse
import com.x_twitter_scraper.api.models.monitors.posts.PostListParams
import com.x_twitter_scraper.api.models.monitors.posts.PostListResponse
import com.x_twitter_scraper.api.models.monitors.posts.PostMonitor
import com.x_twitter_scraper.api.models.monitors.posts.PostMonitorMetrics
import com.x_twitter_scraper.api.models.monitors.posts.PostRetrieveMetricsParams
import com.x_twitter_scraper.api.models.monitors.posts.PostRetrieveParams
import com.x_twitter_scraper.api.models.monitors.posts.PostUpdateParams
import java.util.function.Consumer

/** X account monitoring with 1-second checks */
interface PostService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PostService

    /**
     * Creates a monitor for 1 X post. It tracks replies, quotes, edits, deletion & 6 metrics, for
     * 30 credits an hour with events & webhook deliveries included. That hourly price is a
     * monitor's only charge. Creation needs the credits of the first hour & reads the post once.
     */
    fun create(params: PostCreateParams): PostMonitor =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: PostCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitor

    /**
     * Returns 1 post monitor with its post & the 6 metrics, each with its current value & gain
     * since tracking began.
     */
    fun retrieve(id: String): PostMonitor = retrieve(id, PostRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: PostRetrieveParams = PostRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitor = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: PostRetrieveParams = PostRetrieveParams.none(),
    ): PostMonitor = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: PostRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitor

    /** @see retrieve */
    fun retrieve(params: PostRetrieveParams): PostMonitor =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): PostMonitor =
        retrieve(id, PostRetrieveParams.none(), requestOptions)

    /**
     * Updates a post monitor's label, event types or active state. Turning a paused monitor on
     * reads the post first, & answers 409 while X hides it.
     */
    fun update(id: String): PostMonitor = update(id, PostUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: PostUpdateParams = PostUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitor = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: PostUpdateParams = PostUpdateParams.none(),
    ): PostMonitor = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: PostUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitor

    /** @see update */
    fun update(params: PostUpdateParams): PostMonitor =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): PostMonitor =
        update(id, PostUpdateParams.none(), requestOptions)

    /**
     * Returns post monitors with each post's 6 metrics, their current values & gains since tracking
     * began.
     */
    fun list(): PostListResponse = list(PostListParams.none())

    /** @see list */
    fun list(
        params: PostListParams = PostListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostListResponse

    /** @see list */
    fun list(params: PostListParams = PostListParams.none()): PostListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): PostListResponse =
        list(PostListParams.none(), requestOptions)

    /**
     * Stops 1 post monitor, then removes its stored events & metric history in bounded batches.
     * Poll statusUrl until the monitor returns 404.
     */
    fun delete(id: String): PostDeleteResponse =
        delete(id, PostDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: PostDeleteParams = PostDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: PostDeleteParams = PostDeleteParams.none(),
    ): PostDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: PostDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostDeleteResponse

    /** @see delete */
    fun delete(params: PostDeleteParams): PostDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): PostDeleteResponse =
        delete(id, PostDeleteParams.none(), requestOptions)

    /**
     * Returns 1 bucket per hour with each metric's value at the hour's end & its gain over that
     * hour. The last bucket is the current hour. Hours before tracking began carry the starting
     * values with a gain of 0.
     */
    fun retrieveMetrics(id: String): PostMonitorMetrics =
        retrieveMetrics(id, PostRetrieveMetricsParams.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        id: String,
        params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitorMetrics = retrieveMetrics(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        id: String,
        params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
    ): PostMonitorMetrics = retrieveMetrics(id, params, RequestOptions.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        params: PostRetrieveMetricsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PostMonitorMetrics

    /** @see retrieveMetrics */
    fun retrieveMetrics(params: PostRetrieveMetricsParams): PostMonitorMetrics =
        retrieveMetrics(params, RequestOptions.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(id: String, requestOptions: RequestOptions): PostMonitorMetrics =
        retrieveMetrics(id, PostRetrieveMetricsParams.none(), requestOptions)

    /** A view of [PostService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): PostService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors/posts`, but is otherwise the same as
         * [PostService.create].
         */
        @MustBeClosed
        fun create(params: PostCreateParams): HttpResponseFor<PostMonitor> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: PostCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitor>

        /**
         * Returns a raw HTTP response for `get /monitors/posts/{id}`, but is otherwise the same
         * as [PostService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<PostMonitor> =
            retrieve(id, PostRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: PostRetrieveParams = PostRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitor> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: PostRetrieveParams = PostRetrieveParams.none(),
        ): HttpResponseFor<PostMonitor> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: PostRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitor>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: PostRetrieveParams): HttpResponseFor<PostMonitor> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PostMonitor> =
            retrieve(id, PostRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/posts/{id}`, but is otherwise the
         * same as [PostService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<PostMonitor> =
            update(id, PostUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: PostUpdateParams = PostUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitor> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: PostUpdateParams = PostUpdateParams.none(),
        ): HttpResponseFor<PostMonitor> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: PostUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitor>

        /** @see update */
        @MustBeClosed
        fun update(params: PostUpdateParams): HttpResponseFor<PostMonitor> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PostMonitor> =
            update(id, PostUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/posts`, but is otherwise the same as
         * [PostService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<PostListResponse> = list(PostListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: PostListParams = PostListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: PostListParams = PostListParams.none()
        ): HttpResponseFor<PostListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<PostListResponse> =
            list(PostListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/posts/{id}`, but is otherwise the
         * same as [PostService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<PostDeleteResponse> =
            delete(id, PostDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: PostDeleteParams = PostDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: PostDeleteParams = PostDeleteParams.none(),
        ): HttpResponseFor<PostDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PostDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PostDeleteParams
        ): HttpResponseFor<PostDeleteResponse> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PostDeleteResponse> =
            delete(id, PostDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/posts/{id}/metrics`, but is otherwise the
         * same as [PostService.retrieveMetrics].
         */
        @MustBeClosed
        fun retrieveMetrics(id: String): HttpResponseFor<PostMonitorMetrics> =
            retrieveMetrics(id, PostRetrieveMetricsParams.none())

        /** @see retrieveMetrics */
        @MustBeClosed
        fun retrieveMetrics(
            id: String,
            params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitorMetrics> =
            retrieveMetrics(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMetrics */
        @MustBeClosed
        fun retrieveMetrics(
            id: String,
            params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
        ): HttpResponseFor<PostMonitorMetrics> = retrieveMetrics(id, params, RequestOptions.none())

        /** @see retrieveMetrics */
        @MustBeClosed
        fun retrieveMetrics(
            params: PostRetrieveMetricsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PostMonitorMetrics>

        /** @see retrieveMetrics */
        @MustBeClosed
        fun retrieveMetrics(
            params: PostRetrieveMetricsParams
        ): HttpResponseFor<PostMonitorMetrics> = retrieveMetrics(params, RequestOptions.none())

        /** @see retrieveMetrics */
        @MustBeClosed
        fun retrieveMetrics(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PostMonitorMetrics> =
            retrieveMetrics(id, PostRetrieveMetricsParams.none(), requestOptions)
    }
}
