// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communitynotes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityNoteRetrieveContributorResponseTest {

    @Test
    fun create() {
        val communityNoteRetrieveContributorResponse =
            CommunityNoteRetrieveContributorResponse.builder()
                .contributor(
                    CommunityNoteRetrieveContributorResponse.Contributor.builder()
                        .alias("ardent-beach-friarbird")
                        .deletedNotesCount(0L)
                        .isApiContributor(false)
                        .isTopWriter(false)
                        .notesCount(
                            CommunityNoteRetrieveContributorResponse.Contributor.NotesCount
                                .builder()
                                .awaitingMoreRatings(18L)
                                .currentlyRatedHelpful(1L)
                                .currentlyRatedNotHelpful(2L)
                                .updatedAt(OffsetDateTime.parse("2026-10-12T22:18:40.096Z"))
                                .build()
                        )
                        .ratingsCount(
                            CommunityNoteRetrieveContributorResponse.Contributor.RatingsCount
                                .builder()
                                .awaitingMoreRatings(703L)
                                .ratedAfterDecision(154L)
                                .successful(
                                    CommunityNoteRetrieveContributorResponse.Contributor
                                        .RatingsCount
                                        .Successful
                                        .builder()
                                        .helpfulCount(27L)
                                        .notHelpfulCount(22L)
                                        .total(49L)
                                        .build()
                                )
                                .unsuccessful(
                                    CommunityNoteRetrieveContributorResponse.Contributor
                                        .RatingsCount
                                        .Unsuccessful
                                        .builder()
                                        .helpfulCount(15L)
                                        .notHelpfulCount(4L)
                                        .total(0L)
                                        .build()
                                )
                                .updatedAt(OffsetDateTime.parse("2026-10-12T22:50:13.228Z"))
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(communityNoteRetrieveContributorResponse.contributor())
            .isEqualTo(
                CommunityNoteRetrieveContributorResponse.Contributor.builder()
                    .alias("ardent-beach-friarbird")
                    .deletedNotesCount(0L)
                    .isApiContributor(false)
                    .isTopWriter(false)
                    .notesCount(
                        CommunityNoteRetrieveContributorResponse.Contributor.NotesCount.builder()
                            .awaitingMoreRatings(18L)
                            .currentlyRatedHelpful(1L)
                            .currentlyRatedNotHelpful(2L)
                            .updatedAt(OffsetDateTime.parse("2026-10-12T22:18:40.096Z"))
                            .build()
                    )
                    .ratingsCount(
                        CommunityNoteRetrieveContributorResponse.Contributor.RatingsCount.builder()
                            .awaitingMoreRatings(703L)
                            .ratedAfterDecision(154L)
                            .successful(
                                CommunityNoteRetrieveContributorResponse.Contributor.RatingsCount
                                    .Successful
                                    .builder()
                                    .helpfulCount(27L)
                                    .notHelpfulCount(22L)
                                    .total(49L)
                                    .build()
                            )
                            .unsuccessful(
                                CommunityNoteRetrieveContributorResponse.Contributor.RatingsCount
                                    .Unsuccessful
                                    .builder()
                                    .helpfulCount(15L)
                                    .notHelpfulCount(4L)
                                    .total(0L)
                                    .build()
                            )
                            .updatedAt(OffsetDateTime.parse("2026-10-12T22:50:13.228Z"))
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityNoteRetrieveContributorResponse =
            CommunityNoteRetrieveContributorResponse.builder()
                .contributor(
                    CommunityNoteRetrieveContributorResponse.Contributor.builder()
                        .alias("ardent-beach-friarbird")
                        .deletedNotesCount(0L)
                        .isApiContributor(false)
                        .isTopWriter(false)
                        .notesCount(
                            CommunityNoteRetrieveContributorResponse.Contributor.NotesCount
                                .builder()
                                .awaitingMoreRatings(18L)
                                .currentlyRatedHelpful(1L)
                                .currentlyRatedNotHelpful(2L)
                                .updatedAt(OffsetDateTime.parse("2026-10-12T22:18:40.096Z"))
                                .build()
                        )
                        .ratingsCount(
                            CommunityNoteRetrieveContributorResponse.Contributor.RatingsCount
                                .builder()
                                .awaitingMoreRatings(703L)
                                .ratedAfterDecision(154L)
                                .successful(
                                    CommunityNoteRetrieveContributorResponse.Contributor
                                        .RatingsCount
                                        .Successful
                                        .builder()
                                        .helpfulCount(27L)
                                        .notHelpfulCount(22L)
                                        .total(49L)
                                        .build()
                                )
                                .unsuccessful(
                                    CommunityNoteRetrieveContributorResponse.Contributor
                                        .RatingsCount
                                        .Unsuccessful
                                        .builder()
                                        .helpfulCount(15L)
                                        .notHelpfulCount(4L)
                                        .total(0L)
                                        .build()
                                )
                                .updatedAt(OffsetDateTime.parse("2026-10-12T22:50:13.228Z"))
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedCommunityNoteRetrieveContributorResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityNoteRetrieveContributorResponse),
                jacksonTypeRef<CommunityNoteRetrieveContributorResponse>(),
            )

        assertThat(roundtrippedCommunityNoteRetrieveContributorResponse)
            .isEqualTo(communityNoteRetrieveContributorResponse)
    }
}
