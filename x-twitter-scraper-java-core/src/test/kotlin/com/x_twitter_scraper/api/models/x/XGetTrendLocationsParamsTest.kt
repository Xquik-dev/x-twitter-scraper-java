// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendLocationsParamsTest {

    @Test
    fun create() {
        XGetTrendLocationsParams.builder()
            .country("country")
            .fields("id,text,author.username")
            .limit(1L)
            .omit("entities,media")
            .placeType(XGetTrendLocationsParams.PlaceType.COUNTRY)
            .q("q")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetTrendLocationsParams.builder()
                .country("country")
                .fields("id,text,author.username")
                .limit(1L)
                .omit("entities,media")
                .placeType(XGetTrendLocationsParams.PlaceType.COUNTRY)
                .q("q")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("country", "country")
                    .put("fields", "id,text,author.username")
                    .put("limit", "1")
                    .put("omit", "entities,media")
                    .put("placeType", "country")
                    .put("q", "q")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetTrendLocationsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun placeTypeSendsEachKnownValue() {
        val values =
            listOf(
                    XGetTrendLocationsParams.PlaceType.COUNTRY,
                    XGetTrendLocationsParams.PlaceType.TOWN,
                    XGetTrendLocationsParams.PlaceType.WORLDWIDE,
                    XGetTrendLocationsParams.PlaceType.UNKNOWN,
                )
                .map {
                    XGetTrendLocationsParams.builder()
                        .placeType(it)
                        .build()
                        ._queryParams()
                        .values("placeType")
                }

        assertThat(values)
            .containsExactly(
                listOf("country"),
                listOf("town"),
                listOf("worldwide"),
                listOf("unknown"),
            )
    }
}
