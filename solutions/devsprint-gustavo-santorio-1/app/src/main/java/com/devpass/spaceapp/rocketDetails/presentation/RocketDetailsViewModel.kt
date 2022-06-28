package com.devpass.spaceapp.rocketDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsUseCase
import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsUseCaseImpl
import kotlinx.coroutines.launch

class RocketDetailsViewModel(
    private val useCase: RocketDetailsUseCase = RocketDetailsUseCaseImpl()):ViewModel() {
     init {
            getDetails()
        }
    private fun getDetails(){
        viewModelScope.launch {
            useCase.getDetails().collect{
                //criar livedata ou stateflow, atribuir valor e consumir na tela

            }
        }
    }
}