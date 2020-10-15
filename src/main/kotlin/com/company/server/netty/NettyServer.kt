package com.company.server.netty

import com.company.database.DBInterface
import com.company.server.ServerInterface
import io.ktor.server.engine.*
import io.ktor.server.netty.*


class NettyServer(
        secret: String,
        dbInterface: DBInterface
) : ServerInterface, NettyEnv(secret,dbInterface) {

    val server = embeddedServer(Netty, env)

    override fun start() {
        this.server.start(wait = true)
    }

    override fun rDatabase(): DBInterface {
        return dbInterface
    }


}