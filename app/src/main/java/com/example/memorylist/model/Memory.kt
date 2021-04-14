package com.example.memorylist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Memory(
    @PrimaryKey
    var name:String,
    var lasTime: Date,
    var img:String?){

}