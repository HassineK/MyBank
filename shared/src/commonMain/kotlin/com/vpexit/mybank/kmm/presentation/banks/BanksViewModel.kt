package com.vpexit.mybank.kmm.presentation.banks

import com.vpexit.mybank.kmm.domain.usecases.DataState
import com.vpexit.mybank.kmm.domain.usecases.banks.GetAllBanksUseCase
import com.vpexit.mybank.kmm.mvi.KmmStateFlow
import com.vpexit.mybank.kmm.mvi.KmmViewModel
import com.vpexit.mybank.kmm.mvi.asKmmStateFlow
import com.vpexit.mybank.kmm.presentation.BaseViewState
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("HomeViewModelDelegate")
class BanksViewModel internal constructor(
    private val getAllBanksUseCase: GetAllBanksUseCase
) : KmmViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, e -> handleException(e) }
    private val _uiState = MutableStateFlow<BaseViewState<*>>(BaseViewState.Empty)
    val uiState: KmmStateFlow<BaseViewState<*>> = _uiState.asKmmStateFlow()

    init {
        collectBanks()
    }

    fun collectBanks() = scope.launch(exceptionHandler) {
        getAllBanksUseCase()
            .onStart {
                _uiState.update { BaseViewState.IsLoading(true) }
            }
            .catch {
                handleException(it)
            }.collect { state ->
                when (state) {
                    is DataState.Error -> handleException(state.exception)
                    is DataState.Success -> {
                        val banksList = state.result.groupBy { it.isCA }
                        _uiState.update { BaseViewState.Success(BanksUiState(banks = banksList)) }
                    }
                }
            }
    }

    private fun handleException(e: Throwable) {
        Napier.e("BanksViewModel handleError : ", e)
        _uiState.update { BaseViewState.Error(e) }
    }
}