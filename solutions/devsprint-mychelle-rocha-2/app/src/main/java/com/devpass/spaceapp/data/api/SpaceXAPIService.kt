package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.model.Rocket
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("v4/rockets/{id}")
    suspend fun fetchRocketDetails(@Path("id") id: String): Call<Rocket>
}