package com.company.feature.statusPages

import com.company.notification.exception.InvalidCredential
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.moduleStatusPages(){
    install(StatusPages){
        exception<InvalidCredential>{ exception ->
            call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
    }
}