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
    //val stateLiveData: LiveData<StateView<NextLaunchesModel>> = nextLaunchesLiveData

    fun fetchNextLaunches() {
        nextLaunchesLiveData.value = StateView.Loading()
        viewModelScope.launch(Dispatchers.IO) {
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
}