package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.api.response.OptionsRequest
import com.devpass.spaceapp.data.api.response.QueryParams
import com.devpass.spaceapp.presentation.launch_list.LaunchModel
import com.devpass.spaceapp.utils.NetworkResult

class FetchLaunchesRepositoryImpl(
    val api: SpaceXAPIService = NetworkService.getSpaceXAPI(),
    val mapper: LaunchModelMapper = LaunchModelMapperImpl()
) : FetchLaunchesRepository {

    override suspend fun fetchLaunches(): NetworkResult<List<LaunchModel>> {
        return try {
            val response = api.fetchNextLaunches(QueryParams(OptionsRequest(20))).docs
            val launchList = response.map {
                mapper.transformToLaunchModel(it)
            }
            NetworkResult.Success(data = launchList)
        } catch (e: Exception) {
            NetworkResult.Error<Nothing>(exception = e)
            throw RuntimeException(e)
        }
    }
}
