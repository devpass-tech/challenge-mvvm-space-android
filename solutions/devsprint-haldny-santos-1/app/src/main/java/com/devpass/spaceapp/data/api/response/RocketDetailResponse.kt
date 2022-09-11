package com.devpass.spaceapp.data.api.response

import com.google.gson.annotations.SerializedName

data class RocketDetailResponse(
    val id: String,
    val name: String,
    val description: String,
    @SerializedName("flickr_images")
    val flickrImages: List<String>
)