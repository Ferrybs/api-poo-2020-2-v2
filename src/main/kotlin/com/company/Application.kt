package com.company

import com.company.auth.AuthJwt
import com.company.database.mongodb.MongoManagement
import com.company.database.mongodb.Mongodb
import com.company.server.netty.NettyServer
import java.io.File

fun main(){
    val connectionString = File("ConnectionString.txt").readLines()[0]
    val databaseName = "apiPoo2020"
    val secret = "M3U-D3US-vazei-a-senha-do-banco-de-dados-123456"
    val authJwt = AuthJwt(secret)
    val database =  MongoManagement(connectionString,databaseName)
    val server = NettyServer(authJwt,database)

    val company= Company(server)
    company.startServer()

}