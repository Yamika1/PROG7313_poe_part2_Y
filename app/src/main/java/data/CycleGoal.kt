package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cycle_goals")
data class CycleGoal(
    @PrimaryKey(true)

    val id: Int= 0,
    val minGoal: Double,
    val maxGoal: Double
)