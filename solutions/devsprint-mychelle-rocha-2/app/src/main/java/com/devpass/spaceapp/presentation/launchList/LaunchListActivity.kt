package com.devpass.spaceapp.presentation.launchList

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.databinding.ActivityLaunchListBinding
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.api.NextLaunchesModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchListBinding

    private lateinit var adapter: LaunchListAdapter
    private val viewModel: LaunchListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycleView()
        observerLaunchList()
        viewModel.fetchNextLaunches()
    }

    private fun observerLaunchList(){
        viewModel.nextLaunchesLiveData.observe(this){ state ->
            when(state){
                is StateView.Loading -> {
                    binding.pbLaunches.isVisible = state.isLoading
                }
                is StateView.Success -> {
                    adapter.submitList(state.data.nextLaunchModel)
                }
                is StateView.Empty -> {}
                is StateView.Error -> {
                    Log.i("Falha", "Error"+state)}
            }
        }
    }

    private fun setupRecycleView() {
        adapter = LaunchListAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}