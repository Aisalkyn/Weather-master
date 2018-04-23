 package com.example.nestana.myweather.ui.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import com.example.nestana.myweather.R
import com.example.nestana.myweather.StartApplication
import com.example.nestana.myweather.model.Weather
import com.example.nestana.myweather.ui.weather_week.WeatherDetailedActivtiy
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), MainContract.View {


     private var presenter: MainPresenter? = null
     private var locationManager: LocationManager? = null
     private var listener: LocationListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

     private fun init(){
         initPresenter()
         layout_weather.setOnClickListener {
             val intent = Intent(this, WeatherDetailedActivtiy::class.java)
             startActivity(intent)
         }
         initlocationManager()

     }
     private fun initlocationManager(){
         locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
         listener = object : LocationListener {
             override fun onLocationChanged(location: Location) {
                 loc_text.append("\n " + location.longitude + " " + location.latitude)
             }

             override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {

             }

             override fun onProviderEnabled(s: String) {

             }

             override fun onProviderDisabled(s: String) {

                 val i = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                 startActivity(i)
             }
         };

         configure_button()

     }

     private fun initPresenter(){

         val app = this.applicationContext as StartApplication
         presenter = MainPresenter(app.service, this)
         presenter!!.bind(this)
         presenter!!.loadWeather()
     }

     override fun onWeatherSuccess(model: Weather) {
         city_name.text= model.name
         temperature_c.text = ((model.main!!.temp!! - 273.15).toInt()).toString() + ""

     }

     override fun onWeatherFail(message: String) {
         Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()

     }

     override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
         when (requestCode) {
             10 -> configure_button()
             else -> {
             }
         }
     }

     internal fun configure_button() {
         // first check for permissions
         if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                 requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET), 10)
             }
             return
         }
         // this code won't execute IF permissions are not allowed, because in the line above there is return statement.
        loc_but.setOnClickListener(object : View.OnClickListener {
             override fun onClick(view: View) {


                 if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                     // TODO: Consider calling
                     //    ActivityCompat#requestPermissions
                     // here to request the missing permissions, and then overriding
                     //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                     //                                          int[] grantResults)
                     // to handle the case where the user grants the permission. See the documentation
                     // for ActivityCompat#requestPermissions for more details.
                     return
                 }
                 locationManager!!.requestLocationUpdates("gps", 5000, 0f, listener)
             }
         })
     }

     override fun onCreateOptionsMenu(menu: Menu): Boolean {
         menuInflater.inflate(R.menu.menu_search, menu)
         val menuItem = menu.findItem(R.id.menuSearch)
         val searchView = menuItem.actionView as SearchView
         searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
             override fun onQueryTextSubmit(query: String): Boolean {
                 return false
             }

             override fun onQueryTextChange(newText: String): Boolean {

                 //adapter.getFilter().filter(newText)
                 return false
             }
         })

         return super.onCreateOptionsMenu(menu)
     }


}
