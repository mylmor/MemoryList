package com.example.memorylist.dal

import androidx.room.*
import com.example.memorylist.model.Memory
import com.example.memorylist.model.MemoryWithDates

@Dao
interface MemoryDao {
    @Query("SELECT * FROM memory")
    fun getAll(): List<Memory>

    @Transaction
    @Query("SELECT * FROM memory")
    fun getAllWithDates():List<MemoryWithDates>
  /*  @Query("SELECT * FROM Memory WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Memory
*/
    @Insert
    fun insertAll(memories: List<Memory>)

    @Delete
    fun delete(memory: Memory)

    @Insert
    fun insert(memory: Memory)
}