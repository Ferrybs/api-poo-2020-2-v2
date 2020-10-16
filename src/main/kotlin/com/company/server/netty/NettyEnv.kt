package com.company.server.netty

import com.company.auth.AuthInterface
import com.company.database.DBInterface
import com.company.feature.authJwt.moduleJwt
import com.company.feature.gson.moduleGson
import com.company.feature.statusPages.moduleStatusPages
import com.company.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        var authInterface: AuthInterface,
        val dbInterface: DBInterface
){
    val env = applicationEngineEnvironment {
        module {
            moduleStatusPages()
            moduleJwt(authInterface)
            moduleGson()
            routes(dbInterface,authInterface)
        }
        connector {
            host = "0.0.0.0"
            port = 8080
        }
    }
}
