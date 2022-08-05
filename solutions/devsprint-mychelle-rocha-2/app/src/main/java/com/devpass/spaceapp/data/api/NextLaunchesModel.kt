package com.devpass.spaceapp.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NextLaunchesModel(
    @SerializedName("docs")
    val docs: List<NextLaunchModel>?
) : Serializable

data class NextLaunchModel(
    @SerializedName("date_utc")
    val date: String = "",
    @SerializedName("details")
    val details: String = "",
    @SerializedName("flight_number")
    val flightNumber: Int = 0,
    @SerializedName("launchpad")
    val launchpad: String = "",
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val nameRocket: String = "",
    @SerializedName("rocket")
    val rocket: String = "",
    @SerializedName("success")
    val status: Boolean = false,
) : Serializable

data class Links(
    @SerializedName("patch")
    val patch: Patch?,
) : Serializable

data class Patch(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?
) : Serializable