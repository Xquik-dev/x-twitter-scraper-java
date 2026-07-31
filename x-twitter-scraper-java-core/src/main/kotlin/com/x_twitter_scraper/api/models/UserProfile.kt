// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

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

/** X user profile with bio, follower counts, and verification status. */
class UserProfile
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val name: JsonField<String>,
    private val username: JsonField<String>,
    private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>,
    private val automatedBy: JsonField<String>,
    private val businessAccountAffiliatesCount: JsonField<Long>,
    private val communityRole: JsonField<String>,
    private val coverPicture: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val creatorSubscriptionsCount: JsonField<Long>,
    private val description: JsonField<String>,
    private val favouritesCount: JsonField<Long>,
    private val followers: JsonField<Long>,
    private val following: JsonField<Long>,
    private val hasCustomTimelines: JsonField<Boolean>,
    private val hasGraduatedAccess: JsonField<Boolean>,
    private val hasHiddenSubscriptionsOnProfile: JsonField<Boolean>,
    private val highlightsInfo: JsonField<HighlightsInfo>,
    private val identityVerification: JsonField<IdentityVerification>,
    private val isAutomated: JsonField<Boolean>,
    private val isBlueVerified: JsonField<Boolean>,
    private val isProfileTranslatable: JsonField<Boolean>,
    private val isTranslator: JsonField<Boolean>,
    private val isVerified: JsonField<Boolean>,
    private val location: JsonField<String>,
    private val mediaCount: JsonField<Long>,
    private val parodyCommentaryFanLabel: JsonField<String>,
    private val pinnedTweetIds: JsonField<List<String>>,
    private val possiblySensitive: JsonField<Boolean>,
    private val profileBio: JsonField<ProfileBio>,
    private val profileBannerUrl: JsonField<String>,
    private val profileDescriptionLanguage: JsonField<String>,
    private val profileImageShape: JsonField<String>,
    private val profileInterstitialType: JsonField<String>,
    private val profilePicture: JsonField<String>,
    private val profileSortEnabled: JsonField<Boolean>,
    private val profileTranslatorType: JsonField<String>,
    private val protected_: JsonField<Boolean>,
    private val statusesCount: JsonField<Long>,
    private val superFollowEligible: JsonField<Boolean>,
    private val unavailable: JsonField<Boolean>,
    private val unavailableReason: JsonField<String>,
    private val url: JsonField<String>,
    private val verified: JsonField<Boolean>,
    private val verifiedType: JsonField<String>,
    private val withheldInCountries: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("affiliatesHighlightedLabel")
        @ExcludeMissing
        affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> = JsonMissing.of(),
        @JsonProperty("automatedBy")
        @ExcludeMissing
        automatedBy: JsonField<String> = JsonMissing.of(),
        @JsonProperty("businessAccountAffiliatesCount")
        @ExcludeMissing
        businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("communityRole")
        @ExcludeMissing
        communityRole: JsonField<String> = JsonMissing.of(),
        @JsonProperty("coverPicture")
        @ExcludeMissing
        coverPicture: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("creatorSubscriptionsCount")
        @ExcludeMissing
        creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of(),
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
        @JsonProperty("hasGraduatedAccess")
        @ExcludeMissing
        hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("hasHiddenSubscriptionsOnProfile")
        @ExcludeMissing
        hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("highlightsInfo")
        @ExcludeMissing
        highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of(),
        @JsonProperty("identityVerification")
        @ExcludeMissing
        identityVerification: JsonField<IdentityVerification> = JsonMissing.of(),
        @JsonProperty("isAutomated")
        @ExcludeMissing
        isAutomated: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isBlueVerified")
        @ExcludeMissing
        isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isProfileTranslatable")
        @ExcludeMissing
        isProfileTranslatable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isTranslator")
        @ExcludeMissing
        isTranslator: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isVerified")
        @ExcludeMissing
        isVerified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mediaCount") @ExcludeMissing mediaCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("parodyCommentaryFanLabel")
        @ExcludeMissing
        parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pinnedTweetIds")
        @ExcludeMissing
        pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("possiblySensitive")
        @ExcludeMissing
        possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("profile_bio")
        @ExcludeMissing
        profileBio: JsonField<ProfileBio> = JsonMissing.of(),
        @JsonProperty("profileBannerUrl")
        @ExcludeMissing
        profileBannerUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profileDescriptionLanguage")
        @ExcludeMissing
        profileDescriptionLanguage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profileImageShape")
        @ExcludeMissing
        profileImageShape: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profileInterstitialType")
        @ExcludeMissing
        profileInterstitialType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profilePicture")
        @ExcludeMissing
        profilePicture: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profileSortEnabled")
        @ExcludeMissing
        profileSortEnabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("profileTranslatorType")
        @ExcludeMissing
        profileTranslatorType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("protected")
        @ExcludeMissing
        protected_: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("statusesCount")
        @ExcludeMissing
        statusesCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("superFollowEligible")
        @ExcludeMissing
        superFollowEligible: JsonField<Boolean> = JsonMissing.of(),
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
        @JsonProperty("withheldInCountries")
        @ExcludeMissing
        withheldInCountries: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        name,
        username,
        affiliatesHighlightedLabel,
        automatedBy,
        businessAccountAffiliatesCount,
        communityRole,
        coverPicture,
        createdAt,
        creatorSubscriptionsCount,
        description,
        favouritesCount,
        followers,
        following,
        hasCustomTimelines,
        hasGraduatedAccess,
        hasHiddenSubscriptionsOnProfile,
        highlightsInfo,
        identityVerification,
        isAutomated,
        isBlueVerified,
        isProfileTranslatable,
        isTranslator,
        isVerified,
        location,
        mediaCount,
        parodyCommentaryFanLabel,
        pinnedTweetIds,
        possiblySensitive,
        profileBio,
        profileBannerUrl,
        profileDescriptionLanguage,
        profileImageShape,
        profileInterstitialType,
        profilePicture,
        profileSortEnabled,
        profileTranslatorType,
        protected_,
        statusesCount,
        superFollowEligible,
        unavailable,
        unavailableReason,
        url,
        verified,
        verifiedType,
        withheldInCountries,
        mutableMapOf(),
    )

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
     * Organization affiliation label shown on an X profile.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> =
        affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun businessAccountAffiliatesCount(): Optional<Long> =
        businessAccountAffiliatesCount.getOptional("businessAccountAffiliatesCount")

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
    fun creatorSubscriptionsCount(): Optional<Long> =
        creatorSubscriptionsCount.getOptional("creatorSubscriptionsCount")

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
    fun hasGraduatedAccess(): Optional<Boolean> =
        hasGraduatedAccess.getOptional("hasGraduatedAccess")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasHiddenSubscriptionsOnProfile(): Optional<Boolean> =
        hasHiddenSubscriptionsOnProfile.getOptional("hasHiddenSubscriptionsOnProfile")

    /**
     * Profile highlight availability and count metadata.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun highlightsInfo(): Optional<HighlightsInfo> = highlightsInfo.getOptional("highlightsInfo")

    /**
     * Identity verification metadata displayed by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun identityVerification(): Optional<IdentityVerification> =
        identityVerification.getOptional("identityVerification")

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
    fun isProfileTranslatable(): Optional<Boolean> =
        isProfileTranslatable.getOptional("isProfileTranslatable")

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
    fun parodyCommentaryFanLabel(): Optional<String> =
        parodyCommentaryFanLabel.getOptional("parodyCommentaryFanLabel")

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
    fun profileBio(): Optional<ProfileBio> = profileBio.getOptional("profile_bio")

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
    fun profileDescriptionLanguage(): Optional<String> =
        profileDescriptionLanguage.getOptional("profileDescriptionLanguage")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileImageShape(): Optional<String> = profileImageShape.getOptional("profileImageShape")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileInterstitialType(): Optional<String> =
        profileInterstitialType.getOptional("profileInterstitialType")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileSortEnabled(): Optional<Boolean> =
        profileSortEnabled.getOptional("profileSortEnabled")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profileTranslatorType(): Optional<String> =
        profileTranslatorType.getOptional("profileTranslatorType")

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
    fun superFollowEligible(): Optional<Boolean> =
        superFollowEligible.getOptional("superFollowEligible")

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
     * Returns the raw JSON value of [affiliatesHighlightedLabel].
     *
     * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("affiliatesHighlightedLabel")
    @ExcludeMissing
    fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> =
        affiliatesHighlightedLabel

    /**
     * Returns the raw JSON value of [automatedBy].
     *
     * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("automatedBy") @ExcludeMissing fun _automatedBy(): JsonField<String> = automatedBy

    /**
     * Returns the raw JSON value of [businessAccountAffiliatesCount].
     *
     * Unlike [businessAccountAffiliatesCount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("businessAccountAffiliatesCount")
    @ExcludeMissing
    fun _businessAccountAffiliatesCount(): JsonField<Long> = businessAccountAffiliatesCount

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
     * Returns the raw JSON value of [creatorSubscriptionsCount].
     *
     * Unlike [creatorSubscriptionsCount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("creatorSubscriptionsCount")
    @ExcludeMissing
    fun _creatorSubscriptionsCount(): JsonField<Long> = creatorSubscriptionsCount

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
     * Returns the raw JSON value of [hasGraduatedAccess].
     *
     * Unlike [hasGraduatedAccess], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("hasGraduatedAccess")
    @ExcludeMissing
    fun _hasGraduatedAccess(): JsonField<Boolean> = hasGraduatedAccess

    /**
     * Returns the raw JSON value of [hasHiddenSubscriptionsOnProfile].
     *
     * Unlike [hasHiddenSubscriptionsOnProfile], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("hasHiddenSubscriptionsOnProfile")
    @ExcludeMissing
    fun _hasHiddenSubscriptionsOnProfile(): JsonField<Boolean> = hasHiddenSubscriptionsOnProfile

    /**
     * Returns the raw JSON value of [highlightsInfo].
     *
     * Unlike [highlightsInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("highlightsInfo")
    @ExcludeMissing
    fun _highlightsInfo(): JsonField<HighlightsInfo> = highlightsInfo

    /**
     * Returns the raw JSON value of [identityVerification].
     *
     * Unlike [identityVerification], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("identityVerification")
    @ExcludeMissing
    fun _identityVerification(): JsonField<IdentityVerification> = identityVerification

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
     * Returns the raw JSON value of [isProfileTranslatable].
     *
     * Unlike [isProfileTranslatable], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("isProfileTranslatable")
    @ExcludeMissing
    fun _isProfileTranslatable(): JsonField<Boolean> = isProfileTranslatable

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
     * Returns the raw JSON value of [parodyCommentaryFanLabel].
     *
     * Unlike [parodyCommentaryFanLabel], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("parodyCommentaryFanLabel")
    @ExcludeMissing
    fun _parodyCommentaryFanLabel(): JsonField<String> = parodyCommentaryFanLabel

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
    fun _profileBio(): JsonField<ProfileBio> = profileBio

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
     * Returns the raw JSON value of [profileDescriptionLanguage].
     *
     * Unlike [profileDescriptionLanguage], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("profileDescriptionLanguage")
    @ExcludeMissing
    fun _profileDescriptionLanguage(): JsonField<String> = profileDescriptionLanguage

    /**
     * Returns the raw JSON value of [profileImageShape].
     *
     * Unlike [profileImageShape], this method doesn't throw if the JSON field has an unexpected
     * type.
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
     * Returns the raw JSON value of [profilePicture].
     *
     * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profilePicture")
    @ExcludeMissing
    fun _profilePicture(): JsonField<String> = profilePicture

    /**
     * Returns the raw JSON value of [profileSortEnabled].
     *
     * Unlike [profileSortEnabled], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("profileSortEnabled")
    @ExcludeMissing
    fun _profileSortEnabled(): JsonField<Boolean> = profileSortEnabled

    /**
     * Returns the raw JSON value of [profileTranslatorType].
     *
     * Unlike [profileTranslatorType], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("profileTranslatorType")
    @ExcludeMissing
    fun _profileTranslatorType(): JsonField<String> = profileTranslatorType

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
     * Returns the raw JSON value of [superFollowEligible].
     *
     * Unlike [superFollowEligible], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("superFollowEligible")
    @ExcludeMissing
    fun _superFollowEligible(): JsonField<Boolean> = superFollowEligible

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
         * Returns a mutable builder for constructing an instance of [UserProfile].
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

    /** A builder for [UserProfile]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var username: JsonField<String>? = null
        private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
            JsonMissing.of()
        private var automatedBy: JsonField<String> = JsonMissing.of()
        private var businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of()
        private var communityRole: JsonField<String> = JsonMissing.of()
        private var coverPicture: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var favouritesCount: JsonField<Long> = JsonMissing.of()
        private var followers: JsonField<Long> = JsonMissing.of()
        private var following: JsonField<Long> = JsonMissing.of()
        private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of()
        private var hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of()
        private var hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of()
        private var highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of()
        private var identityVerification: JsonField<IdentityVerification> = JsonMissing.of()
        private var isAutomated: JsonField<Boolean> = JsonMissing.of()
        private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
        private var isProfileTranslatable: JsonField<Boolean> = JsonMissing.of()
        private var isTranslator: JsonField<Boolean> = JsonMissing.of()
        private var isVerified: JsonField<Boolean> = JsonMissing.of()
        private var location: JsonField<String> = JsonMissing.of()
        private var mediaCount: JsonField<Long> = JsonMissing.of()
        private var parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of()
        private var pinnedTweetIds: JsonField<MutableList<String>>? = null
        private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
        private var profileBio: JsonField<ProfileBio> = JsonMissing.of()
        private var profileBannerUrl: JsonField<String> = JsonMissing.of()
        private var profileDescriptionLanguage: JsonField<String> = JsonMissing.of()
        private var profileImageShape: JsonField<String> = JsonMissing.of()
        private var profileInterstitialType: JsonField<String> = JsonMissing.of()
        private var profilePicture: JsonField<String> = JsonMissing.of()
        private var profileSortEnabled: JsonField<Boolean> = JsonMissing.of()
        private var profileTranslatorType: JsonField<String> = JsonMissing.of()
        private var protected_: JsonField<Boolean> = JsonMissing.of()
        private var statusesCount: JsonField<Long> = JsonMissing.of()
        private var superFollowEligible: JsonField<Boolean> = JsonMissing.of()
        private var unavailable: JsonField<Boolean> = JsonMissing.of()
        private var unavailableReason: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var verified: JsonField<Boolean> = JsonMissing.of()
        private var verifiedType: JsonField<String> = JsonMissing.of()
        private var withheldInCountries: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userProfile: UserProfile) = apply {
            id = userProfile.id
            name = userProfile.name
            username = userProfile.username
            affiliatesHighlightedLabel = userProfile.affiliatesHighlightedLabel
            automatedBy = userProfile.automatedBy
            businessAccountAffiliatesCount = userProfile.businessAccountAffiliatesCount
            communityRole = userProfile.communityRole
            coverPicture = userProfile.coverPicture
            createdAt = userProfile.createdAt
            creatorSubscriptionsCount = userProfile.creatorSubscriptionsCount
            description = userProfile.description
            favouritesCount = userProfile.favouritesCount
            followers = userProfile.followers
            following = userProfile.following
            hasCustomTimelines = userProfile.hasCustomTimelines
            hasGraduatedAccess = userProfile.hasGraduatedAccess
            hasHiddenSubscriptionsOnProfile = userProfile.hasHiddenSubscriptionsOnProfile
            highlightsInfo = userProfile.highlightsInfo
            identityVerification = userProfile.identityVerification
            isAutomated = userProfile.isAutomated
            isBlueVerified = userProfile.isBlueVerified
            isProfileTranslatable = userProfile.isProfileTranslatable
            isTranslator = userProfile.isTranslator
            isVerified = userProfile.isVerified
            location = userProfile.location
            mediaCount = userProfile.mediaCount
            parodyCommentaryFanLabel = userProfile.parodyCommentaryFanLabel
            pinnedTweetIds = userProfile.pinnedTweetIds.map { it.toMutableList() }
            possiblySensitive = userProfile.possiblySensitive
            profileBio = userProfile.profileBio
            profileBannerUrl = userProfile.profileBannerUrl
            profileDescriptionLanguage = userProfile.profileDescriptionLanguage
            profileImageShape = userProfile.profileImageShape
            profileInterstitialType = userProfile.profileInterstitialType
            profilePicture = userProfile.profilePicture
            profileSortEnabled = userProfile.profileSortEnabled
            profileTranslatorType = userProfile.profileTranslatorType
            protected_ = userProfile.protected_
            statusesCount = userProfile.statusesCount
            superFollowEligible = userProfile.superFollowEligible
            unavailable = userProfile.unavailable
            unavailableReason = userProfile.unavailableReason
            url = userProfile.url
            verified = userProfile.verified
            verifiedType = userProfile.verifiedType
            withheldInCountries = userProfile.withheldInCountries.map { it.toMutableList() }
            additionalProperties = userProfile.additionalProperties.toMutableMap()
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

        /** Organization affiliation label shown on an X profile. */
        fun affiliatesHighlightedLabel(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) =
            affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

        /**
         * Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.affiliatesHighlightedLabel] with a well-typed
         * [AffiliatesHighlightedLabel] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun affiliatesHighlightedLabel(
            affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>
        ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

        fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy))

        /**
         * Sets [Builder.automatedBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automatedBy] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun automatedBy(automatedBy: JsonField<String>) = apply { this.automatedBy = automatedBy }

        fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: Long) =
            businessAccountAffiliatesCount(JsonField.of(businessAccountAffiliatesCount))

        /**
         * Sets [Builder.businessAccountAffiliatesCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessAccountAffiliatesCount] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: JsonField<Long>) =
            apply {
                this.businessAccountAffiliatesCount = businessAccountAffiliatesCount
            }

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

        fun creatorSubscriptionsCount(creatorSubscriptionsCount: Long) =
            creatorSubscriptionsCount(JsonField.of(creatorSubscriptionsCount))

        /**
         * Sets [Builder.creatorSubscriptionsCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.creatorSubscriptionsCount] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun creatorSubscriptionsCount(creatorSubscriptionsCount: JsonField<Long>) = apply {
            this.creatorSubscriptionsCount = creatorSubscriptionsCount
        }

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

        fun hasGraduatedAccess(hasGraduatedAccess: Boolean) =
            hasGraduatedAccess(JsonField.of(hasGraduatedAccess))

        /**
         * Sets [Builder.hasGraduatedAccess] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasGraduatedAccess] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun hasGraduatedAccess(hasGraduatedAccess: JsonField<Boolean>) = apply {
            this.hasGraduatedAccess = hasGraduatedAccess
        }

        fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: Boolean) =
            hasHiddenSubscriptionsOnProfile(JsonField.of(hasHiddenSubscriptionsOnProfile))

        /**
         * Sets [Builder.hasHiddenSubscriptionsOnProfile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasHiddenSubscriptionsOnProfile] with a well-typed
         * [Boolean] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: JsonField<Boolean>) =
            apply {
                this.hasHiddenSubscriptionsOnProfile = hasHiddenSubscriptionsOnProfile
            }

        /** Profile highlight availability and count metadata. */
        fun highlightsInfo(highlightsInfo: HighlightsInfo) =
            highlightsInfo(JsonField.of(highlightsInfo))

        /**
         * Sets [Builder.highlightsInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.highlightsInfo] with a well-typed [HighlightsInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun highlightsInfo(highlightsInfo: JsonField<HighlightsInfo>) = apply {
            this.highlightsInfo = highlightsInfo
        }

        /** Identity verification metadata displayed by X. */
        fun identityVerification(identityVerification: IdentityVerification) =
            identityVerification(JsonField.of(identityVerification))

        /**
         * Sets [Builder.identityVerification] to an arbitrary JSON value.
         *
         * You should usually call [Builder.identityVerification] with a well-typed
         * [IdentityVerification] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun identityVerification(identityVerification: JsonField<IdentityVerification>) = apply {
            this.identityVerification = identityVerification
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

        fun isProfileTranslatable(isProfileTranslatable: Boolean) =
            isProfileTranslatable(JsonField.of(isProfileTranslatable))

        /**
         * Sets [Builder.isProfileTranslatable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isProfileTranslatable] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isProfileTranslatable(isProfileTranslatable: JsonField<Boolean>) = apply {
            this.isProfileTranslatable = isProfileTranslatable
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

        fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: String) =
            parodyCommentaryFanLabel(JsonField.of(parodyCommentaryFanLabel))

        /**
         * Sets [Builder.parodyCommentaryFanLabel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parodyCommentaryFanLabel] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: JsonField<String>) = apply {
            this.parodyCommentaryFanLabel = parodyCommentaryFanLabel
        }

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
        fun profileBio(profileBio: ProfileBio) = profileBio(JsonField.of(profileBio))

        /**
         * Sets [Builder.profileBio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileBio] with a well-typed [ProfileBio] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profileBio(profileBio: JsonField<ProfileBio>) = apply { this.profileBio = profileBio }

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

        fun profileDescriptionLanguage(profileDescriptionLanguage: String) =
            profileDescriptionLanguage(JsonField.of(profileDescriptionLanguage))

        /**
         * Sets [Builder.profileDescriptionLanguage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileDescriptionLanguage] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun profileDescriptionLanguage(profileDescriptionLanguage: JsonField<String>) = apply {
            this.profileDescriptionLanguage = profileDescriptionLanguage
        }

        fun profileImageShape(profileImageShape: String) =
            profileImageShape(JsonField.of(profileImageShape))

        /**
         * Sets [Builder.profileImageShape] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileImageShape] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profileImageShape(profileImageShape: JsonField<String>) = apply {
            this.profileImageShape = profileImageShape
        }

        fun profileInterstitialType(profileInterstitialType: String) =
            profileInterstitialType(JsonField.of(profileInterstitialType))

        /**
         * Sets [Builder.profileInterstitialType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileInterstitialType] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun profileInterstitialType(profileInterstitialType: JsonField<String>) = apply {
            this.profileInterstitialType = profileInterstitialType
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

        fun profileSortEnabled(profileSortEnabled: Boolean) =
            profileSortEnabled(JsonField.of(profileSortEnabled))

        /**
         * Sets [Builder.profileSortEnabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileSortEnabled] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profileSortEnabled(profileSortEnabled: JsonField<Boolean>) = apply {
            this.profileSortEnabled = profileSortEnabled
        }

        fun profileTranslatorType(profileTranslatorType: String) =
            profileTranslatorType(JsonField.of(profileTranslatorType))

        /**
         * Sets [Builder.profileTranslatorType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profileTranslatorType] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profileTranslatorType(profileTranslatorType: JsonField<String>) = apply {
            this.profileTranslatorType = profileTranslatorType
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

        fun superFollowEligible(superFollowEligible: Boolean) =
            superFollowEligible(JsonField.of(superFollowEligible))

        /**
         * Sets [Builder.superFollowEligible] to an arbitrary JSON value.
         *
         * You should usually call [Builder.superFollowEligible] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun superFollowEligible(superFollowEligible: JsonField<Boolean>) = apply {
            this.superFollowEligible = superFollowEligible
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
         * Returns an immutable instance of [UserProfile].
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
        fun build(): UserProfile =
            UserProfile(
                checkRequired("id", id),
                checkRequired("name", name),
                checkRequired("username", username),
                affiliatesHighlightedLabel,
                automatedBy,
                businessAccountAffiliatesCount,
                communityRole,
                coverPicture,
                createdAt,
                creatorSubscriptionsCount,
                description,
                favouritesCount,
                followers,
                following,
                hasCustomTimelines,
                hasGraduatedAccess,
                hasHiddenSubscriptionsOnProfile,
                highlightsInfo,
                identityVerification,
                isAutomated,
                isBlueVerified,
                isProfileTranslatable,
                isTranslator,
                isVerified,
                location,
                mediaCount,
                parodyCommentaryFanLabel,
                (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                possiblySensitive,
                profileBio,
                profileBannerUrl,
                profileDescriptionLanguage,
                profileImageShape,
                profileInterstitialType,
                profilePicture,
                profileSortEnabled,
                profileTranslatorType,
                protected_,
                statusesCount,
                superFollowEligible,
                unavailable,
                unavailableReason,
                url,
                verified,
                verifiedType,
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
    fun validate(): UserProfile = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        username()
        affiliatesHighlightedLabel().ifPresent { it.validate() }
        automatedBy()
        businessAccountAffiliatesCount()
        communityRole()
        coverPicture()
        createdAt()
        creatorSubscriptionsCount()
        description()
        favouritesCount()
        followers()
        following()
        hasCustomTimelines()
        hasGraduatedAccess()
        hasHiddenSubscriptionsOnProfile()
        highlightsInfo().ifPresent { it.validate() }
        identityVerification().ifPresent { it.validate() }
        isAutomated()
        isBlueVerified()
        isProfileTranslatable()
        isTranslator()
        isVerified()
        location()
        mediaCount()
        parodyCommentaryFanLabel()
        pinnedTweetIds()
        possiblySensitive()
        profileBio().ifPresent { it.validate() }
        profileBannerUrl()
        profileDescriptionLanguage()
        profileImageShape()
        profileInterstitialType()
        profilePicture()
        profileSortEnabled()
        profileTranslatorType()
        protected_()
        statusesCount()
        superFollowEligible()
        unavailable()
        unavailableReason()
        url()
        verified()
        verifiedType()
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
            (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
            (if (automatedBy.asKnown().isPresent) 1 else 0) +
            (if (businessAccountAffiliatesCount.asKnown().isPresent) 1 else 0) +
            (if (communityRole.asKnown().isPresent) 1 else 0) +
            (if (coverPicture.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (creatorSubscriptionsCount.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (favouritesCount.asKnown().isPresent) 1 else 0) +
            (if (followers.asKnown().isPresent) 1 else 0) +
            (if (following.asKnown().isPresent) 1 else 0) +
            (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) +
            (if (hasGraduatedAccess.asKnown().isPresent) 1 else 0) +
            (if (hasHiddenSubscriptionsOnProfile.asKnown().isPresent) 1 else 0) +
            (highlightsInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (identityVerification.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isAutomated.asKnown().isPresent) 1 else 0) +
            (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
            (if (isProfileTranslatable.asKnown().isPresent) 1 else 0) +
            (if (isTranslator.asKnown().isPresent) 1 else 0) +
            (if (isVerified.asKnown().isPresent) 1 else 0) +
            (if (location.asKnown().isPresent) 1 else 0) +
            (if (mediaCount.asKnown().isPresent) 1 else 0) +
            (if (parodyCommentaryFanLabel.asKnown().isPresent) 1 else 0) +
            (pinnedTweetIds.asKnown().getOrNull()?.size ?: 0) +
            (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
            (profileBio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (profileBannerUrl.asKnown().isPresent) 1 else 0) +
            (if (profileDescriptionLanguage.asKnown().isPresent) 1 else 0) +
            (if (profileImageShape.asKnown().isPresent) 1 else 0) +
            (if (profileInterstitialType.asKnown().isPresent) 1 else 0) +
            (if (profilePicture.asKnown().isPresent) 1 else 0) +
            (if (profileSortEnabled.asKnown().isPresent) 1 else 0) +
            (if (profileTranslatorType.asKnown().isPresent) 1 else 0) +
            (if (protected_.asKnown().isPresent) 1 else 0) +
            (if (statusesCount.asKnown().isPresent) 1 else 0) +
            (if (superFollowEligible.asKnown().isPresent) 1 else 0) +
            (if (unavailable.asKnown().isPresent) 1 else 0) +
            (if (unavailableReason.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (verified.asKnown().isPresent) 1 else 0) +
            (if (verifiedType.asKnown().isPresent) 1 else 0) +
            (withheldInCountries.asKnown().getOrNull()?.size ?: 0)

    /** Organization affiliation label shown on an X profile. */
    class AffiliatesHighlightedLabel
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val badgeUrl: JsonField<String>,
        private val description: JsonField<String>,
        private val url: JsonField<String>,
        private val urlType: JsonField<String>,
        private val userLabelDisplayType: JsonField<String>,
        private val userLabelType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("badgeUrl")
            @ExcludeMissing
            badgeUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("urlType") @ExcludeMissing urlType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userLabelDisplayType")
            @ExcludeMissing
            userLabelDisplayType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userLabelType")
            @ExcludeMissing
            userLabelType: JsonField<String> = JsonMissing.of(),
        ) : this(
            badgeUrl,
            description,
            url,
            urlType,
            userLabelDisplayType,
            userLabelType,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun urlType(): Optional<String> = urlType.getOptional("urlType")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun userLabelDisplayType(): Optional<String> =
            userLabelDisplayType.getOptional("userLabelDisplayType")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType")

        /**
         * Returns the raw JSON value of [badgeUrl].
         *
         * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("badgeUrl") @ExcludeMissing fun _badgeUrl(): JsonField<String> = badgeUrl

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [urlType].
         *
         * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

        /**
         * Returns the raw JSON value of [userLabelDisplayType].
         *
         * Unlike [userLabelDisplayType], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("userLabelDisplayType")
        @ExcludeMissing
        fun _userLabelDisplayType(): JsonField<String> = userLabelDisplayType

        /**
         * Returns the raw JSON value of [userLabelType].
         *
         * Unlike [userLabelType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("userLabelType")
        @ExcludeMissing
        fun _userLabelType(): JsonField<String> = userLabelType

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
             * [AffiliatesHighlightedLabel].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AffiliatesHighlightedLabel]. */
        class Builder internal constructor() {

            private var badgeUrl: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var urlType: JsonField<String> = JsonMissing.of()
            private var userLabelDisplayType: JsonField<String> = JsonMissing.of()
            private var userLabelType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) = apply {
                badgeUrl = affiliatesHighlightedLabel.badgeUrl
                description = affiliatesHighlightedLabel.description
                url = affiliatesHighlightedLabel.url
                urlType = affiliatesHighlightedLabel.urlType
                userLabelDisplayType = affiliatesHighlightedLabel.userLabelDisplayType
                userLabelType = affiliatesHighlightedLabel.userLabelType
                additionalProperties =
                    affiliatesHighlightedLabel.additionalProperties.toMutableMap()
            }

            fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

            /**
             * Sets [Builder.badgeUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.badgeUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

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

            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun urlType(urlType: String) = urlType(JsonField.of(urlType))

            /**
             * Sets [Builder.urlType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.urlType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

            fun userLabelDisplayType(userLabelDisplayType: String) =
                userLabelDisplayType(JsonField.of(userLabelDisplayType))

            /**
             * Sets [Builder.userLabelDisplayType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userLabelDisplayType] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun userLabelDisplayType(userLabelDisplayType: JsonField<String>) = apply {
                this.userLabelDisplayType = userLabelDisplayType
            }

            fun userLabelType(userLabelType: String) = userLabelType(JsonField.of(userLabelType))

            /**
             * Sets [Builder.userLabelType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userLabelType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userLabelType(userLabelType: JsonField<String>) = apply {
                this.userLabelType = userLabelType
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
             * Returns an immutable instance of [AffiliatesHighlightedLabel].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AffiliatesHighlightedLabel =
                AffiliatesHighlightedLabel(
                    badgeUrl,
                    description,
                    url,
                    urlType,
                    userLabelDisplayType,
                    userLabelType,
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
        fun validate(): AffiliatesHighlightedLabel = apply {
            if (validated) {
                return@apply
            }

            badgeUrl()
            description()
            url()
            urlType()
            userLabelDisplayType()
            userLabelType()
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
            (if (badgeUrl.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (urlType.asKnown().isPresent) 1 else 0) +
                (if (userLabelDisplayType.asKnown().isPresent) 1 else 0) +
                (if (userLabelType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AffiliatesHighlightedLabel &&
                badgeUrl == other.badgeUrl &&
                description == other.description &&
                url == other.url &&
                urlType == other.urlType &&
                userLabelDisplayType == other.userLabelDisplayType &&
                userLabelType == other.userLabelType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                badgeUrl,
                description,
                url,
                urlType,
                userLabelDisplayType,
                userLabelType,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AffiliatesHighlightedLabel{badgeUrl=$badgeUrl, description=$description, url=$url, urlType=$urlType, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, additionalProperties=$additionalProperties}"
    }

    /** Profile highlight availability and count metadata. */
    class HighlightsInfo
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val canHighlightTweets: JsonField<Boolean>,
        private val highlightedTweets: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("canHighlightTweets")
            @ExcludeMissing
            canHighlightTweets: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("highlightedTweets")
            @ExcludeMissing
            highlightedTweets: JsonField<String> = JsonMissing.of(),
        ) : this(canHighlightTweets, highlightedTweets, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun canHighlightTweets(): Optional<Boolean> =
            canHighlightTweets.getOptional("canHighlightTweets")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun highlightedTweets(): Optional<String> =
            highlightedTweets.getOptional("highlightedTweets")

        /**
         * Returns the raw JSON value of [canHighlightTweets].
         *
         * Unlike [canHighlightTweets], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("canHighlightTweets")
        @ExcludeMissing
        fun _canHighlightTweets(): JsonField<Boolean> = canHighlightTweets

        /**
         * Returns the raw JSON value of [highlightedTweets].
         *
         * Unlike [highlightedTweets], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("highlightedTweets")
        @ExcludeMissing
        fun _highlightedTweets(): JsonField<String> = highlightedTweets

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

            /** Returns a mutable builder for constructing an instance of [HighlightsInfo]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [HighlightsInfo]. */
        class Builder internal constructor() {

            private var canHighlightTweets: JsonField<Boolean> = JsonMissing.of()
            private var highlightedTweets: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(highlightsInfo: HighlightsInfo) = apply {
                canHighlightTweets = highlightsInfo.canHighlightTweets
                highlightedTweets = highlightsInfo.highlightedTweets
                additionalProperties = highlightsInfo.additionalProperties.toMutableMap()
            }

            fun canHighlightTweets(canHighlightTweets: Boolean) =
                canHighlightTweets(JsonField.of(canHighlightTweets))

            /**
             * Sets [Builder.canHighlightTweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.canHighlightTweets] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun canHighlightTweets(canHighlightTweets: JsonField<Boolean>) = apply {
                this.canHighlightTweets = canHighlightTweets
            }

            fun highlightedTweets(highlightedTweets: String) =
                highlightedTweets(JsonField.of(highlightedTweets))

            /**
             * Sets [Builder.highlightedTweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.highlightedTweets] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun highlightedTweets(highlightedTweets: JsonField<String>) = apply {
                this.highlightedTweets = highlightedTweets
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
             * Returns an immutable instance of [HighlightsInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): HighlightsInfo =
                HighlightsInfo(
                    canHighlightTweets,
                    highlightedTweets,
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
        fun validate(): HighlightsInfo = apply {
            if (validated) {
                return@apply
            }

            canHighlightTweets()
            highlightedTweets()
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
            (if (canHighlightTweets.asKnown().isPresent) 1 else 0) +
                (if (highlightedTweets.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is HighlightsInfo &&
                canHighlightTweets == other.canHighlightTweets &&
                highlightedTweets == other.highlightedTweets &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(canHighlightTweets, highlightedTweets, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "HighlightsInfo{canHighlightTweets=$canHighlightTweets, highlightedTweets=$highlightedTweets, additionalProperties=$additionalProperties}"
    }

    /** Identity verification metadata displayed by X. */
    class IdentityVerification
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val isIdentityVerified: JsonField<Boolean>,
        private val verifiedSinceMsec: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isIdentityVerified")
            @ExcludeMissing
            isIdentityVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("verifiedSinceMsec")
            @ExcludeMissing
            verifiedSinceMsec: JsonField<String> = JsonMissing.of(),
        ) : this(description, isIdentityVerified, verifiedSinceMsec, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isIdentityVerified(): Optional<Boolean> =
            isIdentityVerified.getOptional("isIdentityVerified")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun verifiedSinceMsec(): Optional<String> =
            verifiedSinceMsec.getOptional("verifiedSinceMsec")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [isIdentityVerified].
         *
         * Unlike [isIdentityVerified], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("isIdentityVerified")
        @ExcludeMissing
        fun _isIdentityVerified(): JsonField<Boolean> = isIdentityVerified

        /**
         * Returns the raw JSON value of [verifiedSinceMsec].
         *
         * Unlike [verifiedSinceMsec], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verifiedSinceMsec")
        @ExcludeMissing
        fun _verifiedSinceMsec(): JsonField<String> = verifiedSinceMsec

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

            /** Returns a mutable builder for constructing an instance of [IdentityVerification]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IdentityVerification]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var isIdentityVerified: JsonField<Boolean> = JsonMissing.of()
            private var verifiedSinceMsec: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(identityVerification: IdentityVerification) = apply {
                description = identityVerification.description
                isIdentityVerified = identityVerification.isIdentityVerified
                verifiedSinceMsec = identityVerification.verifiedSinceMsec
                additionalProperties = identityVerification.additionalProperties.toMutableMap()
            }

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

            fun isIdentityVerified(isIdentityVerified: Boolean) =
                isIdentityVerified(JsonField.of(isIdentityVerified))

            /**
             * Sets [Builder.isIdentityVerified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isIdentityVerified] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isIdentityVerified(isIdentityVerified: JsonField<Boolean>) = apply {
                this.isIdentityVerified = isIdentityVerified
            }

            fun verifiedSinceMsec(verifiedSinceMsec: String) =
                verifiedSinceMsec(JsonField.of(verifiedSinceMsec))

            /**
             * Sets [Builder.verifiedSinceMsec] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verifiedSinceMsec] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verifiedSinceMsec(verifiedSinceMsec: JsonField<String>) = apply {
                this.verifiedSinceMsec = verifiedSinceMsec
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
             * Returns an immutable instance of [IdentityVerification].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IdentityVerification =
                IdentityVerification(
                    description,
                    isIdentityVerified,
                    verifiedSinceMsec,
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
        fun validate(): IdentityVerification = apply {
            if (validated) {
                return@apply
            }

            description()
            isIdentityVerified()
            verifiedSinceMsec()
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (isIdentityVerified.asKnown().isPresent) 1 else 0) +
                (if (verifiedSinceMsec.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IdentityVerification &&
                description == other.description &&
                isIdentityVerified == other.isIdentityVerified &&
                verifiedSinceMsec == other.verifiedSinceMsec &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(description, isIdentityVerified, verifiedSinceMsec, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IdentityVerification{description=$description, isIdentityVerified=$isIdentityVerified, verifiedSinceMsec=$verifiedSinceMsec, additionalProperties=$additionalProperties}"
    }

    /** Structured profile bio with entity annotations */
    class ProfileBio
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [ProfileBio]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProfileBio]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(profileBio: ProfileBio) = apply {
                additionalProperties = profileBio.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [ProfileBio].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProfileBio = ProfileBio(additionalProperties.toImmutable())
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
        fun validate(): ProfileBio = apply {
            if (validated) {
                return@apply
            }

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
        internal fun validity(): Int = additionalProperties.count { (_, value) ->
            !value.isNull() && !value.isMissing()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ProfileBio && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "ProfileBio{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserProfile &&
            id == other.id &&
            name == other.name &&
            username == other.username &&
            affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
            automatedBy == other.automatedBy &&
            businessAccountAffiliatesCount == other.businessAccountAffiliatesCount &&
            communityRole == other.communityRole &&
            coverPicture == other.coverPicture &&
            createdAt == other.createdAt &&
            creatorSubscriptionsCount == other.creatorSubscriptionsCount &&
            description == other.description &&
            favouritesCount == other.favouritesCount &&
            followers == other.followers &&
            following == other.following &&
            hasCustomTimelines == other.hasCustomTimelines &&
            hasGraduatedAccess == other.hasGraduatedAccess &&
            hasHiddenSubscriptionsOnProfile == other.hasHiddenSubscriptionsOnProfile &&
            highlightsInfo == other.highlightsInfo &&
            identityVerification == other.identityVerification &&
            isAutomated == other.isAutomated &&
            isBlueVerified == other.isBlueVerified &&
            isProfileTranslatable == other.isProfileTranslatable &&
            isTranslator == other.isTranslator &&
            isVerified == other.isVerified &&
            location == other.location &&
            mediaCount == other.mediaCount &&
            parodyCommentaryFanLabel == other.parodyCommentaryFanLabel &&
            pinnedTweetIds == other.pinnedTweetIds &&
            possiblySensitive == other.possiblySensitive &&
            profileBio == other.profileBio &&
            profileBannerUrl == other.profileBannerUrl &&
            profileDescriptionLanguage == other.profileDescriptionLanguage &&
            profileImageShape == other.profileImageShape &&
            profileInterstitialType == other.profileInterstitialType &&
            profilePicture == other.profilePicture &&
            profileSortEnabled == other.profileSortEnabled &&
            profileTranslatorType == other.profileTranslatorType &&
            protected_ == other.protected_ &&
            statusesCount == other.statusesCount &&
            superFollowEligible == other.superFollowEligible &&
            unavailable == other.unavailable &&
            unavailableReason == other.unavailableReason &&
            url == other.url &&
            verified == other.verified &&
            verifiedType == other.verifiedType &&
            withheldInCountries == other.withheldInCountries &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            name,
            username,
            affiliatesHighlightedLabel,
            automatedBy,
            businessAccountAffiliatesCount,
            communityRole,
            coverPicture,
            createdAt,
            creatorSubscriptionsCount,
            description,
            favouritesCount,
            followers,
            following,
            hasCustomTimelines,
            hasGraduatedAccess,
            hasHiddenSubscriptionsOnProfile,
            highlightsInfo,
            identityVerification,
            isAutomated,
            isBlueVerified,
            isProfileTranslatable,
            isTranslator,
            isVerified,
            location,
            mediaCount,
            parodyCommentaryFanLabel,
            pinnedTweetIds,
            possiblySensitive,
            profileBio,
            profileBannerUrl,
            profileDescriptionLanguage,
            profileImageShape,
            profileInterstitialType,
            profilePicture,
            profileSortEnabled,
            profileTranslatorType,
            protected_,
            statusesCount,
            superFollowEligible,
            unavailable,
            unavailableReason,
            url,
            verified,
            verifiedType,
            withheldInCountries,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserProfile{id=$id, name=$name, username=$username, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, automatedBy=$automatedBy, businessAccountAffiliatesCount=$businessAccountAffiliatesCount, communityRole=$communityRole, coverPicture=$coverPicture, createdAt=$createdAt, creatorSubscriptionsCount=$creatorSubscriptionsCount, description=$description, favouritesCount=$favouritesCount, followers=$followers, following=$following, hasCustomTimelines=$hasCustomTimelines, hasGraduatedAccess=$hasGraduatedAccess, hasHiddenSubscriptionsOnProfile=$hasHiddenSubscriptionsOnProfile, highlightsInfo=$highlightsInfo, identityVerification=$identityVerification, isAutomated=$isAutomated, isBlueVerified=$isBlueVerified, isProfileTranslatable=$isProfileTranslatable, isTranslator=$isTranslator, isVerified=$isVerified, location=$location, mediaCount=$mediaCount, parodyCommentaryFanLabel=$parodyCommentaryFanLabel, pinnedTweetIds=$pinnedTweetIds, possiblySensitive=$possiblySensitive, profileBio=$profileBio, profileBannerUrl=$profileBannerUrl, profileDescriptionLanguage=$profileDescriptionLanguage, profileImageShape=$profileImageShape, profileInterstitialType=$profileInterstitialType, profilePicture=$profilePicture, profileSortEnabled=$profileSortEnabled, profileTranslatorType=$profileTranslatorType, protected_=$protected_, statusesCount=$statusesCount, superFollowEligible=$superFollowEligible, unavailable=$unavailable, unavailableReason=$unavailableReason, url=$url, verified=$verified, verifiedType=$verifiedType, withheldInCountries=$withheldInCountries, additionalProperties=$additionalProperties}"
}
