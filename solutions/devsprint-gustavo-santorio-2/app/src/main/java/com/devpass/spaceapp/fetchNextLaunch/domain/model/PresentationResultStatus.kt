package com.devpass.spaceapp.fetchNextLaunch.domain.model

sealed class PresentationResultStatus<out T>{
    data class Success<T>(val data : T) : PresentationResultStatus<T>()
    data class Error(val error: String) : PresentationResultStatus<Nothing>()
}