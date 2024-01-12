package com.vpexit.mybank.kmm.android.utils

import android.content.Context
import com.vpexit.mybank.kmm.android.App

fun Context.getDemoSdk() = (applicationContext as App).sdk

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}