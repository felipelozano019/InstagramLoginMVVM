package com.example.composeinstagram.login.data.network

import com.example.composeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(user:String, password:String):Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).login()
            response.body()?.success ?: false // If response.body() is null, return false (?: false)
        }
    }
}