package com.service.example.backgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startServiceButton =    findViewById<Button>(R.id.serviceButton)
        startServiceButton.setOnClickListener( {
            val intent = Intent(this, LocationTrackingService::class.java)
            startService(intent)
            finish()
        })
    }
}
