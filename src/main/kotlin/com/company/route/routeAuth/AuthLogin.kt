package com.company.route.routeAuth

import com.company.database.DBInterface
import io.ktor.routing.*


internal fun Route.login(dbInterface: DBInterface) {
    get("/login") {
        TODO()
    }
}
