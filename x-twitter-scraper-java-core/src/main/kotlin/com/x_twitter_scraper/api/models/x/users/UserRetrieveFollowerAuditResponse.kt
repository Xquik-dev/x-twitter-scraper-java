// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

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

class UserRetrieveFollowerAuditResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audit: JsonField<FollowerAudit>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audit") @ExcludeMissing audit: JsonField<FollowerAudit> = JsonMissing.of()
    ) : this(audit, mutableMapOf())

    /**
     * Report on the followers read. Classes rest on public profile signals, so they say what a
     * profile looks like, never who runs it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun audit(): FollowerAudit = audit.getRequired("audit")

    /**
     * Returns the raw JSON value of [audit].
     *
     * Unlike [audit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audit") @ExcludeMissing fun _audit(): JsonField<FollowerAudit> = audit

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
         * [UserRetrieveFollowerAuditResponse].
         *
         * The following fields are required:
         * ```java
         * .audit()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveFollowerAuditResponse]. */
    class Builder internal constructor() {

        private var audit: JsonField<FollowerAudit>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveFollowerAuditResponse: UserRetrieveFollowerAuditResponse) =
            apply {
                audit = userRetrieveFollowerAuditResponse.audit
                additionalProperties =
                    userRetrieveFollowerAuditResponse.additionalProperties.toMutableMap()
            }

        /**
         * Report on the followers read. Classes rest on public profile signals, so they say what a
         * profile looks like, never who runs it.
         */
        fun audit(audit: FollowerAudit) = audit(JsonField.of(audit))

        /** Sets [Builder.audit] to an arbitrary JSON value. */
        fun audit(audit: JsonField<FollowerAudit>) = apply { this.audit = audit }

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
         * Returns an immutable instance of [UserRetrieveFollowerAuditResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audit()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveFollowerAuditResponse =
            UserRetrieveFollowerAuditResponse(
                checkRequired("audit", audit),
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
    fun validate(): UserRetrieveFollowerAuditResponse = apply {
        if (validated) {
            return@apply
        }

        audit().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (audit.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveFollowerAuditResponse &&
            audit == other.audit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(audit, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveFollowerAuditResponse{audit=$audit, additionalProperties=$additionalProperties}"
}
