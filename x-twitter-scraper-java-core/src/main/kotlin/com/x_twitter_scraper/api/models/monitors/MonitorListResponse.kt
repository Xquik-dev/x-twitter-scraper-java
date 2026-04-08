// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

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

class MonitorListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val monitors: JsonField<List<Monitor>>,
    private val total: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("monitors")
        @ExcludeMissing
        monitors: JsonField<List<Monitor>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
    ) : this(monitors, total, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun monitors(): List<Monitor> = monitors.getRequired("monitors")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun total(): Long = total.getRequired("total")

    /**
     * Returns the raw JSON value of [monitors].
     *
     * Unlike [monitors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitors") @ExcludeMissing fun _monitors(): JsonField<List<Monitor>> = monitors

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
         * Returns a mutable builder for constructing an instance of [MonitorListResponse].
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MonitorListResponse]. */
    class Builder internal constructor() {

        private var monitors: JsonField<MutableList<Monitor>>? = null
        private var total: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(monitorListResponse: MonitorListResponse) = apply {
            monitors = monitorListResponse.monitors.map { it.toMutableList() }
            total = monitorListResponse.total
            additionalProperties = monitorListResponse.additionalProperties.toMutableMap()
        }

        fun monitors(monitors: List<Monitor>) = monitors(JsonField.of(monitors))

        /**
         * Sets [Builder.monitors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.monitors] with a well-typed `List<Monitor>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun monitors(monitors: JsonField<List<Monitor>>) = apply {
            this.monitors = monitors.map { it.toMutableList() }
        }

        /**
         * Adds a single [Monitor] to [monitors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMonitor(monitor: Monitor) = apply {
            monitors =
                (monitors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("monitors", it).add(monitor)
                }
        }

        fun total(total: Long) = total(JsonField.of(total))

        /**
         * Sets [Builder.total] to an arbitrary JSON value.
         *
         * You should usually call [Builder.total] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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
         * Returns an immutable instance of [MonitorListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MonitorListResponse =
            MonitorListResponse(
                checkRequired("monitors", monitors).map { it.toImmutable() },
                checkRequired("total", total),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MonitorListResponse = apply {
        if (validated) {
            return@apply
        }

        monitors().forEach { it.validate() }
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (monitors.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MonitorListResponse &&
            monitors == other.monitors &&
            total == other.total &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(monitors, total, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MonitorListResponse{monitors=$monitors, total=$total, additionalProperties=$additionalProperties}"
}
