package com.devpass.spaceapp.model.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.model.Launchpad
import com.devpass.spaceapp.repository.FetchLaunchesRepository

class FechLaunchpadImpl (private val api: SpaceXAPIService) : FetchLaunchesRepository {

    override suspend fun fetchLaunches(): NextLaunchesModel {
        TODO("Not yet implemented")
        //preciso pegar do merge
    }

    override suspend fun fetchLaunchpad(): Launchpad {
        TODO("Not yet implemented")
    }
}