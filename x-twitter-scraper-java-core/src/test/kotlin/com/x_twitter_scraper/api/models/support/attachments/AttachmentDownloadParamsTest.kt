// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.attachments

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttachmentDownloadParamsTest {

    @Test
    fun create() {
        AttachmentDownloadParams.builder()
            .id("att_a1b2c3d4e5f6a1b2c3d4e5f6")
            .range("bytes=0-1048575")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AttachmentDownloadParams.builder().id("att_a1b2c3d4e5f6a1b2c3d4e5f6").build()

        assertThat(params._pathParam(0)).isEqualTo("att_a1b2c3d4e5f6a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            AttachmentDownloadParams.builder()
                .id("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                .range("bytes=0-1048575")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().put("Range", "bytes=0-1048575").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = AttachmentDownloadParams.builder().id("att_a1b2c3d4e5f6a1b2c3d4e5f6").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
