package com.example.nestana.myweather.ui.weather_week

import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.model.weather.DailyForecasts
import com.example.nestana.myweather.utils.Lifecycle

/**
 * Created by admin on 4/12/18.
 */
interface WeatherDetailedContract {
    interface View {
        fun onWeatherDetailedSuccess(model: Weather)
        fun onWeatherWeekSuccess(list: List<DailyForecasts>)

        fun onWeatherDetailedFail(message: String)
        fun onWeatherWeekFail(message: String)


    }

    interface Presenter : Lifecycle<View> {
        fun loadWeatherDetailed()
        fun loadWeatherWeek()

    }
}