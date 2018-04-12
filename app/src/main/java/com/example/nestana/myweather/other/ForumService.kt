package com.example.nestana.myweather.other

import com.example.nestana.myweather.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ForumService {

    @GET("weather?")
    fun getWeather(@Query("q") cityName: String,
                   @Query("appid") apiKey: String
    ): Call<Weather>


}