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
import com.x_twitter_scraper.api.models.x.communities.CommunityFindParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListPopularParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsParams
import com.x_twitter_scraper.api.models.x.communities.CommunitySearchMembersParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class CommunityServiceSpecExampleTest {

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
    fun findParsesTheSpecExample() {
        stubFor(get(urlPathEqualTo("/x/communities/find")).willReturn(okJson(communityPageExample)))
        val params =
            CommunityFindParams.builder()
                .q("q")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communities().find(params)
        val asyncResponse = asyncClient.x().communities().find(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/find"))
                .withQueryParam("q", equalTo("q"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor()).isEqualTo("WzM1LjUxMjQ5N10=")
        assertThat(response.communities()).hasSize(1)
        assertThat(response.communities()[0].id()).isEqualTo("1472105760389668865")
        assertThat(response.communities()[0].name()).isEqualTo("Tech Twitter")
    }

    @Test
    fun listPopularParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/popular")).willReturn(okJson(communityPageExample))
        )
        val params =
            CommunityListPopularParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communities().listPopular(params)
        val asyncResponse = asyncClient.x().communities().listPopular(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/popular"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor()).isEqualTo("WzM1LjUxMjQ5N10=")
        assertThat(response.communities()).hasSize(1)
        assertThat(response.communities()[0].id()).isEqualTo("1472105760389668865")
        assertThat(response.communities()[0].name()).isEqualTo("Tech Twitter")
    }

    @Test
    fun listSuggestedParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/suggested"))
                .willReturn(
                    okJson(
                        """
                        {
                          "communities": [
                            {
                              "id": "1472105760389668865",
                              "name": "Tech Twitter",
                              "member_count": 121468,
                              "is_nsfw": false,
                              "primary_topic": {
                                "name": "Technology"
                              },
                              "banner_url": "https://pbs.twimg.com/community_banner_img/example.jpg",
                              "membersFacepile": [
                                {
                                  "id": "2864203879",
                                  "profilePicture": "https://pbs.twimg.com/profile_images/example.jpg"
                                }
                              ]
                            }
                          ],
                          "count": 1
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            CommunityListSuggestedParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communities().listSuggested(params)
        val asyncResponse = asyncClient.x().communities().listSuggested(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/suggested"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.communities()).hasSize(1)
        assertThat(response.communities()[0].id()).isEqualTo("1472105760389668865")
        assertThat(response.communities()[0].isNsfw()).isEqualTo(false)
        assertThat(response.communities()[0].memberCount()).isEqualTo(121468L)
        assertThat(response.communities()[0].name()).isEqualTo("Tech Twitter")
        assertThat(response.communities()[0].bannerUrl())
            .contains("https://pbs.twimg.com/community_banner_img/example.jpg")
        assertThat(response.communities()[0].membersFacepile().get()).hasSize(1)
        assertThat(response.communities()[0].membersFacepile().get()[0].isCommunityMemberPreview())
            .isTrue()
        assertThat(
                response.communities()[0].membersFacepile().get()[0].asCommunityMemberPreview().id()
            )
            .isEqualTo("2864203879")
        assertThat(
                response
                    .communities()[0]
                    .membersFacepile()
                    .get()[0]
                    .asCommunityMemberPreview()
                    .profilePicture()
            )
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.communities()[0].primaryTopic().get().name()).isEqualTo("Technology")
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.communities()[0].admin()).isEmpty
        assertThat(response.communities()[0].banner()).isEmpty
        assertThat(response.communities()[0].createdAt()).isEmpty
        assertThat(response.communities()[0].creator()).isEmpty
        assertThat(response.communities()[0].description()).isEmpty
        assertThat(response.communities()[0].invitesPolicy()).isEmpty
        assertThat(response.communities()[0].joinPolicy()).isEmpty
        assertThat(
                response
                    .communities()[0]
                    .membersFacepile()
                    .get()[0]
                    .asCommunityMemberPreview()
                    .profilePictureOriginal()
            )
            .isEmpty
        assertThat(response.communities()[0].moderatorCount()).isEmpty
        assertThat(response.communities()[0].primaryTopic().get().id()).isEmpty
        assertThat(response.communities()[0].question()).isEmpty
        assertThat(response.communities()[0].rules()).isEmpty
        assertThat(response.communities()[0].searchTags()).isEmpty
        assertThat(response.message()).isEmpty
    }

    @Test
    fun listTopicsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/topics"))
                .willReturn(
                    okJson(
                        """
                        {
                          "topics": [
                            {
                              "id": "301",
                              "name": "Technology",
                              "subtopics": [
                                {
                                  "id": "302",
                                  "name": "Artificial Intelligence"
                                },
                                {
                                  "id": "303",
                                  "name": "Software"
                                }
                              ]
                            }
                          ],
                          "count": 1
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            CommunityListTopicsParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communities().listTopics(params)
        val asyncResponse = asyncClient.x().communities().listTopics(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/topics"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.topics()).hasSize(1)
        assertThat(response.topics()[0].id()).isEqualTo("301")
        assertThat(response.topics()[0].name()).isEqualTo("Technology")
        assertThat(response.topics()[0].subtopics()).hasSize(2)
        assertThat(response.topics()[0].subtopics()[0].id()).isEqualTo("302")
        assertThat(response.topics()[0].subtopics()[0].name()).isEqualTo("Artificial Intelligence")
        assertThat(response.topics()[0].subtopics()[1].id()).isEqualTo("303")
        assertThat(response.topics()[0].subtopics()[1].name()).isEqualTo("Software")
        assertThat(response.message()).isEmpty
    }

    @Test
    fun searchMembersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/1500000000000000000/members/search"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            CommunitySearchMembersParams.builder()
                .id("1500000000000000000")
                .q("q")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().communities().searchMembers(params)
        val asyncResponse = asyncClient.x().communities().searchMembers(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/1500000000000000000/members/search"))
                .withQueryParam("q", equalTo("q"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(1)
        assertThat(response.users()[0].id()).isEqualTo("641633")
        assertThat(response.users()[0].username()).isEqualTo("marckohlbrugge")
    }

    companion object {

        private val communityPageExample =
            """
            {
              "communities": [
                {
                  "id": "1472105760389668865",
                  "name": "Tech Twitter",
                  "member_count": 121468,
                  "is_nsfw": false,
                  "primary_topic": {
                    "name": "Technology"
                  },
                  "banner_url": "https://pbs.twimg.com/community_banner_img/example.jpg",
                  "membersFacepile": [
                    {
                      "id": "2864203879",
                      "profilePicture": "https://pbs.twimg.com/profile_images/example.jpg"
                    }
                  ]
                }
              ],
              "has_next_page": true,
              "next_cursor": "WzM1LjUxMjQ5N10="
            }
            """
                .trimIndent()

        private val paginatedUsersExample =
            """
            {
              "users": [
                {
                  "id": "641633",
                  "username": "marckohlbrugge",
                  "name": "Marc Köhlbrugge",
                  "communityRole": "Admin",
                  "profilePicture": "https://pbs.twimg.com/profile_images/1857124042433572864/iMivVaYP_normal.jpg",
                  "isBlueVerified": true
                }
              ],
              "has_next_page": false,
              "next_cursor": ""
            }
            """
                .trimIndent()
    }
}
