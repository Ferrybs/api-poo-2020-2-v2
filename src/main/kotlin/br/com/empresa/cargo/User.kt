package br.com.empresa.cargo

import br.com.empresa.cliente.Person

class User(
        var user: String? = null,
        var password: String? = null,
        name: String? = null,
        lastName: String? = null,
        documents: String? = null,
): Person(name,lastName,documents){

}