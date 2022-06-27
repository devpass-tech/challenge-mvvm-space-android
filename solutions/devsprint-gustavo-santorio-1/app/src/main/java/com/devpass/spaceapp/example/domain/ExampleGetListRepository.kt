package com.devpass.spaceapp.example.domain

import kotlinx.coroutines.flow.Flow

interface ExampleGetListRepository {
    fun getList() : Flow<List<String>>
}