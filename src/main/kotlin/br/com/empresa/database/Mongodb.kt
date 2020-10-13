package br.com.empresa.database

import org.litote.kmongo.*

open class Mongodb(
        private val connectionString: String
) {

    val client = KMongo.createClient(connectionString)
    val database = client.getDatabase("apiPoo")

}