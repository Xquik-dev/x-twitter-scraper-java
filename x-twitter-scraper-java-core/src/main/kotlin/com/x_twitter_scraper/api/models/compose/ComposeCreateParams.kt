// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Compose, refine, or score a tweet */
class ComposeCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Workflow step
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun step(): Step = body.step()

    /**
     * Extra context or URLs (refine)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun additionalContext(): Optional<String> = body.additionalContext()

    /**
     * Desired call to action (refine)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun callToAction(): Optional<String> = body.callToAction()

    /**
     * Tweet draft text to evaluate (score)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun draft(): Optional<String> = body.draft()

    /**
     * Optimization goal
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun goal(): Optional<Goal> = body.goal()

    /**
     * Whether a link is attached (score)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasLink(): Optional<Boolean> = body.hasLink()

    /**
     * Whether media is attached (score)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasMedia(): Optional<Boolean> = body.hasMedia()

    /**
     * Media type (refine)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaType(): Optional<MediaType> = body.mediaType()

    /**
     * Cached style username for voice matching (compose)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun styleUsername(): Optional<String> = body.styleUsername()

    /**
     * Desired tone (refine)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tone(): Optional<String> = body.tone()

    /**
     * Tweet topic (compose, refine)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun topic(): Optional<String> = body.topic()

    /**
     * Returns the raw JSON value of [step].
     *
     * Unlike [step], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _step(): JsonField<Step> = body._step()

    /**
     * Returns the raw JSON value of [additionalContext].
     *
     * Unlike [additionalContext], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _additionalContext(): JsonField<String> = body._additionalContext()

    /**
     * Returns the raw JSON value of [callToAction].
     *
     * Unlike [callToAction], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _callToAction(): JsonField<String> = body._callToAction()

    /**
     * Returns the raw JSON value of [draft].
     *
     * Unlike [draft], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _draft(): JsonField<String> = body._draft()

    /**
     * Returns the raw JSON value of [goal].
     *
     * Unlike [goal], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _goal(): JsonField<Goal> = body._goal()

    /**
     * Returns the raw JSON value of [hasLink].
     *
     * Unlike [hasLink], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasLink(): JsonField<Boolean> = body._hasLink()

    /**
     * Returns the raw JSON value of [hasMedia].
     *
     * Unlike [hasMedia], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasMedia(): JsonField<Boolean> = body._hasMedia()

    /**
     * Returns the raw JSON value of [mediaType].
     *
     * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mediaType(): JsonField<MediaType> = body._mediaType()

    /**
     * Returns the raw JSON value of [styleUsername].
     *
     * Unlike [styleUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _styleUsername(): JsonField<String> = body._styleUsername()

    /**
     * Returns the raw JSON value of [tone].
     *
     * Unlike [tone], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tone(): JsonField<String> = body._tone()

    /**
     * Returns the raw JSON value of [topic].
     *
     * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topic(): JsonField<String> = body._topic()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

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
         * .step()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComposeCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(composeCreateParams: ComposeCreateParams) = apply {
            body = composeCreateParams.body.toBuilder()
            additionalHeaders = composeCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = composeCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [step]
         * - [additionalContext]
         * - [callToAction]
         * - [draft]
         * - [goal]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Workflow step */
        fun step(step: Step) = apply { body.step(step) }

        /**
         * Sets [Builder.step] to an arbitrary JSON value.
         *
         * You should usually call [Builder.step] with a well-typed [Step] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun step(step: JsonField<Step>) = apply { body.step(step) }

        /** Extra context or URLs (refine) */
        fun additionalContext(additionalContext: String) = apply {
            body.additionalContext(additionalContext)
        }

        /**
         * Sets [Builder.additionalContext] to an arbitrary JSON value.
         *
         * You should usually call [Builder.additionalContext] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun additionalContext(additionalContext: JsonField<String>) = apply {
            body.additionalContext(additionalContext)
        }

        /** Desired call to action (refine) */
        fun callToAction(callToAction: String) = apply { body.callToAction(callToAction) }

        /**
         * Sets [Builder.callToAction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callToAction] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun callToAction(callToAction: JsonField<String>) = apply {
            body.callToAction(callToAction)
        }

        /** Tweet draft text to evaluate (score) */
        fun draft(draft: String) = apply { body.draft(draft) }

        /**
         * Sets [Builder.draft] to an arbitrary JSON value.
         *
         * You should usually call [Builder.draft] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun draft(draft: JsonField<String>) = apply { body.draft(draft) }

        /** Optimization goal */
        fun goal(goal: Goal) = apply { body.goal(goal) }

        /**
         * Sets [Builder.goal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.goal] with a well-typed [Goal] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun goal(goal: JsonField<Goal>) = apply { body.goal(goal) }

        /** Whether a link is attached (score) */
        fun hasLink(hasLink: Boolean) = apply { body.hasLink(hasLink) }

        /**
         * Sets [Builder.hasLink] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasLink] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasLink(hasLink: JsonField<Boolean>) = apply { body.hasLink(hasLink) }

        /** Whether media is attached (score) */
        fun hasMedia(hasMedia: Boolean) = apply { body.hasMedia(hasMedia) }

        /**
         * Sets [Builder.hasMedia] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMedia] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasMedia(hasMedia: JsonField<Boolean>) = apply { body.hasMedia(hasMedia) }

        /** Media type (refine) */
        fun mediaType(mediaType: MediaType) = apply { body.mediaType(mediaType) }

        /**
         * Sets [Builder.mediaType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaType] with a well-typed [MediaType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mediaType(mediaType: JsonField<MediaType>) = apply { body.mediaType(mediaType) }

        /** Cached style username for voice matching (compose) */
        fun styleUsername(styleUsername: String) = apply { body.styleUsername(styleUsername) }

        /**
         * Sets [Builder.styleUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.styleUsername] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun styleUsername(styleUsername: JsonField<String>) = apply {
            body.styleUsername(styleUsername)
        }

        /** Desired tone (refine) */
        fun tone(tone: String) = apply { body.tone(tone) }

        /**
         * Sets [Builder.tone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tone(tone: JsonField<String>) = apply { body.tone(tone) }

        /** Tweet topic (compose, refine) */
        fun topic(topic: String) = apply { body.topic(topic) }

        /**
         * Sets [Builder.topic] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topic] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topic(topic: JsonField<String>) = apply { body.topic(topic) }

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
         * Returns an immutable instance of [ComposeCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .step()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ComposeCreateParams =
            ComposeCreateParams(
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
        private val step: JsonField<Step>,
        private val additionalContext: JsonField<String>,
        private val callToAction: JsonField<String>,
        private val draft: JsonField<String>,
        private val goal: JsonField<Goal>,
        private val hasLink: JsonField<Boolean>,
        private val hasMedia: JsonField<Boolean>,
        private val mediaType: JsonField<MediaType>,
        private val styleUsername: JsonField<String>,
        private val tone: JsonField<String>,
        private val topic: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("step") @ExcludeMissing step: JsonField<Step> = JsonMissing.of(),
            @JsonProperty("additionalContext")
            @ExcludeMissing
            additionalContext: JsonField<String> = JsonMissing.of(),
            @JsonProperty("callToAction")
            @ExcludeMissing
            callToAction: JsonField<String> = JsonMissing.of(),
            @JsonProperty("draft") @ExcludeMissing draft: JsonField<String> = JsonMissing.of(),
            @JsonProperty("goal") @ExcludeMissing goal: JsonField<Goal> = JsonMissing.of(),
            @JsonProperty("hasLink") @ExcludeMissing hasLink: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasMedia")
            @ExcludeMissing
            hasMedia: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("mediaType")
            @ExcludeMissing
            mediaType: JsonField<MediaType> = JsonMissing.of(),
            @JsonProperty("styleUsername")
            @ExcludeMissing
            styleUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tone") @ExcludeMissing tone: JsonField<String> = JsonMissing.of(),
            @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
        ) : this(
            step,
            additionalContext,
            callToAction,
            draft,
            goal,
            hasLink,
            hasMedia,
            mediaType,
            styleUsername,
            tone,
            topic,
            mutableMapOf(),
        )

        /**
         * Workflow step
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun step(): Step = step.getRequired("step")

        /**
         * Extra context or URLs (refine)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun additionalContext(): Optional<String> =
            additionalContext.getOptional("additionalContext")

        /**
         * Desired call to action (refine)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun callToAction(): Optional<String> = callToAction.getOptional("callToAction")

        /**
         * Tweet draft text to evaluate (score)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun draft(): Optional<String> = draft.getOptional("draft")

        /**
         * Optimization goal
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun goal(): Optional<Goal> = goal.getOptional("goal")

        /**
         * Whether a link is attached (score)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasLink(): Optional<Boolean> = hasLink.getOptional("hasLink")

        /**
         * Whether media is attached (score)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasMedia(): Optional<Boolean> = hasMedia.getOptional("hasMedia")

        /**
         * Media type (refine)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaType(): Optional<MediaType> = mediaType.getOptional("mediaType")

        /**
         * Cached style username for voice matching (compose)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun styleUsername(): Optional<String> = styleUsername.getOptional("styleUsername")

        /**
         * Desired tone (refine)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tone(): Optional<String> = tone.getOptional("tone")

        /**
         * Tweet topic (compose, refine)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun topic(): Optional<String> = topic.getOptional("topic")

        /**
         * Returns the raw JSON value of [step].
         *
         * Unlike [step], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("step") @ExcludeMissing fun _step(): JsonField<Step> = step

        /**
         * Returns the raw JSON value of [additionalContext].
         *
         * Unlike [additionalContext], this method doesn't throw if the JSON field has an unexpected
         * type.
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
         * Returns the raw JSON value of [draft].
         *
         * Unlike [draft], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("draft") @ExcludeMissing fun _draft(): JsonField<String> = draft

        /**
         * Returns the raw JSON value of [goal].
         *
         * Unlike [goal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("goal") @ExcludeMissing fun _goal(): JsonField<Goal> = goal

        /**
         * Returns the raw JSON value of [hasLink].
         *
         * Unlike [hasLink], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasLink") @ExcludeMissing fun _hasLink(): JsonField<Boolean> = hasLink

        /**
         * Returns the raw JSON value of [hasMedia].
         *
         * Unlike [hasMedia], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasMedia") @ExcludeMissing fun _hasMedia(): JsonField<Boolean> = hasMedia

        /**
         * Returns the raw JSON value of [mediaType].
         *
         * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaType")
        @ExcludeMissing
        fun _mediaType(): JsonField<MediaType> = mediaType

        /**
         * Returns the raw JSON value of [styleUsername].
         *
         * Unlike [styleUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("styleUsername")
        @ExcludeMissing
        fun _styleUsername(): JsonField<String> = styleUsername

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
             * .step()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var step: JsonField<Step>? = null
            private var additionalContext: JsonField<String> = JsonMissing.of()
            private var callToAction: JsonField<String> = JsonMissing.of()
            private var draft: JsonField<String> = JsonMissing.of()
            private var goal: JsonField<Goal> = JsonMissing.of()
            private var hasLink: JsonField<Boolean> = JsonMissing.of()
            private var hasMedia: JsonField<Boolean> = JsonMissing.of()
            private var mediaType: JsonField<MediaType> = JsonMissing.of()
            private var styleUsername: JsonField<String> = JsonMissing.of()
            private var tone: JsonField<String> = JsonMissing.of()
            private var topic: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                step = body.step
                additionalContext = body.additionalContext
                callToAction = body.callToAction
                draft = body.draft
                goal = body.goal
                hasLink = body.hasLink
                hasMedia = body.hasMedia
                mediaType = body.mediaType
                styleUsername = body.styleUsername
                tone = body.tone
                topic = body.topic
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Workflow step */
            fun step(step: Step) = step(JsonField.of(step))

            /**
             * Sets [Builder.step] to an arbitrary JSON value.
             *
             * You should usually call [Builder.step] with a well-typed [Step] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun step(step: JsonField<Step>) = apply { this.step = step }

            /** Extra context or URLs (refine) */
            fun additionalContext(additionalContext: String) =
                additionalContext(JsonField.of(additionalContext))

            /**
             * Sets [Builder.additionalContext] to an arbitrary JSON value.
             *
             * You should usually call [Builder.additionalContext] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun additionalContext(additionalContext: JsonField<String>) = apply {
                this.additionalContext = additionalContext
            }

            /** Desired call to action (refine) */
            fun callToAction(callToAction: String) = callToAction(JsonField.of(callToAction))

            /**
             * Sets [Builder.callToAction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callToAction] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callToAction(callToAction: JsonField<String>) = apply {
                this.callToAction = callToAction
            }

            /** Tweet draft text to evaluate (score) */
            fun draft(draft: String) = draft(JsonField.of(draft))

            /**
             * Sets [Builder.draft] to an arbitrary JSON value.
             *
             * You should usually call [Builder.draft] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun draft(draft: JsonField<String>) = apply { this.draft = draft }

            /** Optimization goal */
            fun goal(goal: Goal) = goal(JsonField.of(goal))

            /**
             * Sets [Builder.goal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.goal] with a well-typed [Goal] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun goal(goal: JsonField<Goal>) = apply { this.goal = goal }

            /** Whether a link is attached (score) */
            fun hasLink(hasLink: Boolean) = hasLink(JsonField.of(hasLink))

            /**
             * Sets [Builder.hasLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasLink] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasLink(hasLink: JsonField<Boolean>) = apply { this.hasLink = hasLink }

            /** Whether media is attached (score) */
            fun hasMedia(hasMedia: Boolean) = hasMedia(JsonField.of(hasMedia))

            /**
             * Sets [Builder.hasMedia] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasMedia] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasMedia(hasMedia: JsonField<Boolean>) = apply { this.hasMedia = hasMedia }

            /** Media type (refine) */
            fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

            /**
             * Sets [Builder.mediaType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaType] with a well-typed [MediaType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaType(mediaType: JsonField<MediaType>) = apply { this.mediaType = mediaType }

            /** Cached style username for voice matching (compose) */
            fun styleUsername(styleUsername: String) = styleUsername(JsonField.of(styleUsername))

            /**
             * Sets [Builder.styleUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.styleUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun styleUsername(styleUsername: JsonField<String>) = apply {
                this.styleUsername = styleUsername
            }

            /** Desired tone (refine) */
            fun tone(tone: String) = tone(JsonField.of(tone))

            /**
             * Sets [Builder.tone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tone] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun tone(tone: JsonField<String>) = apply { this.tone = tone }

            /** Tweet topic (compose, refine) */
            fun topic(topic: String) = topic(JsonField.of(topic))

            /**
             * Sets [Builder.topic] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topic] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun topic(topic: JsonField<String>) = apply { this.topic = topic }

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
             * .step()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("step", step),
                    additionalContext,
                    callToAction,
                    draft,
                    goal,
                    hasLink,
                    hasMedia,
                    mediaType,
                    styleUsername,
                    tone,
                    topic,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            step().validate()
            additionalContext()
            callToAction()
            draft()
            goal().ifPresent { it.validate() }
            hasLink()
            hasMedia()
            mediaType().ifPresent { it.validate() }
            styleUsername()
            tone()
            topic()
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
            (step.asKnown().getOrNull()?.validity() ?: 0) +
                (if (additionalContext.asKnown().isPresent) 1 else 0) +
                (if (callToAction.asKnown().isPresent) 1 else 0) +
                (if (draft.asKnown().isPresent) 1 else 0) +
                (goal.asKnown().getOrNull()?.validity() ?: 0) +
                (if (hasLink.asKnown().isPresent) 1 else 0) +
                (if (hasMedia.asKnown().isPresent) 1 else 0) +
                (mediaType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (styleUsername.asKnown().isPresent) 1 else 0) +
                (if (tone.asKnown().isPresent) 1 else 0) +
                (if (topic.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                step == other.step &&
                additionalContext == other.additionalContext &&
                callToAction == other.callToAction &&
                draft == other.draft &&
                goal == other.goal &&
                hasLink == other.hasLink &&
                hasMedia == other.hasMedia &&
                mediaType == other.mediaType &&
                styleUsername == other.styleUsername &&
                tone == other.tone &&
                topic == other.topic &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                step,
                additionalContext,
                callToAction,
                draft,
                goal,
                hasLink,
                hasMedia,
                mediaType,
                styleUsername,
                tone,
                topic,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{step=$step, additionalContext=$additionalContext, callToAction=$callToAction, draft=$draft, goal=$goal, hasLink=$hasLink, hasMedia=$hasMedia, mediaType=$mediaType, styleUsername=$styleUsername, tone=$tone, topic=$topic, additionalProperties=$additionalProperties}"
    }

    /** Workflow step */
    class Step @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COMPOSE = of("compose")

            @JvmField val REFINE = of("refine")

            @JvmField val SCORE = of("score")

            @JvmStatic fun of(value: String) = Step(JsonField.of(value))
        }

        /** An enum containing [Step]'s known values. */
        enum class Known {
            COMPOSE,
            REFINE,
            SCORE,
        }

        /**
         * An enum containing [Step]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Step] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPOSE,
            REFINE,
            SCORE,
            /** An enum member indicating that [Step] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                COMPOSE -> Value.COMPOSE
                REFINE -> Value.REFINE
                SCORE -> Value.SCORE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                COMPOSE -> Known.COMPOSE
                REFINE -> Known.REFINE
                SCORE -> Known.SCORE
                else -> throw XTwitterScraperInvalidDataException("Unknown Step: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Step = apply {
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

            return other is Step && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Optimization goal */
    class Goal @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ENGAGEMENT,
            FOLLOWERS,
            AUTHORITY,
            CONVERSATION,
            /** An enum member indicating that [Goal] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

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

    /** Media type (refine) */
    class MediaType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PHOTO,
            VIDEO,
            NONE,
            /**
             * An enum member indicating that [MediaType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                PHOTO -> Known.PHOTO
                VIDEO -> Known.VIDEO
                NONE -> Known.NONE
                else -> throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

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

        return other is ComposeCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ComposeCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
