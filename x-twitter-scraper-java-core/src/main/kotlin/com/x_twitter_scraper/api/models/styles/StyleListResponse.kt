// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

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

class StyleListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val styles: JsonField<List<StyleProfileSummary>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("styles")
        @ExcludeMissing
        styles: JsonField<List<StyleProfileSummary>> = JsonMissing.of()
    ) : this(styles, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun styles(): List<StyleProfileSummary> = styles.getRequired("styles")

    /**
     * Returns the raw JSON value of [styles].
     *
     * Unlike [styles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("styles")
    @ExcludeMissing
    fun _styles(): JsonField<List<StyleProfileSummary>> = styles

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
         * Returns a mutable builder for constructing an instance of [StyleListResponse].
         *
         * The following fields are required:
         * ```java
         * .styles()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StyleListResponse]. */
    class Builder internal constructor() {

        private var styles: JsonField<MutableList<StyleProfileSummary>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(styleListResponse: StyleListResponse) = apply {
            styles = styleListResponse.styles.map { it.toMutableList() }
            additionalProperties = styleListResponse.additionalProperties.toMutableMap()
        }

        fun styles(styles: List<StyleProfileSummary>) = styles(JsonField.of(styles))

        /**
         * Sets [Builder.styles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.styles] with a well-typed `List<StyleProfileSummary>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun styles(styles: JsonField<List<StyleProfileSummary>>) = apply {
            this.styles = styles.map { it.toMutableList() }
        }

        /**
         * Adds a single [StyleProfileSummary] to [styles].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStyle(style: StyleProfileSummary) = apply {
            styles =
                (styles ?: JsonField.of(mutableListOf())).also {
                    checkKnown("styles", it).add(style)
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
         * Returns an immutable instance of [StyleListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .styles()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StyleListResponse =
            StyleListResponse(
                checkRequired("styles", styles).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StyleListResponse = apply {
        if (validated) {
            return@apply
        }

        styles().forEach { it.validate() }
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
        (styles.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StyleListResponse &&
            styles == other.styles &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(styles, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StyleListResponse{styles=$styles, additionalProperties=$additionalProperties}"
}
