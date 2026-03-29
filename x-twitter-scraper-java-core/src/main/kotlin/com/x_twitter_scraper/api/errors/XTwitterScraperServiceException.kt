// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.errors

import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.http.Headers

abstract class XTwitterScraperServiceException
protected constructor(message: String, cause: Throwable? = null) :
    XTwitterScraperException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
