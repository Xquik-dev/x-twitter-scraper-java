// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get trending hashtags and topics from X by region */
class XGetTrendsParams
private constructor(
    private val count: Long?,
    private val woeid: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Number of trending topics to return (1-50, default 30) */
    fun count(): Optional<Long> = Optional.ofNullable(count)

    /** Region WOEID (1=Worldwide, 23424977=US, 23424975=UK, 23424969=Turkey) */
    fun woeid(): Optional<Long> = Optional.ofNullable(woeid)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): XGetTrendsParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [XGetTrendsParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendsParams]. */
    class Builder internal constructor() {

        private var count: Long? = null
        private var woeid: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(xGetTrendsParams: XGetTrendsParams) = apply {
            count = xGetTrendsParams.count
            woeid = xGetTrendsParams.woeid
            additionalHeaders = xGetTrendsParams.additionalHeaders.toBuilder()
            additionalQueryParams = xGetTrendsParams.additionalQueryParams.toBuilder()
        }

        /** Number of trending topics to return (1-50, default 30) */
        fun count(count: Long?) = apply { this.count = count }

        /**
         * Alias for [Builder.count].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun count(count: Long) = count(count as Long?)

        /** Alias for calling [Builder.count] with `count.orElse(null)`. */
        fun count(count: Optional<Long>) = count(count.getOrNull())

        /** Region WOEID (1=Worldwide, 23424977=US, 23424975=UK, 23424969=Turkey) */
        fun woeid(woeid: Long?) = apply { this.woeid = woeid }

        /**
         * Alias for [Builder.woeid].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun woeid(woeid: Long) = woeid(woeid as Long?)

        /** Alias for calling [Builder.woeid] with `woeid.orElse(null)`. */
        fun woeid(woeid: Optional<Long>) = woeid(woeid.getOrNull())

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
         * Returns an immutable instance of [XGetTrendsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): XGetTrendsParams =
            XGetTrendsParams(count, woeid, additionalHeaders.build(), additionalQueryParams.build())
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                count?.let { put("count", it.toString()) }
                woeid?.let { put("woeid", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendsParams &&
            count == other.count &&
            woeid == other.woeid &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(count, woeid, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "XGetTrendsParams{count=$count, woeid=$woeid, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
