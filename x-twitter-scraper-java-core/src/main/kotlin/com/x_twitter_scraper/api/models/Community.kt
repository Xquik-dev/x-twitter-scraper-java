// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Public X Community, as every Community read returns it. */
class Community
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val isNsfw: JsonField<Boolean>,
    private val memberCount: JsonField<Long>,
    private val name: JsonField<String>,
    private val admin: JsonField<UserProfile>,
    private val banner: JsonField<Banner>,
    private val bannerUrl: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val creator: JsonField<Creator>,
    private val description: JsonField<String>,
    private val invitesPolicy: JsonField<String>,
    private val joinPolicy: JsonField<String>,
    private val membersFacepile: JsonField<List<MembersFacepile>>,
    private val moderatorCount: JsonField<Long>,
    private val primaryTopic: JsonField<PrimaryTopic>,
    private val question: JsonField<String>,
    private val rules: JsonField<List<Rule>>,
    private val searchTags: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_nsfw") @ExcludeMissing isNsfw: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("member_count")
        @ExcludeMissing
        memberCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("admin") @ExcludeMissing admin: JsonField<UserProfile> = JsonMissing.of(),
        @JsonProperty("banner") @ExcludeMissing banner: JsonField<Banner> = JsonMissing.of(),
        @JsonProperty("banner_url") @ExcludeMissing bannerUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("creator") @ExcludeMissing creator: JsonField<Creator> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("invites_policy")
        @ExcludeMissing
        invitesPolicy: JsonField<String> = JsonMissing.of(),
        @JsonProperty("join_policy")
        @ExcludeMissing
        joinPolicy: JsonField<String> = JsonMissing.of(),
        @JsonProperty("membersFacepile")
        @ExcludeMissing
        membersFacepile: JsonField<List<MembersFacepile>> = JsonMissing.of(),
        @JsonProperty("moderator_count")
        @ExcludeMissing
        moderatorCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("primary_topic")
        @ExcludeMissing
        primaryTopic: JsonField<PrimaryTopic> = JsonMissing.of(),
        @JsonProperty("question") @ExcludeMissing question: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rules") @ExcludeMissing rules: JsonField<List<Rule>> = JsonMissing.of(),
        @JsonProperty("searchTags")
        @ExcludeMissing
        searchTags: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        isNsfw,
        memberCount,
        name,
        admin,
        banner,
        bannerUrl,
        createdAt,
        creator,
        description,
        invitesPolicy,
        joinPolicy,
        membersFacepile,
        moderatorCount,
        primaryTopic,
        question,
        rules,
        searchTags,
        mutableMapOf(),
    )

    /**
     * Unique community identifier
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * Whether the community is marked sensitive
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun isNsfw(): Boolean = isNsfw.getRequired("is_nsfw")

    /**
     * Total member count
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun memberCount(): Long = memberCount.getRequired("member_count")

    /**
     * Display name of the community
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun name(): String = name.getRequired("name")

    /**
     * Public X profile.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun admin(): Optional<UserProfile> = admin.getOptional("admin")

    /**
     * The banner X shows for a community, with its size & colors.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun banner(): Optional<Banner> = banner.getOptional("banner")

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

    /**
     * The creator's public profile, or the ID, username and badge alone when X sends no profile
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
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
     * Join policy (open or restricted)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun joinPolicy(): Optional<String> = joinPolicy.getOptional("join_policy")

    /**
     * The members X previews beside the member count. A keyword or topic result gives each member's
     * ID & picture only.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun membersFacepile(): Optional<List<MembersFacepile>> =
        membersFacepile.getOptional("membersFacepile")

    /**
     * Total moderator count
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun moderatorCount(): Optional<Long> = moderatorCount.getOptional("moderator_count")

    /**
     * Primary topic. Its id is absent when X lists the community in a keyword or topic result.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun primaryTopic(): Optional<PrimaryTopic> = primaryTopic.getOptional("primary_topic")

    /**
     * What the community asks a user who joins
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun question(): Optional<String> = question.getOptional("question")

    /**
     * Community rules
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun rules(): Optional<List<Rule>> = rules.getOptional("rules")

    /**
     * Tags X finds the community by
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun searchTags(): Optional<List<String>> = searchTags.getOptional("searchTags")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [isNsfw].
     *
     * Unlike [isNsfw], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_nsfw") @ExcludeMissing fun _isNsfw(): JsonField<Boolean> = isNsfw

    /**
     * Returns the raw JSON value of [memberCount].
     *
     * Unlike [memberCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("member_count") @ExcludeMissing fun _memberCount(): JsonField<Long> = memberCount

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [admin].
     *
     * Unlike [admin], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("admin") @ExcludeMissing fun _admin(): JsonField<UserProfile> = admin

    /**
     * Returns the raw JSON value of [banner].
     *
     * Unlike [banner], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("banner") @ExcludeMissing fun _banner(): JsonField<Banner> = banner

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
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [invitesPolicy].
     *
     * Unlike [invitesPolicy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invites_policy")
    @ExcludeMissing
    fun _invitesPolicy(): JsonField<String> = invitesPolicy

    /**
     * Returns the raw JSON value of [joinPolicy].
     *
     * Unlike [joinPolicy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("join_policy") @ExcludeMissing fun _joinPolicy(): JsonField<String> = joinPolicy

    /**
     * Returns the raw JSON value of [membersFacepile].
     *
     * Unlike [membersFacepile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("membersFacepile")
    @ExcludeMissing
    fun _membersFacepile(): JsonField<List<MembersFacepile>> = membersFacepile

    /**
     * Returns the raw JSON value of [moderatorCount].
     *
     * Unlike [moderatorCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("moderator_count")
    @ExcludeMissing
    fun _moderatorCount(): JsonField<Long> = moderatorCount

    /**
     * Returns the raw JSON value of [primaryTopic].
     *
     * Unlike [primaryTopic], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("primary_topic")
    @ExcludeMissing
    fun _primaryTopic(): JsonField<PrimaryTopic> = primaryTopic

    /**
     * Returns the raw JSON value of [question].
     *
     * Unlike [question], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("question") @ExcludeMissing fun _question(): JsonField<String> = question

    /**
     * Returns the raw JSON value of [rules].
     *
     * Unlike [rules], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rules") @ExcludeMissing fun _rules(): JsonField<List<Rule>> = rules

    /**
     * Returns the raw JSON value of [searchTags].
     *
     * Unlike [searchTags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("searchTags")
    @ExcludeMissing
    fun _searchTags(): JsonField<List<String>> = searchTags

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
         * .isNsfw()
         * .memberCount()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Community]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var isNsfw: JsonField<Boolean>? = null
        private var memberCount: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var admin: JsonField<UserProfile> = JsonMissing.of()
        private var banner: JsonField<Banner> = JsonMissing.of()
        private var bannerUrl: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var creator: JsonField<Creator> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var invitesPolicy: JsonField<String> = JsonMissing.of()
        private var joinPolicy: JsonField<String> = JsonMissing.of()
        private var membersFacepile: JsonField<MutableList<MembersFacepile>>? = null
        private var moderatorCount: JsonField<Long> = JsonMissing.of()
        private var primaryTopic: JsonField<PrimaryTopic> = JsonMissing.of()
        private var question: JsonField<String> = JsonMissing.of()
        private var rules: JsonField<MutableList<Rule>>? = null
        private var searchTags: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(community: Community) = apply {
            id = community.id
            isNsfw = community.isNsfw
            memberCount = community.memberCount
            name = community.name
            admin = community.admin
            banner = community.banner
            bannerUrl = community.bannerUrl
            createdAt = community.createdAt
            creator = community.creator
            description = community.description
            invitesPolicy = community.invitesPolicy
            joinPolicy = community.joinPolicy
            membersFacepile = community.membersFacepile.map { it.toMutableList() }
            moderatorCount = community.moderatorCount
            primaryTopic = community.primaryTopic
            question = community.question
            rules = community.rules.map { it.toMutableList() }
            searchTags = community.searchTags.map { it.toMutableList() }
            additionalProperties = community.additionalProperties.toMutableMap()
        }

        /** Unique community identifier */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Whether the community is marked sensitive */
        fun isNsfw(isNsfw: Boolean) = isNsfw(JsonField.of(isNsfw))

        /** Sets [Builder.isNsfw] to an arbitrary JSON value. */
        fun isNsfw(isNsfw: JsonField<Boolean>) = apply { this.isNsfw = isNsfw }

        /** Total member count */
        fun memberCount(memberCount: Long) = memberCount(JsonField.of(memberCount))

        /** Sets [Builder.memberCount] to an arbitrary JSON value. */
        fun memberCount(memberCount: JsonField<Long>) = apply { this.memberCount = memberCount }

        /** Display name of the community */
        fun name(name: String) = name(JsonField.of(name))

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Public X profile. */
        fun admin(admin: UserProfile) = admin(JsonField.of(admin))

        /** Sets [Builder.admin] to an arbitrary JSON value. */
        fun admin(admin: JsonField<UserProfile>) = apply { this.admin = admin }

        /** The banner X shows for a community, with its size & colors. */
        fun banner(banner: Banner) = banner(JsonField.of(banner))

        /** Sets [Builder.banner] to an arbitrary JSON value. */
        fun banner(banner: JsonField<Banner>) = apply { this.banner = banner }

        /** Community banner image URL */
        fun bannerUrl(bannerUrl: String) = bannerUrl(JsonField.of(bannerUrl))

        /** Sets [Builder.bannerUrl] to an arbitrary JSON value. */
        fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

        /** Community creation timestamp */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /** Sets [Builder.createdAt] to an arbitrary JSON value. */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /**
         * The creator's public profile, or the ID, username and badge alone when X sends no profile
         */
        fun creator(creator: Creator) = creator(JsonField.of(creator))

        /** Sets [Builder.creator] to an arbitrary JSON value. */
        fun creator(creator: JsonField<Creator>) = apply { this.creator = creator }

        /** Alias for calling [creator] with `Creator.ofUserProfile(userProfile)`. */
        fun creator(userProfile: UserProfile) = creator(Creator.ofUserProfile(userProfile))

        /** Alias for calling [creator] with `Creator.ofUnionMember1(unionMember1)`. */
        fun creator(unionMember1: Creator.UnionMember1) =
            creator(Creator.ofUnionMember1(unionMember1))

        /** About text for the community */
        fun description(description: String) = description(JsonField.of(description))

        /** Sets [Builder.description] to an arbitrary JSON value. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Invitation policy */
        fun invitesPolicy(invitesPolicy: String) = invitesPolicy(JsonField.of(invitesPolicy))

        /** Sets [Builder.invitesPolicy] to an arbitrary JSON value. */
        fun invitesPolicy(invitesPolicy: JsonField<String>) = apply {
            this.invitesPolicy = invitesPolicy
        }

        /** Join policy (open or restricted) */
        fun joinPolicy(joinPolicy: String) = joinPolicy(JsonField.of(joinPolicy))

        /** Sets [Builder.joinPolicy] to an arbitrary JSON value. */
        fun joinPolicy(joinPolicy: JsonField<String>) = apply { this.joinPolicy = joinPolicy }

        /**
         * The members X previews beside the member count. A keyword or topic result gives each
         * member's ID & picture only.
         */
        fun membersFacepile(membersFacepile: List<MembersFacepile>) =
            membersFacepile(JsonField.of(membersFacepile))

        /** Sets [Builder.membersFacepile] to an arbitrary JSON value. */
        fun membersFacepile(membersFacepile: JsonField<List<MembersFacepile>>) = apply {
            this.membersFacepile = membersFacepile.map { it.toMutableList() }
        }

        /**
         * Adds a single [MembersFacepile] to [membersFacepile].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMembersFacepile(membersFacepile: MembersFacepile) = apply {
            this.membersFacepile =
                (this.membersFacepile ?: JsonField.of(mutableListOf())).also {
                    checkKnown("membersFacepile", it).add(membersFacepile)
                }
        }

        /**
         * Alias for calling [addMembersFacepile] with `MembersFacepile.ofUserProfile(userProfile)`.
         */
        fun addMembersFacepile(userProfile: UserProfile) =
            addMembersFacepile(MembersFacepile.ofUserProfile(userProfile))

        /**
         * Alias for calling [addMembersFacepile] with
         * `MembersFacepile.ofCommunityMemberPreview(communityMemberPreview)`.
         */
        fun addMembersFacepile(communityMemberPreview: MembersFacepile.CommunityMemberPreview) =
            addMembersFacepile(MembersFacepile.ofCommunityMemberPreview(communityMemberPreview))

        /** Total moderator count */
        fun moderatorCount(moderatorCount: Long) = moderatorCount(JsonField.of(moderatorCount))

        /** Sets [Builder.moderatorCount] to an arbitrary JSON value. */
        fun moderatorCount(moderatorCount: JsonField<Long>) = apply {
            this.moderatorCount = moderatorCount
        }

        /**
         * Primary topic. Its id is absent when X lists the community in a keyword or topic result.
         */
        fun primaryTopic(primaryTopic: PrimaryTopic) = primaryTopic(JsonField.of(primaryTopic))

        /** Sets [Builder.primaryTopic] to an arbitrary JSON value. */
        fun primaryTopic(primaryTopic: JsonField<PrimaryTopic>) = apply {
            this.primaryTopic = primaryTopic
        }

        /** What the community asks a user who joins */
        fun question(question: String) = question(JsonField.of(question))

        /** Sets [Builder.question] to an arbitrary JSON value. */
        fun question(question: JsonField<String>) = apply { this.question = question }

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
                (rules ?: JsonField.of(mutableListOf())).also { checkKnown("rules", it).add(rule) }
        }

        /** Tags X finds the community by */
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
            searchTags =
                (searchTags ?: JsonField.of(mutableListOf())).also {
                    checkKnown("searchTags", it).add(searchTag)
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
         * .isNsfw()
         * .memberCount()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Community =
            Community(
                checkRequired("id", id),
                checkRequired("isNsfw", isNsfw),
                checkRequired("memberCount", memberCount),
                checkRequired("name", name),
                admin,
                banner,
                bannerUrl,
                createdAt,
                creator,
                description,
                invitesPolicy,
                joinPolicy,
                (membersFacepile ?: JsonMissing.of()).map { it.toImmutable() },
                moderatorCount,
                primaryTopic,
                question,
                (rules ?: JsonMissing.of()).map { it.toImmutable() },
                (searchTags ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): Community = apply {
        if (validated) {
            return@apply
        }

        id()
        isNsfw()
        memberCount()
        name()
        admin().ifPresent { it.validate() }
        banner().ifPresent { it.validate() }
        bannerUrl()
        createdAt()
        creator().ifPresent { it.validate() }
        description()
        invitesPolicy()
        joinPolicy()
        membersFacepile().ifPresent { it.forEach { it.validate() } }
        moderatorCount()
        primaryTopic().ifPresent { it.validate() }
        question()
        rules().ifPresent { it.forEach { it.validate() } }
        searchTags()
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
            (if (isNsfw.asKnown().isPresent) 1 else 0) +
            (if (memberCount.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (admin.asKnown().getOrNull()?.validity() ?: 0) +
            (banner.asKnown().getOrNull()?.validity() ?: 0) +
            (if (bannerUrl.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (creator.asKnown().getOrNull()?.validity() ?: 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (invitesPolicy.asKnown().isPresent) 1 else 0) +
            (if (joinPolicy.asKnown().isPresent) 1 else 0) +
            (membersFacepile.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (moderatorCount.asKnown().isPresent) 1 else 0) +
            (primaryTopic.asKnown().getOrNull()?.validity() ?: 0) +
            (if (question.asKnown().isPresent) 1 else 0) +
            (rules.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (searchTags.asKnown().getOrNull()?.size ?: 0)

    /** The banner X shows for a community, with its size & colors. */
    class Banner
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val colors: JsonField<List<Color>>,
        private val focus: JsonField<Focus>,
        private val height: JsonField<Long>,
        private val width: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("colors")
            @ExcludeMissing
            colors: JsonField<List<Color>> = JsonMissing.of(),
            @JsonProperty("focus") @ExcludeMissing focus: JsonField<Focus> = JsonMissing.of(),
            @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
        ) : this(url, colors, focus, height, width, mutableMapOf())

        /**
         * Banner image URL at its original size
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun url(): String = url.getRequired("url")

        /**
         * Main colors of the banner, largest share first
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun colors(): Optional<List<Color>> = colors.getOptional("colors")

        /**
         * Area X keeps in view when it crops the banner, in pixels from the top left
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun focus(): Optional<Focus> = focus.getOptional("focus")

        /**
         * Banner height in pixels
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun height(): Optional<Long> = height.getOptional("height")

        /**
         * Banner width in pixels
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun width(): Optional<Long> = width.getOptional("width")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [colors].
         *
         * Unlike [colors], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("colors") @ExcludeMissing fun _colors(): JsonField<List<Color>> = colors

        /**
         * Returns the raw JSON value of [focus].
         *
         * Unlike [focus], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("focus") @ExcludeMissing fun _focus(): JsonField<Focus> = focus

        /**
         * Returns the raw JSON value of [height].
         *
         * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

        /**
         * Returns the raw JSON value of [width].
         *
         * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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
             * Returns a mutable builder for constructing an instance of [Banner].
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Banner]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var colors: JsonField<MutableList<Color>>? = null
            private var focus: JsonField<Focus> = JsonMissing.of()
            private var height: JsonField<Long> = JsonMissing.of()
            private var width: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(banner: Banner) = apply {
                url = banner.url
                colors = banner.colors.map { it.toMutableList() }
                focus = banner.focus
                height = banner.height
                width = banner.width
                additionalProperties = banner.additionalProperties.toMutableMap()
            }

            /** Banner image URL at its original size */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Main colors of the banner, largest share first */
            fun colors(colors: List<Color>) = colors(JsonField.of(colors))

            /** Sets [Builder.colors] to an arbitrary JSON value. */
            fun colors(colors: JsonField<List<Color>>) = apply {
                this.colors = colors.map { it.toMutableList() }
            }

            /**
             * Adds a single [Color] to [colors].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addColor(color: Color) = apply {
                colors =
                    (colors ?: JsonField.of(mutableListOf())).also {
                        checkKnown("colors", it).add(color)
                    }
            }

            /** Area X keeps in view when it crops the banner, in pixels from the top left */
            fun focus(focus: Focus) = focus(JsonField.of(focus))

            /** Sets [Builder.focus] to an arbitrary JSON value. */
            fun focus(focus: JsonField<Focus>) = apply { this.focus = focus }

            /** Banner height in pixels */
            fun height(height: Long) = height(JsonField.of(height))

            /** Sets [Builder.height] to an arbitrary JSON value. */
            fun height(height: JsonField<Long>) = apply { this.height = height }

            /** Banner width in pixels */
            fun width(width: Long) = width(JsonField.of(width))

            /** Sets [Builder.width] to an arbitrary JSON value. */
            fun width(width: JsonField<Long>) = apply { this.width = width }

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
             * Returns an immutable instance of [Banner].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Banner =
                Banner(
                    checkRequired("url", url),
                    (colors ?: JsonMissing.of()).map { it.toImmutable() },
                    focus,
                    height,
                    width,
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
        fun validate(): Banner = apply {
            if (validated) {
                return@apply
            }

            url()
            colors().ifPresent { it.forEach { it.validate() } }
            focus().ifPresent { it.validate() }
            height()
            width()
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
            (if (url.asKnown().isPresent) 1 else 0) +
                (colors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (focus.asKnown().getOrNull()?.validity() ?: 0) +
                (if (height.asKnown().isPresent) 1 else 0) +
                (if (width.asKnown().isPresent) 1 else 0)

        class Color
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val blue: JsonField<Long>,
            private val green: JsonField<Long>,
            private val percentage: JsonField<Double>,
            private val red: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("blue") @ExcludeMissing blue: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("green") @ExcludeMissing green: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("percentage")
                @ExcludeMissing
                percentage: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("red") @ExcludeMissing red: JsonField<Long> = JsonMissing.of(),
            ) : this(blue, green, percentage, red, mutableMapOf())

            /**
             * Blue value of the color
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun blue(): Long = blue.getRequired("blue")

            /**
             * Green value of the color
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun green(): Long = green.getRequired("green")

            /**
             * Share of the banner in this color
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun percentage(): Double = percentage.getRequired("percentage")

            /**
             * Red value of the color
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun red(): Long = red.getRequired("red")

            /**
             * Returns the raw JSON value of [blue].
             *
             * Unlike [blue], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("blue") @ExcludeMissing fun _blue(): JsonField<Long> = blue

            /**
             * Returns the raw JSON value of [green].
             *
             * Unlike [green], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("green") @ExcludeMissing fun _green(): JsonField<Long> = green

            /**
             * Returns the raw JSON value of [percentage].
             *
             * Unlike [percentage], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("percentage")
            @ExcludeMissing
            fun _percentage(): JsonField<Double> = percentage

            /**
             * Returns the raw JSON value of [red].
             *
             * Unlike [red], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("red") @ExcludeMissing fun _red(): JsonField<Long> = red

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
                 * Returns a mutable builder for constructing an instance of [Color].
                 *
                 * The following fields are required:
                 * ```java
                 * .blue()
                 * .green()
                 * .percentage()
                 * .red()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Color]. */
            class Builder internal constructor() {

                private var blue: JsonField<Long>? = null
                private var green: JsonField<Long>? = null
                private var percentage: JsonField<Double>? = null
                private var red: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(color: Color) = apply {
                    blue = color.blue
                    green = color.green
                    percentage = color.percentage
                    red = color.red
                    additionalProperties = color.additionalProperties.toMutableMap()
                }

                /** Blue value of the color */
                fun blue(blue: Long) = blue(JsonField.of(blue))

                /** Sets [Builder.blue] to an arbitrary JSON value. */
                fun blue(blue: JsonField<Long>) = apply { this.blue = blue }

                /** Green value of the color */
                fun green(green: Long) = green(JsonField.of(green))

                /** Sets [Builder.green] to an arbitrary JSON value. */
                fun green(green: JsonField<Long>) = apply { this.green = green }

                /** Share of the banner in this color */
                fun percentage(percentage: Double) = percentage(JsonField.of(percentage))

                /** Sets [Builder.percentage] to an arbitrary JSON value. */
                fun percentage(percentage: JsonField<Double>) = apply {
                    this.percentage = percentage
                }

                /** Red value of the color */
                fun red(red: Long) = red(JsonField.of(red))

                /** Sets [Builder.red] to an arbitrary JSON value. */
                fun red(red: JsonField<Long>) = apply { this.red = red }

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
                 * Returns an immutable instance of [Color].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .blue()
                 * .green()
                 * .percentage()
                 * .red()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Color =
                    Color(
                        checkRequired("blue", blue),
                        checkRequired("green", green),
                        checkRequired("percentage", percentage),
                        checkRequired("red", red),
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
            fun validate(): Color = apply {
                if (validated) {
                    return@apply
                }

                blue()
                green()
                percentage()
                red()
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
                (if (blue.asKnown().isPresent) 1 else 0) +
                    (if (green.asKnown().isPresent) 1 else 0) +
                    (if (percentage.asKnown().isPresent) 1 else 0) +
                    (if (red.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Color &&
                    blue == other.blue &&
                    green == other.green &&
                    percentage == other.percentage &&
                    red == other.red &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(blue, green, percentage, red, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Color{blue=$blue, green=$green, percentage=$percentage, red=$red, additionalProperties=$additionalProperties}"
        }

        /** Area X keeps in view when it crops the banner, in pixels from the top left */
        class Focus
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val height: JsonField<Long>,
            private val left: JsonField<Long>,
            private val top: JsonField<Long>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("left") @ExcludeMissing left: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("top") @ExcludeMissing top: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(height, left, top, width, mutableMapOf())

            /**
             * Height of the area
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun height(): Optional<Long> = height.getOptional("height")

            /**
             * Distance from the left edge
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun left(): Optional<Long> = left.getOptional("left")

            /**
             * Distance from the top edge
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun top(): Optional<Long> = top.getOptional("top")

            /**
             * Width of the area
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun width(): Optional<Long> = width.getOptional("width")

            /**
             * Returns the raw JSON value of [height].
             *
             * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

            /**
             * Returns the raw JSON value of [left].
             *
             * Unlike [left], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("left") @ExcludeMissing fun _left(): JsonField<Long> = left

            /**
             * Returns the raw JSON value of [top].
             *
             * Unlike [top], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("top") @ExcludeMissing fun _top(): JsonField<Long> = top

            /**
             * Returns the raw JSON value of [width].
             *
             * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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

                /** Returns a mutable builder for constructing an instance of [Focus]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Focus]. */
            class Builder internal constructor() {

                private var height: JsonField<Long> = JsonMissing.of()
                private var left: JsonField<Long> = JsonMissing.of()
                private var top: JsonField<Long> = JsonMissing.of()
                private var width: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(focus: Focus) = apply {
                    height = focus.height
                    left = focus.left
                    top = focus.top
                    width = focus.width
                    additionalProperties = focus.additionalProperties.toMutableMap()
                }

                /** Height of the area */
                fun height(height: Long) = height(JsonField.of(height))

                /** Sets [Builder.height] to an arbitrary JSON value. */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                /** Distance from the left edge */
                fun left(left: Long) = left(JsonField.of(left))

                /** Sets [Builder.left] to an arbitrary JSON value. */
                fun left(left: JsonField<Long>) = apply { this.left = left }

                /** Distance from the top edge */
                fun top(top: Long) = top(JsonField.of(top))

                /** Sets [Builder.top] to an arbitrary JSON value. */
                fun top(top: JsonField<Long>) = apply { this.top = top }

                /** Width of the area */
                fun width(width: Long) = width(JsonField.of(width))

                /** Sets [Builder.width] to an arbitrary JSON value. */
                fun width(width: JsonField<Long>) = apply { this.width = width }

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
                 * Returns an immutable instance of [Focus].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Focus =
                    Focus(height, left, top, width, additionalProperties.toMutableMap())
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
            fun validate(): Focus = apply {
                if (validated) {
                    return@apply
                }

                height()
                left()
                top()
                width()
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
                (if (height.asKnown().isPresent) 1 else 0) +
                    (if (left.asKnown().isPresent) 1 else 0) +
                    (if (top.asKnown().isPresent) 1 else 0) +
                    (if (width.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Focus &&
                    height == other.height &&
                    left == other.left &&
                    top == other.top &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(height, left, top, width, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Focus{height=$height, left=$left, top=$top, width=$width, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Banner &&
                url == other.url &&
                colors == other.colors &&
                focus == other.focus &&
                height == other.height &&
                width == other.width &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(url, colors, focus, height, width, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Banner{url=$url, colors=$colors, focus=$focus, height=$height, width=$width, additionalProperties=$additionalProperties}"
    }

    /** The creator's public profile, or the ID, username and badge alone when X sends no profile */
    @JsonDeserialize(using = Creator.Deserializer::class)
    @JsonSerialize(using = Creator.Serializer::class)
    class Creator
    private constructor(
        private val userProfile: UserProfile? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        fun userProfile(): Optional<UserProfile> = Optional.ofNullable(userProfile)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isUserProfile(): Boolean = userProfile != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        fun asUserProfile(): UserProfile = userProfile.getOrThrow("userProfile")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                userProfile != null -> visitor.visitUserProfile(userProfile)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                else -> visitor.unknown(_json)
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
        fun validate(): Creator = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUserProfile(userProfile: UserProfile) {
                        userProfile.validate()
                    }

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
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

        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitUserProfile(userProfile: UserProfile) = userProfile.validity()

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Creator &&
                userProfile == other.userProfile &&
                unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int = Objects.hash(userProfile, unionMember1)

        override fun toString(): String =
            when {
                userProfile != null -> "Creator{userProfile=$userProfile}"
                unionMember1 != null -> "Creator{unionMember1=$unionMember1}"
                _json != null -> "Creator{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Creator")
            }

        companion object {

            @JvmStatic
            fun ofUserProfile(userProfile: UserProfile) = Creator(userProfile = userProfile)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Creator(unionMember1 = unionMember1)
        }

        /**
         * An interface that defines how to map each variant of [Creator] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitUserProfile(userProfile: UserProfile): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

            /**
             * Maps an unknown variant of [Creator] to a value of type [T].
             *
             * An instance of [Creator] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown Creator: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Creator>(Creator::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Creator {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UserProfile>())?.let {
                                Creator(userProfile = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                Creator(unionMember1 = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> Creator(_json = json)
                    1 -> bestMatches.single()
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Creator>(Creator::class) {

            override fun serialize(
                value: Creator,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.userProfile != null -> generator.writeObject(value.userProfile)
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Creator")
                }
            }
        }

        class UnionMember1
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val username: JsonField<String>,
            private val verified: JsonField<Boolean>,
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
            ) : this(id, username, verified, mutableMapOf())

            /**
             * Numeric X user ID of the creator
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * X username of the creator
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun username(): String = username.getRequired("username")

            /**
             * Whether X shows the creator a badge
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun verified(): Boolean = verified.getRequired("verified")

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
                 * Returns a mutable builder for constructing an instance of [UnionMember1].
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

            /** A builder for [UnionMember1]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var verified: JsonField<Boolean>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(unionMember1: UnionMember1) = apply {
                    id = unionMember1.id
                    username = unionMember1.username
                    verified = unionMember1.verified
                    additionalProperties = unionMember1.additionalProperties.toMutableMap()
                }

                /** Numeric X user ID of the creator */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** X username of the creator */
                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** Whether X shows the creator a badge */
                fun verified(verified: Boolean) = verified(JsonField.of(verified))

                /** Sets [Builder.verified] to an arbitrary JSON value. */
                fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

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
                 * Returns an immutable instance of [UnionMember1].
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
                fun build(): UnionMember1 =
                    UnionMember1(
                        checkRequired("id", id),
                        checkRequired("username", username),
                        checkRequired("verified", verified),
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
            fun validate(): UnionMember1 = apply {
                if (validated) {
                    return@apply
                }

                id()
                username()
                verified()
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
                    (if (verified.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember1 &&
                    id == other.id &&
                    username == other.username &&
                    verified == other.verified &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, username, verified, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UnionMember1{id=$id, username=$username, verified=$verified, additionalProperties=$additionalProperties}"
        }
    }

    @JsonDeserialize(using = MembersFacepile.Deserializer::class)
    @JsonSerialize(using = MembersFacepile.Serializer::class)
    class MembersFacepile
    private constructor(
        private val userProfile: UserProfile? = null,
        private val communityMemberPreview: CommunityMemberPreview? = null,
        private val _json: JsonValue? = null,
    ) {

        fun userProfile(): Optional<UserProfile> = Optional.ofNullable(userProfile)

        fun communityMemberPreview(): Optional<CommunityMemberPreview> =
            Optional.ofNullable(communityMemberPreview)

        fun isUserProfile(): Boolean = userProfile != null

        fun isCommunityMemberPreview(): Boolean = communityMemberPreview != null

        fun asUserProfile(): UserProfile = userProfile.getOrThrow("userProfile")

        fun asCommunityMemberPreview(): CommunityMemberPreview =
            communityMemberPreview.getOrThrow("communityMemberPreview")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                userProfile != null -> visitor.visitUserProfile(userProfile)
                communityMemberPreview != null ->
                    visitor.visitCommunityMemberPreview(communityMemberPreview)
                else -> visitor.unknown(_json)
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
        fun validate(): MembersFacepile = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUserProfile(userProfile: UserProfile) {
                        userProfile.validate()
                    }

                    override fun visitCommunityMemberPreview(
                        communityMemberPreview: CommunityMemberPreview
                    ) {
                        communityMemberPreview.validate()
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

        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitUserProfile(userProfile: UserProfile) = userProfile.validity()

                    override fun visitCommunityMemberPreview(
                        communityMemberPreview: CommunityMemberPreview
                    ) = communityMemberPreview.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MembersFacepile &&
                userProfile == other.userProfile &&
                communityMemberPreview == other.communityMemberPreview
        }

        override fun hashCode(): Int = Objects.hash(userProfile, communityMemberPreview)

        override fun toString(): String =
            when {
                userProfile != null -> "MembersFacepile{userProfile=$userProfile}"
                communityMemberPreview != null ->
                    "MembersFacepile{communityMemberPreview=$communityMemberPreview}"
                _json != null -> "MembersFacepile{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid MembersFacepile")
            }

        companion object {

            @JvmStatic
            fun ofUserProfile(userProfile: UserProfile) = MembersFacepile(userProfile = userProfile)

            @JvmStatic
            fun ofCommunityMemberPreview(communityMemberPreview: CommunityMemberPreview) =
                MembersFacepile(communityMemberPreview = communityMemberPreview)
        }

        /**
         * An interface that defines how to map each variant of [MembersFacepile] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitUserProfile(userProfile: UserProfile): T

            fun visitCommunityMemberPreview(communityMemberPreview: CommunityMemberPreview): T

            /**
             * Maps an unknown variant of [MembersFacepile] to a value of type [T].
             *
             * An instance of [MembersFacepile] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown MembersFacepile: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<MembersFacepile>(MembersFacepile::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): MembersFacepile {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UserProfile>())?.let {
                                MembersFacepile(userProfile = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CommunityMemberPreview>())?.let {
                                MembersFacepile(communityMemberPreview = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> MembersFacepile(_json = json)
                    1 -> bestMatches.single()
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<MembersFacepile>(MembersFacepile::class) {

            override fun serialize(
                value: MembersFacepile,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.userProfile != null -> generator.writeObject(value.userProfile)
                    value.communityMemberPreview != null ->
                        generator.writeObject(value.communityMemberPreview)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid MembersFacepile")
                }
            }
        }

        /** A member X previews by ID & profile picture only. */
        class CommunityMemberPreview
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
            ) : this(id, profilePicture, profilePictureOriginal, mutableMapOf())

            /**
             * Numeric X user ID of the member
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Profile picture URL of the member
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The member's profile picture at full size
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 * [CommunityMemberPreview].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CommunityMemberPreview]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(communityMemberPreview: CommunityMemberPreview) = apply {
                    id = communityMemberPreview.id
                    profilePicture = communityMemberPreview.profilePicture
                    profilePictureOriginal = communityMemberPreview.profilePictureOriginal
                    additionalProperties =
                        communityMemberPreview.additionalProperties.toMutableMap()
                }

                /** Numeric X user ID of the member */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Profile picture URL of the member */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The member's profile picture at full size */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
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
                 * Returns an immutable instance of [CommunityMemberPreview].
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
                fun build(): CommunityMemberPreview =
                    CommunityMemberPreview(
                        checkRequired("id", id),
                        profilePicture,
                        profilePictureOriginal,
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
            fun validate(): CommunityMemberPreview = apply {
                if (validated) {
                    return@apply
                }

                id()
                profilePicture()
                profilePictureOriginal()
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
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CommunityMemberPreview &&
                    id == other.id &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, profilePicture, profilePictureOriginal, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CommunityMemberPreview{id=$id, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, additionalProperties=$additionalProperties}"
        }
    }

    /** Primary topic. Its id is absent when X lists the community in a keyword or topic result. */
    class PrimaryTopic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val id: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        ) : this(name, id, mutableMapOf())

        /**
         * Topic name X shows on the community
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * Topic ID that /x/communities/popular takes
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
             * Returns a mutable builder for constructing an instance of [PrimaryTopic].
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PrimaryTopic]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(primaryTopic: PrimaryTopic) = apply {
                name = primaryTopic.name
                id = primaryTopic.id
                additionalProperties = primaryTopic.additionalProperties.toMutableMap()
            }

            /** Topic name X shows on the community */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Topic ID that /x/communities/popular takes */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [PrimaryTopic].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PrimaryTopic =
                PrimaryTopic(checkRequired("name", name), id, additionalProperties.toMutableMap())
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
        fun validate(): PrimaryTopic = apply {
            if (validated) {
                return@apply
            }

            name()
            id()
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
            (if (name.asKnown().isPresent) 1 else 0) + (if (id.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PrimaryTopic &&
                name == other.name &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(name, id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PrimaryTopic{name=$name, id=$id, additionalProperties=$additionalProperties}"
    }

    class Rule
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(description, id, name, mutableMapOf())

        /**
         * What the rule asks of members
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Rule ID
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Rule title
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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

            /** Returns a mutable builder for constructing an instance of [Rule]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Rule]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rule: Rule) = apply {
                description = rule.description
                id = rule.id
                name = rule.name
                additionalProperties = rule.additionalProperties.toMutableMap()
            }

            /** What the rule asks of members */
            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Rule ID */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Rule title */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Rule].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Rule = Rule(description, id, name, additionalProperties.toMutableMap())
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
        fun validate(): Rule = apply {
            if (validated) {
                return@apply
            }

            description()
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Rule &&
                description == other.description &&
                id == other.id &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(description, id, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Rule{description=$description, id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Community &&
            id == other.id &&
            isNsfw == other.isNsfw &&
            memberCount == other.memberCount &&
            name == other.name &&
            admin == other.admin &&
            banner == other.banner &&
            bannerUrl == other.bannerUrl &&
            createdAt == other.createdAt &&
            creator == other.creator &&
            description == other.description &&
            invitesPolicy == other.invitesPolicy &&
            joinPolicy == other.joinPolicy &&
            membersFacepile == other.membersFacepile &&
            moderatorCount == other.moderatorCount &&
            primaryTopic == other.primaryTopic &&
            question == other.question &&
            rules == other.rules &&
            searchTags == other.searchTags &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            isNsfw,
            memberCount,
            name,
            admin,
            banner,
            bannerUrl,
            createdAt,
            creator,
            description,
            invitesPolicy,
            joinPolicy,
            membersFacepile,
            moderatorCount,
            primaryTopic,
            question,
            rules,
            searchTags,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Community{id=$id, isNsfw=$isNsfw, memberCount=$memberCount, name=$name, admin=$admin, banner=$banner, bannerUrl=$bannerUrl, createdAt=$createdAt, creator=$creator, description=$description, invitesPolicy=$invitesPolicy, joinPolicy=$joinPolicy, membersFacepile=$membersFacepile, moderatorCount=$moderatorCount, primaryTopic=$primaryTopic, question=$question, rules=$rules, searchTags=$searchTags, additionalProperties=$additionalProperties}"
}
