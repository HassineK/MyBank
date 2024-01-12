package com.vpexit.mybank.kmm.presentation.banks

import com.vpexit.mybank.kmm.data.model.banks.Bank

data class BanksUiState(
    val isLoading: Boolean = false,
    val banks: Map<Int?, List<Bank>> = mapOf(),
)