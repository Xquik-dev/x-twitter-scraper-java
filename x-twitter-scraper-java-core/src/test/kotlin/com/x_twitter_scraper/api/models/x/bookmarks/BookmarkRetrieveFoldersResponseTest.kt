// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.bookmarks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkRetrieveFoldersResponseTest {

    @Test
    fun create() {
        val bookmarkRetrieveFoldersResponse =
            BookmarkRetrieveFoldersResponse.builder()
                .addFolder(
                    BookmarkRetrieveFoldersResponse.Folder.builder()
                        .id("1234567890")
                        .name("Read Later")
                        .build()
                )
                .hasNextPage(false)
                .nextCursor("")
                .build()

        assertThat(bookmarkRetrieveFoldersResponse.folders())
            .containsExactly(
                BookmarkRetrieveFoldersResponse.Folder.builder()
                    .id("1234567890")
                    .name("Read Later")
                    .build()
            )
        assertThat(bookmarkRetrieveFoldersResponse.hasNextPage()).isEqualTo(false)
        assertThat(bookmarkRetrieveFoldersResponse.nextCursor()).isEqualTo("")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bookmarkRetrieveFoldersResponse =
            BookmarkRetrieveFoldersResponse.builder()
                .addFolder(
                    BookmarkRetrieveFoldersResponse.Folder.builder()
                        .id("1234567890")
                        .name("Read Later")
                        .build()
                )
                .hasNextPage(false)
                .nextCursor("")
                .build()

        val roundtrippedBookmarkRetrieveFoldersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bookmarkRetrieveFoldersResponse),
                jacksonTypeRef<BookmarkRetrieveFoldersResponse>(),
            )

        assertThat(roundtrippedBookmarkRetrieveFoldersResponse)
            .isEqualTo(bookmarkRetrieveFoldersResponse)
    }

    @Test
    fun additionalFolderMediaFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"sample","mediaId":"sample","mediaKey":"sample","originalImageHeight":1,"originalImageUrl":"sample","originalImageWidth":1,"palette":[{}],"type":"sample"}"""
        val model =
            jsonMapper.readValue(
                json,
                jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media>(),
            )

        assertThat(model.id()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("id")
        assertThat(model.mediaId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("mediaId")
        assertThat(model.mediaKey()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("mediaKey")
        assertThat(model.originalImageHeight()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("originalImageHeight")
        assertThat(model.originalImageUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("originalImageUrl")
        assertThat(model.originalImageWidth()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("originalImageWidth")
        assertThat(model.palette()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("palette")
        assertThat(model.type()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("type")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFolderMediaPaletteFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"percentage":1.0,"rgb":{}}"""
        val model =
            jsonMapper.readValue(
                json,
                jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media.Palette>(),
            )

        assertThat(model.percentage()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("percentage")
        assertThat(model.rgb()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("rgb")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media.Palette>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFolderMediaPaletteRgbFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"blue":1.0,"green":1.0,"red":1.0}"""
        val model =
            jsonMapper.readValue(
                json,
                jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media.Palette.Rgb>(),
            )

        assertThat(model.blue()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("blue")
        assertThat(model.green()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("green")
        assertThat(model.red()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("red")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder.Media.Palette.Rgb>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFolderFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"media":{}}"""
        val model =
            jsonMapper.readValue(json, jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder>())

        assertThat(model.media()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("media")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<BookmarkRetrieveFoldersResponse.Folder>(),
                )
            )
            .isEqualTo(model)
    }
}
