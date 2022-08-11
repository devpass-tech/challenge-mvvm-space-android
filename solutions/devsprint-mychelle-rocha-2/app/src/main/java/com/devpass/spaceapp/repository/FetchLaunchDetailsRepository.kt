package com.devpass.spaceapp.repository

import com.devpass.spaceapp.model.LaunchDetails

interface FetchLaunchDetailsRepository {
    suspend fun getLaunchDetails(id: String): LaunchDetails
}