package com.devpass.spaceapp.fetchNextLaunch.data

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.fetchNextLaunch.domain.model.FetchNextLaunchDTO
import com.devpass.spaceapp.fetchNextLaunch.domain.FetchNextLaunchRepository
import com.devpass.spaceapp.fetchNextLaunch.domain.model.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class FetchNextLaunchRepositoryImpl(
    private val apiService: SpaceXAPIService = NetworkModule.retrofitInstance.create(
        SpaceXAPIService::class.java)
) : FetchNextLaunchRepository {
    override suspend fun fetchNextLaunch(): Flow<ResultStatus<FetchNextLaunchDTO>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    val request = apiService.fetchNextLaunch()
                    emit(ResultStatus.Success(request))
                } catch (e: Exception) {
                    emit(ResultStatus.Error(e))
                }
            }
        }
    }
}