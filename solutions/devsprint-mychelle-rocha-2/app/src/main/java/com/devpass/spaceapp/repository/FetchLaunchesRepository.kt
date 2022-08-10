package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.Launchpad

interface FetchLaunchesRepository {
    suspend fun fetchLaunches(): Results<NextLaunchesModel>
}