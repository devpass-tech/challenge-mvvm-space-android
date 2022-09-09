package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.api.response.OptionsRequest
import com.devpass.spaceapp.data.api.response.QueryParams
import com.devpass.spaceapp.presentation.launchList.LaunchModel

class FetchLaunchesRepositoryImpl(
    val api: SpaceXAPIService = NetworkService.getSpaceXAPI(),
    val mapper: LaunchModelMapper = LaunchModelMapperImpl()
) : FetchLaunchesRepository {

    override suspend fun fetchLaunches(): List<LaunchModel> {
        return api.fetchNextLaunches(QueryParams(OptionsRequest(20))).docs.map { response ->
            mapper.transformToLaunchModel(response)
        }
    }
}
