package com.company.server.netty

import com.company.database.DBInterface
import com.company.feature.authJwt.moduleJwt
import com.company.feature.gson.moduleGson
import com.company.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        var secret: String,
        val dbInterface: DBInterface
){
    val env = applicationEngineEnvironment {
        module {
            moduleJwt(secret)
            moduleGson()
            routes(dbInterface)
        }
        connector {
            host = "0.0.0.0"
            port = 8080
        }
    }
}
