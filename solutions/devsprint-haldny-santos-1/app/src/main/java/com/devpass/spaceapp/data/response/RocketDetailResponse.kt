package com.devpass.spaceapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RocketDetailResponse(
    val id: String,
    val name: String,
    val description: String,
    @Json(name="flickr_images")
    val flickrImages: List<String>
)