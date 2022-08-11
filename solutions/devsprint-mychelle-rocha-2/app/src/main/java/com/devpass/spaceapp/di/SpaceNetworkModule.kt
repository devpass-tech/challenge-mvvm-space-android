package com.devpass.spaceapp.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val spaceNetworkModule = module {
    single<Retrofit> {
        create()
    }
}

private const val BASE_URL = "https://api.spacexdata.com/"

fun create() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
