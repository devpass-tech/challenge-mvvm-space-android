package com.devpass.spaceapp.rocketDetails.domain

import com.devpass.spaceapp.rocketDetails.data.RockectDetailsRepositoryImpl
import kotlinx.coroutines.flow.Flow

class RocketDetailsUseCaseImpl(
    private val repository: RocketDetailsRepository = RockectDetailsRepositoryImpl()
):RocketDetailsUseCase{
    override fun getDetails(): Flow<RocketDetail> {
        TODO("Not yet implemented")
    }
}