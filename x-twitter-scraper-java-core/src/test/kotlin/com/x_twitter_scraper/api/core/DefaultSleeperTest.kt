package com.x_twitter_scraper.api.core

import java.time.Duration
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DefaultSleeperTest {

    @Test
    fun sleepsSynchronouslyAndAsynchronously() {
        val sleeper = DefaultSleeper()

        try {
            sleeper.sleep(Duration.ZERO)
            val result = sleeper.sleepAsync(Duration.ZERO).get(5, TimeUnit.SECONDS)

            assertThat(result).isNull()
        } finally {
            sleeper.close()
        }
    }
}
