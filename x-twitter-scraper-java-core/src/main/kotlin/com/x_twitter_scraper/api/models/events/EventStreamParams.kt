// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Streams the account's monitor events as server-sent events, each named by its event type and
 * numbered by its event ID. A reconnect that sends Last-Event-ID first gets every event after that
 * one from the last 30 days, then each new event. A connection lasts up to 30 minutes and sends a
 * comment every 15 seconds while idle. Keep up to 5 streams open per account. Events and streams
 * cost no credits.
 */
class EventStreamParams
private constructor(
    private val lastEventID: String?,
    private val include: Include?,
    private val lookBack: Boolean?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun lastEventID(): Optional<String> = Optional.ofNullable(lastEventID)

    /**
     * Set to post_metrics to also get each post monitor's saved numbers. The API refuses any other
     * value.
     */
    fun include(): Optional<Include> = Optional.ofNullable(include)

    /**
     * Set to true to resume 30 seconds before Last-Event-ID, so events saved late still arrive.
     * Events you have can arrive again, so skip IDs you've seen.
     */
    fun lookBack(): Optional<Boolean> = Optional.ofNullable(lookBack)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): EventStreamParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [EventStreamParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventStreamParams]. */
    class Builder internal constructor() {

        private var lastEventID: String? = null
        private var include: Include? = null
        private var lookBack: Boolean? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eventStreamParams: EventStreamParams) = apply {
            lastEventID = eventStreamParams.lastEventID
            include = eventStreamParams.include
            lookBack = eventStreamParams.lookBack
            additionalHeaders = eventStreamParams.additionalHeaders.toBuilder()
            additionalQueryParams = eventStreamParams.additionalQueryParams.toBuilder()
        }

        fun lastEventID(lastEventID: String?) = apply { this.lastEventID = lastEventID }

        /** Alias for calling [Builder.lastEventID] with `lastEventID.orElse(null)`. */
        fun lastEventID(lastEventID: Optional<String>) = lastEventID(lastEventID.getOrNull())

        /**
         * Set to post_metrics to also get each post monitor's saved numbers. The API refuses any
         * other value.
         */
        fun include(include: Include?) = apply { this.include = include }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<Include>) = include(include.getOrNull())

        /**
         * Set to true to resume 30 seconds before Last-Event-ID, so events saved late still arrive.
         * Events you have can arrive again, so skip IDs you've seen.
         */
        fun lookBack(lookBack: Boolean?) = apply { this.lookBack = lookBack }

        /** Alias for [Builder.lookBack]. */
        fun lookBack(lookBack: Boolean) = lookBack(lookBack as Boolean?)

        /** Alias for calling [Builder.lookBack] with `lookBack.orElse(null)`. */
        fun lookBack(lookBack: Optional<Boolean>) = lookBack(lookBack.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [EventStreamParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): EventStreamParams =
            EventStreamParams(
                lastEventID,
                include,
                lookBack,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                lastEventID?.let { put("Last-Event-ID", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                include?.let { put("include", it.toString()) }
                lookBack?.let { put("lookBack", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Set to post_metrics to also get each post monitor's saved numbers. */
    class Include @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val POST_METRICS = of("post_metrics")

            @JvmStatic fun of(value: String) = Include(JsonField.of(value))
        }

        /** An enum containing [Include]'s known values. */
        enum class Known {
            POST_METRICS
        }

        /** An enum containing [Include]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            POST_METRICS,
            /** An enum member indicating that [Include] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                POST_METRICS -> Value.POST_METRICS
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
                POST_METRICS -> Known.POST_METRICS
                else -> throw XTwitterScraperInvalidDataException("Unknown Include: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Include = apply {
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

            return other is Include && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventStreamParams &&
            lastEventID == other.lastEventID &&
            include == other.include &&
            lookBack == other.lookBack &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(lastEventID, include, lookBack, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "EventStreamParams{lastEventID=$lastEventID, include=$include, lookBack=$lookBack, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
