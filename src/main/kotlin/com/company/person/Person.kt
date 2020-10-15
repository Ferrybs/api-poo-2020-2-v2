package com.company.person

import com.company.address.Address
import java.util.*

open class Person(
        var name: String? = null,
        var lastName: String? =null,
        var birth: String? = null,
        var address: Address? = null,
){

}