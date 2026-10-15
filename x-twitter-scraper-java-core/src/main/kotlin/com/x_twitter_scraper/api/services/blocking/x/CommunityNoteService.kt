// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorResponse
import java.util.function.Consumer

/** Community Notes contributors, their notes, ratings & deleted notes */
interface CommunityNoteService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityNoteService

    /**
     * Returns the notes a contributor deleted, newest first. X keeps each note's ID, times, rating
     * & tags. A notice replaces its text & post. Each note costs 1 credit. A contributor who
     * deleted none returns an empty list, free.
     */
    fun listContributorDeletedNotes(
        alias: String
    ): CommunityNoteListContributorDeletedNotesResponse =
        listContributorDeletedNotes(alias, CommunityNoteListContributorDeletedNotesParams.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        params: CommunityNoteListContributorDeletedNotesParams =
            CommunityNoteListContributorDeletedNotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteListContributorDeletedNotesResponse =
        listContributorDeletedNotes(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        params: CommunityNoteListContributorDeletedNotesParams =
            CommunityNoteListContributorDeletedNotesParams.none(),
    ): CommunityNoteListContributorDeletedNotesResponse =
        listContributorDeletedNotes(alias, params, RequestOptions.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        params: CommunityNoteListContributorDeletedNotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteListContributorDeletedNotesResponse

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        params: CommunityNoteListContributorDeletedNotesParams
    ): CommunityNoteListContributorDeletedNotesResponse =
        listContributorDeletedNotes(params, RequestOptions.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        requestOptions: RequestOptions,
    ): CommunityNoteListContributorDeletedNotesResponse =
        listContributorDeletedNotes(
            alias,
            CommunityNoteListContributorDeletedNotesParams.none(),
            requestOptions,
        )

    /**
     * Returns a contributor's notes, newest first, each with the post it is on. Includes notes X
     * has not rated helpful, which x.com shows under no post. Each note costs 1 credit. Follow
     * next_cursor for more.
     */
    fun listContributorNotes(alias: String): CommunityNoteListContributorNotesResponse =
        listContributorNotes(alias, CommunityNoteListContributorNotesParams.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        params: CommunityNoteListContributorNotesParams =
            CommunityNoteListContributorNotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteListContributorNotesResponse =
        listContributorNotes(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        params: CommunityNoteListContributorNotesParams =
            CommunityNoteListContributorNotesParams.none(),
    ): CommunityNoteListContributorNotesResponse =
        listContributorNotes(alias, params, RequestOptions.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        params: CommunityNoteListContributorNotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteListContributorNotesResponse

    /** @see listContributorNotes */
    fun listContributorNotes(
        params: CommunityNoteListContributorNotesParams
    ): CommunityNoteListContributorNotesResponse =
        listContributorNotes(params, RequestOptions.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        requestOptions: RequestOptions,
    ): CommunityNoteListContributorNotesResponse =
        listContributorNotes(alias, CommunityNoteListContributorNotesParams.none(), requestOptions)

    /**
     * Returns 1 Community Notes contributor by the alias X gives them. Includes note counts by
     * rating, rating counts & the deleted notes count. Each lookup costs 1 credit.
     */
    fun retrieveContributor(alias: String): CommunityNoteRetrieveContributorResponse =
        retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        params: CommunityNoteRetrieveContributorParams =
            CommunityNoteRetrieveContributorParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteRetrieveContributorResponse =
        retrieveContributor(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        params: CommunityNoteRetrieveContributorParams =
            CommunityNoteRetrieveContributorParams.none(),
    ): CommunityNoteRetrieveContributorResponse =
        retrieveContributor(alias, params, RequestOptions.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        params: CommunityNoteRetrieveContributorParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommunityNoteRetrieveContributorResponse

    /** @see retrieveContributor */
    fun retrieveContributor(
        params: CommunityNoteRetrieveContributorParams
    ): CommunityNoteRetrieveContributorResponse = retrieveContributor(params, RequestOptions.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        requestOptions: RequestOptions,
    ): CommunityNoteRetrieveContributorResponse =
        retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none(), requestOptions)

    /**
     * A view of [CommunityNoteService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityNoteService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /x/community-notes/contributors/{alias}/deleted-notes`, but is otherwise the same as
         * [CommunityNoteService.listContributorDeletedNotes].
         */
        @MustBeClosed
        fun listContributorDeletedNotes(
            alias: String
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse> =
            listContributorDeletedNotes(
                alias,
                CommunityNoteListContributorDeletedNotesParams.none(),
            )

        /** @see listContributorDeletedNotes */
        @MustBeClosed
        fun listContributorDeletedNotes(
            alias: String,
            params: CommunityNoteListContributorDeletedNotesParams =
                CommunityNoteListContributorDeletedNotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse> =
            listContributorDeletedNotes(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see listContributorDeletedNotes */
        @MustBeClosed
        fun listContributorDeletedNotes(
            alias: String,
            params: CommunityNoteListContributorDeletedNotesParams =
                CommunityNoteListContributorDeletedNotesParams.none(),
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse> =
            listContributorDeletedNotes(alias, params, RequestOptions.none())

        /** @see listContributorDeletedNotes */
        @MustBeClosed
        fun listContributorDeletedNotes(
            params: CommunityNoteListContributorDeletedNotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>

        /** @see listContributorDeletedNotes */
        @MustBeClosed
        fun listContributorDeletedNotes(
            params: CommunityNoteListContributorDeletedNotesParams
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse> =
            listContributorDeletedNotes(params, RequestOptions.none())

        /** @see listContributorDeletedNotes */
        @MustBeClosed
        fun listContributorDeletedNotes(
            alias: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse> =
            listContributorDeletedNotes(
                alias,
                CommunityNoteListContributorDeletedNotesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /x/community-notes/contributors/{alias}/notes`, but
         * is otherwise the same as [CommunityNoteService.listContributorNotes].
         */
        @MustBeClosed
        fun listContributorNotes(
            alias: String
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse> =
            listContributorNotes(alias, CommunityNoteListContributorNotesParams.none())

        /** @see listContributorNotes */
        @MustBeClosed
        fun listContributorNotes(
            alias: String,
            params: CommunityNoteListContributorNotesParams =
                CommunityNoteListContributorNotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse> =
            listContributorNotes(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see listContributorNotes */
        @MustBeClosed
        fun listContributorNotes(
            alias: String,
            params: CommunityNoteListContributorNotesParams =
                CommunityNoteListContributorNotesParams.none(),
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse> =
            listContributorNotes(alias, params, RequestOptions.none())

        /** @see listContributorNotes */
        @MustBeClosed
        fun listContributorNotes(
            params: CommunityNoteListContributorNotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse>

        /** @see listContributorNotes */
        @MustBeClosed
        fun listContributorNotes(
            params: CommunityNoteListContributorNotesParams
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse> =
            listContributorNotes(params, RequestOptions.none())

        /** @see listContributorNotes */
        @MustBeClosed
        fun listContributorNotes(
            alias: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityNoteListContributorNotesResponse> =
            listContributorNotes(
                alias,
                CommunityNoteListContributorNotesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /x/community-notes/contributors/{alias}`, but is
         * otherwise the same as [CommunityNoteService.retrieveContributor].
         */
        @MustBeClosed
        fun retrieveContributor(
            alias: String
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse> =
            retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none())

        /** @see retrieveContributor */
        @MustBeClosed
        fun retrieveContributor(
            alias: String,
            params: CommunityNoteRetrieveContributorParams =
                CommunityNoteRetrieveContributorParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse> =
            retrieveContributor(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see retrieveContributor */
        @MustBeClosed
        fun retrieveContributor(
            alias: String,
            params: CommunityNoteRetrieveContributorParams =
                CommunityNoteRetrieveContributorParams.none(),
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse> =
            retrieveContributor(alias, params, RequestOptions.none())

        /** @see retrieveContributor */
        @MustBeClosed
        fun retrieveContributor(
            params: CommunityNoteRetrieveContributorParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse>

        /** @see retrieveContributor */
        @MustBeClosed
        fun retrieveContributor(
            params: CommunityNoteRetrieveContributorParams
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse> =
            retrieveContributor(params, RequestOptions.none())

        /** @see retrieveContributor */
        @MustBeClosed
        fun retrieveContributor(
            alias: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityNoteRetrieveContributorResponse> =
            retrieveContributor(
                alias,
                CommunityNoteRetrieveContributorParams.none(),
                requestOptions,
            )
    }
}
