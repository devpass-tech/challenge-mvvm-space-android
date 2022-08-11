package com.devpass.spaceapp.presentation.launchList

import com.devpass.spaceapp.data.api.NextLaunchesModel


sealed class StateView<T>(val isLoading: Boolean = false) {
    class Loading<T>: StateView<T>(true)
    class Success<T>(val data: T) : StateView<T>()
    class Empty<T> : StateView<T>()
    class Error<T>() : StateView<T>()
}

//Opção de State através do Data Class
data class StateViewData(
    val loading: Boolean = false,
    val success: Boolean = false,
    val empty: Boolean = false,
    val error: Boolean = false,
    val nextLaunchesModel: NextLaunchesModel? = null
){
    fun setLoading() = copy(loading = true, success = false, empty = false, error = false, nextLaunchesModel = null)
    fun setSuccess(nextLaunchesModel: NextLaunchesModel) = copy(loading = false, success = true, empty = false, error = false, nextLaunchesModel = nextLaunchesModel)
    fun setEmpty() = copy(loading = false, success = false, empty = true, error = false, nextLaunchesModel = null)
    fun setError() = copy(loading = false, success = false, empty = false, error = true, nextLaunchesModel = null)

}
