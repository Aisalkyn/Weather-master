package com.example.nestana.myweather.ui

import android.content.Context
import android.widget.Toast
import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.model.weather.DailyForecasts
import com.example.nestana.myweather.other.Constants.Companion.KEY_API
import com.example.nestana.myweather.other.Constants.Companion.KEY_API_WEEK
import com.example.nestana.myweather.other.ForumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherDetailedPresenter(var service: ForumService?, var serviceWeek: ForumService?,
                    var context: Context?) : WeatherDetailedContract.Presenter{

    override fun isViewAttached(): Boolean = view != null

    var view: WeatherDetailedContract.View? = null

    override  fun bind(view: WeatherDetailedContract.View){
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
    override fun loadWeatherDetailed() {
        service!!.getWeather("Berlin", KEY_API).enqueue(object: Callback<Weather> {
            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                if (isViewAttached()) {
                view!!.onWeatherDetailedSuccess(response!!.body()!!)
            }
                else{
                    view!!.onWeatherDetailedFail(response!!.message())
                }
            }

            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                if (isViewAttached())
                    view!!.onWeatherDetailedFail(t!!.message!!)
                t?.printStackTrace()
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()

            }
        })
    }
    override fun loadWeatherWeek() {
        serviceWeek!!.getWeatherWeek(KEY_API_WEEK).enqueue(object: Callback<ArrayList<DailyForecasts>>{
            override fun onResponse(call: Call<ArrayList<DailyForecasts>>?, response: Response<ArrayList<DailyForecasts>>?) {

                if (isViewAttached()) {
                    view!!.onWeatherWeekSuccess(response!!.body()!!)
                } else
                    view!!.onWeatherWeekFail(response!!.message()!!)
            }

            override fun onFailure(call: Call<ArrayList<DailyForecasts>>?, t: Throwable?) {
                if (isViewAttached())
                    view!!.onWeatherWeekFail(t!!.message!!)
                t!!.printStackTrace()
                Toast.makeText(context, "HI", Toast.LENGTH_LONG).show()

            }
        })
    }




}