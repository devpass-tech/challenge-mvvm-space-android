package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.Network
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.repository.FetchLaunchesRepository

class FetchRocketRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun getRocketDetails(usersResultCallback: (result: Network) -> Unit) {
        api.fetchRocketDetails(id = "a")
    }

}