package com.devpass.spaceapp.presentation.launchList

import androidx.recyclerview.widget.DiffUtil
import com.devpass.spaceapp.data.api.NextLaunchModel
import com.devpass.spaceapp.data.api.NextLaunchesModel

class NextLaunchesModelDiffUtil() : DiffUtil.ItemCallback<NextLaunchModel>() {
    override fun areItemsTheSame(oldItem: NextLaunchModel, newItem: NextLaunchModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: NextLaunchModel,
        newItem: NextLaunchModel
    ): Boolean {
        return oldItem == newItem
    }
}