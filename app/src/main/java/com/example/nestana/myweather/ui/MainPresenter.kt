package com.example.nestana.myweather.ui

import android.content.Context
import android.widget.Toast
import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.other.Constants.Companion.KEY_API
import com.example.nestana.myweather.other.ForumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var service: ForumService?,
                    var context: Context?) : MainContract.Presenter{


    var view: MainContract.View? = null
    override val isViewAttached: Boolean = view !=null
    override  fun bind(view: MainContract.View){
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
    override fun loadWeather() {
        service!!.getWeather("Bishkek", KEY_API).enqueue(object: Callback<Weather>{
            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                view!!.onWeatherSuccess(response!!.body()!!)
            }

            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()

            }
        })
    }

}
