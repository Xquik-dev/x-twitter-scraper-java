// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.handlers

import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.SseMessage
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class SseHandlerTest {

    @Test
    fun dispatchesEachEventWithItsNameDataAndId() {
        val messages =
            read(
                "id: 42\nevent: tweet.new\ndata: {\"id\":\"42\"}\n\nid: 43\ndata: {\"id\":\"43\"}\n\n"
            )

        assertThat(messages.map { listOf(it.event, it.data, it.id) })
            .containsExactly(
                listOf("tweet.new", "{\"id\":\"42\"}", "42"),
                listOf(null, "{\"id\":\"43\"}", "43"),
            )
    }

    @Test
    fun skipsCommentsAndKeepAlivesAfterAnEventWithAnId() {
        val messages = read(": connected\n\nid: 7\ndata: 1\n\n: keep-alive\n\n: keep-alive\n\n")

        assertThat(messages.map { it.data }).containsExactly("1")
    }

    @Test
    fun joinsDataLinesAndReadsFieldsWithoutASpaceOrAValue() {
        val messages = read("data:first\ndata\ndata: third\nevent\n\n")

        assertThat(messages.map { listOf(it.event, it.data) })
            .containsExactly(listOf("", "first\n\nthird"))
    }

    @Test
    fun readsCarriageReturnLineEndingsAndKeepsTheLastIdAcrossEvents() {
        val messages =
            read("id: 9\r\ndata: a\r\n\r\ndata: b\r\n\r\nid: x\u0000y\r\ndata: c\r\n\r\n")

        assertThat(messages.map { listOf(it.data, it.id) })
            .containsExactly(listOf("a", "9"), listOf("b", "9"), listOf("c", "9"))
    }

    @Test
    fun readsBareCarriageReturnLineEndings() {
        val messages = read("id: 5\rdata: a\r\rdata: b\r\r")

        assertThat(messages.map { listOf(it.data, it.id) })
            .containsExactly(listOf("a", "5"), listOf("b", "5"))
    }

    @Test
    fun ignoresAByteOrderMarkBeforeTheFirstField() {
        val messages = read("\uFEFFdata: first\n\ndata: \uFEFFsecond\n\n")

        assertThat(messages.map { it.data }).containsExactly("first", "\uFEFFsecond")
    }

    @Test
    fun dropsAnEventTheStreamEndsBeforeItsBlankLine() {
        val messages = read("data: done\n\ndata: cut off")

        assertThat(messages.map { it.data }).containsExactly("done")
    }

    @Test
    fun mapsEachEventDataToTheTypeTheCallerAsks() {
        val response = FakeResponse("data: {\"count\":2}\n\n")

        val values =
            sseHandler(jsonMapper()).mapJson<Map<String, Int>>().handle(response).use {
                it.stream().toList()
            }

        assertThat(values).containsExactly(mapOf("count" to 2))
        assertThat(response.closed).isTrue()
    }

    @Test
    fun throwsWhenEventDataIsNotJson() {
        val stream =
            sseHandler(jsonMapper())
                .mapJson<Map<String, Int>>()
                .handle(FakeResponse("data: oops\n\n"))

        assertThatThrownBy { stream.use { it.stream().toList() } }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessage("Error reading response")
    }

    @Test
    fun describesAMessageByItsFields() {
        val message = read("event: ping\nid: 3\ndata: {}\n\n").single()

        assertThat(message.toString()).isEqualTo("SseMessage{event=ping, data={}, id=3}")
    }

    private fun read(body: String): List<SseMessage> =
        sseHandler(jsonMapper()).handle(FakeResponse(body)).use { it.stream().toList() }

    private class FakeResponse(private val body: String) : HttpResponse {

        var closed = false

        override fun statusCode(): Int = 200

        override fun headers(): Headers = Headers.builder().build()

        override fun body(): InputStream = body.byteInputStream()

        override fun close() {
            closed = true
        }
    }
}
