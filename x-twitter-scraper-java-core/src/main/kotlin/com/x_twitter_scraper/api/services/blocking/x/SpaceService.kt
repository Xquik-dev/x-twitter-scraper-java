// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayResponse
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveResponse
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchResponse
import java.util.function.Consumer

/** X Space details, host, and speakers */
interface SpaceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpaceService

    /**
     * Returns 1 X Space as X shows it, live, scheduled or ended. Accepts the Space ID or the
     * URL-encoded Space URL. A Space X limits to subscribers or a community answers 404.
     */
    fun retrieve(id: String): SpaceRetrieveResponse = retrieve(id, SpaceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: SpaceRetrieveParams = SpaceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpaceRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: SpaceRetrieveParams = SpaceRetrieveParams.none(),
    ): SpaceRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SpaceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpaceRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: SpaceRetrieveParams): SpaceRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): SpaceRetrieveResponse =
        retrieve(id, SpaceRetrieveParams.none(), requestOptions)

    /**
     * Returns the recording X plays back once a Space is over, in state Ended or TimedOut. Accepts
     * the Space ID or the URL-encoded Space URL. Check state and isAvailableForReplay with the
     * Space lookup first. A live or scheduled Space answers 409, and a cancelled one 404.
     */
    fun retrieveReplay(id: String): SpaceRetrieveReplayResponse =
        retrieveReplay(id, SpaceRetrieveReplayParams.none())

    /** @see retrieveReplay */
    fun retrieveReplay(
        id: String,
        params: SpaceRetrieveReplayParams = SpaceRetrieveReplayParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpaceRetrieveReplayResponse =
        retrieveReplay(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveReplay */
    fun retrieveReplay(
        id: String,
        params: SpaceRetrieveReplayParams = SpaceRetrieveReplayParams.none(),
    ): SpaceRetrieveReplayResponse = retrieveReplay(id, params, RequestOptions.none())

    /** @see retrieveReplay */
    fun retrieveReplay(
        params: SpaceRetrieveReplayParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpaceRetrieveReplayResponse

    /** @see retrieveReplay */
    fun retrieveReplay(params: SpaceRetrieveReplayParams): SpaceRetrieveReplayResponse =
        retrieveReplay(params, RequestOptions.none())

    /** @see retrieveReplay */
    fun retrieveReplay(id: String, requestOptions: RequestOptions): SpaceRetrieveReplayResponse =
        retrieveReplay(id, SpaceRetrieveReplayParams.none(), requestOptions)

    /**
     * Returns public Spaces each once, as GET /x/spaces/{id} serves them. Latest & Top find the
     * Spaces that matching posts share, live, scheduled or ended. Live & Upcoming read X's own
     * Spaces search, in X's order. It finds live or scheduled Spaces by the words in their titles.
     * Costs 1 credit per Space.
     */
    fun search(params: SpaceSearchParams): SpaceSearchResponse =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: SpaceSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpaceSearchResponse

    /** A view of [SpaceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpaceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/spaces/{id}`, but is otherwise the same as
         * [SpaceService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<SpaceRetrieveResponse> =
            retrieve(id, SpaceRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: SpaceRetrieveParams = SpaceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpaceRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: SpaceRetrieveParams = SpaceRetrieveParams.none(),
        ): HttpResponseFor<SpaceRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SpaceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpaceRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: SpaceRetrieveParams): HttpResponseFor<SpaceRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpaceRetrieveResponse> =
            retrieve(id, SpaceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/spaces/{id}/replay`, but is otherwise the same as
         * [SpaceService.retrieveReplay].
         */
        @MustBeClosed
        fun retrieveReplay(id: String): HttpResponseFor<SpaceRetrieveReplayResponse> =
            retrieveReplay(id, SpaceRetrieveReplayParams.none())

        /** @see retrieveReplay */
        @MustBeClosed
        fun retrieveReplay(
            id: String,
            params: SpaceRetrieveReplayParams = SpaceRetrieveReplayParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpaceRetrieveReplayResponse> =
            retrieveReplay(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveReplay */
        @MustBeClosed
        fun retrieveReplay(
            id: String,
            params: SpaceRetrieveReplayParams = SpaceRetrieveReplayParams.none(),
        ): HttpResponseFor<SpaceRetrieveReplayResponse> =
            retrieveReplay(id, params, RequestOptions.none())

        /** @see retrieveReplay */
        @MustBeClosed
        fun retrieveReplay(
            params: SpaceRetrieveReplayParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpaceRetrieveReplayResponse>

        /** @see retrieveReplay */
        @MustBeClosed
        fun retrieveReplay(
            params: SpaceRetrieveReplayParams
        ): HttpResponseFor<SpaceRetrieveReplayResponse> =
            retrieveReplay(params, RequestOptions.none())

        /** @see retrieveReplay */
        @MustBeClosed
        fun retrieveReplay(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpaceRetrieveReplayResponse> =
            retrieveReplay(id, SpaceRetrieveReplayParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/spaces/search`, but is otherwise the same as
         * [SpaceService.search].
         */
        @MustBeClosed
        fun search(params: SpaceSearchParams): HttpResponseFor<SpaceSearchResponse> =
            search(params, RequestOptions.none())

        /** @see search */
        @MustBeClosed
        fun search(
            params: SpaceSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpaceSearchResponse>
    }
}
