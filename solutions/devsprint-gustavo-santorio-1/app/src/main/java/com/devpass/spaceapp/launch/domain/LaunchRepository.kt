package com.devpass.spaceapp.launch.domain

import com.devpass.spaceapp.launch.model.LaunchModel

interface LaunchRepository {
    fun getLaunch(): List<LaunchModel>
}