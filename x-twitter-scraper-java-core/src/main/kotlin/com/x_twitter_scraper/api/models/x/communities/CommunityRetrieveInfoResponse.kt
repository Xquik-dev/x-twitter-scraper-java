// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

class CommunityRetrieveInfoResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val community: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("community") @ExcludeMissing community: JsonValue = JsonMissing.of()
    ) : this(community, mutableMapOf())

    /**
     * Community info object
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = communityRetrieveInfoResponse.community().convert(MyClass.class);
     * ```
     */
    @JsonProperty("community") @ExcludeMissing fun _community(): JsonValue = community

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
         * [CommunityRetrieveInfoResponse].
         *
         * The following fields are required:
         * ```java
         * .community()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityRetrieveInfoResponse]. */
    class Builder internal constructor() {

        private var community: JsonValue? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityRetrieveInfoResponse: CommunityRetrieveInfoResponse) = apply {
            community = communityRetrieveInfoResponse.community
            additionalProperties = communityRetrieveInfoResponse.additionalProperties.toMutableMap()
        }

        /** Community info object */
        fun community(community: JsonValue) = apply { this.community = community }

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
         * Returns an immutable instance of [CommunityRetrieveInfoResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .community()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse(
                checkRequired("community", community),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CommunityRetrieveInfoResponse = apply {
        if (validated) {
            return@apply
        }

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
    @JvmSynthetic internal fun validity(): Int = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityRetrieveInfoResponse &&
            community == other.community &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(community, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityRetrieveInfoResponse{community=$community, additionalProperties=$additionalProperties}"
}
