package com.devpass.spaceapp.data.api
import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path
import com.devpass.spaceapp.launchpad.domain.dto.LaunchpadDTO
import retrofit2.http.GET
import retrofit2.http.Query
interface SpaceXAPIService {

    @GET("/v4/rockets/{id}")
    suspend fun getDetailRocket(@Path("id") idRocket: String) : RocketDetailDTO
    @GET("/v4/launchpads/{id}")
    suspend fun fetchLaunchpadDetails(@Query("id") id: String): LaunchpadDTO
}