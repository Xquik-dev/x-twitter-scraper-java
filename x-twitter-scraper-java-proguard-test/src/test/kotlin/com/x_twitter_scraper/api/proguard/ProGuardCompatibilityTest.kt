// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
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
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.account()).isNotNull()
        assertThat(client.apiKeys()).isNotNull()
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
    }

    @Test
    fun accountRetrieveResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorsAllowed(10L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupEnabled(false)
                        .balance(50000L)
                        .lifetimePurchased(140000L)
                        .lifetimeUsed(90000L)
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
