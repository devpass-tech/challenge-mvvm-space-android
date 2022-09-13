package com.devpass.spaceapp.presentation.rocket_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.model.RocketDetail
import com.devpass.spaceapp.repository.RocketDetailRepository
import com.devpass.spaceapp.repository.RocketDetailRepositoryImpl
import kotlinx.coroutines.launch

class RocketDetailsViewModel(
    private val rocketDetailRepository: RocketDetailRepository = RocketDetailRepositoryImpl()
) : ViewModel() {
    private val _rocketDetailsData = MutableLiveData<RocketDetailsUiState>()
    val rocketDetailsData: LiveData<RocketDetailsUiState> = _rocketDetailsData

    fun loadRocketDetails(id: String) {
        viewModelScope.launch {
            try {
                val rocketDetail: RocketDetail = rocketDetailRepository.fetchRocketDetail(id)
                _rocketDetailsData.value = RocketDetailsUiState(
                    data = rocketDetail
                )
            } catch (exception: Exception) {
                _rocketDetailsData.value = RocketDetailsUiState(
                    error = exception
                )
            }

        }
    }
}

data class RocketDetailsUiState(
    val data: RocketDetail? = null,
    private val error: Exception? = null
) {
    val showError: Boolean
        get() = error != null
}
