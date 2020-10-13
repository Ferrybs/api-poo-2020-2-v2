package br.com.empresa.servidor

import br.com.empresa.database.DataBase
import br.com.empresa.notificacao.CredencialInvalida
import br.com.empresa.servidor.rota.RotaInicio
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class Servidor: RotaInicio(){
    val serveInstance = DataBase()
    val databaseInstance = serveInstance.database
    val authJwt = AuthJwt("minha-chave-secreta-do-JwT")
    internal val server = embeddedServer(Netty,port = 8080){
        install(StatusPages){
            exception<CredencialInvalida> { exception ->
                call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
            }
        }
        install(Authentication){
            jwt {
                verifier(authJwt.verificador)
                validate {
                    UserIdPrincipal(it.payload.getClaim("nome").asString())
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