package br.com.caio.weathernine

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiClient {

    // https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=London

    private val BASE_URL = "https://api.weatherapi.com/v1/"
    private val apiKey = "YourCodeHere" // Substitua pelo sua chave de API

    private val apiService: WeatherApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(WeatherApiService::class.java)
    }

    fun getCurrentWeather(city: String): Call<WeatherData> {
        return apiService.getCurrentWeather(apiKey, city)
    }
}
