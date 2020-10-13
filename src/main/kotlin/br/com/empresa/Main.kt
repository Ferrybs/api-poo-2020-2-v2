package br.com.empresa

import br.com.empresa.database.Mongodb
import br.com.empresa.servidor.Servidor
import java.io.File

fun main(){
    val connectionString = File("ConnectionString.txt").readLines()[0]
    val database = Mongodb(connectionString)
    val instancia = Servidor(database)

}