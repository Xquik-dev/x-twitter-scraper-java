// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.posts

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

class PostListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val monitors: JsonField<List<PostMonitor>>,
    private val total: JsonField<Long>,
    private val hasMore: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("monitors")
        @ExcludeMissing
        monitors: JsonField<List<PostMonitor>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextCursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(
        monitors,
        total,
        hasMore,
        nextCursor,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitors(): List<PostMonitor> = monitors.getRequired("monitors")

    /**
     * Post monitors on this page.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun total(): Long = total.getRequired("total")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasMore(): Boolean = hasMore.getRequired("hasMore")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [monitors].
     *
     * Unlike [monitors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitors")
    @ExcludeMissing
    fun _monitors(): JsonField<List<PostMonitor>> = monitors

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasMore") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextCursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

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
         * Returns a mutable builder for constructing an instance of [PostListResponse].
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * .hasMore()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostListResponse]. */
    class Builder internal constructor() {

        private var monitors: JsonField<MutableList<PostMonitor>>? = null
        private var total: JsonField<Long>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(postListResponse: PostListResponse) = apply {
            monitors = postListResponse.monitors.map { it.toMutableList() }
            total = postListResponse.total
            hasMore = postListResponse.hasMore
            nextCursor = postListResponse.nextCursor
            additionalProperties = postListResponse.additionalProperties.toMutableMap()
        }

        fun monitors(monitors: List<PostMonitor>) = monitors(JsonField.of(monitors))

        /** Sets [Builder.monitors] to an arbitrary JSON value. */
        fun monitors(monitors: JsonField<List<PostMonitor>>) = apply {
            this.monitors = monitors.map { it.toMutableList() }
        }

        /**
         * Adds a single [PostMonitor] to [monitors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMonitor(monitor: PostMonitor) = apply {
            monitors =
                (monitors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("monitors", it).add(monitor)
                }
        }

        /** Post monitors on this page. */
        fun total(total: Long) = total(JsonField.of(total))

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /** Sets [Builder.hasMore] to an arbitrary JSON value. */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

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
         * Returns an immutable instance of [PostListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * .hasMore()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostListResponse =
            PostListResponse(
                checkRequired("monitors", monitors).map { it.toImmutable() },
                checkRequired("total", total),
                checkRequired("hasMore", hasMore),
                nextCursor,
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
    fun validate(): PostListResponse = apply {
        if (validated) {
            return@apply
        }

        monitors().forEach { it.validate() }
        total()
        hasMore()
        nextCursor()
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
        (monitors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostListResponse &&
            monitors == other.monitors &&
            total == other.total &&
            hasMore == other.hasMore &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(monitors, total, hasMore, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostListResponse{monitors=$monitors, total=$total, hasMore=$hasMore, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
