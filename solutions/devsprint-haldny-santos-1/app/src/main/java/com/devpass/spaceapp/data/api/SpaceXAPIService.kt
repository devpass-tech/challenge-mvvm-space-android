package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.api.response.LaunchesPageResponse
import com.devpass.spaceapp.data.api.response.QueryParams
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchesPageResponse

}