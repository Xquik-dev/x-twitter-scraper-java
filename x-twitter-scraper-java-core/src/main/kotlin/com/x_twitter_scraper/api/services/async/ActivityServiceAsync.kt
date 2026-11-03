// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.activity.ActivityExportParams
import com.x_twitter_scraper.api.models.activity.ActivityListParams
import com.x_twitter_scraper.api.models.activity.ActivityLogRow
import com.x_twitter_scraper.api.models.activity.ActivityRetrieveParams
import com.x_twitter_scraper.api.models.activity.ActivityRecord
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** The account's activity log and the full record of each activity */
interface ActivityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityServiceAsync

    /** Returns 1 activity of the account with its full technical record. It covers every kind of activity the Activity log shows. The record holds the request, the caller, the charge, every timestamp in UTC and related activity. */
    fun retrieve(id: String): CompletableFuture<ActivityRecord> =
        retrieve(id, ActivityRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ActivityRecord> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
    ): CompletableFuture<ActivityRecord> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ActivityRecord>

    /** @see retrieve */
    fun retrieve(params: ActivityRetrieveParams): CompletableFuture<ActivityRecord> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ActivityRecord> =
        retrieve(id, ActivityRetrieveParams.none(), requestOptions)

    /** Returns the account's activity log, newest first, with the Activity page's filters. It covers write actions, extractions, monitor changes and events, webhooks, giveaways, media, support, API keys, X account connections and billing. */
    fun list(): CompletableFuture<List<ActivityLogRow>> = list(ActivityListParams.none())

    /** @see list */
    fun list(
        params: ActivityListParams = ActivityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<ActivityLogRow>>

    /** @see list */
    fun list(params: ActivityListParams = ActivityListParams.none()): CompletableFuture<List<ActivityLogRow>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<ActivityLogRow>> =
        list(ActivityListParams.none(), requestOptions)

    /** @see export */
    fun export(params: ActivityExportParams): CompletableFuture<HttpResponse> =
        export(params, RequestOptions.none())

    /** @see export */
    fun export(
        params: ActivityExportParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** A view of [ActivityServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /activity/{id}`, but is otherwise the same as
         * [ActivityServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ActivityRecord>> =
            retrieve(id, ActivityRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ActivityRecord>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ActivityRecord>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ActivityRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ActivityRecord>>

        /** @see retrieve */
        fun retrieve(
            params: ActivityRetrieveParams
        ): CompletableFuture<HttpResponseFor<ActivityRecord>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ActivityRecord>> =
            retrieve(id, ActivityRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /activity`, but is otherwise the same as
         * [ActivityServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<ActivityLogRow>>> =
            list(ActivityListParams.none())

        /** @see list */
        fun list(
            params: ActivityListParams = ActivityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<ActivityLogRow>>>

        /** @see list */
        fun list(
            params: ActivityListParams = ActivityListParams.none()
        ): CompletableFuture<HttpResponseFor<List<ActivityLogRow>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<ActivityLogRow>>> =
            list(ActivityListParams.none(), requestOptions)

        /** @see export */
        fun export(params: ActivityExportParams): CompletableFuture<HttpResponse> =
            export(params, RequestOptions.none())

        /** @see export */
        fun export(
            params: ActivityExportParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
