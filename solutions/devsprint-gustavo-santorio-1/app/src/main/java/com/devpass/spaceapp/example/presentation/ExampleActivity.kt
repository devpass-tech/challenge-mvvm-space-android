package com.devpass.spaceapp.example.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.devpass.spaceapp.databinding.ActivityTabBinding
import kotlinx.coroutines.launch

class ExampleActivity : AppCompatActivity() {

    private val viewModel : ExampleViewModel by viewModels()

    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.listLiveData.observe(this) {
            println(it)
        }

        viewModel.userNameLiveData.observe(this) {
            println(it)
        }

        viewModel.userEmailLiveData.observe(this) {
            println(it)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userNameStateFlow.collect {
                    println()
                }
            }
        }

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btRunBack.setOnClickListener {
            viewModel.runGetList()
        }
    }
}