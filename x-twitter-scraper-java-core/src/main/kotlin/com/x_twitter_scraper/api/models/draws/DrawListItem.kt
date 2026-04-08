// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

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

/** Giveaway draw summary with entry counts and status. */
class DrawListItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val status: JsonField<String>,
    private val totalEntries: JsonField<Long>,
    private val tweetUrl: JsonField<String>,
    private val validEntries: JsonField<Long>,
    private val drawnAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("totalEntries")
        @ExcludeMissing
        totalEntries: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweetUrl") @ExcludeMissing tweetUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("validEntries")
        @ExcludeMissing
        validEntries: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("drawnAt")
        @ExcludeMissing
        drawnAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(id, createdAt, status, totalEntries, tweetUrl, validEntries, drawnAt, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalEntries(): Long = totalEntries.getRequired("totalEntries")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweetUrl(): String = tweetUrl.getRequired("tweetUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun validEntries(): Long = validEntries.getRequired("validEntries")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun drawnAt(): Optional<OffsetDateTime> = drawnAt.getOptional("drawnAt")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [totalEntries].
     *
     * Unlike [totalEntries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalEntries")
    @ExcludeMissing
    fun _totalEntries(): JsonField<Long> = totalEntries

    /**
     * Returns the raw JSON value of [tweetUrl].
     *
     * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetUrl") @ExcludeMissing fun _tweetUrl(): JsonField<String> = tweetUrl

    /**
     * Returns the raw JSON value of [validEntries].
     *
     * Unlike [validEntries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("validEntries")
    @ExcludeMissing
    fun _validEntries(): JsonField<Long> = validEntries

    /**
     * Returns the raw JSON value of [drawnAt].
     *
     * Unlike [drawnAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("drawnAt") @ExcludeMissing fun _drawnAt(): JsonField<OffsetDateTime> = drawnAt

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
         * Returns a mutable builder for constructing an instance of [DrawListItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .status()
         * .totalEntries()
         * .tweetUrl()
         * .validEntries()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DrawListItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var status: JsonField<String>? = null
        private var totalEntries: JsonField<Long>? = null
        private var tweetUrl: JsonField<String>? = null
        private var validEntries: JsonField<Long>? = null
        private var drawnAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(drawListItem: DrawListItem) = apply {
            id = drawListItem.id
            createdAt = drawListItem.createdAt
            status = drawListItem.status
            totalEntries = drawListItem.totalEntries
            tweetUrl = drawListItem.tweetUrl
            validEntries = drawListItem.validEntries
            drawnAt = drawListItem.drawnAt
            additionalProperties = drawListItem.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun totalEntries(totalEntries: Long) = totalEntries(JsonField.of(totalEntries))

        /**
         * Sets [Builder.totalEntries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalEntries] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalEntries(totalEntries: JsonField<Long>) = apply { this.totalEntries = totalEntries }

        fun tweetUrl(tweetUrl: String) = tweetUrl(JsonField.of(tweetUrl))

        /**
         * Sets [Builder.tweetUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetUrl(tweetUrl: JsonField<String>) = apply { this.tweetUrl = tweetUrl }

        fun validEntries(validEntries: Long) = validEntries(JsonField.of(validEntries))

        /**
         * Sets [Builder.validEntries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.validEntries] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun validEntries(validEntries: JsonField<Long>) = apply { this.validEntries = validEntries }

        fun drawnAt(drawnAt: OffsetDateTime) = drawnAt(JsonField.of(drawnAt))

        /**
         * Sets [Builder.drawnAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.drawnAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun drawnAt(drawnAt: JsonField<OffsetDateTime>) = apply { this.drawnAt = drawnAt }

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
         * Returns an immutable instance of [DrawListItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .status()
         * .totalEntries()
         * .tweetUrl()
         * .validEntries()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DrawListItem =
            DrawListItem(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("status", status),
                checkRequired("totalEntries", totalEntries),
                checkRequired("tweetUrl", tweetUrl),
                checkRequired("validEntries", validEntries),
                drawnAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DrawListItem = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        status()
        totalEntries()
        tweetUrl()
        validEntries()
        drawnAt()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (totalEntries.asKnown().isPresent) 1 else 0) +
            (if (tweetUrl.asKnown().isPresent) 1 else 0) +
            (if (validEntries.asKnown().isPresent) 1 else 0) +
            (if (drawnAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DrawListItem &&
            id == other.id &&
            createdAt == other.createdAt &&
            status == other.status &&
            totalEntries == other.totalEntries &&
            tweetUrl == other.tweetUrl &&
            validEntries == other.validEntries &&
            drawnAt == other.drawnAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            status,
            totalEntries,
            tweetUrl,
            validEntries,
            drawnAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DrawListItem{id=$id, createdAt=$createdAt, status=$status, totalEntries=$totalEntries, tweetUrl=$tweetUrl, validEntries=$validEntries, drawnAt=$drawnAt, additionalProperties=$additionalProperties}"
}
