package com.devpass.spaceapp.data.api

import com.google.gson.annotations.SerializedName

data class QueryRequestParams(
    @SerializedName("options")
    val options: OptionsRequest
)

data class OptionsRequest(
    @SerializedName("limit")
    val limit: Int
)