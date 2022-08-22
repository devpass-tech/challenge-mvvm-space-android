package com.devpass.spaceapp.presentation

open class StateClassView <T>(val isLoading: Boolean = false) {
    class Loading<T> : StateClassView<T>(true)
    class Success<T>(val data: T) : StateClassView<T>()
    class Empty<T> : StateClassView<T>()
    class Error<T>() : StateClassView<T>()
}