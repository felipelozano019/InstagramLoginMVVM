package com.example.composeinstagram.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject


class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun login(user:String, password:String):Boolean{
        return withContext(Dispatchers.IO){
            val response = loginClient.login()
            response.body()?.success ?: false // If response.body() is null, return false (?: false)
        }
    }
}