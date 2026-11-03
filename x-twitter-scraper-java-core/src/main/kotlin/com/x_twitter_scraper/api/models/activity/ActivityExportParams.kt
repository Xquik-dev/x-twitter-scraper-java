// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.activity

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Downloads the account's activity log as a CSV, Excel, Markdown, PDF or text file, with the Activity page's filters. */
class ActivityExportParams
private constructor(
    private val format: Format?,
    private val limit: Long?,
    private val category: String?,
    private val status: String?,
    private val q: String?,
    private val since: String?,
    private val until: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** File format of the export. */
    fun format(): Optional<Format> = Optional.ofNullable(format)

    /** Most rows to return. PDF stops at 10,000 rows. */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Activity group, like the Activity page's tabs. `all` by default, or `actions`, `extractions`, `monitors`, `webhooks` or `billing`. */
    fun category(): Optional<String> = Optional.ofNullable(category)

    /** Comma-separated statuses. */
    fun status(): Optional<String> = Optional.ofNullable(status)

    /** Search text. */
    fun q(): Optional<String> = Optional.ofNullable(q)

    /** Oldest time, ISO 8601. */
    fun since(): Optional<String> = Optional.ofNullable(since)

    /** Newest time, ISO 8601. */
    fun until(): Optional<String> = Optional.ofNullable(until)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ActivityExportParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [ActivityExportParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ActivityExportParams]. */
    class Builder internal constructor() {

        private var format: Format? = null
        private var limit: Long? = null
        private var category: String? = null
        private var status: String? = null
        private var q: String? = null
        private var since: String? = null
        private var until: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic internal fun from(activityExportParams: ActivityExportParams) = apply {
            format = activityExportParams.format
            limit = activityExportParams.limit
            category = activityExportParams.category
            status = activityExportParams.status
            q = activityExportParams.q
            since = activityExportParams.since
            until = activityExportParams.until
            additionalHeaders = activityExportParams.additionalHeaders.toBuilder()
            additionalQueryParams = activityExportParams.additionalQueryParams.toBuilder()
        }

        /** File format of the export. */
        fun format(format: Format?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<Format>) = format(format.getOrNull())

        /** Most rows to return. PDF stops at 10,000 rows. */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Activity group, like the Activity page's tabs. `all` by default, or `actions`, `extractions`, `monitors`, `webhooks` or `billing`. */
        fun category(category: String?) = apply { this.category = category }

        /** Alias for calling [Builder.category] with `category.orElse(null)`. */
        fun category(category: Optional<String>) = category(category.getOrNull())

        /** Comma-separated statuses. */
        fun status(status: String?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /** Search text. */
        fun q(q: String?) = apply { this.q = q }

        /** Alias for calling [Builder.q] with `q.orElse(null)`. */
        fun q(q: Optional<String>) = q(q.getOrNull())

        /** Oldest time, ISO 8601. */
        fun since(since: String?) = apply { this.since = since }

        /** Alias for calling [Builder.since] with `since.orElse(null)`. */
        fun since(since: Optional<String>) = since(since.getOrNull())

        /** Newest time, ISO 8601. */
        fun until(until: String?) = apply { this.until = until }

        /** Alias for calling [Builder.until] with `until.orElse(null)`. */
        fun until(until: Optional<String>) = until(until.getOrNull())


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
         * Returns an immutable instance of [ActivityExportParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ActivityExportParams =
            ActivityExportParams(
                format,
                limit,
                category,
                status,
                q,
                since,
                until,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                format?.let { put("format", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                category?.let { put("category", it) }
                status?.let { put("status", it) }
                q?.let { put("q", it) }
                since?.let { put("since", it) }
                until?.let { put("until", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** File format of the export. */
    class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CSV = of("csv")

            @JvmField val XLSX = of("xlsx")

            @JvmField val MD = of("md")

            @JvmField val MD_DOCUMENT = of("md-document")

            @JvmField val PDF = of("pdf")

            @JvmField val TXT = of("txt")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            CSV,
            XLSX,
            MD,
            MD_DOCUMENT,
            PDF,
            TXT,
        }

        /** An enum containing [Format]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            CSV,
            XLSX,
            MD,
            MD_DOCUMENT,
            PDF,
            TXT,
            /** An enum member indicating that [Format] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                CSV -> Value.CSV
                XLSX -> Value.XLSX
                MD -> Value.MD
                MD_DOCUMENT -> Value.MD_DOCUMENT
                PDF -> Value.PDF
                TXT -> Value.TXT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                CSV -> Known.CSV
                XLSX -> Known.XLSX
                MD -> Known.MD
                MD_DOCUMENT -> Known.MD_DOCUMENT
                PDF -> Known.PDF
                TXT -> Known.TXT
                else -> throw XTwitterScraperInvalidDataException("Unknown Format: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Format = apply {
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

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Format && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ActivityExportParams &&
            format == other.format &&
            limit == other.limit &&
            category == other.category &&
            status == other.status &&
            q == other.q &&
            since == other.since &&
            until == other.until &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(format, limit, category, status, q, since, until, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ActivityExportParams{format=$format, limit=$limit, category=$category, status=$status, q=$q, since=$since, until=$until, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
