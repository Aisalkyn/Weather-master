package com.example.nestana.myweather.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by admin on 4/12/18.
 */
class Day{
    @SerializedName("Icon")
    private var icon: Int? = null
    @SerializedName("IconPhrase")
    private var iconPhrase: String? = null


}