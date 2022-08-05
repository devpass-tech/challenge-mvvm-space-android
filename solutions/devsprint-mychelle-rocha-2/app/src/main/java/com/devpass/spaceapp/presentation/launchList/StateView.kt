package com.devpass.spaceapp.presentation.launchList


sealed class StateView<T> {
    class Loading<T> : StateView<T>()
    class Success<T>(val data: T) : StateView<T>()
    class Empty<T> : StateView<T>()
    class Error<T>(val error: String) : StateView<T>()
}
