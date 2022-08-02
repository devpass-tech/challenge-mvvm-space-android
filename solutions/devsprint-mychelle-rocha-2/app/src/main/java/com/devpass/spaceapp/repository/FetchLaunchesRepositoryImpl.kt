package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.OptionsRequest
import com.devpass.spaceapp.data.api.QueryRequestParams
import com.devpass.spaceapp.data.api.SpaceXAPIService

class FetchLaunchesRepositoryImpl(private val api:SpaceXAPIService): FetchLaunchesRepository {
    override suspend fun fetchLaunches() {
        api.fetchNextLaunches(getParams())
    }

    private fun getParams() =
        QueryRequestParams(OptionsRequest(20))
}