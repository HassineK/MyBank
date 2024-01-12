package com.vpexit.mybank.kmm.domain.usecases

sealed class DataState<out T> {
    data class Success<out T>(val result: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
}