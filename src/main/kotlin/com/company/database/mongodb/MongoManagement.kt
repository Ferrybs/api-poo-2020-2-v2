package com.company.database.mongodb

import com.company.account.Account
import com.company.database.DBInterface
import com.company.role.User
import org.litote.kmongo.getCollection

class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {
    val database = connect()

    override fun cAccount(account: Account): String {
        val col = database.getCollection<Account>()
        var status = col.insertOne(account)
        return status.toString()
    }
}