package com.devpass.spaceapp.fetchNextLaunch.domain.model

sealed class ResultStatus<out T>{
    data class Success<T>(val data : T) : ResultStatus<T>()
    data class Error(val e: Exception) : ResultStatus<Nothing>()
}