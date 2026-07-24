// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.retweet

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
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Durable write lifecycle record. Poll statusUrl until terminal is true. Reusing the original
 * Idempotency-Key returns this same record. Submit a new write only when safeToRetry is true, using
 * a new key.
 */
class RetweetCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val account: JsonField<Account>,
    private val action: JsonField<Action>,
    private val billing: JsonField<Billing>,
    private val charged: JsonField<Boolean>,
    private val chargedCredits: JsonField<String>,
    private val nextAction: JsonField<NextAction>,
    private val object_: JsonValue,
    private val pollAfterMs: JsonField<Long>,
    private val request: JsonField<Request>,
    private val result: JsonField<Result>,
    private val retryable: JsonField<Boolean>,
    private val safeToRetry: JsonField<Boolean>,
    private val sendDispatched: JsonField<Boolean>,
    private val status: JsonField<Status>,
    private val statusUrl: JsonField<String>,
    private val success: JsonField<Boolean>,
    private val target: JsonField<Target>,
    private val targetId: JsonField<String>,
    private val terminal: JsonField<Boolean>,
    private val writeActionId: JsonField<String>,
    private val communityId: JsonField<String>,
    private val communityName: JsonField<String>,
    private val completedAt: JsonField<OffsetDateTime>,
    private val confirmationAttempts: JsonField<Long>,
    private val confirmationCheckedAt: JsonField<OffsetDateTime>,
    private val confirmedAt: JsonField<OffsetDateTime>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val details: JsonField<Details>,
    private val error: JsonField<String>,
    private val expiresAt: JsonField<OffsetDateTime>,
    private val idempotent: JsonField<Boolean>,
    private val media: JsonField<Media>,
    private val mediaId: JsonField<String>,
    private val mediaUrl: JsonField<String>,
    private val message: JsonField<String>,
    private val messageId: JsonField<String>,
    private val requestHash: JsonField<String>,
    private val requestId: JsonField<String>,
    private val resultId: JsonField<String>,
    private val sendDispatchedAt: JsonField<OffsetDateTime>,
    private val tweetId: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account") @ExcludeMissing account: JsonField<Account> = JsonMissing.of(),
        @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
        @JsonProperty("billing") @ExcludeMissing billing: JsonField<Billing> = JsonMissing.of(),
        @JsonProperty("charged") @ExcludeMissing charged: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("chargedCredits")
        @ExcludeMissing
        chargedCredits: JsonField<String> = JsonMissing.of(),
        @JsonProperty("nextAction")
        @ExcludeMissing
        nextAction: JsonField<NextAction> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("pollAfterMs")
        @ExcludeMissing
        pollAfterMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
        @JsonProperty("result") @ExcludeMissing result: JsonField<Result> = JsonMissing.of(),
        @JsonProperty("retryable") @ExcludeMissing retryable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("safeToRetry")
        @ExcludeMissing
        safeToRetry: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("sendDispatched")
        @ExcludeMissing
        sendDispatched: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("statusUrl") @ExcludeMissing statusUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("target") @ExcludeMissing target: JsonField<Target> = JsonMissing.of(),
        @JsonProperty("targetId") @ExcludeMissing targetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("terminal") @ExcludeMissing terminal: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("writeActionId")
        @ExcludeMissing
        writeActionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("communityId")
        @ExcludeMissing
        communityId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("communityName")
        @ExcludeMissing
        communityName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completedAt")
        @ExcludeMissing
        completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("confirmationAttempts")
        @ExcludeMissing
        confirmationAttempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("confirmationCheckedAt")
        @ExcludeMissing
        confirmationCheckedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("confirmedAt")
        @ExcludeMissing
        confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expiresAt")
        @ExcludeMissing
        expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("idempotent")
        @ExcludeMissing
        idempotent: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("media") @ExcludeMissing media: JsonField<Media> = JsonMissing.of(),
        @JsonProperty("mediaId") @ExcludeMissing mediaId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mediaUrl") @ExcludeMissing mediaUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("messageId") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("requestHash")
        @ExcludeMissing
        requestHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("requestId") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("resultId") @ExcludeMissing resultId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sendDispatchedAt")
        @ExcludeMissing
        sendDispatchedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        account,
        action,
        billing,
        charged,
        chargedCredits,
        nextAction,
        object_,
        pollAfterMs,
        request,
        result,
        retryable,
        safeToRetry,
        sendDispatched,
        status,
        statusUrl,
        success,
        target,
        targetId,
        terminal,
        writeActionId,
        communityId,
        communityName,
        completedAt,
        confirmationAttempts,
        confirmationCheckedAt,
        confirmedAt,
        createdAt,
        details,
        error,
        expiresAt,
        idempotent,
        media,
        mediaId,
        mediaUrl,
        message,
        messageId,
        requestHash,
        requestId,
        resultId,
        sendDispatchedAt,
        tweetId,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Connected account selected for the write.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun account(): Optional<Account> = account.getOptional("account")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun action(): Action = action.getRequired("action")

    /**
     * plannedCredits is the approved maximum. chargedCredits comes from the settled credit ledger.
     * Pending or failed writes are not charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): Billing = billing.getRequired("billing")

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
     * Exact follow-up an API client or agent should perform.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nextAction(): Optional<NextAction> = nextAction.getOptional("nextAction")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("x_write_action")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pollAfterMs(): Optional<Long> = pollAfterMs.getOptional("pollAfterMs")

    /**
     * Stable fingerprint and sanitized payload for replay checks.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun request(): Request = request.getRequired("request")

    /**
     * Confirmed result produced by the write, when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun result(): Optional<Result> = result.getOptional("result")

    /**
     * True only when a new attempt can reasonably succeed.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun retryable(): Boolean = retryable.getRequired("retryable")

    /**
     * True only when no write was dispatched and a new idempotency key may be used.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun safeToRetry(): Boolean = safeToRetry.getRequired("safeToRetry")

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
    fun statusUrl(): String = statusUrl.getRequired("statusUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * Existing X resource targeted by the write, when applicable.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun target(): Optional<Target> = target.getOptional("target")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetId(): Optional<String> = targetId.getOptional("targetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun terminal(): Boolean = terminal.getRequired("terminal")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun writeActionId(): String = writeActionId.getRequired("writeActionId")

    /**
     * Compatibility field for a confirmed community ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun communityId(): Optional<String> = communityId.getOptional("communityId")

    /**
     * Confirmed community name when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun communityName(): Optional<String> = communityName.getOptional("communityName")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completedAt")

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
    fun confirmedAt(): Optional<OffsetDateTime> = confirmedAt.getOptional("confirmedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * Structured recovery context for a failed write.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun details(): Optional<Details> = details.getOptional("details")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun error(): Optional<String> = error.getOptional("error")

    /**
     * Deadline for resolving a non-terminal write. This is not the Idempotency-Key retention
     * deadline.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun expiresAt(): Optional<OffsetDateTime> = expiresAt.getOptional("expiresAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun idempotent(): Optional<Boolean> = idempotent.getOptional("idempotent")

    /**
     * Media count, kind, size, and billing details when used.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun media(): Optional<Media> = media.getOptional("media")

    /**
     * Compatibility field for a confirmed media upload ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaId(): Optional<String> = mediaId.getOptional("mediaId")

    /**
     * Public media URL when the upload creates one.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaUrl(): Optional<String> = mediaUrl.getOptional("mediaUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Compatibility field for a confirmed direct message ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("messageId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requestHash(): Optional<String> = requestHash.getOptional("requestHash")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("requestId")

    /**
     * Compatibility result ID for other write actions.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun resultId(): Optional<String> = resultId.getOptional("resultId")

    /**
     * Dispatch timestamp when the write reached execution.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sendDispatchedAt(): Optional<OffsetDateTime> =
        sendDispatchedAt.getOptional("sendDispatchedAt")

    /**
     * Compatibility field for a confirmed tweet result ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [account].
     *
     * Unlike [account], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account") @ExcludeMissing fun _account(): JsonField<Account> = account

    /**
     * Returns the raw JSON value of [action].
     *
     * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<Billing> = billing

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
     * Returns the raw JSON value of [nextAction].
     *
     * Unlike [nextAction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextAction")
    @ExcludeMissing
    fun _nextAction(): JsonField<NextAction> = nextAction

    /**
     * Returns the raw JSON value of [pollAfterMs].
     *
     * Unlike [pollAfterMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pollAfterMs") @ExcludeMissing fun _pollAfterMs(): JsonField<Long> = pollAfterMs

    /**
     * Returns the raw JSON value of [request].
     *
     * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

    /**
     * Returns the raw JSON value of [result].
     *
     * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<Result> = result

    /**
     * Returns the raw JSON value of [retryable].
     *
     * Unlike [retryable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retryable") @ExcludeMissing fun _retryable(): JsonField<Boolean> = retryable

    /**
     * Returns the raw JSON value of [safeToRetry].
     *
     * Unlike [safeToRetry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("safeToRetry")
    @ExcludeMissing
    fun _safeToRetry(): JsonField<Boolean> = safeToRetry

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
     * Returns the raw JSON value of [statusUrl].
     *
     * Unlike [statusUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusUrl") @ExcludeMissing fun _statusUrl(): JsonField<String> = statusUrl

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    /**
     * Returns the raw JSON value of [target].
     *
     * Unlike [target], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("target") @ExcludeMissing fun _target(): JsonField<Target> = target

    /**
     * Returns the raw JSON value of [targetId].
     *
     * Unlike [targetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("targetId") @ExcludeMissing fun _targetId(): JsonField<String> = targetId

    /**
     * Returns the raw JSON value of [terminal].
     *
     * Unlike [terminal], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("terminal") @ExcludeMissing fun _terminal(): JsonField<Boolean> = terminal

    /**
     * Returns the raw JSON value of [writeActionId].
     *
     * Unlike [writeActionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("writeActionId")
    @ExcludeMissing
    fun _writeActionId(): JsonField<String> = writeActionId

    /**
     * Returns the raw JSON value of [communityId].
     *
     * Unlike [communityId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityId") @ExcludeMissing fun _communityId(): JsonField<String> = communityId

    /**
     * Returns the raw JSON value of [communityName].
     *
     * Unlike [communityName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityName")
    @ExcludeMissing
    fun _communityName(): JsonField<String> = communityName

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completedAt")
    @ExcludeMissing
    fun _completedAt(): JsonField<OffsetDateTime> = completedAt

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
     * Returns the raw JSON value of [confirmedAt].
     *
     * Unlike [confirmedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("confirmedAt")
    @ExcludeMissing
    fun _confirmedAt(): JsonField<OffsetDateTime> = confirmedAt

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [details].
     *
     * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expiresAt")
    @ExcludeMissing
    fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

    /**
     * Returns the raw JSON value of [idempotent].
     *
     * Unlike [idempotent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("idempotent") @ExcludeMissing fun _idempotent(): JsonField<Boolean> = idempotent

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<Media> = media

    /**
     * Returns the raw JSON value of [mediaId].
     *
     * Unlike [mediaId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaId") @ExcludeMissing fun _mediaId(): JsonField<String> = mediaId

    /**
     * Returns the raw JSON value of [mediaUrl].
     *
     * Unlike [mediaUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaUrl") @ExcludeMissing fun _mediaUrl(): JsonField<String> = mediaUrl

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
     * Returns the raw JSON value of [requestHash].
     *
     * Unlike [requestHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestHash") @ExcludeMissing fun _requestHash(): JsonField<String> = requestHash

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestId") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

    /**
     * Returns the raw JSON value of [resultId].
     *
     * Unlike [resultId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resultId") @ExcludeMissing fun _resultId(): JsonField<String> = resultId

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
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [RetweetCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .account()
         * .action()
         * .billing()
         * .charged()
         * .chargedCredits()
         * .nextAction()
         * .pollAfterMs()
         * .request()
         * .result()
         * .retryable()
         * .safeToRetry()
         * .sendDispatched()
         * .status()
         * .statusUrl()
         * .success()
         * .target()
         * .targetId()
         * .terminal()
         * .writeActionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RetweetCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var account: JsonField<Account>? = null
        private var action: JsonField<Action>? = null
        private var billing: JsonField<Billing>? = null
        private var charged: JsonField<Boolean>? = null
        private var chargedCredits: JsonField<String>? = null
        private var nextAction: JsonField<NextAction>? = null
        private var object_: JsonValue = JsonValue.from("x_write_action")
        private var pollAfterMs: JsonField<Long>? = null
        private var request: JsonField<Request>? = null
        private var result: JsonField<Result>? = null
        private var retryable: JsonField<Boolean>? = null
        private var safeToRetry: JsonField<Boolean>? = null
        private var sendDispatched: JsonField<Boolean>? = null
        private var status: JsonField<Status>? = null
        private var statusUrl: JsonField<String>? = null
        private var success: JsonField<Boolean>? = null
        private var target: JsonField<Target>? = null
        private var targetId: JsonField<String>? = null
        private var terminal: JsonField<Boolean>? = null
        private var writeActionId: JsonField<String>? = null
        private var communityId: JsonField<String> = JsonMissing.of()
        private var communityName: JsonField<String> = JsonMissing.of()
        private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var confirmationAttempts: JsonField<Long> = JsonMissing.of()
        private var confirmationCheckedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var details: JsonField<Details> = JsonMissing.of()
        private var error: JsonField<String> = JsonMissing.of()
        private var expiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var idempotent: JsonField<Boolean> = JsonMissing.of()
        private var media: JsonField<Media> = JsonMissing.of()
        private var mediaId: JsonField<String> = JsonMissing.of()
        private var mediaUrl: JsonField<String> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var requestHash: JsonField<String> = JsonMissing.of()
        private var requestId: JsonField<String> = JsonMissing.of()
        private var resultId: JsonField<String> = JsonMissing.of()
        private var sendDispatchedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var tweetId: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(retweetCreateResponse: RetweetCreateResponse) = apply {
            id = retweetCreateResponse.id
            account = retweetCreateResponse.account
            action = retweetCreateResponse.action
            billing = retweetCreateResponse.billing
            charged = retweetCreateResponse.charged
            chargedCredits = retweetCreateResponse.chargedCredits
            nextAction = retweetCreateResponse.nextAction
            object_ = retweetCreateResponse.object_
            pollAfterMs = retweetCreateResponse.pollAfterMs
            request = retweetCreateResponse.request
            result = retweetCreateResponse.result
            retryable = retweetCreateResponse.retryable
            safeToRetry = retweetCreateResponse.safeToRetry
            sendDispatched = retweetCreateResponse.sendDispatched
            status = retweetCreateResponse.status
            statusUrl = retweetCreateResponse.statusUrl
            success = retweetCreateResponse.success
            target = retweetCreateResponse.target
            targetId = retweetCreateResponse.targetId
            terminal = retweetCreateResponse.terminal
            writeActionId = retweetCreateResponse.writeActionId
            communityId = retweetCreateResponse.communityId
            communityName = retweetCreateResponse.communityName
            completedAt = retweetCreateResponse.completedAt
            confirmationAttempts = retweetCreateResponse.confirmationAttempts
            confirmationCheckedAt = retweetCreateResponse.confirmationCheckedAt
            confirmedAt = retweetCreateResponse.confirmedAt
            createdAt = retweetCreateResponse.createdAt
            details = retweetCreateResponse.details
            error = retweetCreateResponse.error
            expiresAt = retweetCreateResponse.expiresAt
            idempotent = retweetCreateResponse.idempotent
            media = retweetCreateResponse.media
            mediaId = retweetCreateResponse.mediaId
            mediaUrl = retweetCreateResponse.mediaUrl
            message = retweetCreateResponse.message
            messageId = retweetCreateResponse.messageId
            requestHash = retweetCreateResponse.requestHash
            requestId = retweetCreateResponse.requestId
            resultId = retweetCreateResponse.resultId
            sendDispatchedAt = retweetCreateResponse.sendDispatchedAt
            tweetId = retweetCreateResponse.tweetId
            updatedAt = retweetCreateResponse.updatedAt
            additionalProperties = retweetCreateResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Connected account selected for the write. */
        fun account(account: Account?) = account(JsonField.ofNullable(account))

        /** Alias for calling [Builder.account] with `account.orElse(null)`. */
        fun account(account: Optional<Account>) = account(account.getOrNull())

        /**
         * Sets [Builder.account] to an arbitrary JSON value.
         *
         * You should usually call [Builder.account] with a well-typed [Account] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun account(account: JsonField<Account>) = apply { this.account = account }

        fun action(action: Action) = action(JsonField.of(action))

        /**
         * Sets [Builder.action] to an arbitrary JSON value.
         *
         * You should usually call [Builder.action] with a well-typed [Action] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun action(action: JsonField<Action>) = apply { this.action = action }

        /**
         * plannedCredits is the approved maximum. chargedCredits comes from the settled credit
         * ledger. Pending or failed writes are not charged.
         */
        fun billing(billing: Billing) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [Billing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun billing(billing: JsonField<Billing>) = apply { this.billing = billing }

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

        /** Exact follow-up an API client or agent should perform. */
        fun nextAction(nextAction: NextAction?) = nextAction(JsonField.ofNullable(nextAction))

        /** Alias for calling [Builder.nextAction] with `nextAction.orElse(null)`. */
        fun nextAction(nextAction: Optional<NextAction>) = nextAction(nextAction.getOrNull())

        /**
         * Sets [Builder.nextAction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextAction] with a well-typed [NextAction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun nextAction(nextAction: JsonField<NextAction>) = apply { this.nextAction = nextAction }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("x_write_action")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun pollAfterMs(pollAfterMs: Long?) = pollAfterMs(JsonField.ofNullable(pollAfterMs))

        /**
         * Alias for [Builder.pollAfterMs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pollAfterMs(pollAfterMs: Long) = pollAfterMs(pollAfterMs as Long?)

        /** Alias for calling [Builder.pollAfterMs] with `pollAfterMs.orElse(null)`. */
        fun pollAfterMs(pollAfterMs: Optional<Long>) = pollAfterMs(pollAfterMs.getOrNull())

        /**
         * Sets [Builder.pollAfterMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pollAfterMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pollAfterMs(pollAfterMs: JsonField<Long>) = apply { this.pollAfterMs = pollAfterMs }

        /** Stable fingerprint and sanitized payload for replay checks. */
        fun request(request: Request) = request(JsonField.of(request))

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed [Request] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        /** Confirmed result produced by the write, when available. */
        fun result(result: Result?) = result(JsonField.ofNullable(result))

        /** Alias for calling [Builder.result] with `result.orElse(null)`. */
        fun result(result: Optional<Result>) = result(result.getOrNull())

        /**
         * Sets [Builder.result] to an arbitrary JSON value.
         *
         * You should usually call [Builder.result] with a well-typed [Result] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun result(result: JsonField<Result>) = apply { this.result = result }

        /** True only when a new attempt can reasonably succeed. */
        fun retryable(retryable: Boolean) = retryable(JsonField.of(retryable))

        /**
         * Sets [Builder.retryable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retryable] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retryable(retryable: JsonField<Boolean>) = apply { this.retryable = retryable }

        /** True only when no write was dispatched and a new idempotency key may be used. */
        fun safeToRetry(safeToRetry: Boolean) = safeToRetry(JsonField.of(safeToRetry))

        /**
         * Sets [Builder.safeToRetry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.safeToRetry] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun safeToRetry(safeToRetry: JsonField<Boolean>) = apply { this.safeToRetry = safeToRetry }

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

        fun statusUrl(statusUrl: String) = statusUrl(JsonField.of(statusUrl))

        /**
         * Sets [Builder.statusUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun statusUrl(statusUrl: JsonField<String>) = apply { this.statusUrl = statusUrl }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

        /** Existing X resource targeted by the write, when applicable. */
        fun target(target: Target?) = target(JsonField.ofNullable(target))

        /** Alias for calling [Builder.target] with `target.orElse(null)`. */
        fun target(target: Optional<Target>) = target(target.getOrNull())

        /**
         * Sets [Builder.target] to an arbitrary JSON value.
         *
         * You should usually call [Builder.target] with a well-typed [Target] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun target(target: JsonField<Target>) = apply { this.target = target }

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

        fun terminal(terminal: Boolean) = terminal(JsonField.of(terminal))

        /**
         * Sets [Builder.terminal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.terminal] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun terminal(terminal: JsonField<Boolean>) = apply { this.terminal = terminal }

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

        /** Compatibility field for a confirmed community ID. */
        fun communityId(communityId: String) = communityId(JsonField.of(communityId))

        /**
         * Sets [Builder.communityId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.communityId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun communityId(communityId: JsonField<String>) = apply { this.communityId = communityId }

        /** Confirmed community name when available. */
        fun communityName(communityName: String) = communityName(JsonField.of(communityName))

        /**
         * Sets [Builder.communityName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.communityName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun communityName(communityName: JsonField<String>) = apply {
            this.communityName = communityName
        }

        fun completedAt(completedAt: OffsetDateTime) = completedAt(JsonField.of(completedAt))

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
            this.completedAt = completedAt
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

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Structured recovery context for a failed write. */
        fun details(details: Details) = details(JsonField.of(details))

        /**
         * Sets [Builder.details] to an arbitrary JSON value.
         *
         * You should usually call [Builder.details] with a well-typed [Details] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun details(details: JsonField<Details>) = apply { this.details = details }

        fun error(error: String) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<String>) = apply { this.error = error }

        /**
         * Deadline for resolving a non-terminal write. This is not the Idempotency-Key retention
         * deadline.
         */
        fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

        fun idempotent(idempotent: Boolean) = idempotent(JsonField.of(idempotent))

        /**
         * Sets [Builder.idempotent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.idempotent] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun idempotent(idempotent: JsonField<Boolean>) = apply { this.idempotent = idempotent }

        /** Media count, kind, size, and billing details when used. */
        fun media(media: Media) = media(JsonField.of(media))

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed [Media] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun media(media: JsonField<Media>) = apply { this.media = media }

        /** Compatibility field for a confirmed media upload ID. */
        fun mediaId(mediaId: String) = mediaId(JsonField.of(mediaId))

        /**
         * Sets [Builder.mediaId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaId(mediaId: JsonField<String>) = apply { this.mediaId = mediaId }

        /** Public media URL when the upload creates one. */
        fun mediaUrl(mediaUrl: String) = mediaUrl(JsonField.of(mediaUrl))

        /**
         * Sets [Builder.mediaUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaUrl(mediaUrl: JsonField<String>) = apply { this.mediaUrl = mediaUrl }

        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** Compatibility field for a confirmed direct message ID. */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        fun requestHash(requestHash: String) = requestHash(JsonField.of(requestHash))

        /**
         * Sets [Builder.requestHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestHash] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestHash(requestHash: JsonField<String>) = apply { this.requestHash = requestHash }

        fun requestId(requestId: String) = requestId(JsonField.of(requestId))

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        /** Compatibility result ID for other write actions. */
        fun resultId(resultId: String) = resultId(JsonField.of(resultId))

        /**
         * Sets [Builder.resultId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resultId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun resultId(resultId: JsonField<String>) = apply { this.resultId = resultId }

        /** Dispatch timestamp when the write reached execution. */
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

        /** Compatibility field for a confirmed tweet result ID. */
        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [RetweetCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .account()
         * .action()
         * .billing()
         * .charged()
         * .chargedCredits()
         * .nextAction()
         * .pollAfterMs()
         * .request()
         * .result()
         * .retryable()
         * .safeToRetry()
         * .sendDispatched()
         * .status()
         * .statusUrl()
         * .success()
         * .target()
         * .targetId()
         * .terminal()
         * .writeActionId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RetweetCreateResponse =
            RetweetCreateResponse(
                checkRequired("id", id),
                checkRequired("account", account),
                checkRequired("action", action),
                checkRequired("billing", billing),
                checkRequired("charged", charged),
                checkRequired("chargedCredits", chargedCredits),
                checkRequired("nextAction", nextAction),
                object_,
                checkRequired("pollAfterMs", pollAfterMs),
                checkRequired("request", request),
                checkRequired("result", result),
                checkRequired("retryable", retryable),
                checkRequired("safeToRetry", safeToRetry),
                checkRequired("sendDispatched", sendDispatched),
                checkRequired("status", status),
                checkRequired("statusUrl", statusUrl),
                checkRequired("success", success),
                checkRequired("target", target),
                checkRequired("targetId", targetId),
                checkRequired("terminal", terminal),
                checkRequired("writeActionId", writeActionId),
                communityId,
                communityName,
                completedAt,
                confirmationAttempts,
                confirmationCheckedAt,
                confirmedAt,
                createdAt,
                details,
                error,
                expiresAt,
                idempotent,
                media,
                mediaId,
                mediaUrl,
                message,
                messageId,
                requestHash,
                requestId,
                resultId,
                sendDispatchedAt,
                tweetId,
                updatedAt,
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
    fun validate(): RetweetCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        account().ifPresent { it.validate() }
        action().validate()
        billing().validate()
        charged()
        chargedCredits()
        nextAction().ifPresent { it.validate() }
        _object_().let {
            if (it != JsonValue.from("x_write_action")) {
                throw XTwitterScraperInvalidDataException("'object_' is invalid, received $it")
            }
        }
        pollAfterMs()
        request().validate()
        result().ifPresent { it.validate() }
        retryable()
        safeToRetry()
        sendDispatched()
        status().validate()
        statusUrl()
        success()
        target().ifPresent { it.validate() }
        targetId()
        terminal()
        writeActionId()
        communityId()
        communityName()
        completedAt()
        confirmationAttempts()
        confirmationCheckedAt()
        confirmedAt()
        createdAt()
        details().ifPresent { it.validate() }
        error()
        expiresAt()
        idempotent()
        media().ifPresent { it.validate() }
        mediaId()
        mediaUrl()
        message()
        messageId()
        requestHash()
        requestId()
        resultId()
        sendDispatchedAt()
        tweetId()
        updatedAt()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (account.asKnown().getOrNull()?.validity() ?: 0) +
            (action.asKnown().getOrNull()?.validity() ?: 0) +
            (billing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (charged.asKnown().isPresent) 1 else 0) +
            (if (chargedCredits.asKnown().isPresent) 1 else 0) +
            (nextAction.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("x_write_action")) 1 else 0 } +
            (if (pollAfterMs.asKnown().isPresent) 1 else 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            (result.asKnown().getOrNull()?.validity() ?: 0) +
            (if (retryable.asKnown().isPresent) 1 else 0) +
            (if (safeToRetry.asKnown().isPresent) 1 else 0) +
            (if (sendDispatched.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (statusUrl.asKnown().isPresent) 1 else 0) +
            (if (success.asKnown().isPresent) 1 else 0) +
            (target.asKnown().getOrNull()?.validity() ?: 0) +
            (if (targetId.asKnown().isPresent) 1 else 0) +
            (if (terminal.asKnown().isPresent) 1 else 0) +
            (if (writeActionId.asKnown().isPresent) 1 else 0) +
            (if (communityId.asKnown().isPresent) 1 else 0) +
            (if (communityName.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (confirmationAttempts.asKnown().isPresent) 1 else 0) +
            (if (confirmationCheckedAt.asKnown().isPresent) 1 else 0) +
            (if (confirmedAt.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (details.asKnown().getOrNull()?.validity() ?: 0) +
            (if (error.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (idempotent.asKnown().isPresent) 1 else 0) +
            (media.asKnown().getOrNull()?.validity() ?: 0) +
            (if (mediaId.asKnown().isPresent) 1 else 0) +
            (if (mediaUrl.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (requestHash.asKnown().isPresent) 1 else 0) +
            (if (requestId.asKnown().isPresent) 1 else 0) +
            (if (resultId.asKnown().isPresent) 1 else 0) +
            (if (sendDispatchedAt.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /** Connected account selected for the write. */
    class Account
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val username: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
        ) : this(id, username, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun username(): String = username.getRequired("username")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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
             * Returns a mutable builder for constructing an instance of [Account].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .username()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Account]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var username: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(account: Account) = apply {
                id = account.id
                username = account.username
                additionalProperties = account.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

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
             * Returns an immutable instance of [Account].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .username()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Account =
                Account(
                    checkRequired("id", id),
                    checkRequired("username", username),
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
        fun validate(): Account = apply {
            if (validated) {
                return@apply
            }

            id()
            username()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (username.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Account &&
                id == other.id &&
                username == other.username &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, username, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Account{id=$id, username=$username, additionalProperties=$additionalProperties}"
    }

    class Action @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val CREATE_TWEET = of("create_tweet")

            @JvmField val DELETE_TWEET = of("delete_tweet")

            @JvmField val LIKE = of("like")

            @JvmField val UNLIKE = of("unlike")

            @JvmField val RETWEET = of("retweet")

            @JvmField val UNRETWEET = of("unretweet")

            @JvmField val FOLLOW = of("follow")

            @JvmField val UNFOLLOW = of("unfollow")

            @JvmField val REMOVE_FOLLOWER = of("remove_follower")

            @JvmField val SEND_DM = of("send_dm")

            @JvmField val UPLOAD_MEDIA = of("upload_media")

            @JvmField val UPDATE_PROFILE = of("update_profile")

            @JvmField val UPDATE_AVATAR = of("update_avatar")

            @JvmField val UPDATE_BANNER = of("update_banner")

            @JvmField val CREATE_COMMUNITY = of("create_community")

            @JvmField val DELETE_COMMUNITY = of("delete_community")

            @JvmField val JOIN_COMMUNITY = of("join_community")

            @JvmField val LEAVE_COMMUNITY = of("leave_community")

            @JvmStatic fun of(value: String) = Action(JsonField.of(value))
        }

        /** An enum containing [Action]'s known values. */
        enum class Known {
            CREATE_TWEET,
            DELETE_TWEET,
            LIKE,
            UNLIKE,
            RETWEET,
            UNRETWEET,
            FOLLOW,
            UNFOLLOW,
            REMOVE_FOLLOWER,
            SEND_DM,
            UPLOAD_MEDIA,
            UPDATE_PROFILE,
            UPDATE_AVATAR,
            UPDATE_BANNER,
            CREATE_COMMUNITY,
            DELETE_COMMUNITY,
            JOIN_COMMUNITY,
            LEAVE_COMMUNITY,
        }

        /**
         * An enum containing [Action]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Action] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CREATE_TWEET,
            DELETE_TWEET,
            LIKE,
            UNLIKE,
            RETWEET,
            UNRETWEET,
            FOLLOW,
            UNFOLLOW,
            REMOVE_FOLLOWER,
            SEND_DM,
            UPLOAD_MEDIA,
            UPDATE_PROFILE,
            UPDATE_AVATAR,
            UPDATE_BANNER,
            CREATE_COMMUNITY,
            DELETE_COMMUNITY,
            JOIN_COMMUNITY,
            LEAVE_COMMUNITY,
            /** An enum member indicating that [Action] was instantiated with an unknown value. */
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
                CREATE_TWEET -> Value.CREATE_TWEET
                DELETE_TWEET -> Value.DELETE_TWEET
                LIKE -> Value.LIKE
                UNLIKE -> Value.UNLIKE
                RETWEET -> Value.RETWEET
                UNRETWEET -> Value.UNRETWEET
                FOLLOW -> Value.FOLLOW
                UNFOLLOW -> Value.UNFOLLOW
                REMOVE_FOLLOWER -> Value.REMOVE_FOLLOWER
                SEND_DM -> Value.SEND_DM
                UPLOAD_MEDIA -> Value.UPLOAD_MEDIA
                UPDATE_PROFILE -> Value.UPDATE_PROFILE
                UPDATE_AVATAR -> Value.UPDATE_AVATAR
                UPDATE_BANNER -> Value.UPDATE_BANNER
                CREATE_COMMUNITY -> Value.CREATE_COMMUNITY
                DELETE_COMMUNITY -> Value.DELETE_COMMUNITY
                JOIN_COMMUNITY -> Value.JOIN_COMMUNITY
                LEAVE_COMMUNITY -> Value.LEAVE_COMMUNITY
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
                CREATE_TWEET -> Known.CREATE_TWEET
                DELETE_TWEET -> Known.DELETE_TWEET
                LIKE -> Known.LIKE
                UNLIKE -> Known.UNLIKE
                RETWEET -> Known.RETWEET
                UNRETWEET -> Known.UNRETWEET
                FOLLOW -> Known.FOLLOW
                UNFOLLOW -> Known.UNFOLLOW
                REMOVE_FOLLOWER -> Known.REMOVE_FOLLOWER
                SEND_DM -> Known.SEND_DM
                UPLOAD_MEDIA -> Known.UPLOAD_MEDIA
                UPDATE_PROFILE -> Known.UPDATE_PROFILE
                UPDATE_AVATAR -> Known.UPDATE_AVATAR
                UPDATE_BANNER -> Known.UPDATE_BANNER
                CREATE_COMMUNITY -> Known.CREATE_COMMUNITY
                DELETE_COMMUNITY -> Known.DELETE_COMMUNITY
                JOIN_COMMUNITY -> Known.JOIN_COMMUNITY
                LEAVE_COMMUNITY -> Known.LEAVE_COMMUNITY
                else -> throw XTwitterScraperInvalidDataException("Unknown Action: $value")
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
        fun validate(): Action = apply {
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

            return other is Action && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * plannedCredits is the approved maximum. chargedCredits comes from the settled credit ledger.
     * Pending or failed writes are not charged.
     */
    class Billing
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val charged: JsonField<Boolean>,
        private val chargedCredits: JsonField<String>,
        private val plannedCredits: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("charged") @ExcludeMissing charged: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("chargedCredits")
            @ExcludeMissing
            chargedCredits: JsonField<String> = JsonMissing.of(),
            @JsonProperty("plannedCredits")
            @ExcludeMissing
            plannedCredits: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(charged, chargedCredits, plannedCredits, status, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun charged(): Boolean = charged.getRequired("charged")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun chargedCredits(): String = chargedCredits.getRequired("chargedCredits")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun plannedCredits(): String = plannedCredits.getRequired("plannedCredits")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Returns the raw JSON value of [charged].
         *
         * Unlike [charged], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("charged") @ExcludeMissing fun _charged(): JsonField<Boolean> = charged

        /**
         * Returns the raw JSON value of [chargedCredits].
         *
         * Unlike [chargedCredits], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("chargedCredits")
        @ExcludeMissing
        fun _chargedCredits(): JsonField<String> = chargedCredits

        /**
         * Returns the raw JSON value of [plannedCredits].
         *
         * Unlike [plannedCredits], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("plannedCredits")
        @ExcludeMissing
        fun _plannedCredits(): JsonField<String> = plannedCredits

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [Billing].
             *
             * The following fields are required:
             * ```java
             * .charged()
             * .chargedCredits()
             * .plannedCredits()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Billing]. */
        class Builder internal constructor() {

            private var charged: JsonField<Boolean>? = null
            private var chargedCredits: JsonField<String>? = null
            private var plannedCredits: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(billing: Billing) = apply {
                charged = billing.charged
                chargedCredits = billing.chargedCredits
                plannedCredits = billing.plannedCredits
                status = billing.status
                additionalProperties = billing.additionalProperties.toMutableMap()
            }

            fun charged(charged: Boolean) = charged(JsonField.of(charged))

            /**
             * Sets [Builder.charged] to an arbitrary JSON value.
             *
             * You should usually call [Builder.charged] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun charged(charged: JsonField<Boolean>) = apply { this.charged = charged }

            fun chargedCredits(chargedCredits: String) =
                chargedCredits(JsonField.of(chargedCredits))

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

            fun plannedCredits(plannedCredits: String) =
                plannedCredits(JsonField.of(plannedCredits))

            /**
             * Sets [Builder.plannedCredits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.plannedCredits] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun plannedCredits(plannedCredits: JsonField<String>) = apply {
                this.plannedCredits = plannedCredits
            }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [Billing].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .charged()
             * .chargedCredits()
             * .plannedCredits()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Billing =
                Billing(
                    checkRequired("charged", charged),
                    checkRequired("chargedCredits", chargedCredits),
                    checkRequired("plannedCredits", plannedCredits),
                    checkRequired("status", status),
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
        fun validate(): Billing = apply {
            if (validated) {
                return@apply
            }

            charged()
            chargedCredits()
            plannedCredits()
            status().validate()
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
            (if (charged.asKnown().isPresent) 1 else 0) +
                (if (chargedCredits.asKnown().isPresent) 1 else 0) +
                (if (plannedCredits.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val NOT_CHARGED = of("not_charged")

                @JvmField val PENDING = of("pending")

                @JvmField val CHARGED = of("charged")

                @JvmField val CHARGE_FAILED = of("charge_failed")

                @JvmField val REFUNDED = of("refunded")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                NOT_CHARGED,
                PENDING,
                CHARGED,
                CHARGE_FAILED,
                REFUNDED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NOT_CHARGED,
                PENDING,
                CHARGED,
                CHARGE_FAILED,
                REFUNDED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
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
                    NOT_CHARGED -> Value.NOT_CHARGED
                    PENDING -> Value.PENDING
                    CHARGED -> Value.CHARGED
                    CHARGE_FAILED -> Value.CHARGE_FAILED
                    REFUNDED -> Value.REFUNDED
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
                    NOT_CHARGED -> Known.NOT_CHARGED
                    PENDING -> Known.PENDING
                    CHARGED -> Known.CHARGED
                    CHARGE_FAILED -> Known.CHARGE_FAILED
                    REFUNDED -> Known.REFUNDED
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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

            return other is Billing &&
                charged == other.charged &&
                chargedCredits == other.chargedCredits &&
                plannedCredits == other.plannedCredits &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(charged, chargedCredits, plannedCredits, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Billing{charged=$charged, chargedCredits=$chargedCredits, plannedCredits=$plannedCredits, status=$status, additionalProperties=$additionalProperties}"
    }

    /** Exact follow-up an API client or agent should perform. */
    class NextAction
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonField<Type>,
        private val afterMs: JsonField<Long>,
        private val requiresNewIdempotencyKey: JsonField<Boolean>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("afterMs") @ExcludeMissing afterMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("requiresNewIdempotencyKey")
            @ExcludeMissing
            requiresNewIdempotencyKey: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(type, afterMs, requiresNewIdempotencyKey, url, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun afterMs(): Optional<Long> = afterMs.getOptional("afterMs")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun requiresNewIdempotencyKey(): Optional<Boolean> =
            requiresNewIdempotencyKey.getOptional("requiresNewIdempotencyKey")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [afterMs].
         *
         * Unlike [afterMs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("afterMs") @ExcludeMissing fun _afterMs(): JsonField<Long> = afterMs

        /**
         * Returns the raw JSON value of [requiresNewIdempotencyKey].
         *
         * Unlike [requiresNewIdempotencyKey], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("requiresNewIdempotencyKey")
        @ExcludeMissing
        fun _requiresNewIdempotencyKey(): JsonField<Boolean> = requiresNewIdempotencyKey

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
             * Returns a mutable builder for constructing an instance of [NextAction].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NextAction]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var afterMs: JsonField<Long> = JsonMissing.of()
            private var requiresNewIdempotencyKey: JsonField<Boolean> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(nextAction: NextAction) = apply {
                type = nextAction.type
                afterMs = nextAction.afterMs
                requiresNewIdempotencyKey = nextAction.requiresNewIdempotencyKey
                url = nextAction.url
                additionalProperties = nextAction.additionalProperties.toMutableMap()
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            fun afterMs(afterMs: Long) = afterMs(JsonField.of(afterMs))

            /**
             * Sets [Builder.afterMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.afterMs] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun afterMs(afterMs: JsonField<Long>) = apply { this.afterMs = afterMs }

            fun requiresNewIdempotencyKey(requiresNewIdempotencyKey: Boolean) =
                requiresNewIdempotencyKey(JsonField.of(requiresNewIdempotencyKey))

            /**
             * Sets [Builder.requiresNewIdempotencyKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requiresNewIdempotencyKey] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun requiresNewIdempotencyKey(requiresNewIdempotencyKey: JsonField<Boolean>) = apply {
                this.requiresNewIdempotencyKey = requiresNewIdempotencyKey
            }

            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [NextAction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NextAction =
                NextAction(
                    checkRequired("type", type),
                    afterMs,
                    requiresNewIdempotencyKey,
                    url,
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
        fun validate(): NextAction = apply {
            if (validated) {
                return@apply
            }

            type().validate()
            afterMs()
            requiresNewIdempotencyKey()
            url()
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (afterMs.asKnown().isPresent) 1 else 0) +
                (if (requiresNewIdempotencyKey.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val POLL = of("poll")

                @JvmField val RETRY = of("retry")

                @JvmField val VERIFY_RESULT = of("verify_result")

                @JvmField val FIX_REQUEST = of("fix_request")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                POLL,
                RETRY,
                VERIFY_RESULT,
                FIX_REQUEST,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                POLL,
                RETRY,
                VERIFY_RESULT,
                FIX_REQUEST,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    POLL -> Value.POLL
                    RETRY -> Value.RETRY
                    VERIFY_RESULT -> Value.VERIFY_RESULT
                    FIX_REQUEST -> Value.FIX_REQUEST
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
                    POLL -> Known.POLL
                    RETRY -> Known.RETRY
                    VERIFY_RESULT -> Known.VERIFY_RESULT
                    FIX_REQUEST -> Known.FIX_REQUEST
                    else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
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
            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NextAction &&
                type == other.type &&
                afterMs == other.afterMs &&
                requiresNewIdempotencyKey == other.requiresNewIdempotencyKey &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(type, afterMs, requiresNewIdempotencyKey, url, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NextAction{type=$type, afterMs=$afterMs, requiresNewIdempotencyKey=$requiresNewIdempotencyKey, url=$url, additionalProperties=$additionalProperties}"
    }

    /** Stable fingerprint and sanitized payload for replay checks. */
    class Request
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hash: JsonField<String>,
        private val payload: JsonField<Payload>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hash") @ExcludeMissing hash: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payload") @ExcludeMissing payload: JsonField<Payload> = JsonMissing.of(),
        ) : this(hash, payload, mutableMapOf())

        /**
         * Stable hash of account, action, target, and payload.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hash(): Optional<String> = hash.getOptional("hash")

        /**
         * Exact sanitized payload dispatched for this action.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun payload(): Optional<Payload> = payload.getOptional("payload")

        /**
         * Returns the raw JSON value of [hash].
         *
         * Unlike [hash], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hash") @ExcludeMissing fun _hash(): JsonField<String> = hash

        /**
         * Returns the raw JSON value of [payload].
         *
         * Unlike [payload], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("payload") @ExcludeMissing fun _payload(): JsonField<Payload> = payload

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
             * Returns a mutable builder for constructing an instance of [Request].
             *
             * The following fields are required:
             * ```java
             * .hash()
             * .payload()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Request]. */
        class Builder internal constructor() {

            private var hash: JsonField<String>? = null
            private var payload: JsonField<Payload>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(request: Request) = apply {
                hash = request.hash
                payload = request.payload
                additionalProperties = request.additionalProperties.toMutableMap()
            }

            /** Stable hash of account, action, target, and payload. */
            fun hash(hash: String?) = hash(JsonField.ofNullable(hash))

            /** Alias for calling [Builder.hash] with `hash.orElse(null)`. */
            fun hash(hash: Optional<String>) = hash(hash.getOrNull())

            /**
             * Sets [Builder.hash] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hash] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun hash(hash: JsonField<String>) = apply { this.hash = hash }

            /** Exact sanitized payload dispatched for this action. */
            fun payload(payload: Payload?) = payload(JsonField.ofNullable(payload))

            /** Alias for calling [Builder.payload] with `payload.orElse(null)`. */
            fun payload(payload: Optional<Payload>) = payload(payload.getOrNull())

            /**
             * Sets [Builder.payload] to an arbitrary JSON value.
             *
             * You should usually call [Builder.payload] with a well-typed [Payload] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun payload(payload: JsonField<Payload>) = apply { this.payload = payload }

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
             * Returns an immutable instance of [Request].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hash()
             * .payload()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Request =
                Request(
                    checkRequired("hash", hash),
                    checkRequired("payload", payload),
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
        fun validate(): Request = apply {
            if (validated) {
                return@apply
            }

            hash()
            payload().ifPresent { it.validate() }
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
            (if (hash.asKnown().isPresent) 1 else 0) +
                (payload.asKnown().getOrNull()?.validity() ?: 0)

        /** Exact sanitized payload dispatched for this action. */
        class Payload
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Payload]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Payload]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(payload: Payload) = apply {
                    additionalProperties = payload.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Payload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Payload = Payload(additionalProperties.toImmutable())
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
            fun validate(): Payload = apply {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Payload && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Payload{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Request &&
                hash == other.hash &&
                payload == other.payload &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(hash, payload, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Request{hash=$hash, payload=$payload, additionalProperties=$additionalProperties}"
    }

    /** Confirmed result produced by the write, when available. */
    class Result
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val state: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(id, state, type, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                id = result.id
                state = result.state
                type = result.type
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun state(state: String) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Result].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Result = Result(id, state, type, additionalProperties.toMutableMap())
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
        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            id()
            state()
            type().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val TWEET = of("tweet")

                @JvmField val DIRECT_MESSAGE = of("direct_message")

                @JvmField val MEDIA = of("media")

                @JvmField val COMMUNITY = of("community")

                @JvmField val STATE_CHANGE = of("state_change")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                TWEET,
                DIRECT_MESSAGE,
                MEDIA,
                COMMUNITY,
                STATE_CHANGE,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TWEET,
                DIRECT_MESSAGE,
                MEDIA,
                COMMUNITY,
                STATE_CHANGE,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    TWEET -> Value.TWEET
                    DIRECT_MESSAGE -> Value.DIRECT_MESSAGE
                    MEDIA -> Value.MEDIA
                    COMMUNITY -> Value.COMMUNITY
                    STATE_CHANGE -> Value.STATE_CHANGE
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
                    TWEET -> Known.TWEET
                    DIRECT_MESSAGE -> Known.DIRECT_MESSAGE
                    MEDIA -> Known.MEDIA
                    COMMUNITY -> Known.COMMUNITY
                    STATE_CHANGE -> Known.STATE_CHANGE
                    else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
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
            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                id == other.id &&
                state == other.state &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, state, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{id=$id, state=$state, type=$type, additionalProperties=$additionalProperties}"
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

            @JvmField val ACCEPTED = of("accepted")

            @JvmField val DISPATCHING = of("dispatching")

            @JvmField val PENDING_CONFIRMATION = of("pending_confirmation")

            @JvmField val SUCCESS = of("success")

            @JvmField val FAILED = of("failed")

            @JvmField val EXPIRED = of("expired")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            ACCEPTED,
            DISPATCHING,
            PENDING_CONFIRMATION,
            SUCCESS,
            FAILED,
            EXPIRED,
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
            ACCEPTED,
            DISPATCHING,
            PENDING_CONFIRMATION,
            SUCCESS,
            FAILED,
            EXPIRED,
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
                ACCEPTED -> Value.ACCEPTED
                DISPATCHING -> Value.DISPATCHING
                PENDING_CONFIRMATION -> Value.PENDING_CONFIRMATION
                SUCCESS -> Value.SUCCESS
                FAILED -> Value.FAILED
                EXPIRED -> Value.EXPIRED
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
                ACCEPTED -> Known.ACCEPTED
                DISPATCHING -> Known.DISPATCHING
                PENDING_CONFIRMATION -> Known.PENDING_CONFIRMATION
                SUCCESS -> Known.SUCCESS
                FAILED -> Known.FAILED
                EXPIRED -> Known.EXPIRED
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

    /** Existing X resource targeted by the write, when applicable. */
    class Target
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(id, type, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [Target].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Target]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(target: Target) = apply {
                id = target.id
                type = target.type
                additionalProperties = target.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Target].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Target =
                Target(
                    checkRequired("id", id),
                    checkRequired("type", type),
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
        fun validate(): Target = apply {
            if (validated) {
                return@apply
            }

            id()
            type().validate()
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
            (if (id.asKnown().isPresent) 1 else 0) + (type.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val TWEET = of("tweet")

                @JvmField val USER = of("user")

                @JvmField val COMMUNITY = of("community")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                TWEET,
                USER,
                COMMUNITY,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TWEET,
                USER,
                COMMUNITY,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    TWEET -> Value.TWEET
                    USER -> Value.USER
                    COMMUNITY -> Value.COMMUNITY
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
                    TWEET -> Known.TWEET
                    USER -> Known.USER
                    COMMUNITY -> Known.COMMUNITY
                    else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
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
            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Target &&
                id == other.id &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Target{id=$id, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Structured recovery context for a failed write. */
    class Details
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Details]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Details]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(details: Details) = apply {
                additionalProperties = details.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Details].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Details = Details(additionalProperties.toImmutable())
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
        fun validate(): Details = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int = additionalProperties.count { (_, value) ->
            !value.isNull() && !value.isMissing()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Details && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Details{additionalProperties=$additionalProperties}"
    }

    /** Media count, kind, size, and billing details when used. */
    class Media
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Media]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Media]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(media: Media) = apply {
                additionalProperties = media.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Media].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Media = Media(additionalProperties.toImmutable())
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
        internal fun validity(): Int = additionalProperties.count { (_, value) ->
            !value.isNull() && !value.isMissing()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Media && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Media{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RetweetCreateResponse &&
            id == other.id &&
            account == other.account &&
            action == other.action &&
            billing == other.billing &&
            charged == other.charged &&
            chargedCredits == other.chargedCredits &&
            nextAction == other.nextAction &&
            object_ == other.object_ &&
            pollAfterMs == other.pollAfterMs &&
            request == other.request &&
            result == other.result &&
            retryable == other.retryable &&
            safeToRetry == other.safeToRetry &&
            sendDispatched == other.sendDispatched &&
            status == other.status &&
            statusUrl == other.statusUrl &&
            success == other.success &&
            target == other.target &&
            targetId == other.targetId &&
            terminal == other.terminal &&
            writeActionId == other.writeActionId &&
            communityId == other.communityId &&
            communityName == other.communityName &&
            completedAt == other.completedAt &&
            confirmationAttempts == other.confirmationAttempts &&
            confirmationCheckedAt == other.confirmationCheckedAt &&
            confirmedAt == other.confirmedAt &&
            createdAt == other.createdAt &&
            details == other.details &&
            error == other.error &&
            expiresAt == other.expiresAt &&
            idempotent == other.idempotent &&
            media == other.media &&
            mediaId == other.mediaId &&
            mediaUrl == other.mediaUrl &&
            message == other.message &&
            messageId == other.messageId &&
            requestHash == other.requestHash &&
            requestId == other.requestId &&
            resultId == other.resultId &&
            sendDispatchedAt == other.sendDispatchedAt &&
            tweetId == other.tweetId &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            account,
            action,
            billing,
            charged,
            chargedCredits,
            nextAction,
            object_,
            pollAfterMs,
            request,
            result,
            retryable,
            safeToRetry,
            sendDispatched,
            status,
            statusUrl,
            success,
            target,
            targetId,
            terminal,
            writeActionId,
            communityId,
            communityName,
            completedAt,
            confirmationAttempts,
            confirmationCheckedAt,
            confirmedAt,
            createdAt,
            details,
            error,
            expiresAt,
            idempotent,
            media,
            mediaId,
            mediaUrl,
            message,
            messageId,
            requestHash,
            requestId,
            resultId,
            sendDispatchedAt,
            tweetId,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RetweetCreateResponse{id=$id, account=$account, action=$action, billing=$billing, charged=$charged, chargedCredits=$chargedCredits, nextAction=$nextAction, object_=$object_, pollAfterMs=$pollAfterMs, request=$request, result=$result, retryable=$retryable, safeToRetry=$safeToRetry, sendDispatched=$sendDispatched, status=$status, statusUrl=$statusUrl, success=$success, target=$target, targetId=$targetId, terminal=$terminal, writeActionId=$writeActionId, communityId=$communityId, communityName=$communityName, completedAt=$completedAt, confirmationAttempts=$confirmationAttempts, confirmationCheckedAt=$confirmationCheckedAt, confirmedAt=$confirmedAt, createdAt=$createdAt, details=$details, error=$error, expiresAt=$expiresAt, idempotent=$idempotent, media=$media, mediaId=$mediaId, mediaUrl=$mediaUrl, message=$message, messageId=$messageId, requestHash=$requestHash, requestId=$requestId, resultId=$resultId, sendDispatchedAt=$sendDispatchedAt, tweetId=$tweetId, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
