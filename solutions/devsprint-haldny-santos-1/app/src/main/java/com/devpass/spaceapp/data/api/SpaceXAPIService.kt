package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.api.response.LaunchesPageResponse
import com.devpass.spaceapp.data.api.response.QueryParams
import com.devpass.spaceapp.data.api.response.RocketDetailResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIService {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchesPageResponse

    @GET("rockets/{id}")
    fun fetchRocketDetails(@Path("id") id: String): Call<RocketDetailResponse>

}
