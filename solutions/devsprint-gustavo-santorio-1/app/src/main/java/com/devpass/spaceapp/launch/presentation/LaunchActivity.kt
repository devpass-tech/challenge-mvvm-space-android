package com.devpass.spaceapp.launch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.databinding.ActivityTabBinding
import com.devpass.spaceapp.presentation.FragmentDetails
import com.devpass.spaceapp.presentation.FragmentLaunchpad
import com.devpass.spaceapp.presentation.RocketFragment
import com.devpass.spaceapp.presentation.ViewPagerAdapter

class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(FragmentDetails(), RocketFragment(), FragmentLaunchpad())
        val fragmentsPageTitle = listOf("Details", "Rocket", "Launchpad")
        val viewPagerAdapter = ViewPagerAdapter(
            fragments = fragments,
            fragmentManager = supportFragmentManager,
            tittles = fragmentsPageTitle
        )

        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}