// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorTest {

    @Test
    fun create() {
        val error =
            Error.builder()
                .error(Error.InnerError.LegacyErrorCode.INVALID_INPUT)
                .message("Invalid input. Check the request body.")
                .reason("temporary_issue")
                .retryAfter(60L)
                .retryAfterMs(60000L)
                .build()

        assertThat(error.error())
            .isEqualTo(
                Error.InnerError.ofLegacyErrorCode(Error.InnerError.LegacyErrorCode.INVALID_INPUT)
            )
        assertThat(error.message()).contains("Invalid input. Check the request body.")
        assertThat(error.reason()).contains("temporary_issue")
        assertThat(error.retryAfter()).contains(60L)
        assertThat(error.retryAfterMs()).contains(60000L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val error =
            Error.builder()
                .error(Error.InnerError.LegacyErrorCode.INVALID_INPUT)
                .message("Invalid input. Check the request body.")
                .reason("temporary_issue")
                .retryAfter(60L)
                .retryAfterMs(60000L)
                .build()

        val roundtrippedError =
            jsonMapper.readValue(jsonMapper.writeValueAsString(error), jacksonTypeRef<Error>())

        assertThat(roundtrippedError).isEqualTo(error)
    }

    @Test
    fun readsTheScopeAndUnknownFieldDetails() {
        val error =
            jsonMapper()
                .readValue(
                    """
                    {
                      "error": "unknown_field",
                      "message": "Unknown field author.usrname. Did you mean author.username?",
                      "requiredScope": "write",
                      "allowedFields": ["author.username", "author.name"],
                      "fieldErrors": [
                        {
                          "code": "unknown_field",
                          "field": "author.usrname",
                          "message": "Unknown field author.usrname. Did you mean author.username?",
                          "path": "query.fields",
                          "suggestion": "author.username"
                        }
                      ]
                    }
                    """,
                    jacksonTypeRef<Error>(),
                )

        assertThat(error.requiredScope()).contains(Error.RequiredScope.WRITE)
        assertThat(error.allowedFields().get()).containsExactly("author.username", "author.name")
        val fieldError = error.fieldErrors().get().single()
        assertThat(fieldError.code()).isEqualTo("unknown_field")
        assertThat(fieldError.field()).isEqualTo("author.usrname")
        assertThat(fieldError.message())
            .isEqualTo("Unknown field author.usrname. Did you mean author.username?")
        assertThat(fieldError.path()).isEqualTo(Error.FieldError.Path.QUERY_FIELDS)
        assertThat(fieldError.suggestion()).contains("author.username")
        assertThat(error.isValid()).isTrue()
    }

    @Test
    fun builtScopeAndUnknownFieldDetailsRoundtrip() {
        val jsonMapper = jsonMapper()
        val error =
            Error.builder()
                .error(Error.InnerError.LegacyErrorCode.INVALID_INPUT)
                .requiredScope(Error.RequiredScope.MONITORS)
                .addAllowedField("author.username")
                .addFieldError(
                    Error.FieldError.builder()
                        .code("unknown_field")
                        .field("author.usrname")
                        .message("Unknown field author.usrname. Did you mean author.username?")
                        .path(Error.FieldError.Path.QUERY_OMIT)
                        .build()
                )
                .build()

        val roundtrippedError =
            jsonMapper.readValue(jsonMapper.writeValueAsString(error), jacksonTypeRef<Error>())

        assertThat(roundtrippedError).isEqualTo(error)
        assertThat(roundtrippedError.toBuilder().build()).isEqualTo(error)
        assertThat(roundtrippedError.fieldErrors().get().single().suggestion()).isEmpty
    }
}
