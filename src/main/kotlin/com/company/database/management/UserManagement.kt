package com.company.database.management

import com.company.role.User
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*

open class UserManagement(database: MongoDatabase) : Management(database){
    fun cUser(user: User){
        val col = database.getCollection<User>()
        col.insertOne(user)
    }
}