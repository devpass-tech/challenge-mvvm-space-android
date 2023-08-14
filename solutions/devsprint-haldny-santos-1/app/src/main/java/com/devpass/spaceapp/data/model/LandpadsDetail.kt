package com.devpass.spaceapp.data.model

import com.squareup.moshi.Json

data class LandpadsDetail(
    @Json(name = "name")
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "locality")
    val locality: String,
    @Json(name = "region")
    val region: String,
    @Json(name = "latitude")
    val latitude: String,
    @Json(name = "landing_attempts")
    val landingAttempts: Int,
    @Json(name = "landing_successes")
    val landingSuccesses: Int,
    @Json(name = "details")
    val details: String,
    @Json(name = "id")
    val id: String,

)