// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.x.tweets.SearchTweet
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
        assertThat(client.integrations()).isNotNull()
        assertThat(client.x()).isNotNull()
        assertThat(client.trends()).isNotNull()
        assertThat(client.bot()).isNotNull()
        assertThat(client.support()).isNotNull()
        assertThat(client.credits()).isNotNull()
    }

    @Test
    fun searchTweetRoundtrip() {
        val jsonMapper = jsonMapper()
        val searchTweet =
            SearchTweet.builder()
                .id("id")
                .text("text")
                .author(
                    SearchTweet.Author.builder()
                        .id("id")
                        .name("name")
                        .username("username")
                        .verified(true)
                        .build()
                )
                .bookmarkCount(0L)
                .createdAt("createdAt")
                .likeCount(0L)
                .quoteCount(0L)
                .replyCount(0L)
                .retweetCount(0L)
                .viewCount(0L)
                .build()

        val roundtrippedSearchTweet =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(searchTweet),
                jacksonTypeRef<SearchTweet>(),
            )

        assertThat(roundtrippedSearchTweet).isEqualTo(searchTweet)
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
