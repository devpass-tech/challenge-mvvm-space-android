package com.devpass.spaceapp.repository

import com.devpass.spaceapp.presentation.launch_list.LaunchModel

interface FetchLaunchesRepository {

    suspend fun fetchLaunches() : List<LaunchModel>
}