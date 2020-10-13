package br.com.company

import br.com.company.database.Mongodb
import br.com.company.server.Server
import java.io.File

fun main(){
    val connectionString = File("ConnectionString.txt").readLines()[0]
    val database = Mongodb(connectionString)
    val instancia = Server(database)

}