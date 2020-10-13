package br.com.empresa.database

import br.com.empresa.cargo.User
import org.litote.kmongo.getCollection

class DataBaseUser: DataBase() {
    val col = database.getCollection<User>()

    fun incert(user: User){
        col.insertOne(user)
    }
}