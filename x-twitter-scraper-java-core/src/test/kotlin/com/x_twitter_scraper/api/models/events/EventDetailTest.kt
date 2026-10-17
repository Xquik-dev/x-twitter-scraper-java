// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventDetailTest {

    @Test
    fun create() {
        val eventDetail =
            EventDetail.builder()
                .id("42")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .monitorType(EventDetail.MonitorType.ACCOUNT)
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventType.TWEET_NEW)
                .keywordMonitorId("21")
                .query("xquik OR \"x api\"")
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        assertThat(eventDetail.id()).isEqualTo("42")
        assertThat(eventDetail.data())
            .isEqualTo(
                EventDetail.Data.builder()
                    .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventDetail.monitorId()).isEqualTo("10")
        assertThat(eventDetail.monitorType()).isEqualTo(EventDetail.MonitorType.ACCOUNT)
        assertThat(eventDetail.occurredAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(eventDetail.type()).isEqualTo(EventType.TWEET_NEW)
        assertThat(eventDetail.keywordMonitorId()).contains("21")
        assertThat(eventDetail.query()).contains("xquik OR \"x api\"")
        assertThat(eventDetail.username()).contains("elonmusk")
        assertThat(eventDetail.xEventId()).contains("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventDetail =
            EventDetail.builder()
                .id("42")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .monitorType(EventDetail.MonitorType.ACCOUNT)
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventType.TWEET_NEW)
                .keywordMonitorId("21")
                .query("xquik OR \"x api\"")
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        val roundtrippedEventDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventDetail),
                jacksonTypeRef<EventDetail>(),
            )

        assertThat(roundtrippedEventDetail).isEqualTo(eventDetail)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"xUserId":"sample","monitorName":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<EventDetail>())

        assertThat(model.xUserId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xUserId")
        assertThat(model.monitorName()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("monitorName")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<EventDetail>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalDataFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"sample","text":"sample","type":"sample","createdAt":"sample","url":"sample","lang":"sample","isReply":true,"isLimitedReply":true,"isNoteTweet":true,"isPinned":true,"isQuoteStatus":true,"isRetweet":true,"quotedTweetId":"sample","quotedTweetPermalink":{},"quotedTweetUnavailable":{},"retweetedAt":"2025-01-15T12:00:00Z","inReplyToId":"sample","inReplyToUserId":"sample","inReplyToUsername":"sample","conversationId":"sample","conversationControl":{},"limitedActions":[{}],"source":"sample","displayTextRange":[1],"textHighlights":[{}],"contentDisclosure":{},"article":{},"authorUnavailable":{},"unavailableAuthorId":"sample","card":{},"cashtagAttachments":[{}],"communityId":"sample","communityName":"sample","communityNote":{},"hasCommunityNotes":true,"edit":{},"exclusiveContent":{},"isTranslatable":true,"grokShareAttachment":{},"grokTranslatedPost":{},"jetfuelAttachment":{},"noteTweet":{},"place":{},"coordinates":{},"geo":{},"postCta":{},"possiblySensitive":true,"previousCounts":{},"reactionContext":{},"sportsContext":{},"subscriberBadge":{},"tombstone":{},"interstitial":{},"unmentionedUserIds":["sample"],"viewState":"sample","entities":{},"scopes":{},"media":[{}],"retweetCount":1,"replyCount":1,"likeCount":1,"quoteCount":1,"viewCount":1,"bookmarkCount":1,"parentTweet":{},"quoted_tweet":{},"retweeted_tweet":{},"author":{},"field":"sample","change":1,"userId":"sample","username":"sample","previous":{},"current":{},"followedAt":"2025-01-15T12:00:00Z","followedAtExact":true,"reason":"unavailable"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<EventDetail.Data>())

        assertThat(model.id()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("id")
        assertThat(model.text()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("text")
        assertThat(model.type()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("type")
        assertThat(model.createdAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("createdAt")
        assertThat(model.url()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("url")
        assertThat(model.lang()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("lang")
        assertThat(model.isReply()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isReply")
        assertThat(model.isLimitedReply()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isLimitedReply")
        assertThat(model.isNoteTweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isNoteTweet")
        assertThat(model.isPinned()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isPinned")
        assertThat(model.isQuoteStatus()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isQuoteStatus")
        assertThat(model.isRetweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isRetweet")
        assertThat(model.quotedTweetId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quotedTweetId")
        assertThat(model.quotedTweetPermalink()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quotedTweetPermalink")
        assertThat(model.quotedTweetUnavailable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quotedTweetUnavailable")
        assertThat(model.retweetedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("retweetedAt")
        assertThat(model.inReplyToId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("inReplyToId")
        assertThat(model.inReplyToUserId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("inReplyToUserId")
        assertThat(model.inReplyToUsername()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("inReplyToUsername")
        assertThat(model.conversationId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("conversationId")
        assertThat(model.conversationControl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("conversationControl")
        assertThat(model.limitedActions()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("limitedActions")
        assertThat(model.source()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("source")
        assertThat(model.displayTextRange()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("displayTextRange")
        assertThat(model.textHighlights()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("textHighlights")
        assertThat(model.contentDisclosure()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("contentDisclosure")
        assertThat(model.article()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("article")
        assertThat(model.authorUnavailable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("authorUnavailable")
        assertThat(model.unavailableAuthorId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("unavailableAuthorId")
        assertThat(model.card()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("card")
        assertThat(model.cashtagAttachments()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("cashtagAttachments")
        assertThat(model.communityId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("communityId")
        assertThat(model.communityName()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("communityName")
        assertThat(model.communityNote()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("communityNote")
        assertThat(model.hasCommunityNotes()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasCommunityNotes")
        assertThat(model.edit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("edit")
        assertThat(model.exclusiveContent()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("exclusiveContent")
        assertThat(model.isTranslatable()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("isTranslatable")
        assertThat(model.grokShareAttachment()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("grokShareAttachment")
        assertThat(model.grokTranslatedPost()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("grokTranslatedPost")
        assertThat(model.jetfuelAttachment()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("jetfuelAttachment")
        assertThat(model.noteTweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("noteTweet")
        assertThat(model.place()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("place")
        assertThat(model.coordinates()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("coordinates")
        assertThat(model.geo()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("geo")
        assertThat(model.postCta()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("postCta")
        assertThat(model.possiblySensitive()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("possiblySensitive")
        assertThat(model.previousCounts()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("previousCounts")
        assertThat(model.reactionContext()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("reactionContext")
        assertThat(model.sportsContext()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("sportsContext")
        assertThat(model.subscriberBadge()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("subscriberBadge")
        assertThat(model.tombstone()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tombstone")
        assertThat(model.interstitial()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("interstitial")
        assertThat(model.unmentionedUserIds()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("unmentionedUserIds")
        assertThat(model.viewState()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("viewState")
        assertThat(model.entities()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("entities")
        assertThat(model.scopes()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("scopes")
        assertThat(model.media()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("media")
        assertThat(model.retweetCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("retweetCount")
        assertThat(model.replyCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("replyCount")
        assertThat(model.likeCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("likeCount")
        assertThat(model.quoteCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quoteCount")
        assertThat(model.viewCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("viewCount")
        assertThat(model.bookmarkCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("bookmarkCount")
        assertThat(model.parentTweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("parentTweet")
        assertThat(model.quotedTweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quoted_tweet")
        assertThat(model.retweetedTweet()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("retweeted_tweet")
        assertThat(model.author()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("author")
        assertThat(model.field()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("field")
        assertThat(model.change()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("change")
        assertThat(model.userId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("userId")
        assertThat(model.username()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("username")
        assertThat(model.previous()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("previous")
        assertThat(model.current()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("current")
        assertThat(model.followedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("followedAt")
        assertThat(model.followedAtExact()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("followedAtExact")
        assertThat(model.reason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("reason")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<EventDetail.Data>(),
                )
            )
            .isEqualTo(model)
    }
}
