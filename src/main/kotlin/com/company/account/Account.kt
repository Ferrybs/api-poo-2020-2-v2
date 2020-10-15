package com.company.account

import com.company.role.User
import org.hashids.Hashids

open class Account: User() {

    val idAccount:String = this.cId()

    private fun cId():String{
        val rand1 = (1000..99999).shuffled().first()
        val rand2 = (1000..99999).shuffled().first()
        var final = (rand1*rand2).toLong()
        if(final <0) final *= (-1)
        val hashids = Hashids(name+lastName+birth,6,"1234567890abcdef")
        return hashids.encode(final).toString()
    }

}