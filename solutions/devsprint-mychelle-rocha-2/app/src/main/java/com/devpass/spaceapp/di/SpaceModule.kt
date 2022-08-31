package com.devpass.spaceapp.di

import FetchLaunchesRepositoryImpl
import com.devpass.spaceapp.data.api.NetworkModule
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.model.repository.FetchRocketRepositoryImpl
import com.devpass.spaceapp.presentation.RocketDetailsViewModel
import com.devpass.spaceapp.presentation.launchList.LaunchListViewModel
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchRocketRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val spaceModules = module{
    factory<FetchLaunchesRepository>{FetchLaunchesRepositoryImpl(get())}
    factory { get<Retrofit>().create(SpaceXAPIService::class.java) }
    viewModel{LaunchListViewModel(get())}

    factory<FetchRocketRepository>{FetchRocketRepositoryImpl(get())}
    viewModel{RocketDetailsViewModel(get())}

}