package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.Rocket

interface FetchRocketRepository {
    suspend fun getRocketDetails(id: String): Results<Rocket>
}