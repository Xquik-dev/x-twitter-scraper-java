// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import org.junit.jupiter.api.Test

internal class CommunityNoteServiceAsyncTest {
    @Test
    fun listContributorDeletedNotes() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteServiceAsync = client.x().communityNotes()

        val responseFuture =
            communityNoteServiceAsync.listContributorDeletedNotes(
                CommunityNoteListContributorDeletedNotesParams.builder()
                    .alias("alias")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun listContributorNotes() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteServiceAsync = client.x().communityNotes()

        val responseFuture =
            communityNoteServiceAsync.listContributorNotes(
                CommunityNoteListContributorNotesParams.builder()
                    .alias("alias")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveContributor() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteServiceAsync = client.x().communityNotes()

        val responseFuture =
            communityNoteServiceAsync.retrieveContributor(
                CommunityNoteRetrieveContributorParams.builder()
                    .alias("alias")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
