// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.media

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
import com.x_twitter_scraper.api.models.ImageFilterSummary
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class MediaDownloadResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cacheHit: JsonField<Boolean>,
    private val galleryUrl: JsonField<String>,
    private val totalMedia: JsonField<Long>,
    private val totalTweets: JsonField<Long>,
    private val tweetId: JsonField<String>,
    private val items: JsonField<List<Item>>,
    private val imageFilter: JsonField<ImageFilterSummary>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cacheHit") @ExcludeMissing cacheHit: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("galleryUrl")
        @ExcludeMissing
        galleryUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("totalMedia") @ExcludeMissing totalMedia: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("totalTweets")
        @ExcludeMissing
        totalTweets: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("items") @ExcludeMissing items: JsonField<List<Item>> = JsonMissing.of(),
        @JsonProperty("imageFilter")
        @ExcludeMissing
        imageFilter: JsonField<ImageFilterSummary> = JsonMissing.of(),
    ) : this(
        cacheHit,
        galleryUrl,
        totalMedia,
        totalTweets,
        tweetId,
        items,
        imageFilter,
        mutableMapOf(),
    )

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun cacheHit(): Optional<Boolean> = cacheHit.getOptional("cacheHit")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun galleryUrl(): Optional<String> = galleryUrl.getOptional("galleryUrl")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun totalMedia(): Optional<Long> = totalMedia.getOptional("totalMedia")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun totalTweets(): Optional<Long> = totalTweets.getOptional("totalTweets")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

    /** The post's files saved to your gallery. Single downloads only. */
    fun items(): Optional<List<Item>> = items.getOptional("items")

    /**
     * Returns the raw JSON value of [cacheHit].
     *
     * Unlike [cacheHit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cacheHit") @ExcludeMissing fun _cacheHit(): JsonField<Boolean> = cacheHit

    /**
     * Returns the raw JSON value of [galleryUrl].
     *
     * Unlike [galleryUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("galleryUrl") @ExcludeMissing fun _galleryUrl(): JsonField<String> = galleryUrl

    /**
     * Returns the raw JSON value of [totalMedia].
     *
     * Unlike [totalMedia], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalMedia") @ExcludeMissing fun _totalMedia(): JsonField<Long> = totalMedia

    /**
     * Returns the raw JSON value of [totalTweets].
     *
     * Unlike [totalTweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalTweets") @ExcludeMissing fun _totalTweets(): JsonField<Long> = totalTweets

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

    /** Returns the raw JSON value of [items]. */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<Item>> = items

    /**
     * What the image filter asked & how many posts it kept. Present when the request sent
     * imageShows.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun imageFilter(): Optional<ImageFilterSummary> = imageFilter.getOptional("imageFilter")

    /**
     * Returns the raw JSON value of [imageFilter].
     *
     * Unlike [imageFilter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("imageFilter")
    @ExcludeMissing
    fun _imageFilter(): JsonField<ImageFilterSummary> = imageFilter

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

        /** Returns a mutable builder for constructing an instance of [MediaDownloadResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MediaDownloadResponse]. */
    class Builder internal constructor() {

        private var cacheHit: JsonField<Boolean> = JsonMissing.of()
        private var galleryUrl: JsonField<String> = JsonMissing.of()
        private var totalMedia: JsonField<Long> = JsonMissing.of()
        private var totalTweets: JsonField<Long> = JsonMissing.of()
        private var tweetId: JsonField<String> = JsonMissing.of()
        private var items: JsonField<MutableList<Item>>? = null
        private var imageFilter: JsonField<ImageFilterSummary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mediaDownloadResponse: MediaDownloadResponse) = apply {
            cacheHit = mediaDownloadResponse.cacheHit
            galleryUrl = mediaDownloadResponse.galleryUrl
            totalMedia = mediaDownloadResponse.totalMedia
            totalTweets = mediaDownloadResponse.totalTweets
            tweetId = mediaDownloadResponse.tweetId
            items = mediaDownloadResponse.items.map { it.toMutableList() }
            imageFilter = mediaDownloadResponse.imageFilter
            additionalProperties = mediaDownloadResponse.additionalProperties.toMutableMap()
        }

        fun cacheHit(cacheHit: Boolean) = cacheHit(JsonField.of(cacheHit))

        /** Sets [Builder.cacheHit] to an arbitrary JSON value. */
        fun cacheHit(cacheHit: JsonField<Boolean>) = apply { this.cacheHit = cacheHit }

        fun galleryUrl(galleryUrl: String) = galleryUrl(JsonField.of(galleryUrl))

        /** Sets [Builder.galleryUrl] to an arbitrary JSON value. */
        fun galleryUrl(galleryUrl: JsonField<String>) = apply { this.galleryUrl = galleryUrl }

        fun totalMedia(totalMedia: Long) = totalMedia(JsonField.of(totalMedia))

        /** Sets [Builder.totalMedia] to an arbitrary JSON value. */
        fun totalMedia(totalMedia: JsonField<Long>) = apply { this.totalMedia = totalMedia }

        fun totalTweets(totalTweets: Long) = totalTweets(JsonField.of(totalTweets))

        /** Sets [Builder.totalTweets] to an arbitrary JSON value. */
        fun totalTweets(totalTweets: JsonField<Long>) = apply { this.totalTweets = totalTweets }

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /** Sets [Builder.tweetId] to an arbitrary JSON value. */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

        /** The post's files saved to your gallery. Single downloads only. */
        fun items(items: List<Item>) = items(JsonField.of(items))

        /** Sets [Builder.items] to an arbitrary JSON value. */
        fun items(items: JsonField<List<Item>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /** Adds a single [Item] to [items]. */
        fun addItem(item: Item) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        /**
         * What the image filter asked & how many posts it kept. Present when the request sent
         * imageShows.
         */
        fun imageFilter(imageFilter: ImageFilterSummary) = imageFilter(JsonField.of(imageFilter))

        /**
         * Sets [Builder.imageFilter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageFilter] with a well-typed [ImageFilterSummary]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun imageFilter(imageFilter: JsonField<ImageFilterSummary>) = apply {
            this.imageFilter = imageFilter
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
         * Returns an immutable instance of [MediaDownloadResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MediaDownloadResponse =
            MediaDownloadResponse(
                cacheHit,
                galleryUrl,
                totalMedia,
                totalTweets,
                tweetId,
                (items ?: JsonMissing.of()).map { it.toImmutable() },
                imageFilter,
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
    fun validate(): MediaDownloadResponse = apply {
        if (validated) {
            return@apply
        }

        cacheHit()
        galleryUrl()
        totalMedia()
        totalTweets()
        tweetId()
        items().ifPresent { it.forEach { it.validate() } }
        imageFilter().ifPresent { it.validate() }
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
        (if (cacheHit.asKnown().isPresent) 1 else 0) +
            (if (galleryUrl.asKnown().isPresent) 1 else 0) +
            (if (totalMedia.asKnown().isPresent) 1 else 0) +
            (if (totalTweets.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0) +
            (items.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (imageFilter.asKnown().getOrNull()?.validity() ?: 0)

    class Item
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val tweetId: JsonField<String>,
        private val mediaType: JsonField<MediaType>,
        private val mediaUrl: JsonField<String>,
        private val posterUrl: JsonField<String>,
        private val qualities: JsonField<List<Quality>>,
        private val fileSize: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val authorUsername: JsonField<String>,
        private val authorDisplayName: JsonField<String>,
        private val authorAvatar: JsonField<String>,
        private val tweetText: JsonField<String>,
        private val likes: JsonField<Long>,
        private val retweets: JsonField<Long>,
        private val views: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mediaType")
            @ExcludeMissing
            mediaType: JsonField<MediaType> = JsonMissing.of(),
            @JsonProperty("mediaUrl")
            @ExcludeMissing
            mediaUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("posterUrl")
            @ExcludeMissing
            posterUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("qualities")
            @ExcludeMissing
            qualities: JsonField<List<Quality>> = JsonMissing.of(),
            @JsonProperty("fileSize")
            @ExcludeMissing
            fileSize: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("authorUsername")
            @ExcludeMissing
            authorUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("authorDisplayName")
            @ExcludeMissing
            authorDisplayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("authorAvatar")
            @ExcludeMissing
            authorAvatar: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetText")
            @ExcludeMissing
            tweetText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("likes") @ExcludeMissing likes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweets") @ExcludeMissing retweets: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("views") @ExcludeMissing views: JsonField<Long> = JsonMissing.of(),
        ) : this(
            id,
            tweetId,
            mediaType,
            mediaUrl,
            posterUrl,
            qualities,
            fileSize,
            createdAt,
            authorUsername,
            authorDisplayName,
            authorAvatar,
            tweetText,
            likes,
            retweets,
            views,
            mutableMapOf(),
        )

        /** Gallery file ID */
        fun id(): String = id.getRequired("id")

        fun tweetId(): String = tweetId.getRequired("tweetId")

        fun mediaType(): MediaType = mediaType.getRequired("mediaType")

        /**
         * Link to the file. It goes to X when X flagged the post or its media at save time, or sent
         * no post flag. Xquik keeps no copy of those files.
         */
        fun mediaUrl(): String = mediaUrl.getRequired("mediaUrl")

        /**
         * Cover image of a video or GIF. Null for photos & files first saved to Xquik before
         * 2026-11-03.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun posterUrl(): Optional<String> = posterUrl.getOptional("posterUrl")

        /**
         * The MP4 sizes X stores for a video, highest bitrate first. Empty for photos, GIFs & files
         * first saved to Xquik before 2026-11-03.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun qualities(): List<Quality> = qualities.getRequired("qualities")

        /** File size in bytes, as a string */
        fun fileSize(): Optional<String> = fileSize.getOptional("fileSize")

        /** When the file joined your gallery */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        fun authorUsername(): String = authorUsername.getRequired("authorUsername")

        fun authorDisplayName(): String = authorDisplayName.getRequired("authorDisplayName")

        fun authorAvatar(): Optional<String> = authorAvatar.getOptional("authorAvatar")

        fun tweetText(): String = tweetText.getRequired("tweetText")

        fun likes(): Optional<Long> = likes.getOptional("likes")

        fun retweets(): Optional<Long> = retweets.getOptional("retweets")

        fun views(): Optional<Long> = views.getOptional("views")

        /** Returns the raw JSON value of [id]. */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /** Returns the raw JSON value of [tweetId]. */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /** Returns the raw JSON value of [mediaType]. */
        @JsonProperty("mediaType")
        @ExcludeMissing
        fun _mediaType(): JsonField<MediaType> = mediaType

        /** Returns the raw JSON value of [mediaUrl]. */
        @JsonProperty("mediaUrl") @ExcludeMissing fun _mediaUrl(): JsonField<String> = mediaUrl

        /**
         * Returns the raw JSON value of [posterUrl].
         *
         * Unlike [posterUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("posterUrl") @ExcludeMissing fun _posterUrl(): JsonField<String> = posterUrl

        /**
         * Returns the raw JSON value of [qualities].
         *
         * Unlike [qualities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("qualities")
        @ExcludeMissing
        fun _qualities(): JsonField<List<Quality>> = qualities

        /** Returns the raw JSON value of [fileSize]. */
        @JsonProperty("fileSize") @ExcludeMissing fun _fileSize(): JsonField<String> = fileSize

        /** Returns the raw JSON value of [createdAt]. */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /** Returns the raw JSON value of [authorUsername]. */
        @JsonProperty("authorUsername")
        @ExcludeMissing
        fun _authorUsername(): JsonField<String> = authorUsername

        /** Returns the raw JSON value of [authorDisplayName]. */
        @JsonProperty("authorDisplayName")
        @ExcludeMissing
        fun _authorDisplayName(): JsonField<String> = authorDisplayName

        /** Returns the raw JSON value of [authorAvatar]. */
        @JsonProperty("authorAvatar")
        @ExcludeMissing
        fun _authorAvatar(): JsonField<String> = authorAvatar

        /** Returns the raw JSON value of [tweetText]. */
        @JsonProperty("tweetText") @ExcludeMissing fun _tweetText(): JsonField<String> = tweetText

        /** Returns the raw JSON value of [likes]. */
        @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<Long> = likes

        /** Returns the raw JSON value of [retweets]. */
        @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<Long> = retweets

        /** Returns the raw JSON value of [views]. */
        @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<Long> = views

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

            /** Returns a mutable builder for constructing an instance of [Item]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Item]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var tweetId: JsonField<String>? = null
            private var mediaType: JsonField<MediaType>? = null
            private var mediaUrl: JsonField<String>? = null
            private var posterUrl: JsonField<String>? = null
            private var qualities: JsonField<MutableList<Quality>>? = null
            private var fileSize: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var authorUsername: JsonField<String>? = null
            private var authorDisplayName: JsonField<String>? = null
            private var authorAvatar: JsonField<String>? = null
            private var tweetText: JsonField<String>? = null
            private var likes: JsonField<Long>? = null
            private var retweets: JsonField<Long>? = null
            private var views: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(item: Item) = apply {
                id = item.id
                tweetId = item.tweetId
                mediaType = item.mediaType
                mediaUrl = item.mediaUrl
                posterUrl = item.posterUrl
                qualities = item.qualities.map { it.toMutableList() }
                fileSize = item.fileSize
                createdAt = item.createdAt
                authorUsername = item.authorUsername
                authorDisplayName = item.authorDisplayName
                authorAvatar = item.authorAvatar
                tweetText = item.tweetText
                likes = item.likes
                retweets = item.retweets
                views = item.views
                additionalProperties = item.additionalProperties.toMutableMap()
            }

            /** Gallery file ID */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

            /** Sets [Builder.mediaType] to an arbitrary JSON value. */
            fun mediaType(mediaType: JsonField<MediaType>) = apply { this.mediaType = mediaType }

            /**
             * Link to the file. It goes to X when X flagged the post or its media at save time, or
             * sent no post flag. Xquik keeps no copy of those files.
             */
            fun mediaUrl(mediaUrl: String) = mediaUrl(JsonField.of(mediaUrl))

            /** Sets [Builder.mediaUrl] to an arbitrary JSON value. */
            fun mediaUrl(mediaUrl: JsonField<String>) = apply { this.mediaUrl = mediaUrl }

            /**
             * Cover image of a video or GIF. Null for photos & files first saved to Xquik before
             * 2026-11-03.
             */
            fun posterUrl(posterUrl: String?) = posterUrl(JsonField.ofNullable(posterUrl))

            /** Alias for calling [Builder.posterUrl] with `posterUrl.orElse(null)`. */
            fun posterUrl(posterUrl: Optional<String>) = posterUrl(posterUrl.getOrNull())

            /** Sets [Builder.posterUrl] to an arbitrary JSON value. */
            fun posterUrl(posterUrl: JsonField<String>) = apply { this.posterUrl = posterUrl }

            /**
             * The MP4 sizes X stores for a video, highest bitrate first. Empty for photos, GIFs &
             * files first saved to Xquik before 2026-11-03.
             */
            fun qualities(qualities: List<Quality>) = qualities(JsonField.of(qualities))

            /** Sets [Builder.qualities] to an arbitrary JSON value. */
            fun qualities(qualities: JsonField<List<Quality>>) = apply {
                this.qualities = qualities.map { it.toMutableList() }
            }

            /**
             * Adds a single [Quality] to [qualities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQuality(quality: Quality) = apply {
                this.qualities =
                    (this.qualities ?: JsonField.of(mutableListOf())).also {
                        checkKnown("qualities", it).add(quality)
                    }
            }

            /** File size in bytes, as a string */
            fun fileSize(fileSize: String?) = fileSize(JsonField.ofNullable(fileSize))

            /** Alias for calling [Builder.fileSize] with `fileSize.orElse(null)`. */
            fun fileSize(fileSize: Optional<String>) = fileSize(fileSize.getOrNull())

            /** Sets [Builder.fileSize] to an arbitrary JSON value. */
            fun fileSize(fileSize: JsonField<String>) = apply { this.fileSize = fileSize }

            /** When the file joined your gallery */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun authorUsername(authorUsername: String) =
                authorUsername(JsonField.of(authorUsername))

            /** Sets [Builder.authorUsername] to an arbitrary JSON value. */
            fun authorUsername(authorUsername: JsonField<String>) = apply {
                this.authorUsername = authorUsername
            }

            fun authorDisplayName(authorDisplayName: String) =
                authorDisplayName(JsonField.of(authorDisplayName))

            /** Sets [Builder.authorDisplayName] to an arbitrary JSON value. */
            fun authorDisplayName(authorDisplayName: JsonField<String>) = apply {
                this.authorDisplayName = authorDisplayName
            }

            fun authorAvatar(authorAvatar: String?) =
                authorAvatar(JsonField.ofNullable(authorAvatar))

            /** Alias for calling [Builder.authorAvatar] with `authorAvatar.orElse(null)`. */
            fun authorAvatar(authorAvatar: Optional<String>) =
                authorAvatar(authorAvatar.getOrNull())

            /** Sets [Builder.authorAvatar] to an arbitrary JSON value. */
            fun authorAvatar(authorAvatar: JsonField<String>) = apply {
                this.authorAvatar = authorAvatar
            }

            fun tweetText(tweetText: String) = tweetText(JsonField.of(tweetText))

            /** Sets [Builder.tweetText] to an arbitrary JSON value. */
            fun tweetText(tweetText: JsonField<String>) = apply { this.tweetText = tweetText }

            fun likes(likes: Long?) = likes(JsonField.ofNullable(likes))

            /**
             * Alias for [Builder.likes].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun likes(likes: Long) = likes(likes as Long?)

            /** Alias for calling [Builder.likes] with `likes.orElse(null)`. */
            fun likes(likes: Optional<Long>) = likes(likes.getOrNull())

            /** Sets [Builder.likes] to an arbitrary JSON value. */
            fun likes(likes: JsonField<Long>) = apply { this.likes = likes }

            fun retweets(retweets: Long?) = retweets(JsonField.ofNullable(retweets))

            /**
             * Alias for [Builder.retweets].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun retweets(retweets: Long) = retweets(retweets as Long?)

            /** Alias for calling [Builder.retweets] with `retweets.orElse(null)`. */
            fun retweets(retweets: Optional<Long>) = retweets(retweets.getOrNull())

            /** Sets [Builder.retweets] to an arbitrary JSON value. */
            fun retweets(retweets: JsonField<Long>) = apply { this.retweets = retweets }

            fun views(views: Long?) = views(JsonField.ofNullable(views))

            /**
             * Alias for [Builder.views].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun views(views: Long) = views(views as Long?)

            /** Alias for calling [Builder.views] with `views.orElse(null)`. */
            fun views(views: Optional<Long>) = views(views.getOrNull())

            /** Sets [Builder.views] to an arbitrary JSON value. */
            fun views(views: JsonField<Long>) = apply { this.views = views }

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
             * Returns an immutable instance of [Item].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Item =
                Item(
                    checkRequired("id", id),
                    checkRequired("tweetId", tweetId),
                    checkRequired("mediaType", mediaType),
                    checkRequired("mediaUrl", mediaUrl),
                    checkRequired("posterUrl", posterUrl),
                    checkRequired("qualities", qualities).map { it.toImmutable() },
                    checkRequired("fileSize", fileSize),
                    checkRequired("createdAt", createdAt),
                    checkRequired("authorUsername", authorUsername),
                    checkRequired("authorDisplayName", authorDisplayName),
                    checkRequired("authorAvatar", authorAvatar),
                    checkRequired("tweetText", tweetText),
                    checkRequired("likes", likes),
                    checkRequired("retweets", retweets),
                    checkRequired("views", views),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Item = apply {
            if (validated) {
                return@apply
            }

            id()
            tweetId()
            mediaType().validate()
            mediaUrl()
            posterUrl()
            qualities().forEach { it.validate() }
            fileSize()
            createdAt()
            authorUsername()
            authorDisplayName()
            authorAvatar()
            tweetText()
            likes()
            retweets()
            views()
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
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (mediaType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (mediaUrl.asKnown().isPresent) 1 else 0) +
                (if (posterUrl.asKnown().isPresent) 1 else 0) +
                (qualities.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (fileSize.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (authorUsername.asKnown().isPresent) 1 else 0) +
                (if (authorDisplayName.asKnown().isPresent) 1 else 0) +
                (if (authorAvatar.asKnown().isPresent) 1 else 0) +
                (if (tweetText.asKnown().isPresent) 1 else 0) +
                (if (likes.asKnown().isPresent) 1 else 0) +
                (if (retweets.asKnown().isPresent) 1 else 0) +
                (if (views.asKnown().isPresent) 1 else 0)

        class Quality
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bitrate: JsonField<Long>,
            private val height: JsonField<Long>,
            private val url: JsonField<String>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bitrate")
                @ExcludeMissing
                bitrate: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(bitrate, height, url, width, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun bitrate(): Long = bitrate.getRequired("bitrate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun height(): Long = height.getRequired("height")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun url(): String = url.getRequired("url")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun width(): Long = width.getRequired("width")

            /**
             * Returns the raw JSON value of [bitrate].
             *
             * Unlike [bitrate], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bitrate") @ExcludeMissing fun _bitrate(): JsonField<Long> = bitrate

            /**
             * Returns the raw JSON value of [height].
             *
             * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [Quality].
                 *
                 * The following fields are required:
                 * ```java
                 * .bitrate()
                 * .height()
                 * .url()
                 * .width()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Quality]. */
            class Builder internal constructor() {

                private var bitrate: JsonField<Long>? = null
                private var height: JsonField<Long>? = null
                private var url: JsonField<String>? = null
                private var width: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(quality: Quality) = apply {
                    bitrate = quality.bitrate
                    height = quality.height
                    url = quality.url
                    width = quality.width
                    additionalProperties = quality.additionalProperties.toMutableMap()
                }

                fun bitrate(bitrate: Long) = bitrate(JsonField.of(bitrate))

                /** Sets [Builder.bitrate] to an arbitrary JSON value. */
                fun bitrate(bitrate: JsonField<Long>) = apply { this.bitrate = bitrate }

                fun height(height: Long) = height(JsonField.of(height))

                /** Sets [Builder.height] to an arbitrary JSON value. */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [Quality].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bitrate()
                 * .height()
                 * .url()
                 * .width()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Quality =
                    Quality(
                        checkRequired("bitrate", bitrate),
                        checkRequired("height", height),
                        checkRequired("url", url),
                        checkRequired("width", width),
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
            fun validate(): Quality = apply {
                if (validated) {
                    return@apply
                }

                bitrate()
                height()
                url()
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
                (if (bitrate.asKnown().isPresent) 1 else 0) +
                    (if (height.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (width.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Quality &&
                    bitrate == other.bitrate &&
                    height == other.height &&
                    url == other.url &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bitrate, height, url, width, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Quality{bitrate=$bitrate, height=$height, url=$url, width=$width, additionalProperties=$additionalProperties}"
        }

        class MediaType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PHOTO = of("photo")

                @JvmField val VIDEO = of("video")

                @JvmField val ANIMATED_GIF = of("animated_gif")

                @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
            }

            /** An enum containing [MediaType]'s known values. */
            enum class Known {
                PHOTO,
                VIDEO,
                ANIMATED_GIF,
            }

            /** An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                PHOTO,
                VIDEO,
                ANIMATED_GIF,
                /**
                 * An enum member indicating that [MediaType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if unknown.
             */
            fun value(): Value =
                when (this) {
                    PHOTO -> Value.PHOTO
                    VIDEO -> Value.VIDEO
                    ANIMATED_GIF -> Value.ANIMATED_GIF
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
                    PHOTO -> Known.PHOTO
                    VIDEO -> Known.VIDEO
                    ANIMATED_GIF -> Known.ANIMATED_GIF
                    else -> throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /** Validates that this value is a known member. */
            fun validate(): MediaType = apply {
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

                return other is MediaType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Item &&
                id == other.id &&
                tweetId == other.tweetId &&
                mediaType == other.mediaType &&
                mediaUrl == other.mediaUrl &&
                posterUrl == other.posterUrl &&
                qualities == other.qualities &&
                fileSize == other.fileSize &&
                createdAt == other.createdAt &&
                authorUsername == other.authorUsername &&
                authorDisplayName == other.authorDisplayName &&
                authorAvatar == other.authorAvatar &&
                tweetText == other.tweetText &&
                likes == other.likes &&
                retweets == other.retweets &&
                views == other.views &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                tweetId,
                mediaType,
                mediaUrl,
                posterUrl,
                qualities,
                fileSize,
                createdAt,
                authorUsername,
                authorDisplayName,
                authorAvatar,
                tweetText,
                likes,
                retweets,
                views,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Item{id=$id, tweetId=$tweetId, mediaType=$mediaType, mediaUrl=$mediaUrl, posterUrl=$posterUrl, qualities=$qualities, fileSize=$fileSize, createdAt=$createdAt, authorUsername=$authorUsername, authorDisplayName=$authorDisplayName, authorAvatar=$authorAvatar, tweetText=$tweetText, likes=$likes, retweets=$retweets, views=$views, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MediaDownloadResponse &&
            cacheHit == other.cacheHit &&
            galleryUrl == other.galleryUrl &&
            totalMedia == other.totalMedia &&
            totalTweets == other.totalTweets &&
            tweetId == other.tweetId &&
            items == other.items &&
            imageFilter == other.imageFilter &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            cacheHit,
            galleryUrl,
            totalMedia,
            totalTweets,
            tweetId,
            items,
            imageFilter,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MediaDownloadResponse{cacheHit=$cacheHit, galleryUrl=$galleryUrl, totalMedia=$totalMedia, totalTweets=$totalTweets, tweetId=$tweetId, items=$items, imageFilter=$imageFilter, additionalProperties=$additionalProperties}"
}
