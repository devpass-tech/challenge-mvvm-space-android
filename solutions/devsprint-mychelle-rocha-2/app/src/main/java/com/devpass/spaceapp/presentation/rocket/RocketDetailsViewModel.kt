package com.devpass.spaceapp.presentation.rocket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.Rocket
import com.devpass.spaceapp.presentation.StateClassView
import com.devpass.spaceapp.presentation.launchList.StateViewData
import com.devpass.spaceapp.repository.FetchRocketRepository
import kotlinx.coroutines.launch

class RocketDetailsViewModel(
    private val launchRepository: FetchRocketRepository
) : ViewModel() {

    private val resultRocketLiveData = MutableLiveData<StateClassView<Rocket>>()
    private val resultRocketErrorLiveData =MutableLiveData(StateViewData())

    fun fetchRocketLaunches(id: String) {
        resultRocketLiveData.value = StateClassView.Loading()
        viewModelScope.launch {
            when (val result = launchRepository.getRocket(id)) {
                is Results.Success -> {
                    if (result.data.description.isNullOrEmpty()) {
                        resultRocketLiveData.value = StateClassView.Loading()
                    } else {
                        resultRocketLiveData.value = StateClassView.Success(result.data)
                    }
                }
                is Results.Error -> {
                    resultRocketLiveData.value = StateClassView.Error()
                }
            }
        }
    }
}