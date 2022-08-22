package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.model.Rocket
import com.devpass.spaceapp.repository.FetchRocketRepository

class FetchRocketRepositoryImpl(private val api: SpaceXAPIService) : FetchRocketRepository {
    override suspend fun getRocket(id: String): Results<Rocket> {
        return try {
            Results.Success(api.fetchRocket(id))
        } catch (e: Exception) {
            Results.Error(Throwable())
        }
    }
}