// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ExtractionListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val extractions: JsonField<List<Extraction>>,
    private val hasMore: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("extractions")
        @ExcludeMissing
        extractions: JsonField<List<Extraction>> = JsonMissing.of(),
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextCursor") @ExcludeMissing nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(extractions, hasMore, nextCursor, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun extractions(): List<Extraction> = extractions.getRequired("extractions")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("hasMore")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [extractions].
     *
     * Unlike [extractions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("extractions")
    @ExcludeMissing
    fun _extractions(): JsonField<List<Extraction>> = extractions

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasMore") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextCursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

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
         * Returns a mutable builder for constructing an instance of [ExtractionListResponse].
         *
         * The following fields are required:
         * ```java
         * .extractions()
         * .hasMore()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionListResponse]. */
    class Builder internal constructor() {

        private var extractions: JsonField<MutableList<Extraction>>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionListResponse: ExtractionListResponse) = apply {
            extractions = extractionListResponse.extractions.map { it.toMutableList() }
            hasMore = extractionListResponse.hasMore
            nextCursor = extractionListResponse.nextCursor
            additionalProperties = extractionListResponse.additionalProperties.toMutableMap()
        }

        fun extractions(extractions: List<Extraction>) = extractions(JsonField.of(extractions))

        /**
         * Sets [Builder.extractions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.extractions] with a well-typed `List<Extraction>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun extractions(extractions: JsonField<List<Extraction>>) = apply {
            this.extractions = extractions.map { it.toMutableList() }
        }

        /**
         * Adds a single [Extraction] to [extractions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExtraction(extraction: Extraction) = apply {
            extractions =
                (extractions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("extractions", it).add(extraction)
                }
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

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
         * Returns an immutable instance of [ExtractionListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .extractions()
         * .hasMore()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionListResponse =
            ExtractionListResponse(
                checkRequired("extractions", extractions).map { it.toImmutable() },
                checkRequired("hasMore", hasMore),
                nextCursor,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExtractionListResponse = apply {
        if (validated) {
            return@apply
        }

        extractions().forEach { it.validate() }
        hasMore()
        nextCursor()
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
        (extractions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    /** Extraction job tracking status, tool type, and result count. */
    class Extraction
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val toolType: JsonField<ToolType>,
        private val totalResults: JsonField<Long>,
        private val completedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("toolType")
            @ExcludeMissing
            toolType: JsonField<ToolType> = JsonMissing.of(),
            @JsonProperty("totalResults")
            @ExcludeMissing
            totalResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("completedAt")
            @ExcludeMissing
            completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(id, createdAt, status, toolType, totalResults, completedAt, mutableMapOf())

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Identifier for the extraction tool used to run a job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun toolType(): ToolType = toolType.getRequired("toolType")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun totalResults(): Long = totalResults.getRequired("totalResults")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [toolType].
         *
         * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toolType") @ExcludeMissing fun _toolType(): JsonField<ToolType> = toolType

        /**
         * Returns the raw JSON value of [totalResults].
         *
         * Unlike [totalResults], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalResults")
        @ExcludeMissing
        fun _totalResults(): JsonField<Long> = totalResults

        /**
         * Returns the raw JSON value of [completedAt].
         *
         * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("completedAt")
        @ExcludeMissing
        fun _completedAt(): JsonField<OffsetDateTime> = completedAt

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
             * Returns a mutable builder for constructing an instance of [Extraction].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .status()
             * .toolType()
             * .totalResults()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Extraction]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var toolType: JsonField<ToolType>? = null
            private var totalResults: JsonField<Long>? = null
            private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(extraction: Extraction) = apply {
                id = extraction.id
                createdAt = extraction.createdAt
                status = extraction.status
                toolType = extraction.toolType
                totalResults = extraction.totalResults
                completedAt = extraction.completedAt
                additionalProperties = extraction.additionalProperties.toMutableMap()
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

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            /** Identifier for the extraction tool used to run a job. */
            fun toolType(toolType: ToolType) = toolType(JsonField.of(toolType))

            /**
             * Sets [Builder.toolType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolType] with a well-typed [ToolType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolType(toolType: JsonField<ToolType>) = apply { this.toolType = toolType }

            fun totalResults(totalResults: Long) = totalResults(JsonField.of(totalResults))

            /**
             * Sets [Builder.totalResults] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalResults] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalResults(totalResults: JsonField<Long>) = apply {
                this.totalResults = totalResults
            }

            fun completedAt(completedAt: OffsetDateTime) = completedAt(JsonField.of(completedAt))

            /**
             * Sets [Builder.completedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
                this.completedAt = completedAt
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
             * Returns an immutable instance of [Extraction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .status()
             * .toolType()
             * .totalResults()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Extraction =
                Extraction(
                    checkRequired("id", id),
                    checkRequired("createdAt", createdAt),
                    checkRequired("status", status),
                    checkRequired("toolType", toolType),
                    checkRequired("totalResults", totalResults),
                    completedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Extraction = apply {
            if (validated) {
                return@apply
            }

            id()
            createdAt()
            status().validate()
            toolType().validate()
            totalResults()
            completedAt()
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
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (toolType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalResults.asKnown().isPresent) 1 else 0) +
                (if (completedAt.asKnown().isPresent) 1 else 0)

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

                @JvmField val RUNNING = of("running")

                @JvmField val COMPLETED = of("completed")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                RUNNING,
                COMPLETED,
                FAILED,
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
                RUNNING,
                COMPLETED,
                FAILED,
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
                    RUNNING -> Value.RUNNING
                    COMPLETED -> Value.COMPLETED
                    FAILED -> Value.FAILED
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
                    RUNNING -> Known.RUNNING
                    COMPLETED -> Known.COMPLETED
                    FAILED -> Known.FAILED
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

        /** Identifier for the extraction tool used to run a job. */
        class ToolType @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val ARTICLE_EXTRACTOR = of("article_extractor")

                @JvmField val COMMUNITY_EXTRACTOR = of("community_extractor")

                @JvmField val COMMUNITY_MODERATOR_EXPLORER = of("community_moderator_explorer")

                @JvmField val COMMUNITY_POST_EXTRACTOR = of("community_post_extractor")

                @JvmField val COMMUNITY_SEARCH = of("community_search")

                @JvmField val FOLLOWER_EXPLORER = of("follower_explorer")

                @JvmField val FOLLOWING_EXPLORER = of("following_explorer")

                @JvmField val LIST_FOLLOWER_EXPLORER = of("list_follower_explorer")

                @JvmField val LIST_MEMBER_EXTRACTOR = of("list_member_extractor")

                @JvmField val LIST_POST_EXTRACTOR = of("list_post_extractor")

                @JvmField val MENTION_EXTRACTOR = of("mention_extractor")

                @JvmField val PEOPLE_SEARCH = of("people_search")

                @JvmField val POST_EXTRACTOR = of("post_extractor")

                @JvmField val QUOTE_EXTRACTOR = of("quote_extractor")

                @JvmField val REPLY_EXTRACTOR = of("reply_extractor")

                @JvmField val REPOST_EXTRACTOR = of("repost_extractor")

                @JvmField val SPACE_EXPLORER = of("space_explorer")

                @JvmField val THREAD_EXTRACTOR = of("thread_extractor")

                @JvmField val TWEET_SEARCH_EXTRACTOR = of("tweet_search_extractor")

                @JvmField val VERIFIED_FOLLOWER_EXPLORER = of("verified_follower_explorer")

                @JvmStatic fun of(value: String) = ToolType(JsonField.of(value))
            }

            /** An enum containing [ToolType]'s known values. */
            enum class Known {
                ARTICLE_EXTRACTOR,
                COMMUNITY_EXTRACTOR,
                COMMUNITY_MODERATOR_EXPLORER,
                COMMUNITY_POST_EXTRACTOR,
                COMMUNITY_SEARCH,
                FOLLOWER_EXPLORER,
                FOLLOWING_EXPLORER,
                LIST_FOLLOWER_EXPLORER,
                LIST_MEMBER_EXTRACTOR,
                LIST_POST_EXTRACTOR,
                MENTION_EXTRACTOR,
                PEOPLE_SEARCH,
                POST_EXTRACTOR,
                QUOTE_EXTRACTOR,
                REPLY_EXTRACTOR,
                REPOST_EXTRACTOR,
                SPACE_EXPLORER,
                THREAD_EXTRACTOR,
                TWEET_SEARCH_EXTRACTOR,
                VERIFIED_FOLLOWER_EXPLORER,
            }

            /**
             * An enum containing [ToolType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ToolType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ARTICLE_EXTRACTOR,
                COMMUNITY_EXTRACTOR,
                COMMUNITY_MODERATOR_EXPLORER,
                COMMUNITY_POST_EXTRACTOR,
                COMMUNITY_SEARCH,
                FOLLOWER_EXPLORER,
                FOLLOWING_EXPLORER,
                LIST_FOLLOWER_EXPLORER,
                LIST_MEMBER_EXTRACTOR,
                LIST_POST_EXTRACTOR,
                MENTION_EXTRACTOR,
                PEOPLE_SEARCH,
                POST_EXTRACTOR,
                QUOTE_EXTRACTOR,
                REPLY_EXTRACTOR,
                REPOST_EXTRACTOR,
                SPACE_EXPLORER,
                THREAD_EXTRACTOR,
                TWEET_SEARCH_EXTRACTOR,
                VERIFIED_FOLLOWER_EXPLORER,
                /**
                 * An enum member indicating that [ToolType] was instantiated with an unknown value.
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
                    ARTICLE_EXTRACTOR -> Value.ARTICLE_EXTRACTOR
                    COMMUNITY_EXTRACTOR -> Value.COMMUNITY_EXTRACTOR
                    COMMUNITY_MODERATOR_EXPLORER -> Value.COMMUNITY_MODERATOR_EXPLORER
                    COMMUNITY_POST_EXTRACTOR -> Value.COMMUNITY_POST_EXTRACTOR
                    COMMUNITY_SEARCH -> Value.COMMUNITY_SEARCH
                    FOLLOWER_EXPLORER -> Value.FOLLOWER_EXPLORER
                    FOLLOWING_EXPLORER -> Value.FOLLOWING_EXPLORER
                    LIST_FOLLOWER_EXPLORER -> Value.LIST_FOLLOWER_EXPLORER
                    LIST_MEMBER_EXTRACTOR -> Value.LIST_MEMBER_EXTRACTOR
                    LIST_POST_EXTRACTOR -> Value.LIST_POST_EXTRACTOR
                    MENTION_EXTRACTOR -> Value.MENTION_EXTRACTOR
                    PEOPLE_SEARCH -> Value.PEOPLE_SEARCH
                    POST_EXTRACTOR -> Value.POST_EXTRACTOR
                    QUOTE_EXTRACTOR -> Value.QUOTE_EXTRACTOR
                    REPLY_EXTRACTOR -> Value.REPLY_EXTRACTOR
                    REPOST_EXTRACTOR -> Value.REPOST_EXTRACTOR
                    SPACE_EXPLORER -> Value.SPACE_EXPLORER
                    THREAD_EXTRACTOR -> Value.THREAD_EXTRACTOR
                    TWEET_SEARCH_EXTRACTOR -> Value.TWEET_SEARCH_EXTRACTOR
                    VERIFIED_FOLLOWER_EXPLORER -> Value.VERIFIED_FOLLOWER_EXPLORER
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
                    ARTICLE_EXTRACTOR -> Known.ARTICLE_EXTRACTOR
                    COMMUNITY_EXTRACTOR -> Known.COMMUNITY_EXTRACTOR
                    COMMUNITY_MODERATOR_EXPLORER -> Known.COMMUNITY_MODERATOR_EXPLORER
                    COMMUNITY_POST_EXTRACTOR -> Known.COMMUNITY_POST_EXTRACTOR
                    COMMUNITY_SEARCH -> Known.COMMUNITY_SEARCH
                    FOLLOWER_EXPLORER -> Known.FOLLOWER_EXPLORER
                    FOLLOWING_EXPLORER -> Known.FOLLOWING_EXPLORER
                    LIST_FOLLOWER_EXPLORER -> Known.LIST_FOLLOWER_EXPLORER
                    LIST_MEMBER_EXTRACTOR -> Known.LIST_MEMBER_EXTRACTOR
                    LIST_POST_EXTRACTOR -> Known.LIST_POST_EXTRACTOR
                    MENTION_EXTRACTOR -> Known.MENTION_EXTRACTOR
                    PEOPLE_SEARCH -> Known.PEOPLE_SEARCH
                    POST_EXTRACTOR -> Known.POST_EXTRACTOR
                    QUOTE_EXTRACTOR -> Known.QUOTE_EXTRACTOR
                    REPLY_EXTRACTOR -> Known.REPLY_EXTRACTOR
                    REPOST_EXTRACTOR -> Known.REPOST_EXTRACTOR
                    SPACE_EXPLORER -> Known.SPACE_EXPLORER
                    THREAD_EXTRACTOR -> Known.THREAD_EXTRACTOR
                    TWEET_SEARCH_EXTRACTOR -> Known.TWEET_SEARCH_EXTRACTOR
                    VERIFIED_FOLLOWER_EXPLORER -> Known.VERIFIED_FOLLOWER_EXPLORER
                    else -> throw XTwitterScraperInvalidDataException("Unknown ToolType: $value")
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

            fun validate(): ToolType = apply {
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

                return other is ToolType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Extraction &&
                id == other.id &&
                createdAt == other.createdAt &&
                status == other.status &&
                toolType == other.toolType &&
                totalResults == other.totalResults &&
                completedAt == other.completedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                createdAt,
                status,
                toolType,
                totalResults,
                completedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Extraction{id=$id, createdAt=$createdAt, status=$status, toolType=$toolType, totalResults=$totalResults, completedAt=$completedAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionListResponse &&
            extractions == other.extractions &&
            hasMore == other.hasMore &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(extractions, hasMore, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionListResponse{extractions=$extractions, hasMore=$hasMore, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
