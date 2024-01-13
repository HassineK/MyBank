package com.vpexit.mybank.kmm.data.remote.banks

import com.vpexit.mybank.kmm.data.model.banks.Bank

interface BanksApi {

    suspend fun fetchAllBanks(): List<Bank>
}