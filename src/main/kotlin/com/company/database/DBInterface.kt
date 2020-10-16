package com.company.database

import com.company.account.Account
import com.company.login.Login

interface DBInterface {
    fun cAccount(account: Account): String
    fun rOrNullAccount(login: Login): Account?
}