// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communitynotes

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
import com.x_twitter_scraper.api.models.SearchTweet
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** 1 page of Community Notes. Follow next_cursor while the response reports more pages. */
class CommunityNoteListContributorDeletedNotesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val notes: JsonField<List<Note>>,
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
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<List<Note>> = JsonMissing.of(),
    ) : this(hasNextPage, nextCursor, notes, mutableMapOf())

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
    fun notes(): List<Note> = notes.getRequired("notes")

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
     * Returns the raw JSON value of [notes].
     *
     * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<List<Note>> = notes

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
         * [CommunityNoteListContributorDeletedNotesResponse].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .notes()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityNoteListContributorDeletedNotesResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var notes: JsonField<MutableList<Note>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            communityNoteListContributorDeletedNotesResponse:
                CommunityNoteListContributorDeletedNotesResponse
        ) = apply {
            hasNextPage = communityNoteListContributorDeletedNotesResponse.hasNextPage
            nextCursor = communityNoteListContributorDeletedNotesResponse.nextCursor
            notes =
                communityNoteListContributorDeletedNotesResponse.notes.map { it.toMutableList() }
            additionalProperties =
                communityNoteListContributorDeletedNotesResponse.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun notes(notes: List<Note>) = notes(JsonField.of(notes))

        /** Sets [Builder.notes] to an arbitrary JSON value. */
        fun notes(notes: JsonField<List<Note>>) = apply {
            this.notes = notes.map { it.toMutableList() }
        }

        /**
         * Adds a single [Note] to [notes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addNote(note: Note) = apply {
            notes =
                (notes ?: JsonField.of(mutableListOf())).also { checkKnown("notes", it).add(note) }
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
         * Returns an immutable instance of [CommunityNoteListContributorDeletedNotesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .notes()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityNoteListContributorDeletedNotesResponse =
            CommunityNoteListContributorDeletedNotesResponse(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("notes", notes).map { it.toImmutable() },
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
    fun validate(): CommunityNoteListContributorDeletedNotesResponse = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
        notes().forEach { it.validate() }
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
            (notes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    /**
     * A Community Note as its writer's page lists it, with the post it is on. A deleted note has no
     * text, classification or post. A field X leaves out is left out.
     */
    class Note
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val abovePcrhThreshold: JsonField<Boolean>,
        private val appealStatus: JsonField<String>,
        private val classification: JsonField<String>,
        private val contributor: JsonField<Contributor>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val decidedBy: JsonField<String>,
        private val deleted: JsonField<Boolean>,
        private val displayUrl: JsonField<String>,
        private val entities: JsonField<List<Entity>>,
        private val fullyVisibleModel: JsonField<Boolean>,
        private val helpfulTags: JsonField<List<String>>,
        private val impressionCount: JsonField<Long>,
        private val isApiAuthor: JsonField<Boolean>,
        private val isMediaNote: JsonField<Boolean>,
        private val isTranslatable: JsonField<Boolean>,
        private val isUrlNote: JsonField<Boolean>,
        private val language: JsonField<String>,
        private val mediaNoteMatchCount: JsonField<Long>,
        private val notHelpfulTags: JsonField<List<String>>,
        private val post: JsonField<SearchTweet>,
        private val postId: JsonField<String>,
        private val postUnavailable: JsonField<PostUnavailable>,
        private val ratingStatus: JsonField<String>,
        private val text: JsonField<String>,
        private val timeToHelpfulFromNoteMs: JsonField<Long>,
        private val timeToHelpfulFromPostMs: JsonField<Long>,
        private val tombstone: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("abovePcrhThreshold")
            @ExcludeMissing
            abovePcrhThreshold: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("appealStatus")
            @ExcludeMissing
            appealStatus: JsonField<String> = JsonMissing.of(),
            @JsonProperty("classification")
            @ExcludeMissing
            classification: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contributor")
            @ExcludeMissing
            contributor: JsonField<Contributor> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("decidedBy")
            @ExcludeMissing
            decidedBy: JsonField<String> = JsonMissing.of(),
            @JsonProperty("deleted") @ExcludeMissing deleted: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("displayUrl")
            @ExcludeMissing
            displayUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entities")
            @ExcludeMissing
            entities: JsonField<List<Entity>> = JsonMissing.of(),
            @JsonProperty("fullyVisibleModel")
            @ExcludeMissing
            fullyVisibleModel: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("helpfulTags")
            @ExcludeMissing
            helpfulTags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("impressionCount")
            @ExcludeMissing
            impressionCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("isApiAuthor")
            @ExcludeMissing
            isApiAuthor: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isMediaNote")
            @ExcludeMissing
            isMediaNote: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isTranslatable")
            @ExcludeMissing
            isTranslatable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isUrlNote")
            @ExcludeMissing
            isUrlNote: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mediaNoteMatchCount")
            @ExcludeMissing
            mediaNoteMatchCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("notHelpfulTags")
            @ExcludeMissing
            notHelpfulTags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("post") @ExcludeMissing post: JsonField<SearchTweet> = JsonMissing.of(),
            @JsonProperty("postId") @ExcludeMissing postId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postUnavailable")
            @ExcludeMissing
            postUnavailable: JsonField<PostUnavailable> = JsonMissing.of(),
            @JsonProperty("ratingStatus")
            @ExcludeMissing
            ratingStatus: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timeToHelpfulFromNoteMs")
            @ExcludeMissing
            timeToHelpfulFromNoteMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("timeToHelpfulFromPostMs")
            @ExcludeMissing
            timeToHelpfulFromPostMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("tombstone")
            @ExcludeMissing
            tombstone: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            abovePcrhThreshold,
            appealStatus,
            classification,
            contributor,
            createdAt,
            decidedBy,
            deleted,
            displayUrl,
            entities,
            fullyVisibleModel,
            helpfulTags,
            impressionCount,
            isApiAuthor,
            isMediaNote,
            isTranslatable,
            isUrlNote,
            language,
            mediaNoteMatchCount,
            notHelpfulTags,
            post,
            postId,
            postUnavailable,
            ratingStatus,
            text,
            timeToHelpfulFromNoteMs,
            timeToHelpfulFromPostMs,
            tombstone,
            mutableMapOf(),
        )

        /**
         * Note ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Whether the note scores above X's bar for a possible helpful rating.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun abovePcrhThreshold(): Optional<Boolean> =
            abovePcrhThreshold.getOptional("abovePcrhThreshold")

        /**
         * Whether the rating is under appeal.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun appealStatus(): Optional<String> = appealStatus.getOptional("appealStatus")

        /**
         * What the writer says of the post, such as MisinformedOrPotentiallyMisleading or
         * NotMisleading.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun classification(): Optional<String> = classification.getOptional("classification")

        /**
         * The note's writer, with the counts X sends beside a note. GET
         * /x/community-notes/contributors/{alias} serves every count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun contributor(): Optional<Contributor> = contributor.getOptional("contributor")

        /**
         * When the contributor wrote the note.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * The X scoring model that set the rating.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun decidedBy(): Optional<String> = decidedBy.getOptional("decidedBy")

        /**
         * Whether the writer deleted the note.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun deleted(): Optional<Boolean> = deleted.getOptional("deleted")

        /**
         * The link a link note is on, as X shows it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun displayUrl(): Optional<String> = displayUrl.getOptional("displayUrl")

        /**
         * Links, tags & accounts inside the text, by character range.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun entities(): Optional<List<Entity>> = entities.getOptional("entities")

        /**
         * Whether X marks that scoring model as fully visible.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun fullyVisibleModel(): Optional<Boolean> =
            fullyVisibleModel.getOptional("fullyVisibleModel")

        /**
         * Why raters called the note helpful.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun helpfulTags(): Optional<List<String>> = helpfulTags.getOptional("helpfulTags")

        /**
         * Views of the note, when X shares them.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun impressionCount(): Optional<Long> = impressionCount.getOptional("impressionCount")

        /**
         * Whether the note came through X's API.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isApiAuthor(): Optional<Boolean> = isApiAuthor.getOptional("isApiAuthor")

        /**
         * Whether the note is about the post's media. X can show such a note on other posts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isMediaNote(): Optional<Boolean> = isMediaNote.getOptional("isMediaNote")

        /**
         * Whether X offers a translation of the note.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isTranslatable(): Optional<Boolean> = isTranslatable.getOptional("isTranslatable")

        /**
         * Whether the note is on a link.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isUrlNote(): Optional<Boolean> = isUrlNote.getOptional("isUrlNote")

        /**
         * Language code of the note.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * Other posts X matched a media note to.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun mediaNoteMatchCount(): Optional<Long> =
            mediaNoteMatchCount.getOptional("mediaNoteMatchCount")

        /**
         * Why raters called the note not helpful.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun notHelpfulTags(): Optional<List<String>> = notHelpfulTags.getOptional("notHelpfulTags")

        /**
         * The post the note is on. Null when X no longer shows it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun post(): Optional<SearchTweet> = post.getOptional("post")

        /**
         * ID of the post the note is on.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun postId(): Optional<String> = postId.getOptional("postId")

        /**
         * Why X shows no post, when X says.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun postUnavailable(): Optional<PostUnavailable> =
            postUnavailable.getOptional("postUnavailable")

        /**
         * X's current rating, such as NeedsMoreRatings, CurrentlyRatedHelpful or
         * CurrentlyRatedNotHelpful. x.com shows only helpful notes under posts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun ratingStatus(): Optional<String> = ratingStatus.getOptional("ratingStatus")

        /**
         * What the note says.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun text(): Optional<String> = text.getOptional("text")

        /**
         * Milliseconds from the note's creation to its helpful rating.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun timeToHelpfulFromNoteMs(): Optional<Long> =
            timeToHelpfulFromNoteMs.getOptional("timeToHelpfulFromNoteMs")

        /**
         * Milliseconds from the post's creation to the note's helpful rating.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun timeToHelpfulFromPostMs(): Optional<Long> =
            timeToHelpfulFromPostMs.getOptional("timeToHelpfulFromPostMs")

        /**
         * X's notice in place of a deleted note.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tombstone(): Optional<String> = tombstone.getOptional("tombstone")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [abovePcrhThreshold].
         *
         * Unlike [abovePcrhThreshold], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("abovePcrhThreshold")
        @ExcludeMissing
        fun _abovePcrhThreshold(): JsonField<Boolean> = abovePcrhThreshold

        /**
         * Returns the raw JSON value of [appealStatus].
         *
         * Unlike [appealStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("appealStatus")
        @ExcludeMissing
        fun _appealStatus(): JsonField<String> = appealStatus

        /**
         * Returns the raw JSON value of [classification].
         *
         * Unlike [classification], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("classification")
        @ExcludeMissing
        fun _classification(): JsonField<String> = classification

        /**
         * Returns the raw JSON value of [contributor].
         *
         * Unlike [contributor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contributor")
        @ExcludeMissing
        fun _contributor(): JsonField<Contributor> = contributor

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [decidedBy].
         *
         * Unlike [decidedBy], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("decidedBy") @ExcludeMissing fun _decidedBy(): JsonField<String> = decidedBy

        /**
         * Returns the raw JSON value of [deleted].
         *
         * Unlike [deleted], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

        /**
         * Returns the raw JSON value of [displayUrl].
         *
         * Unlike [displayUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("displayUrl")
        @ExcludeMissing
        fun _displayUrl(): JsonField<String> = displayUrl

        /**
         * Returns the raw JSON value of [entities].
         *
         * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entities")
        @ExcludeMissing
        fun _entities(): JsonField<List<Entity>> = entities

        /**
         * Returns the raw JSON value of [fullyVisibleModel].
         *
         * Unlike [fullyVisibleModel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("fullyVisibleModel")
        @ExcludeMissing
        fun _fullyVisibleModel(): JsonField<Boolean> = fullyVisibleModel

        /**
         * Returns the raw JSON value of [helpfulTags].
         *
         * Unlike [helpfulTags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("helpfulTags")
        @ExcludeMissing
        fun _helpfulTags(): JsonField<List<String>> = helpfulTags

        /**
         * Returns the raw JSON value of [impressionCount].
         *
         * Unlike [impressionCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("impressionCount")
        @ExcludeMissing
        fun _impressionCount(): JsonField<Long> = impressionCount

        /**
         * Returns the raw JSON value of [isApiAuthor].
         *
         * Unlike [isApiAuthor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isApiAuthor")
        @ExcludeMissing
        fun _isApiAuthor(): JsonField<Boolean> = isApiAuthor

        /**
         * Returns the raw JSON value of [isMediaNote].
         *
         * Unlike [isMediaNote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isMediaNote")
        @ExcludeMissing
        fun _isMediaNote(): JsonField<Boolean> = isMediaNote

        /**
         * Returns the raw JSON value of [isTranslatable].
         *
         * Unlike [isTranslatable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isTranslatable")
        @ExcludeMissing
        fun _isTranslatable(): JsonField<Boolean> = isTranslatable

        /**
         * Returns the raw JSON value of [isUrlNote].
         *
         * Unlike [isUrlNote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isUrlNote") @ExcludeMissing fun _isUrlNote(): JsonField<Boolean> = isUrlNote

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [mediaNoteMatchCount].
         *
         * Unlike [mediaNoteMatchCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("mediaNoteMatchCount")
        @ExcludeMissing
        fun _mediaNoteMatchCount(): JsonField<Long> = mediaNoteMatchCount

        /**
         * Returns the raw JSON value of [notHelpfulTags].
         *
         * Unlike [notHelpfulTags], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("notHelpfulTags")
        @ExcludeMissing
        fun _notHelpfulTags(): JsonField<List<String>> = notHelpfulTags

        /**
         * Returns the raw JSON value of [post].
         *
         * Unlike [post], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("post") @ExcludeMissing fun _post(): JsonField<SearchTweet> = post

        /**
         * Returns the raw JSON value of [postId].
         *
         * Unlike [postId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postId") @ExcludeMissing fun _postId(): JsonField<String> = postId

        /**
         * Returns the raw JSON value of [postUnavailable].
         *
         * Unlike [postUnavailable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("postUnavailable")
        @ExcludeMissing
        fun _postUnavailable(): JsonField<PostUnavailable> = postUnavailable

        /**
         * Returns the raw JSON value of [ratingStatus].
         *
         * Unlike [ratingStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ratingStatus")
        @ExcludeMissing
        fun _ratingStatus(): JsonField<String> = ratingStatus

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [timeToHelpfulFromNoteMs].
         *
         * Unlike [timeToHelpfulFromNoteMs], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("timeToHelpfulFromNoteMs")
        @ExcludeMissing
        fun _timeToHelpfulFromNoteMs(): JsonField<Long> = timeToHelpfulFromNoteMs

        /**
         * Returns the raw JSON value of [timeToHelpfulFromPostMs].
         *
         * Unlike [timeToHelpfulFromPostMs], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("timeToHelpfulFromPostMs")
        @ExcludeMissing
        fun _timeToHelpfulFromPostMs(): JsonField<Long> = timeToHelpfulFromPostMs

        /**
         * Returns the raw JSON value of [tombstone].
         *
         * Unlike [tombstone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tombstone") @ExcludeMissing fun _tombstone(): JsonField<String> = tombstone

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
             * Returns a mutable builder for constructing an instance of [Note].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Note]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var abovePcrhThreshold: JsonField<Boolean> = JsonMissing.of()
            private var appealStatus: JsonField<String> = JsonMissing.of()
            private var classification: JsonField<String> = JsonMissing.of()
            private var contributor: JsonField<Contributor> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var decidedBy: JsonField<String> = JsonMissing.of()
            private var deleted: JsonField<Boolean> = JsonMissing.of()
            private var displayUrl: JsonField<String> = JsonMissing.of()
            private var entities: JsonField<MutableList<Entity>>? = null
            private var fullyVisibleModel: JsonField<Boolean> = JsonMissing.of()
            private var helpfulTags: JsonField<MutableList<String>>? = null
            private var impressionCount: JsonField<Long> = JsonMissing.of()
            private var isApiAuthor: JsonField<Boolean> = JsonMissing.of()
            private var isMediaNote: JsonField<Boolean> = JsonMissing.of()
            private var isTranslatable: JsonField<Boolean> = JsonMissing.of()
            private var isUrlNote: JsonField<Boolean> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var mediaNoteMatchCount: JsonField<Long> = JsonMissing.of()
            private var notHelpfulTags: JsonField<MutableList<String>>? = null
            private var post: JsonField<SearchTweet> = JsonMissing.of()
            private var postId: JsonField<String> = JsonMissing.of()
            private var postUnavailable: JsonField<PostUnavailable> = JsonMissing.of()
            private var ratingStatus: JsonField<String> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var timeToHelpfulFromNoteMs: JsonField<Long> = JsonMissing.of()
            private var timeToHelpfulFromPostMs: JsonField<Long> = JsonMissing.of()
            private var tombstone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(note: Note) = apply {
                id = note.id
                abovePcrhThreshold = note.abovePcrhThreshold
                appealStatus = note.appealStatus
                classification = note.classification
                contributor = note.contributor
                createdAt = note.createdAt
                decidedBy = note.decidedBy
                deleted = note.deleted
                displayUrl = note.displayUrl
                entities = note.entities.map { it.toMutableList() }
                fullyVisibleModel = note.fullyVisibleModel
                helpfulTags = note.helpfulTags.map { it.toMutableList() }
                impressionCount = note.impressionCount
                isApiAuthor = note.isApiAuthor
                isMediaNote = note.isMediaNote
                isTranslatable = note.isTranslatable
                isUrlNote = note.isUrlNote
                language = note.language
                mediaNoteMatchCount = note.mediaNoteMatchCount
                notHelpfulTags = note.notHelpfulTags.map { it.toMutableList() }
                post = note.post
                postId = note.postId
                postUnavailable = note.postUnavailable
                ratingStatus = note.ratingStatus
                text = note.text
                timeToHelpfulFromNoteMs = note.timeToHelpfulFromNoteMs
                timeToHelpfulFromPostMs = note.timeToHelpfulFromPostMs
                tombstone = note.tombstone
                additionalProperties = note.additionalProperties.toMutableMap()
            }

            /** Note ID. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Whether the note scores above X's bar for a possible helpful rating. */
            fun abovePcrhThreshold(abovePcrhThreshold: Boolean) =
                abovePcrhThreshold(JsonField.of(abovePcrhThreshold))

            /** Sets [Builder.abovePcrhThreshold] to an arbitrary JSON value. */
            fun abovePcrhThreshold(abovePcrhThreshold: JsonField<Boolean>) = apply {
                this.abovePcrhThreshold = abovePcrhThreshold
            }

            /** Whether the rating is under appeal. */
            fun appealStatus(appealStatus: String) = appealStatus(JsonField.of(appealStatus))

            /** Sets [Builder.appealStatus] to an arbitrary JSON value. */
            fun appealStatus(appealStatus: JsonField<String>) = apply {
                this.appealStatus = appealStatus
            }

            /**
             * What the writer says of the post, such as MisinformedOrPotentiallyMisleading or
             * NotMisleading.
             */
            fun classification(classification: String) =
                classification(JsonField.of(classification))

            /** Sets [Builder.classification] to an arbitrary JSON value. */
            fun classification(classification: JsonField<String>) = apply {
                this.classification = classification
            }

            /**
             * The note's writer, with the counts X sends beside a note. GET
             * /x/community-notes/contributors/{alias} serves every count.
             */
            fun contributor(contributor: Contributor) = contributor(JsonField.of(contributor))

            /** Sets [Builder.contributor] to an arbitrary JSON value. */
            fun contributor(contributor: JsonField<Contributor>) = apply {
                this.contributor = contributor
            }

            /** When the contributor wrote the note. */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** The X scoring model that set the rating. */
            fun decidedBy(decidedBy: String) = decidedBy(JsonField.of(decidedBy))

            /** Sets [Builder.decidedBy] to an arbitrary JSON value. */
            fun decidedBy(decidedBy: JsonField<String>) = apply { this.decidedBy = decidedBy }

            /** Whether the writer deleted the note. */
            fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

            /** Sets [Builder.deleted] to an arbitrary JSON value. */
            fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

            /** The link a link note is on, as X shows it. */
            fun displayUrl(displayUrl: String) = displayUrl(JsonField.of(displayUrl))

            /** Sets [Builder.displayUrl] to an arbitrary JSON value. */
            fun displayUrl(displayUrl: JsonField<String>) = apply { this.displayUrl = displayUrl }

            /** Links, tags & accounts inside the text, by character range. */
            fun entities(entities: List<Entity>) = entities(JsonField.of(entities))

            /** Sets [Builder.entities] to an arbitrary JSON value. */
            fun entities(entities: JsonField<List<Entity>>) = apply {
                this.entities = entities.map { it.toMutableList() }
            }

            /**
             * Adds a single [Entity] to [entities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEntity(entity: Entity) = apply {
                entities =
                    (entities ?: JsonField.of(mutableListOf())).also {
                        checkKnown("entities", it).add(entity)
                    }
            }

            /** Whether X marks that scoring model as fully visible. */
            fun fullyVisibleModel(fullyVisibleModel: Boolean) =
                fullyVisibleModel(JsonField.of(fullyVisibleModel))

            /** Sets [Builder.fullyVisibleModel] to an arbitrary JSON value. */
            fun fullyVisibleModel(fullyVisibleModel: JsonField<Boolean>) = apply {
                this.fullyVisibleModel = fullyVisibleModel
            }

            /** Why raters called the note helpful. */
            fun helpfulTags(helpfulTags: List<String>) = helpfulTags(JsonField.of(helpfulTags))

            /** Sets [Builder.helpfulTags] to an arbitrary JSON value. */
            fun helpfulTags(helpfulTags: JsonField<List<String>>) = apply {
                this.helpfulTags = helpfulTags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [helpfulTags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addHelpfulTag(helpfulTag: String) = apply {
                helpfulTags =
                    (helpfulTags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("helpfulTags", it).add(helpfulTag)
                    }
            }

            /** Views of the note, when X shares them. */
            fun impressionCount(impressionCount: Long) =
                impressionCount(JsonField.of(impressionCount))

            /** Sets [Builder.impressionCount] to an arbitrary JSON value. */
            fun impressionCount(impressionCount: JsonField<Long>) = apply {
                this.impressionCount = impressionCount
            }

            /** Whether the note came through X's API. */
            fun isApiAuthor(isApiAuthor: Boolean) = isApiAuthor(JsonField.of(isApiAuthor))

            /** Sets [Builder.isApiAuthor] to an arbitrary JSON value. */
            fun isApiAuthor(isApiAuthor: JsonField<Boolean>) = apply {
                this.isApiAuthor = isApiAuthor
            }

            /**
             * Whether the note is about the post's media. X can show such a note on other posts.
             */
            fun isMediaNote(isMediaNote: Boolean) = isMediaNote(JsonField.of(isMediaNote))

            /** Sets [Builder.isMediaNote] to an arbitrary JSON value. */
            fun isMediaNote(isMediaNote: JsonField<Boolean>) = apply {
                this.isMediaNote = isMediaNote
            }

            /** Whether X offers a translation of the note. */
            fun isTranslatable(isTranslatable: Boolean) =
                isTranslatable(JsonField.of(isTranslatable))

            /** Sets [Builder.isTranslatable] to an arbitrary JSON value. */
            fun isTranslatable(isTranslatable: JsonField<Boolean>) = apply {
                this.isTranslatable = isTranslatable
            }

            /** Whether the note is on a link. */
            fun isUrlNote(isUrlNote: Boolean) = isUrlNote(JsonField.of(isUrlNote))

            /** Sets [Builder.isUrlNote] to an arbitrary JSON value. */
            fun isUrlNote(isUrlNote: JsonField<Boolean>) = apply { this.isUrlNote = isUrlNote }

            /** Language code of the note. */
            fun language(language: String) = language(JsonField.of(language))

            /** Sets [Builder.language] to an arbitrary JSON value. */
            fun language(language: JsonField<String>) = apply { this.language = language }

            /** Other posts X matched a media note to. */
            fun mediaNoteMatchCount(mediaNoteMatchCount: Long) =
                mediaNoteMatchCount(JsonField.of(mediaNoteMatchCount))

            /** Sets [Builder.mediaNoteMatchCount] to an arbitrary JSON value. */
            fun mediaNoteMatchCount(mediaNoteMatchCount: JsonField<Long>) = apply {
                this.mediaNoteMatchCount = mediaNoteMatchCount
            }

            /** Why raters called the note not helpful. */
            fun notHelpfulTags(notHelpfulTags: List<String>) =
                notHelpfulTags(JsonField.of(notHelpfulTags))

            /** Sets [Builder.notHelpfulTags] to an arbitrary JSON value. */
            fun notHelpfulTags(notHelpfulTags: JsonField<List<String>>) = apply {
                this.notHelpfulTags = notHelpfulTags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [notHelpfulTags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addNotHelpfulTag(notHelpfulTag: String) = apply {
                notHelpfulTags =
                    (notHelpfulTags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("notHelpfulTags", it).add(notHelpfulTag)
                    }
            }

            /** The post the note is on. Null when X no longer shows it. */
            fun post(post: SearchTweet?) = post(JsonField.ofNullable(post))

            /** Alias for calling [Builder.post] with `post.orElse(null)`. */
            fun post(post: Optional<SearchTweet>) = post(post.getOrNull())

            /** Sets [Builder.post] to an arbitrary JSON value. */
            fun post(post: JsonField<SearchTweet>) = apply { this.post = post }

            /** ID of the post the note is on. */
            fun postId(postId: String) = postId(JsonField.of(postId))

            /** Sets [Builder.postId] to an arbitrary JSON value. */
            fun postId(postId: JsonField<String>) = apply { this.postId = postId }

            /** Why X shows no post, when X says. */
            fun postUnavailable(postUnavailable: PostUnavailable) =
                postUnavailable(JsonField.of(postUnavailable))

            /** Sets [Builder.postUnavailable] to an arbitrary JSON value. */
            fun postUnavailable(postUnavailable: JsonField<PostUnavailable>) = apply {
                this.postUnavailable = postUnavailable
            }

            /**
             * X's current rating, such as NeedsMoreRatings, CurrentlyRatedHelpful or
             * CurrentlyRatedNotHelpful. x.com shows only helpful notes under posts.
             */
            fun ratingStatus(ratingStatus: String) = ratingStatus(JsonField.of(ratingStatus))

            /** Sets [Builder.ratingStatus] to an arbitrary JSON value. */
            fun ratingStatus(ratingStatus: JsonField<String>) = apply {
                this.ratingStatus = ratingStatus
            }

            /** What the note says. */
            fun text(text: String) = text(JsonField.of(text))

            /** Sets [Builder.text] to an arbitrary JSON value. */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /** Milliseconds from the note's creation to its helpful rating. */
            fun timeToHelpfulFromNoteMs(timeToHelpfulFromNoteMs: Long) =
                timeToHelpfulFromNoteMs(JsonField.of(timeToHelpfulFromNoteMs))

            /** Sets [Builder.timeToHelpfulFromNoteMs] to an arbitrary JSON value. */
            fun timeToHelpfulFromNoteMs(timeToHelpfulFromNoteMs: JsonField<Long>) = apply {
                this.timeToHelpfulFromNoteMs = timeToHelpfulFromNoteMs
            }

            /** Milliseconds from the post's creation to the note's helpful rating. */
            fun timeToHelpfulFromPostMs(timeToHelpfulFromPostMs: Long) =
                timeToHelpfulFromPostMs(JsonField.of(timeToHelpfulFromPostMs))

            /** Sets [Builder.timeToHelpfulFromPostMs] to an arbitrary JSON value. */
            fun timeToHelpfulFromPostMs(timeToHelpfulFromPostMs: JsonField<Long>) = apply {
                this.timeToHelpfulFromPostMs = timeToHelpfulFromPostMs
            }

            /** X's notice in place of a deleted note. */
            fun tombstone(tombstone: String) = tombstone(JsonField.of(tombstone))

            /** Sets [Builder.tombstone] to an arbitrary JSON value. */
            fun tombstone(tombstone: JsonField<String>) = apply { this.tombstone = tombstone }

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
             * Returns an immutable instance of [Note].
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
            fun build(): Note =
                Note(
                    checkRequired("id", id),
                    abovePcrhThreshold,
                    appealStatus,
                    classification,
                    contributor,
                    createdAt,
                    decidedBy,
                    deleted,
                    displayUrl,
                    (entities ?: JsonMissing.of()).map { it.toImmutable() },
                    fullyVisibleModel,
                    (helpfulTags ?: JsonMissing.of()).map { it.toImmutable() },
                    impressionCount,
                    isApiAuthor,
                    isMediaNote,
                    isTranslatable,
                    isUrlNote,
                    language,
                    mediaNoteMatchCount,
                    (notHelpfulTags ?: JsonMissing.of()).map { it.toImmutable() },
                    post,
                    postId,
                    postUnavailable,
                    ratingStatus,
                    text,
                    timeToHelpfulFromNoteMs,
                    timeToHelpfulFromPostMs,
                    tombstone,
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
        fun validate(): Note = apply {
            if (validated) {
                return@apply
            }

            id()
            abovePcrhThreshold()
            appealStatus()
            classification()
            contributor().ifPresent { it.validate() }
            createdAt()
            decidedBy()
            deleted()
            displayUrl()
            entities().ifPresent { it.forEach { it.validate() } }
            fullyVisibleModel()
            helpfulTags()
            impressionCount()
            isApiAuthor()
            isMediaNote()
            isTranslatable()
            isUrlNote()
            language()
            mediaNoteMatchCount()
            notHelpfulTags()
            post().ifPresent { it.validate() }
            postId()
            postUnavailable().ifPresent { it.validate() }
            ratingStatus()
            text()
            timeToHelpfulFromNoteMs()
            timeToHelpfulFromPostMs()
            tombstone()
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
                (if (abovePcrhThreshold.asKnown().isPresent) 1 else 0) +
                (if (appealStatus.asKnown().isPresent) 1 else 0) +
                (if (classification.asKnown().isPresent) 1 else 0) +
                (contributor.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (decidedBy.asKnown().isPresent) 1 else 0) +
                (if (deleted.asKnown().isPresent) 1 else 0) +
                (if (displayUrl.asKnown().isPresent) 1 else 0) +
                (entities.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (fullyVisibleModel.asKnown().isPresent) 1 else 0) +
                (helpfulTags.asKnown().getOrNull()?.size ?: 0) +
                (if (impressionCount.asKnown().isPresent) 1 else 0) +
                (if (isApiAuthor.asKnown().isPresent) 1 else 0) +
                (if (isMediaNote.asKnown().isPresent) 1 else 0) +
                (if (isTranslatable.asKnown().isPresent) 1 else 0) +
                (if (isUrlNote.asKnown().isPresent) 1 else 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (mediaNoteMatchCount.asKnown().isPresent) 1 else 0) +
                (notHelpfulTags.asKnown().getOrNull()?.size ?: 0) +
                (post.asKnown().getOrNull()?.validity() ?: 0) +
                (if (postId.asKnown().isPresent) 1 else 0) +
                (postUnavailable.asKnown().getOrNull()?.validity() ?: 0) +
                (if (ratingStatus.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (timeToHelpfulFromNoteMs.asKnown().isPresent) 1 else 0) +
                (if (timeToHelpfulFromPostMs.asKnown().isPresent) 1 else 0) +
                (if (tombstone.asKnown().isPresent) 1 else 0)

        /**
         * A Community Notes contributor. X names contributors by an alias, never by their X
         * account. A field X leaves out is left out. Beside a note, X sends its writer with only
         * some of the counts.
         */
        class Contributor
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val alias: JsonField<String>,
            private val deletedNotesCount: JsonField<Long>,
            private val isApiContributor: JsonField<Boolean>,
            private val isTopWriter: JsonField<Boolean>,
            private val notesCount: JsonField<NotesCount>,
            private val ratingsCount: JsonField<RatingsCount>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("alias") @ExcludeMissing alias: JsonField<String> = JsonMissing.of(),
                @JsonProperty("deletedNotesCount")
                @ExcludeMissing
                deletedNotesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("isApiContributor")
                @ExcludeMissing
                isApiContributor: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isTopWriter")
                @ExcludeMissing
                isTopWriter: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("notesCount")
                @ExcludeMissing
                notesCount: JsonField<NotesCount> = JsonMissing.of(),
                @JsonProperty("ratingsCount")
                @ExcludeMissing
                ratingsCount: JsonField<RatingsCount> = JsonMissing.of(),
            ) : this(
                alias,
                deletedNotesCount,
                isApiContributor,
                isTopWriter,
                notesCount,
                ratingsCount,
                mutableMapOf(),
            )

            /**
             * The alias X gives the contributor.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun alias(): String = alias.getRequired("alias")

            /**
             * Notes the contributor deleted.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun deletedNotesCount(): Optional<Long> =
                deletedNotesCount.getOptional("deletedNotesCount")

            /**
             * Whether the contributor writes notes through X's API.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isApiContributor(): Optional<Boolean> =
                isApiContributor.getOptional("isApiContributor")

            /**
             * Whether X marks the contributor as a top writer.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isTopWriter(): Optional<Boolean> = isTopWriter.getOptional("isTopWriter")

            /**
             * How many notes a contributor wrote, by X's current rating.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun notesCount(): Optional<NotesCount> = notesCount.getOptional("notesCount")

            /**
             * How a contributor's ratings of other notes went.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun ratingsCount(): Optional<RatingsCount> = ratingsCount.getOptional("ratingsCount")

            /**
             * Returns the raw JSON value of [alias].
             *
             * Unlike [alias], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("alias") @ExcludeMissing fun _alias(): JsonField<String> = alias

            /**
             * Returns the raw JSON value of [deletedNotesCount].
             *
             * Unlike [deletedNotesCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("deletedNotesCount")
            @ExcludeMissing
            fun _deletedNotesCount(): JsonField<Long> = deletedNotesCount

            /**
             * Returns the raw JSON value of [isApiContributor].
             *
             * Unlike [isApiContributor], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isApiContributor")
            @ExcludeMissing
            fun _isApiContributor(): JsonField<Boolean> = isApiContributor

            /**
             * Returns the raw JSON value of [isTopWriter].
             *
             * Unlike [isTopWriter], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isTopWriter")
            @ExcludeMissing
            fun _isTopWriter(): JsonField<Boolean> = isTopWriter

            /**
             * Returns the raw JSON value of [notesCount].
             *
             * Unlike [notesCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("notesCount")
            @ExcludeMissing
            fun _notesCount(): JsonField<NotesCount> = notesCount

            /**
             * Returns the raw JSON value of [ratingsCount].
             *
             * Unlike [ratingsCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ratingsCount")
            @ExcludeMissing
            fun _ratingsCount(): JsonField<RatingsCount> = ratingsCount

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
                 * Returns a mutable builder for constructing an instance of [Contributor].
                 *
                 * The following fields are required:
                 * ```java
                 * .alias()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Contributor]. */
            class Builder internal constructor() {

                private var alias: JsonField<String>? = null
                private var deletedNotesCount: JsonField<Long> = JsonMissing.of()
                private var isApiContributor: JsonField<Boolean> = JsonMissing.of()
                private var isTopWriter: JsonField<Boolean> = JsonMissing.of()
                private var notesCount: JsonField<NotesCount> = JsonMissing.of()
                private var ratingsCount: JsonField<RatingsCount> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contributor: Contributor) = apply {
                    alias = contributor.alias
                    deletedNotesCount = contributor.deletedNotesCount
                    isApiContributor = contributor.isApiContributor
                    isTopWriter = contributor.isTopWriter
                    notesCount = contributor.notesCount
                    ratingsCount = contributor.ratingsCount
                    additionalProperties = contributor.additionalProperties.toMutableMap()
                }

                /** The alias X gives the contributor. */
                fun alias(alias: String) = alias(JsonField.of(alias))

                /** Sets [Builder.alias] to an arbitrary JSON value. */
                fun alias(alias: JsonField<String>) = apply { this.alias = alias }

                /** Notes the contributor deleted. */
                fun deletedNotesCount(deletedNotesCount: Long) =
                    deletedNotesCount(JsonField.of(deletedNotesCount))

                /** Sets [Builder.deletedNotesCount] to an arbitrary JSON value. */
                fun deletedNotesCount(deletedNotesCount: JsonField<Long>) = apply {
                    this.deletedNotesCount = deletedNotesCount
                }

                /** Whether the contributor writes notes through X's API. */
                fun isApiContributor(isApiContributor: Boolean) =
                    isApiContributor(JsonField.of(isApiContributor))

                /** Sets [Builder.isApiContributor] to an arbitrary JSON value. */
                fun isApiContributor(isApiContributor: JsonField<Boolean>) = apply {
                    this.isApiContributor = isApiContributor
                }

                /** Whether X marks the contributor as a top writer. */
                fun isTopWriter(isTopWriter: Boolean) = isTopWriter(JsonField.of(isTopWriter))

                /** Sets [Builder.isTopWriter] to an arbitrary JSON value. */
                fun isTopWriter(isTopWriter: JsonField<Boolean>) = apply {
                    this.isTopWriter = isTopWriter
                }

                /** How many notes a contributor wrote, by X's current rating. */
                fun notesCount(notesCount: NotesCount) = notesCount(JsonField.of(notesCount))

                /** Sets [Builder.notesCount] to an arbitrary JSON value. */
                fun notesCount(notesCount: JsonField<NotesCount>) = apply {
                    this.notesCount = notesCount
                }

                /** How a contributor's ratings of other notes went. */
                fun ratingsCount(ratingsCount: RatingsCount) =
                    ratingsCount(JsonField.of(ratingsCount))

                /** Sets [Builder.ratingsCount] to an arbitrary JSON value. */
                fun ratingsCount(ratingsCount: JsonField<RatingsCount>) = apply {
                    this.ratingsCount = ratingsCount
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
                 * Returns an immutable instance of [Contributor].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .alias()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Contributor =
                    Contributor(
                        checkRequired("alias", alias),
                        deletedNotesCount,
                        isApiContributor,
                        isTopWriter,
                        notesCount,
                        ratingsCount,
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
            fun validate(): Contributor = apply {
                if (validated) {
                    return@apply
                }

                alias()
                deletedNotesCount()
                isApiContributor()
                isTopWriter()
                notesCount().ifPresent { it.validate() }
                ratingsCount().ifPresent { it.validate() }
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
                (if (alias.asKnown().isPresent) 1 else 0) +
                    (if (deletedNotesCount.asKnown().isPresent) 1 else 0) +
                    (if (isApiContributor.asKnown().isPresent) 1 else 0) +
                    (if (isTopWriter.asKnown().isPresent) 1 else 0) +
                    (notesCount.asKnown().getOrNull()?.validity() ?: 0) +
                    (ratingsCount.asKnown().getOrNull()?.validity() ?: 0)

            /** How many notes a contributor wrote, by X's current rating. */
            class NotesCount
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val awaitingMoreRatings: JsonField<Long>,
                private val currentlyRatedHelpful: JsonField<Long>,
                private val currentlyRatedNotHelpful: JsonField<Long>,
                private val updatedAt: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("awaitingMoreRatings")
                    @ExcludeMissing
                    awaitingMoreRatings: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("currentlyRatedHelpful")
                    @ExcludeMissing
                    currentlyRatedHelpful: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("currentlyRatedNotHelpful")
                    @ExcludeMissing
                    currentlyRatedNotHelpful: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("updatedAt")
                    @ExcludeMissing
                    updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(
                    awaitingMoreRatings,
                    currentlyRatedHelpful,
                    currentlyRatedNotHelpful,
                    updatedAt,
                    mutableMapOf(),
                )

                /**
                 * Notes that need more ratings.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun awaitingMoreRatings(): Optional<Long> =
                    awaitingMoreRatings.getOptional("awaitingMoreRatings")

                /**
                 * Notes X rates helpful now.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun currentlyRatedHelpful(): Optional<Long> =
                    currentlyRatedHelpful.getOptional("currentlyRatedHelpful")

                /**
                 * Notes X rates not helpful now.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun currentlyRatedNotHelpful(): Optional<Long> =
                    currentlyRatedNotHelpful.getOptional("currentlyRatedNotHelpful")

                /**
                 * When X last counted the notes.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

                /**
                 * Returns the raw JSON value of [awaitingMoreRatings].
                 *
                 * Unlike [awaitingMoreRatings], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("awaitingMoreRatings")
                @ExcludeMissing
                fun _awaitingMoreRatings(): JsonField<Long> = awaitingMoreRatings

                /**
                 * Returns the raw JSON value of [currentlyRatedHelpful].
                 *
                 * Unlike [currentlyRatedHelpful], this method doesn't throw if the JSON field has
                 * an unexpected type.
                 */
                @JsonProperty("currentlyRatedHelpful")
                @ExcludeMissing
                fun _currentlyRatedHelpful(): JsonField<Long> = currentlyRatedHelpful

                /**
                 * Returns the raw JSON value of [currentlyRatedNotHelpful].
                 *
                 * Unlike [currentlyRatedNotHelpful], this method doesn't throw if the JSON field
                 * has an unexpected type.
                 */
                @JsonProperty("currentlyRatedNotHelpful")
                @ExcludeMissing
                fun _currentlyRatedNotHelpful(): JsonField<Long> = currentlyRatedNotHelpful

                /**
                 * Returns the raw JSON value of [updatedAt].
                 *
                 * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("updatedAt")
                @ExcludeMissing
                fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

                    /** Returns a mutable builder for constructing an instance of [NotesCount]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [NotesCount]. */
                class Builder internal constructor() {

                    private var awaitingMoreRatings: JsonField<Long> = JsonMissing.of()
                    private var currentlyRatedHelpful: JsonField<Long> = JsonMissing.of()
                    private var currentlyRatedNotHelpful: JsonField<Long> = JsonMissing.of()
                    private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(notesCount: NotesCount) = apply {
                        awaitingMoreRatings = notesCount.awaitingMoreRatings
                        currentlyRatedHelpful = notesCount.currentlyRatedHelpful
                        currentlyRatedNotHelpful = notesCount.currentlyRatedNotHelpful
                        updatedAt = notesCount.updatedAt
                        additionalProperties = notesCount.additionalProperties.toMutableMap()
                    }

                    /** Notes that need more ratings. */
                    fun awaitingMoreRatings(awaitingMoreRatings: Long) =
                        awaitingMoreRatings(JsonField.of(awaitingMoreRatings))

                    /** Sets [Builder.awaitingMoreRatings] to an arbitrary JSON value. */
                    fun awaitingMoreRatings(awaitingMoreRatings: JsonField<Long>) = apply {
                        this.awaitingMoreRatings = awaitingMoreRatings
                    }

                    /** Notes X rates helpful now. */
                    fun currentlyRatedHelpful(currentlyRatedHelpful: Long) =
                        currentlyRatedHelpful(JsonField.of(currentlyRatedHelpful))

                    /** Sets [Builder.currentlyRatedHelpful] to an arbitrary JSON value. */
                    fun currentlyRatedHelpful(currentlyRatedHelpful: JsonField<Long>) = apply {
                        this.currentlyRatedHelpful = currentlyRatedHelpful
                    }

                    /** Notes X rates not helpful now. */
                    fun currentlyRatedNotHelpful(currentlyRatedNotHelpful: Long) =
                        currentlyRatedNotHelpful(JsonField.of(currentlyRatedNotHelpful))

                    /** Sets [Builder.currentlyRatedNotHelpful] to an arbitrary JSON value. */
                    fun currentlyRatedNotHelpful(currentlyRatedNotHelpful: JsonField<Long>) =
                        apply {
                            this.currentlyRatedNotHelpful = currentlyRatedNotHelpful
                        }

                    /** When X last counted the notes. */
                    fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

                    /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
                    fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                        this.updatedAt = updatedAt
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
                     * Returns an immutable instance of [NotesCount].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): NotesCount =
                        NotesCount(
                            awaitingMoreRatings,
                            currentlyRatedHelpful,
                            currentlyRatedNotHelpful,
                            updatedAt,
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
                fun validate(): NotesCount = apply {
                    if (validated) {
                        return@apply
                    }

                    awaitingMoreRatings()
                    currentlyRatedHelpful()
                    currentlyRatedNotHelpful()
                    updatedAt()
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
                    (if (awaitingMoreRatings.asKnown().isPresent) 1 else 0) +
                        (if (currentlyRatedHelpful.asKnown().isPresent) 1 else 0) +
                        (if (currentlyRatedNotHelpful.asKnown().isPresent) 1 else 0) +
                        (if (updatedAt.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is NotesCount &&
                        awaitingMoreRatings == other.awaitingMoreRatings &&
                        currentlyRatedHelpful == other.currentlyRatedHelpful &&
                        currentlyRatedNotHelpful == other.currentlyRatedNotHelpful &&
                        updatedAt == other.updatedAt &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        awaitingMoreRatings,
                        currentlyRatedHelpful,
                        currentlyRatedNotHelpful,
                        updatedAt,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "NotesCount{awaitingMoreRatings=$awaitingMoreRatings, currentlyRatedHelpful=$currentlyRatedHelpful, currentlyRatedNotHelpful=$currentlyRatedNotHelpful, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
            }

            /** How a contributor's ratings of other notes went. */
            class RatingsCount
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val awaitingMoreRatings: JsonField<Long>,
                private val ratedAfterDecision: JsonField<Long>,
                private val successful: JsonField<Successful>,
                private val unsuccessful: JsonField<Unsuccessful>,
                private val updatedAt: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("awaitingMoreRatings")
                    @ExcludeMissing
                    awaitingMoreRatings: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("ratedAfterDecision")
                    @ExcludeMissing
                    ratedAfterDecision: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("successful")
                    @ExcludeMissing
                    successful: JsonField<Successful> = JsonMissing.of(),
                    @JsonProperty("unsuccessful")
                    @ExcludeMissing
                    unsuccessful: JsonField<Unsuccessful> = JsonMissing.of(),
                    @JsonProperty("updatedAt")
                    @ExcludeMissing
                    updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(
                    awaitingMoreRatings,
                    ratedAfterDecision,
                    successful,
                    unsuccessful,
                    updatedAt,
                    mutableMapOf(),
                )

                /**
                 * Ratings on notes that need more ratings.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun awaitingMoreRatings(): Optional<Long> =
                    awaitingMoreRatings.getOptional("awaitingMoreRatings")

                /**
                 * Ratings made after X rated the note.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun ratedAfterDecision(): Optional<Long> =
                    ratedAfterDecision.getOptional("ratedAfterDecision")

                /**
                 * Ratings that matched the rating X gave the note.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun successful(): Optional<Successful> = successful.getOptional("successful")

                /**
                 * Ratings that went against the rating X gave the note.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun unsuccessful(): Optional<Unsuccessful> =
                    unsuccessful.getOptional("unsuccessful")

                /**
                 * When X last counted the ratings.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

                /**
                 * Returns the raw JSON value of [awaitingMoreRatings].
                 *
                 * Unlike [awaitingMoreRatings], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("awaitingMoreRatings")
                @ExcludeMissing
                fun _awaitingMoreRatings(): JsonField<Long> = awaitingMoreRatings

                /**
                 * Returns the raw JSON value of [ratedAfterDecision].
                 *
                 * Unlike [ratedAfterDecision], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ratedAfterDecision")
                @ExcludeMissing
                fun _ratedAfterDecision(): JsonField<Long> = ratedAfterDecision

                /**
                 * Returns the raw JSON value of [successful].
                 *
                 * Unlike [successful], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("successful")
                @ExcludeMissing
                fun _successful(): JsonField<Successful> = successful

                /**
                 * Returns the raw JSON value of [unsuccessful].
                 *
                 * Unlike [unsuccessful], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("unsuccessful")
                @ExcludeMissing
                fun _unsuccessful(): JsonField<Unsuccessful> = unsuccessful

                /**
                 * Returns the raw JSON value of [updatedAt].
                 *
                 * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("updatedAt")
                @ExcludeMissing
                fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

                    /** Returns a mutable builder for constructing an instance of [RatingsCount]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [RatingsCount]. */
                class Builder internal constructor() {

                    private var awaitingMoreRatings: JsonField<Long> = JsonMissing.of()
                    private var ratedAfterDecision: JsonField<Long> = JsonMissing.of()
                    private var successful: JsonField<Successful> = JsonMissing.of()
                    private var unsuccessful: JsonField<Unsuccessful> = JsonMissing.of()
                    private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(ratingsCount: RatingsCount) = apply {
                        awaitingMoreRatings = ratingsCount.awaitingMoreRatings
                        ratedAfterDecision = ratingsCount.ratedAfterDecision
                        successful = ratingsCount.successful
                        unsuccessful = ratingsCount.unsuccessful
                        updatedAt = ratingsCount.updatedAt
                        additionalProperties = ratingsCount.additionalProperties.toMutableMap()
                    }

                    /** Ratings on notes that need more ratings. */
                    fun awaitingMoreRatings(awaitingMoreRatings: Long) =
                        awaitingMoreRatings(JsonField.of(awaitingMoreRatings))

                    /** Sets [Builder.awaitingMoreRatings] to an arbitrary JSON value. */
                    fun awaitingMoreRatings(awaitingMoreRatings: JsonField<Long>) = apply {
                        this.awaitingMoreRatings = awaitingMoreRatings
                    }

                    /** Ratings made after X rated the note. */
                    fun ratedAfterDecision(ratedAfterDecision: Long) =
                        ratedAfterDecision(JsonField.of(ratedAfterDecision))

                    /** Sets [Builder.ratedAfterDecision] to an arbitrary JSON value. */
                    fun ratedAfterDecision(ratedAfterDecision: JsonField<Long>) = apply {
                        this.ratedAfterDecision = ratedAfterDecision
                    }

                    /** Ratings that matched the rating X gave the note. */
                    fun successful(successful: Successful) = successful(JsonField.of(successful))

                    /** Sets [Builder.successful] to an arbitrary JSON value. */
                    fun successful(successful: JsonField<Successful>) = apply {
                        this.successful = successful
                    }

                    /** Ratings that went against the rating X gave the note. */
                    fun unsuccessful(unsuccessful: Unsuccessful) =
                        unsuccessful(JsonField.of(unsuccessful))

                    /** Sets [Builder.unsuccessful] to an arbitrary JSON value. */
                    fun unsuccessful(unsuccessful: JsonField<Unsuccessful>) = apply {
                        this.unsuccessful = unsuccessful
                    }

                    /** When X last counted the ratings. */
                    fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

                    /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
                    fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                        this.updatedAt = updatedAt
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
                     * Returns an immutable instance of [RatingsCount].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): RatingsCount =
                        RatingsCount(
                            awaitingMoreRatings,
                            ratedAfterDecision,
                            successful,
                            unsuccessful,
                            updatedAt,
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
                fun validate(): RatingsCount = apply {
                    if (validated) {
                        return@apply
                    }

                    awaitingMoreRatings()
                    ratedAfterDecision()
                    successful().ifPresent { it.validate() }
                    unsuccessful().ifPresent { it.validate() }
                    updatedAt()
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
                    (if (awaitingMoreRatings.asKnown().isPresent) 1 else 0) +
                        (if (ratedAfterDecision.asKnown().isPresent) 1 else 0) +
                        (successful.asKnown().getOrNull()?.validity() ?: 0) +
                        (unsuccessful.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (updatedAt.asKnown().isPresent) 1 else 0)

                /** A group of a contributor's ratings, by what each one said. */
                class Successful
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val helpfulCount: JsonField<Long>,
                    private val notHelpfulCount: JsonField<Long>,
                    private val total: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("helpfulCount")
                        @ExcludeMissing
                        helpfulCount: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("notHelpfulCount")
                        @ExcludeMissing
                        notHelpfulCount: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("total")
                        @ExcludeMissing
                        total: JsonField<Long> = JsonMissing.of(),
                    ) : this(helpfulCount, notHelpfulCount, total, mutableMapOf())

                    /**
                     * Ratings that called a note helpful.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun helpfulCount(): Optional<Long> = helpfulCount.getOptional("helpfulCount")

                    /**
                     * Ratings that called a note not helpful.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun notHelpfulCount(): Optional<Long> =
                        notHelpfulCount.getOptional("notHelpfulCount")

                    /**
                     * All ratings in the group, when X sends the sum.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun total(): Optional<Long> = total.getOptional("total")

                    /**
                     * Returns the raw JSON value of [helpfulCount].
                     *
                     * Unlike [helpfulCount], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("helpfulCount")
                    @ExcludeMissing
                    fun _helpfulCount(): JsonField<Long> = helpfulCount

                    /**
                     * Returns the raw JSON value of [notHelpfulCount].
                     *
                     * Unlike [notHelpfulCount], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("notHelpfulCount")
                    @ExcludeMissing
                    fun _notHelpfulCount(): JsonField<Long> = notHelpfulCount

                    /**
                     * Returns the raw JSON value of [total].
                     *
                     * Unlike [total], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
                         * Returns a mutable builder for constructing an instance of [Successful].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Successful]. */
                    class Builder internal constructor() {

                        private var helpfulCount: JsonField<Long> = JsonMissing.of()
                        private var notHelpfulCount: JsonField<Long> = JsonMissing.of()
                        private var total: JsonField<Long> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(successful: Successful) = apply {
                            helpfulCount = successful.helpfulCount
                            notHelpfulCount = successful.notHelpfulCount
                            total = successful.total
                            additionalProperties = successful.additionalProperties.toMutableMap()
                        }

                        /** Ratings that called a note helpful. */
                        fun helpfulCount(helpfulCount: Long) =
                            helpfulCount(JsonField.of(helpfulCount))

                        /** Sets [Builder.helpfulCount] to an arbitrary JSON value. */
                        fun helpfulCount(helpfulCount: JsonField<Long>) = apply {
                            this.helpfulCount = helpfulCount
                        }

                        /** Ratings that called a note not helpful. */
                        fun notHelpfulCount(notHelpfulCount: Long) =
                            notHelpfulCount(JsonField.of(notHelpfulCount))

                        /** Sets [Builder.notHelpfulCount] to an arbitrary JSON value. */
                        fun notHelpfulCount(notHelpfulCount: JsonField<Long>) = apply {
                            this.notHelpfulCount = notHelpfulCount
                        }

                        /** All ratings in the group, when X sends the sum. */
                        fun total(total: Long) = total(JsonField.of(total))

                        /** Sets [Builder.total] to an arbitrary JSON value. */
                        fun total(total: JsonField<Long>) = apply { this.total = total }

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
                         * Returns an immutable instance of [Successful].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Successful =
                            Successful(
                                helpfulCount,
                                notHelpfulCount,
                                total,
                                additionalProperties.toMutableMap(),
                            )
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
                    fun validate(): Successful = apply {
                        if (validated) {
                            return@apply
                        }

                        helpfulCount()
                        notHelpfulCount()
                        total()
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
                        (if (helpfulCount.asKnown().isPresent) 1 else 0) +
                            (if (notHelpfulCount.asKnown().isPresent) 1 else 0) +
                            (if (total.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Successful &&
                            helpfulCount == other.helpfulCount &&
                            notHelpfulCount == other.notHelpfulCount &&
                            total == other.total &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(helpfulCount, notHelpfulCount, total, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Successful{helpfulCount=$helpfulCount, notHelpfulCount=$notHelpfulCount, total=$total, additionalProperties=$additionalProperties}"
                }

                /** A group of a contributor's ratings, by what each one said. */
                class Unsuccessful
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val helpfulCount: JsonField<Long>,
                    private val notHelpfulCount: JsonField<Long>,
                    private val total: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("helpfulCount")
                        @ExcludeMissing
                        helpfulCount: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("notHelpfulCount")
                        @ExcludeMissing
                        notHelpfulCount: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("total")
                        @ExcludeMissing
                        total: JsonField<Long> = JsonMissing.of(),
                    ) : this(helpfulCount, notHelpfulCount, total, mutableMapOf())

                    /**
                     * Ratings that called a note helpful.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun helpfulCount(): Optional<Long> = helpfulCount.getOptional("helpfulCount")

                    /**
                     * Ratings that called a note not helpful.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun notHelpfulCount(): Optional<Long> =
                        notHelpfulCount.getOptional("notHelpfulCount")

                    /**
                     * All ratings in the group, when X sends the sum.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun total(): Optional<Long> = total.getOptional("total")

                    /**
                     * Returns the raw JSON value of [helpfulCount].
                     *
                     * Unlike [helpfulCount], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("helpfulCount")
                    @ExcludeMissing
                    fun _helpfulCount(): JsonField<Long> = helpfulCount

                    /**
                     * Returns the raw JSON value of [notHelpfulCount].
                     *
                     * Unlike [notHelpfulCount], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("notHelpfulCount")
                    @ExcludeMissing
                    fun _notHelpfulCount(): JsonField<Long> = notHelpfulCount

                    /**
                     * Returns the raw JSON value of [total].
                     *
                     * Unlike [total], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
                         * Returns a mutable builder for constructing an instance of [Unsuccessful].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Unsuccessful]. */
                    class Builder internal constructor() {

                        private var helpfulCount: JsonField<Long> = JsonMissing.of()
                        private var notHelpfulCount: JsonField<Long> = JsonMissing.of()
                        private var total: JsonField<Long> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(unsuccessful: Unsuccessful) = apply {
                            helpfulCount = unsuccessful.helpfulCount
                            notHelpfulCount = unsuccessful.notHelpfulCount
                            total = unsuccessful.total
                            additionalProperties = unsuccessful.additionalProperties.toMutableMap()
                        }

                        /** Ratings that called a note helpful. */
                        fun helpfulCount(helpfulCount: Long) =
                            helpfulCount(JsonField.of(helpfulCount))

                        /** Sets [Builder.helpfulCount] to an arbitrary JSON value. */
                        fun helpfulCount(helpfulCount: JsonField<Long>) = apply {
                            this.helpfulCount = helpfulCount
                        }

                        /** Ratings that called a note not helpful. */
                        fun notHelpfulCount(notHelpfulCount: Long) =
                            notHelpfulCount(JsonField.of(notHelpfulCount))

                        /** Sets [Builder.notHelpfulCount] to an arbitrary JSON value. */
                        fun notHelpfulCount(notHelpfulCount: JsonField<Long>) = apply {
                            this.notHelpfulCount = notHelpfulCount
                        }

                        /** All ratings in the group, when X sends the sum. */
                        fun total(total: Long) = total(JsonField.of(total))

                        /** Sets [Builder.total] to an arbitrary JSON value. */
                        fun total(total: JsonField<Long>) = apply { this.total = total }

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
                         * Returns an immutable instance of [Unsuccessful].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Unsuccessful =
                            Unsuccessful(
                                helpfulCount,
                                notHelpfulCount,
                                total,
                                additionalProperties.toMutableMap(),
                            )
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
                    fun validate(): Unsuccessful = apply {
                        if (validated) {
                            return@apply
                        }

                        helpfulCount()
                        notHelpfulCount()
                        total()
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
                        (if (helpfulCount.asKnown().isPresent) 1 else 0) +
                            (if (notHelpfulCount.asKnown().isPresent) 1 else 0) +
                            (if (total.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Unsuccessful &&
                            helpfulCount == other.helpfulCount &&
                            notHelpfulCount == other.notHelpfulCount &&
                            total == other.total &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(helpfulCount, notHelpfulCount, total, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Unsuccessful{helpfulCount=$helpfulCount, notHelpfulCount=$notHelpfulCount, total=$total, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is RatingsCount &&
                        awaitingMoreRatings == other.awaitingMoreRatings &&
                        ratedAfterDecision == other.ratedAfterDecision &&
                        successful == other.successful &&
                        unsuccessful == other.unsuccessful &&
                        updatedAt == other.updatedAt &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        awaitingMoreRatings,
                        ratedAfterDecision,
                        successful,
                        unsuccessful,
                        updatedAt,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "RatingsCount{awaitingMoreRatings=$awaitingMoreRatings, ratedAfterDecision=$ratedAfterDecision, successful=$successful, unsuccessful=$unsuccessful, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Contributor &&
                    alias == other.alias &&
                    deletedNotesCount == other.deletedNotesCount &&
                    isApiContributor == other.isApiContributor &&
                    isTopWriter == other.isTopWriter &&
                    notesCount == other.notesCount &&
                    ratingsCount == other.ratingsCount &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    alias,
                    deletedNotesCount,
                    isApiContributor,
                    isTopWriter,
                    notesCount,
                    ratingsCount,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Contributor{alias=$alias, deletedNotesCount=$deletedNotesCount, isApiContributor=$isApiContributor, isTopWriter=$isTopWriter, notesCount=$notesCount, ratingsCount=$ratingsCount, additionalProperties=$additionalProperties}"
        }

        /** A link, tag or account inside a note's text. */
        class Entity
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fromIndex: JsonField<Long>,
            private val ref: JsonField<Ref>,
            private val toIndex: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("fromIndex")
                @ExcludeMissing
                fromIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("ref") @ExcludeMissing ref: JsonField<Ref> = JsonMissing.of(),
                @JsonProperty("toIndex")
                @ExcludeMissing
                toIndex: JsonField<Long> = JsonMissing.of(),
            ) : this(fromIndex, ref, toIndex, mutableMapOf())

            /**
             * Where it starts in the text.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun fromIndex(): Optional<Long> = fromIndex.getOptional("fromIndex")

            /**
             * What it points at.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun ref(): Optional<Ref> = ref.getOptional("ref")

            /**
             * Where it ends in the text.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun toIndex(): Optional<Long> = toIndex.getOptional("toIndex")

            /**
             * Returns the raw JSON value of [fromIndex].
             *
             * Unlike [fromIndex], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fromIndex") @ExcludeMissing fun _fromIndex(): JsonField<Long> = fromIndex

            /**
             * Returns the raw JSON value of [ref].
             *
             * Unlike [ref], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ref") @ExcludeMissing fun _ref(): JsonField<Ref> = ref

            /**
             * Returns the raw JSON value of [toIndex].
             *
             * Unlike [toIndex], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("toIndex") @ExcludeMissing fun _toIndex(): JsonField<Long> = toIndex

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

                /** Returns a mutable builder for constructing an instance of [Entity]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Entity]. */
            class Builder internal constructor() {

                private var fromIndex: JsonField<Long> = JsonMissing.of()
                private var ref: JsonField<Ref> = JsonMissing.of()
                private var toIndex: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(entity: Entity) = apply {
                    fromIndex = entity.fromIndex
                    ref = entity.ref
                    toIndex = entity.toIndex
                    additionalProperties = entity.additionalProperties.toMutableMap()
                }

                /** Where it starts in the text. */
                fun fromIndex(fromIndex: Long) = fromIndex(JsonField.of(fromIndex))

                /** Sets [Builder.fromIndex] to an arbitrary JSON value. */
                fun fromIndex(fromIndex: JsonField<Long>) = apply { this.fromIndex = fromIndex }

                /** What it points at. */
                fun ref(ref: Ref) = ref(JsonField.of(ref))

                /** Sets [Builder.ref] to an arbitrary JSON value. */
                fun ref(ref: JsonField<Ref>) = apply { this.ref = ref }

                /** Where it ends in the text. */
                fun toIndex(toIndex: Long) = toIndex(JsonField.of(toIndex))

                /** Sets [Builder.toIndex] to an arbitrary JSON value. */
                fun toIndex(toIndex: JsonField<Long>) = apply { this.toIndex = toIndex }

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
                 * Returns an immutable instance of [Entity].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Entity =
                    Entity(fromIndex, ref, toIndex, additionalProperties.toMutableMap())
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
            fun validate(): Entity = apply {
                if (validated) {
                    return@apply
                }

                fromIndex()
                ref().ifPresent { it.validate() }
                toIndex()
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
                (if (fromIndex.asKnown().isPresent) 1 else 0) +
                    (ref.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (toIndex.asKnown().isPresent) 1 else 0)

            /** What it points at. */
            class Ref
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val screenName: JsonField<String>,
                private val text: JsonField<String>,
                private val type: JsonField<String>,
                private val url: JsonField<String>,
                private val urlType: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("screenName")
                    @ExcludeMissing
                    screenName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("urlType")
                    @ExcludeMissing
                    urlType: JsonField<String> = JsonMissing.of(),
                ) : this(screenName, text, type, url, urlType, mutableMapOf())

                /**
                 * A mentioned account's username.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun screenName(): Optional<String> = screenName.getOptional("screenName")

                /**
                 * A hashtag's or cashtag's text.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * X's kind, such as TimelineUrl.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * The link.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

                /**
                 * How X opens the link, such as ExternalUrl.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun urlType(): Optional<String> = urlType.getOptional("urlType")

                /**
                 * Returns the raw JSON value of [screenName].
                 *
                 * Unlike [screenName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("screenName")
                @ExcludeMissing
                fun _screenName(): JsonField<String> = screenName

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [urlType].
                 *
                 * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

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

                    /** Returns a mutable builder for constructing an instance of [Ref]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Ref]. */
                class Builder internal constructor() {

                    private var screenName: JsonField<String> = JsonMissing.of()
                    private var text: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<String> = JsonMissing.of()
                    private var url: JsonField<String> = JsonMissing.of()
                    private var urlType: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(ref: Ref) = apply {
                        screenName = ref.screenName
                        text = ref.text
                        type = ref.type
                        url = ref.url
                        urlType = ref.urlType
                        additionalProperties = ref.additionalProperties.toMutableMap()
                    }

                    /** A mentioned account's username. */
                    fun screenName(screenName: String) = screenName(JsonField.of(screenName))

                    /** Sets [Builder.screenName] to an arbitrary JSON value. */
                    fun screenName(screenName: JsonField<String>) = apply {
                        this.screenName = screenName
                    }

                    /** A hashtag's or cashtag's text. */
                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /** X's kind, such as TimelineUrl. */
                    fun type(type: String) = type(JsonField.of(type))

                    /** Sets [Builder.type] to an arbitrary JSON value. */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    /** The link. */
                    fun url(url: String) = url(JsonField.of(url))

                    /** Sets [Builder.url] to an arbitrary JSON value. */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    /** How X opens the link, such as ExternalUrl. */
                    fun urlType(urlType: String) = urlType(JsonField.of(urlType))

                    /** Sets [Builder.urlType] to an arbitrary JSON value. */
                    fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

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
                     * Returns an immutable instance of [Ref].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Ref =
                        Ref(
                            screenName,
                            text,
                            type,
                            url,
                            urlType,
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
                fun validate(): Ref = apply {
                    if (validated) {
                        return@apply
                    }

                    screenName()
                    text()
                    type()
                    url()
                    urlType()
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
                    (if (screenName.asKnown().isPresent) 1 else 0) +
                        (if (text.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (urlType.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Ref &&
                        screenName == other.screenName &&
                        text == other.text &&
                        type == other.type &&
                        url == other.url &&
                        urlType == other.urlType &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(screenName, text, type, url, urlType, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Ref{screenName=$screenName, text=$text, type=$type, url=$url, urlType=$urlType, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Entity &&
                    fromIndex == other.fromIndex &&
                    ref == other.ref &&
                    toIndex == other.toIndex &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fromIndex, ref, toIndex, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Entity{fromIndex=$fromIndex, ref=$ref, toIndex=$toIndex, additionalProperties=$additionalProperties}"
        }

        /** Why X shows no post, when X says. */
        class PostUnavailable
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val reason: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of()
            ) : this(reason, mutableMapOf())

            /**
             * Why X shows no post, as X names it.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun reason(): String = reason.getRequired("reason")

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
                 * Returns a mutable builder for constructing an instance of [PostUnavailable].
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [PostUnavailable]. */
            class Builder internal constructor() {

                private var reason: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(postUnavailable: PostUnavailable) = apply {
                    reason = postUnavailable.reason
                    additionalProperties = postUnavailable.additionalProperties.toMutableMap()
                }

                /** Why X shows no post, as X names it. */
                fun reason(reason: String) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<String>) = apply { this.reason = reason }

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
                 * Returns an immutable instance of [PostUnavailable].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): PostUnavailable =
                    PostUnavailable(
                        checkRequired("reason", reason),
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
            fun validate(): PostUnavailable = apply {
                if (validated) {
                    return@apply
                }

                reason()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int = (if (reason.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PostUnavailable &&
                    reason == other.reason &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(reason, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PostUnavailable{reason=$reason, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Note &&
                id == other.id &&
                abovePcrhThreshold == other.abovePcrhThreshold &&
                appealStatus == other.appealStatus &&
                classification == other.classification &&
                contributor == other.contributor &&
                createdAt == other.createdAt &&
                decidedBy == other.decidedBy &&
                deleted == other.deleted &&
                displayUrl == other.displayUrl &&
                entities == other.entities &&
                fullyVisibleModel == other.fullyVisibleModel &&
                helpfulTags == other.helpfulTags &&
                impressionCount == other.impressionCount &&
                isApiAuthor == other.isApiAuthor &&
                isMediaNote == other.isMediaNote &&
                isTranslatable == other.isTranslatable &&
                isUrlNote == other.isUrlNote &&
                language == other.language &&
                mediaNoteMatchCount == other.mediaNoteMatchCount &&
                notHelpfulTags == other.notHelpfulTags &&
                post == other.post &&
                postId == other.postId &&
                postUnavailable == other.postUnavailable &&
                ratingStatus == other.ratingStatus &&
                text == other.text &&
                timeToHelpfulFromNoteMs == other.timeToHelpfulFromNoteMs &&
                timeToHelpfulFromPostMs == other.timeToHelpfulFromPostMs &&
                tombstone == other.tombstone &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                abovePcrhThreshold,
                appealStatus,
                classification,
                contributor,
                createdAt,
                decidedBy,
                deleted,
                displayUrl,
                entities,
                fullyVisibleModel,
                helpfulTags,
                impressionCount,
                isApiAuthor,
                isMediaNote,
                isTranslatable,
                isUrlNote,
                language,
                mediaNoteMatchCount,
                notHelpfulTags,
                post,
                postId,
                postUnavailable,
                ratingStatus,
                text,
                timeToHelpfulFromNoteMs,
                timeToHelpfulFromPostMs,
                tombstone,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Note{id=$id, abovePcrhThreshold=$abovePcrhThreshold, appealStatus=$appealStatus, classification=$classification, contributor=$contributor, createdAt=$createdAt, decidedBy=$decidedBy, deleted=$deleted, displayUrl=$displayUrl, entities=$entities, fullyVisibleModel=$fullyVisibleModel, helpfulTags=$helpfulTags, impressionCount=$impressionCount, isApiAuthor=$isApiAuthor, isMediaNote=$isMediaNote, isTranslatable=$isTranslatable, isUrlNote=$isUrlNote, language=$language, mediaNoteMatchCount=$mediaNoteMatchCount, notHelpfulTags=$notHelpfulTags, post=$post, postId=$postId, postUnavailable=$postUnavailable, ratingStatus=$ratingStatus, text=$text, timeToHelpfulFromNoteMs=$timeToHelpfulFromNoteMs, timeToHelpfulFromPostMs=$timeToHelpfulFromPostMs, tombstone=$tombstone, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityNoteListContributorDeletedNotesResponse &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            notes == other.notes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasNextPage, nextCursor, notes, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityNoteListContributorDeletedNotesResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, notes=$notes, additionalProperties=$additionalProperties}"
}
