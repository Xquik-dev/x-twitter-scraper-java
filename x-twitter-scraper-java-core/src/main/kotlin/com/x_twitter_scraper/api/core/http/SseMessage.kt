// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.json.JsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

internal class SseMessage(
    val jsonMapper: JsonMapper,
    val event: String?,
    val data: String,
    val id: String?,
) {

    inline fun <reified T> json(): T =
        try {
            jsonMapper.readValue(data, object : TypeReference<T>() {})
        } catch (e: Exception) {
            throw XTwitterScraperInvalidDataException("Error reading response", e)
        }

    override fun toString() = "SseMessage{event=$event, data=$data, id=$id}"
}
