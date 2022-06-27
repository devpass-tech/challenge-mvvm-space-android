package com.devpass.spaceapp.example.domain

import com.devpass.spaceapp.example.data.ExampleGetListRepositoryImpl
import kotlinx.coroutines.flow.*

class ExampleGetListUseCaseImpl(private val getListRepository: ExampleGetListRepository = ExampleGetListRepositoryImpl()) : ExampleGetListUseCase{

    override fun getList(): Flow<List<String>> =
        getListRepository.getList()
            .map {
                val sortedList = it.toMutableList()
                sortedList.sort()
                sortedList
            }

}