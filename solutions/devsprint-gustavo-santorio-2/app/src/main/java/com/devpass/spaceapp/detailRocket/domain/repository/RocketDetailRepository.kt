package com.devpass.spaceapp.detailRocket.domain.repository

import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailDTO
import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailVO
import kotlinx.coroutines.flow.Flow

interface RocketDetailRepository {
    suspend fun getDetailRocket(id: String) : Flow<Result<RocketDetailDTO>>
}