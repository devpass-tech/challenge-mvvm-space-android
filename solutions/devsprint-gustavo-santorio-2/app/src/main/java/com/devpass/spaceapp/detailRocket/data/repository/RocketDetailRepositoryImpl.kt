package com.devpass.spaceapp.detailRocket.data.repository

import NetworkModule
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.detailRocket.domain.dto.RocketDetailDTO
import com.devpass.spaceapp.detailRocket.domain.repository.RocketDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import okio.IOException

class RocketDetailRepositoryImpl(private val rocketService: SpaceXAPIService =
    NetworkModule.retrofitInstance.create(SpaceXAPIService::class.java)) : RocketDetailRepository {

    override suspend fun getDetailRocket(id: String): Flow<Result<RocketDetailDTO>> = flow {
        val dataResult = rocketService.getDetailRocket(id)
        val messageError = MutableStateFlow<String>("")
        try {
            emit(Result.success(dataResult))
        } catch (exception: Exception) {
            emit(Result.failure(IOException()))
            exception.printStackTrace()
            messageError.value = exception.localizedMessage ?: "error"
        }
    }
}