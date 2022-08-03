package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.*
import com.devpass.spaceapp.repository.FetchLaunchesRepository

class FetchRocketRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun fetchLaunches(): NextLaunchesModel {
        return api.fetchNextLaunches(getParams())
    }

    override suspend fun getRocketDetails(usersResultCallback: (result: Network) -> Unit) {
        api.fetchRocketDetails(id = "a")
    }
    private fun getParams() =
        QueryRequestParams(OptionsRequest(20))
}