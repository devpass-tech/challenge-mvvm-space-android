package com.devpass.spaceapp.launchpad.domain.model

data class LaunchpadVO(
    val name: String,
    val fullName: String,
    val region: String,
    val launchAttempts: String,
    val launchSuccesses: String
)
