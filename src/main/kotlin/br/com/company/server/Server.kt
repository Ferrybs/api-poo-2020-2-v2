package br.com.company.server

import br.com.company.database.Mongodb
import br.com.company.notification.InvalidCredential
import br.com.company.server.route.StartingRoute
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class Server(
        private val mongo: Mongodb
): StartingRoute(){
    val databaseInstance = mongo.database
    val authJwt = AuthJwt("minha-chave-secreta-do-JwT")
    internal val server = embeddedServer(Netty,port = 8080){
        install(StatusPages){
            exception<InvalidCredential> { exception ->
                call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
            }
        }
        install(Authentication){
            jwt {
                verifier(authJwt.verifier)
                validate {
                    UserIdPrincipal(it.payload.getClaim("name").asString())
                }
                }
            }
        install(ContentNegotiation){
            gson {
                setPrettyPrinting()
            }
        }
        inicio(databaseInstance,authJwt)
    }.start(wait = true)


}