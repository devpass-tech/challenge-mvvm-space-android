package com.devpass.spaceapp.repository

import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.model.LaunchpadDetail
import com.devpass.spaceapp.utils.NetworkResult
import com.devpass.spaceapp.utils.latitude
import com.devpass.spaceapp.utils.longitude

class LaunchpadDetailRepositoryImpl(
    val api: SpaceXAPIService = NetworkService.getSpaceXAPI()
) : LaunchpadDetailRepository {

    override suspend fun fetchLaunchpadDetails(id: String): NetworkResult<LaunchpadDetail> {
        return try {
            NetworkResult.Success(data = LaunchpadDetail(
                id = "",
                name = R.string.label_launchpad.toString(),
                locality = R.string.label_name_launchpad.toString(),
                region = R.string.label_site_launch.toString(),
                latitude = latitude,
                longitude = longitude,
                launchAttempts = R.string.label_launch_attempts,
                launchSuccesses = R.string.label_launch_successes
            ))
        } catch (e: Exception) {
            NetworkResult.Error<Nothing>(exception = e)
            throw RuntimeException(e)
        }
    }
}
