// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

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

/**
 * Says whether X limits 1 account in search, search suggestions, reply threads or its timeline.
 * Each check holds a verdict, its reason & the evidence it read. Evidence is null for a check that
 * couldn't read the account.
 */
class ShadowbanReport
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val username: JsonField<String>,
    private val userId: JsonField<String>,
    private val account: JsonField<Account>,
    private val checkedAt: JsonField<OffsetDateTime>,
    private val overall: JsonField<Overall>,
    private val checks: JsonField<Checks>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account") @ExcludeMissing account: JsonField<Account> = JsonMissing.of(),
        @JsonProperty("checkedAt")
        @ExcludeMissing
        checkedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("overall") @ExcludeMissing overall: JsonField<Overall> = JsonMissing.of(),
        @JsonProperty("checks") @ExcludeMissing checks: JsonField<Checks> = JsonMissing.of(),
    ) : this(username, userId, account, checkedAt, overall, checks, mutableMapOf())

    /** Username of the account. Null for a suspended account asked for by ID. */
    fun username(): Optional<String> = username.getOptional("username")

    /** ID of the account. Null for a suspended account asked for by username. */
    fun userId(): Optional<String> = userId.getOptional("userId")

    /** Whether the account is active, protected or suspended. */
    fun account(): Account = account.getRequired("account")

    /** When the check ran. */
    fun checkedAt(): OffsetDateTime = checkedAt.getRequired("checkedAt")

    /**
     * `suspended` means X suspended the account. `limited` means at least 1 check failed. `clear`
     * means search & suggestions passed with no fail. `unclear` means neither of those.
     */
    fun overall(): Overall = overall.getRequired("overall")

    /** The 9 checks, each with a verdict, a reason & evidence. */
    fun checks(): Checks = checks.getRequired("checks")

    /** Returns the raw JSON value of [username]. */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /** Returns the raw JSON value of [userId]. */
    @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

    /** Returns the raw JSON value of [account]. */
    @JsonProperty("account") @ExcludeMissing fun _account(): JsonField<Account> = account

    /** Returns the raw JSON value of [checkedAt]. */
    @JsonProperty("checkedAt")
    @ExcludeMissing
    fun _checkedAt(): JsonField<OffsetDateTime> = checkedAt

    /** Returns the raw JSON value of [overall]. */
    @JsonProperty("overall") @ExcludeMissing fun _overall(): JsonField<Overall> = overall

    /** Returns the raw JSON value of [checks]. */
    @JsonProperty("checks") @ExcludeMissing fun _checks(): JsonField<Checks> = checks

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

        /** Returns a mutable builder for constructing an instance of [ShadowbanReport]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ShadowbanReport]. */
    class Builder internal constructor() {

        private var username: JsonField<String>? = null
        private var userId: JsonField<String>? = null
        private var account: JsonField<Account>? = null
        private var checkedAt: JsonField<OffsetDateTime>? = null
        private var overall: JsonField<Overall>? = null
        private var checks: JsonField<Checks>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(shadowbanReport: ShadowbanReport) = apply {
            username = shadowbanReport.username
            userId = shadowbanReport.userId
            account = shadowbanReport.account
            checkedAt = shadowbanReport.checkedAt
            overall = shadowbanReport.overall
            checks = shadowbanReport.checks
            additionalProperties = shadowbanReport.additionalProperties.toMutableMap()
        }

        /** Username of the account. Null for a suspended account asked for by ID. */
        fun username(username: String?) = username(JsonField.ofNullable(username))

        /** Alias for calling [Builder.username] with `username.orElse(null)`. */
        fun username(username: Optional<String>) = username(username.getOrNull())

        /** Sets [Builder.username] to an arbitrary JSON value. */
        fun username(username: JsonField<String>) = apply { this.username = username }

        /** ID of the account. Null for a suspended account asked for by username. */
        fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        /** Sets [Builder.userId] to an arbitrary JSON value. */
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

        /** Whether the account is active, protected or suspended. */
        fun account(account: Account) = account(JsonField.of(account))

        /** Sets [Builder.account] to an arbitrary JSON value. */
        fun account(account: JsonField<Account>) = apply { this.account = account }

        /** When the check ran. */
        fun checkedAt(checkedAt: OffsetDateTime) = checkedAt(JsonField.of(checkedAt))

        /** Sets [Builder.checkedAt] to an arbitrary JSON value. */
        fun checkedAt(checkedAt: JsonField<OffsetDateTime>) = apply { this.checkedAt = checkedAt }

        /**
         * `suspended` means X suspended the account. `limited` means at least 1 check failed.
         * `clear` means search & suggestions passed with no fail. `unclear` means neither of those.
         */
        fun overall(overall: Overall) = overall(JsonField.of(overall))

        /** Sets [Builder.overall] to an arbitrary JSON value. */
        fun overall(overall: JsonField<Overall>) = apply { this.overall = overall }

        /** The 9 checks, each with a verdict, a reason & evidence. */
        fun checks(checks: Checks) = checks(JsonField.of(checks))

        /** Sets [Builder.checks] to an arbitrary JSON value. */
        fun checks(checks: JsonField<Checks>) = apply { this.checks = checks }

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
         * Returns an immutable instance of [ShadowbanReport].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ShadowbanReport =
            ShadowbanReport(
                checkRequired("username", username),
                checkRequired("userId", userId),
                checkRequired("account", account),
                checkRequired("checkedAt", checkedAt),
                checkRequired("overall", overall),
                checkRequired("checks", checks),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): ShadowbanReport = apply {
        if (validated) {
            return@apply
        }

        username()
        userId()
        account().validate()
        checkedAt()
        overall().validate()
        checks().validate()
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
        (if (username.asKnown().isPresent) 1 else 0) +
            (if (userId.asKnown().isPresent) 1 else 0) +
            (account.asKnown().getOrNull()?.validity() ?: 0) +
            (if (checkedAt.asKnown().isPresent) 1 else 0) +
            (overall.asKnown().getOrNull()?.validity() ?: 0) +
            (checks.asKnown().getOrNull()?.validity() ?: 0)

    /** Whether the account is active, protected or suspended. */
    class Account @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACTIVE = of("active")

            @JvmField val PROTECTED = of("protected")

            @JvmField val SUSPENDED = of("suspended")

            @JvmStatic fun of(value: String) = Account(JsonField.of(value))
        }

        /** An enum containing [Account]'s known values. */
        enum class Known {
            ACTIVE,
            PROTECTED,
            SUSPENDED,
        }

        /** An enum containing [Account]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            ACTIVE,
            PROTECTED,
            SUSPENDED,
            /** An enum member indicating that [Account] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                PROTECTED -> Value.PROTECTED
                SUSPENDED -> Value.SUSPENDED
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
                ACTIVE -> Known.ACTIVE
                PROTECTED -> Known.PROTECTED
                SUSPENDED -> Known.SUSPENDED
                else -> throw XTwitterScraperInvalidDataException("Unknown Account: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Account = apply {
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

            return other is Account && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * `suspended` means X suspended the account. `limited` means at least 1 check failed. `clear`
     * means search & suggestions passed with no fail. `unclear` means neither of those.
     */
    class Overall @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CLEAR = of("clear")

            @JvmField val LIMITED = of("limited")

            @JvmField val UNCLEAR = of("unclear")

            @JvmField val SUSPENDED = of("suspended")

            @JvmStatic fun of(value: String) = Overall(JsonField.of(value))
        }

        /** An enum containing [Overall]'s known values. */
        enum class Known {
            CLEAR,
            LIMITED,
            UNCLEAR,
            SUSPENDED,
        }

        /** An enum containing [Overall]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            CLEAR,
            LIMITED,
            UNCLEAR,
            SUSPENDED,
            /** An enum member indicating that [Overall] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                CLEAR -> Value.CLEAR
                LIMITED -> Value.LIMITED
                UNCLEAR -> Value.UNCLEAR
                SUSPENDED -> Value.SUSPENDED
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
                CLEAR -> Known.CLEAR
                LIMITED -> Known.LIMITED
                UNCLEAR -> Known.UNCLEAR
                SUSPENDED -> Known.SUSPENDED
                else -> throw XTwitterScraperInvalidDataException("Unknown Overall: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Overall = apply {
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

            return other is Overall && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The 9 checks, each with a verdict, a reason & evidence. */
    class Checks
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val account: JsonField<Account>,
        private val search: JsonField<Search>,
        private val suggestion: JsonField<Suggestion>,
        private val replies: JsonField<Replies>,
        private val replyLock: JsonField<ReplyLock>,
        private val timeline: JsonField<Timeline>,
        private val engagement: JsonField<Engagement>,
        private val sensitive: JsonField<Sensitive>,
        private val withheld: JsonField<Withheld>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("account") @ExcludeMissing account: JsonField<Account> = JsonMissing.of(),
            @JsonProperty("search") @ExcludeMissing search: JsonField<Search> = JsonMissing.of(),
            @JsonProperty("suggestion")
            @ExcludeMissing
            suggestion: JsonField<Suggestion> = JsonMissing.of(),
            @JsonProperty("replies") @ExcludeMissing replies: JsonField<Replies> = JsonMissing.of(),
            @JsonProperty("replyLock")
            @ExcludeMissing
            replyLock: JsonField<ReplyLock> = JsonMissing.of(),
            @JsonProperty("timeline")
            @ExcludeMissing
            timeline: JsonField<Timeline> = JsonMissing.of(),
            @JsonProperty("engagement")
            @ExcludeMissing
            engagement: JsonField<Engagement> = JsonMissing.of(),
            @JsonProperty("sensitive")
            @ExcludeMissing
            sensitive: JsonField<Sensitive> = JsonMissing.of(),
            @JsonProperty("withheld")
            @ExcludeMissing
            withheld: JsonField<Withheld> = JsonMissing.of(),
        ) : this(
            account,
            search,
            suggestion,
            replies,
            replyLock,
            timeline,
            engagement,
            sensitive,
            withheld,
            mutableMapOf(),
        )

        /** Passes an active or protected account & fails a suspended one. */
        fun account(): Account = account.getRequired("account")

        /**
         * Looks for the account's recent posts in X search, sorted by Latest. `listed` passes &
         * `missing` fails.
         */
        fun search(): Search = search.getRequired("search")

        /**
         * Looks for the account among the accounts X suggests for its username. `suggested` passes
         * & `not_suggested` fails.
         */
        fun suggestion(): Suggestion = suggestion.getRequired("suggestion")

        /**
         * Opens the threads of up to 3 recent replies to other accounts. `in_thread` passes. X
         * ranks replies for each viewer, so `more_replies` can't tell.
         */
        fun replies(): Replies = replies.getRequired("replies")

        /**
         * Reads the same reply threads as `replies`. `replies_show` passes when any checked reply
         * shows. X ranks replies for each viewer, so `replies_missing` can't tell.
         */
        fun replyLock(): ReplyLock = replyLock.getRequired("replyLock")

        /**
         * Looks for the account's posts on its profile timeline. `visible` passes & `hidden` fails.
         */
        fun timeline(): Timeline = timeline.getRequired("timeline")

        /**
         * Compares the newest 5 of the account's own posts older than 24 hours with its earlier
         * posts, by the median of likes, replies, reposts & quotes. `typical` passes at 25% or
         * more. A drop alone proves nothing, so `low` can't tell.
         */
        fun engagement(): Engagement = engagement.getRequired("engagement")

        /** Reads X's sensitive flag on the profile. `not_flagged` passes & `flagged` fails. */
        fun sensitive(): Sensitive = sensitive.getRequired("sensitive")

        /** Reads the countries where X withholds the account. `none` passes & `countries` fails. */
        fun withheld(): Withheld = withheld.getRequired("withheld")

        /** Returns the raw JSON value of [account]. */
        @JsonProperty("account") @ExcludeMissing fun _account(): JsonField<Account> = account

        /** Returns the raw JSON value of [search]. */
        @JsonProperty("search") @ExcludeMissing fun _search(): JsonField<Search> = search

        /** Returns the raw JSON value of [suggestion]. */
        @JsonProperty("suggestion")
        @ExcludeMissing
        fun _suggestion(): JsonField<Suggestion> = suggestion

        /** Returns the raw JSON value of [replies]. */
        @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Replies> = replies

        /** Returns the raw JSON value of [replyLock]. */
        @JsonProperty("replyLock")
        @ExcludeMissing
        fun _replyLock(): JsonField<ReplyLock> = replyLock

        /** Returns the raw JSON value of [timeline]. */
        @JsonProperty("timeline") @ExcludeMissing fun _timeline(): JsonField<Timeline> = timeline

        /** Returns the raw JSON value of [engagement]. */
        @JsonProperty("engagement")
        @ExcludeMissing
        fun _engagement(): JsonField<Engagement> = engagement

        /** Returns the raw JSON value of [sensitive]. */
        @JsonProperty("sensitive")
        @ExcludeMissing
        fun _sensitive(): JsonField<Sensitive> = sensitive

        /** Returns the raw JSON value of [withheld]. */
        @JsonProperty("withheld") @ExcludeMissing fun _withheld(): JsonField<Withheld> = withheld

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

            /** Returns a mutable builder for constructing an instance of [Checks]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Checks]. */
        class Builder internal constructor() {

            private var account: JsonField<Account>? = null
            private var search: JsonField<Search>? = null
            private var suggestion: JsonField<Suggestion>? = null
            private var replies: JsonField<Replies>? = null
            private var replyLock: JsonField<ReplyLock>? = null
            private var timeline: JsonField<Timeline>? = null
            private var engagement: JsonField<Engagement>? = null
            private var sensitive: JsonField<Sensitive>? = null
            private var withheld: JsonField<Withheld>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(checks: Checks) = apply {
                account = checks.account
                search = checks.search
                suggestion = checks.suggestion
                replies = checks.replies
                replyLock = checks.replyLock
                timeline = checks.timeline
                engagement = checks.engagement
                sensitive = checks.sensitive
                withheld = checks.withheld
                additionalProperties = checks.additionalProperties.toMutableMap()
            }

            /** Passes an active or protected account & fails a suspended one. */
            fun account(account: Account) = account(JsonField.of(account))

            /** Sets [Builder.account] to an arbitrary JSON value. */
            fun account(account: JsonField<Account>) = apply { this.account = account }

            /**
             * Looks for the account's recent posts in X search, sorted by Latest. `listed` passes &
             * `missing` fails.
             */
            fun search(search: Search) = search(JsonField.of(search))

            /** Sets [Builder.search] to an arbitrary JSON value. */
            fun search(search: JsonField<Search>) = apply { this.search = search }

            /**
             * Looks for the account among the accounts X suggests for its username. `suggested`
             * passes & `not_suggested` fails.
             */
            fun suggestion(suggestion: Suggestion) = suggestion(JsonField.of(suggestion))

            /** Sets [Builder.suggestion] to an arbitrary JSON value. */
            fun suggestion(suggestion: JsonField<Suggestion>) = apply {
                this.suggestion = suggestion
            }

            /**
             * Opens the threads of up to 3 recent replies to other accounts. `in_thread` passes. X
             * ranks replies for each viewer, so `more_replies` can't tell.
             */
            fun replies(replies: Replies) = replies(JsonField.of(replies))

            /** Sets [Builder.replies] to an arbitrary JSON value. */
            fun replies(replies: JsonField<Replies>) = apply { this.replies = replies }

            /**
             * Reads the same reply threads as `replies`. `replies_show` passes when any checked
             * reply shows. X ranks replies for each viewer, so `replies_missing` can't tell.
             */
            fun replyLock(replyLock: ReplyLock) = replyLock(JsonField.of(replyLock))

            /** Sets [Builder.replyLock] to an arbitrary JSON value. */
            fun replyLock(replyLock: JsonField<ReplyLock>) = apply { this.replyLock = replyLock }

            /**
             * Looks for the account's posts on its profile timeline. `visible` passes & `hidden`
             * fails.
             */
            fun timeline(timeline: Timeline) = timeline(JsonField.of(timeline))

            /** Sets [Builder.timeline] to an arbitrary JSON value. */
            fun timeline(timeline: JsonField<Timeline>) = apply { this.timeline = timeline }

            /**
             * Compares the newest 5 of the account's own posts older than 24 hours with its earlier
             * posts, by the median of likes, replies, reposts & quotes. `typical` passes at 25% or
             * more. A drop alone proves nothing, so `low` can't tell.
             */
            fun engagement(engagement: Engagement) = engagement(JsonField.of(engagement))

            /** Sets [Builder.engagement] to an arbitrary JSON value. */
            fun engagement(engagement: JsonField<Engagement>) = apply {
                this.engagement = engagement
            }

            /** Reads X's sensitive flag on the profile. `not_flagged` passes & `flagged` fails. */
            fun sensitive(sensitive: Sensitive) = sensitive(JsonField.of(sensitive))

            /** Sets [Builder.sensitive] to an arbitrary JSON value. */
            fun sensitive(sensitive: JsonField<Sensitive>) = apply { this.sensitive = sensitive }

            /**
             * Reads the countries where X withholds the account. `none` passes & `countries` fails.
             */
            fun withheld(withheld: Withheld) = withheld(JsonField.of(withheld))

            /** Sets [Builder.withheld] to an arbitrary JSON value. */
            fun withheld(withheld: JsonField<Withheld>) = apply { this.withheld = withheld }

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
             * Returns an immutable instance of [Checks].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Checks =
                Checks(
                    checkRequired("account", account),
                    checkRequired("search", search),
                    checkRequired("suggestion", suggestion),
                    checkRequired("replies", replies),
                    checkRequired("replyLock", replyLock),
                    checkRequired("timeline", timeline),
                    checkRequired("engagement", engagement),
                    checkRequired("sensitive", sensitive),
                    checkRequired("withheld", withheld),
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
        fun validate(): Checks = apply {
            if (validated) {
                return@apply
            }

            account().validate()
            search().validate()
            suggestion().validate()
            replies().validate()
            replyLock().validate()
            timeline().validate()
            engagement().validate()
            sensitive().validate()
            withheld().validate()
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
            (account.asKnown().getOrNull()?.validity() ?: 0) +
                (search.asKnown().getOrNull()?.validity() ?: 0) +
                (suggestion.asKnown().getOrNull()?.validity() ?: 0) +
                (replies.asKnown().getOrNull()?.validity() ?: 0) +
                (replyLock.asKnown().getOrNull()?.validity() ?: 0) +
                (timeline.asKnown().getOrNull()?.validity() ?: 0) +
                (engagement.asKnown().getOrNull()?.validity() ?: 0) +
                (sensitive.asKnown().getOrNull()?.validity() ?: 0) +
                (withheld.asKnown().getOrNull()?.validity() ?: 0)

        /** Passes an active or protected account & fails a suspended one. */
        class Account
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /** State of the account on X. */
            fun reason(): Reason = reason.getRequired("reason")

            /** Where to see the account on X. */
            fun evidence(): Evidence = evidence.getRequired("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Account]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Account]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(account: Account) = apply {
                    verdict = account.verdict
                    reason = account.reason
                    evidence = account.evidence
                    additionalProperties = account.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /** State of the account on X. */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** Where to see the account on X. */
                fun evidence(evidence: Evidence) = evidence(JsonField.of(evidence))

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Account].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Account =
                    Account(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Account = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().validate()
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /** State of the account on X. */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ACTIVE = of("active")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    ACTIVE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    ACTIVE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        ACTIVE -> Value.ACTIVE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        ACTIVE -> Known.ACTIVE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** Where to see the account on X. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val profileUrl: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("profileUrl")
                    @ExcludeMissing
                    profileUrl: JsonField<String> = JsonMissing.of()
                ) : this(profileUrl, mutableMapOf())

                /** Profile of the account on X. */
                fun profileUrl(): String = profileUrl.getRequired("profileUrl")

                /** Returns the raw JSON value of [profileUrl]. */
                @JsonProperty("profileUrl")
                @ExcludeMissing
                fun _profileUrl(): JsonField<String> = profileUrl

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var profileUrl: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        profileUrl = evidence.profileUrl
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Profile of the account on X. */
                    fun profileUrl(profileUrl: String) = profileUrl(JsonField.of(profileUrl))

                    /** Sets [Builder.profileUrl] to an arbitrary JSON value. */
                    fun profileUrl(profileUrl: JsonField<String>) = apply {
                        this.profileUrl = profileUrl
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("profileUrl", profileUrl),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    profileUrl()
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
                internal fun validity(): Int = (if (profileUrl.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        profileUrl == other.profileUrl &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(profileUrl, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{profileUrl=$profileUrl, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Account &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Account{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Looks for the account's recent posts in X search, sorted by Latest. `listed` passes &
         * `missing` fails.
         */
        class Search
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /**
             * `listed` means search shows its posts & `missing` means it shows none.
             * `no_recent_posts` means the account has no recent post to look for.
             */
            fun reason(): Reason = reason.getRequired("reason")

            /** The search & the posts it looked for. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Search]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Search]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(search: Search) = apply {
                    verdict = search.verdict
                    reason = search.reason
                    evidence = search.evidence
                    additionalProperties = search.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /**
                 * `listed` means search shows its posts & `missing` means it shows none.
                 * `no_recent_posts` means the account has no recent post to look for.
                 */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** The search & the posts it looked for. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Search].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Search =
                    Search(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Search = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * `listed` means search shows its posts & `missing` means it shows none.
             * `no_recent_posts` means the account has no recent post to look for.
             */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val LISTED = of("listed")

                    @JvmField val MISSING = of("missing")

                    @JvmField val NO_RECENT_POSTS = of("no_recent_posts")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    LISTED,
                    MISSING,
                    NO_RECENT_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    LISTED,
                    MISSING,
                    NO_RECENT_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        LISTED -> Value.LISTED
                        MISSING -> Value.MISSING
                        NO_RECENT_POSTS -> Value.NO_RECENT_POSTS
                        UNAVAILABLE -> Value.UNAVAILABLE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        LISTED -> Known.LISTED
                        MISSING -> Known.MISSING
                        NO_RECENT_POSTS -> Known.NO_RECENT_POSTS
                        UNAVAILABLE -> Known.UNAVAILABLE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The search & the posts it looked for. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val query: JsonField<String>,
                private val searchUrl: JsonField<String>,
                private val recentPostIds: JsonField<List<String>>,
                private val foundPostIds: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("query")
                    @ExcludeMissing
                    query: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("searchUrl")
                    @ExcludeMissing
                    searchUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("recentPostIds")
                    @ExcludeMissing
                    recentPostIds: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("foundPostIds")
                    @ExcludeMissing
                    foundPostIds: JsonField<List<String>> = JsonMissing.of(),
                ) : this(query, searchUrl, recentPostIds, foundPostIds, mutableMapOf())

                /** The search it ran. */
                fun query(): String = query.getRequired("query")

                /** The same search on X, sorted by Latest. */
                fun searchUrl(): String = searchUrl.getRequired("searchUrl")

                /** Up to 5 recent posts of the account. */
                fun recentPostIds(): List<String> = recentPostIds.getRequired("recentPostIds")

                /** Up to 5 posts of the account that search showed. */
                fun foundPostIds(): List<String> = foundPostIds.getRequired("foundPostIds")

                /** Returns the raw JSON value of [query]. */
                @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

                /** Returns the raw JSON value of [searchUrl]. */
                @JsonProperty("searchUrl")
                @ExcludeMissing
                fun _searchUrl(): JsonField<String> = searchUrl

                /** Returns the raw JSON value of [recentPostIds]. */
                @JsonProperty("recentPostIds")
                @ExcludeMissing
                fun _recentPostIds(): JsonField<List<String>> = recentPostIds

                /** Returns the raw JSON value of [foundPostIds]. */
                @JsonProperty("foundPostIds")
                @ExcludeMissing
                fun _foundPostIds(): JsonField<List<String>> = foundPostIds

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var query: JsonField<String>? = null
                    private var searchUrl: JsonField<String>? = null
                    private var recentPostIds: JsonField<MutableList<String>>? = null
                    private var foundPostIds: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        query = evidence.query
                        searchUrl = evidence.searchUrl
                        recentPostIds = evidence.recentPostIds.map { it.toMutableList() }
                        foundPostIds = evidence.foundPostIds.map { it.toMutableList() }
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** The search it ran. */
                    fun query(query: String) = query(JsonField.of(query))

                    /** Sets [Builder.query] to an arbitrary JSON value. */
                    fun query(query: JsonField<String>) = apply { this.query = query }

                    /** The same search on X, sorted by Latest. */
                    fun searchUrl(searchUrl: String) = searchUrl(JsonField.of(searchUrl))

                    /** Sets [Builder.searchUrl] to an arbitrary JSON value. */
                    fun searchUrl(searchUrl: JsonField<String>) = apply {
                        this.searchUrl = searchUrl
                    }

                    /** Up to 5 recent posts of the account. */
                    fun recentPostIds(recentPostIds: List<String>) =
                        recentPostIds(JsonField.of(recentPostIds))

                    /** Sets [Builder.recentPostIds] to an arbitrary JSON value. */
                    fun recentPostIds(recentPostIds: JsonField<List<String>>) = apply {
                        this.recentPostIds = recentPostIds.map { it.toMutableList() }
                    }

                    /** Adds a single [String] to [recentPostIds]. */
                    fun addRecentPostId(recentPostId: String) = apply {
                        recentPostIds =
                            (recentPostIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("recentPostIds", it).add(recentPostId)
                            }
                    }

                    /** Up to 5 posts of the account that search showed. */
                    fun foundPostIds(foundPostIds: List<String>) =
                        foundPostIds(JsonField.of(foundPostIds))

                    /** Sets [Builder.foundPostIds] to an arbitrary JSON value. */
                    fun foundPostIds(foundPostIds: JsonField<List<String>>) = apply {
                        this.foundPostIds = foundPostIds.map { it.toMutableList() }
                    }

                    /** Adds a single [String] to [foundPostIds]. */
                    fun addFoundPostId(foundPostId: String) = apply {
                        foundPostIds =
                            (foundPostIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("foundPostIds", it).add(foundPostId)
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("query", query),
                            checkRequired("searchUrl", searchUrl),
                            checkRequired("recentPostIds", recentPostIds).map { it.toImmutable() },
                            checkRequired("foundPostIds", foundPostIds).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    query()
                    searchUrl()
                    recentPostIds()
                    foundPostIds()
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
                    (if (query.asKnown().isPresent) 1 else 0) +
                        (if (searchUrl.asKnown().isPresent) 1 else 0) +
                        (recentPostIds.asKnown().getOrNull()?.size ?: 0) +
                        (foundPostIds.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        query == other.query &&
                        searchUrl == other.searchUrl &&
                        recentPostIds == other.recentPostIds &&
                        foundPostIds == other.foundPostIds &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        query,
                        searchUrl,
                        recentPostIds,
                        foundPostIds,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{query=$query, searchUrl=$searchUrl, recentPostIds=$recentPostIds, foundPostIds=$foundPostIds, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Search &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Search{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Looks for the account among the accounts X suggests for its username. `suggested` passes
         * & `not_suggested` fails.
         */
        class Suggestion
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /** `suggested` means X suggests the account for its username. */
            fun reason(): Reason = reason.getRequired("reason")

            /** The username searched & the accounts X suggested. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Suggestion]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Suggestion]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(suggestion: Suggestion) = apply {
                    verdict = suggestion.verdict
                    reason = suggestion.reason
                    evidence = suggestion.evidence
                    additionalProperties = suggestion.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /** `suggested` means X suggests the account for its username. */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** The username searched & the accounts X suggested. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Suggestion].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Suggestion =
                    Suggestion(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Suggestion = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /** `suggested` means X suggests the account for its username. */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val SUGGESTED = of("suggested")

                    @JvmField val NOT_SUGGESTED = of("not_suggested")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    SUGGESTED,
                    NOT_SUGGESTED,
                    UNAVAILABLE,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    SUGGESTED,
                    NOT_SUGGESTED,
                    UNAVAILABLE,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        SUGGESTED -> Value.SUGGESTED
                        NOT_SUGGESTED -> Value.NOT_SUGGESTED
                        UNAVAILABLE -> Value.UNAVAILABLE
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        SUGGESTED -> Known.SUGGESTED
                        NOT_SUGGESTED -> Known.NOT_SUGGESTED
                        UNAVAILABLE -> Known.UNAVAILABLE
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The username searched & the accounts X suggested. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val query: JsonField<String>,
                private val suggestedUsernames: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("query")
                    @ExcludeMissing
                    query: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("suggestedUsernames")
                    @ExcludeMissing
                    suggestedUsernames: JsonField<List<String>> = JsonMissing.of(),
                ) : this(query, suggestedUsernames, mutableMapOf())

                /** The username it typed. */
                fun query(): String = query.getRequired("query")

                /** Up to 10 accounts X suggested, in its order. */
                fun suggestedUsernames(): List<String> =
                    suggestedUsernames.getRequired("suggestedUsernames")

                /** Returns the raw JSON value of [query]. */
                @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

                /** Returns the raw JSON value of [suggestedUsernames]. */
                @JsonProperty("suggestedUsernames")
                @ExcludeMissing
                fun _suggestedUsernames(): JsonField<List<String>> = suggestedUsernames

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var query: JsonField<String>? = null
                    private var suggestedUsernames: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        query = evidence.query
                        suggestedUsernames = evidence.suggestedUsernames.map { it.toMutableList() }
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** The username it typed. */
                    fun query(query: String) = query(JsonField.of(query))

                    /** Sets [Builder.query] to an arbitrary JSON value. */
                    fun query(query: JsonField<String>) = apply { this.query = query }

                    /** Up to 10 accounts X suggested, in its order. */
                    fun suggestedUsernames(suggestedUsernames: List<String>) =
                        suggestedUsernames(JsonField.of(suggestedUsernames))

                    /** Sets [Builder.suggestedUsernames] to an arbitrary JSON value. */
                    fun suggestedUsernames(suggestedUsernames: JsonField<List<String>>) = apply {
                        this.suggestedUsernames = suggestedUsernames.map { it.toMutableList() }
                    }

                    /** Adds a single [String] to [suggestedUsernames]. */
                    fun addSuggestedUsername(suggestedUsername: String) = apply {
                        suggestedUsernames =
                            (suggestedUsernames ?: JsonField.of(mutableListOf())).also {
                                checkKnown("suggestedUsernames", it).add(suggestedUsername)
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("query", query),
                            checkRequired("suggestedUsernames", suggestedUsernames).map {
                                it.toImmutable()
                            },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    query()
                    suggestedUsernames()
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
                    (if (query.asKnown().isPresent) 1 else 0) +
                        (suggestedUsernames.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        query == other.query &&
                        suggestedUsernames == other.suggestedUsernames &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(query, suggestedUsernames, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{query=$query, suggestedUsernames=$suggestedUsernames, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Suggestion &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Suggestion{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Opens the threads of up to 3 recent replies to other accounts. `in_thread` passes. X
         * ranks replies for each viewer, so `more_replies` can't tell.
         */
        class Replies
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /**
             * `more_replies` means X put a reply behind its hidden replies prompt. `not_found`
             * means no reply showed on the pages the check read.
             */
            fun reason(): Reason = reason.getRequired("reason")

            /** Each reply it opened & where it showed. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Replies]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Replies]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(replies: Replies) = apply {
                    verdict = replies.verdict
                    reason = replies.reason
                    evidence = replies.evidence
                    additionalProperties = replies.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /**
                 * `more_replies` means X put a reply behind its hidden replies prompt. `not_found`
                 * means no reply showed on the pages the check read.
                 */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** Each reply it opened & where it showed. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Replies].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Replies =
                    Replies(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Replies = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * `more_replies` means X put a reply behind its hidden replies prompt. `not_found`
             * means no reply showed on the pages the check read.
             */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_THREAD = of("in_thread")

                    @JvmField val MORE_REPLIES = of("more_replies")

                    @JvmField val NO_RECENT_REPLIES = of("no_recent_replies")

                    @JvmField val NOT_FOUND = of("not_found")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    IN_THREAD,
                    MORE_REPLIES,
                    NO_RECENT_REPLIES,
                    NOT_FOUND,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    IN_THREAD,
                    MORE_REPLIES,
                    NO_RECENT_REPLIES,
                    NOT_FOUND,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        IN_THREAD -> Value.IN_THREAD
                        MORE_REPLIES -> Value.MORE_REPLIES
                        NO_RECENT_REPLIES -> Value.NO_RECENT_REPLIES
                        NOT_FOUND -> Value.NOT_FOUND
                        UNAVAILABLE -> Value.UNAVAILABLE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        IN_THREAD -> Known.IN_THREAD
                        MORE_REPLIES -> Known.MORE_REPLIES
                        NO_RECENT_REPLIES -> Known.NO_RECENT_REPLIES
                        NOT_FOUND -> Known.NOT_FOUND
                        UNAVAILABLE -> Known.UNAVAILABLE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** Each reply it opened & where it showed. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val replies: JsonField<List<Reply>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("replies")
                    @ExcludeMissing
                    replies: JsonField<List<Reply>> = JsonMissing.of()
                ) : this(replies, mutableMapOf())

                /** Up to 3 replies, newest first. */
                fun replies(): List<Reply> = replies.getRequired("replies")

                /** Returns the raw JSON value of [replies]. */
                @JsonProperty("replies")
                @ExcludeMissing
                fun _replies(): JsonField<List<Reply>> = replies

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var replies: JsonField<MutableList<Reply>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        replies = evidence.replies.map { it.toMutableList() }
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Up to 3 replies, newest first. */
                    fun replies(replies: List<Reply>) = replies(JsonField.of(replies))

                    /** Sets [Builder.replies] to an arbitrary JSON value. */
                    fun replies(replies: JsonField<List<Reply>>) = apply {
                        this.replies = replies.map { it.toMutableList() }
                    }

                    /** Adds a single [Reply] to [replies]. */
                    fun addReply(reply: Reply) = apply {
                        replies =
                            (replies ?: JsonField.of(mutableListOf())).also {
                                checkKnown("replies", it).add(reply)
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("replies", replies).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    replies().forEach { it.validate() }
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
                    (replies.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

                class Reply
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val replyId: JsonField<String>,
                    private val replyUrl: JsonField<String>,
                    private val parentId: JsonField<String>,
                    private val parentUrl: JsonField<String>,
                    private val placement: JsonField<Placement>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("replyId")
                        @ExcludeMissing
                        replyId: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("replyUrl")
                        @ExcludeMissing
                        replyUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("parentId")
                        @ExcludeMissing
                        parentId: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("parentUrl")
                        @ExcludeMissing
                        parentUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("placement")
                        @ExcludeMissing
                        placement: JsonField<Placement> = JsonMissing.of(),
                    ) : this(replyId, replyUrl, parentId, parentUrl, placement, mutableMapOf())

                    /** ID of the reply. */
                    fun replyId(): String = replyId.getRequired("replyId")

                    /** The reply on X. */
                    fun replyUrl(): String = replyUrl.getRequired("replyUrl")

                    /** ID of the post it replies to. */
                    fun parentId(): String = parentId.getRequired("parentId")

                    /** The thread of that post on X. */
                    fun parentUrl(): String = parentUrl.getRequired("parentUrl")

                    /**
                     * `thread` means the reply shows in the thread. `more_replies` means it shows
                     * only behind X's hidden replies prompt.
                     */
                    fun placement(): Placement = placement.getRequired("placement")

                    /** Returns the raw JSON value of [replyId]. */
                    @JsonProperty("replyId")
                    @ExcludeMissing
                    fun _replyId(): JsonField<String> = replyId

                    /** Returns the raw JSON value of [replyUrl]. */
                    @JsonProperty("replyUrl")
                    @ExcludeMissing
                    fun _replyUrl(): JsonField<String> = replyUrl

                    /** Returns the raw JSON value of [parentId]. */
                    @JsonProperty("parentId")
                    @ExcludeMissing
                    fun _parentId(): JsonField<String> = parentId

                    /** Returns the raw JSON value of [parentUrl]. */
                    @JsonProperty("parentUrl")
                    @ExcludeMissing
                    fun _parentUrl(): JsonField<String> = parentUrl

                    /** Returns the raw JSON value of [placement]. */
                    @JsonProperty("placement")
                    @ExcludeMissing
                    fun _placement(): JsonField<Placement> = placement

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

                        /** Returns a mutable builder for constructing an instance of [Reply]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Reply]. */
                    class Builder internal constructor() {

                        private var replyId: JsonField<String>? = null
                        private var replyUrl: JsonField<String>? = null
                        private var parentId: JsonField<String>? = null
                        private var parentUrl: JsonField<String>? = null
                        private var placement: JsonField<Placement>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(reply: Reply) = apply {
                            replyId = reply.replyId
                            replyUrl = reply.replyUrl
                            parentId = reply.parentId
                            parentUrl = reply.parentUrl
                            placement = reply.placement
                            additionalProperties = reply.additionalProperties.toMutableMap()
                        }

                        /** ID of the reply. */
                        fun replyId(replyId: String) = replyId(JsonField.of(replyId))

                        /** Sets [Builder.replyId] to an arbitrary JSON value. */
                        fun replyId(replyId: JsonField<String>) = apply { this.replyId = replyId }

                        /** The reply on X. */
                        fun replyUrl(replyUrl: String) = replyUrl(JsonField.of(replyUrl))

                        /** Sets [Builder.replyUrl] to an arbitrary JSON value. */
                        fun replyUrl(replyUrl: JsonField<String>) = apply {
                            this.replyUrl = replyUrl
                        }

                        /** ID of the post it replies to. */
                        fun parentId(parentId: String) = parentId(JsonField.of(parentId))

                        /** Sets [Builder.parentId] to an arbitrary JSON value. */
                        fun parentId(parentId: JsonField<String>) = apply {
                            this.parentId = parentId
                        }

                        /** The thread of that post on X. */
                        fun parentUrl(parentUrl: String) = parentUrl(JsonField.of(parentUrl))

                        /** Sets [Builder.parentUrl] to an arbitrary JSON value. */
                        fun parentUrl(parentUrl: JsonField<String>) = apply {
                            this.parentUrl = parentUrl
                        }

                        /**
                         * `thread` means the reply shows in the thread. `more_replies` means it
                         * shows only behind X's hidden replies prompt.
                         */
                        fun placement(placement: Placement) = placement(JsonField.of(placement))

                        /** Sets [Builder.placement] to an arbitrary JSON value. */
                        fun placement(placement: JsonField<Placement>) = apply {
                            this.placement = placement
                        }

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
                         * Returns an immutable instance of [Reply].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Reply =
                            Reply(
                                checkRequired("replyId", replyId),
                                checkRequired("replyUrl", replyUrl),
                                checkRequired("parentId", parentId),
                                checkRequired("parentUrl", parentUrl),
                                checkRequired("placement", placement),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): Reply = apply {
                        if (validated) {
                            return@apply
                        }

                        replyId()
                        replyUrl()
                        parentId()
                        parentUrl()
                        placement().validate()
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
                        (if (replyId.asKnown().isPresent) 1 else 0) +
                            (if (replyUrl.asKnown().isPresent) 1 else 0) +
                            (if (parentId.asKnown().isPresent) 1 else 0) +
                            (if (parentUrl.asKnown().isPresent) 1 else 0) +
                            (placement.asKnown().getOrNull()?.validity() ?: 0)

                    /**
                     * `thread` means the reply shows in the thread. `more_replies` means it shows
                     * only behind X's hidden replies prompt.
                     */
                    class Placement
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /** Returns this class instance's raw value. */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val THREAD = of("thread")

                            @JvmField val MORE_REPLIES = of("more_replies")

                            @JvmField val NOT_FOUND = of("not_found")

                            @JvmStatic fun of(value: String) = Placement(JsonField.of(value))
                        }

                        /** An enum containing [Placement]'s known values. */
                        enum class Known {
                            THREAD,
                            MORE_REPLIES,
                            NOT_FOUND,
                        }

                        /**
                         * An enum containing [Placement]'s known values, as well as an [_UNKNOWN]
                         * member.
                         */
                        enum class Value {
                            THREAD,
                            MORE_REPLIES,
                            NOT_FOUND,
                            /**
                             * An enum member indicating that [Placement] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if unknown.
                         */
                        fun value(): Value =
                            when (this) {
                                THREAD -> Value.THREAD
                                MORE_REPLIES -> Value.MORE_REPLIES
                                NOT_FOUND -> Value.NOT_FOUND
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * @throws XTwitterScraperInvalidDataException if this class instance's
                         *   value is a not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                THREAD -> Known.THREAD
                                MORE_REPLIES -> Known.MORE_REPLIES
                                NOT_FOUND -> Known.NOT_FOUND
                                else ->
                                    throw XTwitterScraperInvalidDataException(
                                        "Unknown Placement: $value"
                                    )
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * @throws XTwitterScraperInvalidDataException if this class instance's
                         *   value does not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                XTwitterScraperInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        /** Validates that this value is a known member. */
                        fun validate(): Placement = apply {
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

                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Placement && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Reply &&
                            replyId == other.replyId &&
                            replyUrl == other.replyUrl &&
                            parentId == other.parentId &&
                            parentUrl == other.parentUrl &&
                            placement == other.placement &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            replyId,
                            replyUrl,
                            parentId,
                            parentUrl,
                            placement,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Reply{replyId=$replyId, replyUrl=$replyUrl, parentId=$parentId, parentUrl=$parentUrl, placement=$placement, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        replies == other.replies &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(replies, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{replies=$replies, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Replies &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Replies{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Reads the same reply threads as `replies`. `replies_show` passes when any checked reply
         * shows. X ranks replies for each viewer, so `replies_missing` can't tell.
         */
        class ReplyLock
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /**
             * `replies_show` means X showed at least 1 checked reply. `replies_missing` means it
             * showed none on the pages read.
             */
            fun reason(): Reason = reason.getRequired("reason")

            /** How many replies it opened & how many showed. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [ReplyLock]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ReplyLock]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(replyLock: ReplyLock) = apply {
                    verdict = replyLock.verdict
                    reason = replyLock.reason
                    evidence = replyLock.evidence
                    additionalProperties = replyLock.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /**
                 * `replies_show` means X showed at least 1 checked reply. `replies_missing` means
                 * it showed none on the pages read.
                 */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** How many replies it opened & how many showed. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [ReplyLock].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ReplyLock =
                    ReplyLock(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): ReplyLock = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * `replies_show` means X showed at least 1 checked reply. `replies_missing` means it
             * showed none on the pages read.
             */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val REPLIES_SHOW = of("replies_show")

                    @JvmField val REPLIES_MISSING = of("replies_missing")

                    @JvmField val NO_RECENT_REPLIES = of("no_recent_replies")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    REPLIES_SHOW,
                    REPLIES_MISSING,
                    NO_RECENT_REPLIES,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    REPLIES_SHOW,
                    REPLIES_MISSING,
                    NO_RECENT_REPLIES,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        REPLIES_SHOW -> Value.REPLIES_SHOW
                        REPLIES_MISSING -> Value.REPLIES_MISSING
                        NO_RECENT_REPLIES -> Value.NO_RECENT_REPLIES
                        UNAVAILABLE -> Value.UNAVAILABLE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        REPLIES_SHOW -> Known.REPLIES_SHOW
                        REPLIES_MISSING -> Known.REPLIES_MISSING
                        NO_RECENT_REPLIES -> Known.NO_RECENT_REPLIES
                        UNAVAILABLE -> Known.UNAVAILABLE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** How many replies it opened & how many showed. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val checkedReplies: JsonField<Long>,
                private val shownReplies: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("checkedReplies")
                    @ExcludeMissing
                    checkedReplies: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("shownReplies")
                    @ExcludeMissing
                    shownReplies: JsonField<Long> = JsonMissing.of(),
                ) : this(checkedReplies, shownReplies, mutableMapOf())

                /** Replies it looked for, up to 3. */
                fun checkedReplies(): Long = checkedReplies.getRequired("checkedReplies")

                /** Replies that showed in their thread. */
                fun shownReplies(): Long = shownReplies.getRequired("shownReplies")

                /** Returns the raw JSON value of [checkedReplies]. */
                @JsonProperty("checkedReplies")
                @ExcludeMissing
                fun _checkedReplies(): JsonField<Long> = checkedReplies

                /** Returns the raw JSON value of [shownReplies]. */
                @JsonProperty("shownReplies")
                @ExcludeMissing
                fun _shownReplies(): JsonField<Long> = shownReplies

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var checkedReplies: JsonField<Long>? = null
                    private var shownReplies: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        checkedReplies = evidence.checkedReplies
                        shownReplies = evidence.shownReplies
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Replies it looked for, up to 3. */
                    fun checkedReplies(checkedReplies: Long) =
                        checkedReplies(JsonField.of(checkedReplies))

                    /** Sets [Builder.checkedReplies] to an arbitrary JSON value. */
                    fun checkedReplies(checkedReplies: JsonField<Long>) = apply {
                        this.checkedReplies = checkedReplies
                    }

                    /** Replies that showed in their thread. */
                    fun shownReplies(shownReplies: Long) = shownReplies(JsonField.of(shownReplies))

                    /** Sets [Builder.shownReplies] to an arbitrary JSON value. */
                    fun shownReplies(shownReplies: JsonField<Long>) = apply {
                        this.shownReplies = shownReplies
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("checkedReplies", checkedReplies),
                            checkRequired("shownReplies", shownReplies),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    checkedReplies()
                    shownReplies()
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
                    (if (checkedReplies.asKnown().isPresent) 1 else 0) +
                        (if (shownReplies.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        checkedReplies == other.checkedReplies &&
                        shownReplies == other.shownReplies &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(checkedReplies, shownReplies, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{checkedReplies=$checkedReplies, shownReplies=$shownReplies, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ReplyLock &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ReplyLock{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Looks for the account's posts on its profile timeline. `visible` passes & `hidden` fails.
         */
        class Timeline
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /**
             * `visible` means the timeline shows posts. `hidden` means X counts posts but shows
             * none. `no_posts` means the account has none to show.
             */
            fun reason(): Reason = reason.getRequired("reason")

            /** The post count on the profile & the posts read. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Timeline]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Timeline]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(timeline: Timeline) = apply {
                    verdict = timeline.verdict
                    reason = timeline.reason
                    evidence = timeline.evidence
                    additionalProperties = timeline.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /**
                 * `visible` means the timeline shows posts. `hidden` means X counts posts but shows
                 * none. `no_posts` means the account has none to show.
                 */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** The post count on the profile & the posts read. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Timeline].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Timeline =
                    Timeline(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Timeline = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * `visible` means the timeline shows posts. `hidden` means X counts posts but shows
             * none. `no_posts` means the account has none to show.
             */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val VISIBLE = of("visible")

                    @JvmField val HIDDEN = of("hidden")

                    @JvmField val NO_POSTS = of("no_posts")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    VISIBLE,
                    HIDDEN,
                    NO_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    VISIBLE,
                    HIDDEN,
                    NO_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        VISIBLE -> Value.VISIBLE
                        HIDDEN -> Value.HIDDEN
                        NO_POSTS -> Value.NO_POSTS
                        UNAVAILABLE -> Value.UNAVAILABLE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        VISIBLE -> Known.VISIBLE
                        HIDDEN -> Known.HIDDEN
                        NO_POSTS -> Known.NO_POSTS
                        UNAVAILABLE -> Known.UNAVAILABLE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The post count on the profile & the posts read. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val postCount: JsonField<Long>,
                private val timelinePosts: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("postCount")
                    @ExcludeMissing
                    postCount: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("timelinePosts")
                    @ExcludeMissing
                    timelinePosts: JsonField<Long> = JsonMissing.of(),
                ) : this(postCount, timelinePosts, mutableMapOf())

                /** Posts X counts on the profile. */
                fun postCount(): Optional<Long> = postCount.getOptional("postCount")

                /** Posts the timeline read returned, up to 20. */
                fun timelinePosts(): Long = timelinePosts.getRequired("timelinePosts")

                /** Returns the raw JSON value of [postCount]. */
                @JsonProperty("postCount")
                @ExcludeMissing
                fun _postCount(): JsonField<Long> = postCount

                /** Returns the raw JSON value of [timelinePosts]. */
                @JsonProperty("timelinePosts")
                @ExcludeMissing
                fun _timelinePosts(): JsonField<Long> = timelinePosts

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var postCount: JsonField<Long>? = null
                    private var timelinePosts: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        postCount = evidence.postCount
                        timelinePosts = evidence.timelinePosts
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Posts X counts on the profile. */
                    fun postCount(postCount: Long?) = postCount(JsonField.ofNullable(postCount))

                    /**
                     * Alias for [Builder.postCount].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun postCount(postCount: Long) = postCount(postCount as Long?)

                    /** Alias for calling [Builder.postCount] with `postCount.orElse(null)`. */
                    fun postCount(postCount: Optional<Long>) = postCount(postCount.getOrNull())

                    /** Sets [Builder.postCount] to an arbitrary JSON value. */
                    fun postCount(postCount: JsonField<Long>) = apply { this.postCount = postCount }

                    /** Posts the timeline read returned, up to 20. */
                    fun timelinePosts(timelinePosts: Long) =
                        timelinePosts(JsonField.of(timelinePosts))

                    /** Sets [Builder.timelinePosts] to an arbitrary JSON value. */
                    fun timelinePosts(timelinePosts: JsonField<Long>) = apply {
                        this.timelinePosts = timelinePosts
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("postCount", postCount),
                            checkRequired("timelinePosts", timelinePosts),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    postCount()
                    timelinePosts()
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
                    (if (postCount.asKnown().isPresent) 1 else 0) +
                        (if (timelinePosts.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        postCount == other.postCount &&
                        timelinePosts == other.timelinePosts &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(postCount, timelinePosts, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{postCount=$postCount, timelinePosts=$timelinePosts, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Timeline &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Timeline{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /**
         * Compares the newest 5 of the account's own posts older than 24 hours with its earlier
         * posts, by the median of likes, replies, reposts & quotes. `typical` passes at 25% or
         * more. A drop alone proves nothing, so `low` can't tell.
         */
        class Engagement
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /**
             * `too_few_posts` means fewer than 8 posts to compare, or earlier posts with no
             * engagement.
             */
            fun reason(): Reason = reason.getRequired("reason")

            /** The 2 medians & how many posts each one covers. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Engagement]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Engagement]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(engagement: Engagement) = apply {
                    verdict = engagement.verdict
                    reason = engagement.reason
                    evidence = engagement.evidence
                    additionalProperties = engagement.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /**
                 * `too_few_posts` means fewer than 8 posts to compare, or earlier posts with no
                 * engagement.
                 */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** The 2 medians & how many posts each one covers. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Engagement].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Engagement =
                    Engagement(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Engagement = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * `too_few_posts` means fewer than 8 posts to compare, or earlier posts with no
             * engagement.
             */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val TYPICAL = of("typical")

                    @JvmField val LOW = of("low")

                    @JvmField val TOO_FEW_POSTS = of("too_few_posts")

                    @JvmField val UNAVAILABLE = of("unavailable")

                    @JvmField val PROTECTED = of("protected")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    TYPICAL,
                    LOW,
                    TOO_FEW_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    TYPICAL,
                    LOW,
                    TOO_FEW_POSTS,
                    UNAVAILABLE,
                    PROTECTED,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        TYPICAL -> Value.TYPICAL
                        LOW -> Value.LOW
                        TOO_FEW_POSTS -> Value.TOO_FEW_POSTS
                        UNAVAILABLE -> Value.UNAVAILABLE
                        PROTECTED -> Value.PROTECTED
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        TYPICAL -> Known.TYPICAL
                        LOW -> Known.LOW
                        TOO_FEW_POSTS -> Known.TOO_FEW_POSTS
                        UNAVAILABLE -> Known.UNAVAILABLE
                        PROTECTED -> Known.PROTECTED
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The 2 medians & how many posts each one covers. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val newestMedian: JsonField<Double>,
                private val newestPosts: JsonField<Long>,
                private val earlierMedian: JsonField<Double>,
                private val earlierPosts: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("newestMedian")
                    @ExcludeMissing
                    newestMedian: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("newestPosts")
                    @ExcludeMissing
                    newestPosts: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("earlierMedian")
                    @ExcludeMissing
                    earlierMedian: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("earlierPosts")
                    @ExcludeMissing
                    earlierPosts: JsonField<Long> = JsonMissing.of(),
                ) : this(newestMedian, newestPosts, earlierMedian, earlierPosts, mutableMapOf())

                /** Median engagement of the newest posts. */
                fun newestMedian(): Double = newestMedian.getRequired("newestMedian")

                /** Posts in the newest group, up to 5. */
                fun newestPosts(): Long = newestPosts.getRequired("newestPosts")

                /** Median engagement of the earlier posts. */
                fun earlierMedian(): Double = earlierMedian.getRequired("earlierMedian")

                /** Posts in the earlier group. */
                fun earlierPosts(): Long = earlierPosts.getRequired("earlierPosts")

                /** Returns the raw JSON value of [newestMedian]. */
                @JsonProperty("newestMedian")
                @ExcludeMissing
                fun _newestMedian(): JsonField<Double> = newestMedian

                /** Returns the raw JSON value of [newestPosts]. */
                @JsonProperty("newestPosts")
                @ExcludeMissing
                fun _newestPosts(): JsonField<Long> = newestPosts

                /** Returns the raw JSON value of [earlierMedian]. */
                @JsonProperty("earlierMedian")
                @ExcludeMissing
                fun _earlierMedian(): JsonField<Double> = earlierMedian

                /** Returns the raw JSON value of [earlierPosts]. */
                @JsonProperty("earlierPosts")
                @ExcludeMissing
                fun _earlierPosts(): JsonField<Long> = earlierPosts

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var newestMedian: JsonField<Double>? = null
                    private var newestPosts: JsonField<Long>? = null
                    private var earlierMedian: JsonField<Double>? = null
                    private var earlierPosts: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        newestMedian = evidence.newestMedian
                        newestPosts = evidence.newestPosts
                        earlierMedian = evidence.earlierMedian
                        earlierPosts = evidence.earlierPosts
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Median engagement of the newest posts. */
                    fun newestMedian(newestMedian: Double) =
                        newestMedian(JsonField.of(newestMedian))

                    /** Sets [Builder.newestMedian] to an arbitrary JSON value. */
                    fun newestMedian(newestMedian: JsonField<Double>) = apply {
                        this.newestMedian = newestMedian
                    }

                    /** Posts in the newest group, up to 5. */
                    fun newestPosts(newestPosts: Long) = newestPosts(JsonField.of(newestPosts))

                    /** Sets [Builder.newestPosts] to an arbitrary JSON value. */
                    fun newestPosts(newestPosts: JsonField<Long>) = apply {
                        this.newestPosts = newestPosts
                    }

                    /** Median engagement of the earlier posts. */
                    fun earlierMedian(earlierMedian: Double) =
                        earlierMedian(JsonField.of(earlierMedian))

                    /** Sets [Builder.earlierMedian] to an arbitrary JSON value. */
                    fun earlierMedian(earlierMedian: JsonField<Double>) = apply {
                        this.earlierMedian = earlierMedian
                    }

                    /** Posts in the earlier group. */
                    fun earlierPosts(earlierPosts: Long) = earlierPosts(JsonField.of(earlierPosts))

                    /** Sets [Builder.earlierPosts] to an arbitrary JSON value. */
                    fun earlierPosts(earlierPosts: JsonField<Long>) = apply {
                        this.earlierPosts = earlierPosts
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("newestMedian", newestMedian),
                            checkRequired("newestPosts", newestPosts),
                            checkRequired("earlierMedian", earlierMedian),
                            checkRequired("earlierPosts", earlierPosts),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    newestMedian()
                    newestPosts()
                    earlierMedian()
                    earlierPosts()
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
                    (if (newestMedian.asKnown().isPresent) 1 else 0) +
                        (if (newestPosts.asKnown().isPresent) 1 else 0) +
                        (if (earlierMedian.asKnown().isPresent) 1 else 0) +
                        (if (earlierPosts.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        newestMedian == other.newestMedian &&
                        newestPosts == other.newestPosts &&
                        earlierMedian == other.earlierMedian &&
                        earlierPosts == other.earlierPosts &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        newestMedian,
                        newestPosts,
                        earlierMedian,
                        earlierPosts,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{newestMedian=$newestMedian, newestPosts=$newestPosts, earlierMedian=$earlierMedian, earlierPosts=$earlierPosts, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Engagement &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Engagement{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /** Reads X's sensitive flag on the profile. `not_flagged` passes & `flagged` fails. */
        class Sensitive
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence") @ExcludeMissing evidence: JsonValue = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /** `unknown` means X left the flag out of the profile. */
            fun reason(): Reason = reason.getRequired("reason")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Always null, since the reason holds the answer. */
            @JsonProperty("evidence") @ExcludeMissing fun _evidence(): JsonValue = evidence

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

                /** Returns a mutable builder for constructing an instance of [Sensitive]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Sensitive]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonValue = JsonValue.from(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(sensitive: Sensitive) = apply {
                    verdict = sensitive.verdict
                    reason = sensitive.reason
                    evidence = sensitive.evidence
                    additionalProperties = sensitive.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /** `unknown` means X left the flag out of the profile. */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** Always null, since the reason holds the answer. */
                fun evidence(evidence: JsonValue) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Sensitive].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Sensitive =
                    Sensitive(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        evidence,
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
            fun validate(): Sensitive = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0)

            /** `unknown` means X left the flag out of the profile. */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val NOT_FLAGGED = of("not_flagged")

                    @JvmField val FLAGGED = of("flagged")

                    @JvmField val UNKNOWN = of("unknown")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    NOT_FLAGGED,
                    FLAGGED,
                    UNKNOWN,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    NOT_FLAGGED,
                    FLAGGED,
                    UNKNOWN,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        NOT_FLAGGED -> Value.NOT_FLAGGED
                        FLAGGED -> Value.FLAGGED
                        UNKNOWN -> Value.UNKNOWN
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        NOT_FLAGGED -> Known.NOT_FLAGGED
                        FLAGGED -> Known.FLAGGED
                        UNKNOWN -> Known.UNKNOWN
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Sensitive &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Sensitive{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        /** Reads the countries where X withholds the account. `none` passes & `countries` fails. */
        class Withheld
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val verdict: JsonField<ShadowbanVerdict>,
            private val reason: JsonField<Reason>,
            private val evidence: JsonField<Evidence>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("verdict")
                @ExcludeMissing
                verdict: JsonField<ShadowbanVerdict> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("evidence")
                @ExcludeMissing
                evidence: JsonField<Evidence> = JsonMissing.of(),
            ) : this(verdict, reason, evidence, mutableMapOf())

            /**
             * Pass means X shows the account there, and fail means it doesn't. Unknown means the
             * check had nothing to test or X didn't answer.
             */
            fun verdict(): ShadowbanVerdict = verdict.getRequired("verdict")

            /** `countries` means X lists at least 1 country. */
            fun reason(): Reason = reason.getRequired("reason")

            /** The countries X lists. */
            fun evidence(): Optional<Evidence> = evidence.getOptional("evidence")

            /** Returns the raw JSON value of [verdict]. */
            @JsonProperty("verdict")
            @ExcludeMissing
            fun _verdict(): JsonField<ShadowbanVerdict> = verdict

            /** Returns the raw JSON value of [reason]. */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /** Returns the raw JSON value of [evidence]. */
            @JsonProperty("evidence")
            @ExcludeMissing
            fun _evidence(): JsonField<Evidence> = evidence

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

                /** Returns a mutable builder for constructing an instance of [Withheld]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Withheld]. */
            class Builder internal constructor() {

                private var verdict: JsonField<ShadowbanVerdict>? = null
                private var reason: JsonField<Reason>? = null
                private var evidence: JsonField<Evidence>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(withheld: Withheld) = apply {
                    verdict = withheld.verdict
                    reason = withheld.reason
                    evidence = withheld.evidence
                    additionalProperties = withheld.additionalProperties.toMutableMap()
                }

                /**
                 * Pass means X shows the account there, and fail means it doesn't. Unknown means
                 * the check had nothing to test or X didn't answer.
                 */
                fun verdict(verdict: ShadowbanVerdict) = verdict(JsonField.of(verdict))

                /** Sets [Builder.verdict] to an arbitrary JSON value. */
                fun verdict(verdict: JsonField<ShadowbanVerdict>) = apply { this.verdict = verdict }

                /** `countries` means X lists at least 1 country. */
                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /** Sets [Builder.reason] to an arbitrary JSON value. */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                /** The countries X lists. */
                fun evidence(evidence: Evidence?) = evidence(JsonField.ofNullable(evidence))

                /** Alias for calling [Builder.evidence] with `evidence.orElse(null)`. */
                fun evidence(evidence: Optional<Evidence>) = evidence(evidence.getOrNull())

                /** Sets [Builder.evidence] to an arbitrary JSON value. */
                fun evidence(evidence: JsonField<Evidence>) = apply { this.evidence = evidence }

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
                 * Returns an immutable instance of [Withheld].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Withheld =
                    Withheld(
                        checkRequired("verdict", verdict),
                        checkRequired("reason", reason),
                        checkRequired("evidence", evidence),
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
            fun validate(): Withheld = apply {
                if (validated) {
                    return@apply
                }

                verdict().validate()
                reason().validate()
                evidence().ifPresent { it.validate() }
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
                (verdict.asKnown().getOrNull()?.validity() ?: 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (evidence.asKnown().getOrNull()?.validity() ?: 0)

            /** `countries` means X lists at least 1 country. */
            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val NONE = of("none")

                    @JvmField val COUNTRIES = of("countries")

                    @JvmField val SUSPENDED = of("suspended")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    NONE,
                    COUNTRIES,
                    SUSPENDED,
                }

                /** An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member. */
                enum class Value {
                    NONE,
                    COUNTRIES,
                    SUSPENDED,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
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
                        NONE -> Value.NONE
                        COUNTRIES -> Value.COUNTRIES
                        SUSPENDED -> Value.SUSPENDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        NONE -> Known.NONE
                        COUNTRIES -> Known.COUNTRIES
                        SUSPENDED -> Known.SUSPENDED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /** Validates that this value is a known member. */
                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The countries X lists. */
            class Evidence
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val countries: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("countries")
                    @ExcludeMissing
                    countries: JsonField<List<String>> = JsonMissing.of()
                ) : this(countries, mutableMapOf())

                /** Country codes as X gives them. */
                fun countries(): List<String> = countries.getRequired("countries")

                /** Returns the raw JSON value of [countries]. */
                @JsonProperty("countries")
                @ExcludeMissing
                fun _countries(): JsonField<List<String>> = countries

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

                    /** Returns a mutable builder for constructing an instance of [Evidence]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Evidence]. */
                class Builder internal constructor() {

                    private var countries: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evidence: Evidence) = apply {
                        countries = evidence.countries.map { it.toMutableList() }
                        additionalProperties = evidence.additionalProperties.toMutableMap()
                    }

                    /** Country codes as X gives them. */
                    fun countries(countries: List<String>) = countries(JsonField.of(countries))

                    /** Sets [Builder.countries] to an arbitrary JSON value. */
                    fun countries(countries: JsonField<List<String>>) = apply {
                        this.countries = countries.map { it.toMutableList() }
                    }

                    /** Adds a single [String] to [countries]. */
                    fun addCountry(country: String) = apply {
                        countries =
                            (countries ?: JsonField.of(mutableListOf())).also {
                                checkKnown("countries", it).add(country)
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
                     * Returns an immutable instance of [Evidence].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Evidence =
                        Evidence(
                            checkRequired("countries", countries).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Evidence = apply {
                    if (validated) {
                        return@apply
                    }

                    countries()
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
                internal fun validity(): Int = (countries.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Evidence &&
                        countries == other.countries &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(countries, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Evidence{countries=$countries, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Withheld &&
                    verdict == other.verdict &&
                    reason == other.reason &&
                    evidence == other.evidence &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(verdict, reason, evidence, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Withheld{verdict=$verdict, reason=$reason, evidence=$evidence, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Checks &&
                account == other.account &&
                search == other.search &&
                suggestion == other.suggestion &&
                replies == other.replies &&
                replyLock == other.replyLock &&
                timeline == other.timeline &&
                engagement == other.engagement &&
                sensitive == other.sensitive &&
                withheld == other.withheld &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                account,
                search,
                suggestion,
                replies,
                replyLock,
                timeline,
                engagement,
                sensitive,
                withheld,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Checks{account=$account, search=$search, suggestion=$suggestion, replies=$replies, replyLock=$replyLock, timeline=$timeline, engagement=$engagement, sensitive=$sensitive, withheld=$withheld, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShadowbanReport &&
            username == other.username &&
            userId == other.userId &&
            account == other.account &&
            checkedAt == other.checkedAt &&
            overall == other.overall &&
            checks == other.checks &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(username, userId, account, checkedAt, overall, checks, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ShadowbanReport{username=$username, userId=$userId, account=$account, checkedAt=$checkedAt, overall=$overall, checks=$checks, additionalProperties=$additionalProperties}"
}
