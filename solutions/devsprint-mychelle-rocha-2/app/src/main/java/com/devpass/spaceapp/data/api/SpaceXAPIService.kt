package com.devpass.spaceapp.data.api

import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryRequestParams): NextLaunchesModel
}