package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.BuildConfig
import com.devpass.spaceapp.data.api.response.LaunchesPageResponse
import com.devpass.spaceapp.data.api.response.QueryParams
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchesPageResponse


    companion object SpaceXAPIClient {

        val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getSpaceXAPI() = retrofit.create(SpaceXAPIClient::class.java)
    }
}
