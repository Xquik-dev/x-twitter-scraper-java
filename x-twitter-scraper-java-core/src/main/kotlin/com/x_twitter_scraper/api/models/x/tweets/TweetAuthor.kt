// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Tweet author profile. The lookup route always includes follower count and verification state.
 * Other profile fields appear when available.
 */
class TweetAuthor
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val name: JsonField<String>,
    private val username: JsonField<String>,
    private val automatedBy: JsonField<String>,
    private val canDm: JsonField<Boolean>,
    private val communityRole: JsonField<String>,
    private val coverPicture: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val description: JsonField<String>,
    private val favouritesCount: JsonField<Long>,
    private val followers: JsonField<Long>,
    private val following: JsonField<Long>,
    private val hasCustomTimelines: JsonField<Boolean>,
    private val isAutomated: JsonField<Boolean>,
    private val isBlueVerified: JsonField<Boolean>,
    private val isTranslator: JsonField<Boolean>,
    private val isVerified: JsonField<Boolean>,
    private val location: JsonField<String>,
    private val mediaCount: JsonField<Long>,
    private val pinnedTweetIds: JsonField<List<String>>,
    private val possiblySensitive: JsonField<Boolean>,
    private val profileBio: JsonField<UserProfile.ProfileBio>,
    private val profileBannerUrl: JsonField<String>,
    private val profilePicture: JsonField<String>,
    private val protected_: JsonField<Boolean>,
    private val statusesCount: JsonField<Long>,
    private val unavailable: JsonField<Boolean>,
    private val unavailableReason: JsonField<String>,
    private val url: JsonField<String>,
    private val verified: JsonField<Boolean>,
    private val verifiedType: JsonField<String>,
    private val viewerFollowedBy: JsonField<Boolean>,
    private val viewerFollowing: JsonField<Boolean>,
    private val withheldInCountries: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("automatedBy")
        @ExcludeMissing
        automatedBy: JsonField<String> = JsonMissing.of(),
        @JsonProperty("canDm") @ExcludeMissing canDm: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("communityRole")
        @ExcludeMissing
        communityRole: JsonField<String> = JsonMissing.of(),
        @JsonProperty("coverPicture")
        @ExcludeMissing
        coverPicture: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("favouritesCount")
        @ExcludeMissing
        favouritesCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("followers") @ExcludeMissing followers: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("following") @ExcludeMissing following: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hasCustomTimelines")
        @ExcludeMissing
        hasCustomTimelines: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isAutomated")
        @ExcludeMissing
        isAutomated: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isBlueVerified")
        @ExcludeMissing
        isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isTranslator")
        @ExcludeMissing
        isTranslator: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isVerified")
        @ExcludeMissing
        isVerified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mediaCount") @ExcludeMissing mediaCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("pinnedTweetIds")
        @ExcludeMissing
        pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("possiblySensitive")
        @ExcludeMissing
        possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("profile_bio")
        @ExcludeMissing
        profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of(),
        @JsonProperty("profileBannerUrl")
        @ExcludeMissing
        profileBannerUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profilePicture")
        @ExcludeMissing
        profilePicture: JsonField<String> = JsonMissing.of(),
        @JsonProperty("protected")
        @ExcludeMissing
        protected_: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("statusesCount")
        @ExcludeMissing
        statusesCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("unavailable")
        @ExcludeMissing
        unavailable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("unavailableReason")
        @ExcludeMissing
        unavailableReason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("verified") @ExcludeMissing verified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("verifiedType")
        @ExcludeMissing
        verifiedType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("viewerFollowedBy")
        @ExcludeMissing
        viewerFollowedBy: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("viewerFollowing")
        @ExcludeMissing
        viewerFollowing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("withheldInCountries")
        @ExcludeMissing
        withheldInCountries: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        name,
        username,
        automatedBy,
        canDm,
        communityRole,
        coverPicture,
        createdAt,
        description,
        favouritesCount,
        followers,
        following,
        hasCustomTimelines,
        isAutomated,
        isBlueVerified,
        isTranslator,
        isVerified,
        location,
        mediaCount,
        pinnedTweetIds,
        possiblySensitive,
        profileBio,
        profileBannerUrl,
        profilePicture,
        protected_,
        statusesCount,
        unavailable,
        unavailableReason,
        url,
        verified,
        verifiedType,
        viewerFollowedBy,
        viewerFollowing,
        withheldInCountries,
        mutableMapOf(),
    )

    fun toUserProfile(): UserProfile =
        UserProfile.builder()
            .id(id)
            .name(name)
            .username(username)
            .automatedBy(automatedBy)
            .canDm(canDm)
            .communityRole(communityRole)
            .coverPicture(coverPicture)
            .createdAt(createdAt)
            .description(description)
            .favouritesCount(favouritesCount)
            .followers(followers)
            .following(following)
            .hasCustomTimelines(hasCustomTimelines)
            .isAutomated(isAutomated)
            .isBlueVerified(isBlueVerified)
            .isTranslator(isTranslator)
            .isVerified(isVerified)
            .location(location)
            .mediaCount(mediaCount)
            .pinnedTweetIds(pinnedTweetIds)
            .possiblySensitive(possiblySensitive)
            .profileBio(profileBio)
            .profileBannerUrl(profileBannerUrl)
            .profilePicture(profilePicture)
            .protected_(protected_)
            .statusesCount(statusesCount)
            .unavailable(unavailable)
            .unavailableReason(unavailableReason)
            .url(url)
            .verified(verified)
            .verifiedType(verifiedType)
            .viewerFollowedBy(viewerFollowedBy)
            .viewerFollowing(viewerFollowing)
            .withheldInCountries(withheldInCountries)
            .build()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun username(): String = username.getRequired("username")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun canDm(): Optional<Boolean> = canDm.getOptional("canDm")

    /**
     * Community role when returned by community member reads
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun communityRole(): Optional<String> = communityRole.getOptional("communityRole")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun coverPicture(): Optional<String> = coverPicture.getOptional("coverPicture")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun followers(): Optional<Long> = followers.getOptional("followers")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun following(): Optional<Long> = following.getOptional("following")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasCustomTimelines(): Optional<Boolean> =
        hasCustomTimelines.getOptional("hasCustomTimelines")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isAutomated(): Optional<Boolean> = isAutomated.getOptional("isAutomated")

    /**
     * Whether X shows a blue verification badge
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator")

    /**
     * Whether X marks the profile as verified
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun location(): Optional<String> = location.getOptional("location")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pinnedTweetIds(): Optional<List<String>> = pinnedTweetIds.getOptional("pinnedTweetIds")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun possiblySensitive(): Optional<Boolean> = possiblySensitive.getOptional("possiblySensitive")

    /**
     * Structured profile bio with entity annotations
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileBio(): Optional<UserProfile.ProfileBio> = profileBio.getOptional("profile_bio")

    /**
     * Original X profile banner field when available
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileBannerUrl(): Optional<String> = profileBannerUrl.getOptional("profileBannerUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

    /**
     * Whether the profile protects its posts
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun unavailable(): Optional<Boolean> = unavailable.getOptional("unavailable")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun unavailableReason(): Optional<String> = unavailableReason.getOptional("unavailableReason")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun verified(): Optional<Boolean> = verified.getOptional("verified")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

    /**
     * Whether this profile follows the authenticated viewer
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun viewerFollowedBy(): Optional<Boolean> = viewerFollowedBy.getOptional("viewerFollowedBy")

    /**
     * Whether the authenticated viewer follows this profile
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun viewerFollowing(): Optional<Boolean> = viewerFollowing.getOptional("viewerFollowing")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun withheldInCountries(): Optional<List<String>> =
        withheldInCountries.getOptional("withheldInCountries")

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
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /**
     * Returns the raw JSON value of [automatedBy].
     *
     * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("automatedBy") @ExcludeMissing fun _automatedBy(): JsonField<String> = automatedBy

    /**
     * Returns the raw JSON value of [canDm].
     *
     * Unlike [canDm], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("canDm") @ExcludeMissing fun _canDm(): JsonField<Boolean> = canDm

    /**
     * Returns the raw JSON value of [communityRole].
     *
     * Unlike [communityRole], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityRole")
    @ExcludeMissing
    fun _communityRole(): JsonField<String> = communityRole

    /**
     * Returns the raw JSON value of [coverPicture].
     *
     * Unlike [coverPicture], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("coverPicture")
    @ExcludeMissing
    fun _coverPicture(): JsonField<String> = coverPicture

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [favouritesCount].
     *
     * Unlike [favouritesCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("favouritesCount")
    @ExcludeMissing
    fun _favouritesCount(): JsonField<Long> = favouritesCount

    /**
     * Returns the raw JSON value of [followers].
     *
     * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

    /**
     * Returns the raw JSON value of [following].
     *
     * Unlike [following], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following

    /**
     * Returns the raw JSON value of [hasCustomTimelines].
     *
     * Unlike [hasCustomTimelines], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("hasCustomTimelines")
    @ExcludeMissing
    fun _hasCustomTimelines(): JsonField<Boolean> = hasCustomTimelines

    /**
     * Returns the raw JSON value of [isAutomated].
     *
     * Unlike [isAutomated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isAutomated")
    @ExcludeMissing
    fun _isAutomated(): JsonField<Boolean> = isAutomated

    /**
     * Returns the raw JSON value of [isBlueVerified].
     *
     * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isBlueVerified")
    @ExcludeMissing
    fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

    /**
     * Returns the raw JSON value of [isTranslator].
     *
     * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isTranslator")
    @ExcludeMissing
    fun _isTranslator(): JsonField<Boolean> = isTranslator

    /**
     * Returns the raw JSON value of [isVerified].
     *
     * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isVerified") @ExcludeMissing fun _isVerified(): JsonField<Boolean> = isVerified

    /**
     * Returns the raw JSON value of [location].
     *
     * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

    /**
     * Returns the raw JSON value of [mediaCount].
     *
     * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaCount") @ExcludeMissing fun _mediaCount(): JsonField<Long> = mediaCount

    /**
     * Returns the raw JSON value of [pinnedTweetIds].
     *
     * Unlike [pinnedTweetIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pinnedTweetIds")
    @ExcludeMissing
    fun _pinnedTweetIds(): JsonField<List<String>> = pinnedTweetIds

    /**
     * Returns the raw JSON value of [possiblySensitive].
     *
     * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("possiblySensitive")
    @ExcludeMissing
    fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive

    /**
     * Returns the raw JSON value of [profileBio].
     *
     * Unlike [profileBio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profile_bio")
    @ExcludeMissing
    fun _profileBio(): JsonField<UserProfile.ProfileBio> = profileBio

    /**
     * Returns the raw JSON value of [profileBannerUrl].
     *
     * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("profileBannerUrl")
    @ExcludeMissing
    fun _profileBannerUrl(): JsonField<String> = profileBannerUrl

    /**
     * Returns the raw JSON value of [profilePicture].
     *
     * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profilePicture")
    @ExcludeMissing
    fun _profilePicture(): JsonField<String> = profilePicture

    /**
     * Returns the raw JSON value of [protected_].
     *
     * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("protected") @ExcludeMissing fun _protected_(): JsonField<Boolean> = protected_

    /**
     * Returns the raw JSON value of [statusesCount].
     *
     * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusesCount")
    @ExcludeMissing
    fun _statusesCount(): JsonField<Long> = statusesCount

    /**
     * Returns the raw JSON value of [unavailable].
     *
     * Unlike [unavailable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unavailable")
    @ExcludeMissing
    fun _unavailable(): JsonField<Boolean> = unavailable

    /**
     * Returns the raw JSON value of [unavailableReason].
     *
     * Unlike [unavailableReason], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("unavailableReason")
    @ExcludeMissing
    fun _unavailableReason(): JsonField<String> = unavailableReason

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [verified].
     *
     * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

    /**
     * Returns the raw JSON value of [verifiedType].
     *
     * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("verifiedType")
    @ExcludeMissing
    fun _verifiedType(): JsonField<String> = verifiedType

    /**
     * Returns the raw JSON value of [viewerFollowedBy].
     *
     * Unlike [viewerFollowedBy], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("viewerFollowedBy")
    @ExcludeMissing
    fun _viewerFollowedBy(): JsonField<Boolean> = viewerFollowedBy

    /**
     * Returns the raw JSON value of [viewerFollowing].
     *
     * Unlike [viewerFollowing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("viewerFollowing")
    @ExcludeMissing
    fun _viewerFollowing(): JsonField<Boolean> = viewerFollowing

    /**
     * Returns the raw JSON value of [withheldInCountries].
     *
     * Unlike [withheldInCountries], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("withheldInCountries")
    @ExcludeMissing
    fun _withheldInCountries(): JsonField<List<String>> = withheldInCountries

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
         * Returns a mutable builder for constructing an instance of [TweetAuthor].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .name()
         * .username()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetAuthor]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var username: JsonField<String>? = null
        private var automatedBy: JsonField<String> = JsonMissing.of()
        private var canDm: JsonField<Boolean> = JsonMissing.of()
        private var communityRole: JsonField<String> = JsonMissing.of()
        private var coverPicture: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var favouritesCount: JsonField<Long> = JsonMissing.of()
        private var followers: JsonField<Long> = JsonMissing.of()
        private var following: JsonField<Long> = JsonMissing.of()
        private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of()
        private var isAutomated: JsonField<Boolean> = JsonMissing.of()
        private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
        private var isTranslator: JsonField<Boolean> = JsonMissing.of()
        private var isVerified: JsonField<Boolean> = JsonMissing.of()
        private var location: JsonField<String> = JsonMissing.of()
        private var mediaCount: JsonField<Long> = JsonMissing.of()
        private var pinnedTweetIds: JsonField<MutableList<String>>? = null
        private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
        private var profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of()
        private var profileBannerUrl: JsonField<String> = JsonMissing.of()
        private var profilePicture: JsonField<String> = JsonMissing.of()
        private var protected_: JsonField<Boolean> = JsonMissing.of()
        private var statusesCount: JsonField<Long> = JsonMissing.of()
        private var unavailable: JsonField<Boolean> = JsonMissing.of()
        private var unavailableReason: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var verified: JsonField<Boolean> = JsonMissing.of()
        private var verifiedType: JsonField<String> = JsonMissing.of()
        private var viewerFollowedBy: JsonField<Boolean> = JsonMissing.of()
        private var viewerFollowing: JsonField<Boolean> = JsonMissing.of()
        private var withheldInCountries: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetAuthor: TweetAuthor) = apply {
            id = tweetAuthor.id
            name = tweetAuthor.name
            username = tweetAuthor.username
            automatedBy = tweetAuthor.automatedBy
            canDm = tweetAuthor.canDm
            communityRole = tweetAuthor.communityRole
            coverPicture = tweetAuthor.coverPicture
            createdAt = tweetAuthor.createdAt
            description = tweetAuthor.description
            favouritesCount = tweetAuthor.favouritesCount
            followers = tweetAuthor.followers
            following = tweetAuthor.following
            hasCustomTimelines = tweetAuthor.hasCustomTimelines
            isAutomated = tweetAuthor.isAutomated
            isBlueVerified = tweetAuthor.isBlueVerified
            isTranslator = tweetAuthor.isTranslator
            isVerified = tweetAuthor.isVerified
            location = tweetAuthor.location
            mediaCount = tweetAuthor.mediaCount
            pinnedTweetIds = tweetAuthor.pinnedTweetIds.map { it.toMutableList() }
            possiblySensitive = tweetAuthor.possiblySensitive
            profileBio = tweetAuthor.profileBio
            profileBannerUrl = tweetAuthor.profileBannerUrl
            profilePicture = tweetAuthor.profilePicture
            protected_ = tweetAuthor.protected_
            statusesCount = tweetAuthor.statusesCount
            unavailable = tweetAuthor.unavailable
            unavailableReason = tweetAuthor.unavailableReason
            url = tweetAuthor.url
            verified = tweetAuthor.verified
            verifiedType = tweetAuthor.verifiedType
            viewerFollowedBy = tweetAuthor.viewerFollowedBy
            viewerFollowing = tweetAuthor.viewerFollowing
            withheldInCountries = tweetAuthor.withheldInCountries.map { it.toMutableList() }
            additionalProperties = tweetAuthor.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun username(username: String) = username(JsonField.of(username))

        /**
         * Sets [Builder.username] to an arbitrary JSON value.
         *
         * You should usually call [Builder.username] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy))

        /**
         * Sets [Builder.automatedBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automatedBy] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun automatedBy(automatedBy: JsonField<String>) = apply { this.automatedBy = automatedBy }

        fun canDm(canDm: Boolean) = canDm(JsonField.of(canDm))

        /**
         * Sets [Builder.canDm] to an arbitrary JSON value.
         *
         * You should usually call [Builder.canDm] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun canDm(canDm: JsonField<Boolean>) = apply { this.canDm = canDm }

        /** Community role when returned by community member reads */
        fun communityRole(communityRole: String) = communityRole(JsonField.of(communityRole))

        /**
         * Sets [Builder.communityRole] to an arbitrary JSON value.
         *
         * You should usually call [Builder.communityRole] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun communityRole(communityRole: JsonField<String>) = apply {
            this.communityRole = communityRole
        }

        fun coverPicture(coverPicture: String) = coverPicture(JsonField.of(coverPicture))

        /**
         * Sets [Builder.coverPicture] to an arbitrary JSON value.
         *
         * You should usually call [Builder.coverPicture] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun coverPicture(coverPicture: JsonField<String>) = apply {
            this.coverPicture = coverPicture
        }

        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun favouritesCount(favouritesCount: Long) = favouritesCount(JsonField.of(favouritesCount))

        /**
         * Sets [Builder.favouritesCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.favouritesCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun favouritesCount(favouritesCount: JsonField<Long>) = apply {
            this.favouritesCount = favouritesCount
        }

        fun followers(followers: Long) = followers(JsonField.of(followers))

        /**
         * Sets [Builder.followers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.followers] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

        fun following(following: Long) = following(JsonField.of(following))

        /**
         * Sets [Builder.following] to an arbitrary JSON value.
         *
         * You should usually call [Builder.following] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun following(following: JsonField<Long>) = apply { this.following = following }

        fun hasCustomTimelines(hasCustomTimelines: Boolean) =
            hasCustomTimelines(JsonField.of(hasCustomTimelines))

        /**
         * Sets [Builder.hasCustomTimelines] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasCustomTimelines] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun hasCustomTimelines(hasCustomTimelines: JsonField<Boolean>) = apply {
            this.hasCustomTimelines = hasCustomTimelines
        }

        fun isAutomated(isAutomated: Boolean) = isAutomated(JsonField.of(isAutomated))

        /**
         * Sets [Builder.isAutomated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isAutomated] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isAutomated(isAutomated: JsonField<Boolean>) = apply { this.isAutomated = isAutomated }

        /** Whether X shows a blue verification badge */
        fun isBlueVerified(isBlueVerified: Boolean) = isBlueVerified(JsonField.of(isBlueVerified))

        /**
         * Sets [Builder.isBlueVerified] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isBlueVerified] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
            this.isBlueVerified = isBlueVerified
        }

        fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator))

        /**
         * Sets [Builder.isTranslator] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isTranslator] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isTranslator(isTranslator: JsonField<Boolean>) = apply {
            this.isTranslator = isTranslator
        }

        /** Whether X marks the profile as verified */
        fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

        /**
         * Sets [Builder.isVerified] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isVerified] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified }

        fun location(location: String) = location(JsonField.of(location))

        /**
         * Sets [Builder.location] to an arbitrary JSON value.
         *
         * You should usually call [Builder.location] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun location(location: JsonField<String>) = apply { this.location = location }

        fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount))

        /**
         * Sets [Builder.mediaCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount }

        fun pinnedTweetIds(pinnedTweetIds: List<String>) =
            pinnedTweetIds(JsonField.of(pinnedTweetIds))

        /**
         * Sets [Builder.pinnedTweetIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pinnedTweetIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pinnedTweetIds(pinnedTweetIds: JsonField<List<String>>) = apply {
            this.pinnedTweetIds = pinnedTweetIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [pinnedTweetIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPinnedTweetId(pinnedTweetId: String) = apply {
            pinnedTweetIds =
                (pinnedTweetIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("pinnedTweetIds", it).add(pinnedTweetId)
                }
        }

        fun possiblySensitive(possiblySensitive: Boolean) =
            possiblySensitive(JsonField.of(possiblySensitive))

        /**
         * Sets [Builder.possiblySensitive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.possiblySensitive] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
            this.possiblySensitive = possiblySensitive
        }

        /** Structured profile bio with entity annotations */
        fun profileBio(profileBio: UserProfile.ProfileBio) = profileBio(JsonField.of(profileBio))

        /**
         * Sets [Builder.profileBio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileBio] with a well-typed [UserProfile.ProfileBio]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun profileBio(profileBio: JsonField<UserProfile.ProfileBio>) = apply {
            this.profileBio = profileBio
        }

        /** Original X profile banner field when available */
        fun profileBannerUrl(profileBannerUrl: String) =
            profileBannerUrl(JsonField.of(profileBannerUrl))

        /**
         * Sets [Builder.profileBannerUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileBannerUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply {
            this.profileBannerUrl = profileBannerUrl
        }

        fun profilePicture(profilePicture: String) = profilePicture(JsonField.of(profilePicture))

        /**
         * Sets [Builder.profilePicture] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profilePicture] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profilePicture(profilePicture: JsonField<String>) = apply {
            this.profilePicture = profilePicture
        }

        /** Whether the profile protects its posts */
        fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

        /**
         * Sets [Builder.protected_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.protected_] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ }

        fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

        /**
         * Sets [Builder.statusesCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusesCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun statusesCount(statusesCount: JsonField<Long>) = apply {
            this.statusesCount = statusesCount
        }

        fun unavailable(unavailable: Boolean) = unavailable(JsonField.of(unavailable))

        /**
         * Sets [Builder.unavailable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.unavailable] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun unavailable(unavailable: JsonField<Boolean>) = apply { this.unavailable = unavailable }

        fun unavailableReason(unavailableReason: String) =
            unavailableReason(JsonField.of(unavailableReason))

        /**
         * Sets [Builder.unavailableReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.unavailableReason] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun unavailableReason(unavailableReason: JsonField<String>) = apply {
            this.unavailableReason = unavailableReason
        }

        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        fun verified(verified: Boolean) = verified(JsonField.of(verified))

        /**
         * Sets [Builder.verified] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verified] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

        fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

        /**
         * Sets [Builder.verifiedType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verifiedType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verifiedType(verifiedType: JsonField<String>) = apply {
            this.verifiedType = verifiedType
        }

        /** Whether this profile follows the authenticated viewer */
        fun viewerFollowedBy(viewerFollowedBy: Boolean) =
            viewerFollowedBy(JsonField.of(viewerFollowedBy))

        /**
         * Sets [Builder.viewerFollowedBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.viewerFollowedBy] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun viewerFollowedBy(viewerFollowedBy: JsonField<Boolean>) = apply {
            this.viewerFollowedBy = viewerFollowedBy
        }

        /** Whether the authenticated viewer follows this profile */
        fun viewerFollowing(viewerFollowing: Boolean) =
            viewerFollowing(JsonField.of(viewerFollowing))

        /**
         * Sets [Builder.viewerFollowing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.viewerFollowing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun viewerFollowing(viewerFollowing: JsonField<Boolean>) = apply {
            this.viewerFollowing = viewerFollowing
        }

        fun withheldInCountries(withheldInCountries: List<String>) =
            withheldInCountries(JsonField.of(withheldInCountries))

        /**
         * Sets [Builder.withheldInCountries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.withheldInCountries] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun withheldInCountries(withheldInCountries: JsonField<List<String>>) = apply {
            this.withheldInCountries = withheldInCountries.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [withheldInCountries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWithheldInCountry(withheldInCountry: String) = apply {
            withheldInCountries =
                (withheldInCountries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("withheldInCountries", it).add(withheldInCountry)
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
         * Returns an immutable instance of [TweetAuthor].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .name()
         * .username()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetAuthor =
            TweetAuthor(
                checkRequired("id", id),
                checkRequired("name", name),
                checkRequired("username", username),
                automatedBy,
                canDm,
                communityRole,
                coverPicture,
                createdAt,
                description,
                favouritesCount,
                followers,
                following,
                hasCustomTimelines,
                isAutomated,
                isBlueVerified,
                isTranslator,
                isVerified,
                location,
                mediaCount,
                (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                possiblySensitive,
                profileBio,
                profileBannerUrl,
                profilePicture,
                protected_,
                statusesCount,
                unavailable,
                unavailableReason,
                url,
                verified,
                verifiedType,
                viewerFollowedBy,
                viewerFollowing,
                (withheldInCountries ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): TweetAuthor = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        username()
        automatedBy()
        canDm()
        communityRole()
        coverPicture()
        createdAt()
        description()
        favouritesCount()
        followers()
        following()
        hasCustomTimelines()
        isAutomated()
        isBlueVerified()
        isTranslator()
        isVerified()
        location()
        mediaCount()
        pinnedTweetIds()
        possiblySensitive()
        profileBio().ifPresent { it.validate() }
        profileBannerUrl()
        profilePicture()
        protected_()
        statusesCount()
        unavailable()
        unavailableReason()
        url()
        verified()
        verifiedType()
        viewerFollowedBy()
        viewerFollowing()
        withheldInCountries()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (username.asKnown().isPresent) 1 else 0) +
            (if (automatedBy.asKnown().isPresent) 1 else 0) +
            (if (canDm.asKnown().isPresent) 1 else 0) +
            (if (communityRole.asKnown().isPresent) 1 else 0) +
            (if (coverPicture.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (favouritesCount.asKnown().isPresent) 1 else 0) +
            (if (followers.asKnown().isPresent) 1 else 0) +
            (if (following.asKnown().isPresent) 1 else 0) +
            (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) +
            (if (isAutomated.asKnown().isPresent) 1 else 0) +
            (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
            (if (isTranslator.asKnown().isPresent) 1 else 0) +
            (if (isVerified.asKnown().isPresent) 1 else 0) +
            (if (location.asKnown().isPresent) 1 else 0) +
            (if (mediaCount.asKnown().isPresent) 1 else 0) +
            (pinnedTweetIds.asKnown().getOrNull()?.size ?: 0) +
            (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
            (profileBio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (profileBannerUrl.asKnown().isPresent) 1 else 0) +
            (if (profilePicture.asKnown().isPresent) 1 else 0) +
            (if (protected_.asKnown().isPresent) 1 else 0) +
            (if (statusesCount.asKnown().isPresent) 1 else 0) +
            (if (unavailable.asKnown().isPresent) 1 else 0) +
            (if (unavailableReason.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (verified.asKnown().isPresent) 1 else 0) +
            (if (verifiedType.asKnown().isPresent) 1 else 0) +
            (if (viewerFollowedBy.asKnown().isPresent) 1 else 0) +
            (if (viewerFollowing.asKnown().isPresent) 1 else 0) +
            (withheldInCountries.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetAuthor &&
            id == other.id &&
            name == other.name &&
            username == other.username &&
            automatedBy == other.automatedBy &&
            canDm == other.canDm &&
            communityRole == other.communityRole &&
            coverPicture == other.coverPicture &&
            createdAt == other.createdAt &&
            description == other.description &&
            favouritesCount == other.favouritesCount &&
            followers == other.followers &&
            following == other.following &&
            hasCustomTimelines == other.hasCustomTimelines &&
            isAutomated == other.isAutomated &&
            isBlueVerified == other.isBlueVerified &&
            isTranslator == other.isTranslator &&
            isVerified == other.isVerified &&
            location == other.location &&
            mediaCount == other.mediaCount &&
            pinnedTweetIds == other.pinnedTweetIds &&
            possiblySensitive == other.possiblySensitive &&
            profileBio == other.profileBio &&
            profileBannerUrl == other.profileBannerUrl &&
            profilePicture == other.profilePicture &&
            protected_ == other.protected_ &&
            statusesCount == other.statusesCount &&
            unavailable == other.unavailable &&
            unavailableReason == other.unavailableReason &&
            url == other.url &&
            verified == other.verified &&
            verifiedType == other.verifiedType &&
            viewerFollowedBy == other.viewerFollowedBy &&
            viewerFollowing == other.viewerFollowing &&
            withheldInCountries == other.withheldInCountries &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            name,
            username,
            automatedBy,
            canDm,
            communityRole,
            coverPicture,
            createdAt,
            description,
            favouritesCount,
            followers,
            following,
            hasCustomTimelines,
            isAutomated,
            isBlueVerified,
            isTranslator,
            isVerified,
            location,
            mediaCount,
            pinnedTweetIds,
            possiblySensitive,
            profileBio,
            profileBannerUrl,
            profilePicture,
            protected_,
            statusesCount,
            unavailable,
            unavailableReason,
            url,
            verified,
            verifiedType,
            viewerFollowedBy,
            viewerFollowing,
            withheldInCountries,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetAuthor{id=$id, name=$name, username=$username, automatedBy=$automatedBy, canDm=$canDm, communityRole=$communityRole, coverPicture=$coverPicture, createdAt=$createdAt, description=$description, favouritesCount=$favouritesCount, followers=$followers, following=$following, hasCustomTimelines=$hasCustomTimelines, isAutomated=$isAutomated, isBlueVerified=$isBlueVerified, isTranslator=$isTranslator, isVerified=$isVerified, location=$location, mediaCount=$mediaCount, pinnedTweetIds=$pinnedTweetIds, possiblySensitive=$possiblySensitive, profileBio=$profileBio, profileBannerUrl=$profileBannerUrl, profilePicture=$profilePicture, protected_=$protected_, statusesCount=$statusesCount, unavailable=$unavailable, unavailableReason=$unavailableReason, url=$url, verified=$verified, verifiedType=$verifiedType, viewerFollowedBy=$viewerFollowedBy, viewerFollowing=$viewerFollowing, withheldInCountries=$withheldInCountries, additionalProperties=$additionalProperties}"
}
