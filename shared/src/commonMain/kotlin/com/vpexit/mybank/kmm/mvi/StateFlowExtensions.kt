package com.vpexit.mybank.kmm.mvi

import kotlinx.coroutines.flow.StateFlow

internal fun <T> StateFlow<T>.asKmmStateFlow() = KmmStateFlow(this)
