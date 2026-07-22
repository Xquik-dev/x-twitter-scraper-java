// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
import com.x_twitter_scraper.api.models.compose.ComposeCreateResponse
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/x-twitter-scraper-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.account()).isNotNull()
        assertThat(client.subscribe()).isNotNull()
        assertThat(client.compose()).isNotNull()
        assertThat(client.drafts()).isNotNull()
        assertThat(client.styles()).isNotNull()
        assertThat(client.radar()).isNotNull()
        assertThat(client.monitors()).isNotNull()
        assertThat(client.events()).isNotNull()
        assertThat(client.extractions()).isNotNull()
        assertThat(client.draws()).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.x()).isNotNull()
        assertThat(client.trends()).isNotNull()
        assertThat(client.support()).isNotNull()
        assertThat(client.credits()).isNotNull()
        assertThat(client.guestWallets()).isNotNull()
    }

    @Test
    fun accountRetrieveResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorBilling(
                    AccountRetrieveResponse.MonitorBilling.builder()
                        .activeDailyEstimate("1500")
                        .activeHourlyBurn("63")
                        .creditsPerActiveMonitorDay("500")
                        .creditsPerActiveMonitorHour("21")
                        .eventsIncluded(true)
                        .instantCheckIntervalSeconds(1L)
                        .unlimitedSlots(true)
                        .build()
                )
                .monitorsAllowed(9007199254740991L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupAmountDollars(10.0)
                        .autoTopupEnabled(false)
                        .autoTopupThreshold("50000")
                        .balance("50000")
                        .lifetimePurchased("140000")
                        .lifetimeUsed("90000")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }

    @Test
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

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }

    @Test
    fun eventTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val eventType = EventType.TWEET_NEW

        val roundtrippedEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventType),
                jacksonTypeRef<EventType>(),
            )

        assertThat(roundtrippedEventType).isEqualTo(eventType)
    }
}
