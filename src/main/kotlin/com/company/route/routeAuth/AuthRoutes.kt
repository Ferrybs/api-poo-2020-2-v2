package com.company.route.routeAuth

import com.company.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authRoutes(dbInterface: DBInterface) {
    routing {
        login(dbInterface)
        register(dbInterface)
    }
}
