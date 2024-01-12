package com.vpexit.mybank.kmm.domain

import com.vpexit.mybank.kmm.domain.usecases.GetAllBanksUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val domainModule = module {
    factoryOf(::GetAllBanksUseCase)
}
