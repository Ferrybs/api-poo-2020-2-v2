package com.company.database.mongodb

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo


open class Mongodb(
        val connectionString: String,
){
     val client = KMongo.createClient(connectionString)
}