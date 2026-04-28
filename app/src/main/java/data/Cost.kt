package com.example.prog7313_poe_part2.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="costs")
data class Cost(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val category:String,
    val amount: Double,
    val date:String,
    val description:String
)
