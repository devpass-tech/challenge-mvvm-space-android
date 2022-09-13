package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.LaunchDetails

interface FetchLaunchDetailsRepository {
    suspend fun getLaunchDetails(id: String): Results<LaunchDetails>
}