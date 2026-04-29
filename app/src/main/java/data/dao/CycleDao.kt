package data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import data.CycleGoal

@Dao
interface CycleDao {

    @Insert
    suspend fun insertCycleGoal(cycleGoal: CycleGoal)

    @Update
    suspend fun updateCycleGoal(cycleGoal: CycleGoal)

    @Query("SELECT * FROM cycle_goals WHERE month = :month LIMIT 1")
    suspend fun getCycleGoalByMonth(month: String): CycleGoal?

    @Query("SELECT * FROM cycle_goals ORDER BY cycleId DESC LIMIT 1")
    suspend fun getLatestCycleGoal(): CycleGoal?
}