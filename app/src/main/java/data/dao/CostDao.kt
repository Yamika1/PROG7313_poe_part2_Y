package data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import data.Cost


@Dao
interface CostDao {
  @Insert
  suspend fun insertCost(expense: Cost)

    @Query("SELECT*FROM costs")
    suspend fun getAllCosts():List<Cost>

  @Query("SELECT SUM(amount) FROM costs")
  suspend fun getTotalBalance(): Double?
}