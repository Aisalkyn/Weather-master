package com.example.nestana.myweather.ui.weather_week

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nestana.myweather.R
import com.example.nestana.myweather.model.weather.DailyForecasts
import kotlinx.android.synthetic.main.cell_weather_week_day.view.*


class WeatherDetailedAdapter(var listOfOrders: List<DailyForecasts> ) : RecyclerView.Adapter<WeatherDetailedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.cell_weather_week_day, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(listOfOrders[position])
        holder.itemView!!.tag = position

    }

    fun setList(listOfOrders: List<DailyForecasts> ) {
        this.listOfOrders = listOfOrders
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listOfOrders.size

    override fun onViewRecycled(holder: ViewHolder?) {
        super.onViewRecycled(holder)
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: DailyForecasts) {

            itemView.titleofWeek.text = model.date
            itemView.high_temp.text = model.temperature!!.max!!.value.toString()
            itemView.lowest_temp.text = model.temperature!!.min!!.value.toString()
        }
    }

}