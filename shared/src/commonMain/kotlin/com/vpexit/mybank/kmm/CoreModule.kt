package com.vpexit.mybank.kmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val coreModule = module {
    single {
        HttpClient(createHttpEngineFactory()) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }
}

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>
