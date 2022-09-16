package com.devpass.spaceapp.repository

import com.devpass.spaceapp.model.LaunchpadDetail
import com.devpass.spaceapp.utils.NetworkResult

interface LaunchpadDetailRepository {
    suspend fun fetchLaunchpadDetails(id: String) : NetworkResult<LaunchpadDetail>
}
