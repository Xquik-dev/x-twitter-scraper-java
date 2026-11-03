// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.activity.ActivityListParams
import com.x_twitter_scraper.api.models.activity.ActivityLogRow
import com.x_twitter_scraper.api.models.activity.ActivityRecord
import com.x_twitter_scraper.api.models.activity.ActivityRetrieveParams
import java.util.function.Consumer

/** The account's activity log and the full record of each activity */
interface ActivityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityService

    /**
     * Returns 1 activity of the account with its full technical record. It covers every kind of
     * activity the Activity log shows. The record holds the request, the caller, the charge, every
     * timestamp in UTC and related activity.
     */
    fun retrieve(id: String): ActivityRecord = retrieve(id, ActivityRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ActivityRecord = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
    ): ActivityRecord = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ActivityRecord

    /** @see retrieve */
    fun retrieve(params: ActivityRetrieveParams): ActivityRecord =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ActivityRecord =
        retrieve(id, ActivityRetrieveParams.none(), requestOptions)

    /**
     * Returns the account's activity log, newest first, with the Activity page's filters. It covers
     * write actions, extractions, monitor changes and events, webhooks, giveaways, media, support,
     * API keys, X account connections and billing.
     */
    fun list(): List<ActivityLogRow> = list(ActivityListParams.none())

    /** @see list */
    fun list(
        params: ActivityListParams = ActivityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<ActivityLogRow>

    /** @see list */
    fun list(params: ActivityListParams = ActivityListParams.none()): List<ActivityLogRow> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<ActivityLogRow> =
        list(ActivityListParams.none(), requestOptions)

    /** A view of [ActivityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /activity/{id}`, but is otherwise the same as
         * [ActivityService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ActivityRecord> =
            retrieve(id, ActivityRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ActivityRecord> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ActivityRetrieveParams = ActivityRetrieveParams.none(),
        ): HttpResponseFor<ActivityRecord> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ActivityRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ActivityRecord>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ActivityRetrieveParams): HttpResponseFor<ActivityRecord> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ActivityRecord> =
            retrieve(id, ActivityRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /activity`, but is otherwise the same as
         * [ActivityService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<ActivityLogRow>> = list(ActivityListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ActivityListParams = ActivityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<ActivityLogRow>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ActivityListParams = ActivityListParams.none()
        ): HttpResponseFor<List<ActivityLogRow>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<ActivityLogRow>> =
            list(ActivityListParams.none(), requestOptions)
    }
}
