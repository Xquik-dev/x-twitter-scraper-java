// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.jobs.JobListLocationsParams
import com.x_twitter_scraper.api.models.x.jobs.JobListLocationsResponse
import com.x_twitter_scraper.api.models.x.jobs.JobRetrieveParams
import com.x_twitter_scraper.api.models.x.jobs.JobRetrieveResponse
import com.x_twitter_scraper.api.models.x.jobs.JobSearchParams
import com.x_twitter_scraper.api.models.x.jobs.JobSearchResponse
import java.util.function.Consumer

/** Public X job listings, search and details */
interface JobService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobService

    /**
     * Returns a public job listing with its description as text & Markdown, work type, seniority,
     * salary, company & apply link. A job that closed returns job_not_found & is free.
     */
    fun retrieve(id: String): JobRetrieveResponse = retrieve(id, JobRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: JobRetrieveParams = JobRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: JobRetrieveParams = JobRetrieveParams.none(),
    ): JobRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: JobRetrieveParams): JobRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): JobRetrieveResponse =
        retrieve(id, JobRetrieveParams.none(), requestOptions)

    /**
     * Returns the places whose names match a query, each with the location ID that GET
     * /x/jobs/search takes. No match returns an empty list, free.
     */
    fun listLocations(params: JobListLocationsParams): JobListLocationsResponse =
        listLocations(params, RequestOptions.none())

    /** @see listLocations */
    fun listLocations(
        params: JobListLocationsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobListLocationsResponse

    /**
     * Returns job listings with title, location, salary, company & apply link. Add filters to
     * narrow them. A closed job does not appear & costs nothing. Follow next_cursor for more.
     */
    fun search(params: JobSearchParams): JobSearchResponse = search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: JobSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobSearchResponse

    /** A view of [JobService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/jobs/{id}`, but is otherwise the same as
         * [JobService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<JobRetrieveResponse> =
            retrieve(id, JobRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: JobRetrieveParams = JobRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: JobRetrieveParams = JobRetrieveParams.none(),
        ): HttpResponseFor<JobRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: JobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: JobRetrieveParams): HttpResponseFor<JobRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JobRetrieveResponse> =
            retrieve(id, JobRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/jobs/locations`, but is otherwise the same as
         * [JobService.listLocations].
         */
        @MustBeClosed
        fun listLocations(
            params: JobListLocationsParams
        ): HttpResponseFor<JobListLocationsResponse> = listLocations(params, RequestOptions.none())

        /** @see listLocations */
        @MustBeClosed
        fun listLocations(
            params: JobListLocationsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobListLocationsResponse>

        /**
         * Returns a raw HTTP response for `get /x/jobs/search`, but is otherwise the same as
         * [JobService.search].
         */
        @MustBeClosed
        fun search(params: JobSearchParams): HttpResponseFor<JobSearchResponse> =
            search(params, RequestOptions.none())

        /** @see search */
        @MustBeClosed
        fun search(
            params: JobSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobSearchResponse>
    }
}
