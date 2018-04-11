package com.example.nestana.myweather.other

interface Lifecycle<V> {

    val isViewAttached: Boolean

    fun bind(view: V)

    fun unbind()
}