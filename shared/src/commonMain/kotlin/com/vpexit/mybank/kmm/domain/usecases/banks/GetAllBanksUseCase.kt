package com.vpexit.mybank.kmm.domain.usecases.banks

import com.vpexit.mybank.kmm.data.model.banks.Bank
import com.vpexit.mybank.kmm.data.repository.banks.BanksRepository
import com.vpexit.mybank.kmm.domain.usecases.DataState
import com.vpexit.mybank.kmm.domain.usecases.DataStateUseCase
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.FlowCollector

internal class GetAllBanksUseCase(
    private val banksRepository: BanksRepository
) : DataStateUseCase<List<Bank>>() {

    override suspend fun FlowCollector<DataState<List<Bank>>>.execute() {
        val service = try {
            val response = banksRepository.getAllBanks()
            Napier.e("GetAllBanksUseCase response : $response")
            DataState.Success(response)
        } catch (exception: Exception) {
            Napier.e("GetAllBanksUseCase exception : ", exception)
            DataState.Error(exception)
        }
        emit(service)
    }
}