package com.example.memorylist.dal

import android.content.Context
import androidx.room.Room
import com.example.memorylist.model.Memory

class MemoryRepository(private val context: Context){
    private var db :AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()

    fun closeDB(){
        db.close()
        db.isOpen
    }
    fun getAllMemories():List<Memory>{
        return db.memoryDao().getAll()
    }
    fun updateAllMemories(memories:List<Memory>){
        return db.memoryDao().insertAll(memories)
    }
}