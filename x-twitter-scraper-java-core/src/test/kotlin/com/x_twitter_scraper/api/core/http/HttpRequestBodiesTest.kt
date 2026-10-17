// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.support.tickets.TicketCreateParams
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.services.async.x.MediaServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.ProfileServiceAsyncImpl
import com.x_twitter_scraper.api.services.blocking.x.MediaServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.ProfileServiceImpl
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.Base64
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class HttpRequestBodiesTest {

    private val png =
        Base64.getDecoder()
            .decode(
                "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mP8/x8AAwMCAO+aWQAAAABJRU5ErkJggg=="
            )

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun ticketCreate_serializesAttachmentFiles(addIndividually: Boolean) {
        val params =
            TicketCreateParams.builder()
                .body("Please help")
                .subject("Upload issue")
                .apply {
                    if (addIndividually) {
                        addAttachment(png.inputStream())
                        addAttachment(png.inputStream())
                    } else {
                        attachments(listOf(png.inputStream(), png.inputStream()))
                    }
                }
                .build()
                .toBuilder()
                .build()
        val parts = multipartParts(multipartFormData(jsonMapper(), params._body()))

        assertThat(parts.map { disposition(it.first).getValue("name") })
            .containsExactlyInAnyOrder("body", "subject", "attachments", "attachments")
        parts
            .filter { disposition(it.first)["name"] == "attachments" }
            .forEach {
                assertPngPart(it, "attachments")
            }
    }

    @ParameterizedTest
    @CsvSource(
        "media, false, false",
        "media, false, true",
        "media, true, false",
        "media, true, true",
        "avatar, false, false",
        "avatar, false, true",
        "avatar, true, false",
        "avatar, true, true",
        "banner, false, false",
        "banner, false, true",
        "banner, true, false",
        "banner, true, true",
    )
    fun uploadRequests_useTheInputContentType(route: String, async: Boolean, file: Boolean) {
        val httpClient = CapturingHttpClient()
        val options = ClientOptions.builder().httpClient(httpClient).apiKey("test").build()
        val url = "https://example.com/image.png"

        when (route) {
            "media" -> {
                val params =
                    MediaUploadParams.builder()
                        .account("@example")
                        .idempotencyKey("test")
                        .apply { if (file) file(png.inputStream()) else url(url) }
                        .build()
                if (async) {
                    MediaServiceAsyncImpl(options).withRawResponse().upload(params).get().close()
                } else {
                    MediaServiceImpl(options).withRawResponse().upload(params).close()
                }
            }
            "avatar" -> {
                val params =
                    ProfileUpdateAvatarParams.builder()
                        .account("@example")
                        .idempotencyKey("test")
                        .apply { if (file) file(png.inputStream()) else url(url) }
                        .build()
                if (async) {
                    ProfileServiceAsyncImpl(options)
                        .withRawResponse()
                        .updateAvatar(params)
                        .get()
                        .close()
                } else {
                    ProfileServiceImpl(options).withRawResponse().updateAvatar(params).close()
                }
            }
            "banner" -> {
                val params =
                    ProfileUpdateBannerParams.builder()
                        .account("@example")
                        .idempotencyKey("test")
                        .apply { if (file) file(png.inputStream()) else url(url) }
                        .build()
                if (async) {
                    ProfileServiceAsyncImpl(options)
                        .withRawResponse()
                        .updateBanner(params)
                        .get()
                        .close()
                } else {
                    ProfileServiceImpl(options).withRawResponse().updateBanner(params).close()
                }
            }
            else -> error("Unknown route $route")
        }

        val body = checkNotNull(httpClient.request.body)
        if (file) {
            val parts = multipartParts(body)
            assertThat(parts.map { disposition(it.first).getValue("name") })
                .containsExactlyInAnyOrder("account", "file")
            val account = parts.single { disposition(it.first)["name"] == "account" }
            assertThat(account.first["content-type"]).isEqualTo("text/plain; charset=utf-8")
            assertThat(account.second).isEqualTo("@example")
            assertPngPart(parts.single { disposition(it.first)["name"] == "file" }, "file")
        } else {
            assertThat(body.contentType()).isEqualTo("application/json")
            val output = ByteArrayOutputStream()
            body.writeTo(output)
            assertThat(jsonMapper().readTree(output.toByteArray()))
                .isEqualTo(jsonMapper().readTree("{\"account\":\"@example\",\"url\":\"$url\"}"))
        }
    }

    private fun multipartParts(body: HttpRequestBody): List<Pair<Map<String, String>, String>> {
        assertThat(body.contentType()).startsWith("multipart/form-data; boundary=")
        val boundary = body.contentType()!!.substringAfter("boundary=")
        val output = ByteArrayOutputStream()
        body.writeTo(output)
        return output.toString("ISO-8859-1").split("--$boundary").drop(1).dropLast(1).map {
            val (headers, content) =
                it.removePrefix("\r\n").removeSuffix("\r\n").split("\r\n\r\n", limit = 2)
            headers.split("\r\n").associate { header ->
                header.substringBefore(":").lowercase() to header.substringAfter(":").trim()
            } to content
        }
    }

    @Test
    fun fileParts_preserveCustomMetadata() {
        fun field() =
            MultipartField.builder<InputStream>()
                .value("image".byteInputStream())
                .filename("photo.jpg")
                .contentType("image/jpeg")
                .build()

        val bodies =
            listOf(
                MediaUploadParams.builder()
                    .account("@example")
                    .idempotencyKey("test")
                    .file(field())
                    .build()
                    .toBuilder()
                    .build()
                    ._body(),
                ProfileUpdateAvatarParams.builder()
                    .account("@example")
                    .idempotencyKey("test")
                    .file(field())
                    .build()
                    .toBuilder()
                    .build()
                    ._body(),
                ProfileUpdateBannerParams.builder()
                    .account("@example")
                    .idempotencyKey("test")
                    .file(field())
                    .build()
                    .toBuilder()
                    .build()
                    ._body(),
            )

        bodies.forEach { fields ->
            val part = multipartParts(multipartFormData(jsonMapper(), fields)).last()
            assertThat(disposition(part.first))
                .containsEntry("name", "file")
                .containsEntry("filename", "photo.jpg")
            assertThat(part.first["content-type"]).isEqualTo("image/jpeg")
        }

        val params =
            TicketCreateParams.builder()
                .body("Please help")
                .subject("Upload issue")
                .attachments(
                    MultipartField.builder<List<InputStream>>()
                        .value(listOf("first".byteInputStream()))
                        .filename("photo.jpg")
                        .contentType("image/jpeg")
                        .build()
                )
                .build()
                .toBuilder()
                .addAttachment("second".byteInputStream())
                .build()
        val attachments =
            multipartParts(multipartFormData(jsonMapper(), params._body())).filter {
                disposition(it.first)["name"] == "attachments"
            }
        assertThat(attachments).hasSize(2)
        attachments.forEach {
            assertThat(disposition(it.first))
                .containsEntry("name", "attachments")
                .containsEntry("filename", "photo.jpg")
            assertThat(it.first["content-type"]).isEqualTo("image/jpeg")
        }
    }

    private fun disposition(headers: Map<String, String>): Map<String, String> =
        headers.getValue("content-disposition").split("; ").drop(1).associate {
            it.substringBefore("=") to it.substringAfter("=").removeSurrounding("\"")
        }

    private fun assertPngPart(part: Pair<Map<String, String>, String>, name: String) {
        val disposition = disposition(part.first)
        assertThat(disposition["name"]).isEqualTo(name)
        assertThat(disposition["filename"]).isNotBlank()
        assertThat(part.first["content-type"]).isEqualTo("image/png")
        assertThat(part.second.toByteArray(Charsets.ISO_8859_1)).isEqualTo(png)
    }

    private class CapturingHttpClient : HttpClient {

        lateinit var request: HttpRequest

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            this.request = request
            return object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream = "{}".byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }

    @Test
    fun multipartFormData_omitsMissingFields() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf("file" to MultipartField.of<String>(JsonMissing.of())),
            )
        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(output.toString("UTF-8")).doesNotContain("Content-Disposition")
    }

    @Test
    fun multipartFormData_serializesBinaryAttachments() {
        val field = MultipartField.of(listOf("first".byteInputStream(), "second".byteInputStream()))
        val body = multipartFormData(jsonMapper(), mapOf("attachments" to field))
        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(field.contentType).isEqualTo("application/octet-stream")
        assertThat(output.toString("UTF-8"))
            .contains(
                "name=\"attachments\"",
                "first",
                "second",
                "Content-Type: application/octet-stream",
            )
        assertThat(output.size().toLong()).isEqualTo(body.contentLength())
    }

    @Test
    fun multipartFormData_serializesFieldWithFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "file" to
                        MultipartField.builder<String>()
                            .value("hello")
                            .filename("hello.txt")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(output.size().toLong()).isEqualTo(body.contentLength())
        val boundary = body.contentType()!!.substringAfter("multipart/form-data; boundary=")
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="file"; filename="hello.txt"
                |Content-Type: text/plain
                |
                |hello
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesFieldWithoutFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("value")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(output.size().toLong()).isEqualTo(body.contentLength())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="field"
                |Content-Type: text/plain
                |
                |value
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesInputStream() {
        val inputStream = "stream content".byteInputStream().buffered()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data"
                |Content-Type: application/octet-stream
                |
                |stream content
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesByteArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "binary" to
                        MultipartField.builder<ByteArray>()
                            .value("abc".toByteArray())
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="binary"
                |Content-Type: application/octet-stream
                |
                |abc
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesBooleanValue() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "flag" to
                        MultipartField.builder<Boolean>()
                            .value(true)
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="flag"
                |Content-Type: text/plain
                |
                |true
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNumberValue() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "count" to
                        MultipartField.builder<Int>().value(42).contentType("text/plain").build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="count"
                |Content-Type: text/plain
                |
                |42
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNullValueAsNoParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "present" to
                        MultipartField.builder<String>()
                            .value("yes")
                            .contentType("text/plain")
                            .build(),
                    "absent" to
                        MultipartField.builder<String>()
                            .value(null as String?)
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="present"
                |Content-Type: text/plain
                |
                |yes
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "items" to
                        MultipartField.builder<List<String>>()
                            .value(listOf("alpha", "beta", "gamma"))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="items"
                |Content-Type: text/plain
                |
                |alpha,beta,gamma
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesObjectAsNestedParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "meta" to
                        MultipartField.builder<Map<String, String>>()
                            .value(mapOf("key1" to "val1", "key2" to "val2"))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="meta[key1]"
                |Content-Type: text/plain
                |
                |val1
                |--$boundary
                |Content-Disposition: form-data; name="meta[key2]"
                |Content-Type: text/plain
                |
                |val2
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesMultipleFields() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "name" to
                        MultipartField.builder<String>()
                            .value("Alice")
                            .contentType("text/plain")
                            .build(),
                    "age" to
                        MultipartField.builder<Int>().value(30).contentType("text/plain").build(),
                    "file" to
                        MultipartField.builder<String>()
                            .value("file contents")
                            .filename("doc.txt")
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="name"
                |Content-Type: text/plain
                |
                |Alice
                |--$boundary
                |Content-Disposition: form-data; name="age"
                |Content-Type: text/plain
                |
                |30
                |--$boundary
                |Content-Disposition: form-data; name="file"; filename="doc.txt"
                |Content-Type: text/plain
                |
                |file contents
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_quotesSpecialCharactersInNameAndFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field\nname" to
                        MultipartField.builder<String>()
                            .value("value")
                            .filename("file\r\"name.txt")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="field%0Aname"; filename="file%0D%22name.txt"
                |Content-Type: text/plain
                |
                |value
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_writeIsRepeatable() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("repeatable")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output1 = ByteArrayOutputStream()
        body.writeTo(output1)
        val output2 = ByteArrayOutputStream()
        body.writeTo(output2)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output1.size().toLong())
        val boundary = boundary(body)
        val expected =
            """
            |--$boundary
            |Content-Disposition: form-data; name="field"
            |Content-Type: text/plain
            |
            |repeatable
            |--$boundary--
            |
            """
                .trimMargin()
                .replace("\n", "\r\n")
        assertThat(output1.toString("UTF-8")).isEqualTo(expected)
        assertThat(output2.toString("UTF-8")).isEqualTo(expected)
    }

    @Test
    fun multipartFormData_serializesByteArrayInputStream() {
        val inputStream = "byte array stream".byteInputStream()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data"
                |Content-Type: application/octet-stream
                |
                |byte array stream
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesInputStreamWithFilename() {
        val inputStream = "file data".byteInputStream().buffered()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "upload" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .filename("upload.bin")
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="upload"; filename="upload.bin"
                |Content-Type: application/octet-stream
                |
                |file data
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNestedArrayInObject() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<Map<String, List<String>>>()
                            .value(mapOf("tags" to listOf("a", "b")))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data[tags]"
                |Content-Type: text/plain
                |
                |a,b
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_contentLengthIsUnknownWhenInputStreamPresent() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "text" to
                        MultipartField.builder<String>()
                            .value("hello")
                            .contentType("text/plain")
                            .build(),
                    "stream" to
                        MultipartField.builder<InputStream>()
                            .value("data".byteInputStream().buffered())
                            .contentType("application/octet-stream")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="text"
                |Content-Type: text/plain
                |
                |hello
                |--$boundary
                |Content-Disposition: form-data; name="stream"
                |Content-Type: application/octet-stream
                |
                |data
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesEmptyArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "required" to
                        MultipartField.builder<String>()
                            .value("present")
                            .contentType("text/plain")
                            .build(),
                    "items" to
                        MultipartField.builder<List<String>>()
                            .value(emptyList())
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="required"
                |Content-Type: text/plain
                |
                |present
                |--$boundary
                |Content-Disposition: form-data; name="items"
                |Content-Type: text/plain
                |
                |
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesEmptyObject() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "required" to
                        MultipartField.builder<String>()
                            .value("present")
                            .contentType("text/plain")
                            .build(),
                    "meta" to
                        MultipartField.builder<Map<String, String>>()
                            .value(emptyMap())
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="required"
                |Content-Type: text/plain
                |
                |present
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    private fun boundary(body: HttpRequestBody): String =
        body.contentType()!!.substringAfter("multipart/form-data; boundary=")
}
