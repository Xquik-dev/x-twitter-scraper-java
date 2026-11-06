// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.posts

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a monitor for 1 X post. It tracks replies, quotes, edits, deletion & 6 metrics, for 30
 * credits an hour with events & webhook deliveries included. That hourly price is a monitor's only
 * charge. Creation needs the credits of the first hour & reads the post once.
 */
class PostCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Post event types to send. Without it, a monitor sends new replies, new quotes, like & retweet
     * changes, edits & deletion.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun eventTypes(): Optional<List<PostMonitor.EventType>> = body.eventTypes()

    /**
     * Post link or ID. x.com, twitter.com, mobile & /i/web/status/ links work with any query
     * string.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun post(): String = body.post()

    /**
     * Send false to create the monitor paused. A paused monitor reads nothing & costs nothing until
     * a PATCH sets isActive to true.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun isActive(): Optional<Boolean> = body.isActive()

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _eventTypes(): JsonField<List<PostMonitor.EventType>> = body._eventTypes()

    /**
     * Returns the raw JSON value of [post].
     *
     * Unlike [post], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _post(): JsonField<String> = body._post()

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isActive(): JsonField<Boolean> = body._isActive()

    /**
     * Your own label for the post monitor. Its events carry it as monitorName.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun name(): Optional<String> = body.name()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PostCreateParams].
         *
         * The following fields are required:
         * ```java
         * .post()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(postCreateParams: PostCreateParams) = apply {
            body = postCreateParams.body.toBuilder()
            additionalHeaders = postCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = postCreateParams.additionalQueryParams.toBuilder()
        }

        /** Sets the entire request body. */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Post event types to send. Without it, a monitor sends new replies, new quotes, like &
         * retweet changes, edits & deletion.
         */
        fun eventTypes(eventTypes: List<PostMonitor.EventType>) = apply {
            body.eventTypes(eventTypes)
        }

        /** Sets [Builder.eventTypes] to an arbitrary JSON value. */
        fun eventTypes(eventTypes: JsonField<List<PostMonitor.EventType>>) = apply {
            body.eventTypes(eventTypes)
        }

        /**
         * Adds a single [PostMonitor.EventType] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: PostMonitor.EventType) = apply { body.addEventType(eventType) }

        /**
         * Post link or ID. x.com, twitter.com, mobile & /i/web/status/ links work with any query
         * string.
         */
        fun post(post: String) = apply { body.post(post) }

        /** Sets [Builder.post] to an arbitrary JSON value. */
        fun post(post: JsonField<String>) = apply { body.post(post) }

        /**
         * Send false to create the monitor paused. A paused monitor reads nothing & costs nothing
         * until a PATCH sets isActive to true.
         */
        fun isActive(isActive: Boolean) = apply { body.isActive(isActive) }

        /** Sets [Builder.isActive] to an arbitrary JSON value. */
        fun isActive(isActive: JsonField<Boolean>) = apply { body.isActive(isActive) }

        /** Your own label for the post monitor. Its events carry it as monitorName. */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [PostCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .post()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostCreateParams =
            PostCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val eventTypes: JsonField<List<PostMonitor.EventType>>,
        private val post: JsonField<String>,
        private val isActive: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("eventTypes")
            @ExcludeMissing
            eventTypes: JsonField<List<PostMonitor.EventType>> = JsonMissing.of(),
            @JsonProperty("post") @ExcludeMissing post: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isActive")
            @ExcludeMissing
            isActive: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(
            eventTypes,
            post,
            isActive,
            name,
            mutableMapOf(),
        )

        /**
         * Post event types to send. Without it, a monitor sends new replies, new quotes, like &
         * retweet changes, edits & deletion.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun eventTypes(): Optional<List<PostMonitor.EventType>> =
            eventTypes.getOptional("eventTypes")

        /**
         * Post link or ID. x.com, twitter.com, mobile & /i/web/status/ links work with any query
         * string.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun post(): String = post.getRequired("post")

        /**
         * Send false to create the monitor paused. A paused monitor reads nothing & costs nothing
         * until a PATCH sets isActive to true.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isActive(): Optional<Boolean> = isActive.getOptional("isActive")

        /**
         * Your own label for the post monitor. Its events carry it as monitorName.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [eventTypes].
         *
         * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("eventTypes")
        @ExcludeMissing
        fun _eventTypes(): JsonField<List<PostMonitor.EventType>> = eventTypes

        /**
         * Returns the raw JSON value of [post].
         *
         * Unlike [post], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("post") @ExcludeMissing fun _post(): JsonField<String> = post

        /**
         * Returns the raw JSON value of [isActive].
         *
         * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .post()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var eventTypes: JsonField<MutableList<PostMonitor.EventType>>? = null
            private var post: JsonField<String>? = null
            private var isActive: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                eventTypes = body.eventTypes.map { it.toMutableList() }
                post = body.post
                isActive = body.isActive
                name = body.name
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Post event types to send. Without it, a monitor sends new replies, new quotes, like &
             * retweet changes, edits & deletion.
             */
            fun eventTypes(eventTypes: List<PostMonitor.EventType>) =
                eventTypes(JsonField.of(eventTypes))

            /** Sets [Builder.eventTypes] to an arbitrary JSON value. */
            fun eventTypes(eventTypes: JsonField<List<PostMonitor.EventType>>) = apply {
                this.eventTypes = eventTypes.map { it.toMutableList() }
            }

            /**
             * Adds a single [PostMonitor.EventType] to [eventTypes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEventType(eventType: PostMonitor.EventType) = apply {
                eventTypes =
                    (eventTypes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("eventTypes", it).add(eventType)
                    }
            }

            /**
             * Post link or ID. x.com, twitter.com, mobile & /i/web/status/ links work with any
             * query string.
             */
            fun post(post: String) = post(JsonField.of(post))

            /** Sets [Builder.post] to an arbitrary JSON value. */
            fun post(post: JsonField<String>) = apply { this.post = post }

            /**
             * Send false to create the monitor paused. A paused monitor reads nothing & costs
             * nothing until a PATCH sets isActive to true.
             */
            fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

            /** Sets [Builder.isActive] to an arbitrary JSON value. */
            fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

            /** Your own label for the post monitor. Its events carry it as monitorName. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .post()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("post", post),
                    isActive,
                    name,
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            eventTypes().ifPresent { it.forEach { it.validate() } }
            post()
            isActive()
            name()
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
            (eventTypes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (post.asKnown().isPresent) 1 else 0) +
                (if (isActive.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                eventTypes == other.eventTypes &&
                post == other.post &&
                isActive == other.isActive &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventTypes, post, isActive, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{eventTypes=$eventTypes, post=$post, isActive=$isActive, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "PostCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
