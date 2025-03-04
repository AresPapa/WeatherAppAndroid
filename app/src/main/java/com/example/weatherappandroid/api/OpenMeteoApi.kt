package com.example.weatherappandroid.api

import com.example.weatherappandroid.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,windspeed_10m",
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponse
}