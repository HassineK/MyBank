package com.vpexit.mybank.kmm.data

import com.vpexit.mybank.kmm.data.remote.BanksApi
import com.vpexit.mybank.kmm.data.remote.BanksApiImp
import com.vpexit.mybank.kmm.data.repository.BanksRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::BanksRepository)
    factoryOf(::BanksApiImp) bind BanksApi::class
}
