package com.aa.weatherforecast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aa.weatherforecast.api.DailyForecastApi
import com.aa.weatherforecast.databinding.ActivityMainBinding
import com.aa.weatherforecast.network.NetworkService

class MainActivity : AppCompatActivity() {


    val networkService = NetworkService()
    val retrofit = networkService.getRetrofitInstance()
    lateinit var dailyForecastApi: DailyForecastApi

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        dailyForecastApi = retrofit.create(DailyForecastApi::class.java)
    }

    override fun onResume() {
        super.onResume()


    }
}
