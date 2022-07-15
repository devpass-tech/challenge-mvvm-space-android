package com.devpass.spaceapp.launchpad.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.launchpad.data.FetchLaunchesRepositoryImpl
import com.devpass.spaceapp.launchpad.domain.repository.FetchLaunchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

sealed class State {
    data class Success(
        val name: String,
        val fullName: String,
        val locale: String,
        val attempts: String,
        val successes: String
    ) : State()

    object Loading : State()
    data class Failure(val error: String) : State()
}

class LaunchDetailsViewModel(
    private val repository: FetchLaunchesRepository = FetchLaunchesRepositoryImpl()
) : ViewModel() {

    companion object {
        const val ID = "5e9e4502f509092b78566f87"
    }

    val state: MutableStateFlow<State> = MutableStateFlow(State.Loading)

    init {
        fetchLaunchpadData()
    }

    private fun fetchLaunchpadData(id: String = ID) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchLaunchpadDetails(id = id)
                .onSuccess {
                    state.value = State.Success(
                        name = it.name,
                        fullName = it.fullName,
                        locale = it.region,
                        attempts = it.launchAttempts,
                        successes = it.launchSuccesses
                    )
                }.onFailure {
                    state.value = State.Failure(
                        error = it.message.toString()
                    )
                }
        }
    }
}