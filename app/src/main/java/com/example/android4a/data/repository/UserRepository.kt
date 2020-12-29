package com.example.android4a.data.repository

import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao) {

    fun createUser(user: User): String {
        return if(getUserEmail(user.email)){
            "EmailAlreadyUsed"
        }else {
            databaseDao.insert(user.toData())
            "Success"
        }
    }

    fun getUser(email: String, password: String): User? {
        val userLocal = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }

    private fun getUserEmail(email: String): Boolean {
        val userLocal = databaseDao.findByMail(email)
        return userLocal?.toEntity()!=null
    }
}