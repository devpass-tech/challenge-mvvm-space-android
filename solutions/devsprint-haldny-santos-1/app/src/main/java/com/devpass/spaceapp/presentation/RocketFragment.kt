package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentRocketBinding
import com.devpass.spaceapp.presentation.rocket_detail.RocketDetailsActivity

class RocketFragment : Fragment() {

    private lateinit var binding: FragmentRocketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRocketBinding.inflate(inflater, container, false)

        with(binding) {
            cardView.setOnClickListener {
                val intent = Intent(requireContext(), RocketDetailsActivity::class.java)
                startActivity(intent)
            }
        }


        return binding.root
    }
}