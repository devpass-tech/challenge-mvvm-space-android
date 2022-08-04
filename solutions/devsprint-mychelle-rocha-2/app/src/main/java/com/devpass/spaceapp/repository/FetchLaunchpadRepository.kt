package com.devpass.spaceapp.repository

import com.devpass.spaceapp.model.Launchpad

interface FetchLaunchpadRepository {
    suspend fun getLaunchpadDetails(id: String): Launchpad

}