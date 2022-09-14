package com.devpass.spaceapp.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.presentation.launch_list.LaunchModel
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchLaunchesRepositoryImpl
import com.devpass.spaceapp.utils.NetworkResult
import kotlinx.coroutines.launch

class LaunchListViewModel(
    val repository: FetchLaunchesRepository = FetchLaunchesRepositoryImpl(),
) : ViewModel() {

    private val _launches: MutableLiveData<NetworkResult<List<LaunchModel>>> =
        MutableLiveData(NetworkResult.Loading())
    val launches: LiveData<NetworkResult<List<LaunchModel>>> = _launches

    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val error: MutableLiveData<Boolean> = MutableLiveData()

    init {
        loading.postValue(true)
        getLaunches()
    }

    private fun getLaunches() = viewModelScope.launch {
        safeLaunchesCall()
    }

    private suspend fun safeLaunchesCall() {
        val response = repository.fetchLaunches()
        kotlin.runCatching {
            response
        }.onSuccess {
            _launches.postValue(it)
            loading.postValue(false)
        }.onFailure {
            loading.postValue(false)
            error.postValue(true)
        }
    }
}
