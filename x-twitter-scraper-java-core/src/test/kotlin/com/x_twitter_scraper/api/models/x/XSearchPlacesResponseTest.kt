// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XSearchPlacesResponseTest {

    @Test
    fun create() {
        val xSearchPlacesResponse =
            XSearchPlacesResponse.builder()
                .count(1L)
                .addPlace(
                    XSearchPlacesResponse.Place.builder()
                        .attributes(
                            XSearchPlacesResponse.Place.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .boundingBox(
                            XSearchPlacesResponse.Place.BoundingBox.builder()
                                .addCoordinate(listOf(listOf(28.6321043)))
                                .type("Polygon")
                                .build()
                        )
                        .addCentroid(28.84318392941324)
                        .addContainedWithin(
                            XSearchPlacesResponse.Place.ContainedWithin.builder()
                                .attributes(
                                    XSearchPlacesResponse.Place.ContainedWithin.Attributes.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .boundingBox(
                                    XSearchPlacesResponse.Place.ContainedWithin.BoundingBox
                                        .builder()
                                        .addCoordinate(listOf(listOf(28.6321043)))
                                        .type("Polygon")
                                        .build()
                                )
                                .addCentroid(28.84318392941324)
                                .country("Turkey")
                                .countryCode("TR")
                                .fullName("İstanbul, Türkiye")
                                .id("5e02a0f0d91c76d2")
                                .name("İstanbul")
                                .placeType("city")
                                .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                                .build()
                        )
                        .country("Turkey")
                        .countryCode("TR")
                        .fullName("İstanbul, Türkiye")
                        .id("5e02a0f0d91c76d2")
                        .name("İstanbul")
                        .placeType("city")
                        .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                        .build()
                )
                .total(1L)
                .message("X found no place for that text. Try a city or country name.")
                .build()

        assertThat(xSearchPlacesResponse.count()).isEqualTo(1L)
        assertThat(xSearchPlacesResponse.places())
            .containsExactly(
                XSearchPlacesResponse.Place.builder()
                    .attributes(
                        XSearchPlacesResponse.Place.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .boundingBox(
                        XSearchPlacesResponse.Place.BoundingBox.builder()
                            .addCoordinate(listOf(listOf(28.6321043)))
                            .type("Polygon")
                            .build()
                    )
                    .addCentroid(28.84318392941324)
                    .addContainedWithin(
                        XSearchPlacesResponse.Place.ContainedWithin.builder()
                            .attributes(
                                XSearchPlacesResponse.Place.ContainedWithin.Attributes.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .boundingBox(
                                XSearchPlacesResponse.Place.ContainedWithin.BoundingBox.builder()
                                    .addCoordinate(listOf(listOf(28.6321043)))
                                    .type("Polygon")
                                    .build()
                            )
                            .addCentroid(28.84318392941324)
                            .country("Turkey")
                            .countryCode("TR")
                            .fullName("İstanbul, Türkiye")
                            .id("5e02a0f0d91c76d2")
                            .name("İstanbul")
                            .placeType("city")
                            .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                            .build()
                    )
                    .country("Turkey")
                    .countryCode("TR")
                    .fullName("İstanbul, Türkiye")
                    .id("5e02a0f0d91c76d2")
                    .name("İstanbul")
                    .placeType("city")
                    .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                    .build()
            )
        assertThat(xSearchPlacesResponse.total()).isEqualTo(1L)
        assertThat(xSearchPlacesResponse.message())
            .contains("X found no place for that text. Try a city or country name.")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xSearchPlacesResponse =
            XSearchPlacesResponse.builder()
                .count(1L)
                .addPlace(
                    XSearchPlacesResponse.Place.builder()
                        .attributes(
                            XSearchPlacesResponse.Place.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .boundingBox(
                            XSearchPlacesResponse.Place.BoundingBox.builder()
                                .addCoordinate(listOf(listOf(28.6321043)))
                                .type("Polygon")
                                .build()
                        )
                        .addCentroid(28.84318392941324)
                        .addContainedWithin(
                            XSearchPlacesResponse.Place.ContainedWithin.builder()
                                .attributes(
                                    XSearchPlacesResponse.Place.ContainedWithin.Attributes.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .boundingBox(
                                    XSearchPlacesResponse.Place.ContainedWithin.BoundingBox
                                        .builder()
                                        .addCoordinate(listOf(listOf(28.6321043)))
                                        .type("Polygon")
                                        .build()
                                )
                                .addCentroid(28.84318392941324)
                                .country("Turkey")
                                .countryCode("TR")
                                .fullName("İstanbul, Türkiye")
                                .id("5e02a0f0d91c76d2")
                                .name("İstanbul")
                                .placeType("city")
                                .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                                .build()
                        )
                        .country("Turkey")
                        .countryCode("TR")
                        .fullName("İstanbul, Türkiye")
                        .id("5e02a0f0d91c76d2")
                        .name("İstanbul")
                        .placeType("city")
                        .url("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
                        .build()
                )
                .total(1L)
                .message("X found no place for that text. Try a city or country name.")
                .build()

        val roundtrippedXSearchPlacesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xSearchPlacesResponse),
                jacksonTypeRef<XSearchPlacesResponse>(),
            )

        assertThat(roundtrippedXSearchPlacesResponse).isEqualTo(xSearchPlacesResponse)
    }
}
