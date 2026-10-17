// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

@file:JvmName("HttpRequestBodies")

package com.x_twitter_scraper.api.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@JvmSynthetic
internal inline fun <reified T> json(jsonMapper: JsonMapper, value: T): HttpRequestBody =
    object : HttpRequestBody {
        private val lazyBytes: Lazy<ByteArray> = lazy { jsonMapper.writeValueAsBytes(value) }

        private val bytes: ByteArray
            get() = lazyBytes.value

        override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

        override fun contentType(): String = "application/json"

        override fun contentLength(): Long = bytes.size.toLong()

        override fun repeatable(): Boolean = true

        override fun close() {}
    }

@JvmSynthetic
internal fun uploadFile(file: InputStream): MultipartField<InputStream> {
    val stream = if (file.markSupported()) file else BufferedInputStream(file, 12)
    val header = ByteArray(12)
    stream.mark(header.size)
    var size = 0
    try {
        while (size < header.size) {
            val next = stream.read()
            if (next == -1) break
            header[size++] = next.toByte()
        }
    } finally {
        stream.reset()
    }

    fun matches(offset: Int, signature: String): Boolean =
        size >= offset + signature.length &&
            signature.indices.all { header[offset + it] == signature[it].code.toByte() }

    val (contentType, filename) =
        when {
            matches(0, "\u0089PNG\r\n\u001a\n") -> "image/png" to "upload.png"
            matches(0, "\u00ff\u00d8\u00ff") -> "image/jpeg" to "upload.jpg"
            matches(0, "GIF87a") || matches(0, "GIF89a") -> "image/gif" to "upload.gif"
            matches(0, "RIFF") && matches(8, "WEBP") -> "image/webp" to "upload.webp"
            size >= 12 && matches(4, "ftyp") ->
                if (matches(8, "avif") || matches(8, "avis")) "image/avif" to "upload.avif"
                else "video/mp4" to "upload.mp4"
            else -> "application/octet-stream" to "upload"
        }
    return MultipartField.builder<InputStream>()
        .value(stream)
        .filename(filename)
        .contentType(contentType)
        .build()
}

@JvmSynthetic
internal fun multipartFormData(
    jsonMapper: JsonMapper,
    fields: Map<String, MultipartField<*>>,
): HttpRequestBody =
    MultipartBody.Builder()
        .apply {
            fields.forEach { (name, field) ->
                if (field.value.isMissing()) {
                    return@forEach
                }
                val knownValue = field.value.asKnown().getOrNull()
                val parts =
                    if (knownValue is InputStream) {
                        sequenceOf(name to knownValue)
                    } else if (
                        knownValue is List<*> &&
                            knownValue.isNotEmpty() &&
                            knownValue.all { it is InputStream }
                    ) {
                        knownValue.asSequence().map { name to it as InputStream }
                    } else {
                        val node = jsonMapper.valueToTree<JsonNode>(field.value)
                        serializePart(name, node)
                    }

                parts.forEach { (name, bytes) ->
                    val partBody =
                        if (bytes is ByteArrayInputStream) {
                            val byteArray = bytes.readBytes()

                            object : HttpRequestBody {

                                override fun writeTo(outputStream: OutputStream) {
                                    outputStream.write(byteArray)
                                }

                                override fun contentType(): String = field.contentType

                                override fun contentLength(): Long = byteArray.size.toLong()

                                override fun repeatable(): Boolean = true

                                override fun close() {}
                            }
                        } else {
                            object : HttpRequestBody {

                                override fun writeTo(outputStream: OutputStream) {
                                    bytes.copyTo(outputStream)
                                }

                                override fun contentType(): String = field.contentType

                                override fun contentLength(): Long = -1L

                                override fun repeatable(): Boolean = false

                                override fun close() = bytes.close()
                            }
                        }

                    addPart(
                        MultipartBody.Part.create(
                            name,
                            field.filename().getOrNull(),
                            field.contentType,
                            partBody,
                        )
                    )
                }
            }
        }
        .build()

