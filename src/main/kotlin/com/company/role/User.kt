package com.company.role

import com.company.address.Address
import com.company.person.Person

open class User(
        var username: String?=null,
        var password: String?=null,
        name: String? =null,
        lastName: String? =null,
        birth: String? =null,
        address: Address? = null
):Person(name,lastName,birth,address){


}