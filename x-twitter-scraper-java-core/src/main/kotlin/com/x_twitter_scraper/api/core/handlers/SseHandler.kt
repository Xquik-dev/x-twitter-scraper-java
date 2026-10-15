// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

@file:JvmName("SseHandler")

package com.x_twitter_scraper.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.SseMessage
import com.x_twitter_scraper.api.core.http.StreamResponse
import com.x_twitter_scraper.api.core.http.map

@JvmSynthetic
internal fun sseHandler(jsonMapper: JsonMapper): Handler<StreamResponse<SseMessage>> =
    streamHandler { _, lines ->
        val state = SseState(jsonMapper)
        for ((index, line) in lines.withIndex()) {
            state.decode(if (index == 0) line.removePrefix("\uFEFF") else line)?.let { yield(it) }
        }
    }

@JvmSynthetic
internal inline fun <reified T> Handler<StreamResponse<SseMessage>>.mapJson():
    Handler<StreamResponse<T>> {
    val messages = this
    return object : Handler<StreamResponse<T>> {
        override fun handle(response: HttpResponse): StreamResponse<T> =
            messages.handle(response).map { it.json<T>() }
    }
}

// https://html.spec.whatwg.org/multipage/server-sent-events.html#event-stream-interpretation
private class SseState(private val jsonMapper: JsonMapper) {

    private var event: String? = null
    private val data = mutableListOf<String>()
    private var lastId: String? = null

    fun decode(line: String): SseMessage? {
        if (line.isEmpty()) {
            return dispatch()
        }
        if (line.startsWith(':')) {
            return null
        }
        val colon = line.indexOf(':')
        val field = if (colon == -1) line else line.substring(0, colon)
        val value = if (colon == -1) "" else line.substring(colon + 1).removePrefix(" ")
        when (field) {
            "event" -> event = value
            "data" -> data.add(value)
            "id" -> if (!value.contains('\u0000')) lastId = value
        }
        return null
    }

    private fun dispatch(): SseMessage? {
        val message =
            if (data.isEmpty()) null
            else SseMessage(jsonMapper, event, data.joinToString("\n"), lastId)
        event = null
        data.clear()
        return message
    }
}
