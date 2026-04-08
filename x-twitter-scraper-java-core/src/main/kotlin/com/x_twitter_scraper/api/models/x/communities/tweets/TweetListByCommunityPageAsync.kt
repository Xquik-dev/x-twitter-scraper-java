// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities.tweets

import com.x_twitter_scraper.api.core.AutoPagerAsync
import com.x_twitter_scraper.api.core.PageAsync
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.services.async.x.communities.TweetServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see TweetServiceAsync.listByCommunity */
class TweetListByCommunityPageAsync
private constructor(
    private val service: TweetServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TweetListByCommunityParams,
    private val response: PaginatedTweets,
) : PageAsync<PaginatedTweets> {

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

    fun nextPageParams(): TweetListByCommunityParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<TweetListByCommunityPageAsync> =
        service.listByCommunity(nextPageParams())

    fun autoPager(): AutoPagerAsync<PaginatedTweets> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TweetListByCommunityParams = params

    /** The response that this page was parsed from. */
    fun response(): PaginatedTweets = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [TweetListByCommunityPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetListByCommunityPageAsync]. */
    class Builder internal constructor() {

        private var service: TweetServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TweetListByCommunityParams? = null
        private var response: PaginatedTweets? = null

        @JvmSynthetic
        internal fun from(tweetListByCommunityPageAsync: TweetListByCommunityPageAsync) = apply {
            service = tweetListByCommunityPageAsync.service
            streamHandlerExecutor = tweetListByCommunityPageAsync.streamHandlerExecutor
            params = tweetListByCommunityPageAsync.params
            response = tweetListByCommunityPageAsync.response
        }

        fun service(service: TweetServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TweetListByCommunityParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PaginatedTweets) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TweetListByCommunityPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetListByCommunityPageAsync =
            TweetListByCommunityPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetListByCommunityPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "TweetListByCommunityPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
