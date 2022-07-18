package com.devpass.spaceapp.detailRocket.data.repository

import NetworkModule
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailDTO
import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailVO
import com.devpass.spaceapp.detailRocket.domain.repository.RocketDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RocketDetailRepositoryImpl(private val rocketService: SpaceXAPIService =
    NetworkModule.retrofitInstance.create(SpaceXAPIService::class.java)) : RocketDetailRepository {

    override suspend fun getDetailRocket(id: String): Flow<Result<RocketDetailDTO>> = flow {
        val dataResult = rocketService.getDetailRocket(id)
        try {
            emit(Result.success(dataResult))
            RocketDetailVO(dataResult.name, dataResult.flickr_images, dataResult.description)
        } catch (exception: Exception) {
            emit(Result.failure(exception = Throwable(exception.message.toString())))
            exception.printStackTrace()
        }
    }
}