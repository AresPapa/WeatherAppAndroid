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
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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
                Text(
                    text = "Hourly Weather:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                weatherData?.hourly?.time?.forEachIndexed { index, time ->
                    val formattedTime = ZonedDateTime.parse(time).format(DateTimeFormatter.ofPattern("HH:mm"))
                    Text(
                        text = "$formattedTime: ${weatherData!!.hourly.temperature_2m[index]}°C",
                        fontSize = 16.sp
                    )
                }
                Text(
                    text = "Daily Weather:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                weatherData?.daily?.time?.forEachIndexed { index, time ->
                    val formattedDay = ZonedDateTime.parse(time).format(DateTimeFormatter.ofPattern("dd"))
                    Text(
                        text = "$formattedDay: Max ${weatherData!!.daily.temperature_2m_max[index]}°C, Min ${weatherData!!.daily.temperature_2m_min[index]}°C",
                        fontSize = 16.sp
                    )
                }
            }
            else -> {
                Text(text = "No weather data available", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}