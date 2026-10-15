// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class AnalysisServiceSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun brandParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/brand"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisBrandParams.builder()
                .analysis(
                    AnalysisBrandParams.Analysis.builder()
                        .addTarget(
                            AnalysisBrandParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().brand(params)
        val asyncResponse = asyncClient.x().analysis().brand(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/brand"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisBrandResponse.Result.Analysis.ContextAvailability.Article.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE)
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED)
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(AnalysisBrandResponse.Result.Analysis.ContextAvailability.PostText.FULL)
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisBrandResponse.Result.Analysis.ContextAvailability.Quote.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisBrandResponse.Result.Analysis.ContextAvailability.Reply.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisBrandResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisBrandResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }

    @Test
    fun classifyParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/classify"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisClassifyParams.builder()
                .analysis(
                    AnalysisClassifyParams.Analysis.builder()
                        .addTarget(
                            AnalysisClassifyParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().classify(params)
        val asyncResponse = asyncClient.x().analysis().classify(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/classify"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisClassifyResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisClassifyResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisClassifyResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisClassifyResponse.Result.Analysis.ContextAvailability.Article.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(
                AnalysisClassifyResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(
                AnalysisClassifyResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(AnalysisClassifyResponse.Result.Analysis.ContextAvailability.PostText.FULL)
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisClassifyResponse.Result.Analysis.ContextAvailability.Quote.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisClassifyResponse.Result.Analysis.ContextAvailability.Reply.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisClassifyResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisClassifyResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }

    @Test
    fun marketSignalsParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/market-signals"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisMarketSignalsParams.builder()
                .analysis(
                    AnalysisMarketSignalsParams.Analysis.builder()
                        .addTarget(
                            AnalysisMarketSignalsParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().marketSignals(params)
        val asyncResponse = asyncClient.x().analysis().marketSignals(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/market-signals"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisMarketSignalsResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisMarketSignalsResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisMarketSignalsResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.Article
                    .NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.PostText.FULL
            )
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.Quote
                    .NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisMarketSignalsResponse.Result.Analysis.ContextAvailability.Reply
                    .NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisMarketSignalsResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisMarketSignalsResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }

    @Test
    fun newsParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/news"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisNewsParams.builder()
                .analysis(
                    AnalysisNewsParams.Analysis.builder()
                        .addTarget(
                            AnalysisNewsParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().news(params)
        val asyncResponse = asyncClient.x().analysis().news(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/news"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisNewsResponse.Result.Analysis.ContextAvailability.Article.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE)
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED)
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(AnalysisNewsResponse.Result.Analysis.ContextAvailability.PostText.FULL)
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisNewsResponse.Result.Analysis.ContextAvailability.Quote.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisNewsResponse.Result.Analysis.ContextAvailability.Reply.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisNewsResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisNewsResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }

    @Test
    fun sentimentParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/sentiment"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisSentimentParams.builder()
                .analysis(
                    AnalysisSentimentParams.Analysis.builder()
                        .addTarget(
                            AnalysisSentimentParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().sentiment(params)
        val asyncResponse = asyncClient.x().analysis().sentiment(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/sentiment"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisSentimentResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisSentimentResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisSentimentResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisSentimentResponse.Result.Analysis.ContextAvailability.Article.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(
                AnalysisSentimentResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(
                AnalysisSentimentResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(AnalysisSentimentResponse.Result.Analysis.ContextAvailability.PostText.FULL)
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisSentimentResponse.Result.Analysis.ContextAvailability.Quote.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisSentimentResponse.Result.Analysis.ContextAvailability.Reply.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisSentimentResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisSentimentResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }

    @Test
    fun viralScoreParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/x/analysis/viral-score"))
                .willReturn(
                    okJson(
                        """
                        {
                          "results": [
                            {
                              "tweet": {
                                "id": "1893456789012345678",
                                "text": "The new headphones sound great. The app keeps crashing.",
                                "retweetCount": 4,
                                "replyCount": 2,
                                "likeCount": 31,
                                "quoteCount": 0,
                                "viewCount": 2140,
                                "bookmarkCount": 1
                              },
                              "analysis": {
                                "status": "succeeded",
                                "answers": [
                                  {
                                    "questionId": "sentiment",
                                    "questionVersion": "sentiment:2",
                                    "type": "choice",
                                    "value": "mixed",
                                    "confidence": 0.88,
                                    "probabilities": {
                                      "positive": 0.06,
                                      "negative": 0.04,
                                      "mixed": 0.88,
                                      "neutral": 0.01,
                                      "unclear": 0.01
                                    }
                                  },
                                  {
                                    "questionId": "intensity",
                                    "questionVersion": "sentiment:2",
                                    "type": "score",
                                    "value": 1,
                                    "confidence": 0.81,
                                    "probabilities": {
                                      "0": 0.05,
                                      "1": 0.81,
                                      "2": 0.14
                                    },
                                    "levels": [
                                      "No attitude or a passing mention.",
                                      "A clear but measured attitude.",
                                      "An emphatic or emotional attitude with strong wording."
                                    ]
                                  },
                                  {
                                    "questionId": "sarcasm",
                                    "questionVersion": "sentiment:2",
                                    "type": "probability",
                                    "probability": 0.03
                                  }
                                ],
                                "questions": [
                                  {
                                    "id": "sentiment",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "intensity",
                                    "version": "sentiment:2"
                                  },
                                  {
                                    "id": "sarcasm",
                                    "version": "sentiment:2"
                                  }
                                ],
                                "contextBytes": 612,
                                "contextAvailability": {
                                  "quote": "not_applicable",
                                  "reply": "not_applicable",
                                  "author": "available",
                                  "media": "not_supplied",
                                  "article": "not_supplied",
                                  "postText": "full"
                                }
                              },
                              "answers": {
                                "sentiment": "mixed",
                                "intensity": 1,
                                "sarcasm": 0.03
                              },
                              "sourceDomains": [
                                "youtube.com"
                              ],
                              "cashtags": [
                                "${'$'}NVDA"
                              ],
                              "monitor": {
                                "configurationFingerprint": "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a",
                                "baselineDatasetId": null,
                                "status": "changed",
                                "changedQuestionIds": [
                                  "sentiment"
                                ],
                                "changes": [
                                  {
                                    "questionId": "sentiment",
                                    "previous": "positive",
                                    "current": "mixed"
                                  }
                                ]
                              }
                            }
                          ],
                          "unanalyzed": [
                            {
                              "id": "1893456789012345679",
                              "status": "skipped",
                              "reason": "post_unavailable"
                            }
                          ],
                          "analysisSummary": {
                            "schemaVersion": 1,
                            "rows": {
                              "analyzed": 1,
                              "failed": 0,
                              "skipped": 0
                            },
                            "engagement": 37,
                            "questions": {
                              "sentiment": {
                                "type": "choice",
                                "counts": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                },
                                "shares": {
                                  "positive": 0,
                                  "negative": 0,
                                  "mixed": 1,
                                  "neutral": 0,
                                  "unclear": 0
                                }
                              }
                            },
                            "targets": [
                              {
                                "name": "Sony",
                                "mentions": 14,
                                "share": 0.7,
                                "engagement": 1200,
                                "choices": {
                                  "sentiment": {
                                    "positive": 9,
                                    "negative": 5
                                  }
                                },
                                "top": {
                                  "sentiment": {
                                    "negative": [
                                      {
                                        "tweetId": "1893456789012345678",
                                        "engagement": 412
                                      }
                                    ]
                                  }
                                }
                              }
                            ],
                            "cashtags": [
                              {
                                "cashtag": "${'$'}NVDA",
                                "rows": 3,
                                "choices": {
                                  "stance": {
                                    "bullish": 2,
                                    "bearish": 1
                                  }
                                },
                                "signal": {
                                  "bullish": 2,
                                  "bearish": 1,
                                  "score": 0.3333
                                }
                              }
                            ],
                            "sourceDomains": [
                              {
                                "domain": "youtube.com",
                                "posts": 4
                              }
                            ],
                            "monitor": {
                              "statuses": {
                                "changed": 1
                              },
                              "changedRows": [
                                {
                                  "tweetId": "1893456789012345678",
                                  "changes": [
                                    {
                                      "questionId": "sentiment",
                                      "previous": "positive",
                                      "current": "mixed"
                                    }
                                  ]
                                }
                              ]
                            }
                          },
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            AnalysisViralScoreParams.builder()
                .analysis(
                    AnalysisViralScoreParams.Analysis.builder()
                        .addTarget(
                            AnalysisViralScoreParams.Analysis.Target.builder()
                                .name("Sony")
                                .addAlias("WH-1000XM6")
                                .build()
                        )
                        .build()
                )
                .limit(20L)
                .query("Sony WH-1000XM6 lang:en")
                .build()

        val response = client.x().analysis().viralScore(params)
        val asyncResponse = asyncClient.x().analysis().viralScore(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/x/analysis/viral-score"))
                .withRequestBody(
                    equalToJson(
                        "{\"analysis\": {\"targets\": [{\"name\": \"Sony\", \"aliases\": [\"WH-1000XM6\"]}]}, \"limit\": 20, \"query\": \"Sony WH-1000XM6 lang:en\"}"
                    )
                ),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.analysisSummary().cashtags()).hasSize(1)
        assertThat(response.analysisSummary().cashtags()[0].cashtag()).isEqualTo("\$NVDA")
        assertThat(response.analysisSummary().cashtags()[0].rows()).isEqualTo(3L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bearish()).isEqualTo(1L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().bullish()).isEqualTo(2L)
        assertThat(response.analysisSummary().cashtags()[0].signal().get().score())
            .isEqualTo(0.3333)
        assertThat(response.analysisSummary().engagement()).isEqualTo(37L)
        assertThat(response.analysisSummary().monitor().get().changedRows()).hasSize(1)
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].changes()).hasSize(1)
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].current()
            )
            .isEqualTo("mixed")
        assertThat(
                response.analysisSummary().monitor().get().changedRows()[0].changes()[0].previous()
            )
            .isEqualTo("positive")
        assertThat(
                response
                    .analysisSummary()
                    .monitor()
                    .get()
                    .changedRows()[0]
                    .changes()[0]
                    .questionId()
            )
            .isEqualTo("sentiment")
        assertThat(response.analysisSummary().monitor().get().changedRows()[0].tweetId())
            .isEqualTo("1893456789012345678")
        assertThat(response.analysisSummary().rows().analyzed()).isEqualTo(1L)
        assertThat(response.analysisSummary().rows().failed()).isEqualTo(0L)
        assertThat(response.analysisSummary().rows().skipped()).isEqualTo(0L)
        assertThat(response.analysisSummary().schemaVersion()).isEqualTo(1L)
        assertThat(response.analysisSummary().sourceDomains()).hasSize(1)
        assertThat(response.analysisSummary().sourceDomains()[0].domain()).isEqualTo("youtube.com")
        assertThat(response.analysisSummary().sourceDomains()[0].posts()).isEqualTo(4L)
        assertThat(response.analysisSummary().targets()).hasSize(1)
        assertThat(response.analysisSummary().targets()[0].engagement()).isEqualTo(1200L)
        assertThat(response.analysisSummary().targets()[0].mentions()).isEqualTo(14L)
        assertThat(response.analysisSummary().targets()[0].name()).isEqualTo("Sony")
        assertThat(response.analysisSummary().targets()[0].share()).isEqualTo(0.7)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.results()).hasSize(1)
        assertThat(response.results()[0].analysis().answers()).hasSize(3)
        assertThat(response.results()[0].analysis().answers()[0].questionId())
            .isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().answers()[0].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[0].type())
            .isEqualTo(AnalysisViralScoreResponse.Result.Analysis.Answer.Type.CHOICE)
        assertThat(response.results()[0].analysis().answers()[0].confidence()).contains(0.88)
        assertThat(response.results()[0].analysis().answers()[1].questionId())
            .isEqualTo("intensity")
        assertThat(response.results()[0].analysis().answers()[1].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[1].type())
            .isEqualTo(AnalysisViralScoreResponse.Result.Analysis.Answer.Type.SCORE)
        assertThat(response.results()[0].analysis().answers()[1].confidence()).contains(0.81)
        assertThat(response.results()[0].analysis().answers()[1].levels().get())
            .containsExactly(
                "No attitude or a passing mention.",
                "A clear but measured attitude.",
                "An emphatic or emotional attitude with strong wording.",
            )
        assertThat(response.results()[0].analysis().answers()[2].questionId()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().answers()[2].questionVersion())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().answers()[2].type())
            .isEqualTo(AnalysisViralScoreResponse.Result.Analysis.Answer.Type.PROBABILITY)
        assertThat(response.results()[0].analysis().answers()[2].probability()).contains(0.03)
        assertThat(response.results()[0].analysis().contextAvailability().article())
            .isEqualTo(
                AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.Article.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().author())
            .isEqualTo(
                AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.Author.AVAILABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().media())
            .isEqualTo(
                AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.Media.NOT_SUPPLIED
            )
        assertThat(response.results()[0].analysis().contextAvailability().postText())
            .isEqualTo(AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.PostText.FULL)
        assertThat(response.results()[0].analysis().contextAvailability().quote())
            .isEqualTo(
                AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.Quote.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextAvailability().reply())
            .isEqualTo(
                AnalysisViralScoreResponse.Result.Analysis.ContextAvailability.Reply.NOT_APPLICABLE
            )
        assertThat(response.results()[0].analysis().contextBytes()).isEqualTo(612L)
        assertThat(response.results()[0].analysis().questions()).hasSize(3)
        assertThat(response.results()[0].analysis().questions()[0].id()).isEqualTo("sentiment")
        assertThat(response.results()[0].analysis().questions()[0].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[1].id()).isEqualTo("intensity")
        assertThat(response.results()[0].analysis().questions()[1].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis().questions()[2].id()).isEqualTo("sarcasm")
        assertThat(response.results()[0].analysis().questions()[2].version())
            .isEqualTo("sentiment:2")
        assertThat(response.results()[0].analysis()._status())
            .isEqualTo(JsonValue.from("succeeded"))
        assertThat(response.results()[0].cashtags()).containsExactly("\$NVDA")
        assertThat(response.results()[0].monitor()._baselineDatasetId())
            .isEqualTo(JsonValue.from(null))
        assertThat(response.results()[0].monitor().changedQuestionIds())
            .containsExactly("sentiment")
        assertThat(response.results()[0].monitor().changes()).hasSize(1)
        assertThat(response.results()[0].monitor().changes()[0].current()).isEqualTo("mixed")
        assertThat(response.results()[0].monitor().changes()[0].previous()).isEqualTo("positive")
        assertThat(response.results()[0].monitor().changes()[0].questionId()).isEqualTo("sentiment")
        assertThat(response.results()[0].monitor().configurationFingerprint())
            .isEqualTo("9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a")
        assertThat(response.results()[0].monitor().status())
            .isEqualTo(AnalysisViralScoreResponse.Result.Monitor.Status.CHANGED)
        assertThat(response.results()[0].sourceDomains()).containsExactly("youtube.com")
        assertThat(response.results()[0].tweet().id()).isEqualTo("1893456789012345678")
        assertThat(response.results()[0].tweet().text())
            .isEqualTo("The new headphones sound great. The app keeps crashing.")
        assertThat(response.unanalyzed()).hasSize(1)
        assertThat(response.unanalyzed()[0].id()).isEqualTo("1893456789012345679")
        assertThat(response.unanalyzed()[0].reason()).isEqualTo("post_unavailable")
        assertThat(response.unanalyzed()[0].status())
            .isEqualTo(AnalysisViralScoreResponse.Unanalyzed.Status.SKIPPED)
        assertThat(response.results()[0].analysis().answers()[0].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[0].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[1].probability()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].confidence()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].levels()).isEmpty
        assertThat(response.results()[0].analysis().answers()[2].value()).isEmpty
        assertThat(response.results()[0].viralActualEngagementRate()).isEmpty
        assertThat(response.results()[0].viralAlgorithmScore()).isEmpty
        assertThat(response.results()[0].viralScore()).isEmpty
        assertThat(response.results()[0].viralVerdict()).isEmpty
    }
}
