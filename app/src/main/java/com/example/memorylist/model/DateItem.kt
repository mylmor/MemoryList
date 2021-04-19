package com.example.memorylist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class DateItem (
    @PrimaryKey
    val ID:Long,
    val memoryName:String,
    val date : Date)