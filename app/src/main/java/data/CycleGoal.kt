package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cycle_goals")
data class CycleGoal(
    @PrimaryKey(autoGenerate = true)
    val cycleId: Int = 0,
    val month: String,
    val minGoal: Double,
    val maxGoal: Double,
    val totalSpent: Double = 0.0
)
