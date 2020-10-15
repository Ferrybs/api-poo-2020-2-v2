package com.company

import com.company.database.DBInterface
import com.company.server.ServerInterface

internal data class Company(
        private val server: ServerInterface,
){
    fun startServer() {
        server.start()
    }

}


