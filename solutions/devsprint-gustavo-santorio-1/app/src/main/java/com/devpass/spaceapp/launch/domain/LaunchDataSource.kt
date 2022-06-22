package com.devpass.spaceapp.launch.domain

import com.devpass.spaceapp.launch.data.model.LaunchModelServer

interface LaunchDataSource {
    fun getLaunch(): LaunchModelServer
}