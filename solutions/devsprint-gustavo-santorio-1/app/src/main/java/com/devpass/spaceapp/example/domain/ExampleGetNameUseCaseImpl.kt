package com.devpass.spaceapp.example.domain

import com.devpass.spaceapp.example.data.ExampleGetNameRepositoryImpl
import java.util.*

class ExampleGetNameUseCaseImpl(private val exampleGetNameRepository: ExampleGetNameRepository = ExampleGetNameRepositoryImpl()) : ExampleGetNameUseCase{
    override fun getName(): String =
        exampleGetNameRepository.getName()
            .replaceFirstChar {
                if (it.isLowerCase())
                    it.titlecase(Locale.getDefault())
                else
                    it.toString()
            }
}