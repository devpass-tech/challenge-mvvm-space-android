package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.model.LaunchDetails
import com.devpass.spaceapp.repository.FetchLaunchDetailsRepository

class FetchLaunchDetailsRepositoryImpl(private val api: SpaceXAPIService): FetchLaunchDetailsRepository {
    override suspend fun getLaunchDetails(id: String) : Results<LaunchDetails> {
        return try {
            Results.Success(api.fetchLaunchDetails(id))
        } catch (e: Exception) {
            Results.Error(Throwable())
        }
    }
}