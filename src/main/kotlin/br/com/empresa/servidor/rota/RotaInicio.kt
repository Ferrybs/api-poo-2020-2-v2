package br.com.empresa.servidor.rota

import br.com.empresa.cargo.User
import br.com.empresa.servidor.AuthJwt
import com.mongodb.client.MongoDatabase
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection


open class RotaInicio{

    fun Application.inicio(database: MongoDatabase,authJwt: AuthJwt){
        routing {
            get("/"){
                call.respond("Rota Inicio")
            }
            post("/register") {
                val post = call.receiveOrNull<User>()
                if (post !=null){
                    val col = database.getCollection<User>()
                    call.respond(mapOf("token" to authJwt.assinar(post.user.toString())))
                }
            }

        }
    }
}