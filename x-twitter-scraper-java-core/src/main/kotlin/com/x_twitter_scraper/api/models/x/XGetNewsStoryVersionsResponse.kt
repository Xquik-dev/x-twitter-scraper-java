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
import kotlin.jvm.optionals.getOrNull

class XGetNewsStoryVersionsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val id: JsonField<String>,
    private val versions: JsonField<List<Version>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("versions")
        @ExcludeMissing
        versions: JsonField<List<Version>> = JsonMissing.of(),
    ) : this(count, id, versions, mutableMapOf())

    /**
     * Versions returned.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * The story's ID, as the request named it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun versions(): List<Version> = versions.getRequired("versions")

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
     * Returns the raw JSON value of [versions].
     *
     * Unlike [versions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("versions") @ExcludeMissing fun _versions(): JsonField<List<Version>> = versions

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
         * [XGetNewsStoryVersionsResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .id()
         * .versions()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetNewsStoryVersionsResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var id: JsonField<String>? = null
        private var versions: JsonField<MutableList<Version>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetNewsStoryVersionsResponse: XGetNewsStoryVersionsResponse) = apply {
            count = xGetNewsStoryVersionsResponse.count
            id = xGetNewsStoryVersionsResponse.id
            versions = xGetNewsStoryVersionsResponse.versions.map { it.toMutableList() }
            additionalProperties = xGetNewsStoryVersionsResponse.additionalProperties.toMutableMap()
        }

        /** Versions returned. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** The story's ID, as the request named it. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun versions(versions: List<Version>) = versions(JsonField.of(versions))

        /** Sets [Builder.versions] to an arbitrary JSON value. */
        fun versions(versions: JsonField<List<Version>>) = apply {
            this.versions = versions.map { it.toMutableList() }
        }

        /**
         * Adds a single [Version] to [versions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVersion(version: Version) = apply {
            versions =
                (versions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("versions", it).add(version)
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
         * Returns an immutable instance of [XGetNewsStoryVersionsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .id()
         * .versions()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetNewsStoryVersionsResponse =
            XGetNewsStoryVersionsResponse(
                checkRequired("count", count),
                checkRequired("id", id),
                checkRequired("versions", versions).map { it.toImmutable() },
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
    fun validate(): XGetNewsStoryVersionsResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        id()
        versions().forEach { it.validate() }
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
            (versions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    /** 1 version X wrote of a news story. */
    class Version
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val createdAt: JsonField<OffsetDateTime>,
        private val headline: JsonField<String>,
        private val id: JsonField<String>,
        private val text: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("headline")
            @ExcludeMissing
            headline: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        ) : this(createdAt, headline, id, text, mutableMapOf())

        /**
         * When X wrote the version, in UTC, from its ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * The story's headline in this version.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun headline(): String = headline.getRequired("headline")

        /**
         * The version's ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * The story's text in this version, without the time line X writes above it in the reader's
         * time zone.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun text(): String = text.getRequired("text")

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [headline].
         *
         * Unlike [headline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headline") @ExcludeMissing fun _headline(): JsonField<String> = headline

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of [Version].
             *
             * The following fields are required:
             * ```java
             * .createdAt()
             * .headline()
             * .id()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Version]. */
        class Builder internal constructor() {

            private var createdAt: JsonField<OffsetDateTime>? = null
            private var headline: JsonField<String>? = null
            private var id: JsonField<String>? = null
            private var text: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(version: Version) = apply {
                createdAt = version.createdAt
                headline = version.headline
                id = version.id
                text = version.text
                additionalProperties = version.additionalProperties.toMutableMap()
            }

            /** When X wrote the version, in UTC, from its ID. */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** The story's headline in this version. */
            fun headline(headline: String) = headline(JsonField.of(headline))

            /** Sets [Builder.headline] to an arbitrary JSON value. */
            fun headline(headline: JsonField<String>) = apply { this.headline = headline }

            /** The version's ID. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * The story's text in this version, without the time line X writes above it in the
             * reader's time zone.
             */
            fun text(text: String) = text(JsonField.of(text))

            /** Sets [Builder.text] to an arbitrary JSON value. */
            fun text(text: JsonField<String>) = apply { this.text = text }

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
             * Returns an immutable instance of [Version].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .createdAt()
             * .headline()
             * .id()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Version =
                Version(
                    checkRequired("createdAt", createdAt),
                    checkRequired("headline", headline),
                    checkRequired("id", id),
                    checkRequired("text", text),
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
        fun validate(): Version = apply {
            if (validated) {
                return@apply
            }

            createdAt()
            headline()
            id()
            text()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (headline.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Version &&
                createdAt == other.createdAt &&
                headline == other.headline &&
                id == other.id &&
                text == other.text &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(createdAt, headline, id, text, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Version{createdAt=$createdAt, headline=$headline, id=$id, text=$text, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetNewsStoryVersionsResponse &&
            count == other.count &&
            id == other.id &&
            versions == other.versions &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, id, versions, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetNewsStoryVersionsResponse{count=$count, id=$id, versions=$versions, additionalProperties=$additionalProperties}"
}
