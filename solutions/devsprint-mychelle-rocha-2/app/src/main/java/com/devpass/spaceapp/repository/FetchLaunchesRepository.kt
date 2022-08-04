package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NextLaunchesModel


interface FetchLaunchesRepository {
    suspend fun fetchLaunches(): NextLaunchesModel
}