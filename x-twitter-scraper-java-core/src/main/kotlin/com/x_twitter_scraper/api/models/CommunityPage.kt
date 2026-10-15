// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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
import kotlin.jvm.optionals.getOrNull

/** 1 page of X Communities, in X's order. */
class CommunityPage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val communities: JsonField<List<Community>>,
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("communities")
        @ExcludeMissing
        communities: JsonField<List<Community>> = JsonMissing.of(),
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(communities, hasNextPage, nextCursor, mutableMapOf())

    /**
     * Communities in X's order
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun communities(): List<Community> = communities.getRequired("communities")

    /**
     * Whether another page of communities follows
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * Cursor for the next page of communities. Empty at the end.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * Returns the raw JSON value of [communities].
     *
     * Unlike [communities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communities")
    @ExcludeMissing
    fun _communities(): JsonField<List<Community>> = communities

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
         * Returns a mutable builder for constructing an instance of [CommunityPage].
         *
         * The following fields are required:
         * ```java
         * .communities()
         * .hasNextPage()
         * .nextCursor()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityPage]. */
    class Builder internal constructor() {

        private var communities: JsonField<MutableList<Community>>? = null
        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityPage: CommunityPage) = apply {
            communities = communityPage.communities.map { it.toMutableList() }
            hasNextPage = communityPage.hasNextPage
            nextCursor = communityPage.nextCursor
            additionalProperties = communityPage.additionalProperties.toMutableMap()
        }

        /** Communities in X's order */
        fun communities(communities: List<Community>) = communities(JsonField.of(communities))

        /** Sets [Builder.communities] to an arbitrary JSON value. */
        fun communities(communities: JsonField<List<Community>>) = apply {
            this.communities = communities.map { it.toMutableList() }
        }

        /**
         * Adds a single [Community] to [communities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCommunity(community: Community) = apply {
            communities =
                (communities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("communities", it).add(community)
                }
        }

        /** Whether another page of communities follows */
        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        /** Cursor for the next page of communities. Empty at the end. */
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
         * Returns an immutable instance of [CommunityPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .communities()
         * .hasNextPage()
         * .nextCursor()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityPage =
            CommunityPage(
                checkRequired("communities", communities).map { it.toImmutable() },
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
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
    fun validate(): CommunityPage = apply {
        if (validated) {
            return@apply
        }

        communities().forEach { it.validate() }
        hasNextPage()
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
        (communities.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityPage &&
            communities == other.communities &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(communities, hasNextPage, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityPage{communities=$communities, hasNextPage=$hasNextPage, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
