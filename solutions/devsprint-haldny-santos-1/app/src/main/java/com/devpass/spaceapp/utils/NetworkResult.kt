package com.devpass.spaceapp.utils

import java.lang.Exception


sealed class NetworkResult<T>(
    data: T? = null,
    exception: Exception? = null
) {
    data class Success<T>(val data: T) : NetworkResult<T>(data = data, exception = null)
    data class Error<T>(val exception: Exception) : NetworkResult<T>(
        data = null,
        exception = exception
    )

    class Loading<T> : NetworkResult<T>()
}
