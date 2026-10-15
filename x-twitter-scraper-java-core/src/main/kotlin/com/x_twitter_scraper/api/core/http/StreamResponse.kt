// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import java.util.stream.Stream

interface StreamResponse<T> : AutoCloseable {

    fun stream(): Stream<T>

    override fun close()
}

@JvmSynthetic
internal fun <T, R> StreamResponse<T>.map(transform: (T) -> R): StreamResponse<R> =
    MappedStreamResponse(this, transform)

private class MappedStreamResponse<T, R>(
    private val response: StreamResponse<T>,
    private val transform: (T) -> R,
) : StreamResponse<R> {

    override fun stream(): Stream<R> = response.stream().map(transform)

    override fun close() = response.close()
}
