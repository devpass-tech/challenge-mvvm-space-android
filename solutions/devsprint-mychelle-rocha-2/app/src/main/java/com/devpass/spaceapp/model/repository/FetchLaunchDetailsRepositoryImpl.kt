package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.repository.FetchLaunchDetailsRepository

class FetchLaunchDetailsRepositoryImpl(private val api: SpaceXAPIService): FetchLaunchDetailsRepository {
    override suspend fun getLaunchDetails(id: String) = api.fetchLaunchDetails(id)
}