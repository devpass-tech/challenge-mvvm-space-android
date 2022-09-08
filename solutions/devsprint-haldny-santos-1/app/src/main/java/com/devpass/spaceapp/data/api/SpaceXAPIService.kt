package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.response.RocketDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("rockets/{id}")
    fun fetchRocketDetails(@Path("id") id: String): Call<RocketDetailResponse>

}