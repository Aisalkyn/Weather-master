package com.example.nestana.myweather.ui.main

import android.content.Context
import android.widget.Toast
import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.utils.Constants.Companion.KEY_API
import com.example.nestana.myweather.utils.ForumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var service: ForumService?,
                    var context: Context?) : MainContract.Presenter{


    var view: MainContract.View? = null
    override fun isViewAttached(): Boolean = view != null
    override  fun bind(view: MainContract.View){
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
    override fun loadWeather() {
        service!!.getWeather("Berlin", KEY_API).enqueue(object: Callback<Weather>{
            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                if (isViewAttached()) {
                    view!!.onWeatherSuccess(response!!.body()!!)
                } else {
                }
                view!!.onWeatherFail(response!!.message())
            }

            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                if (isViewAttached())
                    view!!.onWeatherFail(t!!.message!!)
                t!!.printStackTrace()
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()

            }
        })
    }

}
