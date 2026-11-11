// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Report on the followers read. Classes rest on public profile signals, so they say what a profile
 * looks like, never who runs it.
 */
class FollowerAudit
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val account: JsonField<UserRetrieveInsightsResponse.Insights>,
    private val coverage: JsonField<Coverage>,
    private val quality: JsonField<Quality>,
    private val classes: JsonField<List<ClassCount>>,
    private val signals: JsonField<List<Signal>>,
    private val arrivalBands: JsonField<List<ArrivalBand>>,
    private val cohorts: JsonField<List<Cohort>>,
    private val languages: JsonField<List<FollowerValueCount>>,
    private val places: JsonField<List<FollowerValueCount>>,
    private val verified: JsonField<Verified>,
    private val followers: JsonField<List<AuditedFollower>>,
    private val topFollowers: JsonField<List<AuditedFollower>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account")
        @ExcludeMissing
        account: JsonField<UserRetrieveInsightsResponse.Insights> = JsonMissing.of(),
        @JsonProperty("coverage") @ExcludeMissing coverage: JsonField<Coverage> = JsonMissing.of(),
        @JsonProperty("quality") @ExcludeMissing quality: JsonField<Quality> = JsonMissing.of(),
        @JsonProperty("classes")
        @ExcludeMissing
        classes: JsonField<List<ClassCount>> = JsonMissing.of(),
        @JsonProperty("signals")
        @ExcludeMissing
        signals: JsonField<List<Signal>> = JsonMissing.of(),
        @JsonProperty("arrivalBands")
        @ExcludeMissing
        arrivalBands: JsonField<List<ArrivalBand>> = JsonMissing.of(),
        @JsonProperty("cohorts")
        @ExcludeMissing
        cohorts: JsonField<List<Cohort>> = JsonMissing.of(),
        @JsonProperty("languages")
        @ExcludeMissing
        languages: JsonField<List<FollowerValueCount>> = JsonMissing.of(),
        @JsonProperty("places")
        @ExcludeMissing
        places: JsonField<List<FollowerValueCount>> = JsonMissing.of(),
        @JsonProperty("verified") @ExcludeMissing verified: JsonField<Verified> = JsonMissing.of(),
        @JsonProperty("followers")
        @ExcludeMissing
        followers: JsonField<List<AuditedFollower>> = JsonMissing.of(),
        @JsonProperty("topFollowers")
        @ExcludeMissing
        topFollowers: JsonField<List<AuditedFollower>> = JsonMissing.of(),
    ) : this(
        account,
        coverage,
        quality,
        classes,
        signals,
        arrivalBands,
        cohorts,
        languages,
        places,
        verified,
        followers,
        topFollowers,
        mutableMapOf(),
    )

    /**
     * Engagement insights of 1 profile. Engagements are likes, replies, reposts and quotes. A rate
     * is null when nothing divides it, such as a profile without posts of its own.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun account(): UserRetrieveInsightsResponse.Insights = account.getRequired("account")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun coverage(): Coverage = coverage.getRequired("coverage")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun quality(): Quality = quality.getRequired("quality")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun classes(): List<ClassCount> = classes.getRequired("classes")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun signals(): List<Signal> = signals.getRequired("signals")

    /**
     * Likely fake share by position in the newest-first list.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun arrivalBands(): List<ArrivalBand> = arrivalBands.getRequired("arrivalBands")

    /**
     * Followers who joined X in the same UTC week.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun cohorts(): List<Cohort> = cohorts.getRequired("cohorts")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun languages(): List<FollowerValueCount> = languages.getRequired("languages")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun places(): List<FollowerValueCount> = places.getRequired("places")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun verified(): Verified = verified.getRequired("verified")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun followers(): List<AuditedFollower> = followers.getRequired("followers")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun topFollowers(): List<AuditedFollower> = topFollowers.getRequired("topFollowers")

    /**
     * Returns the raw JSON value of [account].
     *
     * Unlike [account], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account")
    @ExcludeMissing
    fun _account(): JsonField<UserRetrieveInsightsResponse.Insights> = account

    /**
     * Returns the raw JSON value of [coverage].
     *
     * Unlike [coverage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("coverage") @ExcludeMissing fun _coverage(): JsonField<Coverage> = coverage

    /**
     * Returns the raw JSON value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Quality> = quality

    /**
     * Returns the raw JSON value of [classes].
     *
     * Unlike [classes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("classes") @ExcludeMissing fun _classes(): JsonField<List<ClassCount>> = classes

    /**
     * Returns the raw JSON value of [signals].
     *
     * Unlike [signals], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signals") @ExcludeMissing fun _signals(): JsonField<List<Signal>> = signals

    /**
     * Returns the raw JSON value of [arrivalBands].
     *
     * Unlike [arrivalBands], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("arrivalBands")
    @ExcludeMissing
    fun _arrivalBands(): JsonField<List<ArrivalBand>> = arrivalBands

    /**
     * Returns the raw JSON value of [cohorts].
     *
     * Unlike [cohorts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cohorts") @ExcludeMissing fun _cohorts(): JsonField<List<Cohort>> = cohorts

    /**
     * Returns the raw JSON value of [languages].
     *
     * Unlike [languages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("languages")
    @ExcludeMissing
    fun _languages(): JsonField<List<FollowerValueCount>> = languages

    /**
     * Returns the raw JSON value of [places].
     *
     * Unlike [places], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("places")
    @ExcludeMissing
    fun _places(): JsonField<List<FollowerValueCount>> = places

    /**
     * Returns the raw JSON value of [verified].
     *
     * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Verified> = verified

    /**
     * Returns the raw JSON value of [followers].
     *
     * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("followers")
    @ExcludeMissing
    fun _followers(): JsonField<List<AuditedFollower>> = followers

    /**
     * Returns the raw JSON value of [topFollowers].
     *
     * Unlike [topFollowers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topFollowers")
    @ExcludeMissing
    fun _topFollowers(): JsonField<List<AuditedFollower>> = topFollowers

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
         * Returns a mutable builder for constructing an instance of [FollowerAudit].
         *
         * The following fields are required:
         * ```java
         * .account()
         * .coverage()
         * .quality()
         * .classes()
         * .signals()
         * .arrivalBands()
         * .cohorts()
         * .languages()
         * .places()
         * .verified()
         * .followers()
         * .topFollowers()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FollowerAudit]. */
    class Builder internal constructor() {

        private var account: JsonField<UserRetrieveInsightsResponse.Insights>? = null
        private var coverage: JsonField<Coverage>? = null
        private var quality: JsonField<Quality>? = null
        private var classes: JsonField<MutableList<ClassCount>>? = null
        private var signals: JsonField<MutableList<Signal>>? = null
        private var arrivalBands: JsonField<MutableList<ArrivalBand>>? = null
        private var cohorts: JsonField<MutableList<Cohort>>? = null
        private var languages: JsonField<MutableList<FollowerValueCount>>? = null
        private var places: JsonField<MutableList<FollowerValueCount>>? = null
        private var verified: JsonField<Verified>? = null
        private var followers: JsonField<MutableList<AuditedFollower>>? = null
        private var topFollowers: JsonField<MutableList<AuditedFollower>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(followerAudit: FollowerAudit) = apply {
            account = followerAudit.account
            coverage = followerAudit.coverage
            quality = followerAudit.quality
            classes = followerAudit.classes.map { it.toMutableList() }
            signals = followerAudit.signals.map { it.toMutableList() }
            arrivalBands = followerAudit.arrivalBands.map { it.toMutableList() }
            cohorts = followerAudit.cohorts.map { it.toMutableList() }
            languages = followerAudit.languages.map { it.toMutableList() }
            places = followerAudit.places.map { it.toMutableList() }
            verified = followerAudit.verified
            followers = followerAudit.followers.map { it.toMutableList() }
            topFollowers = followerAudit.topFollowers.map { it.toMutableList() }
            additionalProperties = followerAudit.additionalProperties.toMutableMap()
        }

        /**
         * Engagement insights of 1 profile. Engagements are likes, replies, reposts and quotes. A
         * rate is null when nothing divides it, such as a profile without posts of its own.
         */
        fun account(account: UserRetrieveInsightsResponse.Insights) = account(JsonField.of(account))

        /** Sets [Builder.account] to an arbitrary JSON value. */
        fun account(account: JsonField<UserRetrieveInsightsResponse.Insights>) = apply {
            this.account = account
        }

        fun coverage(coverage: Coverage) = coverage(JsonField.of(coverage))

        /** Sets [Builder.coverage] to an arbitrary JSON value. */
        fun coverage(coverage: JsonField<Coverage>) = apply { this.coverage = coverage }

        fun quality(quality: Quality) = quality(JsonField.of(quality))

        /** Sets [Builder.quality] to an arbitrary JSON value. */
        fun quality(quality: JsonField<Quality>) = apply { this.quality = quality }

        fun classes(classes: List<ClassCount>) = classes(JsonField.of(classes))

        /** Sets [Builder.classes] to an arbitrary JSON value. */
        fun classes(classes: JsonField<List<ClassCount>>) = apply {
            this.classes = classes.map { it.toMutableList() }
        }

        /**
         * Adds a single [ClassCount] to [classes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addClass(class_: ClassCount) = apply {
            classes =
                (classes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("classes", it).add(class_)
                }
        }

        fun signals(signals: List<Signal>) = signals(JsonField.of(signals))

        /** Sets [Builder.signals] to an arbitrary JSON value. */
        fun signals(signals: JsonField<List<Signal>>) = apply {
            this.signals = signals.map { it.toMutableList() }
        }

        /**
         * Adds a single [Signal] to [signals].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSignal(signal: Signal) = apply {
            signals =
                (signals ?: JsonField.of(mutableListOf())).also {
                    checkKnown("signals", it).add(signal)
                }
        }

        /** Likely fake share by position in the newest-first list. */
        fun arrivalBands(arrivalBands: List<ArrivalBand>) = arrivalBands(JsonField.of(arrivalBands))

        /** Sets [Builder.arrivalBands] to an arbitrary JSON value. */
        fun arrivalBands(arrivalBands: JsonField<List<ArrivalBand>>) = apply {
            this.arrivalBands = arrivalBands.map { it.toMutableList() }
        }

        /**
         * Adds a single [ArrivalBand] to [arrivalBands].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addArrivalBand(arrivalBand: ArrivalBand) = apply {
            arrivalBands =
                (arrivalBands ?: JsonField.of(mutableListOf())).also {
                    checkKnown("arrivalBands", it).add(arrivalBand)
                }
        }

        /** Followers who joined X in the same UTC week. */
        fun cohorts(cohorts: List<Cohort>) = cohorts(JsonField.of(cohorts))

        /** Sets [Builder.cohorts] to an arbitrary JSON value. */
        fun cohorts(cohorts: JsonField<List<Cohort>>) = apply {
            this.cohorts = cohorts.map { it.toMutableList() }
        }

        /**
         * Adds a single [Cohort] to [cohorts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCohort(cohort: Cohort) = apply {
            cohorts =
                (cohorts ?: JsonField.of(mutableListOf())).also {
                    checkKnown("cohorts", it).add(cohort)
                }
        }

        fun languages(languages: List<FollowerValueCount>) = languages(JsonField.of(languages))

        /** Sets [Builder.languages] to an arbitrary JSON value. */
        fun languages(languages: JsonField<List<FollowerValueCount>>) = apply {
            this.languages = languages.map { it.toMutableList() }
        }

        /**
         * Adds a single [FollowerValueCount] to [languages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLanguage(language: FollowerValueCount) = apply {
            languages =
                (languages ?: JsonField.of(mutableListOf())).also {
                    checkKnown("languages", it).add(language)
                }
        }

        fun places(places: List<FollowerValueCount>) = places(JsonField.of(places))

        /** Sets [Builder.places] to an arbitrary JSON value. */
        fun places(places: JsonField<List<FollowerValueCount>>) = apply {
            this.places = places.map { it.toMutableList() }
        }

        /**
         * Adds a single [FollowerValueCount] to [places].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPlace(place: FollowerValueCount) = apply {
            places =
                (places ?: JsonField.of(mutableListOf())).also {
                    checkKnown("places", it).add(place)
                }
        }

        fun verified(verified: Verified) = verified(JsonField.of(verified))

        /** Sets [Builder.verified] to an arbitrary JSON value. */
        fun verified(verified: JsonField<Verified>) = apply { this.verified = verified }

        fun followers(followers: List<AuditedFollower>) = followers(JsonField.of(followers))

        /** Sets [Builder.followers] to an arbitrary JSON value. */
        fun followers(followers: JsonField<List<AuditedFollower>>) = apply {
            this.followers = followers.map { it.toMutableList() }
        }

        /**
         * Adds a single [AuditedFollower] to [followers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFollower(follower: AuditedFollower) = apply {
            followers =
                (followers ?: JsonField.of(mutableListOf())).also {
                    checkKnown("followers", it).add(follower)
                }
        }

        fun topFollowers(topFollowers: List<AuditedFollower>) =
            topFollowers(JsonField.of(topFollowers))

        /** Sets [Builder.topFollowers] to an arbitrary JSON value. */
        fun topFollowers(topFollowers: JsonField<List<AuditedFollower>>) = apply {
            this.topFollowers = topFollowers.map { it.toMutableList() }
        }

        /**
         * Adds a single [AuditedFollower] to [topFollowers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTopFollower(topFollower: AuditedFollower) = apply {
            topFollowers =
                (topFollowers ?: JsonField.of(mutableListOf())).also {
                    checkKnown("topFollowers", it).add(topFollower)
                }
        }

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
         * Returns an immutable instance of [FollowerAudit].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .account()
         * .coverage()
         * .quality()
         * .classes()
         * .signals()
         * .arrivalBands()
         * .cohorts()
         * .languages()
         * .places()
         * .verified()
         * .followers()
         * .topFollowers()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FollowerAudit =
            FollowerAudit(
                checkRequired("account", account),
                checkRequired("coverage", coverage),
                checkRequired("quality", quality),
                checkRequired("classes", classes).map { it.toImmutable() },
                checkRequired("signals", signals).map { it.toImmutable() },
                checkRequired("arrivalBands", arrivalBands).map { it.toImmutable() },
                checkRequired("cohorts", cohorts).map { it.toImmutable() },
                checkRequired("languages", languages).map { it.toImmutable() },
                checkRequired("places", places).map { it.toImmutable() },
                checkRequired("verified", verified),
                checkRequired("followers", followers).map { it.toImmutable() },
                checkRequired("topFollowers", topFollowers).map { it.toImmutable() },
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
    fun validate(): FollowerAudit = apply {
        if (validated) {
            return@apply
        }

        account().validate()
        coverage().validate()
        quality().validate()
        classes().forEach { it.validate() }
        signals().forEach { it.validate() }
        arrivalBands().forEach { it.validate() }
        cohorts().forEach { it.validate() }
        languages().forEach { it.validate() }
        places().forEach { it.validate() }
        verified().validate()
        followers().forEach { it.validate() }
        topFollowers().forEach { it.validate() }
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
        (account.asKnown().getOrNull()?.validity() ?: 0) +
            (coverage.asKnown().getOrNull()?.validity() ?: 0) +
            (quality.asKnown().getOrNull()?.validity() ?: 0) +
            (classes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (signals.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (arrivalBands.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (cohorts.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (languages.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (places.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (verified.asKnown().getOrNull()?.validity() ?: 0) +
            (followers.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (topFollowers.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    class Coverage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val percent: JsonField<Double>,
        private val read: JsonField<Long>,
        private val total: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("read") @ExcludeMissing read: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        ) : this(percent, read, total, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun read(): Long = read.getRequired("read")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun total(): Long = total.getRequired("total")

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

        /**
         * Returns the raw JSON value of [read].
         *
         * Unlike [read], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("read") @ExcludeMissing fun _read(): JsonField<Long> = read

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
             * Returns a mutable builder for constructing an instance of [Coverage].
             *
             * The following fields are required:
             * ```java
             * .percent()
             * .read()
             * .total()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Coverage]. */
        class Builder internal constructor() {

            private var percent: JsonField<Double>? = null
            private var read: JsonField<Long>? = null
            private var total: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(coverage: Coverage) = apply {
                percent = coverage.percent
                read = coverage.read
                total = coverage.total
                additionalProperties = coverage.additionalProperties.toMutableMap()
            }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

            fun read(read: Long) = read(JsonField.of(read))

            /** Sets [Builder.read] to an arbitrary JSON value. */
            fun read(read: JsonField<Long>) = apply { this.read = read }

            fun total(total: Long) = total(JsonField.of(total))

            /** Sets [Builder.total] to an arbitrary JSON value. */
            fun total(total: JsonField<Long>) = apply { this.total = total }

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
             * Returns an immutable instance of [Coverage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .percent()
             * .read()
             * .total()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Coverage =
                Coverage(
                    checkRequired("percent", percent),
                    checkRequired("read", read),
                    checkRequired("total", total),
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
        fun validate(): Coverage = apply {
            if (validated) {
                return@apply
            }

            percent()
            read()
            total()
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
            (if (percent.asKnown().isPresent) 1 else 0) +
                (if (read.asKnown().isPresent) 1 else 0) +
                (if (total.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Coverage &&
                percent == other.percent &&
                read == other.read &&
                total == other.total &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(percent, read, total, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Coverage{percent=$percent, read=$read, total=$total, additionalProperties=$additionalProperties}"
    }

    class Quality
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val grade: JsonField<Grade>,
        private val score: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("grade") @ExcludeMissing grade: JsonField<Grade> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Long> = JsonMissing.of(),
        ) : this(grade, score, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun grade(): Grade = grade.getRequired("grade")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun score(): Long = score.getRequired("score")

        /**
         * Returns the raw JSON value of [grade].
         *
         * Unlike [grade], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("grade") @ExcludeMissing fun _grade(): JsonField<Grade> = grade

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Long> = score

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
             * Returns a mutable builder for constructing an instance of [Quality].
             *
             * The following fields are required:
             * ```java
             * .grade()
             * .score()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Quality]. */
        class Builder internal constructor() {

            private var grade: JsonField<Grade>? = null
            private var score: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(quality: Quality) = apply {
                grade = quality.grade
                score = quality.score
                additionalProperties = quality.additionalProperties.toMutableMap()
            }

            fun grade(grade: Grade) = grade(JsonField.of(grade))

            /** Sets [Builder.grade] to an arbitrary JSON value. */
            fun grade(grade: JsonField<Grade>) = apply { this.grade = grade }

            fun score(score: Long) = score(JsonField.of(score))

            /** Sets [Builder.score] to an arbitrary JSON value. */
            fun score(score: JsonField<Long>) = apply { this.score = score }

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
             * Returns an immutable instance of [Quality].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .grade()
             * .score()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Quality =
                Quality(
                    checkRequired("grade", grade),
                    checkRequired("score", score),
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
        fun validate(): Quality = apply {
            if (validated) {
                return@apply
            }

            grade().validate()
            score()
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
            (grade.asKnown().getOrNull()?.validity() ?: 0) +
                (if (score.asKnown().isPresent) 1 else 0)

        class Grade @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val A = of("A")

                @JvmField val B = of("B")

                @JvmField val C = of("C")

                @JvmField val D = of("D")

                @JvmField val F = of("F")

                @JvmStatic fun of(value: String) = Grade(JsonField.of(value))
            }

            /** An enum containing [Grade]'s known values. */
            enum class Known {
                A,
                B,
                C,
                D,
                F,
            }

            /** An enum containing [Grade]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                A,
                B,
                C,
                D,
                F,
                /**
                 * An enum member indicating that [Grade] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if unknown.
             */
            fun value(): Value =
                when (this) {
                    A -> Value.A
                    B -> Value.B
                    C -> Value.C
                    D -> Value.D
                    F -> Value.F
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    A -> Known.A
                    B -> Known.B
                    C -> Known.C
                    D -> Known.D
                    F -> Known.F
                    else -> throw XTwitterScraperInvalidDataException("Unknown Grade: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /** Validates that this value is a known member. */
            fun validate(): Grade = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Grade && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Quality &&
                grade == other.grade &&
                score == other.score &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(grade, score, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Quality{grade=$grade, score=$score, additionalProperties=$additionalProperties}"
    }

    class ClassCount
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val class_: JsonField<FollowerClass>,
        private val count: JsonField<Long>,
        private val percent: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("class")
            @ExcludeMissing
            class_: JsonField<FollowerClass> = JsonMissing.of(),
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
        ) : this(class_, count, percent, mutableMapOf())

        /**
         * What 1 follower looks like from its public profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun class_(): FollowerClass = class_.getRequired("class")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * Returns the raw JSON value of [class_].
         *
         * Unlike [class_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("class") @ExcludeMissing fun _class_(): JsonField<FollowerClass> = class_

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

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
             * Returns a mutable builder for constructing an instance of [ClassCount].
             *
             * The following fields are required:
             * ```java
             * .class_()
             * .count()
             * .percent()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClassCount]. */
        class Builder internal constructor() {

            private var class_: JsonField<FollowerClass>? = null
            private var count: JsonField<Long>? = null
            private var percent: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(classCount: ClassCount) = apply {
                class_ = classCount.class_
                count = classCount.count
                percent = classCount.percent
                additionalProperties = classCount.additionalProperties.toMutableMap()
            }

            /** What 1 follower looks like from its public profile. */
            fun class_(class_: FollowerClass) = class_(JsonField.of(class_))

            /** Sets [Builder.class_] to an arbitrary JSON value. */
            fun class_(class_: JsonField<FollowerClass>) = apply { this.class_ = class_ }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

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
             * Returns an immutable instance of [ClassCount].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .class_()
             * .count()
             * .percent()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ClassCount =
                ClassCount(
                    checkRequired("class_", class_),
                    checkRequired("count", count),
                    checkRequired("percent", percent),
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
        fun validate(): ClassCount = apply {
            if (validated) {
                return@apply
            }

            class_().validate()
            count()
            percent()
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
            (class_.asKnown().getOrNull()?.validity() ?: 0) +
                (if (count.asKnown().isPresent) 1 else 0) +
                (if (percent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClassCount &&
                class_ == other.class_ &&
                count == other.count &&
                percent == other.percent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(class_, count, percent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClassCount{class_=$class_, count=$count, percent=$percent, additionalProperties=$additionalProperties}"
    }

    class Signal
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val id: JsonField<String>,
        private val percent: JsonField<Double>,
        private val points: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("points") @ExcludeMissing points: JsonField<Long> = JsonMissing.of(),
        ) : this(count, id, percent, points, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun points(): Long = points.getRequired("points")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

        /**
         * Returns the raw JSON value of [points].
         *
         * Unlike [points], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("points") @ExcludeMissing fun _points(): JsonField<Long> = points

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
             * Returns a mutable builder for constructing an instance of [Signal].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .id()
             * .percent()
             * .points()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Signal]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var id: JsonField<String>? = null
            private var percent: JsonField<Double>? = null
            private var points: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(signal: Signal) = apply {
                count = signal.count
                id = signal.id
                percent = signal.percent
                points = signal.points
                additionalProperties = signal.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

            fun points(points: Long) = points(JsonField.of(points))

            /** Sets [Builder.points] to an arbitrary JSON value. */
            fun points(points: JsonField<Long>) = apply { this.points = points }

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
             * Returns an immutable instance of [Signal].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .id()
             * .percent()
             * .points()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Signal =
                Signal(
                    checkRequired("count", count),
                    checkRequired("id", id),
                    checkRequired("percent", percent),
                    checkRequired("points", points),
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
        fun validate(): Signal = apply {
            if (validated) {
                return@apply
            }

            count()
            id()
            percent()
            points()
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
            (if (count.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (percent.asKnown().isPresent) 1 else 0) +
                (if (points.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Signal &&
                count == other.count &&
                id == other.id &&
                percent == other.percent &&
                points == other.points &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(count, id, percent, points, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Signal{count=$count, id=$id, percent=$percent, points=$points, additionalProperties=$additionalProperties}"
    }

    class ArrivalBand
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val from: JsonField<Long>,
        private val percent: JsonField<Double>,
        private val read: JsonField<Long>,
        private val to: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("read") @ExcludeMissing read: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<Long> = JsonMissing.of(),
        ) : this(count, from, percent, read, to, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun from(): Long = from.getRequired("from")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun read(): Long = read.getRequired("read")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun to(): Long = to.getRequired("to")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [from].
         *
         * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<Long> = from

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

        /**
         * Returns the raw JSON value of [read].
         *
         * Unlike [read], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("read") @ExcludeMissing fun _read(): JsonField<Long> = read

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<Long> = to

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
             * Returns a mutable builder for constructing an instance of [ArrivalBand].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .from()
             * .percent()
             * .read()
             * .to()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ArrivalBand]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var from: JsonField<Long>? = null
            private var percent: JsonField<Double>? = null
            private var read: JsonField<Long>? = null
            private var to: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(arrivalBand: ArrivalBand) = apply {
                count = arrivalBand.count
                from = arrivalBand.from
                percent = arrivalBand.percent
                read = arrivalBand.read
                to = arrivalBand.to
                additionalProperties = arrivalBand.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun from(from: Long) = from(JsonField.of(from))

            /** Sets [Builder.from] to an arbitrary JSON value. */
            fun from(from: JsonField<Long>) = apply { this.from = from }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

            fun read(read: Long) = read(JsonField.of(read))

            /** Sets [Builder.read] to an arbitrary JSON value. */
            fun read(read: JsonField<Long>) = apply { this.read = read }

            fun to(to: Long) = to(JsonField.of(to))

            /** Sets [Builder.to] to an arbitrary JSON value. */
            fun to(to: JsonField<Long>) = apply { this.to = to }

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
             * Returns an immutable instance of [ArrivalBand].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .from()
             * .percent()
             * .read()
             * .to()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ArrivalBand =
                ArrivalBand(
                    checkRequired("count", count),
                    checkRequired("from", from),
                    checkRequired("percent", percent),
                    checkRequired("read", read),
                    checkRequired("to", to),
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
        fun validate(): ArrivalBand = apply {
            if (validated) {
                return@apply
            }

            count()
            from()
            percent()
            read()
            to()
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
            (if (count.asKnown().isPresent) 1 else 0) +
                (if (from.asKnown().isPresent) 1 else 0) +
                (if (percent.asKnown().isPresent) 1 else 0) +
                (if (read.asKnown().isPresent) 1 else 0) +
                (if (to.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ArrivalBand &&
                count == other.count &&
                from == other.from &&
                percent == other.percent &&
                read == other.read &&
                to == other.to &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(count, from, percent, read, to, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ArrivalBand{count=$count, from=$from, percent=$percent, read=$read, to=$to, additionalProperties=$additionalProperties}"
    }

    class Cohort
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val likelyFake: JsonField<Long>,
        private val percent: JsonField<Double>,
        private val weekStartMs: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("likelyFake")
            @ExcludeMissing
            likelyFake: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("weekStartMs")
            @ExcludeMissing
            weekStartMs: JsonField<Long> = JsonMissing.of(),
        ) : this(count, likelyFake, percent, weekStartMs, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun likelyFake(): Long = likelyFake.getRequired("likelyFake")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun weekStartMs(): Long = weekStartMs.getRequired("weekStartMs")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [likelyFake].
         *
         * Unlike [likelyFake], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likelyFake") @ExcludeMissing fun _likelyFake(): JsonField<Long> = likelyFake

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

        /**
         * Returns the raw JSON value of [weekStartMs].
         *
         * Unlike [weekStartMs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("weekStartMs")
        @ExcludeMissing
        fun _weekStartMs(): JsonField<Long> = weekStartMs

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
             * Returns a mutable builder for constructing an instance of [Cohort].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .likelyFake()
             * .percent()
             * .weekStartMs()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Cohort]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var likelyFake: JsonField<Long>? = null
            private var percent: JsonField<Double>? = null
            private var weekStartMs: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cohort: Cohort) = apply {
                count = cohort.count
                likelyFake = cohort.likelyFake
                percent = cohort.percent
                weekStartMs = cohort.weekStartMs
                additionalProperties = cohort.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun likelyFake(likelyFake: Long) = likelyFake(JsonField.of(likelyFake))

            /** Sets [Builder.likelyFake] to an arbitrary JSON value. */
            fun likelyFake(likelyFake: JsonField<Long>) = apply { this.likelyFake = likelyFake }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

            fun weekStartMs(weekStartMs: Long) = weekStartMs(JsonField.of(weekStartMs))

            /** Sets [Builder.weekStartMs] to an arbitrary JSON value. */
            fun weekStartMs(weekStartMs: JsonField<Long>) = apply { this.weekStartMs = weekStartMs }

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
             * Returns an immutable instance of [Cohort].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .likelyFake()
             * .percent()
             * .weekStartMs()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Cohort =
                Cohort(
                    checkRequired("count", count),
                    checkRequired("likelyFake", likelyFake),
                    checkRequired("percent", percent),
                    checkRequired("weekStartMs", weekStartMs),
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
        fun validate(): Cohort = apply {
            if (validated) {
                return@apply
            }

            count()
            likelyFake()
            percent()
            weekStartMs()
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
            (if (count.asKnown().isPresent) 1 else 0) +
                (if (likelyFake.asKnown().isPresent) 1 else 0) +
                (if (percent.asKnown().isPresent) 1 else 0) +
                (if (weekStartMs.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cohort &&
                count == other.count &&
                likelyFake == other.likelyFake &&
                percent == other.percent &&
                weekStartMs == other.weekStartMs &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(count, likelyFake, percent, weekStartMs, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Cohort{count=$count, likelyFake=$likelyFake, percent=$percent, weekStartMs=$weekStartMs, additionalProperties=$additionalProperties}"
    }

    /** How many followers share 1 value, such as a language or place. */
    class FollowerValueCount
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val percent: JsonField<Double>,
        private val value: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
        ) : this(count, percent, value, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun value(): String = value.getRequired("value")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
             * Returns a mutable builder for constructing an instance of [FollowerValueCount].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .percent()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FollowerValueCount]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var percent: JsonField<Double>? = null
            private var value: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(followerValueCount: FollowerValueCount) = apply {
                count = followerValueCount.count
                percent = followerValueCount.percent
                value = followerValueCount.value
                additionalProperties = followerValueCount.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

            fun value(value: String) = value(JsonField.of(value))

            /** Sets [Builder.value] to an arbitrary JSON value. */
            fun value(value: JsonField<String>) = apply { this.value = value }

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
             * Returns an immutable instance of [FollowerValueCount].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .percent()
             * .value()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FollowerValueCount =
                FollowerValueCount(
                    checkRequired("count", count),
                    checkRequired("percent", percent),
                    checkRequired("value", value),
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
        fun validate(): FollowerValueCount = apply {
            if (validated) {
                return@apply
            }

            count()
            percent()
            value()
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
            (if (count.asKnown().isPresent) 1 else 0) +
                (if (percent.asKnown().isPresent) 1 else 0) +
                (if (value.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FollowerValueCount &&
                count == other.count &&
                percent == other.percent &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(count, percent, value, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FollowerValueCount{count=$count, percent=$percent, value=$value, additionalProperties=$additionalProperties}"
    }

    class Verified
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val percent: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("percent") @ExcludeMissing percent: JsonField<Double> = JsonMissing.of(),
        ) : this(count, percent, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun percent(): Double = percent.getRequired("percent")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [percent].
         *
         * Unlike [percent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("percent") @ExcludeMissing fun _percent(): JsonField<Double> = percent

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
             * Returns a mutable builder for constructing an instance of [Verified].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .percent()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Verified]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var percent: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(verified: Verified) = apply {
                count = verified.count
                percent = verified.percent
                additionalProperties = verified.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun percent(percent: Double) = percent(JsonField.of(percent))

            /** Sets [Builder.percent] to an arbitrary JSON value. */
            fun percent(percent: JsonField<Double>) = apply { this.percent = percent }

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
             * Returns an immutable instance of [Verified].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .percent()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Verified =
                Verified(
                    checkRequired("count", count),
                    checkRequired("percent", percent),
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
        fun validate(): Verified = apply {
            if (validated) {
                return@apply
            }

            count()
            percent()
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
            (if (count.asKnown().isPresent) 1 else 0) + (if (percent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Verified &&
                count == other.count &&
                percent == other.percent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(count, percent, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Verified{count=$count, percent=$percent, additionalProperties=$additionalProperties}"
    }

    /** 1 follower the audit read, with its class, score & signals. */
    class AuditedFollower
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val class_: JsonField<FollowerClass>,
        private val followers: JsonField<Long>,
        private val following: JsonField<Long>,
        private val id: JsonField<String>,
        private val likes: JsonField<Long>,
        private val name: JsonField<String>,
        private val position: JsonField<Long>,
        private val posts: JsonField<Long>,
        private val score: JsonField<Long>,
        private val signals: JsonField<List<String>>,
        private val userName: JsonField<String>,
        private val joinedAtMs: JsonField<Long>,
        private val owner: JsonField<String>,
        private val pictureUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("class")
            @ExcludeMissing
            class_: JsonField<FollowerClass> = JsonMissing.of(),
            @JsonProperty("followers")
            @ExcludeMissing
            followers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("following")
            @ExcludeMissing
            following: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("likes") @ExcludeMissing likes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("position") @ExcludeMissing position: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("posts") @ExcludeMissing posts: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("signals")
            @ExcludeMissing
            signals: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("userName")
            @ExcludeMissing
            userName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("joinedAtMs")
            @ExcludeMissing
            joinedAtMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("owner") @ExcludeMissing owner: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pictureUrl")
            @ExcludeMissing
            pictureUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            class_,
            followers,
            following,
            id,
            likes,
            name,
            position,
            posts,
            score,
            signals,
            userName,
            joinedAtMs,
            owner,
            pictureUrl,
            mutableMapOf(),
        )

        /**
         * What 1 follower looks like from its public profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun class_(): FollowerClass = class_.getRequired("class")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun followers(): Long = followers.getRequired("followers")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun following(): Long = following.getRequired("following")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun likes(): Long = likes.getRequired("likes")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun position(): Long = position.getRequired("position")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun posts(): Long = posts.getRequired("posts")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun score(): Long = score.getRequired("score")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun signals(): List<String> = signals.getRequired("signals")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun userName(): String = userName.getRequired("userName")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun joinedAtMs(): Optional<Long> = joinedAtMs.getOptional("joinedAtMs")

        /**
         * Account that runs an automated follower, when X names it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun owner(): Optional<String> = owner.getOptional("owner")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun pictureUrl(): Optional<String> = pictureUrl.getOptional("pictureUrl")

        /**
         * Returns the raw JSON value of [class_].
         *
         * Unlike [class_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("class") @ExcludeMissing fun _class_(): JsonField<FollowerClass> = class_

        /**
         * Returns the raw JSON value of [followers].
         *
         * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

        /**
         * Returns the raw JSON value of [following].
         *
         * Unlike [following], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [likes].
         *
         * Unlike [likes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<Long> = likes

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [position].
         *
         * Unlike [position], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("position") @ExcludeMissing fun _position(): JsonField<Long> = position

        /**
         * Returns the raw JSON value of [posts].
         *
         * Unlike [posts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("posts") @ExcludeMissing fun _posts(): JsonField<Long> = posts

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Long> = score

        /**
         * Returns the raw JSON value of [signals].
         *
         * Unlike [signals], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("signals") @ExcludeMissing fun _signals(): JsonField<List<String>> = signals

        /**
         * Returns the raw JSON value of [userName].
         *
         * Unlike [userName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userName") @ExcludeMissing fun _userName(): JsonField<String> = userName

        /**
         * Returns the raw JSON value of [joinedAtMs].
         *
         * Unlike [joinedAtMs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("joinedAtMs") @ExcludeMissing fun _joinedAtMs(): JsonField<Long> = joinedAtMs

        /**
         * Returns the raw JSON value of [owner].
         *
         * Unlike [owner], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("owner") @ExcludeMissing fun _owner(): JsonField<String> = owner

        /**
         * Returns the raw JSON value of [pictureUrl].
         *
         * Unlike [pictureUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pictureUrl")
        @ExcludeMissing
        fun _pictureUrl(): JsonField<String> = pictureUrl

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
             * Returns a mutable builder for constructing an instance of [AuditedFollower].
             *
             * The following fields are required:
             * ```java
             * .class_()
             * .followers()
             * .following()
             * .id()
             * .likes()
             * .name()
             * .position()
             * .posts()
             * .score()
             * .signals()
             * .userName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AuditedFollower]. */
        class Builder internal constructor() {

            private var class_: JsonField<FollowerClass>? = null
            private var followers: JsonField<Long>? = null
            private var following: JsonField<Long>? = null
            private var id: JsonField<String>? = null
            private var likes: JsonField<Long>? = null
            private var name: JsonField<String>? = null
            private var position: JsonField<Long>? = null
            private var posts: JsonField<Long>? = null
            private var score: JsonField<Long>? = null
            private var signals: JsonField<MutableList<String>>? = null
            private var userName: JsonField<String>? = null
            private var joinedAtMs: JsonField<Long> = JsonMissing.of()
            private var owner: JsonField<String> = JsonMissing.of()
            private var pictureUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(auditedFollower: AuditedFollower) = apply {
                class_ = auditedFollower.class_
                followers = auditedFollower.followers
                following = auditedFollower.following
                id = auditedFollower.id
                likes = auditedFollower.likes
                name = auditedFollower.name
                position = auditedFollower.position
                posts = auditedFollower.posts
                score = auditedFollower.score
                signals = auditedFollower.signals.map { it.toMutableList() }
                userName = auditedFollower.userName
                joinedAtMs = auditedFollower.joinedAtMs
                owner = auditedFollower.owner
                pictureUrl = auditedFollower.pictureUrl
                additionalProperties = auditedFollower.additionalProperties.toMutableMap()
            }

            /** What 1 follower looks like from its public profile. */
            fun class_(class_: FollowerClass) = class_(JsonField.of(class_))

            /** Sets [Builder.class_] to an arbitrary JSON value. */
            fun class_(class_: JsonField<FollowerClass>) = apply { this.class_ = class_ }

            fun followers(followers: Long) = followers(JsonField.of(followers))

            /** Sets [Builder.followers] to an arbitrary JSON value. */
            fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

            fun following(following: Long) = following(JsonField.of(following))

            /** Sets [Builder.following] to an arbitrary JSON value. */
            fun following(following: JsonField<Long>) = apply { this.following = following }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun likes(likes: Long) = likes(JsonField.of(likes))

            /** Sets [Builder.likes] to an arbitrary JSON value. */
            fun likes(likes: JsonField<Long>) = apply { this.likes = likes }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun position(position: Long) = position(JsonField.of(position))

            /** Sets [Builder.position] to an arbitrary JSON value. */
            fun position(position: JsonField<Long>) = apply { this.position = position }

            fun posts(posts: Long) = posts(JsonField.of(posts))

            /** Sets [Builder.posts] to an arbitrary JSON value. */
            fun posts(posts: JsonField<Long>) = apply { this.posts = posts }

            fun score(score: Long) = score(JsonField.of(score))

            /** Sets [Builder.score] to an arbitrary JSON value. */
            fun score(score: JsonField<Long>) = apply { this.score = score }

            fun signals(signals: List<String>) = signals(JsonField.of(signals))

            /** Sets [Builder.signals] to an arbitrary JSON value. */
            fun signals(signals: JsonField<List<String>>) = apply {
                this.signals = signals.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [signals].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSignal(signal: String) = apply {
                signals =
                    (signals ?: JsonField.of(mutableListOf())).also {
                        checkKnown("signals", it).add(signal)
                    }
            }

            fun userName(userName: String) = userName(JsonField.of(userName))

            /** Sets [Builder.userName] to an arbitrary JSON value. */
            fun userName(userName: JsonField<String>) = apply { this.userName = userName }

            fun joinedAtMs(joinedAtMs: Long) = joinedAtMs(JsonField.of(joinedAtMs))

            /** Sets [Builder.joinedAtMs] to an arbitrary JSON value. */
            fun joinedAtMs(joinedAtMs: JsonField<Long>) = apply { this.joinedAtMs = joinedAtMs }

            /** Account that runs an automated follower, when X names it. */
            fun owner(owner: String) = owner(JsonField.of(owner))

            /** Sets [Builder.owner] to an arbitrary JSON value. */
            fun owner(owner: JsonField<String>) = apply { this.owner = owner }

            fun pictureUrl(pictureUrl: String) = pictureUrl(JsonField.of(pictureUrl))

            /** Sets [Builder.pictureUrl] to an arbitrary JSON value. */
            fun pictureUrl(pictureUrl: JsonField<String>) = apply { this.pictureUrl = pictureUrl }

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
             * Returns an immutable instance of [AuditedFollower].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .class_()
             * .followers()
             * .following()
             * .id()
             * .likes()
             * .name()
             * .position()
             * .posts()
             * .score()
             * .signals()
             * .userName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AuditedFollower =
                AuditedFollower(
                    checkRequired("class_", class_),
                    checkRequired("followers", followers),
                    checkRequired("following", following),
                    checkRequired("id", id),
                    checkRequired("likes", likes),
                    checkRequired("name", name),
                    checkRequired("position", position),
                    checkRequired("posts", posts),
                    checkRequired("score", score),
                    checkRequired("signals", signals).map { it.toImmutable() },
                    checkRequired("userName", userName),
                    joinedAtMs,
                    owner,
                    pictureUrl,
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
        fun validate(): AuditedFollower = apply {
            if (validated) {
                return@apply
            }

            class_().validate()
            followers()
            following()
            id()
            likes()
            name()
            position()
            posts()
            score()
            signals()
            userName()
            joinedAtMs()
            owner()
            pictureUrl()
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
            (class_.asKnown().getOrNull()?.validity() ?: 0) +
                (if (followers.asKnown().isPresent) 1 else 0) +
                (if (following.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (likes.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (position.asKnown().isPresent) 1 else 0) +
                (if (posts.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (signals.asKnown().getOrNull()?.size ?: 0) +
                (if (userName.asKnown().isPresent) 1 else 0) +
                (if (joinedAtMs.asKnown().isPresent) 1 else 0) +
                (if (owner.asKnown().isPresent) 1 else 0) +
                (if (pictureUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AuditedFollower &&
                class_ == other.class_ &&
                followers == other.followers &&
                following == other.following &&
                id == other.id &&
                likes == other.likes &&
                name == other.name &&
                position == other.position &&
                posts == other.posts &&
                score == other.score &&
                signals == other.signals &&
                userName == other.userName &&
                joinedAtMs == other.joinedAtMs &&
                owner == other.owner &&
                pictureUrl == other.pictureUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                class_,
                followers,
                following,
                id,
                likes,
                name,
                position,
                posts,
                score,
                signals,
                userName,
                joinedAtMs,
                owner,
                pictureUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AuditedFollower{class_=$class_, followers=$followers, following=$following, id=$id, likes=$likes, name=$name, position=$position, posts=$posts, score=$score, signals=$signals, userName=$userName, joinedAtMs=$joinedAtMs, owner=$owner, pictureUrl=$pictureUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FollowerAudit &&
            account == other.account &&
            coverage == other.coverage &&
            quality == other.quality &&
            classes == other.classes &&
            signals == other.signals &&
            arrivalBands == other.arrivalBands &&
            cohorts == other.cohorts &&
            languages == other.languages &&
            places == other.places &&
            verified == other.verified &&
            followers == other.followers &&
            topFollowers == other.topFollowers &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            account,
            coverage,
            quality,
            classes,
            signals,
            arrivalBands,
            cohorts,
            languages,
            places,
            verified,
            followers,
            topFollowers,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FollowerAudit{account=$account, coverage=$coverage, quality=$quality, classes=$classes, signals=$signals, arrivalBands=$arrivalBands, cohorts=$cohorts, languages=$languages, places=$places, verified=$verified, followers=$followers, topFollowers=$topFollowers, additionalProperties=$additionalProperties}"
}
