// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleDeleteParams
import com.x_twitter_scraper.api.models.styles.StyleGetPerformanceParams
import com.x_twitter_scraper.api.models.styles.StyleGetPerformanceResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import com.x_twitter_scraper.api.models.styles.StyleProfile
import com.x_twitter_scraper.api.models.styles.StyleRetrieveParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
interface StyleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService

    /** Get cached style profile */
    fun retrieve(username: String): StyleProfile = retrieve(username, StyleRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        username: String,
        params: StyleRetrieveParams = StyleRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleProfile = retrieve(params.toBuilder().username(username).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        username: String,
        params: StyleRetrieveParams = StyleRetrieveParams.none(),
    ): StyleProfile = retrieve(username, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: StyleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleProfile

    /** @see retrieve */
    fun retrieve(params: StyleRetrieveParams): StyleProfile =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(username: String, requestOptions: RequestOptions): StyleProfile =
        retrieve(username, StyleRetrieveParams.none(), requestOptions)

    /** Save style profile with custom tweets */
    fun update(username: String, params: StyleUpdateParams): StyleProfile =
        update(username, params, RequestOptions.none())

    /** @see update */
    fun update(
        username: String,
        params: StyleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleProfile = update(params.toBuilder().username(username).build(), requestOptions)

    /** @see update */
    fun update(params: StyleUpdateParams): StyleProfile = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: StyleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleProfile

    /** List cached style profiles */
    fun list(): StyleListResponse = list(StyleListParams.none())

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleListResponse

    /** @see list */
    fun list(params: StyleListParams = StyleListParams.none()): StyleListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): StyleListResponse =
        list(StyleListParams.none(), requestOptions)

    /** Delete a style profile */
    fun delete(username: String) = delete(username, StyleDeleteParams.none())

    /** @see delete */
    fun delete(
        username: String,
        params: StyleDeleteParams = StyleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().username(username).build(), requestOptions)

    /** @see delete */
    fun delete(username: String, params: StyleDeleteParams = StyleDeleteParams.none()) =
        delete(username, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: StyleDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: StyleDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(username: String, requestOptions: RequestOptions) =
        delete(username, StyleDeleteParams.none(), requestOptions)

    /** Analyze writing style from recent tweets */
    fun analyze(params: StyleAnalyzeParams): StyleProfile = analyze(params, RequestOptions.none())

    /** @see analyze */
    fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleProfile

    /** Compare two style profiles */
    fun compare(params: StyleCompareParams): StyleCompareResponse =
        compare(params, RequestOptions.none())

    /** @see compare */
    fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleCompareResponse

    /** Get engagement metrics for style tweets */
    fun getPerformance(username: String): StyleGetPerformanceResponse =
        getPerformance(username, StyleGetPerformanceParams.none())

    /** @see getPerformance */
    fun getPerformance(
        username: String,
        params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleGetPerformanceResponse =
        getPerformance(params.toBuilder().username(username).build(), requestOptions)

    /** @see getPerformance */
    fun getPerformance(
        username: String,
        params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
    ): StyleGetPerformanceResponse = getPerformance(username, params, RequestOptions.none())

    /** @see getPerformance */
    fun getPerformance(
        params: StyleGetPerformanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleGetPerformanceResponse

    /** @see getPerformance */
    fun getPerformance(params: StyleGetPerformanceParams): StyleGetPerformanceResponse =
        getPerformance(params, RequestOptions.none())

    /** @see getPerformance */
    fun getPerformance(
        username: String,
        requestOptions: RequestOptions,
    ): StyleGetPerformanceResponse =
        getPerformance(username, StyleGetPerformanceParams.none(), requestOptions)

    /** A view of [StyleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /styles/{username}`, but is otherwise the same as
         * [StyleService.retrieve].
         */
        @MustBeClosed
        fun retrieve(username: String): HttpResponseFor<StyleProfile> =
            retrieve(username, StyleRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            username: String,
            params: StyleRetrieveParams = StyleRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleProfile> =
            retrieve(params.toBuilder().username(username).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            username: String,
            params: StyleRetrieveParams = StyleRetrieveParams.none(),
        ): HttpResponseFor<StyleProfile> = retrieve(username, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: StyleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleProfile>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: StyleRetrieveParams): HttpResponseFor<StyleProfile> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            username: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleProfile> =
            retrieve(username, StyleRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /styles/{username}`, but is otherwise the same as
         * [StyleService.update].
         */
        @MustBeClosed
        fun update(username: String, params: StyleUpdateParams): HttpResponseFor<StyleProfile> =
            update(username, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            username: String,
            params: StyleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleProfile> =
            update(params.toBuilder().username(username).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: StyleUpdateParams): HttpResponseFor<StyleProfile> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: StyleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleProfile>

        /**
         * Returns a raw HTTP response for `get /styles`, but is otherwise the same as
         * [StyleService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<StyleListResponse> = list(StyleListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: StyleListParams = StyleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: StyleListParams = StyleListParams.none()
        ): HttpResponseFor<StyleListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<StyleListResponse> =
            list(StyleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /styles/{username}`, but is otherwise the same as
         * [StyleService.delete].
         */
        @MustBeClosed
        fun delete(username: String): HttpResponse = delete(username, StyleDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            username: String,
            params: StyleDeleteParams = StyleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().username(username).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            username: String,
            params: StyleDeleteParams = StyleDeleteParams.none(),
        ): HttpResponse = delete(username, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: StyleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: StyleDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(username: String, requestOptions: RequestOptions): HttpResponse =
            delete(username, StyleDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /styles`, but is otherwise the same as
         * [StyleService.analyze].
         */
        @MustBeClosed
        fun analyze(params: StyleAnalyzeParams): HttpResponseFor<StyleProfile> =
            analyze(params, RequestOptions.none())

        /** @see analyze */
        @MustBeClosed
        fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleProfile>

        /**
         * Returns a raw HTTP response for `get /styles/compare`, but is otherwise the same as
         * [StyleService.compare].
         */
        @MustBeClosed
        fun compare(params: StyleCompareParams): HttpResponseFor<StyleCompareResponse> =
            compare(params, RequestOptions.none())

        /** @see compare */
        @MustBeClosed
        fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleCompareResponse>

        /**
         * Returns a raw HTTP response for `get /styles/{username}/performance`, but is otherwise
         * the same as [StyleService.getPerformance].
         */
        @MustBeClosed
        fun getPerformance(username: String): HttpResponseFor<StyleGetPerformanceResponse> =
            getPerformance(username, StyleGetPerformanceParams.none())

        /** @see getPerformance */
        @MustBeClosed
        fun getPerformance(
            username: String,
            params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleGetPerformanceResponse> =
            getPerformance(params.toBuilder().username(username).build(), requestOptions)

        /** @see getPerformance */
        @MustBeClosed
        fun getPerformance(
            username: String,
            params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
        ): HttpResponseFor<StyleGetPerformanceResponse> =
            getPerformance(username, params, RequestOptions.none())

        /** @see getPerformance */
        @MustBeClosed
        fun getPerformance(
            params: StyleGetPerformanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleGetPerformanceResponse>

        /** @see getPerformance */
        @MustBeClosed
        fun getPerformance(
            params: StyleGetPerformanceParams
        ): HttpResponseFor<StyleGetPerformanceResponse> =
            getPerformance(params, RequestOptions.none())

        /** @see getPerformance */
        @MustBeClosed
        fun getPerformance(
            username: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StyleGetPerformanceResponse> =
            getPerformance(username, StyleGetPerformanceParams.none(), requestOptions)
    }
}
