package com.example.screenon

object DataManager {
    private val dataList = mutableListOf<String>()

    val datalistDb:List<String>
        get() = dataList

    fun addDate(date:String){
        dataList.add(date)
    }
}