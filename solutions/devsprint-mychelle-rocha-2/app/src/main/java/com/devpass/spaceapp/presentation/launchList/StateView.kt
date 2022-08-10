package com.devpass.spaceapp.presentation.launchList


sealed class StateView<T>(val isLoading: Boolean = false) {
    class Loading<T>: StateView<T>(true)
    class Success<T>(val data: T) : StateView<T>()
    class Empty<T> : StateView<T>()
    class Error<T>() : StateView<T>()
}
