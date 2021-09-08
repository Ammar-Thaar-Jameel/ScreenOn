package com.example.screenon

import android.content.ContentValues
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.screenon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataBaseHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val brodcastReciver = MyBrodcastReciver()
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)
        registerReceiver(brodcastReciver, filter)

        dataBaseHelper = DataBaseHelper(applicationContext)

        addlistener()
    }

    private fun addlistener() {
        binding.addButton.setOnClickListener() {
            val data = binding.myEditText.text.toString()
            addNewData(data)

        }
        binding.readButton.setOnClickListener() {
                readData()
        }
    }

    private fun readData() {
        val cursor=dataBaseHelper.readableDatabase.rawQuery("SELECT * FROM ${DbTable.TABLE_NAME}", arrayOf<String>())
            while (cursor.moveToNext()){
                val id=cursor.getInt(0)
                val data=cursor.getString(1)
                binding.myText.text=data
                Log.i("main","$id - $data")
            }
    }

    private fun addNewData(data:String) {
        DataManager.datalistDb.forEach{
            val newEntry = ContentValues().apply {

                put(DbTable.DATE,it)
        }
            dataBaseHelper.writableDatabase.insert(DbTable.TABLE_NAME, null, newEntry)
        }

    }
}