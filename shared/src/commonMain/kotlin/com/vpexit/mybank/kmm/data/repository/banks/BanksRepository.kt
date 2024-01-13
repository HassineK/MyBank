package com.vpexit.mybank.kmm.data.repository.banks

import com.vpexit.mybank.kmm.data.remote.banks.BanksApi

internal class BanksRepository(
    private val banksApi: BanksApi
) {
    suspend fun getAllBanks() = banksApi.fetchAllBanks()
}