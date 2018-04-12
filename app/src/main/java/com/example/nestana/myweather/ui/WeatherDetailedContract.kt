package com.example.nestana.myweather.ui

import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.model.weather.DailyForecasts
import com.example.nestana.myweather.other.Lifecycle

/**
 * Created by admin on 4/12/18.
 */
interface WeatherDetailedContract {
    interface View {
        fun onWeatherDetailedSuccess(model: Weather)
        fun onWeatherWeekSuccess(list: ArrayList<DailyForecasts>)

        fun onWeatherDetailedFail(message: String)
        fun onWeatherWeekFail(message: String)


    }

    interface Presenter : Lifecycle<View> {
        fun loadWeatherDetailed()
        fun loadWeatherWeek()

    }
}