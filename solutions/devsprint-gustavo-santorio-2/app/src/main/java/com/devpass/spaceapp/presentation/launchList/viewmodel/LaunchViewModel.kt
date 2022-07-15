package com.devpass.spaceapp.presentation.launchList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.presentation.launchList.LaunchModel
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Mudar a classe do ViewModel posteriormente
class LaunchViewModel(private val repository: FetchLaunchesRepository) : ViewModel() {
    val isResult = MutableLiveData<Boolean>()
    val launchModel = MutableLiveData<LaunchModel>()
    val message = MutableLiveData<String>()

    fun getLaunch() {
        viewModelScope.launch(Dispatchers.IO) {
            isResult.postValue(true)
            repository.fetchLaunch().onSuccess {
                launchModel.postValue(it)
            }.onFailure { message.postValue(it.message) }
        }
    }
}