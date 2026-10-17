// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkExactlyOne
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceResponse
import com.x_twitter_scraper.api.models.drafts.DraftCreateParams
import com.x_twitter_scraper.api.models.trends.TrendListResponse
import com.x_twitter_scraper.api.models.x.media.MediaUploadParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateAvatarParams
import com.x_twitter_scraper.api.models.x.profile.ProfileUpdateBannerParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import kotlin.test.assertFailsWith
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FieldCheckTest {

    private val credits =
        """"/api/v1/credits": {"get": {"responses": {"200": {"content": {"application/json": {"schema": {
          "type": "object",
          "required": ["auto_topup_amount_dollars", "auto_topup_enabled", "auto_topup_threshold", "balance", "lifetime_purchased", "lifetime_used"],
          "properties": {
            "auto_topup_amount_dollars": {"type": "number"}, "auto_topup_enabled": {"type": "boolean"},
            "auto_topup_threshold": {"type": "string"}, "auto_topup_stopped": {"type": "boolean"}, "balance": {"type": "string"},
            "lifetime_purchased": {"type": "string"}, "lifetime_used": {"type": "string"}%s
          }}}}}}}}"""

    private val mediaUpload =
        """"/api/v1/x/media": {"post": {
          "requestBody": {"content": {
            "application/json": {"schema": {
              "type": "object", "required": ["account", "url"],
              "properties": {"account": {"type": "string"}, "url": {"type": "string"}}
            }},
            "multipart/form-data": {"schema": {
              "type": "object", "required": ["account", "file"],
              "properties": {"account": {"type": "string"}, "file": {"type": "string"}, "is_long_video": {"type": "boolean"}}
            }}
          }},
          "responses": {}
        }}"""

    private fun root(accepted: String = "[]", excluded: String = "[]"): File =
        Files.createTempDirectory("api-fields").toFile().apply {
            resolve("accepted-field-differences.json").writeText(accepted)
            resolve("excluded-operations.json").writeText(excluded)
            deleteOnExit()
        }

    private fun check(paths: String, root: File = root()): String =
        FieldCheck(ObjectMapper().readTree("""{"paths": {$paths}}"""), root).run()

    private fun failure(paths: String, root: File = root()): String =
        assertFailsWith<CheckFailure> { check(paths, root) }.message!!

    @Test
    fun passesWhenEveryFieldMatches() {
        assertThat(check(credits.format("")))
            .isEqualTo(
                "The SDK's fields match the API for 1 operation, and accepted-field-differences.json lists 0 accepted differences."
            )
    }

    @Test
    fun comparesJsonUploadWithoutLongVideo() {
        assertThat(check(mediaUpload))
            .isEqualTo(
                "The SDK's fields match the API for 1 operation, and accepted-field-differences.json lists 0 accepted differences."
            )
    }

    @Test
    fun reportsLongVideoInJsonWhenTheBuilderHasNoRequiresRule() {
        val spec = ObjectMapper().readTree("""{"paths": {$mediaUpload}}""")
        val path = spec.at("/paths/~1api~1v1~1x~1media")
        val operation = SpecShapes(spec).operation(path, path.get("post"), "application/json")
        val shapes = SdkShapes()
        val (query, body) = shapes.params(UploadWithoutRequires::class.java, "url")

        assertThat(
                compareOperation(operation, SdkOperation(query, body, null), shapes.defs).map {
                    "${it.side} ${it.kind} ${it.path}"
                }
            )
            .containsExactly("request extra is_long_video")

        val (checkedQuery, checkedBody) = shapes.params(MediaUploadParams::class.java, "url")

        assertThat(
                compareOperation(
                    operation,
                    SdkOperation(checkedQuery, checkedBody, null),
                    shapes.defs,
                )
            )
            .isEmpty()
    }

    @Test
    fun setsDependentFieldsOnlyForTheRequiredInput() {
        listOf("url", "file").forEach { input ->
            val builder =
                SdkShapes().newParams(MediaUploadParams::class.java, input).builder
                    as MediaUploadParams.Builder

            assertThat(builder.build()._body().containsKey("is_long_video"))
                .isEqualTo(input == "file")
        }
    }

    @Test
    fun reportsAFieldMissingFromMultipartEvenWhenJsonHasIt() {
        val spec =
            mediaUpload
                .replace("\"required\": [\"account\", \"file\"]", "\"required\": [\"file\"]")
                .replace(
                    "\"properties\": {\"account\": {\"type\": \"string\"}, \"file\"",
                    "\"properties\": {\"file\"",
                )

        assertThat(failure(spec).lines())
            .containsExactly(
                "POST /api/v1/x/media request extra account",
                "Fix each field above in the SDK, or list it in accepted-field-differences.json with a reason.",
            )
    }

    @Test
    fun reportsAFieldMissingFromJsonEvenWhenMultipartHasIt() {
        val spec =
            mediaUpload
                .replace("\"required\": [\"account\", \"url\"]", "\"required\": [\"url\"]")
                .replace(
                    "\"properties\": {\"account\": {\"type\": \"string\"}, \"url\"",
                    "\"properties\": {\"url\"",
                )

        assertThat(failure(spec).lines())
            .containsExactly(
                "POST /api/v1/x/media request extra account",
                "Fix each field above in the SDK, or list it in accepted-field-differences.json with a reason.",
            )
    }

    @Test
    fun listsEachDifferenceThenTheNextStep() {
        val message =
            failure(
                credits
                    .format(""", "pending": {"type": "string"}""")
                    .replace("\"lifetime_used\"]", "\"pending\"]")
            )

        assertThat(message.lines())
            .containsExactly(
                "GET /api/v1/credits response required lifetime_used",
                "GET /api/v1/credits response missing pending",
                "Fix each field above in the SDK, or list it in accepted-field-differences.json with a reason.",
            )
    }

    @Test
    fun acceptsListedDifferencesAndRejectsStaleOnes() {
        val accepted =
            """[{"reason": "The SDK keeps it.", "differences": ["GET /api/v1/credits response missing pending"]}]"""
        val spec = credits.format(""", "pending": {"type": "string"}""")

        assertThat(check(spec, root(accepted)))
            .isEqualTo(
                "The SDK's fields match the API for 1 operation, and accepted-field-differences.json lists 1 accepted difference."
            )
        assertThat(failure(credits.format(""), root(accepted)).lines())
            .containsExactly(
                "accepted-field-differences.json lists GET /api/v1/credits response missing pending, which the check no longer finds. Remove it.",
                "Remove each difference above from accepted-field-differences.json.",
            )
    }

    @Test
    fun rejectsAnInvalidAcceptedList() {
        assertThat(failure(credits.format(""), root("{")))
            .isEqualTo("accepted-field-differences.json is not valid. It is not JSON near line 1.")
        assertThat(
                failure(
                    credits.format(""),
                    root("""[{"reason": " ", "differences": ["GET /x response missing a"]}]"""),
                )
            )
            .isEqualTo("accepted-field-differences.json is not valid. Group 1 needs a reason.")
        assertThat(
                failure(
                    credits.format(""),
                    root("""[{"reason": "r", "differences": ["missing a"]}]"""),
                )
            )
            .startsWith(
                "accepted-field-differences.json is not valid. Group 1 lists \"missing a\", which needs a method"
            )
        assertThat(
                failure(
                    credits.format(""),
                    root(
                        """[{"reason": "r", "differences": ["GET /a/{id} response missing b", "GET /a/{x} response missing b"]}]"""
                    ),
                )
            )
            .isEqualTo(
                "accepted-field-differences.json is not valid. It lists GET /a/{x} response missing b more than once."
            )
        assertThat(
                failure(
                    credits.format(""),
                    root("""[{"reason": "r", "differences": [], "note": 1}]"""),
                )
            )
            .isEqualTo(
                "accepted-field-differences.json is not valid. Group 1 has the unknown field note."
            )
    }

    @Test
    fun failsOnAnOperationWithoutAnSdkMethodUnlessItIsExcluded() {
        val paths = """"/api/v1/nothing": {"get": {"responses": {}}}"""

        assertThat(failure(paths).lines())
            .containsExactly(
                "GET /api/v1/nothing has no SDK method the field check can read.",
                "Write each operation above as a service method, or list it in excluded-operations.json.",
            )
        assertThat(
                check(
                    paths,
                    root(excluded = """[{"reason": "r", "operations": ["GET /api/v1/nothing"]}]"""),
                )
            )
            .isEqualTo(
                "The SDK's fields match the API for 0 operations, and accepted-field-differences.json lists 0 accepted differences."
            )
    }

    @Test
    fun findsEverySdkMethodByTheRequestItSends() {
        val methods = Operations.methods(SdkShapes())

        assertThat(methods).hasSize(183)
        assertThat(methods.map { "${it.httpMethod} /${it.segments.joinToString("/")}" })
            .contains(
                "GET /api/v1/credits",
                "GET /api/v1/x/tweets/sample/replies",
                "DELETE /api/v1/x/dm/sample/messages/sample",
            )
        assertThat(methods.map { it.name to it.input }).doesNotHaveDuplicates()
        assertThat(methods.map { "${it.httpMethod} /${it.segments.joinToString("/")}" }.distinct())
            .hasSize(180)
        listOf(
                MediaUploadParams::class.java,
                ProfileUpdateAvatarParams::class.java,
                ProfileUpdateBannerParams::class.java,
            )
            .forEach { cls ->
                assertThat(methods.filter { it.params == cls }.map { it.input to it.bodyType })
                    .containsExactlyInAnyOrder(
                        "url" to "application/json",
                        "file" to "multipart/form-data",
                    )
            }
    }

    @Test
    fun readsQueryWireNamesAndRequiredParamsFromParamsClasses() {
        val query = SdkShapes().params(TweetSearchParams::class.java).first as Obj

        assertThat(query.props).containsKeys("q", "queryType", "fields", "omit", "sinceTime")
        assertThat(query.props.getValue("q").required).isTrue()
        assertThat(query.props.getValue("fields").required).isFalse()
    }

    @Test
    fun readsEnumValuesUnionsAndNullableFields() {
        val shapes = SdkShapes()
        val spaces = shapes.params(SpaceSearchParams::class.java).first as Obj
        val trends = canon(shapes.type(TrendListResponse::class.java), shapes.defs) as Obj
        val search = canon(shapes.type(TweetSearchResponse::class.java), shapes.defs) as Obj
        val trend = (trends.props.getValue("trends").shape as Arr).items as Obj

        assertThat(spaces.props.getValue("queryType").shape)
            .isEqualTo(Leaf(listOf("Latest", "Live", "Top", "Upcoming")))
        assertThat(trend.props.getValue("promotedContent").nullable).isTrue()
        assertThat(trend.props.getValue("name").required).isTrue()
        assertThat(search.props.keys).contains("tweets", "has_next_page", "diagnostic")
        assertThat(search.props.getValue("diagnostic").required).isFalse()
    }

    @Test
    fun readsJsonAndMultipartBodies() {
        val shapes = SdkShapes()
        val draft = shapes.params(DraftCreateParams::class.java).second!!
        val avatar = shapes.params(ProfileUpdateAvatarParams::class.java).second!!
        val balance =
            canon(shapes.type(CreditRetrieveBalanceResponse::class.java), shapes.defs) as Obj

        assertThat((canon(draft, shapes.defs) as Obj).props.getValue("text").required).isTrue()
        assertThat((canon(avatar, shapes.defs) as Obj).props.keys).contains("account", "url")
        assertThat(
                balance.props.filterKeys { it != "auto_topup_stopped" }.values.map { it.required }
            )
            .containsOnly(true)
        assertThat(balance.props.getValue("auto_topup_stopped").required).isFalse()
    }

    @Test
    fun readsAlternativeUploadInputs() {
        listOf(
                MediaUploadParams::class.java,
                ProfileUpdateAvatarParams::class.java,
                ProfileUpdateBannerParams::class.java,
            )
            .forEach { cls ->
                val shapes = SdkShapes()
                listOf("url", "file").forEach { input ->
                    val (query, body) = shapes.params(cls, input)
                    val props = (canon(body!!, shapes.defs) as Obj).props

                    assertThat((query as Obj).props).isEmpty()
                    assertThat(props.getValue("account").required).isTrue()
                    assertThat(props.getValue(input).required).isTrue()
                    assertThat(props).doesNotContainKey(if (input == "url") "file" else "url")
                    if (cls == MediaUploadParams::class.java && input == "file") {
                        assertThat(props.getValue("is_long_video").required).isFalse()
                    } else {
                        assertThat(props).doesNotContainKey("is_long_video")
                    }
                }
            }
    }

    class UploadWithoutRequires private constructor(private val body: Body) : Params {

        fun _account(): MultipartField<String> = body._account()

        fun _url(): MultipartField<String> = body._url()

        fun _file(): MultipartField<InputStream> = body._file()

        fun _isLongVideo(): MultipartField<Boolean> = body._isLongVideo()

        fun _body(): Map<String, MultipartField<*>> =
            mapOf(
                    "account" to _account(),
                    "url" to _url(),
                    "file" to _file(),
                    "is_long_video" to _isLongVideo(),
                )
                .filterValues { !it.value.isMissing() }

        override fun _headers(): Headers = Headers.builder().build()

        override fun _queryParams(): QueryParams = QueryParams.builder().build()

        fun toBuilder(): Builder = Builder(body.toBuilder())

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder(private val body: Body.Builder = Body.builder()) {

            fun account(account: String) = apply { body.account(account) }

            fun url(url: String) = apply { body.url(url) }

            fun file(file: InputStream) = apply { body.file(file) }

            fun isLongVideo(isLongVideo: Boolean) = apply { body.isLongVideo(isLongVideo) }

            fun build(): UploadWithoutRequires = UploadWithoutRequires(body.build())
        }

        class Body
        private constructor(
            private val account: MultipartField<String>,
            private val url: MultipartField<String>,
            private val file: MultipartField<InputStream>,
            private val isLongVideo: MultipartField<Boolean>,
        ) {

            @JsonProperty("account") fun _account(): MultipartField<String> = account

            @JsonProperty("url") fun _url(): MultipartField<String> = url

            @JsonProperty("file") fun _file(): MultipartField<InputStream> = file

            @JsonProperty("is_long_video") fun _isLongVideo(): MultipartField<Boolean> = isLongVideo

            fun toBuilder(): Builder = Builder(account, url, file, isLongVideo)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder(
                private var account: MultipartField<String>? = null,
                private var url: MultipartField<String> = MultipartField.of(JsonMissing.of()),
                private var file: MultipartField<InputStream> = MultipartField.of(JsonMissing.of()),
                private var isLongVideo: MultipartField<Boolean> =
                    MultipartField.of(JsonMissing.of()),
            ) {

                fun account(account: String) = apply { this.account = MultipartField.of(account) }

                fun url(url: String) = apply { this.url = MultipartField.of(url) }

                fun file(file: InputStream) = apply { this.file = MultipartField.of(file) }

                fun isLongVideo(isLongVideo: Boolean) = apply {
                    this.isLongVideo = MultipartField.of(isLongVideo)
                }

                fun build(): Body {
                    checkExactlyOne("url", url, "file", file)
                    return Body(checkRequired("account", account), url, file, isLongVideo)
                }
            }
        }
    }
}
