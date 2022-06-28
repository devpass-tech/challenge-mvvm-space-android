package com.devpass.spaceapp.rocketDetails.data

import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsRepository
import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsUseCase

class RocketDetailsUseCaseImpl(
    private val repository: RocketDetailsRepository = RockectDetailsRepositoryImpl()):RocketDetailsUseCase{
}