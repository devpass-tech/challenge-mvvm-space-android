package com.devpass.spaceapp.rocketDetails.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.devpass.spaceapp.R

class RocketDetailsActivity : AppCompatActivity() {
    private val viewModel by viewModels<RocketDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_details)

    }

}