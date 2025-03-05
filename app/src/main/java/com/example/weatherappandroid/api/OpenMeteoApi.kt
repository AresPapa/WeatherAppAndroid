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
        @Query("current") current: String = "weather_code, temperature_2m",
        @Query("hourly") hourly: String = "time, weather_code, temperature_2m, relative_humidity_2m",
        @Query("daily") daily: String = "time, weather_code, temperature_2m_max, temperature_2m_min"
    ): WeatherResponse
}