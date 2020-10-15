package com.company.database

import com.company.account.Account

interface DBInterface {
    fun cAccount(account: Account): String
}