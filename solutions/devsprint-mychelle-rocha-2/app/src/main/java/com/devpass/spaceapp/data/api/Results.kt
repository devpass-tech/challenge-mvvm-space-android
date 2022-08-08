package com.devpass.spaceapp.data.api

sealed class Results<T>{
    data class Success<T>(val data:T) : Results<T>()
    class Error<T>(val error: Throwable? = null) : Results<T>()
}