package com.example.nestana.myweather

import android.app.Application
import com.example.nestana.myweather.other.ForumService
import com.example.nestana.myweather.other.Network

class StartApplication : Application() {

    private val URL = "http://api.openweathermap.org/data/2.5/"

    var service: ForumService? = null

    override fun onCreate() {
        super.onCreate()
        init()
    }

     private fun init(){
         service = Network.Companion.initRetrofit(URL)    }

}