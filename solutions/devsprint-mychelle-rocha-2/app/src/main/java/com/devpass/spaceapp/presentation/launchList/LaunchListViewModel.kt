package com.devpass.spaceapp.presentation.launchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import kotlinx.coroutines.launch

class LaunchListViewModel(private val repository: FetchLaunchesRepository) : ViewModel() {

    private val resultNextLaunches = MutableLiveData<StateView<NextLaunchesModel>>()

    fun fetchNextLaunches() {
        resultNextLaunches.value = StateView.Loading()
        viewModelScope.launch {
            when (val result = repository.fetchLaunches()) {
                is Results.Success -> {
                    if (result.data.docs.isNullOrEmpty()) {
                        resultNextLaunches.value = StateView.Empty()
                    } else {
                        resultNextLaunches.value = StateView.Success(result.data)
                    }
                }
                is Results.Error -> {
                    resultNextLaunches.value = StateView.Error("Ops :( Tente novamente mais tarde.")
                }
            }
        }
    }
}