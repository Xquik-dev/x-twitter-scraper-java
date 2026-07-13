// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveRepliesParamsTest {

    @Test
    fun create() {
        UserRetrieveRepliesParams.builder()
            .id("id")
            .anyWords("anyWords")
            .cashtags("cashtags")
            .conversationId("conversationId")
            .cursor("cursor")
            .exactPhrase("exactPhrase")
            .excludeWords("excludeWords")
            .fromUser("fromUser")
            .hashtags("hashtags")
            .includeParentTweet(true)
            .inReplyToTweetId("inReplyToTweetId")
            .language("language")
            .mediaType(UserRetrieveRepliesParams.MediaType.IMAGES)
            .mentioning("mentioning")
            .minFaves(0L)
            .minQuotes(0L)
            .minReplies(0L)
            .minRetweets(0L)
            .pageSize(1L)
            .quotes(UserRetrieveRepliesParams.Quotes.INCLUDE)
            .quotesOfTweetId("quotesOfTweetId")
            .replies(UserRetrieveRepliesParams.Replies.INCLUDE)
            .retweets(UserRetrieveRepliesParams.Retweets.INCLUDE)
            .retweetsOfTweetId("retweetsOfTweetId")
            .sinceDate(LocalDate.parse("2019-12-27"))
            .toUser("toUser")
            .untilDate(LocalDate.parse("2019-12-27"))
            .url("url")
            .verifiedOnly(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveRepliesParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveRepliesParams.builder()
                .id("id")
                .anyWords("anyWords")
                .cashtags("cashtags")
                .conversationId("conversationId")
                .cursor("cursor")
                .exactPhrase("exactPhrase")
                .excludeWords("excludeWords")
                .fromUser("fromUser")
                .hashtags("hashtags")
                .includeParentTweet(true)
                .inReplyToTweetId("inReplyToTweetId")
                .language("language")
                .mediaType(UserRetrieveRepliesParams.MediaType.IMAGES)
                .mentioning("mentioning")
                .minFaves(0L)
                .minQuotes(0L)
                .minReplies(0L)
                .minRetweets(0L)
                .pageSize(1L)
                .quotes(UserRetrieveRepliesParams.Quotes.INCLUDE)
                .quotesOfTweetId("quotesOfTweetId")
                .replies(UserRetrieveRepliesParams.Replies.INCLUDE)
                .retweets(UserRetrieveRepliesParams.Retweets.INCLUDE)
                .retweetsOfTweetId("retweetsOfTweetId")
                .sinceDate(LocalDate.parse("2019-12-27"))
                .toUser("toUser")
                .untilDate(LocalDate.parse("2019-12-27"))
                .url("url")
                .verifiedOnly(true)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("anyWords", "anyWords")
                    .put("cashtags", "cashtags")
                    .put("conversationId", "conversationId")
                    .put("cursor", "cursor")
                    .put("exactPhrase", "exactPhrase")
                    .put("excludeWords", "excludeWords")
                    .put("fromUser", "fromUser")
                    .put("hashtags", "hashtags")
                    .put("includeParentTweet", "true")
                    .put("inReplyToTweetId", "inReplyToTweetId")
                    .put("language", "language")
                    .put("mediaType", "images")
                    .put("mentioning", "mentioning")
                    .put("minFaves", "0")
                    .put("minQuotes", "0")
                    .put("minReplies", "0")
                    .put("minRetweets", "0")
                    .put("pageSize", "1")
                    .put("quotes", "include")
                    .put("quotesOfTweetId", "quotesOfTweetId")
                    .put("replies", "include")
                    .put("retweets", "include")
                    .put("retweetsOfTweetId", "retweetsOfTweetId")
                    .put("sinceDate", "2019-12-27")
                    .put("toUser", "toUser")
                    .put("untilDate", "2019-12-27")
                    .put("url", "url")
                    .put("verifiedOnly", "true")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveRepliesParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
