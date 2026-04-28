package data.dao

import com.example.prog7313_poe_part2.Costs

//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import com.example.prog7313_poe_part2.Costs
//import com.example.prog7313_poe_part2.data.Expense

//@Dao
interface CostDao {
 // @Insert
  suspend fun insertCost(expense:Costs)

   // @Query("SELECT*FROM costs")
    suspend fun getAllCosts():List<Costs>


}