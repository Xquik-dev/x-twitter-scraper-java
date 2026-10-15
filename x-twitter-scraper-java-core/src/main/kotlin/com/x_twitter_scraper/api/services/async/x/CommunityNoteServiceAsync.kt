// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesResponse
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Community Notes contributors, their notes, ratings & deleted notes */
interface CommunityNoteServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityNoteServiceAsync

    /**
     * Returns the notes a contributor deleted, newest first. X keeps each note's ID, times, rating
     * & tags. A notice replaces its text & post. Each note costs 1 credit. A contributor who
     * deleted none returns an empty list, free.
     */
    fun listContributorDeletedNotes(
        alias: String
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
        listContributorDeletedNotes(alias, CommunityNoteListContributorDeletedNotesParams.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        params: CommunityNoteListContributorDeletedNotesParams =
            CommunityNoteListContributorDeletedNotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
        listContributorDeletedNotes(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        params: CommunityNoteListContributorDeletedNotesParams =
            CommunityNoteListContributorDeletedNotesParams.none(),
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
        listContributorDeletedNotes(alias, params, RequestOptions.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        params: CommunityNoteListContributorDeletedNotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse>

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        params: CommunityNoteListContributorDeletedNotesParams
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
        listContributorDeletedNotes(params, RequestOptions.none())

    /** @see listContributorDeletedNotes */
    fun listContributorDeletedNotes(
        alias: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteListContributorDeletedNotesResponse> =
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
    fun listContributorNotes(
        alias: String
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        listContributorNotes(alias, CommunityNoteListContributorNotesParams.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        params: CommunityNoteListContributorNotesParams =
            CommunityNoteListContributorNotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        listContributorNotes(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        params: CommunityNoteListContributorNotesParams =
            CommunityNoteListContributorNotesParams.none(),
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        listContributorNotes(alias, params, RequestOptions.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        params: CommunityNoteListContributorNotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteListContributorNotesResponse>

    /** @see listContributorNotes */
    fun listContributorNotes(
        params: CommunityNoteListContributorNotesParams
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        listContributorNotes(params, RequestOptions.none())

    /** @see listContributorNotes */
    fun listContributorNotes(
        alias: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteListContributorNotesResponse> =
        listContributorNotes(alias, CommunityNoteListContributorNotesParams.none(), requestOptions)

    /**
     * Returns 1 Community Notes contributor by the alias X gives them. Includes note counts by
     * rating, rating counts & the deleted notes count. Each lookup costs 1 credit.
     */
    fun retrieveContributor(
        alias: String
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        params: CommunityNoteRetrieveContributorParams =
            CommunityNoteRetrieveContributorParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        retrieveContributor(params.toBuilder().alias(alias).build(), requestOptions)

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        params: CommunityNoteRetrieveContributorParams =
            CommunityNoteRetrieveContributorParams.none(),
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        retrieveContributor(alias, params, RequestOptions.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        params: CommunityNoteRetrieveContributorParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse>

    /** @see retrieveContributor */
    fun retrieveContributor(
        params: CommunityNoteRetrieveContributorParams
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        retrieveContributor(params, RequestOptions.none())

    /** @see retrieveContributor */
    fun retrieveContributor(
        alias: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityNoteRetrieveContributorResponse> =
        retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none(), requestOptions)

    /**
     * A view of [CommunityNoteServiceAsync] that provides access to raw HTTP responses for each
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
        ): CommunityNoteServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /x/community-notes/contributors/{alias}/deleted-notes`, but is otherwise the same as
         * [CommunityNoteServiceAsync.listContributorDeletedNotes].
         */
        fun listContributorDeletedNotes(
            alias: String
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> =
            listContributorDeletedNotes(
                alias,
                CommunityNoteListContributorDeletedNotesParams.none(),
            )

        /** @see listContributorDeletedNotes */
        fun listContributorDeletedNotes(
            alias: String,
            params: CommunityNoteListContributorDeletedNotesParams =
                CommunityNoteListContributorDeletedNotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> =
            listContributorDeletedNotes(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see listContributorDeletedNotes */
        fun listContributorDeletedNotes(
            alias: String,
            params: CommunityNoteListContributorDeletedNotesParams =
                CommunityNoteListContributorDeletedNotesParams.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> =
            listContributorDeletedNotes(alias, params, RequestOptions.none())

        /** @see listContributorDeletedNotes */
        fun listContributorDeletedNotes(
            params: CommunityNoteListContributorDeletedNotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>>

        /** @see listContributorDeletedNotes */
        fun listContributorDeletedNotes(
            params: CommunityNoteListContributorDeletedNotesParams
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> =
            listContributorDeletedNotes(params, RequestOptions.none())

        /** @see listContributorDeletedNotes */
        fun listContributorDeletedNotes(
            alias: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorDeletedNotesResponse>> =
            listContributorDeletedNotes(
                alias,
                CommunityNoteListContributorDeletedNotesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /x/community-notes/contributors/{alias}/notes`, but
         * is otherwise the same as [CommunityNoteServiceAsync.listContributorNotes].
         */
        fun listContributorNotes(
            alias: String
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> =
            listContributorNotes(alias, CommunityNoteListContributorNotesParams.none())

        /** @see listContributorNotes */
        fun listContributorNotes(
            alias: String,
            params: CommunityNoteListContributorNotesParams =
                CommunityNoteListContributorNotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> =
            listContributorNotes(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see listContributorNotes */
        fun listContributorNotes(
            alias: String,
            params: CommunityNoteListContributorNotesParams =
                CommunityNoteListContributorNotesParams.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> =
            listContributorNotes(alias, params, RequestOptions.none())

        /** @see listContributorNotes */
        fun listContributorNotes(
            params: CommunityNoteListContributorNotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>>

        /** @see listContributorNotes */
        fun listContributorNotes(
            params: CommunityNoteListContributorNotesParams
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> =
            listContributorNotes(params, RequestOptions.none())

        /** @see listContributorNotes */
        fun listContributorNotes(
            alias: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteListContributorNotesResponse>> =
            listContributorNotes(
                alias,
                CommunityNoteListContributorNotesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /x/community-notes/contributors/{alias}`, but is
         * otherwise the same as [CommunityNoteServiceAsync.retrieveContributor].
         */
        fun retrieveContributor(
            alias: String
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> =
            retrieveContributor(alias, CommunityNoteRetrieveContributorParams.none())

        /** @see retrieveContributor */
        fun retrieveContributor(
            alias: String,
            params: CommunityNoteRetrieveContributorParams =
                CommunityNoteRetrieveContributorParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> =
            retrieveContributor(params.toBuilder().alias(alias).build(), requestOptions)

        /** @see retrieveContributor */
        fun retrieveContributor(
            alias: String,
            params: CommunityNoteRetrieveContributorParams =
                CommunityNoteRetrieveContributorParams.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> =
            retrieveContributor(alias, params, RequestOptions.none())

        /** @see retrieveContributor */
        fun retrieveContributor(
            params: CommunityNoteRetrieveContributorParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>>

        /** @see retrieveContributor */
        fun retrieveContributor(
            params: CommunityNoteRetrieveContributorParams
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> =
            retrieveContributor(params, RequestOptions.none())

        /** @see retrieveContributor */
        fun retrieveContributor(
            alias: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityNoteRetrieveContributorResponse>> =
            retrieveContributor(
                alias,
                CommunityNoteRetrieveContributorParams.none(),
                requestOptions,
            )
    }
}
