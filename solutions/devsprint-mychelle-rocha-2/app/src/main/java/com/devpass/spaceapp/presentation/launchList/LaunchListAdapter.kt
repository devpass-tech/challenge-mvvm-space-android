package com.devpass.spaceapp.presentation.launchList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devpass.spaceapp.data.api.NextLaunchModel
import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.databinding.ListItemBinding

class LaunchListAdapter : ListAdapter<NextLaunchModel, LaunchViewHolder>(NextLaunchesModelDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
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

    fun bind(model: NextLaunchModel) {
        numberLaunch.text = model.flightNumber.toString()
        nameLaunch.text = model.nameRocket
        dateLaunch.text = model.date
        statusLaunch.text = if (model.status) "Success" else "Failure"
        Glide.with(itemView)
            .load(model.links.patch?.small)
            .into(imageLaunch)
    }
}