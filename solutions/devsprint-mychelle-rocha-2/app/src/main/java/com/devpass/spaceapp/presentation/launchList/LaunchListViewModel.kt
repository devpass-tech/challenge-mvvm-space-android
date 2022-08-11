package com.devpass.spaceapp.presentation.launchList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LaunchListViewModel(private val repository: FetchLaunchesRepository) : ViewModel() {

    val nextLaunchesLiveData = MutableLiveData<StateView<NextLaunchesModel>>()
    val nextLaunchesDataLiveData = MutableLiveData(StateViewData())

    fun fetchNextLaunches() {
        nextLaunchesLiveData.value = StateView.Loading()
        viewModelScope.launch {
            when (val result = repository.fetchLaunches()) {
                is Results.Success -> {
                    if (result.data.nextLaunchModel.isNullOrEmpty()) {
                        nextLaunchesLiveData.value = StateView.Empty()
                    } else {
                        nextLaunchesLiveData.value = StateView.Success(result.data)
                    }
                }
                is Results.Error -> {
                    nextLaunchesLiveData.value = StateView.Error()
                }
            }
        }
    }

    //Método para utilizar State através do Data Class
    fun fetchNextLaunchesData() {
        nextLaunchesDataLiveData.value = StateViewData().setLoading()
        viewModelScope.launch {
            when (val result = repository.fetchLaunches()) {
                is Results.Success -> {
                    if (result.data.nextLaunchModel.isNullOrEmpty()) {
                        nextLaunchesDataLiveData.value = StateViewData().setEmpty()
                    } else {
                        nextLaunchesDataLiveData.value = StateViewData().setSuccess(result.data)
                    }
                }
                is Results.Error -> {
                    nextLaunchesDataLiveData.value = StateViewData().setError()
                }
            }
        }
    }
}