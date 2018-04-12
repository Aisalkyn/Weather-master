package com.example.nestana.myweather.ui

import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.other.Lifecycle


interface MainContract {
    interface View {
        fun onWeatherSuccess(model:Weather )
        fun onWeatherFail()

    }

    interface Presenter : Lifecycle<View> {
        fun loadWeather()

    }
}
