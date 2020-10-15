package com.company.administration

import com.company.account.Account
import com.company.database.DBInterface

class cAccount(
        val account: Account
){
    fun create(dbInterface: DBInterface): String {
        return dbInterface.cAccount(account)
    }
}