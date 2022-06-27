package com.devpass.spaceapp.data.api

import retrofit2.http.GET

interface SpaceXAPIService {

    @GET
    fun getList() : List<String>

}