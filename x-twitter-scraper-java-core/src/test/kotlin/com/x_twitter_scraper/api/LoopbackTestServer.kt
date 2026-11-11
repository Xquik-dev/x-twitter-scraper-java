// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                            while (input.read(buffer) != -1) {}
                        }

                        val responseBody =
                            if (
                                exchange.requestURI.path.startsWith(
                                    "/x/account-connection-attempts/"
                                )
                            ) {
                                """{"id":"xatt_0123456789abcdef0123456789abcdef","object":"x_account_connection_attempt","pollAfterMs":3000,"status":"pending"}"""
                            } else if (
                                exchange.requestURI.path.startsWith("/x/account-connection-links")
                            ) {
                                if (exchange.requestMethod == "DELETE") {
                                    """{"success":true}"""
                                } else {
                                    """{"id":"xlink_AAAAAAAAAAAAAAAA","accountId":null,"completedAt":null,"createdAt":"2026-11-08T12:00:00Z","expiresAt":"2026-11-08T12:30:00Z","failure":null,"health":null,"object":"x_account_connection_link","purpose":"connect","reference":"crm-user-7","returnUrl":"https://app.example.com/connected","status":"pending","xUserId":null,"xUsername":null,"url":"https://xquik.com/connect-x#token=CONNECT_LINK_TOKEN"}"""
                                }
                            } else {
                                "{}"
                            }
                        val response = responseBody.toByteArray(StandardCharsets.UTF_8)
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
