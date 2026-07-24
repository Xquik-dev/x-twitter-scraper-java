// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.xquik.consumer.proguard

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.XTwitterScraperClientImpl
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.HttpClient
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.compose.ComposeCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetAuthor
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            val test = ProGuardCompatibilityTest()
            test.proguardRules()
            test.client()
            test.productionDeserialization()
            test.tweetAuthorRoundtrip()
            test.composeCreateResponseRoundtrip()
            test.eventTypeRoundtrip()
        }
    }

    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/x-twitter-scraper-java-core.pro"
            )

        checkNotNull(rulesFile).close()
    }

    fun client() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()

        client.account()
        client.guestWallets()
        client.subscribe()
        client.compose()
        client.drafts()
        client.styles()
        client.radar()
        client.monitors()
        client.events()
        client.extractions()
        client.draws()
        client.webhooks()
        client.x()
        client.trends()
        client.support()
        client.credits()
        client.close()
    }

    fun productionDeserialization() {
        val client =
            XTwitterScraperClientImpl(
                ClientOptions.builder()
                    .httpClient(FixedResponseHttpClient(CREDIT_BALANCE_JSON))
                    .apiKey("My API Key")
                    .maxRetries(0)
                    .build()
            )

        val balance = client.credits().retrieveBalance()
        check(balance.autoTopupEnabled())
        check(balance.balance() == "42")
        check(balance.lifetimePurchased() == "100")
        check(balance.lifetimeUsed() == "58")
        client.close()
    }

    fun tweetAuthorRoundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
                .id("9876543210")
                .name("Elon Musk")
                .followers(150000000L)
                .username("elonmusk")
                .verified(true)
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .build()

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                object : TypeReference<TweetAuthor>() {},
            )

        check(roundtrippedTweetAuthor == tweetAuthor) {
            "TweetAuthor roundtrip changed: expected=$tweetAuthor, actual=$roundtrippedTweetAuthor"
        }
    }

    fun composeCreateResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.ofPrepareResult(
                ComposeCreateResponse.ComposePrepareResult.builder()
                    .contentRules(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                        )
                    )
                    .engagementMultipliers(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                        )
                    )
                    .engagementVelocity("engagementVelocity")
                    .followUpQuestions(listOf("string", "string", "string", "string"))
                    .intentUrl("https://example.com")
                    .nextStep("nextStep")
                    .scorerWeights(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                        )
                    )
                    .source("source")
                    .topPenalties(listOf("string", "string", "string", "string"))
                    .addSavedStyle(
                        ComposeCreateResponse.ComposePrepareResult.SavedStyle.builder()
                            .tweetCount(0L)
                            .username("username")
                            .build()
                    )
                    .styleNote("styleNote")
                    .addStyleTweet("string")
                    .build()
            )

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        check(roundtrippedComposeCreateResponse == composeCreateResponse) {
            "ComposeCreateResponse roundtrip changed"
        }
    }

    fun eventTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val eventType = EventType.TWEET_NEW

        val roundtrippedEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventType),
                object : TypeReference<EventType>() {},
            )

        check(roundtrippedEventType == eventType) {
            "EventType roundtrip changed: expected=$eventType, actual=$roundtrippedEventType"
        }
    }
}

private const val CREDIT_BALANCE_JSON =
    """{"auto_topup_enabled":true,"balance":"42","lifetime_purchased":"100","lifetime_used":"58"}"""

private class FixedResponseHttpClient(responseBody: String) : HttpClient {

    private val responseBody = responseBody.toByteArray()

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response()

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response())

    override fun close() {}

    private fun response(): HttpResponse =
        object : HttpResponse {

            override fun statusCode(): Int = 200

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(responseBody)

            override fun close() {}
        }
}
