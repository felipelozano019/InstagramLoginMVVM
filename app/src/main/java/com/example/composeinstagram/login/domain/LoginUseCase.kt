package com.example.composeinstagram.login.domain

import com.example.composeinstagram.login.data.repository.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor( private val repository: LoginRepository){


    suspend operator fun invoke(user: String, password:String): Boolean{
        return repository.login(user, password)
    }
}