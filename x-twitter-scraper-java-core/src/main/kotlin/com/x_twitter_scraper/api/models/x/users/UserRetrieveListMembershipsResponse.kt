// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

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
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * 1 page of public X Lists. Follow next_cursor while the response reports more pages. Each returned
 * List costs 1 credit.
 */
class UserRetrieveListMembershipsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val lists: JsonField<List<XList>>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("lists") @ExcludeMissing lists: JsonField<List<XList>> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(hasNextPage, lists, nextCursor, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun lists(): List<XList> = lists.getRequired("lists")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * Returns the raw JSON value of [hasNextPage].
     *
     * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_next_page")
    @ExcludeMissing
    fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /**
     * Returns the raw JSON value of [lists].
     *
     * Unlike [lists], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lists") @ExcludeMissing fun _lists(): JsonField<List<XList>> = lists

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

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
         * [UserRetrieveListMembershipsResponse].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .lists()
         * .nextCursor()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveListMembershipsResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var lists: JsonField<MutableList<XList>>? = null
        private var nextCursor: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            userRetrieveListMembershipsResponse: UserRetrieveListMembershipsResponse
        ) = apply {
            hasNextPage = userRetrieveListMembershipsResponse.hasNextPage
            lists = userRetrieveListMembershipsResponse.lists.map { it.toMutableList() }
            nextCursor = userRetrieveListMembershipsResponse.nextCursor
            additionalProperties =
                userRetrieveListMembershipsResponse.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun lists(lists: List<XList>) = lists(JsonField.of(lists))

        /** Sets [Builder.lists] to an arbitrary JSON value. */
        fun lists(lists: JsonField<List<XList>>) = apply {
            this.lists = lists.map { it.toMutableList() }
        }

        /**
         * Adds a single [XList] to [lists].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addList(list: XList) = apply {
            lists =
                (lists ?: JsonField.of(mutableListOf())).also { checkKnown("lists", it).add(list) }
        }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
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
         * Returns an immutable instance of [UserRetrieveListMembershipsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .lists()
         * .nextCursor()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveListMembershipsResponse =
            UserRetrieveListMembershipsResponse(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("lists", lists).map { it.toImmutable() },
                checkRequired("nextCursor", nextCursor),
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
    fun validate(): UserRetrieveListMembershipsResponse = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        lists().forEach { it.validate() }
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

    @JvmSynthetic
    internal fun validity(): Int =
        (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (lists.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    /**
     * Public X List with its owner's public profile. Leaves out what X tells the reading account,
     * such as whether it follows the List.
     */
    class XList
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val bannerUrl: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val customBanner: JsonField<CustomBanner>,
        private val defaultBanner: JsonField<DefaultBanner>,
        private val description: JsonField<String>,
        private val facepileUrls: JsonField<List<String>>,
        private val memberCount: JsonField<Long>,
        private val membersContext: JsonField<String>,
        private val owner: JsonField<UserProfile>,
        private val subscriberCount: JsonField<Long>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bannerUrl")
            @ExcludeMissing
            bannerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("customBanner")
            @ExcludeMissing
            customBanner: JsonField<CustomBanner> = JsonMissing.of(),
            @JsonProperty("defaultBanner")
            @ExcludeMissing
            defaultBanner: JsonField<DefaultBanner> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("facepileUrls")
            @ExcludeMissing
            facepileUrls: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("memberCount")
            @ExcludeMissing
            memberCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("membersContext")
            @ExcludeMissing
            membersContext: JsonField<String> = JsonMissing.of(),
            @JsonProperty("owner") @ExcludeMissing owner: JsonField<UserProfile> = JsonMissing.of(),
            @JsonProperty("subscriberCount")
            @ExcludeMissing
            subscriberCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            name,
            bannerUrl,
            createdAt,
            customBanner,
            defaultBanner,
            description,
            facepileUrls,
            memberCount,
            membersContext,
            owner,
            subscriberCount,
            url,
            mutableMapOf(),
        )

        /**
         * Numeric ID of the List.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Name the owner gave the List.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * URL of the banner the owner uploaded. Absent when the owner uploaded none.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun bannerUrl(): Optional<String> = bannerUrl.getOptional("bannerUrl")

        /**
         * When the owner made the List.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * Banner the owner uploaded.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun customBanner(): Optional<CustomBanner> = customBanner.getOptional("customBanner")

        /**
         * Banner X shows when the owner uploaded none. X picks it per reading account, so 2 calls
         * can return different ones.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun defaultBanner(): Optional<DefaultBanner> = defaultBanner.getOptional("defaultBanner")

        /**
         * About text of the List. Empty when the owner wrote none.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Avatar URLs of a few List members, which X may pick per request.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun facepileUrls(): Optional<List<String>> = facepileUrls.getOptional("facepileUrls")

        /**
         * Accounts on the List.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun memberCount(): Optional<Long> = memberCount.getOptional("memberCount")

        /**
         * Member count as X words it, such as 35 members.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun membersContext(): Optional<String> = membersContext.getOptional("membersContext")

        /**
         * Public profile of the account that owns the List.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun owner(): Optional<UserProfile> = owner.getOptional("owner")

        /**
         * Accounts that follow the List, which X calls followers.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun subscriberCount(): Optional<Long> = subscriberCount.getOptional("subscriberCount")

        /**
         * List page on x.com.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun url(): Optional<String> = url.getOptional("url")

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

        /**
         * Returns the raw JSON value of [bannerUrl].
         *
         * Unlike [bannerUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bannerUrl") @ExcludeMissing fun _bannerUrl(): JsonField<String> = bannerUrl

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [customBanner].
         *
         * Unlike [customBanner], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("customBanner")
        @ExcludeMissing
        fun _customBanner(): JsonField<CustomBanner> = customBanner

        /**
         * Returns the raw JSON value of [defaultBanner].
         *
         * Unlike [defaultBanner], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("defaultBanner")
        @ExcludeMissing
        fun _defaultBanner(): JsonField<DefaultBanner> = defaultBanner

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [facepileUrls].
         *
         * Unlike [facepileUrls], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("facepileUrls")
        @ExcludeMissing
        fun _facepileUrls(): JsonField<List<String>> = facepileUrls

        /**
         * Returns the raw JSON value of [memberCount].
         *
         * Unlike [memberCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("memberCount")
        @ExcludeMissing
        fun _memberCount(): JsonField<Long> = memberCount

        /**
         * Returns the raw JSON value of [membersContext].
         *
         * Unlike [membersContext], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("membersContext")
        @ExcludeMissing
        fun _membersContext(): JsonField<String> = membersContext

        /**
         * Returns the raw JSON value of [owner].
         *
         * Unlike [owner], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("owner") @ExcludeMissing fun _owner(): JsonField<UserProfile> = owner

        /**
         * Returns the raw JSON value of [subscriberCount].
         *
         * Unlike [subscriberCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriberCount")
        @ExcludeMissing
        fun _subscriberCount(): JsonField<Long> = subscriberCount

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
             * Returns a mutable builder for constructing an instance of [XList].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [XList]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var bannerUrl: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var customBanner: JsonField<CustomBanner> = JsonMissing.of()
            private var defaultBanner: JsonField<DefaultBanner> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var facepileUrls: JsonField<MutableList<String>>? = null
            private var memberCount: JsonField<Long> = JsonMissing.of()
            private var membersContext: JsonField<String> = JsonMissing.of()
            private var owner: JsonField<UserProfile> = JsonMissing.of()
            private var subscriberCount: JsonField<Long> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(xList: XList) = apply {
                id = xList.id
                name = xList.name
                bannerUrl = xList.bannerUrl
                createdAt = xList.createdAt
                customBanner = xList.customBanner
                defaultBanner = xList.defaultBanner
                description = xList.description
                facepileUrls = xList.facepileUrls.map { it.toMutableList() }
                memberCount = xList.memberCount
                membersContext = xList.membersContext
                owner = xList.owner
                subscriberCount = xList.subscriberCount
                url = xList.url
                additionalProperties = xList.additionalProperties.toMutableMap()
            }

            /** Numeric ID of the List. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Name the owner gave the List. */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** URL of the banner the owner uploaded. Absent when the owner uploaded none. */
            fun bannerUrl(bannerUrl: String) = bannerUrl(JsonField.of(bannerUrl))

            /** Sets [Builder.bannerUrl] to an arbitrary JSON value. */
            fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

            /** When the owner made the List. */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Banner the owner uploaded. */
            fun customBanner(customBanner: CustomBanner) = customBanner(JsonField.of(customBanner))

            /** Sets [Builder.customBanner] to an arbitrary JSON value. */
            fun customBanner(customBanner: JsonField<CustomBanner>) = apply {
                this.customBanner = customBanner
            }

            /**
             * Banner X shows when the owner uploaded none. X picks it per reading account, so 2
             * calls can return different ones.
             */
            fun defaultBanner(defaultBanner: DefaultBanner) =
                defaultBanner(JsonField.of(defaultBanner))

            /** Sets [Builder.defaultBanner] to an arbitrary JSON value. */
            fun defaultBanner(defaultBanner: JsonField<DefaultBanner>) = apply {
                this.defaultBanner = defaultBanner
            }

            /** About text of the List. Empty when the owner wrote none. */
            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Avatar URLs of a few List members, which X may pick per request. */
            fun facepileUrls(facepileUrls: List<String>) = facepileUrls(JsonField.of(facepileUrls))

            /** Sets [Builder.facepileUrls] to an arbitrary JSON value. */
            fun facepileUrls(facepileUrls: JsonField<List<String>>) = apply {
                this.facepileUrls = facepileUrls.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [facepileUrls].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFacepileUrl(facepileUrl: String) = apply {
                facepileUrls =
                    (facepileUrls ?: JsonField.of(mutableListOf())).also {
                        checkKnown("facepileUrls", it).add(facepileUrl)
                    }
            }

            /** Accounts on the List. */
            fun memberCount(memberCount: Long) = memberCount(JsonField.of(memberCount))

            /** Sets [Builder.memberCount] to an arbitrary JSON value. */
            fun memberCount(memberCount: JsonField<Long>) = apply { this.memberCount = memberCount }

            /** Member count as X words it, such as 35 members. */
            fun membersContext(membersContext: String) =
                membersContext(JsonField.of(membersContext))

            /** Sets [Builder.membersContext] to an arbitrary JSON value. */
            fun membersContext(membersContext: JsonField<String>) = apply {
                this.membersContext = membersContext
            }

            /** Public profile of the account that owns the List. */
            fun owner(owner: UserProfile) = owner(JsonField.of(owner))

            /** Sets [Builder.owner] to an arbitrary JSON value. */
            fun owner(owner: JsonField<UserProfile>) = apply { this.owner = owner }

            /** Accounts that follow the List, which X calls followers. */
            fun subscriberCount(subscriberCount: Long) =
                subscriberCount(JsonField.of(subscriberCount))

            /** Sets [Builder.subscriberCount] to an arbitrary JSON value. */
            fun subscriberCount(subscriberCount: JsonField<Long>) = apply {
                this.subscriberCount = subscriberCount
            }

            /** List page on x.com. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [XList].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): XList =
                XList(
                    checkRequired("id", id),
                    checkRequired("name", name),
                    bannerUrl,
                    createdAt,
                    customBanner,
                    defaultBanner,
                    description,
                    (facepileUrls ?: JsonMissing.of()).map { it.toImmutable() },
                    memberCount,
                    membersContext,
                    owner,
                    subscriberCount,
                    url,
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
        fun validate(): XList = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            bannerUrl()
            createdAt()
            customBanner().ifPresent { it.validate() }
            defaultBanner().ifPresent { it.validate() }
            description()
            facepileUrls()
            memberCount()
            membersContext()
            owner().ifPresent { it.validate() }
            subscriberCount()
            url()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (bannerUrl.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (customBanner.asKnown().getOrNull()?.validity() ?: 0) +
                (defaultBanner.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (facepileUrls.asKnown().getOrNull()?.size ?: 0) +
                (if (memberCount.asKnown().isPresent) 1 else 0) +
                (if (membersContext.asKnown().isPresent) 1 else 0) +
                (owner.asKnown().getOrNull()?.validity() ?: 0) +
                (if (subscriberCount.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        /** Banner image of an X List. */
        class CustomBanner
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val url: JsonField<String>,
            private val height: JsonField<Long>,
            private val mediaId: JsonField<String>,
            private val mediaKey: JsonField<String>,
            private val palette: JsonField<List<Palette>>,
            private val salientRect: JsonField<SalientRect>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("mediaId")
                @ExcludeMissing
                mediaId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("mediaKey")
                @ExcludeMissing
                mediaKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("palette")
                @ExcludeMissing
                palette: JsonField<List<Palette>> = JsonMissing.of(),
                @JsonProperty("salientRect")
                @ExcludeMissing
                salientRect: JsonField<SalientRect> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(url, height, mediaId, mediaKey, palette, salientRect, width, mutableMapOf())

            /**
             * Banner image URL.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun url(): String = url.getRequired("url")

            /**
             * Banner height in pixels.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun height(): Optional<Long> = height.getOptional("height")

            /**
             * Media ID of an uploaded banner.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaId(): Optional<String> = mediaId.getOptional("mediaId")

            /**
             * Stable media key of an uploaded banner.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

            /**
             * Dominant colors of an uploaded banner and their shares.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun palette(): Optional<List<Palette>> = palette.getOptional("palette")

            /**
             * Area X marks as the subject of the banner, in pixels.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun salientRect(): Optional<SalientRect> = salientRect.getOptional("salientRect")

            /**
             * Banner width in pixels.
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
             * Returns the raw JSON value of [height].
             *
             * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

            /**
             * Returns the raw JSON value of [mediaId].
             *
             * Unlike [mediaId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("mediaId") @ExcludeMissing fun _mediaId(): JsonField<String> = mediaId

            /**
             * Returns the raw JSON value of [mediaKey].
             *
             * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

            /**
             * Returns the raw JSON value of [palette].
             *
             * Unlike [palette], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("palette")
            @ExcludeMissing
            fun _palette(): JsonField<List<Palette>> = palette

            /**
             * Returns the raw JSON value of [salientRect].
             *
             * Unlike [salientRect], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("salientRect")
            @ExcludeMissing
            fun _salientRect(): JsonField<SalientRect> = salientRect

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
                 * Returns a mutable builder for constructing an instance of [CustomBanner].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CustomBanner]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var height: JsonField<Long> = JsonMissing.of()
                private var mediaId: JsonField<String> = JsonMissing.of()
                private var mediaKey: JsonField<String> = JsonMissing.of()
                private var palette: JsonField<MutableList<Palette>>? = null
                private var salientRect: JsonField<SalientRect> = JsonMissing.of()
                private var width: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(customBanner: CustomBanner) = apply {
                    url = customBanner.url
                    height = customBanner.height
                    mediaId = customBanner.mediaId
                    mediaKey = customBanner.mediaKey
                    palette = customBanner.palette.map { it.toMutableList() }
                    salientRect = customBanner.salientRect
                    width = customBanner.width
                    additionalProperties = customBanner.additionalProperties.toMutableMap()
                }

                /** Banner image URL. */
                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                /** Banner height in pixels. */
                fun height(height: Long) = height(JsonField.of(height))

                /** Sets [Builder.height] to an arbitrary JSON value. */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                /** Media ID of an uploaded banner. */
                fun mediaId(mediaId: String) = mediaId(JsonField.of(mediaId))

                /** Sets [Builder.mediaId] to an arbitrary JSON value. */
                fun mediaId(mediaId: JsonField<String>) = apply { this.mediaId = mediaId }

                /** Stable media key of an uploaded banner. */
                fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

                /** Sets [Builder.mediaKey] to an arbitrary JSON value. */
                fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

                /** Dominant colors of an uploaded banner and their shares. */
                fun palette(palette: List<Palette>) = palette(JsonField.of(palette))

                /** Sets [Builder.palette] to an arbitrary JSON value. */
                fun palette(palette: JsonField<List<Palette>>) = apply {
                    this.palette = palette.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Palette] to [palette].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPalette(palette: Palette) = apply {
                    this.palette =
                        (this.palette ?: JsonField.of(mutableListOf())).also {
                            checkKnown("palette", it).add(palette)
                        }
                }

                /** Area X marks as the subject of the banner, in pixels. */
                fun salientRect(salientRect: SalientRect) = salientRect(JsonField.of(salientRect))

                /** Sets [Builder.salientRect] to an arbitrary JSON value. */
                fun salientRect(salientRect: JsonField<SalientRect>) = apply {
                    this.salientRect = salientRect
                }

                /** Banner width in pixels. */
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
                 * Returns an immutable instance of [CustomBanner].
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
                fun build(): CustomBanner =
                    CustomBanner(
                        checkRequired("url", url),
                        height,
                        mediaId,
                        mediaKey,
                        (palette ?: JsonMissing.of()).map { it.toImmutable() },
                        salientRect,
                        width,
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
            fun validate(): CustomBanner = apply {
                if (validated) {
                    return@apply
                }

                url()
                height()
                mediaId()
                mediaKey()
                palette().ifPresent { it.forEach { it.validate() } }
                salientRect().ifPresent { it.validate() }
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
                    (if (height.asKnown().isPresent) 1 else 0) +
                    (if (mediaId.asKnown().isPresent) 1 else 0) +
                    (if (mediaKey.asKnown().isPresent) 1 else 0) +
                    (palette.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (salientRect.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (width.asKnown().isPresent) 1 else 0)

            class Palette
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val percentage: JsonField<Double>,
                private val rgb: JsonField<Rgb>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("percentage")
                    @ExcludeMissing
                    percentage: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("rgb") @ExcludeMissing rgb: JsonField<Rgb> = JsonMissing.of(),
                ) : this(percentage, rgb, mutableMapOf())

                /**
                 * Share of the banner
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun percentage(): Optional<Double> = percentage.getOptional("percentage")

                /**
                 * The color's red, green and blue values.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun rgb(): Optional<Rgb> = rgb.getOptional("rgb")

                /**
                 * Returns the raw JSON value of [percentage].
                 *
                 * Unlike [percentage], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("percentage")
                @ExcludeMissing
                fun _percentage(): JsonField<Double> = percentage

                /**
                 * Returns the raw JSON value of [rgb].
                 *
                 * Unlike [rgb], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("rgb") @ExcludeMissing fun _rgb(): JsonField<Rgb> = rgb

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

                    /** Returns a mutable builder for constructing an instance of [Palette]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Palette]. */
                class Builder internal constructor() {

                    private var percentage: JsonField<Double> = JsonMissing.of()
                    private var rgb: JsonField<Rgb> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(palette: Palette) = apply {
                        percentage = palette.percentage
                        rgb = palette.rgb
                        additionalProperties = palette.additionalProperties.toMutableMap()
                    }

                    /** Share of the banner */
                    fun percentage(percentage: Double) = percentage(JsonField.of(percentage))

                    /** Sets [Builder.percentage] to an arbitrary JSON value. */
                    fun percentage(percentage: JsonField<Double>) = apply {
                        this.percentage = percentage
                    }

                    /** The color's red, green and blue values. */
                    fun rgb(rgb: Rgb) = rgb(JsonField.of(rgb))

                    /** Sets [Builder.rgb] to an arbitrary JSON value. */
                    fun rgb(rgb: JsonField<Rgb>) = apply { this.rgb = rgb }

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
                     * Returns an immutable instance of [Palette].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Palette =
                        Palette(percentage, rgb, additionalProperties.toMutableMap())
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
                fun validate(): Palette = apply {
                    if (validated) {
                        return@apply
                    }

                    percentage()
                    rgb().ifPresent { it.validate() }
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
                    (if (percentage.asKnown().isPresent) 1 else 0) +
                        (rgb.asKnown().getOrNull()?.validity() ?: 0)

                /** The color's red, green and blue values. */
                class Rgb
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val blue: JsonField<Long>,
                    private val green: JsonField<Long>,
                    private val red: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("blue")
                        @ExcludeMissing
                        blue: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("green")
                        @ExcludeMissing
                        green: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("red")
                        @ExcludeMissing
                        red: JsonField<Long> = JsonMissing.of(),
                    ) : this(blue, green, red, mutableMapOf())

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun blue(): Optional<Long> = blue.getOptional("blue")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun green(): Optional<Long> = green.getOptional("green")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun red(): Optional<Long> = red.getOptional("red")

                    /**
                     * Returns the raw JSON value of [blue].
                     *
                     * Unlike [blue], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("blue") @ExcludeMissing fun _blue(): JsonField<Long> = blue

                    /**
                     * Returns the raw JSON value of [green].
                     *
                     * Unlike [green], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("green") @ExcludeMissing fun _green(): JsonField<Long> = green

                    /**
                     * Returns the raw JSON value of [red].
                     *
                     * Unlike [red], this method doesn't throw if the JSON field has an unexpected
                     * type.
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

                        /** Returns a mutable builder for constructing an instance of [Rgb]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Rgb]. */
                    class Builder internal constructor() {

                        private var blue: JsonField<Long> = JsonMissing.of()
                        private var green: JsonField<Long> = JsonMissing.of()
                        private var red: JsonField<Long> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(rgb: Rgb) = apply {
                            blue = rgb.blue
                            green = rgb.green
                            red = rgb.red
                            additionalProperties = rgb.additionalProperties.toMutableMap()
                        }

                        fun blue(blue: Long) = blue(JsonField.of(blue))

                        /** Sets [Builder.blue] to an arbitrary JSON value. */
                        fun blue(blue: JsonField<Long>) = apply { this.blue = blue }

                        fun green(green: Long) = green(JsonField.of(green))

                        /** Sets [Builder.green] to an arbitrary JSON value. */
                        fun green(green: JsonField<Long>) = apply { this.green = green }

                        fun red(red: Long) = red(JsonField.of(red))

                        /** Sets [Builder.red] to an arbitrary JSON value. */
                        fun red(red: JsonField<Long>) = apply { this.red = red }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Rgb].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Rgb =
                            Rgb(blue, green, red, additionalProperties.toMutableMap())
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
                    fun validate(): Rgb = apply {
                        if (validated) {
                            return@apply
                        }

                        blue()
                        green()
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
                            (if (red.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Rgb &&
                            blue == other.blue &&
                            green == other.green &&
                            red == other.red &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(blue, green, red, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Rgb{blue=$blue, green=$green, red=$red, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Palette &&
                        percentage == other.percentage &&
                        rgb == other.rgb &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(percentage, rgb, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Palette{percentage=$percentage, rgb=$rgb, additionalProperties=$additionalProperties}"
            }

            /** Area X marks as the subject of the banner, in pixels. */
            class SalientRect
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
                    @JsonProperty("height")
                    @ExcludeMissing
                    height: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("left") @ExcludeMissing left: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("top") @ExcludeMissing top: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("width")
                    @ExcludeMissing
                    width: JsonField<Long> = JsonMissing.of(),
                ) : this(height, left, top, width, mutableMapOf())

                /**
                 * Height of the marked area.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun height(): Optional<Long> = height.getOptional("height")

                /**
                 * Pixels from the banner's left.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun left(): Optional<Long> = left.getOptional("left")

                /**
                 * Pixels from the banner's top.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun top(): Optional<Long> = top.getOptional("top")

                /**
                 * Width of the marked area.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun width(): Optional<Long> = width.getOptional("width")

                /**
                 * Returns the raw JSON value of [height].
                 *
                 * Unlike [height], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

                /**
                 * Returns the raw JSON value of [left].
                 *
                 * Unlike [left], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                 * Unlike [width], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /** Returns a mutable builder for constructing an instance of [SalientRect]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SalientRect]. */
                class Builder internal constructor() {

                    private var height: JsonField<Long> = JsonMissing.of()
                    private var left: JsonField<Long> = JsonMissing.of()
                    private var top: JsonField<Long> = JsonMissing.of()
                    private var width: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(salientRect: SalientRect) = apply {
                        height = salientRect.height
                        left = salientRect.left
                        top = salientRect.top
                        width = salientRect.width
                        additionalProperties = salientRect.additionalProperties.toMutableMap()
                    }

                    /** Height of the marked area. */
                    fun height(height: Long) = height(JsonField.of(height))

                    /** Sets [Builder.height] to an arbitrary JSON value. */
                    fun height(height: JsonField<Long>) = apply { this.height = height }

                    /** Pixels from the banner's left. */
                    fun left(left: Long) = left(JsonField.of(left))

                    /** Sets [Builder.left] to an arbitrary JSON value. */
                    fun left(left: JsonField<Long>) = apply { this.left = left }

                    /** Pixels from the banner's top. */
                    fun top(top: Long) = top(JsonField.of(top))

                    /** Sets [Builder.top] to an arbitrary JSON value. */
                    fun top(top: JsonField<Long>) = apply { this.top = top }

                    /** Width of the marked area. */
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
                     * Returns an immutable instance of [SalientRect].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): SalientRect =
                        SalientRect(height, left, top, width, additionalProperties.toMutableMap())
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
                fun validate(): SalientRect = apply {
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

                    return other is SalientRect &&
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
                    "SalientRect{height=$height, left=$left, top=$top, width=$width, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CustomBanner &&
                    url == other.url &&
                    height == other.height &&
                    mediaId == other.mediaId &&
                    mediaKey == other.mediaKey &&
                    palette == other.palette &&
                    salientRect == other.salientRect &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    url,
                    height,
                    mediaId,
                    mediaKey,
                    palette,
                    salientRect,
                    width,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CustomBanner{url=$url, height=$height, mediaId=$mediaId, mediaKey=$mediaKey, palette=$palette, salientRect=$salientRect, width=$width, additionalProperties=$additionalProperties}"
        }

        /** Banner image of an X List. */
        class DefaultBanner
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val url: JsonField<String>,
            private val height: JsonField<Long>,
            private val mediaId: JsonField<String>,
            private val mediaKey: JsonField<String>,
            private val palette: JsonField<List<Palette>>,
            private val salientRect: JsonField<SalientRect>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("mediaId")
                @ExcludeMissing
                mediaId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("mediaKey")
                @ExcludeMissing
                mediaKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("palette")
                @ExcludeMissing
                palette: JsonField<List<Palette>> = JsonMissing.of(),
                @JsonProperty("salientRect")
                @ExcludeMissing
                salientRect: JsonField<SalientRect> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(url, height, mediaId, mediaKey, palette, salientRect, width, mutableMapOf())

            /**
             * Banner image URL.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun url(): String = url.getRequired("url")

            /**
             * Banner height in pixels.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun height(): Optional<Long> = height.getOptional("height")

            /**
             * Media ID of an uploaded banner.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaId(): Optional<String> = mediaId.getOptional("mediaId")

            /**
             * Stable media key of an uploaded banner.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

            /**
             * Dominant colors of an uploaded banner and their shares.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun palette(): Optional<List<Palette>> = palette.getOptional("palette")

            /**
             * Area X marks as the subject of the banner, in pixels.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun salientRect(): Optional<SalientRect> = salientRect.getOptional("salientRect")

            /**
             * Banner width in pixels.
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
             * Returns the raw JSON value of [height].
             *
             * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

            /**
             * Returns the raw JSON value of [mediaId].
             *
             * Unlike [mediaId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("mediaId") @ExcludeMissing fun _mediaId(): JsonField<String> = mediaId

            /**
             * Returns the raw JSON value of [mediaKey].
             *
             * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

            /**
             * Returns the raw JSON value of [palette].
             *
             * Unlike [palette], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("palette")
            @ExcludeMissing
            fun _palette(): JsonField<List<Palette>> = palette

            /**
             * Returns the raw JSON value of [salientRect].
             *
             * Unlike [salientRect], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("salientRect")
            @ExcludeMissing
            fun _salientRect(): JsonField<SalientRect> = salientRect

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
                 * Returns a mutable builder for constructing an instance of [DefaultBanner].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DefaultBanner]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var height: JsonField<Long> = JsonMissing.of()
                private var mediaId: JsonField<String> = JsonMissing.of()
                private var mediaKey: JsonField<String> = JsonMissing.of()
                private var palette: JsonField<MutableList<Palette>>? = null
                private var salientRect: JsonField<SalientRect> = JsonMissing.of()
                private var width: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(defaultBanner: DefaultBanner) = apply {
                    url = defaultBanner.url
                    height = defaultBanner.height
                    mediaId = defaultBanner.mediaId
                    mediaKey = defaultBanner.mediaKey
                    palette = defaultBanner.palette.map { it.toMutableList() }
                    salientRect = defaultBanner.salientRect
                    width = defaultBanner.width
                    additionalProperties = defaultBanner.additionalProperties.toMutableMap()
                }

                /** Banner image URL. */
                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                /** Banner height in pixels. */
                fun height(height: Long) = height(JsonField.of(height))

                /** Sets [Builder.height] to an arbitrary JSON value. */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                /** Media ID of an uploaded banner. */
                fun mediaId(mediaId: String) = mediaId(JsonField.of(mediaId))

                /** Sets [Builder.mediaId] to an arbitrary JSON value. */
                fun mediaId(mediaId: JsonField<String>) = apply { this.mediaId = mediaId }

                /** Stable media key of an uploaded banner. */
                fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

                /** Sets [Builder.mediaKey] to an arbitrary JSON value. */
                fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

                /** Dominant colors of an uploaded banner and their shares. */
                fun palette(palette: List<Palette>) = palette(JsonField.of(palette))

                /** Sets [Builder.palette] to an arbitrary JSON value. */
                fun palette(palette: JsonField<List<Palette>>) = apply {
                    this.palette = palette.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Palette] to [palette].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPalette(palette: Palette) = apply {
                    this.palette =
                        (this.palette ?: JsonField.of(mutableListOf())).also {
                            checkKnown("palette", it).add(palette)
                        }
                }

                /** Area X marks as the subject of the banner, in pixels. */
                fun salientRect(salientRect: SalientRect) = salientRect(JsonField.of(salientRect))

                /** Sets [Builder.salientRect] to an arbitrary JSON value. */
                fun salientRect(salientRect: JsonField<SalientRect>) = apply {
                    this.salientRect = salientRect
                }

                /** Banner width in pixels. */
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
                 * Returns an immutable instance of [DefaultBanner].
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
                fun build(): DefaultBanner =
                    DefaultBanner(
                        checkRequired("url", url),
                        height,
                        mediaId,
                        mediaKey,
                        (palette ?: JsonMissing.of()).map { it.toImmutable() },
                        salientRect,
                        width,
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
            fun validate(): DefaultBanner = apply {
                if (validated) {
                    return@apply
                }

                url()
                height()
                mediaId()
                mediaKey()
                palette().ifPresent { it.forEach { it.validate() } }
                salientRect().ifPresent { it.validate() }
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
                    (if (height.asKnown().isPresent) 1 else 0) +
                    (if (mediaId.asKnown().isPresent) 1 else 0) +
                    (if (mediaKey.asKnown().isPresent) 1 else 0) +
                    (palette.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (salientRect.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (width.asKnown().isPresent) 1 else 0)

            class Palette
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val percentage: JsonField<Double>,
                private val rgb: JsonField<Rgb>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("percentage")
                    @ExcludeMissing
                    percentage: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("rgb") @ExcludeMissing rgb: JsonField<Rgb> = JsonMissing.of(),
                ) : this(percentage, rgb, mutableMapOf())

                /**
                 * Share of the banner
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun percentage(): Optional<Double> = percentage.getOptional("percentage")

                /**
                 * The color's red, green and blue values.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun rgb(): Optional<Rgb> = rgb.getOptional("rgb")

                /**
                 * Returns the raw JSON value of [percentage].
                 *
                 * Unlike [percentage], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("percentage")
                @ExcludeMissing
                fun _percentage(): JsonField<Double> = percentage

                /**
                 * Returns the raw JSON value of [rgb].
                 *
                 * Unlike [rgb], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("rgb") @ExcludeMissing fun _rgb(): JsonField<Rgb> = rgb

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

                    /** Returns a mutable builder for constructing an instance of [Palette]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Palette]. */
                class Builder internal constructor() {

                    private var percentage: JsonField<Double> = JsonMissing.of()
                    private var rgb: JsonField<Rgb> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(palette: Palette) = apply {
                        percentage = palette.percentage
                        rgb = palette.rgb
                        additionalProperties = palette.additionalProperties.toMutableMap()
                    }

                    /** Share of the banner */
                    fun percentage(percentage: Double) = percentage(JsonField.of(percentage))

                    /** Sets [Builder.percentage] to an arbitrary JSON value. */
                    fun percentage(percentage: JsonField<Double>) = apply {
                        this.percentage = percentage
                    }

                    /** The color's red, green and blue values. */
                    fun rgb(rgb: Rgb) = rgb(JsonField.of(rgb))

                    /** Sets [Builder.rgb] to an arbitrary JSON value. */
                    fun rgb(rgb: JsonField<Rgb>) = apply { this.rgb = rgb }

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
                     * Returns an immutable instance of [Palette].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Palette =
                        Palette(percentage, rgb, additionalProperties.toMutableMap())
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
                fun validate(): Palette = apply {
                    if (validated) {
                        return@apply
                    }

                    percentage()
                    rgb().ifPresent { it.validate() }
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
                    (if (percentage.asKnown().isPresent) 1 else 0) +
                        (rgb.asKnown().getOrNull()?.validity() ?: 0)

                /** The color's red, green and blue values. */
                class Rgb
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val blue: JsonField<Long>,
                    private val green: JsonField<Long>,
                    private val red: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("blue")
                        @ExcludeMissing
                        blue: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("green")
                        @ExcludeMissing
                        green: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("red")
                        @ExcludeMissing
                        red: JsonField<Long> = JsonMissing.of(),
                    ) : this(blue, green, red, mutableMapOf())

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun blue(): Optional<Long> = blue.getOptional("blue")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun green(): Optional<Long> = green.getOptional("green")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun red(): Optional<Long> = red.getOptional("red")

                    /**
                     * Returns the raw JSON value of [blue].
                     *
                     * Unlike [blue], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("blue") @ExcludeMissing fun _blue(): JsonField<Long> = blue

                    /**
                     * Returns the raw JSON value of [green].
                     *
                     * Unlike [green], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("green") @ExcludeMissing fun _green(): JsonField<Long> = green

                    /**
                     * Returns the raw JSON value of [red].
                     *
                     * Unlike [red], this method doesn't throw if the JSON field has an unexpected
                     * type.
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

                        /** Returns a mutable builder for constructing an instance of [Rgb]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Rgb]. */
                    class Builder internal constructor() {

                        private var blue: JsonField<Long> = JsonMissing.of()
                        private var green: JsonField<Long> = JsonMissing.of()
                        private var red: JsonField<Long> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(rgb: Rgb) = apply {
                            blue = rgb.blue
                            green = rgb.green
                            red = rgb.red
                            additionalProperties = rgb.additionalProperties.toMutableMap()
                        }

                        fun blue(blue: Long) = blue(JsonField.of(blue))

                        /** Sets [Builder.blue] to an arbitrary JSON value. */
                        fun blue(blue: JsonField<Long>) = apply { this.blue = blue }

                        fun green(green: Long) = green(JsonField.of(green))

                        /** Sets [Builder.green] to an arbitrary JSON value. */
                        fun green(green: JsonField<Long>) = apply { this.green = green }

                        fun red(red: Long) = red(JsonField.of(red))

                        /** Sets [Builder.red] to an arbitrary JSON value. */
                        fun red(red: JsonField<Long>) = apply { this.red = red }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Rgb].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Rgb =
                            Rgb(blue, green, red, additionalProperties.toMutableMap())
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
                    fun validate(): Rgb = apply {
                        if (validated) {
                            return@apply
                        }

                        blue()
                        green()
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
                            (if (red.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Rgb &&
                            blue == other.blue &&
                            green == other.green &&
                            red == other.red &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(blue, green, red, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Rgb{blue=$blue, green=$green, red=$red, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Palette &&
                        percentage == other.percentage &&
                        rgb == other.rgb &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(percentage, rgb, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Palette{percentage=$percentage, rgb=$rgb, additionalProperties=$additionalProperties}"
            }

            /** Area X marks as the subject of the banner, in pixels. */
            class SalientRect
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
                    @JsonProperty("height")
                    @ExcludeMissing
                    height: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("left") @ExcludeMissing left: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("top") @ExcludeMissing top: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("width")
                    @ExcludeMissing
                    width: JsonField<Long> = JsonMissing.of(),
                ) : this(height, left, top, width, mutableMapOf())

                /**
                 * Height of the marked area.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun height(): Optional<Long> = height.getOptional("height")

                /**
                 * Pixels from the banner's left.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun left(): Optional<Long> = left.getOptional("left")

                /**
                 * Pixels from the banner's top.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun top(): Optional<Long> = top.getOptional("top")

                /**
                 * Width of the marked area.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun width(): Optional<Long> = width.getOptional("width")

                /**
                 * Returns the raw JSON value of [height].
                 *
                 * Unlike [height], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

                /**
                 * Returns the raw JSON value of [left].
                 *
                 * Unlike [left], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                 * Unlike [width], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /** Returns a mutable builder for constructing an instance of [SalientRect]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SalientRect]. */
                class Builder internal constructor() {

                    private var height: JsonField<Long> = JsonMissing.of()
                    private var left: JsonField<Long> = JsonMissing.of()
                    private var top: JsonField<Long> = JsonMissing.of()
                    private var width: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(salientRect: SalientRect) = apply {
                        height = salientRect.height
                        left = salientRect.left
                        top = salientRect.top
                        width = salientRect.width
                        additionalProperties = salientRect.additionalProperties.toMutableMap()
                    }

                    /** Height of the marked area. */
                    fun height(height: Long) = height(JsonField.of(height))

                    /** Sets [Builder.height] to an arbitrary JSON value. */
                    fun height(height: JsonField<Long>) = apply { this.height = height }

                    /** Pixels from the banner's left. */
                    fun left(left: Long) = left(JsonField.of(left))

                    /** Sets [Builder.left] to an arbitrary JSON value. */
                    fun left(left: JsonField<Long>) = apply { this.left = left }

                    /** Pixels from the banner's top. */
                    fun top(top: Long) = top(JsonField.of(top))

                    /** Sets [Builder.top] to an arbitrary JSON value. */
                    fun top(top: JsonField<Long>) = apply { this.top = top }

                    /** Width of the marked area. */
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
                     * Returns an immutable instance of [SalientRect].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): SalientRect =
                        SalientRect(height, left, top, width, additionalProperties.toMutableMap())
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
                fun validate(): SalientRect = apply {
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

                    return other is SalientRect &&
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
                    "SalientRect{height=$height, left=$left, top=$top, width=$width, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DefaultBanner &&
                    url == other.url &&
                    height == other.height &&
                    mediaId == other.mediaId &&
                    mediaKey == other.mediaKey &&
                    palette == other.palette &&
                    salientRect == other.salientRect &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    url,
                    height,
                    mediaId,
                    mediaKey,
                    palette,
                    salientRect,
                    width,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DefaultBanner{url=$url, height=$height, mediaId=$mediaId, mediaKey=$mediaKey, palette=$palette, salientRect=$salientRect, width=$width, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is XList &&
                id == other.id &&
                name == other.name &&
                bannerUrl == other.bannerUrl &&
                createdAt == other.createdAt &&
                customBanner == other.customBanner &&
                defaultBanner == other.defaultBanner &&
                description == other.description &&
                facepileUrls == other.facepileUrls &&
                memberCount == other.memberCount &&
                membersContext == other.membersContext &&
                owner == other.owner &&
                subscriberCount == other.subscriberCount &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                name,
                bannerUrl,
                createdAt,
                customBanner,
                defaultBanner,
                description,
                facepileUrls,
                memberCount,
                membersContext,
                owner,
                subscriberCount,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "XList{id=$id, name=$name, bannerUrl=$bannerUrl, createdAt=$createdAt, customBanner=$customBanner, defaultBanner=$defaultBanner, description=$description, facepileUrls=$facepileUrls, memberCount=$memberCount, membersContext=$membersContext, owner=$owner, subscriberCount=$subscriberCount, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveListMembershipsResponse &&
            hasNextPage == other.hasNextPage &&
            lists == other.lists &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasNextPage, lists, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveListMembershipsResponse{hasNextPage=$hasNextPage, lists=$lists, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
