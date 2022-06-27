package com.devpass.spaceapp.example.data

import com.devpass.spaceapp.example.domain.ExampleGetNameDataSource
import com.devpass.spaceapp.example.domain.ExampleGetNameRepository

class ExampleGetNameRepositoryImpl(private val exampleGetNameDataSource: ExampleGetNameDataSource = ExampleGetNameDataSourceImpl()) : ExampleGetNameRepository {
    override fun getName(): String =
        exampleGetNameDataSource.getName()
            .uppercase()
}