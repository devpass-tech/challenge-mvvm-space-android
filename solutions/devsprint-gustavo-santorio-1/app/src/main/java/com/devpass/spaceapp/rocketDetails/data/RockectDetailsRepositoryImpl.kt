package com.devpass.spaceapp.rocketDetails.data

import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsDataSource
import com.devpass.spaceapp.rocketDetails.domain.RocketDetailsRepository

class RockectDetailsRepositoryImpl(
    private val dataSource: RocketDetailsDataSource = RocketDetailsDataSourceImpl()) :
    RocketDetailsRepository {
}
