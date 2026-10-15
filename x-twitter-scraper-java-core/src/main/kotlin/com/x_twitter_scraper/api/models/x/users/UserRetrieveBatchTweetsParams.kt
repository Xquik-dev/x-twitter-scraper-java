// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns the newest posts of up to 20 users, named by user ID, username or profile link, in the
 * order named. Send ids or usernames, not both. Each post costs 1 credit. A user in unavailable_ids
 * or unprocessed_ids costs nothing.
 */
class UserRetrieveBatchTweetsParams
private constructor(
    private val fields: String?,
    private val ids: String?,
    private val omit: String?,
    private val pageSize: Long?,
    private val usernames: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Comma-separated numeric user IDs (1-20 values). Xquik ignores duplicate IDs and keeps the
     * first-seen order.
     */
    fun ids(): Optional<String> = Optional.ofNullable(ids)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Posts per user (1-20, default 20). A low credit balance can return fewer. Its aliases are
     * limit, count, max_results, maxItems, max_items & per_page.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /**
     * Comma-separated X usernames, with or without @, or profile links such as x.com/nasa (1-20
     * values), in place of ids. A name in another case is the same account. A number is a user ID.
     */
    fun usernames(): Optional<String> = Optional.ofNullable(usernames)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): UserRetrieveBatchTweetsParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [UserRetrieveBatchTweetsParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveBatchTweetsParams]. */
    class Builder internal constructor() {

        private var fields: String? = null
        private var ids: String? = null
        private var omit: String? = null
        private var pageSize: Long? = null
        private var usernames: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userRetrieveBatchTweetsParams: UserRetrieveBatchTweetsParams) = apply {
            fields = userRetrieveBatchTweetsParams.fields
            ids = userRetrieveBatchTweetsParams.ids
            omit = userRetrieveBatchTweetsParams.omit
            pageSize = userRetrieveBatchTweetsParams.pageSize
            usernames = userRetrieveBatchTweetsParams.usernames
            additionalHeaders = userRetrieveBatchTweetsParams.additionalHeaders.toBuilder()
            additionalQueryParams = userRetrieveBatchTweetsParams.additionalQueryParams.toBuilder()
        }

        /**
         * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
         * author.username. A list keeps the field in each item. Case & underscores do not matter. A
         * row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An
         * unknown name answers 400 unknown_field with the valid names, before any read. The price
         * stays the same. SDK row types then hold only the named fields.
         */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /**
         * Comma-separated numeric user IDs (1-20 values). Xquik ignores duplicate IDs and keeps the
         * first-seen order.
         */
        fun ids(ids: String?) = apply { this.ids = ids }

        /** Alias for calling [Builder.ids] with `ids.orElse(null)`. */
        fun ids(ids: Optional<String>) = ids(ids.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Posts per user (1-20, default 20). A low credit balance can return fewer. Its aliases are
         * limit, count, max_results, maxItems, max_items & per_page.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** Alias for [Builder.pageSize]. */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /**
         * Comma-separated X usernames, with or without @, or profile links such as x.com/nasa (1-20
         * values), in place of ids. A name in another case is the same account. A number is a user
         * ID.
         */
        fun usernames(usernames: String?) = apply { this.usernames = usernames }

        /** Alias for calling [Builder.usernames] with `usernames.orElse(null)`. */
        fun usernames(usernames: Optional<String>) = usernames(usernames.getOrNull())

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
         * Returns an immutable instance of [UserRetrieveBatchTweetsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserRetrieveBatchTweetsParams =
            UserRetrieveBatchTweetsParams(
                fields,
                ids,
                omit,
                pageSize,
                usernames,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                fields?.let { put("fields", it) }
                ids?.let { put("ids", it) }
                omit?.let { put("omit", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                usernames?.let { put("usernames", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveBatchTweetsParams &&
            fields == other.fields &&
            ids == other.ids &&
            omit == other.omit &&
            pageSize == other.pageSize &&
            usernames == other.usernames &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            fields,
            ids,
            omit,
            pageSize,
            usernames,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UserRetrieveBatchTweetsParams{fields=$fields, ids=$ids, omit=$omit, pageSize=$pageSize, usernames=$usernames, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
