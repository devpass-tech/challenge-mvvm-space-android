package com.devpass.spaceapp.example.data

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.example.domain.ExampleGetListDataSource
import com.devpass.spaceapp.example.domain.model.User
import kotlinx.coroutines.flow.*

class ExampleGetListDataSourceImpl() : ExampleGetListDataSource {

    override fun getList(): Flow<List<String>> =
        flow {
            /*emit(service.getList())*/
        }
}