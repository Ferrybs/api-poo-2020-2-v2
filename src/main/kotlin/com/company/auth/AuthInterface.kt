package com.company.auth

interface AuthInterface {
    fun sign(pass: String): String
    fun rSecret(): String
}