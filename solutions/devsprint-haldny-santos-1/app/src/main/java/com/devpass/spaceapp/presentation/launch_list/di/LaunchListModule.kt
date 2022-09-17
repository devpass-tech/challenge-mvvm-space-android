package com.devpass.spaceapp.presentation.launch_list.di

import com.devpass.spaceapp.presentation.view_model.LaunchListViewModel
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchLaunchesRepositoryImpl
import com.devpass.spaceapp.repository.LaunchModelMapper
import com.devpass.spaceapp.repository.LaunchModelMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val launchListModule = module {

    single<FetchLaunchesRepository> { FetchLaunchesRepositoryImpl(get(), get()) }
    single<LaunchModelMapper> { LaunchModelMapperImpl() }

    viewModel { LaunchListViewModel(get()) }

}