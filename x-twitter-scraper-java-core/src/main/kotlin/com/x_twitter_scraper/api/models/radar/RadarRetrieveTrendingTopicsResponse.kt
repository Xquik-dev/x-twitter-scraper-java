// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

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

class RadarRetrieveTrendingTopicsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasMore: JsonField<Boolean>,
    private val items: JsonField<List<RadarItem>>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("items") @ExcludeMissing items: JsonField<List<RadarItem>> = JsonMissing.of(),
        @JsonProperty("nextCursor") @ExcludeMissing nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(hasMore, items, nextCursor, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("hasMore")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun items(): List<RadarItem> = items.getRequired("items")

    /**
     * Opaque cursor for the next page (present only when hasMore is true).
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasMore") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<RadarItem>> = items

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
         * Returns a mutable builder for constructing an instance of
         * [RadarRetrieveTrendingTopicsResponse].
         *
         * The following fields are required:
         * ```java
         * .hasMore()
         * .items()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RadarRetrieveTrendingTopicsResponse]. */
    class Builder internal constructor() {

        private var hasMore: JsonField<Boolean>? = null
        private var items: JsonField<MutableList<RadarItem>>? = null
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            radarRetrieveTrendingTopicsResponse: RadarRetrieveTrendingTopicsResponse
        ) = apply {
            hasMore = radarRetrieveTrendingTopicsResponse.hasMore
            items = radarRetrieveTrendingTopicsResponse.items.map { it.toMutableList() }
            nextCursor = radarRetrieveTrendingTopicsResponse.nextCursor
            additionalProperties =
                radarRetrieveTrendingTopicsResponse.additionalProperties.toMutableMap()
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun items(items: List<RadarItem>) = items(JsonField.of(items))

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<RadarItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun items(items: JsonField<List<RadarItem>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /**
         * Adds a single [RadarItem] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: RadarItem) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        /** Opaque cursor for the next page (present only when hasMore is true). */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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
         * Returns an immutable instance of [RadarRetrieveTrendingTopicsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasMore()
         * .items()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RadarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse(
                checkRequired("hasMore", hasMore),
                checkRequired("items", items).map { it.toImmutable() },
                nextCursor,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RadarRetrieveTrendingTopicsResponse = apply {
        if (validated) {
            return@apply
        }

        hasMore()
        items().forEach { it.validate() }
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (hasMore.asKnown().isPresent) 1 else 0) +
            (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RadarRetrieveTrendingTopicsResponse &&
            hasMore == other.hasMore &&
            items == other.items &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasMore, items, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RadarRetrieveTrendingTopicsResponse{hasMore=$hasMore, items=$items, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
