package com.x_twitter_scraper.api

import com.sun.net.httpserver.HttpServer
import java.net.InetAddress
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.junit.platform.launcher.LauncherSession
import org.junit.platform.launcher.LauncherSessionListener

internal object LoopbackTestServer {

    private var executor: ExecutorService? = null
    private var server: HttpServer? = null

    @Synchronized
    fun baseUrl(): String {
        start()
        val port = checkNotNull(server).address.port
        return "http://127.0.0.1:$port"
    }

    @Synchronized
    fun start() {
        if (server != null) {
            return
        }

        val testExecutor = Executors.newCachedThreadPool { task ->
            Thread(task, "xquik-loopback-test").apply { isDaemon = true }
        }
        val testServer =
            HttpServer.create(
                    InetSocketAddress(InetAddress.getByName("127.0.0.1"), 0),
                    0,
                )
                .apply {
                    createContext("/") { exchange ->
                        exchange.requestBody.use { input ->
                            val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
                            while (input.read(buffer) != -1) {
                                // Drain the local test request before replying.
                            }
                        }

                        val response = "{}".toByteArray(StandardCharsets.UTF_8)
                        exchange.responseHeaders.set("Content-Type", "application/json")
                        exchange.sendResponseHeaders(200, response.size.toLong())
                        exchange.responseBody.use { it.write(response) }
                    }
                    executor = testExecutor
                    start()
                }

        executor = testExecutor
        server = testServer
    }

    @Synchronized
    fun stop() {
        server?.stop(0)
        server = null
        executor?.shutdownNow()
        executor = null
    }
}

class LoopbackLauncherSessionListener : LauncherSessionListener {

    override fun launcherSessionOpened(session: LauncherSession) {
        LoopbackTestServer.start()
    }

    override fun launcherSessionClosed(session: LauncherSession) {
        LoopbackTestServer.stop()
    }
}
