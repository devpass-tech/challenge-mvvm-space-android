package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.*

private const val NUMBER_ROCKETS = 20

class FetchLaunchesRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun fetchLaunches(): NextLaunchesModel {
        return api.fetchNextLaunches(getParams())
    }

    override suspend fun getRocketDetails(usersResultCallback: (result: Network) -> Unit) {
        api.fetchRocketDetails(id = "a")
    }

    private fun getParams() =
        QueryRequestParams(OptionsRequest(NUMBER_ROCKETS))
}