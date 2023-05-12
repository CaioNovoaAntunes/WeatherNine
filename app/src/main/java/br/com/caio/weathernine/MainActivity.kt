package br.com.caio.weathernine

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var cityEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var weatherTextView: TextView
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityEditText = findViewById(R.id.cityEditText)
        submitButton = findViewById(R.id.submitButton)
        weatherTextView = findViewById(R.id.weatherTextView)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        submitButton.setOnClickListener {
            val city = cityEditText.text.toString().trim()

            if (city.isNotEmpty()) {
                getWeatherData(city)
            }
        }

        weatherViewModel.weatherLiveData.observe(this, Observer { weatherText ->
            weatherTextView.text = weatherText
        })
    }

    private fun getWeatherData(city: String) {
        weatherViewModel.getWeatherData(city)
    }
}

