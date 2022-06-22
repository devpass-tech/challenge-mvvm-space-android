package com.devpass.spaceapp.launch.data

import com.devpass.spaceapp.launch.domain.LaunchDataSource
import com.devpass.spaceapp.launch.domain.LaunchRepository
import com.devpass.spaceapp.launch.model.LaunchModel

class LaunchRepositoryImpl(private val dataSource: LaunchDataSource = LaunchDataSourceImpl()) :
    LaunchRepository {

    override fun getLaunch(): List<LaunchModel> {
        return dataSource.getLaunch().docs.map {
            LaunchModel(
                name = it.name,
                number = it.flight_number,
                date = it.date_utc,
                status = it.success,
                image = it.links.patch.small
            )
        }
    }
}