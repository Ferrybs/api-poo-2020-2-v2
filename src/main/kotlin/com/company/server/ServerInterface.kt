package com.company.server

import com.company.database.DBInterface


interface ServerInterface{
    fun start()
    fun rDatabase(): DBInterface
}