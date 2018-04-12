package com.example.nestana.myweather.other

import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.model.weather.DailyForecasts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ForumService {

    @GET("data/2.5/weather")
    fun getWeather(@Query("q") cityName: String,
                   @Query("appid") apiKey: String): Call<Weather>

    @GET("forecasts/v1/daily/5day/222844")
    fun getWeatherWeek(@Query("apikey") apiKey: String): Call<ArrayList<DailyForecasts>>


}