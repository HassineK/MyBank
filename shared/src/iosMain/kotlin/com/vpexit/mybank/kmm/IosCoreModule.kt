package com.vpexit.mybank.kmm

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin


internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = Darwin
