package com.vpexit.mybank.kmm.data.remote

import com.vpexit.mybank.kmm.data.constant.NetworkConstant
import com.vpexit.mybank.kmm.data.model.banks.Bank
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BanksApiImp(
    private val httpClient: HttpClient
) : BanksApi {

    override suspend fun fetchAllBanks(): List<Bank> {
        return httpClient.get(NetworkConstant.GET_ALL_BANKS_URL).body()
    }
}