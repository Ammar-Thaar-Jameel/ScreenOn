package com.example.screenon.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.screenon.data.DataManager
import java.util.*

class MyBrodcastReciver:BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                if (p1.extras?.getBoolean("state") == true) {

                    Toast.makeText(p0, "testOne", Toast.LENGTH_SHORT).show()

                } else{
                    val currentTime: Date = Calendar.getInstance().time
                    DataManager.addDate(currentTime.toString())
                    //Log.v("time111",currentTime.toString())

                    Toast.makeText(p0, "testTwo", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}