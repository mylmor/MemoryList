package com.example.memorylist.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.memorylist.model.Memory

@Database(entities = [Memory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao
}