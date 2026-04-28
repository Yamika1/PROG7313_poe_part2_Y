package data.database

import Data.dao.UserDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.Cost
import data.CycleGoal
import data.User
import data.dao.CostDao

@Database(
    entities=[User::class, Cost::class, CycleGoal::class],
    version=1,
    exportSchema = false
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun cycleDao(): CycleGoal
    abstract fun costDao() : CostDao

    companion object{
        @Volatile
        private var INSTANCE: data.database.RoomDatabase? = null

        fun getDatabase(context:Context): data.database.RoomDatabase {
            return INSTANCE?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java,
                    "BudgetBee_database"
                ).build()
                INSTANCE = instance as data.database.RoomDatabase?
                instance
            }
        }
    }
}