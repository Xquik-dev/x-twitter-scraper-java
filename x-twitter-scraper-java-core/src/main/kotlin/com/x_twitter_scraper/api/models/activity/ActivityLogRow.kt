// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.activity

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * 1 Activity log row. A cut list ends with a row whose category is notice and whose activity says
 * where it stopped.
 */
class ActivityLogRow
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val time: JsonField<String>,
    private val category: JsonField<String>,
    private val type: JsonField<String>,
    private val activity: JsonField<String>,
    private val status: JsonField<String>,
    private val source: JsonField<String>,
    private val target: JsonField<String>,
    private val results: JsonField<Count>,
    private val credits: JsonField<Count>,
    private val details: JsonField<String>,
    private val id: JsonField<String>,
    private val link: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("time") @ExcludeMissing time: JsonField<String> = JsonMissing.of(),
        @JsonProperty("category") @ExcludeMissing category: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("activity") @ExcludeMissing activity: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("target") @ExcludeMissing target: JsonField<String> = JsonMissing.of(),
        @JsonProperty("results") @ExcludeMissing results: JsonField<Count> = JsonMissing.of(),
        @JsonProperty("credits") @ExcludeMissing credits: JsonField<Count> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("link") @ExcludeMissing link: JsonField<String> = JsonMissing.of(),
    ) : this(
        time,
        category,
        type,
        activity,
        status,
        source,
        target,
        results,
        credits,
        details,
        id,
        link,
        mutableMapOf(),
    )

    /** ISO 8601 time in UTC to the millisecond. Empty on the notice row. */
    fun time(): String = time.getRequired("time")

    fun category(): String = category.getRequired("category")

    fun type(): String = type.getRequired("type")

    fun activity(): String = activity.getRequired("activity")

    fun status(): String = status.getRequired("status")

    fun source(): String = source.getRequired("source")

    fun target(): String = target.getRequired("target")

    fun details(): String = details.getRequired("details")

    /** Activity ID. GET /activity/{id} returns its full record. */
    fun id(): String = id.getRequired("id")

    fun link(): String = link.getRequired("link")

    /** Returns the raw JSON value of [time]. */
    @JsonProperty("time") @ExcludeMissing fun _time(): JsonField<String> = time

    /** Returns the raw JSON value of [category]. */
    @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

    /** Returns the raw JSON value of [type]. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /** Returns the raw JSON value of [activity]. */
    @JsonProperty("activity") @ExcludeMissing fun _activity(): JsonField<String> = activity

    /** Returns the raw JSON value of [status]. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /** Returns the raw JSON value of [source]. */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    /** Returns the raw JSON value of [target]. */
    @JsonProperty("target") @ExcludeMissing fun _target(): JsonField<String> = target

    /** Rows the activity read, or an empty string when it has no count. */
    fun results(): Count = results.getRequired("results")

    /** Credits the activity charged, or an empty string when it has no charge. */
    fun credits(): Count = credits.getRequired("credits")

    /** Returns the raw JSON value of [results]. */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<Count> = results

    /** Returns the raw JSON value of [credits]. */
    @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<Count> = credits

    /** Returns the raw JSON value of [details]. */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<String> = details

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [link]. */
    @JsonProperty("link") @ExcludeMissing fun _link(): JsonField<String> = link

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

        /** Returns a mutable builder for constructing an instance of [ActivityLogRow]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ActivityLogRow]. */
    class Builder internal constructor() {

        private var time: JsonField<String>? = null
        private var category: JsonField<String>? = null
        private var type: JsonField<String>? = null
        private var activity: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var source: JsonField<String>? = null
        private var target: JsonField<String>? = null
        private var results: JsonField<Count>? = null
        private var credits: JsonField<Count>? = null
        private var details: JsonField<String>? = null
        private var id: JsonField<String>? = null
        private var link: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(activityLogRow: ActivityLogRow) = apply {
            time = activityLogRow.time
            category = activityLogRow.category
            type = activityLogRow.type
            activity = activityLogRow.activity
            status = activityLogRow.status
            source = activityLogRow.source
            target = activityLogRow.target
            results = activityLogRow.results
            credits = activityLogRow.credits
            details = activityLogRow.details
            id = activityLogRow.id
            link = activityLogRow.link
            additionalProperties = activityLogRow.additionalProperties.toMutableMap()
        }

        /** ISO 8601 time in UTC to the millisecond. Empty on the notice row. */
        fun time(time: String) = time(JsonField.of(time))

        /** Sets [Builder.time] to an arbitrary JSON value. */
        fun time(time: JsonField<String>) = apply { this.time = time }

        fun category(category: String) = category(JsonField.of(category))

        /** Sets [Builder.category] to an arbitrary JSON value. */
        fun category(category: JsonField<String>) = apply { this.category = category }

        fun type(type: String) = type(JsonField.of(type))

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun activity(activity: String) = activity(JsonField.of(activity))

        /** Sets [Builder.activity] to an arbitrary JSON value. */
        fun activity(activity: JsonField<String>) = apply { this.activity = activity }

        fun status(status: String) = status(JsonField.of(status))

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun source(source: String) = source(JsonField.of(source))

        /** Sets [Builder.source] to an arbitrary JSON value. */
        fun source(source: JsonField<String>) = apply { this.source = source }

        fun target(target: String) = target(JsonField.of(target))

        /** Sets [Builder.target] to an arbitrary JSON value. */
        fun target(target: JsonField<String>) = apply { this.target = target }

        /** Rows the activity read, or an empty string when it has no count. */
        fun results(results: Count) = results(JsonField.of(results))

        /** Sets [Builder.results] to an arbitrary JSON value. */
        fun results(results: JsonField<Count>) = apply { this.results = results }

        /** Credits the activity charged, or an empty string when it has no charge. */
        fun credits(credits: Count) = credits(JsonField.of(credits))

        /** Sets [Builder.credits] to an arbitrary JSON value. */
        fun credits(credits: JsonField<Count>) = apply { this.credits = credits }

        fun details(details: String) = details(JsonField.of(details))

        /** Sets [Builder.details] to an arbitrary JSON value. */
        fun details(details: JsonField<String>) = apply { this.details = details }

        /** Activity ID. GET /activity/{id} returns its full record. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun link(link: String) = link(JsonField.of(link))

        /** Sets [Builder.link] to an arbitrary JSON value. */
        fun link(link: JsonField<String>) = apply { this.link = link }

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
         * Returns an immutable instance of [ActivityLogRow].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ActivityLogRow =
            ActivityLogRow(
                checkRequired("time", time),
                checkRequired("category", category),
                checkRequired("type", type),
                checkRequired("activity", activity),
                checkRequired("status", status),
                checkRequired("source", source),
                checkRequired("target", target),
                checkRequired("results", results),
                checkRequired("credits", credits),
                checkRequired("details", details),
                checkRequired("id", id),
                checkRequired("link", link),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): ActivityLogRow = apply {
        if (validated) {
            return@apply
        }

        time()
        category()
        type()
        activity()
        status()
        source()
        target()
        results().validate()
        credits().validate()
        details()
        id()
        link()
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
        (if (time.asKnown().isPresent) 1 else 0) +
            (if (category.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (activity.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (target.asKnown().isPresent) 1 else 0) +
            (results.asKnown().getOrNull()?.validity() ?: 0) +
            (credits.asKnown().getOrNull()?.validity() ?: 0) +
            (if (details.asKnown().isPresent) 1 else 0) +
            (if (id.asKnown().isPresent) 1 else 0) +
            (if (link.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ActivityLogRow &&
            time == other.time &&
            category == other.category &&
            type == other.type &&
            activity == other.activity &&
            status == other.status &&
            source == other.source &&
            target == other.target &&
            results == other.results &&
            credits == other.credits &&
            details == other.details &&
            id == other.id &&
            link == other.link &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            time,
            category,
            type,
            activity,
            status,
            source,
            target,
            results,
            credits,
            details,
            id,
            link,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ActivityLogRow{time=$time, category=$category, type=$type, activity=$activity, status=$status, source=$source, target=$target, results=$results, credits=$credits, details=$details, id=$id, link=$link, additionalProperties=$additionalProperties}"

    /** A count the API sends as a whole number, or as an empty string when the row has none. */
    @JsonDeserialize(using = Count.Deserializer::class)
    @JsonSerialize(using = Count.Serializer::class)
    class Count
    private constructor(
        private val long: Long? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun long(): Optional<Long> = Optional.ofNullable(long)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isLong(): Boolean = long != null

        fun isString(): Boolean = string != null

        fun asLong(): Long = long.getOrThrow("long")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                long != null -> visitor.visitLong(long)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Count = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitLong(long: Long) {}

                    override fun visitString(string: String) {}
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitLong(long: Long) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Count && long == other.long && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(long, string)

        override fun toString(): String =
            when {
                long != null -> "Count{long=$long}"
                string != null -> "Count{string=$string}"
                _json != null -> "Count{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Count")
            }

        companion object {

            @JvmStatic fun ofLong(long: Long) = Count(long = long)

            @JvmStatic fun ofString(string: String) = Count(string = string)
        }

        /** An interface that defines how to map each variant of [Count] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitLong(long: Long): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Count] to a value of type [T].
             *
             * An instance of [Count] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown Count: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Count>(Count::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Count {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                Count(long = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Count(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> Count(_json = json)
                    1 -> bestMatches.single()
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Count>(Count::class) {

            override fun serialize(
                value: Count,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.long != null -> generator.writeObject(value.long)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Count")
                }
            }
        }
    }
}
