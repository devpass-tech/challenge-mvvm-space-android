package com.devpass.spaceapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule{

    private const val BASE_URL = "https://api.spacexdata.com/"

    fun create(): SpaceXAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(SpaceXAPIService::class.java)
    }
}
