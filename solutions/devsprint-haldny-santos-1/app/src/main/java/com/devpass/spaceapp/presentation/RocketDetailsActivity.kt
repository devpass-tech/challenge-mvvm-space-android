package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding
import com.devpass.spaceapp.model.RocketDetail
import com.devpass.spaceapp.repository.RocketDetailRepository
import com.devpass.spaceapp.repository.RocketDetailRepositoryImpl
import kotlinx.coroutines.launch

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    private lateinit var api: SpaceXAPIService
    private lateinit var rocketDetailRepository: RocketDetailRepository
    private var rocketDetail: RocketDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        api = NetworkService.getSpaceXAPI()
        rocketDetailRepository = RocketDetailRepositoryImpl(api)

        binding.tbRocketDetailsBackButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            getData()
        }
    }

    private fun updateUI() {
        rocketDetail?.let { model ->
            with(binding) {
                tbRocketDetailsTitle.text = model.name
                textViewNameRocketDetails.text = model.name
                textViewDetailsRocketDetails.text = model.description
                Glide.with(baseContext)
                    .load(model.image)
                    .placeholder(android.R.color.transparent)
                    .into(imageViewRocketDetails)

            }
        }
    }

    private suspend fun getData() {
        try {
            val id = "5e9d0d96eda699382d09d1ee"
            rocketDetail = rocketDetailRepository.fetchRocketDetail(id)
            updateUI()
        } catch (e: Exception) {
            e.message?.let {
                showDialogErrorMessage(it)
            }.also {
                showDialogErrorMessage(getString(R.string.rocket_details_dialog_error_message))
            }
        }
    }

    private fun showDialogErrorMessage(error: String) {
        AlertDialog.Builder(baseContext)
            .setTitle(R.string.rocket_details_dialog_error_title)
            .setMessage(error)
            .setPositiveButton(android.R.string.ok) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .show()
    }

}
