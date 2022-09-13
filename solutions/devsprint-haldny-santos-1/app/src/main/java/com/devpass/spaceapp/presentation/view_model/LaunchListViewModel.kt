package com.devpass.spaceapp.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.presentation.launch_list.LaunchModel
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchLaunchesRepositoryImpl
import kotlinx.coroutines.launch

class LaunchListViewModel(
    val repository: FetchLaunchesRepository = FetchLaunchesRepositoryImpl()
) : ViewModel() {

    private val _launches: MutableLiveData<List<LaunchModel>> = MutableLiveData()
    val launches: LiveData<List<LaunchModel>> = _launches

    init {
        getLaunches()
    }

    private fun getLaunches() = viewModelScope.launch {
        safeLaunchesCall()
    }

    private suspend fun safeLaunchesCall() {
        val response = repository.fetchLaunches()
        _launches.postValue(response)
    }
}
