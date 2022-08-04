package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.OptionsRequest
import com.devpass.spaceapp.data.api.QueryRequestParams
import com.devpass.spaceapp.data.api.SpaceXAPIService


private const val NUMBER_ROCKETS = 20

class FetchLaunchesRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun fetchLaunches(): NextLaunchesModel {
        return api.fetchNextLaunches(getParams())
    }

    private fun getParams() =
        QueryRequestParams(OptionsRequest(NUMBER_ROCKETS))
}