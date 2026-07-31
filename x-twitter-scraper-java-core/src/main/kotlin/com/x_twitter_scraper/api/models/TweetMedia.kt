// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Normalized media attached to a tweet. */
class TweetMedia
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mediaUrl: JsonField<String>,
    private val type: JsonField<Type>,
    private val url: JsonField<String>,
    private val id: JsonField<String>,
    private val allowDownload: JsonField<Boolean>,
    private val altText: JsonField<String>,
    private val aspectRatio: JsonField<List<Long>>,
    private val availabilityStatus: JsonField<String>,
    private val displayUrl: JsonField<String>,
    private val durationMillis: JsonField<Long>,
    private val expandedUrl: JsonField<String>,
    private val faceRects: JsonField<FaceRects>,
    private val focusRects: JsonField<List<FocusRect>>,
    private val height: JsonField<Long>,
    private val indices: JsonField<List<Long>>,
    private val mediaKey: JsonField<String>,
    private val monetizable: JsonField<Boolean>,
    private val sizes: JsonField<Sizes>,
    private val videoVariants: JsonField<List<VideoVariant>>,
    private val width: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mediaUrl") @ExcludeMissing mediaUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("allowDownload")
        @ExcludeMissing
        allowDownload: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("altText") @ExcludeMissing altText: JsonField<String> = JsonMissing.of(),
        @JsonProperty("aspectRatio")
        @ExcludeMissing
        aspectRatio: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("availabilityStatus")
        @ExcludeMissing
        availabilityStatus: JsonField<String> = JsonMissing.of(),
        @JsonProperty("displayUrl")
        @ExcludeMissing
        displayUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("durationMillis")
        @ExcludeMissing
        durationMillis: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("expandedUrl")
        @ExcludeMissing
        expandedUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("faceRects")
        @ExcludeMissing
        faceRects: JsonField<FaceRects> = JsonMissing.of(),
        @JsonProperty("focusRects")
        @ExcludeMissing
        focusRects: JsonField<List<FocusRect>> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("indices") @ExcludeMissing indices: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("mediaKey") @ExcludeMissing mediaKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("monetizable")
        @ExcludeMissing
        monetizable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("sizes") @ExcludeMissing sizes: JsonField<Sizes> = JsonMissing.of(),
        @JsonProperty("videoVariants")
        @ExcludeMissing
        videoVariants: JsonField<List<VideoVariant>> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
    ) : this(
        mediaUrl,
        type,
        url,
        id,
        allowDownload,
        altText,
        aspectRatio,
        availabilityStatus,
        displayUrl,
        durationMillis,
        expandedUrl,
        faceRects,
        focusRects,
        height,
        indices,
        mediaKey,
        monetizable,
        sizes,
        videoVariants,
        width,
        mutableMapOf(),
    )

    /**
     * Media preview URL
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mediaUrl(): String = mediaUrl.getRequired("mediaUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * X media link from the tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

    /**
     * X media entity ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Whether X permits direct media download.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun allowDownload(): Optional<Boolean> = allowDownload.getOptional("allowDownload")

    /**
     * Accessibility text supplied for the media.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun altText(): Optional<String> = altText.getOptional("altText")

    /**
     * Video aspect ratio as width and height.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun aspectRatio(): Optional<List<Long>> = aspectRatio.getOptional("aspectRatio")

    /**
     * Media availability state reported by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun availabilityStatus(): Optional<String> =
        availabilityStatus.getOptional("availabilityStatus")

    /**
     * Display-friendly media URL reported by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun displayUrl(): Optional<String> = displayUrl.getOptional("displayUrl")

    /**
     * Video duration in milliseconds.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun durationMillis(): Optional<Long> = durationMillis.getOptional("durationMillis")

    /**
     * Expanded X media URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun expandedUrl(): Optional<String> = expandedUrl.getOptional("expandedUrl")

    /**
     * Face-aware crop rectangles grouped by media size.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun faceRects(): Optional<FaceRects> = faceRects.getOptional("faceRects")

    /**
     * Suggested image crops reported by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun focusRects(): Optional<List<FocusRect>> = focusRects.getOptional("focusRects")

    /**
     * Original media height.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun height(): Optional<Long> = height.getOptional("height")

    /**
     * Media entity offsets in the tweet text.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun indices(): Optional<List<Long>> = indices.getOptional("indices")

    /**
     * Stable X media key.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

    /**
     * Whether X reports the media as monetizable.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun monetizable(): Optional<Boolean> = monetizable.getOptional("monetizable")

    /**
     * Named media renditions and resize modes.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sizes(): Optional<Sizes> = sizes.getOptional("sizes")

    /**
     * Available video encodings, ordered as returned
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun videoVariants(): Optional<List<VideoVariant>> = videoVariants.getOptional("videoVariants")

    /**
     * Original media width.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun width(): Optional<Long> = width.getOptional("width")

    /**
     * Returns the raw JSON value of [mediaUrl].
     *
     * Unlike [mediaUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaUrl") @ExcludeMissing fun _mediaUrl(): JsonField<String> = mediaUrl

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [allowDownload].
     *
     * Unlike [allowDownload], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowDownload")
    @ExcludeMissing
    fun _allowDownload(): JsonField<Boolean> = allowDownload

    /**
     * Returns the raw JSON value of [altText].
     *
     * Unlike [altText], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("altText") @ExcludeMissing fun _altText(): JsonField<String> = altText

    /**
     * Returns the raw JSON value of [aspectRatio].
     *
     * Unlike [aspectRatio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aspectRatio")
    @ExcludeMissing
    fun _aspectRatio(): JsonField<List<Long>> = aspectRatio

    /**
     * Returns the raw JSON value of [availabilityStatus].
     *
     * Unlike [availabilityStatus], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("availabilityStatus")
    @ExcludeMissing
    fun _availabilityStatus(): JsonField<String> = availabilityStatus

    /**
     * Returns the raw JSON value of [displayUrl].
     *
     * Unlike [displayUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("displayUrl") @ExcludeMissing fun _displayUrl(): JsonField<String> = displayUrl

    /**
     * Returns the raw JSON value of [durationMillis].
     *
     * Unlike [durationMillis], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("durationMillis")
    @ExcludeMissing
    fun _durationMillis(): JsonField<Long> = durationMillis

    /**
     * Returns the raw JSON value of [expandedUrl].
     *
     * Unlike [expandedUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expandedUrl") @ExcludeMissing fun _expandedUrl(): JsonField<String> = expandedUrl

    /**
     * Returns the raw JSON value of [faceRects].
     *
     * Unlike [faceRects], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("faceRects") @ExcludeMissing fun _faceRects(): JsonField<FaceRects> = faceRects

    /**
     * Returns the raw JSON value of [focusRects].
     *
     * Unlike [focusRects], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("focusRects")
    @ExcludeMissing
    fun _focusRects(): JsonField<List<FocusRect>> = focusRects

    /**
     * Returns the raw JSON value of [height].
     *
     * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

    /**
     * Returns the raw JSON value of [indices].
     *
     * Unlike [indices], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("indices") @ExcludeMissing fun _indices(): JsonField<List<Long>> = indices

    /**
     * Returns the raw JSON value of [mediaKey].
     *
     * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

    /**
     * Returns the raw JSON value of [monetizable].
     *
     * Unlike [monetizable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monetizable")
    @ExcludeMissing
    fun _monetizable(): JsonField<Boolean> = monetizable

    /**
     * Returns the raw JSON value of [sizes].
     *
     * Unlike [sizes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sizes") @ExcludeMissing fun _sizes(): JsonField<Sizes> = sizes

    /**
     * Returns the raw JSON value of [videoVariants].
     *
     * Unlike [videoVariants], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("videoVariants")
    @ExcludeMissing
    fun _videoVariants(): JsonField<List<VideoVariant>> = videoVariants

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
         * Returns a mutable builder for constructing an instance of [TweetMedia].
         *
         * The following fields are required:
         * ```java
         * .mediaUrl()
         * .type()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetMedia]. */
    class Builder internal constructor() {

        private var mediaUrl: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var url: JsonField<String>? = null
        private var id: JsonField<String> = JsonMissing.of()
        private var allowDownload: JsonField<Boolean> = JsonMissing.of()
        private var altText: JsonField<String> = JsonMissing.of()
        private var aspectRatio: JsonField<MutableList<Long>>? = null
        private var availabilityStatus: JsonField<String> = JsonMissing.of()
        private var displayUrl: JsonField<String> = JsonMissing.of()
        private var durationMillis: JsonField<Long> = JsonMissing.of()
        private var expandedUrl: JsonField<String> = JsonMissing.of()
        private var faceRects: JsonField<FaceRects> = JsonMissing.of()
        private var focusRects: JsonField<MutableList<FocusRect>>? = null
        private var height: JsonField<Long> = JsonMissing.of()
        private var indices: JsonField<MutableList<Long>>? = null
        private var mediaKey: JsonField<String> = JsonMissing.of()
        private var monetizable: JsonField<Boolean> = JsonMissing.of()
        private var sizes: JsonField<Sizes> = JsonMissing.of()
        private var videoVariants: JsonField<MutableList<VideoVariant>>? = null
        private var width: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetMedia: TweetMedia) = apply {
            mediaUrl = tweetMedia.mediaUrl
            type = tweetMedia.type
            url = tweetMedia.url
            id = tweetMedia.id
            allowDownload = tweetMedia.allowDownload
            altText = tweetMedia.altText
            aspectRatio = tweetMedia.aspectRatio.map { it.toMutableList() }
            availabilityStatus = tweetMedia.availabilityStatus
            displayUrl = tweetMedia.displayUrl
            durationMillis = tweetMedia.durationMillis
            expandedUrl = tweetMedia.expandedUrl
            faceRects = tweetMedia.faceRects
            focusRects = tweetMedia.focusRects.map { it.toMutableList() }
            height = tweetMedia.height
            indices = tweetMedia.indices.map { it.toMutableList() }
            mediaKey = tweetMedia.mediaKey
            monetizable = tweetMedia.monetizable
            sizes = tweetMedia.sizes
            videoVariants = tweetMedia.videoVariants.map { it.toMutableList() }
            width = tweetMedia.width
            additionalProperties = tweetMedia.additionalProperties.toMutableMap()
        }

        /** Media preview URL */
        fun mediaUrl(mediaUrl: String) = mediaUrl(JsonField.of(mediaUrl))

        /**
         * Sets [Builder.mediaUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaUrl(mediaUrl: JsonField<String>) = apply { this.mediaUrl = mediaUrl }

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** X media link from the tweet */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** X media entity ID. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Whether X permits direct media download. */
        fun allowDownload(allowDownload: Boolean) = allowDownload(JsonField.of(allowDownload))

        /**
         * Sets [Builder.allowDownload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowDownload] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowDownload(allowDownload: JsonField<Boolean>) = apply {
            this.allowDownload = allowDownload
        }

        /** Accessibility text supplied for the media. */
        fun altText(altText: String) = altText(JsonField.of(altText))

        /**
         * Sets [Builder.altText] to an arbitrary JSON value.
         *
         * You should usually call [Builder.altText] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun altText(altText: JsonField<String>) = apply { this.altText = altText }

        /** Video aspect ratio as width and height. */
        fun aspectRatio(aspectRatio: List<Long>) = aspectRatio(JsonField.of(aspectRatio))

        /**
         * Sets [Builder.aspectRatio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aspectRatio] with a well-typed `List<Long>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aspectRatio(aspectRatio: JsonField<List<Long>>) = apply {
            this.aspectRatio = aspectRatio.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [Builder.aspectRatio].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAspectRatio(aspectRatio: Long) = apply {
            this.aspectRatio =
                (this.aspectRatio ?: JsonField.of(mutableListOf())).also {
                    checkKnown("aspectRatio", it).add(aspectRatio)
                }
        }

        /** Media availability state reported by X. */
        fun availabilityStatus(availabilityStatus: String) =
            availabilityStatus(JsonField.of(availabilityStatus))

        /**
         * Sets [Builder.availabilityStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.availabilityStatus] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun availabilityStatus(availabilityStatus: JsonField<String>) = apply {
            this.availabilityStatus = availabilityStatus
        }

        /** Display-friendly media URL reported by X. */
        fun displayUrl(displayUrl: String) = displayUrl(JsonField.of(displayUrl))

        /**
         * Sets [Builder.displayUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayUrl(displayUrl: JsonField<String>) = apply { this.displayUrl = displayUrl }

        /** Video duration in milliseconds. */
        fun durationMillis(durationMillis: Long) = durationMillis(JsonField.of(durationMillis))

        /**
         * Sets [Builder.durationMillis] to an arbitrary JSON value.
         *
         * You should usually call [Builder.durationMillis] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun durationMillis(durationMillis: JsonField<Long>) = apply {
            this.durationMillis = durationMillis
        }

        /** Expanded X media URL. */
        fun expandedUrl(expandedUrl: String) = expandedUrl(JsonField.of(expandedUrl))

        /**
         * Sets [Builder.expandedUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expandedUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun expandedUrl(expandedUrl: JsonField<String>) = apply { this.expandedUrl = expandedUrl }

        /** Face-aware crop rectangles grouped by media size. */
        fun faceRects(faceRects: FaceRects) = faceRects(JsonField.of(faceRects))

        /**
         * Sets [Builder.faceRects] to an arbitrary JSON value.
         *
         * You should usually call [Builder.faceRects] with a well-typed [FaceRects] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun faceRects(faceRects: JsonField<FaceRects>) = apply { this.faceRects = faceRects }

        /** Suggested image crops reported by X. */
        fun focusRects(focusRects: List<FocusRect>) = focusRects(JsonField.of(focusRects))

        /**
         * Sets [Builder.focusRects] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focusRects] with a well-typed `List<FocusRect>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun focusRects(focusRects: JsonField<List<FocusRect>>) = apply {
            this.focusRects = focusRects.map { it.toMutableList() }
        }

        /**
         * Adds a single [FocusRect] to [focusRects].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFocusRect(focusRect: FocusRect) = apply {
            focusRects =
                (focusRects ?: JsonField.of(mutableListOf())).also {
                    checkKnown("focusRects", it).add(focusRect)
                }
        }

        /** Original media height. */
        fun height(height: Long) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Long>) = apply { this.height = height }

        /** Media entity offsets in the tweet text. */
        fun indices(indices: List<Long>) = indices(JsonField.of(indices))

        /**
         * Sets [Builder.indices] to an arbitrary JSON value.
         *
         * You should usually call [Builder.indices] with a well-typed `List<Long>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun indices(indices: JsonField<List<Long>>) = apply {
            this.indices = indices.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [indices].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addIndex(index: Long) = apply {
            indices =
                (indices ?: JsonField.of(mutableListOf())).also {
                    checkKnown("indices", it).add(index)
                }
        }

        /** Stable X media key. */
        fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

        /**
         * Sets [Builder.mediaKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaKey] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

        /** Whether X reports the media as monetizable. */
        fun monetizable(monetizable: Boolean) = monetizable(JsonField.of(monetizable))

        /**
         * Sets [Builder.monetizable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.monetizable] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun monetizable(monetizable: JsonField<Boolean>) = apply { this.monetizable = monetizable }

        /** Named media renditions and resize modes. */
        fun sizes(sizes: Sizes) = sizes(JsonField.of(sizes))

        /**
         * Sets [Builder.sizes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sizes] with a well-typed [Sizes] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sizes(sizes: JsonField<Sizes>) = apply { this.sizes = sizes }

        /** Available video encodings, ordered as returned */
        fun videoVariants(videoVariants: List<VideoVariant>) =
            videoVariants(JsonField.of(videoVariants))

        /**
         * Sets [Builder.videoVariants] to an arbitrary JSON value.
         *
         * You should usually call [Builder.videoVariants] with a well-typed `List<VideoVariant>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun videoVariants(videoVariants: JsonField<List<VideoVariant>>) = apply {
            this.videoVariants = videoVariants.map { it.toMutableList() }
        }

        /**
         * Adds a single [VideoVariant] to [videoVariants].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVideoVariant(videoVariant: VideoVariant) = apply {
            videoVariants =
                (videoVariants ?: JsonField.of(mutableListOf())).also {
                    checkKnown("videoVariants", it).add(videoVariant)
                }
        }

        /** Original media width. */
        fun width(width: Long) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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
         * Returns an immutable instance of [TweetMedia].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .mediaUrl()
         * .type()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetMedia =
            TweetMedia(
                checkRequired("mediaUrl", mediaUrl),
                checkRequired("type", type),
                checkRequired("url", url),
                id,
                allowDownload,
                altText,
                (aspectRatio ?: JsonMissing.of()).map { it.toImmutable() },
                availabilityStatus,
                displayUrl,
                durationMillis,
                expandedUrl,
                faceRects,
                (focusRects ?: JsonMissing.of()).map { it.toImmutable() },
                height,
                (indices ?: JsonMissing.of()).map { it.toImmutable() },
                mediaKey,
                monetizable,
                sizes,
                (videoVariants ?: JsonMissing.of()).map { it.toImmutable() },
                width,
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
    fun validate(): TweetMedia = apply {
        if (validated) {
            return@apply
        }

        mediaUrl()
        type().validate()
        url()
        id()
        allowDownload()
        altText()
        aspectRatio()
        availabilityStatus()
        displayUrl()
        durationMillis()
        expandedUrl()
        faceRects().ifPresent { it.validate() }
        focusRects().ifPresent { it.forEach { it.validate() } }
        height()
        indices()
        mediaKey()
        monetizable()
        sizes().ifPresent { it.validate() }
        videoVariants().ifPresent { it.forEach { it.validate() } }
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (mediaUrl.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (id.asKnown().isPresent) 1 else 0) +
            (if (allowDownload.asKnown().isPresent) 1 else 0) +
            (if (altText.asKnown().isPresent) 1 else 0) +
            (aspectRatio.asKnown().getOrNull()?.size ?: 0) +
            (if (availabilityStatus.asKnown().isPresent) 1 else 0) +
            (if (displayUrl.asKnown().isPresent) 1 else 0) +
            (if (durationMillis.asKnown().isPresent) 1 else 0) +
            (if (expandedUrl.asKnown().isPresent) 1 else 0) +
            (faceRects.asKnown().getOrNull()?.validity() ?: 0) +
            (focusRects.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (height.asKnown().isPresent) 1 else 0) +
            (indices.asKnown().getOrNull()?.size ?: 0) +
            (if (mediaKey.asKnown().isPresent) 1 else 0) +
            (if (monetizable.asKnown().isPresent) 1 else 0) +
            (sizes.asKnown().getOrNull()?.validity() ?: 0) +
            (videoVariants.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (width.asKnown().isPresent) 1 else 0)

    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PHOTO = of("photo")

            @JvmField val VIDEO = of("video")

            @JvmField val ANIMATED_GIF = of("animated_gif")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            PHOTO,
            VIDEO,
            ANIMATED_GIF,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PHOTO,
            VIDEO,
            ANIMATED_GIF,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                PHOTO -> Known.PHOTO
                VIDEO -> Known.VIDEO
                ANIMATED_GIF -> Known.ANIMATED_GIF
                else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Face-aware crop rectangles grouped by media size. */
    class FaceRects
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

            /** Returns a mutable builder for constructing an instance of [FaceRects]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FaceRects]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(faceRects: FaceRects) = apply {
                additionalProperties = faceRects.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [FaceRects].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FaceRects = FaceRects(additionalProperties.toImmutable())
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
        fun validate(): FaceRects = apply {
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
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FaceRects && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "FaceRects{additionalProperties=$additionalProperties}"
    }

    class FocusRect
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val h: JsonField<Long>,
        private val w: JsonField<Long>,
        private val x: JsonField<Long>,
        private val y: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("h") @ExcludeMissing h: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("w") @ExcludeMissing w: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("x") @ExcludeMissing x: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("y") @ExcludeMissing y: JsonField<Long> = JsonMissing.of(),
        ) : this(h, w, x, y, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun h(): Long = h.getRequired("h")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun w(): Long = w.getRequired("w")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun x(): Long = x.getRequired("x")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun y(): Long = y.getRequired("y")

        /**
         * Returns the raw JSON value of [h].
         *
         * Unlike [h], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("h") @ExcludeMissing fun _h(): JsonField<Long> = h

        /**
         * Returns the raw JSON value of [w].
         *
         * Unlike [w], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("w") @ExcludeMissing fun _w(): JsonField<Long> = w

        /**
         * Returns the raw JSON value of [x].
         *
         * Unlike [x], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

        /**
         * Returns the raw JSON value of [y].
         *
         * Unlike [y], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

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
             * Returns a mutable builder for constructing an instance of [FocusRect].
             *
             * The following fields are required:
             * ```java
             * .h()
             * .w()
             * .x()
             * .y()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FocusRect]. */
        class Builder internal constructor() {

            private var h: JsonField<Long>? = null
            private var w: JsonField<Long>? = null
            private var x: JsonField<Long>? = null
            private var y: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(focusRect: FocusRect) = apply {
                h = focusRect.h
                w = focusRect.w
                x = focusRect.x
                y = focusRect.y
                additionalProperties = focusRect.additionalProperties.toMutableMap()
            }

            fun h(h: Long) = h(JsonField.of(h))

            /**
             * Sets [Builder.h] to an arbitrary JSON value.
             *
             * You should usually call [Builder.h] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun h(h: JsonField<Long>) = apply { this.h = h }

            fun w(w: Long) = w(JsonField.of(w))

            /**
             * Sets [Builder.w] to an arbitrary JSON value.
             *
             * You should usually call [Builder.w] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun w(w: JsonField<Long>) = apply { this.w = w }

            fun x(x: Long) = x(JsonField.of(x))

            /**
             * Sets [Builder.x] to an arbitrary JSON value.
             *
             * You should usually call [Builder.x] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun x(x: JsonField<Long>) = apply { this.x = x }

            fun y(y: Long) = y(JsonField.of(y))

            /**
             * Sets [Builder.y] to an arbitrary JSON value.
             *
             * You should usually call [Builder.y] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun y(y: JsonField<Long>) = apply { this.y = y }

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
             * Returns an immutable instance of [FocusRect].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .h()
             * .w()
             * .x()
             * .y()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FocusRect =
                FocusRect(
                    checkRequired("h", h),
                    checkRequired("w", w),
                    checkRequired("x", x),
                    checkRequired("y", y),
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
        fun validate(): FocusRect = apply {
            if (validated) {
                return@apply
            }

            h()
            w()
            x()
            y()
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
            (if (h.asKnown().isPresent) 1 else 0) +
                (if (w.asKnown().isPresent) 1 else 0) +
                (if (x.asKnown().isPresent) 1 else 0) +
                (if (y.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FocusRect &&
                h == other.h &&
                w == other.w &&
                x == other.x &&
                y == other.y &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(h, w, x, y, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FocusRect{h=$h, w=$w, x=$x, y=$y, additionalProperties=$additionalProperties}"
    }

    /** Named media renditions and resize modes. */
    class Sizes
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

            /** Returns a mutable builder for constructing an instance of [Sizes]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Sizes]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(sizes: Sizes) = apply {
                additionalProperties = sizes.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Sizes].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Sizes = Sizes(additionalProperties.toImmutable())
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
        fun validate(): Sizes = apply {
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
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Sizes && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Sizes{additionalProperties=$additionalProperties}"
    }

    class VideoVariant
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentType: JsonField<String>,
        private val url: JsonField<String>,
        private val bitrate: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("contentType")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bitrate") @ExcludeMissing bitrate: JsonField<Long> = JsonMissing.of(),
        ) : this(contentType, url, bitrate, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun contentType(): String = contentType.getRequired("contentType")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun url(): String = url.getRequired("url")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bitrate(): Optional<Long> = bitrate.getOptional("bitrate")

        /**
         * Returns the raw JSON value of [contentType].
         *
         * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contentType")
        @ExcludeMissing
        fun _contentType(): JsonField<String> = contentType

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [bitrate].
         *
         * Unlike [bitrate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bitrate") @ExcludeMissing fun _bitrate(): JsonField<Long> = bitrate

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
             * Returns a mutable builder for constructing an instance of [VideoVariant].
             *
             * The following fields are required:
             * ```java
             * .contentType()
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [VideoVariant]. */
        class Builder internal constructor() {

            private var contentType: JsonField<String>? = null
            private var url: JsonField<String>? = null
            private var bitrate: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(videoVariant: VideoVariant) = apply {
                contentType = videoVariant.contentType
                url = videoVariant.url
                bitrate = videoVariant.bitrate
                additionalProperties = videoVariant.additionalProperties.toMutableMap()
            }

            fun contentType(contentType: String) = contentType(JsonField.of(contentType))

            /**
             * Sets [Builder.contentType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentType(contentType: JsonField<String>) = apply {
                this.contentType = contentType
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

            fun bitrate(bitrate: Long) = bitrate(JsonField.of(bitrate))

            /**
             * Sets [Builder.bitrate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bitrate] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bitrate(bitrate: JsonField<Long>) = apply { this.bitrate = bitrate }

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
             * Returns an immutable instance of [VideoVariant].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentType()
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): VideoVariant =
                VideoVariant(
                    checkRequired("contentType", contentType),
                    checkRequired("url", url),
                    bitrate,
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
        fun validate(): VideoVariant = apply {
            if (validated) {
                return@apply
            }

            contentType()
            url()
            bitrate()
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
            (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (bitrate.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VideoVariant &&
                contentType == other.contentType &&
                url == other.url &&
                bitrate == other.bitrate &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(contentType, url, bitrate, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "VideoVariant{contentType=$contentType, url=$url, bitrate=$bitrate, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetMedia &&
            mediaUrl == other.mediaUrl &&
            type == other.type &&
            url == other.url &&
            id == other.id &&
            allowDownload == other.allowDownload &&
            altText == other.altText &&
            aspectRatio == other.aspectRatio &&
            availabilityStatus == other.availabilityStatus &&
            displayUrl == other.displayUrl &&
            durationMillis == other.durationMillis &&
            expandedUrl == other.expandedUrl &&
            faceRects == other.faceRects &&
            focusRects == other.focusRects &&
            height == other.height &&
            indices == other.indices &&
            mediaKey == other.mediaKey &&
            monetizable == other.monetizable &&
            sizes == other.sizes &&
            videoVariants == other.videoVariants &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            mediaUrl,
            type,
            url,
            id,
            allowDownload,
            altText,
            aspectRatio,
            availabilityStatus,
            displayUrl,
            durationMillis,
            expandedUrl,
            faceRects,
            focusRects,
            height,
            indices,
            mediaKey,
            monetizable,
            sizes,
            videoVariants,
            width,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetMedia{mediaUrl=$mediaUrl, type=$type, url=$url, id=$id, allowDownload=$allowDownload, altText=$altText, aspectRatio=$aspectRatio, availabilityStatus=$availabilityStatus, displayUrl=$displayUrl, durationMillis=$durationMillis, expandedUrl=$expandedUrl, faceRects=$faceRects, focusRects=$focusRects, height=$height, indices=$indices, mediaKey=$mediaKey, monetizable=$monetizable, sizes=$sizes, videoVariants=$videoVariants, width=$width, additionalProperties=$additionalProperties}"
}
