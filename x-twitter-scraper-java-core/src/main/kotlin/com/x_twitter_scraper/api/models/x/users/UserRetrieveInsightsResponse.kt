// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UserRetrieveInsightsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val insights: JsonField<Insights>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("insights") @ExcludeMissing insights: JsonField<Insights> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(insights, message, mutableMapOf())

    /**
     * Engagement insights of 1 profile. Engagements are likes, replies, reposts and quotes. A rate
     * is null when nothing divides it, such as a profile without posts of its own.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun insights(): Insights = insights.getRequired("insights")

    /**
     * Says why the report has counts only.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [insights].
     *
     * Unlike [insights], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("insights") @ExcludeMissing fun _insights(): JsonField<Insights> = insights

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserRetrieveInsightsResponse].
         *
         * The following fields are required:
         * ```java
         * .insights()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveInsightsResponse]. */
    class Builder internal constructor() {

        private var insights: JsonField<Insights>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveInsightsResponse: UserRetrieveInsightsResponse) = apply {
            insights = userRetrieveInsightsResponse.insights
            message = userRetrieveInsightsResponse.message
            additionalProperties = userRetrieveInsightsResponse.additionalProperties.toMutableMap()
        }

        /**
         * Engagement insights of 1 profile. Engagements are likes, replies, reposts and quotes. A
         * rate is null when nothing divides it, such as a profile without posts of its own.
         */
        fun insights(insights: Insights) = insights(JsonField.of(insights))

        /** Sets [Builder.insights] to an arbitrary JSON value. */
        fun insights(insights: JsonField<Insights>) = apply { this.insights = insights }

        /** Says why the report has counts only. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [UserRetrieveInsightsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .insights()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveInsightsResponse =
            UserRetrieveInsightsResponse(
                checkRequired("insights", insights),
                message,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): UserRetrieveInsightsResponse = apply {
        if (validated) {
            return@apply
        }

        insights().validate()
        message()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic
    internal fun validity(): Int =
        (insights.asKnown().getOrNull()?.validity() ?: 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    /**
     * Engagement insights of 1 profile. Engagements are likes, replies, reposts and quotes. A rate
     * is null when nothing divides it, such as a profile without posts of its own.
     */
    class Insights
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val accountAgeDays: JsonField<Double>,
        private val averages: JsonField<Averages>,
        private val engagementPerView: JsonField<Double>,
        private val engagementRate: JsonField<Double>,
        private val followers: JsonField<Double>,
        private val following: JsonField<Double>,
        private val posts: JsonField<Double>,
        private val postsPerDay: JsonField<Double>,
        private val postsPrivate: JsonField<Boolean>,
        private val sample: JsonField<Sample>,
        private val topPostId: JsonField<String>,
        private val userId: JsonField<String>,
        private val userName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("accountAgeDays")
            @ExcludeMissing
            accountAgeDays: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("averages")
            @ExcludeMissing
            averages: JsonField<Averages> = JsonMissing.of(),
            @JsonProperty("engagementPerView")
            @ExcludeMissing
            engagementPerView: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("engagementRate")
            @ExcludeMissing
            engagementRate: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("followers")
            @ExcludeMissing
            followers: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("following")
            @ExcludeMissing
            following: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("posts") @ExcludeMissing posts: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("postsPerDay")
            @ExcludeMissing
            postsPerDay: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("postsPrivate")
            @ExcludeMissing
            postsPrivate: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("sample") @ExcludeMissing sample: JsonField<Sample> = JsonMissing.of(),
            @JsonProperty("topPostId")
            @ExcludeMissing
            topPostId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userName")
            @ExcludeMissing
            userName: JsonField<String> = JsonMissing.of(),
        ) : this(
            accountAgeDays,
            averages,
            engagementPerView,
            engagementRate,
            followers,
            following,
            posts,
            postsPerDay,
            postsPrivate,
            sample,
            topPostId,
            userId,
            userName,
            mutableMapOf(),
        )

        /**
         * Whole days since the account joined X.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun accountAgeDays(): Optional<Double> = accountAgeDays.getOptional("accountAgeDays")

        /**
         * Each count per post of the sample. Null without posts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun averages(): Optional<Averages> = averages.getOptional("averages")

        /**
         * Engagements as a percent of views across the sample.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun engagementPerView(): Optional<Double> =
            engagementPerView.getOptional("engagementPerView")

        /**
         * Average engagements per post, as a percent of followers.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun engagementRate(): Optional<Double> = engagementRate.getOptional("engagementRate")

        /**
         * Followers.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun followers(): Double = followers.getRequired("followers")

        /**
         * Accounts the user follows.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun following(): Double = following.getRequired("following")

        /**
         * Posts the user has made.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun posts(): Double = posts.getRequired("posts")

        /**
         * Sampled posts per day, from the oldest one until now.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun postsPerDay(): Optional<Double> = postsPerDay.getOptional("postsPerDay")

        /**
         * True when only the account's followers see its posts. The report then has its counts
         * only.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun postsPrivate(): Boolean = postsPrivate.getRequired("postsPrivate")

        /**
         * The recent posts the averages read.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun sample(): Sample = sample.getRequired("sample")

        /**
         * The sampled post with the most engagements.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun topPostId(): Optional<String> = topPostId.getOptional("topPostId")

        /**
         * ID of the profile the insights describe.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun userId(): String = userId.getRequired("userId")

        /**
         * Username of that profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun userName(): String = userName.getRequired("userName")

        /**
         * Returns the raw JSON value of [accountAgeDays].
         *
         * Unlike [accountAgeDays], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("accountAgeDays")
        @ExcludeMissing
        fun _accountAgeDays(): JsonField<Double> = accountAgeDays

        /**
         * Returns the raw JSON value of [averages].
         *
         * Unlike [averages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("averages") @ExcludeMissing fun _averages(): JsonField<Averages> = averages

        /**
         * Returns the raw JSON value of [engagementPerView].
         *
         * Unlike [engagementPerView], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engagementPerView")
        @ExcludeMissing
        fun _engagementPerView(): JsonField<Double> = engagementPerView

        /**
         * Returns the raw JSON value of [engagementRate].
         *
         * Unlike [engagementRate], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engagementRate")
        @ExcludeMissing
        fun _engagementRate(): JsonField<Double> = engagementRate

        /**
         * Returns the raw JSON value of [followers].
         *
         * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Double> = followers

        /**
         * Returns the raw JSON value of [following].
         *
         * Unlike [following], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Double> = following

        /**
         * Returns the raw JSON value of [posts].
         *
         * Unlike [posts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("posts") @ExcludeMissing fun _posts(): JsonField<Double> = posts

        /**
         * Returns the raw JSON value of [postsPerDay].
         *
         * Unlike [postsPerDay], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postsPerDay")
        @ExcludeMissing
        fun _postsPerDay(): JsonField<Double> = postsPerDay

        /**
         * Returns the raw JSON value of [postsPrivate].
         *
         * Unlike [postsPrivate], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("postsPrivate")
        @ExcludeMissing
        fun _postsPrivate(): JsonField<Boolean> = postsPrivate

        /**
         * Returns the raw JSON value of [sample].
         *
         * Unlike [sample], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sample") @ExcludeMissing fun _sample(): JsonField<Sample> = sample

        /**
         * Returns the raw JSON value of [topPostId].
         *
         * Unlike [topPostId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("topPostId") @ExcludeMissing fun _topPostId(): JsonField<String> = topPostId

        /**
         * Returns the raw JSON value of [userId].
         *
         * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

        /**
         * Returns the raw JSON value of [userName].
         *
         * Unlike [userName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userName") @ExcludeMissing fun _userName(): JsonField<String> = userName

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Insights].
             *
             * The following fields are required:
             * ```java
             * .accountAgeDays()
             * .averages()
             * .engagementPerView()
             * .engagementRate()
             * .followers()
             * .following()
             * .posts()
             * .postsPerDay()
             * .postsPrivate()
             * .sample()
             * .topPostId()
             * .userId()
             * .userName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Insights]. */
        class Builder internal constructor() {

            private var accountAgeDays: JsonField<Double>? = null
            private var averages: JsonField<Averages>? = null
            private var engagementPerView: JsonField<Double>? = null
            private var engagementRate: JsonField<Double>? = null
            private var followers: JsonField<Double>? = null
            private var following: JsonField<Double>? = null
            private var posts: JsonField<Double>? = null
            private var postsPerDay: JsonField<Double>? = null
            private var postsPrivate: JsonField<Boolean>? = null
            private var sample: JsonField<Sample>? = null
            private var topPostId: JsonField<String>? = null
            private var userId: JsonField<String>? = null
            private var userName: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(insights: Insights) = apply {
                accountAgeDays = insights.accountAgeDays
                averages = insights.averages
                engagementPerView = insights.engagementPerView
                engagementRate = insights.engagementRate
                followers = insights.followers
                following = insights.following
                posts = insights.posts
                postsPerDay = insights.postsPerDay
                postsPrivate = insights.postsPrivate
                sample = insights.sample
                topPostId = insights.topPostId
                userId = insights.userId
                userName = insights.userName
                additionalProperties = insights.additionalProperties.toMutableMap()
            }

            /** Whole days since the account joined X. */
            fun accountAgeDays(accountAgeDays: Double?) =
                accountAgeDays(JsonField.ofNullable(accountAgeDays))

            /** Alias for [Builder.accountAgeDays]. */
            fun accountAgeDays(accountAgeDays: Double) = accountAgeDays(accountAgeDays as Double?)

            /** Alias for calling [Builder.accountAgeDays] with `accountAgeDays.orElse(null)`. */
            fun accountAgeDays(accountAgeDays: Optional<Double>) =
                accountAgeDays(accountAgeDays.getOrNull())

            /** Sets [Builder.accountAgeDays] to an arbitrary JSON value. */
            fun accountAgeDays(accountAgeDays: JsonField<Double>) = apply {
                this.accountAgeDays = accountAgeDays
            }

            /** Each count per post of the sample. Null without posts. */
            fun averages(averages: Averages?) = averages(JsonField.ofNullable(averages))

            /** Alias for calling [Builder.averages] with `averages.orElse(null)`. */
            fun averages(averages: Optional<Averages>) = averages(averages.getOrNull())

            /** Sets [Builder.averages] to an arbitrary JSON value. */
            fun averages(averages: JsonField<Averages>) = apply { this.averages = averages }

            /** Engagements as a percent of views across the sample. */
            fun engagementPerView(engagementPerView: Double?) =
                engagementPerView(JsonField.ofNullable(engagementPerView))

            /** Alias for [Builder.engagementPerView]. */
            fun engagementPerView(engagementPerView: Double) =
                engagementPerView(engagementPerView as Double?)

            /**
             * Alias for calling [Builder.engagementPerView] with `engagementPerView.orElse(null)`.
             */
            fun engagementPerView(engagementPerView: Optional<Double>) =
                engagementPerView(engagementPerView.getOrNull())

            /** Sets [Builder.engagementPerView] to an arbitrary JSON value. */
            fun engagementPerView(engagementPerView: JsonField<Double>) = apply {
                this.engagementPerView = engagementPerView
            }

            /** Average engagements per post, as a percent of followers. */
            fun engagementRate(engagementRate: Double?) =
                engagementRate(JsonField.ofNullable(engagementRate))

            /** Alias for [Builder.engagementRate]. */
            fun engagementRate(engagementRate: Double) = engagementRate(engagementRate as Double?)

            /** Alias for calling [Builder.engagementRate] with `engagementRate.orElse(null)`. */
            fun engagementRate(engagementRate: Optional<Double>) =
                engagementRate(engagementRate.getOrNull())

            /** Sets [Builder.engagementRate] to an arbitrary JSON value. */
            fun engagementRate(engagementRate: JsonField<Double>) = apply {
                this.engagementRate = engagementRate
            }

            /** Followers. */
            fun followers(followers: Double) = followers(JsonField.of(followers))

            /** Sets [Builder.followers] to an arbitrary JSON value. */
            fun followers(followers: JsonField<Double>) = apply { this.followers = followers }

            /** Accounts the user follows. */
            fun following(following: Double) = following(JsonField.of(following))

            /** Sets [Builder.following] to an arbitrary JSON value. */
            fun following(following: JsonField<Double>) = apply { this.following = following }

            /** Posts the user has made. */
            fun posts(posts: Double) = posts(JsonField.of(posts))

            /** Sets [Builder.posts] to an arbitrary JSON value. */
            fun posts(posts: JsonField<Double>) = apply { this.posts = posts }

            /** Sampled posts per day, from the oldest one until now. */
            fun postsPerDay(postsPerDay: Double?) = postsPerDay(JsonField.ofNullable(postsPerDay))

            /** Alias for [Builder.postsPerDay]. */
            fun postsPerDay(postsPerDay: Double) = postsPerDay(postsPerDay as Double?)

            /** Alias for calling [Builder.postsPerDay] with `postsPerDay.orElse(null)`. */
            fun postsPerDay(postsPerDay: Optional<Double>) = postsPerDay(postsPerDay.getOrNull())

            /** Sets [Builder.postsPerDay] to an arbitrary JSON value. */
            fun postsPerDay(postsPerDay: JsonField<Double>) = apply {
                this.postsPerDay = postsPerDay
            }

            /**
             * True when only the account's followers see its posts. The report then has its counts
             * only.
             */
            fun postsPrivate(postsPrivate: Boolean) = postsPrivate(JsonField.of(postsPrivate))

            /** Sets [Builder.postsPrivate] to an arbitrary JSON value. */
            fun postsPrivate(postsPrivate: JsonField<Boolean>) = apply {
                this.postsPrivate = postsPrivate
            }

            /** The recent posts the averages read. */
            fun sample(sample: Sample) = sample(JsonField.of(sample))

            /** Sets [Builder.sample] to an arbitrary JSON value. */
            fun sample(sample: JsonField<Sample>) = apply { this.sample = sample }

            /** The sampled post with the most engagements. */
            fun topPostId(topPostId: String?) = topPostId(JsonField.ofNullable(topPostId))

            /** Alias for calling [Builder.topPostId] with `topPostId.orElse(null)`. */
            fun topPostId(topPostId: Optional<String>) = topPostId(topPostId.getOrNull())

            /** Sets [Builder.topPostId] to an arbitrary JSON value. */
            fun topPostId(topPostId: JsonField<String>) = apply { this.topPostId = topPostId }

            /** ID of the profile the insights describe. */
            fun userId(userId: String) = userId(JsonField.of(userId))

            /** Sets [Builder.userId] to an arbitrary JSON value. */
            fun userId(userId: JsonField<String>) = apply { this.userId = userId }

            /** Username of that profile. */
            fun userName(userName: String) = userName(JsonField.of(userName))

            /** Sets [Builder.userName] to an arbitrary JSON value. */
            fun userName(userName: JsonField<String>) = apply { this.userName = userName }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Insights].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .accountAgeDays()
             * .averages()
             * .engagementPerView()
             * .engagementRate()
             * .followers()
             * .following()
             * .posts()
             * .postsPerDay()
             * .postsPrivate()
             * .sample()
             * .topPostId()
             * .userId()
             * .userName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Insights =
                Insights(
                    checkRequired("accountAgeDays", accountAgeDays),
                    checkRequired("averages", averages),
                    checkRequired("engagementPerView", engagementPerView),
                    checkRequired("engagementRate", engagementRate),
                    checkRequired("followers", followers),
                    checkRequired("following", following),
                    checkRequired("posts", posts),
                    checkRequired("postsPerDay", postsPerDay),
                    checkRequired("postsPrivate", postsPrivate),
                    checkRequired("sample", sample),
                    checkRequired("topPostId", topPostId),
                    checkRequired("userId", userId),
                    checkRequired("userName", userName),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Insights = apply {
            if (validated) {
                return@apply
            }

            accountAgeDays()
            averages().ifPresent { it.validate() }
            engagementPerView()
            engagementRate()
            followers()
            following()
            posts()
            postsPerDay()
            postsPrivate()
            sample().validate()
            topPostId()
            userId()
            userName()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (if (accountAgeDays.asKnown().isPresent) 1 else 0) +
                (averages.asKnown().getOrNull()?.validity() ?: 0) +
                (if (engagementPerView.asKnown().isPresent) 1 else 0) +
                (if (engagementRate.asKnown().isPresent) 1 else 0) +
                (if (followers.asKnown().isPresent) 1 else 0) +
                (if (following.asKnown().isPresent) 1 else 0) +
                (if (posts.asKnown().isPresent) 1 else 0) +
                (if (postsPerDay.asKnown().isPresent) 1 else 0) +
                (if (postsPrivate.asKnown().isPresent) 1 else 0) +
                (sample.asKnown().getOrNull()?.validity() ?: 0) +
                (if (topPostId.asKnown().isPresent) 1 else 0) +
                (if (userId.asKnown().isPresent) 1 else 0) +
                (if (userName.asKnown().isPresent) 1 else 0)

        /** The public counts of 1 tweet. */
        class Averages
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bookmarks: JsonField<Double>,
            private val engagements: JsonField<Double>,
            private val likes: JsonField<Double>,
            private val quotes: JsonField<Double>,
            private val replies: JsonField<Double>,
            private val reposts: JsonField<Double>,
            private val views: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bookmarks")
                @ExcludeMissing
                bookmarks: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("engagements")
                @ExcludeMissing
                engagements: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("likes") @ExcludeMissing likes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("quotes")
                @ExcludeMissing
                quotes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("replies")
                @ExcludeMissing
                replies: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("reposts")
                @ExcludeMissing
                reposts: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("views") @ExcludeMissing views: JsonField<Double> = JsonMissing.of(),
            ) : this(bookmarks, engagements, likes, quotes, replies, reposts, views, mutableMapOf())

            /**
             * Bookmarks.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun bookmarks(): Double = bookmarks.getRequired("bookmarks")

            /**
             * Likes, replies, reposts and quotes per post.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun engagements(): Double = engagements.getRequired("engagements")

            /**
             * Likes.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun likes(): Double = likes.getRequired("likes")

            /**
             * Quotes.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun quotes(): Double = quotes.getRequired("quotes")

            /**
             * Replies.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun replies(): Double = replies.getRequired("replies")

            /**
             * Reposts.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun reposts(): Double = reposts.getRequired("reposts")

            /**
             * Views.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun views(): Double = views.getRequired("views")

            /**
             * Returns the raw JSON value of [bookmarks].
             *
             * Unlike [bookmarks], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("bookmarks")
            @ExcludeMissing
            fun _bookmarks(): JsonField<Double> = bookmarks

            /**
             * Returns the raw JSON value of [engagements].
             *
             * Unlike [engagements], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("engagements")
            @ExcludeMissing
            fun _engagements(): JsonField<Double> = engagements

            /**
             * Returns the raw JSON value of [likes].
             *
             * Unlike [likes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<Double> = likes

            /**
             * Returns the raw JSON value of [quotes].
             *
             * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<Double> = quotes

            /**
             * Returns the raw JSON value of [replies].
             *
             * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Double> = replies

            /**
             * Returns the raw JSON value of [reposts].
             *
             * Unlike [reposts], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reposts") @ExcludeMissing fun _reposts(): JsonField<Double> = reposts

            /**
             * Returns the raw JSON value of [views].
             *
             * Unlike [views], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<Double> = views

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Averages].
                 *
                 * The following fields are required:
                 * ```java
                 * .bookmarks()
                 * .engagements()
                 * .likes()
                 * .quotes()
                 * .replies()
                 * .reposts()
                 * .views()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Averages]. */
            class Builder internal constructor() {

                private var bookmarks: JsonField<Double>? = null
                private var engagements: JsonField<Double>? = null
                private var likes: JsonField<Double>? = null
                private var quotes: JsonField<Double>? = null
                private var replies: JsonField<Double>? = null
                private var reposts: JsonField<Double>? = null
                private var views: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(averages: Averages) = apply {
                    bookmarks = averages.bookmarks
                    engagements = averages.engagements
                    likes = averages.likes
                    quotes = averages.quotes
                    replies = averages.replies
                    reposts = averages.reposts
                    views = averages.views
                    additionalProperties = averages.additionalProperties.toMutableMap()
                }

                /** Bookmarks. */
                fun bookmarks(bookmarks: Double) = bookmarks(JsonField.of(bookmarks))

                /** Sets [Builder.bookmarks] to an arbitrary JSON value. */
                fun bookmarks(bookmarks: JsonField<Double>) = apply { this.bookmarks = bookmarks }

                /** Likes, replies, reposts and quotes per post. */
                fun engagements(engagements: Double) = engagements(JsonField.of(engagements))

                /** Sets [Builder.engagements] to an arbitrary JSON value. */
                fun engagements(engagements: JsonField<Double>) = apply {
                    this.engagements = engagements
                }

                /** Likes. */
                fun likes(likes: Double) = likes(JsonField.of(likes))

                /** Sets [Builder.likes] to an arbitrary JSON value. */
                fun likes(likes: JsonField<Double>) = apply { this.likes = likes }

                /** Quotes. */
                fun quotes(quotes: Double) = quotes(JsonField.of(quotes))

                /** Sets [Builder.quotes] to an arbitrary JSON value. */
                fun quotes(quotes: JsonField<Double>) = apply { this.quotes = quotes }

                /** Replies. */
                fun replies(replies: Double) = replies(JsonField.of(replies))

                /** Sets [Builder.replies] to an arbitrary JSON value. */
                fun replies(replies: JsonField<Double>) = apply { this.replies = replies }

                /** Reposts. */
                fun reposts(reposts: Double) = reposts(JsonField.of(reposts))

                /** Sets [Builder.reposts] to an arbitrary JSON value. */
                fun reposts(reposts: JsonField<Double>) = apply { this.reposts = reposts }

                /** Views. */
                fun views(views: Double) = views(JsonField.of(views))

                /** Sets [Builder.views] to an arbitrary JSON value. */
                fun views(views: JsonField<Double>) = apply { this.views = views }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Averages].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bookmarks()
                 * .engagements()
                 * .likes()
                 * .quotes()
                 * .replies()
                 * .reposts()
                 * .views()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Averages =
                    Averages(
                        checkRequired("bookmarks", bookmarks),
                        checkRequired("engagements", engagements),
                        checkRequired("likes", likes),
                        checkRequired("quotes", quotes),
                        checkRequired("replies", replies),
                        checkRequired("reposts", reposts),
                        checkRequired("views", views),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Averages = apply {
                if (validated) {
                    return@apply
                }

                bookmarks()
                engagements()
                likes()
                quotes()
                replies()
                reposts()
                views()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (bookmarks.asKnown().isPresent) 1 else 0) +
                    (if (engagements.asKnown().isPresent) 1 else 0) +
                    (if (likes.asKnown().isPresent) 1 else 0) +
                    (if (quotes.asKnown().isPresent) 1 else 0) +
                    (if (replies.asKnown().isPresent) 1 else 0) +
                    (if (reposts.asKnown().isPresent) 1 else 0) +
                    (if (views.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Averages &&
                    bookmarks == other.bookmarks &&
                    engagements == other.engagements &&
                    likes == other.likes &&
                    quotes == other.quotes &&
                    replies == other.replies &&
                    reposts == other.reposts &&
                    views == other.views &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    bookmarks,
                    engagements,
                    likes,
                    quotes,
                    replies,
                    reposts,
                    views,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Averages{bookmarks=$bookmarks, engagements=$engagements, likes=$likes, quotes=$quotes, replies=$replies, reposts=$reposts, views=$views, additionalProperties=$additionalProperties}"
        }

        /** The recent posts the averages read. */
        class Sample
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val newestAt: JsonField<OffsetDateTime>,
            private val oldestAt: JsonField<OffsetDateTime>,
            private val posts: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("newestAt")
                @ExcludeMissing
                newestAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("oldestAt")
                @ExcludeMissing
                oldestAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("posts") @ExcludeMissing posts: JsonField<Double> = JsonMissing.of(),
            ) : this(newestAt, oldestAt, posts, mutableMapOf())

            /**
             * When the newest of them went up.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun newestAt(): Optional<OffsetDateTime> = newestAt.getOptional("newestAt")

            /**
             * When the oldest of them went up.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun oldestAt(): Optional<OffsetDateTime> = oldestAt.getOptional("oldestAt")

            /**
             * Posts read.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun posts(): Double = posts.getRequired("posts")

            /**
             * Returns the raw JSON value of [newestAt].
             *
             * Unlike [newestAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("newestAt")
            @ExcludeMissing
            fun _newestAt(): JsonField<OffsetDateTime> = newestAt

            /**
             * Returns the raw JSON value of [oldestAt].
             *
             * Unlike [oldestAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("oldestAt")
            @ExcludeMissing
            fun _oldestAt(): JsonField<OffsetDateTime> = oldestAt

            /**
             * Returns the raw JSON value of [posts].
             *
             * Unlike [posts], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("posts") @ExcludeMissing fun _posts(): JsonField<Double> = posts

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Sample].
                 *
                 * The following fields are required:
                 * ```java
                 * .newestAt()
                 * .oldestAt()
                 * .posts()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Sample]. */
            class Builder internal constructor() {

                private var newestAt: JsonField<OffsetDateTime>? = null
                private var oldestAt: JsonField<OffsetDateTime>? = null
                private var posts: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(sample: Sample) = apply {
                    newestAt = sample.newestAt
                    oldestAt = sample.oldestAt
                    posts = sample.posts
                    additionalProperties = sample.additionalProperties.toMutableMap()
                }

                /** When the newest of them went up. */
                fun newestAt(newestAt: OffsetDateTime?) = newestAt(JsonField.ofNullable(newestAt))

                /** Alias for calling [Builder.newestAt] with `newestAt.orElse(null)`. */
                fun newestAt(newestAt: Optional<OffsetDateTime>) = newestAt(newestAt.getOrNull())

                /** Sets [Builder.newestAt] to an arbitrary JSON value. */
                fun newestAt(newestAt: JsonField<OffsetDateTime>) = apply {
                    this.newestAt = newestAt
                }

                /** When the oldest of them went up. */
                fun oldestAt(oldestAt: OffsetDateTime?) = oldestAt(JsonField.ofNullable(oldestAt))

                /** Alias for calling [Builder.oldestAt] with `oldestAt.orElse(null)`. */
                fun oldestAt(oldestAt: Optional<OffsetDateTime>) = oldestAt(oldestAt.getOrNull())

                /** Sets [Builder.oldestAt] to an arbitrary JSON value. */
                fun oldestAt(oldestAt: JsonField<OffsetDateTime>) = apply {
                    this.oldestAt = oldestAt
                }

                /** Posts read. */
                fun posts(posts: Double) = posts(JsonField.of(posts))

                /** Sets [Builder.posts] to an arbitrary JSON value. */
                fun posts(posts: JsonField<Double>) = apply { this.posts = posts }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Sample].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .newestAt()
                 * .oldestAt()
                 * .posts()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Sample =
                    Sample(
                        checkRequired("newestAt", newestAt),
                        checkRequired("oldestAt", oldestAt),
                        checkRequired("posts", posts),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Sample = apply {
                if (validated) {
                    return@apply
                }

                newestAt()
                oldestAt()
                posts()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (newestAt.asKnown().isPresent) 1 else 0) +
                    (if (oldestAt.asKnown().isPresent) 1 else 0) +
                    (if (posts.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Sample &&
                    newestAt == other.newestAt &&
                    oldestAt == other.oldestAt &&
                    posts == other.posts &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(newestAt, oldestAt, posts, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Sample{newestAt=$newestAt, oldestAt=$oldestAt, posts=$posts, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Insights &&
                accountAgeDays == other.accountAgeDays &&
                averages == other.averages &&
                engagementPerView == other.engagementPerView &&
                engagementRate == other.engagementRate &&
                followers == other.followers &&
                following == other.following &&
                posts == other.posts &&
                postsPerDay == other.postsPerDay &&
                postsPrivate == other.postsPrivate &&
                sample == other.sample &&
                topPostId == other.topPostId &&
                userId == other.userId &&
                userName == other.userName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                accountAgeDays,
                averages,
                engagementPerView,
                engagementRate,
                followers,
                following,
                posts,
                postsPerDay,
                postsPrivate,
                sample,
                topPostId,
                userId,
                userName,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Insights{accountAgeDays=$accountAgeDays, averages=$averages, engagementPerView=$engagementPerView, engagementRate=$engagementRate, followers=$followers, following=$following, posts=$posts, postsPerDay=$postsPerDay, postsPrivate=$postsPrivate, sample=$sample, topPostId=$topPostId, userId=$userId, userName=$userName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveInsightsResponse &&
            insights == other.insights &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(insights, message, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveInsightsResponse{insights=$insights, message=$message, additionalProperties=$additionalProperties}"
}
