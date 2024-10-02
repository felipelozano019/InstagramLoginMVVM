package com.example.composeinstagram.login.data.network

import com.example.composeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/e150857b-1f35-417c-bdf9-d9bfebf7d76c")

    //si falla (no da success en el Logcat) es pq el mocky expiró, hay que crear uno nuevo
    suspend fun login(): Response<LoginResponse>
}