package br.com.caio.weathernine

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {
    private val weatherApiClient: WeatherApiClient = WeatherApiClient()

    fun getCurrentWeather(city: String, callback: (WeatherData?, Throwable?) -> Unit) {
        weatherApiClient.getCurrentWeather(city).enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful) {
                    val weatherData = response.body()
                    callback(weatherData, null)
                } else {
                    callback(null, Exception("Failed to get weather data"))
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                callback(null, t)
            }
        })
    }
}