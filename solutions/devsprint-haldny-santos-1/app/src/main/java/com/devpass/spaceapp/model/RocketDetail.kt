package com.devpass.spaceapp.model

data class RocketDetail(
    val id: String,
    val name: String,
    val description: String,
    val flickrImages: List<String>
)