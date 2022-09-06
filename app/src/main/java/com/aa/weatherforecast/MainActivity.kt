package com.aa.weatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.aa.weatherforecast.api.DailyForecastApi
import com.aa.weatherforecast.databinding.ActivityMainBinding
import com.aa.weatherforecast.network.NetworkService
import com.aa.weatherforecast.ui.theme.WeatherForecastTheme

class MainActivity : ComponentActivity() {
    
    private val networkService = NetworkService()
    private val retrofit = networkService.getRetrofitInstance()

    lateinit var dailyForecastApi: DailyForecastApi
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind the layout file using Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Optionally, you can use Compose for layout instead
//        setContent {
//            WeatherForecastTheme {
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    Greeting("Hello Android!")
//                }
//            }
//        }

        dailyForecastApi = retrofit.create(DailyForecastApi::class.java)

        // Do stuff with the API here.
    }

    @Composable
    fun Greeting(string: String) {
        Text(string)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        WeatherForecastTheme {
            Greeting("Hello Android!")
        }
    }
}
