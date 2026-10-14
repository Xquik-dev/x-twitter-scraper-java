// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.core.closeWhenPhantomReachable
import com.x_twitter_scraper.api.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

internal class PhantomReachableClosingAsyncStreamResponse<T>(
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : AsyncStreamResponse<T> {

    private val reachabilityTracker = Any()

    init {
        closeWhenPhantomReachable(reachabilityTracker, asyncStreamResponse::close)
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> = apply {
        asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker))
    }

    override fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T> =
        apply {
            asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker), executor)
        }

    override fun onCompleteFuture(): CompletableFuture<Void?> =
        asyncStreamResponse.onCompleteFuture()

    override fun close() = asyncStreamResponse.close()
}

private class TrackedHandler<T>(
    private val handler: Handler<T>,
    private val reachabilityTracker: Any,
) : Handler<T> {
    override fun onNext(value: T) = handler.onNext(value)

    override fun onComplete(error: Optional<Throwable>) = handler.onComplete(error)
}
