package com.akramas.straight

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.akramas.straight.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
//        configureSockets()
        configureRouting()
//        configureSecurity()
    }.start(wait = true)
}
