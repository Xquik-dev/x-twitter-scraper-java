// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveInfoResponseTest {

    @Test
    fun create() {
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(
                    CommunityRetrieveInfoResponse.Community.builder()
                        .id("1500000000000000000")
                        .bannerUrl("banner_url")
                        .createdAt("created_at")
                        .creator(
                            CommunityRetrieveInfoResponse.Community.Creator.builder()
                                .id("id")
                                .username("username")
                                .verified(true)
                                .name("name")
                                .build()
                        )
                        .description("description")
                        .invitesPolicy("invites_policy")
                        .isNsfw(true)
                        .joinPolicy("join_policy")
                        .memberCount(0L)
                        .moderatorCount(0L)
                        .name("Tesla Fans")
                        .primaryTopic(
                            CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .addRule(
                            CommunityRetrieveInfoResponse.Community.Rule.builder()
                                .id("id")
                                .description("description")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(communityRetrieveInfoResponse.community())
            .isEqualTo(
                CommunityRetrieveInfoResponse.Community.builder()
                    .id("1500000000000000000")
                    .bannerUrl("banner_url")
                    .createdAt("created_at")
                    .creator(
                        CommunityRetrieveInfoResponse.Community.Creator.builder()
                            .id("id")
                            .username("username")
                            .verified(true)
                            .name("name")
                            .build()
                    )
                    .description("description")
                    .invitesPolicy("invites_policy")
                    .isNsfw(true)
                    .joinPolicy("join_policy")
                    .memberCount(0L)
                    .moderatorCount(0L)
                    .name("Tesla Fans")
                    .primaryTopic(
                        CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                            .id("id")
                            .name("name")
                            .build()
                    )
                    .addRule(
                        CommunityRetrieveInfoResponse.Community.Rule.builder()
                            .id("id")
                            .description("description")
                            .name("name")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(
                    CommunityRetrieveInfoResponse.Community.builder()
                        .id("1500000000000000000")
                        .bannerUrl("banner_url")
                        .createdAt("created_at")
                        .creator(
                            CommunityRetrieveInfoResponse.Community.Creator.builder()
                                .id("id")
                                .username("username")
                                .verified(true)
                                .name("name")
                                .build()
                        )
                        .description("description")
                        .invitesPolicy("invites_policy")
                        .isNsfw(true)
                        .joinPolicy("join_policy")
                        .memberCount(0L)
                        .moderatorCount(0L)
                        .name("Tesla Fans")
                        .primaryTopic(
                            CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .addRule(
                            CommunityRetrieveInfoResponse.Community.Rule.builder()
                                .id("id")
                                .description("description")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedCommunityRetrieveInfoResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityRetrieveInfoResponse),
                jacksonTypeRef<CommunityRetrieveInfoResponse>(),
            )

        assertThat(roundtrippedCommunityRetrieveInfoResponse)
            .isEqualTo(communityRetrieveInfoResponse)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val communityRetrieveInfoResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "community": {
                        "id": "1493446837214187523",
                        "name": "Build in Public",
                        "member_count": 268126,
                        "is_nsfw": false,
                        "banner": {
                          "url": "https://pbs.twimg.com/community_banner_img/1915033378811772928/KdaKUaRP?format=png&name=orig",
                          "width": 805,
                          "height": 322,
                          "colors": [
                            {
                              "percentage": 42.48,
                              "red": 247,
                              "green": 228,
                              "blue": 29
                            },
                            {
                              "percentage": 42.48,
                              "red": 0,
                              "green": 0,
                              "blue": 1
                            },
                            {
                              "percentage": 9.57,
                              "red": 64,
                              "green": 58,
                              "blue": 13
                            },
                            {
                              "percentage": 4.43,
                              "red": 167,
                              "green": 154,
                              "blue": 27
                            },
                            {
                              "percentage": 0.75,
                              "red": 219,
                              "green": 219,
                              "blue": 219
                            }
                          ],
                          "focus": {
                            "left": 403,
                            "top": 161,
                            "width": 1,
                            "height": 1
                          }
                        },
                        "description": "Share what you're working on. Get feedback. Help each other move forward. – Sponsored by bolt.new ⚡",
                        "created_at": "1644900447551",
                        "join_policy": "Open",
                        "invites_policy": "MemberInvitesAllowed",
                        "banner_url": "https://pbs.twimg.com/community_banner_img/1915033378811772928/KdaKUaRP?format=png&name=orig",
                        "moderator_count": 6,
                        "primary_topic": {
                          "id": "603",
                          "name": "Entrepreneurship"
                        },
                        "question": "What are you working on?",
                        "rules": [
                          {
                            "description": "Don't be scared to share unfinished work",
                            "id": "1493447542045958144",
                            "name": "Share what you're working on"
                          },
                          {
                            "description": "Visual tweets tend to grab people's attention",
                            "id": "1493448150169755648",
                            "name": "Screenshots, screencasts, drafts, etc"
                          },
                          {
                            "description": "Don't ask for upvotes or advertise your products/services.",
                            "id": "1836095088465781029",
                            "name": "No self-promotion"
                          },
                          {
                            "description": "Only post about building in public. No politics or other off-topic posts. There are other communities for that.",
                            "id": "1836095194716066104",
                            "name": "Stay on-topic"
                          },
                          {
                            "description": "If your goal is to get replies, likes, etc, don't post it here. Don't ask super generic questions like \"what's everyone working on?\"",
                            "id": "1836095002557944207",
                            "name": "No engagement farming"
                          },
                          {
                            "description": "No company accounts. No logos. Use your own name. No promotion or URLs in your name.",
                            "id": "1836094745590059481",
                            "name": "Use a personal account"
                          }
                        ],
                        "searchTags": [
                          "buildinpublic",
                          "buildinginpublic",
                          "builtinpublic"
                        ],
                        "admin": {
                          "id": "641633",
                          "username": "marckohlbrugge",
                          "name": "Marc Köhlbrugge",
                          "followers": 89054,
                          "following": 973,
                          "verified": true,
                          "isBlueVerified": true,
                          "isVerified": true,
                          "profilePicture": "https://pbs.twimg.com/profile_images/1857124042433572864/iMivVaYP_normal.jpg",
                          "coverPicture": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                          "profileBannerUrl": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                          "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                          "createdAt": "Mon Jan 15 23:55:33 +0000 2007",
                          "statusesCount": 50114,
                          "mediaCount": 4890,
                          "protected": false,
                          "url": "https://wip.co/@marc",
                          "favouritesCount": 37854,
                          "possiblySensitive": false,
                          "pinnedTweetIds": [
                            "2105016385931989045"
                          ],
                          "verifiedType": "Blue",
                          "profile_bio": {
                            "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                            "entities": {
                              "description": {
                                "urls": [
                                  {
                                    "display_url": "wip.co",
                                    "expanded_url": "http://wip.co",
                                    "indices": [
                                      2,
                                      25
                                    ],
                                    "url": "https://t.co/aMZ4K3azU0"
                                  },
                                  {
                                    "display_url": "roomai.com",
                                    "expanded_url": "http://roomai.com",
                                    "indices": [
                                      28,
                                      51
                                    ],
                                    "url": "https://t.co/1KH3Ex4L2r"
                                  },
                                  {
                                    "display_url": "highscore.money",
                                    "expanded_url": "http://highscore.money",
                                    "indices": [
                                      54,
                                      77
                                    ],
                                    "url": "https://t.co/z2G662Uvhl"
                                  },
                                  {
                                    "display_url": "loot.photos",
                                    "expanded_url": "http://loot.photos",
                                    "indices": [
                                      80,
                                      103
                                    ],
                                    "url": "https://t.co/LtA0MMRVNA"
                                  },
                                  {
                                    "display_url": "betalist.com",
                                    "expanded_url": "http://betalist.com",
                                    "indices": [
                                      106,
                                      129
                                    ],
                                    "url": "https://t.co/sxmNUGTYQv"
                                  },
                                  {
                                    "display_url": "submit.co",
                                    "expanded_url": "http://submit.co",
                                    "indices": [
                                      132,
                                      155
                                    ],
                                    "url": "https://t.co/oPODwYE4Iq"
                                  },
                                  {
                                    "display_url": "startup.jobs",
                                    "expanded_url": "http://startup.jobs",
                                    "indices": [
                                      158,
                                      181
                                    ],
                                    "url": "https://t.co/leziY51tRd"
                                  },
                                  {
                                    "display_url": "yay.camera",
                                    "expanded_url": "http://yay.camera",
                                    "indices": [
                                      184,
                                      207
                                    ],
                                    "url": "https://t.co/NJnFBXCSCj"
                                  },
                                  {
                                    "display_url": "buildinpublic.com",
                                    "expanded_url": "http://buildinpublic.com",
                                    "indices": [
                                      212,
                                      235
                                    ],
                                    "url": "https://t.co/6qUnpK7VH5"
                                  }
                                ]
                              },
                              "url": {
                                "urls": [
                                  {
                                    "display_url": "wip.co/@marc",
                                    "expanded_url": "https://wip.co/@marc",
                                    "indices": [
                                      0,
                                      23
                                    ],
                                    "url": "https://t.co/QVn818Sinw"
                                  }
                                ]
                              }
                            }
                          },
                          "hasGraduatedAccess": true,
                          "professional": {
                            "category": [],
                            "professional_type": "Creator",
                            "rest_id": "1458256691506683904"
                          },
                          "profileDescriptionLanguage": "en",
                          "profileImageShape": "Circle",
                          "profileTranslatorType": "none",
                          "superFollowEligible": true
                        },
                        "creator": {
                          "id": "641633",
                          "username": "marckohlbrugge",
                          "name": "Marc Köhlbrugge",
                          "followers": 89054,
                          "following": 973,
                          "verified": true,
                          "isBlueVerified": true,
                          "isVerified": true,
                          "profilePicture": "https://pbs.twimg.com/profile_images/1857124042433572864/iMivVaYP_normal.jpg",
                          "coverPicture": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                          "profileBannerUrl": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                          "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                          "createdAt": "Mon Jan 15 23:55:33 +0000 2007",
                          "statusesCount": 50114,
                          "mediaCount": 4890,
                          "protected": false,
                          "url": "https://wip.co/@marc",
                          "favouritesCount": 37854,
                          "possiblySensitive": false,
                          "pinnedTweetIds": [
                            "2105016385931989045"
                          ],
                          "verifiedType": "Blue",
                          "profile_bio": {
                            "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                            "entities": {
                              "description": {
                                "urls": [
                                  {
                                    "display_url": "wip.co",
                                    "expanded_url": "http://wip.co",
                                    "indices": [
                                      2,
                                      25
                                    ],
                                    "url": "https://t.co/aMZ4K3azU0"
                                  },
                                  {
                                    "display_url": "roomai.com",
                                    "expanded_url": "http://roomai.com",
                                    "indices": [
                                      28,
                                      51
                                    ],
                                    "url": "https://t.co/1KH3Ex4L2r"
                                  },
                                  {
                                    "display_url": "highscore.money",
                                    "expanded_url": "http://highscore.money",
                                    "indices": [
                                      54,
                                      77
                                    ],
                                    "url": "https://t.co/z2G662Uvhl"
                                  },
                                  {
                                    "display_url": "loot.photos",
                                    "expanded_url": "http://loot.photos",
                                    "indices": [
                                      80,
                                      103
                                    ],
                                    "url": "https://t.co/LtA0MMRVNA"
                                  },
                                  {
                                    "display_url": "betalist.com",
                                    "expanded_url": "http://betalist.com",
                                    "indices": [
                                      106,
                                      129
                                    ],
                                    "url": "https://t.co/sxmNUGTYQv"
                                  },
                                  {
                                    "display_url": "submit.co",
                                    "expanded_url": "http://submit.co",
                                    "indices": [
                                      132,
                                      155
                                    ],
                                    "url": "https://t.co/oPODwYE4Iq"
                                  },
                                  {
                                    "display_url": "startup.jobs",
                                    "expanded_url": "http://startup.jobs",
                                    "indices": [
                                      158,
                                      181
                                    ],
                                    "url": "https://t.co/leziY51tRd"
                                  },
                                  {
                                    "display_url": "yay.camera",
                                    "expanded_url": "http://yay.camera",
                                    "indices": [
                                      184,
                                      207
                                    ],
                                    "url": "https://t.co/NJnFBXCSCj"
                                  },
                                  {
                                    "display_url": "buildinpublic.com",
                                    "expanded_url": "http://buildinpublic.com",
                                    "indices": [
                                      212,
                                      235
                                    ],
                                    "url": "https://t.co/6qUnpK7VH5"
                                  }
                                ]
                              },
                              "url": {
                                "urls": [
                                  {
                                    "display_url": "wip.co/@marc",
                                    "expanded_url": "https://wip.co/@marc",
                                    "indices": [
                                      0,
                                      23
                                    ],
                                    "url": "https://t.co/QVn818Sinw"
                                  }
                                ]
                              }
                            }
                          },
                          "hasGraduatedAccess": true,
                          "professional": {
                            "category": [],
                            "professional_type": "Creator",
                            "rest_id": "1458256691506683904"
                          },
                          "profileDescriptionLanguage": "en",
                          "profileImageShape": "Circle",
                          "profileTranslatorType": "none",
                          "superFollowEligible": true
                        },
                        "membersFacepile": [
                          {
                            "id": "641633",
                            "username": "marckohlbrugge",
                            "name": "Marc Köhlbrugge",
                            "followers": 89054,
                            "following": 973,
                            "verified": true,
                            "isBlueVerified": true,
                            "isVerified": true,
                            "profilePicture": "https://pbs.twimg.com/profile_images/1857124042433572864/iMivVaYP_normal.jpg",
                            "coverPicture": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                            "profileBannerUrl": "https://pbs.twimg.com/profile_banners/641633/1781378883",
                            "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                            "createdAt": "Mon Jan 15 23:55:33 +0000 2007",
                            "statusesCount": 50114,
                            "mediaCount": 4890,
                            "protected": false,
                            "url": "https://wip.co/@marc",
                            "favouritesCount": 37854,
                            "possiblySensitive": false,
                            "pinnedTweetIds": [
                              "2105016385931989045"
                            ],
                            "verifiedType": "Blue",
                            "profile_bio": {
                              "description": "🚧 https://t.co/aMZ4K3azU0 🏠 https://t.co/1KH3Ex4L2r 🤑 https://t.co/z2G662Uvhl 👀 https://t.co/LtA0MMRVNA 🚀 https://t.co/sxmNUGTYQv 📣 https://t.co/oPODwYE4Iq 💻 https://t.co/leziY51tRd 📸 https://t.co/NJnFBXCSCj #️⃣ https://t.co/6qUnpK7VH5",
                              "entities": {
                                "description": {
                                  "urls": [
                                    {
                                      "display_url": "wip.co",
                                      "expanded_url": "http://wip.co",
                                      "indices": [
                                        2,
                                        25
                                      ],
                                      "url": "https://t.co/aMZ4K3azU0"
                                    },
                                    {
                                      "display_url": "roomai.com",
                                      "expanded_url": "http://roomai.com",
                                      "indices": [
                                        28,
                                        51
                                      ],
                                      "url": "https://t.co/1KH3Ex4L2r"
                                    },
                                    {
                                      "display_url": "highscore.money",
                                      "expanded_url": "http://highscore.money",
                                      "indices": [
                                        54,
                                        77
                                      ],
                                      "url": "https://t.co/z2G662Uvhl"
                                    },
                                    {
                                      "display_url": "loot.photos",
                                      "expanded_url": "http://loot.photos",
                                      "indices": [
                                        80,
                                        103
                                      ],
                                      "url": "https://t.co/LtA0MMRVNA"
                                    },
                                    {
                                      "display_url": "betalist.com",
                                      "expanded_url": "http://betalist.com",
                                      "indices": [
                                        106,
                                        129
                                      ],
                                      "url": "https://t.co/sxmNUGTYQv"
                                    },
                                    {
                                      "display_url": "submit.co",
                                      "expanded_url": "http://submit.co",
                                      "indices": [
                                        132,
                                        155
                                      ],
                                      "url": "https://t.co/oPODwYE4Iq"
                                    },
                                    {
                                      "display_url": "startup.jobs",
                                      "expanded_url": "http://startup.jobs",
                                      "indices": [
                                        158,
                                        181
                                      ],
                                      "url": "https://t.co/leziY51tRd"
                                    },
                                    {
                                      "display_url": "yay.camera",
                                      "expanded_url": "http://yay.camera",
                                      "indices": [
                                        184,
                                        207
                                      ],
                                      "url": "https://t.co/NJnFBXCSCj"
                                    },
                                    {
                                      "display_url": "buildinpublic.com",
                                      "expanded_url": "http://buildinpublic.com",
                                      "indices": [
                                        212,
                                        235
                                      ],
                                      "url": "https://t.co/6qUnpK7VH5"
                                    }
                                  ]
                                },
                                "url": {
                                  "urls": [
                                    {
                                      "display_url": "wip.co/@marc",
                                      "expanded_url": "https://wip.co/@marc",
                                      "indices": [
                                        0,
                                        23
                                      ],
                                      "url": "https://t.co/QVn818Sinw"
                                    }
                                  ]
                                }
                              }
                            },
                            "hasGraduatedAccess": true,
                            "professional": {
                              "category": [],
                              "professional_type": "Creator",
                              "rest_id": "1458256691506683904"
                            },
                            "profileDescriptionLanguage": "en",
                            "profileImageShape": "Circle",
                            "profileTranslatorType": "none",
                            "superFollowEligible": true
                          }
                        ]
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<CommunityRetrieveInfoResponse>(),
                )

        communityRetrieveInfoResponse.validate()
        assertThat(communityRetrieveInfoResponse._additionalProperties()).isEmpty()
    }

    @Test
    fun additionalCommunityCreatorFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"description":"sample","followers":1,"following":1,"isBlueVerified":true,"isVerified":true,"profilePicture":"sample","profilePictureOriginal":"sample","coverPicture":"sample","profileBannerUrl":"sample","location":"sample","accountBasedIn":{},"accountBasedInUnavailable":true,"accountBasedInAccurate":true,"connectedVia":"sample","connectedViaAccurate":true,"affiliateUsername":"sample","email":"sample","contactInfo":{},"usernameChanges":{},"birthdate":{},"retweetedAt":"2025-01-15T12:00:00Z","createdAt":"sample","statusesCount":1,"mediaCount":1,"protected":true,"url":"sample","favouritesCount":1,"hasCustomTimelines":true,"isTranslator":true,"withheldInCountries":["sample"],"withheldScope":"sample","possiblySensitive":true,"professional":{},"grokTranslatedBio":{},"pinnedTweetIds":["sample"],"isAutomated":true,"automatedBy":"sample","unavailable":true,"unavailableReason":"sample","verifiedType":"sample","affiliatesHighlightedLabel":{},"businessAccountAffiliatesCount":1,"creatorSubscriptionsCount":1,"hasGraduatedAccess":true,"hasHiddenSubscriptionsOnProfile":true,"highlightsInfo":{},"identityVerification":{},"isProfileTranslatable":true,"parodyCommentaryFanLabel":"sample","profileDescriptionLanguage":"sample","profileImageShape":"sample","profileInterstitialType":"sample","profileSortEnabled":true,"profileTranslatorType":"sample","redirectsToUsername":"sample","superFollowEligible":true,"superFollowsUserProfileActive":true,"tipJar":{},"listedCount":1,"fastFollowersCount":1,"normalFollowersCount":1,"defaultProfile":true,"defaultProfileImage":true,"hasExtendedProfile":true,"isTranslationEnabled":true,"geoEnabled":true,"advertiserAccountType":"sample","advertiserAccountServiceLevels":["sample"],"businessProfileState":"sample","subscribersCount":1,"verificationReason":{},"communityRole":"sample","profile_bio":{}}"""
        val model =
            jsonMapper.readValue(
                json,
                jacksonTypeRef<CommunityRetrieveInfoResponse.Community.Creator>(),
            )

        assertThat(model.description()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("description")
        assertThat(model.followers()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("followers")
        assertThat(model.following()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("following")
        assertThat(model.isBlueVerified()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isBlueVerified")
        assertThat(model.isVerified()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isVerified")
        assertThat(model.profilePicture()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profilePicture")
        assertThat(model.profilePictureOriginal()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profilePictureOriginal")
        assertThat(model.coverPicture()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("coverPicture")
        assertThat(model.profileBannerUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileBannerUrl")
        assertThat(model.location()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("location")
        assertThat(model.accountBasedIn()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("accountBasedIn")
        assertThat(model.accountBasedInUnavailable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("accountBasedInUnavailable")
        assertThat(model.accountBasedInAccurate()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("accountBasedInAccurate")
        assertThat(model.connectedVia()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("connectedVia")
        assertThat(model.connectedViaAccurate()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("connectedViaAccurate")
        assertThat(model.affiliateUsername()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("affiliateUsername")
        assertThat(model.email()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("email")
        assertThat(model.contactInfo()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("contactInfo")
        assertThat(model.usernameChanges()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("usernameChanges")
        assertThat(model.birthdate()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("birthdate")
        assertThat(model.retweetedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("retweetedAt")
        assertThat(model.createdAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("createdAt")
        assertThat(model.statusesCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("statusesCount")
        assertThat(model.mediaCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("mediaCount")
        assertThat(model.protected_()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("protected")
        assertThat(model.url()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("url")
        assertThat(model.favouritesCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("favouritesCount")
        assertThat(model.hasCustomTimelines()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasCustomTimelines")
        assertThat(model.isTranslator()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isTranslator")
        assertThat(model.withheldInCountries()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("withheldInCountries")
        assertThat(model.withheldScope()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("withheldScope")
        assertThat(model.possiblySensitive()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("possiblySensitive")
        assertThat(model.professional()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("professional")
        assertThat(model.grokTranslatedBio()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("grokTranslatedBio")
        assertThat(model.pinnedTweetIds()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pinnedTweetIds")
        assertThat(model.isAutomated()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isAutomated")
        assertThat(model.automatedBy()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("automatedBy")
        assertThat(model.unavailable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("unavailable")
        assertThat(model.unavailableReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("unavailableReason")
        assertThat(model.verifiedType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("verifiedType")
        assertThat(model.affiliatesHighlightedLabel()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("affiliatesHighlightedLabel")
        assertThat(model.businessAccountAffiliatesCount()).isPresent()
        assertThat(model._additionalProperties())
            .doesNotContainKey("businessAccountAffiliatesCount")
        assertThat(model.creatorSubscriptionsCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("creatorSubscriptionsCount")
        assertThat(model.hasGraduatedAccess()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasGraduatedAccess")
        assertThat(model.hasHiddenSubscriptionsOnProfile()).isPresent()
        assertThat(model._additionalProperties())
            .doesNotContainKey("hasHiddenSubscriptionsOnProfile")
        assertThat(model.highlightsInfo()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("highlightsInfo")
        assertThat(model.identityVerification()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("identityVerification")
        assertThat(model.isProfileTranslatable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isProfileTranslatable")
        assertThat(model.parodyCommentaryFanLabel()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("parodyCommentaryFanLabel")
        assertThat(model.profileDescriptionLanguage()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileDescriptionLanguage")
        assertThat(model.profileImageShape()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileImageShape")
        assertThat(model.profileInterstitialType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileInterstitialType")
        assertThat(model.profileSortEnabled()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileSortEnabled")
        assertThat(model.profileTranslatorType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profileTranslatorType")
        assertThat(model.redirectsToUsername()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("redirectsToUsername")
        assertThat(model.superFollowEligible()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("superFollowEligible")
        assertThat(model.superFollowsUserProfileActive()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("superFollowsUserProfileActive")
        assertThat(model.tipJar()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tipJar")
        assertThat(model.listedCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("listedCount")
        assertThat(model.fastFollowersCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("fastFollowersCount")
        assertThat(model.normalFollowersCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("normalFollowersCount")
        assertThat(model.defaultProfile()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("defaultProfile")
        assertThat(model.defaultProfileImage()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("defaultProfileImage")
        assertThat(model.hasExtendedProfile()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasExtendedProfile")
        assertThat(model.isTranslationEnabled()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isTranslationEnabled")
        assertThat(model.geoEnabled()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("geoEnabled")
        assertThat(model.advertiserAccountType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("advertiserAccountType")
        assertThat(model.advertiserAccountServiceLevels()).isPresent()
        assertThat(model._additionalProperties())
            .doesNotContainKey("advertiserAccountServiceLevels")
        assertThat(model.businessProfileState()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("businessProfileState")
        assertThat(model.subscribersCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("subscribersCount")
        assertThat(model.verificationReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("verificationReason")
        assertThat(model.communityRole()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("communityRole")
        assertThat(model.profileBio()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("profile_bio")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<CommunityRetrieveInfoResponse.Community.Creator>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalCommunityFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"question":"sample","searchTags":["sample"],"admin":{},"membersFacepile":[{}],"banner":{}}"""
        val model =
            jsonMapper.readValue(json, jacksonTypeRef<CommunityRetrieveInfoResponse.Community>())

        assertThat(model.question()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("question")
        assertThat(model.searchTags()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("searchTags")
        assertThat(model.admin()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("admin")
        assertThat(model.membersFacepile()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("membersFacepile")
        assertThat(model.banner()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("banner")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<CommunityRetrieveInfoResponse.Community>(),
                )
            )
            .isEqualTo(model)
    }
}
