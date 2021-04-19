package com.example.memorylist.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.memorylist.model.DateItem
import com.example.memorylist.model.Memory
import com.example.memorylist.model.MemoryWithDates

@Database(entities = [Memory::class,DateItem::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao
}