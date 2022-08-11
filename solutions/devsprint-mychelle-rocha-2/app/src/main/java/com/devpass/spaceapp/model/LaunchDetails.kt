package com.devpass.spaceapp.model
import com.google.gson.annotations.SerializedName


data class LaunchDetails(
    @SerializedName("date_utc")
    val dateUtc: String?,
    @SerializedName("details")
    val details: Any?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("success")
    val success: Any?,
)

data class Links(
    @SerializedName("article")
    val article: Any?,
    @SerializedName("patch")
    val patch: Patch?,
)

data class Patch(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?
)