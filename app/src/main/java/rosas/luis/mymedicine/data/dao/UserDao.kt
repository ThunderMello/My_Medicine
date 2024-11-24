package rosas.luis.mymedicine.data.dao

import androidx.room.*
import rosas.luis.mymedicine.data.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>

    @Delete
    suspend fun deleteUser(user: User)
}