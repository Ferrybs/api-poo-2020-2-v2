package com.company.database.mongodb

import com.company.account.Account
import com.company.database.DBInterface
import com.company.login.Login
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {
    val database = connect()

    override fun cAccount(account: Account): String {
        val col = database.getCollection<Account>()
        var status = col.insertOne(account)
        return status.toString()
    }
    override fun rOrNullAccount(login: Login): Account?{
        val col = database.getCollection<Account>()
        val status = col.findOne(Account::username eq login.username)
        if (status!=null){
            return status
        }
        return null
    }
}