package com.devpass.spaceapp.repository

import com.devpass.spaceapp.presentation.launchList.LaunchModel

interface FetchLaunchesRepository {
    suspend fun fetchLaunch(): Result<LaunchModel>
}