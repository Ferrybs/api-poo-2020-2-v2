package com.company.route.routeAuth

import com.company.auth.AuthInterface
import com.company.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authRoutes(dbInterface: DBInterface,authInterface: AuthInterface) {
    routing {
        login(dbInterface,authInterface)
        register(dbInterface)
    }
}
