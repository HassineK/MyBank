package com.vpexit.mybank.kmm.domain.usecases

import com.vpexit.mybank.kmm.data.model.banks.Bank
import com.vpexit.mybank.kmm.data.repository.BanksRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.FlowCollector

internal class GetAllBanksUseCase(
    private val banksRepository: BanksRepository
) : DataStateUseCase<List<Bank>>() {

    override suspend fun FlowCollector<DataState<List<Bank>>>.execute() {
        val service = try {
            val response = banksRepository.getAllBanks()
            DataState.Success(response)
        } catch (exception: Exception) {
            Napier.e("GetAllBanksUseCase exception", exception)
            DataState.Error(exception)
        }
        emit(service)
    }
}