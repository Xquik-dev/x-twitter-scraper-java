// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetTranslateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val translation: JsonField<Translation>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("translation")
        @ExcludeMissing
        translation: JsonField<Translation> = JsonMissing.of()
    ) : this(translation, mutableMapOf())

    /**
     * Holds X's translation of 1 tweet into the requested language. `entities` holds the links,
     * mentions, and tags with their offsets in the translated text, and is empty when the text has
     * none.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun translation(): Translation = translation.getRequired("translation")

    /**
     * Returns the raw JSON value of [translation].
     *
     * Unlike [translation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("translation")
    @ExcludeMissing
    fun _translation(): JsonField<Translation> = translation

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
         * Returns a mutable builder for constructing an instance of [TweetTranslateResponse].
         *
         * The following fields are required:
         * ```java
         * .translation()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetTranslateResponse]. */
    class Builder internal constructor() {

        private var translation: JsonField<Translation>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetTranslateResponse: TweetTranslateResponse) = apply {
            translation = tweetTranslateResponse.translation
            additionalProperties = tweetTranslateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Holds X's translation of 1 tweet into the requested language. `entities` holds the links,
         * mentions, and tags with their offsets in the translated text, and is empty when the text
         * has none.
         */
        fun translation(translation: Translation) = translation(JsonField.of(translation))

        /** Sets [Builder.translation] to an arbitrary JSON value. */
        fun translation(translation: JsonField<Translation>) = apply {
            this.translation = translation
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
         * Returns an immutable instance of [TweetTranslateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .translation()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetTranslateResponse =
            TweetTranslateResponse(
                checkRequired("translation", translation),
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
    fun validate(): TweetTranslateResponse = apply {
        if (validated) {
            return@apply
        }

        translation().validate()
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
    internal fun validity(): Int = (translation.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Holds X's translation of 1 tweet into the requested language. `entities` holds the links,
     * mentions, and tags with their offsets in the translated text, and is empty when the text has
     * none.
     */
    class Translation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val entities: JsonField<Entities>,
        private val language: JsonField<String>,
        private val text: JsonField<String>,
        private val tweetId: JsonField<String>,
        private val sourceLanguage: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("entities")
            @ExcludeMissing
            entities: JsonField<Entities> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceLanguage")
            @ExcludeMissing
            sourceLanguage: JsonField<String> = JsonMissing.of(),
        ) : this(entities, language, text, tweetId, sourceLanguage, mutableMapOf())

        /**
         * Lists hashtags, symbols, links, and mentions from tweet text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun entities(): Entities = entities.getRequired("entities")

        /**
         * Language code of the translated text, in lower case.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun language(): String = language.getRequired("language")

        /**
         * Translated tweet text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun text(): String = text.getRequired("text")

        /**
         * ID of the translated tweet.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tweetId(): String = tweetId.getRequired("tweetId")

        /**
         * Language code X detects in the tweet, when it names one.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun sourceLanguage(): Optional<String> = sourceLanguage.getOptional("sourceLanguage")

        /**
         * Returns the raw JSON value of [entities].
         *
         * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entities") @ExcludeMissing fun _entities(): JsonField<Entities> = entities

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /**
         * Returns the raw JSON value of [sourceLanguage].
         *
         * Unlike [sourceLanguage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourceLanguage")
        @ExcludeMissing
        fun _sourceLanguage(): JsonField<String> = sourceLanguage

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
             * Returns a mutable builder for constructing an instance of [Translation].
             *
             * The following fields are required:
             * ```java
             * .entities()
             * .language()
             * .text()
             * .tweetId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Translation]. */
        class Builder internal constructor() {

            private var entities: JsonField<Entities>? = null
            private var language: JsonField<String>? = null
            private var text: JsonField<String>? = null
            private var tweetId: JsonField<String>? = null
            private var sourceLanguage: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(translation: Translation) = apply {
                entities = translation.entities
                language = translation.language
                text = translation.text
                tweetId = translation.tweetId
                sourceLanguage = translation.sourceLanguage
                additionalProperties = translation.additionalProperties.toMutableMap()
            }

            /** Lists hashtags, symbols, links, and mentions from tweet text. */
            fun entities(entities: Entities) = entities(JsonField.of(entities))

            /** Sets [Builder.entities] to an arbitrary JSON value. */
            fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

            /** Language code of the translated text, in lower case. */
            fun language(language: String) = language(JsonField.of(language))

            /** Sets [Builder.language] to an arbitrary JSON value. */
            fun language(language: JsonField<String>) = apply { this.language = language }

            /** Translated tweet text. */
            fun text(text: String) = text(JsonField.of(text))

            /** Sets [Builder.text] to an arbitrary JSON value. */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /** ID of the translated tweet. */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            /** Language code X detects in the tweet, when it names one. */
            fun sourceLanguage(sourceLanguage: String) =
                sourceLanguage(JsonField.of(sourceLanguage))

            /** Sets [Builder.sourceLanguage] to an arbitrary JSON value. */
            fun sourceLanguage(sourceLanguage: JsonField<String>) = apply {
                this.sourceLanguage = sourceLanguage
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
             * Returns an immutable instance of [Translation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .entities()
             * .language()
             * .text()
             * .tweetId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Translation =
                Translation(
                    checkRequired("entities", entities),
                    checkRequired("language", language),
                    checkRequired("text", text),
                    checkRequired("tweetId", tweetId),
                    sourceLanguage,
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
        fun validate(): Translation = apply {
            if (validated) {
                return@apply
            }

            entities().validate()
            language()
            text()
            tweetId()
            sourceLanguage()
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
            (entities.asKnown().getOrNull()?.validity() ?: 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (if (sourceLanguage.asKnown().isPresent) 1 else 0)

        /** Lists hashtags, symbols, links, and mentions from tweet text. */
        class Entities
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val hashtags: JsonField<List<Hashtag>>,
            private val smarttags: JsonField<List<Smarttag>>,
            private val symbols: JsonField<List<Symbol>>,
            private val timestamps: JsonField<List<Timestamp>>,
            private val urls: JsonField<List<Url>>,
            private val userMentions: JsonField<List<UserMention>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("hashtags")
                @ExcludeMissing
                hashtags: JsonField<List<Hashtag>> = JsonMissing.of(),
                @JsonProperty("smarttags")
                @ExcludeMissing
                smarttags: JsonField<List<Smarttag>> = JsonMissing.of(),
                @JsonProperty("symbols")
                @ExcludeMissing
                symbols: JsonField<List<Symbol>> = JsonMissing.of(),
                @JsonProperty("timestamps")
                @ExcludeMissing
                timestamps: JsonField<List<Timestamp>> = JsonMissing.of(),
                @JsonProperty("urls") @ExcludeMissing urls: JsonField<List<Url>> = JsonMissing.of(),
                @JsonProperty("user_mentions")
                @ExcludeMissing
                userMentions: JsonField<List<UserMention>> = JsonMissing.of(),
            ) : this(hashtags, smarttags, symbols, timestamps, urls, userMentions, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hashtags(): Optional<List<Hashtag>> = hashtags.getOptional("hashtags")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun smarttags(): Optional<List<Smarttag>> = smarttags.getOptional("smarttags")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun symbols(): Optional<List<Symbol>> = symbols.getOptional("symbols")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun timestamps(): Optional<List<Timestamp>> = timestamps.getOptional("timestamps")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun urls(): Optional<List<Url>> = urls.getOptional("urls")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun userMentions(): Optional<List<UserMention>> =
                userMentions.getOptional("user_mentions")

            /**
             * Returns the raw JSON value of [hashtags].
             *
             * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("hashtags")
            @ExcludeMissing
            fun _hashtags(): JsonField<List<Hashtag>> = hashtags

            /**
             * Returns the raw JSON value of [smarttags].
             *
             * Unlike [smarttags], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("smarttags")
            @ExcludeMissing
            fun _smarttags(): JsonField<List<Smarttag>> = smarttags

            /**
             * Returns the raw JSON value of [symbols].
             *
             * Unlike [symbols], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("symbols")
            @ExcludeMissing
            fun _symbols(): JsonField<List<Symbol>> = symbols

            /**
             * Returns the raw JSON value of [timestamps].
             *
             * Unlike [timestamps], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamps")
            @ExcludeMissing
            fun _timestamps(): JsonField<List<Timestamp>> = timestamps

            /**
             * Returns the raw JSON value of [urls].
             *
             * Unlike [urls], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("urls") @ExcludeMissing fun _urls(): JsonField<List<Url>> = urls

            /**
             * Returns the raw JSON value of [userMentions].
             *
             * Unlike [userMentions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("user_mentions")
            @ExcludeMissing
            fun _userMentions(): JsonField<List<UserMention>> = userMentions

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

                /** Returns a mutable builder for constructing an instance of [Entities]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Entities]. */
            class Builder internal constructor() {

                private var hashtags: JsonField<MutableList<Hashtag>>? = null
                private var smarttags: JsonField<MutableList<Smarttag>>? = null
                private var symbols: JsonField<MutableList<Symbol>>? = null
                private var timestamps: JsonField<MutableList<Timestamp>>? = null
                private var urls: JsonField<MutableList<Url>>? = null
                private var userMentions: JsonField<MutableList<UserMention>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(entities: Entities) = apply {
                    hashtags = entities.hashtags.map { it.toMutableList() }
                    smarttags = entities.smarttags.map { it.toMutableList() }
                    symbols = entities.symbols.map { it.toMutableList() }
                    timestamps = entities.timestamps.map { it.toMutableList() }
                    urls = entities.urls.map { it.toMutableList() }
                    userMentions = entities.userMentions.map { it.toMutableList() }
                    additionalProperties = entities.additionalProperties.toMutableMap()
                }

                fun hashtags(hashtags: List<Hashtag>) = hashtags(JsonField.of(hashtags))

                /** Sets [Builder.hashtags] to an arbitrary JSON value. */
                fun hashtags(hashtags: JsonField<List<Hashtag>>) = apply {
                    this.hashtags = hashtags.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Hashtag] to [hashtags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addHashtag(hashtag: Hashtag) = apply {
                    hashtags =
                        (hashtags ?: JsonField.of(mutableListOf())).also {
                            checkKnown("hashtags", it).add(hashtag)
                        }
                }

                fun smarttags(smarttags: List<Smarttag>) = smarttags(JsonField.of(smarttags))

                /** Sets [Builder.smarttags] to an arbitrary JSON value. */
                fun smarttags(smarttags: JsonField<List<Smarttag>>) = apply {
                    this.smarttags = smarttags.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Smarttag] to [smarttags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSmarttag(smarttag: Smarttag) = apply {
                    smarttags =
                        (smarttags ?: JsonField.of(mutableListOf())).also {
                            checkKnown("smarttags", it).add(smarttag)
                        }
                }

                fun symbols(symbols: List<Symbol>) = symbols(JsonField.of(symbols))

                /** Sets [Builder.symbols] to an arbitrary JSON value. */
                fun symbols(symbols: JsonField<List<Symbol>>) = apply {
                    this.symbols = symbols.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Symbol] to [symbols].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSymbol(symbol: Symbol) = apply {
                    symbols =
                        (symbols ?: JsonField.of(mutableListOf())).also {
                            checkKnown("symbols", it).add(symbol)
                        }
                }

                fun timestamps(timestamps: List<Timestamp>) = timestamps(JsonField.of(timestamps))

                /** Sets [Builder.timestamps] to an arbitrary JSON value. */
                fun timestamps(timestamps: JsonField<List<Timestamp>>) = apply {
                    this.timestamps = timestamps.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Timestamp] to [timestamps].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTimestamp(timestamp: Timestamp) = apply {
                    timestamps =
                        (timestamps ?: JsonField.of(mutableListOf())).also {
                            checkKnown("timestamps", it).add(timestamp)
                        }
                }

                fun urls(urls: List<Url>) = urls(JsonField.of(urls))

                /** Sets [Builder.urls] to an arbitrary JSON value. */
                fun urls(urls: JsonField<List<Url>>) = apply {
                    this.urls = urls.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Url] to [urls].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUrl(url: Url) = apply {
                    urls =
                        (urls ?: JsonField.of(mutableListOf())).also {
                            checkKnown("urls", it).add(url)
                        }
                }

                fun userMentions(userMentions: List<UserMention>) =
                    userMentions(JsonField.of(userMentions))

                /** Sets [Builder.userMentions] to an arbitrary JSON value. */
                fun userMentions(userMentions: JsonField<List<UserMention>>) = apply {
                    this.userMentions = userMentions.map { it.toMutableList() }
                }

                /**
                 * Adds a single [UserMention] to [userMentions].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUserMention(userMention: UserMention) = apply {
                    userMentions =
                        (userMentions ?: JsonField.of(mutableListOf())).also {
                            checkKnown("userMentions", it).add(userMention)
                        }
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
                 * Returns an immutable instance of [Entities].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Entities =
                    Entities(
                        (hashtags ?: JsonMissing.of()).map { it.toImmutable() },
                        (smarttags ?: JsonMissing.of()).map { it.toImmutable() },
                        (symbols ?: JsonMissing.of()).map { it.toImmutable() },
                        (timestamps ?: JsonMissing.of()).map { it.toImmutable() },
                        (urls ?: JsonMissing.of()).map { it.toImmutable() },
                        (userMentions ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Entities = apply {
                if (validated) {
                    return@apply
                }

                hashtags().ifPresent { it.forEach { it.validate() } }
                smarttags().ifPresent { it.forEach { it.validate() } }
                symbols().ifPresent { it.forEach { it.validate() } }
                timestamps().ifPresent { it.forEach { it.validate() } }
                urls().ifPresent { it.forEach { it.validate() } }
                userMentions().ifPresent { it.forEach { it.validate() } }
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
                (hashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (smarttags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (symbols.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (timestamps.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (urls.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (userMentions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

            /** Hashtag text and its source offsets in a tweet. */
            class Hashtag
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val indices: JsonField<List<Long>>,
                private val tag: JsonField<Tag>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("tag") @ExcludeMissing tag: JsonField<Tag> = JsonMissing.of(),
                ) : this(text, indices, tag, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun tag(): Optional<Tag> = tag.getOptional("tag")

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

                /**
                 * Returns the raw JSON value of [tag].
                 *
                 * Unlike [tag], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("tag") @ExcludeMissing fun _tag(): JsonField<Tag> = tag

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
                     * Returns a mutable builder for constructing an instance of [Hashtag].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Hashtag]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var indices: JsonField<MutableList<Long>>? = null
                    private var tag: JsonField<Tag> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hashtag: Hashtag) = apply {
                        text = hashtag.text
                        indices = hashtag.indices.map { it.toMutableList() }
                        tag = hashtag.tag
                        additionalProperties = hashtag.additionalProperties.toMutableMap()
                    }

                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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

                    /**
                     * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                     * platforms, which differ by reader.
                     */
                    fun tag(tag: Tag) = tag(JsonField.of(tag))

                    /** Sets [Builder.tag] to an arbitrary JSON value. */
                    fun tag(tag: JsonField<Tag>) = apply { this.tag = tag }

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
                     * Returns an immutable instance of [Hashtag].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Hashtag =
                        Hashtag(
                            checkRequired("text", text),
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            tag,
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
                fun validate(): Hashtag = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    indices()
                    tag().ifPresent { it.validate() }
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
                    (if (text.asKnown().isPresent) 1 else 0) +
                        (indices.asKnown().getOrNull()?.size ?: 0) +
                        (tag.asKnown().getOrNull()?.validity() ?: 0)

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 */
                class Tag
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val id: JsonField<String>,
                    private val info: JsonField<Info>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("info")
                        @ExcludeMissing
                        info: JsonField<Info> = JsonMissing.of(),
                    ) : this(id, info, mutableMapOf())

                    /**
                     * X's ID for the SmartTag.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun id(): Optional<String> = id.getOptional("id")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun info(): Optional<Info> = info.getOptional("info")

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                    /**
                     * Returns the raw JSON value of [info].
                     *
                     * Unlike [info], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("info") @ExcludeMissing fun _info(): JsonField<Info> = info

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

                        /** Returns a mutable builder for constructing an instance of [Tag]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Tag]. */
                    class Builder internal constructor() {

                        private var id: JsonField<String> = JsonMissing.of()
                        private var info: JsonField<Info> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(tag: Tag) = apply {
                            id = tag.id
                            info = tag.info
                            additionalProperties = tag.additionalProperties.toMutableMap()
                        }

                        /** X's ID for the SmartTag. */
                        fun id(id: String) = id(JsonField.of(id))

                        /** Sets [Builder.id] to an arbitrary JSON value. */
                        fun id(id: JsonField<String>) = apply { this.id = id }

                        fun info(info: Info) = info(JsonField.of(info))

                        /** Sets [Builder.info] to an arbitrary JSON value. */
                        fun info(info: JsonField<Info>) = apply { this.info = info }

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
                         * Returns an immutable instance of [Tag].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Tag = Tag(id, info, additionalProperties.toMutableMap())
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
                    fun validate(): Tag = apply {
                        if (validated) {
                            return@apply
                        }

                        id()
                        info().ifPresent { it.validate() }
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
                            (info.asKnown().getOrNull()?.validity() ?: 0)

                    class Info
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val info: JsonField<InfoInfo>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("info")
                            @ExcludeMissing
                            info: JsonField<InfoInfo> = JsonMissing.of()
                        ) : this(info, mutableMapOf())

                        /**
                         * @throws XTwitterScraperInvalidDataException if the JSON field has an
                         *   unexpected type.
                         */
                        fun info(): Optional<InfoInfo> = info.getOptional("info")

                        /**
                         * Returns the raw JSON value of [info].
                         *
                         * Unlike [info], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("info")
                        @ExcludeMissing
                        fun _info(): JsonField<InfoInfo> = info

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

                            /** Returns a mutable builder for constructing an instance of [Info]. */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Info]. */
                        class Builder internal constructor() {

                            private var info: JsonField<InfoInfo> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(info: Info) = apply {
                                this.info = info.info
                                additionalProperties = info.additionalProperties.toMutableMap()
                            }

                            fun info(info: InfoInfo) = info(JsonField.of(info))

                            /** Sets [Builder.info] to an arbitrary JSON value. */
                            fun info(info: JsonField<InfoInfo>) = apply { this.info = info }

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
                             * Returns an immutable instance of [Info].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Info = Info(info, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws XTwitterScraperInvalidDataException if any value type in this
                         *   object doesn't match its expected type.
                         */
                        fun validate(): Info = apply {
                            if (validated) {
                                return@apply
                            }

                            info().ifPresent { it.validate() }
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
                        internal fun validity(): Int = (info.asKnown().getOrNull()?.validity() ?: 0)

                        class InfoInfo
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val active: JsonField<Boolean>,
                            private val name: JsonField<String>,
                            private val ticker: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("active")
                                @ExcludeMissing
                                active: JsonField<Boolean> = JsonMissing.of(),
                                @JsonProperty("name")
                                @ExcludeMissing
                                name: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("ticker")
                                @ExcludeMissing
                                ticker: JsonField<String> = JsonMissing.of(),
                            ) : this(active, name, ticker, mutableMapOf())

                            /**
                             * Whether X marks the SmartTag active.
                             *
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun active(): Optional<Boolean> = active.getOptional("active")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun name(): Optional<String> = name.getOptional("name")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun ticker(): Optional<String> = ticker.getOptional("ticker")

                            /**
                             * Returns the raw JSON value of [active].
                             *
                             * Unlike [active], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("active")
                            @ExcludeMissing
                            fun _active(): JsonField<Boolean> = active

                            /**
                             * Returns the raw JSON value of [name].
                             *
                             * Unlike [name], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("name")
                            @ExcludeMissing
                            fun _name(): JsonField<String> = name

                            /**
                             * Returns the raw JSON value of [ticker].
                             *
                             * Unlike [ticker], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("ticker")
                            @ExcludeMissing
                            fun _ticker(): JsonField<String> = ticker

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
                                 * [InfoInfo].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [InfoInfo]. */
                            class Builder internal constructor() {

                                private var active: JsonField<Boolean> = JsonMissing.of()
                                private var name: JsonField<String> = JsonMissing.of()
                                private var ticker: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(infoInfo: InfoInfo) = apply {
                                    active = infoInfo.active
                                    name = infoInfo.name
                                    ticker = infoInfo.ticker
                                    additionalProperties =
                                        infoInfo.additionalProperties.toMutableMap()
                                }

                                /** Whether X marks the SmartTag active. */
                                fun active(active: Boolean) = active(JsonField.of(active))

                                /** Sets [Builder.active] to an arbitrary JSON value. */
                                fun active(active: JsonField<Boolean>) = apply {
                                    this.active = active
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                /** Sets [Builder.name] to an arbitrary JSON value. */
                                fun name(name: JsonField<String>) = apply { this.name = name }

                                fun ticker(ticker: String) = ticker(JsonField.of(ticker))

                                /** Sets [Builder.ticker] to an arbitrary JSON value. */
                                fun ticker(ticker: JsonField<String>) = apply {
                                    this.ticker = ticker
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [InfoInfo].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): InfoInfo =
                                    InfoInfo(
                                        active,
                                        name,
                                        ticker,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws XTwitterScraperInvalidDataException if any value type in this
                             *   object doesn't match its expected type.
                             */
                            fun validate(): InfoInfo = apply {
                                if (validated) {
                                    return@apply
                                }

                                active()
                                name()
                                ticker()
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
                                (if (active.asKnown().isPresent) 1 else 0) +
                                    (if (name.asKnown().isPresent) 1 else 0) +
                                    (if (ticker.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is InfoInfo &&
                                    active == other.active &&
                                    name == other.name &&
                                    ticker == other.ticker &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(active, name, ticker, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "InfoInfo{active=$active, name=$name, ticker=$ticker, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Info &&
                                info == other.info &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(info, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Info{info=$info, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Tag &&
                            id == other.id &&
                            info == other.info &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(id, info, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Tag{id=$id, info=$info, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Hashtag &&
                        text == other.text &&
                        indices == other.indices &&
                        tag == other.tag &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(text, indices, tag, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hashtag{text=$text, indices=$indices, tag=$tag, additionalProperties=$additionalProperties}"
            }

            /** Indexed smart-tag, cashtag, or video timestamp metadata. */
            class Smarttag
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val indices: JsonField<List<Long>>,
                private val seconds: JsonField<Double>,
                private val tag: JsonField<Tag>,
                private val text: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("seconds")
                    @ExcludeMissing
                    seconds: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("tag") @ExcludeMissing tag: JsonField<Tag> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                ) : this(indices, seconds, tag, text, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun seconds(): Optional<Double> = seconds.getOptional("seconds")

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun tag(): Optional<Tag> = tag.getOptional("tag")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

                /**
                 * Returns the raw JSON value of [seconds].
                 *
                 * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

                /**
                 * Returns the raw JSON value of [tag].
                 *
                 * Unlike [tag], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("tag") @ExcludeMissing fun _tag(): JsonField<Tag> = tag

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

                    /** Returns a mutable builder for constructing an instance of [Smarttag]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Smarttag]. */
                class Builder internal constructor() {

                    private var indices: JsonField<MutableList<Long>>? = null
                    private var seconds: JsonField<Double> = JsonMissing.of()
                    private var tag: JsonField<Tag> = JsonMissing.of()
                    private var text: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(smarttag: Smarttag) = apply {
                        indices = smarttag.indices.map { it.toMutableList() }
                        seconds = smarttag.seconds
                        tag = smarttag.tag
                        text = smarttag.text
                        additionalProperties = smarttag.additionalProperties.toMutableMap()
                    }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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

                    fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

                    /** Sets [Builder.seconds] to an arbitrary JSON value. */
                    fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

                    /**
                     * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                     * platforms, which differ by reader.
                     */
                    fun tag(tag: Tag) = tag(JsonField.of(tag))

                    /** Sets [Builder.tag] to an arbitrary JSON value. */
                    fun tag(tag: JsonField<Tag>) = apply { this.tag = tag }

                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

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
                     * Returns an immutable instance of [Smarttag].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Smarttag =
                        Smarttag(
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            seconds,
                            tag,
                            text,
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
                fun validate(): Smarttag = apply {
                    if (validated) {
                        return@apply
                    }

                    indices()
                    seconds()
                    tag().ifPresent { it.validate() }
                    text()
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
                    (indices.asKnown().getOrNull()?.size ?: 0) +
                        (if (seconds.asKnown().isPresent) 1 else 0) +
                        (tag.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (text.asKnown().isPresent) 1 else 0)

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 */
                class Tag
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val id: JsonField<String>,
                    private val info: JsonField<Info>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("info")
                        @ExcludeMissing
                        info: JsonField<Info> = JsonMissing.of(),
                    ) : this(id, info, mutableMapOf())

                    /**
                     * X's ID for the SmartTag.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun id(): Optional<String> = id.getOptional("id")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun info(): Optional<Info> = info.getOptional("info")

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                    /**
                     * Returns the raw JSON value of [info].
                     *
                     * Unlike [info], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("info") @ExcludeMissing fun _info(): JsonField<Info> = info

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

                        /** Returns a mutable builder for constructing an instance of [Tag]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Tag]. */
                    class Builder internal constructor() {

                        private var id: JsonField<String> = JsonMissing.of()
                        private var info: JsonField<Info> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(tag: Tag) = apply {
                            id = tag.id
                            info = tag.info
                            additionalProperties = tag.additionalProperties.toMutableMap()
                        }

                        /** X's ID for the SmartTag. */
                        fun id(id: String) = id(JsonField.of(id))

                        /** Sets [Builder.id] to an arbitrary JSON value. */
                        fun id(id: JsonField<String>) = apply { this.id = id }

                        fun info(info: Info) = info(JsonField.of(info))

                        /** Sets [Builder.info] to an arbitrary JSON value. */
                        fun info(info: JsonField<Info>) = apply { this.info = info }

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
                         * Returns an immutable instance of [Tag].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Tag = Tag(id, info, additionalProperties.toMutableMap())
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
                    fun validate(): Tag = apply {
                        if (validated) {
                            return@apply
                        }

                        id()
                        info().ifPresent { it.validate() }
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
                            (info.asKnown().getOrNull()?.validity() ?: 0)

                    class Info
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val info: JsonField<InfoInfo>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("info")
                            @ExcludeMissing
                            info: JsonField<InfoInfo> = JsonMissing.of()
                        ) : this(info, mutableMapOf())

                        /**
                         * @throws XTwitterScraperInvalidDataException if the JSON field has an
                         *   unexpected type.
                         */
                        fun info(): Optional<InfoInfo> = info.getOptional("info")

                        /**
                         * Returns the raw JSON value of [info].
                         *
                         * Unlike [info], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("info")
                        @ExcludeMissing
                        fun _info(): JsonField<InfoInfo> = info

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

                            /** Returns a mutable builder for constructing an instance of [Info]. */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Info]. */
                        class Builder internal constructor() {

                            private var info: JsonField<InfoInfo> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(info: Info) = apply {
                                this.info = info.info
                                additionalProperties = info.additionalProperties.toMutableMap()
                            }

                            fun info(info: InfoInfo) = info(JsonField.of(info))

                            /** Sets [Builder.info] to an arbitrary JSON value. */
                            fun info(info: JsonField<InfoInfo>) = apply { this.info = info }

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
                             * Returns an immutable instance of [Info].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Info = Info(info, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws XTwitterScraperInvalidDataException if any value type in this
                         *   object doesn't match its expected type.
                         */
                        fun validate(): Info = apply {
                            if (validated) {
                                return@apply
                            }

                            info().ifPresent { it.validate() }
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
                        internal fun validity(): Int = (info.asKnown().getOrNull()?.validity() ?: 0)

                        class InfoInfo
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val active: JsonField<Boolean>,
                            private val name: JsonField<String>,
                            private val ticker: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("active")
                                @ExcludeMissing
                                active: JsonField<Boolean> = JsonMissing.of(),
                                @JsonProperty("name")
                                @ExcludeMissing
                                name: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("ticker")
                                @ExcludeMissing
                                ticker: JsonField<String> = JsonMissing.of(),
                            ) : this(active, name, ticker, mutableMapOf())

                            /**
                             * Whether X marks the SmartTag active.
                             *
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun active(): Optional<Boolean> = active.getOptional("active")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun name(): Optional<String> = name.getOptional("name")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun ticker(): Optional<String> = ticker.getOptional("ticker")

                            /**
                             * Returns the raw JSON value of [active].
                             *
                             * Unlike [active], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("active")
                            @ExcludeMissing
                            fun _active(): JsonField<Boolean> = active

                            /**
                             * Returns the raw JSON value of [name].
                             *
                             * Unlike [name], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("name")
                            @ExcludeMissing
                            fun _name(): JsonField<String> = name

                            /**
                             * Returns the raw JSON value of [ticker].
                             *
                             * Unlike [ticker], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("ticker")
                            @ExcludeMissing
                            fun _ticker(): JsonField<String> = ticker

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
                                 * [InfoInfo].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [InfoInfo]. */
                            class Builder internal constructor() {

                                private var active: JsonField<Boolean> = JsonMissing.of()
                                private var name: JsonField<String> = JsonMissing.of()
                                private var ticker: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(infoInfo: InfoInfo) = apply {
                                    active = infoInfo.active
                                    name = infoInfo.name
                                    ticker = infoInfo.ticker
                                    additionalProperties =
                                        infoInfo.additionalProperties.toMutableMap()
                                }

                                /** Whether X marks the SmartTag active. */
                                fun active(active: Boolean) = active(JsonField.of(active))

                                /** Sets [Builder.active] to an arbitrary JSON value. */
                                fun active(active: JsonField<Boolean>) = apply {
                                    this.active = active
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                /** Sets [Builder.name] to an arbitrary JSON value. */
                                fun name(name: JsonField<String>) = apply { this.name = name }

                                fun ticker(ticker: String) = ticker(JsonField.of(ticker))

                                /** Sets [Builder.ticker] to an arbitrary JSON value. */
                                fun ticker(ticker: JsonField<String>) = apply {
                                    this.ticker = ticker
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [InfoInfo].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): InfoInfo =
                                    InfoInfo(
                                        active,
                                        name,
                                        ticker,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws XTwitterScraperInvalidDataException if any value type in this
                             *   object doesn't match its expected type.
                             */
                            fun validate(): InfoInfo = apply {
                                if (validated) {
                                    return@apply
                                }

                                active()
                                name()
                                ticker()
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
                                (if (active.asKnown().isPresent) 1 else 0) +
                                    (if (name.asKnown().isPresent) 1 else 0) +
                                    (if (ticker.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is InfoInfo &&
                                    active == other.active &&
                                    name == other.name &&
                                    ticker == other.ticker &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(active, name, ticker, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "InfoInfo{active=$active, name=$name, ticker=$ticker, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Info &&
                                info == other.info &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(info, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Info{info=$info, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Tag &&
                            id == other.id &&
                            info == other.info &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(id, info, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Tag{id=$id, info=$info, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Smarttag &&
                        indices == other.indices &&
                        seconds == other.seconds &&
                        tag == other.tag &&
                        text == other.text &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(indices, seconds, tag, text, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Smarttag{indices=$indices, seconds=$seconds, tag=$tag, text=$text, additionalProperties=$additionalProperties}"
            }

            /** Indexed smart-tag, cashtag, or video timestamp metadata. */
            class Symbol
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val indices: JsonField<List<Long>>,
                private val seconds: JsonField<Double>,
                private val tag: JsonField<Tag>,
                private val text: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("seconds")
                    @ExcludeMissing
                    seconds: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("tag") @ExcludeMissing tag: JsonField<Tag> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                ) : this(indices, seconds, tag, text, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun seconds(): Optional<Double> = seconds.getOptional("seconds")

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun tag(): Optional<Tag> = tag.getOptional("tag")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

                /**
                 * Returns the raw JSON value of [seconds].
                 *
                 * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

                /**
                 * Returns the raw JSON value of [tag].
                 *
                 * Unlike [tag], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("tag") @ExcludeMissing fun _tag(): JsonField<Tag> = tag

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

                    /** Returns a mutable builder for constructing an instance of [Symbol]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Symbol]. */
                class Builder internal constructor() {

                    private var indices: JsonField<MutableList<Long>>? = null
                    private var seconds: JsonField<Double> = JsonMissing.of()
                    private var tag: JsonField<Tag> = JsonMissing.of()
                    private var text: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(symbol: Symbol) = apply {
                        indices = symbol.indices.map { it.toMutableList() }
                        seconds = symbol.seconds
                        tag = symbol.tag
                        text = symbol.text
                        additionalProperties = symbol.additionalProperties.toMutableMap()
                    }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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

                    fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

                    /** Sets [Builder.seconds] to an arbitrary JSON value. */
                    fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

                    /**
                     * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                     * platforms, which differ by reader.
                     */
                    fun tag(tag: Tag) = tag(JsonField.of(tag))

                    /** Sets [Builder.tag] to an arbitrary JSON value. */
                    fun tag(tag: JsonField<Tag>) = apply { this.tag = tag }

                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

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
                     * Returns an immutable instance of [Symbol].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Symbol =
                        Symbol(
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            seconds,
                            tag,
                            text,
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
                fun validate(): Symbol = apply {
                    if (validated) {
                        return@apply
                    }

                    indices()
                    seconds()
                    tag().ifPresent { it.validate() }
                    text()
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
                    (indices.asKnown().getOrNull()?.size ?: 0) +
                        (if (seconds.asKnown().isPresent) 1 else 0) +
                        (tag.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (text.asKnown().isPresent) 1 else 0)

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 */
                class Tag
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val id: JsonField<String>,
                    private val info: JsonField<Info>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("info")
                        @ExcludeMissing
                        info: JsonField<Info> = JsonMissing.of(),
                    ) : this(id, info, mutableMapOf())

                    /**
                     * X's ID for the SmartTag.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun id(): Optional<String> = id.getOptional("id")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun info(): Optional<Info> = info.getOptional("info")

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                    /**
                     * Returns the raw JSON value of [info].
                     *
                     * Unlike [info], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("info") @ExcludeMissing fun _info(): JsonField<Info> = info

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

                        /** Returns a mutable builder for constructing an instance of [Tag]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Tag]. */
                    class Builder internal constructor() {

                        private var id: JsonField<String> = JsonMissing.of()
                        private var info: JsonField<Info> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(tag: Tag) = apply {
                            id = tag.id
                            info = tag.info
                            additionalProperties = tag.additionalProperties.toMutableMap()
                        }

                        /** X's ID for the SmartTag. */
                        fun id(id: String) = id(JsonField.of(id))

                        /** Sets [Builder.id] to an arbitrary JSON value. */
                        fun id(id: JsonField<String>) = apply { this.id = id }

                        fun info(info: Info) = info(JsonField.of(info))

                        /** Sets [Builder.info] to an arbitrary JSON value. */
                        fun info(info: JsonField<Info>) = apply { this.info = info }

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
                         * Returns an immutable instance of [Tag].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Tag = Tag(id, info, additionalProperties.toMutableMap())
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
                    fun validate(): Tag = apply {
                        if (validated) {
                            return@apply
                        }

                        id()
                        info().ifPresent { it.validate() }
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
                            (info.asKnown().getOrNull()?.validity() ?: 0)

                    class Info
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val info: JsonField<InfoInfo>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("info")
                            @ExcludeMissing
                            info: JsonField<InfoInfo> = JsonMissing.of()
                        ) : this(info, mutableMapOf())

                        /**
                         * @throws XTwitterScraperInvalidDataException if the JSON field has an
                         *   unexpected type.
                         */
                        fun info(): Optional<InfoInfo> = info.getOptional("info")

                        /**
                         * Returns the raw JSON value of [info].
                         *
                         * Unlike [info], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("info")
                        @ExcludeMissing
                        fun _info(): JsonField<InfoInfo> = info

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

                            /** Returns a mutable builder for constructing an instance of [Info]. */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Info]. */
                        class Builder internal constructor() {

                            private var info: JsonField<InfoInfo> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(info: Info) = apply {
                                this.info = info.info
                                additionalProperties = info.additionalProperties.toMutableMap()
                            }

                            fun info(info: InfoInfo) = info(JsonField.of(info))

                            /** Sets [Builder.info] to an arbitrary JSON value. */
                            fun info(info: JsonField<InfoInfo>) = apply { this.info = info }

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
                             * Returns an immutable instance of [Info].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Info = Info(info, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws XTwitterScraperInvalidDataException if any value type in this
                         *   object doesn't match its expected type.
                         */
                        fun validate(): Info = apply {
                            if (validated) {
                                return@apply
                            }

                            info().ifPresent { it.validate() }
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
                        internal fun validity(): Int = (info.asKnown().getOrNull()?.validity() ?: 0)

                        class InfoInfo
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val active: JsonField<Boolean>,
                            private val name: JsonField<String>,
                            private val ticker: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("active")
                                @ExcludeMissing
                                active: JsonField<Boolean> = JsonMissing.of(),
                                @JsonProperty("name")
                                @ExcludeMissing
                                name: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("ticker")
                                @ExcludeMissing
                                ticker: JsonField<String> = JsonMissing.of(),
                            ) : this(active, name, ticker, mutableMapOf())

                            /**
                             * Whether X marks the SmartTag active.
                             *
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun active(): Optional<Boolean> = active.getOptional("active")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun name(): Optional<String> = name.getOptional("name")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun ticker(): Optional<String> = ticker.getOptional("ticker")

                            /**
                             * Returns the raw JSON value of [active].
                             *
                             * Unlike [active], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("active")
                            @ExcludeMissing
                            fun _active(): JsonField<Boolean> = active

                            /**
                             * Returns the raw JSON value of [name].
                             *
                             * Unlike [name], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("name")
                            @ExcludeMissing
                            fun _name(): JsonField<String> = name

                            /**
                             * Returns the raw JSON value of [ticker].
                             *
                             * Unlike [ticker], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("ticker")
                            @ExcludeMissing
                            fun _ticker(): JsonField<String> = ticker

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
                                 * [InfoInfo].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [InfoInfo]. */
                            class Builder internal constructor() {

                                private var active: JsonField<Boolean> = JsonMissing.of()
                                private var name: JsonField<String> = JsonMissing.of()
                                private var ticker: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(infoInfo: InfoInfo) = apply {
                                    active = infoInfo.active
                                    name = infoInfo.name
                                    ticker = infoInfo.ticker
                                    additionalProperties =
                                        infoInfo.additionalProperties.toMutableMap()
                                }

                                /** Whether X marks the SmartTag active. */
                                fun active(active: Boolean) = active(JsonField.of(active))

                                /** Sets [Builder.active] to an arbitrary JSON value. */
                                fun active(active: JsonField<Boolean>) = apply {
                                    this.active = active
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                /** Sets [Builder.name] to an arbitrary JSON value. */
                                fun name(name: JsonField<String>) = apply { this.name = name }

                                fun ticker(ticker: String) = ticker(JsonField.of(ticker))

                                /** Sets [Builder.ticker] to an arbitrary JSON value. */
                                fun ticker(ticker: JsonField<String>) = apply {
                                    this.ticker = ticker
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [InfoInfo].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): InfoInfo =
                                    InfoInfo(
                                        active,
                                        name,
                                        ticker,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws XTwitterScraperInvalidDataException if any value type in this
                             *   object doesn't match its expected type.
                             */
                            fun validate(): InfoInfo = apply {
                                if (validated) {
                                    return@apply
                                }

                                active()
                                name()
                                ticker()
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
                                (if (active.asKnown().isPresent) 1 else 0) +
                                    (if (name.asKnown().isPresent) 1 else 0) +
                                    (if (ticker.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is InfoInfo &&
                                    active == other.active &&
                                    name == other.name &&
                                    ticker == other.ticker &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(active, name, ticker, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "InfoInfo{active=$active, name=$name, ticker=$ticker, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Info &&
                                info == other.info &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(info, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Info{info=$info, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Tag &&
                            id == other.id &&
                            info == other.info &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(id, info, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Tag{id=$id, info=$info, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Symbol &&
                        indices == other.indices &&
                        seconds == other.seconds &&
                        tag == other.tag &&
                        text == other.text &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(indices, seconds, tag, text, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Symbol{indices=$indices, seconds=$seconds, tag=$tag, text=$text, additionalProperties=$additionalProperties}"
            }

            /** Indexed smart-tag, cashtag, or video timestamp metadata. */
            class Timestamp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val indices: JsonField<List<Long>>,
                private val seconds: JsonField<Double>,
                private val tag: JsonField<Tag>,
                private val text: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("seconds")
                    @ExcludeMissing
                    seconds: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("tag") @ExcludeMissing tag: JsonField<Tag> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                ) : this(indices, seconds, tag, text, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun seconds(): Optional<Double> = seconds.getOptional("seconds")

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun tag(): Optional<Tag> = tag.getOptional("tag")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

                /**
                 * Returns the raw JSON value of [seconds].
                 *
                 * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

                /**
                 * Returns the raw JSON value of [tag].
                 *
                 * Unlike [tag], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("tag") @ExcludeMissing fun _tag(): JsonField<Tag> = tag

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

                    /** Returns a mutable builder for constructing an instance of [Timestamp]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Timestamp]. */
                class Builder internal constructor() {

                    private var indices: JsonField<MutableList<Long>>? = null
                    private var seconds: JsonField<Double> = JsonMissing.of()
                    private var tag: JsonField<Tag> = JsonMissing.of()
                    private var text: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(timestamp: Timestamp) = apply {
                        indices = timestamp.indices.map { it.toMutableList() }
                        seconds = timestamp.seconds
                        tag = timestamp.tag
                        text = timestamp.text
                        additionalProperties = timestamp.additionalProperties.toMutableMap()
                    }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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

                    fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

                    /** Sets [Builder.seconds] to an arbitrary JSON value. */
                    fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

                    /**
                     * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                     * platforms, which differ by reader.
                     */
                    fun tag(tag: Tag) = tag(JsonField.of(tag))

                    /** Sets [Builder.tag] to an arbitrary JSON value. */
                    fun tag(tag: JsonField<Tag>) = apply { this.tag = tag }

                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

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
                     * Returns an immutable instance of [Timestamp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Timestamp =
                        Timestamp(
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            seconds,
                            tag,
                            text,
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
                fun validate(): Timestamp = apply {
                    if (validated) {
                        return@apply
                    }

                    indices()
                    seconds()
                    tag().ifPresent { it.validate() }
                    text()
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
                    (indices.asKnown().getOrNull()?.size ?: 0) +
                        (if (seconds.asKnown().isPresent) 1 else 0) +
                        (tag.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (text.asKnown().isPresent) 1 else 0)

                /**
                 * X's SmartTag for a cashtag, smarttag or hashtag. Xquik leaves out X's trading
                 * platforms, which differ by reader.
                 */
                class Tag
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val id: JsonField<String>,
                    private val info: JsonField<Info>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("info")
                        @ExcludeMissing
                        info: JsonField<Info> = JsonMissing.of(),
                    ) : this(id, info, mutableMapOf())

                    /**
                     * X's ID for the SmartTag.
                     *
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun id(): Optional<String> = id.getOptional("id")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type.
                     */
                    fun info(): Optional<Info> = info.getOptional("info")

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                    /**
                     * Returns the raw JSON value of [info].
                     *
                     * Unlike [info], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("info") @ExcludeMissing fun _info(): JsonField<Info> = info

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

                        /** Returns a mutable builder for constructing an instance of [Tag]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Tag]. */
                    class Builder internal constructor() {

                        private var id: JsonField<String> = JsonMissing.of()
                        private var info: JsonField<Info> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(tag: Tag) = apply {
                            id = tag.id
                            info = tag.info
                            additionalProperties = tag.additionalProperties.toMutableMap()
                        }

                        /** X's ID for the SmartTag. */
                        fun id(id: String) = id(JsonField.of(id))

                        /** Sets [Builder.id] to an arbitrary JSON value. */
                        fun id(id: JsonField<String>) = apply { this.id = id }

                        fun info(info: Info) = info(JsonField.of(info))

                        /** Sets [Builder.info] to an arbitrary JSON value. */
                        fun info(info: JsonField<Info>) = apply { this.info = info }

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
                         * Returns an immutable instance of [Tag].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Tag = Tag(id, info, additionalProperties.toMutableMap())
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
                    fun validate(): Tag = apply {
                        if (validated) {
                            return@apply
                        }

                        id()
                        info().ifPresent { it.validate() }
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
                            (info.asKnown().getOrNull()?.validity() ?: 0)

                    class Info
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val info: JsonField<InfoInfo>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("info")
                            @ExcludeMissing
                            info: JsonField<InfoInfo> = JsonMissing.of()
                        ) : this(info, mutableMapOf())

                        /**
                         * @throws XTwitterScraperInvalidDataException if the JSON field has an
                         *   unexpected type.
                         */
                        fun info(): Optional<InfoInfo> = info.getOptional("info")

                        /**
                         * Returns the raw JSON value of [info].
                         *
                         * Unlike [info], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("info")
                        @ExcludeMissing
                        fun _info(): JsonField<InfoInfo> = info

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

                            /** Returns a mutable builder for constructing an instance of [Info]. */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Info]. */
                        class Builder internal constructor() {

                            private var info: JsonField<InfoInfo> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(info: Info) = apply {
                                this.info = info.info
                                additionalProperties = info.additionalProperties.toMutableMap()
                            }

                            fun info(info: InfoInfo) = info(JsonField.of(info))

                            /** Sets [Builder.info] to an arbitrary JSON value. */
                            fun info(info: JsonField<InfoInfo>) = apply { this.info = info }

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
                             * Returns an immutable instance of [Info].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Info = Info(info, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws XTwitterScraperInvalidDataException if any value type in this
                         *   object doesn't match its expected type.
                         */
                        fun validate(): Info = apply {
                            if (validated) {
                                return@apply
                            }

                            info().ifPresent { it.validate() }
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
                        internal fun validity(): Int = (info.asKnown().getOrNull()?.validity() ?: 0)

                        class InfoInfo
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val active: JsonField<Boolean>,
                            private val name: JsonField<String>,
                            private val ticker: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("active")
                                @ExcludeMissing
                                active: JsonField<Boolean> = JsonMissing.of(),
                                @JsonProperty("name")
                                @ExcludeMissing
                                name: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("ticker")
                                @ExcludeMissing
                                ticker: JsonField<String> = JsonMissing.of(),
                            ) : this(active, name, ticker, mutableMapOf())

                            /**
                             * Whether X marks the SmartTag active.
                             *
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun active(): Optional<Boolean> = active.getOptional("active")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun name(): Optional<String> = name.getOptional("name")

                            /**
                             * @throws XTwitterScraperInvalidDataException if the JSON field has an
                             *   unexpected type.
                             */
                            fun ticker(): Optional<String> = ticker.getOptional("ticker")

                            /**
                             * Returns the raw JSON value of [active].
                             *
                             * Unlike [active], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("active")
                            @ExcludeMissing
                            fun _active(): JsonField<Boolean> = active

                            /**
                             * Returns the raw JSON value of [name].
                             *
                             * Unlike [name], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("name")
                            @ExcludeMissing
                            fun _name(): JsonField<String> = name

                            /**
                             * Returns the raw JSON value of [ticker].
                             *
                             * Unlike [ticker], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("ticker")
                            @ExcludeMissing
                            fun _ticker(): JsonField<String> = ticker

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
                                 * [InfoInfo].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [InfoInfo]. */
                            class Builder internal constructor() {

                                private var active: JsonField<Boolean> = JsonMissing.of()
                                private var name: JsonField<String> = JsonMissing.of()
                                private var ticker: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(infoInfo: InfoInfo) = apply {
                                    active = infoInfo.active
                                    name = infoInfo.name
                                    ticker = infoInfo.ticker
                                    additionalProperties =
                                        infoInfo.additionalProperties.toMutableMap()
                                }

                                /** Whether X marks the SmartTag active. */
                                fun active(active: Boolean) = active(JsonField.of(active))

                                /** Sets [Builder.active] to an arbitrary JSON value. */
                                fun active(active: JsonField<Boolean>) = apply {
                                    this.active = active
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                /** Sets [Builder.name] to an arbitrary JSON value. */
                                fun name(name: JsonField<String>) = apply { this.name = name }

                                fun ticker(ticker: String) = ticker(JsonField.of(ticker))

                                /** Sets [Builder.ticker] to an arbitrary JSON value. */
                                fun ticker(ticker: JsonField<String>) = apply {
                                    this.ticker = ticker
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [InfoInfo].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): InfoInfo =
                                    InfoInfo(
                                        active,
                                        name,
                                        ticker,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws XTwitterScraperInvalidDataException if any value type in this
                             *   object doesn't match its expected type.
                             */
                            fun validate(): InfoInfo = apply {
                                if (validated) {
                                    return@apply
                                }

                                active()
                                name()
                                ticker()
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
                                (if (active.asKnown().isPresent) 1 else 0) +
                                    (if (name.asKnown().isPresent) 1 else 0) +
                                    (if (ticker.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is InfoInfo &&
                                    active == other.active &&
                                    name == other.name &&
                                    ticker == other.ticker &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(active, name, ticker, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "InfoInfo{active=$active, name=$name, ticker=$ticker, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Info &&
                                info == other.info &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(info, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Info{info=$info, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Tag &&
                            id == other.id &&
                            info == other.info &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(id, info, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Tag{id=$id, info=$info, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Timestamp &&
                        indices == other.indices &&
                        seconds == other.seconds &&
                        tag == other.tag &&
                        text == other.text &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(indices, seconds, tag, text, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Timestamp{indices=$indices, seconds=$seconds, tag=$tag, text=$text, additionalProperties=$additionalProperties}"
            }

            /** Shortened, display, and expanded URLs from tweet text. */
            class Url
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val displayUrl: JsonField<String>,
                private val expandedUrl: JsonField<String>,
                private val indices: JsonField<List<Long>>,
                private val url: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("display_url")
                    @ExcludeMissing
                    displayUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("expanded_url")
                    @ExcludeMissing
                    expandedUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                ) : this(displayUrl, expandedUrl, indices, url, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun displayUrl(): Optional<String> = displayUrl.getOptional("display_url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun expandedUrl(): Optional<String> = expandedUrl.getOptional("expanded_url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

                /**
                 * Returns the raw JSON value of [displayUrl].
                 *
                 * Unlike [displayUrl], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("display_url")
                @ExcludeMissing
                fun _displayUrl(): JsonField<String> = displayUrl

                /**
                 * Returns the raw JSON value of [expandedUrl].
                 *
                 * Unlike [expandedUrl], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("expanded_url")
                @ExcludeMissing
                fun _expandedUrl(): JsonField<String> = expandedUrl

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

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

                    /** Returns a mutable builder for constructing an instance of [Url]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Url]. */
                class Builder internal constructor() {

                    private var displayUrl: JsonField<String> = JsonMissing.of()
                    private var expandedUrl: JsonField<String> = JsonMissing.of()
                    private var indices: JsonField<MutableList<Long>>? = null
                    private var url: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(url: Url) = apply {
                        displayUrl = url.displayUrl
                        expandedUrl = url.expandedUrl
                        indices = url.indices.map { it.toMutableList() }
                        this.url = url.url
                        additionalProperties = url.additionalProperties.toMutableMap()
                    }

                    fun displayUrl(displayUrl: String) = displayUrl(JsonField.of(displayUrl))

                    /** Sets [Builder.displayUrl] to an arbitrary JSON value. */
                    fun displayUrl(displayUrl: JsonField<String>) = apply {
                        this.displayUrl = displayUrl
                    }

                    fun expandedUrl(expandedUrl: String) = expandedUrl(JsonField.of(expandedUrl))

                    /** Sets [Builder.expandedUrl] to an arbitrary JSON value. */
                    fun expandedUrl(expandedUrl: JsonField<String>) = apply {
                        this.expandedUrl = expandedUrl
                    }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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
                     * Returns an immutable instance of [Url].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Url =
                        Url(
                            displayUrl,
                            expandedUrl,
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            url,
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
                fun validate(): Url = apply {
                    if (validated) {
                        return@apply
                    }

                    displayUrl()
                    expandedUrl()
                    indices()
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
                    (if (displayUrl.asKnown().isPresent) 1 else 0) +
                        (if (expandedUrl.asKnown().isPresent) 1 else 0) +
                        (indices.asKnown().getOrNull()?.size ?: 0) +
                        (if (url.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Url &&
                        displayUrl == other.displayUrl &&
                        expandedUrl == other.expandedUrl &&
                        indices == other.indices &&
                        url == other.url &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(displayUrl, expandedUrl, indices, url, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Url{displayUrl=$displayUrl, expandedUrl=$expandedUrl, indices=$indices, url=$url, additionalProperties=$additionalProperties}"
            }

            /** Profile identity and source offsets of a mention. */
            class UserMention
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val screenName: JsonField<String>,
                private val idStr: JsonField<String>,
                private val indices: JsonField<List<Long>>,
                private val name: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("screen_name")
                    @ExcludeMissing
                    screenName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("id_str")
                    @ExcludeMissing
                    idStr: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("indices")
                    @ExcludeMissing
                    indices: JsonField<List<Long>> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                ) : this(screenName, idStr, indices, name, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun screenName(): String = screenName.getRequired("screen_name")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun idStr(): Optional<String> = idStr.getOptional("id_str")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun indices(): Optional<List<Long>> = indices.getOptional("indices")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Returns the raw JSON value of [screenName].
                 *
                 * Unlike [screenName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("screen_name")
                @ExcludeMissing
                fun _screenName(): JsonField<String> = screenName

                /**
                 * Returns the raw JSON value of [idStr].
                 *
                 * Unlike [idStr], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("id_str") @ExcludeMissing fun _idStr(): JsonField<String> = idStr

                /**
                 * Returns the raw JSON value of [indices].
                 *
                 * Unlike [indices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("indices")
                @ExcludeMissing
                fun _indices(): JsonField<List<Long>> = indices

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /**
                     * Returns a mutable builder for constructing an instance of [UserMention].
                     *
                     * The following fields are required:
                     * ```java
                     * .screenName()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [UserMention]. */
                class Builder internal constructor() {

                    private var screenName: JsonField<String>? = null
                    private var idStr: JsonField<String> = JsonMissing.of()
                    private var indices: JsonField<MutableList<Long>>? = null
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(userMention: UserMention) = apply {
                        screenName = userMention.screenName
                        idStr = userMention.idStr
                        indices = userMention.indices.map { it.toMutableList() }
                        name = userMention.name
                        additionalProperties = userMention.additionalProperties.toMutableMap()
                    }

                    fun screenName(screenName: String) = screenName(JsonField.of(screenName))

                    /** Sets [Builder.screenName] to an arbitrary JSON value. */
                    fun screenName(screenName: JsonField<String>) = apply {
                        this.screenName = screenName
                    }

                    fun idStr(idStr: String) = idStr(JsonField.of(idStr))

                    /** Sets [Builder.idStr] to an arbitrary JSON value. */
                    fun idStr(idStr: JsonField<String>) = apply { this.idStr = idStr }

                    fun indices(indices: List<Long>) = indices(JsonField.of(indices))

                    /** Sets [Builder.indices] to an arbitrary JSON value. */
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
                     * Returns an immutable instance of [UserMention].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .screenName()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): UserMention =
                        UserMention(
                            checkRequired("screenName", screenName),
                            idStr,
                            (indices ?: JsonMissing.of()).map { it.toImmutable() },
                            name,
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
                fun validate(): UserMention = apply {
                    if (validated) {
                        return@apply
                    }

                    screenName()
                    idStr()
                    indices()
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
                    (if (screenName.asKnown().isPresent) 1 else 0) +
                        (if (idStr.asKnown().isPresent) 1 else 0) +
                        (indices.asKnown().getOrNull()?.size ?: 0) +
                        (if (name.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UserMention &&
                        screenName == other.screenName &&
                        idStr == other.idStr &&
                        indices == other.indices &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(screenName, idStr, indices, name, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "UserMention{screenName=$screenName, idStr=$idStr, indices=$indices, name=$name, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Entities &&
                    hashtags == other.hashtags &&
                    smarttags == other.smarttags &&
                    symbols == other.symbols &&
                    timestamps == other.timestamps &&
                    urls == other.urls &&
                    userMentions == other.userMentions &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    hashtags,
                    smarttags,
                    symbols,
                    timestamps,
                    urls,
                    userMentions,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Entities{hashtags=$hashtags, smarttags=$smarttags, symbols=$symbols, timestamps=$timestamps, urls=$urls, userMentions=$userMentions, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Translation &&
                entities == other.entities &&
                language == other.language &&
                text == other.text &&
                tweetId == other.tweetId &&
                sourceLanguage == other.sourceLanguage &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(entities, language, text, tweetId, sourceLanguage, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Translation{entities=$entities, language=$language, text=$text, tweetId=$tweetId, sourceLanguage=$sourceLanguage, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetTranslateResponse &&
            translation == other.translation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(translation, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetTranslateResponse{translation=$translation, additionalProperties=$additionalProperties}"
}
