package com.example.memorylist.model

import java.text.DateFormat
import java.util.*

object DateFormater {
    private val format = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE)
    fun fullDate(date:Date):String{
        return format.format(date)
    }
}