package rosas.luis.mymedicine.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import rosas.luis.mymedicine.data.dao.UserDao
import rosas.luis.mymedicine.data.dao.MedicineDao
import rosas.luis.mymedicine.data.entities.User
import rosas.luis.mymedicine.data.entities.Medicine

@Database(entities = [User::class, Medicine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun medicineDao(): MedicineDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
