package com.devpass.spaceapp.repository

import com.devpass.spaceapp.model.Rocket

interface FetchRocketRepository {
    suspend fun getRocketDetails(id: String): Rocket
}