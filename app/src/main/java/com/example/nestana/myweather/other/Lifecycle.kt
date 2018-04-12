package com.example.nestana.myweather.other

interface Lifecycle<V> {

    fun isViewAttached(): Boolean

    fun bind(view: V)

    fun unbind()
}