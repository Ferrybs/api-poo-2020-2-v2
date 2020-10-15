package com.company.feature.gson

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*

fun Application.moduleGson(){
    install(ContentNegotiation){
        gson{
            setPrettyPrinting()
        }
    }
}