package com.devpass.spaceapp.launchpad.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.devpass.spaceapp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.devpass.spaceapp.databinding.ActivityLaunchpadDetailsBinding
import com.devpass.spaceapp.utils.latitude
import com.devpass.spaceapp.utils.longitude
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LaunchpadDetailsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLaunchpadDetailsBinding
    private val viewModel by viewModels<LaunchDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLaunchpadDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        observeData()
    }

    private fun setupToolbar() {
        val toolbar = binding.includeToolbar.tvToolbarTitle
        toolbar.text = resources.getString(R.string.label_launchpad)
        toolbar.gravity = Gravity.CENTER
    }

    fun observeData() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is State.Loading -> {
                        binding.apply {
                            viewFlipper.displayedChild = 0
                        }
                    }
                    is State.Success -> {
                        binding.apply {
                            viewFlipper.displayedChild = 2
                            tvLaunchpad.text = state.name
                            tvNameLaunchpad.text = state.fullName
                            tvLaunchSite.text = state.locale
                            tvLaunchAttempts.text = state.attempts
                            tvLaunchSuccesses.text = state.successes
                        }
                    }
                    is State.Failure -> {
                        binding.apply {
                            viewFlipper.displayedChild = 1
                            errorText.text = state.error
                        }
                    }
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val launchpad = LatLng(latitude, longitude)
        val zoomLevel = 15f

        mMap.addMarker(MarkerOptions().position(launchpad))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(launchpad, zoomLevel))
    }
}