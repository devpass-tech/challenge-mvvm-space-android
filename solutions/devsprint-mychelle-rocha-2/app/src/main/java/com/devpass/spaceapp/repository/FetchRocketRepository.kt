package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.model.Rocket

interface FetchRocketRepository {
    suspend fun getRocket(id: String): Results<Rocket>
}