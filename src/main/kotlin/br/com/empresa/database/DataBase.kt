package br.com.empresa.database

import org.litote.kmongo.*

open class DataBase {
    val client = KMongo.createClient()
    val database = client.getDatabase("Test")

}