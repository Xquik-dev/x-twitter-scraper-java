package com.x_twitter_scraper.api.core

import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PhantomReachableExecutorServiceTest {

    @Test
    fun delegatesEveryExecutorOperation() {
        val delegate = Executors.newFixedThreadPool(2)
        val executor = PhantomReachableExecutorService(delegate)
        try {
            val executed = CountDownLatch(1)

            executor.execute { executed.countDown() }
            assertThat(executed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(executor.submit(Callable { "callable" }).get()).isEqualTo("callable")
            assertThat(executor.submit(Runnable {}, "result").get()).isEqualTo("result")
            assertThat(executor.submit(Runnable {}).get()).isNull()

            val tasks = mutableListOf(Callable { 1 }, Callable { 2 })
            assertThat(executor.invokeAll(tasks).map { it.get() }).containsExactly(1, 2)
            assertThat(executor.invokeAll(tasks, 5, TimeUnit.SECONDS).map { it.get() })
                .containsExactly(1, 2)
            assertThat(executor.invokeAny(mutableListOf(Callable { "first" }))).isEqualTo("first")
            assertThat(
                    executor.invokeAny(
                        mutableListOf(Callable { "timed" }),
                        5,
                        TimeUnit.SECONDS,
                    )
                )
                .isEqualTo("timed")
            assertThat(executor.isShutdown).isFalse()

            executor.shutdown()
            assertThat(executor.isShutdown).isTrue()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(executor.isTerminated).isTrue()
        } finally {
            delegate.shutdownNow()
        }

        val secondDelegate = Executors.newSingleThreadExecutor()
        try {
            val secondExecutor = PhantomReachableExecutorService(secondDelegate)
            assertThat(secondExecutor.shutdownNow()).isEmpty()
        } finally {
            secondDelegate.shutdownNow()
        }
    }
}
