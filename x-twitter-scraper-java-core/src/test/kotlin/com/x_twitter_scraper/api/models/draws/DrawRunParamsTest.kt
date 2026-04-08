// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawRunParamsTest {

    @Test
    fun create() {
        DrawRunParams.builder()
            .tweetUrl("https://x.com/elonmusk/status/1234567890")
            .backupCount(2L)
            .filterAccountAgeDays(30L)
            .filterLanguage("en")
            .filterMinFollowers(50L)
            .mustFollowUsername("elonmusk")
            .mustRetweet(true)
            .addRequiredHashtag("#giveaway")
            .addRequiredKeyword("entered")
            .addRequiredMention("@elonmusk")
            .uniqueAuthorsOnly(true)
            .winnerCount(3L)
            .build()
    }

    @Test
    fun body() {
        val params =
            DrawRunParams.builder()
                .tweetUrl("https://x.com/elonmusk/status/1234567890")
                .backupCount(2L)
                .filterAccountAgeDays(30L)
                .filterLanguage("en")
                .filterMinFollowers(50L)
                .mustFollowUsername("elonmusk")
                .mustRetweet(true)
                .addRequiredHashtag("#giveaway")
                .addRequiredKeyword("entered")
                .addRequiredMention("@elonmusk")
                .uniqueAuthorsOnly(true)
                .winnerCount(3L)
                .build()

        val body = params._body()

        assertThat(body.tweetUrl()).isEqualTo("https://x.com/elonmusk/status/1234567890")
        assertThat(body.backupCount()).contains(2L)
        assertThat(body.filterAccountAgeDays()).contains(30L)
        assertThat(body.filterLanguage()).contains("en")
        assertThat(body.filterMinFollowers()).contains(50L)
        assertThat(body.mustFollowUsername()).contains("elonmusk")
        assertThat(body.mustRetweet()).contains(true)
        assertThat(body.requiredHashtags().getOrNull()).containsExactly("#giveaway")
        assertThat(body.requiredKeywords().getOrNull()).containsExactly("entered")
        assertThat(body.requiredMentions().getOrNull()).containsExactly("@elonmusk")
        assertThat(body.uniqueAuthorsOnly()).contains(true)
        assertThat(body.winnerCount()).contains(3L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DrawRunParams.builder().tweetUrl("https://x.com/elonmusk/status/1234567890").build()

        val body = params._body()

        assertThat(body.tweetUrl()).isEqualTo("https://x.com/elonmusk/status/1234567890")
    }
}
