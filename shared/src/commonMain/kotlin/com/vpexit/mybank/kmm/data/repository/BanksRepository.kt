package com.vpexit.mybank.kmm.data.repository

import com.vpexit.mybank.kmm.data.remote.BanksApi

internal class BanksRepository(
    private val banksApi: BanksApi
) {
    suspend fun getAllBanks() = banksApi.fetchAllBanks()
}