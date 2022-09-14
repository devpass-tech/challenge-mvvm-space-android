package com.devpass.spaceapp.utils

import com.devpass.spaceapp.presentation.launch_list.LaunchModel
import java.lang.Exception

sealed interface NetworkResult {
    data class Success(val data: List<LaunchModel>) : NetworkResult
    data class Error(val exception: Exception) : NetworkResult
}
