// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** 1 page of job listings. Follow next_cursor while the response reports more pages. */
class JobSearchResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val jobs: JsonField<List<Job>>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("jobs") @ExcludeMissing jobs: JsonField<List<Job>> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(hasNextPage, jobs, nextCursor, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun jobs(): List<Job> = jobs.getRequired("jobs")

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
     * Returns the raw JSON value of [jobs].
     *
     * Unlike [jobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("jobs") @ExcludeMissing fun _jobs(): JsonField<List<Job>> = jobs

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
         * Returns a mutable builder for constructing an instance of [JobSearchResponse].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .jobs()
         * .nextCursor()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [JobSearchResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var jobs: JsonField<MutableList<Job>>? = null
        private var nextCursor: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(jobSearchResponse: JobSearchResponse) = apply {
            hasNextPage = jobSearchResponse.hasNextPage
            jobs = jobSearchResponse.jobs.map { it.toMutableList() }
            nextCursor = jobSearchResponse.nextCursor
            additionalProperties = jobSearchResponse.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun jobs(jobs: List<Job>) = jobs(JsonField.of(jobs))

        /** Sets [Builder.jobs] to an arbitrary JSON value. */
        fun jobs(jobs: JsonField<List<Job>>) = apply { this.jobs = jobs.map { it.toMutableList() } }

        /**
         * Adds a single [Job] to [jobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addJob(job: Job) = apply {
            jobs = (jobs ?: JsonField.of(mutableListOf())).also { checkKnown("jobs", it).add(job) }
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
         * Returns an immutable instance of [JobSearchResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .jobs()
         * .nextCursor()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): JobSearchResponse =
            JobSearchResponse(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("jobs", jobs).map { it.toImmutable() },
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
    fun validate(): JobSearchResponse = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        jobs().forEach { it.validate() }
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
            (jobs.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    /**
     * Public X job listing. A search returns the fields down to the salary, plus company & account.
     * A lookup adds work type, seniority, function, team & descriptions. A field X leaves empty is
     * left out.
     */
    class Job
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val url: JsonField<String>,
        private val account: JsonField<Account>,
        private val applyUrl: JsonField<String>,
        private val company: JsonField<Company>,
        private val description: JsonField<String>,
        private val descriptionMarkdown: JsonField<String>,
        private val employmentType: JsonField<String>,
        private val featured: JsonField<Boolean>,
        private val formattedSalary: JsonField<String>,
        private val jobFunction: JsonField<String>,
        private val location: JsonField<String>,
        private val locationType: JsonField<String>,
        private val postedAt: JsonField<OffsetDateTime>,
        private val salaryCurrencyCode: JsonField<String>,
        private val salaryInterval: JsonField<String>,
        private val salaryMax: JsonField<Double>,
        private val salaryMin: JsonField<Double>,
        private val seniorityLevel: JsonField<String>,
        private val shortDescription: JsonField<String>,
        private val team: JsonField<String>,
        private val title: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("account") @ExcludeMissing account: JsonField<Account> = JsonMissing.of(),
            @JsonProperty("applyUrl")
            @ExcludeMissing
            applyUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("company") @ExcludeMissing company: JsonField<Company> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("descriptionMarkdown")
            @ExcludeMissing
            descriptionMarkdown: JsonField<String> = JsonMissing.of(),
            @JsonProperty("employmentType")
            @ExcludeMissing
            employmentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("featured")
            @ExcludeMissing
            featured: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("formattedSalary")
            @ExcludeMissing
            formattedSalary: JsonField<String> = JsonMissing.of(),
            @JsonProperty("jobFunction")
            @ExcludeMissing
            jobFunction: JsonField<String> = JsonMissing.of(),
            @JsonProperty("location")
            @ExcludeMissing
            location: JsonField<String> = JsonMissing.of(),
            @JsonProperty("locationType")
            @ExcludeMissing
            locationType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postedAt")
            @ExcludeMissing
            postedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("salaryCurrencyCode")
            @ExcludeMissing
            salaryCurrencyCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("salaryInterval")
            @ExcludeMissing
            salaryInterval: JsonField<String> = JsonMissing.of(),
            @JsonProperty("salaryMax")
            @ExcludeMissing
            salaryMax: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("salaryMin")
            @ExcludeMissing
            salaryMin: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("seniorityLevel")
            @ExcludeMissing
            seniorityLevel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shortDescription")
            @ExcludeMissing
            shortDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("team") @ExcludeMissing team: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            url,
            account,
            applyUrl,
            company,
            description,
            descriptionMarkdown,
            employmentType,
            featured,
            formattedSalary,
            jobFunction,
            location,
            locationType,
            postedAt,
            salaryCurrencyCode,
            salaryInterval,
            salaryMax,
            salaryMin,
            seniorityLevel,
            shortDescription,
            team,
            title,
            mutableMapOf(),
        )

        /**
         * Job ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * The job page on X.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun url(): String = url.getRequired("url")

        /**
         * The X account that posted a job. A job has none when X imported it from a job board or no
         * longer shows the account.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun account(): Optional<Account> = account.getOptional("account")

        /**
         * Where applicants apply, off X.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun applyUrl(): Optional<String> = applyUrl.getOptional("applyUrl")

        /**
         * The company profile of a job X imported from a job board.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun company(): Optional<Company> = company.getOptional("company")

        /**
         * Full description as plain text, 1 line per paragraph.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Full description as Markdown, with headings, lists, links, bold & italics.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun descriptionMarkdown(): Optional<String> =
            descriptionMarkdown.getOptional("descriptionMarkdown")

        /**
         * Contract type (full_time, full_time_contract, part_time or contract_to_hire).
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun employmentType(): Optional<String> = employmentType.getOptional("employmentType")

        /**
         * Whether X features the job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun featured(): Optional<Boolean> = featured.getOptional("featured")

        /**
         * Salary as X shows it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun formattedSalary(): Optional<String> = formattedSalary.getOptional("formattedSalary")

        /**
         * Job function, such as software_engineering.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun jobFunction(): Optional<String> = jobFunction.getOptional("jobFunction")

        /**
         * Location as the employer wrote it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun location(): Optional<String> = location.getOptional("location")

        /**
         * Where the work happens (onsite, remote or hybrid).
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun locationType(): Optional<String> = locationType.getOptional("locationType")

        /**
         * When the employer posted the job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun postedAt(): Optional<OffsetDateTime> = postedAt.getOptional("postedAt")

        /**
         * ISO 4217 currency code of the salary.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun salaryCurrencyCode(): Optional<String> =
            salaryCurrencyCode.getOptional("salaryCurrencyCode")

        /**
         * Pay period of the salary (annually or hourly).
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun salaryInterval(): Optional<String> = salaryInterval.getOptional("salaryInterval")

        /**
         * Highest salary, in salaryCurrencyCode per salaryInterval.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun salaryMax(): Optional<Double> = salaryMax.getOptional("salaryMax")

        /**
         * Lowest salary, in salaryCurrencyCode per salaryInterval.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun salaryMin(): Optional<Double> = salaryMin.getOptional("salaryMin")

        /**
         * Seniority (intern, entry_level, junior, mid_level, senior, lead, manager or executive).
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun seniorityLevel(): Optional<String> = seniorityLevel.getOptional("seniorityLevel")

        /**
         * Short summary of the job, as plain text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun shortDescription(): Optional<String> = shortDescription.getOptional("shortDescription")

        /**
         * Team inside the company.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun team(): Optional<String> = team.getOptional("team")

        /**
         * Job title.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [account].
         *
         * Unlike [account], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("account") @ExcludeMissing fun _account(): JsonField<Account> = account

        /**
         * Returns the raw JSON value of [applyUrl].
         *
         * Unlike [applyUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("applyUrl") @ExcludeMissing fun _applyUrl(): JsonField<String> = applyUrl

        /**
         * Returns the raw JSON value of [company].
         *
         * Unlike [company], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("company") @ExcludeMissing fun _company(): JsonField<Company> = company

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [descriptionMarkdown].
         *
         * Unlike [descriptionMarkdown], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("descriptionMarkdown")
        @ExcludeMissing
        fun _descriptionMarkdown(): JsonField<String> = descriptionMarkdown

        /**
         * Returns the raw JSON value of [employmentType].
         *
         * Unlike [employmentType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("employmentType")
        @ExcludeMissing
        fun _employmentType(): JsonField<String> = employmentType

        /**
         * Returns the raw JSON value of [featured].
         *
         * Unlike [featured], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("featured") @ExcludeMissing fun _featured(): JsonField<Boolean> = featured

        /**
         * Returns the raw JSON value of [formattedSalary].
         *
         * Unlike [formattedSalary], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("formattedSalary")
        @ExcludeMissing
        fun _formattedSalary(): JsonField<String> = formattedSalary

        /**
         * Returns the raw JSON value of [jobFunction].
         *
         * Unlike [jobFunction], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("jobFunction")
        @ExcludeMissing
        fun _jobFunction(): JsonField<String> = jobFunction

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

        /**
         * Returns the raw JSON value of [locationType].
         *
         * Unlike [locationType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("locationType")
        @ExcludeMissing
        fun _locationType(): JsonField<String> = locationType

        /**
         * Returns the raw JSON value of [postedAt].
         *
         * Unlike [postedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postedAt")
        @ExcludeMissing
        fun _postedAt(): JsonField<OffsetDateTime> = postedAt

        /**
         * Returns the raw JSON value of [salaryCurrencyCode].
         *
         * Unlike [salaryCurrencyCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("salaryCurrencyCode")
        @ExcludeMissing
        fun _salaryCurrencyCode(): JsonField<String> = salaryCurrencyCode

        /**
         * Returns the raw JSON value of [salaryInterval].
         *
         * Unlike [salaryInterval], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("salaryInterval")
        @ExcludeMissing
        fun _salaryInterval(): JsonField<String> = salaryInterval

        /**
         * Returns the raw JSON value of [salaryMax].
         *
         * Unlike [salaryMax], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("salaryMax") @ExcludeMissing fun _salaryMax(): JsonField<Double> = salaryMax

        /**
         * Returns the raw JSON value of [salaryMin].
         *
         * Unlike [salaryMin], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("salaryMin") @ExcludeMissing fun _salaryMin(): JsonField<Double> = salaryMin

        /**
         * Returns the raw JSON value of [seniorityLevel].
         *
         * Unlike [seniorityLevel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("seniorityLevel")
        @ExcludeMissing
        fun _seniorityLevel(): JsonField<String> = seniorityLevel

        /**
         * Returns the raw JSON value of [shortDescription].
         *
         * Unlike [shortDescription], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("shortDescription")
        @ExcludeMissing
        fun _shortDescription(): JsonField<String> = shortDescription

        /**
         * Returns the raw JSON value of [team].
         *
         * Unlike [team], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("team") @ExcludeMissing fun _team(): JsonField<String> = team

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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
             * Returns a mutable builder for constructing an instance of [Job].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Job]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var url: JsonField<String>? = null
            private var account: JsonField<Account> = JsonMissing.of()
            private var applyUrl: JsonField<String> = JsonMissing.of()
            private var company: JsonField<Company> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var descriptionMarkdown: JsonField<String> = JsonMissing.of()
            private var employmentType: JsonField<String> = JsonMissing.of()
            private var featured: JsonField<Boolean> = JsonMissing.of()
            private var formattedSalary: JsonField<String> = JsonMissing.of()
            private var jobFunction: JsonField<String> = JsonMissing.of()
            private var location: JsonField<String> = JsonMissing.of()
            private var locationType: JsonField<String> = JsonMissing.of()
            private var postedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var salaryCurrencyCode: JsonField<String> = JsonMissing.of()
            private var salaryInterval: JsonField<String> = JsonMissing.of()
            private var salaryMax: JsonField<Double> = JsonMissing.of()
            private var salaryMin: JsonField<Double> = JsonMissing.of()
            private var seniorityLevel: JsonField<String> = JsonMissing.of()
            private var shortDescription: JsonField<String> = JsonMissing.of()
            private var team: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(job: Job) = apply {
                id = job.id
                url = job.url
                account = job.account
                applyUrl = job.applyUrl
                company = job.company
                description = job.description
                descriptionMarkdown = job.descriptionMarkdown
                employmentType = job.employmentType
                featured = job.featured
                formattedSalary = job.formattedSalary
                jobFunction = job.jobFunction
                location = job.location
                locationType = job.locationType
                postedAt = job.postedAt
                salaryCurrencyCode = job.salaryCurrencyCode
                salaryInterval = job.salaryInterval
                salaryMax = job.salaryMax
                salaryMin = job.salaryMin
                seniorityLevel = job.seniorityLevel
                shortDescription = job.shortDescription
                team = job.team
                title = job.title
                additionalProperties = job.additionalProperties.toMutableMap()
            }

            /** Job ID. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The job page on X. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /**
             * The X account that posted a job. A job has none when X imported it from a job board
             * or no longer shows the account.
             */
            fun account(account: Account) = account(JsonField.of(account))

            /** Sets [Builder.account] to an arbitrary JSON value. */
            fun account(account: JsonField<Account>) = apply { this.account = account }

            /** Where applicants apply, off X. */
            fun applyUrl(applyUrl: String) = applyUrl(JsonField.of(applyUrl))

            /** Sets [Builder.applyUrl] to an arbitrary JSON value. */
            fun applyUrl(applyUrl: JsonField<String>) = apply { this.applyUrl = applyUrl }

            /** The company profile of a job X imported from a job board. */
            fun company(company: Company) = company(JsonField.of(company))

            /** Sets [Builder.company] to an arbitrary JSON value. */
            fun company(company: JsonField<Company>) = apply { this.company = company }

            /** Full description as plain text, 1 line per paragraph. */
            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Full description as Markdown, with headings, lists, links, bold & italics. */
            fun descriptionMarkdown(descriptionMarkdown: String) =
                descriptionMarkdown(JsonField.of(descriptionMarkdown))

            /** Sets [Builder.descriptionMarkdown] to an arbitrary JSON value. */
            fun descriptionMarkdown(descriptionMarkdown: JsonField<String>) = apply {
                this.descriptionMarkdown = descriptionMarkdown
            }

            /** Contract type (full_time, full_time_contract, part_time or contract_to_hire). */
            fun employmentType(employmentType: String) =
                employmentType(JsonField.of(employmentType))

            /** Sets [Builder.employmentType] to an arbitrary JSON value. */
            fun employmentType(employmentType: JsonField<String>) = apply {
                this.employmentType = employmentType
            }

            /** Whether X features the job. */
            fun featured(featured: Boolean) = featured(JsonField.of(featured))

            /** Sets [Builder.featured] to an arbitrary JSON value. */
            fun featured(featured: JsonField<Boolean>) = apply { this.featured = featured }

            /** Salary as X shows it. */
            fun formattedSalary(formattedSalary: String) =
                formattedSalary(JsonField.of(formattedSalary))

            /** Sets [Builder.formattedSalary] to an arbitrary JSON value. */
            fun formattedSalary(formattedSalary: JsonField<String>) = apply {
                this.formattedSalary = formattedSalary
            }

            /** Job function, such as software_engineering. */
            fun jobFunction(jobFunction: String) = jobFunction(JsonField.of(jobFunction))

            /** Sets [Builder.jobFunction] to an arbitrary JSON value. */
            fun jobFunction(jobFunction: JsonField<String>) = apply {
                this.jobFunction = jobFunction
            }

            /** Location as the employer wrote it. */
            fun location(location: String) = location(JsonField.of(location))

            /** Sets [Builder.location] to an arbitrary JSON value. */
            fun location(location: JsonField<String>) = apply { this.location = location }

            /** Where the work happens (onsite, remote or hybrid). */
            fun locationType(locationType: String) = locationType(JsonField.of(locationType))

            /** Sets [Builder.locationType] to an arbitrary JSON value. */
            fun locationType(locationType: JsonField<String>) = apply {
                this.locationType = locationType
            }

            /** When the employer posted the job. */
            fun postedAt(postedAt: OffsetDateTime) = postedAt(JsonField.of(postedAt))

            /** Sets [Builder.postedAt] to an arbitrary JSON value. */
            fun postedAt(postedAt: JsonField<OffsetDateTime>) = apply { this.postedAt = postedAt }

            /** ISO 4217 currency code of the salary. */
            fun salaryCurrencyCode(salaryCurrencyCode: String) =
                salaryCurrencyCode(JsonField.of(salaryCurrencyCode))

            /** Sets [Builder.salaryCurrencyCode] to an arbitrary JSON value. */
            fun salaryCurrencyCode(salaryCurrencyCode: JsonField<String>) = apply {
                this.salaryCurrencyCode = salaryCurrencyCode
            }

            /** Pay period of the salary (annually or hourly). */
            fun salaryInterval(salaryInterval: String) =
                salaryInterval(JsonField.of(salaryInterval))

            /** Sets [Builder.salaryInterval] to an arbitrary JSON value. */
            fun salaryInterval(salaryInterval: JsonField<String>) = apply {
                this.salaryInterval = salaryInterval
            }

            /** Highest salary, in salaryCurrencyCode per salaryInterval. */
            fun salaryMax(salaryMax: Double) = salaryMax(JsonField.of(salaryMax))

            /** Sets [Builder.salaryMax] to an arbitrary JSON value. */
            fun salaryMax(salaryMax: JsonField<Double>) = apply { this.salaryMax = salaryMax }

            /** Lowest salary, in salaryCurrencyCode per salaryInterval. */
            fun salaryMin(salaryMin: Double) = salaryMin(JsonField.of(salaryMin))

            /** Sets [Builder.salaryMin] to an arbitrary JSON value. */
            fun salaryMin(salaryMin: JsonField<Double>) = apply { this.salaryMin = salaryMin }

            /**
             * Seniority (intern, entry_level, junior, mid_level, senior, lead, manager or
             * executive).
             */
            fun seniorityLevel(seniorityLevel: String) =
                seniorityLevel(JsonField.of(seniorityLevel))

            /** Sets [Builder.seniorityLevel] to an arbitrary JSON value. */
            fun seniorityLevel(seniorityLevel: JsonField<String>) = apply {
                this.seniorityLevel = seniorityLevel
            }

            /** Short summary of the job, as plain text. */
            fun shortDescription(shortDescription: String) =
                shortDescription(JsonField.of(shortDescription))

            /** Sets [Builder.shortDescription] to an arbitrary JSON value. */
            fun shortDescription(shortDescription: JsonField<String>) = apply {
                this.shortDescription = shortDescription
            }

            /** Team inside the company. */
            fun team(team: String) = team(JsonField.of(team))

            /** Sets [Builder.team] to an arbitrary JSON value. */
            fun team(team: JsonField<String>) = apply { this.team = team }

            /** Job title. */
            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
            fun title(title: JsonField<String>) = apply { this.title = title }

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
             * Returns an immutable instance of [Job].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Job =
                Job(
                    checkRequired("id", id),
                    checkRequired("url", url),
                    account,
                    applyUrl,
                    company,
                    description,
                    descriptionMarkdown,
                    employmentType,
                    featured,
                    formattedSalary,
                    jobFunction,
                    location,
                    locationType,
                    postedAt,
                    salaryCurrencyCode,
                    salaryInterval,
                    salaryMax,
                    salaryMin,
                    seniorityLevel,
                    shortDescription,
                    team,
                    title,
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
        fun validate(): Job = apply {
            if (validated) {
                return@apply
            }

            id()
            url()
            account().ifPresent { it.validate() }
            applyUrl()
            company().ifPresent { it.validate() }
            description()
            descriptionMarkdown()
            employmentType()
            featured()
            formattedSalary()
            jobFunction()
            location()
            locationType()
            postedAt()
            salaryCurrencyCode()
            salaryInterval()
            salaryMax()
            salaryMin()
            seniorityLevel()
            shortDescription()
            team()
            title()
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
                (if (url.asKnown().isPresent) 1 else 0) +
                (account.asKnown().getOrNull()?.validity() ?: 0) +
                (if (applyUrl.asKnown().isPresent) 1 else 0) +
                (company.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (descriptionMarkdown.asKnown().isPresent) 1 else 0) +
                (if (employmentType.asKnown().isPresent) 1 else 0) +
                (if (featured.asKnown().isPresent) 1 else 0) +
                (if (formattedSalary.asKnown().isPresent) 1 else 0) +
                (if (jobFunction.asKnown().isPresent) 1 else 0) +
                (if (location.asKnown().isPresent) 1 else 0) +
                (if (locationType.asKnown().isPresent) 1 else 0) +
                (if (postedAt.asKnown().isPresent) 1 else 0) +
                (if (salaryCurrencyCode.asKnown().isPresent) 1 else 0) +
                (if (salaryInterval.asKnown().isPresent) 1 else 0) +
                (if (salaryMax.asKnown().isPresent) 1 else 0) +
                (if (salaryMin.asKnown().isPresent) 1 else 0) +
                (if (seniorityLevel.asKnown().isPresent) 1 else 0) +
                (if (shortDescription.asKnown().isPresent) 1 else 0) +
                (if (team.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0)

        /**
         * The X account that posted a job. A job has none when X imported it from a job board or no
         * longer shows the account.
         */
        class Account
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val verified: JsonField<Boolean>,
            private val description: JsonField<String>,
            private val name: JsonField<String>,
            private val profileImageShape: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val username: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verified")
                @ExcludeMissing
                verified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileImageShape")
                @ExcludeMissing
                profileImageShape: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                verified,
                description,
                name,
                profileImageShape,
                profilePicture,
                profilePictureOriginal,
                username,
                verifiedType,
                mutableMapOf(),
            )

            /**
             * X user ID of the account.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Whether X shows a verification badge on the account.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun verified(): Boolean = verified.getRequired("verified")

            /**
             * Bio of the account. A job lookup returns it.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Display name of the account that posted the job.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Avatar shape, such as Circle or Square.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileImageShape(): Optional<String> =
                profileImageShape.getOptional("profileImageShape")

            /**
             * Avatar URL of the account that posted the job.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The job account's avatar at full size.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Handle without @.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun username(): Optional<String> = username.getOptional("username")

            /**
             * Badge type, such as Business or Government.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [verified].
             *
             * Unlike [verified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [profileImageShape].
             *
             * Unlike [profileImageShape], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileImageShape")
            @ExcludeMissing
            fun _profileImageShape(): JsonField<String> = profileImageShape

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

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

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
                 * Returns a mutable builder for constructing an instance of [Account].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .verified()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Account]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var verified: JsonField<Boolean>? = null
                private var description: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var profileImageShape: JsonField<String> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var username: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(account: Account) = apply {
                    id = account.id
                    verified = account.verified
                    description = account.description
                    name = account.name
                    profileImageShape = account.profileImageShape
                    profilePicture = account.profilePicture
                    profilePictureOriginal = account.profilePictureOriginal
                    username = account.username
                    verifiedType = account.verifiedType
                    additionalProperties = account.additionalProperties.toMutableMap()
                }

                /** X user ID of the account. */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Whether X shows a verification badge on the account. */
                fun verified(verified: Boolean) = verified(JsonField.of(verified))

                /** Sets [Builder.verified] to an arbitrary JSON value. */
                fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

                /** Bio of the account. A job lookup returns it. */
                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** Display name of the account that posted the job. */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Avatar shape, such as Circle or Square. */
                fun profileImageShape(profileImageShape: String) =
                    profileImageShape(JsonField.of(profileImageShape))

                /** Sets [Builder.profileImageShape] to an arbitrary JSON value. */
                fun profileImageShape(profileImageShape: JsonField<String>) = apply {
                    this.profileImageShape = profileImageShape
                }

                /** Avatar URL of the account that posted the job. */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The job account's avatar at full size. */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                /** Handle without @. */
                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** Badge type, such as Business or Government. */
                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
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
                 * Returns an immutable instance of [Account].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .verified()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Account =
                    Account(
                        checkRequired("id", id),
                        checkRequired("verified", verified),
                        description,
                        name,
                        profileImageShape,
                        profilePicture,
                        profilePictureOriginal,
                        username,
                        verifiedType,
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
            fun validate(): Account = apply {
                if (validated) {
                    return@apply
                }

                id()
                verified()
                description()
                name()
                profileImageShape()
                profilePicture()
                profilePictureOriginal()
                username()
                verifiedType()
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
                    (if (verified.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (profileImageShape.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Account &&
                    id == other.id &&
                    verified == other.verified &&
                    description == other.description &&
                    name == other.name &&
                    profileImageShape == other.profileImageShape &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    username == other.username &&
                    verifiedType == other.verifiedType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    verified,
                    description,
                    name,
                    profileImageShape,
                    profilePicture,
                    profilePictureOriginal,
                    username,
                    verifiedType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Account{id=$id, verified=$verified, description=$description, name=$name, profileImageShape=$profileImageShape, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, username=$username, verifiedType=$verifiedType, additionalProperties=$additionalProperties}"
        }

        /** The company profile of a job X imported from a job board. */
        class Company
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val logoUrl: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("logoUrl")
                @ExcludeMissing
                logoUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, logoUrl, name, mutableMapOf())

            /**
             * X company profile ID.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Company logo URL.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun logoUrl(): Optional<String> = logoUrl.getOptional("logoUrl")

            /**
             * Company name.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [logoUrl].
             *
             * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("logoUrl") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

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

                /**
                 * Returns a mutable builder for constructing an instance of [Company].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Company]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var logoUrl: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(company: Company) = apply {
                    id = company.id
                    logoUrl = company.logoUrl
                    name = company.name
                    additionalProperties = company.additionalProperties.toMutableMap()
                }

                /** X company profile ID. */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Company logo URL. */
                fun logoUrl(logoUrl: String) = logoUrl(JsonField.of(logoUrl))

                /** Sets [Builder.logoUrl] to an arbitrary JSON value. */
                fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

                /** Company name. */
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
                 * Returns an immutable instance of [Company].
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
                fun build(): Company =
                    Company(
                        checkRequired("id", id),
                        logoUrl,
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
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Company = apply {
                if (validated) {
                    return@apply
                }

                id()
                logoUrl()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (logoUrl.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Company &&
                    id == other.id &&
                    logoUrl == other.logoUrl &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, logoUrl, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Company{id=$id, logoUrl=$logoUrl, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Job &&
                id == other.id &&
                url == other.url &&
                account == other.account &&
                applyUrl == other.applyUrl &&
                company == other.company &&
                description == other.description &&
                descriptionMarkdown == other.descriptionMarkdown &&
                employmentType == other.employmentType &&
                featured == other.featured &&
                formattedSalary == other.formattedSalary &&
                jobFunction == other.jobFunction &&
                location == other.location &&
                locationType == other.locationType &&
                postedAt == other.postedAt &&
                salaryCurrencyCode == other.salaryCurrencyCode &&
                salaryInterval == other.salaryInterval &&
                salaryMax == other.salaryMax &&
                salaryMin == other.salaryMin &&
                seniorityLevel == other.seniorityLevel &&
                shortDescription == other.shortDescription &&
                team == other.team &&
                title == other.title &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                url,
                account,
                applyUrl,
                company,
                description,
                descriptionMarkdown,
                employmentType,
                featured,
                formattedSalary,
                jobFunction,
                location,
                locationType,
                postedAt,
                salaryCurrencyCode,
                salaryInterval,
                salaryMax,
                salaryMin,
                seniorityLevel,
                shortDescription,
                team,
                title,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Job{id=$id, url=$url, account=$account, applyUrl=$applyUrl, company=$company, description=$description, descriptionMarkdown=$descriptionMarkdown, employmentType=$employmentType, featured=$featured, formattedSalary=$formattedSalary, jobFunction=$jobFunction, location=$location, locationType=$locationType, postedAt=$postedAt, salaryCurrencyCode=$salaryCurrencyCode, salaryInterval=$salaryInterval, salaryMax=$salaryMax, salaryMin=$salaryMin, seniorityLevel=$seniorityLevel, shortDescription=$shortDescription, team=$team, title=$title, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JobSearchResponse &&
            hasNextPage == other.hasNextPage &&
            jobs == other.jobs &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasNextPage, jobs, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "JobSearchResponse{hasNextPage=$hasNextPage, jobs=$jobs, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
