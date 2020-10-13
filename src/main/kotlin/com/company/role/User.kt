package com.company.role

import com.company.person.Person

class User(
        var user: String? = null,
        var password: String? = null,
        name: String? = null,
        lastName: String? = null,
        documents: String? = null,
): Person(name,lastName,documents){

}