// File generated from our OpenAPI spec by Stainless.

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class XGetTrendsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val trends: JsonField<List<Trend>>,
    private val woeid: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("trends") @ExcludeMissing trends: JsonField<List<Trend>> = JsonMissing.of(),
        @JsonProperty("woeid") @ExcludeMissing woeid: JsonField<Long> = JsonMissing.of(),
    ) : this(count, trends, woeid, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun count(): Long = count.getRequired("count")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun trends(): List<Trend> = trends.getRequired("trends")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun woeid(): Long = woeid.getRequired("woeid")

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
         * Returns a mutable builder for constructing an instance of [XGetTrendsResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .trends()
         * .woeid()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendsResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var trends: JsonField<MutableList<Trend>>? = null
        private var woeid: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetTrendsResponse: XGetTrendsResponse) = apply {
            count = xGetTrendsResponse.count
            trends = xGetTrendsResponse.trends.map { it.toMutableList() }
            woeid = xGetTrendsResponse.woeid
            additionalProperties = xGetTrendsResponse.additionalProperties.toMutableMap()
        }

        fun count(count: Long) = count(JsonField.of(count))

        /**
         * Sets [Builder.count] to an arbitrary JSON value.
         *
         * You should usually call [Builder.count] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun trends(trends: List<Trend>) = trends(JsonField.of(trends))

        /**
         * Sets [Builder.trends] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trends] with a well-typed `List<Trend>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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

        fun woeid(woeid: Long) = woeid(JsonField.of(woeid))

        /**
         * Sets [Builder.woeid] to an arbitrary JSON value.
         *
         * You should usually call [Builder.woeid] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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
         * Returns an immutable instance of [XGetTrendsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .trends()
         * .woeid()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetTrendsResponse =
            XGetTrendsResponse(
                checkRequired("count", count),
                checkRequired("trends", trends).map { it.toImmutable() },
                checkRequired("woeid", woeid),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): XGetTrendsResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        trends().forEach { it.validate() }
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (count.asKnown().isPresent) 1 else 0) +
            (trends.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (woeid.asKnown().isPresent) 1 else 0)

    class Trend
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val description: JsonField<String>,
        private val query: JsonField<String>,
        private val rank: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
            @JsonProperty("rank") @ExcludeMissing rank: JsonField<Long> = JsonMissing.of(),
        ) : this(name, description, query, rank, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun query(): Optional<String> = query.getOptional("query")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun rank(): Optional<Long> = rank.getOptional("rank")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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
            private var query: JsonField<String> = JsonMissing.of()
            private var rank: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(trend: Trend) = apply {
                name = trend.name
                description = trend.description
                query = trend.query
                rank = trend.rank
                additionalProperties = trend.additionalProperties.toMutableMap()
            }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun query(query: String) = query(JsonField.of(query))

            /**
             * Sets [Builder.query] to an arbitrary JSON value.
             *
             * You should usually call [Builder.query] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun query(query: JsonField<String>) = apply { this.query = query }

            fun rank(rank: Long) = rank(JsonField.of(rank))

            /**
             * Sets [Builder.rank] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rank] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rank(rank: JsonField<Long>) = apply { this.rank = rank }

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
                    query,
                    rank,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Trend = apply {
            if (validated) {
                return@apply
            }

            name()
            description()
            query()
            rank()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0) +
                (if (rank.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Trend &&
                name == other.name &&
                description == other.description &&
                query == other.query &&
                rank == other.rank &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(name, description, query, rank, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Trend{name=$name, description=$description, query=$query, rank=$rank, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendsResponse &&
            count == other.count &&
            trends == other.trends &&
            woeid == other.woeid &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, trends, woeid, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetTrendsResponse{count=$count, trends=$trends, woeid=$woeid, additionalProperties=$additionalProperties}"
}
