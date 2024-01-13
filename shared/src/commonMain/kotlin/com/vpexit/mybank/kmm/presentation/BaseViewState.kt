package com.vpexit.mybank.kmm.presentation

sealed interface BaseViewState<out T> {
    data class IsLoading<Boolean>(val value: Boolean) : BaseViewState<Boolean>
    data object Empty : BaseViewState<Nothing>
    data class Success<T>(val value: T) : BaseViewState<T>
    data class Error(val throwable: Throwable) : BaseViewState<Nothing>
}