package com.example.weatherappandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weatherappandroid.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData by viewModel.weatherData.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            isLoading -> {
                Text(text = "Loading...", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            errorMessage != null -> {
                Text(text = "Error: $errorMessage", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            weatherData != null -> {
                Text(
                    text = "Weather: ${weatherData?.current?.temperature_2m}°C",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            else -> {
                Text(text = "No weather data available", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}