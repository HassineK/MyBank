package com.vpexit.mybank.kmm.mvi

import kotlinx.coroutines.CoroutineScope

expect abstract class KmmViewModel constructor() {
    protected val scope: CoroutineScope
}
