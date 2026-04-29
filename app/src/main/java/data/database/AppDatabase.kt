package data.database

import data.dao.UserDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.Cost
import data.CycleGoal
import data.User
import data.dao.CostDao
import data.dao.CycleDao

@Database(
    entities=[User::class, Cost::class, CycleGoal::class],
    version=1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun cycleDao(): CycleDao
    abstract fun costDao() : CostDao

    companion object{
        @Volatile
        private var INSTANCE: data.database.AppDatabase? = null

        fun getDatabase(context:Context): data.database.AppDatabase {
            return INSTANCE?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "BudgetBee_database"
                ).build()
                INSTANCE = instance as data.database.AppDatabase?
                instance
            }
        }
    }
}