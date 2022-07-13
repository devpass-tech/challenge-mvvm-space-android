package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("/v4/rockets/{id}")
    suspend fun getDetailRocket(@Path("id") idRocket: String) : RocketDetailDTO
}