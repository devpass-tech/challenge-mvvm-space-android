package com.devpass.spaceapp.fetchNextLaunch.domain.usecase

import com.devpass.spaceapp.fetchNextLaunch.data.FetchNextLaunchRepositoryImpl
import com.devpass.spaceapp.fetchNextLaunch.domain.FetchNextLaunchRepository
import com.devpass.spaceapp.fetchNextLaunch.domain.model.formatDate
import com.devpass.spaceapp.fetchNextLaunch.domain.model.formatStatus
import com.devpass.spaceapp.fetchNextLaunch.domain.model.FetchNextLaunchVO
import com.devpass.spaceapp.fetchNextLaunch.domain.model.PresentationResultStatus
import com.devpass.spaceapp.fetchNextLaunch.domain.model.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFetchNextLaunchUseCase(
    private val fetchNextLaunchRepository : FetchNextLaunchRepository = FetchNextLaunchRepositoryImpl()
) : FetchNextLaunchUseCase {
    override suspend fun fetchNextLaunch(): Flow<PresentationResultStatus<FetchNextLaunchVO>> {
        return fetchNextLaunchRepository.fetchNextLaunch().map { resultStatus ->
            when(resultStatus){
                is ResultStatus.Error -> {
                    PresentationResultStatus.Error("Ocorreu um erro.")
                }
                is ResultStatus.Success -> {
                    val resultStatusDto = resultStatus.data
                    PresentationResultStatus.Success(
                        FetchNextLaunchVO(
                            name = resultStatusDto.name ?: "",
                            date = resultStatusDto.formatDate(),
                            image = resultStatusDto.links?.patch?.large ?: "",
                            status = resultStatusDto.formatStatus()
                        )
                    )
                }
            }
        }
    }
}