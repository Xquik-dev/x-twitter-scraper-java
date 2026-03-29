// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class IntegrationRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val config: JsonField<Config>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val eventTypes: JsonField<List<EventType>>,
    private val isActive: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val type: JsonField<Type>,
    private val filters: JsonField<Filters>,
    private val messageTemplate: JsonField<String>,
    private val scopeAllMonitors: JsonField<Boolean>,
    private val silentPush: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("config") @ExcludeMissing config: JsonField<Config> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("eventTypes")
        @ExcludeMissing
        eventTypes: JsonField<List<EventType>> = JsonMissing.of(),
        @JsonProperty("isActive") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filters> = JsonMissing.of(),
        @JsonProperty("messageTemplate")
        @ExcludeMissing
        messageTemplate: JsonField<String> = JsonMissing.of(),
        @JsonProperty("scopeAllMonitors")
        @ExcludeMissing
        scopeAllMonitors: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("silentPush")
        @ExcludeMissing
        silentPush: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        id,
        config,
        createdAt,
        eventTypes,
        isActive,
        name,
        type,
        filters,
        messageTemplate,
        scopeAllMonitors,
        silentPush,
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
    fun config(): Config = config.getRequired("config")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isActive(): Boolean = isActive.getRequired("isActive")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun filters(): Optional<Filters> = filters.getOptional("filters")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun messageTemplate(): Optional<String> = messageTemplate.getOptional("messageTemplate")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun scopeAllMonitors(): Optional<Boolean> = scopeAllMonitors.getOptional("scopeAllMonitors")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun silentPush(): Optional<Boolean> = silentPush.getOptional("silentPush")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [config].
     *
     * Unlike [config], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("config") @ExcludeMissing fun _config(): JsonField<Config> = config

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eventTypes")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<EventType>> = eventTypes

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [filters].
     *
     * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filters> = filters

    /**
     * Returns the raw JSON value of [messageTemplate].
     *
     * Unlike [messageTemplate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageTemplate")
    @ExcludeMissing
    fun _messageTemplate(): JsonField<String> = messageTemplate

    /**
     * Returns the raw JSON value of [scopeAllMonitors].
     *
     * Unlike [scopeAllMonitors], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("scopeAllMonitors")
    @ExcludeMissing
    fun _scopeAllMonitors(): JsonField<Boolean> = scopeAllMonitors

    /**
     * Returns the raw JSON value of [silentPush].
     *
     * Unlike [silentPush], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("silentPush") @ExcludeMissing fun _silentPush(): JsonField<Boolean> = silentPush

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
         * Returns a mutable builder for constructing an instance of [IntegrationRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .config()
         * .createdAt()
         * .eventTypes()
         * .isActive()
         * .name()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [IntegrationRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var config: JsonField<Config>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var eventTypes: JsonField<MutableList<EventType>>? = null
        private var isActive: JsonField<Boolean>? = null
        private var name: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var filters: JsonField<Filters> = JsonMissing.of()
        private var messageTemplate: JsonField<String> = JsonMissing.of()
        private var scopeAllMonitors: JsonField<Boolean> = JsonMissing.of()
        private var silentPush: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(integrationRetrieveResponse: IntegrationRetrieveResponse) = apply {
            id = integrationRetrieveResponse.id
            config = integrationRetrieveResponse.config
            createdAt = integrationRetrieveResponse.createdAt
            eventTypes = integrationRetrieveResponse.eventTypes.map { it.toMutableList() }
            isActive = integrationRetrieveResponse.isActive
            name = integrationRetrieveResponse.name
            type = integrationRetrieveResponse.type
            filters = integrationRetrieveResponse.filters
            messageTemplate = integrationRetrieveResponse.messageTemplate
            scopeAllMonitors = integrationRetrieveResponse.scopeAllMonitors
            silentPush = integrationRetrieveResponse.silentPush
            additionalProperties = integrationRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun config(config: Config) = config(JsonField.of(config))

        /**
         * Sets [Builder.config] to an arbitrary JSON value.
         *
         * You should usually call [Builder.config] with a well-typed [Config] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun config(config: JsonField<Config>) = apply { this.config = config }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun eventTypes(eventTypes: List<EventType>) = eventTypes(JsonField.of(eventTypes))

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<EventType>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<EventType>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

        /**
         * Adds a single [EventType] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: EventType) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
        }

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /**
         * Sets [Builder.isActive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isActive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun filters(filters: Filters) = filters(JsonField.of(filters))

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed [Filters] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filters(filters: JsonField<Filters>) = apply { this.filters = filters }

        fun messageTemplate(messageTemplate: String) =
            messageTemplate(JsonField.of(messageTemplate))

        /**
         * Sets [Builder.messageTemplate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageTemplate] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun messageTemplate(messageTemplate: JsonField<String>) = apply {
            this.messageTemplate = messageTemplate
        }

        fun scopeAllMonitors(scopeAllMonitors: Boolean) =
            scopeAllMonitors(JsonField.of(scopeAllMonitors))

        /**
         * Sets [Builder.scopeAllMonitors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scopeAllMonitors] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scopeAllMonitors(scopeAllMonitors: JsonField<Boolean>) = apply {
            this.scopeAllMonitors = scopeAllMonitors
        }

        fun silentPush(silentPush: Boolean) = silentPush(JsonField.of(silentPush))

        /**
         * Sets [Builder.silentPush] to an arbitrary JSON value.
         *
         * You should usually call [Builder.silentPush] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun silentPush(silentPush: JsonField<Boolean>) = apply { this.silentPush = silentPush }

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
         * Returns an immutable instance of [IntegrationRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .config()
         * .createdAt()
         * .eventTypes()
         * .isActive()
         * .name()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): IntegrationRetrieveResponse =
            IntegrationRetrieveResponse(
                checkRequired("id", id),
                checkRequired("config", config),
                checkRequired("createdAt", createdAt),
                checkRequired("eventTypes", eventTypes).map { it.toImmutable() },
                checkRequired("isActive", isActive),
                checkRequired("name", name),
                checkRequired("type", type),
                filters,
                messageTemplate,
                scopeAllMonitors,
                silentPush,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): IntegrationRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        config().validate()
        createdAt()
        eventTypes().forEach { it.validate() }
        isActive()
        name()
        type().validate()
        filters().ifPresent { it.validate() }
        messageTemplate()
        scopeAllMonitors()
        silentPush()
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
            (config.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (eventTypes.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (filters.asKnown().getOrNull()?.validity() ?: 0) +
            (if (messageTemplate.asKnown().isPresent) 1 else 0) +
            (if (scopeAllMonitors.asKnown().isPresent) 1 else 0) +
            (if (silentPush.asKnown().isPresent) 1 else 0)

    class Config
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

            /** Returns a mutable builder for constructing an instance of [Config]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Config]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(config: Config) = apply {
                additionalProperties = config.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Config].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Config = Config(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Config = apply {
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

            return other is Config && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Config{additionalProperties=$additionalProperties}"
    }

    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val TWEET_NEW = of("tweet.new")

            @JvmField val TWEET_REPLY = of("tweet.reply")

            @JvmField val TWEET_RETWEET = of("tweet.retweet")

            @JvmField val TWEET_QUOTE = of("tweet.quote")

            @JvmField val FOLLOWER_GAINED = of("follower.gained")

            @JvmField val FOLLOWER_LOST = of("follower.lost")

            @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
        }

        /** An enum containing [EventType]'s known values. */
        enum class Known {
            TWEET_NEW,
            TWEET_REPLY,
            TWEET_RETWEET,
            TWEET_QUOTE,
            FOLLOWER_GAINED,
            FOLLOWER_LOST,
        }

        /**
         * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EventType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TWEET_NEW,
            TWEET_REPLY,
            TWEET_RETWEET,
            TWEET_QUOTE,
            FOLLOWER_GAINED,
            FOLLOWER_LOST,
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
             */
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
                TWEET_NEW -> Value.TWEET_NEW
                TWEET_REPLY -> Value.TWEET_REPLY
                TWEET_RETWEET -> Value.TWEET_RETWEET
                TWEET_QUOTE -> Value.TWEET_QUOTE
                FOLLOWER_GAINED -> Value.FOLLOWER_GAINED
                FOLLOWER_LOST -> Value.FOLLOWER_LOST
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
                TWEET_NEW -> Known.TWEET_NEW
                TWEET_REPLY -> Known.TWEET_REPLY
                TWEET_RETWEET -> Known.TWEET_RETWEET
                TWEET_QUOTE -> Known.TWEET_QUOTE
                FOLLOWER_GAINED -> Known.FOLLOWER_GAINED
                FOLLOWER_LOST -> Known.FOLLOWER_LOST
                else -> throw XTwitterScraperInvalidDataException("Unknown EventType: $value")
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

        fun validate(): EventType = apply {
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

            return other is EventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

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

            @JvmField val TELEGRAM = of("telegram")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            TELEGRAM
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
            TELEGRAM,
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
                TELEGRAM -> Value.TELEGRAM
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
                TELEGRAM -> Known.TELEGRAM
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

    class Filters
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

            /** Returns a mutable builder for constructing an instance of [Filters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Filters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(filters: Filters) = apply {
                additionalProperties = filters.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Filters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Filters = Filters(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Filters = apply {
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

            return other is Filters && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Filters{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is IntegrationRetrieveResponse &&
            id == other.id &&
            config == other.config &&
            createdAt == other.createdAt &&
            eventTypes == other.eventTypes &&
            isActive == other.isActive &&
            name == other.name &&
            type == other.type &&
            filters == other.filters &&
            messageTemplate == other.messageTemplate &&
            scopeAllMonitors == other.scopeAllMonitors &&
            silentPush == other.silentPush &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            config,
            createdAt,
            eventTypes,
            isActive,
            name,
            type,
            filters,
            messageTemplate,
            scopeAllMonitors,
            silentPush,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "IntegrationRetrieveResponse{id=$id, config=$config, createdAt=$createdAt, eventTypes=$eventTypes, isActive=$isActive, name=$name, type=$type, filters=$filters, messageTemplate=$messageTemplate, scopeAllMonitors=$scopeAllMonitors, silentPush=$silentPush, additionalProperties=$additionalProperties}"
}
