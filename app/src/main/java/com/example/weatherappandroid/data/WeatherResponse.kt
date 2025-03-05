package com.example.weatherappandroid.data

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val timezone: String,
    val current: CurrentWeather,
    val hourly: HourlyWeather,
    val daily: DailyWeather
)

data class CurrentWeather(
    val time: String,
    val weather_code: String,
    val temperature_2m: Double,
)

data class HourlyWeather(
    val time: List<String>,
    val weather_code: List<String>,
    val temperature_2m: List<Double>,
    val relative_humidity_2m: List<Double>
)

data class DailyWeather(
    val time: List<String>,
    val weather_code: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>
)
