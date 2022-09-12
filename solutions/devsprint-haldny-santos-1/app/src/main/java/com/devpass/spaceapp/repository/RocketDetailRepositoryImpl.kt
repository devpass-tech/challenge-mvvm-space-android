package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.mapper.toModel
import com.devpass.spaceapp.model.RocketDetail

class RocketDetailRepositoryImpl(val api: SpaceXAPIService = NetworkService.getSpaceXAPI()) : RocketDetailRepository {
    override suspend fun fetchRocketDetail(id: String): RocketDetail {
        return api.fetchRocketDetails(id).toModel()
    }
}
