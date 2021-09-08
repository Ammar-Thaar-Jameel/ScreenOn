package com.example.screenon.data

object DataManager {
    private val dataList = mutableListOf<String>()

    val datalistDb:List<String>
        get() = dataList

    fun addDate(date:String){
        dataList.add(date)
    }
}