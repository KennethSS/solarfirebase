package com.solar.firebase.presentation

import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.gms.location.LocationServices
import com.solar.firebase.LocationController
import com.solar.firebase.R
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val locationObserver = MutableLiveData<Location>()
        locationObserver.observe(this, Observer {
            it?.let { location ->
                latitude.text = location.latitude.toString()
                longitude.text = location.longitude.toString()
            }
        })
        val locationController = LocationController(
                this,
                getSystemService(LOCATION_SERVICE) as LocationManager,
                LocationServices.getFusedLocationProviderClient(this),
                locationObserver
        )
        locationController.getLocation()
    }

    override fun onResume() {
        super.onResume()
    }
}