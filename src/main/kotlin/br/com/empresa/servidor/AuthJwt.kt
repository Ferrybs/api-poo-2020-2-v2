package br.com.empresa.servidor

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

open class AuthJwt(val chave: String ) {
    private val algoritimo = Algorithm.HMAC256(chave)
    val verificador = JWT.require(algoritimo).build()


    fun assinar (nome: String) : String = JWT.create().withClaim("nome", nome).sign(algoritimo)
}