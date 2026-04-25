// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** AI tweet composition, drafts, writing styles, and radar */
interface StyleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleServiceAsync

    /** Get cached style profile */
    fun retrieve(id: String): CompletableFuture<StyleProfile> =
        retrieve(id, StyleRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StyleRetrieveParams = StyleRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleProfile> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StyleRetrieveParams = StyleRetrieveParams.none(),
    ): CompletableFuture<StyleProfile> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: StyleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleProfile>

    /** @see retrieve */
    fun retrieve(params: StyleRetrieveParams): CompletableFuture<StyleProfile> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<StyleProfile> =
        retrieve(id, StyleRetrieveParams.none(), requestOptions)

    /** Save style profile with custom tweets */
    fun update(id: String, params: StyleUpdateParams): CompletableFuture<StyleProfile> =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: StyleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleProfile> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: StyleUpdateParams): CompletableFuture<StyleProfile> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: StyleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleProfile>

    /** List cached style profiles */
    fun list(): CompletableFuture<StyleListResponse> = list(StyleListParams.none())

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleListResponse>

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none()
    ): CompletableFuture<StyleListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<StyleListResponse> =
        list(StyleListParams.none(), requestOptions)

    /** Delete a style profile */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, StyleDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: StyleDeleteParams = StyleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: StyleDeleteParams = StyleDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: StyleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: StyleDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, StyleDeleteParams.none(), requestOptions)

    /** Analyze writing style from recent tweets */
    fun analyze(params: StyleAnalyzeParams): CompletableFuture<StyleProfile> =
        analyze(params, RequestOptions.none())

    /** @see analyze */
    fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleProfile>

    /** Compare two style profiles */
    fun compare(params: StyleCompareParams): CompletableFuture<StyleCompareResponse> =
        compare(params, RequestOptions.none())

    /** @see compare */
    fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleCompareResponse>

    /** Get engagement metrics for style tweets */
    fun getPerformance(id: String): CompletableFuture<StyleGetPerformanceResponse> =
        getPerformance(id, StyleGetPerformanceParams.none())

    /** @see getPerformance */
    fun getPerformance(
        id: String,
        params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleGetPerformanceResponse> =
        getPerformance(params.toBuilder().id(id).build(), requestOptions)

    /** @see getPerformance */
    fun getPerformance(
        id: String,
        params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
    ): CompletableFuture<StyleGetPerformanceResponse> =
        getPerformance(id, params, RequestOptions.none())

    /** @see getPerformance */
    fun getPerformance(
        params: StyleGetPerformanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleGetPerformanceResponse>

    /** @see getPerformance */
    fun getPerformance(
        params: StyleGetPerformanceParams
    ): CompletableFuture<StyleGetPerformanceResponse> =
        getPerformance(params, RequestOptions.none())

    /** @see getPerformance */
    fun getPerformance(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<StyleGetPerformanceResponse> =
        getPerformance(id, StyleGetPerformanceParams.none(), requestOptions)

    /** A view of [StyleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StyleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /styles/{id}`, but is otherwise the same as
         * [StyleServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<StyleProfile>> =
            retrieve(id, StyleRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: StyleRetrieveParams = StyleRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: StyleRetrieveParams = StyleRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: StyleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>>

        /** @see retrieve */
        fun retrieve(
            params: StyleRetrieveParams
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            retrieve(id, StyleRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /styles/{id}`, but is otherwise the same as
         * [StyleServiceAsync.update].
         */
        fun update(
            id: String,
            params: StyleUpdateParams,
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            params: StyleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(params: StyleUpdateParams): CompletableFuture<HttpResponseFor<StyleProfile>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: StyleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>>

        /**
         * Returns a raw HTTP response for `get /styles`, but is otherwise the same as
         * [StyleServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(StyleListParams.none())

        /** @see list */
        fun list(
            params: StyleListParams = StyleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleListResponse>>

        /** @see list */
        fun list(
            params: StyleListParams = StyleListParams.none()
        ): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(StyleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /styles/{id}`, but is otherwise the same as
         * [StyleServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, StyleDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: StyleDeleteParams = StyleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: StyleDeleteParams = StyleDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: StyleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: StyleDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, StyleDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /styles`, but is otherwise the same as
         * [StyleServiceAsync.analyze].
         */
        fun analyze(params: StyleAnalyzeParams): CompletableFuture<HttpResponseFor<StyleProfile>> =
            analyze(params, RequestOptions.none())

        /** @see analyze */
        fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleProfile>>

        /**
         * Returns a raw HTTP response for `get /styles/compare`, but is otherwise the same as
         * [StyleServiceAsync.compare].
         */
        fun compare(
            params: StyleCompareParams
        ): CompletableFuture<HttpResponseFor<StyleCompareResponse>> =
            compare(params, RequestOptions.none())

        /** @see compare */
        fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleCompareResponse>>

        /**
         * Returns a raw HTTP response for `get /styles/{id}/performance`, but is otherwise the same
         * as [StyleServiceAsync.getPerformance].
         */
        fun getPerformance(
            id: String
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>> =
            getPerformance(id, StyleGetPerformanceParams.none())

        /** @see getPerformance */
        fun getPerformance(
            id: String,
            params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>> =
            getPerformance(params.toBuilder().id(id).build(), requestOptions)

        /** @see getPerformance */
        fun getPerformance(
            id: String,
            params: StyleGetPerformanceParams = StyleGetPerformanceParams.none(),
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>> =
            getPerformance(id, params, RequestOptions.none())

        /** @see getPerformance */
        fun getPerformance(
            params: StyleGetPerformanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>>

        /** @see getPerformance */
        fun getPerformance(
            params: StyleGetPerformanceParams
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>> =
            getPerformance(params, RequestOptions.none())

        /** @see getPerformance */
        fun getPerformance(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StyleGetPerformanceResponse>> =
            getPerformance(id, StyleGetPerformanceParams.none(), requestOptions)
    }
}
