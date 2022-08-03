package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.Network

interface FetchLaunchesRepository {
    suspend fun getRocketDetails(usersResultCallback: (result: Network) -> Unit)

}