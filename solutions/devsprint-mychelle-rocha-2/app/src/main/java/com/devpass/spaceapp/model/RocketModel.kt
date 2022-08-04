package com.devpass.spaceapp.model

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("description")
    val description: String,
    @SerializedName("first_flight")
    val firstFlight: String,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("stages")
    val stages: Int,
    @SerializedName("wikipedia")
    val wikipedia: String
)
