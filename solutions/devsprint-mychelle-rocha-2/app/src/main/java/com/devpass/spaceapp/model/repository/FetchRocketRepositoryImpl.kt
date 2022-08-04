package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.repository.FetchRocketRepository

class FetchRocketRepositoryImpl(private val api: SpaceXAPIService) : FetchRocketRepository {
    override suspend fun getRocketDetails(id: String) = api.fetchRocketDetails(id)
}