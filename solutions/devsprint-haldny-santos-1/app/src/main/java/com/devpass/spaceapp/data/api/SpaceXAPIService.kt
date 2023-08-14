package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.QueryParams
import com.devpass.spaceapp.data.model.RocketsDetail as RocketsDetailResponse
import com.devpass.spaceapp.data.model.LandpadsDetail as LandpadsDetailResponse
import retrofit2.http.Body
import com.devpass.spaceapp.data.model.LaunchesPage as LaunchesPageResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIService {
    @GET("/launchpads/{id}")
    suspend fun getLandpadsDetail(@Path("id") id: String): LandpadsDetailResponse
    @GET("/rockets/{id}")
    suspend fun getRocketsDetail(@Path("id") id: String): RocketsDetailResponse
    @POST("/launches/query")
    suspend fun getsLaunches(@Body params: QueryParams): LaunchesPageResponse
}