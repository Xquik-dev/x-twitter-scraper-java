// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetResolveLinksResponseTest {

    @Test
    fun create() {
        val tweetResolveLinksResponse =
            TweetResolveLinksResponse.builder()
                .addLink(
                    TweetResolveLinksResponse.Link.builder()
                        .url("https://t.co/Xe1nm2pkSX")
                        .resolvedUrl("https://go.nasa.gov/3VcvAQn")
                        .build()
                )
                .addUnprocessedUrl("unprocessedUrl")
                .build()

        assertThat(tweetResolveLinksResponse.links())
            .containsExactly(
                TweetResolveLinksResponse.Link.builder()
                    .url("https://t.co/Xe1nm2pkSX")
                    .resolvedUrl("https://go.nasa.gov/3VcvAQn")
                    .build()
            )
        assertThat(tweetResolveLinksResponse.unprocessedUrls()).containsExactly("unprocessedUrl")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetResolveLinksResponse =
            TweetResolveLinksResponse.builder()
                .addLink(
                    TweetResolveLinksResponse.Link.builder()
                        .url("https://t.co/Xe1nm2pkSX")
                        .resolvedUrl("https://go.nasa.gov/3VcvAQn")
                        .build()
                )
                .addUnprocessedUrl("unprocessedUrl")
                .build()

        val roundtrippedTweetResolveLinksResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetResolveLinksResponse),
                jacksonTypeRef<TweetResolveLinksResponse>(),
            )

        assertThat(roundtrippedTweetResolveLinksResponse).isEqualTo(tweetResolveLinksResponse)
    }
}
