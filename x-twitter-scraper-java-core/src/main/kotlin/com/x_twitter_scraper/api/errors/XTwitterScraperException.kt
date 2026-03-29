package com.x_twitter_scraper.api.errors

open class XTwitterScraperException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
