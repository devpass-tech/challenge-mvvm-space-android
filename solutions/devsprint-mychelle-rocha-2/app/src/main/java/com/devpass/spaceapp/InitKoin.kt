package com.devpass.spaceapp

import android.app.Application
import com.devpass.spaceapp.di.spaceModules
import com.devpass.spaceapp.di.spaceNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun initKoin(application: Application){
    startKoin {
        androidContext(application)
        modules(listOf(spaceModules, spaceNetworkModule))
    }
}