package com.devpass.spaceapp.fetchNextLaunch.domain

import com.devpass.spaceapp.fetchNextLaunch.domain.model.FetchNextLaunchDTO
import com.devpass.spaceapp.fetchNextLaunch.domain.model.ResultStatus
import kotlinx.coroutines.flow.Flow

interface FetchNextLaunchRepository {
    suspend fun fetchNextLaunch() : Flow<ResultStatus<FetchNextLaunchDTO>>
}