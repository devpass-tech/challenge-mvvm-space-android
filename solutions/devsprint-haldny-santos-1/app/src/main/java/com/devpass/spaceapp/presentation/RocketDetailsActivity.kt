package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.devpass.spaceapp.data.api.RetrofitService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.response.RocketDetailResponse
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    private lateinit var api: SpaceXAPIService
    private lateinit var rocketDetail: RocketDetailResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        api = RetrofitService.getInstance().create(SpaceXAPIService::class.java)

    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun updateUI() {
        with(binding) {
            tbRocketDetailsTitle.text = rocketDetail.name
            textViewNameRocketDetails.text = rocketDetail.name
            textViewDetailsRocketDetails.text = rocketDetail.description
            rocketDetail.flickrImages.firstOrNull()?.let {
                imageViewRocketDetails.load(it) {
                    crossfade(true)
                }
            }
            tbRocketDetailsBackButton.setOnClickListener {
                onBackPressed()
            }
        }
    }

    private fun getData() {
        val id = "5e9d0d96eda699382d09d1ee"
        val callback = api.fetchRocketDetails(id)
        callback.enqueue(object : Callback<RocketDetailResponse> {
            override fun onFailure(call: Call<RocketDetailResponse>, t: Throwable) {
                Log.e(TAG, "getData", t)
            }

            override fun onResponse(
                call: Call<RocketDetailResponse>,
                response: Response<RocketDetailResponse>
            ) {
                Log.i(TAG, response.body().toString())
                rocketDetail = response.body()!!
                updateUI()
            }
        })
    }

    companion object {
        const val TAG = "RocketDetailsActivity"
    }

}