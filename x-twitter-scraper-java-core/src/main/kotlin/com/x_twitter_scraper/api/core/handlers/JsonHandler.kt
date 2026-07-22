@file:JvmName("JsonHandler")

package com.x_twitter_scraper.api.core.handlers

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.json.JsonMapper
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), object : TypeReference<T>() {})
            } catch (e: Exception) {
                throw XTwitterScraperInvalidDataException("Error reading response", e)
            }
    }
