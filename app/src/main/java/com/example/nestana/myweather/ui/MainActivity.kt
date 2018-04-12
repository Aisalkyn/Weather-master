 package com.example.nestana.myweather.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nestana.myweather.R
import com.example.nestana.myweather.StartApplication
import com.example.nestana.myweather.model.Weather
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), MainContract.View {


     private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

     private fun init(){
         initPresenter()
         layout_weather.setOnClickListener {
             val intent = Intent(this, WeatherDetailedActivtiy::class.java)
             startActivity(intent)
         }
     }

     private fun initPresenter(){
         val app = this.applicationContext as StartApplication
         presenter = MainPresenter(app.service, this)
         presenter!!.bind(this)
         presenter!!.loadWeather()
     }

     override fun onWeatherSuccess(model: Weather) {
         city_name.text= model.name
         temperature_c.text = model.main!!.temp.toString()

     }

     override fun onWeatherFail() {
     }
}
