package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.fetchNextLaunch.domain.model.FetchNextLaunchDTO

interface SpaceXAPIService {

    @GET("v5/launches/next")
    suspend fun fetchNextLaunch() : FetchNextLaunchDTO

}