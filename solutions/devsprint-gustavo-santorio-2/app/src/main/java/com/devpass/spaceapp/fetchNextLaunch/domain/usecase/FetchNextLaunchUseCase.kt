package com.devpass.spaceapp.fetchNextLaunch.domain.usecase

import com.devpass.spaceapp.fetchNextLaunch.domain.model.FetchNextLaunchVO
import com.devpass.spaceapp.fetchNextLaunch.domain.model.PresentationResultStatus
import kotlinx.coroutines.flow.Flow

interface FetchNextLaunchUseCase {
    suspend fun fetchNextLaunch() : Flow<PresentationResultStatus<FetchNextLaunchVO>>
}