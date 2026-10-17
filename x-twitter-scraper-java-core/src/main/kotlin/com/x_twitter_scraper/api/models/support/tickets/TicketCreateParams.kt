// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.io.InputStream
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a support ticket */
class TicketCreateParams
private constructor(
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun body(): String = body.body()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun subject(): String = body.subject()

    /**
     * Returns the raw multipart value of [body].
     *
     * Unlike [body], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _body_(): MultipartField<String> = this.body._body_()

    /**
     * Returns the raw multipart value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _subject(): MultipartField<String> = body._subject()

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun attachments(): Optional<List<InputStream>> = body.attachments()

    /**
     * Returns the raw multipart value of [attachments].
     *
     * Unlike [attachments], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _attachments(): MultipartField<List<InputStream>> = body._attachments()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TicketCreateParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * .subject()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TicketCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(ticketCreateParams: TicketCreateParams) = apply {
            idempotencyKey = ticketCreateParams.idempotencyKey
            body = ticketCreateParams.body.toBuilder()
            additionalHeaders = ticketCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = ticketCreateParams.additionalQueryParams.toBuilder()
        }

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        /** Sets the entire request body. */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun body(body: String) = apply { this.body.body(body) }

        /** Sets [Builder.body] to an arbitrary multipart value. */
        fun body(body: MultipartField<String>) = apply { this.body.body(body) }

        fun subject(subject: String) = apply { body.subject(subject) }

        /** Sets [Builder.subject] to an arbitrary multipart value. */
        fun subject(subject: MultipartField<String>) = apply { body.subject(subject) }

        fun attachments(attachments: List<InputStream>) = apply { body.attachments(attachments) }

        /** Sets [Builder.attachments] to an arbitrary multipart value. */
        fun attachments(attachments: MultipartField<List<InputStream>>) = apply {
            body.attachments(attachments)
        }

        /**
         * Adds a single [InputStream] to [attachments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAttachment(attachment: InputStream) = apply { body.addAttachment(attachment) }

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
         * Returns an immutable instance of [TicketCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * .subject()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TicketCreateParams =
            TicketCreateParams(
                idempotencyKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("body" to _body_(), "attachments" to _attachments(), "subject" to _subject()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .filterValues { !it.value.isMissing() }
            .toImmutable()

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val body: MultipartField<String>,
        private val subject: MultipartField<String>,
        private val attachments: MultipartField<List<InputStream>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun body(): String = body.value.getRequired("body")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun subject(): String = subject.value.getRequired("subject")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun attachments(): Optional<List<InputStream>> =
            attachments.value.getOptional("attachments")

        /**
         * Returns the raw multipart value of [body].
         *
         * Unlike [body], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body_(): MultipartField<String> = body

        /**
         * Returns the raw multipart value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): MultipartField<String> = subject

        /**
         * Returns the raw multipart value of [attachments].
         *
         * Unlike [attachments], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("attachments")
        @ExcludeMissing
        fun _attachments(): MultipartField<List<InputStream>> = attachments

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
             * .body()
             * .subject()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var body: MultipartField<String>? = null
            private var subject: MultipartField<String>? = null
            private var attachments: MultipartField<MutableList<InputStream>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                this.body = body.body
                subject = body.subject
                attachments = body.attachments.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun body(body: String) = body(MultipartField.of(body))

            /** Sets [Builder.body] to an arbitrary multipart value. */
            fun body(body: MultipartField<String>) = apply { this.body = body }

            fun subject(subject: String) = subject(MultipartField.of(subject))

            /** Sets [Builder.subject] to an arbitrary multipart value. */
            fun subject(subject: MultipartField<String>) = apply { this.subject = subject }

            fun attachments(attachments: List<InputStream>) =
                attachments(
                    MultipartField.builder<List<InputStream>>()
                        .value(attachments)
                        .filename("attachment")
                        .contentType("application/octet-stream")
                        .build()
                )

            /** Sets [Builder.attachments] to an arbitrary multipart value. */
            fun attachments(attachments: MultipartField<List<InputStream>>) = apply {
                this.attachments = attachments.map { it.toMutableList() }
            }

            /**
             * Adds a single [InputStream] to [attachments].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAttachment(attachment: InputStream) = apply {
                this.attachments =
                    (this.attachments
                            ?: MultipartField.builder<MutableList<InputStream>>()
                                .value(mutableListOf())
                                .filename("attachment")
                                .contentType("application/octet-stream")
                                .build())
                        .also {
                            checkKnown("attachments", it).add(attachment)
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .body()
             * .subject()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("body", body),
                    checkRequired("subject", subject),
                    (attachments ?: MultipartField.of(JsonMissing.of())).map { it.toImmutable() },
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

            body()
            subject()
            attachments()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                body == other.body &&
                subject == other.subject &&
                attachments == other.attachments &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(body, subject, attachments, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{body=$body, subject=$subject, attachments=$attachments, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TicketCreateParams{idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
