// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.LoopbackTestServer
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RawResponseMetadataTest {
    @Test
    fun rawResponsesExposeReadableGenericTypes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(LoopbackTestServer.baseUrl())
                .apiKey("test-only")
                .build()
        try {
            client.credits().withRawResponse().retrieveBalance().use { response ->
                response.javaClass.declaredConstructors.forEach { constructor ->
                    constructor.genericParameterTypes.forEach { type ->
                        assertThat(type.typeName).isNotBlank()
                    }
                }
            }
        } finally {
            client.close()
        }
    }
}
