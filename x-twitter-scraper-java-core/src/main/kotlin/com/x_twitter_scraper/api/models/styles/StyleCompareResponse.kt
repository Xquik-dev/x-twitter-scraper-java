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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class StyleCompareResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val style1: JsonField<StyleProfile>,
    private val style2: JsonField<StyleProfile>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("style1") @ExcludeMissing style1: JsonField<StyleProfile> = JsonMissing.of(),
        @JsonProperty("style2") @ExcludeMissing style2: JsonField<StyleProfile> = JsonMissing.of(),
    ) : this(style1, style2, mutableMapOf())

    /**
     * Full style profile with sampled tweets used for tone analysis.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun style1(): StyleProfile = style1.getRequired("style1")

    /**
     * Full style profile with sampled tweets used for tone analysis.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun style2(): StyleProfile = style2.getRequired("style2")

    /**
     * Returns the raw JSON value of [style1].
     *
     * Unlike [style1], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("style1") @ExcludeMissing fun _style1(): JsonField<StyleProfile> = style1

    /**
     * Returns the raw JSON value of [style2].
     *
     * Unlike [style2], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("style2") @ExcludeMissing fun _style2(): JsonField<StyleProfile> = style2

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
         * Returns a mutable builder for constructing an instance of [StyleCompareResponse].
         *
         * The following fields are required:
         * ```java
         * .style1()
         * .style2()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StyleCompareResponse]. */
    class Builder internal constructor() {

        private var style1: JsonField<StyleProfile>? = null
        private var style2: JsonField<StyleProfile>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(styleCompareResponse: StyleCompareResponse) = apply {
            style1 = styleCompareResponse.style1
            style2 = styleCompareResponse.style2
            additionalProperties = styleCompareResponse.additionalProperties.toMutableMap()
        }

        /** Full style profile with sampled tweets used for tone analysis. */
        fun style1(style1: StyleProfile) = style1(JsonField.of(style1))

        /**
         * Sets [Builder.style1] to an arbitrary JSON value.
         *
         * You should usually call [Builder.style1] with a well-typed [StyleProfile] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun style1(style1: JsonField<StyleProfile>) = apply { this.style1 = style1 }

        /** Full style profile with sampled tweets used for tone analysis. */
        fun style2(style2: StyleProfile) = style2(JsonField.of(style2))

        /**
         * Sets [Builder.style2] to an arbitrary JSON value.
         *
         * You should usually call [Builder.style2] with a well-typed [StyleProfile] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun style2(style2: JsonField<StyleProfile>) = apply { this.style2 = style2 }

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
         * Returns an immutable instance of [StyleCompareResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .style1()
         * .style2()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StyleCompareResponse =
            StyleCompareResponse(
                checkRequired("style1", style1),
                checkRequired("style2", style2),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StyleCompareResponse = apply {
        if (validated) {
            return@apply
        }

        style1().validate()
        style2().validate()
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
        (style1.asKnown().getOrNull()?.validity() ?: 0) +
            (style2.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StyleCompareResponse &&
            style1 == other.style1 &&
            style2 == other.style2 &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(style1, style2, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StyleCompareResponse{style1=$style1, style2=$style2, additionalProperties=$additionalProperties}"
}
