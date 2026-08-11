// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

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
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.UserProfile
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
@JsonDeserialize(using = UserRetrieveVerifiedFollowersResponse.Deserializer::class)
@JsonSerialize(using = UserRetrieveVerifiedFollowersResponse.Serializer::class)
class UserRetrieveVerifiedFollowersResponse
private constructor(
    private val paginatedUsers: PaginatedUsers? = null,
    private val listCoverage: UserListCoverageResponse? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Paginated user profiles. No-mode follower, following, and verified follower requests merge
     * independent views automatically. Response fields, page size, aliases, filters, and
     * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
     * behavior. Follow next_cursor while has_next_page is true.
     */
    fun paginatedUsers(): Optional<PaginatedUsers> = Optional.ofNullable(paginatedUsers)

    /**
     * Paginated user profiles. No-mode follower, following, and verified follower requests merge
     * independent views automatically. Response fields, page size, aliases, filters, and
     * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
     * behavior. Follow next_cursor while has_next_page is true.
     */
    fun listCoverage(): Optional<UserListCoverageResponse> = Optional.ofNullable(listCoverage)

    fun isPaginatedUsers(): Boolean = paginatedUsers != null

    fun isListCoverage(): Boolean = listCoverage != null

    /**
     * Paginated user profiles. No-mode follower, following, and verified follower requests merge
     * independent views automatically. Response fields, page size, aliases, filters, and
     * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
     * behavior. Follow next_cursor while has_next_page is true.
     */
    fun asPaginatedUsers(): PaginatedUsers = paginatedUsers.getOrThrow("paginatedUsers")

    /**
     * Paginated user profiles. No-mode follower, following, and verified follower requests merge
     * independent views automatically. Response fields, page size, aliases, filters, and
     * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
     * behavior. Follow next_cursor while has_next_page is true.
     */
    fun asListCoverage(): UserListCoverageResponse = listCoverage.getOrThrow("listCoverage")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.x_twitter_scraper.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = userRetrieveVerifiedFollowersResponse.accept(new UserRetrieveVerifiedFollowersResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitPaginatedUsers(PaginatedUsers paginatedUsers) {
     *         return Optional.of(paginatedUsers.toString());
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
            paginatedUsers != null -> visitor.visitPaginatedUsers(paginatedUsers)
            listCoverage != null -> visitor.visitListCoverage(listCoverage)
            else -> visitor.unknown(_json)
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
    fun validate(): UserRetrieveVerifiedFollowersResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPaginatedUsers(paginatedUsers: PaginatedUsers) {
                    paginatedUsers.validate()
                }

                override fun visitListCoverage(listCoverage: UserListCoverageResponse) {
                    listCoverage.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitPaginatedUsers(paginatedUsers: PaginatedUsers) =
                    paginatedUsers.validity()

                override fun visitListCoverage(listCoverage: UserListCoverageResponse) =
                    listCoverage.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveVerifiedFollowersResponse &&
            paginatedUsers == other.paginatedUsers &&
            listCoverage == other.listCoverage
    }

    override fun hashCode(): Int = Objects.hash(paginatedUsers, listCoverage)

    override fun toString(): String =
        when {
            paginatedUsers != null ->
                "UserRetrieveVerifiedFollowersResponse{paginatedUsers=$paginatedUsers}"
            listCoverage != null ->
                "UserRetrieveVerifiedFollowersResponse{listCoverage=$listCoverage}"
            _json != null -> "UserRetrieveVerifiedFollowersResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UserRetrieveVerifiedFollowersResponse")
        }

    companion object {

        /**
         * Paginated user profiles. No-mode follower, following, and verified follower requests
         * merge independent views automatically. Response fields, page size, aliases, filters, and
         * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
         * behavior. Follow next_cursor while has_next_page is true.
         */
        @JvmStatic
        fun ofPaginatedUsers(paginatedUsers: PaginatedUsers) =
            UserRetrieveVerifiedFollowersResponse(paginatedUsers = paginatedUsers)

        /**
         * Paginated user profiles. No-mode follower, following, and verified follower requests
         * merge independent views automatically. Response fields, page size, aliases, filters, and
         * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
         * behavior. Follow next_cursor while has_next_page is true.
         */
        @JvmStatic
        fun ofListCoverage(listCoverage: UserListCoverageResponse) =
            UserRetrieveVerifiedFollowersResponse(listCoverage = listCoverage)
    }

    /**
     * An interface that defines how to map each variant of [UserRetrieveVerifiedFollowersResponse]
     * to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Paginated user profiles. No-mode follower, following, and verified follower requests
         * merge independent views automatically. Response fields, page size, aliases, filters, and
         * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
         * behavior. Follow next_cursor while has_next_page is true.
         */
        fun visitPaginatedUsers(paginatedUsers: PaginatedUsers): T

        /**
         * Paginated user profiles. No-mode follower, following, and verified follower requests
         * merge independent views automatically. Response fields, page size, aliases, filters, and
         * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
         * behavior. Follow next_cursor while has_next_page is true.
         */
        fun visitListCoverage(listCoverage: UserListCoverageResponse): T

        /**
         * Maps an unknown variant of [UserRetrieveVerifiedFollowersResponse] to a value of type
         * [T].
         *
         * An instance of [UserRetrieveVerifiedFollowersResponse] can contain an unknown variant if
         * it was deserialized from data that doesn't match any known variant. For example, if the
         * SDK is on an older version than the API, then the API may respond with new variants that
         * the SDK is unaware of.
         *
         * @throws XTwitterScraperInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw XTwitterScraperInvalidDataException(
                "Unknown UserRetrieveVerifiedFollowersResponse: $json"
            )
        }
    }

    internal class Deserializer :
        BaseDeserializer<UserRetrieveVerifiedFollowersResponse>(
            UserRetrieveVerifiedFollowersResponse::class
        ) {

        override fun ObjectCodec.deserialize(
            node: JsonNode
        ): UserRetrieveVerifiedFollowersResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<PaginatedUsers>())?.let {
                            UserRetrieveVerifiedFollowersResponse(paginatedUsers = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UserListCoverageResponse>())?.let {
                            UserRetrieveVerifiedFollowersResponse(listCoverage = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> UserRetrieveVerifiedFollowersResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<UserRetrieveVerifiedFollowersResponse>(
            UserRetrieveVerifiedFollowersResponse::class
        ) {

        override fun serialize(
            value: UserRetrieveVerifiedFollowersResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.paginatedUsers != null -> generator.writeObject(value.paginatedUsers)
                value.listCoverage != null -> generator.writeObject(value.listCoverage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UserRetrieveVerifiedFollowersResponse")
            }
        }
    }

    /**
     * Paginated user profiles. No-mode follower, following, and verified follower requests merge
     * independent views automatically. Response fields, page size, aliases, filters, and
     * per-returned-profile billing stay unchanged. Existing unprefixed cursors retain legacy
     * behavior. Follow next_cursor while has_next_page is true.
     */
    class UserListCoverageResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hasNextPage: JsonField<Boolean>,
        private val nextCursor: JsonField<String>,
        private val users: JsonField<List<UserProfile>>,
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
            @JsonProperty("diagnostic")
            @ExcludeMissing
            diagnostic: JsonField<Diagnostic> = JsonMissing.of(),
        ) : this(hasNextPage, nextCursor, users, diagnostic, mutableMapOf())

        fun toPaginatedUsers(): PaginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(hasNextPage)
                .nextCursor(nextCursor)
                .users(users)
                .build()

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nextCursor(): String = nextCursor.getRequired("next_cursor")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun users(): List<UserProfile> = users.getRequired("users")

        /**
         * Coverage evidence across parallel relationship strategies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun diagnostic(): Diagnostic = diagnostic.getRequired("diagnostic")

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
        @JsonProperty("next_cursor")
        @ExcludeMissing
        fun _nextCursor(): JsonField<String> = nextCursor

        /**
         * Returns the raw JSON value of [users].
         *
         * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<UserProfile>> = users

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
             * Returns a mutable builder for constructing an instance of [UserListCoverageResponse].
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .nextCursor()
             * .users()
             * .diagnostic()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UserListCoverageResponse]. */
        class Builder internal constructor() {

            private var hasNextPage: JsonField<Boolean>? = null
            private var nextCursor: JsonField<String>? = null
            private var users: JsonField<MutableList<UserProfile>>? = null
            private var diagnostic: JsonField<Diagnostic>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(userListCoverageResponse: UserListCoverageResponse) = apply {
                hasNextPage = userListCoverageResponse.hasNextPage
                nextCursor = userListCoverageResponse.nextCursor
                users = userListCoverageResponse.users.map { it.toMutableList() }
                diagnostic = userListCoverageResponse.diagnostic
                additionalProperties = userListCoverageResponse.additionalProperties.toMutableMap()
            }

            fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

            /**
             * Sets [Builder.hasNextPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply {
                this.hasNextPage = hasNextPage
            }

            fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

            /**
             * Sets [Builder.nextCursor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nextCursor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

            fun users(users: List<UserProfile>) = users(JsonField.of(users))

            /**
             * Sets [Builder.users] to an arbitrary JSON value.
             *
             * You should usually call [Builder.users] with a well-typed `List<UserProfile>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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
                    (users ?: JsonField.of(mutableListOf())).also {
                        checkKnown("users", it).add(user)
                    }
            }

            /** Coverage evidence across parallel relationship strategies. */
            fun diagnostic(diagnostic: Diagnostic) = diagnostic(JsonField.of(diagnostic))

            /**
             * Sets [Builder.diagnostic] to an arbitrary JSON value.
             *
             * You should usually call [Builder.diagnostic] with a well-typed [Diagnostic] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun diagnostic(diagnostic: JsonField<Diagnostic>) = apply {
                this.diagnostic = diagnostic
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
             * Returns an immutable instance of [UserListCoverageResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .nextCursor()
             * .users()
             * .diagnostic()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UserListCoverageResponse =
                UserListCoverageResponse(
                    checkRequired("hasNextPage", hasNextPage),
                    checkRequired("nextCursor", nextCursor),
                    checkRequired("users", users).map { it.toImmutable() },
                    checkRequired("diagnostic", diagnostic),
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
        fun validate(): UserListCoverageResponse = apply {
            if (validated) {
                return@apply
            }

            hasNextPage()
            nextCursor()
            users().forEach { it.validate() }
            diagnostic().validate()
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
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
                (if (nextCursor.asKnown().isPresent) 1 else 0) +
                (users.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (diagnostic.asKnown().getOrNull()?.validity() ?: 0)

        /** Coverage evidence across parallel relationship strategies. */
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
            private val returnedUsers: JsonField<Long>,
            private val stalledStrategyCount: JsonField<Long>,
            private val strategies: JsonField<List<Strategy>>,
            private val strategyCount: JsonField<Long>,
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
                @JsonProperty("returnedUsers")
                @ExcludeMissing
                returnedUsers: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("stalledStrategyCount")
                @ExcludeMissing
                stalledStrategyCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("strategies")
                @ExcludeMissing
                strategies: JsonField<List<Strategy>> = JsonMissing.of(),
                @JsonProperty("strategyCount")
                @ExcludeMissing
                strategyCount: JsonField<Long> = JsonMissing.of(),
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
                returnedUsers,
                stalledStrategyCount,
                strategies,
                strategyCount,
                uniqueUsers,
                mutableMapOf(),
            )

            /**
             * True when every strategy exhausted its source.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun complete(): Boolean = complete.getRequired("complete")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cursorFailureCount(): Long = cursorFailureCount.getRequired("cursorFailureCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun deadlineReached(): Boolean = deadlineReached.getRequired("deadlineReached")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun duplicateCount(): Long = duplicateCount.getRequired("duplicateCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun failedStrategyCount(): Long = failedStrategyCount.getRequired("failedStrategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun malformedCount(): Long = malformedCount.getRequired("malformedCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pagesFetched(): Long = pagesFetched.getRequired("pagesFetched")

            /**
             * Whether credits or the requested limit reduced output.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun responseTruncated(): Boolean = responseTruncated.getRequired("responseTruncated")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun resultLimitReached(): Boolean = resultLimitReached.getRequired("resultLimitReached")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun returnedUsers(): Long = returnedUsers.getRequired("returnedUsers")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun stalledStrategyCount(): Long =
                stalledStrategyCount.getRequired("stalledStrategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun strategies(): List<Strategy> = strategies.getRequired("strategies")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun strategyCount(): Long = strategyCount.getRequired("strategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun uniqueUsers(): Long = uniqueUsers.getRequired("uniqueUsers")

            /**
             * Returns the raw JSON value of [complete].
             *
             * Unlike [complete], this method doesn't throw if the JSON field has an unexpected
             * type.
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
             * Unlike [deadlineReached], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("deadlineReached")
            @ExcludeMissing
            fun _deadlineReached(): JsonField<Boolean> = deadlineReached

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
             * Unlike [malformedCount], this method doesn't throw if the JSON field has an
             * unexpected type.
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
             * Unlike [responseTruncated], this method doesn't throw if the JSON field has an
             * unexpected type.
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
             * Returns the raw JSON value of [returnedUsers].
             *
             * Unlike [returnedUsers], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("returnedUsers")
            @ExcludeMissing
            fun _returnedUsers(): JsonField<Long> = returnedUsers

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
             * Returns the raw JSON value of [strategies].
             *
             * Unlike [strategies], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("strategies")
            @ExcludeMissing
            fun _strategies(): JsonField<List<Strategy>> = strategies

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
             * Returns the raw JSON value of [uniqueUsers].
             *
             * Unlike [uniqueUsers], this method doesn't throw if the JSON field has an unexpected
             * type.
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

                /**
                 * Returns a mutable builder for constructing an instance of [Diagnostic].
                 *
                 * The following fields are required:
                 * ```java
                 * .complete()
                 * .cursorFailureCount()
                 * .deadlineReached()
                 * .duplicateCount()
                 * .failedStrategyCount()
                 * .malformedCount()
                 * .pagesFetched()
                 * .responseTruncated()
                 * .resultLimitReached()
                 * .returnedUsers()
                 * .stalledStrategyCount()
                 * .strategies()
                 * .strategyCount()
                 * .uniqueUsers()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Diagnostic]. */
            class Builder internal constructor() {

                private var complete: JsonField<Boolean>? = null
                private var cursorFailureCount: JsonField<Long>? = null
                private var deadlineReached: JsonField<Boolean>? = null
                private var duplicateCount: JsonField<Long>? = null
                private var failedStrategyCount: JsonField<Long>? = null
                private var malformedCount: JsonField<Long>? = null
                private var pagesFetched: JsonField<Long>? = null
                private var responseTruncated: JsonField<Boolean>? = null
                private var resultLimitReached: JsonField<Boolean>? = null
                private var returnedUsers: JsonField<Long>? = null
                private var stalledStrategyCount: JsonField<Long>? = null
                private var strategies: JsonField<MutableList<Strategy>>? = null
                private var strategyCount: JsonField<Long>? = null
                private var uniqueUsers: JsonField<Long>? = null
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
                    returnedUsers = diagnostic.returnedUsers
                    stalledStrategyCount = diagnostic.stalledStrategyCount
                    strategies = diagnostic.strategies.map { it.toMutableList() }
                    strategyCount = diagnostic.strategyCount
                    uniqueUsers = diagnostic.uniqueUsers
                    additionalProperties = diagnostic.additionalProperties.toMutableMap()
                }

                /** True when every strategy exhausted its source. */
                fun complete(complete: Boolean) = complete(JsonField.of(complete))

                /**
                 * Sets [Builder.complete] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complete] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

                fun cursorFailureCount(cursorFailureCount: Long) =
                    cursorFailureCount(JsonField.of(cursorFailureCount))

                /**
                 * Sets [Builder.cursorFailureCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cursorFailureCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun cursorFailureCount(cursorFailureCount: JsonField<Long>) = apply {
                    this.cursorFailureCount = cursorFailureCount
                }

                fun deadlineReached(deadlineReached: Boolean) =
                    deadlineReached(JsonField.of(deadlineReached))

                /**
                 * Sets [Builder.deadlineReached] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deadlineReached] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun deadlineReached(deadlineReached: JsonField<Boolean>) = apply {
                    this.deadlineReached = deadlineReached
                }

                fun duplicateCount(duplicateCount: Long) =
                    duplicateCount(JsonField.of(duplicateCount))

                /**
                 * Sets [Builder.duplicateCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.duplicateCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                    this.duplicateCount = duplicateCount
                }

                fun failedStrategyCount(failedStrategyCount: Long) =
                    failedStrategyCount(JsonField.of(failedStrategyCount))

                /**
                 * Sets [Builder.failedStrategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.failedStrategyCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun failedStrategyCount(failedStrategyCount: JsonField<Long>) = apply {
                    this.failedStrategyCount = failedStrategyCount
                }

                fun malformedCount(malformedCount: Long) =
                    malformedCount(JsonField.of(malformedCount))

                /**
                 * Sets [Builder.malformedCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.malformedCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun malformedCount(malformedCount: JsonField<Long>) = apply {
                    this.malformedCount = malformedCount
                }

                fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

                /**
                 * Sets [Builder.pagesFetched] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pagesFetched] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                    this.pagesFetched = pagesFetched
                }

                /** Whether credits or the requested limit reduced output. */
                fun responseTruncated(responseTruncated: Boolean) =
                    responseTruncated(JsonField.of(responseTruncated))

                /**
                 * Sets [Builder.responseTruncated] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responseTruncated] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun responseTruncated(responseTruncated: JsonField<Boolean>) = apply {
                    this.responseTruncated = responseTruncated
                }

                fun resultLimitReached(resultLimitReached: Boolean) =
                    resultLimitReached(JsonField.of(resultLimitReached))

                /**
                 * Sets [Builder.resultLimitReached] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resultLimitReached] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun resultLimitReached(resultLimitReached: JsonField<Boolean>) = apply {
                    this.resultLimitReached = resultLimitReached
                }

                fun returnedUsers(returnedUsers: Long) = returnedUsers(JsonField.of(returnedUsers))

                /**
                 * Sets [Builder.returnedUsers] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.returnedUsers] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun returnedUsers(returnedUsers: JsonField<Long>) = apply {
                    this.returnedUsers = returnedUsers
                }

                fun stalledStrategyCount(stalledStrategyCount: Long) =
                    stalledStrategyCount(JsonField.of(stalledStrategyCount))

                /**
                 * Sets [Builder.stalledStrategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.stalledStrategyCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun stalledStrategyCount(stalledStrategyCount: JsonField<Long>) = apply {
                    this.stalledStrategyCount = stalledStrategyCount
                }

                fun strategies(strategies: List<Strategy>) = strategies(JsonField.of(strategies))

                /**
                 * Sets [Builder.strategies] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.strategies] with a well-typed `List<Strategy>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun strategies(strategies: JsonField<List<Strategy>>) = apply {
                    this.strategies = strategies.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Strategy] to [strategies].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addStrategy(strategy: Strategy) = apply {
                    strategies =
                        (strategies ?: JsonField.of(mutableListOf())).also {
                            checkKnown("strategies", it).add(strategy)
                        }
                }

                fun strategyCount(strategyCount: Long) = strategyCount(JsonField.of(strategyCount))

                /**
                 * Sets [Builder.strategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.strategyCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun strategyCount(strategyCount: JsonField<Long>) = apply {
                    this.strategyCount = strategyCount
                }

                fun uniqueUsers(uniqueUsers: Long) = uniqueUsers(JsonField.of(uniqueUsers))

                /**
                 * Sets [Builder.uniqueUsers] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.uniqueUsers] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun uniqueUsers(uniqueUsers: JsonField<Long>) = apply {
                    this.uniqueUsers = uniqueUsers
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
                 * Returns an immutable instance of [Diagnostic].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .complete()
                 * .cursorFailureCount()
                 * .deadlineReached()
                 * .duplicateCount()
                 * .failedStrategyCount()
                 * .malformedCount()
                 * .pagesFetched()
                 * .responseTruncated()
                 * .resultLimitReached()
                 * .returnedUsers()
                 * .stalledStrategyCount()
                 * .strategies()
                 * .strategyCount()
                 * .uniqueUsers()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Diagnostic =
                    Diagnostic(
                        checkRequired("complete", complete),
                        checkRequired("cursorFailureCount", cursorFailureCount),
                        checkRequired("deadlineReached", deadlineReached),
                        checkRequired("duplicateCount", duplicateCount),
                        checkRequired("failedStrategyCount", failedStrategyCount),
                        checkRequired("malformedCount", malformedCount),
                        checkRequired("pagesFetched", pagesFetched),
                        checkRequired("responseTruncated", responseTruncated),
                        checkRequired("resultLimitReached", resultLimitReached),
                        checkRequired("returnedUsers", returnedUsers),
                        checkRequired("stalledStrategyCount", stalledStrategyCount),
                        checkRequired("strategies", strategies).map { it.toImmutable() },
                        checkRequired("strategyCount", strategyCount),
                        checkRequired("uniqueUsers", uniqueUsers),
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
                returnedUsers()
                stalledStrategyCount()
                strategies().forEach { it.validate() }
                strategyCount()
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

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
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
                    (if (returnedUsers.asKnown().isPresent) 1 else 0) +
                    (if (stalledStrategyCount.asKnown().isPresent) 1 else 0) +
                    (strategies.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (strategyCount.asKnown().isPresent) 1 else 0) +
                    (if (uniqueUsers.asKnown().isPresent) 1 else 0)

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
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun duplicateCount(): Long = duplicateCount.getRequired("duplicateCount")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun pagesFetched(): Long = pagesFetched.getRequired("pagesFetched")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun stopReason(): StopReason = stopReason.getRequired("stopReason")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun strategy(): Long = strategy.getRequired("strategy")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun uniqueAdded(): Long = uniqueAdded.getRequired("uniqueAdded")

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
                 * Unlike [pagesFetched], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("pagesFetched")
                @ExcludeMissing
                fun _pagesFetched(): JsonField<Long> = pagesFetched

                /**
                 * Returns the raw JSON value of [stopReason].
                 *
                 * Unlike [stopReason], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                @JsonProperty("strategy")
                @ExcludeMissing
                fun _strategy(): JsonField<Long> = strategy

                /**
                 * Returns the raw JSON value of [uniqueAdded].
                 *
                 * Unlike [uniqueAdded], this method doesn't throw if the JSON field has an
                 * unexpected type.
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

                    /**
                     * Returns a mutable builder for constructing an instance of [Strategy].
                     *
                     * The following fields are required:
                     * ```java
                     * .duplicateCount()
                     * .pagesFetched()
                     * .stopReason()
                     * .strategy()
                     * .uniqueAdded()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Strategy]. */
                class Builder internal constructor() {

                    private var duplicateCount: JsonField<Long>? = null
                    private var pagesFetched: JsonField<Long>? = null
                    private var stopReason: JsonField<StopReason>? = null
                    private var strategy: JsonField<Long>? = null
                    private var uniqueAdded: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(strategy: Strategy) = apply {
                        duplicateCount = strategy.duplicateCount
                        pagesFetched = strategy.pagesFetched
                        stopReason = strategy.stopReason
                        this.strategy = strategy.strategy
                        uniqueAdded = strategy.uniqueAdded
                        additionalProperties = strategy.additionalProperties.toMutableMap()
                    }

                    fun duplicateCount(duplicateCount: Long) =
                        duplicateCount(JsonField.of(duplicateCount))

                    /**
                     * Sets [Builder.duplicateCount] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.duplicateCount] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                        this.duplicateCount = duplicateCount
                    }

                    fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

                    /**
                     * Sets [Builder.pagesFetched] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.pagesFetched] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                        this.pagesFetched = pagesFetched
                    }

                    fun stopReason(stopReason: StopReason) = stopReason(JsonField.of(stopReason))

                    /**
                     * Sets [Builder.stopReason] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.stopReason] with a well-typed [StopReason]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun stopReason(stopReason: JsonField<StopReason>) = apply {
                        this.stopReason = stopReason
                    }

                    fun strategy(strategy: Long) = strategy(JsonField.of(strategy))

                    /**
                     * Sets [Builder.strategy] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.strategy] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun strategy(strategy: JsonField<Long>) = apply { this.strategy = strategy }

                    fun uniqueAdded(uniqueAdded: Long) = uniqueAdded(JsonField.of(uniqueAdded))

                    /**
                     * Sets [Builder.uniqueAdded] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.uniqueAdded] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
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
                     *
                     * The following fields are required:
                     * ```java
                     * .duplicateCount()
                     * .pagesFetched()
                     * .stopReason()
                     * .strategy()
                     * .uniqueAdded()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Strategy =
                        Strategy(
                            checkRequired("duplicateCount", duplicateCount),
                            checkRequired("pagesFetched", pagesFetched),
                            checkRequired("stopReason", stopReason),
                            checkRequired("strategy", strategy),
                            checkRequired("uniqueAdded", uniqueAdded),
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Strategy = apply {
                    if (validated) {
                        return@apply
                    }

                    duplicateCount()
                    pagesFetched()
                    stopReason().validate()
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

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                        (if (pagesFetched.asKnown().isPresent) 1 else 0) +
                        (stopReason.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (strategy.asKnown().isPresent) 1 else 0) +
                        (if (uniqueAdded.asKnown().isPresent) 1 else 0)

                class StopReason
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

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
                     * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [StopReason] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
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
                         * An enum member indicating that [StopReason] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
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
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
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
                                throw XTwitterScraperInvalidDataException(
                                    "Unknown StopReason: $value"
                                )
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            XTwitterScraperInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
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

                    /**
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is StopReason && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

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
            }

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
                    returnedUsers == other.returnedUsers &&
                    stalledStrategyCount == other.stalledStrategyCount &&
                    strategies == other.strategies &&
                    strategyCount == other.strategyCount &&
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
                    returnedUsers,
                    stalledStrategyCount,
                    strategies,
                    strategyCount,
                    uniqueUsers,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Diagnostic{complete=$complete, cursorFailureCount=$cursorFailureCount, deadlineReached=$deadlineReached, duplicateCount=$duplicateCount, failedStrategyCount=$failedStrategyCount, malformedCount=$malformedCount, pagesFetched=$pagesFetched, responseTruncated=$responseTruncated, resultLimitReached=$resultLimitReached, returnedUsers=$returnedUsers, stalledStrategyCount=$stalledStrategyCount, strategies=$strategies, strategyCount=$strategyCount, uniqueUsers=$uniqueUsers, additionalProperties=$additionalProperties}"
        }

        class HasNextPage @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

            companion object {

                @JvmField val FALSE = of(false)

                @JvmStatic fun of(value: Boolean) = HasNextPage(JsonField.of(value))
            }

            /** An enum containing [HasNextPage]'s known values. */
            enum class Known {
                FALSE
            }

            /**
             * An enum containing [HasNextPage]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [HasNextPage] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FALSE,
                /**
                 * An enum member indicating that [HasNextPage] was instantiated with an unknown
                 * value.
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
                    FALSE -> Value.FALSE
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
                    FALSE -> Known.FALSE
                    else -> throw XTwitterScraperInvalidDataException("Unknown HasNextPage: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a Boolean")
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
            fun validate(): HasNextPage = apply {
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

                return other is HasNextPage && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class NextCursor @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val EMPTY = of("")

                @JvmStatic fun of(value: String) = NextCursor(JsonField.of(value))
            }

            /** An enum containing [NextCursor]'s known values. */
            enum class Known {
                EMPTY
            }

            /**
             * An enum containing [NextCursor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [NextCursor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                EMPTY,
                /**
                 * An enum member indicating that [NextCursor] was instantiated with an unknown
                 * value.
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
                    EMPTY -> Value.EMPTY
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
                    EMPTY -> Known.EMPTY
                    else -> throw XTwitterScraperInvalidDataException("Unknown NextCursor: $value")
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
            fun validate(): NextCursor = apply {
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

                return other is NextCursor && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UserListCoverageResponse &&
                hasNextPage == other.hasNextPage &&
                nextCursor == other.nextCursor &&
                users == other.users &&
                diagnostic == other.diagnostic &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hasNextPage, nextCursor, users, diagnostic, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserListCoverageResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, users=$users, diagnostic=$diagnostic, additionalProperties=$additionalProperties}"
    }
}
