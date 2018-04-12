package com.example.nestana.myweather.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by admin on 4/12/18.
 */
class Temperature{
    @SerializedName("Minimum")
    var min: Minimum? = null
    @SerializedName("Maximum")
    var max: Maximum? = null




}