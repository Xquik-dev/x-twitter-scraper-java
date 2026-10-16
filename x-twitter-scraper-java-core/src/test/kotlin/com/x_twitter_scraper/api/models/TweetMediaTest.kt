// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetMediaTest {

    @Test
    fun create() {
        val tweetMedia =
            TweetMedia.builder()
                .mediaUrl("mediaUrl")
                .type(TweetMedia.Type.PHOTO)
                .url("url")
                .id("id")
                .allowDownload(true)
                .altText("altText")
                .addAspectRatio(0L)
                .availabilityStatus("availabilityStatus")
                .displayUrl("displayUrl")
                .durationMillis(0L)
                .expandedUrl("expandedUrl")
                .faceRects(
                    TweetMedia.FaceRects.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                        )
                        .build()
                )
                .addFocusRect(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
                .height(0L)
                .addIndex(0L)
                .mediaKey("mediaKey")
                .monetizable(true)
                .sizes(
                    TweetMedia.Sizes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                        )
                        .build()
                )
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .width(0L)
                .build()

        assertThat(tweetMedia.mediaUrl()).isEqualTo("mediaUrl")
        assertThat(tweetMedia.type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(tweetMedia.url()).isEqualTo("url")
        assertThat(tweetMedia.id()).contains("id")
        assertThat(tweetMedia.allowDownload()).contains(true)
        assertThat(tweetMedia.altText()).contains("altText")
        assertThat(tweetMedia.aspectRatio().getOrNull()).containsExactly(0L)
        assertThat(tweetMedia.availabilityStatus()).contains("availabilityStatus")
        assertThat(tweetMedia.displayUrl()).contains("displayUrl")
        assertThat(tweetMedia.durationMillis()).contains(0L)
        assertThat(tweetMedia.expandedUrl()).contains("expandedUrl")
        assertThat(tweetMedia.faceRects())
            .contains(
                TweetMedia.FaceRects.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                    )
                    .build()
            )
        assertThat(tweetMedia.focusRects().getOrNull())
            .containsExactly(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
        assertThat(tweetMedia.height()).contains(0L)
        assertThat(tweetMedia.indices().getOrNull()).containsExactly(0L)
        assertThat(tweetMedia.mediaKey()).contains("mediaKey")
        assertThat(tweetMedia.monetizable()).contains(true)
        assertThat(tweetMedia.sizes())
            .contains(
                TweetMedia.Sizes.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                    )
                    .build()
            )
        assertThat(tweetMedia.videoVariants().getOrNull())
            .containsExactly(
                TweetMedia.VideoVariant.builder()
                    .contentType("contentType")
                    .url("url")
                    .bitrate(0L)
                    .build()
            )
        assertThat(tweetMedia.width()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetMedia =
            TweetMedia.builder()
                .mediaUrl("mediaUrl")
                .type(TweetMedia.Type.PHOTO)
                .url("url")
                .id("id")
                .allowDownload(true)
                .altText("altText")
                .addAspectRatio(0L)
                .availabilityStatus("availabilityStatus")
                .displayUrl("displayUrl")
                .durationMillis(0L)
                .expandedUrl("expandedUrl")
                .faceRects(
                    TweetMedia.FaceRects.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                        )
                        .build()
                )
                .addFocusRect(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
                .height(0L)
                .addIndex(0L)
                .mediaKey("mediaKey")
                .monetizable(true)
                .sizes(
                    TweetMedia.Sizes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                        )
                        .build()
                )
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .width(0L)
                .build()

        val roundtrippedTweetMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetMedia),
                jacksonTypeRef<TweetMedia>(),
            )

        assertThat(roundtrippedTweetMedia).isEqualTo(tweetMedia)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val tweetMedia =
            jsonMapper()
                .readValue(
                    """
                    {
                      "mediaUrl": "mediaUrl-value",
                      "type": "photo",
                      "url": "url-value",
                      "adultContent": false,
                      "allowDownload": false,
                      "altText": "altText-value",
                      "aspectRatio": [
                        1251
                      ],
                      "availabilityReason": "Dmcaed",
                      "availabilityStatus": "Available",
                      "description": "description-value",
                      "displayUrl": "displayUrl-value",
                      "durationMillis": 1588,
                      "expandedUrl": "expandedUrl-value",
                      "embeddable": false,
                      "faceRects": {},
                      "focusRects": [
                        {
                          "x": 220,
                          "y": 221,
                          "w": 219,
                          "h": 204
                        }
                      ],
                      "grokImageAnnotation": {
                        "prompt": "prompt-value",
                        "upsampledPrompt": "upsampledPrompt-value"
                      },
                      "grokPostId": "grokPostId-value",
                      "graphicViolence": false,
                      "height": 733,
                      "id": "id-value",
                      "indices": [
                        835
                      ],
                      "mediaKey": "mediaKey-value",
                      "monetizable": true,
                      "otherSensitiveContent": false,
                      "sizes": {},
                      "sourceStatusId": "sourceStatusId-value",
                      "sourceUser": {
                        "id": "11348282",
                        "username": "NASA",
                        "name": "NASA",
                        "followers": 92376187,
                        "accountBasedIn": null,
                        "following": 115,
                        "verified": true,
                        "isBlueVerified": true,
                        "isVerified": true,
                        "profilePicture": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg",
                        "profilePictureOriginal": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg",
                        "coverPicture": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                        "profileBannerUrl": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                        "description": "Making the seemingly impossible, possible. ✨",
                        "location": "Pale Blue Dot",
                        "createdAt": "Wed Dec 19 20:20:32 +0000 2007",
                        "birthdate": {
                          "day": 1,
                          "month": 10,
                          "year": 1958
                        },
                        "statusesCount": 74336,
                        "mediaCount": 28160,
                        "protected": false,
                        "url": "http://www.nasa.gov/",
                        "contactInfo": {
                          "links": [
                            {
                              "url": "http://www.nasa.gov/",
                              "network": "website",
                              "source": "url"
                            }
                          ]
                        },
                        "favouritesCount": 17003,
                        "possiblySensitive": false,
                        "verifiedType": "Government",
                        "profile_bio": {
                          "description": "Making the seemingly impossible, possible. ✨",
                          "entities": {
                            "description": {},
                            "url": {
                              "urls": [
                                {
                                  "display_url": "nasa.gov",
                                  "expanded_url": "http://www.nasa.gov/",
                                  "indices": [
                                    0,
                                    23
                                  ],
                                  "url": "https://t.co/9NkQJKAnuU"
                                }
                              ]
                            }
                          }
                        },
                        "businessAccountAffiliatesCount": 85,
                        "creatorSubscriptionsCount": 0,
                        "hasGraduatedAccess": true,
                        "hasHiddenSubscriptionsOnProfile": false,
                        "highlightsInfo": {
                          "canHighlightTweets": true,
                          "highlightedTweets": "280"
                        },
                        "identityVerification": {
                          "isIdentityVerified": false,
                          "verifiedSinceMsec": "1249674830941"
                        },
                        "isProfileTranslatable": false,
                        "parodyCommentaryFanLabel": "None",
                        "profileDescriptionLanguage": "en",
                        "profileImageShape": "Square",
                        "profileSortEnabled": true,
                        "profileTranslatorType": "regular",
                        "superFollowEligible": false,
                        "verificationReason": {
                          "entities": [
                            {
                              "fromIndex": 91,
                              "toIndex": 101,
                              "url": "https://help.twitter.com/en/rules-and-policies/profile-labels",
                              "urlType": "ExternalUrl"
                            }
                          ],
                          "text": "This account is verified because it is a government or multilateral organization account.  Learn more"
                        }
                      },
                      "sourceUserId": "sourceUserId-value",
                      "tags": [
                        {
                          "name": "name-value",
                          "screen_name": "screen_name-value",
                          "type": "type-value",
                          "user_id": "user_id-value"
                        }
                      ],
                      "title": "title-value",
                      "videoVariants": [
                        {
                          "bitrate": 847,
                          "contentType": "contentType-value",
                          "url": "url-value"
                        }
                      ],
                      "watchNowUrl": "watchNowUrl-value",
                      "visitSiteUrl": "visitSiteUrl-value",
                      "width": 644
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetMedia>(),
                )

        tweetMedia.validate()
        assertThat(tweetMedia.mediaUrl()).isEqualTo("mediaUrl-value")
        assertThat(tweetMedia.type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(tweetMedia.url()).isEqualTo("url-value")
        assertThat(tweetMedia.adultContent()).contains(false)
        assertThat(tweetMedia.availabilityReason()).contains("Dmcaed")
        assertThat(tweetMedia.description()).contains("description-value")
        assertThat(tweetMedia.embeddable()).contains(false)
        assertThat(tweetMedia.graphicViolence()).contains(false)
        assertThat(tweetMedia.grokImageAnnotation().get().prompt()).contains("prompt-value")
        assertThat(tweetMedia.grokImageAnnotation().get().upsampledPrompt())
            .contains("upsampledPrompt-value")
        assertThat(tweetMedia.grokImageAnnotation().get()._additionalProperties()).isEmpty()
        assertThat(tweetMedia.grokPostId()).contains("grokPostId-value")
        assertThat(tweetMedia.id()).contains("id-value")
        assertThat(tweetMedia.allowDownload()).contains(false)
        assertThat(tweetMedia.altText()).contains("altText-value")
        assertThat(tweetMedia.aspectRatio().get()).containsExactly(1251L)
        assertThat(tweetMedia.availabilityStatus()).contains("Available")
        assertThat(tweetMedia.displayUrl()).contains("displayUrl-value")
        assertThat(tweetMedia.durationMillis()).contains(1588L)
        assertThat(tweetMedia.expandedUrl()).contains("expandedUrl-value")
        assertThat(tweetMedia.focusRects().get()).hasSize(1)
        assertThat(tweetMedia.focusRects().get()[0].h()).isEqualTo(204L)
        assertThat(tweetMedia.focusRects().get()[0].w()).isEqualTo(219L)
        assertThat(tweetMedia.focusRects().get()[0].x()).isEqualTo(220L)
        assertThat(tweetMedia.focusRects().get()[0].y()).isEqualTo(221L)
        assertThat(tweetMedia.focusRects().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetMedia.height()).contains(733L)
        assertThat(tweetMedia.indices().get()).containsExactly(835L)
        assertThat(tweetMedia.mediaKey()).contains("mediaKey-value")
        assertThat(tweetMedia.monetizable()).contains(true)
        assertThat(tweetMedia.otherSensitiveContent()).contains(false)
        assertThat(tweetMedia.sourceStatusId()).contains("sourceStatusId-value")
        assertThat(tweetMedia.sourceUser().get().id()).isEqualTo("11348282")
        assertThat(tweetMedia.sourceUser().get().name()).isEqualTo("NASA")
        assertThat(tweetMedia.sourceUser().get().username()).isEqualTo("NASA")
        assertThat(tweetMedia.sourceUserId()).contains("sourceUserId-value")
        assertThat(tweetMedia.tags().get()).hasSize(1)
        assertThat(tweetMedia.tags().get()[0].name()).contains("name-value")
        assertThat(tweetMedia.tags().get()[0].screenName()).contains("screen_name-value")
        assertThat(tweetMedia.tags().get()[0].type()).contains("type-value")
        assertThat(tweetMedia.tags().get()[0].userId()).contains("user_id-value")
        assertThat(tweetMedia.tags().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetMedia.title()).contains("title-value")
        assertThat(tweetMedia.videoVariants().get()).hasSize(1)
        assertThat(tweetMedia.videoVariants().get()[0].contentType()).isEqualTo("contentType-value")
        assertThat(tweetMedia.videoVariants().get()[0].url()).isEqualTo("url-value")
        assertThat(tweetMedia.videoVariants().get()[0].bitrate()).contains(847L)
        assertThat(tweetMedia.videoVariants().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetMedia.visitSiteUrl()).contains("visitSiteUrl-value")
        assertThat(tweetMedia.watchNowUrl()).contains("watchNowUrl-value")
        assertThat(tweetMedia.width()).contains(644L)
        assertThat(tweetMedia._additionalProperties()).isEmpty()
    }
}
