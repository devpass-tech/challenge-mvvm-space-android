package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.Results

interface FetchLaunchesRepository {
    suspend fun fetchLaunches(): Results<NextLaunchesModel>
}