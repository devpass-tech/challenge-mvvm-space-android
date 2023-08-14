package com.devpass.spaceapp.data.model

import com.squareup.moshi.Json

data class Launches(
    @Json(name = "links")
    val links: Link,
    @Json(name = "rocket")
    val rocket: String,
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "name")
    val name: String,
    @Json(name = "date_utc")
    val dateUtc: String,
    @Json(name = "details")
    val details: String,
    @Json(name = "launchpad")
    val flightNumber: String,
    @Json(name = "id")
    val id: String,
)

data class Link(
    @Json(name = "patch")
    val patch: Patch
)

data class Patch(
    @Json(name = "small")
    val small: String
)