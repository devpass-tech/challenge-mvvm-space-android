package com.devpass.spaceapp.data.api

sealed class Results<T>{
    class Success<T>(val data:T) : Results<T>()
    class Error<T>(val error: Throwable? = null) : Results<T>()
}