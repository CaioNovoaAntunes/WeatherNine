package br.com.caio.weathernine

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    private val weatherRepository = WeatherRepository()

    val weatherLiveData: MutableLiveData<String> = MutableLiveData()

    fun getWeatherData(city: String) {
        weatherRepository.getCurrentWeather(city) { weatherData, error ->
            if (error != null) {
                // Trate o erro aqui, se necessário
            } else {
                val temperature = weatherData?.currentWeather?.temperature
                val cityName = weatherData?.location?.cityName
                val countryName = weatherData?.location?.countryName

                val weatherText = "City: $cityName\nCountry: $countryName\nTemperature: $temperature°C"
                weatherLiveData.value = weatherText
            }
        }
    }
}