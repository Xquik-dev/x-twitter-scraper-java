// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.writeactions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
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
import kotlin.jvm.optionals.getOrNull

class WriteActionRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val action: JsonField<String>,
    private val charged: JsonField<Boolean>,
    private val chargedCredits: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val media: JsonField<Media>,
    private val retryable: JsonValue,
    private val sendDispatched: JsonField<Boolean>,
    private val status: JsonField<Status>,
    private val writeActionId: JsonField<String>,
    private val confirmationAttempts: JsonField<Long>,
    private val confirmationCheckedAt: JsonField<OffsetDateTime>,
    private val confirmationSource: JsonField<String>,
    private val confirmedAt: JsonField<OffsetDateTime>,
    private val message: JsonField<String>,
    private val messageId: JsonField<String>,
    private val sendDispatchedAt: JsonField<OffsetDateTime>,
    private val targetId: JsonField<String>,
    private val tweetId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("action") @ExcludeMissing action: JsonField<String> = JsonMissing.of(),
        @JsonProperty("charged") @ExcludeMissing charged: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("chargedCredits")
        @ExcludeMissing
        chargedCredits: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("media") @ExcludeMissing media: JsonField<Media> = JsonMissing.of(),
        @JsonProperty("retryable") @ExcludeMissing retryable: JsonValue = JsonMissing.of(),
        @JsonProperty("sendDispatched")
        @ExcludeMissing
        sendDispatched: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("writeActionId")
        @ExcludeMissing
        writeActionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("confirmationAttempts")
        @ExcludeMissing
        confirmationAttempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("confirmationCheckedAt")
        @ExcludeMissing
        confirmationCheckedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("confirmationSource")
        @ExcludeMissing
        confirmationSource: JsonField<String> = JsonMissing.of(),
        @JsonProperty("confirmedAt")
        @ExcludeMissing
        confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("messageId") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sendDispatchedAt")
        @ExcludeMissing
        sendDispatchedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("targetId") @ExcludeMissing targetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
    ) : this(
        action,
        charged,
        chargedCredits,
        createdAt,
        media,
        retryable,
        sendDispatched,
        status,
        writeActionId,
        confirmationAttempts,
        confirmationCheckedAt,
        confirmationSource,
        confirmedAt,
        message,
        messageId,
        sendDispatchedAt,
        targetId,
        tweetId,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun action(): String = action.getRequired("action")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun charged(): Boolean = charged.getRequired("charged")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chargedCredits(): String = chargedCredits.getRequired("chargedCredits")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun media(): Media = media.getRequired("media")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(false)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("retryable") @ExcludeMissing fun _retryable(): JsonValue = retryable

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sendDispatched(): Boolean = sendDispatched.getRequired("sendDispatched")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun writeActionId(): String = writeActionId.getRequired("writeActionId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun confirmationAttempts(): Optional<Long> =
        confirmationAttempts.getOptional("confirmationAttempts")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun confirmationCheckedAt(): Optional<OffsetDateTime> =
        confirmationCheckedAt.getOptional("confirmationCheckedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun confirmationSource(): Optional<String> =
        confirmationSource.getOptional("confirmationSource")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun confirmedAt(): Optional<OffsetDateTime> = confirmedAt.getOptional("confirmedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("messageId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sendDispatchedAt(): Optional<OffsetDateTime> =
        sendDispatchedAt.getOptional("sendDispatchedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetId(): Optional<String> = targetId.getOptional("targetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

    /**
     * Returns the raw JSON value of [action].
     *
     * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<String> = action

    /**
     * Returns the raw JSON value of [charged].
     *
     * Unlike [charged], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("charged") @ExcludeMissing fun _charged(): JsonField<Boolean> = charged

    /**
     * Returns the raw JSON value of [chargedCredits].
     *
     * Unlike [chargedCredits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chargedCredits")
    @ExcludeMissing
    fun _chargedCredits(): JsonField<String> = chargedCredits

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<Media> = media

    /**
     * Returns the raw JSON value of [sendDispatched].
     *
     * Unlike [sendDispatched], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sendDispatched")
    @ExcludeMissing
    fun _sendDispatched(): JsonField<Boolean> = sendDispatched

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [writeActionId].
     *
     * Unlike [writeActionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("writeActionId")
    @ExcludeMissing
    fun _writeActionId(): JsonField<String> = writeActionId

    /**
     * Returns the raw JSON value of [confirmationAttempts].
     *
     * Unlike [confirmationAttempts], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("confirmationAttempts")
    @ExcludeMissing
    fun _confirmationAttempts(): JsonField<Long> = confirmationAttempts

    /**
     * Returns the raw JSON value of [confirmationCheckedAt].
     *
     * Unlike [confirmationCheckedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("confirmationCheckedAt")
    @ExcludeMissing
    fun _confirmationCheckedAt(): JsonField<OffsetDateTime> = confirmationCheckedAt

    /**
     * Returns the raw JSON value of [confirmationSource].
     *
     * Unlike [confirmationSource], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("confirmationSource")
    @ExcludeMissing
    fun _confirmationSource(): JsonField<String> = confirmationSource

    /**
     * Returns the raw JSON value of [confirmedAt].
     *
     * Unlike [confirmedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("confirmedAt")
    @ExcludeMissing
    fun _confirmedAt(): JsonField<OffsetDateTime> = confirmedAt

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageId") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [sendDispatchedAt].
     *
     * Unlike [sendDispatchedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("sendDispatchedAt")
    @ExcludeMissing
    fun _sendDispatchedAt(): JsonField<OffsetDateTime> = sendDispatchedAt

    /**
     * Returns the raw JSON value of [targetId].
     *
     * Unlike [targetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("targetId") @ExcludeMissing fun _targetId(): JsonField<String> = targetId

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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
         * Returns a mutable builder for constructing an instance of [WriteActionRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .action()
         * .charged()
         * .chargedCredits()
         * .createdAt()
         * .media()
         * .sendDispatched()
         * .status()
         * .writeActionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WriteActionRetrieveResponse]. */
    class Builder internal constructor() {

        private var action: JsonField<String>? = null
        private var charged: JsonField<Boolean>? = null
        private var chargedCredits: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var media: JsonField<Media>? = null
        private var retryable: JsonValue = JsonValue.from(false)
        private var sendDispatched: JsonField<Boolean>? = null
        private var status: JsonField<Status>? = null
        private var writeActionId: JsonField<String>? = null
        private var confirmationAttempts: JsonField<Long> = JsonMissing.of()
        private var confirmationCheckedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var confirmationSource: JsonField<String> = JsonMissing.of()
        private var confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var sendDispatchedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var targetId: JsonField<String> = JsonMissing.of()
        private var tweetId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(writeActionRetrieveResponse: WriteActionRetrieveResponse) = apply {
            action = writeActionRetrieveResponse.action
            charged = writeActionRetrieveResponse.charged
            chargedCredits = writeActionRetrieveResponse.chargedCredits
            createdAt = writeActionRetrieveResponse.createdAt
            media = writeActionRetrieveResponse.media
            retryable = writeActionRetrieveResponse.retryable
            sendDispatched = writeActionRetrieveResponse.sendDispatched
            status = writeActionRetrieveResponse.status
            writeActionId = writeActionRetrieveResponse.writeActionId
            confirmationAttempts = writeActionRetrieveResponse.confirmationAttempts
            confirmationCheckedAt = writeActionRetrieveResponse.confirmationCheckedAt
            confirmationSource = writeActionRetrieveResponse.confirmationSource
            confirmedAt = writeActionRetrieveResponse.confirmedAt
            message = writeActionRetrieveResponse.message
            messageId = writeActionRetrieveResponse.messageId
            sendDispatchedAt = writeActionRetrieveResponse.sendDispatchedAt
            targetId = writeActionRetrieveResponse.targetId
            tweetId = writeActionRetrieveResponse.tweetId
            additionalProperties = writeActionRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun action(action: String) = action(JsonField.of(action))

        /**
         * Sets [Builder.action] to an arbitrary JSON value.
         *
         * You should usually call [Builder.action] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun action(action: JsonField<String>) = apply { this.action = action }

        fun charged(charged: Boolean) = charged(JsonField.of(charged))

        /**
         * Sets [Builder.charged] to an arbitrary JSON value.
         *
         * You should usually call [Builder.charged] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun charged(charged: JsonField<Boolean>) = apply { this.charged = charged }

        fun chargedCredits(chargedCredits: String) = chargedCredits(JsonField.of(chargedCredits))

        /**
         * Sets [Builder.chargedCredits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chargedCredits] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun chargedCredits(chargedCredits: JsonField<String>) = apply {
            this.chargedCredits = chargedCredits
        }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun media(media: Media) = media(JsonField.of(media))

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed [Media] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun media(media: JsonField<Media>) = apply { this.media = media }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(false)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retryable(retryable: JsonValue) = apply { this.retryable = retryable }

        fun sendDispatched(sendDispatched: Boolean) = sendDispatched(JsonField.of(sendDispatched))

        /**
         * Sets [Builder.sendDispatched] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendDispatched] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sendDispatched(sendDispatched: JsonField<Boolean>) = apply {
            this.sendDispatched = sendDispatched
        }

        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun writeActionId(writeActionId: String) = writeActionId(JsonField.of(writeActionId))

        /**
         * Sets [Builder.writeActionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.writeActionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun writeActionId(writeActionId: JsonField<String>) = apply {
            this.writeActionId = writeActionId
        }

        fun confirmationAttempts(confirmationAttempts: Long) =
            confirmationAttempts(JsonField.of(confirmationAttempts))

        /**
         * Sets [Builder.confirmationAttempts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.confirmationAttempts] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun confirmationAttempts(confirmationAttempts: JsonField<Long>) = apply {
            this.confirmationAttempts = confirmationAttempts
        }

        fun confirmationCheckedAt(confirmationCheckedAt: OffsetDateTime) =
            confirmationCheckedAt(JsonField.of(confirmationCheckedAt))

        /**
         * Sets [Builder.confirmationCheckedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.confirmationCheckedAt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun confirmationCheckedAt(confirmationCheckedAt: JsonField<OffsetDateTime>) = apply {
            this.confirmationCheckedAt = confirmationCheckedAt
        }

        fun confirmationSource(confirmationSource: String?) =
            confirmationSource(JsonField.ofNullable(confirmationSource))

        /**
         * Alias for calling [Builder.confirmationSource] with `confirmationSource.orElse(null)`.
         */
        fun confirmationSource(confirmationSource: Optional<String>) =
            confirmationSource(confirmationSource.getOrNull())

        /**
         * Sets [Builder.confirmationSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.confirmationSource] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun confirmationSource(confirmationSource: JsonField<String>) = apply {
            this.confirmationSource = confirmationSource
        }

        fun confirmedAt(confirmedAt: OffsetDateTime) = confirmedAt(JsonField.of(confirmedAt))

        /**
         * Sets [Builder.confirmedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.confirmedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun confirmedAt(confirmedAt: JsonField<OffsetDateTime>) = apply {
            this.confirmedAt = confirmedAt
        }

        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        fun sendDispatchedAt(sendDispatchedAt: OffsetDateTime) =
            sendDispatchedAt(JsonField.of(sendDispatchedAt))

        /**
         * Sets [Builder.sendDispatchedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendDispatchedAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sendDispatchedAt(sendDispatchedAt: JsonField<OffsetDateTime>) = apply {
            this.sendDispatchedAt = sendDispatchedAt
        }

        fun targetId(targetId: String?) = targetId(JsonField.ofNullable(targetId))

        /** Alias for calling [Builder.targetId] with `targetId.orElse(null)`. */
        fun targetId(targetId: Optional<String>) = targetId(targetId.getOrNull())

        /**
         * Sets [Builder.targetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun targetId(targetId: JsonField<String>) = apply { this.targetId = targetId }

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

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
         * Returns an immutable instance of [WriteActionRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .action()
         * .charged()
         * .chargedCredits()
         * .createdAt()
         * .media()
         * .sendDispatched()
         * .status()
         * .writeActionId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WriteActionRetrieveResponse =
            WriteActionRetrieveResponse(
                checkRequired("action", action),
                checkRequired("charged", charged),
                checkRequired("chargedCredits", chargedCredits),
                checkRequired("createdAt", createdAt),
                checkRequired("media", media),
                retryable,
                checkRequired("sendDispatched", sendDispatched),
                checkRequired("status", status),
                checkRequired("writeActionId", writeActionId),
                confirmationAttempts,
                confirmationCheckedAt,
                confirmationSource,
                confirmedAt,
                message,
                messageId,
                sendDispatchedAt,
                targetId,
                tweetId,
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
    fun validate(): WriteActionRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        action()
        charged()
        chargedCredits()
        createdAt()
        media().validate()
        _retryable().let {
            if (it != JsonValue.from(false)) {
                throw XTwitterScraperInvalidDataException("'retryable' is invalid, received $it")
            }
        }
        sendDispatched()
        status().validate()
        writeActionId()
        confirmationAttempts()
        confirmationCheckedAt()
        confirmationSource()
        confirmedAt()
        message()
        messageId()
        sendDispatchedAt()
        targetId()
        tweetId()
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
        (if (action.asKnown().isPresent) 1 else 0) +
            (if (charged.asKnown().isPresent) 1 else 0) +
            (if (chargedCredits.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (media.asKnown().getOrNull()?.validity() ?: 0) +
            retryable.let { if (it == JsonValue.from(false)) 1 else 0 } +
            (if (sendDispatched.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (writeActionId.asKnown().isPresent) 1 else 0) +
            (if (confirmationAttempts.asKnown().isPresent) 1 else 0) +
            (if (confirmationCheckedAt.asKnown().isPresent) 1 else 0) +
            (if (confirmationSource.asKnown().isPresent) 1 else 0) +
            (if (confirmedAt.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (sendDispatchedAt.asKnown().isPresent) 1 else 0) +
            (if (targetId.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0)

    class Media
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val count: JsonField<Long>,
        private val credits: JsonField<String>,
        private val kind: JsonField<Kind>,
        private val totalBytes: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("credits") @ExcludeMissing credits: JsonField<String> = JsonMissing.of(),
            @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
            @JsonProperty("totalBytes")
            @ExcludeMissing
            totalBytes: JsonField<String> = JsonMissing.of(),
        ) : this(count, credits, kind, totalBytes, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun count(): Long = count.getRequired("count")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun credits(): String = credits.getRequired("credits")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun kind(): Kind = kind.getRequired("kind")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun totalBytes(): String = totalBytes.getRequired("totalBytes")

        /**
         * Returns the raw JSON value of [count].
         *
         * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

        /**
         * Returns the raw JSON value of [credits].
         *
         * Unlike [credits], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<String> = credits

        /**
         * Returns the raw JSON value of [kind].
         *
         * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

        /**
         * Returns the raw JSON value of [totalBytes].
         *
         * Unlike [totalBytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("totalBytes")
        @ExcludeMissing
        fun _totalBytes(): JsonField<String> = totalBytes

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
             * Returns a mutable builder for constructing an instance of [Media].
             *
             * The following fields are required:
             * ```java
             * .count()
             * .credits()
             * .kind()
             * .totalBytes()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Media]. */
        class Builder internal constructor() {

            private var count: JsonField<Long>? = null
            private var credits: JsonField<String>? = null
            private var kind: JsonField<Kind>? = null
            private var totalBytes: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(media: Media) = apply {
                count = media.count
                credits = media.credits
                kind = media.kind
                totalBytes = media.totalBytes
                additionalProperties = media.additionalProperties.toMutableMap()
            }

            fun count(count: Long) = count(JsonField.of(count))

            /**
             * Sets [Builder.count] to an arbitrary JSON value.
             *
             * You should usually call [Builder.count] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun count(count: JsonField<Long>) = apply { this.count = count }

            fun credits(credits: String) = credits(JsonField.of(credits))

            /**
             * Sets [Builder.credits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credits] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credits(credits: JsonField<String>) = apply { this.credits = credits }

            fun kind(kind: Kind) = kind(JsonField.of(kind))

            /**
             * Sets [Builder.kind] to an arbitrary JSON value.
             *
             * You should usually call [Builder.kind] with a well-typed [Kind] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

            fun totalBytes(totalBytes: String) = totalBytes(JsonField.of(totalBytes))

            /**
             * Sets [Builder.totalBytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalBytes] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalBytes(totalBytes: JsonField<String>) = apply { this.totalBytes = totalBytes }

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
             * Returns an immutable instance of [Media].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .count()
             * .credits()
             * .kind()
             * .totalBytes()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Media =
                Media(
                    checkRequired("count", count),
                    checkRequired("credits", credits),
                    checkRequired("kind", kind),
                    checkRequired("totalBytes", totalBytes),
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
        fun validate(): Media = apply {
            if (validated) {
                return@apply
            }

            count()
            credits()
            kind().validate()
            totalBytes()
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
            (if (count.asKnown().isPresent) 1 else 0) +
                (if (credits.asKnown().isPresent) 1 else 0) +
                (kind.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalBytes.asKnown().isPresent) 1 else 0)

        class Kind @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NONE = of("none")

                @JvmField val IMAGE = of("image")

                @JvmField val VIDEO = of("video")

                @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
            }

            /** An enum containing [Kind]'s known values. */
            enum class Known {
                NONE,
                IMAGE,
                VIDEO,
            }

            /**
             * An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Kind] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NONE,
                IMAGE,
                VIDEO,
                /** An enum member indicating that [Kind] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    NONE -> Value.NONE
                    IMAGE -> Value.IMAGE
                    VIDEO -> Value.VIDEO
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    NONE -> Known.NONE
                    IMAGE -> Known.IMAGE
                    VIDEO -> Known.VIDEO
                    else -> throw XTwitterScraperInvalidDataException("Unknown Kind: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
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
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Kind = apply {
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

                return other is Kind && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Media &&
                count == other.count &&
                credits == other.credits &&
                kind == other.kind &&
                totalBytes == other.totalBytes &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(count, credits, kind, totalBytes, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Media{count=$count, credits=$credits, kind=$kind, totalBytes=$totalBytes, additionalProperties=$additionalProperties}"
    }

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SUCCESS = of("success")

            @JvmField val FAILED = of("failed")

            @JvmField val PENDING_CONFIRMATION = of("pending_confirmation")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            SUCCESS,
            FAILED,
            PENDING_CONFIRMATION,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SUCCESS,
            FAILED,
            PENDING_CONFIRMATION,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                SUCCESS -> Value.SUCCESS
                FAILED -> Value.FAILED
                PENDING_CONFIRMATION -> Value.PENDING_CONFIRMATION
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
                SUCCESS -> Known.SUCCESS
                FAILED -> Known.FAILED
                PENDING_CONFIRMATION -> Known.PENDING_CONFIRMATION
                else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WriteActionRetrieveResponse &&
            action == other.action &&
            charged == other.charged &&
            chargedCredits == other.chargedCredits &&
            createdAt == other.createdAt &&
            media == other.media &&
            retryable == other.retryable &&
            sendDispatched == other.sendDispatched &&
            status == other.status &&
            writeActionId == other.writeActionId &&
            confirmationAttempts == other.confirmationAttempts &&
            confirmationCheckedAt == other.confirmationCheckedAt &&
            confirmationSource == other.confirmationSource &&
            confirmedAt == other.confirmedAt &&
            message == other.message &&
            messageId == other.messageId &&
            sendDispatchedAt == other.sendDispatchedAt &&
            targetId == other.targetId &&
            tweetId == other.tweetId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            action,
            charged,
            chargedCredits,
            createdAt,
            media,
            retryable,
            sendDispatched,
            status,
            writeActionId,
            confirmationAttempts,
            confirmationCheckedAt,
            confirmationSource,
            confirmedAt,
            message,
            messageId,
            sendDispatchedAt,
            targetId,
            tweetId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WriteActionRetrieveResponse{action=$action, charged=$charged, chargedCredits=$chargedCredits, createdAt=$createdAt, media=$media, retryable=$retryable, sendDispatched=$sendDispatched, status=$status, writeActionId=$writeActionId, confirmationAttempts=$confirmationAttempts, confirmationCheckedAt=$confirmationCheckedAt, confirmationSource=$confirmationSource, confirmedAt=$confirmedAt, message=$message, messageId=$messageId, sendDispatchedAt=$sendDispatchedAt, targetId=$targetId, tweetId=$tweetId, additionalProperties=$additionalProperties}"
}
