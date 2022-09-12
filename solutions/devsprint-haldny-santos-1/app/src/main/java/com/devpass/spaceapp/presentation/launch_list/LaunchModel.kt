package com.devpass.spaceapp.presentation.launch_list

import androidx.recyclerview.widget.DiffUtil

data class LaunchModel(
    val name: String,
    val number: String,
    var date: String,
    val status: String,
    val image: String
    ) {
    companion object : DiffUtil.ItemCallback<LaunchModel>() {
        override fun areItemsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem == newItem
        }
    }
}