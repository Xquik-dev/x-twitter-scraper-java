// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.bookmarks

import com.x_twitter_scraper.api.core.AutoPager
import com.x_twitter_scraper.api.core.Page
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.services.blocking.x.BookmarkService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see BookmarkService.list */
class BookmarkListPage
private constructor(
    private val service: BookmarkService,
    private val params: BookmarkListParams,
    private val response: PaginatedTweets,
) : Page<PaginatedTweets> {

    /**
     * Delegates to [PaginatedTweets], but gracefully handles missing data.
     *
     * @see PaginatedTweets.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    /**
     * Delegates to [PaginatedTweets], but gracefully handles missing data.
     *
     * @see PaginatedTweets.hasNextPage
     */
    fun hasNextPageRaw(): Optional<Boolean> = response._hasNextPage().getOptional("has_next_page")

    override fun items(): List<PaginatedTweets> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): BookmarkListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): BookmarkListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<PaginatedTweets> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BookmarkListParams = params

    /** The response that this page was parsed from. */
    fun response(): PaginatedTweets = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BookmarkListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BookmarkListPage]. */
    class Builder internal constructor() {

        private var service: BookmarkService? = null
        private var params: BookmarkListParams? = null
        private var response: PaginatedTweets? = null

        @JvmSynthetic
        internal fun from(bookmarkListPage: BookmarkListPage) = apply {
            service = bookmarkListPage.service
            params = bookmarkListPage.params
            response = bookmarkListPage.response
        }

        fun service(service: BookmarkService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BookmarkListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PaginatedTweets) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BookmarkListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BookmarkListPage =
            BookmarkListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BookmarkListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BookmarkListPage{service=$service, params=$params, response=$response}"
}
