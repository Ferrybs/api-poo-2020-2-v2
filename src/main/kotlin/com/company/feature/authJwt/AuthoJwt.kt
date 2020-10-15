package com.company.feature.authJwt

import com.company.auth.AuthJwt
import io.ktor.auth.*
import io.ktor.application.*
import io.ktor.auth.jwt.*

fun Application.moduleJwt(secret: String) {
    val authTwt = AuthJwt(secret)
    install(Authentication) {
        jwt {
            verifier(authTwt.verifier)
            validate {
                UserIdPrincipal(it.payload.getClaim("pass").asString())
            }
        }
    }
}
