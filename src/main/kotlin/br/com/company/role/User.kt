package br.com.company.role

import br.com.company.client.Person

class User(
        var user: String? = null,
        var password: String? = null,
        name: String? = null,
        lastName: String? = null,
        documents: String? = null,
): Person(name,lastName,documents){

}