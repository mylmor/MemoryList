package com.example.memorylist.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
class MemoryWithDates(
    @Embedded
    val memory:Memory,
    @Relation(
        parentColumn = "name",
        entityColumn = "memoryName"
    )
    val dates : List<DateItem>
)