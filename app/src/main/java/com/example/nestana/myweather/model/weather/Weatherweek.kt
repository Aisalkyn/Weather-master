package com.example.nestana.myweather.model.weather

import com.google.gson.annotations.SerializedName

class Weatherweek{
    @SerializedName("DailyForecasts")
    var list: List<DailyForecasts>? = null
}