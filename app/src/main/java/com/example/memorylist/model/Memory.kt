package com.example.memorylist.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.text.DateFormat
import java.util.*

@Entity
data class Memory(
    @PrimaryKey
    var name:String,
    var lasTime: Date,
    var img:String?):Serializable