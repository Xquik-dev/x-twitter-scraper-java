// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.spaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpaceRetrieveReplayResponseTest {

    @Test
    fun create() {
        val spaceRetrieveReplayResponse =
            SpaceRetrieveReplayResponse.builder()
                .replay(
                    SpaceRetrieveReplayResponse.Replay.builder()
                        .url(
                            "https://prod-fastly-us-east-1.video.pscp.tv/Transcoding/v1/hls/example/audio-space/playlist.m3u8?type=replay"
                        )
                        .status("LIVE_PUBLIC")
                        .streamType("HLS")
                        .build()
                )
                .build()

        assertThat(spaceRetrieveReplayResponse.replay())
            .isEqualTo(
                SpaceRetrieveReplayResponse.Replay.builder()
                    .url(
                        "https://prod-fastly-us-east-1.video.pscp.tv/Transcoding/v1/hls/example/audio-space/playlist.m3u8?type=replay"
                    )
                    .status("LIVE_PUBLIC")
                    .streamType("HLS")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val spaceRetrieveReplayResponse =
            SpaceRetrieveReplayResponse.builder()
                .replay(
                    SpaceRetrieveReplayResponse.Replay.builder()
                        .url(
                            "https://prod-fastly-us-east-1.video.pscp.tv/Transcoding/v1/hls/example/audio-space/playlist.m3u8?type=replay"
                        )
                        .status("LIVE_PUBLIC")
                        .streamType("HLS")
                        .build()
                )
                .build()

        val roundtrippedSpaceRetrieveReplayResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(spaceRetrieveReplayResponse),
                jacksonTypeRef<SpaceRetrieveReplayResponse>(),
            )

        assertThat(roundtrippedSpaceRetrieveReplayResponse).isEqualTo(spaceRetrieveReplayResponse)
    }
}
