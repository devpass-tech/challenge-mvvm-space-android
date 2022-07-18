package com.devpass.spaceapp.launchpad.data

import com.devpass.spaceapp.data.api.NetworkModule
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.launchpad.domain.repository.FetchLaunchesRepository
import com.devpass.spaceapp.launchpad.domain.model.LaunchpadVO

class FetchLaunchesRepositoryImpl(
    private val service: SpaceXAPIService = NetworkModule.retrofitInstance.create(SpaceXAPIService::class.java)
) : FetchLaunchesRepository {
    override suspend fun fetchLaunchpadDetails(id: String): Result<LaunchpadVO> {    
           return runCatching {
             val response = service.fetchLaunchpadDetails(id = id)
             with(response) {
                 LaunchpadVO(
                     name = name,
                     fullName = full_name,
                     region = region,
                     launchAttempts = launch_attempts.toString(),
                     launchSuccesses = launch_successes.toString()
                 )
             }
         }
     }
        return runCatching {
            val response = service.fetchLaunchpadDetails(id = id)
            with(response) {
                LaunchpadVO(
                    name = name,
                    fullName = full_name,
                    region = region,
                    launchAttempts = launch_attempts.toString(),
                    launchSuccesses = launch_successes.toString()
                )
            }
        }
    }
}
