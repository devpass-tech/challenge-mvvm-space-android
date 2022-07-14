package com.devpass.spaceapp.fetchNextLaunch.domain.model

import com.google.gson.annotations.SerializedName

data class FetchNextLaunchDTO(
    @SerializedName("auto_update")
    val autoUpdate: Boolean?,
    @SerializedName("capsules")
    val capsules: List<String>?,
    @SerializedName("cores")
    val cores: List<Core>?,
    @SerializedName("crew")
    val crew: List<Any>?,
    @SerializedName("date_local")
    val dateLocal: String?,
    @SerializedName("date_precision")
    val datePrecision: String?,
    @SerializedName("date_unix")
    val dateUnix: Int?,
    @SerializedName("date_utc")
    val dateUtc: String?,
    @SerializedName("details")
    val details: String?,
    @SerializedName("failures")
    val failures: List<Any>?,
    @SerializedName("fairings")
    val fairings: Any?,
    @SerializedName("flight_number")
    val flightNumber: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("launchpad")
    val launchpad: String?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("net")
    val net: Boolean?,
    @SerializedName("payloads")
    val payloads: List<String>?,
    @SerializedName("rocket")
    val rocket: String?,
    @SerializedName("ships")
    val ships: List<Any>?,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Int?,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("tdb")
    val tdb: Boolean?,
    @SerializedName("upcoming")
    val upcoming: Boolean?,
    @SerializedName("window")
    val window: Int?
)

data class Core(
    @SerializedName("core")
    val core: String?,
    @SerializedName("flight")
    val flight: Int?,
    @SerializedName("gridfins")
    val gridfins: Boolean?,
    @SerializedName("landing_attempt")
    val landingAttempt: Boolean?,
    @SerializedName("landing_success")
    val landingSuccess: Boolean?,
    @SerializedName("landing_type")
    val landingType: String?,
    @SerializedName("landpad")
    val landpad: String?,
    @SerializedName("legs")
    val legs: Boolean?,
    @SerializedName("reused")
    val reused: Boolean?
)

data class Flickr(
    @SerializedName("original")
    val original: List<String>?,
    @SerializedName("small")
    val small: List<Any>?
)

data class Links(
    @SerializedName("article")
    val article: String?,
    @SerializedName("flickr")
    val flickr: Flickr?,
    @SerializedName("patch")
    val patch: Patch?,
    @SerializedName("presskit")
    val presskit: String?,
    @SerializedName("reddit")
    val reddit: Reddit?,
    @SerializedName("webcast")
    val webcast: String?,
    @SerializedName("wikipedia")
    val wikipedia: String?,
    @SerializedName("youtube_id")
    val youtubeId: String?
)

data class Patch(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?
)

data class Reddit(
    @SerializedName("campaign")
    val campaign: String?,
    @SerializedName("launch")
    val launch: String?,
    @SerializedName("media")
    val media: String?,
    @SerializedName("recovery")
    val recovery: Any?
)

fun FetchNextLaunchDTO.formatDate() : String {
    val monthName = when(dateUtc?.substring(8..9)?.toInt()){
        1 -> {
            "January"
        }
        2 -> {
            "February"
        }
        3 -> {
            "March"
        }
        4 -> {
            "April"
        }
        5 -> {
            "May"
        }
        6 -> {
            "June"
        }
        7 -> {
            "July"
        }
        8 -> {
            "August"
        }
        9 -> {
            "September"
        }
        10 -> {
            "October"
        }
        11 -> {
            "November"
        }
        12 -> {
            "December"
        }
        else -> {
            "Desconhecido"
        }
    }
    return "$monthName ${dateUtc?.substring(5..6)},${dateUtc?.substring(0..3)}"
}

fun FetchNextLaunchDTO.formatStatus() : String{
    return success?.let {
        if (it) "Success" else "Failure"
    } ?: "Desconhecido"
}
