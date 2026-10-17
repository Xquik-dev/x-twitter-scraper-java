// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Paginated user profiles. No-mode follower, following, and verified follower requests merge
 * independent views automatically. Response fields, page size, aliases, filters, and
 * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy behavior.
 * Follow next_cursor while has_next_page is true.
 */
class PaginatedUsers
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val users: JsonField<List<UserProfile>>,
    private val filteredCount: JsonField<Long>,
    private val scanLimit: JsonField<ScanLimit>,
    private val diagnostic: JsonField<Diagnostic>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("users")
        @ExcludeMissing
        users: JsonField<List<UserProfile>> = JsonMissing.of(),
        @JsonProperty("filtered_count")
        @ExcludeMissing
        filteredCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("scanLimit")
        @ExcludeMissing
        scanLimit: JsonField<ScanLimit> = JsonMissing.of(),
        @JsonProperty("diagnostic")
        @ExcludeMissing
        diagnostic: JsonField<Diagnostic> = JsonMissing.of(),
    ) : this(
        hasNextPage,
        nextCursor,
        users,
        filteredCount,
        scanLimit,
        diagnostic,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun users(): List<UserProfile> = users.getRequired("users")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun filteredCount(): Optional<Long> = filteredCount.getOptional("filtered_count")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun scanLimit(): Optional<ScanLimit> = scanLimit.getOptional("scanLimit")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun diagnostic(): Optional<Diagnostic> = diagnostic.getOptional("diagnostic")

    /**
     * Returns the raw JSON value of [hasNextPage].
     *
     * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_next_page")
    @ExcludeMissing
    fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [users].
     *
     * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<UserProfile>> = users

    /**
     * Returns the raw JSON value of [filteredCount].
     *
     * Unlike [filteredCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filtered_count")
    @ExcludeMissing
    fun _filteredCount(): JsonField<Long> = filteredCount

    /**
     * Returns the raw JSON value of [scanLimit].
     *
     * Unlike [scanLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scanLimit") @ExcludeMissing fun _scanLimit(): JsonField<ScanLimit> = scanLimit

    /**
     * Returns the raw JSON value of [diagnostic].
     *
     * Unlike [diagnostic], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("diagnostic")
    @ExcludeMissing
    fun _diagnostic(): JsonField<Diagnostic> = diagnostic

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
         * Returns a mutable builder for constructing an instance of [PaginatedUsers].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .users()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PaginatedUsers]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var users: JsonField<MutableList<UserProfile>>? = null
        private var filteredCount: JsonField<Long> = JsonMissing.of()
        private var scanLimit: JsonField<ScanLimit> = JsonMissing.of()
        private var diagnostic: JsonField<Diagnostic> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginatedUsers: PaginatedUsers) = apply {
            hasNextPage = paginatedUsers.hasNextPage
            nextCursor = paginatedUsers.nextCursor
            users = paginatedUsers.users.map { it.toMutableList() }
            filteredCount = paginatedUsers.filteredCount
            scanLimit = paginatedUsers.scanLimit
            diagnostic = paginatedUsers.diagnostic
            additionalProperties = paginatedUsers.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun users(users: List<UserProfile>) = users(JsonField.of(users))

        /** Sets [Builder.users] to an arbitrary JSON value. */
        fun users(users: JsonField<List<UserProfile>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [UserProfile] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: UserProfile) = apply {
            users =
                (users ?: JsonField.of(mutableListOf())).also { checkKnown("users", it).add(user) }
        }

        fun filteredCount(filteredCount: Long) = filteredCount(JsonField.of(filteredCount))

        /** Sets [Builder.filteredCount] to an arbitrary JSON value. */
        fun filteredCount(filteredCount: JsonField<Long>) = apply {
            this.filteredCount = filteredCount
        }

        fun scanLimit(scanLimit: ScanLimit) = scanLimit(JsonField.of(scanLimit))

        /** Sets [Builder.scanLimit] to an arbitrary JSON value. */
        fun scanLimit(scanLimit: JsonField<ScanLimit>) = apply { this.scanLimit = scanLimit }

        fun diagnostic(diagnostic: Diagnostic) = diagnostic(JsonField.of(diagnostic))

        /** Sets [Builder.diagnostic] to an arbitrary JSON value. */
        fun diagnostic(diagnostic: JsonField<Diagnostic>) = apply { this.diagnostic = diagnostic }

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
         * Returns an immutable instance of [PaginatedUsers].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .users()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PaginatedUsers =
            PaginatedUsers(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("users", users).map { it.toImmutable() },
                filteredCount,
                scanLimit,
                diagnostic,
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
    fun validate(): PaginatedUsers = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
        users().forEach { it.validate() }
        filteredCount()
        scanLimit().ifPresent { it.validate() }
        diagnostic().ifPresent { it.validate() }
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
        (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (filteredCount.asKnown().isPresent) 1 else 0) +
            (scanLimit.asKnown().getOrNull()?.validity() ?: 0) +
            (diagnostic.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaginatedUsers &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            users == other.users &&
            filteredCount == other.filteredCount &&
            scanLimit == other.scanLimit &&
            diagnostic == other.diagnostic &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            hasNextPage,
            nextCursor,
            users,
            filteredCount,
            scanLimit,
            diagnostic,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginatedUsers{hasNextPage=$hasNextPage, nextCursor=$nextCursor, users=$users, filteredCount=$filteredCount, scanLimit=$scanLimit, diagnostic=$diagnostic, additionalProperties=$additionalProperties}"

    class ScanLimit
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val limit: JsonField<Limit>,
        private val rowsRead: JsonField<Long>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Limit> = JsonMissing.of(),
            @JsonProperty("rowsRead") @ExcludeMissing rowsRead: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(
            limit,
            rowsRead,
            message,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun limit(): Optional<Limit> = limit.getOptional("limit")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun rowsRead(): Optional<Long> = rowsRead.getOptional("rowsRead")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun message(): Optional<String> = message.getOptional("message")

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Limit> = limit

        /**
         * Returns the raw JSON value of [rowsRead].
         *
         * Unlike [rowsRead], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rowsRead") @ExcludeMissing fun _rowsRead(): JsonField<Long> = rowsRead

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
            /** Returns a mutable builder for constructing an instance of [ScanLimit]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ScanLimit]. */
        class Builder internal constructor() {
            private var limit: JsonField<Limit> = JsonMissing.of()
            private var rowsRead: JsonField<Long> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(scanLimit: ScanLimit) = apply {
                limit = scanLimit.limit
                rowsRead = scanLimit.rowsRead
                message = scanLimit.message
                additionalProperties = scanLimit.additionalProperties.toMutableMap()
            }

            fun limit(limit: Limit) = limit(JsonField.of(limit))

            /** Sets [Builder.limit] to an arbitrary JSON value. */
            fun limit(limit: JsonField<Limit>) = apply { this.limit = limit }

            fun rowsRead(rowsRead: Long) = rowsRead(JsonField.of(rowsRead))

            /** Sets [Builder.rowsRead] to an arbitrary JSON value. */
            fun rowsRead(rowsRead: JsonField<Long>) = apply { this.rowsRead = rowsRead }

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
             * Returns an immutable instance of [ScanLimit].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ScanLimit =
                ScanLimit(
                    limit,
                    rowsRead,
                    message,
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
        fun validate(): ScanLimit = apply {
            if (validated) {
                return@apply
            }
            limit().ifPresent { it.validate() }
            rowsRead()
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
            (limit.asKnown().getOrNull()?.validity() ?: 0) +
                (if (rowsRead.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is ScanLimit &&
                limit == other.limit &&
                rowsRead == other.rowsRead &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(limit, rowsRead, message, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ScanLimit{limit=$limit, rowsRead=$rowsRead, message=$message, additionalProperties=$additionalProperties}"

        class Limit @JsonCreator private constructor(private val value: JsonField<Long>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Long> = value

            companion object {

                @JvmField val _100000 = of(100000L)

                @JvmStatic fun of(value: Long) = Limit(JsonField.of(value))
            }

            /** An enum containing [Limit]'s known values. */
            enum class Known {
                _100000
            }

            /**
             * An enum containing [Limit]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Limit] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _100000,
                /**
                 * An enum member indicating that [Limit] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    _100000 -> Value._100000
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    _100000 -> Known._100000
                    else -> throw XTwitterScraperInvalidDataException("Unknown Limit: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asLong(): Long =
                _value().asNumber().getOrNull()?.let {
                    if (it.toDouble() % 1 == 0.0) it.toLong() else null
                } ?: throw XTwitterScraperInvalidDataException("Value is not a Long")

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
            fun validate(): Limit = apply {
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

                return other is Limit && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    class Diagnostic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val complete: JsonField<Boolean>,
        private val cursorFailureCount: JsonField<Long>,
        private val deadlineReached: JsonField<Boolean>,
        private val duplicateCount: JsonField<Long>,
        private val failedStrategyCount: JsonField<Long>,
        private val malformedCount: JsonField<Long>,
        private val pagesFetched: JsonField<Long>,
        private val responseTruncated: JsonField<Boolean>,
        private val resultLimitReached: JsonField<Boolean>,
        private val stalledStrategyCount: JsonField<Long>,
        private val strategyCount: JsonField<Long>,
        private val returnedUsers: JsonField<Long>,
        private val strategies: JsonField<List<Strategy>>,
        private val uniqueUsers: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("complete")
            @ExcludeMissing
            complete: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("cursorFailureCount")
            @ExcludeMissing
            cursorFailureCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("deadlineReached")
            @ExcludeMissing
            deadlineReached: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("duplicateCount")
            @ExcludeMissing
            duplicateCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("failedStrategyCount")
            @ExcludeMissing
            failedStrategyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("malformedCount")
            @ExcludeMissing
            malformedCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("pagesFetched")
            @ExcludeMissing
            pagesFetched: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("responseTruncated")
            @ExcludeMissing
            responseTruncated: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("resultLimitReached")
            @ExcludeMissing
            resultLimitReached: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("stalledStrategyCount")
            @ExcludeMissing
            stalledStrategyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("strategyCount")
            @ExcludeMissing
            strategyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("returnedUsers")
            @ExcludeMissing
            returnedUsers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("strategies")
            @ExcludeMissing
            strategies: JsonField<List<Strategy>> = JsonMissing.of(),
            @JsonProperty("uniqueUsers")
            @ExcludeMissing
            uniqueUsers: JsonField<Long> = JsonMissing.of(),
        ) : this(
            complete,
            cursorFailureCount,
            deadlineReached,
            duplicateCount,
            failedStrategyCount,
            malformedCount,
            pagesFetched,
            responseTruncated,
            resultLimitReached,
            stalledStrategyCount,
            strategyCount,
            returnedUsers,
            strategies,
            uniqueUsers,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun complete(): Optional<Boolean> = complete.getOptional("complete")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun cursorFailureCount(): Optional<Long> =
            cursorFailureCount.getOptional("cursorFailureCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun deadlineReached(): Optional<Boolean> = deadlineReached.getOptional("deadlineReached")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun duplicateCount(): Optional<Long> = duplicateCount.getOptional("duplicateCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun failedStrategyCount(): Optional<Long> =
            failedStrategyCount.getOptional("failedStrategyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun malformedCount(): Optional<Long> = malformedCount.getOptional("malformedCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun pagesFetched(): Optional<Long> = pagesFetched.getOptional("pagesFetched")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun responseTruncated(): Optional<Boolean> =
            responseTruncated.getOptional("responseTruncated")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun resultLimitReached(): Optional<Boolean> =
            resultLimitReached.getOptional("resultLimitReached")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun stalledStrategyCount(): Optional<Long> =
            stalledStrategyCount.getOptional("stalledStrategyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun strategyCount(): Optional<Long> = strategyCount.getOptional("strategyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun returnedUsers(): Optional<Long> = returnedUsers.getOptional("returnedUsers")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun strategies(): Optional<List<Strategy>> = strategies.getOptional("strategies")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun uniqueUsers(): Optional<Long> = uniqueUsers.getOptional("uniqueUsers")

        /**
         * Returns the raw JSON value of [complete].
         *
         * Unlike [complete], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("complete") @ExcludeMissing fun _complete(): JsonField<Boolean> = complete

        /**
         * Returns the raw JSON value of [cursorFailureCount].
         *
         * Unlike [cursorFailureCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cursorFailureCount")
        @ExcludeMissing
        fun _cursorFailureCount(): JsonField<Long> = cursorFailureCount

        /**
         * Returns the raw JSON value of [deadlineReached].
         *
         * Unlike [deadlineReached], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("deadlineReached")
        @ExcludeMissing
        fun _deadlineReached(): JsonField<Boolean> = deadlineReached

        /**
         * Returns the raw JSON value of [duplicateCount].
         *
         * Unlike [duplicateCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("duplicateCount")
        @ExcludeMissing
        fun _duplicateCount(): JsonField<Long> = duplicateCount

        /**
         * Returns the raw JSON value of [failedStrategyCount].
         *
         * Unlike [failedStrategyCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("failedStrategyCount")
        @ExcludeMissing
        fun _failedStrategyCount(): JsonField<Long> = failedStrategyCount

        /**
         * Returns the raw JSON value of [malformedCount].
         *
         * Unlike [malformedCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("malformedCount")
        @ExcludeMissing
        fun _malformedCount(): JsonField<Long> = malformedCount

        /**
         * Returns the raw JSON value of [pagesFetched].
         *
         * Unlike [pagesFetched], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("pagesFetched")
        @ExcludeMissing
        fun _pagesFetched(): JsonField<Long> = pagesFetched

        /**
         * Returns the raw JSON value of [responseTruncated].
         *
         * Unlike [responseTruncated], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("responseTruncated")
        @ExcludeMissing
        fun _responseTruncated(): JsonField<Boolean> = responseTruncated

        /**
         * Returns the raw JSON value of [resultLimitReached].
         *
         * Unlike [resultLimitReached], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("resultLimitReached")
        @ExcludeMissing
        fun _resultLimitReached(): JsonField<Boolean> = resultLimitReached

        /**
         * Returns the raw JSON value of [stalledStrategyCount].
         *
         * Unlike [stalledStrategyCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("stalledStrategyCount")
        @ExcludeMissing
        fun _stalledStrategyCount(): JsonField<Long> = stalledStrategyCount

        /**
         * Returns the raw JSON value of [strategyCount].
         *
         * Unlike [strategyCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("strategyCount")
        @ExcludeMissing
        fun _strategyCount(): JsonField<Long> = strategyCount

        /**
         * Returns the raw JSON value of [returnedUsers].
         *
         * Unlike [returnedUsers], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("returnedUsers")
        @ExcludeMissing
        fun _returnedUsers(): JsonField<Long> = returnedUsers

        /**
         * Returns the raw JSON value of [strategies].
         *
         * Unlike [strategies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("strategies")
        @ExcludeMissing
        fun _strategies(): JsonField<List<Strategy>> = strategies

        /**
         * Returns the raw JSON value of [uniqueUsers].
         *
         * Unlike [uniqueUsers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("uniqueUsers")
        @ExcludeMissing
        fun _uniqueUsers(): JsonField<Long> = uniqueUsers

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
            /** Returns a mutable builder for constructing an instance of [Diagnostic]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Diagnostic]. */
        class Builder internal constructor() {
            private var complete: JsonField<Boolean> = JsonMissing.of()
            private var cursorFailureCount: JsonField<Long> = JsonMissing.of()
            private var deadlineReached: JsonField<Boolean> = JsonMissing.of()
            private var duplicateCount: JsonField<Long> = JsonMissing.of()
            private var failedStrategyCount: JsonField<Long> = JsonMissing.of()
            private var malformedCount: JsonField<Long> = JsonMissing.of()
            private var pagesFetched: JsonField<Long> = JsonMissing.of()
            private var responseTruncated: JsonField<Boolean> = JsonMissing.of()
            private var resultLimitReached: JsonField<Boolean> = JsonMissing.of()
            private var stalledStrategyCount: JsonField<Long> = JsonMissing.of()
            private var strategyCount: JsonField<Long> = JsonMissing.of()
            private var returnedUsers: JsonField<Long> = JsonMissing.of()
            private var strategies: JsonField<MutableList<Strategy>>? = null
            private var uniqueUsers: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(diagnostic: Diagnostic) = apply {
                complete = diagnostic.complete
                cursorFailureCount = diagnostic.cursorFailureCount
                deadlineReached = diagnostic.deadlineReached
                duplicateCount = diagnostic.duplicateCount
                failedStrategyCount = diagnostic.failedStrategyCount
                malformedCount = diagnostic.malformedCount
                pagesFetched = diagnostic.pagesFetched
                responseTruncated = diagnostic.responseTruncated
                resultLimitReached = diagnostic.resultLimitReached
                stalledStrategyCount = diagnostic.stalledStrategyCount
                strategyCount = diagnostic.strategyCount
                returnedUsers = diagnostic.returnedUsers
                strategies = diagnostic.strategies.map { it.toMutableList() }
                uniqueUsers = diagnostic.uniqueUsers
                additionalProperties = diagnostic.additionalProperties.toMutableMap()
            }

            fun complete(complete: Boolean) = complete(JsonField.of(complete))

            /** Sets [Builder.complete] to an arbitrary JSON value. */
            fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

            fun cursorFailureCount(cursorFailureCount: Long) =
                cursorFailureCount(JsonField.of(cursorFailureCount))

            /** Sets [Builder.cursorFailureCount] to an arbitrary JSON value. */
            fun cursorFailureCount(cursorFailureCount: JsonField<Long>) = apply {
                this.cursorFailureCount = cursorFailureCount
            }

            fun deadlineReached(deadlineReached: Boolean) =
                deadlineReached(JsonField.of(deadlineReached))

            /** Sets [Builder.deadlineReached] to an arbitrary JSON value. */
            fun deadlineReached(deadlineReached: JsonField<Boolean>) = apply {
                this.deadlineReached = deadlineReached
            }

            fun duplicateCount(duplicateCount: Long) = duplicateCount(JsonField.of(duplicateCount))

            /** Sets [Builder.duplicateCount] to an arbitrary JSON value. */
            fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                this.duplicateCount = duplicateCount
            }

            fun failedStrategyCount(failedStrategyCount: Long) =
                failedStrategyCount(JsonField.of(failedStrategyCount))

            /** Sets [Builder.failedStrategyCount] to an arbitrary JSON value. */
            fun failedStrategyCount(failedStrategyCount: JsonField<Long>) = apply {
                this.failedStrategyCount = failedStrategyCount
            }

            fun malformedCount(malformedCount: Long) = malformedCount(JsonField.of(malformedCount))

            /** Sets [Builder.malformedCount] to an arbitrary JSON value. */
            fun malformedCount(malformedCount: JsonField<Long>) = apply {
                this.malformedCount = malformedCount
            }

            fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

            /** Sets [Builder.pagesFetched] to an arbitrary JSON value. */
            fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                this.pagesFetched = pagesFetched
            }

            fun responseTruncated(responseTruncated: Boolean) =
                responseTruncated(JsonField.of(responseTruncated))

            /** Sets [Builder.responseTruncated] to an arbitrary JSON value. */
            fun responseTruncated(responseTruncated: JsonField<Boolean>) = apply {
                this.responseTruncated = responseTruncated
            }

            fun resultLimitReached(resultLimitReached: Boolean) =
                resultLimitReached(JsonField.of(resultLimitReached))

            /** Sets [Builder.resultLimitReached] to an arbitrary JSON value. */
            fun resultLimitReached(resultLimitReached: JsonField<Boolean>) = apply {
                this.resultLimitReached = resultLimitReached
            }

            fun stalledStrategyCount(stalledStrategyCount: Long) =
                stalledStrategyCount(JsonField.of(stalledStrategyCount))

            /** Sets [Builder.stalledStrategyCount] to an arbitrary JSON value. */
            fun stalledStrategyCount(stalledStrategyCount: JsonField<Long>) = apply {
                this.stalledStrategyCount = stalledStrategyCount
            }

            fun strategyCount(strategyCount: Long) = strategyCount(JsonField.of(strategyCount))

            /** Sets [Builder.strategyCount] to an arbitrary JSON value. */
            fun strategyCount(strategyCount: JsonField<Long>) = apply {
                this.strategyCount = strategyCount
            }

            fun returnedUsers(returnedUsers: Long) = returnedUsers(JsonField.of(returnedUsers))

            /** Sets [Builder.returnedUsers] to an arbitrary JSON value. */
            fun returnedUsers(returnedUsers: JsonField<Long>) = apply {
                this.returnedUsers = returnedUsers
            }

            fun strategies(strategies: List<Strategy>) = strategies(JsonField.of(strategies))

            /** Sets [Builder.strategies] to an arbitrary JSON value. */
            fun strategies(strategies: JsonField<List<Strategy>>) = apply {
                this.strategies = strategies.map { it.toMutableList() }
            }

            /**
             * Adds a single [Strategy] to [strategies].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addStrategy(strategy: Strategy) = apply {
                this.strategies =
                    (this.strategies ?: JsonField.of(mutableListOf())).also {
                        checkKnown("strategies", it).add(strategy)
                    }
            }

            fun uniqueUsers(uniqueUsers: Long) = uniqueUsers(JsonField.of(uniqueUsers))

            /** Sets [Builder.uniqueUsers] to an arbitrary JSON value. */
            fun uniqueUsers(uniqueUsers: JsonField<Long>) = apply { this.uniqueUsers = uniqueUsers }

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
             * Returns an immutable instance of [Diagnostic].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Diagnostic =
                Diagnostic(
                    complete,
                    cursorFailureCount,
                    deadlineReached,
                    duplicateCount,
                    failedStrategyCount,
                    malformedCount,
                    pagesFetched,
                    responseTruncated,
                    resultLimitReached,
                    stalledStrategyCount,
                    strategyCount,
                    returnedUsers,
                    (strategies ?: JsonMissing.of()).map { it.toImmutable() },
                    uniqueUsers,
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
        fun validate(): Diagnostic = apply {
            if (validated) {
                return@apply
            }
            complete()
            cursorFailureCount()
            deadlineReached()
            duplicateCount()
            failedStrategyCount()
            malformedCount()
            pagesFetched()
            responseTruncated()
            resultLimitReached()
            stalledStrategyCount()
            strategyCount()
            returnedUsers()
            strategies().ifPresent { it.forEach { it.validate() } }
            uniqueUsers()
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
            (if (complete.asKnown().isPresent) 1 else 0) +
                (if (cursorFailureCount.asKnown().isPresent) 1 else 0) +
                (if (deadlineReached.asKnown().isPresent) 1 else 0) +
                (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                (if (failedStrategyCount.asKnown().isPresent) 1 else 0) +
                (if (malformedCount.asKnown().isPresent) 1 else 0) +
                (if (pagesFetched.asKnown().isPresent) 1 else 0) +
                (if (responseTruncated.asKnown().isPresent) 1 else 0) +
                (if (resultLimitReached.asKnown().isPresent) 1 else 0) +
                (if (stalledStrategyCount.asKnown().isPresent) 1 else 0) +
                (if (strategyCount.asKnown().isPresent) 1 else 0) +
                (if (returnedUsers.asKnown().isPresent) 1 else 0) +
                (strategies.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (uniqueUsers.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is Diagnostic &&
                complete == other.complete &&
                cursorFailureCount == other.cursorFailureCount &&
                deadlineReached == other.deadlineReached &&
                duplicateCount == other.duplicateCount &&
                failedStrategyCount == other.failedStrategyCount &&
                malformedCount == other.malformedCount &&
                pagesFetched == other.pagesFetched &&
                responseTruncated == other.responseTruncated &&
                resultLimitReached == other.resultLimitReached &&
                stalledStrategyCount == other.stalledStrategyCount &&
                strategyCount == other.strategyCount &&
                returnedUsers == other.returnedUsers &&
                strategies == other.strategies &&
                uniqueUsers == other.uniqueUsers &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                complete,
                cursorFailureCount,
                deadlineReached,
                duplicateCount,
                failedStrategyCount,
                malformedCount,
                pagesFetched,
                responseTruncated,
                resultLimitReached,
                stalledStrategyCount,
                strategyCount,
                returnedUsers,
                strategies,
                uniqueUsers,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Diagnostic{complete=$complete, cursorFailureCount=$cursorFailureCount, deadlineReached=$deadlineReached, duplicateCount=$duplicateCount, failedStrategyCount=$failedStrategyCount, malformedCount=$malformedCount, pagesFetched=$pagesFetched, responseTruncated=$responseTruncated, resultLimitReached=$resultLimitReached, stalledStrategyCount=$stalledStrategyCount, strategyCount=$strategyCount, returnedUsers=$returnedUsers, strategies=$strategies, uniqueUsers=$uniqueUsers, additionalProperties=$additionalProperties}"

        class Strategy
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val duplicateCount: JsonField<Long>,
            private val pagesFetched: JsonField<Long>,
            private val stopReason: JsonField<StopReason>,
            private val strategy: JsonField<Long>,
            private val uniqueAdded: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {
            @JsonCreator
            private constructor(
                @JsonProperty("duplicateCount")
                @ExcludeMissing
                duplicateCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("pagesFetched")
                @ExcludeMissing
                pagesFetched: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("stopReason")
                @ExcludeMissing
                stopReason: JsonField<StopReason> = JsonMissing.of(),
                @JsonProperty("strategy")
                @ExcludeMissing
                strategy: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("uniqueAdded")
                @ExcludeMissing
                uniqueAdded: JsonField<Long> = JsonMissing.of(),
            ) : this(
                duplicateCount,
                pagesFetched,
                stopReason,
                strategy,
                uniqueAdded,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun duplicateCount(): Optional<Long> = duplicateCount.getOptional("duplicateCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun pagesFetched(): Optional<Long> = pagesFetched.getOptional("pagesFetched")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun stopReason(): Optional<StopReason> = stopReason.getOptional("stopReason")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun strategy(): Optional<Long> = strategy.getOptional("strategy")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun uniqueAdded(): Optional<Long> = uniqueAdded.getOptional("uniqueAdded")

            /**
             * Returns the raw JSON value of [duplicateCount].
             *
             * Unlike [duplicateCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("duplicateCount")
            @ExcludeMissing
            fun _duplicateCount(): JsonField<Long> = duplicateCount

            /**
             * Returns the raw JSON value of [pagesFetched].
             *
             * Unlike [pagesFetched], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pagesFetched")
            @ExcludeMissing
            fun _pagesFetched(): JsonField<Long> = pagesFetched

            /**
             * Returns the raw JSON value of [stopReason].
             *
             * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("stopReason")
            @ExcludeMissing
            fun _stopReason(): JsonField<StopReason> = stopReason

            /**
             * Returns the raw JSON value of [strategy].
             *
             * Unlike [strategy], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("strategy") @ExcludeMissing fun _strategy(): JsonField<Long> = strategy

            /**
             * Returns the raw JSON value of [uniqueAdded].
             *
             * Unlike [uniqueAdded], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("uniqueAdded")
            @ExcludeMissing
            fun _uniqueAdded(): JsonField<Long> = uniqueAdded

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
                /** Returns a mutable builder for constructing an instance of [Strategy]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Strategy]. */
            class Builder internal constructor() {
                private var duplicateCount: JsonField<Long> = JsonMissing.of()
                private var pagesFetched: JsonField<Long> = JsonMissing.of()
                private var stopReason: JsonField<StopReason> = JsonMissing.of()
                private var strategy: JsonField<Long> = JsonMissing.of()
                private var uniqueAdded: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(strategie: Strategy) = apply {
                    duplicateCount = strategie.duplicateCount
                    pagesFetched = strategie.pagesFetched
                    stopReason = strategie.stopReason
                    strategy = strategie.strategy
                    uniqueAdded = strategie.uniqueAdded
                    additionalProperties = strategie.additionalProperties.toMutableMap()
                }

                fun duplicateCount(duplicateCount: Long) =
                    duplicateCount(JsonField.of(duplicateCount))

                /** Sets [Builder.duplicateCount] to an arbitrary JSON value. */
                fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                    this.duplicateCount = duplicateCount
                }

                fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

                /** Sets [Builder.pagesFetched] to an arbitrary JSON value. */
                fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                    this.pagesFetched = pagesFetched
                }

                fun stopReason(stopReason: StopReason) = stopReason(JsonField.of(stopReason))

                /** Sets [Builder.stopReason] to an arbitrary JSON value. */
                fun stopReason(stopReason: JsonField<StopReason>) = apply {
                    this.stopReason = stopReason
                }

                fun strategy(strategy: Long) = strategy(JsonField.of(strategy))

                /** Sets [Builder.strategy] to an arbitrary JSON value. */
                fun strategy(strategy: JsonField<Long>) = apply { this.strategy = strategy }

                fun uniqueAdded(uniqueAdded: Long) = uniqueAdded(JsonField.of(uniqueAdded))

                /** Sets [Builder.uniqueAdded] to an arbitrary JSON value. */
                fun uniqueAdded(uniqueAdded: JsonField<Long>) = apply {
                    this.uniqueAdded = uniqueAdded
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
                 * Returns an immutable instance of [Strategy].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Strategy =
                    Strategy(
                        duplicateCount,
                        pagesFetched,
                        stopReason,
                        strategy,
                        uniqueAdded,
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
            fun validate(): Strategy = apply {
                if (validated) {
                    return@apply
                }
                duplicateCount()
                pagesFetched()
                stopReason().ifPresent { it.validate() }
                strategy()
                uniqueAdded()
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
                (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                    (if (pagesFetched.asKnown().isPresent) 1 else 0) +
                    (stopReason.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (strategy.asKnown().isPresent) 1 else 0) +
                    (if (uniqueAdded.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }
                return other is Strategy &&
                    duplicateCount == other.duplicateCount &&
                    pagesFetched == other.pagesFetched &&
                    stopReason == other.stopReason &&
                    strategy == other.strategy &&
                    uniqueAdded == other.uniqueAdded &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    duplicateCount,
                    pagesFetched,
                    stopReason,
                    strategy,
                    uniqueAdded,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Strategy{duplicateCount=$duplicateCount, pagesFetched=$pagesFetched, stopReason=$stopReason, strategy=$strategy, uniqueAdded=$uniqueAdded, additionalProperties=$additionalProperties}"

            class StopReason
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val CURSOR_FAILURE = of("cursor_failure")

                    @JvmField val DEADLINE = of("deadline")

                    @JvmField val EXHAUSTED = of("exhausted")

                    @JvmField val FAILED = of("failed")

                    @JvmField val PAGE_LIMIT = of("page_limit")

                    @JvmField val RESULT_LIMIT = of("result_limit")

                    @JvmField val STALLED = of("stalled")

                    @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
                }

                /** An enum containing [StopReason]'s known values. */
                enum class Known {
                    CURSOR_FAILURE,
                    DEADLINE,
                    EXHAUSTED,
                    FAILED,
                    PAGE_LIMIT,
                    RESULT_LIMIT,
                    STALLED,
                }

                /**
                 * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [StopReason] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CURSOR_FAILURE,
                    DEADLINE,
                    EXHAUSTED,
                    FAILED,
                    PAGE_LIMIT,
                    RESULT_LIMIT,
                    STALLED,
                    /**
                     * An enum member indicating that [StopReason] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        CURSOR_FAILURE -> Value.CURSOR_FAILURE
                        DEADLINE -> Value.DEADLINE
                        EXHAUSTED -> Value.EXHAUSTED
                        FAILED -> Value.FAILED
                        PAGE_LIMIT -> Value.PAGE_LIMIT
                        RESULT_LIMIT -> Value.RESULT_LIMIT
                        STALLED -> Value.STALLED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        CURSOR_FAILURE -> Known.CURSOR_FAILURE
                        DEADLINE -> Known.DEADLINE
                        EXHAUSTED -> Known.EXHAUSTED
                        FAILED -> Known.FAILED
                        PAGE_LIMIT -> Known.PAGE_LIMIT
                        RESULT_LIMIT -> Known.RESULT_LIMIT
                        STALLED -> Known.STALLED
                        else ->
                            throw XTwitterScraperInvalidDataException("Unknown StopReason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
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
                fun validate(): StopReason = apply {
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

                    return other is StopReason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }
        }
    }
}
