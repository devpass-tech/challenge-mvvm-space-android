package com.devpass.spaceapp.rocketDetails.domain

import kotlinx.coroutines.flow.Flow

interface RocketDetailsUseCase {

    fun getDetails(): Flow<RocketDetail>
}