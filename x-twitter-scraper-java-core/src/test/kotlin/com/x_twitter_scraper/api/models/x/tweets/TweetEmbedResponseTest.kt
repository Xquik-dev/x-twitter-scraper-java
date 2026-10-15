// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetEmbedResponseTest {

    @Test
    fun create() {
        val tweetEmbedResponse =
            TweetEmbedResponse.builder()
                .embed(
                    TweetEmbedResponse.Embed.builder()
                        .authorName("NASA")
                        .authorUrl("https://x.com/NASA")
                        .html("<blockquote class=\"twitter-tweet\">...</blockquote>")
                        .tweetId("2102882545427714266")
                        .url("https://x.com/NASA/status/2102882545427714266")
                        .height(1L)
                        .width(550L)
                        .build()
                )
                .build()

        assertThat(tweetEmbedResponse.embed())
            .isEqualTo(
                TweetEmbedResponse.Embed.builder()
                    .authorName("NASA")
                    .authorUrl("https://x.com/NASA")
                    .html("<blockquote class=\"twitter-tweet\">...</blockquote>")
                    .tweetId("2102882545427714266")
                    .url("https://x.com/NASA/status/2102882545427714266")
                    .height(1L)
                    .width(550L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetEmbedResponse =
            TweetEmbedResponse.builder()
                .embed(
                    TweetEmbedResponse.Embed.builder()
                        .authorName("NASA")
                        .authorUrl("https://x.com/NASA")
                        .html("<blockquote class=\"twitter-tweet\">...</blockquote>")
                        .tweetId("2102882545427714266")
                        .url("https://x.com/NASA/status/2102882545427714266")
                        .height(1L)
                        .width(550L)
                        .build()
                )
                .build()

        val roundtrippedTweetEmbedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetEmbedResponse),
                jacksonTypeRef<TweetEmbedResponse>(),
            )

        assertThat(roundtrippedTweetEmbedResponse).isEqualTo(tweetEmbedResponse)
    }
}
