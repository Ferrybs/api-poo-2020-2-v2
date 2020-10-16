package com.company.route.routeAuth

import com.company.auth.AuthInterface
import com.company.database.DBInterface
import com.company.login.Login
import com.company.notification.exception.InvalidCredential
import com.company.validate.Validate
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.login(dbInterface: DBInterface,authInterface: AuthInterface) {
    get("/login") {
        val get = call.receiveOrNull<Login>()
        if (get!=null){
            val sign = Validate(get,dbInterface).signOrNull(authInterface) ?:
            throw InvalidCredential("Invalid credentials")
            call.respond(mapOf("token:" to sign))
        }
    }
}
