package com.devpass.spaceapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.Rocket
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchRocketRepository
import kotlinx.coroutines.launch

class LaunchViewModel(
    private val launchRepository: FetchRocketRepository
) : ViewModel() {

    private val resultRocketLiveData = MutableLiveData<Rocket>()
    private val resultRocketErrorLiveData = MutableLiveData<Throwable>()

    fun fetchRocketDetails(id: String) {
        viewModelScope.launch {
            val resultRocket = launchRepository.getRocketDetails(id)

            when (resultRocket) {
                is Results.Success -> {
                    resultRocket.data.let {
                        resultRocketLiveData.value = it
                    }
                }
                is Results.Error -> {
                    resultRocketErrorLiveData.value = Throwable()
                }
            }
        }
    }
}