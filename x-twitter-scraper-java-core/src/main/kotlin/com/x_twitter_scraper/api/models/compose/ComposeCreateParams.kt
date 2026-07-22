// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Run one step of Xquik's three-step writing workflow. Compose returns questions and editorial
 * rules. Refine returns goal-specific guidance. Score applies deterministic text checks. It does
 * not predict reach or expose X ranking weights.
 */
class ComposeCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun body(): Body = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ComposeCreateParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComposeCreateParams]. */
    class Builder internal constructor() {

        private var body: Body? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(composeCreateParams: ComposeCreateParams) = apply {
            body = composeCreateParams.body
            additionalHeaders = composeCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = composeCreateParams.additionalQueryParams.toBuilder()
        }

        fun body(body: Body) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofComposePrepareRequest(composePrepareRequest)`. */
        fun body(composePrepareRequest: Body.ComposePrepareRequest) =
            body(Body.ofComposePrepareRequest(composePrepareRequest))

        /** Alias for calling [body] with `Body.ofComposeRefineRequest(composeRefineRequest)`. */
        fun body(composeRefineRequest: Body.ComposeRefineRequest) =
            body(Body.ofComposeRefineRequest(composeRefineRequest))

        /** Alias for calling [body] with `Body.ofComposeScoreRequest(composeScoreRequest)`. */
        fun body(composeScoreRequest: Body.ComposeScoreRequest) =
            body(Body.ofComposeScoreRequest(composeScoreRequest))

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
         * Returns an immutable instance of [ComposeCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ComposeCreateParams =
            ComposeCreateParams(
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val composePrepareRequest: ComposePrepareRequest? = null,
        private val composeRefineRequest: ComposeRefineRequest? = null,
        private val composeScoreRequest: ComposeScoreRequest? = null,
        private val _json: JsonValue? = null,
    ) {

        fun composePrepareRequest(): Optional<ComposePrepareRequest> =
            Optional.ofNullable(composePrepareRequest)

        fun composeRefineRequest(): Optional<ComposeRefineRequest> =
            Optional.ofNullable(composeRefineRequest)

        fun composeScoreRequest(): Optional<ComposeScoreRequest> =
            Optional.ofNullable(composeScoreRequest)

        fun isComposePrepareRequest(): Boolean = composePrepareRequest != null

        fun isComposeRefineRequest(): Boolean = composeRefineRequest != null

        fun isComposeScoreRequest(): Boolean = composeScoreRequest != null

        fun asComposePrepareRequest(): ComposePrepareRequest =
            composePrepareRequest.getOrThrow("composePrepareRequest")

        fun asComposeRefineRequest(): ComposeRefineRequest =
            composeRefineRequest.getOrThrow("composeRefineRequest")

        fun asComposeScoreRequest(): ComposeScoreRequest =
            composeScoreRequest.getOrThrow("composeScoreRequest")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.x_twitter_scraper.api.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = body.accept(new Body.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitComposePrepareRequest(ComposePrepareRequest composePrepareRequest) {
         *         return Optional.of(composePrepareRequest.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                composePrepareRequest != null ->
                    visitor.visitComposePrepareRequest(composePrepareRequest)
                composeRefineRequest != null ->
                    visitor.visitComposeRefineRequest(composeRefineRequest)
                composeScoreRequest != null -> visitor.visitComposeScoreRequest(composeScoreRequest)
                else -> visitor.unknown(_json)
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

            accept(
                object : Visitor<Unit> {
                    override fun visitComposePrepareRequest(
                        composePrepareRequest: ComposePrepareRequest
                    ) {
                        composePrepareRequest.validate()
                    }

                    override fun visitComposeRefineRequest(
                        composeRefineRequest: ComposeRefineRequest
                    ) {
                        composeRefineRequest.validate()
                    }

                    override fun visitComposeScoreRequest(
                        composeScoreRequest: ComposeScoreRequest
                    ) {
                        composeScoreRequest.validate()
                    }
                }
            )
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitComposePrepareRequest(
                        composePrepareRequest: ComposePrepareRequest
                    ) = composePrepareRequest.validity()

                    override fun visitComposeRefineRequest(
                        composeRefineRequest: ComposeRefineRequest
                    ) = composeRefineRequest.validity()

                    override fun visitComposeScoreRequest(
                        composeScoreRequest: ComposeScoreRequest
                    ) = composeScoreRequest.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                composePrepareRequest == other.composePrepareRequest &&
                composeRefineRequest == other.composeRefineRequest &&
                composeScoreRequest == other.composeScoreRequest
        }

        override fun hashCode(): Int =
            Objects.hash(composePrepareRequest, composeRefineRequest, composeScoreRequest)

        override fun toString(): String =
            when {
                composePrepareRequest != null ->
                    "Body{composePrepareRequest=$composePrepareRequest}"
                composeRefineRequest != null -> "Body{composeRefineRequest=$composeRefineRequest}"
                composeScoreRequest != null -> "Body{composeScoreRequest=$composeScoreRequest}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            @JvmStatic
            fun ofComposePrepareRequest(composePrepareRequest: ComposePrepareRequest) =
                Body(composePrepareRequest = composePrepareRequest)

            @JvmStatic
            fun ofComposeRefineRequest(composeRefineRequest: ComposeRefineRequest) =
                Body(composeRefineRequest = composeRefineRequest)

            @JvmStatic
            fun ofComposeScoreRequest(composeScoreRequest: ComposeScoreRequest) =
                Body(composeScoreRequest = composeScoreRequest)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitComposePrepareRequest(composePrepareRequest: ComposePrepareRequest): T

            fun visitComposeRefineRequest(composeRefineRequest: ComposeRefineRequest): T

            fun visitComposeScoreRequest(composeScoreRequest: ComposeScoreRequest): T

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown Body: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<ComposePrepareRequest>())?.let {
                                Body(composePrepareRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ComposeRefineRequest>())?.let {
                                Body(composeRefineRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ComposeScoreRequest>())?.let {
                                Body(composeScoreRequest = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Body(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.composePrepareRequest != null ->
                        generator.writeObject(value.composePrepareRequest)
                    value.composeRefineRequest != null ->
                        generator.writeObject(value.composeRefineRequest)
                    value.composeScoreRequest != null ->
                        generator.writeObject(value.composeScoreRequest)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        class ComposePrepareRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val step: JsonValue,
            private val topic: JsonField<String>,
            private val goal: JsonField<Goal>,
            private val styleUsername: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("step") @ExcludeMissing step: JsonValue = JsonMissing.of(),
                @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
                @JsonProperty("goal") @ExcludeMissing goal: JsonField<Goal> = JsonMissing.of(),
                @JsonProperty("styleUsername")
                @ExcludeMissing
                styleUsername: JsonField<String> = JsonMissing.of(),
            ) : this(step, topic, goal, styleUsername, mutableMapOf())

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("compose")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("step") @ExcludeMissing fun _step(): JsonValue = step

            /**
             * Subject for the post.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun topic(): String = topic.getRequired("topic")

            /**
             * Editorial goal used to order the rules and questions.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun goal(): Optional<Goal> = goal.getOptional("goal")

            /**
             * Username from a style analysis saved to this account.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun styleUsername(): Optional<String> = styleUsername.getOptional("styleUsername")

            /**
             * Returns the raw JSON value of [topic].
             *
             * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("topic") @ExcludeMissing fun _topic(): JsonField<String> = topic

            /**
             * Returns the raw JSON value of [goal].
             *
             * Unlike [goal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("goal") @ExcludeMissing fun _goal(): JsonField<Goal> = goal

            /**
             * Returns the raw JSON value of [styleUsername].
             *
             * Unlike [styleUsername], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("styleUsername")
            @ExcludeMissing
            fun _styleUsername(): JsonField<String> = styleUsername

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
                 * [ComposePrepareRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .topic()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComposePrepareRequest]. */
            class Builder internal constructor() {

                private var step: JsonValue = JsonValue.from("compose")
                private var topic: JsonField<String>? = null
                private var goal: JsonField<Goal> = JsonMissing.of()
                private var styleUsername: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(composePrepareRequest: ComposePrepareRequest) = apply {
                    step = composePrepareRequest.step
                    topic = composePrepareRequest.topic
                    goal = composePrepareRequest.goal
                    styleUsername = composePrepareRequest.styleUsername
                    additionalProperties = composePrepareRequest.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("compose")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun step(step: JsonValue) = apply { this.step = step }

                /** Subject for the post. */
                fun topic(topic: String) = topic(JsonField.of(topic))

                /**
                 * Sets [Builder.topic] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.topic] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun topic(topic: JsonField<String>) = apply { this.topic = topic }

                /** Editorial goal used to order the rules and questions. */
                fun goal(goal: Goal) = goal(JsonField.of(goal))

                /**
                 * Sets [Builder.goal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.goal] with a well-typed [Goal] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun goal(goal: JsonField<Goal>) = apply { this.goal = goal }

                /** Username from a style analysis saved to this account. */
                fun styleUsername(styleUsername: String) =
                    styleUsername(JsonField.of(styleUsername))

                /**
                 * Sets [Builder.styleUsername] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.styleUsername] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun styleUsername(styleUsername: JsonField<String>) = apply {
                    this.styleUsername = styleUsername
                }

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
                 * Returns an immutable instance of [ComposePrepareRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .topic()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ComposePrepareRequest =
                    ComposePrepareRequest(
                        step,
                        checkRequired("topic", topic),
                        goal,
                        styleUsername,
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
            fun validate(): ComposePrepareRequest = apply {
                if (validated) {
                    return@apply
                }

                _step().let {
                    if (it != JsonValue.from("compose")) {
                        throw XTwitterScraperInvalidDataException("'step' is invalid, received $it")
                    }
                }
                topic()
                goal().ifPresent { it.validate() }
                styleUsername()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                step.let { if (it == JsonValue.from("compose")) 1 else 0 } +
                    (if (topic.asKnown().isPresent) 1 else 0) +
                    (goal.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (styleUsername.asKnown().isPresent) 1 else 0)

            /** Editorial goal used to order the rules and questions. */
            class Goal @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ENGAGEMENT = of("engagement")

                    @JvmField val FOLLOWERS = of("followers")

                    @JvmField val AUTHORITY = of("authority")

                    @JvmField val CONVERSATION = of("conversation")

                    @JvmStatic fun of(value: String) = Goal(JsonField.of(value))
                }

                /** An enum containing [Goal]'s known values. */
                enum class Known {
                    ENGAGEMENT,
                    FOLLOWERS,
                    AUTHORITY,
                    CONVERSATION,
                }

                /**
                 * An enum containing [Goal]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Goal] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ENGAGEMENT,
                    FOLLOWERS,
                    AUTHORITY,
                    CONVERSATION,
                    /**
                     * An enum member indicating that [Goal] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ENGAGEMENT -> Value.ENGAGEMENT
                        FOLLOWERS -> Value.FOLLOWERS
                        AUTHORITY -> Value.AUTHORITY
                        CONVERSATION -> Value.CONVERSATION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        ENGAGEMENT -> Known.ENGAGEMENT
                        FOLLOWERS -> Known.FOLLOWERS
                        AUTHORITY -> Known.AUTHORITY
                        CONVERSATION -> Known.CONVERSATION
                        else -> throw XTwitterScraperInvalidDataException("Unknown Goal: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Goal = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Goal && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ComposePrepareRequest &&
                    step == other.step &&
                    topic == other.topic &&
                    goal == other.goal &&
                    styleUsername == other.styleUsername &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(step, topic, goal, styleUsername, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComposePrepareRequest{step=$step, topic=$topic, goal=$goal, styleUsername=$styleUsername, additionalProperties=$additionalProperties}"
        }

        class ComposeRefineRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val goal: JsonField<Goal>,
            private val step: JsonValue,
            private val tone: JsonField<String>,
            private val topic: JsonField<String>,
            private val additionalContext: JsonField<String>,
            private val callToAction: JsonField<String>,
            private val mediaType: JsonField<MediaType>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("goal") @ExcludeMissing goal: JsonField<Goal> = JsonMissing.of(),
                @JsonProperty("step") @ExcludeMissing step: JsonValue = JsonMissing.of(),
                @JsonProperty("tone") @ExcludeMissing tone: JsonField<String> = JsonMissing.of(),
                @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
                @JsonProperty("additionalContext")
                @ExcludeMissing
                additionalContext: JsonField<String> = JsonMissing.of(),
                @JsonProperty("callToAction")
                @ExcludeMissing
                callToAction: JsonField<String> = JsonMissing.of(),
                @JsonProperty("mediaType")
                @ExcludeMissing
                mediaType: JsonField<MediaType> = JsonMissing.of(),
            ) : this(
                goal,
                step,
                tone,
                topic,
                additionalContext,
                callToAction,
                mediaType,
                mutableMapOf(),
            )

            /**
             * Editorial goal for the guidance.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun goal(): Goal = goal.getRequired("goal")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("refine")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("step") @ExcludeMissing fun _step(): JsonValue = step

            /**
             * Requested writing tone.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tone(): String = tone.getRequired("tone")

            /**
             * Subject for the post.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun topic(): String = topic.getRequired("topic")

            /**
             * Audience, constraints, sources, or other writing context.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun additionalContext(): Optional<String> =
                additionalContext.getOptional("additionalContext")

            /**
             * Specific action the draft should request.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun callToAction(): Optional<String> = callToAction.getOptional("callToAction")

            /**
             * Planned media type.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun mediaType(): Optional<MediaType> = mediaType.getOptional("mediaType")

            /**
             * Returns the raw JSON value of [goal].
             *
             * Unlike [goal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("goal") @ExcludeMissing fun _goal(): JsonField<Goal> = goal

            /**
             * Returns the raw JSON value of [tone].
             *
             * Unlike [tone], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tone") @ExcludeMissing fun _tone(): JsonField<String> = tone

            /**
             * Returns the raw JSON value of [topic].
             *
             * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("topic") @ExcludeMissing fun _topic(): JsonField<String> = topic

            /**
             * Returns the raw JSON value of [additionalContext].
             *
             * Unlike [additionalContext], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("additionalContext")
            @ExcludeMissing
            fun _additionalContext(): JsonField<String> = additionalContext

            /**
             * Returns the raw JSON value of [callToAction].
             *
             * Unlike [callToAction], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("callToAction")
            @ExcludeMissing
            fun _callToAction(): JsonField<String> = callToAction

            /**
             * Returns the raw JSON value of [mediaType].
             *
             * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaType")
            @ExcludeMissing
            fun _mediaType(): JsonField<MediaType> = mediaType

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
                 * Returns a mutable builder for constructing an instance of [ComposeRefineRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .goal()
                 * .tone()
                 * .topic()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComposeRefineRequest]. */
            class Builder internal constructor() {

                private var goal: JsonField<Goal>? = null
                private var step: JsonValue = JsonValue.from("refine")
                private var tone: JsonField<String>? = null
                private var topic: JsonField<String>? = null
                private var additionalContext: JsonField<String> = JsonMissing.of()
                private var callToAction: JsonField<String> = JsonMissing.of()
                private var mediaType: JsonField<MediaType> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(composeRefineRequest: ComposeRefineRequest) = apply {
                    goal = composeRefineRequest.goal
                    step = composeRefineRequest.step
                    tone = composeRefineRequest.tone
                    topic = composeRefineRequest.topic
                    additionalContext = composeRefineRequest.additionalContext
                    callToAction = composeRefineRequest.callToAction
                    mediaType = composeRefineRequest.mediaType
                    additionalProperties = composeRefineRequest.additionalProperties.toMutableMap()
                }

                /** Editorial goal for the guidance. */
                fun goal(goal: Goal) = goal(JsonField.of(goal))

                /**
                 * Sets [Builder.goal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.goal] with a well-typed [Goal] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun goal(goal: JsonField<Goal>) = apply { this.goal = goal }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("refine")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun step(step: JsonValue) = apply { this.step = step }

                /** Requested writing tone. */
                fun tone(tone: String) = tone(JsonField.of(tone))

                /**
                 * Sets [Builder.tone] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tone] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun tone(tone: JsonField<String>) = apply { this.tone = tone }

                /** Subject for the post. */
                fun topic(topic: String) = topic(JsonField.of(topic))

                /**
                 * Sets [Builder.topic] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.topic] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun topic(topic: JsonField<String>) = apply { this.topic = topic }

                /** Audience, constraints, sources, or other writing context. */
                fun additionalContext(additionalContext: String) =
                    additionalContext(JsonField.of(additionalContext))

                /**
                 * Sets [Builder.additionalContext] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.additionalContext] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun additionalContext(additionalContext: JsonField<String>) = apply {
                    this.additionalContext = additionalContext
                }

                /** Specific action the draft should request. */
                fun callToAction(callToAction: String) = callToAction(JsonField.of(callToAction))

                /**
                 * Sets [Builder.callToAction] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callToAction] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callToAction(callToAction: JsonField<String>) = apply {
                    this.callToAction = callToAction
                }

                /** Planned media type. */
                fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

                /**
                 * Sets [Builder.mediaType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.mediaType] with a well-typed [MediaType] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun mediaType(mediaType: JsonField<MediaType>) = apply {
                    this.mediaType = mediaType
                }

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
                 * Returns an immutable instance of [ComposeRefineRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .goal()
                 * .tone()
                 * .topic()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ComposeRefineRequest =
                    ComposeRefineRequest(
                        checkRequired("goal", goal),
                        step,
                        checkRequired("tone", tone),
                        checkRequired("topic", topic),
                        additionalContext,
                        callToAction,
                        mediaType,
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
            fun validate(): ComposeRefineRequest = apply {
                if (validated) {
                    return@apply
                }

                goal().validate()
                _step().let {
                    if (it != JsonValue.from("refine")) {
                        throw XTwitterScraperInvalidDataException("'step' is invalid, received $it")
                    }
                }
                tone()
                topic()
                additionalContext()
                callToAction()
                mediaType().ifPresent { it.validate() }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (goal.asKnown().getOrNull()?.validity() ?: 0) +
                    step.let { if (it == JsonValue.from("refine")) 1 else 0 } +
                    (if (tone.asKnown().isPresent) 1 else 0) +
                    (if (topic.asKnown().isPresent) 1 else 0) +
                    (if (additionalContext.asKnown().isPresent) 1 else 0) +
                    (if (callToAction.asKnown().isPresent) 1 else 0) +
                    (mediaType.asKnown().getOrNull()?.validity() ?: 0)

            /** Editorial goal for the guidance. */
            class Goal @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ENGAGEMENT = of("engagement")

                    @JvmField val FOLLOWERS = of("followers")

                    @JvmField val AUTHORITY = of("authority")

                    @JvmField val CONVERSATION = of("conversation")

                    @JvmStatic fun of(value: String) = Goal(JsonField.of(value))
                }

                /** An enum containing [Goal]'s known values. */
                enum class Known {
                    ENGAGEMENT,
                    FOLLOWERS,
                    AUTHORITY,
                    CONVERSATION,
                }

                /**
                 * An enum containing [Goal]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Goal] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ENGAGEMENT,
                    FOLLOWERS,
                    AUTHORITY,
                    CONVERSATION,
                    /**
                     * An enum member indicating that [Goal] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ENGAGEMENT -> Value.ENGAGEMENT
                        FOLLOWERS -> Value.FOLLOWERS
                        AUTHORITY -> Value.AUTHORITY
                        CONVERSATION -> Value.CONVERSATION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        ENGAGEMENT -> Known.ENGAGEMENT
                        FOLLOWERS -> Known.FOLLOWERS
                        AUTHORITY -> Known.AUTHORITY
                        CONVERSATION -> Known.CONVERSATION
                        else -> throw XTwitterScraperInvalidDataException("Unknown Goal: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Goal = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Goal && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** Planned media type. */
            class MediaType @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val PHOTO = of("photo")

                    @JvmField val VIDEO = of("video")

                    @JvmField val NONE = of("none")

                    @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
                }

                /** An enum containing [MediaType]'s known values. */
                enum class Known {
                    PHOTO,
                    VIDEO,
                    NONE,
                }

                /**
                 * An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [MediaType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    PHOTO,
                    VIDEO,
                    NONE,
                    /**
                     * An enum member indicating that [MediaType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        PHOTO -> Value.PHOTO
                        VIDEO -> Value.VIDEO
                        NONE -> Value.NONE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        PHOTO -> Known.PHOTO
                        VIDEO -> Known.VIDEO
                        NONE -> Known.NONE
                        else ->
                            throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): MediaType = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is MediaType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ComposeRefineRequest &&
                    goal == other.goal &&
                    step == other.step &&
                    tone == other.tone &&
                    topic == other.topic &&
                    additionalContext == other.additionalContext &&
                    callToAction == other.callToAction &&
                    mediaType == other.mediaType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    goal,
                    step,
                    tone,
                    topic,
                    additionalContext,
                    callToAction,
                    mediaType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComposeRefineRequest{goal=$goal, step=$step, tone=$tone, topic=$topic, additionalContext=$additionalContext, callToAction=$callToAction, mediaType=$mediaType, additionalProperties=$additionalProperties}"
        }

        class ComposeScoreRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val draft: JsonField<String>,
            private val step: JsonValue,
            private val hasLink: JsonField<Boolean>,
            private val hasMedia: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("draft") @ExcludeMissing draft: JsonField<String> = JsonMissing.of(),
                @JsonProperty("step") @ExcludeMissing step: JsonValue = JsonMissing.of(),
                @JsonProperty("hasLink")
                @ExcludeMissing
                hasLink: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("hasMedia")
                @ExcludeMissing
                hasMedia: JsonField<Boolean> = JsonMissing.of(),
            ) : this(draft, step, hasLink, hasMedia, mutableMapOf())

            /**
             * Full post text for deterministic editorial checks.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun draft(): String = draft.getRequired("draft")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("score")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("step") @ExcludeMissing fun _step(): JsonValue = step

            /**
             * True when a separate link card is attached.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun hasLink(): Optional<Boolean> = hasLink.getOptional("hasLink")

            /**
             * Accepted for backward compatibility. Text checks ignore this field.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            @Deprecated("Ignored. Remove this field. Use hasLink for a separate link card.")
            fun hasMedia(): Optional<Boolean> = hasMedia.getOptional("hasMedia")

            /**
             * Returns the raw JSON value of [draft].
             *
             * Unlike [draft], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("draft") @ExcludeMissing fun _draft(): JsonField<String> = draft

            /**
             * Returns the raw JSON value of [hasLink].
             *
             * Unlike [hasLink], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("hasLink") @ExcludeMissing fun _hasLink(): JsonField<Boolean> = hasLink

            /**
             * Returns the raw JSON value of [hasMedia].
             *
             * Unlike [hasMedia], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @Deprecated("Ignored. Remove this field. Use hasLink for a separate link card.")
            @JsonProperty("hasMedia")
            @ExcludeMissing
            fun _hasMedia(): JsonField<Boolean> = hasMedia

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
                 * Returns a mutable builder for constructing an instance of [ComposeScoreRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .draft()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComposeScoreRequest]. */
            class Builder internal constructor() {

                private var draft: JsonField<String>? = null
                private var step: JsonValue = JsonValue.from("score")
                private var hasLink: JsonField<Boolean> = JsonMissing.of()
                private var hasMedia: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(composeScoreRequest: ComposeScoreRequest) = apply {
                    draft = composeScoreRequest.draft
                    step = composeScoreRequest.step
                    hasLink = composeScoreRequest.hasLink
                    hasMedia = composeScoreRequest.hasMedia
                    additionalProperties = composeScoreRequest.additionalProperties.toMutableMap()
                }

                /** Full post text for deterministic editorial checks. */
                fun draft(draft: String) = draft(JsonField.of(draft))

                /**
                 * Sets [Builder.draft] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.draft] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun draft(draft: JsonField<String>) = apply { this.draft = draft }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("score")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun step(step: JsonValue) = apply { this.step = step }

                /** True when a separate link card is attached. */
                fun hasLink(hasLink: Boolean) = hasLink(JsonField.of(hasLink))

                /**
                 * Sets [Builder.hasLink] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.hasLink] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun hasLink(hasLink: JsonField<Boolean>) = apply { this.hasLink = hasLink }

                /** Accepted for backward compatibility. Text checks ignore this field. */
                @Deprecated("Ignored. Remove this field. Use hasLink for a separate link card.")
                fun hasMedia(hasMedia: Boolean) = apply {
                    this.hasMedia = JsonField.of(hasMedia)
                }

                /**
                 * Sets [Builder.hasMedia] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.hasMedia] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                @Deprecated("Ignored. Remove this field. Use hasLink for a separate link card.")
                fun hasMedia(hasMedia: JsonField<Boolean>) = apply { this.hasMedia = hasMedia }

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
                 * Returns an immutable instance of [ComposeScoreRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .draft()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ComposeScoreRequest =
                    ComposeScoreRequest(
                        checkRequired("draft", draft),
                        step,
                        hasLink,
                        hasMedia,
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
            fun validate(): ComposeScoreRequest = apply {
                if (validated) {
                    return@apply
                }

                draft()
                _step().let {
                    if (it != JsonValue.from("score")) {
                        throw XTwitterScraperInvalidDataException("'step' is invalid, received $it")
                    }
                }
                hasLink()
                hasMedia.getOptional("hasMedia")
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (draft.asKnown().isPresent) 1 else 0) +
                    step.let { if (it == JsonValue.from("score")) 1 else 0 } +
                    (if (hasLink.asKnown().isPresent) 1 else 0) +
                    (if (hasMedia.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ComposeScoreRequest &&
                    draft == other.draft &&
                    step == other.step &&
                    hasLink == other.hasLink &&
                    hasMedia == other.hasMedia &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(draft, step, hasLink, hasMedia, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComposeScoreRequest{draft=$draft, step=$step, hasLink=$hasLink, hasMedia=$hasMedia, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComposeCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ComposeCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
