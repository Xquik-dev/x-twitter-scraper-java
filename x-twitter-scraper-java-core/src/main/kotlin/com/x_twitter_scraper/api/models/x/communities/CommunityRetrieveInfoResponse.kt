// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

class CommunityRetrieveInfoResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val community: JsonField<Community>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("community")
        @ExcludeMissing
        community: JsonField<Community> = JsonMissing.of()
    ) : this(community, mutableMapOf())

    /**
     * Community info object
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun community(): Community = community.getRequired("community")

    /**
     * Returns the raw JSON value of [community].
     *
     * Unlike [community], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("community") @ExcludeMissing fun _community(): JsonField<Community> = community

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
         * Returns a mutable builder for constructing an instance of
         * [CommunityRetrieveInfoResponse].
         *
         * The following fields are required:
         * ```java
         * .community()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityRetrieveInfoResponse]. */
    class Builder internal constructor() {

        private var community: JsonField<Community>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityRetrieveInfoResponse: CommunityRetrieveInfoResponse) = apply {
            community = communityRetrieveInfoResponse.community
            additionalProperties = communityRetrieveInfoResponse.additionalProperties.toMutableMap()
        }

        /** Community info object */
        fun community(community: Community) = community(JsonField.of(community))

        /**
         * Sets [Builder.community] to an arbitrary JSON value.
         *
         * You should usually call [Builder.community] with a well-typed [Community] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun community(community: JsonField<Community>) = apply { this.community = community }

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
         * Returns an immutable instance of [CommunityRetrieveInfoResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .community()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse(
                checkRequired("community", community),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CommunityRetrieveInfoResponse = apply {
        if (validated) {
            return@apply
        }

        community().validate()
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
    @JvmSynthetic internal fun validity(): Int = (community.asKnown().getOrNull()?.validity() ?: 0)

    /** Community info object */
    class Community
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val bannerUrl: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val description: JsonField<String>,
        private val joinPolicy: JsonField<String>,
        private val memberCount: JsonField<Long>,
        private val moderatorCount: JsonField<Long>,
        private val name: JsonField<String>,
        private val primaryTopic: JsonField<PrimaryTopic>,
        private val rules: JsonField<List<Rule>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("banner_url")
            @ExcludeMissing
            bannerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("created_at")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("join_policy")
            @ExcludeMissing
            joinPolicy: JsonField<String> = JsonMissing.of(),
            @JsonProperty("member_count")
            @ExcludeMissing
            memberCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("moderator_count")
            @ExcludeMissing
            moderatorCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("primary_topic")
            @ExcludeMissing
            primaryTopic: JsonField<PrimaryTopic> = JsonMissing.of(),
            @JsonProperty("rules") @ExcludeMissing rules: JsonField<List<Rule>> = JsonMissing.of(),
        ) : this(
            id,
            bannerUrl,
            createdAt,
            description,
            joinPolicy,
            memberCount,
            moderatorCount,
            name,
            primaryTopic,
            rules,
            mutableMapOf(),
        )

        /**
         * Unique community identifier
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Community banner image URL
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bannerUrl(): Optional<String> = bannerUrl.getOptional("banner_url")

        /**
         * Community creation timestamp
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("created_at")

        /**
         * About text for the community
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Join policy (open or restricted)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun joinPolicy(): Optional<String> = joinPolicy.getOptional("join_policy")

        /**
         * Total member count
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun memberCount(): Optional<Long> = memberCount.getOptional("member_count")

        /**
         * Total moderator count
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun moderatorCount(): Optional<Long> = moderatorCount.getOptional("moderator_count")

        /**
         * Display name of the community
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Primary topic
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun primaryTopic(): Optional<PrimaryTopic> = primaryTopic.getOptional("primary_topic")

        /**
         * Community rules
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun rules(): Optional<List<Rule>> = rules.getOptional("rules")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bannerUrl].
         *
         * Unlike [bannerUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("banner_url") @ExcludeMissing fun _bannerUrl(): JsonField<String> = bannerUrl

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [joinPolicy].
         *
         * Unlike [joinPolicy], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("join_policy")
        @ExcludeMissing
        fun _joinPolicy(): JsonField<String> = joinPolicy

        /**
         * Returns the raw JSON value of [memberCount].
         *
         * Unlike [memberCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("member_count")
        @ExcludeMissing
        fun _memberCount(): JsonField<Long> = memberCount

        /**
         * Returns the raw JSON value of [moderatorCount].
         *
         * Unlike [moderatorCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("moderator_count")
        @ExcludeMissing
        fun _moderatorCount(): JsonField<Long> = moderatorCount

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [primaryTopic].
         *
         * Unlike [primaryTopic], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("primary_topic")
        @ExcludeMissing
        fun _primaryTopic(): JsonField<PrimaryTopic> = primaryTopic

        /**
         * Returns the raw JSON value of [rules].
         *
         * Unlike [rules], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rules") @ExcludeMissing fun _rules(): JsonField<List<Rule>> = rules

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
             * Returns a mutable builder for constructing an instance of [Community].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Community]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bannerUrl: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var joinPolicy: JsonField<String> = JsonMissing.of()
            private var memberCount: JsonField<Long> = JsonMissing.of()
            private var moderatorCount: JsonField<Long> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var primaryTopic: JsonField<PrimaryTopic> = JsonMissing.of()
            private var rules: JsonField<MutableList<Rule>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(community: Community) = apply {
                id = community.id
                bannerUrl = community.bannerUrl
                createdAt = community.createdAt
                description = community.description
                joinPolicy = community.joinPolicy
                memberCount = community.memberCount
                moderatorCount = community.moderatorCount
                name = community.name
                primaryTopic = community.primaryTopic
                rules = community.rules.map { it.toMutableList() }
                additionalProperties = community.additionalProperties.toMutableMap()
            }

            /** Unique community identifier */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Community banner image URL */
            fun bannerUrl(bannerUrl: String) = bannerUrl(JsonField.of(bannerUrl))

            /**
             * Sets [Builder.bannerUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bannerUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

            /** Community creation timestamp */
            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            /** About text for the community */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Join policy (open or restricted) */
            fun joinPolicy(joinPolicy: String) = joinPolicy(JsonField.of(joinPolicy))

            /**
             * Sets [Builder.joinPolicy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.joinPolicy] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun joinPolicy(joinPolicy: JsonField<String>) = apply { this.joinPolicy = joinPolicy }

            /** Total member count */
            fun memberCount(memberCount: Long) = memberCount(JsonField.of(memberCount))

            /**
             * Sets [Builder.memberCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.memberCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun memberCount(memberCount: JsonField<Long>) = apply { this.memberCount = memberCount }

            /** Total moderator count */
            fun moderatorCount(moderatorCount: Long) = moderatorCount(JsonField.of(moderatorCount))

            /**
             * Sets [Builder.moderatorCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.moderatorCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun moderatorCount(moderatorCount: JsonField<Long>) = apply {
                this.moderatorCount = moderatorCount
            }

            /** Display name of the community */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Primary topic */
            fun primaryTopic(primaryTopic: PrimaryTopic) = primaryTopic(JsonField.of(primaryTopic))

            /**
             * Sets [Builder.primaryTopic] to an arbitrary JSON value.
             *
             * You should usually call [Builder.primaryTopic] with a well-typed [PrimaryTopic] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun primaryTopic(primaryTopic: JsonField<PrimaryTopic>) = apply {
                this.primaryTopic = primaryTopic
            }

            /** Community rules */
            fun rules(rules: List<Rule>) = rules(JsonField.of(rules))

            /**
             * Sets [Builder.rules] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rules] with a well-typed `List<Rule>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rules(rules: JsonField<List<Rule>>) = apply {
                this.rules = rules.map { it.toMutableList() }
            }

            /**
             * Adds a single [Rule] to [rules].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRule(rule: Rule) = apply {
                rules =
                    (rules ?: JsonField.of(mutableListOf())).also {
                        checkKnown("rules", it).add(rule)
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
             * Returns an immutable instance of [Community].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Community =
                Community(
                    checkRequired("id", id),
                    bannerUrl,
                    createdAt,
                    description,
                    joinPolicy,
                    memberCount,
                    moderatorCount,
                    name,
                    primaryTopic,
                    (rules ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Community = apply {
            if (validated) {
                return@apply
            }

            id()
            bannerUrl()
            createdAt()
            description()
            joinPolicy()
            memberCount()
            moderatorCount()
            name()
            primaryTopic().ifPresent { it.validate() }
            rules().ifPresent { it.forEach { it.validate() } }
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
                (if (bannerUrl.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (joinPolicy.asKnown().isPresent) 1 else 0) +
                (if (memberCount.asKnown().isPresent) 1 else 0) +
                (if (moderatorCount.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (primaryTopic.asKnown().getOrNull()?.validity() ?: 0) +
                (rules.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** Primary topic */
        class PrimaryTopic
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [PrimaryTopic]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [PrimaryTopic]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(primaryTopic: PrimaryTopic) = apply {
                    id = primaryTopic.id
                    name = primaryTopic.name
                    additionalProperties = primaryTopic.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [PrimaryTopic].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): PrimaryTopic =
                    PrimaryTopic(id, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): PrimaryTopic = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
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
                (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PrimaryTopic &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PrimaryTopic{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        class Rule
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val description: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, description, name, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [Rule]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Rule]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(rule: Rule) = apply {
                    id = rule.id
                    description = rule.description
                    name = rule.name
                    additionalProperties = rule.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Rule].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Rule = Rule(id, description, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Rule = apply {
                if (validated) {
                    return@apply
                }

                id()
                description()
                name()
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
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Rule &&
                    id == other.id &&
                    description == other.description &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, description, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Rule{id=$id, description=$description, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Community &&
                id == other.id &&
                bannerUrl == other.bannerUrl &&
                createdAt == other.createdAt &&
                description == other.description &&
                joinPolicy == other.joinPolicy &&
                memberCount == other.memberCount &&
                moderatorCount == other.moderatorCount &&
                name == other.name &&
                primaryTopic == other.primaryTopic &&
                rules == other.rules &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bannerUrl,
                createdAt,
                description,
                joinPolicy,
                memberCount,
                moderatorCount,
                name,
                primaryTopic,
                rules,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Community{id=$id, bannerUrl=$bannerUrl, createdAt=$createdAt, description=$description, joinPolicy=$joinPolicy, memberCount=$memberCount, moderatorCount=$moderatorCount, name=$name, primaryTopic=$primaryTopic, rules=$rules, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityRetrieveInfoResponse &&
            community == other.community &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(community, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityRetrieveInfoResponse{community=$community, additionalProperties=$additionalProperties}"
}
