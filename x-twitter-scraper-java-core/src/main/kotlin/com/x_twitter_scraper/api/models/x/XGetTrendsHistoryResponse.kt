// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class XGetTrendsHistoryResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val fromTime: JsonField<OffsetDateTime>,
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val snapshots: JsonField<List<Snapshot>>,
    private val toTime: JsonField<OffsetDateTime>,
    private val woeid: JsonField<Long>,
    private val location: JsonField<Location>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("fromTime")
        @ExcludeMissing
        fromTime: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("snapshots")
        @ExcludeMissing
        snapshots: JsonField<List<Snapshot>> = JsonMissing.of(),
        @JsonProperty("toTime")
        @ExcludeMissing
        toTime: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("woeid") @ExcludeMissing woeid: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<Location> = JsonMissing.of(),
    ) : this(
        count,
        fromTime,
        hasNextPage,
        nextCursor,
        snapshots,
        toTime,
        woeid,
        location,
        mutableMapOf(),
    )

    /**
     * Lists returned & charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * Start of the range as Xquik read it. A span such as 7d shows here as the time it counted back
     * to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun fromTime(): OffsetDateTime = fromTime.getRequired("fromTime")

    /**
     * Whether the range holds more lists.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * Send it as cursor for the next lists. Empty on the last page.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * 1 stored list per step, oldest first. A step with no stored list is left out.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun snapshots(): List<Snapshot> = snapshots.getRequired("snapshots")

    /**
     * End of the range as Xquik read it, which the range leaves out. Without to, it is the time of
     * the first request.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun toTime(): OffsetDateTime = toTime.getRequired("toTime")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun woeid(): Long = woeid.getRequired("woeid")

    /**
     * The place the request named by country or location. Absent when it sent a woeid or named no
     * place.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun location(): Optional<Location> = location.getOptional("location")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [fromTime].
     *
     * Unlike [fromTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fromTime") @ExcludeMissing fun _fromTime(): JsonField<OffsetDateTime> = fromTime

    /**
     * Returns the raw JSON value of [hasNextPage].
     *
     * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_next_page")
    @ExcludeMissing
    fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [snapshots].
     *
     * Unlike [snapshots], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("snapshots")
    @ExcludeMissing
    fun _snapshots(): JsonField<List<Snapshot>> = snapshots

    /**
     * Returns the raw JSON value of [toTime].
     *
     * Unlike [toTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("toTime") @ExcludeMissing fun _toTime(): JsonField<OffsetDateTime> = toTime

    /**
     * Returns the raw JSON value of [woeid].
     *
     * Unlike [woeid], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("woeid") @ExcludeMissing fun _woeid(): JsonField<Long> = woeid

    /**
     * Returns the raw JSON value of [location].
     *
     * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<Location> = location

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
         * Returns a mutable builder for constructing an instance of [XGetTrendsHistoryResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .fromTime()
         * .hasNextPage()
         * .nextCursor()
         * .snapshots()
         * .toTime()
         * .woeid()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendsHistoryResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var fromTime: JsonField<OffsetDateTime>? = null
        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var snapshots: JsonField<MutableList<Snapshot>>? = null
        private var toTime: JsonField<OffsetDateTime>? = null
        private var woeid: JsonField<Long>? = null
        private var location: JsonField<Location> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetTrendsHistoryResponse: XGetTrendsHistoryResponse) = apply {
            count = xGetTrendsHistoryResponse.count
            fromTime = xGetTrendsHistoryResponse.fromTime
            hasNextPage = xGetTrendsHistoryResponse.hasNextPage
            nextCursor = xGetTrendsHistoryResponse.nextCursor
            snapshots = xGetTrendsHistoryResponse.snapshots.map { it.toMutableList() }
            toTime = xGetTrendsHistoryResponse.toTime
            woeid = xGetTrendsHistoryResponse.woeid
            location = xGetTrendsHistoryResponse.location
            additionalProperties = xGetTrendsHistoryResponse.additionalProperties.toMutableMap()
        }

        /** Lists returned & charged. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /**
         * Start of the range as Xquik read it. A span such as 7d shows here as the time it counted
         * back to.
         */
        fun fromTime(fromTime: OffsetDateTime) = fromTime(JsonField.of(fromTime))

        /** Sets [Builder.fromTime] to an arbitrary JSON value. */
        fun fromTime(fromTime: JsonField<OffsetDateTime>) = apply { this.fromTime = fromTime }

        /** Whether the range holds more lists. */
        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        /** Send it as cursor for the next lists. Empty on the last page. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        /** 1 stored list per step, oldest first. A step with no stored list is left out. */
        fun snapshots(snapshots: List<Snapshot>) = snapshots(JsonField.of(snapshots))

        /** Sets [Builder.snapshots] to an arbitrary JSON value. */
        fun snapshots(snapshots: JsonField<List<Snapshot>>) = apply {
            this.snapshots = snapshots.map { it.toMutableList() }
        }

        /**
         * Adds a single [Snapshot] to [snapshots].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSnapshot(snapshot: Snapshot) = apply {
            snapshots =
                (snapshots ?: JsonField.of(mutableListOf())).also {
                    checkKnown("snapshots", it).add(snapshot)
                }
        }

        /**
         * End of the range as Xquik read it, which the range leaves out. Without to, it is the time
         * of the first request.
         */
        fun toTime(toTime: OffsetDateTime) = toTime(JsonField.of(toTime))

        /** Sets [Builder.toTime] to an arbitrary JSON value. */
        fun toTime(toTime: JsonField<OffsetDateTime>) = apply { this.toTime = toTime }

        fun woeid(woeid: Long) = woeid(JsonField.of(woeid))

        /** Sets [Builder.woeid] to an arbitrary JSON value. */
        fun woeid(woeid: JsonField<Long>) = apply { this.woeid = woeid }

        /**
         * The place the request named by country or location. Absent when it sent a woeid or named
         * no place.
         */
        fun location(location: Location) = location(JsonField.of(location))

        /** Sets [Builder.location] to an arbitrary JSON value. */
        fun location(location: JsonField<Location>) = apply { this.location = location }

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
         * Returns an immutable instance of [XGetTrendsHistoryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .fromTime()
         * .hasNextPage()
         * .nextCursor()
         * .snapshots()
         * .toTime()
         * .woeid()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetTrendsHistoryResponse =
            XGetTrendsHistoryResponse(
                checkRequired("count", count),
                checkRequired("fromTime", fromTime),
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("snapshots", snapshots).map { it.toImmutable() },
                checkRequired("toTime", toTime),
                checkRequired("woeid", woeid),
                location,
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
    fun validate(): XGetTrendsHistoryResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        fromTime()
        hasNextPage()
        nextCursor()
        snapshots().forEach { it.validate() }
        toTime()
        woeid()
        location().ifPresent { it.validate() }
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
            (if (fromTime.asKnown().isPresent) 1 else 0) +
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (snapshots.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (toTime.asKnown().isPresent) 1 else 0) +
            (if (woeid.asKnown().isPresent) 1 else 0) +
            (location.asKnown().getOrNull()?.validity() ?: 0)

    class Snapshot
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val capturedAt: JsonField<OffsetDateTime>,
        private val count: JsonField<Long>,
        private val trends: JsonField<List<Trend>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("capturedAt")
            @ExcludeMissing
            capturedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("trends")
            @ExcludeMissing
            trends: JsonField<List<Trend>> = JsonMissing.of(),
        ) : this(capturedAt, count, trends, mutableMapOf())

        /**
         * When Xquik read this stored list from X. Xquik never estimates it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun capturedAt(): OffsetDateTime = capturedAt.getRequired("capturedAt")

        /**
         * Trends in this list.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun trends(): List<Trend> = trends.getRequired("trends")

        /**
         * Returns the raw JSON value of [capturedAt].
         *
         * Unlike [capturedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("capturedAt")
        @ExcludeMissing
        fun _capturedAt(): JsonField<OffsetDateTime> = capturedAt

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [trends].
         *
         * Unlike [trends], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("trends") @ExcludeMissing fun _trends(): JsonField<List<Trend>> = trends

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
             * Returns a mutable builder for constructing an instance of [Snapshot].
             *
             * The following fields are required:
             * ```java
             * .capturedAt()
             * .count()
             * .trends()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Snapshot]. */
        class Builder internal constructor() {

            private var capturedAt: JsonField<OffsetDateTime>? = null
            private var count: JsonField<Long>? = null
            private var trends: JsonField<MutableList<Trend>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(snapshot: Snapshot) = apply {
                capturedAt = snapshot.capturedAt
                count = snapshot.count
                trends = snapshot.trends.map { it.toMutableList() }
                additionalProperties = snapshot.additionalProperties.toMutableMap()
            }

            /** When Xquik read this stored list from X. Xquik never estimates it. */
            fun capturedAt(capturedAt: OffsetDateTime) = capturedAt(JsonField.of(capturedAt))

            /** Sets [Builder.capturedAt] to an arbitrary JSON value. */
            fun capturedAt(capturedAt: JsonField<OffsetDateTime>) = apply {
                this.capturedAt = capturedAt
            }

            /** Trends in this list. */
            fun count(count: Long) = count(JsonField.of(count))

            /** Sets [Builder.count] to an arbitrary JSON value. */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun trends(trends: List<Trend>) = trends(JsonField.of(trends))

            /** Sets [Builder.trends] to an arbitrary JSON value. */
            fun trends(trends: JsonField<List<Trend>>) = apply {
                this.trends = trends.map { it.toMutableList() }
            }

            /**
             * Adds a single [Trend] to [trends].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrend(trend: Trend) = apply {
                trends =
                    (trends ?: JsonField.of(mutableListOf())).also {
                        checkKnown("trends", it).add(trend)
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
             * Returns an immutable instance of [Snapshot].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .capturedAt()
             * .count()
             * .trends()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Snapshot =
                Snapshot(
                    checkRequired("capturedAt", capturedAt),
                    checkRequired("count", count),
                    checkRequired("trends", trends).map { it.toImmutable() },
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
        fun validate(): Snapshot = apply {
            if (validated) {
                return@apply
            }

            capturedAt()
            count()
            trends().forEach { it.validate() }
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
            (if (capturedAt.asKnown().isPresent) 1 else 0) +
                (if (count.asKnown().isPresent) 1 else 0) +
                (trends.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

        class Trend
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val description: JsonField<String>,
            private val promotedContent: JsonField<String>,
            private val query: JsonField<String>,
            private val rank: JsonField<Long>,
            private val tweetVolume: JsonField<Long>,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("promotedContent")
                @ExcludeMissing
                promotedContent: JsonField<String> = JsonMissing.of(),
                @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
                @JsonProperty("rank") @ExcludeMissing rank: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("tweetVolume")
                @ExcludeMissing
                tweetVolume: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(
                name,
                description,
                promotedContent,
                query,
                rank,
                tweetVolume,
                url,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * X's promotion ID of a promoted trend. Null for the others.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun promotedContent(): Optional<String> = promotedContent.getOptional("promotedContent")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun query(): Optional<String> = query.getOptional("query")

            /**
             * The trend's place in X's list at that time.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun rank(): Optional<Long> = rank.getOptional("rank")

            /**
             * X's post count for the trend at that time, when X showed one.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun tweetVolume(): Optional<Long> = tweetVolume.getOptional("tweetVolume")

            /**
             * The trend's search link on X.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [promotedContent].
             *
             * Unlike [promotedContent], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("promotedContent")
            @ExcludeMissing
            fun _promotedContent(): JsonField<String> = promotedContent

            /**
             * Returns the raw JSON value of [query].
             *
             * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

            /**
             * Returns the raw JSON value of [rank].
             *
             * Unlike [rank], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("rank") @ExcludeMissing fun _rank(): JsonField<Long> = rank

            /**
             * Returns the raw JSON value of [tweetVolume].
             *
             * Unlike [tweetVolume], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tweetVolume")
            @ExcludeMissing
            fun _tweetVolume(): JsonField<Long> = tweetVolume

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [Trend].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Trend]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var description: JsonField<String> = JsonMissing.of()
                private var promotedContent: JsonField<String> = JsonMissing.of()
                private var query: JsonField<String> = JsonMissing.of()
                private var rank: JsonField<Long> = JsonMissing.of()
                private var tweetVolume: JsonField<Long> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(trend: Trend) = apply {
                    name = trend.name
                    description = trend.description
                    promotedContent = trend.promotedContent
                    query = trend.query
                    rank = trend.rank
                    tweetVolume = trend.tweetVolume
                    url = trend.url
                    additionalProperties = trend.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** X's promotion ID of a promoted trend. Null for the others. */
                fun promotedContent(promotedContent: String?) =
                    promotedContent(JsonField.ofNullable(promotedContent))

                /**
                 * Alias for calling [Builder.promotedContent] with `promotedContent.orElse(null)`.
                 */
                fun promotedContent(promotedContent: Optional<String>) =
                    promotedContent(promotedContent.getOrNull())

                /** Sets [Builder.promotedContent] to an arbitrary JSON value. */
                fun promotedContent(promotedContent: JsonField<String>) = apply {
                    this.promotedContent = promotedContent
                }

                fun query(query: String) = query(JsonField.of(query))

                /** Sets [Builder.query] to an arbitrary JSON value. */
                fun query(query: JsonField<String>) = apply { this.query = query }

                /** The trend's place in X's list at that time. */
                fun rank(rank: Long) = rank(JsonField.of(rank))

                /** Sets [Builder.rank] to an arbitrary JSON value. */
                fun rank(rank: JsonField<Long>) = apply { this.rank = rank }

                /** X's post count for the trend at that time, when X showed one. */
                fun tweetVolume(tweetVolume: Long?) = tweetVolume(JsonField.ofNullable(tweetVolume))

                /** Alias for [Builder.tweetVolume]. */
                fun tweetVolume(tweetVolume: Long) = tweetVolume(tweetVolume as Long?)

                /** Alias for calling [Builder.tweetVolume] with `tweetVolume.orElse(null)`. */
                fun tweetVolume(tweetVolume: Optional<Long>) = tweetVolume(tweetVolume.getOrNull())

                /** Sets [Builder.tweetVolume] to an arbitrary JSON value. */
                fun tweetVolume(tweetVolume: JsonField<Long>) = apply {
                    this.tweetVolume = tweetVolume
                }

                /** The trend's search link on X. */
                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [Trend].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Trend =
                    Trend(
                        checkRequired("name", name),
                        description,
                        promotedContent,
                        query,
                        rank,
                        tweetVolume,
                        url,
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
            fun validate(): Trend = apply {
                if (validated) {
                    return@apply
                }

                name()
                description()
                promotedContent()
                query()
                rank()
                tweetVolume()
                url()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (promotedContent.asKnown().isPresent) 1 else 0) +
                    (if (query.asKnown().isPresent) 1 else 0) +
                    (if (rank.asKnown().isPresent) 1 else 0) +
                    (if (tweetVolume.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Trend &&
                    name == other.name &&
                    description == other.description &&
                    promotedContent == other.promotedContent &&
                    query == other.query &&
                    rank == other.rank &&
                    tweetVolume == other.tweetVolume &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    name,
                    description,
                    promotedContent,
                    query,
                    rank,
                    tweetVolume,
                    url,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Trend{name=$name, description=$description, promotedContent=$promotedContent, query=$query, rank=$rank, tweetVolume=$tweetVolume, url=$url, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Snapshot &&
                capturedAt == other.capturedAt &&
                count == other.count &&
                trends == other.trends &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(capturedAt, count, trends, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Snapshot{capturedAt=$capturedAt, count=$count, trends=$trends, additionalProperties=$additionalProperties}"
    }

    /** A place X offers trends for. */
    class Location
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val name: JsonField<String>,
        private val parentWoeid: JsonField<Long>,
        private val placeType: JsonField<String>,
        private val placeTypeCode: JsonField<Long>,
        private val url: JsonField<String>,
        private val woeid: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("countryCode")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parentWoeid")
            @ExcludeMissing
            parentWoeid: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("placeType")
            @ExcludeMissing
            placeType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeTypeCode")
            @ExcludeMissing
            placeTypeCode: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("woeid") @ExcludeMissing woeid: JsonField<Long> = JsonMissing.of(),
        ) : this(
            country,
            countryCode,
            name,
            parentWoeid,
            placeType,
            placeTypeCode,
            url,
            woeid,
            mutableMapOf(),
        )

        /**
         * Country name. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * 2-letter country code. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * WOEID of the country or region above it. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun parentWoeid(): Optional<Long> = parentWoeid.getOptional("parentWoeid")

        /**
         * X's kind of place. Town, Country, Supername for Worldwide, or Unknown.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun placeType(): Optional<String> = placeType.getOptional("placeType")

        /**
         * X's numeric code for the kind of place.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun placeTypeCode(): Optional<Long> = placeTypeCode.getOptional("placeTypeCode")

        /**
         * X's legacy Yahoo GeoPlanet reference. It may not resolve.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Location ID. Pass it as woeid to /x/trends.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun woeid(): Long = woeid.getRequired("woeid")

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("countryCode")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [parentWoeid].
         *
         * Unlike [parentWoeid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parentWoeid")
        @ExcludeMissing
        fun _parentWoeid(): JsonField<Long> = parentWoeid

        /**
         * Returns the raw JSON value of [placeType].
         *
         * Unlike [placeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("placeType") @ExcludeMissing fun _placeType(): JsonField<String> = placeType

        /**
         * Returns the raw JSON value of [placeTypeCode].
         *
         * Unlike [placeTypeCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("placeTypeCode")
        @ExcludeMissing
        fun _placeTypeCode(): JsonField<Long> = placeTypeCode

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [woeid].
         *
         * Unlike [woeid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("woeid") @ExcludeMissing fun _woeid(): JsonField<Long> = woeid

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
             * Returns a mutable builder for constructing an instance of [Location].
             *
             * The following fields are required:
             * ```java
             * .country()
             * .countryCode()
             * .name()
             * .parentWoeid()
             * .placeType()
             * .placeTypeCode()
             * .url()
             * .woeid()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Location]. */
        class Builder internal constructor() {

            private var country: JsonField<String>? = null
            private var countryCode: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var parentWoeid: JsonField<Long>? = null
            private var placeType: JsonField<String>? = null
            private var placeTypeCode: JsonField<Long>? = null
            private var url: JsonField<String>? = null
            private var woeid: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(location: Location) = apply {
                country = location.country
                countryCode = location.countryCode
                name = location.name
                parentWoeid = location.parentWoeid
                placeType = location.placeType
                placeTypeCode = location.placeTypeCode
                url = location.url
                woeid = location.woeid
                additionalProperties = location.additionalProperties.toMutableMap()
            }

            /** Country name. Null for Worldwide. */
            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /** Sets [Builder.country] to an arbitrary JSON value. */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /** 2-letter country code. Null for Worldwide. */
            fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

            /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
            fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

            /** Sets [Builder.countryCode] to an arbitrary JSON value. */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** WOEID of the country or region above it. Null for Worldwide. */
            fun parentWoeid(parentWoeid: Long?) = parentWoeid(JsonField.ofNullable(parentWoeid))

            /** Alias for [Builder.parentWoeid]. */
            fun parentWoeid(parentWoeid: Long) = parentWoeid(parentWoeid as Long?)

            /** Alias for calling [Builder.parentWoeid] with `parentWoeid.orElse(null)`. */
            fun parentWoeid(parentWoeid: Optional<Long>) = parentWoeid(parentWoeid.getOrNull())

            /** Sets [Builder.parentWoeid] to an arbitrary JSON value. */
            fun parentWoeid(parentWoeid: JsonField<Long>) = apply { this.parentWoeid = parentWoeid }

            /** X's kind of place. Town, Country, Supername for Worldwide, or Unknown. */
            fun placeType(placeType: String?) = placeType(JsonField.ofNullable(placeType))

            /** Alias for calling [Builder.placeType] with `placeType.orElse(null)`. */
            fun placeType(placeType: Optional<String>) = placeType(placeType.getOrNull())

            /** Sets [Builder.placeType] to an arbitrary JSON value. */
            fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

            /** X's numeric code for the kind of place. */
            fun placeTypeCode(placeTypeCode: Long?) =
                placeTypeCode(JsonField.ofNullable(placeTypeCode))

            /** Alias for [Builder.placeTypeCode]. */
            fun placeTypeCode(placeTypeCode: Long) = placeTypeCode(placeTypeCode as Long?)

            /** Alias for calling [Builder.placeTypeCode] with `placeTypeCode.orElse(null)`. */
            fun placeTypeCode(placeTypeCode: Optional<Long>) =
                placeTypeCode(placeTypeCode.getOrNull())

            /** Sets [Builder.placeTypeCode] to an arbitrary JSON value. */
            fun placeTypeCode(placeTypeCode: JsonField<Long>) = apply {
                this.placeTypeCode = placeTypeCode
            }

            /** X's legacy Yahoo GeoPlanet reference. It may not resolve. */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Location ID. Pass it as woeid to /x/trends. */
            fun woeid(woeid: Long) = woeid(JsonField.of(woeid))

            /** Sets [Builder.woeid] to an arbitrary JSON value. */
            fun woeid(woeid: JsonField<Long>) = apply { this.woeid = woeid }

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
             * Returns an immutable instance of [Location].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .country()
             * .countryCode()
             * .name()
             * .parentWoeid()
             * .placeType()
             * .placeTypeCode()
             * .url()
             * .woeid()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Location =
                Location(
                    checkRequired("country", country),
                    checkRequired("countryCode", countryCode),
                    checkRequired("name", name),
                    checkRequired("parentWoeid", parentWoeid),
                    checkRequired("placeType", placeType),
                    checkRequired("placeTypeCode", placeTypeCode),
                    checkRequired("url", url),
                    checkRequired("woeid", woeid),
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
        fun validate(): Location = apply {
            if (validated) {
                return@apply
            }

            country()
            countryCode()
            name()
            parentWoeid()
            placeType()
            placeTypeCode()
            url()
            woeid()
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
            (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (parentWoeid.asKnown().isPresent) 1 else 0) +
                (if (placeType.asKnown().isPresent) 1 else 0) +
                (if (placeTypeCode.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (woeid.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Location &&
                country == other.country &&
                countryCode == other.countryCode &&
                name == other.name &&
                parentWoeid == other.parentWoeid &&
                placeType == other.placeType &&
                placeTypeCode == other.placeTypeCode &&
                url == other.url &&
                woeid == other.woeid &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                country,
                countryCode,
                name,
                parentWoeid,
                placeType,
                placeTypeCode,
                url,
                woeid,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Location{country=$country, countryCode=$countryCode, name=$name, parentWoeid=$parentWoeid, placeType=$placeType, placeTypeCode=$placeTypeCode, url=$url, woeid=$woeid, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendsHistoryResponse &&
            count == other.count &&
            fromTime == other.fromTime &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            snapshots == other.snapshots &&
            toTime == other.toTime &&
            woeid == other.woeid &&
            location == other.location &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            count,
            fromTime,
            hasNextPage,
            nextCursor,
            snapshots,
            toTime,
            woeid,
            location,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetTrendsHistoryResponse{count=$count, fromTime=$fromTime, hasNextPage=$hasNextPage, nextCursor=$nextCursor, snapshots=$snapshots, toTime=$toTime, woeid=$woeid, location=$location, additionalProperties=$additionalProperties}"
}
