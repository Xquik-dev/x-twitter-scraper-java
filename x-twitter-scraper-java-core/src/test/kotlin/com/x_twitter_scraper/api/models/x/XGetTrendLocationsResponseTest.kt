// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendLocationsResponseTest {

    @Test
    fun create() {
        val xGetTrendLocationsResponse =
            XGetTrendLocationsResponse.builder()
                .count(1L)
                .addLocation(
                    XGetTrendLocationsResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Istanbul")
                        .parentWoeid(23424969L)
                        .placeType("Town")
                        .placeTypeCode(7L)
                        .url("http://where.yahooapis.com/v1/place/2344116")
                        .woeid(2344116L)
                        .build()
                )
                .total(1L)
                .message("Unknown placeType. Use country, town, worldwide or unknown.")
                .build()

        assertThat(xGetTrendLocationsResponse.count()).isEqualTo(1L)
        assertThat(xGetTrendLocationsResponse.locations())
            .containsExactly(
                XGetTrendLocationsResponse.Location.builder()
                    .country("Turkey")
                    .countryCode("TR")
                    .name("Istanbul")
                    .parentWoeid(23424969L)
                    .placeType("Town")
                    .placeTypeCode(7L)
                    .url("http://where.yahooapis.com/v1/place/2344116")
                    .woeid(2344116L)
                    .build()
            )
        assertThat(xGetTrendLocationsResponse.total()).isEqualTo(1L)
        assertThat(xGetTrendLocationsResponse.message())
            .contains("Unknown placeType. Use country, town, worldwide or unknown.")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetTrendLocationsResponse =
            XGetTrendLocationsResponse.builder()
                .count(1L)
                .addLocation(
                    XGetTrendLocationsResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Istanbul")
                        .parentWoeid(23424969L)
                        .placeType("Town")
                        .placeTypeCode(7L)
                        .url("http://where.yahooapis.com/v1/place/2344116")
                        .woeid(2344116L)
                        .build()
                )
                .total(1L)
                .message("Unknown placeType. Use country, town, worldwide or unknown.")
                .build()

        val roundtrippedXGetTrendLocationsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetTrendLocationsResponse),
                jacksonTypeRef<XGetTrendLocationsResponse>(),
            )

        assertThat(roundtrippedXGetTrendLocationsResponse).isEqualTo(xGetTrendLocationsResponse)
    }
}
