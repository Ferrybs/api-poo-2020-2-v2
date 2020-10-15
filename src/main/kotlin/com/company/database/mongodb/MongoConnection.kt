package com.company.database.mongodb

import com.mongodb.ConnectionString
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase

open class MongoConnection(
        connectionString: String,
        val databaseName: String
): Mongodb(connectionString){
    fun connect(): MongoDatabase {
        return client.getDatabase(databaseName)
    }
    fun disconnect(){
    }
}