// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core

import java.time.Duration
import java.util.concurrent.CompletableFuture

/** An interface for delaying execution for a specified amount of time. */
interface Sleeper : AutoCloseable {

    /** Synchronously pauses execution for the given [duration]. */
    fun sleep(duration: Duration)

    /** Asynchronously pauses execution for the given [duration]. */
    fun sleepAsync(duration: Duration): CompletableFuture<Void>

    override fun close()
}
