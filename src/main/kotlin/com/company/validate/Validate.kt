package com.company.validate

import com.company.auth.AuthInterface
import com.company.database.DBInterface
import com.company.login.Login

class Validate(
        login: Login,
        dbInterface: DBInterface
) : ValidateLogin(login, dbInterface) {

    fun signOrNull(authInterface: AuthInterface):String? {
        if(validate()){
            return authInterface.sign(account!!.getId())
        }
        return null
    }
}