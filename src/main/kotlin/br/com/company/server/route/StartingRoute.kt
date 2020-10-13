package br.com.company.server.route

import br.com.company.role.User
import br.com.company.database.management.UserManagement
import br.com.company.server.AuthJwt
import com.mongodb.client.MongoDatabase
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


open class StartingRoute{

    fun Application.inicio(database: MongoDatabase,authJwt: AuthJwt){
        routing {
            get("/"){
                call.respond("Rota Inicio")
            }
            post("/register") {
                val post = call.receiveOrNull<User>()
                if (post !=null){
                    val management = UserManagement(database)
                    management.cUser(post)
                    call.respond(mapOf("token" to authJwt.sign(post.user.toString())))
                }
            }

        }
    }
}