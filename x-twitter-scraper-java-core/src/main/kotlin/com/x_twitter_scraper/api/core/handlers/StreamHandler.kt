// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

@file:JvmName("StreamHandler")

package com.x_twitter_scraper.api.core.handlers

import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.PhantomReachableClosingStreamResponse
import com.x_twitter_scraper.api.core.http.StreamResponse
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Stream
import kotlin.streams.asStream

@JvmSynthetic
internal fun <T> streamHandler(
    block: suspend SequenceScope<T>.(response: HttpResponse, lines: Sequence<String>) -> Unit
): Handler<StreamResponse<T>> = LineStreamHandler(block)

private class LineStreamHandler<T>(
    private val block:
        suspend SequenceScope<T>.(response: HttpResponse, lines: Sequence<String>) -> Unit
) : Handler<StreamResponse<T>> {

    override fun handle(response: HttpResponse): StreamResponse<T> {
        val lines = ResponseLines(response)
        val values = sequence {
            try {
                block(response, lines.asSequence())
            } finally {
                lines.release()
            }
        }
            .constrainOnce()
        return PhantomReachableClosingStreamResponse(LineStreamResponse(values, lines))
    }
}

private class LineStreamResponse<T>(
    private val values: Sequence<T>,
    private val lines: ResponseLines,
) : StreamResponse<T> {

    override fun stream(): Stream<T> = values.asStream()

    override fun close() = lines.close()
}

private class ResponseLines(private val response: HttpResponse) : Iterator<String> {

    private val lines = response.body().bufferedReader().lineSequence().iterator()
    @Volatile private var closed = false
    @Volatile private var reading = false
    private val released = AtomicBoolean(false)

    override fun hasNext(): Boolean {
        reading = true
        try {
            return !closed && lines.hasNext()
        } catch (e: Exception) {
            if (!closed) {
                throw e
            }
            return false
        } finally {
            reading = false
            if (closed) {
                release()
            }
        }
    }

    override fun next(): String = lines.next()

    fun close() {
        closed = true
        if (!reading) {
            release()
        }
    }

    fun release() {
        if (released.compareAndSet(false, true)) {
            response.close()
        }
    }
}
