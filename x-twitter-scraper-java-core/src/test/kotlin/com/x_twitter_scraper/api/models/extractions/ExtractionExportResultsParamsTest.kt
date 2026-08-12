// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.x_twitter_scraper.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionExportResultsParamsTest {

    @Test
    fun create() {
        ExtractionExportResultsParams.builder()
            .id("id")
            .format(ExtractionExportResultsParams.Format.CSV)
            .hasDescription(true)
            .hasLocation(true)
            .hasMedia(true)
            .lang("lang")
            .maxFollowers(0L)
            .maxFollowing(0L)
            .maxPosts(0L)
            .minFollowers(0L)
            .minFollowing(0L)
            .minLikes(0L)
            .minPosts(0L)
            .minReplies(0L)
            .minRetweets(0L)
            .minViews(0L)
            .search("search")
            .sinceDate(LocalDate.parse("2019-12-27"))
            .untilDate(LocalDate.parse("2019-12-27"))
            .verified(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ExtractionExportResultsParams.builder()
                .id("id")
                .format(ExtractionExportResultsParams.Format.CSV)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ExtractionExportResultsParams.builder()
                .id("id")
                .format(ExtractionExportResultsParams.Format.CSV)
                .hasDescription(true)
                .hasLocation(true)
                .hasMedia(true)
                .lang("lang")
                .maxFollowers(0L)
                .maxFollowing(0L)
                .maxPosts(0L)
                .minFollowers(0L)
                .minFollowing(0L)
                .minLikes(0L)
                .minPosts(0L)
                .minReplies(0L)
                .minRetweets(0L)
                .minViews(0L)
                .search("search")
                .sinceDate(LocalDate.parse("2019-12-27"))
                .untilDate(LocalDate.parse("2019-12-27"))
                .verified(true)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("format", "csv")
                    .put("hasDescription", "true")
                    .put("hasLocation", "true")
                    .put("hasMedia", "true")
                    .put("lang", "lang")
                    .put("maxFollowers", "0")
                    .put("maxFollowing", "0")
                    .put("maxPosts", "0")
                    .put("minFollowers", "0")
                    .put("minFollowing", "0")
                    .put("minLikes", "0")
                    .put("minPosts", "0")
                    .put("minReplies", "0")
                    .put("minRetweets", "0")
                    .put("minViews", "0")
                    .put("search", "search")
                    .put("sinceDate", "2019-12-27")
                    .put("untilDate", "2019-12-27")
                    .put("verified", "true")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ExtractionExportResultsParams.builder()
                .id("id")
                .format(ExtractionExportResultsParams.Format.CSV)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "csv").build())
    }
}
