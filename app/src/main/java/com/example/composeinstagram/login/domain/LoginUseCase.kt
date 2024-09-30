package com.example.composeinstagram.login.domain

import com.example.composeinstagram.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password:String): Boolean{
        return repository.login(user, password)
    }
}