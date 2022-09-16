package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.repository.RocketDetailRepository
import com.devpass.spaceapp.repository.RocketDetailRepositoryImpl
import org.koin.dsl.module

val networkModule = module {
    single { NetworkService.getSpaceXAPI() }
    single<RocketDetailRepository> { RocketDetailRepositoryImpl(get()) }
}
