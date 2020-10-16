package com.company.validate

import com.company.database.DBInterface
import com.company.login.Login

open class ValidateLogin(
        private val login: Login,
        protected val dbInterface: DBInterface
) {
    val account = dbInterface.rOrNullAccount(login)

    fun validate():Boolean{
        if (account!=null){
            if (login.password != account.password) return false
            return true
        }
        return false
    }
}