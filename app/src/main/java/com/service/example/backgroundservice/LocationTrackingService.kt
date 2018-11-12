package com.service.example.backgroundservice

import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import androidx.core.app.NotificationCompat

class LocationTrackingService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()

        createNotification()

        //add your code here
    }

    private fun createNotification() {

        val stop: String = "stop"
        registerReceiver(stopReceiver, IntentFilter(stop))
        val broadcastIntent: PendingIntent = PendingIntent.getBroadcast(this, 0, Intent(stop), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(this)
                .setContentTitle("App Name")
                .setContentText("Tap to stop the Service")
                .setOngoing(true)
                .setContentIntent(broadcastIntent)
                .setSmallIcon(R.drawable.train)

        startForeground(1, builder.build())
    }

    val stopReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            callUnregister()
            stopSelf()
        }
    }

    private fun callUnregister() {
        unregisterReceiver(stopReceiver)
    }
}
