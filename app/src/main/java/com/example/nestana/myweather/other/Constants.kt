package com.example.nestana.myweather.other

import kotlin.math.round

/**
 * Created by admin on 01.03.2018.
 */
class Constants {
    companion object {
        val KEY_API = "42f7f5712178a2caf10d529534f260ba"

        fun covertFromCalvinToCelsium(kelvinNumber: Double): Double? {
            return round(kelvinNumber - 273.15)
        }
    }
}