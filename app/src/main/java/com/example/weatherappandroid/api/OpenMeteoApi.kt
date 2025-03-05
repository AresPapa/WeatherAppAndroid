package com.example.weatherappandroid.api

import com.example.weatherappandroid.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("timezone") timezone: String = "auto",
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("hourly") hourly: String = "temperature_2m,relative_humidity_2m,weather_code",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min,weather_code"
    ): WeatherResponse
}