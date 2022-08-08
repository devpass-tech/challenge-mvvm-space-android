package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.model.Launchpad
import com.devpass.spaceapp.model.Rocket
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("v4/rockets/{id}")
    suspend fun fetchRocket(@Path("id") id: String): Rocket

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryRequestParams): NextLaunchesModel

    @GET("v4/launchpads/{id}")
    suspend fun fetchLaunchpadDetails(@Path("id") id: String): Launchpad
}