package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.repository.FetchLaunchpadRepository

class FetchLaunchpadRepositoryImpl (private val api: SpaceXAPIService) : FetchLaunchpadRepository {
    override suspend fun getLaunchpadDetails(id: String) = api.fetchLaunchpadDetails(id)

}