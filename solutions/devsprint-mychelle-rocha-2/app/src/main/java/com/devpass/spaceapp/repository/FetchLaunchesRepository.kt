package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.model.Launchpad
import com.devpass.spaceapp.model.repository.FechLaunchpadImpl


interface FetchLaunchesRepository {
    suspend fun fetchLaunches(): NextLaunchesModel

    suspend fun fetchLaunchpad(): Launchpad
}