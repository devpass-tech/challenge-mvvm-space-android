package com.devpass.spaceapp.launchpad.domain.repository

import com.devpass.spaceapp.launchpad.domain.model.LaunchpadVO

interface FetchLaunchesRepository {
    suspend fun fetchLaunchpadDetails(id: String): Result<LaunchpadVO>
}