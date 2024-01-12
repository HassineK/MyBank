package com.vpexit.mybank.kmm

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = OkHttp
