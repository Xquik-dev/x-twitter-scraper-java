// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetCheckRepostResponseTest {

    @Test
    fun create() {
        val tweetCheckRepostResponse =
            TweetCheckRepostResponse.builder()
                .checkedPosts(20L)
                .complete(false)
                .isRetweeted(true)
                .retweetedAt("2026-09-11T16:59:50.000Z")
                .retweetId("2098456494362460375")
                .tweetId("2098439298617856319")
                .userId("3065618342")
                .build()

        assertThat(tweetCheckRepostResponse.checkedPosts()).isEqualTo(20L)
        assertThat(tweetCheckRepostResponse.complete()).isEqualTo(false)
        assertThat(tweetCheckRepostResponse.isRetweeted()).isEqualTo(true)
        assertThat(tweetCheckRepostResponse.retweetedAt()).contains("2026-09-11T16:59:50.000Z")
        assertThat(tweetCheckRepostResponse.retweetId()).contains("2098456494362460375")
        assertThat(tweetCheckRepostResponse.tweetId()).isEqualTo("2098439298617856319")
        assertThat(tweetCheckRepostResponse.userId()).isEqualTo("3065618342")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetCheckRepostResponse =
            TweetCheckRepostResponse.builder()
                .checkedPosts(20L)
                .complete(false)
                .isRetweeted(true)
                .retweetedAt("2026-09-11T16:59:50.000Z")
                .retweetId("2098456494362460375")
                .tweetId("2098439298617856319")
                .userId("3065618342")
                .build()

        val roundtrippedTweetCheckRepostResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetCheckRepostResponse),
                jacksonTypeRef<TweetCheckRepostResponse>(),
            )

        assertThat(roundtrippedTweetCheckRepostResponse).isEqualTo(tweetCheckRepostResponse)
    }
}
