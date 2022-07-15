package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.launchpad.domain.dto.LaunchpadDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXAPIService {

    @GET("/v4/launchpads/{id}")
    suspend fun fetchLaunchpadDetails(@Query("id") id: String): LaunchpadDTO
}