package com.example.screenon

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {


    override fun onCreate(database: SQLiteDatabase?) {
            val sql = "CREATE TABLE ${DbTable.TABLE_NAME} (" +
                    "${DbTable.ID} INTEGER PRIMARY KEY," +
                    "${DbTable.DATE} TEXT"+
                    ")"
            database?.execSQL(sql)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }



    companion object {
        private const val DB_NAME = "TasksDatabase"
        private const val DB_VERSION = 1
    }
}