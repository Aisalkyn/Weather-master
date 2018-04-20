package com.example.nestana.myweather.other


import kotlin.math.round

/**
 * Created by admin on 01.03.2018.
 */
class Constants {
    companion object {
        val KEY_API = "1a40b6d9b0f6bf2c9add0e7df10225e4"
        val KEY_API_WEEK = "s5MlGND1pGZoFoIIIBZBUL9jSIopKR5O"



        fun covertFromKelvinToCelsium(kelvinNumber: Double): Double? {
            return round(kelvinNumber - 273.15)
        }
    }
}