// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import java.io.InputStream

interface HttpResponseFor<T> : HttpResponse {

    fun parse(): T
}

@JvmSynthetic
internal fun <T> HttpResponse.parseable(parse: () -> T): HttpResponseFor<T> =
    object : HttpResponseFor<T> {

        // A plain Lazy field, not `by lazy`. CodeQL cannot read a delegated property in an
        // anonymous object of a generic function, so it would scan this file only in part.
        private val lazyParsed: Lazy<T> = lazy { parse() }

        private val parsed: T
            get() = lazyParsed.value

        override fun parse(): T = parsed

        override fun statusCode(): Int = this@parseable.statusCode()

        override fun headers(): Headers = this@parseable.headers()

        override fun body(): InputStream = this@parseable.body()

        override fun close() = this@parseable.close()
    }
