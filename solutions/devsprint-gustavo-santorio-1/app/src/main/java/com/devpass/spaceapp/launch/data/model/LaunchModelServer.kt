package com.devpass.spaceapp.launch.data.model

data class LaunchModelServer(val docs: List<Doc>)

data class Doc(
    val name: String,
    val flight_number: Int,
    val date_utc: String,
    val success: Boolean,
    val links: Links
)

data class Links(val patch: Patch)

data class Patch(val small: String)
