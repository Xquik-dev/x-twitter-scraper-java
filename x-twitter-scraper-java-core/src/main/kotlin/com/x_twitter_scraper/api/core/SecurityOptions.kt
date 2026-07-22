// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.core

import java.util.Objects

/** A class for configuring which security schemes are enabled for a request. */
class SecurityOptions
private constructor(
    /** Whether the apiKey security scheme is enabled. */
    @get:JvmName("apiKey") val apiKey: Boolean,
    /** Whether the oauthBearer security scheme is enabled. */
    @get:JvmName("oauthBearer") val oauthBearer: Boolean,
) {

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [SecurityOptions]. */
        @JvmStatic fun builder() = Builder()

        /** Returns a [Security] instance with all security schemes enabled. */
        @JvmStatic fun all(): SecurityOptions = builder().apiKey(true).oauthBearer(true).build()

        /** Returns a [Security] instance with no security schemes enabled. */
        @JvmStatic fun none(): SecurityOptions = builder().build()
    }

    /** A builder for [SecurityOptions]. */
    class Builder internal constructor() {

        private var apiKey: Boolean = false
        private var oauthBearer: Boolean = false

        @JvmSynthetic
        internal fun from(securityOptions: SecurityOptions) = apply {
            apiKey = securityOptions.apiKey
            oauthBearer = securityOptions.oauthBearer
        }

        /** Whether the apiKey security scheme is enabled. */
        fun apiKey(apiKey: Boolean) = apply { this.apiKey = apiKey }

        /** Whether the oauthBearer security scheme is enabled. */
        fun oauthBearer(oauthBearer: Boolean) = apply { this.oauthBearer = oauthBearer }

        /**
         * Returns an immutable instance of [SecurityOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SecurityOptions = SecurityOptions(apiKey, oauthBearer)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SecurityOptions &&
            apiKey == other.apiKey &&
            oauthBearer == other.oauthBearer
    }

    override fun hashCode(): Int = Objects.hash(apiKey, oauthBearer)

    override fun toString() = "SecurityOptions{apiKey=$apiKey, oauthBearer=$oauthBearer}"
}
