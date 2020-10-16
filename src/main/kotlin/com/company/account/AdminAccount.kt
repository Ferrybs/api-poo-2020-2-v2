package com.company.account

import com.company.role.User
import org.hashids.Hashids

class AdminAccount : Account(){
    private val idAdminAccount: String = this.cId()

    private fun cId(): String{
        val rand1 = (1000..99999).shuffled().first()
        val rand2 = (1000..99999).shuffled().first()
        var final = (rand1*rand2).toLong()
        if(final <0) final *= (-1)
        val hashids = Hashids("Th125-i53-th3-s1lt-f0r-adm1n-",9)
        return hashids.encode(final).toString()
    }
}