package com.example.composeinstagram.login.data.repository

import com.example.composeinstagram.login.data.network.LoginService
import javax.inject.Inject


class LoginRepository @Inject constructor(private val api:LoginService) {


    suspend fun login(user: String, password: String): Boolean {
        return api.login(user, password)
    }
}