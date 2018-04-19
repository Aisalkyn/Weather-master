package com.example.nestana.myweather.other

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ForumService {

    @GET("data/2.5/weather")
    fun getWeather(@Query("q") cityName: String,
                   @Query("appid") apiKey: String): Call<com.example.nestana.myweather.model.Weather>

    @GET("forecasts/v1/daily/5day/222844")
    fun getWeatherWeek(@Query("apikey") apiKey: String): Call<com.example.nestana.myweather.model.weather.Weatherweek>


}