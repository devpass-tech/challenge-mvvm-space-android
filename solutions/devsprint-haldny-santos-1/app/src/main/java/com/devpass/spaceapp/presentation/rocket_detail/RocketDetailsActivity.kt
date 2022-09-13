package com.devpass.spaceapp.presentation.rocket_detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding
import com.devpass.spaceapp.model.RocketDetail

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    private val viewModel: RocketDetailsViewModel by viewModels()

    private var rocketDetail: RocketDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tbRocketDetailsBackButton.setOnClickListener {
            onBackPressed()
        }

        lifecycleScope.launchWhenResumed {
            val id = "5e9d0d96eda699382d09d1ee"
            viewModel.loadRocketDetails(id)
        }

        renderRocketDetail()
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

    private fun showDialogErrorMessage() {
        AlertDialog.Builder(baseContext)
            .setTitle(R.string.rocket_details_dialog_error_title)
            .setMessage(R.string.rocket_details_dialog_error_message)
            .setPositiveButton(android.R.string.ok) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }.show()
    }

    private fun renderRocketDetail() {
        viewModel.rocketDetailsData.observe(this) {
            it.data?.let { model ->
                rocketDetail = model
                updateUI()
            }
            if (it.showError) {
                showDialogErrorMessage()
            }
        }
    }

}
