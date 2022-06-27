package com.devpass.spaceapp.example.domain

import kotlinx.coroutines.flow.Flow

interface ExampleGetListUseCase {
    fun getList() : Flow<List<String>>
}