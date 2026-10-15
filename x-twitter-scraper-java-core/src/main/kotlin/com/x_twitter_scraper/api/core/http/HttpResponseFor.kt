// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

interface HttpResponseFor<T> : HttpResponse {

    fun parse(): T
}

@JvmSynthetic
internal fun <T> HttpResponse.parseable(parse: () -> T): HttpResponseFor<T> =
    ParseableHttpResponse(this, parse)

private class ParseableHttpResponse<T>(response: HttpResponse, parse: () -> T) :
    HttpResponseFor<T>, HttpResponse by response {

    private val parsed: T by lazy(parse)

    override fun parse(): T = parsed
}
