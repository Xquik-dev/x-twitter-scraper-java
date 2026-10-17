// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import com.x_twitter_scraper.api.models.Community
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
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
     *   unexpectedly missing or null.
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

        /** Sets [Builder.community] to an arbitrary JSON value. */
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
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

    @JvmSynthetic internal fun validity(): Int = (community.asKnown().getOrNull()?.validity() ?: 0)

    /** Community info object */
    class Community
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val bannerUrl: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val creator: JsonField<Creator>,
        private val description: JsonField<String>,
        private val invitesPolicy: JsonField<String>,
        private val isNsfw: JsonField<Boolean>,
        private val joinPolicy: JsonField<String>,
        private val memberCount: JsonField<Long>,
        private val moderatorCount: JsonField<Long>,
        private val name: JsonField<String>,
        private val primaryTopic: JsonField<PrimaryTopic>,
        private val rules: JsonField<List<Rule>>,
        private val question: JsonField<String>,
        private val searchTags: JsonField<List<String>>,
        private val admin: JsonField<UserProfile>,
        private val membersFacepile: JsonField<List<UserProfile>>,
        private val banner: JsonField<Community.Banner>,
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
            @JsonProperty("creator") @ExcludeMissing creator: JsonField<Creator> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("invites_policy")
            @ExcludeMissing
            invitesPolicy: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_nsfw") @ExcludeMissing isNsfw: JsonField<Boolean> = JsonMissing.of(),
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
            @JsonProperty("question")
            @ExcludeMissing
            question: JsonField<String> = JsonMissing.of(),
            @JsonProperty("searchTags")
            @ExcludeMissing
            searchTags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("admin") @ExcludeMissing admin: JsonField<UserProfile> = JsonMissing.of(),
            @JsonProperty("membersFacepile")
            @ExcludeMissing
            membersFacepile: JsonField<List<UserProfile>> = JsonMissing.of(),
            @JsonProperty("banner")
            @ExcludeMissing
            banner: JsonField<Community.Banner> = JsonMissing.of(),
        ) : this(
            id,
            bannerUrl,
            createdAt,
            creator,
            description,
            invitesPolicy,
            isNsfw,
            joinPolicy,
            memberCount,
            moderatorCount,
            name,
            primaryTopic,
            rules,
            question,
            searchTags,
            admin,
            membersFacepile,
            banner,
            mutableMapOf(),
        )

        /**
         * Unique community identifier
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Community banner image URL
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun bannerUrl(): Optional<String> = bannerUrl.getOptional("banner_url")

        /**
         * Community creation timestamp
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("created_at")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun creator(): Optional<Creator> = creator.getOptional("creator")

        /**
         * About text for the community
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Invitation policy
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun invitesPolicy(): Optional<String> = invitesPolicy.getOptional("invites_policy")

        /**
         * Whether the community is marked sensitive
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isNsfw(): Optional<Boolean> = isNsfw.getOptional("is_nsfw")

        /**
         * Join policy (open or restricted)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun joinPolicy(): Optional<String> = joinPolicy.getOptional("join_policy")

        /**
         * Total member count
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun memberCount(): Optional<Long> = memberCount.getOptional("member_count")

        /**
         * Total moderator count
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun moderatorCount(): Optional<Long> = moderatorCount.getOptional("moderator_count")

        /**
         * Display name of the community
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Primary topic
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun primaryTopic(): Optional<PrimaryTopic> = primaryTopic.getOptional("primary_topic")

        /**
         * Community rules
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun rules(): Optional<List<Rule>> = rules.getOptional("rules")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun question(): Optional<String> = question.getOptional("question")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun searchTags(): Optional<List<String>> = searchTags.getOptional("searchTags")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun admin(): Optional<UserProfile> = admin.getOptional("admin")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun membersFacepile(): Optional<List<UserProfile>> =
            membersFacepile.getOptional("membersFacepile")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun banner(): Optional<Community.Banner> = banner.getOptional("banner")

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
         * Returns the raw JSON value of [creator].
         *
         * Unlike [creator], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("creator") @ExcludeMissing fun _creator(): JsonField<Creator> = creator

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [invitesPolicy].
         *
         * Unlike [invitesPolicy], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("invites_policy")
        @ExcludeMissing
        fun _invitesPolicy(): JsonField<String> = invitesPolicy

        /**
         * Returns the raw JSON value of [isNsfw].
         *
         * Unlike [isNsfw], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_nsfw") @ExcludeMissing fun _isNsfw(): JsonField<Boolean> = isNsfw

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

        /**
         * Returns the raw JSON value of [question].
         *
         * Unlike [question], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("question") @ExcludeMissing fun _question(): JsonField<String> = question

        /**
         * Returns the raw JSON value of [searchTags].
         *
         * Unlike [searchTags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("searchTags")
        @ExcludeMissing
        fun _searchTags(): JsonField<List<String>> = searchTags

        /**
         * Returns the raw JSON value of [admin].
         *
         * Unlike [admin], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("admin") @ExcludeMissing fun _admin(): JsonField<UserProfile> = admin

        /**
         * Returns the raw JSON value of [membersFacepile].
         *
         * Unlike [membersFacepile], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("membersFacepile")
        @ExcludeMissing
        fun _membersFacepile(): JsonField<List<UserProfile>> = membersFacepile

        /**
         * Returns the raw JSON value of [banner].
         *
         * Unlike [banner], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("banner") @ExcludeMissing fun _banner(): JsonField<Community.Banner> = banner

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
            private var creator: JsonField<Creator> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var invitesPolicy: JsonField<String> = JsonMissing.of()
            private var isNsfw: JsonField<Boolean> = JsonMissing.of()
            private var joinPolicy: JsonField<String> = JsonMissing.of()
            private var memberCount: JsonField<Long> = JsonMissing.of()
            private var moderatorCount: JsonField<Long> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var primaryTopic: JsonField<PrimaryTopic> = JsonMissing.of()
            private var rules: JsonField<MutableList<Rule>>? = null
            private var question: JsonField<String> = JsonMissing.of()
            private var searchTags: JsonField<MutableList<String>>? = null
            private var admin: JsonField<UserProfile> = JsonMissing.of()
            private var membersFacepile: JsonField<MutableList<UserProfile>>? = null
            private var banner: JsonField<Community.Banner> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(community: Community) = apply {
                id = community.id
                bannerUrl = community.bannerUrl
                createdAt = community.createdAt
                creator = community.creator
                description = community.description
                invitesPolicy = community.invitesPolicy
                isNsfw = community.isNsfw
                joinPolicy = community.joinPolicy
                memberCount = community.memberCount
                moderatorCount = community.moderatorCount
                name = community.name
                primaryTopic = community.primaryTopic
                rules = community.rules.map { it.toMutableList() }
                question = community.question
                searchTags = community.searchTags.map { it.toMutableList() }
                admin = community.admin
                membersFacepile = community.membersFacepile.map { it.toMutableList() }
                banner = community.banner
                additionalProperties = community.additionalProperties.toMutableMap()
            }

            /** Unique community identifier */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Community banner image URL */
            fun bannerUrl(bannerUrl: String) = bannerUrl(JsonField.of(bannerUrl))

            /** Sets [Builder.bannerUrl] to an arbitrary JSON value. */
            fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

            /** Community creation timestamp */
            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun creator(creator: Creator) = creator(JsonField.of(creator))

            /** Sets [Builder.creator] to an arbitrary JSON value. */
            fun creator(creator: JsonField<Creator>) = apply { this.creator = creator }

            /** About text for the community */
            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Invitation policy */
            fun invitesPolicy(invitesPolicy: String) = invitesPolicy(JsonField.of(invitesPolicy))

            /** Sets [Builder.invitesPolicy] to an arbitrary JSON value. */
            fun invitesPolicy(invitesPolicy: JsonField<String>) = apply {
                this.invitesPolicy = invitesPolicy
            }

            /** Whether the community is marked sensitive */
            fun isNsfw(isNsfw: Boolean) = isNsfw(JsonField.of(isNsfw))

            /** Sets [Builder.isNsfw] to an arbitrary JSON value. */
            fun isNsfw(isNsfw: JsonField<Boolean>) = apply { this.isNsfw = isNsfw }

            /** Join policy (open or restricted) */
            fun joinPolicy(joinPolicy: String) = joinPolicy(JsonField.of(joinPolicy))

            /** Sets [Builder.joinPolicy] to an arbitrary JSON value. */
            fun joinPolicy(joinPolicy: JsonField<String>) = apply { this.joinPolicy = joinPolicy }

            /** Total member count */
            fun memberCount(memberCount: Long) = memberCount(JsonField.of(memberCount))

            /** Sets [Builder.memberCount] to an arbitrary JSON value. */
            fun memberCount(memberCount: JsonField<Long>) = apply { this.memberCount = memberCount }

            /** Total moderator count */
            fun moderatorCount(moderatorCount: Long) = moderatorCount(JsonField.of(moderatorCount))

            /** Sets [Builder.moderatorCount] to an arbitrary JSON value. */
            fun moderatorCount(moderatorCount: JsonField<Long>) = apply {
                this.moderatorCount = moderatorCount
            }

            /** Display name of the community */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Primary topic */
            fun primaryTopic(primaryTopic: PrimaryTopic) = primaryTopic(JsonField.of(primaryTopic))

            /** Sets [Builder.primaryTopic] to an arbitrary JSON value. */
            fun primaryTopic(primaryTopic: JsonField<PrimaryTopic>) = apply {
                this.primaryTopic = primaryTopic
            }

            /** Community rules */
            fun rules(rules: List<Rule>) = rules(JsonField.of(rules))

            /** Sets [Builder.rules] to an arbitrary JSON value. */
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

            fun question(question: String) = question(JsonField.of(question))

            /** Sets [Builder.question] to an arbitrary JSON value. */
            fun question(question: JsonField<String>) = apply { this.question = question }

            fun searchTags(searchTags: List<String>) = searchTags(JsonField.of(searchTags))

            /** Sets [Builder.searchTags] to an arbitrary JSON value. */
            fun searchTags(searchTags: JsonField<List<String>>) = apply {
                this.searchTags = searchTags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [searchTags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSearchTag(searchTag: String) = apply {
                this.searchTags =
                    (this.searchTags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("searchTags", it).add(searchTag)
                    }
            }

            fun admin(admin: UserProfile) = admin(JsonField.of(admin))

            /** Sets [Builder.admin] to an arbitrary JSON value. */
            fun admin(admin: JsonField<UserProfile>) = apply { this.admin = admin }

            fun membersFacepile(membersFacepile: List<UserProfile>) =
                membersFacepile(JsonField.of(membersFacepile))

            /** Sets [Builder.membersFacepile] to an arbitrary JSON value. */
            fun membersFacepile(membersFacepile: JsonField<List<UserProfile>>) = apply {
                this.membersFacepile = membersFacepile.map { it.toMutableList() }
            }

            /**
             * Adds a single [UserProfile] to [membersFacepile].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMembersFacepile(membersFacepile: UserProfile) = apply {
                this.membersFacepile =
                    (this.membersFacepile ?: JsonField.of(mutableListOf())).also {
                        checkKnown("membersFacepile", it).add(membersFacepile)
                    }
            }

            fun banner(banner: Community.Banner) = banner(JsonField.of(banner))

            /** Sets [Builder.banner] to an arbitrary JSON value. */
            fun banner(banner: JsonField<Community.Banner>) = apply { this.banner = banner }

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
                    creator,
                    description,
                    invitesPolicy,
                    isNsfw,
                    joinPolicy,
                    memberCount,
                    moderatorCount,
                    name,
                    primaryTopic,
                    (rules ?: JsonMissing.of()).map { it.toImmutable() },
                    question,
                    (searchTags ?: JsonMissing.of()).map { it.toImmutable() },
                    admin,
                    (membersFacepile ?: JsonMissing.of()).map { it.toImmutable() },
                    banner,
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
        fun validate(): Community = apply {
            if (validated) {
                return@apply
            }

            id()
            bannerUrl()
            createdAt()
            creator().ifPresent { it.validate() }
            description()
            invitesPolicy()
            isNsfw()
            joinPolicy()
            memberCount()
            moderatorCount()
            name()
            primaryTopic().ifPresent { it.validate() }
            rules().ifPresent { it.forEach { it.validate() } }
            question()
            searchTags()
            admin().ifPresent { it.validate() }
            membersFacepile().ifPresent { it.forEach { it.validate() } }
            banner().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (bannerUrl.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (creator.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (invitesPolicy.asKnown().isPresent) 1 else 0) +
                (if (isNsfw.asKnown().isPresent) 1 else 0) +
                (if (joinPolicy.asKnown().isPresent) 1 else 0) +
                (if (memberCount.asKnown().isPresent) 1 else 0) +
                (if (moderatorCount.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (primaryTopic.asKnown().getOrNull()?.validity() ?: 0) +
                (rules.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (question.asKnown().isPresent) 1 else 0) +
                (if (searchTags.asKnown().isPresent) 1 else 0) +
                (admin.asKnown().getOrNull()?.validity() ?: 0) +
                (membersFacepile.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (banner.asKnown().getOrNull()?.validity() ?: 0)

        class Creator
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val username: JsonField<String>,
            private val verified: JsonField<Boolean>,
            private val name: JsonField<String>,
            private val description: JsonField<String>,
            private val followers: JsonField<Long>,
            private val following: JsonField<Long>,
            private val isBlueVerified: JsonField<Boolean>,
            private val isVerified: JsonField<Boolean>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val coverPicture: JsonField<String>,
            private val profileBannerUrl: JsonField<String>,
            private val location: JsonField<String>,
            private val accountBasedIn: JsonField<UserProfile.AccountBasedIn>,
            private val accountBasedInUnavailable: JsonField<Boolean>,
            private val accountBasedInAccurate: JsonField<Boolean>,
            private val connectedVia: JsonField<String>,
            private val connectedViaAccurate: JsonField<Boolean>,
            private val affiliateUsername: JsonField<String>,
            private val email: JsonField<String>,
            private val contactInfo: JsonField<UserProfile.ContactInfo>,
            private val usernameChanges: JsonField<UserProfile.UsernameChanges>,
            private val birthdate: JsonField<UserProfile.Birthdate>,
            private val retweetedAt: JsonField<OffsetDateTime>,
            private val createdAt: JsonField<String>,
            private val statusesCount: JsonField<Long>,
            private val mediaCount: JsonField<Long>,
            private val protected_: JsonField<Boolean>,
            private val url: JsonField<String>,
            private val favouritesCount: JsonField<Long>,
            private val hasCustomTimelines: JsonField<Boolean>,
            private val isTranslator: JsonField<Boolean>,
            private val withheldInCountries: JsonField<List<String>>,
            private val withheldScope: JsonField<String>,
            private val possiblySensitive: JsonField<Boolean>,
            private val professional: JsonField<UserProfile.Professional>,
            private val grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio>,
            private val pinnedTweetIds: JsonField<List<String>>,
            private val isAutomated: JsonField<Boolean>,
            private val automatedBy: JsonField<String>,
            private val unavailable: JsonField<Boolean>,
            private val unavailableReason: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val affiliatesHighlightedLabel:
                JsonField<UserProfile.AffiliatesHighlightedLabel>,
            private val businessAccountAffiliatesCount: JsonField<Long>,
            private val creatorSubscriptionsCount: JsonField<Long>,
            private val hasGraduatedAccess: JsonField<Boolean>,
            private val hasHiddenSubscriptionsOnProfile: JsonField<Boolean>,
            private val highlightsInfo: JsonField<UserProfile.HighlightsInfo>,
            private val identityVerification: JsonField<UserProfile.IdentityVerification>,
            private val isProfileTranslatable: JsonField<Boolean>,
            private val parodyCommentaryFanLabel: JsonField<String>,
            private val profileDescriptionLanguage: JsonField<String>,
            private val profileImageShape: JsonField<String>,
            private val profileInterstitialType: JsonField<String>,
            private val profileSortEnabled: JsonField<Boolean>,
            private val profileTranslatorType: JsonField<String>,
            private val redirectsToUsername: JsonField<String>,
            private val superFollowEligible: JsonField<Boolean>,
            private val superFollowsUserProfileActive: JsonField<Boolean>,
            private val tipJar: JsonField<UserProfile.TipJar>,
            private val listedCount: JsonField<Long>,
            private val fastFollowersCount: JsonField<Long>,
            private val normalFollowersCount: JsonField<Long>,
            private val defaultProfile: JsonField<Boolean>,
            private val defaultProfileImage: JsonField<Boolean>,
            private val hasExtendedProfile: JsonField<Boolean>,
            private val isTranslationEnabled: JsonField<Boolean>,
            private val geoEnabled: JsonField<Boolean>,
            private val advertiserAccountType: JsonField<String>,
            private val advertiserAccountServiceLevels: JsonField<List<String>>,
            private val businessProfileState: JsonField<String>,
            private val subscribersCount: JsonField<Long>,
            private val verificationReason: JsonField<UserProfile.VerificationReason>,
            private val communityRole: JsonField<String>,
            private val profileBio: JsonField<UserProfile.ProfileBio>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verified")
                @ExcludeMissing
                verified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("followers")
                @ExcludeMissing
                followers: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("following")
                @ExcludeMissing
                following: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("isBlueVerified")
                @ExcludeMissing
                isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isVerified")
                @ExcludeMissing
                isVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("coverPicture")
                @ExcludeMissing
                coverPicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileBannerUrl")
                @ExcludeMissing
                profileBannerUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<String> = JsonMissing.of(),
                @JsonProperty("accountBasedIn")
                @ExcludeMissing
                accountBasedIn: JsonField<UserProfile.AccountBasedIn> = JsonMissing.of(),
                @JsonProperty("accountBasedInUnavailable")
                @ExcludeMissing
                accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("accountBasedInAccurate")
                @ExcludeMissing
                accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("connectedVia")
                @ExcludeMissing
                connectedVia: JsonField<String> = JsonMissing.of(),
                @JsonProperty("connectedViaAccurate")
                @ExcludeMissing
                connectedViaAccurate: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("affiliateUsername")
                @ExcludeMissing
                affiliateUsername: JsonField<String> = JsonMissing.of(),
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("contactInfo")
                @ExcludeMissing
                contactInfo: JsonField<UserProfile.ContactInfo> = JsonMissing.of(),
                @JsonProperty("usernameChanges")
                @ExcludeMissing
                usernameChanges: JsonField<UserProfile.UsernameChanges> = JsonMissing.of(),
                @JsonProperty("birthdate")
                @ExcludeMissing
                birthdate: JsonField<UserProfile.Birthdate> = JsonMissing.of(),
                @JsonProperty("retweetedAt")
                @ExcludeMissing
                retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("statusesCount")
                @ExcludeMissing
                statusesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("mediaCount")
                @ExcludeMissing
                mediaCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("protected")
                @ExcludeMissing
                protected_: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("favouritesCount")
                @ExcludeMissing
                favouritesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("hasCustomTimelines")
                @ExcludeMissing
                hasCustomTimelines: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isTranslator")
                @ExcludeMissing
                isTranslator: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("withheldInCountries")
                @ExcludeMissing
                withheldInCountries: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("withheldScope")
                @ExcludeMissing
                withheldScope: JsonField<String> = JsonMissing.of(),
                @JsonProperty("possiblySensitive")
                @ExcludeMissing
                possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("professional")
                @ExcludeMissing
                professional: JsonField<UserProfile.Professional> = JsonMissing.of(),
                @JsonProperty("grokTranslatedBio")
                @ExcludeMissing
                grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio> = JsonMissing.of(),
                @JsonProperty("pinnedTweetIds")
                @ExcludeMissing
                pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("isAutomated")
                @ExcludeMissing
                isAutomated: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("automatedBy")
                @ExcludeMissing
                automatedBy: JsonField<String> = JsonMissing.of(),
                @JsonProperty("unavailable")
                @ExcludeMissing
                unavailable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("unavailableReason")
                @ExcludeMissing
                unavailableReason: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("affiliatesHighlightedLabel")
                @ExcludeMissing
                affiliatesHighlightedLabel: JsonField<UserProfile.AffiliatesHighlightedLabel> =
                    JsonMissing.of(),
                @JsonProperty("businessAccountAffiliatesCount")
                @ExcludeMissing
                businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("creatorSubscriptionsCount")
                @ExcludeMissing
                creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("hasGraduatedAccess")
                @ExcludeMissing
                hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("hasHiddenSubscriptionsOnProfile")
                @ExcludeMissing
                hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("highlightsInfo")
                @ExcludeMissing
                highlightsInfo: JsonField<UserProfile.HighlightsInfo> = JsonMissing.of(),
                @JsonProperty("identityVerification")
                @ExcludeMissing
                identityVerification: JsonField<UserProfile.IdentityVerification> =
                    JsonMissing.of(),
                @JsonProperty("isProfileTranslatable")
                @ExcludeMissing
                isProfileTranslatable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("parodyCommentaryFanLabel")
                @ExcludeMissing
                parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileDescriptionLanguage")
                @ExcludeMissing
                profileDescriptionLanguage: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileImageShape")
                @ExcludeMissing
                profileImageShape: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileInterstitialType")
                @ExcludeMissing
                profileInterstitialType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileSortEnabled")
                @ExcludeMissing
                profileSortEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("profileTranslatorType")
                @ExcludeMissing
                profileTranslatorType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("redirectsToUsername")
                @ExcludeMissing
                redirectsToUsername: JsonField<String> = JsonMissing.of(),
                @JsonProperty("superFollowEligible")
                @ExcludeMissing
                superFollowEligible: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("superFollowsUserProfileActive")
                @ExcludeMissing
                superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("tipJar")
                @ExcludeMissing
                tipJar: JsonField<UserProfile.TipJar> = JsonMissing.of(),
                @JsonProperty("listedCount")
                @ExcludeMissing
                listedCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("fastFollowersCount")
                @ExcludeMissing
                fastFollowersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("normalFollowersCount")
                @ExcludeMissing
                normalFollowersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("defaultProfile")
                @ExcludeMissing
                defaultProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("defaultProfileImage")
                @ExcludeMissing
                defaultProfileImage: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("hasExtendedProfile")
                @ExcludeMissing
                hasExtendedProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isTranslationEnabled")
                @ExcludeMissing
                isTranslationEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("geoEnabled")
                @ExcludeMissing
                geoEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("advertiserAccountType")
                @ExcludeMissing
                advertiserAccountType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("advertiserAccountServiceLevels")
                @ExcludeMissing
                advertiserAccountServiceLevels: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("businessProfileState")
                @ExcludeMissing
                businessProfileState: JsonField<String> = JsonMissing.of(),
                @JsonProperty("subscribersCount")
                @ExcludeMissing
                subscribersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("verificationReason")
                @ExcludeMissing
                verificationReason: JsonField<UserProfile.VerificationReason> = JsonMissing.of(),
                @JsonProperty("communityRole")
                @ExcludeMissing
                communityRole: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profile_bio")
                @ExcludeMissing
                profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of(),
            ) : this(
                id,
                username,
                verified,
                name,
                description,
                followers,
                following,
                isBlueVerified,
                isVerified,
                profilePicture,
                profilePictureOriginal,
                coverPicture,
                profileBannerUrl,
                location,
                accountBasedIn,
                accountBasedInUnavailable,
                accountBasedInAccurate,
                connectedVia,
                connectedViaAccurate,
                affiliateUsername,
                email,
                contactInfo,
                usernameChanges,
                birthdate,
                retweetedAt,
                createdAt,
                statusesCount,
                mediaCount,
                protected_,
                url,
                favouritesCount,
                hasCustomTimelines,
                isTranslator,
                withheldInCountries,
                withheldScope,
                possiblySensitive,
                professional,
                grokTranslatedBio,
                pinnedTweetIds,
                isAutomated,
                automatedBy,
                unavailable,
                unavailableReason,
                verifiedType,
                affiliatesHighlightedLabel,
                businessAccountAffiliatesCount,
                creatorSubscriptionsCount,
                hasGraduatedAccess,
                hasHiddenSubscriptionsOnProfile,
                highlightsInfo,
                identityVerification,
                isProfileTranslatable,
                parodyCommentaryFanLabel,
                profileDescriptionLanguage,
                profileImageShape,
                profileInterstitialType,
                profileSortEnabled,
                profileTranslatorType,
                redirectsToUsername,
                superFollowEligible,
                superFollowsUserProfileActive,
                tipJar,
                listedCount,
                fastFollowersCount,
                normalFollowersCount,
                defaultProfile,
                defaultProfileImage,
                hasExtendedProfile,
                isTranslationEnabled,
                geoEnabled,
                advertiserAccountType,
                advertiserAccountServiceLevels,
                businessProfileState,
                subscribersCount,
                verificationReason,
                communityRole,
                profileBio,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun username(): String = username.getRequired("username")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun verified(): Boolean = verified.getRequired("verified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun followers(): Optional<Long> = followers.getOptional("followers")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun following(): Optional<Long> = following.getOptional("following")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun coverPicture(): Optional<String> = coverPicture.getOptional("coverPicture")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileBannerUrl(): Optional<String> =
                profileBannerUrl.getOptional("profileBannerUrl")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun location(): Optional<String> = location.getOptional("location")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedIn(): Optional<UserProfile.AccountBasedIn> =
                accountBasedIn.getOptional("accountBasedIn")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedInUnavailable(): Optional<Boolean> =
                accountBasedInUnavailable.getOptional("accountBasedInUnavailable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedInAccurate(): Optional<Boolean> =
                accountBasedInAccurate.getOptional("accountBasedInAccurate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun connectedVia(): Optional<String> = connectedVia.getOptional("connectedVia")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun connectedViaAccurate(): Optional<Boolean> =
                connectedViaAccurate.getOptional("connectedViaAccurate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliateUsername(): Optional<String> =
                affiliateUsername.getOptional("affiliateUsername")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun contactInfo(): Optional<UserProfile.ContactInfo> =
                contactInfo.getOptional("contactInfo")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun usernameChanges(): Optional<UserProfile.UsernameChanges> =
                usernameChanges.getOptional("usernameChanges")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun birthdate(): Optional<UserProfile.Birthdate> = birthdate.getOptional("birthdate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasCustomTimelines(): Optional<Boolean> =
                hasCustomTimelines.getOptional("hasCustomTimelines")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun withheldInCountries(): Optional<List<String>> =
                withheldInCountries.getOptional("withheldInCountries")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun withheldScope(): Optional<String> = withheldScope.getOptional("withheldScope")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun possiblySensitive(): Optional<Boolean> =
                possiblySensitive.getOptional("possiblySensitive")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun professional(): Optional<UserProfile.Professional> =
                professional.getOptional("professional")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun grokTranslatedBio(): Optional<UserProfile.GrokTranslatedBio> =
                grokTranslatedBio.getOptional("grokTranslatedBio")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun pinnedTweetIds(): Optional<List<String>> =
                pinnedTweetIds.getOptional("pinnedTweetIds")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isAutomated(): Optional<Boolean> = isAutomated.getOptional("isAutomated")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun unavailable(): Optional<Boolean> = unavailable.getOptional("unavailable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun unavailableReason(): Optional<String> =
                unavailableReason.getOptional("unavailableReason")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliatesHighlightedLabel(): Optional<UserProfile.AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun businessAccountAffiliatesCount(): Optional<Long> =
                businessAccountAffiliatesCount.getOptional("businessAccountAffiliatesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun creatorSubscriptionsCount(): Optional<Long> =
                creatorSubscriptionsCount.getOptional("creatorSubscriptionsCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasGraduatedAccess(): Optional<Boolean> =
                hasGraduatedAccess.getOptional("hasGraduatedAccess")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasHiddenSubscriptionsOnProfile(): Optional<Boolean> =
                hasHiddenSubscriptionsOnProfile.getOptional("hasHiddenSubscriptionsOnProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun highlightsInfo(): Optional<UserProfile.HighlightsInfo> =
                highlightsInfo.getOptional("highlightsInfo")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun identityVerification(): Optional<UserProfile.IdentityVerification> =
                identityVerification.getOptional("identityVerification")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isProfileTranslatable(): Optional<Boolean> =
                isProfileTranslatable.getOptional("isProfileTranslatable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun parodyCommentaryFanLabel(): Optional<String> =
                parodyCommentaryFanLabel.getOptional("parodyCommentaryFanLabel")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileDescriptionLanguage(): Optional<String> =
                profileDescriptionLanguage.getOptional("profileDescriptionLanguage")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileImageShape(): Optional<String> =
                profileImageShape.getOptional("profileImageShape")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileInterstitialType(): Optional<String> =
                profileInterstitialType.getOptional("profileInterstitialType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileSortEnabled(): Optional<Boolean> =
                profileSortEnabled.getOptional("profileSortEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileTranslatorType(): Optional<String> =
                profileTranslatorType.getOptional("profileTranslatorType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun redirectsToUsername(): Optional<String> =
                redirectsToUsername.getOptional("redirectsToUsername")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun superFollowEligible(): Optional<Boolean> =
                superFollowEligible.getOptional("superFollowEligible")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun superFollowsUserProfileActive(): Optional<Boolean> =
                superFollowsUserProfileActive.getOptional("superFollowsUserProfileActive")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun tipJar(): Optional<UserProfile.TipJar> = tipJar.getOptional("tipJar")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun listedCount(): Optional<Long> = listedCount.getOptional("listedCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun fastFollowersCount(): Optional<Long> =
                fastFollowersCount.getOptional("fastFollowersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun normalFollowersCount(): Optional<Long> =
                normalFollowersCount.getOptional("normalFollowersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun defaultProfile(): Optional<Boolean> = defaultProfile.getOptional("defaultProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun defaultProfileImage(): Optional<Boolean> =
                defaultProfileImage.getOptional("defaultProfileImage")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasExtendedProfile(): Optional<Boolean> =
                hasExtendedProfile.getOptional("hasExtendedProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isTranslationEnabled(): Optional<Boolean> =
                isTranslationEnabled.getOptional("isTranslationEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun geoEnabled(): Optional<Boolean> = geoEnabled.getOptional("geoEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun advertiserAccountType(): Optional<String> =
                advertiserAccountType.getOptional("advertiserAccountType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun advertiserAccountServiceLevels(): Optional<List<String>> =
                advertiserAccountServiceLevels.getOptional("advertiserAccountServiceLevels")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun businessProfileState(): Optional<String> =
                businessProfileState.getOptional("businessProfileState")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun subscribersCount(): Optional<Long> =
                subscribersCount.getOptional("subscribersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verificationReason(): Optional<UserProfile.VerificationReason> =
                verificationReason.getOptional("verificationReason")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun communityRole(): Optional<String> = communityRole.getOptional("communityRole")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileBio(): Optional<UserProfile.ProfileBio> =
                profileBio.getOptional("profile_bio")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [verified].
             *
             * Unlike [verified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns the raw JSON value of [followers].
             *
             * Unlike [followers], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

            /**
             * Returns the raw JSON value of [following].
             *
             * Unlike [following], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following

            /**
             * Returns the raw JSON value of [isBlueVerified].
             *
             * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

            /**
             * Returns the raw JSON value of [isVerified].
             *
             * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isVerified")
            @ExcludeMissing
            fun _isVerified(): JsonField<Boolean> = isVerified

            /**
             * Returns the raw JSON value of [profilePicture].
             *
             * Unlike [profilePicture], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profilePicture")
            @ExcludeMissing
            fun _profilePicture(): JsonField<String> = profilePicture

            /**
             * Returns the raw JSON value of [profilePictureOriginal].
             *
             * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profilePictureOriginal")
            @ExcludeMissing
            fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal

            /**
             * Returns the raw JSON value of [coverPicture].
             *
             * Unlike [coverPicture], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("coverPicture")
            @ExcludeMissing
            fun _coverPicture(): JsonField<String> = coverPicture

            /**
             * Returns the raw JSON value of [profileBannerUrl].
             *
             * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileBannerUrl")
            @ExcludeMissing
            fun _profileBannerUrl(): JsonField<String> = profileBannerUrl

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

            /**
             * Returns the raw JSON value of [accountBasedIn].
             *
             * Unlike [accountBasedIn], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("accountBasedIn")
            @ExcludeMissing
            fun _accountBasedIn(): JsonField<UserProfile.AccountBasedIn> = accountBasedIn

            /**
             * Returns the raw JSON value of [accountBasedInUnavailable].
             *
             * Unlike [accountBasedInUnavailable], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("accountBasedInUnavailable")
            @ExcludeMissing
            fun _accountBasedInUnavailable(): JsonField<Boolean> = accountBasedInUnavailable

            /**
             * Returns the raw JSON value of [accountBasedInAccurate].
             *
             * Unlike [accountBasedInAccurate], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("accountBasedInAccurate")
            @ExcludeMissing
            fun _accountBasedInAccurate(): JsonField<Boolean> = accountBasedInAccurate

            /**
             * Returns the raw JSON value of [connectedVia].
             *
             * Unlike [connectedVia], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("connectedVia")
            @ExcludeMissing
            fun _connectedVia(): JsonField<String> = connectedVia

            /**
             * Returns the raw JSON value of [connectedViaAccurate].
             *
             * Unlike [connectedViaAccurate], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("connectedViaAccurate")
            @ExcludeMissing
            fun _connectedViaAccurate(): JsonField<Boolean> = connectedViaAccurate

            /**
             * Returns the raw JSON value of [affiliateUsername].
             *
             * Unlike [affiliateUsername], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("affiliateUsername")
            @ExcludeMissing
            fun _affiliateUsername(): JsonField<String> = affiliateUsername

            /**
             * Returns the raw JSON value of [email].
             *
             * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

            /**
             * Returns the raw JSON value of [contactInfo].
             *
             * Unlike [contactInfo], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("contactInfo")
            @ExcludeMissing
            fun _contactInfo(): JsonField<UserProfile.ContactInfo> = contactInfo

            /**
             * Returns the raw JSON value of [usernameChanges].
             *
             * Unlike [usernameChanges], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("usernameChanges")
            @ExcludeMissing
            fun _usernameChanges(): JsonField<UserProfile.UsernameChanges> = usernameChanges

            /**
             * Returns the raw JSON value of [birthdate].
             *
             * Unlike [birthdate], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("birthdate")
            @ExcludeMissing
            fun _birthdate(): JsonField<UserProfile.Birthdate> = birthdate

            /**
             * Returns the raw JSON value of [retweetedAt].
             *
             * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("retweetedAt")
            @ExcludeMissing
            fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<String> = createdAt

            /**
             * Returns the raw JSON value of [statusesCount].
             *
             * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("statusesCount")
            @ExcludeMissing
            fun _statusesCount(): JsonField<Long> = statusesCount

            /**
             * Returns the raw JSON value of [mediaCount].
             *
             * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaCount")
            @ExcludeMissing
            fun _mediaCount(): JsonField<Long> = mediaCount

            /**
             * Returns the raw JSON value of [protected_].
             *
             * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("protected")
            @ExcludeMissing
            fun _protected_(): JsonField<Boolean> = protected_

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [favouritesCount].
             *
             * Unlike [favouritesCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("favouritesCount")
            @ExcludeMissing
            fun _favouritesCount(): JsonField<Long> = favouritesCount

            /**
             * Returns the raw JSON value of [hasCustomTimelines].
             *
             * Unlike [hasCustomTimelines], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasCustomTimelines")
            @ExcludeMissing
            fun _hasCustomTimelines(): JsonField<Boolean> = hasCustomTimelines

            /**
             * Returns the raw JSON value of [isTranslator].
             *
             * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isTranslator")
            @ExcludeMissing
            fun _isTranslator(): JsonField<Boolean> = isTranslator

            /**
             * Returns the raw JSON value of [withheldInCountries].
             *
             * Unlike [withheldInCountries], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("withheldInCountries")
            @ExcludeMissing
            fun _withheldInCountries(): JsonField<List<String>> = withheldInCountries

            /**
             * Returns the raw JSON value of [withheldScope].
             *
             * Unlike [withheldScope], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("withheldScope")
            @ExcludeMissing
            fun _withheldScope(): JsonField<String> = withheldScope

            /**
             * Returns the raw JSON value of [possiblySensitive].
             *
             * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("possiblySensitive")
            @ExcludeMissing
            fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive

            /**
             * Returns the raw JSON value of [professional].
             *
             * Unlike [professional], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("professional")
            @ExcludeMissing
            fun _professional(): JsonField<UserProfile.Professional> = professional

            /**
             * Returns the raw JSON value of [grokTranslatedBio].
             *
             * Unlike [grokTranslatedBio], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("grokTranslatedBio")
            @ExcludeMissing
            fun _grokTranslatedBio(): JsonField<UserProfile.GrokTranslatedBio> = grokTranslatedBio

            /**
             * Returns the raw JSON value of [pinnedTweetIds].
             *
             * Unlike [pinnedTweetIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("pinnedTweetIds")
            @ExcludeMissing
            fun _pinnedTweetIds(): JsonField<List<String>> = pinnedTweetIds

            /**
             * Returns the raw JSON value of [isAutomated].
             *
             * Unlike [isAutomated], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isAutomated")
            @ExcludeMissing
            fun _isAutomated(): JsonField<Boolean> = isAutomated

            /**
             * Returns the raw JSON value of [automatedBy].
             *
             * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("automatedBy")
            @ExcludeMissing
            fun _automatedBy(): JsonField<String> = automatedBy

            /**
             * Returns the raw JSON value of [unavailable].
             *
             * Unlike [unavailable], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("unavailable")
            @ExcludeMissing
            fun _unavailable(): JsonField<Boolean> = unavailable

            /**
             * Returns the raw JSON value of [unavailableReason].
             *
             * Unlike [unavailableReason], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("unavailableReason")
            @ExcludeMissing
            fun _unavailableReason(): JsonField<String> = unavailableReason

            /**
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

            /**
             * Returns the raw JSON value of [affiliatesHighlightedLabel].
             *
             * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("affiliatesHighlightedLabel")
            @ExcludeMissing
            fun _affiliatesHighlightedLabel(): JsonField<UserProfile.AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel

            /**
             * Returns the raw JSON value of [businessAccountAffiliatesCount].
             *
             * Unlike [businessAccountAffiliatesCount], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("businessAccountAffiliatesCount")
            @ExcludeMissing
            fun _businessAccountAffiliatesCount(): JsonField<Long> = businessAccountAffiliatesCount

            /**
             * Returns the raw JSON value of [creatorSubscriptionsCount].
             *
             * Unlike [creatorSubscriptionsCount], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("creatorSubscriptionsCount")
            @ExcludeMissing
            fun _creatorSubscriptionsCount(): JsonField<Long> = creatorSubscriptionsCount

            /**
             * Returns the raw JSON value of [hasGraduatedAccess].
             *
             * Unlike [hasGraduatedAccess], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasGraduatedAccess")
            @ExcludeMissing
            fun _hasGraduatedAccess(): JsonField<Boolean> = hasGraduatedAccess

            /**
             * Returns the raw JSON value of [hasHiddenSubscriptionsOnProfile].
             *
             * Unlike [hasHiddenSubscriptionsOnProfile], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("hasHiddenSubscriptionsOnProfile")
            @ExcludeMissing
            fun _hasHiddenSubscriptionsOnProfile(): JsonField<Boolean> =
                hasHiddenSubscriptionsOnProfile

            /**
             * Returns the raw JSON value of [highlightsInfo].
             *
             * Unlike [highlightsInfo], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("highlightsInfo")
            @ExcludeMissing
            fun _highlightsInfo(): JsonField<UserProfile.HighlightsInfo> = highlightsInfo

            /**
             * Returns the raw JSON value of [identityVerification].
             *
             * Unlike [identityVerification], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("identityVerification")
            @ExcludeMissing
            fun _identityVerification(): JsonField<UserProfile.IdentityVerification> =
                identityVerification

            /**
             * Returns the raw JSON value of [isProfileTranslatable].
             *
             * Unlike [isProfileTranslatable], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isProfileTranslatable")
            @ExcludeMissing
            fun _isProfileTranslatable(): JsonField<Boolean> = isProfileTranslatable

            /**
             * Returns the raw JSON value of [parodyCommentaryFanLabel].
             *
             * Unlike [parodyCommentaryFanLabel], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("parodyCommentaryFanLabel")
            @ExcludeMissing
            fun _parodyCommentaryFanLabel(): JsonField<String> = parodyCommentaryFanLabel

            /**
             * Returns the raw JSON value of [profileDescriptionLanguage].
             *
             * Unlike [profileDescriptionLanguage], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("profileDescriptionLanguage")
            @ExcludeMissing
            fun _profileDescriptionLanguage(): JsonField<String> = profileDescriptionLanguage

            /**
             * Returns the raw JSON value of [profileImageShape].
             *
             * Unlike [profileImageShape], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileImageShape")
            @ExcludeMissing
            fun _profileImageShape(): JsonField<String> = profileImageShape

            /**
             * Returns the raw JSON value of [profileInterstitialType].
             *
             * Unlike [profileInterstitialType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileInterstitialType")
            @ExcludeMissing
            fun _profileInterstitialType(): JsonField<String> = profileInterstitialType

            /**
             * Returns the raw JSON value of [profileSortEnabled].
             *
             * Unlike [profileSortEnabled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileSortEnabled")
            @ExcludeMissing
            fun _profileSortEnabled(): JsonField<Boolean> = profileSortEnabled

            /**
             * Returns the raw JSON value of [profileTranslatorType].
             *
             * Unlike [profileTranslatorType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileTranslatorType")
            @ExcludeMissing
            fun _profileTranslatorType(): JsonField<String> = profileTranslatorType

            /**
             * Returns the raw JSON value of [redirectsToUsername].
             *
             * Unlike [redirectsToUsername], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("redirectsToUsername")
            @ExcludeMissing
            fun _redirectsToUsername(): JsonField<String> = redirectsToUsername

            /**
             * Returns the raw JSON value of [superFollowEligible].
             *
             * Unlike [superFollowEligible], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("superFollowEligible")
            @ExcludeMissing
            fun _superFollowEligible(): JsonField<Boolean> = superFollowEligible

            /**
             * Returns the raw JSON value of [superFollowsUserProfileActive].
             *
             * Unlike [superFollowsUserProfileActive], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("superFollowsUserProfileActive")
            @ExcludeMissing
            fun _superFollowsUserProfileActive(): JsonField<Boolean> = superFollowsUserProfileActive

            /**
             * Returns the raw JSON value of [tipJar].
             *
             * Unlike [tipJar], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tipJar")
            @ExcludeMissing
            fun _tipJar(): JsonField<UserProfile.TipJar> = tipJar

            /**
             * Returns the raw JSON value of [listedCount].
             *
             * Unlike [listedCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("listedCount")
            @ExcludeMissing
            fun _listedCount(): JsonField<Long> = listedCount

            /**
             * Returns the raw JSON value of [fastFollowersCount].
             *
             * Unlike [fastFollowersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("fastFollowersCount")
            @ExcludeMissing
            fun _fastFollowersCount(): JsonField<Long> = fastFollowersCount

            /**
             * Returns the raw JSON value of [normalFollowersCount].
             *
             * Unlike [normalFollowersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("normalFollowersCount")
            @ExcludeMissing
            fun _normalFollowersCount(): JsonField<Long> = normalFollowersCount

            /**
             * Returns the raw JSON value of [defaultProfile].
             *
             * Unlike [defaultProfile], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("defaultProfile")
            @ExcludeMissing
            fun _defaultProfile(): JsonField<Boolean> = defaultProfile

            /**
             * Returns the raw JSON value of [defaultProfileImage].
             *
             * Unlike [defaultProfileImage], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("defaultProfileImage")
            @ExcludeMissing
            fun _defaultProfileImage(): JsonField<Boolean> = defaultProfileImage

            /**
             * Returns the raw JSON value of [hasExtendedProfile].
             *
             * Unlike [hasExtendedProfile], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasExtendedProfile")
            @ExcludeMissing
            fun _hasExtendedProfile(): JsonField<Boolean> = hasExtendedProfile

            /**
             * Returns the raw JSON value of [isTranslationEnabled].
             *
             * Unlike [isTranslationEnabled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isTranslationEnabled")
            @ExcludeMissing
            fun _isTranslationEnabled(): JsonField<Boolean> = isTranslationEnabled

            /**
             * Returns the raw JSON value of [geoEnabled].
             *
             * Unlike [geoEnabled], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("geoEnabled")
            @ExcludeMissing
            fun _geoEnabled(): JsonField<Boolean> = geoEnabled

            /**
             * Returns the raw JSON value of [advertiserAccountType].
             *
             * Unlike [advertiserAccountType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("advertiserAccountType")
            @ExcludeMissing
            fun _advertiserAccountType(): JsonField<String> = advertiserAccountType

            /**
             * Returns the raw JSON value of [advertiserAccountServiceLevels].
             *
             * Unlike [advertiserAccountServiceLevels], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("advertiserAccountServiceLevels")
            @ExcludeMissing
            fun _advertiserAccountServiceLevels(): JsonField<List<String>> =
                advertiserAccountServiceLevels

            /**
             * Returns the raw JSON value of [businessProfileState].
             *
             * Unlike [businessProfileState], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("businessProfileState")
            @ExcludeMissing
            fun _businessProfileState(): JsonField<String> = businessProfileState

            /**
             * Returns the raw JSON value of [subscribersCount].
             *
             * Unlike [subscribersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("subscribersCount")
            @ExcludeMissing
            fun _subscribersCount(): JsonField<Long> = subscribersCount

            /**
             * Returns the raw JSON value of [verificationReason].
             *
             * Unlike [verificationReason], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("verificationReason")
            @ExcludeMissing
            fun _verificationReason(): JsonField<UserProfile.VerificationReason> =
                verificationReason

            /**
             * Returns the raw JSON value of [communityRole].
             *
             * Unlike [communityRole], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("communityRole")
            @ExcludeMissing
            fun _communityRole(): JsonField<String> = communityRole

            /**
             * Returns the raw JSON value of [profileBio].
             *
             * Unlike [profileBio], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("profile_bio")
            @ExcludeMissing
            fun _profileBio(): JsonField<UserProfile.ProfileBio> = profileBio

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
                 * Returns a mutable builder for constructing an instance of [Creator].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .username()
                 * .verified()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Creator]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var verified: JsonField<Boolean>? = null
                private var name: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var followers: JsonField<Long> = JsonMissing.of()
                private var following: JsonField<Long> = JsonMissing.of()
                private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
                private var isVerified: JsonField<Boolean> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var coverPicture: JsonField<String> = JsonMissing.of()
                private var profileBannerUrl: JsonField<String> = JsonMissing.of()
                private var location: JsonField<String> = JsonMissing.of()
                private var accountBasedIn: JsonField<UserProfile.AccountBasedIn> = JsonMissing.of()
                private var accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of()
                private var accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of()
                private var connectedVia: JsonField<String> = JsonMissing.of()
                private var connectedViaAccurate: JsonField<Boolean> = JsonMissing.of()
                private var affiliateUsername: JsonField<String> = JsonMissing.of()
                private var email: JsonField<String> = JsonMissing.of()
                private var contactInfo: JsonField<UserProfile.ContactInfo> = JsonMissing.of()
                private var usernameChanges: JsonField<UserProfile.UsernameChanges> =
                    JsonMissing.of()
                private var birthdate: JsonField<UserProfile.Birthdate> = JsonMissing.of()
                private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var createdAt: JsonField<String> = JsonMissing.of()
                private var statusesCount: JsonField<Long> = JsonMissing.of()
                private var mediaCount: JsonField<Long> = JsonMissing.of()
                private var protected_: JsonField<Boolean> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var favouritesCount: JsonField<Long> = JsonMissing.of()
                private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of()
                private var isTranslator: JsonField<Boolean> = JsonMissing.of()
                private var withheldInCountries: JsonField<MutableList<String>>? = null
                private var withheldScope: JsonField<String> = JsonMissing.of()
                private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
                private var professional: JsonField<UserProfile.Professional> = JsonMissing.of()
                private var grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio> =
                    JsonMissing.of()
                private var pinnedTweetIds: JsonField<MutableList<String>>? = null
                private var isAutomated: JsonField<Boolean> = JsonMissing.of()
                private var automatedBy: JsonField<String> = JsonMissing.of()
                private var unavailable: JsonField<Boolean> = JsonMissing.of()
                private var unavailableReason: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var affiliatesHighlightedLabel:
                    JsonField<UserProfile.AffiliatesHighlightedLabel> =
                    JsonMissing.of()
                private var businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of()
                private var creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of()
                private var hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of()
                private var hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of()
                private var highlightsInfo: JsonField<UserProfile.HighlightsInfo> = JsonMissing.of()
                private var identityVerification: JsonField<UserProfile.IdentityVerification> =
                    JsonMissing.of()
                private var isProfileTranslatable: JsonField<Boolean> = JsonMissing.of()
                private var parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of()
                private var profileDescriptionLanguage: JsonField<String> = JsonMissing.of()
                private var profileImageShape: JsonField<String> = JsonMissing.of()
                private var profileInterstitialType: JsonField<String> = JsonMissing.of()
                private var profileSortEnabled: JsonField<Boolean> = JsonMissing.of()
                private var profileTranslatorType: JsonField<String> = JsonMissing.of()
                private var redirectsToUsername: JsonField<String> = JsonMissing.of()
                private var superFollowEligible: JsonField<Boolean> = JsonMissing.of()
                private var superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of()
                private var tipJar: JsonField<UserProfile.TipJar> = JsonMissing.of()
                private var listedCount: JsonField<Long> = JsonMissing.of()
                private var fastFollowersCount: JsonField<Long> = JsonMissing.of()
                private var normalFollowersCount: JsonField<Long> = JsonMissing.of()
                private var defaultProfile: JsonField<Boolean> = JsonMissing.of()
                private var defaultProfileImage: JsonField<Boolean> = JsonMissing.of()
                private var hasExtendedProfile: JsonField<Boolean> = JsonMissing.of()
                private var isTranslationEnabled: JsonField<Boolean> = JsonMissing.of()
                private var geoEnabled: JsonField<Boolean> = JsonMissing.of()
                private var advertiserAccountType: JsonField<String> = JsonMissing.of()
                private var advertiserAccountServiceLevels: JsonField<MutableList<String>>? = null
                private var businessProfileState: JsonField<String> = JsonMissing.of()
                private var subscribersCount: JsonField<Long> = JsonMissing.of()
                private var verificationReason: JsonField<UserProfile.VerificationReason> =
                    JsonMissing.of()
                private var communityRole: JsonField<String> = JsonMissing.of()
                private var profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(creator: Creator) = apply {
                    id = creator.id
                    username = creator.username
                    verified = creator.verified
                    name = creator.name
                    description = creator.description
                    followers = creator.followers
                    following = creator.following
                    isBlueVerified = creator.isBlueVerified
                    isVerified = creator.isVerified
                    profilePicture = creator.profilePicture
                    profilePictureOriginal = creator.profilePictureOriginal
                    coverPicture = creator.coverPicture
                    profileBannerUrl = creator.profileBannerUrl
                    location = creator.location
                    accountBasedIn = creator.accountBasedIn
                    accountBasedInUnavailable = creator.accountBasedInUnavailable
                    accountBasedInAccurate = creator.accountBasedInAccurate
                    connectedVia = creator.connectedVia
                    connectedViaAccurate = creator.connectedViaAccurate
                    affiliateUsername = creator.affiliateUsername
                    email = creator.email
                    contactInfo = creator.contactInfo
                    usernameChanges = creator.usernameChanges
                    birthdate = creator.birthdate
                    retweetedAt = creator.retweetedAt
                    createdAt = creator.createdAt
                    statusesCount = creator.statusesCount
                    mediaCount = creator.mediaCount
                    protected_ = creator.protected_
                    url = creator.url
                    favouritesCount = creator.favouritesCount
                    hasCustomTimelines = creator.hasCustomTimelines
                    isTranslator = creator.isTranslator
                    withheldInCountries = creator.withheldInCountries.map { it.toMutableList() }
                    withheldScope = creator.withheldScope
                    possiblySensitive = creator.possiblySensitive
                    professional = creator.professional
                    grokTranslatedBio = creator.grokTranslatedBio
                    pinnedTweetIds = creator.pinnedTweetIds.map { it.toMutableList() }
                    isAutomated = creator.isAutomated
                    automatedBy = creator.automatedBy
                    unavailable = creator.unavailable
                    unavailableReason = creator.unavailableReason
                    verifiedType = creator.verifiedType
                    affiliatesHighlightedLabel = creator.affiliatesHighlightedLabel
                    businessAccountAffiliatesCount = creator.businessAccountAffiliatesCount
                    creatorSubscriptionsCount = creator.creatorSubscriptionsCount
                    hasGraduatedAccess = creator.hasGraduatedAccess
                    hasHiddenSubscriptionsOnProfile = creator.hasHiddenSubscriptionsOnProfile
                    highlightsInfo = creator.highlightsInfo
                    identityVerification = creator.identityVerification
                    isProfileTranslatable = creator.isProfileTranslatable
                    parodyCommentaryFanLabel = creator.parodyCommentaryFanLabel
                    profileDescriptionLanguage = creator.profileDescriptionLanguage
                    profileImageShape = creator.profileImageShape
                    profileInterstitialType = creator.profileInterstitialType
                    profileSortEnabled = creator.profileSortEnabled
                    profileTranslatorType = creator.profileTranslatorType
                    redirectsToUsername = creator.redirectsToUsername
                    superFollowEligible = creator.superFollowEligible
                    superFollowsUserProfileActive = creator.superFollowsUserProfileActive
                    tipJar = creator.tipJar
                    listedCount = creator.listedCount
                    fastFollowersCount = creator.fastFollowersCount
                    normalFollowersCount = creator.normalFollowersCount
                    defaultProfile = creator.defaultProfile
                    defaultProfileImage = creator.defaultProfileImage
                    hasExtendedProfile = creator.hasExtendedProfile
                    isTranslationEnabled = creator.isTranslationEnabled
                    geoEnabled = creator.geoEnabled
                    advertiserAccountType = creator.advertiserAccountType
                    advertiserAccountServiceLevels =
                        creator.advertiserAccountServiceLevels.map { it.toMutableList() }
                    businessProfileState = creator.businessProfileState
                    subscribersCount = creator.subscribersCount
                    verificationReason = creator.verificationReason
                    communityRole = creator.communityRole
                    profileBio = creator.profileBio
                    additionalProperties = creator.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                fun verified(verified: Boolean) = verified(JsonField.of(verified))

                /** Sets [Builder.verified] to an arbitrary JSON value. */
                fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun followers(followers: Long) = followers(JsonField.of(followers))

                /** Sets [Builder.followers] to an arbitrary JSON value. */
                fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

                fun following(following: Long) = following(JsonField.of(following))

                /** Sets [Builder.following] to an arbitrary JSON value. */
                fun following(following: JsonField<Long>) = apply { this.following = following }

                fun isBlueVerified(isBlueVerified: Boolean) =
                    isBlueVerified(JsonField.of(isBlueVerified))

                /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
                fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                    this.isBlueVerified = isBlueVerified
                }

                fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

                /** Sets [Builder.isVerified] to an arbitrary JSON value. */
                fun isVerified(isVerified: JsonField<Boolean>) = apply {
                    this.isVerified = isVerified
                }

                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                fun coverPicture(coverPicture: String) = coverPicture(JsonField.of(coverPicture))

                /** Sets [Builder.coverPicture] to an arbitrary JSON value. */
                fun coverPicture(coverPicture: JsonField<String>) = apply {
                    this.coverPicture = coverPicture
                }

                fun profileBannerUrl(profileBannerUrl: String) =
                    profileBannerUrl(JsonField.of(profileBannerUrl))

                /** Sets [Builder.profileBannerUrl] to an arbitrary JSON value. */
                fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply {
                    this.profileBannerUrl = profileBannerUrl
                }

                fun location(location: String) = location(JsonField.of(location))

                /** Sets [Builder.location] to an arbitrary JSON value. */
                fun location(location: JsonField<String>) = apply { this.location = location }

                fun accountBasedIn(accountBasedIn: UserProfile.AccountBasedIn?) =
                    accountBasedIn(JsonField.ofNullable(accountBasedIn))

                /**
                 * Alias for calling [Builder.accountBasedIn] with `accountBasedIn.orElse(null)`.
                 */
                fun accountBasedIn(accountBasedIn: Optional<UserProfile.AccountBasedIn>) =
                    accountBasedIn(accountBasedIn.getOrNull())

                /** Sets [Builder.accountBasedIn] to an arbitrary JSON value. */
                fun accountBasedIn(accountBasedIn: JsonField<UserProfile.AccountBasedIn>) = apply {
                    this.accountBasedIn = accountBasedIn
                }

                fun accountBasedInUnavailable(accountBasedInUnavailable: Boolean) =
                    accountBasedInUnavailable(JsonField.of(accountBasedInUnavailable))

                /** Sets [Builder.accountBasedInUnavailable] to an arbitrary JSON value. */
                fun accountBasedInUnavailable(accountBasedInUnavailable: JsonField<Boolean>) =
                    apply {
                        this.accountBasedInUnavailable = accountBasedInUnavailable
                    }

                fun accountBasedInAccurate(accountBasedInAccurate: Boolean) =
                    accountBasedInAccurate(JsonField.of(accountBasedInAccurate))

                /** Sets [Builder.accountBasedInAccurate] to an arbitrary JSON value. */
                fun accountBasedInAccurate(accountBasedInAccurate: JsonField<Boolean>) = apply {
                    this.accountBasedInAccurate = accountBasedInAccurate
                }

                fun connectedVia(connectedVia: String) = connectedVia(JsonField.of(connectedVia))

                /** Sets [Builder.connectedVia] to an arbitrary JSON value. */
                fun connectedVia(connectedVia: JsonField<String>) = apply {
                    this.connectedVia = connectedVia
                }

                fun connectedViaAccurate(connectedViaAccurate: Boolean) =
                    connectedViaAccurate(JsonField.of(connectedViaAccurate))

                /** Sets [Builder.connectedViaAccurate] to an arbitrary JSON value. */
                fun connectedViaAccurate(connectedViaAccurate: JsonField<Boolean>) = apply {
                    this.connectedViaAccurate = connectedViaAccurate
                }

                fun affiliateUsername(affiliateUsername: String) =
                    affiliateUsername(JsonField.of(affiliateUsername))

                /** Sets [Builder.affiliateUsername] to an arbitrary JSON value. */
                fun affiliateUsername(affiliateUsername: JsonField<String>) = apply {
                    this.affiliateUsername = affiliateUsername
                }

                fun email(email: String) = email(JsonField.of(email))

                /** Sets [Builder.email] to an arbitrary JSON value. */
                fun email(email: JsonField<String>) = apply { this.email = email }

                fun contactInfo(contactInfo: UserProfile.ContactInfo) =
                    contactInfo(JsonField.of(contactInfo))

                /** Sets [Builder.contactInfo] to an arbitrary JSON value. */
                fun contactInfo(contactInfo: JsonField<UserProfile.ContactInfo>) = apply {
                    this.contactInfo = contactInfo
                }

                fun usernameChanges(usernameChanges: UserProfile.UsernameChanges) =
                    usernameChanges(JsonField.of(usernameChanges))

                /** Sets [Builder.usernameChanges] to an arbitrary JSON value. */
                fun usernameChanges(usernameChanges: JsonField<UserProfile.UsernameChanges>) =
                    apply {
                        this.usernameChanges = usernameChanges
                    }

                fun birthdate(birthdate: UserProfile.Birthdate) = birthdate(JsonField.of(birthdate))

                /** Sets [Builder.birthdate] to an arbitrary JSON value. */
                fun birthdate(birthdate: JsonField<UserProfile.Birthdate>) = apply {
                    this.birthdate = birthdate
                }

                fun retweetedAt(retweetedAt: OffsetDateTime?) =
                    retweetedAt(JsonField.ofNullable(retweetedAt))

                /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */
                fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) =
                    retweetedAt(retweetedAt.getOrNull())

                /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */
                fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply {
                    this.retweetedAt = retweetedAt
                }

                fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

                /** Sets [Builder.createdAt] to an arbitrary JSON value. */
                fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

                fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

                /** Sets [Builder.statusesCount] to an arbitrary JSON value. */
                fun statusesCount(statusesCount: JsonField<Long>) = apply {
                    this.statusesCount = statusesCount
                }

                fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount))

                /** Sets [Builder.mediaCount] to an arbitrary JSON value. */
                fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount }

                fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

                /** Sets [Builder.protected_] to an arbitrary JSON value. */
                fun protected_(protected_: JsonField<Boolean>) = apply {
                    this.protected_ = protected_
                }

                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun favouritesCount(favouritesCount: Long) =
                    favouritesCount(JsonField.of(favouritesCount))

                /** Sets [Builder.favouritesCount] to an arbitrary JSON value. */
                fun favouritesCount(favouritesCount: JsonField<Long>) = apply {
                    this.favouritesCount = favouritesCount
                }

                fun hasCustomTimelines(hasCustomTimelines: Boolean) =
                    hasCustomTimelines(JsonField.of(hasCustomTimelines))

                /** Sets [Builder.hasCustomTimelines] to an arbitrary JSON value. */
                fun hasCustomTimelines(hasCustomTimelines: JsonField<Boolean>) = apply {
                    this.hasCustomTimelines = hasCustomTimelines
                }

                fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator))

                /** Sets [Builder.isTranslator] to an arbitrary JSON value. */
                fun isTranslator(isTranslator: JsonField<Boolean>) = apply {
                    this.isTranslator = isTranslator
                }

                fun withheldInCountries(withheldInCountries: List<String>) =
                    withheldInCountries(JsonField.of(withheldInCountries))

                /** Sets [Builder.withheldInCountries] to an arbitrary JSON value. */
                fun withheldInCountries(withheldInCountries: JsonField<List<String>>) = apply {
                    this.withheldInCountries = withheldInCountries.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [withheldInCountries].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addWithheldInCountry(withheldInCountry: String) = apply {
                    this.withheldInCountries =
                        (this.withheldInCountries ?: JsonField.of(mutableListOf())).also {
                            checkKnown("withheldInCountries", it).add(withheldInCountry)
                        }
                }

                fun withheldScope(withheldScope: String) =
                    withheldScope(JsonField.of(withheldScope))

                /** Sets [Builder.withheldScope] to an arbitrary JSON value. */
                fun withheldScope(withheldScope: JsonField<String>) = apply {
                    this.withheldScope = withheldScope
                }

                fun possiblySensitive(possiblySensitive: Boolean) =
                    possiblySensitive(JsonField.of(possiblySensitive))

                /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */
                fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
                    this.possiblySensitive = possiblySensitive
                }

                fun professional(professional: UserProfile.Professional) =
                    professional(JsonField.of(professional))

                /** Sets [Builder.professional] to an arbitrary JSON value. */
                fun professional(professional: JsonField<UserProfile.Professional>) = apply {
                    this.professional = professional
                }

                fun grokTranslatedBio(grokTranslatedBio: UserProfile.GrokTranslatedBio) =
                    grokTranslatedBio(JsonField.of(grokTranslatedBio))

                /** Sets [Builder.grokTranslatedBio] to an arbitrary JSON value. */
                fun grokTranslatedBio(grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio>) =
                    apply {
                        this.grokTranslatedBio = grokTranslatedBio
                    }

                fun pinnedTweetIds(pinnedTweetIds: List<String>) =
                    pinnedTweetIds(JsonField.of(pinnedTweetIds))

                /** Sets [Builder.pinnedTweetIds] to an arbitrary JSON value. */
                fun pinnedTweetIds(pinnedTweetIds: JsonField<List<String>>) = apply {
                    this.pinnedTweetIds = pinnedTweetIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [pinnedTweetIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPinnedTweetId(pinnedTweetId: String) = apply {
                    this.pinnedTweetIds =
                        (this.pinnedTweetIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("pinnedTweetIds", it).add(pinnedTweetId)
                        }
                }

                fun isAutomated(isAutomated: Boolean) = isAutomated(JsonField.of(isAutomated))

                /** Sets [Builder.isAutomated] to an arbitrary JSON value. */
                fun isAutomated(isAutomated: JsonField<Boolean>) = apply {
                    this.isAutomated = isAutomated
                }

                fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy))

                /** Sets [Builder.automatedBy] to an arbitrary JSON value. */
                fun automatedBy(automatedBy: JsonField<String>) = apply {
                    this.automatedBy = automatedBy
                }

                fun unavailable(unavailable: Boolean) = unavailable(JsonField.of(unavailable))

                /** Sets [Builder.unavailable] to an arbitrary JSON value. */
                fun unavailable(unavailable: JsonField<Boolean>) = apply {
                    this.unavailable = unavailable
                }

                fun unavailableReason(unavailableReason: String) =
                    unavailableReason(JsonField.of(unavailableReason))

                /** Sets [Builder.unavailableReason] to an arbitrary JSON value. */
                fun unavailableReason(unavailableReason: JsonField<String>) = apply {
                    this.unavailableReason = unavailableReason
                }

                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
                }

                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: UserProfile.AffiliatesHighlightedLabel
                ) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

                /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: JsonField<UserProfile.AffiliatesHighlightedLabel>
                ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

                fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: Long) =
                    businessAccountAffiliatesCount(JsonField.of(businessAccountAffiliatesCount))

                /** Sets [Builder.businessAccountAffiliatesCount] to an arbitrary JSON value. */
                fun businessAccountAffiliatesCount(
                    businessAccountAffiliatesCount: JsonField<Long>
                ) = apply { this.businessAccountAffiliatesCount = businessAccountAffiliatesCount }

                fun creatorSubscriptionsCount(creatorSubscriptionsCount: Long) =
                    creatorSubscriptionsCount(JsonField.of(creatorSubscriptionsCount))

                /** Sets [Builder.creatorSubscriptionsCount] to an arbitrary JSON value. */
                fun creatorSubscriptionsCount(creatorSubscriptionsCount: JsonField<Long>) = apply {
                    this.creatorSubscriptionsCount = creatorSubscriptionsCount
                }

                fun hasGraduatedAccess(hasGraduatedAccess: Boolean) =
                    hasGraduatedAccess(JsonField.of(hasGraduatedAccess))

                /** Sets [Builder.hasGraduatedAccess] to an arbitrary JSON value. */
                fun hasGraduatedAccess(hasGraduatedAccess: JsonField<Boolean>) = apply {
                    this.hasGraduatedAccess = hasGraduatedAccess
                }

                fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: Boolean) =
                    hasHiddenSubscriptionsOnProfile(JsonField.of(hasHiddenSubscriptionsOnProfile))

                /** Sets [Builder.hasHiddenSubscriptionsOnProfile] to an arbitrary JSON value. */
                fun hasHiddenSubscriptionsOnProfile(
                    hasHiddenSubscriptionsOnProfile: JsonField<Boolean>
                ) = apply { this.hasHiddenSubscriptionsOnProfile = hasHiddenSubscriptionsOnProfile }

                fun highlightsInfo(highlightsInfo: UserProfile.HighlightsInfo) =
                    highlightsInfo(JsonField.of(highlightsInfo))

                /** Sets [Builder.highlightsInfo] to an arbitrary JSON value. */
                fun highlightsInfo(highlightsInfo: JsonField<UserProfile.HighlightsInfo>) = apply {
                    this.highlightsInfo = highlightsInfo
                }

                fun identityVerification(identityVerification: UserProfile.IdentityVerification) =
                    identityVerification(JsonField.of(identityVerification))

                /** Sets [Builder.identityVerification] to an arbitrary JSON value. */
                fun identityVerification(
                    identityVerification: JsonField<UserProfile.IdentityVerification>
                ) = apply { this.identityVerification = identityVerification }

                fun isProfileTranslatable(isProfileTranslatable: Boolean) =
                    isProfileTranslatable(JsonField.of(isProfileTranslatable))

                /** Sets [Builder.isProfileTranslatable] to an arbitrary JSON value. */
                fun isProfileTranslatable(isProfileTranslatable: JsonField<Boolean>) = apply {
                    this.isProfileTranslatable = isProfileTranslatable
                }

                fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: String) =
                    parodyCommentaryFanLabel(JsonField.of(parodyCommentaryFanLabel))

                /** Sets [Builder.parodyCommentaryFanLabel] to an arbitrary JSON value. */
                fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: JsonField<String>) = apply {
                    this.parodyCommentaryFanLabel = parodyCommentaryFanLabel
                }

                fun profileDescriptionLanguage(profileDescriptionLanguage: String) =
                    profileDescriptionLanguage(JsonField.of(profileDescriptionLanguage))

                /** Sets [Builder.profileDescriptionLanguage] to an arbitrary JSON value. */
                fun profileDescriptionLanguage(profileDescriptionLanguage: JsonField<String>) =
                    apply {
                        this.profileDescriptionLanguage = profileDescriptionLanguage
                    }

                fun profileImageShape(profileImageShape: String) =
                    profileImageShape(JsonField.of(profileImageShape))

                /** Sets [Builder.profileImageShape] to an arbitrary JSON value. */
                fun profileImageShape(profileImageShape: JsonField<String>) = apply {
                    this.profileImageShape = profileImageShape
                }

                fun profileInterstitialType(profileInterstitialType: String) =
                    profileInterstitialType(JsonField.of(profileInterstitialType))

                /** Sets [Builder.profileInterstitialType] to an arbitrary JSON value. */
                fun profileInterstitialType(profileInterstitialType: JsonField<String>) = apply {
                    this.profileInterstitialType = profileInterstitialType
                }

                fun profileSortEnabled(profileSortEnabled: Boolean) =
                    profileSortEnabled(JsonField.of(profileSortEnabled))

                /** Sets [Builder.profileSortEnabled] to an arbitrary JSON value. */
                fun profileSortEnabled(profileSortEnabled: JsonField<Boolean>) = apply {
                    this.profileSortEnabled = profileSortEnabled
                }

                fun profileTranslatorType(profileTranslatorType: String) =
                    profileTranslatorType(JsonField.of(profileTranslatorType))

                /** Sets [Builder.profileTranslatorType] to an arbitrary JSON value. */
                fun profileTranslatorType(profileTranslatorType: JsonField<String>) = apply {
                    this.profileTranslatorType = profileTranslatorType
                }

                fun redirectsToUsername(redirectsToUsername: String) =
                    redirectsToUsername(JsonField.of(redirectsToUsername))

                /** Sets [Builder.redirectsToUsername] to an arbitrary JSON value. */
                fun redirectsToUsername(redirectsToUsername: JsonField<String>) = apply {
                    this.redirectsToUsername = redirectsToUsername
                }

                fun superFollowEligible(superFollowEligible: Boolean) =
                    superFollowEligible(JsonField.of(superFollowEligible))

                /** Sets [Builder.superFollowEligible] to an arbitrary JSON value. */
                fun superFollowEligible(superFollowEligible: JsonField<Boolean>) = apply {
                    this.superFollowEligible = superFollowEligible
                }

                fun superFollowsUserProfileActive(superFollowsUserProfileActive: Boolean) =
                    superFollowsUserProfileActive(JsonField.of(superFollowsUserProfileActive))

                /** Sets [Builder.superFollowsUserProfileActive] to an arbitrary JSON value. */
                fun superFollowsUserProfileActive(
                    superFollowsUserProfileActive: JsonField<Boolean>
                ) = apply { this.superFollowsUserProfileActive = superFollowsUserProfileActive }

                fun tipJar(tipJar: UserProfile.TipJar) = tipJar(JsonField.of(tipJar))

                /** Sets [Builder.tipJar] to an arbitrary JSON value. */
                fun tipJar(tipJar: JsonField<UserProfile.TipJar>) = apply { this.tipJar = tipJar }

                fun listedCount(listedCount: Long) = listedCount(JsonField.of(listedCount))

                /** Sets [Builder.listedCount] to an arbitrary JSON value. */
                fun listedCount(listedCount: JsonField<Long>) = apply {
                    this.listedCount = listedCount
                }

                fun fastFollowersCount(fastFollowersCount: Long) =
                    fastFollowersCount(JsonField.of(fastFollowersCount))

                /** Sets [Builder.fastFollowersCount] to an arbitrary JSON value. */
                fun fastFollowersCount(fastFollowersCount: JsonField<Long>) = apply {
                    this.fastFollowersCount = fastFollowersCount
                }

                fun normalFollowersCount(normalFollowersCount: Long) =
                    normalFollowersCount(JsonField.of(normalFollowersCount))

                /** Sets [Builder.normalFollowersCount] to an arbitrary JSON value. */
                fun normalFollowersCount(normalFollowersCount: JsonField<Long>) = apply {
                    this.normalFollowersCount = normalFollowersCount
                }

                fun defaultProfile(defaultProfile: Boolean) =
                    defaultProfile(JsonField.of(defaultProfile))

                /** Sets [Builder.defaultProfile] to an arbitrary JSON value. */
                fun defaultProfile(defaultProfile: JsonField<Boolean>) = apply {
                    this.defaultProfile = defaultProfile
                }

                fun defaultProfileImage(defaultProfileImage: Boolean) =
                    defaultProfileImage(JsonField.of(defaultProfileImage))

                /** Sets [Builder.defaultProfileImage] to an arbitrary JSON value. */
                fun defaultProfileImage(defaultProfileImage: JsonField<Boolean>) = apply {
                    this.defaultProfileImage = defaultProfileImage
                }

                fun hasExtendedProfile(hasExtendedProfile: Boolean) =
                    hasExtendedProfile(JsonField.of(hasExtendedProfile))

                /** Sets [Builder.hasExtendedProfile] to an arbitrary JSON value. */
                fun hasExtendedProfile(hasExtendedProfile: JsonField<Boolean>) = apply {
                    this.hasExtendedProfile = hasExtendedProfile
                }

                fun isTranslationEnabled(isTranslationEnabled: Boolean) =
                    isTranslationEnabled(JsonField.of(isTranslationEnabled))

                /** Sets [Builder.isTranslationEnabled] to an arbitrary JSON value. */
                fun isTranslationEnabled(isTranslationEnabled: JsonField<Boolean>) = apply {
                    this.isTranslationEnabled = isTranslationEnabled
                }

                fun geoEnabled(geoEnabled: Boolean) = geoEnabled(JsonField.of(geoEnabled))

                /** Sets [Builder.geoEnabled] to an arbitrary JSON value. */
                fun geoEnabled(geoEnabled: JsonField<Boolean>) = apply {
                    this.geoEnabled = geoEnabled
                }

                fun advertiserAccountType(advertiserAccountType: String) =
                    advertiserAccountType(JsonField.of(advertiserAccountType))

                /** Sets [Builder.advertiserAccountType] to an arbitrary JSON value. */
                fun advertiserAccountType(advertiserAccountType: JsonField<String>) = apply {
                    this.advertiserAccountType = advertiserAccountType
                }

                fun advertiserAccountServiceLevels(advertiserAccountServiceLevels: List<String>) =
                    advertiserAccountServiceLevels(JsonField.of(advertiserAccountServiceLevels))

                /** Sets [Builder.advertiserAccountServiceLevels] to an arbitrary JSON value. */
                fun advertiserAccountServiceLevels(
                    advertiserAccountServiceLevels: JsonField<List<String>>
                ) = apply {
                    this.advertiserAccountServiceLevels = advertiserAccountServiceLevels.map {
                        it.toMutableList()
                    }
                }

                /**
                 * Adds a single [String] to [advertiserAccountServiceLevels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAdvertiserAccountServiceLevel(advertiserAccountServiceLevel: String) =
                    apply {
                        this.advertiserAccountServiceLevels =
                            (this.advertiserAccountServiceLevels ?: JsonField.of(mutableListOf()))
                                .also {
                                    checkKnown("advertiserAccountServiceLevels", it)
                                        .add(advertiserAccountServiceLevel)
                                }
                    }

                fun businessProfileState(businessProfileState: String) =
                    businessProfileState(JsonField.of(businessProfileState))

                /** Sets [Builder.businessProfileState] to an arbitrary JSON value. */
                fun businessProfileState(businessProfileState: JsonField<String>) = apply {
                    this.businessProfileState = businessProfileState
                }

                fun subscribersCount(subscribersCount: Long) =
                    subscribersCount(JsonField.of(subscribersCount))

                /** Sets [Builder.subscribersCount] to an arbitrary JSON value. */
                fun subscribersCount(subscribersCount: JsonField<Long>) = apply {
                    this.subscribersCount = subscribersCount
                }

                fun verificationReason(verificationReason: UserProfile.VerificationReason) =
                    verificationReason(JsonField.of(verificationReason))

                /** Sets [Builder.verificationReason] to an arbitrary JSON value. */
                fun verificationReason(
                    verificationReason: JsonField<UserProfile.VerificationReason>
                ) = apply { this.verificationReason = verificationReason }

                fun communityRole(communityRole: String) =
                    communityRole(JsonField.of(communityRole))

                /** Sets [Builder.communityRole] to an arbitrary JSON value. */
                fun communityRole(communityRole: JsonField<String>) = apply {
                    this.communityRole = communityRole
                }

                fun profileBio(profileBio: UserProfile.ProfileBio) =
                    profileBio(JsonField.of(profileBio))

                /** Sets [Builder.profileBio] to an arbitrary JSON value. */
                fun profileBio(profileBio: JsonField<UserProfile.ProfileBio>) = apply {
                    this.profileBio = profileBio
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
                 * Returns an immutable instance of [Creator].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .username()
                 * .verified()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Creator =
                    Creator(
                        checkRequired("id", id),
                        checkRequired("username", username),
                        checkRequired("verified", verified),
                        name,
                        description,
                        followers,
                        following,
                        isBlueVerified,
                        isVerified,
                        profilePicture,
                        profilePictureOriginal,
                        coverPicture,
                        profileBannerUrl,
                        location,
                        accountBasedIn,
                        accountBasedInUnavailable,
                        accountBasedInAccurate,
                        connectedVia,
                        connectedViaAccurate,
                        affiliateUsername,
                        email,
                        contactInfo,
                        usernameChanges,
                        birthdate,
                        retweetedAt,
                        createdAt,
                        statusesCount,
                        mediaCount,
                        protected_,
                        url,
                        favouritesCount,
                        hasCustomTimelines,
                        isTranslator,
                        (withheldInCountries ?: JsonMissing.of()).map { it.toImmutable() },
                        withheldScope,
                        possiblySensitive,
                        professional,
                        grokTranslatedBio,
                        (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                        isAutomated,
                        automatedBy,
                        unavailable,
                        unavailableReason,
                        verifiedType,
                        affiliatesHighlightedLabel,
                        businessAccountAffiliatesCount,
                        creatorSubscriptionsCount,
                        hasGraduatedAccess,
                        hasHiddenSubscriptionsOnProfile,
                        highlightsInfo,
                        identityVerification,
                        isProfileTranslatable,
                        parodyCommentaryFanLabel,
                        profileDescriptionLanguage,
                        profileImageShape,
                        profileInterstitialType,
                        profileSortEnabled,
                        profileTranslatorType,
                        redirectsToUsername,
                        superFollowEligible,
                        superFollowsUserProfileActive,
                        tipJar,
                        listedCount,
                        fastFollowersCount,
                        normalFollowersCount,
                        defaultProfile,
                        defaultProfileImage,
                        hasExtendedProfile,
                        isTranslationEnabled,
                        geoEnabled,
                        advertiserAccountType,
                        (advertiserAccountServiceLevels ?: JsonMissing.of()).map {
                            it.toImmutable()
                        },
                        businessProfileState,
                        subscribersCount,
                        verificationReason,
                        communityRole,
                        profileBio,
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
            fun validate(): Creator = apply {
                if (validated) {
                    return@apply
                }

                id()
                username()
                verified()
                name()
                description()
                followers()
                following()
                isBlueVerified()
                isVerified()
                profilePicture()
                profilePictureOriginal()
                coverPicture()
                profileBannerUrl()
                location()
                accountBasedIn().ifPresent { it.validate() }
                accountBasedInUnavailable()
                accountBasedInAccurate()
                connectedVia()
                connectedViaAccurate()
                affiliateUsername()
                email()
                contactInfo().ifPresent { it.validate() }
                usernameChanges().ifPresent { it.validate() }
                birthdate().ifPresent { it.validate() }
                retweetedAt()
                createdAt()
                statusesCount()
                mediaCount()
                protected_()
                url()
                favouritesCount()
                hasCustomTimelines()
                isTranslator()
                withheldInCountries()
                withheldScope()
                possiblySensitive()
                professional().ifPresent { it.validate() }
                grokTranslatedBio().ifPresent { it.validate() }
                pinnedTweetIds()
                isAutomated()
                automatedBy()
                unavailable()
                unavailableReason()
                verifiedType()
                affiliatesHighlightedLabel().ifPresent { it.validate() }
                businessAccountAffiliatesCount()
                creatorSubscriptionsCount()
                hasGraduatedAccess()
                hasHiddenSubscriptionsOnProfile()
                highlightsInfo().ifPresent { it.validate() }
                identityVerification().ifPresent { it.validate() }
                isProfileTranslatable()
                parodyCommentaryFanLabel()
                profileDescriptionLanguage()
                profileImageShape()
                profileInterstitialType()
                profileSortEnabled()
                profileTranslatorType()
                redirectsToUsername()
                superFollowEligible()
                superFollowsUserProfileActive()
                tipJar().ifPresent { it.validate() }
                listedCount()
                fastFollowersCount()
                normalFollowersCount()
                defaultProfile()
                defaultProfileImage()
                hasExtendedProfile()
                isTranslationEnabled()
                geoEnabled()
                advertiserAccountType()
                advertiserAccountServiceLevels()
                businessProfileState()
                subscribersCount()
                verificationReason().ifPresent { it.validate() }
                communityRole()
                profileBio().ifPresent { it.validate() }
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (if (verified.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (followers.asKnown().isPresent) 1 else 0) +
                    (if (following.asKnown().isPresent) 1 else 0) +
                    (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                    (if (isVerified.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (coverPicture.asKnown().isPresent) 1 else 0) +
                    (if (profileBannerUrl.asKnown().isPresent) 1 else 0) +
                    (if (location.asKnown().isPresent) 1 else 0) +
                    (accountBasedIn.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (accountBasedInUnavailable.asKnown().isPresent) 1 else 0) +
                    (if (accountBasedInAccurate.asKnown().isPresent) 1 else 0) +
                    (if (connectedVia.asKnown().isPresent) 1 else 0) +
                    (if (connectedViaAccurate.asKnown().isPresent) 1 else 0) +
                    (if (affiliateUsername.asKnown().isPresent) 1 else 0) +
                    (if (email.asKnown().isPresent) 1 else 0) +
                    (contactInfo.asKnown().getOrNull()?.validity() ?: 0) +
                    (usernameChanges.asKnown().getOrNull()?.validity() ?: 0) +
                    (birthdate.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (retweetedAt.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (statusesCount.asKnown().isPresent) 1 else 0) +
                    (if (mediaCount.asKnown().isPresent) 1 else 0) +
                    (if (protected_.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (favouritesCount.asKnown().isPresent) 1 else 0) +
                    (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) +
                    (if (isTranslator.asKnown().isPresent) 1 else 0) +
                    (if (withheldInCountries.asKnown().isPresent) 1 else 0) +
                    (if (withheldScope.asKnown().isPresent) 1 else 0) +
                    (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
                    (professional.asKnown().getOrNull()?.validity() ?: 0) +
                    (grokTranslatedBio.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (pinnedTweetIds.asKnown().isPresent) 1 else 0) +
                    (if (isAutomated.asKnown().isPresent) 1 else 0) +
                    (if (automatedBy.asKnown().isPresent) 1 else 0) +
                    (if (unavailable.asKnown().isPresent) 1 else 0) +
                    (if (unavailableReason.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0) +
                    (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (businessAccountAffiliatesCount.asKnown().isPresent) 1 else 0) +
                    (if (creatorSubscriptionsCount.asKnown().isPresent) 1 else 0) +
                    (if (hasGraduatedAccess.asKnown().isPresent) 1 else 0) +
                    (if (hasHiddenSubscriptionsOnProfile.asKnown().isPresent) 1 else 0) +
                    (highlightsInfo.asKnown().getOrNull()?.validity() ?: 0) +
                    (identityVerification.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isProfileTranslatable.asKnown().isPresent) 1 else 0) +
                    (if (parodyCommentaryFanLabel.asKnown().isPresent) 1 else 0) +
                    (if (profileDescriptionLanguage.asKnown().isPresent) 1 else 0) +
                    (if (profileImageShape.asKnown().isPresent) 1 else 0) +
                    (if (profileInterstitialType.asKnown().isPresent) 1 else 0) +
                    (if (profileSortEnabled.asKnown().isPresent) 1 else 0) +
                    (if (profileTranslatorType.asKnown().isPresent) 1 else 0) +
                    (if (redirectsToUsername.asKnown().isPresent) 1 else 0) +
                    (if (superFollowEligible.asKnown().isPresent) 1 else 0) +
                    (if (superFollowsUserProfileActive.asKnown().isPresent) 1 else 0) +
                    (tipJar.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (listedCount.asKnown().isPresent) 1 else 0) +
                    (if (fastFollowersCount.asKnown().isPresent) 1 else 0) +
                    (if (normalFollowersCount.asKnown().isPresent) 1 else 0) +
                    (if (defaultProfile.asKnown().isPresent) 1 else 0) +
                    (if (defaultProfileImage.asKnown().isPresent) 1 else 0) +
                    (if (hasExtendedProfile.asKnown().isPresent) 1 else 0) +
                    (if (isTranslationEnabled.asKnown().isPresent) 1 else 0) +
                    (if (geoEnabled.asKnown().isPresent) 1 else 0) +
                    (if (advertiserAccountType.asKnown().isPresent) 1 else 0) +
                    (if (advertiserAccountServiceLevels.asKnown().isPresent) 1 else 0) +
                    (if (businessProfileState.asKnown().isPresent) 1 else 0) +
                    (if (subscribersCount.asKnown().isPresent) 1 else 0) +
                    (verificationReason.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (communityRole.asKnown().isPresent) 1 else 0) +
                    (profileBio.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Creator &&
                    id == other.id &&
                    username == other.username &&
                    verified == other.verified &&
                    name == other.name &&
                    description == other.description &&
                    followers == other.followers &&
                    following == other.following &&
                    isBlueVerified == other.isBlueVerified &&
                    isVerified == other.isVerified &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    coverPicture == other.coverPicture &&
                    profileBannerUrl == other.profileBannerUrl &&
                    location == other.location &&
                    accountBasedIn == other.accountBasedIn &&
                    accountBasedInUnavailable == other.accountBasedInUnavailable &&
                    accountBasedInAccurate == other.accountBasedInAccurate &&
                    connectedVia == other.connectedVia &&
                    connectedViaAccurate == other.connectedViaAccurate &&
                    affiliateUsername == other.affiliateUsername &&
                    email == other.email &&
                    contactInfo == other.contactInfo &&
                    usernameChanges == other.usernameChanges &&
                    birthdate == other.birthdate &&
                    retweetedAt == other.retweetedAt &&
                    createdAt == other.createdAt &&
                    statusesCount == other.statusesCount &&
                    mediaCount == other.mediaCount &&
                    protected_ == other.protected_ &&
                    url == other.url &&
                    favouritesCount == other.favouritesCount &&
                    hasCustomTimelines == other.hasCustomTimelines &&
                    isTranslator == other.isTranslator &&
                    withheldInCountries == other.withheldInCountries &&
                    withheldScope == other.withheldScope &&
                    possiblySensitive == other.possiblySensitive &&
                    professional == other.professional &&
                    grokTranslatedBio == other.grokTranslatedBio &&
                    pinnedTweetIds == other.pinnedTweetIds &&
                    isAutomated == other.isAutomated &&
                    automatedBy == other.automatedBy &&
                    unavailable == other.unavailable &&
                    unavailableReason == other.unavailableReason &&
                    verifiedType == other.verifiedType &&
                    affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
                    businessAccountAffiliatesCount == other.businessAccountAffiliatesCount &&
                    creatorSubscriptionsCount == other.creatorSubscriptionsCount &&
                    hasGraduatedAccess == other.hasGraduatedAccess &&
                    hasHiddenSubscriptionsOnProfile == other.hasHiddenSubscriptionsOnProfile &&
                    highlightsInfo == other.highlightsInfo &&
                    identityVerification == other.identityVerification &&
                    isProfileTranslatable == other.isProfileTranslatable &&
                    parodyCommentaryFanLabel == other.parodyCommentaryFanLabel &&
                    profileDescriptionLanguage == other.profileDescriptionLanguage &&
                    profileImageShape == other.profileImageShape &&
                    profileInterstitialType == other.profileInterstitialType &&
                    profileSortEnabled == other.profileSortEnabled &&
                    profileTranslatorType == other.profileTranslatorType &&
                    redirectsToUsername == other.redirectsToUsername &&
                    superFollowEligible == other.superFollowEligible &&
                    superFollowsUserProfileActive == other.superFollowsUserProfileActive &&
                    tipJar == other.tipJar &&
                    listedCount == other.listedCount &&
                    fastFollowersCount == other.fastFollowersCount &&
                    normalFollowersCount == other.normalFollowersCount &&
                    defaultProfile == other.defaultProfile &&
                    defaultProfileImage == other.defaultProfileImage &&
                    hasExtendedProfile == other.hasExtendedProfile &&
                    isTranslationEnabled == other.isTranslationEnabled &&
                    geoEnabled == other.geoEnabled &&
                    advertiserAccountType == other.advertiserAccountType &&
                    advertiserAccountServiceLevels == other.advertiserAccountServiceLevels &&
                    businessProfileState == other.businessProfileState &&
                    subscribersCount == other.subscribersCount &&
                    verificationReason == other.verificationReason &&
                    communityRole == other.communityRole &&
                    profileBio == other.profileBio &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    username,
                    verified,
                    name,
                    description,
                    followers,
                    following,
                    isBlueVerified,
                    isVerified,
                    profilePicture,
                    profilePictureOriginal,
                    coverPicture,
                    profileBannerUrl,
                    location,
                    accountBasedIn,
                    accountBasedInUnavailable,
                    accountBasedInAccurate,
                    connectedVia,
                    connectedViaAccurate,
                    affiliateUsername,
                    email,
                    contactInfo,
                    usernameChanges,
                    birthdate,
                    retweetedAt,
                    createdAt,
                    statusesCount,
                    mediaCount,
                    protected_,
                    url,
                    favouritesCount,
                    hasCustomTimelines,
                    isTranslator,
                    withheldInCountries,
                    withheldScope,
                    possiblySensitive,
                    professional,
                    grokTranslatedBio,
                    pinnedTweetIds,
                    isAutomated,
                    automatedBy,
                    unavailable,
                    unavailableReason,
                    verifiedType,
                    affiliatesHighlightedLabel,
                    businessAccountAffiliatesCount,
                    creatorSubscriptionsCount,
                    hasGraduatedAccess,
                    hasHiddenSubscriptionsOnProfile,
                    highlightsInfo,
                    identityVerification,
                    isProfileTranslatable,
                    parodyCommentaryFanLabel,
                    profileDescriptionLanguage,
                    profileImageShape,
                    profileInterstitialType,
                    profileSortEnabled,
                    profileTranslatorType,
                    redirectsToUsername,
                    superFollowEligible,
                    superFollowsUserProfileActive,
                    tipJar,
                    listedCount,
                    fastFollowersCount,
                    normalFollowersCount,
                    defaultProfile,
                    defaultProfileImage,
                    hasExtendedProfile,
                    isTranslationEnabled,
                    geoEnabled,
                    advertiserAccountType,
                    advertiserAccountServiceLevels,
                    businessProfileState,
                    subscribersCount,
                    verificationReason,
                    communityRole,
                    profileBio,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Creator{id=$id, username=$username, verified=$verified, name=$name, description=$description, followers=$followers, following=$following, isBlueVerified=$isBlueVerified, isVerified=$isVerified, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, coverPicture=$coverPicture, profileBannerUrl=$profileBannerUrl, location=$location, accountBasedIn=$accountBasedIn, accountBasedInUnavailable=$accountBasedInUnavailable, accountBasedInAccurate=$accountBasedInAccurate, connectedVia=$connectedVia, connectedViaAccurate=$connectedViaAccurate, affiliateUsername=$affiliateUsername, email=$email, contactInfo=$contactInfo, usernameChanges=$usernameChanges, birthdate=$birthdate, retweetedAt=$retweetedAt, createdAt=$createdAt, statusesCount=$statusesCount, mediaCount=$mediaCount, protected_=$protected_, url=$url, favouritesCount=$favouritesCount, hasCustomTimelines=$hasCustomTimelines, isTranslator=$isTranslator, withheldInCountries=$withheldInCountries, withheldScope=$withheldScope, possiblySensitive=$possiblySensitive, professional=$professional, grokTranslatedBio=$grokTranslatedBio, pinnedTweetIds=$pinnedTweetIds, isAutomated=$isAutomated, automatedBy=$automatedBy, unavailable=$unavailable, unavailableReason=$unavailableReason, verifiedType=$verifiedType, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, businessAccountAffiliatesCount=$businessAccountAffiliatesCount, creatorSubscriptionsCount=$creatorSubscriptionsCount, hasGraduatedAccess=$hasGraduatedAccess, hasHiddenSubscriptionsOnProfile=$hasHiddenSubscriptionsOnProfile, highlightsInfo=$highlightsInfo, identityVerification=$identityVerification, isProfileTranslatable=$isProfileTranslatable, parodyCommentaryFanLabel=$parodyCommentaryFanLabel, profileDescriptionLanguage=$profileDescriptionLanguage, profileImageShape=$profileImageShape, profileInterstitialType=$profileInterstitialType, profileSortEnabled=$profileSortEnabled, profileTranslatorType=$profileTranslatorType, redirectsToUsername=$redirectsToUsername, superFollowEligible=$superFollowEligible, superFollowsUserProfileActive=$superFollowsUserProfileActive, tipJar=$tipJar, listedCount=$listedCount, fastFollowersCount=$fastFollowersCount, normalFollowersCount=$normalFollowersCount, defaultProfile=$defaultProfile, defaultProfileImage=$defaultProfileImage, hasExtendedProfile=$hasExtendedProfile, isTranslationEnabled=$isTranslationEnabled, geoEnabled=$geoEnabled, advertiserAccountType=$advertiserAccountType, advertiserAccountServiceLevels=$advertiserAccountServiceLevels, businessProfileState=$businessProfileState, subscribersCount=$subscribersCount, verificationReason=$verificationReason, communityRole=$communityRole, profileBio=$profileBio, additionalProperties=$additionalProperties}"
        }

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
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
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

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
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
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
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

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
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
                creator == other.creator &&
                description == other.description &&
                invitesPolicy == other.invitesPolicy &&
                isNsfw == other.isNsfw &&
                joinPolicy == other.joinPolicy &&
                memberCount == other.memberCount &&
                moderatorCount == other.moderatorCount &&
                name == other.name &&
                primaryTopic == other.primaryTopic &&
                rules == other.rules &&
                question == other.question &&
                searchTags == other.searchTags &&
                admin == other.admin &&
                membersFacepile == other.membersFacepile &&
                banner == other.banner &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bannerUrl,
                createdAt,
                creator,
                description,
                invitesPolicy,
                isNsfw,
                joinPolicy,
                memberCount,
                moderatorCount,
                name,
                primaryTopic,
                rules,
                question,
                searchTags,
                admin,
                membersFacepile,
                banner,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Community{id=$id, bannerUrl=$bannerUrl, createdAt=$createdAt, creator=$creator, description=$description, invitesPolicy=$invitesPolicy, isNsfw=$isNsfw, joinPolicy=$joinPolicy, memberCount=$memberCount, moderatorCount=$moderatorCount, name=$name, primaryTopic=$primaryTopic, rules=$rules, question=$question, searchTags=$searchTags, admin=$admin, membersFacepile=$membersFacepile, banner=$banner, additionalProperties=$additionalProperties}"
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
