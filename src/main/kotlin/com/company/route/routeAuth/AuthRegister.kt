package com.company.route.routeAuth

import com.company.account.Account
import com.company.administration.cAccount
import com.company.database.DBInterface
import com.company.role.User
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {
        val post = call.receiveOrNull<Account>()
        if(post!=null){
            val status = cAccount(post).create(dbInterface)
            call.respond(status)
        }
        call.respond(HttpStatusCode.BadRequest)
    }
}
