package com.company.route

import com.company.auth.AuthInterface
import com.company.database.DBInterface
import com.company.route.routeAuth.authRoutes
import com.company.route.routeHome.homeRoutes
import io.ktor.application.*


fun Application.routes(dbInterface: DBInterface,authInterface: AuthInterface) {
    authRoutes(dbInterface,authInterface)
    homeRoutes()
}
