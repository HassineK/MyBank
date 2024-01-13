package com.vpexit.mybank.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform