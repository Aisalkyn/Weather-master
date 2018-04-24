package com.example.nestana.myweather.utils

interface Lifecycle<V> {

    fun isViewAttached(): Boolean

    fun bind(view: V)

    fun unbind()
}