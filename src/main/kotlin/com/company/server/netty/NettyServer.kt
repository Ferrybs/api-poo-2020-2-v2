package com.company.server.netty

import com.company.auth.AuthInterface
import com.company.auth.AuthJwt
import com.company.database.DBInterface
import com.company.server.ServerInterface
import io.ktor.server.engine.*
import io.ktor.server.netty.*


class NettyServer(
        authInterface: AuthInterface,
        dbInterface: DBInterface
) : ServerInterface, NettyEnv(authInterface,dbInterface) {

    val server = embeddedServer(Netty, env)

    override fun start() {
        this.server.start(wait = true)
    }

    override fun rDatabase(): DBInterface {
        return dbInterface
    }


}