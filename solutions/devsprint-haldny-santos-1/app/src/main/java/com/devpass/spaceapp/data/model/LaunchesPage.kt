package com.devpass.spaceapp.data.model

import com.squareup.moshi.Json

data class LaunchesPage(
    @Json(name = "docs")
    val docs: List<String>,
    @Json(name = "totalDocs")
    val totalDocs: Int,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "totalPages")
    val totalPages: Int,
    @Json(name = "page")
    val page: Int,
    @Json(name = "pagingCounter")
    val pagingCounter: Int,
    @Json(name = "hasPrevPage")
    val hasPrevPage: Boolean,
    @Json(name = "hasNextPage")
    val hasNextPage: Boolean,
    @Json(name = "prevPage")
    val prevPage: Int?,
    @Json(name = "nextPage")
    val nextPage: Int?
)
