package com.example.nestana.myweather.ui.main

import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.other.Lifecycle


interface MainContract {
    interface View {
        fun onWeatherSuccess(model:Weather )
        fun onWeatherFail(message: String)

    }

    interface Presenter : Lifecycle<View> {
        fun loadWeather()

    }
}
