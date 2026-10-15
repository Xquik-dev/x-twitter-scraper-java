// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import org.junit.jupiter.api.Test

internal class CommunityNoteServiceTest {
    @Test
    fun listContributorDeletedNotes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteService = client.x().communityNotes()

        val response =
            communityNoteService.listContributorDeletedNotes(
                CommunityNoteListContributorDeletedNotesParams.builder()
                    .alias("alias")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun listContributorNotes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteService = client.x().communityNotes()

        val response =
            communityNoteService.listContributorNotes(
                CommunityNoteListContributorNotesParams.builder()
                    .alias("alias")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveContributor() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityNoteService = client.x().communityNotes()

        val response =
            communityNoteService.retrieveContributor(
                CommunityNoteRetrieveContributorParams.builder()
                    .alias("alias")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
