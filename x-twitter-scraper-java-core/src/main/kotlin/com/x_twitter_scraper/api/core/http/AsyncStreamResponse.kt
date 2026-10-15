// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference

/**
 * A class providing access to an API response as an asynchronous stream of chunks of type [T],
 * where each chunk can be individually processed as soon as it arrives instead of waiting on the
 * full response.
 */
interface AsyncStreamResponse<T> {

    /**
     * Registers [handler] to be called for events of this stream.
     *
     * [handler]'s methods will be called in the client's configured or default thread pool.
     *
     * @throws IllegalStateException if [subscribe] has already been called.
     */
    fun subscribe(handler: Handler<T>): AsyncStreamResponse<T>

    /**
     * Registers [handler] to be called for events of this stream.
     *
     * [handler]'s methods will be called in the given [executor].
     *
     * @throws IllegalStateException if [subscribe] has already been called.
     */
    fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T>

    /**
     * Returns a future that completes when a stream is fully consumed, errors, or gets closed
     * early.
     */
    fun onCompleteFuture(): CompletableFuture<Void?>

    /** Closes this resource, relinquishing any underlying resources. */
    fun close()

    /** A class for handling streaming events. */
    fun interface Handler<in T> {

        /** Called whenever a chunk is received. */
        fun onNext(value: T)

        /**
         * Called when a stream is fully consumed, errors, or gets closed early.
         *
         * [onNext] will not be called once this method is called.
         *
         * @param error Non-empty if the stream completed due to an error.
         */
        fun onComplete(error: Optional<Throwable>) {}
    }
}

@JvmSynthetic
internal fun <T> CompletableFuture<StreamResponse<T>>.toAsync(streamHandlerExecutor: Executor) =
    PhantomReachableClosingAsyncStreamResponse(
        FutureAsyncStreamResponse(this, streamHandlerExecutor)
    )

private class FutureAsyncStreamResponse<T>(
    private val streamResponseFuture: CompletableFuture<StreamResponse<T>>,
    private val streamHandlerExecutor: Executor,
) : AsyncStreamResponse<T> {

    private val onCompleteFuture = CompletableFuture<Void?>()
    private val state = AtomicReference(State.NEW)

    init {
        streamResponseFuture.whenComplete { _, error ->
            error?.let(onCompleteFuture::completeExceptionally)
        }
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> =
        subscribe(handler, streamHandlerExecutor)

    override fun subscribe(
        handler: Handler<T>,
        executor: Executor,
    ): AsyncStreamResponse<T> = apply {
        check(state.compareAndSet(State.NEW, State.SUBSCRIBED)) {
            if (state.get() == State.SUBSCRIBED) "Cannot subscribe more than once"
            else "Cannot subscribe after the response is closed"
        }

        streamResponseFuture.whenCompleteAsync(
            { streamResponse, futureError ->
                if (state.get() == State.CLOSED) {
                    return@whenCompleteAsync
                }

                if (futureError != null) {
                    handler.onComplete(Optional.of(futureError))
                    return@whenCompleteAsync
                }

                var streamError: Throwable? = null
                try {
                    streamResponse.stream().forEach(handler::onNext)
                } catch (e: Throwable) {
                    streamError = e
                }

                try {
                    handler.onComplete(Optional.ofNullable(streamError))
                } finally {
                    try {
                        if (streamError == null) {
                            onCompleteFuture.complete(null)
                        } else {
                            onCompleteFuture.completeExceptionally(streamError)
                        }
                    } finally {
                        close()
                    }
                }
            },
            executor,
        )
    }

    override fun onCompleteFuture(): CompletableFuture<Void?> = onCompleteFuture

    override fun close() {
        val previousState = state.getAndSet(State.CLOSED)
        if (previousState == State.CLOSED) {
            return
        }

        streamResponseFuture.whenComplete { streamResponse, error -> streamResponse?.close() }
        onCompleteFuture.complete(null)
    }
}

private enum class State {
    NEW,
    SUBSCRIBED,
    CLOSED,
}
