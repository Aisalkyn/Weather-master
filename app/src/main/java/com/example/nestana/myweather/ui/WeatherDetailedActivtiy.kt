package com.example.nestana.myweather.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.nestana.myweather.R
import com.example.nestana.myweather.StartApplication
import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.model.weather.DailyForecasts
import kotlinx.android.synthetic.main.activity_weather.*


class WeatherDetailedActivtiy : AppCompatActivity(), WeatherDetailedContract.View {


    private var presenter: WeatherDetailedPresenter? = null
    private var adapter: WeatherDetailedAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        init()

    }
    private fun init(){
        initPresenter()
        initRecyclerView()
    }

    private fun initPresenter(){

        val app = this.applicationContext as StartApplication
        presenter = WeatherDetailedPresenter(app.service, app.serviceWeek, this)
        presenter!!.bind(this)
        presenter!!.loadWeatherDetailed()
        presenter!!.loadWeatherWeek()

    }
    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WeatherDetailedAdapter(ArrayList())
        recyclerView.adapter = adapter
    }
    override fun onWeatherDetailedSuccess(model: Weather) {
        temperature_c.text = ((model.main!!.temp!! - 273.15).toInt()).toString() + "°C"
        city_name.text = model.name
    }

    override fun onWeatherDetailedFail(message: String) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()

    }
    override fun onWeatherWeekSuccess(list: ArrayList<DailyForecasts>) {
        adapter!!.setList(list)
    }

    override fun onWeatherWeekFail(message: String) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

}

// http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=s5MlGND1pGZoFoIIIBZBUL9jSIopKR5O
















