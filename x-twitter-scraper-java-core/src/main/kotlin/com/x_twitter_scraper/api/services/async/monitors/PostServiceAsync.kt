// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.monitors

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X account monitoring with 1-second checks */
interface PostServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PostServiceAsync

    /**
     * Creates a monitor for 1 X post. It tracks replies, quotes, edits, deletion & 6 metrics, for
     * 30 credits an hour with events & webhook deliveries included. That hourly price is a
     * monitor's only charge. Creation needs the credits of the first hour & reads the post once.
     */
    fun create(params: PostCreateParams): CompletableFuture<PostMonitor> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: PostCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitor>

    /**
     * Returns 1 post monitor with its post & the 6 metrics, each with its current value & gain
     * since tracking began.
     */
    fun retrieve(id: String): CompletableFuture<PostMonitor> =
        retrieve(id, PostRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: PostRetrieveParams = PostRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitor> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: PostRetrieveParams = PostRetrieveParams.none(),
    ): CompletableFuture<PostMonitor> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: PostRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitor>

    /** @see retrieve */
    fun retrieve(params: PostRetrieveParams): CompletableFuture<PostMonitor> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitor> =
        retrieve(id, PostRetrieveParams.none(), requestOptions)

    /**
     * Updates a post monitor's label, event types or active state. Turning a paused monitor on
     * reads the post first, & answers 409 while X hides it.
     */
    fun update(id: String): CompletableFuture<PostMonitor> =
        update(id, PostUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: PostUpdateParams = PostUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitor> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: PostUpdateParams = PostUpdateParams.none(),
    ): CompletableFuture<PostMonitor> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: PostUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitor>

    /** @see update */
    fun update(params: PostUpdateParams): CompletableFuture<PostMonitor> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitor> =
        update(id, PostUpdateParams.none(), requestOptions)

    /**
     * Returns post monitors with each post's 6 metrics, their current values & gains since tracking
     * began.
     */
    fun list(): CompletableFuture<PostListResponse> = list(PostListParams.none())

    /** @see list */
    fun list(
        params: PostListParams = PostListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostListResponse>

    /** @see list */
    fun list(
        params: PostListParams = PostListParams.none()
    ): CompletableFuture<PostListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<PostListResponse> =
        list(PostListParams.none(), requestOptions)

    /**
     * Stops 1 post monitor, then removes its stored events & metric history in bounded batches.
     * Poll statusUrl until the monitor returns 404.
     */
    fun delete(id: String): CompletableFuture<PostDeleteResponse> =
        delete(id, PostDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: PostDeleteParams = PostDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: PostDeleteParams = PostDeleteParams.none(),
    ): CompletableFuture<PostDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: PostDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostDeleteResponse>

    /** @see delete */
    fun delete(params: PostDeleteParams): CompletableFuture<PostDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostDeleteResponse> =
        delete(id, PostDeleteParams.none(), requestOptions)

    /**
     * Returns 1 bucket per hour with each metric's value at the hour's end & its gain over that
     * hour. The last bucket is the current hour. Hours before tracking began carry the starting
     * values with a gain of 0.
     */
    fun retrieveMetrics(id: String): CompletableFuture<PostMonitorMetrics> =
        retrieveMetrics(id, PostRetrieveMetricsParams.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        id: String,
        params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitorMetrics> =
        retrieveMetrics(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        id: String,
        params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
    ): CompletableFuture<PostMonitorMetrics> = retrieveMetrics(id, params, RequestOptions.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        params: PostRetrieveMetricsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PostMonitorMetrics>

    /** @see retrieveMetrics */
    fun retrieveMetrics(params: PostRetrieveMetricsParams): CompletableFuture<PostMonitorMetrics> =
        retrieveMetrics(params, RequestOptions.none())

    /** @see retrieveMetrics */
    fun retrieveMetrics(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitorMetrics> =
        retrieveMetrics(id, PostRetrieveMetricsParams.none(), requestOptions)

    /**
     * A view of [PostServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PostServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /monitors/posts`, but is otherwise the same as
         * [PostServiceAsync.create].
         */
        fun create(
            params: PostCreateParams
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: PostCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>>

        /**
         * Returns a raw HTTP response for `get /monitors/posts/{id}`, but is otherwise the same
         * as [PostServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<PostMonitor>> =
            retrieve(id, PostRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: PostRetrieveParams = PostRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: PostRetrieveParams = PostRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: PostRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>>

        /** @see retrieve */
        fun retrieve(
            params: PostRetrieveParams
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            retrieve(id, PostRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /monitors/posts/{id}`, but is otherwise the
         * same as [PostServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<PostMonitor>> =
            update(id, PostUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: PostUpdateParams = PostUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: PostUpdateParams = PostUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: PostUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitor>>

        /** @see update */
        fun update(
            params: PostUpdateParams
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitor>> =
            update(id, PostUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/posts`, but is otherwise the same as
         * [PostServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<PostListResponse>> =
            list(PostListParams.none())

        /** @see list */
        fun list(
            params: PostListParams = PostListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostListResponse>>

        /** @see list */
        fun list(
            params: PostListParams = PostListParams.none()
        ): CompletableFuture<HttpResponseFor<PostListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<PostListResponse>> =
            list(PostListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /monitors/posts/{id}`, but is otherwise the
         * same as [PostServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<PostDeleteResponse>> =
            delete(id, PostDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: PostDeleteParams = PostDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: PostDeleteParams = PostDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: PostDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>>

        /** @see delete */
        fun delete(
            params: PostDeleteParams
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>> =
            delete(id, PostDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /monitors/posts/{id}/metrics`, but is otherwise the
         * same as [PostServiceAsync.retrieveMetrics].
         */
        fun retrieveMetrics(id: String): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> =
            retrieveMetrics(id, PostRetrieveMetricsParams.none())

        /** @see retrieveMetrics */
        fun retrieveMetrics(
            id: String,
            params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> =
            retrieveMetrics(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveMetrics */
        fun retrieveMetrics(
            id: String,
            params: PostRetrieveMetricsParams = PostRetrieveMetricsParams.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> =
            retrieveMetrics(id, params, RequestOptions.none())

        /** @see retrieveMetrics */
        fun retrieveMetrics(
            params: PostRetrieveMetricsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>>

        /** @see retrieveMetrics */
        fun retrieveMetrics(
            params: PostRetrieveMetricsParams
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> =
            retrieveMetrics(params, RequestOptions.none())

        /** @see retrieveMetrics */
        fun retrieveMetrics(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> =
            retrieveMetrics(id, PostRetrieveMetricsParams.none(), requestOptions)
    }
}
