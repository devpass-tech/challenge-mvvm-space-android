package com.devpass.spaceapp.presentation.launchList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.databinding.ActivityLaunchListBinding
import com.devpass.spaceapp.launch.data.LaunchRepositoryImpl

class LaunchListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchListBinding

    private lateinit var adapter: LaunchListAdapter

    private var repository: LaunchRepositoryImpl = LaunchRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycleView()
        initLaunchList()
    }

    private fun initLaunchList() {
        val launchList = repository.getLaunch()
        adapter.submitList(launchList)
    }

    private fun setupRecycleView() {
        adapter = LaunchListAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}