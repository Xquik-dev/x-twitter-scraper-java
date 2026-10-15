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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class XGetHashflagsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val hashflags: JsonField<List<Hashflag>>,
    private val total: JsonField<Long>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hashflags")
        @ExcludeMissing
        hashflags: JsonField<List<Hashflag>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(count, hashflags, total, message, mutableMapOf())

    /**
     * Hashflags returned & charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hashflags(): List<Hashflag> = hashflags.getRequired("hashflags")

    /**
     * Hashflags that match the filters, before limit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun total(): Long = total.getRequired("total")

    /**
     * What to send instead. Present only when no hashflag matches.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [hashflags].
     *
     * Unlike [hashflags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hashflags")
    @ExcludeMissing
    fun _hashflags(): JsonField<List<Hashflag>> = hashflags

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
         * Returns a mutable builder for constructing an instance of [XGetHashflagsResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .hashflags()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetHashflagsResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var hashflags: JsonField<MutableList<Hashflag>>? = null
        private var total: JsonField<Long>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetHashflagsResponse: XGetHashflagsResponse) = apply {
            count = xGetHashflagsResponse.count
            hashflags = xGetHashflagsResponse.hashflags.map { it.toMutableList() }
            total = xGetHashflagsResponse.total
            message = xGetHashflagsResponse.message
            additionalProperties = xGetHashflagsResponse.additionalProperties.toMutableMap()
        }

        /** Hashflags returned & charged. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun hashflags(hashflags: List<Hashflag>) = hashflags(JsonField.of(hashflags))

        /** Sets [Builder.hashflags] to an arbitrary JSON value. */
        fun hashflags(hashflags: JsonField<List<Hashflag>>) = apply {
            this.hashflags = hashflags.map { it.toMutableList() }
        }

        /**
         * Adds a single [Hashflag] to [hashflags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addHashflag(hashflag: Hashflag) = apply {
            hashflags =
                (hashflags ?: JsonField.of(mutableListOf())).also {
                    checkKnown("hashflags", it).add(hashflag)
                }
        }

        /** Hashflags that match the filters, before limit. */
        fun total(total: Long) = total(JsonField.of(total))

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /** What to send instead. Present only when no hashflag matches. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

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
         * Returns an immutable instance of [XGetHashflagsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .hashflags()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetHashflagsResponse =
            XGetHashflagsResponse(
                checkRequired("count", count),
                checkRequired("hashflags", hashflags).map { it.toImmutable() },
                checkRequired("total", total),
                message,
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
    fun validate(): XGetHashflagsResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        hashflags().forEach { it.validate() }
        total()
        message()
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
            (hashflags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    /** A custom emoji X shows after a hashtag for a set time. */
    class Hashflag
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val animations: JsonField<List<Animation>>,
        private val assetUrl: JsonField<String>,
        private val endsAt: JsonField<OffsetDateTime>,
        private val hashtag: JsonField<String>,
        private val isHashfettiEnabled: JsonField<Boolean>,
        private val startsAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("animations")
            @ExcludeMissing
            animations: JsonField<List<Animation>> = JsonMissing.of(),
            @JsonProperty("assetUrl")
            @ExcludeMissing
            assetUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("endsAt")
            @ExcludeMissing
            endsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("hashtag") @ExcludeMissing hashtag: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isHashfettiEnabled")
            @ExcludeMissing
            isHashfettiEnabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("startsAt")
            @ExcludeMissing
            startsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            animations,
            assetUrl,
            endsAt,
            hashtag,
            isHashfettiEnabled,
            startsAt,
            mutableMapOf(),
        )

        /**
         * Animations X plays for the hashtag, such as on a like. Often empty.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun animations(): List<Animation> = animations.getRequired("animations")

        /**
         * Image of the emoji.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun assetUrl(): String = assetUrl.getRequired("assetUrl")

        /**
         * When X stops showing the emoji, in UTC.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun endsAt(): OffsetDateTime = endsAt.getRequired("endsAt")

        /**
         * Hashtag text without the hash sign. X also lists some plain phrases.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun hashtag(): String = hashtag.getRequired("hashtag")

        /**
         * Whether X marks the hashflag for its hashfetti effect.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun isHashfettiEnabled(): Boolean = isHashfettiEnabled.getRequired("isHashfettiEnabled")

        /**
         * When X starts showing the emoji, in UTC.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun startsAt(): OffsetDateTime = startsAt.getRequired("startsAt")

        /**
         * Returns the raw JSON value of [animations].
         *
         * Unlike [animations], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("animations")
        @ExcludeMissing
        fun _animations(): JsonField<List<Animation>> = animations

        /**
         * Returns the raw JSON value of [assetUrl].
         *
         * Unlike [assetUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("assetUrl") @ExcludeMissing fun _assetUrl(): JsonField<String> = assetUrl

        /**
         * Returns the raw JSON value of [endsAt].
         *
         * Unlike [endsAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endsAt") @ExcludeMissing fun _endsAt(): JsonField<OffsetDateTime> = endsAt

        /**
         * Returns the raw JSON value of [hashtag].
         *
         * Unlike [hashtag], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hashtag") @ExcludeMissing fun _hashtag(): JsonField<String> = hashtag

        /**
         * Returns the raw JSON value of [isHashfettiEnabled].
         *
         * Unlike [isHashfettiEnabled], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("isHashfettiEnabled")
        @ExcludeMissing
        fun _isHashfettiEnabled(): JsonField<Boolean> = isHashfettiEnabled

        /**
         * Returns the raw JSON value of [startsAt].
         *
         * Unlike [startsAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("startsAt")
        @ExcludeMissing
        fun _startsAt(): JsonField<OffsetDateTime> = startsAt

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
             * Returns a mutable builder for constructing an instance of [Hashflag].
             *
             * The following fields are required:
             * ```java
             * .animations()
             * .assetUrl()
             * .endsAt()
             * .hashtag()
             * .isHashfettiEnabled()
             * .startsAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Hashflag]. */
        class Builder internal constructor() {

            private var animations: JsonField<MutableList<Animation>>? = null
            private var assetUrl: JsonField<String>? = null
            private var endsAt: JsonField<OffsetDateTime>? = null
            private var hashtag: JsonField<String>? = null
            private var isHashfettiEnabled: JsonField<Boolean>? = null
            private var startsAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hashflag: Hashflag) = apply {
                animations = hashflag.animations.map { it.toMutableList() }
                assetUrl = hashflag.assetUrl
                endsAt = hashflag.endsAt
                hashtag = hashflag.hashtag
                isHashfettiEnabled = hashflag.isHashfettiEnabled
                startsAt = hashflag.startsAt
                additionalProperties = hashflag.additionalProperties.toMutableMap()
            }

            /** Animations X plays for the hashtag, such as on a like. Often empty. */
            fun animations(animations: List<Animation>) = animations(JsonField.of(animations))

            /** Sets [Builder.animations] to an arbitrary JSON value. */
            fun animations(animations: JsonField<List<Animation>>) = apply {
                this.animations = animations.map { it.toMutableList() }
            }

            /**
             * Adds a single [Animation] to [animations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAnimation(animation: Animation) = apply {
                animations =
                    (animations ?: JsonField.of(mutableListOf())).also {
                        checkKnown("animations", it).add(animation)
                    }
            }

            /** Image of the emoji. */
            fun assetUrl(assetUrl: String) = assetUrl(JsonField.of(assetUrl))

            /** Sets [Builder.assetUrl] to an arbitrary JSON value. */
            fun assetUrl(assetUrl: JsonField<String>) = apply { this.assetUrl = assetUrl }

            /** When X stops showing the emoji, in UTC. */
            fun endsAt(endsAt: OffsetDateTime) = endsAt(JsonField.of(endsAt))

            /** Sets [Builder.endsAt] to an arbitrary JSON value. */
            fun endsAt(endsAt: JsonField<OffsetDateTime>) = apply { this.endsAt = endsAt }

            /** Hashtag text without the hash sign. X also lists some plain phrases. */
            fun hashtag(hashtag: String) = hashtag(JsonField.of(hashtag))

            /** Sets [Builder.hashtag] to an arbitrary JSON value. */
            fun hashtag(hashtag: JsonField<String>) = apply { this.hashtag = hashtag }

            /** Whether X marks the hashflag for its hashfetti effect. */
            fun isHashfettiEnabled(isHashfettiEnabled: Boolean) =
                isHashfettiEnabled(JsonField.of(isHashfettiEnabled))

            /** Sets [Builder.isHashfettiEnabled] to an arbitrary JSON value. */
            fun isHashfettiEnabled(isHashfettiEnabled: JsonField<Boolean>) = apply {
                this.isHashfettiEnabled = isHashfettiEnabled
            }

            /** When X starts showing the emoji, in UTC. */
            fun startsAt(startsAt: OffsetDateTime) = startsAt(JsonField.of(startsAt))

            /** Sets [Builder.startsAt] to an arbitrary JSON value. */
            fun startsAt(startsAt: JsonField<OffsetDateTime>) = apply { this.startsAt = startsAt }

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
             * Returns an immutable instance of [Hashflag].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .animations()
             * .assetUrl()
             * .endsAt()
             * .hashtag()
             * .isHashfettiEnabled()
             * .startsAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Hashflag =
                Hashflag(
                    checkRequired("animations", animations).map { it.toImmutable() },
                    checkRequired("assetUrl", assetUrl),
                    checkRequired("endsAt", endsAt),
                    checkRequired("hashtag", hashtag),
                    checkRequired("isHashfettiEnabled", isHashfettiEnabled),
                    checkRequired("startsAt", startsAt),
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
        fun validate(): Hashflag = apply {
            if (validated) {
                return@apply
            }

            animations().forEach { it.validate() }
            assetUrl()
            endsAt()
            hashtag()
            isHashfettiEnabled()
            startsAt()
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
            (animations.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (assetUrl.asKnown().isPresent) 1 else 0) +
                (if (endsAt.asKnown().isPresent) 1 else 0) +
                (if (hashtag.asKnown().isPresent) 1 else 0) +
                (if (isHashfettiEnabled.asKnown().isPresent) 1 else 0) +
                (if (startsAt.asKnown().isPresent) 1 else 0)

        class Animation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val assetUrl: JsonField<String>,
            private val context: JsonField<String>,
            private val priority: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("assetUrl")
                @ExcludeMissing
                assetUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("context")
                @ExcludeMissing
                context: JsonField<String> = JsonMissing.of(),
                @JsonProperty("priority")
                @ExcludeMissing
                priority: JsonField<Double> = JsonMissing.of(),
            ) : this(assetUrl, context, priority, mutableMapOf())

            /**
             * Animation file.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun assetUrl(): String = assetUrl.getRequired("assetUrl")

            /**
             * What plays the animation, such as Like.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun context(): Optional<String> = context.getOptional("context")

            /**
             * X's order among the animations of a hashtag.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun priority(): Optional<Double> = priority.getOptional("priority")

            /**
             * Returns the raw JSON value of [assetUrl].
             *
             * Unlike [assetUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("assetUrl") @ExcludeMissing fun _assetUrl(): JsonField<String> = assetUrl

            /**
             * Returns the raw JSON value of [context].
             *
             * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<String> = context

            /**
             * Returns the raw JSON value of [priority].
             *
             * Unlike [priority], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("priority") @ExcludeMissing fun _priority(): JsonField<Double> = priority

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
                 * Returns a mutable builder for constructing an instance of [Animation].
                 *
                 * The following fields are required:
                 * ```java
                 * .assetUrl()
                 * .context()
                 * .priority()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Animation]. */
            class Builder internal constructor() {

                private var assetUrl: JsonField<String>? = null
                private var context: JsonField<String>? = null
                private var priority: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(animation: Animation) = apply {
                    assetUrl = animation.assetUrl
                    context = animation.context
                    priority = animation.priority
                    additionalProperties = animation.additionalProperties.toMutableMap()
                }

                /** Animation file. */
                fun assetUrl(assetUrl: String) = assetUrl(JsonField.of(assetUrl))

                /** Sets [Builder.assetUrl] to an arbitrary JSON value. */
                fun assetUrl(assetUrl: JsonField<String>) = apply { this.assetUrl = assetUrl }

                /** What plays the animation, such as Like. */
                fun context(context: String?) = context(JsonField.ofNullable(context))

                /** Alias for calling [Builder.context] with `context.orElse(null)`. */
                fun context(context: Optional<String>) = context(context.getOrNull())

                /** Sets [Builder.context] to an arbitrary JSON value. */
                fun context(context: JsonField<String>) = apply { this.context = context }

                /** X's order among the animations of a hashtag. */
                fun priority(priority: Double?) = priority(JsonField.ofNullable(priority))

                /** Alias for [Builder.priority]. */
                fun priority(priority: Double) = priority(priority as Double?)

                /** Alias for calling [Builder.priority] with `priority.orElse(null)`. */
                fun priority(priority: Optional<Double>) = priority(priority.getOrNull())

                /** Sets [Builder.priority] to an arbitrary JSON value. */
                fun priority(priority: JsonField<Double>) = apply { this.priority = priority }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Animation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .assetUrl()
                 * .context()
                 * .priority()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Animation =
                    Animation(
                        checkRequired("assetUrl", assetUrl),
                        checkRequired("context", context),
                        checkRequired("priority", priority),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Animation = apply {
                if (validated) {
                    return@apply
                }

                assetUrl()
                context()
                priority()
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
                (if (assetUrl.asKnown().isPresent) 1 else 0) +
                    (if (context.asKnown().isPresent) 1 else 0) +
                    (if (priority.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Animation &&
                    assetUrl == other.assetUrl &&
                    context == other.context &&
                    priority == other.priority &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(assetUrl, context, priority, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Animation{assetUrl=$assetUrl, context=$context, priority=$priority, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Hashflag &&
                animations == other.animations &&
                assetUrl == other.assetUrl &&
                endsAt == other.endsAt &&
                hashtag == other.hashtag &&
                isHashfettiEnabled == other.isHashfettiEnabled &&
                startsAt == other.startsAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                animations,
                assetUrl,
                endsAt,
                hashtag,
                isHashfettiEnabled,
                startsAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hashflag{animations=$animations, assetUrl=$assetUrl, endsAt=$endsAt, hashtag=$hashtag, isHashfettiEnabled=$isHashfettiEnabled, startsAt=$startsAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetHashflagsResponse &&
            count == other.count &&
            hashflags == other.hashflags &&
            total == other.total &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(count, hashflags, total, message, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetHashflagsResponse{count=$count, hashflags=$hashflags, total=$total, message=$message, additionalProperties=$additionalProperties}"
}
