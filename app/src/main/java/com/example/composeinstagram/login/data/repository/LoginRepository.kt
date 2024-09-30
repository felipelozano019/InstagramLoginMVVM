package com.example.composeinstagram.login.data.repository

import com.example.composeinstagram.login.data.network.LoginService

class LoginRepository {
    private val api: LoginService = LoginService()

    suspend fun login(user: String, password: String): Boolean {
        return api.login(user, password)
    }
}