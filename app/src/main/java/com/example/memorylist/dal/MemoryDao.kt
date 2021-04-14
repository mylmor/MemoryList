package com.example.memorylist.dal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.memorylist.model.Memory

@Dao
interface MemoryDao {
    @Query("SELECT * FROM memory")
    fun getAll(): List<Memory>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Memory

    @Insert
    fun insertAll(vararg users: Memory)

    @Delete
    fun delete(user: Memory)
}