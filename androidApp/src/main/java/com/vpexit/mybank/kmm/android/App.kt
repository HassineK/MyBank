package com.vpexit.mybank.kmm.android

import android.app.Application
import com.vpexit.mybank.kmm.ModuleComponent

class App : Application() {

    lateinit var sdk: ModuleComponent

    override fun onCreate() {
        super.onCreate()
        sdk = ModuleComponent()
    }
}
