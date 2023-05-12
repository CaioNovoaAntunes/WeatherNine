package br.com.caio.weathernine

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("location") val location: LocationData,
    @SerializedName("current") val currentWeather: CurrentWeatherData
)

data class LocationData(
    @SerializedName("name") val cityName: String,
    @SerializedName("country") val countryName: String,


    ) {

}

data class CurrentWeatherData(
    @SerializedName("temp_c") val temperature: Float
)
