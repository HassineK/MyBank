package com.vpexit.mybank.kmm

import com.vpexit.mybank.kmm.data.dataModule
import com.vpexit.mybank.kmm.domain.domainModule
import com.vpexit.mybank.kmm.presentation.banks.BanksViewModel
import com.vpexit.mybank.kmm.presentation.presentationModule
import org.koin.core.KoinApplication

class ModuleComponent {

    private val koinApplication: KoinApplication =
        KoinApplication
            .init()
            .modules(
                presentationModule,
                domainModule,
                dataModule,
                coreModule,
            )

    val banksViewModel: BanksViewModel
        get() = getFromKoin()

    private inline fun <reified T> getFromKoin(): T {
        return koinApplication.koin.get()
    }
}