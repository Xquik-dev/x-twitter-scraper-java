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
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SpaceServiceSpecExampleTest {

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
    fun retrieveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/spaces/1234567890"))
                .willReturn(
                    okJson(
                        """
                        {
                          "space": {
                            "id": "1OGwblLjnQMKB",
                            "title": "Extending the Network to the Edge",
                            "state": "Ended",
                            "startedAt": "2026-03-11T17:00:26.227Z",
                            "endedAt": "2026-03-11T17:49:29.190Z",
                            "totalLiveListeners": 841,
                            "totalReplayWatched": 609,
                            "creator": {
                              "id": "951329744804392960",
                              "username": "solana",
                              "name": "Solana"
                            },
                            "admins": [
                              {
                                "id": "951329744804392960",
                                "username": "solana",
                                "name": "Solana"
                              }
                            ],
                            "speakers": [
                              {
                                "id": "9876543210",
                                "username": "elonmusk",
                                "name": "Solana",
                                "profilePicture": "https://pbs.twimg.com/profile_images/example_normal.jpg",
                                "profilePictureOriginal": "https://pbs.twimg.com/profile_images/example.jpg",
                                "isVerified": true,
                                "isBlueVerified": true,
                                "verifiedType": "Business",
                                "affiliatesHighlightedLabel": {
                                  "badgeUrl": "string",
                                  "description": "string",
                                  "longDescription": {},
                                  "url": "string",
                                  "urlType": "string",
                                  "userLabelDisplayType": "string",
                                  "userLabelType": "string"
                                },
                                "joinedAt": "2026-03-11T17:00:52.759Z",
                                "isMutedByAdmin": true,
                                "isMutedByGuest": true,
                                "periscopeUserId": "645158"
                              }
                            ],
                            "listeners": [
                              {
                                "id": "9876543210",
                                "username": "elonmusk",
                                "name": "Solana",
                                "profilePicture": "https://pbs.twimg.com/profile_images/example_normal.jpg",
                                "profilePictureOriginal": "https://pbs.twimg.com/profile_images/example.jpg",
                                "isVerified": true,
                                "isBlueVerified": true,
                                "verifiedType": "Business",
                                "affiliatesHighlightedLabel": {
                                  "badgeUrl": "string",
                                  "description": "string",
                                  "longDescription": {},
                                  "url": "string",
                                  "urlType": "string",
                                  "userLabelDisplayType": "string",
                                  "userLabelType": "string"
                                },
                                "joinedAt": "2026-03-11T17:00:52.759Z",
                                "isMutedByAdmin": true,
                                "isMutedByGuest": true,
                                "periscopeUserId": "645158"
                              }
                            ]
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            SpaceRetrieveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().spaces().retrieve(params)
        val asyncResponse = asyncClient.x().spaces().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/spaces/1234567890"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.space().admins()).hasSize(1)
        assertThat(response.space().admins()[0].id()).isEqualTo("951329744804392960")
        assertThat(response.space().admins()[0].name()).isEqualTo("Solana")
        assertThat(response.space().admins()[0].username()).isEqualTo("solana")
        assertThat(response.space().id()).isEqualTo("1OGwblLjnQMKB")
        assertThat(response.space().listeners()).hasSize(1)
        assertThat(response.space().listeners()[0].id()).isEqualTo("9876543210")
        assertThat(response.space().listeners()[0].name()).isEqualTo("Solana")
        assertThat(response.space().listeners()[0].username()).isEqualTo("elonmusk")
        assertThat(response.space().listeners()[0].affiliatesHighlightedLabel().get().badgeUrl())
            .contains("string")
        assertThat(response.space().listeners()[0].affiliatesHighlightedLabel().get().description())
            .contains("string")
        assertThat(response.space().listeners()[0].affiliatesHighlightedLabel().get().url())
            .contains("string")
        assertThat(response.space().listeners()[0].affiliatesHighlightedLabel().get().urlType())
            .contains("string")
        assertThat(
                response
                    .space()
                    .listeners()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelDisplayType()
            )
            .contains("string")
        assertThat(
                response.space().listeners()[0].affiliatesHighlightedLabel().get().userLabelType()
            )
            .contains("string")
        assertThat(response.space().listeners()[0].isBlueVerified()).contains(true)
        assertThat(response.space().listeners()[0].isMutedByAdmin()).contains(true)
        assertThat(response.space().listeners()[0].isMutedByGuest()).contains(true)
        assertThat(response.space().listeners()[0].isVerified()).contains(true)
        assertThat(response.space().listeners()[0].joinedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:52.759Z"))
        assertThat(response.space().listeners()[0].periscopeUserId()).contains("645158")
        assertThat(response.space().listeners()[0].profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(response.space().listeners()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.space().listeners()[0].verifiedType()).contains("Business")
        assertThat(response.space().speakers()).hasSize(1)
        assertThat(response.space().speakers()[0].id()).isEqualTo("9876543210")
        assertThat(response.space().speakers()[0].name()).isEqualTo("Solana")
        assertThat(response.space().speakers()[0].username()).isEqualTo("elonmusk")
        assertThat(response.space().speakers()[0].affiliatesHighlightedLabel().get().badgeUrl())
            .contains("string")
        assertThat(response.space().speakers()[0].affiliatesHighlightedLabel().get().description())
            .contains("string")
        assertThat(response.space().speakers()[0].affiliatesHighlightedLabel().get().url())
            .contains("string")
        assertThat(response.space().speakers()[0].affiliatesHighlightedLabel().get().urlType())
            .contains("string")
        assertThat(
                response
                    .space()
                    .speakers()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelDisplayType()
            )
            .contains("string")
        assertThat(
                response.space().speakers()[0].affiliatesHighlightedLabel().get().userLabelType()
            )
            .contains("string")
        assertThat(response.space().speakers()[0].isBlueVerified()).contains(true)
        assertThat(response.space().speakers()[0].isMutedByAdmin()).contains(true)
        assertThat(response.space().speakers()[0].isMutedByGuest()).contains(true)
        assertThat(response.space().speakers()[0].isVerified()).contains(true)
        assertThat(response.space().speakers()[0].joinedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:52.759Z"))
        assertThat(response.space().speakers()[0].periscopeUserId()).contains("645158")
        assertThat(response.space().speakers()[0].profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(response.space().speakers()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.space().speakers()[0].verifiedType()).contains("Business")
        assertThat(response.space().creator().get().id()).isEqualTo("951329744804392960")
        assertThat(response.space().creator().get().username()).isEqualTo("solana")
        assertThat(response.space().creator().get().name()).isEqualTo("Solana")
        assertThat(response.space().endedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:49:29.190Z"))
        assertThat(response.space().startedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:26.227Z"))
        assertThat(response.space().state()).contains("Ended")
        assertThat(response.space().title()).contains("Extending the Network to the Edge")
        assertThat(response.space().totalLiveListeners()).contains(841L)
        assertThat(response.space().totalReplayWatched()).contains(609L)
        assertThat(response.space().admins()[0].affiliatesHighlightedLabel()).isEmpty
        assertThat(response.space().admins()[0].isBlueVerified()).isEmpty
        assertThat(response.space().admins()[0].isMutedByAdmin()).isEmpty
        assertThat(response.space().admins()[0].isMutedByGuest()).isEmpty
        assertThat(response.space().admins()[0].isVerified()).isEmpty
        assertThat(response.space().admins()[0].joinedAt()).isEmpty
        assertThat(response.space().admins()[0].periscopeUserId()).isEmpty
        assertThat(response.space().admins()[0].profilePicture()).isEmpty
        assertThat(response.space().admins()[0].profilePictureOriginal()).isEmpty
        assertThat(response.space().admins()[0].verifiedType()).isEmpty
        assertThat(response.space().contentType()).isEmpty
        assertThat(response.space().conversationControls()).isEmpty
        assertThat(response.space().createdAt()).isEmpty
        assertThat(response.space().disallowJoin()).isEmpty
        assertThat(response.space().isAvailableForClipping()).isEmpty
        assertThat(response.space().isAvailableForReplay()).isEmpty
        assertThat(response.space().isEmployeeOnly()).isEmpty
        assertThat(response.space().isLocked()).isEmpty
        assertThat(response.space().maxAdminCapacity()).isEmpty
        assertThat(response.space().mediaKey()).isEmpty
        assertThat(response.space().mentionedUserIds()).isEmpty
        assertThat(response.space().noIncognito()).isEmpty
        assertThat(response.space().participantCount()).isEmpty
        assertThat(response.space().scheduledStart()).isEmpty
        assertThat(response.space().sharings()).isEmpty
        assertThat(response.space().tweet()).isEmpty
        assertThat(response.space().tweetId()).isEmpty
        assertThat(response.space().updatedAt()).isEmpty
    }

    @Test
    fun retrieveReplayParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/spaces/1234567890/replay"))
                .willReturn(
                    okJson(
                        """
                        {
                          "replay": {
                            "url": "https://prod-fastly-us-east-1.video.pscp.tv/Transcoding/v1/hls/example/audio-space/playlist.m3u8?type=replay",
                            "streamType": "HLS",
                            "status": "LIVE_PUBLIC"
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            SpaceRetrieveReplayParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().spaces().retrieveReplay(params)
        val asyncResponse = asyncClient.x().spaces().retrieveReplay(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/spaces/1234567890/replay"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.replay().url())
            .isEqualTo(
                "https://prod-fastly-us-east-1.video.pscp.tv/Transcoding/v1/hls/example/audio-space/playlist.m3u8?type=replay"
            )
        assertThat(response.replay().status()).contains("LIVE_PUBLIC")
        assertThat(response.replay().streamType()).contains("HLS")
    }

    @Test
    fun searchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/spaces/search"))
                .willReturn(
                    okJson(
                        """
                        {
                          "spaces": [
                            {
                              "id": "1OGwblLjnQMKB",
                              "title": "Extending the Network to the Edge",
                              "state": "Ended",
                              "startedAt": "2026-03-11T17:00:26.227Z",
                              "endedAt": "2026-03-11T17:49:29.190Z",
                              "totalLiveListeners": 841,
                              "totalReplayWatched": 609,
                              "admins": [
                                {
                                  "id": "951329744804392960",
                                  "username": "solana",
                                  "name": "Solana"
                                }
                              ],
                              "speakers": [
                                {
                                  "id": "9876543210",
                                  "username": "elonmusk",
                                  "name": "Solana",
                                  "profilePicture": "https://pbs.twimg.com/profile_images/example_normal.jpg",
                                  "profilePictureOriginal": "https://pbs.twimg.com/profile_images/example.jpg",
                                  "isVerified": true,
                                  "isBlueVerified": true,
                                  "verifiedType": "Business",
                                  "affiliatesHighlightedLabel": {
                                    "badgeUrl": "string",
                                    "description": "string",
                                    "longDescription": {},
                                    "url": "string",
                                    "urlType": "string",
                                    "userLabelDisplayType": "string",
                                    "userLabelType": "string"
                                  },
                                  "joinedAt": "2026-03-11T17:00:52.759Z",
                                  "isMutedByAdmin": true,
                                  "isMutedByGuest": true,
                                  "periscopeUserId": "645158"
                                }
                              ],
                              "listeners": [
                                {
                                  "id": "9876543210",
                                  "username": "elonmusk",
                                  "name": "Solana",
                                  "profilePicture": "https://pbs.twimg.com/profile_images/example_normal.jpg",
                                  "profilePictureOriginal": "https://pbs.twimg.com/profile_images/example.jpg",
                                  "isVerified": true,
                                  "isBlueVerified": true,
                                  "verifiedType": "Business",
                                  "affiliatesHighlightedLabel": {
                                    "badgeUrl": "string",
                                    "description": "string",
                                    "longDescription": {},
                                    "url": "string",
                                    "urlType": "string",
                                    "userLabelDisplayType": "string",
                                    "userLabelType": "string"
                                  },
                                  "joinedAt": "2026-03-11T17:00:52.759Z",
                                  "isMutedByAdmin": true,
                                  "isMutedByGuest": true,
                                  "periscopeUserId": "645158"
                                }
                              ]
                            }
                          ],
                          "has_next_page": true,
                          "next_cursor": "DAACCgACGRElMJcAAA"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            SpaceSearchParams.builder()
                .q("from:solana")
                .fields("id,text,author.username")
                .omit("entities,media")
                .queryType(SpaceSearchParams.QueryType.LATEST)
                .build()

        val response = client.x().spaces().search(params)
        val asyncResponse = asyncClient.x().spaces().search(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/spaces/search"))
                .withQueryParam("q", equalTo("from:solana"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("queryType", equalTo("Latest")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(response.spaces()).hasSize(1)
        assertThat(response.spaces()[0].admins()).hasSize(1)
        assertThat(response.spaces()[0].admins()[0].id()).isEqualTo("951329744804392960")
        assertThat(response.spaces()[0].admins()[0].name()).isEqualTo("Solana")
        assertThat(response.spaces()[0].admins()[0].username()).isEqualTo("solana")
        assertThat(response.spaces()[0].id()).isEqualTo("1OGwblLjnQMKB")
        assertThat(response.spaces()[0].listeners()).hasSize(1)
        assertThat(response.spaces()[0].listeners()[0].id()).isEqualTo("9876543210")
        assertThat(response.spaces()[0].listeners()[0].name()).isEqualTo("Solana")
        assertThat(response.spaces()[0].listeners()[0].username()).isEqualTo("elonmusk")
        assertThat(
                response.spaces()[0].listeners()[0].affiliatesHighlightedLabel().get().badgeUrl()
            )
            .contains("string")
        assertThat(
                response.spaces()[0].listeners()[0].affiliatesHighlightedLabel().get().description()
            )
            .contains("string")
        assertThat(response.spaces()[0].listeners()[0].affiliatesHighlightedLabel().get().url())
            .contains("string")
        assertThat(response.spaces()[0].listeners()[0].affiliatesHighlightedLabel().get().urlType())
            .contains("string")
        assertThat(
                response
                    .spaces()[0]
                    .listeners()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelDisplayType()
            )
            .contains("string")
        assertThat(
                response
                    .spaces()[0]
                    .listeners()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelType()
            )
            .contains("string")
        assertThat(response.spaces()[0].listeners()[0].isBlueVerified()).contains(true)
        assertThat(response.spaces()[0].listeners()[0].isMutedByAdmin()).contains(true)
        assertThat(response.spaces()[0].listeners()[0].isMutedByGuest()).contains(true)
        assertThat(response.spaces()[0].listeners()[0].isVerified()).contains(true)
        assertThat(response.spaces()[0].listeners()[0].joinedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:52.759Z"))
        assertThat(response.spaces()[0].listeners()[0].periscopeUserId()).contains("645158")
        assertThat(response.spaces()[0].listeners()[0].profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(response.spaces()[0].listeners()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.spaces()[0].listeners()[0].verifiedType()).contains("Business")
        assertThat(response.spaces()[0].speakers()).hasSize(1)
        assertThat(response.spaces()[0].speakers()[0].id()).isEqualTo("9876543210")
        assertThat(response.spaces()[0].speakers()[0].name()).isEqualTo("Solana")
        assertThat(response.spaces()[0].speakers()[0].username()).isEqualTo("elonmusk")
        assertThat(response.spaces()[0].speakers()[0].affiliatesHighlightedLabel().get().badgeUrl())
            .contains("string")
        assertThat(
                response.spaces()[0].speakers()[0].affiliatesHighlightedLabel().get().description()
            )
            .contains("string")
        assertThat(response.spaces()[0].speakers()[0].affiliatesHighlightedLabel().get().url())
            .contains("string")
        assertThat(response.spaces()[0].speakers()[0].affiliatesHighlightedLabel().get().urlType())
            .contains("string")
        assertThat(
                response
                    .spaces()[0]
                    .speakers()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelDisplayType()
            )
            .contains("string")
        assertThat(
                response
                    .spaces()[0]
                    .speakers()[0]
                    .affiliatesHighlightedLabel()
                    .get()
                    .userLabelType()
            )
            .contains("string")
        assertThat(response.spaces()[0].speakers()[0].isBlueVerified()).contains(true)
        assertThat(response.spaces()[0].speakers()[0].isMutedByAdmin()).contains(true)
        assertThat(response.spaces()[0].speakers()[0].isMutedByGuest()).contains(true)
        assertThat(response.spaces()[0].speakers()[0].isVerified()).contains(true)
        assertThat(response.spaces()[0].speakers()[0].joinedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:52.759Z"))
        assertThat(response.spaces()[0].speakers()[0].periscopeUserId()).contains("645158")
        assertThat(response.spaces()[0].speakers()[0].profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(response.spaces()[0].speakers()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.spaces()[0].speakers()[0].verifiedType()).contains("Business")
        assertThat(response.spaces()[0].endedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:49:29.190Z"))
        assertThat(response.spaces()[0].startedAt())
            .contains(OffsetDateTime.parse("2026-03-11T17:00:26.227Z"))
        assertThat(response.spaces()[0].state()).contains("Ended")
        assertThat(response.spaces()[0].title()).contains("Extending the Network to the Edge")
        assertThat(response.spaces()[0].totalLiveListeners()).contains(841L)
        assertThat(response.spaces()[0].totalReplayWatched()).contains(609L)
        assertThat(response.spaces()[0].admins()[0].affiliatesHighlightedLabel()).isEmpty
        assertThat(response.spaces()[0].admins()[0].isBlueVerified()).isEmpty
        assertThat(response.spaces()[0].admins()[0].isMutedByAdmin()).isEmpty
        assertThat(response.spaces()[0].admins()[0].isMutedByGuest()).isEmpty
        assertThat(response.spaces()[0].admins()[0].isVerified()).isEmpty
        assertThat(response.spaces()[0].admins()[0].joinedAt()).isEmpty
        assertThat(response.spaces()[0].admins()[0].periscopeUserId()).isEmpty
        assertThat(response.spaces()[0].admins()[0].profilePicture()).isEmpty
        assertThat(response.spaces()[0].admins()[0].profilePictureOriginal()).isEmpty
        assertThat(response.spaces()[0].admins()[0].verifiedType()).isEmpty
        assertThat(response.spaces()[0].contentType()).isEmpty
        assertThat(response.spaces()[0].conversationControls()).isEmpty
        assertThat(response.spaces()[0].createdAt()).isEmpty
        assertThat(response.spaces()[0].creator()).isEmpty
        assertThat(response.spaces()[0].disallowJoin()).isEmpty
        assertThat(response.spaces()[0].isAvailableForClipping()).isEmpty
        assertThat(response.spaces()[0].isAvailableForReplay()).isEmpty
        assertThat(response.spaces()[0].isEmployeeOnly()).isEmpty
        assertThat(response.spaces()[0].isLocked()).isEmpty
        assertThat(response.spaces()[0].maxAdminCapacity()).isEmpty
        assertThat(response.spaces()[0].mediaKey()).isEmpty
        assertThat(response.spaces()[0].mentionedUserIds()).isEmpty
        assertThat(response.spaces()[0].noIncognito()).isEmpty
        assertThat(response.spaces()[0].participantCount()).isEmpty
        assertThat(response.spaces()[0].scheduledStart()).isEmpty
        assertThat(response.spaces()[0].sharings()).isEmpty
        assertThat(response.spaces()[0].tweet()).isEmpty
        assertThat(response.spaces()[0].tweetId()).isEmpty
        assertThat(response.spaces()[0].updatedAt()).isEmpty
    }
}
