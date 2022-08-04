package com.devpass.spaceapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL_ROCKET = "https://api.spacexdata.com/"
object Network {

    private fun createRetrofit(): SpaceXAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_ROCKET)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpaceXAPIService::class.java)
    }

}