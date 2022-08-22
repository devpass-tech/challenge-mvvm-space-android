package com.devpass.spaceapp.presentation.launchDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.LaunchDetails
import com.devpass.spaceapp.presentation.launchList.StateView
import com.devpass.spaceapp.presentation.launchList.StateViewData
import com.devpass.spaceapp.repository.FetchLaunchDetailsRepository
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import kotlinx.coroutines.launch

class LaunchDetailsViewModel(private val repository: FetchLaunchDetailsRepository) : ViewModel() {

    private val resultLaunchDetailsLiveData = MutableLiveData<StateView<LaunchDetails>>()

    fun fetchLaunchDetails(id: String) {
        resultLaunchDetailsLiveData.value = StateView.Loading()
        viewModelScope.launch {
            when (val result = repository.getLaunchDetails(id)) {
                is Results.Success -> {
                    resultLaunchDetailsLiveData.value = StateView.Success(result.data)
                }
                is Results.Error -> {
                    resultLaunchDetailsLiveData.value = StateView.Error()
                }
            }

        }
    }
}