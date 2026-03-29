// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawRunParamsTest {

    @Test
    fun create() {
        DrawRunParams.builder()
            .tweetUrl("https://example.com")
            .backupCount(0L)
            .filterAccountAgeDays(0L)
            .filterLanguage("filterLanguage")
            .filterMinFollowers(0L)
            .mustFollowUsername("mustFollowUsername")
            .mustRetweet(true)
            .addRequiredHashtag("string")
            .addRequiredKeyword("string")
            .addRequiredMention("string")
            .uniqueAuthorsOnly(true)
            .winnerCount(0L)
            .build()
    }

    @Test
    fun body() {
        val params =
            DrawRunParams.builder()
                .tweetUrl("https://example.com")
                .backupCount(0L)
                .filterAccountAgeDays(0L)
                .filterLanguage("filterLanguage")
                .filterMinFollowers(0L)
                .mustFollowUsername("mustFollowUsername")
                .mustRetweet(true)
                .addRequiredHashtag("string")
                .addRequiredKeyword("string")
                .addRequiredMention("string")
                .uniqueAuthorsOnly(true)
                .winnerCount(0L)
                .build()

        val body = params._body()

        assertThat(body.tweetUrl()).isEqualTo("https://example.com")
        assertThat(body.backupCount()).contains(0L)
        assertThat(body.filterAccountAgeDays()).contains(0L)
        assertThat(body.filterLanguage()).contains("filterLanguage")
        assertThat(body.filterMinFollowers()).contains(0L)
        assertThat(body.mustFollowUsername()).contains("mustFollowUsername")
        assertThat(body.mustRetweet()).contains(true)
        assertThat(body.requiredHashtags().getOrNull()).containsExactly("string")
        assertThat(body.requiredKeywords().getOrNull()).containsExactly("string")
        assertThat(body.requiredMentions().getOrNull()).containsExactly("string")
        assertThat(body.uniqueAuthorsOnly()).contains(true)
        assertThat(body.winnerCount()).contains(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DrawRunParams.builder().tweetUrl("https://example.com").build()

        val body = params._body()

        assertThat(body.tweetUrl()).isEqualTo("https://example.com")
    }
}
