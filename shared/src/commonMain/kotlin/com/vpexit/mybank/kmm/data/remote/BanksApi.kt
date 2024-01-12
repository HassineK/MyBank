package com.vpexit.mybank.kmm.data.remote

import com.vpexit.mybank.kmm.data.model.banks.Bank

interface BanksApi {

    suspend fun fetchAllBanks(): List<Bank>
}