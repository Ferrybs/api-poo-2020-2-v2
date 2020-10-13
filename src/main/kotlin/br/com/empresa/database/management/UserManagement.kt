package br.com.empresa.database.management

import br.com.empresa.cargo.User
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*

open class UserManagement(database: MongoDatabase) : Management(database){
    fun cUser(user: User){
        val col = database.getCollection<User>()
        col.insertOne(user)
    }
}