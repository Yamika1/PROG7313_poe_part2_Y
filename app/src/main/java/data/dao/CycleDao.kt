package data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import data.CycleGoal


@Dao
interface CycleDao{

    @Insert
    suspend fun insertGoal(goal:CycleGoal)

    @Update()
    suspend fun updateGoal(goal: CycleGoal)

    @Query("SELECT*FROM cycle_goals LIMIT 1")
    suspend fun getGoal(): CycleGoal

}