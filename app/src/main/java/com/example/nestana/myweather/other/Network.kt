package com.example.nestana.myweather.other

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class  Network {

    fun initRetrofit(URL: String): ForumService {
        return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(initGson()))
                .build()
                .create(ForumService::class.java)
    }

    private fun initGson(): Gson {
        return GsonBuilder().create()
    }
}
