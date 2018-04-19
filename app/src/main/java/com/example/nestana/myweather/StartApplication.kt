package com.example.nestana.myweather

import android.app.Application
import com.example.nestana.myweather.other.ForumService
import com.example.nestana.myweather.other.Network

class StartApplication : Application() {

    private val URL = "http://api.openweathermap.org/"
    private val URL_WEEK = "http://dataservice.accuweather.com/"

    var service: ForumService? = null
    var serviceWeek: ForumService? = null


    override fun onCreate() {
        super.onCreate()
        init()
    }

     private fun init(){
         service = Network.Companion.initService(URL)
         serviceWeek = Network.Companion.initService(URL_WEEK)

     }

}