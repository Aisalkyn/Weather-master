 package com.example.nestana.myweather.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nestana.myweather.R
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

     private fun init(){
         layout_weather.setOnClickListener {
             val intent = Intent(this, WeatherDetailedActivtiy::class.java)
             startActivity(intent)
         }
     }
}
