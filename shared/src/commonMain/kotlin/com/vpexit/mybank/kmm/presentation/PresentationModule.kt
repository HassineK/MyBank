package com.vpexit.mybank.kmm.presentation

import com.vpexit.mybank.kmm.presentation.banks.BanksViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val presentationModule = module {
    factoryOf(::BanksViewModel)
}