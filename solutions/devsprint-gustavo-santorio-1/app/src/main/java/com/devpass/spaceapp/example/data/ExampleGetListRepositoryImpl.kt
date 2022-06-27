package com.devpass.spaceapp.example.data

import com.devpass.spaceapp.example.domain.ExampleGetListDataSource
import com.devpass.spaceapp.example.domain.ExampleGetListRepository
import kotlinx.coroutines.flow.Flow

class ExampleGetListRepositoryImpl(private val exampleGetListDataSource: ExampleGetListDataSource = ExampleGetListDataSourceImpl()) : ExampleGetListRepository {
    override fun getList(): Flow<List<String>> =
        exampleGetListDataSource.getList()
}