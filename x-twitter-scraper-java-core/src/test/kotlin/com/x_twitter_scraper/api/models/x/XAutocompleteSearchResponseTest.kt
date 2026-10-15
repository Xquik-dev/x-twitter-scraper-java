// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XAutocompleteSearchResponseTest {

    @Test
    fun create() {
        val xAutocompleteSearchResponse =
            XAutocompleteSearchResponse.builder()
                .addCashtag(
                    XAutocompleteSearchResponse.Cashtag.builder()
                        .ticker("TSLA")
                        .chainLogoUrl(
                            "https://abs.twimg.com/finance/v1/crypto/robinhood/native.png"
                        )
                        .contractAddress("0x322f0929c4625ed5bad873c95208d54e1c003b2d")
                        .currency("USD")
                        .dailyChangePercent(4.6539)
                        .exchangeShortName("NASDAQ")
                        .logoUrl("https://abs.twimg.com/finance/v1/stock/TSLA.png")
                        .marketCap("1463662787286.778808593")
                        .name("Tesla Inc")
                        .price("370.589999999")
                        .smartTag("\$TSLA")
                        .build()
                )
                .count(2L)
                .addHashtag(
                    XAutocompleteSearchResponse.Hashtag.builder()
                        .hashtag("#nasuanimalkingdom")
                        .inline(false)
                        .score(600.0)
                        .addToken("#nasuanimalkingdom")
                        .build()
                )
                .query("nasa")
                .addTopic(
                    XAutocompleteSearchResponse.Topic.builder()
                        .topic("nasa")
                        .inline(false)
                        .score(0.0)
                        .addToken("token")
                        .build()
                )
                .addUser(
                    XAutocompleteSearchResponse.User.builder()
                        .id("11348282")
                        .name("NASA")
                        .username("NASA")
                        .addBadge(
                            XAutocompleteSearchResponse.User.Badge.builder()
                                .badgeType("BusinessLabel")
                                .badgeUrl(
                                    "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_bigger.jpg"
                                )
                                .description("NASA")
                                .build()
                        )
                        .inline(false)
                        .isBlueVerified(true)
                        .isPersonaMediaGenable(false)
                        .isVerified(false)
                        .location("Pale Blue Dot")
                        .profilePicture(
                            "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
                        )
                        .profilePictureOriginal(
                            "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg"
                        )
                        .protected_(false)
                        .score(0.0)
                        .addToken("token")
                        .verified(true)
                        .verifiedType("Government")
                        .build()
                )
                .build()

        assertThat(xAutocompleteSearchResponse.cashtags())
            .containsExactly(
                XAutocompleteSearchResponse.Cashtag.builder()
                    .ticker("TSLA")
                    .chainLogoUrl("https://abs.twimg.com/finance/v1/crypto/robinhood/native.png")
                    .contractAddress("0x322f0929c4625ed5bad873c95208d54e1c003b2d")
                    .currency("USD")
                    .dailyChangePercent(4.6539)
                    .exchangeShortName("NASDAQ")
                    .logoUrl("https://abs.twimg.com/finance/v1/stock/TSLA.png")
                    .marketCap("1463662787286.778808593")
                    .name("Tesla Inc")
                    .price("370.589999999")
                    .smartTag("\$TSLA")
                    .build()
            )
        assertThat(xAutocompleteSearchResponse.count()).isEqualTo(2L)
        assertThat(xAutocompleteSearchResponse.hashtags())
            .containsExactly(
                XAutocompleteSearchResponse.Hashtag.builder()
                    .hashtag("#nasuanimalkingdom")
                    .inline(false)
                    .score(600.0)
                    .addToken("#nasuanimalkingdom")
                    .build()
            )
        assertThat(xAutocompleteSearchResponse.query()).isEqualTo("nasa")
        assertThat(xAutocompleteSearchResponse.topics())
            .containsExactly(
                XAutocompleteSearchResponse.Topic.builder()
                    .topic("nasa")
                    .inline(false)
                    .score(0.0)
                    .addToken("token")
                    .build()
            )
        assertThat(xAutocompleteSearchResponse.users())
            .containsExactly(
                XAutocompleteSearchResponse.User.builder()
                    .id("11348282")
                    .name("NASA")
                    .username("NASA")
                    .addBadge(
                        XAutocompleteSearchResponse.User.Badge.builder()
                            .badgeType("BusinessLabel")
                            .badgeUrl(
                                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_bigger.jpg"
                            )
                            .description("NASA")
                            .build()
                    )
                    .inline(false)
                    .isBlueVerified(true)
                    .isPersonaMediaGenable(false)
                    .isVerified(false)
                    .location("Pale Blue Dot")
                    .profilePicture(
                        "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
                    )
                    .profilePictureOriginal(
                        "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg"
                    )
                    .protected_(false)
                    .score(0.0)
                    .addToken("token")
                    .verified(true)
                    .verifiedType("Government")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xAutocompleteSearchResponse =
            XAutocompleteSearchResponse.builder()
                .addCashtag(
                    XAutocompleteSearchResponse.Cashtag.builder()
                        .ticker("TSLA")
                        .chainLogoUrl(
                            "https://abs.twimg.com/finance/v1/crypto/robinhood/native.png"
                        )
                        .contractAddress("0x322f0929c4625ed5bad873c95208d54e1c003b2d")
                        .currency("USD")
                        .dailyChangePercent(4.6539)
                        .exchangeShortName("NASDAQ")
                        .logoUrl("https://abs.twimg.com/finance/v1/stock/TSLA.png")
                        .marketCap("1463662787286.778808593")
                        .name("Tesla Inc")
                        .price("370.589999999")
                        .smartTag("\$TSLA")
                        .build()
                )
                .count(2L)
                .addHashtag(
                    XAutocompleteSearchResponse.Hashtag.builder()
                        .hashtag("#nasuanimalkingdom")
                        .inline(false)
                        .score(600.0)
                        .addToken("#nasuanimalkingdom")
                        .build()
                )
                .query("nasa")
                .addTopic(
                    XAutocompleteSearchResponse.Topic.builder()
                        .topic("nasa")
                        .inline(false)
                        .score(0.0)
                        .addToken("token")
                        .build()
                )
                .addUser(
                    XAutocompleteSearchResponse.User.builder()
                        .id("11348282")
                        .name("NASA")
                        .username("NASA")
                        .addBadge(
                            XAutocompleteSearchResponse.User.Badge.builder()
                                .badgeType("BusinessLabel")
                                .badgeUrl(
                                    "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_bigger.jpg"
                                )
                                .description("NASA")
                                .build()
                        )
                        .inline(false)
                        .isBlueVerified(true)
                        .isPersonaMediaGenable(false)
                        .isVerified(false)
                        .location("Pale Blue Dot")
                        .profilePicture(
                            "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
                        )
                        .profilePictureOriginal(
                            "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg"
                        )
                        .protected_(false)
                        .score(0.0)
                        .addToken("token")
                        .verified(true)
                        .verifiedType("Government")
                        .build()
                )
                .build()

        val roundtrippedXAutocompleteSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xAutocompleteSearchResponse),
                jacksonTypeRef<XAutocompleteSearchResponse>(),
            )

        assertThat(roundtrippedXAutocompleteSearchResponse).isEqualTo(xAutocompleteSearchResponse)
    }
}
