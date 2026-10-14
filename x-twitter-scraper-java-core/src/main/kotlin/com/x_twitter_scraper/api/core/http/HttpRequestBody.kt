// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import java.io.OutputStream
import java.lang.AutoCloseable

interface HttpRequestBody : AutoCloseable {

    fun writeTo(outputStream: OutputStream)

    fun contentType(): String?

    fun contentLength(): Long

    /** Determines if a request can be repeated in a meaningful way. */
    fun repeatable(): Boolean

    override fun close()
}
