// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.x.sports.SportsGamePosts
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class EndReasonTest {

    private val tweetsPage = """{"has_next_page":false,"next_cursor":"","tweets":[]"""
    private val usersPage = """{"has_next_page":false,"next_cursor":"","users":[]"""
    private val stalled = ""","endReason":"stalled"}"""

    private inline fun <reified T> read(json: String): T =
        jsonMapper().readValue(json, jacksonTypeRef<T>())

    private fun endReasons(ending: String): List<Optional<CoverageEndReason>> {
        val coverage =
            read<TweetSearchResponse.TweetSearchCoverageResponse>(
                """{"has_next_page":false,"next_cursor":"","tweets":[],"diagnostic":{}$ending"""
            )
        val replies = read<TweetGetRepliesResponse>(tweetsPage + ending)
        return listOf(
            read<PaginatedTweets>(tweetsPage + ending).endReason(),
            read<PaginatedUsers>(usersPage + ending).endReason(),
            read<SportsGamePosts>(
                    """{"query":null,"has_next_page":false,"next_cursor":"","tweets":[]$ending"""
                )
                .endReason(),
            replies.endReason(),
            replies.toPaginatedTweets().endReason(),
            coverage.endReason(),
            coverage.toPaginatedTweets().endReason(),
        )
    }

    @Test
    fun everyTweetsAndUsersPageSaysWhenXCutItShort() {
        assertThat(endReasons(stalled)).containsOnly(Optional.of(CoverageEndReason.STALLED))
    }

    @Test
    fun aPageXDidNotCutShortHasNoEndReason() {
        assertThat(endReasons("}")).containsOnly(Optional.empty())
    }

    @Test
    fun anEndReasonSurvivesTheBuilderAndJson() {
        val page =
            PaginatedUsers.builder()
                .hasNextPage(false)
                .nextCursor("")
                .users(listOf())
                .endReason(CoverageEndReason.STALLED)
                .build()

        assertThat(page.endReason()).contains(CoverageEndReason.STALLED)
        assertThat(page.validate()).isSameAs(page)
        assertThat(read<PaginatedUsers>(jsonMapper().writeValueAsString(page))).isEqualTo(page)
        assertThat(page.toString()).contains("endReason=stalled")
        assertThat(page.toBuilder().build()).isEqualTo(page)
    }

    @Test
    fun aNewEndReasonReadsAsUnknown() {
        val page = read<PaginatedTweets>("""$tweetsPage,"endReason":"throttled"}""")
        val reason = page.endReason().get()

        assertThat(reason.value()).isEqualTo(CoverageEndReason.Value._UNKNOWN)
        assertThat(reason.asString()).isEqualTo("throttled")
        assertThat(page.isValid()).isFalse()
        assertThatThrownBy { reason.known() }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(CoverageEndReason.of("stalled")).isEqualTo(CoverageEndReason.STALLED)
        assertThat(CoverageEndReason.STALLED.known()).isEqualTo(CoverageEndReason.Known.STALLED)
    }
}
