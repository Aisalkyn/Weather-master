package com.example.nestana.myweather.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by admin on 4/12/18.
 */
class DailyForecasts{
    @SerializedName("Date")
     var date: String? = null
    @SerializedName("Temperature")
     var temperature: Temperature? = null
    @SerializedName("Day")
     var day: Day? = null
    @SerializedName("Night")
     var night: Night? = null


}