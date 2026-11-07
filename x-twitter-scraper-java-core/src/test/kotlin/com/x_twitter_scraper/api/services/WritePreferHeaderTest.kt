// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services

import com.github.tomakehurst.wiremock.client.WireMock.any
import com.github.tomakehurst.wiremock.client.WireMock.anyRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageParams
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkCreateParams
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteParams
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerParams
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateParams
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteCreateParams
import com.x_twitter_scraper.api.models.x.users.mute.MuteDeleteParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class WritePreferHeaderTest {

    private lateinit var client: XTwitterScraperClient

    private val writePaths =
        listOf(
            "/x/tweets",
            "/x/tweets/1",
            "/x/tweets/2/like",
            "/x/tweets/3/like",
            "/x/tweets/4/retweet",
            "/x/tweets/5/retweet",
            "/x/users/6/follow",
            "/x/users/7/follow",
            "/x/users/8/remove-follower",
            "/x/dm/9",
            "/x/dm/9/messages/10",
            "/x/media",
            "/x/profile",
            "/x/profile/avatar",
            "/x/profile/banner",
            "/x/communities",
            "/x/communities/11",
            "/x/communities/12/join",
            "/x/communities/13/join",
            "/x/tweets/14/bookmark",
            "/x/tweets/15/bookmark",
            "/x/users/16/block",
            "/x/users/17/block",
            "/x/users/18/mute",
            "/x/users/19/mute",
        )

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(any(anyUrl()).willReturn(okJson("{}")))
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun everyWriteSendsPreferAsAHeader() {
        sendEveryWrite("wait=50")

        for (path in writePaths) {
            verify(
                1,
                anyRequestedFor(urlPathEqualTo(path))
                    .withHeader("Prefer", equalTo("wait=50"))
                    .withHeader("Idempotency-Key", equalTo("write-key-1")),
            )
        }
    }

    @Test
    fun everyWriteOmitsPreferWhenUnset() {
        sendEveryWrite(null)

        for (path in writePaths) {
            verify(1, anyRequestedFor(urlPathEqualTo(path)).withoutHeader("Prefer"))
        }
    }

    @Test
    fun bookmarkBlockAndMuteUseTheirMethodAndSendOnlyTheAccountInTheBody() {
        sendEveryWrite("wait=50")

        val body = equalToJson("""{"account":"@xquik_test"}""")
        for (path in listOf("/x/tweets/14/bookmark", "/x/users/16/block", "/x/users/18/mute")) {
            verify(1, postRequestedFor(urlPathEqualTo(path)).withRequestBody(body))
        }
        for (path in listOf("/x/tweets/15/bookmark", "/x/users/17/block", "/x/users/19/mute")) {
            verify(1, deleteRequestedFor(urlPathEqualTo(path)).withRequestBody(body))
        }
    }

    private fun sendEveryWrite(prefer: String?) {
        val tweets = client.x().tweets()
        val likes = tweets.like()
        val retweets = tweets.retweet()
        val users = client.x().users()
        val follows = users.follow()
        val dms = client.x().dm()
        val media = client.x().media()
        val profile = client.x().profile()
        val communities = client.x().communities()
        val joins = communities.join()
        val bookmarks = tweets.bookmark()
        val blocks = users.block()
        val mutes = users.mute()

        tweets.create(
            TweetCreateParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .text("hi")
                .build()
        )
        tweets.delete(
            TweetDeleteParams.builder()
                .id("1")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        likes.create(
            LikeCreateParams.builder()
                .id("2")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        likes.delete(
            LikeDeleteParams.builder()
                .id("3")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        retweets.create(
            RetweetCreateParams.builder()
                .id("4")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        retweets.delete(
            RetweetDeleteParams.builder()
                .id("5")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        follows.create(
            FollowCreateParams.builder()
                .id("6")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        follows.deleteAll(
            FollowDeleteAllParams.builder()
                .id("7")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        users.removeFollower(
            UserRemoveFollowerParams.builder()
                .id("8")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        dms.send(
            DmSendParams.builder()
                .userId("9")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .text("hi")
                .build()
        )
        dms.deleteMessage(
            DmDeleteMessageParams.builder()
                .userId("9")
                .messageId("10")
                .account("@xquik_test")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .build()
        )
        media.upload(
            MediaUploadParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .url("https://example.com/a.png")
                .build()
        )
        profile.update(
            ProfileUpdateParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .name("Example")
                .build()
        )
        profile.updateAvatar(
            ProfileUpdateAvatarParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .url("https://example.com/a.png")
                .build()
        )
        profile.updateBanner(
            ProfileUpdateBannerParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .url("https://example.com/b.png")
                .build()
        )
        communities.create(
            CommunityCreateParams.builder()
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .name("Example")
                .build()
        )
        communities.delete(
            CommunityDeleteParams.builder()
                .id("11")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .communityName("Example")
                .build()
        )
        joins.create(
            JoinCreateParams.builder()
                .id("12")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        joins.deleteAll(
            JoinDeleteAllParams.builder()
                .id("13")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        bookmarks.create(
            BookmarkCreateParams.builder()
                .id("14")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        bookmarks.delete(
            BookmarkDeleteParams.builder()
                .id("15")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        blocks.create(
            BlockCreateParams.builder()
                .id("16")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        blocks.delete(
            BlockDeleteParams.builder()
                .id("17")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        mutes.create(
            MuteCreateParams.builder()
                .id("18")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
        mutes.delete(
            MuteDeleteParams.builder()
                .id("19")
                .idempotencyKey("write-key-1")
                .prefer(prefer)
                .account("@xquik_test")
                .build()
        )
    }
}
