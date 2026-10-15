// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorDeletedNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteListContributorNotesParams
import com.x_twitter_scraper.api.models.x.communitynotes.CommunityNoteRetrieveContributorParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class CommunityNoteServiceSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun listContributorDeletedNotesParsesTheSpecExample() {
        stubFor(
            get(
                    urlPathEqualTo(
                        "/x/community-notes/contributors/ardent-beach-friarbird/deleted-notes"
                    )
                )
                .willReturn(
                    okJson(
                        """
                        {
                          "notes": [
                            {
                              "id": "2078950499982696756",
                              "createdAt": "2026-07-19T21:09:58.885Z",
                              "ratingStatus": "CurrentlyRatedNotHelpful",
                              "notHelpfulTags": [
                                "MissingKeyPoints",
                                "Incorrect"
                              ],
                              "decidedBy": "CoreModel (v1.1)",
                              "fullyVisibleModel": true,
                              "abovePcrhThreshold": false,
                              "appealStatus": "NotAppealed",
                              "deleted": true,
                              "tombstone": "This note has been deleted",
                              "isApiAuthor": false,
                              "isMediaNote": false,
                              "mediaNoteMatchCount": 0,
                              "isUrlNote": false
                            }
                          ],
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            CommunityNoteListContributorDeletedNotesParams.builder()
                .alias("ardent-beach-friarbird")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communityNotes().listContributorDeletedNotes(params)
        val asyncResponse =
            asyncClient.x().communityNotes().listContributorDeletedNotes(params).get()

        verify(
            2,
            getRequestedFor(
                    urlPathEqualTo(
                        "/x/community-notes/contributors/ardent-beach-friarbird/deleted-notes"
                    )
                )
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.notes()).hasSize(1)
        assertThat(response.notes()[0].id()).isEqualTo("2078950499982696756")
        assertThat(response.notes()[0].abovePcrhThreshold()).contains(false)
        assertThat(response.notes()[0].appealStatus()).contains("NotAppealed")
        assertThat(response.notes()[0].createdAt())
            .contains(OffsetDateTime.parse("2026-07-19T21:09:58.885Z"))
        assertThat(response.notes()[0].decidedBy()).contains("CoreModel (v1.1)")
        assertThat(response.notes()[0].deleted()).contains(true)
        assertThat(response.notes()[0].fullyVisibleModel()).contains(true)
        assertThat(response.notes()[0].isApiAuthor()).contains(false)
        assertThat(response.notes()[0].isMediaNote()).contains(false)
        assertThat(response.notes()[0].isUrlNote()).contains(false)
        assertThat(response.notes()[0].mediaNoteMatchCount()).contains(0L)
        assertThat(response.notes()[0].notHelpfulTags().get())
            .containsExactly("MissingKeyPoints", "Incorrect")
        assertThat(response.notes()[0].ratingStatus()).contains("CurrentlyRatedNotHelpful")
        assertThat(response.notes()[0].tombstone()).contains("This note has been deleted")
        assertThat(response.notes()[0].classification()).isEmpty
        assertThat(response.notes()[0].contributor()).isEmpty
        assertThat(response.notes()[0].displayUrl()).isEmpty
        assertThat(response.notes()[0].entities()).isEmpty
        assertThat(response.notes()[0].helpfulTags()).isEmpty
        assertThat(response.notes()[0].impressionCount()).isEmpty
        assertThat(response.notes()[0].isTranslatable()).isEmpty
        assertThat(response.notes()[0].language()).isEmpty
        assertThat(response.notes()[0].post()).isEmpty
        assertThat(response.notes()[0].postId()).isEmpty
        assertThat(response.notes()[0].postUnavailable()).isEmpty
        assertThat(response.notes()[0].text()).isEmpty
        assertThat(response.notes()[0].timeToHelpfulFromNoteMs()).isEmpty
        assertThat(response.notes()[0].timeToHelpfulFromPostMs()).isEmpty
    }

    @Test
    fun listContributorNotesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/community-notes/contributors/ardent-beach-friarbird/notes"))
                .willReturn(
                    okJson(
                        """
                        {
                          "notes": [
                            {
                              "id": "2026375778254868976",
                              "createdAt": "2026-02-24T19:16:48.435Z",
                              "language": "en",
                              "classification": "MisinformedOrPotentiallyMisleading",
                              "contributor": {
                                "alias": "ardent-beach-friarbird",
                                "notesCount": {
                                  "currentlyRatedHelpful": 1,
                                  "currentlyRatedNotHelpful": 2
                                },
                                "ratingsCount": {
                                  "successful": {
                                    "total": 49
                                  },
                                  "unsuccessful": {
                                    "helpfulCount": 15,
                                    "notHelpfulCount": 4
                                  }
                                }
                              },
                              "text": "Since this is a wall of text article and the headline doesn't say, this quick-to-read context is necessary:\n\nDiscord is STILL rolling out Age Verification methods, just delayed to the second half of 2026 per the very own article in this post.\n\nhttps://discord.com/blog/getting-global-age-assurance-right-what-we-got-wrong-and-whats-changing",
                              "entities": [
                                {
                                  "fromIndex": 244,
                                  "toIndex": 340,
                                  "ref": {
                                    "type": "TimelineUrl",
                                    "url": "https://t.co/7fJbcLrO1k"
                                  }
                                }
                              ],
                              "ratingStatus": "CurrentlyRatedHelpful",
                              "helpfulTags": [
                                "ImportantContext",
                                "Clear"
                              ],
                              "decidedBy": "CoreModel (v1.1)",
                              "fullyVisibleModel": true,
                              "abovePcrhThreshold": false,
                              "appealStatus": "NotAppealed",
                              "deleted": false,
                              "isApiAuthor": false,
                              "isMediaNote": false,
                              "mediaNoteMatchCount": 0,
                              "isUrlNote": false,
                              "isTranslatable": false,
                              "timeToHelpfulFromNoteMs": 132890587,
                              "timeToHelpfulFromPostMs": 136815576,
                              "postId": "2026359315657805939",
                              "post": {
                                "id": "2026359315657805939",
                                "text": "Getting Global Age Assurance Right: What We Got Wrong and What’s Changing. \n\nRead the update: https://t.co/h7aRGmN7xW",
                                "createdAt": "Tue Feb 24 18:11:23 +0000 2026",
                                "retweetCount": 542,
                                "replyCount": 4197,
                                "likeCount": 3990,
                                "quoteCount": 1122,
                                "viewCount": 7038435,
                                "bookmarkCount": 1472,
                                "lang": "en",
                                "url": "https://x.com/discord/status/2026359315657805939",
                                "author": {
                                  "id": "3065618342",
                                  "username": "discord",
                                  "name": "Discord",
                                  "verifiedType": "Business"
                                }
                              }
                            }
                          ],
                          "has_next_page": true,
                          "next_cursor": "-1767098234260"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            CommunityNoteListContributorNotesParams.builder()
                .alias("ardent-beach-friarbird")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communityNotes().listContributorNotes(params)
        val asyncResponse = asyncClient.x().communityNotes().listContributorNotes(params).get()

        verify(
            2,
            getRequestedFor(
                    urlPathEqualTo("/x/community-notes/contributors/ardent-beach-friarbird/notes")
                )
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor()).isEqualTo("-1767098234260")
        assertThat(response.notes()).hasSize(1)
        assertThat(response.notes()[0].id()).isEqualTo("2026375778254868976")
        assertThat(response.notes()[0].abovePcrhThreshold()).contains(false)
        assertThat(response.notes()[0].appealStatus()).contains("NotAppealed")
        assertThat(response.notes()[0].classification())
            .contains("MisinformedOrPotentiallyMisleading")
        assertThat(response.notes()[0].contributor().get().alias())
            .isEqualTo("ardent-beach-friarbird")
        assertThat(
                response.notes()[0].contributor().get().notesCount().get().currentlyRatedHelpful()
            )
            .contains(1L)
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .notesCount()
                    .get()
                    .currentlyRatedNotHelpful()
            )
            .contains(2L)
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .successful()
                    .get()
                    .total()
            )
            .contains(49L)
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .unsuccessful()
                    .get()
                    .helpfulCount()
            )
            .contains(15L)
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .unsuccessful()
                    .get()
                    .notHelpfulCount()
            )
            .contains(4L)
        assertThat(response.notes()[0].createdAt())
            .contains(OffsetDateTime.parse("2026-02-24T19:16:48.435Z"))
        assertThat(response.notes()[0].decidedBy()).contains("CoreModel (v1.1)")
        assertThat(response.notes()[0].deleted()).contains(false)
        assertThat(response.notes()[0].entities().get()).hasSize(1)
        assertThat(response.notes()[0].entities().get()[0].fromIndex()).contains(244L)
        assertThat(response.notes()[0].entities().get()[0].ref().get().type())
            .contains("TimelineUrl")
        assertThat(response.notes()[0].entities().get()[0].ref().get().url())
            .contains("https://t.co/7fJbcLrO1k")
        assertThat(response.notes()[0].entities().get()[0].toIndex()).contains(340L)
        assertThat(response.notes()[0].fullyVisibleModel()).contains(true)
        assertThat(response.notes()[0].helpfulTags().get())
            .containsExactly("ImportantContext", "Clear")
        assertThat(response.notes()[0].isApiAuthor()).contains(false)
        assertThat(response.notes()[0].isMediaNote()).contains(false)
        assertThat(response.notes()[0].isTranslatable()).contains(false)
        assertThat(response.notes()[0].isUrlNote()).contains(false)
        assertThat(response.notes()[0].language()).contains("en")
        assertThat(response.notes()[0].mediaNoteMatchCount()).contains(0L)
        assertThat(response.notes()[0].post().get().id()).isEqualTo("2026359315657805939")
        assertThat(response.notes()[0].post().get().text())
            .isEqualTo(
                "Getting Global Age Assurance Right: What We Got Wrong and What’s Changing. \n\nRead the update: https://t.co/h7aRGmN7xW"
            )
        assertThat(response.notes()[0].postId()).contains("2026359315657805939")
        assertThat(response.notes()[0].ratingStatus()).contains("CurrentlyRatedHelpful")
        assertThat(response.notes()[0].text())
            .contains(
                "Since this is a wall of text article and the headline doesn't say, this quick-to-read context is necessary:\n\nDiscord is STILL rolling out Age Verification methods, just delayed to the second half of 2026 per the very own article in this post.\n\nhttps://discord.com/blog/getting-global-age-assurance-right-what-we-got-wrong-and-whats-changing"
            )
        assertThat(response.notes()[0].timeToHelpfulFromNoteMs()).contains(132890587L)
        assertThat(response.notes()[0].timeToHelpfulFromPostMs()).contains(136815576L)
        assertThat(response.notes()[0].contributor().get().deletedNotesCount()).isEmpty
        assertThat(response.notes()[0].contributor().get().isApiContributor()).isEmpty
        assertThat(response.notes()[0].contributor().get().isTopWriter()).isEmpty
        assertThat(response.notes()[0].contributor().get().notesCount().get().awaitingMoreRatings())
            .isEmpty
        assertThat(response.notes()[0].contributor().get().notesCount().get().updatedAt()).isEmpty
        assertThat(
                response.notes()[0].contributor().get().ratingsCount().get().awaitingMoreRatings()
            )
            .isEmpty
        assertThat(
                response.notes()[0].contributor().get().ratingsCount().get().ratedAfterDecision()
            )
            .isEmpty
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .successful()
                    .get()
                    .helpfulCount()
            )
            .isEmpty
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .successful()
                    .get()
                    .notHelpfulCount()
            )
            .isEmpty
        assertThat(
                response
                    .notes()[0]
                    .contributor()
                    .get()
                    .ratingsCount()
                    .get()
                    .unsuccessful()
                    .get()
                    .total()
            )
            .isEmpty
        assertThat(response.notes()[0].contributor().get().ratingsCount().get().updatedAt()).isEmpty
        assertThat(response.notes()[0].displayUrl()).isEmpty
        assertThat(response.notes()[0].entities().get()[0].ref().get().screenName()).isEmpty
        assertThat(response.notes()[0].entities().get()[0].ref().get().text()).isEmpty
        assertThat(response.notes()[0].entities().get()[0].ref().get().urlType()).isEmpty
        assertThat(response.notes()[0].impressionCount()).isEmpty
        assertThat(response.notes()[0].notHelpfulTags()).isEmpty
        assertThat(response.notes()[0].postUnavailable()).isEmpty
        assertThat(response.notes()[0].tombstone()).isEmpty
    }

    @Test
    fun retrieveContributorParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/community-notes/contributors/ardent-beach-friarbird"))
                .willReturn(
                    okJson(
                        """
                        {
                          "contributor": {
                            "alias": "ardent-beach-friarbird",
                            "deletedNotesCount": 0,
                            "isApiContributor": false,
                            "isTopWriter": false,
                            "notesCount": {
                              "awaitingMoreRatings": 18,
                              "currentlyRatedHelpful": 1,
                              "currentlyRatedNotHelpful": 2,
                              "updatedAt": "2026-10-12T22:18:40.096Z"
                            },
                            "ratingsCount": {
                              "awaitingMoreRatings": 703,
                              "ratedAfterDecision": 154,
                              "successful": {
                                "helpfulCount": 27,
                                "notHelpfulCount": 22,
                                "total": 49
                              },
                              "unsuccessful": {
                                "helpfulCount": 15,
                                "notHelpfulCount": 4
                              },
                              "updatedAt": "2026-10-12T22:50:13.228Z"
                            }
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            CommunityNoteRetrieveContributorParams.builder()
                .alias("ardent-beach-friarbird")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communityNotes().retrieveContributor(params)
        val asyncResponse = asyncClient.x().communityNotes().retrieveContributor(params).get()

        verify(
            2,
            getRequestedFor(
                    urlPathEqualTo("/x/community-notes/contributors/ardent-beach-friarbird")
                )
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.contributor().alias()).isEqualTo("ardent-beach-friarbird")
        assertThat(response.contributor().deletedNotesCount()).contains(0L)
        assertThat(response.contributor().isApiContributor()).contains(false)
        assertThat(response.contributor().isTopWriter()).contains(false)
        assertThat(response.contributor().notesCount().get().awaitingMoreRatings()).contains(18L)
        assertThat(response.contributor().notesCount().get().currentlyRatedHelpful()).contains(1L)
        assertThat(response.contributor().notesCount().get().currentlyRatedNotHelpful())
            .contains(2L)
        assertThat(response.contributor().notesCount().get().updatedAt())
            .contains(OffsetDateTime.parse("2026-10-12T22:18:40.096Z"))
        assertThat(response.contributor().ratingsCount().get().awaitingMoreRatings()).contains(703L)
        assertThat(response.contributor().ratingsCount().get().ratedAfterDecision()).contains(154L)
        assertThat(response.contributor().ratingsCount().get().successful().get().helpfulCount())
            .contains(27L)
        assertThat(response.contributor().ratingsCount().get().successful().get().notHelpfulCount())
            .contains(22L)
        assertThat(response.contributor().ratingsCount().get().successful().get().total())
            .contains(49L)
        assertThat(response.contributor().ratingsCount().get().unsuccessful().get().helpfulCount())
            .contains(15L)
        assertThat(
                response.contributor().ratingsCount().get().unsuccessful().get().notHelpfulCount()
            )
            .contains(4L)
        assertThat(response.contributor().ratingsCount().get().updatedAt())
            .contains(OffsetDateTime.parse("2026-10-12T22:50:13.228Z"))
        assertThat(response.contributor().ratingsCount().get().unsuccessful().get().total()).isEmpty
    }
}
