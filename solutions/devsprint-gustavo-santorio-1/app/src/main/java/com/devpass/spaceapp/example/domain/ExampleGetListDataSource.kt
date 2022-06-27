package com.devpass.spaceapp.example.domain

import kotlinx.coroutines.flow.Flow

interface ExampleGetListDataSource {
    fun getList() : Flow<List<String>>
}