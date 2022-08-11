package com.devpass.spaceapp.presentation.launchList

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
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
        observerLaunchListData()
        viewModel.fetchNextLaunches()
    }

    private fun observerLaunchList(){
        viewModel.nextLaunchesLiveData.observe(this){ state ->
            binding.pbLaunches.isVisible = state.isLoading
            when(state){
                is StateView.Success -> {
                    adapter.submitList(state.data.nextLaunchModel)
                }
                is StateView.Empty -> {
                    binding.tvEmptyMessage.isVisible = true
                }
                is StateView.Error -> {
                    binding.tvErrorMessage.isVisible = true
                }
            }
        }
    }

    //Método para utilizar State com Data Class - colocar este método em OnCreate
    private fun observerLaunchListData(){
        viewModel.nextLaunchesDataLiveData.observe(this) { state ->
            binding.pbLaunches.isVisible = state.loading
            if (state.success) adapter.submitList(state.nextLaunchesModel?.nextLaunchModel)
            binding.tvEmptyMessage.isVisible = state.empty
            binding.tvErrorMessage.isVisible = state.error
        }
    }


    private fun setupRecycleView() {
        adapter = LaunchListAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}