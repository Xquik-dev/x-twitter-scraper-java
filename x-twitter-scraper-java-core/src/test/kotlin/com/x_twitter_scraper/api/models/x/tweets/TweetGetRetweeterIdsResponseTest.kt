// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetRetweeterIdsResponseTest {

    @Test
    fun create() {
        val tweetGetRetweeterIdsResponse =
            TweetGetRetweeterIdsResponse.builder()
                .hasNextPage(true)
                .addId("9876543210")
                .nextCursor("1878079982871151535")
                .build()

        assertThat(tweetGetRetweeterIdsResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetRetweeterIdsResponse.ids()).containsExactly("9876543210")
        assertThat(tweetGetRetweeterIdsResponse.nextCursor()).isEqualTo("1878079982871151535")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetGetRetweeterIdsResponse =
            TweetGetRetweeterIdsResponse.builder()
                .hasNextPage(true)
                .addId("9876543210")
                .nextCursor("1878079982871151535")
                .build()

        val roundtrippedTweetGetRetweeterIdsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetRetweeterIdsResponse),
                jacksonTypeRef<TweetGetRetweeterIdsResponse>(),
            )

        assertThat(roundtrippedTweetGetRetweeterIdsResponse).isEqualTo(tweetGetRetweeterIdsResponse)
    }
}
