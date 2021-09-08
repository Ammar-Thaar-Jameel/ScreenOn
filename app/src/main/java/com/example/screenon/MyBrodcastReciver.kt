package com.example.screenon

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.util.*

class MyBrodcastReciver:BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            Intent.ACTION_SCREEN_ON -> {
                if (p1.extras?.getBoolean("stat") == true) {

                    Toast.makeText(p0, "hello", Toast.LENGTH_SHORT).show()

                } else{
                    val currentTime: Date = Calendar.getInstance().time
                    DataManager.addDate(currentTime.toString())
                    Log.v("time111",currentTime.toString())

                    Toast.makeText(p0, "hello2222", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}