private fun serializePart(name: String, node: JsonNode): Sequence<Pair<String, InputStream>> =
    when (node.nodeType) {
        JsonNodeType.MISSING,
        JsonNodeType.NULL -> emptySequence()
        JsonNodeType.BINARY -> sequenceOf(name to node.binaryValue().inputStream())
        JsonNodeType.STRING -> sequenceOf(name to node.textValue().byteInputStream())
        JsonNodeType.BOOLEAN -> sequenceOf(name to node.booleanValue().toString().byteInputStream())
        JsonNodeType.NUMBER -> sequenceOf(name to node.numberValue().toString().byteInputStream())
        JsonNodeType.ARRAY ->
            sequenceOf(
                name to
                    node
                        .elements()
                        .asSequence()
                        .mapNotNull { element ->
                            when (element.nodeType) {
                                JsonNodeType.MISSING,
                                JsonNodeType.NULL -> null
                                JsonNodeType.STRING -> element.textValue()
                                JsonNodeType.BOOLEAN -> element.booleanValue().toString()
                                JsonNodeType.NUMBER -> element.numberValue().toString()
                                null,
                                JsonNodeType.BINARY,
                                JsonNodeType.ARRAY,
                                JsonNodeType.OBJECT,
                                JsonNodeType.POJO ->
                                    throw XTwitterScraperInvalidDataException(
                                        "Unexpected JsonNode type in array: ${element.nodeType}"
                                    )
                            }
                        }
                        .joinToString(",")
                        .byteInputStream()
            )
        JsonNodeType.OBJECT ->
            node.properties().asSequence().flatMap { (key, value) ->
                serializePart("$name[$key]", value)
            }
        JsonNodeType.POJO,
        null ->
            throw XTwitterScraperInvalidDataException("Unexpected JsonNode type: ${node.nodeType}")
    }

private class MultipartBody
private constructor(private val boundary: String, private val parts: List<Part>) : HttpRequestBody {
    private val boundaryBytes: ByteArray = boundary.toByteArray()
    private val contentType = "multipart/form-data; boundary=$boundary"

    override fun writeTo(outputStream: OutputStream) {
        parts.forEach { part ->
            outputStream.write(DASHDASH)
            outputStream.write(boundaryBytes)
            outputStream.write(CRLF)

            outputStream.write(CONTENT_DISPOSITION)
            outputStream.write(part.contentDisposition.toByteArray())
            outputStream.write(CRLF)

            outputStream.write(CONTENT_TYPE)
            outputStream.write(part.contentType.toByteArray())
            outputStream.write(CRLF)

            outputStream.write(CRLF)
            part.body.writeTo(outputStream)
            outputStream.write(CRLF)
        }

        outputStream.write(DASHDASH)
        outputStream.write(boundaryBytes)
        outputStream.write(DASHDASH)
        outputStream.write(CRLF)
    }

    override fun contentType(): String = contentType

    override fun contentLength(): Long {
        var byteCount = 0L

        parts.forEach { part ->
            val contentLength = part.body.contentLength()
            if (contentLength == -1L) {
                return -1L
            }

            byteCount +=
                DASHDASH.size +
                    boundaryBytes.size +
                    CRLF.size +
                    CONTENT_DISPOSITION.size +
                    part.contentDisposition.toByteArray().size +
                    CRLF.size +
                    CONTENT_TYPE.size +
                    part.contentType.toByteArray().size +
                    CRLF.size +
                    CRLF.size +
                    contentLength +
                    CRLF.size
        }

        byteCount += DASHDASH.size + boundaryBytes.size + DASHDASH.size + CRLF.size
        return byteCount
    }

    override fun repeatable(): Boolean = parts.all { it.body.repeatable() }

    override fun close() {
        parts.forEach { it.body.close() }
    }

    class Builder {
        private val boundary = UUID.randomUUID().toString()
        private val parts: MutableList<Part> = mutableListOf()

        fun addPart(part: Part) = apply { parts.add(part) }

        fun build() = MultipartBody(boundary, parts.toImmutable())
    }

    class Part
    private constructor(
        val contentDisposition: String,
        val contentType: String,
        val body: HttpRequestBody,
    ) {
        companion object {
            fun create(
                name: String,
                filename: String?,
                contentType: String,
                body: HttpRequestBody,
            ): Part {
                val disposition = buildString {
                    append("form-data; name=")
                    appendQuotedString(name)
                    if (filename != null) {
                        append("; filename=")
                        appendQuotedString(filename)
                    }
                }
                return Part(disposition, contentType, body)
            }
        }
    }

    companion object {
        private val CRLF = byteArrayOf('\r'.code.toByte(), '\n'.code.toByte())
        private val DASHDASH = byteArrayOf('-'.code.toByte(), '-'.code.toByte())
        private val CONTENT_DISPOSITION = "Content-Disposition: ".toByteArray()
        private val CONTENT_TYPE = "Content-Type: ".toByteArray()

        private fun StringBuilder.appendQuotedString(key: String) {
            append('"')
            for (ch in key) {
                when (ch) {
                    '\n' -> append("%0A")
                    '\r' -> append("%0D")
                    '"' -> append("%22")
                    else -> append(ch)
                }
            }
            append('"')
        }
    }
}
