// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientImpl
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpClient
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.StreamResponse
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.net.URI
import java.util.concurrent.CompletableFuture

/** An SDK method and the HTTP request it sends. */
internal data class SdkMethod(
    val name: String,
    val httpMethod: String,
    val segments: List<String>,
    val params: Class<*>,
    val response: Type?,
)

private class Recorded(val request: HttpRequest) : RuntimeException(null, null, false, false)

private object RecordingHttpClient : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        throw Recorded(request)

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = throw Recorded(request)

    override fun close() {}
}

/**
 * Finds each SDK method by calling it with a client that records the request instead of sending it.
 */
internal object Operations {

    fun basePath(): List<String> = segments(URI(ClientOptions.PRODUCTION_URL).path)

    fun segments(path: String): List<String> = path.split("/").filter { it.isNotEmpty() }

    fun methods(shapes: SdkShapes): List<SdkMethod> {
        val options =
            ClientOptions.builder()
                .httpClient(RecordingHttpClient)
                .apiKey("key")
                .maxRetries(0)
                .build()
        val client: XTwitterScraperClient = XTwitterScraperClientImpl(options)
        val out = mutableListOf<SdkMethod>()
        walk(client, XTwitterScraperClient::class.java, "client", shapes, out, mutableSetOf())
        return out
    }

    private fun walk(
        service: Any,
        type: Class<*>,
        path: String,
        shapes: SdkShapes,
        out: MutableList<SdkMethod>,
        seen: MutableSet<Class<*>>,
    ) {
        if (!seen.add(type)) return
        for (method in type.methods.sortedBy { it.name }) {
            if (method.parameterCount != 0 || !method.returnType.isInterface) continue
            val child = method.returnType
            when {
                method.name == "withRawResponse" ->
                    raw(method.invoke(service), child, path, shapes, out)
                child.name.endsWith("Service") &&
                    child.packageName.contains(".services.blocking") ->
                    walk(method.invoke(service), child, "$path.${method.name}()", shapes, out, seen)
            }
        }
    }

    private fun raw(
        raw: Any,
        type: Class<*>,
        path: String,
        shapes: SdkShapes,
        out: MutableList<SdkMethod>,
    ) {
        for (method in type.methods.sortedBy { it.name }) {
            val types = method.parameterTypes
            if (
                types.size != 2 ||
                    !Params::class.java.isAssignableFrom(types[0]) ||
                    types[1] != RequestOptions::class.java
            ) {
                continue
            }
            val request = record(raw, method, shapes)
            out.add(
                SdkMethod(
                    "$path.${method.name}",
                    request.method.name,
                    basePath() + request.pathSegments,
                    types[0],
                    responseType(method.genericReturnType),
                )
            )
        }
    }

    private fun record(raw: Any, method: Method, shapes: SdkShapes): HttpRequest {
        val (builder, _) = shapes.newParams(method.parameterTypes[0])
        repeat(20) {
            val params = builder.javaClass.getMethod("build").invoke(builder)
            try {
                method.invoke(raw, params, RequestOptions.none())
            } catch (e: InvocationTargetException) {
                when (val cause = e.targetException) {
                    is Recorded -> return cause.request
                    is IllegalStateException -> shapes.setRequired(builder, cause)
                    else -> throw cause
                }
            }
        }
        throw CheckFailure("${method.declaringClass.name}.${method.name} never sends a request.")
    }

    private fun responseType(type: Type): Type? {
        if (type !is ParameterizedType || type.rawType != HttpResponseFor::class.java) return null
        val parsed = type.actualTypeArguments.single()
        if (parsed is ParameterizedType && parsed.rawType == StreamResponse::class.java) {
            return parsed.actualTypeArguments.single()
        }
        return parsed
    }
}
