package com.devpass.spaceapp.detailRocket.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RocketDetailDTO(
    @SerializedName("active")
    val active: Boolean,

    @SerializedName("boosters")
    val boosters: Int,

    @SerializedName("company")
    val company: String,

    @SerializedName("cost_per_launch")
    val cost_per_launch: Int,

    @SerializedName("country")
    val country: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("diameter")
    val diameter: Diameter,

    @SerializedName("engines")
    val engines: Engines,

    @SerializedName("first_flight")
    val firstFlight: String,

    @SerializedName("first_stage")
    val firstStage: FirstStage,

    @SerializedName("flickr_images")
    val flickr_images: List<String>,

    @SerializedName("height")
    val height: Height,

    @SerializedName("id")
    val id: String,

    @SerializedName("landing_legs")
    val landingLegs: LandingLegs,

    @SerializedName("mass")
    val mass: Mass,

    @SerializedName("name")
    val name: String,

    @SerializedName("payload_weights")
    val payloadWeights: List<PayloadWeight>,

    @SerializedName("second_stage")
    val second_stage: SecondStage,

    @SerializedName("stages")
    val stages: Int,

    @SerializedName("success_rate_pct")
    val sucessRatePCT: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("wikipedia")
    val wikipedia: String
)RocketDetailVO