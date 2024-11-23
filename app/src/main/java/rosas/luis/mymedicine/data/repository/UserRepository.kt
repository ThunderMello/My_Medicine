package rosas.luis.mymedicine.data.repository

import rosas.luis.mymedicine.data.dao.UserDao
import rosas.luis.mymedicine.data.entities.User

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}
