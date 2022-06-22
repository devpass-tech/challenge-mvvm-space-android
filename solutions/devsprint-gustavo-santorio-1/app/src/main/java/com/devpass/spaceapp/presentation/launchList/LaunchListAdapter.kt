package com.devpass.spaceapp.presentation.launchList

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ListItemBinding
import com.devpass.spaceapp.launch.model.LaunchModel

class LaunchListAdapter : ListAdapter<LaunchModel, LaunchViewHolder>(LaunchModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class LaunchViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val imageLaunch = binding.ivLogo
    private val numberLaunch = binding.tvNumber
    private val nameLaunch = binding.tvName
    private val dateLaunch = binding.tvDate
    private val statusLaunch = binding.tvStatus

    fun bind(model: LaunchModel) {
        Glide
            .with(imageLaunch.context)
            .load(model.image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageLaunch)
        numberLaunch.text = model.number.toString()
        nameLaunch.text = model.name
        dateLaunch.text = model.date
        statusLaunch.text = model.status.toString()
    }

    companion object {
        fun from(parent: ViewGroup): LaunchViewHolder {
            return LaunchViewHolder(
                ListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}